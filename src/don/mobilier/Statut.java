package don.mobilier;

public enum Statut {
	   ACCEPTE("Accepté"),STOCKE("Stocké"),VENDU("Vendu"),DONNE("Donne"),REFUSE("Refusé");

	   private String s;
	   private Statut(String s){
	       this.s = s;
	   }

	    @Override
	    public String toString() {
	        return s;
	    }
}
