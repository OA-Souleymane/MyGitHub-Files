package partie2;

import com.rabbitmq.client.DeliverCallback;

public class Agent {
	private static String Queue1 = "first_broker";
	private static String Queue2 = "second_broker";
	private static int num = 0;
	private static String resC[] = {"CPU usage","Available Memory"};
	
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
       	 };
       	Agent.canal.basicConsume(Queue2 , true, broker2, consumerTag -> { });	
       	}
}
