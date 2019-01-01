/*
package com.esme.spring.faircorp.mqtt;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.net.URISyntaxException;

@RestController  // (1)
@RequestMapping("/api/subscribe/") // (2)
@Transactional // (3)
public class SubscriberController {

    public SubscriberController() throws MqttException, URISyntaxException {
    }

    //Subscriber out of Getmapping to avoid creating again the same subscriber.
    private Subscriber s = new Subscriber("tcp://7totor7:7totor7@m15.cloudmqtt.com:14768");

    //Inital Get when loading the page
    @CrossOrigin
    @GetMapping // (5)
    public String subscribe() throws MqttException, InterruptedException {
        String message = "[{\"id\":0,\"level\":8,\"status\":\"ON\",\"roomId\":0},{\"id\":1,\"level\":0,\"status\":\"OFF\",\"roomId\":1}]";
        s.sendMessage(message);
        //Wait until the message is received to return last_message.
        //received_complete and last_message are public var from the subscriber class.
        while(!s.received_complete)
        {
            Thread.sleep(1000);
        }
        s.received_complete = false;
        String last_message = s.last_message;
        return last_message;
    }
}
*/
