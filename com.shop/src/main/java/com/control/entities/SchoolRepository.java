package com.control.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SuppressWarnings("unchecked")
public class SchoolRepository {

	@Autowired
	private SessionFactory mySessionFactory;

	@Transactional
	public void indexSchoolDress() throws Exception {
		try {
			Session session = mySessionFactory.getCurrentSession();

			FullTextSession fullTextSession = Search
					.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional
	public void addSchoolDressToDB(String schoolTitle,
			String schoolDescription, String schoolName) {
		Session session = mySessionFactory.getCurrentSession();

		SchoolDress schoolDress = new SchoolDress();

		UUID x = UUID.randomUUID();

		Date dateNow = new Date();
		schoolDress.setId(x.toString());
		schoolDress.setSchoolname(schoolName);
		schoolDress.setDescription(schoolDescription);
		schoolDress.setTitle(schoolTitle);
		schoolDress.setCreateDate(dateNow);
		schoolDress.setUpdateDate(dateNow);

		session.saveOrUpdate(schoolDress);
	}

	@Transactional
	public List<SchoolDress> searchFromSchoolDress(String searchText)
			throws Exception {
		try {
			Session session = mySessionFactory.getCurrentSession();

			FullTextSession fullTextSession = Search
					.getFullTextSession(session);

			QueryBuilder qb = fullTextSession.getSearchFactory()
					.buildQueryBuilder().forEntity(SchoolDress.class).get();
			org.apache.lucene.search.Query query = qb.keyword()
					.onFields("description", "title", "schoolname")
					.matching(searchText).createQuery();

			org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(
					query, SchoolDress.class);

			List<SchoolDress> results = hibQuery.list();
			return results;
		} catch (Exception e) {
			throw e;
		}
	}

}
