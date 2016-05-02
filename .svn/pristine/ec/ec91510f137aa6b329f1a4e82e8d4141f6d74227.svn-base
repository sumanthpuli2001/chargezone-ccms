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
public class IFSCValidator {

    private Pattern pattern;
    private Matcher matcher;
    private static final String IFSC_PATTERN = "^[A-Z|a-z]{4}[0][A-Z|a-z|\\d]{6}$";

    public IFSCValidator() {
        pattern = Pattern.compile(IFSC_PATTERN);
    }

    public boolean isValidIFSC(final String ifsc) {

        matcher = pattern.matcher(ifsc);
        return matcher.matches();
    }
}
