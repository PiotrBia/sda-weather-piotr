package com.sda.weather;

public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    public String addNewLocation(String city, double longitude, double altitude, String region, String country) {
        Location newLocation = locationService.createNewLocation(null, city, region, country, longitude, altitude);
        return String.format("{\"id\": %s, \"city\": \"%s\", \"region\": \"%s\", \"country\": \"%s\", \"longitude\": \"%s\", \"altitude\": \"%s\"}",
                newLocation.getId(), newLocation.getCity(), newLocation.getRegion(), newLocation.getCountry(), newLocation.getLongitude(), newLocation.getLatitude());
    }
}
