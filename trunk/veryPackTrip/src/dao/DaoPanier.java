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
import bean.Panier;
import bean.Voyage;

public class DaoPanier {

	public static void create (Session sessionHibernate, Voyage refVoyage, int refClient) {
		try {
			Transaction tx = sessionHibernate.beginTransaction();
			
			Panier oPanier = new Panier();
			oPanier.setRefClient(refClient);
			oPanier.setRefVoyage(refVoyage);
			
			sessionHibernate.persist(oPanier);
			tx.commit();
		}
		catch (Exception e) {
			System.out.println("Erreur "+e.getMessage());
		}
	}
	
	/**
	 * Retourne le panier en fonction de son id
	 * @return
	 */
	public static Panier find(Session sessionHibernate, int id) {
		sessionHibernate =  HibernateUtil.getSession();
		Query query = sessionHibernate.createQuery("from " + Panier.class.getName() + " where id = "+id);
		return (Panier) query.uniqueResult();
	}
	
	/**
	 * Supprime un élément du panier
	 * @param sessionHibernate
	 * @param oPanier
	 */
	public static void delete (Session sessionHibernate, Panier oPanier) {
		try {
			Transaction tx = sessionHibernate.beginTransaction();
			
			sessionHibernate.delete(oPanier);
			tx.commit();
		}
		catch (Exception e) {
			System.out.println("Erreur de suppression : "+e.getMessage());
		}
	}
	
	/**
	 * Retourne tous les voyages du panier
	 * @return
	 */
	public static List<Panier> getPaniers(Session sessionHibernate) {
		sessionHibernate =  HibernateUtil.getSession();
		Query query = sessionHibernate.createQuery("from " + Panier.class.getName());
		return query.list();
	}
}