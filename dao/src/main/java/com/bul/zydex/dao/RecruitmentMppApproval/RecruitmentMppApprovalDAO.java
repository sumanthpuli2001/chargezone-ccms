/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RecruitmentMppApproval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.RecruitmentMppApproval;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface RecruitmentMppApprovalDAO<T> extends GenericsDAO<T> {

    public List<?> mPpReadApprovalList(int empId);

    public RecruitmentMppApproval mppreadByIdAndEmpId(int mppid, int empid);
    
    public List<?> recruitmentMppdelete(String employeeId);

}
