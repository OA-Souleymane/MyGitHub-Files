package agent;

import java.nio.charset.StandardCharsets;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import modele.Capability;
import modele.Interrupt;
import modele.Receipt;
import modele.Result;
import modele.Specification;

public class AgentPubSub {
	

	public void publishCapability(Capability cap) throws Exception {
		String queue = "/capability";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, cap.toString().getBytes(StandardCharsets.UTF_8));
	}
		
	public void subscribeSpecifiation() throws Exception {
		String queue = "/specification";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);         
		
		DeliverCallback broker1 = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8"); 
			
			Specification specification = new Specification().fromJsonStr(message);
			new AgentPubSubCallback().subscribeSpecificationCallback(specification);
	    }; 
	     canal.basicConsume(queue , true, broker1, consumerTag -> { });
	}
	
	public void publishReceipt(Receipt receipt) throws Exception {
		String queue = "/receipt";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, receipt.toString().getBytes(StandardCharsets.UTF_8));
	}
	
	public void publishResult(Result result) throws Exception {
		String queue = "/result";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);
	       
	       // stockage du message dans la queue en codage lisibble
	       canal.basicPublish("", queue , null, result.toString().getBytes(StandardCharsets.UTF_8));
	}
	
	
	public void subscribeInterrupt() throws Exception {
		String queue = "/interrupt";
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connexion = factory.newConnection();
		Channel canal = connexion.createChannel();
		canal.queueDeclare(queue , false, false, false, null);         
		
		DeliverCallback broker1 = (consumerTag, delivery) -> {
			String message = new String(delivery.getBody(), "UTF-8");  
			
			Interrupt interrupt = new Interrupt().fromJsonStr(message);
			new AgentPubSubCallback().subscribeInterruptCallback(interrupt);
	    };
	     canal.basicConsume(queue , true, broker1, consumerTag -> { });
	}
	
}

