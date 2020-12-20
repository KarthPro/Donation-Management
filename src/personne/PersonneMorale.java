package personne;

import java.util.ArrayList;

import don.Don;

public class PersonneMorale extends Personne{
	

	
	private String typeActivit�;
	private ArrayList<Don> stock;

	public PersonneMorale(String nom, String coordonnees, String telephone,String typeActivit�){
		super(nom, coordonnees, telephone);
		this.typeActivit�=typeActivit�; 
		stock=new ArrayList<Don>();
		
	}

	public String getTypeActivit�() {
		return typeActivit�;
	}

	public void setTypeActivit�(String typeActivit�) {
		this.typeActivit� = typeActivit�;
	}

	public ArrayList<Don> getStock() {
		return stock;
	}

	public void setStock(ArrayList<Don> stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "PersonneMorale ["+super.toString()+"typeActivit�=" + typeActivit� + "]";
	}
	
	
	
	
	

}
