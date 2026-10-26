/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRPriceApprovalUser;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.model.TenderPriceApprovalUser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class PRPriceApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements PRPriceApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
        return PRPriceApprovalUser.class;
    }

    @Override
    public PRPriceApprovalUser approvaList1(String username, String pr_no) {
        String query = "";
        PRPriceApprovalUser prPriceApprovalUser = new PRPriceApprovalUser();

        query += "SELECT b FROM PRPriceApproval a, PRPriceApprovalUser b WHERE a.prNo='" + pr_no + "' and a.id  =  b.prApprovalId and b.userId = '" + username + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            prPriceApprovalUser = (PRPriceApprovalUser) list.get(0);
        }
        return prPriceApprovalUser;
    }

    @Override
    public List readByRefNo(int approveId) {
        String query = "";
        query += " SELECT a FROM PRPriceApprovalUser a"
                + " WHERE a.prApprovalId = '" + approveId + "'";

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public void deletePr(String refNo) {
        String query = "";
        query += " delete from PRPriceApprovalUser a"
                + " WHERE a.prNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByPRNumber(String prNumber) {
        String query = "";
        query += " SELECT a FROM PRPriceApprovalUser a"
                + " WHERE a.prNo = '" + prNumber + "'";

        List list = getHibernateTemplate().find(query);
        return list;
    }

}
