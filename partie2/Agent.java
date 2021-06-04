package partie2;

import java.util.Scanner;

import com.rabbitmq.client.DeliverCallback;

public class Agent {
	private static String Queue1 = "first_broker";
	private static String Queue2 = "second_broker";
	private static int num = 0;
	private static int ordre = 0;
	private static String resC[] = {"CPU usage","Available Memory"};
	static boolean spec = false;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Publication Capability
		When duree = new When(1);
		num ++;
		Publish controllerP1 = new Publish();
		MessageBody msg1 = new Capaility(""+num+"", "cpu", "Capability", duree, "", "controller", resC);
		controllerP1.Publish(Queue1, msg1.toString());
		Thread.sleep(2000);
		
		//Reception Specification
		Subscribe Agent = new Subscribe();
		Agent.Subscribe(Queue2);
		DeliverCallback broker2 = (consumerTag, delivery) -> {
       	 String message = new String(delivery.getBody(), "UTF-8");
       	 System.out.println(message);
       	 for(int i= 0; i<message.length(); i++)
       		 if(message.charAt(i) == 'S' && message.charAt(i+1) == 'p' && message.charAt(i+2) == 'e' && message.charAt(i+3) == 'c')
       			 spec = true;
       		 else if(message.charAt(i) == 'I' && message.charAt(i+1) == 't' && message.charAt(i+2) == 'e' && message.charAt(i+3) == 'r' && message.charAt(i+4) == 'r')
       			 System.exit(0);
       	         
       			 if(ordre < 5 && spec == true) {
       				When dure = new When(2);
       				int stop;
       				Scanner sc = new Scanner(System.in);
       				 if(ordre == 0) {
       					System.out.println("donnez une limite de capture");
   				        stop = sc.nextInt();
   				     while(stop > 5){
       						System.out.println("donnez une nouvelle limite de capture");
       				        stop = sc.nextInt();
       				        ordre ++;
       					}  				     				   
       					dure = new When(stop); 
       					int i = 0;
       					while(i < stop) {
       				num ++;
       			     MessageBody result = new Result(""+ num++ +"", "result", "", dure, "", "controller", resC);
					try {
						controllerP1.Publish(Queue1, result.toString());
						i++;
						Thread.sleep(2000);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					}      				
       			 }
       				 ordre ++;
       			 }
       		 
       	 };
       	Agent.canal.basicConsume(Queue2 , true, broker2, consumerTag -> { });	
       	}
}
