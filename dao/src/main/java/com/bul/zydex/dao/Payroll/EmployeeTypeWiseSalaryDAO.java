/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public interface EmployeeTypeWiseSalaryDAO<T> extends GenericsDAO<T> {

    public List<?> readForAdditionalAmount(int empTypeId, int empSubTypeId);

    public List<?> readForMasterAdditionalAmount(int empTypeId, int empSubTypeId, int payrollSalaryId);

}
