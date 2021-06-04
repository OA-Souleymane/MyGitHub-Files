package partie2;

import java.util.Arrays;

public class Capaility extends MessageBody{
	
 
  private enum capability{mesure};
  private capability Capability;
  
    public Capaility(String nom, String typ, String opId,	When wh, 
			String date, String cible, String resCol[]) {
    	
    	super(nom, typ, opId, wh, date, cible, resCol);
    	Capability = capability.mesure; 
    	
    }
    
    public capability getCapaility() {
    	return Capability;
    }

	@Override
	public String toString() {
		return "Capaility [" + Capability + ", " + getName() + ", " + getType()
				+ ", " + getWhen() + ", " + getOperationId() + ", " + getTs()
				+ ", " + getTarget() + ", " + Arrays.toString(getResultColums())
				+ "]";
	}
    
}
