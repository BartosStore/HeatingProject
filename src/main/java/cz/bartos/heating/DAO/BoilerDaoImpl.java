/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.heating.DAO;

import cz.bartos.heating.domain.Boiler;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Míra
 */
@Stateless
public class BoilerDaoImpl implements BoilerDao {

    @PersistenceContext
    private EntityManager eManager;

    @Override
    public Boiler findBoilerById(long id) {
        Query query = eManager.createNamedQuery("findBoilerById");
        query.setParameter("id", id);

        return (Boiler) query.getSingleResult();
    }

    @Override
    public void addBoiler(Boiler b) {
        eManager.persist(b);
    }

    @Override
    public Boiler updateBoiler(Boiler b) {
        return eManager.merge(b);
    }

    @Override
    public void deleteBoiler(Boiler b) {
        eManager.remove(b);
    }

}
