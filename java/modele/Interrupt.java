package modele;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

public class Interrupt extends MessageCommonProperties{

	  private enum InterruptEnum{mesure};
	  private InterruptEnum interrupt;
	  
	  public Interrupt() {}
	  
	    public Interrupt(InterruptEnum interrupt, String name, String type, String operationId,	String when, 
				String ts, String target, ArrayList<String> resultColumns) {
	    	
	    	super(name, type,operationId, when, ts, target, resultColumns);
	    	this.interrupt = interrupt; 
	    	
	    }
	    
	    public InterruptEnum getInterrupt() {
	    	return interrupt;
	    }

	    public void setInterrupt(InterruptEnum interrupt) {
	    	  
	    	this.interrupt = interrupt;
	      }

       public Interrupt fromJsonStr(String msg) {
    		
    		Gson gson = new Gson();
            Interrupt interrupt = gson.fromJson(msg, Interrupt.class);
    		return interrupt;
    		
    	   }
	    
	    
}
