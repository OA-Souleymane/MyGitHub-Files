package modele;

import java.util.ArrayList;

public class Receipt extends MessageProprties{

	private enum receipt{mesure};
	private static enum etat{Receipt, Errors};
	  private receipt Receipt;
	  private etat etat_rec;
	  
	    public Receipt(String nom, String typ, String opId,	String wh, 
				String date, String cible, ArrayList<String> resCol) {
	    	
	    	super(nom, typ, opId, wh, date, cible, resCol);
	    	Receipt = receipt.mesure; 
	    	
	    }
	    
	    public receipt getReceipt() {
	    	return Receipt;
	    }
	    public etat getEtat() {
	    	return this.etat_rec;
	    }

		@Override
		public String toString() {
			return "Receipt [" + Receipt +", "+  super.toString() + "]";
		}
	    
	    
}
