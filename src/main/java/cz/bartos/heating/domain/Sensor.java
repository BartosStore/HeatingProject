package cz.bartos.heating.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Miroslav Bartoš
 */
@Entity
public class Sensor {

    @Id
    @GeneratedValue
    private long id;
    private double currentTemperature;

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

}
