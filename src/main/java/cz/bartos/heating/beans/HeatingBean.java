package cz.bartos.heating.beans;

import cz.bartos.heating.dao.BuildingDao;
import cz.bartos.heating.domain.Building;
import cz.bartos.heating.domain.Room;
import cz.bartos.heating.service.HeatingService;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.OptionalDouble;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Miroslav Bartoš
 */
@Named
@ViewScoped
public class HeatingBean implements Serializable {

    @Inject
    private BuildingDao buildingDao;
    @Inject
    private HeatingService heatingService;
    private List<Building> buildings;
    private Building selectedBuilding;
    private double buildingAverageTemperature;
    private double targetTemperature;
    private Room lowestTempRoom, highestTempRoom;

    private void calcTargetTemperature() {
        targetTemperature = heatingService.process(lowestTempRoom.getAverageTempFromSensors());

        targetTemperature = BigDecimal.valueOf(targetTemperature).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @PostConstruct
    private void init() {
        buildings = buildingDao.findAll();
    }

    public void updateSelectedBuildingStatistics() {
        calcBuildingAverageTemperature();
        recognizeSignificantRooms();
        calcTargetTemperature();
    }

    /**
     *
     * @return
     */
    private void calcBuildingAverageTemperature() {
        OptionalDouble average = selectedBuilding.getRooms().stream().mapToDouble(r -> {
            return r.getAverageTempFromSensors();
        }).average();

        if (average.isPresent()) {
            buildingAverageTemperature = average.getAsDouble();
        } else {
            buildingAverageTemperature = Double.NaN;
        }
    }

    private void recognizeSignificantRooms() {
        lowestTempRoom = selectedBuilding.getRooms().stream().reduce((Room a, Room b) -> {
            if (a.getAverageTempFromSensors() < b.getAverageTempFromSensors()) {
                return a;
            } else {
                return b;
            }
        }).get();

        highestTempRoom = selectedBuilding.getRooms().stream().reduce((Room a, Room b) -> {
            if (a.getAverageTempFromSensors() > b.getAverageTempFromSensors()) {
                return a;
            } else {
                return b;
            }
        }).get();
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public Building getSelectedBuilding() {
        return selectedBuilding;
    }

    public void setSelectedBuilding(Building selectedBuilding) {
        this.selectedBuilding = selectedBuilding;
    }

    public double getBuildingAverageTemperature() {
        return buildingAverageTemperature;
    }

    public Room getLowestTempRoom() {
        return lowestTempRoom;
    }

    public double getTargetTemperature() {
        return targetTemperature;
    }

    public Room getHighestTempRoom() {
        return highestTempRoom;
    }

}
