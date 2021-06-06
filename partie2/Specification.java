package partie2;

import java.util.ArrayList;
import java.util.Arrays;

public class Specification extends MessageBody{

	private enum specification{mesure};
	
	  private specification Specification;
	  
	    public Specification(String nom, String typ, String opId,	When wh, 
				String date, String cible, ArrayList<String> resCol) {
	    	
	    	super(nom, typ, "Specification", wh, date, cible, resCol);
	    	Specification = specification.mesure; 
	    	
	    }
	    
	    public specification getSpecification() {
	    	return Specification;
	    }

		@Override
		public String toString() {
			return "Specification [" + Specification + ", " + super.toString()+  "]";
		}

	    
}
