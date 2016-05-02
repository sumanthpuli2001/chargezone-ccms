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
public class NumberValidator {

    private Pattern pattern;
    private Matcher matcher;
    static String regexDecimal = "^-?\\d*\\.\\d+$";
    static String regexInteger = "^-?\\d+$";
    private static final String NUM_PATTERN = regexDecimal + "|" + regexInteger;

    public NumberValidator() {
        pattern = Pattern.compile(NUM_PATTERN);
    }

    public boolean validate(final String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
