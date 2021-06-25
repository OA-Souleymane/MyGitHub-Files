package modele;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

public class Specification extends MessageCommonProperties{

	private enum SpecificationEnum{mesure};
	
	  private SpecificationEnum specification;
	  
	  public Specification() {}
	    public Specification(SpecificationEnum specification, String name, String type, String operationId,	String when, 
				String ts, String target, ArrayList<String> resultColumns) {
	    	
	    	super(name, type,operationId, when, ts, target, resultColumns);
	    	this.specification = specification; 
	    	
	    }
	    
	    public SpecificationEnum getSpecification() {
	    	return specification;
	    }
      public void setSpecification(SpecificationEnum specification) {
    	  
    	  this.specification = specification; 
      }
      public Specification fromJsonStr(String msg) {
    		
    		Gson gson = new Gson();
    		Specification specification = gson.fromJson(msg, Specification.class);
    		return specification;
    		
    	   }
      
}
