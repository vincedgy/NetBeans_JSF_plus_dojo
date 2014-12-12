package com.vincedgy.jsf2project.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.vincedgy.jsf2project.managedBeans.BundleUtil;

@FacesValidator("ValidatePassword")
public class ValidatePassword implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		String password = (String) value;

		if (password.length() < 4 || password.length() > 10) {
			FacesMessage msg = new FacesMessage("Password validator.",
					BundleUtil.getResourceBundleString("messages","login.form.password.error"));
			context.addMessage("password", msg);
			msg.setSeverity(FacesMessage.SEVERITY_WARN);
			throw new ValidatorException(msg);
		}
	}
}