package dao;

import java.util.Collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import sessionHibernate.HibernateUtil;
import bean.Voyage;

public class DaoVoyage {
	
	/**
	 * Retourne tous les voyages
	 * @return
	 */
	public static List<Voyage> getVoyages(Session sessionHibernate) {
		sessionHibernate =  HibernateUtil.getSession();
		Query query = sessionHibernate.createQuery("from " + Voyage.class.getName());
		return query.list();
	}
	
	/**
	 * Retourne tous les voyages
	 * @return
	 */
	public static Voyage find(Session sessionHibernate, int id) {
		sessionHibernate =  HibernateUtil.getSession();
		Query query = sessionHibernate.createQuery("from " + Voyage.class.getName() + " where id = "+id);
		return (Voyage) query.uniqueResult();
	}
	
}
