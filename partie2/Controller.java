package partie2;

import java.io.IOException;
import java.util.*;

import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.rabbitmq.client.GetResponse;

public class Controller {
	//broker or queue
	
	private static String Queue1 = "first_broker";
	public static String Queue2 = "second_broker";
	private static int num = 0;
	static int nbre  = 0;
	static String message = "";
	private static ArrayList<String> resC;
	 
	public static InterfaceDeVisulisation f;
	
	public static void main(String[] args) throws Exception {
		//interface d'affichage
		f = new InterfaceDeVisulisation();
		f.board.append("Attente de Capability msg");
		//tableau des resultats
		resC = new ArrayList<String>();
     	//Reception capability msg	
		Subscribe controllerR1 = new Subscribe();
		controllerR1.Subscribe(Queue1);
		do {
			f.board.setText(f.board.getText()+" !");
			message = controllerR1.getMessage();
			Thread.sleep(2000);
		}while(message == null || message == "");
		f.board.setText(f.board.getText()+"\n"+message);
		f.board.setText(f.board.getText()+"\nVeillez saisir quelque chose dans zone de decalalage <6");
     	//publication Specification
		    //le decalage entre les resultats
	        	int stop = Integer.parseInt(f.decalage_input.getText());
	        	while(stop>5) {
	        		if(f.decalage_input.hasFocus() == false)
	        		stop = Integer.parseInt(f.decalage_input.getText());
	        		Thread.sleep(1000);
	        	}
	        	f.prd.setText("Now...to..."+stop);
	    resC.add(""+f.choix_item.getSelectedItem());
     	Publish controllerP1 = new Publish();
		MessageBody msg1 = new Specification(""+num+"", "cpu", "Specification", new When("Now",stop), "", "controller", resC);
		controllerP1.Publish(Queue2, msg1.toString());
		String msg;
		int nomb = 0;
      //affichage des resultats
		while(true) {
			msg = controllerR1.getMessage();
			if(message != msg) {
				f.board.setText(f.board.getText()+"\n----------------------------\n"+msg);
				message = msg;
				for(int i= 0; i< message.length()-3; i++) 
		      		 if(message.charAt(i) == 'E' && message.charAt(i+1) == 'r' && message.charAt(i+2) == 'r' && message.charAt(i+3) == 'r')
		      	 		 System.exit(0);
			}
			Thread.sleep(Integer.parseInt(""+stop+"000"));
				
		}
		
		
}}