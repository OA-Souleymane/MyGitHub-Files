package agent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import modele.Capability;
import modele.Receipt;
import modele.Result;

public class AgentPubSub {
	

	public void publishCapability(Capability cap) throws Exception {
		String queue = "Capability";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, cap.toString().getBytes(StandardCharsets.UTF_8));
	}
		
	public void subcribeSpeifiation() throws Exception {
		String queue = "Specification";
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
	
	public void publishReceipt(Receipt receipt) throws Exception {
		String queue = "Receipt";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, receipt.toString().getBytes(StandardCharsets.UTF_8));
	}
	
	public void publishResult(Result result) throws Exception {
		String queue = "Result";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, result.toString().getBytes(StandardCharsets.UTF_8));
	}
	
	
	public void subcribeInterrupt() throws Exception {
		String queue = "Interrupt";
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
	
}

