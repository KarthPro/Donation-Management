package stat;

import java.util.ArrayList;

import personne.Adherent;
import personne.Association;
import personne.Beneficiaire;

public class Statistique {
	private int nbDon=0;
	private ArrayList<Adherent> donnateur=new ArrayList<Adherent>();
	private int nbDonVolumineuxAccepter=0;
	private int nbDonVolumineuxRecu=0;
	private int nbDonStockAsso=0;
	private int nbDonStockGardMeuble=0;
	private int nbDonStockDepotVent=0;
	
	public Statistique() {
	}

	public int getNbDon() {
		return nbDon;
	}

	public void NbDonPlus() {
		this.nbDon++;
	}
	
	public void NbDonMoin() {
		this.nbDon--;
	}

	public ArrayList<Adherent> getDonnateur() {
		return donnateur;
	}

	public int getNbDonVolumineuxAccepter() {
		return nbDonVolumineuxAccepter;
	}

	public void NbDonVolumineuxAccepterPlus() {
		this.nbDonVolumineuxAccepter++;
	}
	
	public void NbDonVolumineuxAccepterMoin() {
		this.nbDonVolumineuxAccepter--;
	}

	public int getNbDonVolumineuxRecu() {
		return nbDonVolumineuxRecu;
	}

	public void NbDonVolumineuxRecuPlus() {
		this.nbDonVolumineuxRecu++;
	}
	
	public void NbDonVolumineuxRecuMoin() {
		this.nbDonVolumineuxRecu--;
	}

	public int getNbDonStockAsso() {
		return nbDonStockAsso;
	}

	public void NbDonStockAssoPlus() {
		this.nbDonStockAsso++;
	}
	
	public void NbDonStockAssoMoin() {
		this.nbDonStockAsso--;
	}

	public int getNbDonStockGardMeuble() {
		return nbDonStockGardMeuble;
	}

	public void NbDonStockGardMeublePlus() {
		this.nbDonStockGardMeuble++;
	}
	
	public void NbDonStockGardMeubleMoin() {
		this.nbDonStockGardMeuble--;
	}

	public int getNbDonStockDepotVent() {
		return nbDonStockDepotVent;
	}

	public void NbDonStockDepotVentPlus() {
		this.nbDonStockDepotVent++;
	}
	public void NbDonStockDepotVentMoin() {
		this.nbDonStockDepotVent--;
	}
	
	

}
