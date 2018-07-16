/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Kaizen;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.KaizenApprovalHistory;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class KaizenApprovalHistoryDAOImpl<T> extends GenericsDAOImpl<T> implements KaizenApprovalHistoryDAO<T> {

    @Override
    protected Class getDomainClass() {
        return KaizenApprovalHistory.class;
    }

    @Override
    public List<?> readByKaizenId(int id) {
        String query = "";
        query += " Select a.id,a.comment,a.status,a.statusMessage,a.createdDate,a.createdBy"
                + " FROM KaizenApprovalHistory a "
                + " WHERE a.kaizenMaster=" + id;

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
