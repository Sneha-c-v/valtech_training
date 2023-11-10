package com.valtech.training.hibernet;

import java.io.Serializable;

import javax.persistence.Id;

public class OrderSummaryId  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int orderId;
	
	private int itemId;
	
	@Override
	public String toString() {
		return "OrderSummaryId [OrderId=" + orderId + ", ItemId=" + itemId + "]";
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	public OrderSummaryId() {
		super();
		// TODO Auto-generated constructor stub
	}


	public OrderSummaryId(int orderId, int itemId) {
		this.orderId = orderId;
		this.itemId = itemId;
	}
	
 
}
