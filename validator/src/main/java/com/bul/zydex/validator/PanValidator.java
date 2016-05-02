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
public class PanValidator {

    private Pattern pattern;
    private Matcher matcher;
    private static final String PAN_PATTERN = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

	// [A-Z]{5} - match five literals which can be A to Z
    // [0-9]{4} - followed by 4 numbers 0 to 9
    // [A-Z]{1} - followed by one literal which can A to Z
    public PanValidator() {
        pattern = Pattern.compile(PAN_PATTERN);
    }

    /**
     * Validate password with regular expression
     *
     * @param password password for validation
     * @return true valid password, false invalid password
     */
    public boolean validate(final String pan) {

        matcher = pattern.matcher(pan);
        return matcher.matches();

    }
}
