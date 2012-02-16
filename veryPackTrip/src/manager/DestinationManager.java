package manager;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.Session;
import org.hibernate.validator.constraints.Length;
import org.richfaces.model.TreeNodeImpl;

import dao.DaoPanier;
import dao.DaoVoyage;

import sessionHibernate.HibernateUtil;

import bean.*;


@ManagedBean
@SessionScoped
public class DestinationManager {

	Session sessionHibernate = null;
	String err = "";
	// id du voyage à ajouter
	private Integer idVoyage = null;
	
	public Integer getIdVoyage() {
		return idVoyage;
	}


	public void setIdVoyage(Integer idVoyage) {
		this.idVoyage = idVoyage;
	}

	public DestinationManager()  {
		sessionHibernate =  HibernateUtil.getSession();
	}
	
	public List<Voyage> getVoyages() {
		return DaoVoyage.getVoyages(sessionHibernate);
	}
	
	public String commander() {
		System.out.println("commander:"+this.getIdVoyage());
		Voyage oVoyage = DaoVoyage.find(sessionHibernate, this.getIdVoyage());

		System.out.println("voyage.destination:"+oVoyage.getDestination());
		DaoPanier.create(sessionHibernate, oVoyage, 1);
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		message.setSummary("texte message");
		context.addMessage("LeFormOuIlSapplique", message);
		return null;
	}
}