/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface RecruitmentService<T> extends GenericsService<T> {

    public List<?> readBudgetDetail();

    public List<?> readForBudgetDetail();

    public List<?> searchMppApproval(int empId);

    public List<?> readMppListByUserId(int empId);

    public List<?> fetchAllMpp();

}
