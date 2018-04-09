package com.bul.zydex.validator.Payroll;

import com.bul.zydex.model.PayrollTaxDeductionComponent;
import com.bul.zydex.model.PayrollTaxDeductionMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PayrollTaxDeductionMasterValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return PayrollTaxDeductionMaster.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PayrollTaxDeductionMaster payrollTaxDeductionMaster = (PayrollTaxDeductionMaster) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "section",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taxSavingLimit",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",
                "field.error1", "None");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "additionalTaxBenefit",
                "field.error1", "None");
        
    }

}