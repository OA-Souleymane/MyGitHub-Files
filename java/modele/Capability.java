package modele;

import java.util.ArrayList;
import java.util.Arrays;
public class Capability extends MessageCommonProperties{
	
 
  private enum capability{mesure};
  private capability Capability;
  
    public Capability(String nom, String typ, String opId,	String wh, 
			String date, String cible, ArrayList<String> resCol) {
    	
    	super(nom, typ, "Capability", wh, date, cible, resCol);
    	Capability = capability.mesure; 
    	
    }
    
    public capability getCapaility() {
    	return Capability;
    }

	@Override
	public String toString() {
		return "Capaility [" + Capability + ", " + super.toString()+ "]";
	}
    
}


