package partie2;

public class Agent {

	public String affichageMsg(String message) {
		int code = Integer.parseInt(message);           
        
        //construction des modèle de message
        String type = "";
		if(code == 0)
		  type = "Cap";
		else if(code == 1)
			   type = "Spc";
		else if(code == 2)
			   type = "Rec";
		else if(code == 3)
			   type = "Res";
		else
		  type = "Int";
		return "["+type+" msg : code message "+code+"]";
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
	int code_msg = 0;
		PublishCapability agent = new PublishCapability();
		//System.out.println(msg.toString());
		while(true) {
		MessageBody msg = new MessageBody(code_msg);
		agent.Publish("QUEUE", msg.toString());
		code_msg ++;
		Thread.sleep(3000);
		}
	}

}
