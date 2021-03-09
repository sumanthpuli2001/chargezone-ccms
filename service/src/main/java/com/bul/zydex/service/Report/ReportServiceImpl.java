/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Report;

import com.bul.zydex.dao.Report.ReportDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class ReportServiceImpl<T> extends GenericsServiceImpl<T> implements ReportService<T> {

    private ReportDao<T> reportDao;

    public ReportDao<T> getReportDao() {
        return reportDao;
    }

    public void setReportDao(ReportDao<T> reportDao) {
        this.reportDao = reportDao;
        setGenericsDAO(reportDao);
    }

    @Override
    public List read(String dFrom, String eFrom, String type, String name, String cardCode, String item) {
        return reportDao.read(dFrom, eFrom, type, name, cardCode, item);
    }

    @Override
    public List readByValues(String date, String name, String code, String id, String item) {
        return reportDao.readByValues(date, name, code, id, item);
    }

    @Override
    public List readByDateDiff(String dFrom, String eFrom) {
        return reportDao.readByDateDiff(dFrom, eFrom);
    }

    @Override
    public void delteDataByCodeDate(String code, String tdate) {
        reportDao.delteDataByCodeDate(code, tdate);
    }

    @Override
    public List readByEmp(String dFrom, String eFrom, String type, String cardCode, String item, String empcode) {
        return reportDao.readByEmp(dFrom, eFrom, type, cardCode, item, empcode);
    }

    @Override
    public List readReport(String code, String date, String time, String item) {

        return reportDao.readReport(code, date, time, item);
    }

    
    
     @Override
     public void delteDataByDate(String dFrom, String eFrom) {
      reportDao.delteDataByDate(dFrom, eFrom);
    }
}
