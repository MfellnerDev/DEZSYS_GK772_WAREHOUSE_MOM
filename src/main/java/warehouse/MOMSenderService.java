package warehouse;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.jms.*;

/**
 * The sender class of the MOM Application - sends the data of all articles in a warehouse as JSON
 *
 * @author Manuel Fellner
 * @version 14.11.2023
 */
@Service
public class MOMSenderService {

    private static String warehouseUUID = "469d7240-b974-441d-9562-2c56a7b28767";
    private static String warehouseAPIUrl = "http://localhost:8080/warehouse/" + warehouseUUID + "/data";

    private static String user = ActiveMQConnection.DEFAULT_USER;
    private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String topicName = "warehouse-LINZ";

    public void sendMessage()   {
        System.out.println("Sender startet...");

        // create a connection to the apacheMQ broker
        Session session = null;
        Connection connection = null;
        MessageProducer producer = null;
        Destination destination = null;
        try {
            // init new connection
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connection = connectionFactory.createConnection();
            connection.start();

            // Create the session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic(topicName);

            // Create the producer
            producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);

            // Create the message
            String currentWarehouseData = consumeWarehouseAPI();
            TextMessage message = session.createTextMessage(currentWarehouseData);
            producer.send(message);
            System.out.println(message.getText());

            connection.stop();

        } catch (Exception e)   {
            System.out.println("[MessageProducer] Caught: " + e);
            e.printStackTrace();
        } finally {
            try { producer.close(); } catch ( Exception e ) {}
            try { session.close(); } catch ( Exception e ) {}
            try { connection.close(); } catch ( Exception e ) {}
        }
        System.out.println("Sender finished.");
    }

    public String consumeWarehouseAPI() {
        System.out.println("Consuming the warehouse API with the url " + warehouseAPIUrl + "...");
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(warehouseAPIUrl, String.class);
    }
}