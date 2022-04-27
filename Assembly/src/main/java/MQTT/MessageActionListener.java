package MQTT;

import org.eclipse.paho.client.mqttv3.IMqttToken;


public class MessageActionListener implements org.eclipse.paho.client.mqttv3.IMqttActionListener{

    protected final String messageText;
    protected final String topic;
    protected final String userContext;

    public MessageActionListener(String messageText, String topic, String userContext) {
        this.messageText = messageText;
        this.topic = topic;
        this.userContext = userContext;
    }

    @Override
    public void onSuccess(
            IMqttToken asyncActionToken) {
        if ((asyncActionToken != null) &&
                asyncActionToken.getUserContext()
                        .equals(userContext))
        {
            System.out.println( String.format(
                    "Message '%s' published to topic '%s'",
                    messageText, topic));
        }
    }

    @Override
    public void onFailure(
            IMqttToken asyncActionToken,
            Throwable exception) {
        exception.printStackTrace();
    }
}
