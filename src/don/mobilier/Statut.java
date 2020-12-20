package don.mobilier;

public enum Statut {
	   ACCEPTE("Accept�"),STOCKE("Stock�"),VENDU("Vendu"),DONNE("Donne"),REFUSE("Refus�");

	   private String s;
	   private Statut(String s){
	       this.s = s;
	   }

	    @Override
	    public String toString() {
	        return s;
	    }
}
