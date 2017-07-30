package org.seckill.dto;
/**
 * @author WangFeng 
 * @date 2017��7��26�� ����4:12:42 
 * @version 1.0
 * ����ajax����Ż����ͣ���װjson��� 
 */
public class SeckillResult<T> {
	
	private boolean success;
	
	private T data;
	
	private String error;

	public SeckillResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public SeckillResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
}
