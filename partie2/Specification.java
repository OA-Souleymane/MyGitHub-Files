package partie2;

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

}
