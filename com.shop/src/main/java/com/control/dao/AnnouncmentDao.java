package com.control.dao;

import java.util.List;

import com.control.model.Announcment;

public interface AnnouncmentDao {
	public void insertData(Announcment announcment);

	public List<Announcment> getAnnouncmentList();

	public List<Announcment> getAnnouncmentList(String userID);
}
