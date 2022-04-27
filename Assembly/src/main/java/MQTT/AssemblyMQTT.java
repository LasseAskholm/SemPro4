package MQTT;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.nio.charset.StandardCharsets;


public class AssemblyMQTT {
    private final String SUB_TOPIC = "emulator/status";
    private final String SUB_TOPIC2 = "emulator/checkhealth";
    private final String PUB_TOPIC = "emulator/operation";
    private final String BROKER_ID = "tcp://mqtt.localhost:1883";
    private static String CLIENT_ID = "AssemblyMQTT";
    private static AssemblyMQTT MQTT_instance = null;

    MqttClient client;
    private AssemblyMQTT() throws MqttException {
        MemoryPersistence persistence = new MemoryPersistence();
        client = new MqttClient(BROKER_ID,CLIENT_ID,persistence);
    }

    public void connect() throws MqttException {
        //Hvad fanden skal vi bruge det her til
        MqttConnectOptions options= new MqttConnectOptions();
        options.setUserName("testMQTTClient");
        options.setPassword("testPassword".toCharArray());
        // ???
        options.setCleanSession(true);

        //Vores egen implementering af et MQTTcallback interface, håndterer hvad der skal ske når man modtager en besked osv.
        //Vi skal ændre implementeringen så den gør det vi vil med beskeden i fremtiden, lige nu tester vi bare.
        client.setCallback(new PushCallback());

        //connecter *crossing fingers*
        client.connect(options);

        //subscribe til topic
        client.subscribe(SUB_TOPIC,2);
        client.subscribe(SUB_TOPIC2,2);
    }



    public void publishMessage(int message) throws MqttException {
        String s = "{\"ProcessID\":"+ message +"}";
        MqttMessage mqttMessage = new MqttMessage(s.getBytes(StandardCharsets.UTF_8));
        // qos er enten 0,1,2. Vi skal altid vælge to fordi det sikrer at beskeden altid bliver sendt 1 gang.
        mqttMessage.setQos(2);

        client.publish(PUB_TOPIC,mqttMessage);
    }

    public static AssemblyMQTT getInstance() throws MqttException {
        if (MQTT_instance == null) {
            MQTT_instance = new AssemblyMQTT();
        }
        return MQTT_instance;
    }

    public String removeChar(String s) {
        s = s.substring(1,s.length()-1);

        return s;
    }
    public String[] processMessage(String message) {
        String s = removeChar(message);
        String[] content = s.split(",");
        for (int i = 0;i<content.length;i++) {
            System.out.println(content[i]);
            System.out.println("\n");
        }
        return content;
    }

    public void disconnectClient() throws MqttException {
        client.disconnect();
        client.close();
        System.exit(0);
    }
}
