package com.jsfdemo.app.validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.io.Serializable;

/**
 * Custom JSF validator that checks if a US zip code is valid.
 * Accepts formats: 12345 or 12345-6789
 *
 * Usage in xhtml:
 *   <f:validator validatorId="zipCodeValidator"/>
 */
@FacesValidator("zipCodeValidator")
public class ZipCodeValidator implements Validator<String>, Serializable {

    private static final String ZIP_PATTERN = "^\\d{5}(-\\d{4})?$";

    @Override
    public void validate(FacesContext context, UIComponent component, String value) throws ValidatorException {
        if (value == null || value.isBlank()) {
            return; // let required="true" handle empty values
        }

        if (!value.matches(ZIP_PATTERN)) {
            throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Invalid Zip Code",
                            "Zip code must be in format 12345 or 12345-6789"));
        }
    }
}

