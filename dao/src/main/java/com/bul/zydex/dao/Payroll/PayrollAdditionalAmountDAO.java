/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.EmployeeSalaryProcess;
import java.util.List;

/**
 *
 * @author AJAY <ajay@bulwarks.com>
 */
public interface PayrollAdditionalAmountDAO<T> extends GenericsDAO<T> {

        public List<?> readdaywise(int empId,String Date );
        public List<?> readDayWiseAdditionalAmount(EmployeeSalaryProcess employeeSalaryProcess);
}
