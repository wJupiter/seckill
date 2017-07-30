package org.seckill.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

/**
 * @author WangFeng 
 * @date 2017��7��24�� ����9:14:56 
 * @version 1.0
 * ��ɱ��Ʒ���ӿ� 
 */
public interface SeckillDao {

	/**
	 * �����
	 * @param seckillId
	 * @param killTime
	 * @return ���Ӱ������>1,��ʾ���µļ�¼����
	 */
	int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);
	
	/**
	 * ����Id��ѯ��ɱ����
	 * @param seckillId
	 * @return 
	 */
	Seckill queryById(long seckillId);
	
	/**
	 * ����ƫ������ɱ��Ʒ
	 * @param offet
	 * @param limit
	 * @return
	 */
	List<Seckill> queryAll(@Param("offset")int offet, @Param("limit")int limit);
	
	/**
	 * ʹ�ô洢����ִ����ɱ
	 * @param paramMap
	 */
	void killByProcedure(Map<String, Object> paramMap);
}
