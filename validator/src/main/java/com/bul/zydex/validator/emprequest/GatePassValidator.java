/*
 * 
 * Author Vinita
 */
package com.bul.zydex.validator.emprequest;

import com.bul.zydex.model.GatePass;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public class GatePassValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return GatePass.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "assetDescription", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gatePassType", "field.error13", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "assetValue", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "assetIdentityNo", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destination", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "materialCarryingPersonName", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "materialCarryingPersonCntctNo", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "materialTakenToPersonName", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "materialTakenToPersonLandlineNo", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "materialTakenToPersonMobileNo", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "materialOutDateTime", "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reason", "field.error1", "None");
        GatePass gatePass = (GatePass) o;

        if (gatePass != null && gatePass.getAssetValue() == 0.0d) {
            errors.rejectValue("assetValue", "field.error4", "none");
        }
    }

}
