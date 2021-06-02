package partie2;

import java.util.*;

import com.rabbitmq.client.DeliverCallback;

public class Controller {
	static String inter = "";
	static String message = "";
	
	static int ordre = 1;
	public static void main(String[] args) throws Exception {
	//-----------------------------------------------------------------------
		//Capability retrieved 
		SubscribeOnCapability controllerR1 = new SubscribeOnCapability();
		controllerR1.Subscribe("CAPAILITY");
		System.out.println("En attente de Capability msg ");
		do {
			System.out.print("!");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        	 message = new String(delivery.getBody(), "UTF-8");
        	 if(ordre == 1) { //Monitoring capability
        		 System.out.println();
        	     System.out.println(" message "+message);
        	     ordre ++;
        	 }else{  //Monitoring the Receipt
        		 if(ordre == 2) {
        			System.out.println("----------------------------------------------");
        			System.out.println("Receipt msg");
        			ordre++;
        		 }else if(ordre == 3) { //Monitoring the result
        			 System.out.println("----------------------------------------------");
        			 System.out.println("Result msg");
        			 ordre ++;
        			 }
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
        	 }
        	};
		    Thread.sleep(2000);
        	controllerR1.canal.basicConsume("CAPAILITY" , true, deliverCallback, consumerTag -> { }); 
		} while(message == "");
		
//------------------------------------------------------------------------------------
	  //send code specification
		//on saisit spec code (soit 1 ou une interruption ==> autre que 0,2,3)
		System.out.println("-----------------------------------------------");
		int code_msg;
		System.out.println("donnez une spécification");
	    Scanner sc = new Scanner(System.in);
	    code_msg = sc.nextInt();
	    while(code_msg == 2 || code_msg == 2 || code_msg == 3){
			System.out.println("donnez une nouvelle spécification");
		    code_msg = sc.nextInt();
		}
		PublishCapability controllerP1 = new PublishCapability();
		MessageBody msg1 = new MessageBody(code_msg);
		controllerP1.Publish("SPEC", msg1.toString());
		Thread.sleep(1000);
	}

}
