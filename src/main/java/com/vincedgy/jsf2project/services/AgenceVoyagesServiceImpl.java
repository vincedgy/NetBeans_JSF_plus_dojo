package com.vincedgy.jsf2project.services;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.vincedgy.jsf2project.jaxb.AgenceVoyages;
import com.vincedgy.jsf2project.managedBeans.AgenceVoyageBean;

@ManagedBean(name="AgenceVoyagesService", eager=true)
@ApplicationScoped
public class AgenceVoyagesServiceImpl implements Serializable {

	private static final long serialVersionUID = 1L;

	private static AgenceVoyagesServiceImpl SINGLETON;
	
	private static AgenceVoyages agenceVoyages = null;

		public AgenceVoyagesServiceImpl () {}
	
	public static AgenceVoyagesServiceImpl getInstance() {
		if (SINGLETON == null) {
			SINGLETON = new AgenceVoyagesServiceImpl();
			
			if (agenceVoyages == null) {
				try {
					JAXBContext context = JAXBContext
							.newInstance("com.vincedgy.jsf2project.jaxb");
					Unmarshaller decodeur = context.createUnmarshaller();
					InputStream input = AgenceVoyageBean.class
							.getResourceAsStream("../exercice10.xml");
					agenceVoyages = (AgenceVoyages) decodeur.unmarshal(input);				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		return SINGLETON;
	}
	
	public AgenceVoyages getAgenceVoyages() {
		return agenceVoyages;
	}
}
