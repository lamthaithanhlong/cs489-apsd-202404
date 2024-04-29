package edu.miu.ent.service;

import edu.miu.ent.model.Location;

import java.util.List;

public interface LocationService {
    Location addNewLocation(Location location);
    Location getLocationById(int id);
    List<Location> getAllLocations();
    Location updateLocation(Location location);
    void deleteLocationById(int id);
}