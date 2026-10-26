/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.TenderCommittee;
import com.bul.zydex.model.AuctionPriceApproval;
import com.bul.zydex.model.AuctionPriceApprovalComment;
import com.bul.zydex.model.AuctionPriceApprovalUser;
import com.bul.zydex.model.EmployeeMaster;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionPriceApprovalUserDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionPriceApprovalUserDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return AuctionPriceApprovalUser.class;
    }

    @Override
    public List readByRefNo(int approveId) {
        String query = "";
        query += " SELECT a.auctionNo, a.userId, a.level, a.approvalStatus, b.name FROM AuctionPriceApprovalUser a, EmployeeMaster b"
                + " WHERE a.auctionApprovalId = '" + approveId + "' and a.userId = b.employeeCode";

        List list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public AuctionPriceApprovalUser approvaList1(String username) {
        String query = "";
        AuctionPriceApprovalUser auctionPriceApprovalUser = new AuctionPriceApprovalUser();

        query += "SELECT b FROM AuctionPriceApproval a, AuctionPriceApprovalUser b WHERE  a.id  =  b.auctionApprovalId and b.userId = '" + username + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionPriceApprovalUser = (AuctionPriceApprovalUser) list.get(0);
        }
        return auctionPriceApprovalUser;
    }

    @Override
    public AuctionPriceApprovalUser readByLevel(String auction_no, int level) {
        String query = "";
        AuctionPriceApprovalUser auctionPriceApprovalUser = new AuctionPriceApprovalUser();

        query += " FROM AuctionPriceApprovalUser a WHERE  a.auctionNo = '" + auction_no + "'" + " and a.level = "+level+" ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionPriceApprovalUser = (AuctionPriceApprovalUser) list.get(0);
        }
        return auctionPriceApprovalUser;
    }

    @Override
    public AuctionPriceApprovalUser approvaList2(int parseInt) {
        String query = "";
        AuctionPriceApprovalUser auctionPriceApprovalUser = new AuctionPriceApprovalUser();

        query += "SELECT b FROM AuctionPriceApproval a, AuctionPriceApprovalUser b WHERE  a.id  =  b.auctionApprovalId and b.auctionApprovalId = '" + parseInt + "'" + " and a.approvalStatus = 0 and  a.currentApproval = b.level ";

        List list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionPriceApprovalUser = (AuctionPriceApprovalUser) list.get(0);
        }
        return auctionPriceApprovalUser;
    }
}
