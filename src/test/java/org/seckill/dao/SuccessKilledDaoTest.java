package org.seckill.dao;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author WangFeng 
 * @date 2017��7��25�� ����9:09:59 
 * @version 1.0 
 */

//����ʱ����SpringIOC����
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�����ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
	
	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() {
		/**
		 * ��һ�� insertCount 1
		 * �ڶ��� insertCount 0
		 */
		long id = 1000L;
		long phone = 13502181181L;
		int insertCount = successKilledDao.insertSuccessKilled(id, phone);
		System.out.println("insertCount=" + insertCount);
	}

	@Test
	public void testQueryByIdWithSeckill() {
		long id = 1000L;
		long phone = 13502181181L;
		SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
		/**
		 * SuccessSeckill [seckillId=1000, 
		 * userPhone=13502181181, 
		 * state=0, 
		 * createTime=Wed Jul 26 10:52:40 CST 2017,
		 */
	}
}
