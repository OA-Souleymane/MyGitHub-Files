package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Result extends MessageProprties{

	private enum result{mesure};
	  private result Result;
	  
	    public Result(String nom, String typ, String opId,	String wh, 
				String date, String cible, ArrayList<String> resCol) {
	    	
	    	super(nom, typ, "Result", wh, date, cible, resCol);
	    	Result = result.mesure; 
	    	
	    }
	    
	    public result getReceipt() {
	    	return Result;
	    }

		@Override
		public String toString() {
			return "Result [" + Result + ", " + super.getName() + ", " + super.getType() + ", " + super.getOperationId() + "," + super.getWhen().toString()
			+ ", " + super.getTs() + ", " + super.getTarget() + ", " + super.getResultColums().toString() +  "]";
		}
	    
	    
}
