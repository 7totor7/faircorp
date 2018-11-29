package com.esme.spring.faircorp.model;
import javax.persistence.*;
import java.util.List;

@Entity // (1)
@Table(name = "SP_ROOM") // (2)
public class Room {
    @Id // (3)
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length=255)  // (4)
    private String name;

    @Column(nullable = false, name = "floor") // (4)
    private Integer floor;

    @OneToMany(mappedBy = "room")
    public List<Light> lights;

    @ManyToOne(optional = false)
    private Building building;

    //Empty Constructor
    public Room() {
    }

    public Room(Integer floor, List<Light> lights) {
        this.floor = floor;
        this.lights = lights;
    }

    public Room(String name, Integer floor, Building building){
        this.name = name;
        this.floor = floor;
        this.building = building;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }


}