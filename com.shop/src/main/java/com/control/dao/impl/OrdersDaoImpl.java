package com.control.dao.impl;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.control.dao.OrdersDao;
import com.control.model.OrderDetails;
import com.control.model.OrderDetailsId;
import com.control.model.Orders;

public class OrdersDaoImpl implements OrdersDao {  

	@Autowired  
	DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PlatformTransactionManager ptm;

	public void insertData(final Orders order) {
		TransactionTemplate tx = new TransactionTemplate(ptm);

		tx.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				sessionFactory.getCurrentSession().saveOrUpdate(order);
				OrderDetails orderDet = new OrderDetails();
				OrderDetailsId id = new OrderDetailsId(order.getOrderId(), order.getOrderId(), order.getOrderId());
				orderDet.setId(id);
				sessionFactory.getCurrentSession().saveOrUpdate(orderDet);
				
				System.out.println("Order saved");
			}
		});
	}  
}  