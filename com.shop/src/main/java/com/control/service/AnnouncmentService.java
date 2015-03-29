package com.control.service;

import java.util.List;

import com.control.model.Announcment;

public interface AnnouncmentService {
	public void insertData(Announcment announcment);

	public List<Announcment> getAnnouncmentList();

	public List<Announcment> getAnnouncmentList(String userID);
}
