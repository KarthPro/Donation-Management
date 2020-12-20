package personne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import don.Don;

public class Association extends PersonneMorale {
	
	// list personne
	private ArrayList<PersonneMorale> listDepotVente;
	private ArrayList<PersonneMorale> archiveDepotVente;
	private PersonneMorale gardeMeuble;
	private ArrayList<Adherent> adherent;
	private ArrayList<Adherent> archiveAdherent;
	private ArrayList<Beneficiaire> beneficiaire;
	private ArrayList<Beneficiaire> archiveBeneficiaire;
	private HashMap<Integer,Personne> map;
	
	//don
	ArrayList<Don> donAccepter;
	ArrayList<Don> donVendu;
	ArrayList<Don> donDonner;
	ArrayList<Don> donRefuser;

	public Association(String nom, String coordonnees, String telephone, String typeActivité) {
		super(nom, coordonnees, telephone, typeActivité);
		map= new HashMap<Integer,Personne>();
		listDepotVente = new ArrayList<PersonneMorale>();
		archiveDepotVente= new ArrayList<PersonneMorale>();
		adherent= new ArrayList<Adherent>();
		archiveAdherent= new ArrayList<Adherent>();
		beneficiaire= new ArrayList<Beneficiaire>();
		archiveBeneficiaire=new ArrayList<Beneficiaire>();
		donAccepter= new ArrayList<Don>();
		donRefuser= new ArrayList<Don>();
		donDonner= new ArrayList<Don>();
		donVendu= new ArrayList<Don>();
		gardeMeuble = new PersonneMorale("gardeMeuble","5 rue rivollie paris","0123456789","stock les meubles");
	}
	
	public ArrayList<Don> getDonVendu() {
		return donVendu;
	}

	public void setDonVendu(ArrayList<Don> donVendu) {
		this.donVendu = donVendu;
	}

	public ArrayList<Don> getDonDonner() {
		return donDonner;
	}

	public void setDonDonner(ArrayList<Don> donDonner) {
		this.donDonner = donDonner;
	}

	
	public ArrayList<Adherent> getArchiveAdherent() {
		return archiveAdherent;
	}

	public ArrayList<Don> getDonAccepter() {
		return donAccepter;
	}

	public void setDonAccepter(ArrayList<Don> donAccepter) {
		this.donAccepter = donAccepter;
	}

	public ArrayList<Don> getDonRefuser() {
		return donRefuser;
	}

	public void setDonRefuser(ArrayList<Don> donRefuser) {
		this.donRefuser = donRefuser;
	}

	public ArrayList<Beneficiaire> getArchiveBeneficiaire() {
		return archiveBeneficiaire;
	}

	public HashMap<Integer, Personne> getMap() {
		return map;
	}

	public void creeDepotVente(String id, String nom, String coordonnees, String telephone, String typeActivité) {
		PersonneMorale pm=new PersonneMorale(nom, coordonnees, telephone, typeActivité);
		listDepotVente.add(pm);
		map.put(pm.getId(),pm);
		
	}

	public ArrayList<PersonneMorale> getListDepotVente() {
		return listDepotVente;
	}


	public ArrayList<Adherent> getAdherent() {
		return adherent;
	}

	public ArrayList<Beneficiaire> getBeneficiaire() {
		return beneficiaire;
	}

	public PersonneMorale getGardeMeuble() {
		return gardeMeuble;
	}

	public ArrayList<PersonneMorale> getArchiveDepotVente() {
		return archiveDepotVente;
	}

	public void setArchiveDepotVente(ArrayList<PersonneMorale> archiveDepotVente) {
		this.archiveDepotVente = archiveDepotVente;
	}

	public void setListDepotVente(ArrayList<PersonneMorale> listDepotVente) {
		this.listDepotVente = listDepotVente;
	}

	public void setGardeMeuble(PersonneMorale gardeMeuble) {
		this.gardeMeuble = gardeMeuble;
	}

	public void setAdherent(ArrayList<Adherent> adherent) {
		this.adherent = adherent;
	}

	public void setArchiveAdherent(ArrayList<Adherent> archiveAdherent) {
		this.archiveAdherent = archiveAdherent;
	}

	public void setBeneficiaire(ArrayList<Beneficiaire> beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public void setArchiveBeneficiaire(ArrayList<Beneficiaire> archiveBeneficiaire) {
		this.archiveBeneficiaire = archiveBeneficiaire;
	}

	public void setMap(HashMap<Integer, Personne> map) {
		this.map = map;
	}
	
	public ArrayList<Don> getStock() {
		return super.getStock();
	}



}
