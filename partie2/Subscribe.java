package partie2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Subscribe {
	String QUEUE;
	Channel canal;
	ConnectionFactory factory;
	Connection connexion;
	public Subscribe() throws Exception {
		factory = new ConnectionFactory();
		connexion = factory.newConnection();		
		canal = connexion.createChannel();
	}	
	
	public void Subscribe(String queue)	throws Exception {
		 QUEUE = queue;
	     canal.queueDeclare(QUEUE , false, false, false, null);
	}
}
