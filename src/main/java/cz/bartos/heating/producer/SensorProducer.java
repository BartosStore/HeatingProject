package cz.bartos.heating.producer;

import cz.bartos.heating.domain.Sensor;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

/**
 *
 * @author Pavel Pscheidl
 */
@Named
@RequestScoped
public class SensorProducer implements Serializable {

    @Produces
    public Sensor produce() {
        Sensor sensor = new Sensor();
        return sensor;
    }

}
