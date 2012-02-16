package bean;

import javax.persistence.*;

@Entity
@Table(name = "voyage")
public class Voyage {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String destination = "";
	private String date = "";
	private String duree = "";
	private String prix = "";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}

}
