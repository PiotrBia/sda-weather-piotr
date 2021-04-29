package com.sda.weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String city;
    String region;
    String country;
    double longitude;
    double altitude;
    char longitudeDirection;
    char altitudeDirection;

    public Location() {
    }

    public Location(Long id, String city, String region, String country, double longitude, double altitude) {
        this.id = id;
        this.city = city;
        this.region = region;
        this.country = country;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() { return altitude; }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }
}
