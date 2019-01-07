package com.esme.spring.faircorp.model;

import com.esme.spring.faircorp.mqtt.Subscriber;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static com.esme.spring.faircorp.mqtt.Subscriber.temporarySubscriber;

@RestController  // (1)
@RequestMapping("/api/lights") // (2)
@Transactional // (3)
public class LightController {

    @Autowired
    private LightDao lightDao; // (4)
    @Autowired
    private RoomDao roomDao;

    @CrossOrigin
    @GetMapping // (5)
    public List<LightDto> findAll() {
        return lightDao.findAll()
                .stream()
                .map(LightDto::new)
                .collect(Collectors.toList());
    }
    @CrossOrigin
    @GetMapping(path = "/{id}")
    public LightDto findById(@PathVariable Long id) {
        return lightDao.findById(id).map(light -> new LightDto(light)).orElse(null);
    }

    @CrossOrigin
    @PutMapping(path = "/{id}/switch")
    public LightDto switchStatus(@PathVariable Long id) throws InterruptedException, MqttException, URISyntaxException {
        Subscriber.client.disconnect();
        Subscriber.client.close();
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        String message = String.format("%s/%s", light.getStatus(), light.getId());
        String result = temporarySubscriber("SWITCH", message);
        if (result != null) {
            light.setStatus(light.getStatus() == Status.ON ? Status.OFF : Status.ON);
            return new LightDto(light);
        }
        else{
            return null;
        }
    }

    @CrossOrigin
    @PutMapping(path = "/{id}/party")
    public LightDto party(@PathVariable Long id) throws InterruptedException, MqttException, URISyntaxException {
        Subscriber.client.disconnect();
        Subscriber.client.close();
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        String message = String.format("LOOP/%s", light.getId());
        String result = temporarySubscriber("COLOR", message);
        if (result != null) {
            light.setStatus(Status.ON);
            return new LightDto(light);
        }
        else{
            return null;
        }
    }

    /*@CrossOrigin
    @PutMapping(path = "{id}/{color}")
    public LightDto party(@PathVariable Long id, @PathVariable  String color) throws InterruptedException, MqttException, URISyntaxException {
        Subscriber.client.disconnect();
        Subscriber.client.close();
        Light light = lightDao.findById(id).orElseThrow(IllegalArgumentException::new);
        String message = String.format("%s/%s", color, light.getId());
        String result = temporarySubscriber("COLOR", message);
        if (result != null) {
            light.setStatus(Status.ON);
            return new LightDto(light);
        }
        else{
            return null;
        }
    }*/





    ////////////////////////////////////////////////////////////////////////
    @CrossOrigin
    @PostMapping
    public LightDto create(@RequestBody LightDto dto) {
        Light light = null;
        if (dto.getId() != null) {
            light = lightDao.findById(dto.getId()).orElse(null);
        }

        if (light == null) {
            light = lightDao.save(new Light(roomDao.getOne(dto.getRoomId()), dto.getLevel(), dto.getStatus()));
        } else {
            light.setLevel(dto.getLevel());
            light.setStatus(dto.getStatus());
            lightDao.save(light);
        }

        return new LightDto(light);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        lightDao.deleteById(id);
    }
}
