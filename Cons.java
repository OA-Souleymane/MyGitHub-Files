package projet;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Cons {

    private final static String MA_QUEUE  = "queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connexion = factory.newConnection();
        Channel canal = connexion.createChannel();

        canal.queueDeclare(MA_QUEUE , false, false, false, null);
        System.out.println(" EN attente d'un message");

        //innterface � travers laquelle le consommateur peut retir� le message
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" Message � consommer: " + message + "'");
        };
        
        //notifier que le message a �t� consomm�
        canal.basicConsume(MA_QUEUE , true, deliverCallback, consumerTag -> { });
    }
}
