package org.seckill.dto;
/**
 * @author WangFeng 
 * @date 2017��7��25�� ����9:45:12 
 * @version 1.0
 * ��¶��ɱ��ַDTO 
 */
public class Exposer {
	
	//�ǿ�ʼ��ɱ
	private boolean exposed;
	
	//һ�ּ��ܴ�ʩ
	private String md5;
	
	// id
	private long seckillId;
	
	//ϵͳ��ǰʱ��(����)
	private long now;
	
	//��ʼʱ��
	private long start;
	
	//����ʱ��
	private long end;

	//��ɱ��ʼ
	public Exposer(boolean exposed, String md5, long seckillId) {
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}
	
	// ��ɱ�ر�
	public Exposer(boolean exposed, long seckillId, long now, long start, long end) {
		this.exposed = exposed;
		this.seckillId = seckillId;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	//��ǰ��Ʒ������
	public Exposer(boolean exposed, long seckillId) {
		this.exposed = exposed;
		this.seckillId = seckillId;
	}

	public boolean isExposed() {
		return exposed;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Exposer [exposed=" + exposed + ", md5=" + md5 + ", seckillId=" + seckillId + ", now=" + now + ", start="
				+ start + ", end=" + end + "]";
	}
}
