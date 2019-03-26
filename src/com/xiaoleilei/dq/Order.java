package com.xiaoleilei.dq;

/**
 * 实体类Order
 * @author ly-leiwang
 *
 */
public class Order {
	private final String OrderNumber;
	private final int OrderMoney;
	public Order(String orderNumber, int orderMoney) {
		super();
		OrderNumber = orderNumber;
		OrderMoney = orderMoney;
	}
	public String getOrderNumber() {
		return OrderNumber;
	}
	public int getOrderMoney() {
		return OrderMoney;
	}
	
	
}
