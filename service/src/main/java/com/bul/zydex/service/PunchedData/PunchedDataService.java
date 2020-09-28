/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PunchedData;

import com.bul.zydex.model.DeviceDetails;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface PunchedDataService<T> extends GenericsService<T> {

    public List readBy(String dFrom, String eFrom, String cardCode, String item);

    public List readBYId(int id);

    public void updateQuery(int id, double price);

    public void deleteBySrNo(String checkedValues);

    public List readByEmpDateItem(String code, String format, int srNo);

    public List readByMachineDetails(DeviceDetails deviceDetails, String date);

    public List readByDateAndDeviceId(String date, String deviceId, String coupounID);

    public List readSumOfAmount(String format, String item);

    public List readSumOfPrice(String reportName, String dFrom, String eFrom);

    public List readPriceSum(String rfId, String date);

    public List readEmp(String dFrom, String eFrom, String type);

    public List readDistinct(String dFrom, String eFrom, String cardCode, String item);

    public List readByValues(String format, String string, String item);

    public List readBySumValues(String sdate, String endDate, String empCd, String item);

    public List readByDateDiff(String dFrom, String eFrom);

    public void deleteBySrNo(long srNo);

}
