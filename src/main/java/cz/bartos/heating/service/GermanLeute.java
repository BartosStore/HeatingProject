/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.heating.service;

import cz.bartos.heating.DAO.BoilerDao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Míra
 */
@Named
@RequestScoped
public class GermanLeute implements Service {

    @Inject
    private BoilerDao boilerDao;

    @Override
    public String sayHello() {
        return boilerDao.findBoilerById(1L).getBrand();
    }

}
