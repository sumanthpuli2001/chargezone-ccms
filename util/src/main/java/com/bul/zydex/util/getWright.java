/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Aman Bahukhandi
 */
public class getWright {

    String str;

    public String gtWright(int i, String s) {
        int count = 0;

        if (s != null) {
            ArrayList arr = new ArrayList();
            StringTokenizer st = new StringTokenizer(s, "  ");
            while (st.hasMoreTokens()) {
                arr.add(count, st.nextToken());
                count++;
            }
            String a = (String) arr.get(i);
            return (a);
        }
        return ("No");
    }
}
