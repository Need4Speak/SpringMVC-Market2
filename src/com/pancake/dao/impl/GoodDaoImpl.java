package com.pancake.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.dao.GoodDao;
import com.pancake.entity.Good;
import com.pancake.util.HibernateSessionFactory;

public class GoodDaoImpl implements GoodDao{
	
	/**
	 * @param transientInstance
	 */
	public void save(Good transientInstance) {
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();			
			session.save(transientInstance);			
			transaction.commit();
			HibernateSessionFactory.closeSession();
			
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	/**
	 * @param persistentInstance
	 */
	public void delete(Good persistentInstance) {
//		log.debug("deleting Good instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(persistentInstance);
			transaction.commit();
			HibernateSessionFactory.closeSession();
			
			//log.debug("delete successful");
		} catch (RuntimeException re) {
			//log.error("delete failed", re);
			throw re;
		}
	}
	
	/**
	 * @param id
	 * @return
	 */
	public Good findById(java.lang.Integer id) {
		//log.debug("getting Good instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();
//			Transaction transaction = session.beginTransaction();
			
			Good instance = (Good) session.get("com.entity.Good", id);
			
//			transaction.commit();
//			HibernateSessionFactory.closeSession();
			return instance;
		} catch (RuntimeException re) {
			//log.error("get failed", re);
			throw re;
		}
	}
	
	/**
	 * @return
	 */
	public List findAll() {
		//log.debug("finding all Good instances");
		try {
			Session session = HibernateSessionFactory.getSession();
//			Transaction transaction = session.beginTransaction();
			
			String queryString = "from Good";
			Query queryObject = session.createQuery(queryString);
			
//			transaction.commit();
//			HibernateSessionFactory.closeSession();
			return queryObject.list();
		} catch (RuntimeException re) {
			//log.error("find all failed", re);
			throw re;
		}
	}
}
