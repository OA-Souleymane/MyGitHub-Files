package partie2;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.rabbitmq.client.DeliverCallback;

public class Agent {
	private static String Queue1 = "first_broker";
	private static String Queue2 = "second_broker";
	private static int num = 0;
	private static int decalage = 0;
	private static String message ="";
		
	private static ArrayList<String> resC;
	static boolean spec = false, memory = false;
	static boolean interrupt = false;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 MessageBody capability;
		Publish controllerP1, controllerP2;
		Subscribe Agent;
		resC = new ArrayList<String>();
		resC.add("CPU usage");
		resC.add("Available Memory");

		//signaler que les capability sont prêtes
		controllerP1 = new Publish();
		capability = new Capability(""+num+"", "cpu", "Capability", new When(), "", "controller", resC);
		controllerP1.Publish(Queue1, capability.toString());
		Thread.sleep(2000);
		
		//Reception Specification
		Agent = new Subscribe();
		Agent.Subscribe(Queue2);
		do {
			message = Agent.getMessage();
			Thread.sleep(2000);
		}while(message == null || message == "");
		Controller.f.board.setText(Controller.f.board.getText()+"\n"+message);
	
		//traitement des messages
	while(true) {
		for(int i= 0; i< message.length()-3; i++) { 
      		 if(message.charAt(i) == 'S' && message.charAt(i+1) == 'p' && message.charAt(i+2) == 'e' && message.charAt(i+3) == 'c') {
      			 spec = true;
      			 decalage = Integer.parseInt(""+message.charAt(54)+"");
      		 }else if(message.charAt(i) == 'I' && message.charAt(i+1) == 'n' && message.charAt(i+2) == 't' && message.charAt(i+3) == 'e') {
      			 interrupt = true;
      			 spec = false;
      			 }
		      if(message.charAt(i) == 'M' && message.charAt(i+1) == 'e' && message.charAt(i+2) == 'm' && message.charAt(i+3) == 'o')
			    memory = true;
		}
		MessageBody msg;
		controllerP2 = new Publish();
			 if(spec == true) {
   				    if(num == 0) {
   				    	resC = new ArrayList<String>();
   				    	if(memory == true)
   				    		resC.add("Memory Available");
   				    	else
   				    		resC.add("CPU usage");
   				    		msg = new Receipt(""+num+"", "CPU", "Receipt", new When("Now",decalage), "", "controller", resC);
   				    }else {
   				    	resC = new ArrayList<String>();
   				    	if(memory == true)
   				    		resC.add("______________");
   				    	else
   				    		resC.add("--------------");
   	       				msg = new Result(""+num+"", "CPU", "", new When("Now",decalage), "", "controller", resC);
   				    }
   				    controllerP2.Publish(Queue1, msg.toString());
   				    num++;
					Thread.sleep(Integer.parseInt(""+decalage+"000"));     			 
   			 }else if(interrupt == true){
   				 msg = new Receipt(""+num+"", "CPU", "Receipt", new When("Now",decalage), "", "controller", resC);
   				controllerP2.Publish(Queue1, msg.toString());
   				 System.exit(0);   			
   			 }else {
   				msg = new Receipt(""+num+"", "CPU", "Errors", new When(), "", "controller", resC);
   				controllerP2.Publish(Queue1, msg.toString());
   				Thread.sleep(2000);
   				System.exit(0);
   			 }
			 message = Agent.getMessage();
	}
      	}
}