package com.sda.weather;

public interface LocationRepository {
    Location addLocation(Location location);

    Location showLocations(Location location);
}
