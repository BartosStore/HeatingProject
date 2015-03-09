/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.heating.DAO;

import cz.bartos.heating.domain.Boiler;

/**
 *
 * @author Míra
 */
public interface BoilerDao {

    Boiler findBoilerById(long id);

    void addBoiler(Boiler b);

    Boiler updateBoiler(Boiler b);

    void deleteBoiler(Boiler b);

}
