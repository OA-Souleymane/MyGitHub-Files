package partie2;

import com.rabbitmq.client.DeliverCallback;

public class Agent {
	private static String broker1 = "first_broker";
	private static String broker2 = "second_broker";
	private static int num = 0;
	private static String resC[] = {"CPU usage","Available Memory"};
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//Publication Capability
		num ++;
		Publish controllerP1 = new Publish();
		MessageBody msg1 = new Capaility(""+num+"", "cpu", "specification", "now", "", "controller", resC);
		controllerP1.Publish(broker1, msg1.toString());
		Thread.sleep(2000);
		
		//Reception Specification
		Subscribe Agent = new Subscribe();
		Agent.Subscribe(broker2);
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
       	 String message = new String(delivery.getBody(), "UTF-8");
       	 System.out.println(message);
       	 };
       	Agent.canal.basicConsume(broker2 , true, deliverCallback, consumerTag -> { });	
       	}
}
