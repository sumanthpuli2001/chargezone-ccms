/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.expense;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface ExpenseReconsilationService<T> extends GenericsService<T> {

    public List<?> readExpenseReconsilationByExpenseID(int expenseId);

    public List<?> readExpenseReconsilationFoApprover(int expenseId);

}
