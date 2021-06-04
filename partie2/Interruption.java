package partie2;

public class Interruption extends MessageBody{

	  private enum interruption{mesure};
	  private interruption Interruption;
	  
	    public Interruption(String nom, String typ, String opId,	When wh, 
				String date, String cible, String resCol[]) {
	    	
	    	super(nom, typ, opId, wh, date, cible, resCol);
	    	Interruption = interruption.mesure; 
	    	
	    }
	    
	    public interruption getInterruption() {
	    	return Interruption;
	    }
}
