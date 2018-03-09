/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.RecruitmentMppApproval;

import com.bul.zydex.dao.RecruitmentMppApproval.RecruitmentMppApprovalDAO;
import com.bul.zydex.model.RecruitmentMppApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class RecruitmentMppApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements RecruitmentMppApprovalService<T> {

    private RecruitmentMppApprovalDAO<T> recruitmentMppApprovalDAO;

    public RecruitmentMppApprovalDAO<T> getRecruitmentMppApprovalDAO() {
        return recruitmentMppApprovalDAO;
    }

    public void setRecruitmentMppApprovalDAO(RecruitmentMppApprovalDAO<T> recruitmentMppApprovalDAO) {
        this.recruitmentMppApprovalDAO = recruitmentMppApprovalDAO;
        setGenericsDAO(recruitmentMppApprovalDAO);
    }

    @Override
    public List<?> mPpReadApprovalList(int empId) {
        return recruitmentMppApprovalDAO.mPpReadApprovalList(empId);
    }

    @Override
    public RecruitmentMppApproval mppreadByIdAndEmpId(int mppid, int empid) {
        return recruitmentMppApprovalDAO.mppreadByIdAndEmpId(mppid, empid);
    }

    @Override
    public List<?> recruitmentMppdelete(String employeeId) {
        return recruitmentMppApprovalDAO.recruitmentMppdelete(employeeId);
    }

}
