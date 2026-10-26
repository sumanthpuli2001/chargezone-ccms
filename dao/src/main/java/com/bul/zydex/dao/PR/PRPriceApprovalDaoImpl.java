/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.Tender.*;
import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRPriceApproval;
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
public class PRPriceApprovalDaoImpl<T> extends GenericsDAOImpl<T> implements PRPriceApprovalDao<T> {

    @Override
    protected Class getDomainClass() {
        return PRPriceApproval.class;
    }

    @Override
    public boolean isExist(String ref_no) {
        boolean flag = false;
        
        String query = "";
        
        query += " SELECT a FROM PRPriceApproval a"
                + " WHERE a.prNo = '" + ref_no + "' and a.approvalStatus=0 or a.approvalStatus=1 or a.approvalStatus=3 ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            flag = true;
        }
                 
        return flag ;
    }

    @Override
    public List approvaList(String username) {
        String query = "";
        query += " FROM PRPriceApproval a, PRPriceApprovalUser b WHERE  a.id  =  b.prApprovalId and b.userId = '" + username + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByIds(String id) {
       String query = "";
        query += " FROM PRPriceApproval a"
                + " WHERE a.id = '" + id + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readLog(String prNumber, String open_from_date, String open_to_date) {
         String query = "";
        
        if(open_from_date.equals(""))
        {
            query = " select a "
                + " from PRPriceApproval a "
                + " where prNo like '%"+prNumber+"%' "
                + " ";
        }
        else
        {
            query = " select a "
                + " from PRPriceApproval a "
                + " where (STR_TO_DATE(a.dateTime,'%Y-%m-%d') BETWEEN STR_TO_DATE('" + open_from_date + "', '%Y-%m-%d') and STR_TO_DATE('" + open_to_date + "', '%Y-%m-%d'))"
                + " order by a.prNo desc";
        }
        
        return getHibernateTemplate().find(query);
    }

    @Override
    public void deletePr(String refNo) {
        String query = "";
            query += " delete from PRPriceApproval a"
                + " WHERE a.prNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByprNo(String prNo) {
        String query = "";
        query += " FROM PRPriceApproval a"
                + " WHERE a.prNo = '" + prNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public PRPriceApproval readByPrNo(String prNo) {
        PRPriceApproval pRPriceApproval = new PRPriceApproval();
        String query = "";
        query += " FROM PRPriceApproval a"
                + " WHERE a.prNo = '" + prNo + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            pRPriceApproval = (PRPriceApproval) list.get(0);
        }
        return pRPriceApproval;
    }

    
}
