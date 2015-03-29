package com.control.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.control.dao.AnnouncmentDao;
import com.control.model.Announcment;
import com.control.service.AnnouncmentService;

public class AnnouncmentServiceImpl implements AnnouncmentService {

	@Autowired
	AnnouncmentDao announcmentDao;

	@Override
	public void insertData(Announcment announcment) {
		announcmentDao.insertData(announcment);
	}

	@Override
	public List<Announcment> getAnnouncmentList() {
		return announcmentDao.getAnnouncmentList();
	}

	@Override
	public List<Announcment> getAnnouncmentList(String announcmentId) {
		return announcmentDao.getAnnouncmentList(announcmentId);
	}

}
