package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import pl.put.poznan.transformer.models.Building;
import pl.put.poznan.transformer.models.Room;



import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;
    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @RequestMapping("/buildings")
    public List<Building> all_locations() {
        logger.debug("requested all buildings");
        return locationService.getAllBuildingsList();
    }

    @RequestMapping(method = RequestMethod.POST, value = "buildings")
    public void addBuilding(@RequestBody Building building) {
        locationService.addBuilding(building);
    }

    @RequestMapping("/buildings/{id}/area")
    public float getBuildingArea(@PathVariable("id") int id) {
        return locationService.getBuildingArea(id);
    }

    @RequestMapping("/floors/{id}/area")
    public float getFloorArea(@PathVariable("id") int id) {
        return locationService.getFloorArea(id);
    }

    @RequestMapping("/rooms/{id}/area")
    public float getRoomArea(@PathVariable("id") int id) {
        return locationService.getRoomArea(id);
    }

    @RequestMapping("/buildings/{id}/cube")
    public float getBuildingCube(@PathVariable("id") int id) {
        return locationService.getBuildingCube(id);
    }

    @RequestMapping("/floors/{id}/cube")
    public float getFloorCube(@PathVariable("id") int id) {
        return locationService.getFloorCube(id);
    }

    @RequestMapping("/rooms/{id}/cube")
    public float getRoomCube(@PathVariable("id") int id) {
        return locationService.getRoomCube(id);
    }

    @RequestMapping("/buildings/{id}/lightning")
    public float getBuildingLightning(@PathVariable("id") int id) {
        return locationService.getBuildingLightning(id);
    }

    @RequestMapping("/floors/{id}/lightning")
    public float getFloorLightning(@PathVariable("id") int id) {
        return locationService.getFloorLightning(id);
    }

    @RequestMapping("/rooms/{id}/lightning")
    public float getRoomLightning(@PathVariable("id") int id) {
        return locationService.getRoomLightning(id);
    }

    @RequestMapping("rooms/{id}/heating")
    public float getRoomHeating(@PathVariable("id") int id) {
        return locationService.getRoomHeating(id);
    }

    @RequestMapping("/buildings/{id}/heating")
    public float getBuildingHeating(@PathVariable("id") int id) {
        return locationService.getBuildingHeating(id);
    }

    @RequestMapping("/floors/{id}/heating")
    public float getFloorHeating(@PathVariable("id") int id) {
        return locationService.getFloorHeating(id);
    }
    @RequestMapping("/rooms/overusingheating")
    public List<Room>  getOverusingRooms(@RequestParam float limit){
        return locationService.getOverusingRooms(limit);
    }

}


