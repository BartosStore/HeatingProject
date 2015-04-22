package cz.bartos.heating.dao;

import cz.bartos.heating.domain.Room;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RoomDaoImpl implements RoomDao {

    @PersistenceContext
    EntityManager manager;

    @Override
    public Room merge(Room room) {
        return manager.merge(room);
    }

    @Override
    public void save(Room room) {
        manager.persist(room);
    }

    @Override
    public void delete(Room room) {
        manager.remove(room);
    }

    @Override
    public Room findRoomById(Long id) {
        return manager.find(Room.class, id);
    }

}
