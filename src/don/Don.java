package don;

import java.util.Date;

import don.mobilier.Statut;
import don.mobilier.Mobilier;
import personne.Adherent;
import personne.PersonneMorale;
import personne.Beneficiaire;

public class Don {
	
	private static int idStatic = 0;
	private int id;
    private Date dateDedeReception;
    private Mobilier reference; 
    private Adherent donnateur; 
    private String description;
    private Statut statut;
    private Adherent membre; 
    private PersonneMorale lieu;
    private Beneficiaire beneficiaire;
    private double montant;
    
    public Don() {
		id=idStatic++;
    }
	public int getId() {
		return id;
	}

	public Don(Date dateDedeReception,Mobilier reference, Adherent donnateur, String description) {
		this.dateDedeReception = dateDedeReception;
		this.reference = reference;
		this.donnateur = donnateur;
		this.description = description;
		this.statut = null;
		this.membre = null;
		this.lieu = null;
		this.beneficiaire = null;
		this.montant =-1.0;
	}
	
	public void donAccepte() {
		this.statut=Statut.ACCEPTE;
	}
	
	public void donStock() {
		this.statut=Statut.STOCKE;
	}

	
	public void donRefuse() {
		this.statut=Statut.REFUSE;
	}
	
	public void donDonne(Beneficiaire beneficiaire){
		this.beneficiaire=beneficiaire;
		this.statut=Statut.DONNE;
	}
	
	public void donVendu(Beneficiaire beneficiaire){
		this.beneficiaire=beneficiaire;
		this.statut=Statut.VENDU;
	}
	public Date getDateDedeReception() {
		return dateDedeReception;
	}
	public void setDateDedeReception(Date dateDedeReception) {
		this.dateDedeReception = dateDedeReception;
	}
	public Mobilier getReference() {
		return reference;
	}
	public void setReference(Mobilier reference) {
		this.reference = reference;
	}
	public Adherent getDonnateur() {
		return donnateur;
	}
	public void setDonnateur(Adherent donnateur) {
		this.donnateur = donnateur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public Adherent getMembre() {
		return membre;
	}
	public void setMembre(Adherent membre) {
		this.membre = membre;
	}
	public PersonneMorale getLieu() {
		return lieu;
	}
	public void setLieu(PersonneMorale lieu) {
		this.lieu = lieu;
	}
	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}
	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	@Override
	public String toString() {
		return "Don [id=" + id + ", dateDedeReception=" + dateDedeReception + ", reference=" + reference
				+ ", donnateur=" + donnateur + ", description=" + description + ", statut=" + statut + ", membre="
				+ membre+"]";
	}
	
	
	
    
    
    
    
    

}
