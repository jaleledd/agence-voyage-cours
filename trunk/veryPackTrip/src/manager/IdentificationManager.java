package manager;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.Session;
import org.hibernate.validator.constraints.Length;
import org.richfaces.model.TreeNodeImpl;

import dao.DaoPanier;
import dao.DaoVoyage;
import dao.DaoClient;

import sessionHibernate.HibernateUtil;

import bean.*;


@ManagedBean
@SessionScoped
public class IdentificationManager {

	Session sessionHibernate = null;
	String err = "";
	private Client client;
	boolean logged = false;


	public IdentificationManager()  {
		sessionHibernate =  HibernateUtil.getSession();
		client = new Client();
	}
	
	public String login() {
		// si on a trouvé un client avec ce nom
		if(DaoClient.login(sessionHibernate, client)) {
			// on maj le client afin d'avoir ses informations
			client = DaoClient.findByNom(sessionHibernate, client.getNom());
			logged = true;
			return "accueil";
		}
		return null;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public boolean isLogged() {
		return logged;
	}
	
	public String redirection () {
		// si on est déjà connecté
		if(isLogged())
			return "accueil";
		
		return null;
	}
	
	public String getLienConnexion() {
		System.out.println("public String getTexteConnexion() {");
		return (isLogged()) ? "/veryPackTrip/pages/compte.xhtml" : "/veryPackTrip/pages/identification.xhtml";
	}
	
	public String getTexteLienConnexion() {
		return (isLogged()) ? client.getPrenom()+" "+client.getNom() : "Se connecter";
	}
}