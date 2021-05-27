package partie2;

public class Controller {

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
		PublishCapability spec = new PublishCapability();
		//System.out.println(msg.toString());
		MessageBody msg = new MessageBody(1);
		spec.Publish("SPEC", msg.toString());
		Thread.sleep(5000); 
		
          /*SubscribeOnCapability controller = new SubscribeOnCapability();
          controller.Subscribe("QUEUE");
          while(true) {
          controller.getMessage();
          Thread.sleep(3000);
          }*/
	}

}
