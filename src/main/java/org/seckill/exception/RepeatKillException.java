package org.seckill.exception;
/**
 * @author WangFeng 
 * @date 2017��7��25�� ����9:58:28 
 * @version 1.0 
 * �ظ���ɱ�쳣���������쳣��
 */

public class RepeatKillException extends SeckillException{
	
	public RepeatKillException(String message) {
		super(message);
	}

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
