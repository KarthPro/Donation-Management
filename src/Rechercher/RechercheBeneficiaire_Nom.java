package Rechercher;

import java.util.Comparator;

import personne.Beneficiaire;

public class RechercheBeneficiaire_Nom implements Comparator<Beneficiaire>{
	
    @Override
    public int compare(Beneficiaire a, Beneficiaire b) {
        return a.getNom().compareTo(b.getNom());
    }

}
