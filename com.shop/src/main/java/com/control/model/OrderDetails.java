package com.control.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="OrderDetails")
public class OrderDetails implements Serializable{

	private static final long serialVersionUID = 6205674027838683206L;
	
	private OrderDetailsId id;
	
	public OrderDetails() {
	}

	public OrderDetails(OrderDetailsId id) {
		this.id = id;
	}

	@EmbeddedId
	public OrderDetailsId getId() {
		return id;
	}

	public void setId(OrderDetailsId id) {
		this.id = id;
	}

	/*@Id
	@Column(name = "orderId")
	private Integer orderId;

	@Column(name = "itemId")
	private Integer itemId;
	
	@Column(name = "addressId")
	private Integer addressId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}*/
}
