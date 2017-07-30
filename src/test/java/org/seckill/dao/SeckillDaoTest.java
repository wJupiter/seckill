package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author WangFeng 
 * @date 2017��7��25�� ����4:49:01 
 * @version 1.0 
 * ����Spring��junit���ϣ�junit����ʱ����SpringIOC����
 * spring-test, junit
 */
//����ʱ����SpringIOC����
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�����ļ�
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

	//ע��Daoʵ��������
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testReduceNumber() {
		Date killTime = new Date();
		int updateCount = seckillDao.reduceNumber(1000L, killTime);
		System.out.println(updateCount);
	}

	@Test
	public void testQueryById() {
		long id = 1000;
		Seckill seckill = seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}

	@Test
	public void testQueryAll() {
		/**
		 * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
		 * javaû�б����βεļ�¼��queryAll(int offet, int limit) ->queryAll(argo, arg1)
		 */
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
		for (Seckill seckill : seckills) {
			System.out.println(seckill);
		}
	}
}
