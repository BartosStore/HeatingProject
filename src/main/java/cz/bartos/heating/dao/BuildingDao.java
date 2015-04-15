package cz.bartos.heating.dao;

import cz.bartos.heating.domain.Building;
import java.util.List;

/**
 *
 * @author Verunka
 */
public interface BuildingDao {

    public List<Building> findAll();

    public Building findByName(String name);

    public Building merge(Building building);

}
