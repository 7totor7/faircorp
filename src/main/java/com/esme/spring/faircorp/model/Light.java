package com.esme.spring.faircorp.model;
import javax.persistence.*;

@Entity// (1)
@Table(name = "LIGHT")
public class Light {
    @Id // (2)
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "level")// (3)
    private Integer level;

    @Column(name = "status")// (4)
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(optional = false)
    private Room room;

    public Light(){

    }

    public Light(Room room, Integer level, Status status) {
        this.room = room;
        this.level = level;
        this.status = status;
    }

    public Light(Integer level, Status status) {
        this.level = level;
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}