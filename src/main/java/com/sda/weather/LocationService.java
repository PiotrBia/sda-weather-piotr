package com.sda.weather;

import java.util.List;
import java.util.Scanner;

public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createNewLocation(Long id, String city, String region, String country, double longitude, double altitude) {

        if (city.length() < 1) {
            throw new RuntimeException("City name must have be at least 1 character long.");
        }
        if (region.length() < 1) {
            throw new RuntimeException("Region name must have be at least 1 character long.");
        }
        if (country.length() < 3) {
            throw new RuntimeException("Country name must have be at least 3 character long.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new RuntimeException("Longitude must range from -180 to 180");
        }
        if (altitude < 0 || altitude > 90) {
            throw new RuntimeException("Altitude must range from -90 to 90");
        }

        Location newLocation = new Location(null, city, region, country, longitude, altitude);

        Location addedLocation = locationRepository.addLocation(newLocation);

        return addedLocation;
    }

}
