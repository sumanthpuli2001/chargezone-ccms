/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.MprApproval;

import com.bul.zydex.model.MprApproval;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface MprApprovalService<T> extends GenericsService<T> {

    public List<?> readApprovalMPRList(int empId);

    public MprApproval readByMprIdAndEmpId(int mprid, int empid);

    public List<?> mPrDelete(String mprId);

}
