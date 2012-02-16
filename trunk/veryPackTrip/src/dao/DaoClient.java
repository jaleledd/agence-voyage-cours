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
import bean.Client;

public class DaoClient {
	
	/**
	 * Retourne le client en fonction de son id
	 * @return
	 */
	public static Client find(Session sessionHibernate, int id) {
		sessionHibernate =  HibernateUtil.getSession();
		Query query = sessionHibernate.createQuery("from " + Client.class.getName() + " where id = "+id);
		return (Client) query.uniqueResult();
	}
	
	/**
	 * Retourne le client en fonction de son login
	 * @return
	 */
	public static Client findByNom(Session sessionHibernate, String nom) {
		sessionHibernate =  HibernateUtil.getSession();
		Query query = sessionHibernate.createQuery("from " + Client.class.getName() + " where nom = '"+nom+"'");
		return (Client) query.uniqueResult();
	}

	/**
	 * Enregistre un nouveau client dans la BDD.
	 * @param client Client
	 * @return 
	 */
	public static String saveClient(Session sessionHibernate, Client client){
		try{
			String s = sessionHibernate.save(client).toString();
			System.out.println("save : "+s);
			Transaction tx = sessionHibernate.beginTransaction();
			sessionHibernate.persist(client);
			tx.commit();
			return s;
		}catch(Exception e){
			System.err.println("Existe déja : "+e);
			return null;
		}
	}
	
	/**
	 * Permet à un client de se connecter
	 * @param client Client
	 * @return True si le client existe, false sinon.
	 */
	public static boolean login(Session sessionHibernate, Client client){
		try{
			Query q = sessionHibernate.createQuery("from " + Client.class.getName() + " where nom='"+client.getNom()+"' and password='"+client.getPassword()+"'");
			System.out.println("connexion client : "+q);
			if(q.list().isEmpty()){
				return false;
			}else{
				return true;
			}
		}catch(Exception e){
			System.err.println("Problème lors de l'identification"+ e);
			return false;
		}
	}
}