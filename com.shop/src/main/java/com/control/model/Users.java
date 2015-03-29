package com.control.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "Users")
public class Users implements Serializable {

	private static final long serialVersionUID = 7161689387807284768L;

	@Id
	@GeneratedValue
	@Column(name = "userId")
	private Integer userId;
	@Column(name = "firstName")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String firstName;

	@Column(name = "lastName")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String lastName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "city")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String city;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
