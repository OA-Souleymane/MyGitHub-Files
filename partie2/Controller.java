package partie2;

import java.util.*;

import com.rabbitmq.client.DeliverCallback;

public class Controller {
	static String inter = "";
	static String message = "";
	public static void main(String[] args) throws Exception {
	//-----------------------------------------------------------------------
		//Capability retrieved
		SubscribeOnCapability controllerR1 = new SubscribeOnCapability();
		System.out.println("En attente de Capability msg ");
		do {
			System.out.print("!");
			controllerR1.Subscribe("CAPAILITY");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
        	 message = new String(delivery.getBody(), "UTF-8");
        	 if(message != "") {
        		 System.out.println();
        	     System.out.println(" message "+message);
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
//--------------------------------------------------------------------------------
		//Monitoring the result
		System.out.println("----------------------------------------------");
		System.out.println("Result msg");
		message = "";
		SubscribeOnCapability controllerR2 = new SubscribeOnCapability();
		int etat = 0;
		do {
        controllerR2.Subscribe("RES");
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
	        controllerR2.canal.basicConsume("RES" , true, deliverCallback, consumerTag -> { }); 
		    /*if(inter != "") {
		    	PublishCapability interrupt = new PublishCapability();
				MessageBody inter_msg = new MessageBody(-1);
				controllerP1.Publish("INTERRUPT", inter_msg.toString());
				inter = "";*/
		   
		} while(message != "");
		
//----------------------------------------------------------------------------------------------------------------
		//pour interrompre le l'envoie du resultat
		/*System.out.println("-----------------------------------------------");
		String interrupt_code = "";
		System.out.println("voulez-vous interrompre O/N?");
		interrupt_code = sc.nextLine();
	    while(interrupt_code != ""){
			System.out.println("Encore, voulez-vous interrompre O/N?");
			interrupt_code = sc.nextLine();
		}
		PublishCapability interrupt = new PublishCapability();
		MessageBody inter = new MessageBody(-1);
		controllerP1.Publish("INTERRUPT", inter.toString());
		Thread.sleep(1000);*/
	}

}
