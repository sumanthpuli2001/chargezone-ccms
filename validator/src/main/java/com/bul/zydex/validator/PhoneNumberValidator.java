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
 * @author Administrator
 */
public class PhoneNumberValidator {

    private Pattern pattern;
    private Matcher matcher;
    private static final String DATE_PATTERN = "/^\\(?([0-9]{3})\\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/";

    public PhoneNumberValidator() {
        pattern = Pattern.compile(DATE_PATTERN);
    }

    public boolean validate(final String number) {
        matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
