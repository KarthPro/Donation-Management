package personne;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Beneficiaire extends Personne {
	private Date dateNaissance;
	private String prenom;

	public Beneficiaire(String nom, String coordonnees, String telephone,String prenom,Date dateNaissance) {
		super(nom, coordonnees, telephone);
		this.dateNaissance=dateNaissance;
		this.prenom=prenom;
	}
	
	
	public static boolean readFile(String fileName,Association association) {
        if (fileName == null) {
            System.out.println("filename is null");
            return false;
        }


        Scanner scanner;
        File file = new File(fileName);
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis));
            } else
                return false;
        } catch (FileNotFoundException e) {
            System.out.println("Can not open" + fileName);
            return false;
        }

        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            Vector<String> bufferChamp = new Vector<String>();
            for (String word : line.split(";")){
            	bufferChamp.add(word);
            }
            int dd=Integer.parseInt(bufferChamp.elementAt(4).substring(0, 1));
            int mm=Integer.parseInt(bufferChamp.elementAt(4).substring(3, 4));
            int yyyy=Integer.parseInt(bufferChamp.elementAt(4).substring(6, 9));
            Date date=new Date(yyyy,mm,dd);
            Beneficiaire benefiniaire=new Beneficiaire(bufferChamp.elementAt(0), bufferChamp.elementAt(1), bufferChamp.elementAt(2), bufferChamp.elementAt(3),date);
            association.getBeneficiaire().add(benefiniaire);
            association.getMap().put(benefiniaire.getId(),benefiniaire);
        }
        return true;
    }

	@Override
	public String toString() {
		return "Beneficiaire ["+super.toString()+"dateNaissance=" + dateNaissance + ", prenom=" + prenom + "]";
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

}
