package partie2;

import java.nio.charset.StandardCharsets;

public class MessageBody {
	
	int code_msg = 0;
	//default constructor
	public MessageBody() {
		code_msg = 0;
	}
	//constructor
	public MessageBody(int cMsg) {
		code_msg = cMsg;
	}
	
	//getter
	public int getCapability() {
		return this.code_msg;			
	}
	
	//setter
	void setCapability(int cMsg) {
		code_msg = cMsg;
	}
	//affichage
	public String toString() {
		return ""+code_msg+"";
	}
}
