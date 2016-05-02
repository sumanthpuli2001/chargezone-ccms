/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Irfan
 */
public class AadharValidator {

    private Pattern pattern;
    private Matcher matcher;
    private static final String AADHAR_NUMBER_PATTERN = "^[0-9]{12}$";

    public AadharValidator() {

        pattern = Pattern.compile(AADHAR_NUMBER_PATTERN);
        //this pattern allow exactly 12 digits only.
    }

    public boolean validate(final String aadharNo) {

        matcher = pattern.matcher(aadharNo);
        return matcher.matches();

    }
}
