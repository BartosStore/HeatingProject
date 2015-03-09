package cz.bartos.heating.beans;

import cz.bartos.heating.dao.BuildingDao;
import cz.bartos.heating.domain.Building;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class BuildingConverter implements Converter, Serializable {

    @Inject BuildingDao buildingDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return buildingDao.findByName(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Building building = (Building) value;
        return building.getName();
    }

}
