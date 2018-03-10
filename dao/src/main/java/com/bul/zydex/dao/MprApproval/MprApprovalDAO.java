/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.MprApproval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.MprApproval;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface MprApprovalDAO<T> extends GenericsDAO<T> {

    public List<?> readApprovalMPRList(int empId);

    public MprApproval readByMprIdAndEmpId(int mprid, int empid);
    
    public List<?> mPrDelete(String mprId);
    
}
