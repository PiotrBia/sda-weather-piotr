package com.sda.weather;

import java.util.List;
import java.util.Scanner;

public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createNewLocation(Long id, String city, String region, String country, double longitude, double latitude) { // todo id is unnecessary
        if (city.length() < 1) { // todo check if it is not null
//            throw new RuntimeException("City name must have be at least 1 character long.");
            return null;
        }
        if (region.length() < 1) {  // todo region can be empty
            throw new RuntimeException("Region name must have be at least 1 character long.");
        }
        if (country.length() < 3) {
            throw new RuntimeException("Country name must have be at least 3 character long.");
        }
        if (longitude < -180 || longitude > 180) {
            throw new RuntimeException("Longitude must range from -180 to 180");
        }
        if (latitude < 0 || latitude > 90) { // todo -90 90
            throw new RuntimeException("Altitude must range from -90 to 90");
        }

        Location newLocation = new Location(null, city, region, country, longitude, latitude);

        // todo use a constructor without a region value
        //  set a region if exists

        Location addedLocation = locationRepository.addLocation(newLocation);

        return addedLocation;
    }

    public Location showAllLocations(String city) {
        return locationRepository.showLocations(showAllLocations(city));
    }
}
