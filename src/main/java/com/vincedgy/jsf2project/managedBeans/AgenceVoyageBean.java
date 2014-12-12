package com.vincedgy.jsf2project.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.vincedgy.jsf2project.jaxb.ModeDeTransport;
import com.vincedgy.jsf2project.jaxb.Ville;
import com.vincedgy.jsf2project.services.AgenceVoyagesServiceImpl;

@ManagedBean(name="agenceVoyageBean")
@SessionScoped
public class AgenceVoyageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private AgenceVoyagesServiceImpl agenceVoyagesService = AgenceVoyagesServiceImpl.getInstance();
	private List<Ville> villes; 
	private List<ModeDeTransport> modesDeTransport;
	
	public AgenceVoyageBean() {	}
	
	public List<Ville> getVilles() {
		return villes;
	}

	public List<ModeDeTransport> getModesDeTransport() {
		return modesDeTransport;
	}

	@PostConstruct
	public void init() {
		villes = agenceVoyagesService.getAgenceVoyages().getVille();
		modesDeTransport = agenceVoyagesService.getAgenceVoyages().getModeDeTransport();
	}
		
}
