package com.control.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
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

	@Transactional
	@Override
	public void indexUser() throws Exception {
		try {
			Session session = sessionFactory.getCurrentSession();
			FullTextSession fullTextSession = Search
					.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
		} catch (Exception e) {
			throw e;
		}
	}

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
					@SuppressWarnings("unchecked")
					List<Users> list = (List<Users>) sessionFactory
							.getCurrentSession().createCriteria(Users.class)
							.list();
					result = list;

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
				Users user = (Users) sessionFactory.getCurrentSession().get(
						Users.class, id);
				sessionFactory.getCurrentSession().delete(user);
			}
		});
	}

	@Override
	public void updateData(final Users user, final Integer id) {
		TransactionTemplate tx = new TransactionTemplate(ptm);
		user.setUserId(id);
		tx.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				sessionFactory.getCurrentSession().saveOrUpdate(user);
			}
		});
	}

	@Override
	public Users getUser(final Integer id) {
		TransactionTemplate tx = new TransactionTemplate(ptm);
		return tx.execute(new TransactionCallback<Users>() {
			@Override
			public Users doInTransaction(TransactionStatus status) {
				Users user = null;
				try {
					user = (Users) sessionFactory.getCurrentSession().get(
							Users.class, id);

				} catch (Exception e) {
					e.printStackTrace();
				}
				return user;
			}
		});
	}

	@Override
	public List<Users> searchUser(final String data) {
		TransactionTemplate tx = new TransactionTemplate(ptm);
		return tx.execute(new TransactionCallback<List<Users>>() {
			@Override
			public List<Users> doInTransaction(TransactionStatus status) {
				List<Users> results = null;
				try {
					Session session = sessionFactory.getCurrentSession();

					FullTextSession fullTextSession = Search
							.getFullTextSession(session);

					QueryBuilder qb = fullTextSession.getSearchFactory()
							.buildQueryBuilder().forEntity(Users.class).get();
					org.apache.lucene.search.Query query = qb.keyword()
							.onFields("firstName", "lastName", "city")
							.matching(data).createQuery();

					org.hibernate.Query hibQuery = fullTextSession
							.createFullTextQuery(query, Users.class);

					@SuppressWarnings("unchecked")
					List<Users> list = (List<Users>) hibQuery.list();
					results = list;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return results;
			}
		});
	}

}
