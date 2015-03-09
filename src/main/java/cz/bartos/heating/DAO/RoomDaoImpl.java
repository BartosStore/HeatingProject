/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.heating.DAO;

import cz.bartos.heating.domain.Room;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Míra
 */
public class RoomDaoImpl implements RoomDao {

    @PersistenceContext
    private EntityManager eManager;

    @Override
    public Room findRoomById(long id) {
        Query query = eManager.createNamedQuery("findRoomById");
        query.setParameter("id", id);

        return (Room) query.getSingleResult();
    }

    @Override
    public void addRoom(Room r) {
        eManager.persist(r);
    }

    @Override
    public Room updateRoom(Room r) {
        return eManager.merge(r);
    }

    @Override
    public void deleteRoom(Room r) {
        eManager.remove(r);
    }

    @Override
    public Collection<Room> findAll() {
        Query query = eManager.createNamedQuery("SELECT r from Room r");

        return query.getResultList();
    }

}
