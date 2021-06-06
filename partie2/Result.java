package partie2;

import java.util.ArrayList;
import java.util.Arrays;

public class Result extends MessageBody{

	private enum result{mesure};
	  private result Result;
	  
	    public Result(String nom, String typ, String opId,	When wh, 
				String date, String cible, ArrayList<String> resCol) {
	    	
	    	super(nom, typ, "Result", wh, date, cible, resCol);
	    	Result = result.mesure; 
	    	
	    }
	    
	    public result getReceipt() {
	    	return Result;
	    }

		@Override
		public String toString() {
			return "Result [" + Result + ", " + super.toString()+  "]";
		}
	    
	    
}
