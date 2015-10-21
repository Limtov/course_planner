package com.andrei.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static HibernateUtil hibernateUtil = null;

	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	private HibernateUtil() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static HibernateUtil getInstance() {
		if (hibernateUtil == null) {
			hibernateUtil = new HibernateUtil();
		}
		return hibernateUtil;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
