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
public class BoilerDao {

    @PersistenceContext
    private EntityManager manager;

    public Boiler findById(long id) {

        Query query = manager.createNamedQuery("findBoilerById");
        query.setParameter("id", id);

        return (Boiler) query.getSingleResult();

    }

}
