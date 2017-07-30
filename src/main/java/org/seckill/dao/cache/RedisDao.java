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
 * @date 2017��7��28�� ����3:41:45
 * @version 1.0
 */
public class RedisDao {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final JedisPool jedisPool;

	public RedisDao(String ip, int port) {
		jedisPool = new JedisPool(ip, port);
	}

	// ��Seckill���е����Է�������Լ��
	private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

	public Seckill getSeckill(long seckillId) {
		try {
			// redis�����߼�
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckill:" + seckillId;
				// ��û��ʵ���ڲ����л�����
				// get -> byte[] -> �����л� ->Object(Seckill)
				// �����Զ������л�
				// protostuff : pojo
				byte[] bytes = jedis.get(key.getBytes());
				// �����ػ�ȡ��
				if (bytes != null) {
					// �ն���
					Seckill seckill = schema.newMessage();
					// ���õ���byte��������schemaԼ�������е��յ�seckill������
					ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
					// seckill�������л�
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
		// set Object(Seckill) --> ���л� -> bytes[] -->
		try {
			Jedis jedis = jedisPool.getResource();
			try {
				// ����key
				String key = "seckill:" + seckill.getSeckillId();
				// �������л�ʱ���������Ƚ��Ӵ�ʹ��LinkedBuffer.allocate���л���
				byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema,
						LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				// ��ʱ����ʱ��
				int timeout = 60 * 60; // 1Сʱ
				// ��ʱ����
				String result = jedis.setex(key.getBytes(), timeout, bytes);
				// result��ʾ����Ľ��������ɹ��򷵻�ok
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
