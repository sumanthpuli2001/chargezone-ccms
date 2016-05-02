/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.expenseTravelType;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author dhruv
 */
public interface ExpenseTravelTypeService<T> extends GenericsService<T> {

    public List<?> readByExpenseMasterId(int id);

    public List<?> readByExpenseMasterApproveList(int id);
}
