package cz.bartos.heating.beans;

import cz.bartos.heating.dao.RoomDao;
import cz.bartos.heating.domain.Room;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author Verunka
 */
@Named
@ViewScoped
public class EditRoomBean implements Serializable {

    @ManagedProperty(value = "#{param.id}")
    private Long id;

    @Inject
    private RoomDao roomDao;
    private Room editRoom;

    @Min(1)
    @Max(6)
    private int numOfSensors = 1;

    @PostConstruct
    public void init() {
        //Long pomId = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
        System.out.println("V Y P A R S O V A N É   I D : " + id);

        Long a = Long.valueOf(11);
        editRoom = roomDao.findRoomById(a);
        numOfSensors = editRoom.getSensors().size();

    }

    public String submitRoom() {
        /*editRoom.setSensors(sensorProducer.produceSensors(numOfSensors));

         Building building = editRoom.getBuilding();
         building.getRooms().add(editRoom);
         buildingDao.merge(building);

         FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Místnost přidána", "Vaše místnost " + editRoom.getRoomName() + " byla uložena do budovy " + building.getName());
         FacesContext.getCurrentInstance().addMessage(null, message);*/

        return "/administration.xhtml";
    }

    public int getNumOfSensors() {
        return numOfSensors;
    }

    public void setNumOfSensors(int numOfSensors) {
        this.numOfSensors = numOfSensors;
    }

    public RoomDao getRoomDao() {
        return roomDao;
    }

    public void setRoomDao(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public Room getEditRoom() {
        return editRoom;
    }

    public void setEditRoom(Room editRoom) {
        this.editRoom = editRoom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
