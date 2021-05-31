package partie2;

import com.rabbitmq.client.DeliverCallback;

public class Agent {
	
	static String message = "0";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//------------------------------------------------------------------------------------------------------------
		//Capability send
		//publish capability
		//agent first publish
		PublishCapability agentP1 = new PublishCapability();
		MessageBody msg1 = new MessageBody(0);
		agentP1.Publish("CAPAILITY", msg1.toString());
		
//-----------------------------------------------------------------------------------------------------------
		//retrieve specification code
		//agent first Receive
		SubscribeOnCapability agentR1 = new SubscribeOnCapability();
		do {
			agentR1.Subscribe("SPEC");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        	 message = new String(delivery.getBody(), "UTF-8");
        	 int code = Integer.parseInt(message);           
               //construction des modèle de message
               String type = "";
       		if(code == 0)
       		  type = "Capability";
       		else if(code == 1) 
       			   type = "Spcification";
       		else if(code == 2)
       			   type = "Receipt";
       		else if(code == 3)
       			   type = "Result";
       		else
       		  type = "Interruption";
       		System.out.println("["+type+" msg : code message "+code+"]");
        	};
        	agentR1.canal.basicConsume("SPEC" , true, deliverCallback, consumerTag -> { }); 
		} while(Integer.parseInt(message.toString()) != 1);       
      	      
      	      
//------------------------------------------------------------------------------------------
	//publication des resultats avec le code == 1
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
