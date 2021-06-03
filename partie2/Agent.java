package partie2;

import com.rabbitmq.client.DeliverCallback;

public class Agent {
	static String broker1 = "first_broker";
	static String broker2 = "second_broker";
	
	static String inter_msg = "";
	static String message = "0";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//------------------------------------------------------------------------------------------------------------
		//Capability send
		//publish capability
		//agent first publish
		PublishCapability agentP1 = new PublishCapability();
		MessageBody msg1 = new MessageBody(0);
		agentP1.Publish(broker1, msg1.toString());
		System.out.println("capability msg envoyé!");
		System.out.println("-----------------------------------------");
//-----------------------------------------------------------------------------------------------------------
		//retrieve specification code
		//agent first Receive
		SubscribeOnCapability agentR1 = new SubscribeOnCapability();
		System.out.println("Attente de spécification msg!");
		do {
			agentR1.Subscribe(broker2);
			//System.out.print("!");
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
       		   /*if(message != "1") {
       			   System.out.println("Interrupt msg Reçu");
       			   System.exit(0);}*/
           	};
        	Thread.sleep(2000);
        	agentR1.canal.basicConsume(broker2 , true, deliverCallback, consumerTag -> { }); 
		} while(Integer.parseInt(message.toString()) != 1);       
      	      
      	      
//------------------------------------------------------------------------------------------
	//publication des resultats avec le code == 1
	//agent second publish
	int code_msg = 3;
	int accuse = 1;
	while(true) {
		PublishCapability agentP2 = new PublishCapability();
		MessageBody msg2;
		if(accuse == 1) { //code 2==> receipt msg
			 msg2 = new MessageBody(2);
			 accuse ++;
		}else //code 3==>result msg
		     msg2 = new MessageBody(code_msg);	
		
		agentP2.Publish(broker1, msg2.toString());
		Thread.sleep(3000);
	}
	}

}
