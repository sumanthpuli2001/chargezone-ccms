/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.OapForm;

import java.util.Comparator;
import com.bul.zydex.model.OapForm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OapFormComparator implements Comparator<OapForm> {
 @Override
    public int compare(OapForm o1, OapForm o2) {
        int docCompare = o2.getDocumentNo().compareTo(o1.getDocumentNo());

        if (docCompare != 0) return docCompare;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date d1 = sdf.parse(o1.getDate());
            Date d2 = sdf.parse(o2.getDate());
            return d2.compareTo(d1);
        } catch (Exception e) {
            return 0;
        }
    }
}



