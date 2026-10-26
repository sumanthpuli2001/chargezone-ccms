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
public class TenderPriceApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements TenderPriceApprovalUserDao<T> {

    @Override
    protected Class getDomainClass() {
        return TenderPriceApprovalUser.class;
    }

    @Override
    public TenderPriceApprovalUser approvaList1(String username) {
        String query = "";
        TenderPriceApprovalUser tenderPriceApprovalUser = new TenderPriceApprovalUser();

        query += "SELECT b FROM TenderPriceApproval a, TenderPriceApprovalUser b WHERE  a.id  =  b.tenderApprovalId and b.userId = '" + username + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderPriceApprovalUser = (TenderPriceApprovalUser) list.get(0);
        }
        return tenderPriceApprovalUser;
    }

    @Override
    public List readByRefNo(int approveId) {

        String query = "";
        query += " SELECT a.tenderNo, a.userId, a.level, a.approvalStatus, b.name FROM TenderPriceApprovalUser a, EmployeeMaster b"
                + " WHERE a.tenderApprovalId = '" + approveId + "' and a.userId = b.employeeCode";

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List approvedTenderList(String username) {
        
        

       String query =" ";
        query += " SELECT a.id, b.tenderNo, b.approvalStatus, a.title, a.announceDate, a.submitLastdate, a.projectId FROM TenderMaster a,TenderPriceApproval b"
                + " WHERE a.refNo = b.tenderNo and a.tenderAdmin='"+username+"' and a.closeFlag=0"
                + " and b.approvalStatus=1";

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List holdTenderList(String username) {
        String query =" ";
        query += " SELECT a.id, b.tenderNo, b.approvalStatus, a.title, a.announceDate, a.submitLastdate FROM TenderMaster a,TenderPriceApproval b"
                + " WHERE a.refNo = b.tenderNo and a.tenderAdmin='"+username+"' and a.deleteFlag=0 and a.closeFlag=2"
                + " and b.approvalStatus=1";

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public TenderPriceApprovalUser readByLevel(String tender_no, int level) {
        String query = "";
        TenderPriceApprovalUser tenderPriceApprovalUser = new TenderPriceApprovalUser();

        query += " FROM TenderPriceApprovalUser a WHERE  a.tenderNo = '" + tender_no + "'" + " and a.level = "+level+" ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderPriceApprovalUser = (TenderPriceApprovalUser) list.get(0);
        }
        return tenderPriceApprovalUser;
    }

    @Override
    public List auditorReworkTenderList(String username) {
        String query =" ";
        query += " SELECT a.id, b.tenderNo, b.approvalStatus, a.title, a.announceDate, a.submitLastdate FROM TenderMaster a,TenderPriceApproval b"
                + " WHERE a.refNo = b.tenderNo and a.tenderAdmin='"+username+"' and a.closeFlag=0"
                + " and b.approvalStatus=1 and a.auditFlag=2";

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public TenderPriceApprovalUser approvaList2(int parseInt) {
        String query = "";
        TenderPriceApprovalUser tenderPriceApprovalUser = new TenderPriceApprovalUser();

        query += "SELECT b FROM TenderPriceApproval a, TenderPriceApprovalUser b WHERE  a.id  =  b.tenderApprovalId and b.tenderApprovalId = '" + parseInt + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            tenderPriceApprovalUser = (TenderPriceApprovalUser) list.get(0);
        }
        return tenderPriceApprovalUser;
    }
    				


}
