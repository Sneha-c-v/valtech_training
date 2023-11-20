package com.valtech.training.newspringboot.model;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import com.valtech.training.newspringboot.entity.Order;

public class OrderModel {
	private static final DateTimeFormatter ORDER_DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	private long id;
	private String item;
	private String description;
	private int itemCount;
	private String orderDate;

	public OrderModel() {

	}

	public OrderModel(Order o) {
		this.id = o.getId();
		this.item = o.getItem();
		this.description = o.getDescription();
		this.itemCount = o.getItemCount();
		this.orderDate = o.getOrderDate()== null ? "":o.getOrderDate().format(ORDER_DATE_FORMAT);

	}

	public Order getOrder() {
		return new Order(id, item, itemCount, description, LocalDate.parse(orderDate, ORDER_DATE_FORMAT));
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getOrderDate() {
		return orderDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	@Override
	public String toString() {
		return "OrderModel [id=" + id + ", item=" + item + ", description=" + description + ", itemCount=" + itemCount
				+ ", orderDate=" + orderDate + "]";
	}
	

}
