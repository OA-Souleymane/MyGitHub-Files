package modele;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;


public class Result extends MessageCommonProperties{

	private enum ResultEnum{mesure};
	  private ResultEnum result;
	  
	  public Result() {}
	  
	    public Result(ResultEnum result, String name, String type, String operationId,	String when, 
				String ts, String target, ArrayList<String> resultColumns) {
	    	
	    	super(name, type,operationId, when, ts, target, resultColumns);
	    	this.result = result; 
	    	
	    }
	    
	    public ResultEnum getResult() {
	    	return result;
	    }

	    public void setResult(ResultEnum result) {
	    	  
	    	this.result = result;
	      }
	    
	    public Result fromJsonStr(String msg) {
    		
	    	 Gson gson = new Gson();
	         Result result = gson.fromJson(msg, Result.class);
	         return result;
	    		
	     }
}
