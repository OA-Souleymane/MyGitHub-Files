package projet;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;

public class Prod {
	
	//le nom de la queue
    private final static String MA_QUEUE  = "queue";
    private final static int Msg_num = 0;
    public static void main(String[] argv) throws Exception {
    	
    	//interface de connexion avec RabbitMQ
        ConnectionFactory factory = new ConnectionFactory();
        
        //préciser que la connection en localhost
        factory.setHost("localhost");
        
        //Verification de l'établissement de la connexion
        try (Connection connexion = factory.newConnection();
             Channel canal = connexion.createChannel()) {
        	
        	//creation de la queue
            canal.queueDeclare(MA_QUEUE , false, false, false, null);
            
            //le massage a envoyé et sa publication sur le canal "queue"
            String message = "Message "+Msg_num;
            
            // stockage du message dans la queue en codage lisibble
            canal.basicPublish("", MA_QUEUE , null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Message produit: " + message + "'");
        }
    }
}