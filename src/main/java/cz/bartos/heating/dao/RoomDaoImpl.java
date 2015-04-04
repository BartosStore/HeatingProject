package cz.bartos.heating.dao;

import cz.bartos.heating.domain.Room;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public class RoomDaoImpl implements RoomDao {
    
    @PersistenceContext EntityManager manager;

    @Override
    public Room merge(Room room) {
        return manager.merge(room);
    }
    
}
