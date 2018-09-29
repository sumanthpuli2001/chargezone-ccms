/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandidateF2FRequest;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CandidateF2FRequest;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class CandidateF2FRequestDAOImpl<T> extends GenericsDAOImpl<T> implements CandidateF2FRequestDAO<T> {

    @Override
    protected Class getDomainClass() {
        return CandidateF2FRequest.class;
    }

    @Override
    public List<?> interviewReqDetailread(int empId) {

        String query = " SELECT a.id,b.name as condidateName,c.name as vacancyName,a.dateOfInterview,"
                + " a.status,(select cfa.id  from CandidateF2FApproval cfa where a.id=cfa.candidateF2FRequest.id and cfa.employeeMaster.id=" + empId + ") as flag ,b.id ,a.candidateJobApplication.id,cfq.employeeMaster.id,cfq.status"
                + " FROM CandidateF2FRequest a ,CandidateF2FApproval cfq"
                + " LEFT JOIN a.candidateApplyJob b "
                + " LEFT JOIN a.vacancyMaster c "
                //                + " LEFT JOIN a.candidateF2FApproval d "
                + " where a.id=cfq.candidateF2FRequest.id and cfq.employeeMaster.id=" + empId + ""
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public CandidateF2FRequest readById(int id) {
        CandidateF2FRequest cffr = new CandidateF2FRequest();
        String query = " SELECT a "
                + " FROM CandidateF2FRequest a "
                + " Where a.id =" + id;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            cffr = (CandidateF2FRequest) list.get(0);
        } else {
            cffr = null;
        }

        return cffr;
    }

    @Override
    public List<?> interviewReqDetailreadHR(int empId) {
        String query = " SELECT a.id,b.name as condidateName,c.name as vacancyName,a.dateOfInterview,"
                + " a.status,(select cfa.id  from CandidateF2FApproval cfa where a.id=cfa.candidateF2FRequest.id and cfa.employeeMaster.id=" + empId + ") as flag ,b.id ,a.candidateJobApplication.id,e.status"
                + " FROM CandidateF2FRequest a "
                + " LEFT JOIN a.candidateApplyJob b "
                + " LEFT JOIN a.vacancyMaster c "
                + " LEFT JOIN a.candidateJobApplication e "
                //                + " LEFT JOIN a.candidateF2FApproval d "
                //                + " where a.id=cfq.candidateF2FRequest.id and cfq.employeeMaster.id=" + empId + ""
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
