package cz.bartos.heating.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

/**
 *
 * @author Miroslav Bartoš
 */
@NamedQueries(
        {
            @NamedQuery(name = "findAllBuildings", query = "SELECT b FROM Building b"),
            @NamedQuery(name = "findBuildingByName", query = "SELECT b FROM Building b WHERE b.name = :name")
        }
)
@Entity
public class Building {

    @Id
    @GeneratedValue
    private long id;
    @Size(min = 1, max = 100)
    private String name;
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Room> rooms;
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Boiler> boilers;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Building other = (Building) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

}
