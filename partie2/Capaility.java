package partie2;

import java.util.Arrays;

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

	@Override
	public String toString() {
		return "Capaility [Capability=" + Capability + ", getName()=" + getName() + ", getType()=" + getType()
				+ ", getWhen()=" + getWhen() + ", getOperationId()=" + getOperationId() + ", getTs()=" + getTs()
				+ ", getTarget()=" + getTarget() + ", getResultColums()=" + Arrays.toString(getResultColums())
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
    
}
