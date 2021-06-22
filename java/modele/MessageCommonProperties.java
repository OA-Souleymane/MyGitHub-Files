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
	public MessageCommonProperties(String nom, String typ, String opId,	String wh, 
				String date, String cible, ArrayList<String> resCol) {
		
		name = nom;
		type = typ;
		operationId = opId;
		when = "Start....Stop";
		date = ""+new Date();
		ts = date;
		target = cible;
		resultColumns = resCol;
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
	public void setName(String nom) {
		this.name = nom;
	}
	public void setType(String tp) {
		this.type = tp;
	} 
	public void setWhen(String wh) {
		this.when = wh;
	}
	void setOperationId(String opId) {
		this.operationId = opId;
	}
	void setTs(String ts) {
		this.ts = ts;
	}
	void setTarget(String trg) {
		this.name = trg;
	}
	void setResultColums(ArrayList<String> resC) {
		this.resultColumns = resC;
	}
	@Override
	public String toString() {
		return ""+ name + ", " + type + ", " + operationId + "," + when
				+ ", " + ts + ", " + target + ", " + resultColumns.toString() + "";
	}
	public String convertObjetJson(MessageCommonProperties msgp) {
		
		return ""+new Gson().toJson(msgp)+"";
	
	}


}
