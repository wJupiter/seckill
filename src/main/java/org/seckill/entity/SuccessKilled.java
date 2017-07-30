package org.seckill.entity;

import java.util.Date;

/**
 * @author WangFeng 
 * @date 2017年7月24日 下午9:10:19 
 * @version 1.0
 * 秒杀成功明细类 
 */
public class SuccessKilled {
	
	private long seckillId;
	
	private long userPhone;
	
	private short state;
	
	private Date createTime;

	//秒杀商品库存类（-对多）
	private Seckill seckill;
	
	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Seckill getSeckill() {
		return seckill;
	}

	public void setSeckill(Seckill seckill) {
		this.seckill = seckill;
	}

	@Override
	public String toString() {
		return "SuccessSeckill [seckillId=" + seckillId + ", userPhone=" + userPhone + ", state=" + state
				+ ", createTime=" + createTime + ", seckill=" + seckill + "]";
	}
	
}
