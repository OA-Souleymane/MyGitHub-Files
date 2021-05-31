package partie2;

import com.rabbitmq.client.DeliverCallback;

public class Agent {
	
	static String message = "0";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//Publication des Capability------------------------------------------------------------------------------------------------------------
		//agent first publish
		PublishCapability agentP1 = new PublishCapability();
		MessageBody msg1 = new MessageBody(0);
		agentP1.Publish("CAPAILITY", msg1.toString());
		Thread.sleep(3000);
		
//Traitement de la Specification ==> de la demande---------------------------------------------------------------
		//agent first Receive
		SubscribeOnCapability agentR1 = new SubscribeOnCapability();
		do {
			agentR1.Subscribe("SPEC");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        	 message = new String(delivery.getBody(), "UTF-8");
        	 int code = Integer.parseInt(message);           
               boolean spec = false;
               //construction des modèle de message
               String type = "";
       		if(code == 0)
       		  type = "Cap";
       		else if(code == 1) {
       			   type = "Spc";
       			   spec = true;
       		}else if(code == 2)
       			   type = "Rec";
       		else if(code == 3)
       			   type = "Res";
       		else
       		  type = "Int";
       		System.out.println("["+type+" msg : code message "+code+"]");
        	};
        	agentR1.canal.basicConsume("SPEC" , true, deliverCallback, consumerTag -> { }); 
		} while(Integer.parseInt(message.toString()) != 1);       
      	      
      	      
//Envoie des Resultats------------------------------------------------------------------------------------------
		
				//agent second publish
	int code_msg = 3;
		PublishCapability agentP2 = new PublishCapability();
		//System.out.println(msg.toString());
		while(true) {
		MessageBody msg2 = new MessageBody(code_msg);
		agentP2.Publish("RES", msg2.toString());
		//code_msg ++;
		Thread.sleep(3000);
		}
	}

}
