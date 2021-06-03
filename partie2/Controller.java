package partie2;

import java.util.*;

import com.rabbitmq.client.DeliverCallback;

public class Controller {
	//broker or queue
	private static String broker1 = "first_broker";
	private static String broker2 = "second_broker";
	private static int num = 0;
	private static String resC[] = {"CPU usage","Available Memory"};
	public static void main(String[] args) throws Exception {
	//Reception capability	
		Subscribe controllerR1 = new Subscribe();
		controllerR1.Subscribe(broker1);
		DeliverCallback deliverCallback = (consumerTag, delivery) -> {
       	 String message = new String(delivery.getBody(), "UTF-8");
       	 System.out.println(message);
       	 };
     	controllerR1.canal.basicConsume(broker1 , true, deliverCallback, consumerTag -> { }); 
     	Thread.sleep(2000);
     	
     	//publication Specification
     	num ++;
     	Publish controllerP1 = new Publish();
		MessageBody msg1 = new Specification(""+num+"", "cpu", "Specification", "now", "", "controller", resC);
		controllerP1.Publish(broker2, msg1.toString());
		
}}