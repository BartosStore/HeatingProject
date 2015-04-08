package cz.bartos.heating.producer;

import cz.bartos.heating.domain.Sensor;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 *
 * @author Pavel Pscheidl
 */
@Named
@Singleton
public class SensorProducer {

    @Produces
    public Sensor produce() {
        Sensor sensor = new Sensor();
        return sensor;
    }

}
