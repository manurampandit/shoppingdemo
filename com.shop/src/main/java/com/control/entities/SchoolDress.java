package com.control.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "schooldress")
public class SchoolDress {
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "title", nullable = false, length = 128)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String title;

	@Column(name = "description", nullable = false, length = 256)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String description;

	@Column(name = "schoolname", nullable = false, length = 64)
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String schoolname;

	@Column(name = "createdate", nullable = false)
	private Date createDate;

	@Column(name = "updatedate", nullable = false)
	private Date updateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
