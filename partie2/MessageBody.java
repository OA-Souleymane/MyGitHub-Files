package partie2;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class MessageBody {
	
	private String name;
	private String type;
	private String operationId;
	private When when;
	private String ts;
	private String target;
	private String resultColumns[];
	//constructor
	public MessageBody(String nom, String typ, String opId,	When wh, 
				String date, String cible, String resCol[]) {
		name = nom;
		type = typ;
		operationId = opId;
		when = wh;
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
	public When getWhen() {
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
	public String[] getResultColums() {
		return this.resultColumns;			
	}
	//setter
	void setName(String nom) {
		this.name = nom;
	}
	void setType(String tp) {
		this.type = tp;
	} 
	void setWhen(When wh) {
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
	void setResultColums(String resC[]) {
		this.resultColumns = resC;
	}
}
