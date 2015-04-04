package cz.bartos.heating.dao;

import com.sun.scenario.effect.Merge;
import cz.bartos.heating.domain.Building;
import cz.bartos.heating.domain.Room;
import java.util.List;

/**
 *
 * @author Míra
 */
public interface RoomDao {
    
    public Room merge(Room room);

}
