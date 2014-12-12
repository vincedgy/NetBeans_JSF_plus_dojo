package com.vincedgy.jsf2project.managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.vincedgy.jsf2project.jaxb.ModeDeTransport;
import com.vincedgy.jsf2project.jaxb.Ville;
import com.vincedgy.jsf2project.services.AgenceVoyagesServiceImpl;

@ManagedBean(name = "trajetBean")
@RequestScoped
public class TrajetBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String strDateDepart="";
	private String strDateRetour="";

	private List<String> modesChoisis;
	private List<String> villesChoisies;

	private List<ModeDeTransport> modesDeTransport;
	private List<Ville> villes;

	public TrajetBean() {
	}

	public List<String> getModesChoisis() {
		return modesChoisis;
	}

	public List<ModeDeTransport> getModesDeTransport() {
		return modesDeTransport;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public List<String> getVillesChoisies() {
		return villesChoisies;
	}

	public String submit() {
		villes = new ArrayList<Ville>();
		Iterator<Ville> listVilles = AgenceVoyagesServiceImpl.getInstance()
				.getAgenceVoyages().getVille().iterator();
		do {
			Ville ville = listVilles.next();
			for (String villeChoisie : villesChoisies) {
				if (ville.getCodePostal().equals(villeChoisie)) {
					villes.add(ville);
				}
			}
		} while (listVilles.hasNext());

		modesDeTransport = new ArrayList<ModeDeTransport>();
		Iterator<ModeDeTransport> listModes = AgenceVoyagesServiceImpl
				.getInstance().getAgenceVoyages().getModeDeTransport()
				.iterator();
		do {
			ModeDeTransport modeDeTransport = listModes.next();
			for (String modeChoisi : modesChoisis) {
				if (modeDeTransport.getIdentifiant().toString()
						.equals(modeChoisi)) {
					modesDeTransport.add(modeDeTransport);
				}
			}
		} while (listModes.hasNext());

		return "validate";
	}

	public void setModesChoisis(List<String> modesChoisis) {
		this.modesChoisis = modesChoisis;
	}

	public void setModesDeTransport(List<ModeDeTransport> modesDeTransport) {
		this.modesDeTransport = modesDeTransport;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public void setVillesChoisies(List<String> villesChoisies) {
		this.villesChoisies = villesChoisies;
	}

	public String getStrDateDepart() {
		return strDateDepart;
	}

	public void setStrDateDepart(String strDateDepart) {
		this.strDateDepart = strDateDepart;
	}

	public String getStrDateRetour() {
		return strDateRetour;
	}

	public void setStrDateRetour(String strDateRetour) {
		this.strDateRetour = strDateRetour;
	}

	public String getVerifDateDepart() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg;		
		if ("".equals(strDateDepart) || strDateDepart == null) {
			msg = new FacesMessage("Date Départ","Date de départ invalide !");	
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			context.addMessage("dateDepartMsg", msg);
			return "La date de départ " + strDateDepart + " est invalide";
		} else {			
			return "La date de départ " + strDateDepart + " est valide";
		}
	}

	public String getVerifDateRetour() {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg;		
		if ("".equals(strDateRetour) || strDateRetour == null) {
			msg = new FacesMessage("Date Retour","Date de retour invalide !");	
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			context.addMessage("dateRetourMsg", msg);
			return "La date de retour " + strDateDepart + " est invalide";
		} else {
			return "La date de retour " + strDateRetour + " est valide";
		}
	}

}
