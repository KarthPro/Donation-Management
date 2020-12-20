package don.mobilier;

public class Couverts extends Mobilier {
	
	private int nbCouverts;

	public Couverts() {

	}
	
	public String toString() {
		return super.toString()+" - Couverts [ Nombre de couverts : "+nbCouverts+"]";
	}

	public int getNbCouverts() {
		return nbCouverts;
	}

	public void setNbCouverts(int nbCouverts) {
		this.nbCouverts = nbCouverts;
	}

}
