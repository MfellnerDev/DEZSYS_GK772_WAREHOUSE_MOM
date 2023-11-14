package warehouse;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.stereotype.Service;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Receiver MOM Class
 *
 * @author Manuel Fellner
 * @version 14.11.2023
 */

@Service
public class MOMReceiverService {
    private static String user = ActiveMQConnection.DEFAULT_USER;
    private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String topicName = "warehouse-LINZ";

    public String readMessageQueue() {
        System.out.println( "Receiver started." );

        // Create the connection.
        Session session = null;
        Connection connection = null;
        MessageConsumer consumer = null;
        Destination destination = null;
        StringBuilder receivedMessages = null;

        try {

            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
            connection = connectionFactory.createConnection();
            connection.start();

            // Create the session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic(topicName);

            // Create the consumer
            consumer = session.createConsumer( destination );

            // Start receiving
            receivedMessages = new StringBuilder();
            TextMessage message = (TextMessage) consumer.receive();
            while ( message != null ) {
                receivedMessages.append(message.getText());
                message.acknowledge();
                message = (TextMessage) consumer.receive();
            }
            connection.stop();

        } catch (Exception e) {

            System.out.println("[MessageConsumer] Caught: " + e);
            e.printStackTrace();

        } finally {

            try { consumer.close(); } catch ( Exception e ) {}
            try { session.close(); } catch ( Exception e ) {}
            try { connection.close(); } catch ( Exception e ) {}

        }
        System.out.println( "Receiver finished." );
        return receivedMessages.toString();
    }

}