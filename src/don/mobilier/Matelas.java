package don.mobilier;

public class Matelas extends Mobilier implements MobilierVolumineux{
	
	private double hauteur;
	private double longueur;
	private double largeur;
	
	public Matelas() {
	}
	
	public String toString() {
		return super.toString()+" - Matelas [ Volume : "+this.ToStringVolume()+"]";
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
