package org.seckill.dao.cache;

import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author WangFeng
 * @date 2017年7月28日 下午3:41:45
 * @version 1.0
 */
public class RedisDao {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final JedisPool jedisPool;

	public RedisDao(String ip, int port) {
		jedisPool = new JedisPool(ip, port);
	}

	// 对Seckill类中的属性方法进行约束
	private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

	public Seckill getSeckill(long seckillId) {
		try {
			// redis操作逻辑
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill:" + seckillId;
				// 并没有实现内部序列化操作
				// get -> byte[] -> 反序列化 ->Object(Seckill)
				// 采用自定义序列化
				// protostuff : pojo
				byte[] bytes = jedis.get(key.getBytes());
				// 缓存重获取到
				if (bytes != null) {
					// 空对象
					Seckill seckill = schema.newMessage();
					// 把拿到的byte数组依据schema约束反序列到空的seckill对象中
					ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
					// seckill被反序列化
					return seckill;
				}
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * @param seckill
	 * @return
	 */
	public String putSeckill(Seckill seckill) {
		// set Object(Seckill) --> 序列化 -> bytes[] -->
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				// 设置key
				String key = "seckill:" + seckill.getSeckillId();
				// 进行序列化时，如果对象比较庞大，使用LinkedBuffer.allocate进行缓冲
				byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema,
						LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				// 超时缓存时间
				int timeout = 60 * 60; // 1小时
				// 超时缓存
				String result = jedis.setex(key.getBytes(), timeout, bytes);
				// result表示缓存的结果，如果成功则返回ok
				return result;
			} finally {
				jedis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
