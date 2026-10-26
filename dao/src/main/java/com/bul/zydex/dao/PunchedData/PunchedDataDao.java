/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PunchedData;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.DeviceDetails;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface PunchedDataDao<T> extends GenericsDAO<T> {

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

    public List readDistinct(String dFrom, String eFrom, String cardCode, String item, String type1);

    public List readByValues(String format, String string, String item);

    public List readBySumValues(String sdate, String endDate, String empCd, String item);

    public List readByDateDiff(String dFrom, String eFrom);

    public void deleteBySrNo(long srNo);
       public List readDistinctforemp(String dFrom, String eFrom, String cardCode, String item,String emp);
       public List readByid(long id) ;
        public void deleteByDate(String dFrom, String eFrom);

}
