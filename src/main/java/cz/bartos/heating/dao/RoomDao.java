package cz.bartos.heating.dao;

import cz.bartos.heating.domain.Room;

/**
 *
 * @author Míra
 */
public interface RoomDao {

    public Room merge(Room room);

    public void save(Room room);

    public void delete(Room room);

    public Room findRoomById(Long id);

}
