package com.pancake.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pancake.dao.OrderTableDao;
import com.pancake.entity.OrderTable;
import com.pancake.util.HibernateSessionFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * OrderTable entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.pancake.entity.OrderTable
 * @author MyEclipse Persistence Tools
 */
public class OrderTableDaoImpl implements OrderTableDao{
	// private static final Logger log = LoggerFactory
	// .getLogger(OrderTableDaoImpl.class);
	// property constants
	public static final String GOOD_ID = "goodId";
	public static final String BUYER_ID = "buyerId";
	public static final String SELLER_ID = "sellerId";
	public static final String STATUS = "status";
	public static final String DELIVERY_ADDRESS = "deliveryAddress";
	public static final String FREIGHT = "freight";
	public static final String DESCRIPTION = "description";

	public void save(OrderTable transientInstance) {
		// log.debug("saving OrderTable instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();

			session.save(transientInstance);

			transaction.commit();
			HibernateSessionFactory.closeSession();
			// log.debug("save successful");
		} catch (RuntimeException re) {
			// log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderTable persistentInstance) {
		// log.debug("deleting OrderTable instance");
		try {
			Session session = HibernateSessionFactory.getSession();
			Transaction transaction = session.beginTransaction();

			session.delete(persistentInstance);

			transaction.commit();
			HibernateSessionFactory.closeSession();
			// log.debug("delete successful");
		} catch (RuntimeException re) {
			// log.error("delete failed", re);
			throw re;
		}
	}

	public OrderTable findById(java.lang.Integer id) {
		// log.debug("getting OrderTable instance with id: " + id);
		try {
			Session session = HibernateSessionFactory.getSession();

			OrderTable instance = (OrderTable) session.get(
					"com.pancake.entity.OrderTable", id);
			return instance;
		} catch (RuntimeException re) {
			// log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrderTable instance) {
		// log.debug("finding OrderTable instance by example");
		try {
			Session session = HibernateSessionFactory.getSession();

			List results = session
					.createCriteria("com.pancake.entity.OrderTable")
					.add(Example.create(instance)).list();
			// log.debug("find by example successful, result size: "
			// + results.size());
			return results;
		} catch (RuntimeException re) {
			// log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		// log.debug("finding OrderTable instance with property: " +
		// propertyName
		// + ", value: " + value);
		try {
			String queryString = "from OrderTable as model where model."
					+ propertyName + "= ?";
			Session session = HibernateSessionFactory.getSession();

			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			// log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodId(Object goodId) {
		return findByProperty(GOOD_ID, goodId);
	}

	public List findByBuyerId(Object buyerId) {
		return findByProperty(BUYER_ID, buyerId);
	}

	public List findBySellerId(Object sellerId) {
		return findByProperty(SELLER_ID, sellerId);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByDeliveryAddress(Object deliveryAddress) {
		return findByProperty(DELIVERY_ADDRESS, deliveryAddress);
	}

	public List findByFreight(Object freight) {
		return findByProperty(FREIGHT, freight);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List findAll() {
		// log.debug("finding all OrderTable instances");
		try {
			String queryString = "from OrderTable";
			Session session = HibernateSessionFactory.getSession();

			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			// log.error("find all failed", re);
			throw re;
		}
	}

}