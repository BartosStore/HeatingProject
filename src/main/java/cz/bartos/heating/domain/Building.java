package cz.bartos.heating.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author Miroslav Bartoš
 */
@Entity
public class Building {

    @Id
    @GeneratedValue
    private long id;
    @Size(min = 1, max = 100)
    private String name;
    @OneToMany
    private List<Room> rooms;
    @OneToMany
    private List<Boiler> boilers;

    public List<Boiler> getBoilers() {
        return boilers;
    }

    public void setBoilers(List<Boiler> boilers) {
        this.boilers = boilers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

}
