package partie2;

public class Capaility extends MessageBody{
	
 
  private enum capability{mesure};
  private capability Capability;
  
    public Capaility(String nom, String typ, String opId,	String wh, 
			String date, String cible, String resCol[]) {
    	
    	super(nom, typ, opId, wh, date, cible, resCol);
    	Capability = capability.mesure; 
    	
    }
    
    public capability getCapaility() {
    	return Capability;
    }
    
}
