package modele;

import java.util.ArrayList;

import com.google.gson.Gson;

public class Receipt extends MessageCommonProperties{

	    private enum ReceiptEnum{mesure};
	    private ReceiptEnum receipt;
	    
	    public Receipt() {}
	    
	    public Receipt(ReceiptEnum receipt, String name, String type, String operationId,	String when, 
				String ts, String target, ArrayList<String> resultColumns) {
	    	
	    	super(name, type,operationId, when, ts, target, resultColumns);
	    	this.receipt = receipt; 
	    	
	    }
	    
	    public ReceiptEnum getReceipt() {
	    	return receipt;
	    }

	    public void setReceipt(ReceiptEnum receipt) {
	    	  
	    	this.receipt = receipt;
	    }
       public Receipt fromJsonStr(String msg) {
    		
    	 Gson gson = new Gson();
         Receipt receipt = gson.fromJson(msg, Receipt.class);
         return receipt;
    		
     }
	    
}
