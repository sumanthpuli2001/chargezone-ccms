/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import org.apache.commons.validator.UrlValidator;

/**
 * 
 * @author Jayesh
 */
public class ValidateUrlExample {

	public static void doDefaultSchemes() {

		UrlValidator urlValidator = new UrlValidator();

		String url = "http://foo.bar.com/";
		if (urlValidator.isValid(url)) {
			System.out.println(url + " is valid");
		} else {
			System.out.println(url + " is invalid");
		}

		url = "ftp://foo.bar.com/";
		if (urlValidator.isValid(url)) {
			System.out.println(url + " is valid");
		} else {
			System.out.println(url + " is invalid");
		}
	}

	public static void doUserSpecifiedSchemes() {

		String[] schemes = { "http", "https" };
		UrlValidator urlValidator = new UrlValidator(schemes);

		String url = "http://foo.bar.com/";
		if (urlValidator.isValid(url)) {
			System.out.println(url + " is valid");
		} else {
			System.out.println(url + " is invalid");
		}

		url = "ftp://foo.bar.com/";
		if (urlValidator.isValid(url)) {
			System.out.println(url + " is valid");
		} else {
			System.out.println(url + " is invalid");
		}

	}

	public static void main(String[] args) {
		System.out.println("*** doUserSpecifiedSchemes ***");
		doUserSpecifiedSchemes();
		System.out.println("\n*** doDefaultSchemes ***");
		doDefaultSchemes();
	}
}