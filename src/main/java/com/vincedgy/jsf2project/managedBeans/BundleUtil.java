package com.vincedgy.jsf2project.managedBeans;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public final class BundleUtil {
	public static String getResourceBundleString(String resourceBundleName,
			String resourceBundleKey) throws MissingResourceException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		String messageBundleName = facesContext.getApplication().getMessageBundle();
		Locale locale = facesContext.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
		return bundle.getString(resourceBundleKey);
	}
}
