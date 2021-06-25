package modele;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;

public class MessageCommonProperties {
	
	private String name;
	private String type;
	private String operationId;
	private String when;
	private String ts;
	private String target;
	private ArrayList<String> resultColumns;
	//constructor
	public MessageCommonProperties() {}
	public MessageCommonProperties(String name, String type, String operationId,	String when, 
				String ts, String target, ArrayList<String> resultColumns) {
		
		this.name = name;
		this.type = type;
		this.operationId = operationId;
		this.when = when;
		this.ts = ts;
		this.target = target;
		this.resultColumns = resultColumns;
	}
	//getter
	public String getName() {
		return this.name;			
	}
	public String getType() {
		return this.type;			
	}
	public String getWhen() {
		return this.when;			
	}
	public String getOperationId() {
		return this.operationId;			
	}
	public String getTs() {
		return this.ts;			
	}
	public String getTarget() {
		return this.target;			
	}
	public ArrayList<String> getResultColums() {
		return this.resultColumns;			
	}
	//setter
	public void setName(String name) {
		this.name = name;
	}
	public void setType(String type) {
		this.type = type;
	} 
	public void setWhen(String when) {
		this.when = when;
	}
	void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	void setTs(String ts) {
		this.ts = ts;
	}
	void setTarget(String target) {
		this.name = target;
	}
	void setResultColums(ArrayList<String> resultColumns) {
		this.resultColumns = resultColumns;
	}
	
	//Convert MessageCommonProperties to JSon
	public String toJsonStr(MessageCommonProperties msg) {
		
		return ""+new Gson().toJson(msg)+"";
	
	}//Convert JSon to MessageCommonProperties
  /*public MessageCommonProperties fromJsonStr(String msg) {
	
	Gson gson = new Gson();
    MessageCommonProperties obj = gson.fromJson(msg, MessageCommonProperties.class);
	return obj;
	
   }*/
	
}
