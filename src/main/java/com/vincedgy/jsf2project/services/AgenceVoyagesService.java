package com.vincedgy.jsf2project.services;

import java.util.List;

import com.vincedgy.jsf2project.jaxb.ModeDeTransport;
import com.vincedgy.jsf2project.jaxb.Ville;

public interface AgenceVoyagesService {

	public abstract List<Ville> getVilles();

	public abstract List<ModeDeTransport> getModesDeTransport();

}