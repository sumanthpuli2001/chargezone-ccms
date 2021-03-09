/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RechargeInfo;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface RechargeInfoDao<T> extends GenericsDAO<T> {

    public List readMaxId(String rfId);

    public List readRAmount(String rfId);

    public List readDistinctEmp();

    public List readEmpLatestRecharge(String rfId);

    public List readByRfidAndDate(String format, String rfId);
   
    public List countAmount(String rfId) ;


}
