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
         String query = " SELECT b "
                + " FROM CandidateF2FApproval a "
                + " Left join a.candidateF2FRequest b "
                + " WHERE a.employeeMaster.id =" + empid;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
