/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Payroll;

import com.bul.zydex.dao.Payroll.PayrollFormSixteenMasterDAO;
import com.bul.zydex.model.PayrollFormSixteenMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public class PayrollFormSixteenMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PayrollFormSixteenMasterService<T>{
 private PayrollFormSixteenMasterDAO<T>  payrollFormSixteenMasterDAO;
 
    public PayrollFormSixteenMasterDAO<T> getPayrollFormSixteenMasterDAO() {
        return payrollFormSixteenMasterDAO;
    }

    public void setPayrollFormSixteenMasterDAO(PayrollFormSixteenMasterDAO<T> payrollFormSixteenMasterDAO) {
        this.payrollFormSixteenMasterDAO = payrollFormSixteenMasterDAO;
         setGenericsDAO(payrollFormSixteenMasterDAO);
    }

    @Override
    public List<?> payRollSearchIdCheck(T object) {
       return payrollFormSixteenMasterDAO.payRollSearchIdCheck(object);
    }

    @Override
    public List<?> read(PayrollFormSixteenMaster payrollFormSixteenMaster) {
        return payrollFormSixteenMasterDAO.read(payrollFormSixteenMaster);
    }

   

    
     
      
      
      
      
}
