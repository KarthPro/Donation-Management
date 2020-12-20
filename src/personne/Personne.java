package personne;

public abstract class Personne {

	
	private static int idStatic = 0;
	private int id;
	private String nom;
	private String coordonnees;
	private String telephone;
	
	
	public Personne(String nom, String coordonnees, String telephone) {
		this.id =idStatic++;
		this.nom = nom;
		this.coordonnees = coordonnees;
		this.telephone = telephone;
	}


	public  int getId() {
		return id;
	}


	public  void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCoordonnees() {
		return coordonnees;
	}


	public void setCoordonnees(String coordonnees) {
		this.coordonnees = coordonnees;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "id=" + id + ", nom=" + nom + ", coordonnees=" + coordonnees + ", telephone=" + telephone + ", ";
	}
	

	
}
