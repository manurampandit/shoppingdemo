package com.control.dao.impl;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.control.dao.ItemDao;
import com.control.model.Items;
  
public class ItemDaoImpl implements ItemDao {  

	@Autowired  
	DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PlatformTransactionManager ptm;

	public List<Items> getItemList() {
		TransactionTemplate tx = new TransactionTemplate(ptm);
		return tx.execute(new TransactionCallback<List<Items>>() {
			@Override
			public List<Items> doInTransaction(TransactionStatus status) {
				List<Items> result = null;
				try {
					result = (List<Items>) sessionFactory.getCurrentSession().createCriteria(Items.class).list();

				} catch (Exception e) {
					throw new RuntimeException("Error retrieving Items list");
				}
				return result;
			}
		});
	}  

	public List<Items> getItemDetails(final int itemId) {

		TransactionTemplate tx = new TransactionTemplate(ptm);
		return tx.execute(new TransactionCallback<List<Items>>() {
			@Override
			public List<Items> doInTransaction(TransactionStatus status) {
				List<Items> result = null;
				try {
					result = (List<Items>) sessionFactory.getCurrentSession().get(Items.class, itemId);

				} catch (Exception e) {
					throw new RuntimeException("Error retrieving Items list");
				}
				return result;
			}
		});

	}
}  