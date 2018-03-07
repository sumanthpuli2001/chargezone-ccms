/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface RecruitmentDAO<T> extends GenericsDAO<T> {

    public List<?> readBudgetDetail();

    public List<?> readForBudgetDetail();
    
    public List<?> searchMppApproval();

}
