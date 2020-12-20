package personne;

import java.util.ArrayList;

import don.Don;

public class PersonneMorale extends Personne{
	

	
	private String typeActivité;
	private ArrayList<Don> stock;

	public PersonneMorale(String nom, String coordonnees, String telephone,String typeActivité){
		super(nom, coordonnees, telephone);
		this.typeActivité=typeActivité; 
		stock=new ArrayList<Don>();
		
	}

	public String getTypeActivité() {
		return typeActivité;
	}

	public void setTypeActivité(String typeActivité) {
		this.typeActivité = typeActivité;
	}

	public ArrayList<Don> getStock() {
		return stock;
	}

	public void setStock(ArrayList<Don> stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "PersonneMorale ["+super.toString()+"typeActivité=" + typeActivité + "]";
	}
	
	
	
	
	

}
