/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.heating.DAO;

import cz.bartos.heating.domain.Room;
import java.util.Collection;

/**
 *
 * @author Míra
 */
public interface RoomDao {

    Room findRoomById(long id);

    void addRoom(Room r);

    Room updateRoom(Room r);

    void deleteRoom(Room r);

    Collection<Room> findAll();

}
