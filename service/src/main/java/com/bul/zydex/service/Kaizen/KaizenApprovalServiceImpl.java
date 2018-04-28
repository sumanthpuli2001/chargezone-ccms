/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Kaizen;

import com.bul.zydex.dao.Kaizen.KaizenApprovalDAO;
import com.bul.zydex.model.KaizenApproval;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Aman
 */
public class KaizenApprovalServiceImpl<T>extends GenericsServiceImpl<T> implements KaizenApprovalService<T>{
    
    private KaizenApprovalDAO<T> kaizenApprovalDAO;

    public KaizenApprovalDAO<T> getKaizenApprovalDAO() {
        return kaizenApprovalDAO;
    }

    public void setKaizenApprovalDAO(KaizenApprovalDAO<T> kaizenApprovalDAO) {
        this.kaizenApprovalDAO = kaizenApprovalDAO;
        setGenericsDAO(kaizenApprovalDAO);
    }

    @Override
    public KaizenApproval readByIdAndEmp(int id, int empId) {
        return kaizenApprovalDAO.readByIdAndEmp(id,empId);
    }
    
    
}
