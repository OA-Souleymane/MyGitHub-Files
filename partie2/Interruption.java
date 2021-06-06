package partie2;

import java.util.ArrayList;
import java.util.Arrays;

public class Interruption extends MessageBody{

	  private enum interruption{mesure};
	  private interruption Interruption;
	  
	    public Interruption(String nom, String typ, String opId,	When wh, 
				String date, String cible, ArrayList<String> resCol) {
	    	
	    	super(nom, typ, "Interruption", wh, date, cible, resCol);
	    	Interruption = interruption.mesure; 
	    	
	    }
	    
	    public interruption getInterruption() {
	    	return Interruption;
	    }

		@Override
		public String toString() {
			return "Interruption [" + Interruption + ", " + super.toString()+  "]";
		}
	    
	    
}
