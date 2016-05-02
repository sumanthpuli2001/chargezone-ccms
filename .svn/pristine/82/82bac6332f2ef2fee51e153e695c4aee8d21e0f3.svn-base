/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import webservicexclient.Webservicexclient;
/**
 *
 * @author Jayesh
 */
public class CheckString {

	public static void main(String[] args) {
		CheckString cs = new CheckString();
		System.out.println("strNum() = " + cs.strNum("1111", true));
		System.out.println("strAlpha() = " + cs.strAlpha(" aA", false));
		System.out.println("strAlphaNum() = " + cs.strAlphaNum(" a1A", true));
		System.out.println("strAllowSpc() = "
				+ cs.strAllowSpc("!@#$%^&*%^&*%^&* ", "!@#$%^&*", true));
		System.out.println("strNotAllowSpc() = "
				+ cs.strNotAllowSpc("!@#$%^& ", "*", false));

		List<String> aList = new ArrayList<String>();

		for (Iterator<String> itr = aList.iterator(); itr.hasNext();) {
			String element = itr.next();
			if ("2".equals(element)) {
				itr.remove();
			}
		}
		System.out.println(aList);

		//
		// Webservicexclient webServicexclient = new Webservicexclient();
		// System.out.println("Currency output is : " +
		// webServicexclient.converter(100, webservicexnet.Currency.INR,
		// webservicexnet.Currency.USD));

	}

	String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String alphaSmall = "abcdefghijklmnopqrstuvwxyz";
	String alphaBig = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String num = "1234567890";
	String doubleDot = ".";

	public boolean isURL(String url) {
		if (null == url || url.isEmpty()) {
			return false;
		}
		// Assigning the url format regular expression
		String urlPattern = "^http(s{0,1})://[a-zA-Z0-9_/\\-\\.]+\\.([A-Za-z/]{2,5})[a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%]*";
		return url.matches(urlPattern);
	}

	public boolean strAllowSpc(String dataValue, String strSpc,
			boolean whitespace) {
		String strTemp = "";
		if (null == dataValue || dataValue.isEmpty()) {
			return false;
		}
		for (int i = 0; i < dataValue.length(); i++) {
			strTemp = "" + dataValue.charAt(i);
			if (!(strSpc.contains(strTemp) || alpha.contains(strTemp)
					|| num.contains(strTemp) || (whitespace && " "
					.contains(strTemp)))) {
				return false;
			}
		}
		return true;
	}

	public boolean allowAll(String dataValue, boolean whitespace) {
		return true;
	}

	public boolean strAlpha(String dataValue, boolean whitespace) {
		String strTemp = "";
		if (null == dataValue || dataValue.isEmpty()) {
			return false;
		}
		for (int i = 0; i < dataValue.length(); i++) {
			strTemp = "" + dataValue.charAt(i);
			if (!(alpha.contains(strTemp) || (whitespace && " "
					.contains(strTemp)))) {
				return false;
			}
		}
		return true;
	}

	public boolean strAlphaNum(String dataValue, boolean whitespace) {
		String strTemp = "";
		if (null == dataValue || dataValue.isEmpty()) {
			return false;
		}
		for (int i = 0; i < dataValue.length(); i++) {
			strTemp = "" + dataValue.charAt(i);
			if (!(alpha.contains(strTemp) || num.contains(strTemp) || (whitespace && " "
					.contains(strTemp)))) {
				return false;
			}
		}
		return true;
	}

	public boolean strContactNum(String dataValue, String strSpc,
			boolean whitespace) {
		String strTemp = "";
		if (null == dataValue || dataValue.isEmpty()) {
			return false;
		}
		for (int i = 0; i < dataValue.length(); i++) {
			strTemp = "" + dataValue.charAt(i);
			if (!((strSpc.contains(strTemp)) || (num.contains(strTemp) || (whitespace && " "
					.contains(strTemp))))) {
				return false;
			}
		}
		return true;
	}

	public boolean strDouble(String dataValue) {
		String strTemp = "";
		if (null == dataValue || dataValue.isEmpty()) {
			return false;
		}
		for (int i = 0; i < dataValue.length(); i++) {
			strTemp = "" + dataValue.charAt(i);
			if (!(num.contains(strTemp)) && !(doubleDot.contains(strTemp))) {
				return false;
			}
		}
		return true;
	}

	public boolean strLen(String dataValue, long min, long max) {
		boolean flag = true;
		if ((null == dataValue)
				|| (dataValue.length() > max || dataValue.length() < min)) {
			flag = false;
		}
		return flag;
	}

	public boolean strNotAllowSpc(String dataValue, String strSpc,
			boolean whitespace) {
		String strTemp = "";
		if (null == dataValue || dataValue.isEmpty()) {
			return false;
		}
		for (int i = 0; i < dataValue.length(); i++) {
			strTemp = "" + dataValue.charAt(i);
			if (!((!strSpc.contains(strTemp)) || alpha.contains(strTemp)
					|| num.contains(strTemp) || (whitespace && " "
					.contains(strTemp)))) {
				return false;
			}
		}
		return true;
	}

	public boolean strNum(String dataValue, boolean whitespace) {
		String strTemp = "";
		if (null == dataValue || dataValue.isEmpty()) {
			return false;
		}
		for (int i = 0; i < dataValue.length(); i++) {
			strTemp = "" + dataValue.charAt(i);
			if (!(num.contains(strTemp) || (whitespace && " ".contains(strTemp)))) {
				return false;
			}
		}
		return true;
	}
}
