package cz.bartos.heating.beans;

import cz.bartos.heating.dao.BuildingDao;
import cz.bartos.heating.domain.Building;
import cz.bartos.heating.domain.Room;
import cz.bartos.heating.domain.Sensor;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Verunka
 */
@Named
@ViewScoped
public class OverviewBean implements Serializable {

    @Inject
    private BuildingDao buildingsDao;
    private List<Building> buildings;
    private Building selectedBuilding;

    public Building getSelectedBuilding() {
        return selectedBuilding;
    }

    public void setSelectedBuilding(Building selectedBuilding) {
        this.selectedBuilding = selectedBuilding;
    }

    @PostConstruct
    private void init() {
        buildings = buildingsDao.findAll();
        selectedBuilding = buildings.get(0);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public double calcAverageTemp(List<Sensor> sensors) {
        double identity = 0;
        for (Sensor s : sensors) {
            identity += s.getCurrentTemperature();
        }

        return identity / sensors.size();
    }
}
