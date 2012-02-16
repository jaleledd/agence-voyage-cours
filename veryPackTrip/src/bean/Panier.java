package bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "panier")
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne()
    @JoinColumn(name="refVoyage")
	private Voyage refVoyage = new Voyage();

	private int refClient;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Voyage getRefVoyage() {
		return this.refVoyage;
	}
	public void setRefVoyage(Voyage refVoyage) {
		this.refVoyage = refVoyage;
	}
	public int getRefClient() {
		return refClient;
	}
	public void setRefClient(int refClient) {
		this.refClient = refClient;
	}
	
}
