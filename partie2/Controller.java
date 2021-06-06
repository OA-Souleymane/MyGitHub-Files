package partie2;

import java.io.IOException;
import java.util.*;

import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.rabbitmq.client.GetResponse;

public class Controller {
	//broker or queue
	
	private static String Queue1 = "first_broker";
	private static String Queue2 = "second_broker";
	private static int num = 0;
	static int nbre  = 0;
	static String message = "";
	private static ArrayList<String> resC;
	public static void main(String[] args) throws Exception {
		resC = new ArrayList<String>();
		resC.add("CPU usage");
		resC.add("Memory Available");
     	//Reception capability	
		Subscribe controllerR1 = new Subscribe();
		controllerR1.Subscribe(Queue1);
		do {
			message = controllerR1.getMessage();
			Thread.sleep(2000);
		}while(message == null || message == "");
		System.out.println(message);
     	//publication Specification
     	
     	int stop = 0;
     	Scanner sc = new Scanner(System.in);int ord = 0;
	        do{
	        	if(ord == 0) { 
	    			System.out.println("donnez un decalage de capture");
	        	    ord++;
	        	}else 
				System.out.println("donnez un nouveau decalage de capture");
		        stop = sc.nextInt();
		        
			 }while(stop > 5);
		  
     	Publish controllerP1 = new Publish();
		MessageBody msg1 = new Specification(""+num+"", "cpu", "Specification", new When("Now",stop), "", "controller", resC);
		controllerP1.Publish(Queue2, msg1.toString());
		
		Thread.sleep(4000);
		String msg;
		int nomb = 0;
		System.out.println("appuyer sur <i> et entrer pour l'interrompre");
		//String rep = sc.next();
		while(true) {
			msg = controllerR1.getMessage();
			if(message != msg)
				System.out.println(msg);
			System.out.println("----------------------------");
			if(nomb == 6) {
				
				Publish controllerP2 = new Publish();
				controllerP2.Publish(Queue2, new Interruption(""+nomb+"", "cpu", "Specification", new When("Now",stop), "", "controller", resC).toString());
				
			}
			nomb ++;
			Thread.sleep(Integer.parseInt(""+stop+"000"));
				
		}
		
		
}}