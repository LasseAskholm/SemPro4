package MQTT;

import org.eclipse.paho.client.mqttv3.*;

import java.util.UUID;
import java.util.concurrent.Callable;

public class Client implements Callable<Void> {
    static String publisherId = UUID.randomUUID().toString();
    static IMqttClient publisher;

    static {
        try {
            publisher = new MqttClient("tcp://mqtt.localhost:1883",publisherId);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

    public static void connection() throws MqttException {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        publisher.connect(options);
    }

    public Client() throws MqttException {
    }

    public static void main(String[] args) throws MqttException {
        connection();
    }

    @Override
    public Void call() throws Exception {
        return null;
    }
}
