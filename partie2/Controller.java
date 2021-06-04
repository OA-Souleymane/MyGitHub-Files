package partie2;

import java.io.IOException;
import java.util.*;

import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

public class Controller {
	//broker or queue
	
	private static String Queue1 = "first_broker";
	private static String Queue2 = "second_broker";
	private static int num = 0;
	private static String resC[] = {"CPU usage","Available Memory"};
	public static void main(String[] args) throws Exception {
	
	//Reception capability	
		Subscribe controllerR1 = new Subscribe();
		controllerR1.Subscribe(Queue1);
		DeliverCallback broker1 = (consumerTag, delivery) -> {
       	 String message = new String(delivery.getBody(), "UTF-8");
       	 System.out.println(message);
       	
       	 };
     	controllerR1.canal.basicConsume(Queue1 , true, broker1, consumerTag -> { }); 
     	Thread.sleep(2000);
     	
     	//publication Specification
     	num ++;
     	When duree = new When(2);
     	Publish controllerP1 = new Publish();
		MessageBody msg1 = new Specification(""+num+"", "cpu", "Specification", duree, "", "controller", resC);
		controllerP1.Publish(Queue2, msg1.toString());
		
}}