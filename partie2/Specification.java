package partie2;

import java.util.Arrays;

public class Specification extends MessageBody{

	private enum specification{mesure};
	  private specification Specification;
	  
	    public Specification(String nom, String typ, String opId,	String wh, 
				String date, String cible, String resCol[]) {
	    	
	    	super(nom, typ, opId, wh, date, cible, resCol);
	    	Specification = specification.mesure; 
	    	
	    }
	    
	    public specification getSpecification() {
	    	return Specification;
	    }

		@Override
		public String toString() {
			return "Specification [Specification=" + Specification + ", getName()=" + getName() + ", getType()="
					+ getType() + ", getWhen()=" + getWhen() + ", getOperationId()=" + getOperationId() + ", getTs()="
					+ getTs() + ", getTarget()=" + getTarget() + ", getResultColums()="
					+ Arrays.toString(getResultColums()) + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}

	    
}
