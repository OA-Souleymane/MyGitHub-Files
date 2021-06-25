package controller;

import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import modele.Capability;
import modele.Interruption;
import modele.Receipt;
import modele.Result;
import modele.Specification;

public class ControllerPubSub {
		
	public void subscribeCapability() throws Exception {
		String queue = "/capability";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);         
		
		DeliverCallback broker1 = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");
			Capability capability = new Capability().fromJsonStr(message);
			new ControllerPubSubCallback().subscribeCapabilityCallback(capability);
	    };
	     canal.basicConsume(queue , true, broker1, consumerTag -> { });
	}
	
	public void publishSpecification(Specification spec) throws Exception {
		String queue = "/specification";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, spec.toString().getBytes(StandardCharsets.UTF_8));
	}
	
	public void subscribeReceipt() throws Exception {
		String queue = "/receipt";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);         
		
		DeliverCallback broker1 = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8"); 
			
			Receipt receipt = new Receipt().fromJsonStr(message);
			new ControllerPubSubCallback().subscribeReceiptCallback(receipt);
	    };
	     canal.basicConsume(queue , true, broker1, consumerTag -> { });
	}
	
	public void subscribeResult() throws Exception {
		String queue = "/result";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);         
		
		DeliverCallback broker1 = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8"); 
			
			Result result = new Result().fromJsonStr(message);
			new ControllerPubSubCallback().subscribeResultCallback(result);
	    };
	     canal.basicConsume(queue , true, broker1, consumerTag -> { });
	}
	
	public void publishInterrupt(Interruption interrupt) throws Exception {
		String queue = "/interrupt";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, interrupt.toString().getBytes(StandardCharsets.UTF_8));
	}
}
