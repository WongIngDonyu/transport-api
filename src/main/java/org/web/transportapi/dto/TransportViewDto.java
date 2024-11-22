package org.web.transportapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class TransportViewDto {
    @JsonIgnore
    private UUID id;
    private TransportDto.Type type;
    private String model;
    private int capacity;
    public TransportViewDto() {}

    public TransportViewDto(TransportDto.Type type, String model, int capacity) {
        this.type = type;
        this.model = model;
        this.capacity = capacity;
    }

    public TransportDto.Type getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public UUID getId() {return id;}

}
