package Rechercher;

import java.util.Comparator;

import personne.Beneficiaire;

public class RechercheBeneficiaire_Telephone implements Comparator<Beneficiaire>{

    @Override
    public int compare(Beneficiaire a, Beneficiaire b) {
        return a.getTelephone().compareTo(b.getTelephone());
    }
}
