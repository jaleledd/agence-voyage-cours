package manager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;

import bean.Panier;
import bean.Voyage;
import dao.DaoPanier;
import dao.DaoVoyage;

import sessionHibernate.HibernateUtil;

@ManagedBean
@SessionScoped
public class PanierManager {

	Session sessionHibernate = null;
	
	// id
	private Integer idPanier = null;


	public Integer getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(Integer idPanier) {
		this.idPanier = idPanier;
	}

	public PanierManager()  {
		sessionHibernate =  HibernateUtil.getSession();
	}
	
	public List<Panier> getPaniers() {
		System.out.println("getPaniers");
		return DaoPanier.getPaniers(sessionHibernate);
	}
	
	public String supprimer() {
		System.out.println("supprimer:"+this.getIdPanier());
		DaoPanier.delete(sessionHibernate, DaoPanier.find(sessionHibernate, this.getIdPanier()));
		
		return null;
	}
}
