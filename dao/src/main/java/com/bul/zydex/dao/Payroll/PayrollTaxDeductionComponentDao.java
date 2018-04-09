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
 * @author DELL3
 */
public interface PayrollTaxDeductionComponentDao<T> extends GenericsDAO<T> {
    
//    public List<?> readTaxDeductionComponent();
    
    public List<?> readByComponentId(int id);

    public List readSection();
    
    
}
