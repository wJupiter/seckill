package org.seckill.exception;
/**
 * @author WangFeng 
 * @date 2017��7��25�� ����10:02:49 
 * @version 1.0 
 */
public class SeckillException extends RuntimeException{

	public SeckillException(String message) {
		super(message);
	}
	
	public SeckillException(String message, Throwable cause) {
		super(message, cause);
	}
}
