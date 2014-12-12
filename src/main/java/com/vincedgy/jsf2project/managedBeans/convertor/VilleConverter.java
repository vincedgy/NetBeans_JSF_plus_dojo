package com.vincedgy.jsf2project.managedBeans.convertor;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.vincedgy.jsf2project.jaxb.Ville;
import com.vincedgy.jsf2project.services.AgenceVoyagesService;

@FacesConverter(value="villeConverter", forClass=Ville.class)
public class VilleConverter implements Converter {
	
	@EJB
	private AgenceVoyagesService agenceVoyagesService;
	
	public List<Ville> getVilles() {
		return agenceVoyagesService.getVilles();
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            Ville ville = null;       	
        	Iterator <Ville> iterateOnVilles = getVilles().iterator();
        	do {
        		ville = (Ville) iterateOnVilles.next();        		
        	} while(ville.getCodePostal().equals(submittedValue));        	
        	return ville;
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Ville ID", submittedValue)), e);
        }
    }

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }
        
        if (modelValue instanceof Ville) {
            return String.valueOf(((Ville) modelValue).getNom() + "(" + ((Ville) modelValue).getCodePostal() + ")");
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Ville", modelValue)));
        }
	}

}
