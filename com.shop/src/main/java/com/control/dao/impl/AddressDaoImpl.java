package com.control.dao.impl;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.control.dao.AddressDao;
import com.control.model.Address;

public class AddressDaoImpl implements AddressDao {  

	@Autowired  
	DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PlatformTransactionManager ptm;

	public void insertData(final Address address) {
		TransactionTemplate tx = new TransactionTemplate(ptm);

		tx.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				sessionFactory.getCurrentSession().save(address);
			}
		});
	}  
}  