package com.control.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Announcment")
public class Announcment {

	@Id
	@GeneratedValue
	@Column(name = "announcmentId")
	private Integer announcmentId;

	@Column(name = "message_type")
	private String message_type; // broadcast or private

	@Column(name = "directed_to")
	private String directed_to = "all"; // broadcast (all) or else populate with

	@Column(name = "category")
	private String category;

	@Column(name = "message")
	private String message;

	@Column(name = "scheduled_timestamp")
	private String scheduled_timestamp; // selectdata and time and send

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public String getDirected_to() {
		return directed_to;
	}

	public void setDirected_to(String directed_to) {
		this.directed_to = directed_to;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getScheduled_timestamp() {
		return scheduled_timestamp;
	}

	public void setScheduled_timestamp(String scheduled_timestamp) {
		this.scheduled_timestamp = scheduled_timestamp;
	}
}
