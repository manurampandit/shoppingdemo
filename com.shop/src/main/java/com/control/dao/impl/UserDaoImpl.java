package com.control.dao.impl;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.control.dao.UserDao;
import com.control.model.Users;

public class UserDaoImpl implements UserDao {  

	@Autowired  
	DataSource dataSource;
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PlatformTransactionManager ptm;

	public void insertData(final Users user) {
		TransactionTemplate tx = new TransactionTemplate(ptm);

		tx.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				sessionFactory.getCurrentSession().save(user);
			}
		});
	}
	
	public List<Users> getUserList() {  
		TransactionTemplate tx = new TransactionTemplate(ptm);
		return tx.execute(new TransactionCallback<List<Users>>() {
			@Override
			public List<Users> doInTransaction(TransactionStatus status) {
				List<Users> result = null;
				try {
					result = (List<Users>) sessionFactory.getCurrentSession().createCriteria(Users.class).list();

				} catch (Exception e) {
					throw new RuntimeException("Error retrieving Items list");
				}
				return result;
			}
		});
	}  

	@Override  
	public void deleteData(final Integer id) {
		TransactionTemplate tx = new TransactionTemplate(ptm);

		tx.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				Users user = (Users) sessionFactory.getCurrentSession().get(Users.class, id);
				sessionFactory.getCurrentSession().delete(user);
			}
		});
	}  

	@Override  
	public void updateData(Users user) {  
		//  
		//  String sql = "UPDATE user set first_name = ?,last_name = ?, gender = ?, city = ? where user_id = ?";  
		//  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		//  
		//  jdbcTemplate.update(  
		//    sql,  
		//    new Object[] { user.getFirstName(), user.getLastName(),  
		//      user.getGender(), user.getCity(), user.getUserId() });  
		//  
	}  

	@Override  
	public Users getUser(final Integer id) {  
		TransactionTemplate tx = new TransactionTemplate(ptm);
		return tx.execute(new TransactionCallback<Users>() {
			@Override
			public Users doInTransaction(TransactionStatus status) {
				Users user = null;
				try {
					user = (Users) sessionFactory.getCurrentSession().get(Users.class, id);

				} catch (Exception e) {
					e.printStackTrace();
				}
				return user;
			}
		});
	}  

}  