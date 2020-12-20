package don.mobilier;

public class Table extends Mobilier implements MobilierVolumineux {

	private double hauteur;
	private double longueur;
	private double largeur;
	private String type;
	private String forme;

	
	public Table() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	public String toString() {
		return super.toString()+" - Table [ Volume : "+this.ToStringVolume()+"; Type : "+type+"; Forme : "+forme+"]";
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
