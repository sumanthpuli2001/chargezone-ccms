/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.RecruitmentMppApproval;

import com.bul.zydex.model.RecruitmentMppApproval;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface RecruitmentMppApprovalService<T> extends GenericsService<T> {

    public List<?> mPpReadApprovalList(int empId);

    public RecruitmentMppApproval mppreadByIdAndEmpId(int mppid, int empid);

    public List<?> recruitmentMppdelete(String employeeId);

    public List<?> readByMppId(int id);

}
