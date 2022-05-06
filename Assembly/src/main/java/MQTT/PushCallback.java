package MQTT;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class PushCallback implements MqttCallback {
    AssemblyMQTT instance;
    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("connection lost");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        instance = AssemblyMQTT.getInstance();
        System.out.println("Topic to recieve message from: " + s);
        System.out.println("receive messages QOS: " + mqttMessage.getQos());
        String res = new String(mqttMessage.getPayload());
        //System.out.println("Message content: " + res);
        instance.processMessage(res);
        Thread.sleep(6000);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("Delivery complete " + iMqttDeliveryToken.isComplete());

    }
}
