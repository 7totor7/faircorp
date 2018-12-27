package com.esme.spring.faircorp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController  // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {

    @Autowired
    private RoomDao roomDao;
    @Autowired
    private BuildingDao buildingdao;

    @CrossOrigin
    @GetMapping
    public List<RoomDto> findAll(){
        return roomDao.findAll()
                .stream()
                .map(RoomDto::new)
                .collect(Collectors.toList());
    }


}
