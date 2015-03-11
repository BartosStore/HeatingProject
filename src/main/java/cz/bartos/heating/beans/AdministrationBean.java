package cz.bartos.heating.beans;

import cz.bartos.heating.dao.BuildingDao;
import cz.bartos.heating.domain.Building;
import cz.bartos.heating.domain.Room;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Verunka
 */

@Named
@ViewScoped
public class AdministrationBean implements Serializable {
    
    @Inject private BuildingDao buildingDao;
    private List<Building> buildings;
    private Building selectedBuilding;
    //mistnosti pro vybranou budovu
    private List<Room> rooms;
    private Room selectedRoom;
    
    @PostConstruct
    private void init() {
        buildings = buildingDao.findAll();
        selectedBuilding = buildings.get(0);
        
        //rooms = selectedBuilding.getRooms();
        //selectedRoom = rooms.get(0);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public Building getSelectedBuilding() {
        return selectedBuilding;
    }

    public void setSelectedBuilding(Building selectedBuilding) {
        this.selectedBuilding = selectedBuilding;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getSelectedRoom() {
        return selectedRoom;
    }

    public void setSelectedRoom(Room selectedRoom) {
        this.selectedRoom = selectedRoom;
    }
    
    
    
}
