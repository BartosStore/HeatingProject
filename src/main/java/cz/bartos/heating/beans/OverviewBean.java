package cz.bartos.heating.beans;

import cz.bartos.heating.dao.BuildingDao;
import cz.bartos.heating.domain.Building;
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
    @Inject
    private BuildingConverter converter;
    private Building selectedBuilding;
    private List<Building> buildings;

    public BuildingConverter getConverter() {
        return converter;
    }

    public void setConverter(BuildingConverter converter) {
        this.converter = converter;
    }

    public Building getSelectedBuilding() {
        return selectedBuilding;
    }

    public void setSelectedBuilding(Building selectedBuilding) {
        System.out.println(selectedBuilding.getName());
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
