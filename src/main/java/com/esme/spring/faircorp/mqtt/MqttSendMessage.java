package com.esme.spring.faircorp.mqtt;

import org.eclipse.paho.client.mqttv3.*;

import java.util.UUID;

public class MqttSendMessage {
    public String TOPIC = "topic";
    public MqttSendMessage() throws MqttException {
        String publisherId = "toto";
        String username = "toto";
        String password = "toto";
        MqttClient publisher = new MqttClient("tcp://m23.cloudmqtt.com:11344", publisherId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        publisher.connect(options);

    }
    // ... private members omitted

    public void call(MqttClient publisher) throws Exception {
        if ( !publisher.isConnected()) {
            System.out.println("Connexion failed");
        }
        MqttMessage msg = sendMessage();
        msg.setQos(0);
        msg.setRetained(true);
        publisher.publish(TOPIC,msg);

        /*MqttMessage msg = readEngineTemp();
        msg.setQos(0);
        msg.setRetained(true);
        private String TOPIC = "topic";
        client.publish(TOPIC,msg);*/
    }

    private MqttMessage sendMessage() {
        String msg = "Hola";
        byte[] payload = msg.getBytes();
        return new MqttMessage(payload);
    }
}
