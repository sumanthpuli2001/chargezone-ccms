/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Report;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface ReportService<T> extends GenericsService<T> {

    public List read(String dFrom, String eFrom, String type, String name, String cardCode, String item);

    public List readByValues(String date, String name, String code, String id, String item);

    public List readByDateDiff(String dFrom, String eFrom);

    public void delteDataByCodeDate(String code, String tdate);

}
