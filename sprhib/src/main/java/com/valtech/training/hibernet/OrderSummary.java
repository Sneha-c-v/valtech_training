package com.valtech.training.hibernet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(OrderSummary.class)
public class OrderSummary {

	@Id
	private int OrderId;
	@Id
	private int itemId;

	private int quantity;

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		this.OrderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderSummary(int orderId, int itemId, int quantity) {
		super();
		this.OrderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public OrderSummary() {
	}

}
