package _main_;


import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import Rechercher.RechercheBeneficiaire_Nom;
import Rechercher.RechercheBeneficiaire_Telephone;
import don.mobilier.*;
import don.Don;
import personne.Adherent;
import personne.Association;
import personne.Beneficiaire;
import personne.Personne;
import personne.PersonneMorale;
import stat.Statistique;;
public class Application {
	
	private Association association;
	private Statistique stat;
	File file;
	
	
	public  void LancerApplication() {
		System.out.println("#Lancement de l'application");
		initialisation();


		System.out.println("############################################## \n\n");
		MenuPrincipal();
		
	}
	
	private void initialisation() {
		association = new Association("Association","30-32 avenue de la République 94 800 Villejuif","01 46 77 46 77"," Organise et gère une association de gestion de dons");
		stat=new Statistique();
		association.getMap().put(association.getId(),association);
		association.getMap().put(association.getGardeMeuble().getId(),association.getGardeMeuble());
		PersonneMorale depotvente = new PersonneMorale("depotvente1","52 rue de la republique paris","0126565689","vend les meubles");
		association.getListDepotVente().add(depotvente);
		association.getMap().put(depotvente.getId(),depotvente);
		file = new File("src/_main_/file.txt");
		
		System.out.println("#initialisation de l'application");
			
	}
	
	private void shutDown() {
		System.out.println("\n\n##############################################");
		System.out.println("#Application éteint");
		System.exit(0);
	
	}
	
	private void MenuPrincipal() {
		System.out.println("Quelle Module souhaitez vous accéder ? (entrer le numéro du module souhaité)");
		System.out.println("\t 1 : Module Personne");
		System.out.println("\t 2 : Module Don");
		System.out.println("\t 3 : Module Recherche");
		System.out.println("\t 4 : Module Statistique");
		System.out.println("\t 5 : Fermer l'application");
		
		Scanner scanner = new Scanner(System.in);  
		String input =scanner.next();
		
		switch(input) {
		  case "1":
			  System.out.println("\n## MODULE PERSONNE ##\n");
			  MenuModulePersonne();
			  break;
		  case "2":
			  System.out.println("\n## MODULE DON ##\n");
			  MenuModuleDon();
			  break;
		  case "3":
			  MenuModuleRecherche();
			  break;
		  case "4":
			  MenuModuleStatistique();
			  break;
		  case "5":
			  shutDown();
			  break;
		  default:
		    System.out.println("Le choix \""+input+"\" n'est pas possible\n");
		    MenuPrincipal();
		    
		}

	}
	
	// Module Personne
	
	private void MenuModulePersonne() {
		System.out.println("Que souhaitez vous faire ? (entrer le numéro de l'action souhaité)");
		System.out.println("\t 1 : Lire les fichiers donnés en pièces jointes pour constituer l’ensemble des personnes qui interagissent avec l’association");
		System.out.println("\t 2 : Afficher  les bénéficiaires");
		System.out.println("\t 3 : Afficher  les Dépot-Ventes");
		System.out.println("\t 4 : Afficher  les Adhérents");
		System.out.println("\t 5 : Modification/Suppression des personnes");
		System.out.println("\t 6 : Revenir sur le menu principal");
		
		Scanner scanner = new Scanner(System.in);  
		String input =scanner.next();
		
		switch(input) {
		  case "1":
			  importerPersonne();
			  break;
		  case "2":
			  RechercheBénéficiaire();
			  break;
		  case "3":
			  RechercheDepotVente();
			  break;
		  case "4":
			  RechercheAdherents();
			  break;
		  case "5":
			  personne_ModifierSuprimer();
			  break;
		  case "6":
			  System.out.println("Retour au menu principal");
			  MenuPrincipal();
			  break;
		  default:
		    System.out.println("Le choix \""+input+"\" n'est pas possible\n");
		    MenuModulePersonne();   
		}
		
		
	}
	private void importerPersonne() {
		Beneficiaire.readFile("src/personne/Beneficiaires.txt", association);
		Adherent.readFile("src/personne/Adherents.txt", association);
		System.out.println("importation des données réussie\n");
		MenuModulePersonne();
	}
	
	private void RechercheBénéficiaire() {
		Scanner scanner = new Scanner(System.in); 
		String input;
		boolean repeat=true;
		List<Beneficiaire> listTrier;
		do {
			System.out.println("Trier les bénéficiaire par nom ou par telephone ? (entrer \"nom\" ou \"telephone\")");
			input =scanner.next();
			if(input.equals("nom")) {
				listTrier=new ArrayList<Beneficiaire>(association.getBeneficiaire());
				Collections.sort(listTrier,new RechercheBeneficiaire_Nom());
				for(Beneficiaire beneficiaire:listTrier) {
					System.out.println(beneficiaire);
				}
				repeat=false;
			}
			else if(input.equals("telephone")) {
				listTrier=new ArrayList<Beneficiaire>(association.getBeneficiaire());
				Collections.sort(listTrier,new RechercheBeneficiaire_Telephone());
				for(Beneficiaire beneficiaire:listTrier) {
					System.out.println(beneficiaire);
				}
				repeat=false;
			}
			
			else {
				System.out.println("Le choix \""+input+"\" n'est pas possible\n");
			}
		}while(repeat);
		MenuModulePersonne();
	}
	
	private void RechercheAdherents() {
		System.out.println("Liste des adherents :");
		for(Adherent adherent:association.getAdherent()) {
			System.out.println(adherent);
		}
		
		MenuModulePersonne();
	}
	
	private void RechercheDepotVente() {
		System.out.println("Liste des Depot-Vente :");
		for(PersonneMorale depotVente:association.getListDepotVente()) {
			System.out.println(depotVente);
		}
		
		MenuModulePersonne();
	}
	
	private void personne_ModifierSuprimer() {
		Scanner scanner = new Scanner(System.in); 
		String input;
		boolean repeat=true;
		
		do {
			System.out.println("Voulez-vous modifier ou supprimer ? (entrer \"modifier\" ou \"supprimer\")");
			input =scanner.next();
			if(input.equals("modifier")) {
				modifierPersonne();
				repeat=false;
			}
			else if(input.equals("supprimer")) {
				supprimerPersonne();
				repeat=false;
			}
			
			else {
				System.out.println("Le choix \""+input+"\" n'est pas possible\n");
			}
		}while(repeat);
		MenuModulePersonne();
	}
	
	private void modifierPersonne() {
		String input;
		System.out.println("Donner l'id de la personne que vous souhaiter modifier  ? (entrer le numéro de l'id de la personne");
		Scanner scanner = new Scanner(System.in); 
		int idPersonne =scanner.nextInt();
		Personne personne=(Personne) association.getMap().get(idPersonne);
		System.out.println("Etes vous sûr de modifier  : "+personne+" (entrer \"oui\" ou \"non\") ");
		input =scanner.next();
		if(input.equals("oui")){
			System.out.print("Entrer le nom ? \n \t");
			input =scanner.next();
			personne.setNom(input);
			
			System.out.print("\nEntrer le numéro de telephone ? \n \t");
			input =scanner.next();
			personne.setTelephone(input);
			
			System.out.print("\nEntrer l'adresse ? \n \t");
			input =scanner.next();
			personne.setCoordonnees(input);
			
			System.out.println("\nLa modification est enregistrer : "+personne);
			
		}
		else if(input.equals("non")) {
			System.out.println("La modification est annulé");

		}
		else {
			System.out.println("votre choix n'est pas compréensible\nRetour au menu");
		}
	}
	
	private void supprimerPersonne() {
		String input;
		System.out.println("Donner l'id de la personne que vous souhaiter supprimer  ? (entrer le numéro de l'id de la personne)");
		Scanner scanner = new Scanner(System.in); 
		int idPersonne =scanner.nextInt();
		try {
			Personne personne=(Personne) association.getMap().get(idPersonne);
			if(personne instanceof Beneficiaire) {
				supprimerBeneficiaire((Beneficiaire)personne,idPersonne);
			}
			else if(personne instanceof Adherent) {

				supprimerAdherent((Adherent)personne,idPersonne);	
			}
			else if(personne instanceof PersonneMorale) {

				supprimerPersonneMorale((PersonneMorale)personne,idPersonne);
			}
			else {
				throw new Exception();
			}
		}
		catch(Exception e) {
			System.out.println("votre choix n'est pas compréensible\nRetour au menu");
		}
		finally {
			MenuModulePersonne();
		}
	}
	
	private void supprimerBeneficiaire(Beneficiaire beneficiaire,int id) {
		System.out.println("Etes vous sûr de supprimer  : "+beneficiaire+" (entrer \"oui\" ou \"non\") ");
		Scanner scanner = new Scanner(System.in); 
		String input;
		input =scanner.next();
		if(input.equals("oui")){
			association.getBeneficiaire().remove(beneficiaire);
			association.getMap().remove(id);
			association.getArchiveBeneficiaire().add((Beneficiaire) association.getMap().get(id));
			System.out.println("\nLa supression est enregistrer");
			
		}
		else if(input.equals("non")) {
			System.out.println("La supression est annulé");

		}
		else {
			System.out.println("votre choix n'est pas compréensible\nRetour au menu");
		}
	}
	
	private void supprimerAdherent(Adherent adherent,int id) {
		System.out.println("Etes vous sûr de supprimer  : "+adherent+" (entrer \"oui\" ou \"non\") ");
		Scanner scanner = new Scanner(System.in); 
		String input;
		input =scanner.next();
		if(input.equals("oui")){
			association.getAdherent().remove(adherent);
			association.getMap().remove(id);
			association.getArchiveAdherent().add((Adherent) association.getMap().get(id));
			System.out.println("\nLa supression est enregistrer");
			
		}
		else if(input.equals("non")) {
			System.out.println("La supression est annulé");

		}
		else {
			System.out.println("votre choix n'est pas compréensible\nRetour au menu");
		}
	}
	
	private void supprimerPersonneMorale(PersonneMorale personneMorale,int id) {
		System.out.println("Etes vous sûr de supprimer  : "+personneMorale+" (entrer \"oui\" ou \"non\") ");
		Scanner scanner = new Scanner(System.in); 
		String input;
		input =scanner.next();
		if(input.equals("oui")){
			association.getListDepotVente().remove(personneMorale);
			association.getMap().remove(id);
			association.getListDepotVente().add(personneMorale);
			System.out.println("\nLa supression est enregistrer");
			
		}
		else if(input.equals("non")) {
			System.out.println("La supression est annulé");

		}
		else {
			System.out.println("votre choix n'est pas compréensible\nRetour au menu");
		}
	}
	
	// Don
	
	
	private void MenuModuleDon() {
		System.out.println("Que souhaitez vous faire ? (entrer le numéro de l'action souhaité)");
		System.out.println("\t 1 : Créer un don");
		System.out.println("\t 2 : Stocker un don");
		System.out.println("\t 3 : Transferer un don");
		System.out.println("\t 4 : Archiver un don");
		System.out.println("\t 5 : Revenir sur le menu principal");
		
		Scanner scanner = new Scanner(System.in);  
		String input =scanner.next();
		
		switch(input) {
		  case "1":
			  creerDon();
			  break;
		  case "2":
			  stockerDon();
			  break;
		  case "3":
			  transfertDon();
			  break;
		  case "4":
			  archiverDon();
			  break;
		  case "5":
			  System.out.println("Retour au menu principal");
			  MenuPrincipal();
			  break;
		  default:
		    System.out.println("Le choix \""+input+"\" n'est pas possible\n");
		    MenuModuleDon();   
		}
		
	}
	
	private void creerDon() {
		boolean checkStat=false;
		stat.NbDonPlus();
		Scanner scanner = new Scanner(System.in);  
		String input;
		
		try {
			Don don=new Don();
			don.setDateDedeReception(new Date());
			System.out.print("Entrer l'id du donnateur \n \t");
			input =scanner.next();
			Adherent donnateur=(Adherent) association.getMap().get(Integer.parseInt(input));
			don.setDonnateur(donnateur);
			if(!stat.getDonnateur().contains(donnateur)) {
				stat.getDonnateur().add(donnateur);
			}
			
			System.out.print("Entrer l'id du membre traitant le dossier \n \t");
			input =scanner.next();
			don.setMembre((Adherent) association.getMap().get(Integer.parseInt(input)));
			
			System.out.print("\nEntrer la descritpion du don ? \n \t");
			input =scanner.nextLine();
			don.setDescription(input);

			
			System.out.println("Quelle est le type du mobiler ? (entrer le numéro associé aux mobiliés)");
			System.out.println("\t 1 : Armoire");
			System.out.println("\t 2 : Assiettes");
			System.out.println("\t 3 : Chaises");
			System.out.println("\t 4 : Chevets");
			System.out.println("\t 5 : Couverts");
			System.out.println("\t 6 : Cuisiniere");
			System.out.println("\t 7 : Lave-Linge");
			System.out.println("\t 8 : Matelas");
			System.out.println("\t 9 : Refrigerateur");
			System.out.println("\t 10 : Table");
			input =scanner.next();
			switch(input) {
			  case "1":
				  Armoires armoires=new Armoires();
				  System.out.println("entrer la longueur ?");
				  input =scanner.next();
				  armoires.setLongueur(Double.parseDouble(input));
				  System.out.println("entrer la largeur ?");
				  input =scanner.next();
				  armoires.setLargeur(Double.parseDouble(input));
				  System.out.println("entrer la hauteur ?");
				  input =scanner.next();
				  armoires.setHauteur(Double.parseDouble(input));
				  don.setReference(armoires);
				  break;
			  case "2":
				  Assiettes assiettes=new Assiettes();
				  System.out.println("entrer le nombre d'assiettes ?");
				  input =scanner.next();
				  assiettes.setNbAssiettes(Integer.parseInt(input));
				  don.setReference(assiettes);
				  break;
			  case "3":
				  Chaises chaises=new Chaises();
				  System.out.println("entrer la longueur ?");
				  input =scanner.next();
				  chaises.setLongueur(Double.parseDouble(input));
				  System.out.println("entrer la largeur ?");
				  input =scanner.next();
				  chaises.setLargeur(Double.parseDouble(input));
				  System.out.println("entrer la hauteur ?");
				  input =scanner.next();
				  chaises.setHauteur(Double.parseDouble(input));
				  don.setReference(chaises);
				  break;
			  case "4":
				  Chevets chevets=new Chevets();
				  System.out.println("entrer la longueur ?");
				  input =scanner.next();
				  chevets.setLongueur(Double.parseDouble(input));
				  System.out.println("entrer la largeur ?");
				  input =scanner.next();
				  chevets.setLargeur(Double.parseDouble(input));
				  System.out.println("entrer la hauteur ?");
				  input =scanner.next();
				  chevets.setHauteur(Double.parseDouble(input));
				  don.setReference(chevets);
				  break;
			  case "5":
				  Couverts couverts=new Couverts();
				  System.out.println("entrer le nombre d'assiettes ?");
				  input =scanner.next();
				  couverts.setNbCouverts(Integer.parseInt(input));
				  don.setReference(couverts);
				  break;
			  case "6":
				  Cuisiniere cuisiniere=new Cuisiniere();
				  System.out.println("entrer la longueur ?");
				  input =scanner.next();
				  cuisiniere.setLongueur(Double.parseDouble(input));
				  System.out.println("entrer la largeur ?");
				  input =scanner.next();
				  cuisiniere.setLargeur(Double.parseDouble(input));
				  System.out.println("entrer la hauteur ?");
				  input =scanner.next();
				  cuisiniere.setHauteur(Double.parseDouble(input));
				  System.out.println("entrer le nombre de plaque ?");
				  input =scanner.next();
				  cuisiniere.setNbPlaque(Integer.parseInt(input));
				  System.out.println("entrer la puissance ?");
				  input =scanner.next();
				  cuisiniere.setPuissance(Integer.parseInt(input));
				  don.setReference(cuisiniere);
				  break;
			  case "7":
				  LaveLinge laveLinge=new LaveLinge();
				  System.out.println("entrer la longueur ?");
				  input =scanner.next();
				  laveLinge.setLongueur(Double.parseDouble(input));
				  System.out.println("entrer la largeur ?");
				  input =scanner.next();
				  laveLinge.setLargeur(Double.parseDouble(input));
				  System.out.println("entrer la hauteur ?");
				  input =scanner.next();
				  laveLinge.setHauteur(Double.parseDouble(input));
				  don.setReference(laveLinge);
				  break;
			  case "8":
				  Matelas matelas=new Matelas();
				  System.out.println("entrer la longueur ?");
				  input =scanner.next();
				  matelas.setLongueur(Double.parseDouble(input));
				  System.out.println("entrer la largeur ?");
				  input =scanner.next();
				  matelas.setLargeur(Double.parseDouble(input));
				  System.out.println("entrer la hauteur ?");
				  input =scanner.next();
				  matelas.setHauteur(Double.parseDouble(input));
				  don.setReference(matelas);
				  break;
			  case "9":
				  Refrigerateur refrigerateur=new Refrigerateur();
				  System.out.println("entrer la longueur ?");
				  input =scanner.next();
				  refrigerateur.setLongueur(Double.parseDouble(input));
				  System.out.println("entrer la largeur ?");
				  input =scanner.next();
				  refrigerateur.setLargeur(Double.parseDouble(input));
				  System.out.println("entrer la hauteur ?");
				  input =scanner.next();
				  refrigerateur.setHauteur(Double.parseDouble(input));
				  don.setReference(refrigerateur);
				  break;
			  case "10":
				  Table table=new Table();
				  System.out.println("entrer la longueur ?");
				  input =scanner.next();
				  table.setLongueur(Double.parseDouble(input));
				  System.out.println("entrer la largeur ?");
				  input =scanner.next();
				  table.setLargeur(Double.parseDouble(input));
				  System.out.println("entrer la hauteur ?");
				  input =scanner.next();
				  table.setHauteur(Double.parseDouble(input));
				  System.out.println("entrer le type ?");
				  input =scanner.next();
				  table.setType(input);
				  System.out.println("entrer la forme ?");
				  input =scanner.next();
				  table.setForme(input);
				  don.setReference(table);
				  break;
			  default:
			    System.out.println("Le choix \""+input+"\" n'est pas possible\n");
			    throw new Exception();  
			    
			}
			System.out.print("\nLe don est-il accepter par l'association? (entrer \"oui\" ou \"non\") \n \t");
			input =scanner.next();
			if(don.getReference() instanceof MobilierVolumineux) {
				checkStat=true;
				stat.NbDonVolumineuxRecuPlus();
			}
			if(input.equals("oui")) {
				don.donAccepte();
				association.getDonAccepter().add(don);
				System.out.println("le don : "+don+" est accepter");
				if(checkStat) {
					stat.NbDonVolumineuxAccepterPlus();;
				}
				
			}
			else if(input.equals("non")) {
				don.donRefuse();
				association.getDonRefuser().add(don);
				System.out.println("le don : "+don+" est refuser");
			}
			else {
				throw new Exception();  
			}

			
		}
		catch(Exception e){
			System.out.println("vous avez fait une erreur durant la création d'un don, création annulé");
			stat.NbDonMoin();
			if(checkStat) {
				stat.NbDonVolumineuxRecuMoin();
			}
		}
		MenuModuleDon();
		
	}
	
	private void stockerDon() {
		System.out.println("Voici la liste des dons accepter : ");
		int i=0;
		for(Don don:association.getDonAccepter()) {
			System.out.println(i+" : "+ don);
			i++;
		}
		try {
			System.out.println("Quelle don souhaitez vous stocker ? (entrer le numéro associé au don) ");
			Scanner scanner = new Scanner(System.in);  
			String input;
			int indexList=Integer.parseInt(scanner.next());
			Don donstock =association.getDonAccepter().get(indexList);
			
			System.out.println("Entrer l'id du lieux de stockage ? (entrer l'id de la personne morale) ");
			PersonneMorale pm =(PersonneMorale) association.getMap().get(scanner.nextInt());
			donstock.donStock();
			association.getDonAccepter().remove(indexList);
			pm.getStock().add(donstock);
			donstock.setLieu(pm);
			System.out.println("Don stocké : "+donstock);
			System.out.println("lieux de stockage : "+donstock.getLieu());
			
			if(association.equals(donstock.getLieu())) {
				stat.NbDonStockAssoPlus();
			}
			else if(association.getGardeMeuble().equals(donstock.getLieu())) {
				stat.NbDonStockGardMeublePlus();
			}
			else
				stat.NbDonStockDepotVentPlus();
		
		}
		catch(Exception e){
			System.out.println("Erreur durant le stockage du don, stockage annulé");
		}
		MenuModuleDon();
		
		
	}
	
	private void transfertDon() {
		Scanner scanner = new Scanner(System.in);  
		String input;
		try {
			System.out.println("Entrer l'id du lieux ou se trouve le don ");
			input=scanner.next();
			PersonneMorale pm =(PersonneMorale) association.getMap().get(Integer.parseInt(input));
			System.out.println("Voici l'ensemble des dons stocké dans le lieu : "+pm.getNom());
			int i=0;
			for(Don don:pm.getStock()) {
				System.out.println(i+" : "+ don);
				i++;
			}
			System.out.println("Quelle don souhaitez vous transferer ? (entrer le numero associé au don)");
			Don don=pm.getStock().get(scanner.nextInt());
			
			System.out.println("A qui souhaitez vous transferer? (entrer l'id du bénéficiaire)");
			Beneficiaire beneficiaire=(Beneficiaire) association.getMap().get(scanner.nextInt());
			
			System.out.println("Quelle est le montant de la transaction ? (entrer 0, si c'est gratuit)");
			input =scanner.next();
			don.setMontant(Double.parseDouble(input));
			
			if(don.getMontant()==0) {
				association.getDonDonner().add(don);
				don.donDonne(beneficiaire);
			}
			else if (don.getMontant()>0) {
				association.getDonVendu().add(don);
				don.donVendu(beneficiaire);
			}
			else
				throw new Exception();
			
			System.out.println("le don : "+don);
			System.out.println("a ete transferer a  : "+beneficiaire);
			pm.getStock().remove(don);
		}
		catch(Exception e){
			System.out.println("Erreur durant le transfert d'un don, transfert annulé");
		}
		MenuModuleDon();
		
		
	}
	
	private void archiverDon() {
		Scanner scanner = new Scanner(System.in);  
		String input;
		try {
			
			System.out.println("Le don que vous souhaiter archiver, est il stocker dans l'association ? (entrer \"oui\" ou \"non\")");
			input=scanner.next();
			if(input.equals("oui")) {
				System.out.println("Entrer l'id du lieux ou se trouve le don ");
				input=scanner.next();
				PersonneMorale pm =(PersonneMorale) association.getMap().get(Integer.parseInt(input));
				System.out.println("Voici l'ensemble des dons stocké dans le lieu : "+pm.getNom());
				int i=0;
				for(Don don:pm.getStock()) {
					System.out.println(i+" : "+ don);
					i++;
				}
				System.out.println("Quelle don souhaitez vous archivez ? (entrer le numero associé au don)");
				Don donArchive=pm.getStock().get(scanner.nextInt());
				donArchive.donRefuse();
				pm.getStock().remove(donArchive);
				association.getDonRefuser().add(donArchive);
				System.out.println("le don : "+donArchive);
				System.out.println("a été archiver");
				
			}
			else if(input.equals("non")) {
				System.out.println("Voici la liste des dons accepter mais non stocké dans l'association : ");
				int i=0;
				for(Don don:association.getDonAccepter()) {
					System.out.println(i+" : "+ don);
					i++;
				}
				System.out.println("Quelle don souhaitez vous archivez ? (entrer le numéro associé au don) ");
				int indexList=Integer.parseInt(scanner.next());
				Don donArchive =association.getDonAccepter().get(indexList);
				association.getDonAccepter().remove(indexList);
				donArchive.donRefuse();
				association.getDonRefuser().add(donArchive);
				System.out.println("le don : "+donArchive);
				System.out.println("a été archiver");
			}
			else {
				throw new Exception();  
			}
			
		}
		catch(Exception e){
			System.out.println("Erreur durant le transfert d'un don, transfert annulé");
		}
		MenuModuleDon();
		
		
	}
	
	// module Recherche
	
	
	private void MenuModuleRecherche() {
		System.out.println("Que souhaitez vous faire ? (entrer le numéro de l'action souhaité)");
		System.out.println("\t 1 : Rechercher dons refuser");
		System.out.println("\t 2 : Rechercher dons accepté");
		System.out.println("\t 3 : Rechercher dons vendu");
		System.out.println("\t 4 : Rechercher dons donnés");
		System.out.println("\t 5 : Rechercher les dons par entrepôt");
		System.out.println("\t 6 : Revenir sur le menu principal");
		
		Scanner scanner = new Scanner(System.in);  
		String input =scanner.next();
		
		switch(input) {
		  case "1":
			  afficherDonRefuse();
			  break;
		  case "2":
			  afficherDonAccepte();
			  break;
		  case "3":
			  afficherDonVendu();
			  break;
		  case "4":
			  afficherDonDonne();
			  break;
		  case "5":
			  afficherStock();
			  break;
		  case "6":
			  System.out.println("Retour au menu principal");
			  MenuPrincipal();
			  break;
		  default:
		    System.out.println("Le choix \""+input+"\" n'est pas possible\n");
		    MenuModuleRecherche();   
		}
		
		
	}
	
	private void afficherDonRefuse() {
		try{
			FileWriter writer = new FileWriter(file,true);
			writer.write("Liste des dons refusé : \r\n");
			System.out.println("Liste des dons refusé :");
			for(Don don:association.getDonRefuser()) {
				System.out.println(don);
				writer.write(don.toString()+" \r\n");
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("Ereur, retour menu");
		}
		MenuModuleRecherche();

	}
	
	private void afficherDonAccepte() {
		try{
			FileWriter writer = new FileWriter(file,true);
			writer.write("\r\nListe des dons accepter : \r\n");
			System.out.println("Liste des dons accepter :");
			for(Don don:association.getDonAccepter()) {
				System.out.println(don);
				writer.write(don.toString()+" \r\n");
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("Ereur, retour menu");
		}
		MenuModuleRecherche();

	}
	
	private void afficherDonVendu() {
		try{
			FileWriter writer = new FileWriter(file,true);
			writer.write("\r\nListe des dons vendus : \r\n");
			System.out.println("Liste des dons vendus :");
			for(Don don:association.getDonVendu()) {
				System.out.println(don);
				writer.write(don.toString()+" \r\n");
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("Ereur, retour menu");
		}
		MenuModuleRecherche();

	}
	
	private void afficherDonDonne() {
		try{
			FileWriter writer = new FileWriter(file,true);
			writer.write("\r\nListe des dons donner : \r\n");
			System.out.println("Liste des dons donner :");
			for(Don don:association.getDonDonner()) {
				System.out.println(don);
				writer.write(don.toString()+" \r\n");
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("Ereur, retour menu");
		}
		MenuModuleRecherche();

	}
	
	private void afficherStock() {
		try{
			Scanner scanner = new Scanner(System.in);  
			String input;
			FileWriter writer = new FileWriter(file,true);
			System.out.println("Entrer l'id de l'entrepot ?");
			input=scanner.next();
			PersonneMorale pm =(PersonneMorale) association.getMap().get(Integer.parseInt(input));
			System.out.println("Voici l'ensemble des dons stocké dans l'entreport : "+pm);
			writer.write("\r\nVoici l'ensemble des dons stocké dans l'entreport : "+pm+" \r\n");
			for(Don don:pm.getStock()) {
				System.out.println(don);
				writer.write(don.toString()+" \r\n");
			}
			writer.close();
		}
		catch(Exception e) {
			System.out.println("Ereur, retour menu");
		}
		MenuModuleRecherche();

	}
	
	// module Statistique
	
	private void MenuModuleStatistique() {
		System.out.println("Voici l'ensemble des statistique :");
		System.out.println("nombre de proposition reçu : \n \t -> "+stat.getNbDon());
		System.out.println("nombre de donnateur : \n \t -> "+stat.getDonnateur().size());
		System.out.println("nombre de bénéfiaire : \n \t -> "+association.getBeneficiaire().size());
		System.out.println("nombre de dons volumineux accepté : \n \t -> "+stat.getNbDonVolumineuxAccepter());
		if(stat.getNbDonVolumineuxRecu()!=0)
			System.out.println("ratio dons volumineux accepté sur don volumineux reçu: \n \t -> "+(((double)stat.getNbDonVolumineuxAccepter()/(double)stat.getNbDonVolumineuxRecu())*(double)100)+"%");
		System.out.println("nombre de dons ventilé vers l'association : \n \t -> "+stat.getNbDonStockAsso());
		System.out.println("nombre de dons ventilé vers le garde meuble : \n \t -> "+stat.getNbDonStockGardMeuble());
		System.out.println("nombre de dons ventilé vers les depot-vente : \n \t -> "+stat.getNbDonStockDepotVent());
		
		System.out.println("Souhaitez vous enregistrer les données dans le fichier de sauvegarde ? (entrer \"oui\" ou \"non\")");
		try {
			Scanner scanner = new Scanner(System.in);  
			String input =scanner.next();
			if(input.equals("oui")) {
				FileWriter writer = new FileWriter(file,true);
				writer.write("\r\n Statistique du :"+new Date().toString()+" \r\n");
				writer.write("nombre de proposition reçu : \n \t -> "+stat.getNbDon()+" \r\n");
				writer.write("nombre de donnateur : \n \t -> "+stat.getDonnateur().size()+" \r\n");
				writer.write("nombre de bénéfiaire : \n \t -> "+association.getBeneficiaire().size()+" \r\n");
				writer.write("nombre de dons volumineux accepté : \n \t -> "+stat.getNbDonVolumineuxAccepter()+" \r\n");
				if(stat.getNbDonVolumineuxRecu()!=0)
					writer.write("ratio dons volumineux accepté sur don volumineux reçu: \n \t -> "+(((double)stat.getNbDonVolumineuxAccepter()/(double)stat.getNbDonVolumineuxRecu())*(double)100)+"% \r\n");
				writer.write("nombre de dons ventilé vers l'association : \n \t -> "+stat.getNbDonStockAsso()+" \r\n");
				writer.write("nombre de dons ventilé vers le garde meuble : \n \t -> "+stat.getNbDonStockGardMeuble()+" \r\n");
				writer.write("nombre de dons ventilé vers les depot-vente : \n \t -> "+stat.getNbDonStockDepotVent()+" \r\n");
				writer.close();
			}
			else if(input.equals("non")) {

			}
			else {
				throw new Exception();  
			}
			
		}
		catch(Exception e){
			System.out.println("Erreur, retour au menu");
		}
		MenuPrincipal();	
	}
	

}

	
