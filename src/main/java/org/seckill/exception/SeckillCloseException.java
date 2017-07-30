package org.seckill.exception;
/**
 * @author WangFeng 
 * @date 2017年7月25日 下午10:01:48 
 * @version 1.0
 * 秒杀关闭异常（） 
 */
public class SeckillCloseException extends SeckillException{

	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
	}

	public SeckillCloseException(String message) {
		super(message);
	}
	
}
