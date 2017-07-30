-- ���ݿ��ʼ���ű�
-- �������ݿ�
CREATE DATABASE seckill;

-- ʹ�����ݿ�
use seckill;
-- ������ɱ����
CREATE TABLE seckill(
	`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '��Ʒ���id',
	`name` varchar(120) NOT NULL COMMENT '��Ʒ������',
	`number` int NOT NULL COMMENT '�������',
	`start_time` timestamp NOT NULL COMMENT '��ɱ��ʼʱ��',
	`end_time` timestamp NOT NULL COMMENT '��ɱ����ʱ��',
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
	PRIMARY KEY (seckill_id),
	key idx_start_time(start_time),
	key idx_end_time(end_time),
	key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='��ɱ����';

-- ��ʼ������
insert into 
	seckill(name, number, start_time,end_time)
	values	
	('1000Ԫ��ɱiPhone6',100,'2017-08-01 00:00:00','2017-08-02 00:00:00'),
	('888Ԫ��ɱС��5s',200,'2017-08-01 00:00:00','2017-08-02 00:00:00'),
	('500Ԫ��ɱiPad2',300,'2017-08-01 00:00:00','2017-08-02 00:00:00'),
	('300Ԫ��ɱС��6',400,'2017-08-01 00:00:00','2017-08-02 00:00:00'),
	('200Ԫ��ɱ����note4',500,'2017-08-01 00:00:00','2017-08-02 00:00:00'),
	('100Ԫ��ɱС���ֻ�3',600,'2017-08-01 00:00:00','2017-08-02 00:00:00');
	
-- ��ɱ�ɹ���ϸ��
-- �û���¼��֤��ص���Ϣ
CREATE TABLE success_killed(
	`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '��ɱ��Ʒid',
	`user_phone` bigint NOT NULL COMMENT '�û��ֻ���',
	`state` tinyint NOT NULL DEFAULT -1 COMMENT '״̬��ʶ: -1:��Ч 0:�ɹ� 1:�Ѹ��� 2���ѷ���',
	`create_time` timestamp NOT NULL COMMENT '����ʱ��', 	
	PRIMARY KEY(seckill_id, user_phone),		/*��������*/
	key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɱ�ɹ���ϸ��';

-- �������ݿ����̨
mysql -uroot -p 

-- Ϊʲô��дDDL
-- ��¼ÿ�����ߵ�DDL�޸�
-- ����v1.1

ALTER TABLE seckill
DROP INDEX idx_create_time,
ADD index idx_c_s(start_time, create_time);