package don.mobilier;

public interface MobilierVolumineux {
	
	public double getHauteur();
	public double getLongueur();
	public double getLargeur();
	public void setHauteur(double hauteur);
	public void setLongueur(double longeur);
	public void setLargeur(double largeur);
	
	public String ToStringVolume();

}
