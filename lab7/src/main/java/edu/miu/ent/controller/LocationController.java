package edu.miu.ent.controller;


import edu.miu.ent.model.Location;
import edu.miu.ent.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping
    public Location addLocation(@RequestBody Location location) {
        return locationService.addNewLocation(location);
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PutMapping("/{id}")
    public Location updateLocation(@PathVariable int id, @RequestBody Location location) {
        location.setLocationId(id);
        return locationService.updateLocation(location);
    }
}