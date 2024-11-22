package org.web.transportapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class TransportDto {
    @JsonIgnore
    private UUID id;
    private TransportDto.Type type;
    private String model;
    public TransportDto(){}

    public TransportDto(TransportDto.Type type, String model) {
        this.type = type;
        this.model = model;
    }

    public TransportDto.Type getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public UUID getId() {
        return id;
    }

    public enum Type {
        Bus(0), Train(1), Plane(2), Ship(3);
        int number;
        Type(int number) {
            this.number=number;
        }
        public int getNumber(){
            return number;
        }
    }
}
