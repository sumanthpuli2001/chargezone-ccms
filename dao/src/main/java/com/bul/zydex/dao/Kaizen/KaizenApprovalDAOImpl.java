/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Kaizen;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.KaizenApproval;
import java.util.List;

/**
 *
 * @author Aman
 */
public class KaizenApprovalDAOImpl<T>  extends GenericsDAOImpl<T> implements KaizenApprovalDAO<T>{

    @Override
    protected Class getDomainClass() {
        return KaizenApproval.class;
    }

    @Override
    public KaizenApproval readByIdAndEmp(int id, int empId) {
        KaizenApproval kaizenApproval = new KaizenApproval();
        String query = "SELECT a"
                + " FROM KaizenApproval a "
                + " WHERE a.kaizenMaster.id = " + id
                + " and a.employeeMaster.id = " + empId;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            kaizenApproval = (KaizenApproval) list.get(0);
        } else {
            kaizenApproval = null;
        }
        return kaizenApproval;
        
        
    }
    
}
