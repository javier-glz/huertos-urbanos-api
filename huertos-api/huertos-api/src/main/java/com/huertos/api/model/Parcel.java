package com.huertos.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "parcels")
public class Parcel {

    @Id
    private String id;

    @NotBlank(message = "El nombre de la parcela es obligatorio")
    private String name;

    @NotNull(message> "Las coordenadas de ubicación son obligatorias")
    private GeoLocation location;

    @NotBlank(message = "El tipo de suelo es obligatorio (ej. arcilloso, limoso, arenoso)")
    private String soilType;

    @NotBlank(message = "El responsable o líder de la parcela es obligatorio")
    private String ownerOrLead;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Constructores vacíos y con parámetros
    public Parcel() {}

    public Parcel(String name, GeoLocation location, String soilType, String ownerOrLead) {
        this.name = name;
        this.location = location;
        this.soilType = soilType;
        this.ownerOrLead = ownerOrLead;
        this.createdAt = LocalDateTime.now();
    }

    // Clase interna para las coordenadas GPS
    public static class GeoLocation {
        private Double latitude;
        private Double longitude;

        public GeoLocation() {}

        public GeoLocation(Double latitude, Double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public Double getLatitude() { return latitude; }
        public void setLatitude(Double latitude) { this.latitude = latitude; }
        public Double getLongitude() { return longitude; }
        public void setLongitude(Double longitude) { this.longitude = longitude; }
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public GeoLocation getLocation() { return location; }
    public void setLocation(GeoLocation location) { this.location = location; }

    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }

    public String getOwnerOrLead() { return ownerOrLead; }
    public void setOwnerOrLead(String ownerOrLead) { this.ownerOrLead = ownerOrLead; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}