/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.model.TenderPriceApprovalUser;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.TechnicalTenderPriceApprovalUser;
import com.bul.zydex.model.UserMaster;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class TechnicalTenderPriceApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements TechnicalTenderPriceApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
        return TechnicalTenderPriceApprovalUser.class;
    }

    @Override
    public List readByRefNo(int approveId) {
         String query = "";
        query += " SELECT a.tenderNo, a.userId, a.level, a.approvalStatus, b.name FROM TechnicalTenderPriceApprovalUser a, EmployeeMaster b"
                + " WHERE a.tenderApprovalId = '" + approveId + "' and a.userId = b.employeeCode";

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public TechnicalTenderPriceApprovalUser approvaList2(int id) {
        String query = "";
        TechnicalTenderPriceApprovalUser technicalTenderPriceApprovalUser = new TechnicalTenderPriceApprovalUser();

        query += "SELECT b FROM TechnicalTenderPriceApproval a, TechnicalTenderPriceApprovalUser b WHERE  a.id  =  b.tenderApprovalId and b.tenderApprovalId = '" + id + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            technicalTenderPriceApprovalUser = (TechnicalTenderPriceApprovalUser) list.get(0);
        }
        return technicalTenderPriceApprovalUser;
    }

    @Override
    public TechnicalTenderPriceApprovalUser readByLevel(String tender_no, int level) {
         String query = "";
         TechnicalTenderPriceApprovalUser technicalTenderPriceApprovalUser = new TechnicalTenderPriceApprovalUser();

        query += " FROM TechnicalTenderPriceApprovalUser a WHERE  a.tenderNo = '" + tender_no + "'" + " and a.level = "+level+" ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
           technicalTenderPriceApprovalUser = (TechnicalTenderPriceApprovalUser) list.get(0);
        }
        return technicalTenderPriceApprovalUser;
    }

   

}
