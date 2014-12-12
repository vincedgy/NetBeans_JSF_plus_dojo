package com.vincedgy.jsf2project.managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="projectFormBean")
@RequestScoped
public class ProjectFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String projectName;
	private String projectDescription;
	
	public ProjectFormBean() {}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	
	

}
