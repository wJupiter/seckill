package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @author WangFeng 
 * @date 2017��7��24�� ����9:18:27 
 * @version 1.0 
 */
public interface SuccessKilledDao {
	
	/**
	 * ���빺����ϸ���ɹ����ظ�
	 * @param seckillId
	 * @param userPhone
	 * @return ���ز��������
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
	/**
	 * ����Id��ѯSuccessSeckilled��Я����ɱ��Ʒ����ʵ��
	 * @param seckilled
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
	
}
