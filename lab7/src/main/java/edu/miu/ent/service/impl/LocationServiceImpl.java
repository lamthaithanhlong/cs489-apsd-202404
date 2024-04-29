package edu.miu.ent.service.impl;

import edu.miu.ent.model.Location;
import edu.miu.ent.repository.LocationRepository;
import edu.miu.ent.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location addNewLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location getLocationById(int id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location updateLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteLocationById(int id) {
        locationRepository.deleteById(id);
    }
}