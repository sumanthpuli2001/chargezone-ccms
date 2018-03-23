/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CandidateF2FApproval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CandidateF2FApproval;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface CandidateF2FApprovalDAO<T> extends GenericsDAO<T> {

    public List<?> readByReqId(int id);

    public List<?> readByEmpId(int empid);

    public CandidateF2FApproval readByEmpIdAndReqId(int empid, int ReqId);

    public List<?> readEmployeeCommentByReqId(int id);

}
