/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.MprApproval;

import com.bul.zydex.dao.MprApproval.MprApprovalDAO;
import com.bul.zydex.model.MprApproval;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class MprApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements MprApprovalService<T> {

    private MprApprovalDAO<T> mprApprovalDAO;

    public MprApprovalDAO<T> getMprApprovalDAO() {
        return mprApprovalDAO;
    }

    public void setMprApprovalDAO(MprApprovalDAO<T> mprApprovalDAO) {
        this.mprApprovalDAO = mprApprovalDAO;
        setGenericsDAO(mprApprovalDAO);
    }

    @Override
    public List<?> readApprovalMPRList(int empId) {
        return mprApprovalDAO.readApprovalMPRList(empId);
    }

    @Override
    public MprApproval readByMprIdAndEmpId(int mprid, int empid) {
        return mprApprovalDAO.readByMprIdAndEmpId(mprid, empid);
    }

    @Override
    public List<?> mPrDelete(String mprId) {
        return mprApprovalDAO.mPrDelete(mprId);
    }

}
