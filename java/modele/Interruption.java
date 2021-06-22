package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Interruption extends MessageProprties{

	  private enum interruption{mesure};
	  private interruption Interruption;
	  
	    public Interruption(String nom, String typ, String opId,	String wh, 
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
