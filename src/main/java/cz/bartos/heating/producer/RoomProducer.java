package cz.bartos.heating.producer;

import cz.bartos.heating.domain.Room;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author Verunka
 */
@Named
@Singleton
public class RoomProducer {

    @Produces
    public Room produceSpecimenRoom() {
        Room room = new Room();
        return room;
    }

}
