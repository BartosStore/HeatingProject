package cz.bartos.heating.domain;

import cz.bartos.heating.dao.BuildingDao;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Verunka
 */
@Named
public class BuildingConverter implements Converter, Serializable {
    
    @Inject 
    private BuildingDao buildingDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return buildingDao.findByName(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Building b = (Building) value;
        
        return b.getName();
    }
    
}
