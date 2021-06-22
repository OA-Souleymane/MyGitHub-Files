package controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import modele.Interruption;
import modele.Specification;

public class ControllerPubSub {
		
	public void subcribeCapability() throws Exception {
		String queue = "Capability";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);         
		
		DeliverCallback broker1 = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");       	     
	    };
	     canal.basicConsume(queue , true, broker1, consumerTag -> { });
	}
	
	public void publishSpecification(Specification spec) throws Exception {
		String queue = "Specification";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, spec.toString().getBytes(StandardCharsets.UTF_8));
	}
	
	public void subcribeReceipt() throws Exception {
		String queue = "Receipt";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);         
		
		DeliverCallback broker1 = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");       	     
	    };
	     canal.basicConsume(queue , true, broker1, consumerTag -> { });
	}
	
	public void subcribeResult() throws Exception {
		String queue = "Result";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);         
		
		DeliverCallback broker1 = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");       	     
	    };
	     canal.basicConsume(queue , true, broker1, consumerTag -> { });
	}
	
	public void publishInterrupt(Interruption interrupt) throws Exception {
		String queue = "Interrupt";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, interrupt.toString().getBytes(StandardCharsets.UTF_8));
	}
}
