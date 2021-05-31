package partie2;

import java.nio.charset.StandardCharsets;

public class MessageBody {
	
	int code_msg = 0;
	//code = 0 => Capability msg, 
	//code = 1 => Specification msg, 
	//code = 2 => Receipt msg, 
	//code = 3 => Result msg, 
	//sinon => Interrupt msg;
	//default constructor
	public MessageBody() {
		code_msg = 0;
	}
	//constructor
	public MessageBody(int cMsg) {
		code_msg = cMsg;
	}
	
	//getter
	public int getCodeMsg() {
		return this.code_msg;			
	}
	
	//setter
	void setCodeMsg(int cMsg) {
		code_msg = cMsg;
	}
	//affichage
	public String toString() {
		String msg;
		if(code_msg == 0)
			msg = "Capability Message !!! \n" + 
					"code = 1 => Specification msg, \r\n" + 
					"code = 2 => Receipt msg, \r\n" + 
					"code = 3 => Result msg, \r\n" + 
					"sinon => Interrupt msg;\r\n";
		else msg = ""+code_msg+"";
		return msg;
	}
}
