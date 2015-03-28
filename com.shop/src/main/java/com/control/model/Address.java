package com.control.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Address")
public class Address implements Serializable{

	private static final long serialVersionUID = -5428136044043040219L;

	@Id
	@GeneratedValue
	@Column(name = "addressId")
	private Integer addressId;

	@Column(name="streetName")
	private String streetName;

	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private String pincode;

	@Column(name="guestAdd")
	private String guestAdd;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getGuestAdd() {
		return guestAdd;
	}

	public void setGuestAdd(String guestAdd) {
		this.guestAdd = guestAdd;
	}
}
