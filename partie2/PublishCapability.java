package partie2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class PublishCapability {
	 ConnectionFactory factory;
	 Connection connexion;
	 Channel canal;
	 
	public PublishCapability() throws Exception {
		//interface de connexion avec RabbitMQ
        factory = new ConnectionFactory();
      //préciser que la connection en localhost
        factory.setHost("localhost");
        
        //Verification de l'établissement de la connexion
          connexion = factory.newConnection();
          canal = connexion.createChannel();
	}
	
	
	public void Publish(String queue, String msg) throws Exception {
         //creation de la queue
            canal.queueDeclare(queue , false, false, false, null);         
            
            // stockage du message dans la queue en codage lisibble
            canal.basicPublish("", queue , null, msg.getBytes(StandardCharsets.UTF_8));
		
	}
}
