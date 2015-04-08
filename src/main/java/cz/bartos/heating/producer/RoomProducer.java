package cz.bartos.heating.producer;

import cz.bartos.heating.domain.Room;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Verunka
 */
@Named
@RequestScoped
public class RoomProducer implements Serializable {

    @Inject SensorProducer sensorProducer;

    @Produces
    public Room produceSpecimenRoom() {
        Room room = new Room();
        for (int i = 0; i < 2; i++) {
            room.addSensor(sensorProducer.produce());
        }
        return room;
    }

}
