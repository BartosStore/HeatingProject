package cz.bartos.heating.producer;

import cz.bartos.heating.domain.Sensor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Pavel Pscheidl
 */
@Named
@RequestScoped
public class SensorProducer implements Serializable {

    public Sensor produce() {
        Sensor sensor = new Sensor();
        return sensor;
    }

    public List<Sensor> produceSensors(int numOfSensors) {
        List<Sensor> sensors = new ArrayList<>();
        for (int i = 0; i < numOfSensors; i++) {
            sensors.add(produce());
        }
        return sensors;
    }

}
