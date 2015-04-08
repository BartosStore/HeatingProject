package cz.bartos.heating.producer;

import cz.bartos.heating.domain.Room;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author Verunka
 */
@Named
@Singleton
public class RoomProducer {

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
