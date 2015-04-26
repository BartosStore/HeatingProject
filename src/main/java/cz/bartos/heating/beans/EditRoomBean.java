package cz.bartos.heating.beans;

import cz.bartos.heating.dao.RoomDao;
import cz.bartos.heating.domain.Room;
import cz.bartos.heating.domain.Sensor;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
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

    @ManagedProperty(value = "#{param.roomId}")
    private Long id;

    @Inject
    private RoomDao roomDao;
    private Room editRoom;

    @Min(1)
    @Max(6)
    private int numOfSensors = 1;

    @PostConstruct
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
        String roomId = paramMap.get("roomId");

        System.out.println("V Y P A R S O V A N É   I D : " + roomId);

        id = Long.parseLong(roomId);

        editRoom = roomDao.findRoomById(id);
        numOfSensors = editRoom.getSensors().size();

    }

    public String submitRoom() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Úpravy změněny", "Nové nastavení je platné.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        roomDao.merge(editRoom);
        return "/administration.xhtml";
    }

    public void changeSensorCount() {
        editRoom.getSensors().clear();
        for (int i = 0; i < numOfSensors; i++) {
            editRoom.getSensors().add(new Sensor());
        }
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
