package modele;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

public class Capability extends MessageCommonProperties{
	
 
  public enum CapabilityEunm{mesure};
  private CapabilityEunm capability;
  
  public Capability() {}
  
    public Capability(CapabilityEunm capability, String name, String type, String operationId,	String when, 
			String ts, String target, ArrayList<String> resultColumns) {
    	
    	super(name, type,operationId, when, ts, target, resultColumns);
    	this.capability = capability; 
    	
    }
    
    public CapabilityEunm getCapaility() {
    	return capability;
    }

    public void setResult(CapabilityEunm capability) {
  	  
    	this.capability = capability;
      }
    public Capability fromJsonStr(String msg) {
    	
    	Gson gson = new Gson();
        Capability capability = gson.fromJson(msg, Capability.class);
    	return capability;
    	
       }
    
}


