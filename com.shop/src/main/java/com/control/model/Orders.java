package com.control.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders implements Serializable{

	private static final long serialVersionUID = -8203001335450351335L;

	@Id
	@GeneratedValue
	@Column(name = "orderId")
	private Integer orderId;

	@Column(name="orderReceivedDate")
	private Timestamp orderReceivedDate;
	
	@Column(name="orderStatus")
	private String orderStatus;

	@Column(name="cancellationReason")
	private String cancellationReason;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Timestamp getOrderReceivedDate() {
		return orderReceivedDate;
	}

	public void setOrderReceivedDate(Timestamp orderReceivedDate) {
		this.orderReceivedDate = orderReceivedDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}
	
}
