package cz.bartos.heating.beans;

import cz.bartos.heating.dao.BuildingDao;
import cz.bartos.heating.dao.RoomDao;
import cz.bartos.heating.domain.Building;
import cz.bartos.heating.domain.Room;
import cz.bartos.heating.producer.RoomProducer;
import cz.bartos.heating.producer.SensorProducer;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author Pavel Pscheidl
 */
@Named
@ViewScoped
public class AddRoomBean implements Serializable {

    @Inject
    private BuildingDao buildingDao;
    private List<Building> buildings;

    @Inject
    private RoomProducer roomProducer;
    @Inject
    private SensorProducer sensorProducer;

    @Inject
    private RoomDao roomDao;
    private Room newRoom;

    @Min(1)
    @Max(6)
    private int numOfSensors = 1;

    @PostConstruct
    public void init() {
        buildings = buildingDao.findAll();
        newRoom = roomProducer.produceSpecimenRoom();
    }

    public String submitRoom() {
        newRoom.setSensors(sensorProducer.produceSensors(numOfSensors));

        Building building = newRoom.getBuilding();
        building.getRooms().add(newRoom);
        buildingDao.merge(building);

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Místnost přidána", "Vaše místnost " + newRoom.getRoomName() + " byla uložena do budovy " + building.getName());
        FacesContext.getCurrentInstance().addMessage(null, message);

        return "/administration.xhtml";
    }

    public int getNumOfSensors() {
        return numOfSensors;
    }

    public void setNumOfSensors(int numOfSensors) {
        this.numOfSensors = numOfSensors;
    }

    public RoomProducer getRoomProducer() {
        return roomProducer;
    }

    public void setRoomProducer(RoomProducer roomProducer) {
        this.roomProducer = roomProducer;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public Room getNewRoom() {
        return newRoom;
    }

    public void setNewRoom(Room newRoom) {
        this.newRoom = newRoom;
    }

    public BuildingDao getBuildingDao() {
        return buildingDao;
    }

    public void setBuildingDao(BuildingDao buildingDao) {
        this.buildingDao = buildingDao;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

}
