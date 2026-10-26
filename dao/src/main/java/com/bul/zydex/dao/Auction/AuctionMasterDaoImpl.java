/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Auction;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.AuctionMaster;
import com.bul.zydex.model.AuctionVendor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author admin
 */
public class AuctionMasterDaoImpl<T> extends GenericsDAOImpl<T> implements AuctionMasterDao<T> {
  
    @Override
    protected Class getDomainClass() {
        return AuctionMaster.class;
    }

    @Override
    public List readByRefNo(String refNo) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.auctionNo = '" + refNo + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveAuctionList(String username, String location, String department) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.auctionAdmin = '"+ username+"'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveAuctionAuthorizerList(String username, String location, String department) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.auctionAuthorizeUserName = '"+ username+"'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveAuctionUnautorizeList(String username, String location, String department) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.auctionAdmin = '"+ username+"'"
                + " and a.authorizeFlag = '0'"
                + " and a.deleteFlag = '0'"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateCloseAuction(String auction_no, String remark) {
        String query = "";
            query += " update AuctionMaster a"
                + " set a.deleteFlag='1', "
                + " a.deleteRemark='"+remark+"' "
                + " WHERE a.auctionNo = '" + auction_no + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List unauthorizeAuction(String username, String location, String department) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.authorizeFlag = '0'"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List unauthorizeEmailAuction(String username, String location, String department) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.emailFlag = '1'"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void authorizeAuction(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark, String lastBiddingTime, String extendTime, String extendTimeNo, String autoDecIncAmount, String refreshRate, String bidding_display) {
        
        LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
        
        String query = "";
            query += " update AuctionMaster a"
                + " set a.title='"+title+"', "
                + " a.value='"+value+"', "
                + " a.emd='"+emd+"', "
                + " a.docCost='"+docCost+"', "
                + " a.categoryId='"+categoryId+"', "
                + " a.biddingEnddate='"+submitLastdate+"', "
                + " a.workDesc='"+workDesc+"', "
                + " a.prNo='"+prNo+"', "
                + " a.auctionRemark='"+remark+"', "
                + " a.auctionAuthorizeUserName='"+username+"', "
                + " a.auctionAuthorizePerson='"+full_name+"', "
                + " a.auctionAuthorizeContactNo='"+contact_no+"', "
                + " a.authorizeFlag='1', "
                + " a.authorizeDate='"+formattedDate+"', "
                + " a.lastBiddingTime='"+lastBiddingTime+"', "
                + " a.extendTime='"+extendTime+"', "
                + " a.extendTimeNo='"+extendTimeNo+"', "
                + " a.autoDecIncAmount='"+autoDecIncAmount+"', "    
                + " a.refreshRate='"+refreshRate+"', "    
                + " a.biddingDisplay='"+bidding_display+"', "    
                + " a.auctionRemark='"+remark+"' "
                + " WHERE a.auctionNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List vendorLiveAuction(String username) {
        String query = "";
        query += " select b.auctionNo, a.title, a.biddingStartdate, a.biddingEnddate, a.type FROM AuctionMaster a, AuctionVendor b"
                + " WHERE b.vendorCode = '" + username + "'"
                + " and a.auctionNo = b.auctionNo"
                + " and a.authorizeFlag = '1'"
                + " and STR_TO_DATE(a.biddingStartdate,'%d-%m-%Y %H:%i:%s') <= now()"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List vendorLiveAuction1(String username) {
        String query = "";
        query += " select b.auctionNo, a.title, a.biddingStartdate, a.biddingEnddate, a.type FROM AuctionMaster a, AuctionVendor b"
                + " WHERE b.vendorCode = '" + username + "'"
                + " and a.auctionNo = b.auctionNo"
                + " and STR_TO_DATE(a.biddingStartdate,'%d-%m-%Y %H:%i:%s') >= now()"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public AuctionMaster readByAuctionNo(String auction_no) {
        AuctionMaster auctionMaster = new AuctionMaster();
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.auctionNo = '" + auction_no + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            auctionMaster = (AuctionMaster) list.get(0);
        }
        return auctionMaster;
    }

    @Override
    public void updateDate(String auction_no, Date modifiedDate1, int no_time) {
        LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
        
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
                    String strDate = dateFormat.format(modifiedDate1);  
        String query = "";
            query += " update AuctionMaster a"
                + " set a.biddingEnddate='"+strDate+"', "
                + " a.extendTimeNo='"+no_time+"' "
                + " WHERE a.auctionNo = '" + auction_no + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List rejectAuction(String username, String location, String department) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.authorizeFlag = '3'"
                + " ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List receiveAuctionList(String username, String location, String department) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and STR_TO_DATE(a.biddingStartdate,'%d-%m-%Y %H:%i:%s') <= now()"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List liveAuctionList1(String username, String location, String department) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.auctionAdmin = '"+ username+"'"
                + " and a.authorizeFlag = '1'"
                + " and a.deleteFlag = '0'"
                + " and STR_TO_DATE(a.biddingStartdate,'%d-%m-%Y %H:%i:%s') <= now()"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateDate1(String refNo, String biddingEnddate) {
        String query = "";
            query += " update AuctionMaster a"
                + " set a.biddingEnddate='"+biddingEnddate+"' "
                
                + " WHERE a.auctionNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List recycleAuction(String username, String location, String department) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'"
                + " and a.auctionAdmin = '"+ username+"'"
                + " and a.authorizeFlag = '2'"
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= now()";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void recycleAuctionSubmit(String refNo, String username, String full_name, String contact_no, String title, String value, String categoryId, String docCost, String emd, String submitLastdate, String workDesc, String prNo, String remark, String lastBiddingTime, String extendTime, String extendTimeNo, String autoDecIncAmount, String refreshRate, String bidding_display) {
        LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
        
        String query = "";
            query += " update AuctionMaster a"
                + " set a.title='"+title+"', "
                + " a.value='"+value+"', "
                + " a.emd='"+emd+"', "
                + " a.docCost='"+docCost+"', "
                + " a.categoryId='"+categoryId+"', "
                + " a.biddingEnddate='"+submitLastdate+"', "
                + " a.workDesc='"+workDesc+"', "
                + " a.prNo='"+prNo+"', "
                + " a.auctionRemark='"+remark+"', "
                + " a.authorizeFlag='0', "
                + " a.authorizeDate='"+formattedDate+"', "
                + " a.lastBiddingTime='"+lastBiddingTime+"', "
                + " a.extendTime='"+extendTime+"', "
                + " a.extendTimeNo='"+extendTimeNo+"', "
                + " a.autoDecIncAmount='"+autoDecIncAmount+"', "    
                + " a.refreshRate='"+refreshRate+"', "    
                + " a.biddingDisplay='"+bidding_display+"', "    
                + " a.auctionRemark='"+remark+"' "
                + " WHERE a.auctionNo = '" + refNo + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List pastAuctionList(String location, String department, String auction_no, String auction_title, String open_from_date, String open_to_date, String close_from_date, String close_to_date) {
        String query = "";
        query += " FROM AuctionMaster a"
                + " WHERE a.location = '" + location + "'"
                + " and a.department = '"+ department+"'";
        if(auction_no.equals(""))
        {}
        else
        {
            query += " and a.auctionNo = '"+ auction_no+"'";
        }
        if(auction_title.equals(""))
        {}
        else
        {
            query += " and a.title = '"+ auction_title+"'";
        }
        if(open_from_date.equals(""))
        {}
        else
        {
            query += " and STR_TO_DATE(a.biddingStartdate,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE('"+open_from_date+"','%d-%m-%Y ') and STR_TO_DATE(a.biddingStartdate,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE('"+open_to_date+"','%d-%m-%Y ')";
        }
        
        if(close_from_date.equals(""))
        {}
        else
        {
            query += " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') >= STR_TO_DATE('"+close_from_date+"','%d-%m-%Y ') and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') <= STR_TO_DATE('"+close_to_date+"','%d-%m-%Y ')";
        }
                
        query += " and a.authorizeFlag = '1' "
                + " and STR_TO_DATE(a.biddingEnddate,'%d-%m-%Y %H:%i:%s') <= now()";
        
        return getHibernateTemplate().find(query);
    }
}
