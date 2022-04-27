package MQTT;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.nio.charset.StandardCharsets;


public class TestMQTT {

    public static void main(String[] args) {
        String subTopic = "emulator/status";
        String pubTopic = "emulator/operation";
        String content= "{\"ProcessID\":5555}"; // skal være en json besked ?
        String brokerid="tcp://mqtt.localhost:1883";
        String clientId = "testMQTTClient";
        MemoryPersistence persistence = new MemoryPersistence();

        try{
            MqttClient client = new MqttClient(brokerid,clientId,persistence);

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
            client.subscribe(subTopic);

            //publish message
            client.publish(pubTopic,getPublishMessage(content));

            client.disconnect();
            client.close();
            System.exit(0);


        } catch (MqttException e) {
            e.printStackTrace();
        }


    }

    public static MqttMessage getPublishMessage(String message){


        MqttMessage mqttMessage = new MqttMessage(message.getBytes(StandardCharsets.UTF_8));
        // qos er enten 0,1,2. Vi skal altid vælge to fordi det sikrer at beskeden altid bliver sendt 1 gang.
        mqttMessage.setQos(2);
        return mqttMessage;
    }

    public void disconnectClient(){

    }
}
