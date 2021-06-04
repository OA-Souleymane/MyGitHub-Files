package partie2;


public class Receipt extends MessageBody{

	private enum receipt{mesure};
	  private receipt Receipt;
	  
	    public Receipt(String nom, String typ, String opId,	When wh, 
				String date, String cible, String resCol[]) {
	    	
	    	super(nom, typ, opId, wh, date, cible, resCol);
	    	Receipt = receipt.mesure; 
	    	
	    }
	    
	    public receipt getReceipt() {
	    	return Receipt;
	    }
}
