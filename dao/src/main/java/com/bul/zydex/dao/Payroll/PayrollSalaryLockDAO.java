/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Payroll;

import com.bul.zydex.dao.GenericsDAO;

/**
 *
 * @author Irfan <irfanbhindawala@gmail.com>
 */
public interface PayrollSalaryLockDAO<T> extends GenericsDAO<T>{
    
    public boolean payRollAmountCheckIsExist(T object);
    
}
