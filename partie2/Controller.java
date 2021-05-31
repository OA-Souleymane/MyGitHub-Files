package partie2;

import java.util.*;

import com.rabbitmq.client.DeliverCallback;

public class Controller {
	static String message = "";
	public static void main(String[] args) throws Exception {
		
		SubscribeOnCapability controllerR1 = new SubscribeOnCapability();
		System.out.println("En attente de Spec msg ");
		do {
			System.out.print("!");
			controllerR1.Subscribe("CAPAILITY");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        	 message = new String(delivery.getBody(), "UTF-8");
        	 if(message != "")
        		 System.out.println();
        	 System.out.println(" message "+message);
        	};
		    Thread.sleep(1000);
        	controllerR1.canal.basicConsume("CAPAILITY" , true, deliverCallback, consumerTag -> { }); 
		} while(message == "");
		
		System.out.println("-----------------------------------------------");
		int code_msg;
		System.out.println("donnez une spécification");
	    Scanner sc = new Scanner(System.in);
	    code_msg = sc.nextInt();
	    while(code_msg != 0 && code_msg != 1 && code_msg != 2 && code_msg != 3){
			System.out.println("donnez une nouvelle spécification");
		    code_msg = sc.nextInt();
		}
		PublishCapability controllerP1 = new PublishCapability();
		MessageBody msg1 = new MessageBody(code_msg);
		controllerP1.Publish("SPEC", msg1.toString());
		Thread.sleep(1000);
	
		System.out.println("----------------------------------------------");
		message = "";
		SubscribeOnCapability controllerR2 = new SubscribeOnCapability();
		do {
        controllerR2.Subscribe("RES");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        	 message = new String(delivery.getBody(), "UTF-8");
        	 System.out.println(" message "+message);
        	};
        	
		
		
	        controllerR2.canal.basicConsume("RES" , true, deliverCallback, consumerTag -> { }); 
		} while(message != "");
		
		System.out.println("moi");

	}

}
