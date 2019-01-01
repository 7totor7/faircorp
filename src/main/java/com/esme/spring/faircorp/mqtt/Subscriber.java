/*
package com.esme.spring.faircorp.mqtt;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.net.URI;
import java.net.URISyntaxException;

*/
/**
 * A sample application that demonstrates how to use the Paho MQTT v3.1 Client blocking API.
 *//*

public class Subscriber implements MqttCallback {

    private final int qos = 1;
    private String topic = "toto";
    public String last_message="nothing";
    public volatile boolean received_complete;
    private MqttClient client;

    public Subscriber(String uri) throws MqttException, URISyntaxException {
        this(new URI(uri));
    }

    public Subscriber(URI uri) throws MqttException {
        String host = String.format("tcp://%s:%d", uri.getHost(), uri.getPort());
        String[] auth = this.getAuth(uri);
        String username = auth[0];
        String password = auth[1];
        String clientId = "MQTT-Java-Example";
        if (!uri.getPath().isEmpty()) {
            this.topic = uri.getPath().substring(1);
        }

        MqttConnectOptions conOpt = new MqttConnectOptions();
        conOpt.setCleanSession(true);
        conOpt.setUserName(username);
        conOpt.setPassword(password.toCharArray());

        this.client = new MqttClient(host, clientId, new MemoryPersistence());
        this.client.setCallback(this);
        this.client.connect(conOpt);
        this.client.subscribe(this.topic, qos);
    }

    private String[] getAuth(URI uri) {
        String a = uri.getAuthority();
        String[] first = a.split("@");
        return first[0].split(":");
    }

    public void sendMessage(String payload) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
        message.setQos(qos);
        this.client.publish(this.topic, message); // Blocking publish
    }

    */
/**
     * @see MqttCallback#connectionLost(Throwable)
     *//*

    public void connectionLost(Throwable cause) {
        System.out.println("Connection lost because: " + cause);
        System.exit(1);
    }

    */
/**
     * @see MqttCallback#deliveryComplete(IMqttDeliveryToken)
     *//*

    public void deliveryComplete(IMqttDeliveryToken token) {
    }

    */
/**
     * @see MqttCallback#messageArrived(String, MqttMessage)
     *//*

    @Override
    public void messageArrived(String topic, MqttMessage message) throws MqttException {
        String last_message = new String(message.getPayload());
        this.last_message = last_message;
        System.out.println(String.format("[%s] %s", topic, last_message));
        this.received_complete = true;
    }

    // MAIN inside the class so we can try it without launching the app!!!! :D
    public static void main(String[] args) throws MqttException, URISyntaxException {
        */
/*Subscriber s = new Subscriber("tcp://7totor7:7totor7@m15.cloudmqtt.com:14768");
        s.sendMessage("Hello");
        s.sendMessage("Hello 2");*//*

    }
}*/
