package com.esme.spring.faircorp.model;

public class RoomDto {

    private Long id;
    private String name;
    private Integer floor;
    private Long buildingId;

    public RoomDto(){

    }

    public RoomDto(String name, Integer floor, Long buildingId){
        this.name = name;
        this.floor = floor;
        this.buildingId = buildingId;
    }

    public RoomDto(Room room){
        this.id=room.getId();
        this.name=room.getName();
        this.floor=room.getFloor();
        this.buildingId=room.getBuilding().getId();
    }

    public Long getId(){ return id; }

    public String getName(){ return name; }

    public Integer getFloor(){ return floor; }

    public Long getBuildingId() { return buildingId; }

}
