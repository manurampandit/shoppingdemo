package com.control.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.control.dao.AnnouncmentDao;
import com.control.model.Announcment;

public class AnnouncmentDaoImpl implements AnnouncmentDao {
	@Autowired
	DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PlatformTransactionManager ptm;

	@Override
	public void insertData(final Announcment announcment) {
		TransactionTemplate tx = new TransactionTemplate(ptm);

		tx.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				sessionFactory.getCurrentSession().save(announcment);
			}
		});
	}

	@Override
	public List<Announcment> getAnnouncmentList() {
		TransactionTemplate tx = new TransactionTemplate(ptm);
		return tx.execute(new TransactionCallback<List<Announcment>>() {
			@Override
			public List<Announcment> doInTransaction(TransactionStatus status) {
				List<Announcment> result = null;
				try {
					@SuppressWarnings("unchecked")
					List<Announcment> list = (List<Announcment>) sessionFactory
							.getCurrentSession()
							.createCriteria(Announcment.class).list();
					result = list;

				} catch (Exception e) {
					throw new RuntimeException(
							"Error retrieving Announcment list");
				}
				return result;
			}
		});
	}

	@Override
	public List<Announcment> getAnnouncmentList(final String directed_to) {

		TransactionTemplate tx = new TransactionTemplate(ptm);

		return tx.execute(new TransactionCallback<List<Announcment>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<Announcment> doInTransaction(TransactionStatus status) {
				List<Announcment> announcment = null;
				try {
					Criteria cr = sessionFactory.getCurrentSession()
							.createCriteria(Announcment.class);
					cr.add(Restrictions.eq("directed_to", directed_to));
					announcment = (List<Announcment>) cr.list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return announcment;
			}
		});
	}
}
