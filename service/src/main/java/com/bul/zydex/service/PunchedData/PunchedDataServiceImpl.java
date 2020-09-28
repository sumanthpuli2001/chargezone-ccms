/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PunchedData;

import com.bul.zydex.dao.PunchedData.PunchedDataDao;
import com.bul.zydex.model.DeviceDetails;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class PunchedDataServiceImpl<T> extends GenericsServiceImpl<T> implements PunchedDataService<T> {

    private PunchedDataDao<T> punchedDataDao;

    public PunchedDataDao<T> getPunchedDataDao() {
        return punchedDataDao;
    }

    public void setPunchedDataDao(PunchedDataDao<T> punchedDataDao) {
        this.punchedDataDao = punchedDataDao;
        setGenericsDAO(punchedDataDao);
    }

    @Override
    public List readBy(String dFrom, String eFrom, String cardCode, String item) {
        return punchedDataDao.readBy(dFrom, eFrom, cardCode, item);
    }

    @Override
    public List readBYId(int id) {
        return punchedDataDao.readBYId(id);
    }

    @Override
    public void updateQuery(int id, double price) {
        punchedDataDao.updateQuery(id, price);
    }

    @Override
    public void deleteBySrNo(String checkedValues) {
        punchedDataDao.deleteBySrNo(checkedValues);
    }

    @Override
    public List readByEmpDateItem(String code, String format, int srNo) {
        return punchedDataDao.readByEmpDateItem(code, format, srNo);
    }

    @Override
    public List readByMachineDetails(DeviceDetails deviceDetails, String date) {
        return punchedDataDao.readByMachineDetails(deviceDetails, date);
    }

    @Override
    public List readByDateAndDeviceId(String date, String deviceId, String copounID) {
        return punchedDataDao.readByDateAndDeviceId(date, deviceId, copounID);
    }

    @Override
    public List readSumOfAmount(String format, String item) {
        return punchedDataDao.readSumOfAmount(format, item);
    }

    @Override
    public List readSumOfPrice(String reportName, String dFrom, String eFrom) {
        return punchedDataDao.readSumOfPrice(reportName, dFrom, eFrom);
    }

    @Override
    public List readPriceSum(String rfId, String date) {
        return punchedDataDao.readPriceSum(rfId, date);

    }

    @Override
    public List readEmp(String dFrom, String eFrom, String type) {
        return punchedDataDao.readEmp(dFrom, eFrom, type);
    }

    @Override
    public List readDistinct(String dFrom, String eFrom, String cardCode, String item) {
        return punchedDataDao.readDistinct(dFrom, eFrom, cardCode, item);
    }

    @Override
    public List readByValues(String format, String string, String item) {
        return punchedDataDao.readByValues(format, string, item);
    }

    @Override
    public List readBySumValues(String sdate, String endDate, String empCd, String item) {
        return punchedDataDao.readBySumValues(sdate, endDate, empCd, item);
    }

    @Override
    public List readByDateDiff(String dFrom, String eFrom) {
        return punchedDataDao.readByDateDiff(dFrom, eFrom);
    }

    @Override
    public void deleteBySrNo(long srNo) {
        punchedDataDao.deleteBySrNo(srNo);
    }

}
