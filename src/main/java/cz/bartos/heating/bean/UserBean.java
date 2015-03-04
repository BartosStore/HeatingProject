/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.bartos.heating.bean;

import cz.bartos.heating.domain.Boiler;
import cz.bartos.heating.service.Service;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Míra
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

    private String name = "Pavel";
    private Boiler boiler = new Boiler();
    @Inject
    private Service service;

    public Boiler getBoiler() {
        return boiler;
    }

    public void setBoiler(Boiler boiler) {
        this.boiler = boiler;
    }

    @NotNull
    @Min(value = 0, message = "Fail")
    private int temp;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String setText() {

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ahoj", "Franto"));
        return "index";
    }

    public String getName() {
        return service.sayHello();
    }

    public void setName(String name) {
        this.name = name;
    }

}
