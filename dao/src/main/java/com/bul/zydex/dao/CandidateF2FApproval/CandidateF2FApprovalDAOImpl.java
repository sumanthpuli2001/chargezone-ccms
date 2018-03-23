/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandidateF2FApproval;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateF2FApproval;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class CandidateF2FApprovalDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateF2FApprovalDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateF2FApproval.class;

    }

    @Override
    public List<?> readByReqId(int id) {
        String query = " SELECT a"
                + " FROM CandidateF2FApproval a "
                + " WHERE a.candidateF2FRequest.id =" + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> readByEmpId(int empid) {

        String query = " SELECT b.id,c.name as condidateName,d.name as vacancyName,b.dateOfInterview,"
                + " b.status "
                + " FROM CandidateF2FApproval a "
                + " Left join a.candidateF2FRequest b "
                + " LEFT JOIN b.candidateApplyJob c "
                + " LEFT JOIN b.vacancyMaster d"
                + " WHERE a.employeeMaster.id =" + empid;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public CandidateF2FApproval readByEmpIdAndReqId(int empid, int ReqId) {
        CandidateF2FApproval candidateF2FApproval = new CandidateF2FApproval();
        String query = " SELECT a"
                + " FROM CandidateF2FApproval a "
                + " WHERE a.candidateF2FRequest.id =" + ReqId
                + " AND a.employeeMaster.id =" + empid;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            candidateF2FApproval = (CandidateF2FApproval) list.get(0);
        } else {
            candidateF2FApproval = null;
        }
        return candidateF2FApproval;
    }

}
