package org.seckill.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

/**
 * @author WangFeng 
 * @date 2017年7月24日 下午9:14:56 
 * @version 1.0
 * 秒杀商品库存接口 
 */
public interface SeckillDao {

	/**
	 * 减库存
	 * @param seckillId
	 * @param killTime
	 * @return 如果影响行数>1,表示更新的记录行数
	 */
	int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);
	
	/**
	 * 根据Id查询秒杀对象
	 * @param seckillId
	 * @return 
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * 根据偏移量秒杀商品
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset")int offet, @Param("limit")int limit);
	
	/**
	 * 使用存储过程执行秒杀
	 * @param paramMap
	 */
	void killByProcedure(Map<String, Object> paramMap);
}
