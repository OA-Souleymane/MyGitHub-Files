package partie2;

public class Result extends MessageBody{

	private enum result{mesure};
	  private result Result;
	  
	    public Result(String nom, String typ, String opId,	When wh, 
				String date, String cible, String resCol[]) {
	    	
	    	super(nom, typ, opId, wh, date, cible, resCol);
	    	Result = result.mesure; 
	    	
	    }
	    
	    public result getReceipt() {
	    	return Result;
	    }
}
