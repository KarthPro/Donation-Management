package don.mobilier;

public class Assiettes extends Mobilier {
	
	private int nbAssiettes;

	public Assiettes() {

	}
	
	public int getNbAssiettes() {
		return nbAssiettes;
	}

	public void setNbAssiettes(int nbAssiettes) {
		this.nbAssiettes = nbAssiettes;
	}

	public String toString() {
		return super.toString()+" - Assiettes [ Nombre d'assiettes : "+nbAssiettes+"]";
	}

}
