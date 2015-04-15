package cz.bartos.heating.producer;

import cz.bartos.heating.domain.Room;
import cz.bartos.heating.domain.Sensor;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Verunka
 */
@Named
@RequestScoped
public class RoomProducer implements Serializable {

    public Room produceSpecimenRoom() {
        Room room = new Room();
        room.setSensors(new ArrayList<Sensor>());
        return room;
    }

}
