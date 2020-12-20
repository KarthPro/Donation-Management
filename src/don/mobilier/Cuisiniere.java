package don.mobilier;

public class Cuisiniere extends Mobilier implements MobilierVolumineux {
	private double hauteur;
	private double longueur;
	private double largeur;
	private int puissance;
	private int nbPlaque;
	

	public Cuisiniere() {

	}

	public String toString() {
		return super.toString()+" - Cuisiniere [ Volume : "+this.ToStringVolume()+"; Puissance : "+puissance+"; Nombre de plaques : "+nbPlaque+"]";
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getNbPlaque() {
		return nbPlaque;
	}

	public void setNbPlaque(int nbPlaque) {
		this.nbPlaque = nbPlaque;
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public double getLongueur() {
		return longueur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}


	public String ToStringVolume() {

		return "hauteur : "+hauteur+", longueur "+longueur+", largeur "+largeur;
	}

}
