package com.esme.spring.faircorp.model;
import javax.persistence.*;
import java.util.List;

@Entity // (1)
@Table(name = "SP_BUILDING") // (2)
public class Building {
    @Id // (3)
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length=255)  // (4)
    private String name;

    @OneToMany(mappedBy = "building")
    public List<Room> rooms;


    //Empty Constructor
    public Building() {
    }

    public Building(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Building(String name){
        this.name = name;
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

}
