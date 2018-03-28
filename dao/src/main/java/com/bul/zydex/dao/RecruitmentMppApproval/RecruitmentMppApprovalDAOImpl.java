/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.RecruitmentMppApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.RecruitmentMppApproval;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class RecruitmentMppApprovalDAOImpl<T> extends GenericsDAOImpl<T> implements RecruitmentMppApprovalDAO<T> {

    @Override
    protected Class getDomainClass() {
        return RecruitmentMppApproval.class;
    }

    @Override
    public List<?> mPpReadApprovalList(int empId) {
        String query = "";
        query += " "
                + " SELECT rm.id, rm.numberOfPosition, rm.budget, rm.experiance, rm.mppStatus, rm.currentLevel, "
                + " rma.level, b.location, c.departmentName, d.jobTypeName, rm.createdDate "
                + " FROM RecruitmentMppApproval rma "
                + " Left Join rma.recruitmentMaster rm "
                + " LEFT JOIN rm.locationMaster b "
                + " LEFT JOIN rm.departmentMaster c "
                + " LEFT JOIN rm.jobtypeMaster d "
                + " Where  rm.currentLevel >= rma.level "
                + " And rma.employeeMaster.id = " + empId
                + " order by rm.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    public RecruitmentMppApproval mppreadByIdAndEmpId(int mppid, int empid) {
        RecruitmentMppApproval recruitmentMppApproval = new RecruitmentMppApproval();
        String query = "SELECT a"
                + " FROM RecruitmentMppApproval a "
                + " WHERE a.recruitmentMaster.id = " + mppid
                + " and a.employeeMaster.id = " + empid;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            recruitmentMppApproval = (RecruitmentMppApproval) list.get(0);
        } else {
            recruitmentMppApproval = null;
        }
        return recruitmentMppApproval;
    }

    @Override
    public List<?> recruitmentMppdelete(String employeeId) {
        String query = "";

        query += "  "
                + " select a"
                + " FROM RecruitmentMppApproval a "
                + " WHERE a.recruitmentMaster.id = " + employeeId;
//        return getHibernateTemplate().find(query);
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> readByMppId(int id) {
        String query = "";
        query += " "
                + " SELECT a.id, a.comment, b.employeeName "
                + " FROM RecruitmentMppApproval a "
                + " Left Join a.employeeMaster b "
                + " WHERE a.recruitmentMaster = " + id;
        List<?> list = getHibernateTemplate().find(query);
        return list;
    }
}
