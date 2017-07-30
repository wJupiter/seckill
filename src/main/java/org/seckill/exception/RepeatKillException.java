package org.seckill.exception;
/**
 * @author WangFeng 
 * @date 2017年7月25日 下午9:58:28 
 * @version 1.0 
 * 重复秒杀异常（运行期异常）
 */

public class RepeatKillException extends SeckillException{
	
	public RepeatKillException(String message) {
		super(message);
	}

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
