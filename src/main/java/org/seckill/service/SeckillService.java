package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

/**
 * @author WangFeng 
 * @date 2017��7��25�� ����9:38:50 
 * @version 1.0
 * ҵ��ӿڣ�վ��"ʹ����"�Ƕ���ƽӿ�
 * �������棺�����������ȣ��������������ͣ�return ����/�쳣�� 
 */
public interface SeckillService {
	
	/**
	 * ��ѯ���е���ɱ��¼
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * ��ѯ������ɱ��¼
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * ��ɱ����ʱ�����ɱ�ӿڵ�ַ
	 * �������ϵͳʱ�����ɱʱ��
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * ִ����ɱ����
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException;
	
	/**
	 * ִ����ɱ���� by �洢����
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5);
			
}
