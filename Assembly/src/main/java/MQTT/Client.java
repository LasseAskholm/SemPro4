package MQTT;

import org.eclipse.paho.client.mqttv3.MqttException;

public class Client {
    public static void main(String[] args) throws MqttException {
        AssemblyMQTT assemblyMQTT = new AssemblyMQTT();

        assemblyMQTT.connect();
        assemblyMQTT.publishMessage(435);
    }
}
