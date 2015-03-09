/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.heating.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Míra
 */
@NamedQueries(
        {
            @NamedQuery(name = "findBoilerById", query = "SELECT b FROM Boiler b WHERE b.id = :id")
        }
)

@Entity
public class Boiler implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    @NotNull
    @Min(value = 5, message = "Too cold baby.")
    private int heatTemp;
    @OneToMany //(mappedBy = boiler)
    private Collection<Room> rooms;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getHeatTemp() {
        return heatTemp;
    }

    public void setHeatTemp(int heatTemp) {
        this.heatTemp = heatTemp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }

}
