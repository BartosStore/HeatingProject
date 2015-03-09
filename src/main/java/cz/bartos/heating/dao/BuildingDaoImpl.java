package cz.bartos.heating.dao;

import cz.bartos.heating.domain.Building;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BuildingDaoImpl implements BuildingDao {

    @PersistenceContext
    private EntityManager eManager;
    
    @Override
    public List<Building> findAll() {
        Query query = eManager.createNamedQuery("findAllBuildings");
        
        return query.getResultList();
    }

    @Override
    public Building findByName(String name) {
        Query query = eManager.createNamedQuery("findBuildingByName");
        query.setParameter("name", name);
        
        return (Building) query.getSingleResult();
    }
    
}
