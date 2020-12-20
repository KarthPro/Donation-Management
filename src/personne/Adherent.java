package personne;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Adherent extends Personne{

	private String fonction;
	private String prenom;
	
	public Adherent(String nom, String coordonnees, String telephone,String prenom, String fonction) {
		super(nom, coordonnees, telephone);
		this.fonction=fonction;
		this.prenom=prenom;
	}
	
	public static boolean readFile(String fileName,Association association) {
        if (fileName == null) {
            System.out.println("filename  is null");
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

            Adherent adherent=new Adherent(bufferChamp.elementAt(0), bufferChamp.elementAt(1), bufferChamp.elementAt(2), bufferChamp.elementAt(3),bufferChamp.elementAt(4));
            association.getAdherent().add(adherent);
            association.getMap().put(adherent.getId(),adherent);
        }
        return true;
    }

	@Override
	public String toString() {
		return "Adherent ["+super.toString()+"fonction=" + fonction + ", prenom=" + prenom + "]";
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
