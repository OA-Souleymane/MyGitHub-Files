package partie2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class SubscribeOnCapability {
	String QUEUE;
	Channel canal;
	ConnectionFactory factory;
	Connection connexion;
	public SubscribeOnCapability() throws Exception {
		factory = new ConnectionFactory();
		connexion = factory.newConnection();		
		canal = connexion.createChannel();
	}	
	
	public void Subscribe(String queue)	throws Exception {
		 QUEUE = queue;
	     canal.queueDeclare(QUEUE , false, false, false, null);
	}

	public void getMessage() throws Exception {
		//innterface à travers laquelle le consommateur peut retiré le message
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            	String message = new String(delivery.getBody(), "UTF-8");
            	int code = Integer.parseInt(message);           
                
                //construction des modèle de message
                String type = "";
        		if(code == 0)
        		  type = "Cap";
        		else if(code == 1)
        			   type = "Spc";
        		else if(code == 2)
        			   type = "Rec";
        		else if(code == 3)
        			   type = "Res";
        		else
        		  type = "Int";
        		//System.out.println("i["+type+" msg : code message "+code+"]");
        };
       
       //notifier que le message a été consommé
            canal.basicConsume(QUEUE , true, deliverCallback, consumerTag -> { });
            //System.out.println(" EN attente d'un message");	
            
            
	}
	

}
