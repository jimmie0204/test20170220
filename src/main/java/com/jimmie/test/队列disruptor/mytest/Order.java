package com.jimmie.test.队列disruptor.mytest;

public class Order {

	private String orderNo;
	
	private Integer money;
	
	private Byte status;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", money=" + money + ", status=" + status + "]";
	}
	
	
}
