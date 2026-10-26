/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Auction;

import static com.bul.zydex.controller.CustomAbstract.dateFormat;
import static com.bul.zydex.controller.CustomAbstract.myIp;
import static com.bul.zydex.controller.CustomAbstract.timeFOrmat;
import com.bul.zydex.model.AuctionMaster;
import com.bul.zydex.model.AuctionVendor;
import com.bul.zydex.model.AuctionItemMaster;
import com.bul.zydex.model.AuctionAttachment;
import com.bul.zydex.model.AuctionItemVendor;
import com.bul.zydex.model.AuctionItemVendorBid;
import com.bul.zydex.model.AuctionItemVendorBidHistory;
import com.bul.zydex.model.AuctionNoTemp;
import com.bul.zydex.model.AuctionNo;
import com.bul.zydex.model.AuctionVendorBid;
import com.bul.zydex.model.AuctionVendorBidHistory;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.bul.zydex.util.PreQualificationExcel;
import com.bul.zydex.util.BidStatus;
import com.bul.zydex.util.TenderStatus;
import com.bul.zydex.util.VendorBidItem;
import com.bul.zydex.util.LeadTime;
import com.bul.zydex.util.TechnicalSpecificationExcel;
import com.bul.zydex.util.SendMail;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.TenderAdditionalDoc;
import com.bul.zydex.model.TenderFollowup;
import com.bul.zydex.model.TenderGeneralDoc;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.TenderPreQualification;
import com.bul.zydex.model.TenderTechnical;
import com.bul.zydex.model.TenderTechnicalDoc;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.util.DownloadFile;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author admin
 */
public class VendorAuctionController extends VendorAuctionAbstract  {
    
    public ModelAndView liveVendorAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
    
        List list = auctionMasterService.vendorLiveAuction(username);
        
        List list1 = auctionMasterService.vendorLiveAuction1(username);
        
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/LiveVendorAuction");
        return mv;
    }
    
    public ModelAndView viewVendorAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String auction_no = request.getParameter("auction_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
        String auction_by = auctionMaster.getAuctionBy();
        String auction_amount = auctionMaster.getAuctionAmount();
        
         mv.getModelMap().put("auction_by", auction_by);
        
        AuctionVendor auctionVendor = auctionVendorService.readByVendorAuction(auction_no, username);
        
            if(auction_by.equals("Value"))
            {
                mv.getModelMap().put("auction_amount", auction_amount);
            }
            else if(auction_by.equals("L1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoL1(auction_no);
                
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    if(!final_price.equals("0"))
                    {
                        mv.getModelMap().put("auction_amount", final_price);
                        break;
                    }
                }
                
                
            }
            else if(auction_by.equals("H1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoH1(auction_no);
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    
                        mv.getModelMap().put("auction_amount", final_price);
                        break;
                    
                }
            }
            else
            {
                mv.getModelMap().put("auction_amount", auctionVendor.getFinalPrice());
                
            }
        
        List generalDocs = auctionAttachmentService.readAuctionGeneralDoc(auction_no);
        List additionalDocs = auctionAttachmentService.readAuctionAdditionalDoc(auction_no);
        List technicalDocs = auctionAttachmentService.readAuctionTechnicalDoc(auction_no);
        
        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
    
        List auctionItemMaster = auctionItemMasterService.readRefNo(auction_no);
        
        mv.getModelMap().put("auctionItemMaster", auctionItemMaster);
        
        mv.getModelMap().put("auction_no", auction_no);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/ViewVendorAuction");
        return mv;
    }
    
    public ModelAndView applyAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
            ModelAndView mv = new ModelAndView();
        
        String auction_no = request.getParameter("auction_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
        String auction_type1 = auctionMaster.getType();
        String refresh_rate1 = auctionMaster.getRefreshRate();
        String bidding_end_date = auctionMaster.getBiddingEnddate();
        String auction_by = auctionMaster.getAuctionBy();
        String auction_amount = auctionMaster.getAuctionAmount();
       
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        try
        {
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        
        Date date = new Date();
        Date d11 = sdf.parse(biddingEnddate);
        long difference_In_Time
                = d11.getTime() - date.getTime();
        mv.getModelMap().put("difference_In_Time", difference_In_Time);
        }catch(Exception e11){}
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date d1 = sdf.parse(bidding_end_date);
        Date d2 = sdf.parse(formattedDate);
        
        long difference_In_Time11
                = d1.getTime() - d2.getTime();
        
        if(difference_In_Time11 < 0)
        {
            //exit auction over
            request.setAttribute("successMessage",
                    "Information: Auction Time Is Over");
            mv.setViewName("forward:vendorAuction.htm?act=liveVendorAuction");
            return mv;
        }
        
        int refresh_rate = 50;
        try{
        refresh_rate = Integer.parseInt(refresh_rate1);
        }catch(Exception e11){}
        
        refresh_rate = refresh_rate * 1000;
        mv.getModelMap().put("refresh_rate", refresh_rate);
        mv.getModelMap().put("auction_by", auction_by);
        
        AuctionVendor auctionVendor = auctionVendorService.readByVendorAuction(auction_no, username);
        
            if(auction_by.equals("Value"))
            {
                mv.getModelMap().put("auction_amount", auction_amount);
            }
            else if(auction_by.equals("L1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoL1(auction_no);
                
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    if(!final_price.equals("0"))
                    {
                        mv.getModelMap().put("auction_amount", final_price);
                        break;
                    }
                }
                
                
            }
            else if(auction_by.equals("H1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoH1(auction_no);
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    
                        mv.getModelMap().put("auction_amount", final_price);
                        break;
                    
                }
            }
            else
            {
                mv.getModelMap().put("auction_amount", auctionVendor.getFinalPrice());
                
            }
            
        
        List auctionVendorBid = auctionVendorBidService.readByAuctionNo(auction_no, username);
        
        if(auctionVendorBid.isEmpty())
        {
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            mv.setViewName("Auction/ViewVendorTermsAndCondition");
            return mv;
        }
        else
        {
            int rank=0;
            
            AuctionVendorBid auctionVendorBid4 = auctionVendorBidService.readByL1(auction_no);
            
            String l1_price = auctionVendorBid4.getFinalTotal();
            
            AuctionVendorBid auctionVendorBid5 = auctionVendorBidService.readByH1(auction_no);
            
            String h1_price = auctionVendorBid5.getFinalTotal();
            
            int i=0;
            
            if(auction_type1.equals("Reverse"))
            {
                List auctionVendorBid6 = auctionVendorBidService.readByReverseAuctionRank(auction_no);

                for (Object o : auctionVendorBid6) {
                    i++;
                    AuctionVendorBid avb = (AuctionVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }

                }
            }
            if(auction_type1.equals("Forward"))
            {
                List auctionVendorBid7 = auctionVendorBidService.readByForwardAuctionRank(auction_no);

                for (Object o : auctionVendorBid7) {
                    i++;
                    AuctionVendorBid avb = (AuctionVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }
                }
            }
            
            AuctionVendorBid auctionVendorBid2 = auctionVendorBidService.readByAuctionVendor(auction_no, username);
            
            String start_price = auctionVendorBid2.getVendorBasicStartPrice();
            String final_price = auctionVendorBid2.getFinalPrice();
            String loading_per = auctionVendorBid2.getLoadingFactorPer();
            String loading_val = auctionVendorBid2.getLoadingFactorVal();
            
            mv.getModelMap().put("start_price", start_price);
            mv.getModelMap().put("final_price", final_price);
            mv.getModelMap().put("loading_per", loading_per);
            mv.getModelMap().put("loading_val", loading_val);
            
            mv.getModelMap().put("Rank", i);
            mv.getModelMap().put("l1_price", l1_price);
            mv.getModelMap().put("h1_price", h1_price);
            
            mv.getModelMap().put("auctionVendorBid2", auctionVendorBid2);
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            mv.setViewName("Auction/VendorAuctionApply");
            return mv;
            
        }
    
        //List auctionItemMaster = auctionItemMasterService.readRefNo(auction_no);
        
        //mv.getModelMap().put("auctionItemMaster", auctionItemMaster);
        
        //mv.getModelMap().put("auction_no", auction_no);
        //mv.getModelMap().put("auctionMaster", auctionMaster);
        //mv.setViewName("Auction/ViewVendorAuction");
        //return mv;
    }
    
    public ModelAndView vendorTermsAndConditionSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String auction_no = request.getParameter("auction_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
        String auction_type1 = auctionMaster.getType();
        String refresh_rate1 = auctionMaster.getRefreshRate();
        String bidding_end_date = auctionMaster.getBiddingEnddate();
        String auction_by = auctionMaster.getAuctionBy();
        String auction_amount = auctionMaster.getAuctionAmount();
        
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try
        {
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        
        Date date = new Date();
        Date d11 = sdf.parse(biddingEnddate);
        long difference_In_Time
                = d11.getTime() - date.getTime();
        mv.getModelMap().put("difference_In_Time", difference_In_Time);
        }catch(Exception e11){}
        
        int refresh_rate = 50;
        try{
        refresh_rate = Integer.parseInt(refresh_rate1);
        }catch(Exception e11){}
        
        refresh_rate = refresh_rate * 1000;
        mv.getModelMap().put("refresh_rate", refresh_rate);
        
        mv.getModelMap().put("auction_by", auction_by);
        
        AuctionVendor auctionVendor = auctionVendorService.readByVendorAuction(auction_no, username);
        
            if(auction_by.equals("Value"))
            {
                mv.getModelMap().put("auction_amount", auction_amount);
            }
            else if(auction_by.equals("L1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoL1(auction_no);
                
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    if(!final_price.equals("0"))
                    {
                        mv.getModelMap().put("auction_amount", final_price);
                        break;
                    }
                }
                
                
            }
            else if(auction_by.equals("H1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoH1(auction_no);
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    
                        mv.getModelMap().put("auction_amount", final_price);
                        break;
                    
                }
            }
            else
            {
                mv.getModelMap().put("auction_amount", auctionVendor.getFinalPrice());
                
            }
        
        
        List auctionVendorBid3 = auctionVendorBidService.readByAuctionNo(auction_no, username);
        
        if(auctionVendorBid3.isEmpty())
        {
            AuctionVendorBid auctionVendorBid1 = new AuctionVendorBid();
            auctionVendorBid1.setAuctionNo(auction_no);
            auctionVendorBid1.setVendorCode(username);
            auctionVendorBid1.setCurrency(auctionVendor.getCurrency());
            
            if(auction_by.equals("Value"))
            {
                auctionVendorBid1.setVendorBasicStartPrice(auction_amount);
                auctionVendorBid1.setLoadingFactorPer("0");
                auctionVendorBid1.setLoadingFactorVal("0");
                auctionVendorBid1.setFinalPrice(auction_amount);
                auctionVendorBid1.setFinalTotal(auction_amount);
            }
            else if(auction_by.equals("L1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoL1(auction_no);
                
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    if(!final_price.equals("0"))
                    {
                        auctionVendorBid1.setVendorBasicStartPrice(final_price);
                        auctionVendorBid1.setLoadingFactorPer("0");
                        auctionVendorBid1.setLoadingFactorVal("0");
                        auctionVendorBid1.setFinalPrice(final_price);
                        auctionVendorBid1.setFinalTotal(final_price);
                        break;
                    }
                }
                
                
            }
            else if(auction_by.equals("H1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoH1(auction_no);
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    
                        auctionVendorBid1.setVendorBasicStartPrice(final_price);
                        auctionVendorBid1.setLoadingFactorPer("0");
                        auctionVendorBid1.setLoadingFactorVal("0");
                        auctionVendorBid1.setFinalPrice(final_price);
                        auctionVendorBid1.setFinalTotal(final_price);
                        break;
                    
                }
            }
            else
            {
                auctionVendorBid1.setVendorBasicStartPrice(auctionVendor.getVendorBasicStartPrice());
                auctionVendorBid1.setLoadingFactorPer(auctionVendor.getLoadingFactorPer());
                auctionVendorBid1.setLoadingFactorVal(auctionVendor.getLoadingFactorVal());
                auctionVendorBid1.setFinalPrice(auctionVendor.getFinalPrice());
                auctionVendorBid1.setFinalTotal(auctionVendor.getFinalPrice());
            }
            
            
            auctionVendorBid1.setDateTime(formattedDate);
            auctionVendorBidService.create(auctionVendorBid1);
            
            AuctionVendorBidHistory auctionVendorBidHistory1 = new AuctionVendorBidHistory();
            auctionVendorBidHistory1.setAuctionNo(auction_no);
            auctionVendorBidHistory1.setVendorCode(username);
            auctionVendorBidHistory1.setCurrency(auctionVendor.getCurrency());
            if(auction_by.equals("Value"))
            {
                auctionVendorBidHistory1.setVendorBasicStartPrice(auction_amount);
                auctionVendorBidHistory1.setLoadingFactorPer("0");
                auctionVendorBidHistory1.setLoadingFactorVal("0");
                auctionVendorBidHistory1.setFinalPrice(auction_amount);
                auctionVendorBidHistory1.setFinalTotal(auction_amount);
            }
            else if(auction_by.equals("L1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoL1(auction_no);
                
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    if(!final_price.equals("0"))
                    {
                        auctionVendorBidHistory1.setVendorBasicStartPrice(final_price);
                        auctionVendorBidHistory1.setLoadingFactorPer("0");
                        auctionVendorBidHistory1.setLoadingFactorVal("0");
                        auctionVendorBidHistory1.setFinalPrice(final_price);
                        auctionVendorBidHistory1.setFinalTotal(final_price);
                        break;
                    }
                }
            }
            else if(auction_by.equals("H1 Price"))
            {
                List auctionVendor1 = auctionVendorService.readByRefNoH1(auction_no);
                for (Object o : auctionVendor1) {
                    AuctionVendor av = (AuctionVendor) o;
                    String final_price = av.getFinalPrice();
                    
                        auctionVendorBidHistory1.setVendorBasicStartPrice(final_price);
                        auctionVendorBidHistory1.setLoadingFactorPer("0");
                        auctionVendorBidHistory1.setLoadingFactorVal("0");
                        auctionVendorBidHistory1.setFinalPrice(final_price);
                        auctionVendorBidHistory1.setFinalTotal(final_price);
                        break;
                    
                }
            }
            else
            {
                auctionVendorBidHistory1.setVendorBasicStartPrice(auctionVendor.getVendorBasicStartPrice());
                auctionVendorBidHistory1.setLoadingFactorPer(auctionVendor.getLoadingFactorPer());
                auctionVendorBidHistory1.setLoadingFactorVal(auctionVendor.getLoadingFactorVal());
                auctionVendorBidHistory1.setFinalPrice(auctionVendor.getFinalPrice());
                auctionVendorBidHistory1.setFinalTotal(auctionVendor.getFinalPrice());
            }
            
            
            auctionVendorBidHistory1.setDateTime(formattedDate);
            auctionVendorBidHistoryService.create(auctionVendorBidHistory1);
        }
        
        List auctionVendorBid = auctionVendorBidService.readByAuctionNo(auction_no, username);
        
        if(auctionVendorBid.isEmpty())
        {
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            mv.setViewName("Auction/ViewVendorTermsAndCondition");
            return mv;
        }
        else 
        {
            
            int rank=0;
            
            AuctionVendorBid auctionVendorBid4 = auctionVendorBidService.readByL1(auction_no);
            
            String l1_price = auctionVendorBid4.getFinalTotal();
            
            AuctionVendorBid auctionVendorBid5 = auctionVendorBidService.readByH1(auction_no);
            
            String h1_price = auctionVendorBid5.getFinalTotal();
            
            int i=0;
            
            if(auction_type1.equals("Reverse"))
            {
                List auctionVendorBid6 = auctionVendorBidService.readByReverseAuctionRank(auction_no);

                for (Object o : auctionVendorBid6) {
                    i++;
                    AuctionVendorBid avb = (AuctionVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }

                }
            }
            if(auction_type1.equals("Forward"))
            {
                List auctionVendorBid7 = auctionVendorBidService.readByForwardAuctionRank(auction_no);

                for (Object o : auctionVendorBid7) {
                    i++;
                    AuctionVendorBid avb = (AuctionVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }
                }
            }
            
            AuctionVendorBid auctionVendorBid2 = auctionVendorBidService.readByAuctionVendor(auction_no, username);
            
            String start_price = auctionVendorBid2.getVendorBasicStartPrice();
            String final_price = auctionVendorBid2.getFinalPrice();
            String loading_per = auctionVendorBid2.getLoadingFactorPer();
            String loading_val = auctionVendorBid2.getLoadingFactorVal();
            
            mv.getModelMap().put("start_price", start_price);
            mv.getModelMap().put("final_price", final_price);
            mv.getModelMap().put("loading_per", loading_per);
            mv.getModelMap().put("loading_val", loading_val);
            
            mv.getModelMap().put("Rank", i);
            mv.getModelMap().put("l1_price", l1_price);
            mv.getModelMap().put("h1_price", h1_price);
            
            mv.getModelMap().put("auctionVendorBid2", auctionVendorBid2);
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            mv.setViewName("Auction/VendorAuctionApply");
            return mv;
            
        }
    
        //List auctionItemMaster = auctionItemMasterService.readRefNo(auction_no);
        
        //mv.getModelMap().put("auctionItemMaster", auctionItemMaster);
        
        //mv.getModelMap().put("auction_no", auction_no);
        //mv.getModelMap().put("auctionMaster", auctionMaster);
        //mv.setViewName("Auction/ViewVendorAuction");
        //return mv;
    }
    
    public ModelAndView vendorAuctionApplySubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String auction_no = request.getParameter("auction_no");
        String auction_type = request.getParameter("type");
        String start_price = request.getParameter("start_price");
        String final_price = request.getParameter("final_price");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
        
        String bidding_start_date = auctionMaster.getBiddingStartdate();
        String bidding_end_date = auctionMaster.getBiddingEnddate();
        String last_bidding_time = auctionMaster.getLastBiddingTime();
        String extend_bidding_time = auctionMaster.getExtendTime();
        String no_of_time = auctionMaster.getExtendTimeNo();
        String auction_type1 = auctionMaster.getType();
        
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        SimpleDateFormat sdf11= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        try
        {
        Date date = new Date();
        Date d11 = sdf11.parse(biddingEnddate);
        long difference_In_Time11
                = d11.getTime() - date.getTime();
        mv.getModelMap().put("difference_In_Time", difference_In_Time11);
        }catch(Exception e11){}
        
        String refresh_rate1 = auctionMaster.getRefreshRate();
        
        int refresh_rate = 50;
        try{
        refresh_rate = Integer.parseInt(refresh_rate1);
        }catch(Exception e11){}
        
        refresh_rate = refresh_rate * 1000;
        mv.getModelMap().put("refresh_rate", refresh_rate);
        
        int no_time = Integer.parseInt(no_of_time);
        //Checking Date comparision
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date d1 = sdf.parse(bidding_end_date);
        Date d2 = sdf.parse(formattedDate);
        
        long difference_In_Time
                = d1.getTime() - d2.getTime();
        
        if(difference_In_Time < 0)
        {
            //exit auction over
            request.setAttribute("successMessage",
                    "Information: Auction Time Is Over");
            mv.setViewName("forward:vendorAuction.htm?act=liveVendorAuction");
            return mv;
        }
        else
        {
            if(no_time > 0){
                

                // last minite auction check
                Calendar cal = Calendar.getInstance();
                cal.setTime(d2);

                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date d3 = sdf.parse("00-00-0000 "+last_bidding_time);

                String[] result = last_bidding_time.split(":");

                Calendar c2 = Calendar.getInstance();
                c2.setTime(d3);

                Calendar cTotal = (Calendar) cal.clone();
                cTotal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(result[0]));
                cTotal.add(Calendar.MINUTE, Integer.parseInt(result[1]));
                cTotal.add(Calendar.SECOND, Integer.parseInt(result[2]));

                Date modifiedDate = cTotal.getTime();

                long difference_In_Time1 = d1.getTime() - modifiedDate.getTime();

                if(difference_In_Time1 < 0)
                {
                    //Extend time
                    String[] result1 = extend_bidding_time.split(":");

                    Calendar cal1 = Calendar.getInstance();
                    cal1.setTime(d2);

                    Calendar cTotal1 = (Calendar) cal1.clone();
                    cTotal1.add(Calendar.HOUR_OF_DAY, Integer.parseInt(result1[0]));
                    cTotal1.add(Calendar.MINUTE, Integer.parseInt(result1[1]));
                    cTotal1.add(Calendar.SECOND, Integer.parseInt(result1[2]));

                    Date modifiedDate1 = cTotal1.getTime();
                    //
                    
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
                    String strDate = dateFormat.format(modifiedDate1);  
                    
                    no_time--;
                    //update query
                    
                    auctionMasterService.updateDate(auction_no,modifiedDate1,no_time);

                }
            }
        }
        
        
        
        AuctionVendor auctionVendor = auctionVendorService.readByVendorAuction(auction_no, username);
        
        List auctionVendorBid3 = auctionVendorBidService.readByAuctionNo(auction_no, username);
        
        if(auctionVendorBid3.isEmpty())
        {
            
            AuctionVendorBid auctionVendorBid1 = new AuctionVendorBid();
            auctionVendorBid1.setAuctionNo(auction_no);
            auctionVendorBid1.setVendorCode(username);
            auctionVendorBid1.setCurrency(auctionVendor.getCurrency());
            auctionVendorBid1.setVendorBasicStartPrice(auctionVendor.getVendorBasicStartPrice());
            auctionVendorBid1.setLoadingFactorPer(auctionVendor.getLoadingFactorPer());
            auctionVendorBid1.setLoadingFactorVal(auctionVendor.getLoadingFactorVal());
            auctionVendorBid1.setFinalPrice(auctionVendor.getFinalPrice());
            auctionVendorBid1.setFinalTotal(auctionVendor.getFinalPrice());
            auctionVendorBid1.setDateTime(formattedDate);
            auctionVendorBidService.create(auctionVendorBid1);
        }
        else
        {
            auctionVendorBidService.updateInfo(auction_no,username,start_price,final_price,formattedDate);
        }
        
        AuctionVendorBidHistory auctionVendorBidHistory1 = new AuctionVendorBidHistory();
        auctionVendorBidHistory1.setAuctionNo(auction_no);
        auctionVendorBidHistory1.setVendorCode(username);
        auctionVendorBidHistory1.setCurrency(auctionVendor.getCurrency());
        auctionVendorBidHistory1.setVendorBasicStartPrice(start_price);
        auctionVendorBidHistory1.setLoadingFactorPer(auctionVendor.getLoadingFactorPer());
        auctionVendorBidHistory1.setLoadingFactorVal(auctionVendor.getLoadingFactorVal());
        auctionVendorBidHistory1.setFinalPrice(final_price);
        auctionVendorBidHistory1.setFinalTotal(final_price);
        auctionVendorBidHistory1.setDateTime(formattedDate);
        auctionVendorBidHistoryService.create(auctionVendorBidHistory1);
        
        List auctionVendorBid = auctionVendorBidService.readByAuctionNo(auction_no, username);
        
        if(auctionVendorBid.isEmpty())
        {
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            mv.setViewName("Auction/ViewVendorTermsAndCondition");
            return mv;
        }
        else
        {
            int rank=0;
            
            AuctionVendorBid auctionVendorBid4 = auctionVendorBidService.readByL1(auction_no);
            
            String l1_price = auctionVendorBid4.getFinalTotal();
            
            AuctionVendorBid auctionVendorBid5 = auctionVendorBidService.readByH1(auction_no);
            
            String h1_price = auctionVendorBid5.getFinalTotal();
            
            int i=0;
            
            if(auction_type1.equals("Reverse"))
            {
                List auctionVendorBid6 = auctionVendorBidService.readByReverseAuctionRank(auction_no);

                for (Object o : auctionVendorBid6) {
                    i++;
                    AuctionVendorBid avb = (AuctionVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }

                }
            }
            if(auction_type1.equals("Forward"))
            {
                List auctionVendorBid7 = auctionVendorBidService.readByForwardAuctionRank(auction_no);

                for (Object o : auctionVendorBid7) {
                    i++;
                    AuctionVendorBid avb = (AuctionVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }
                }
            }
            AuctionVendorBid auctionVendorBid2 = auctionVendorBidService.readByAuctionVendor(auction_no, username);
            
            start_price = auctionVendorBid2.getVendorBasicStartPrice();
            final_price = auctionVendorBid2.getFinalPrice();
            String loading_per = auctionVendorBid2.getLoadingFactorPer();
            String loading_val = auctionVendorBid2.getLoadingFactorVal();
            
            mv.getModelMap().put("start_price", start_price);
            mv.getModelMap().put("final_price", final_price);
            mv.getModelMap().put("loading_per", loading_per);
            mv.getModelMap().put("loading_val", loading_val);
            
            mv.getModelMap().put("Rank", i);
            mv.getModelMap().put("l1_price", l1_price);
            mv.getModelMap().put("h1_price", h1_price);
            
            mv.getModelMap().put("auctionVendorBid2", auctionVendorBid2);
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            request.setAttribute("successMessage",
                    "Information: Auction Price Submit successfully");
            mv.setViewName("Auction/VendorAuctionApply");
            return mv;
        }
    
        //List auctionItemMaster = auctionItemMasterService.readRefNo(auction_no);
        
        //mv.getModelMap().put("auctionItemMaster", auctionItemMaster);
        
        //mv.getModelMap().put("auction_no", auction_no);
        //mv.getModelMap().put("auctionMaster", auctionMaster);
        //mv.setViewName("Auction/ViewVendorAuction");
        //return mv;
    }
    
   public ModelAndView vendorItemwiseAuctionSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {  
   
   ModelAndView mv =new ModelAndView();
//   String auctionNo =request.getParameter("auctionNo");
     HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
 
        String auction_no = request.getParameter("auction_no");
          List vendorAuctionNo = auctionItemVendorService.readByAuctionNo(auction_no , username);
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
        String auction_type1 = auctionMaster.getType();
        String refresh_rate1 = auctionMaster.getRefreshRate();
        String bidding_end_date = auctionMaster.getBiddingEnddate();
        
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try
        {
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        
        Date date = new Date();
        Date d11 = sdf.parse(biddingEnddate);
        long difference_In_Time
                = d11.getTime() - date.getTime();
        mv.getModelMap().put("difference_In_Time", difference_In_Time);
        }catch(Exception e11){}
        
        int refresh_rate = 50;
        try{
        refresh_rate = Integer.parseInt(refresh_rate1);
        }catch(Exception e11){}
        
        refresh_rate = refresh_rate * 1000;
        mv.getModelMap().put("refresh_rate", refresh_rate);
        
         for (Object o : vendorAuctionNo) {
            //i++;
            AuctionItemVendor aiv = (AuctionItemVendor) o;
            int item_id = aiv.getAuctionItemMasterId();
            List auctionVendorBid3 = auctionItemVendorBidService.readByAuctionNoWithItem(auction_no, username,item_id);
            
            if(auctionVendorBid3.isEmpty())
            {
                 AuctionItemVendorBid auctionVendorBid1 = new AuctionItemVendorBid();
            auctionVendorBid1.setAuctionNo(auction_no);
            auctionVendorBid1.setVendorCode(username);
            auctionVendorBid1.setCurrency(aiv.getCurrency());
            auctionVendorBid1.setVendorBasicStartPrice(aiv.getVendorBasicStartPrice());
            auctionVendorBid1.setLoadingFactorPer(aiv.getLoadingFactorPer());
            auctionVendorBid1.setLoadingFactorVal(aiv.getLoadingFactorVal());
            auctionVendorBid1.setFinalPrice(aiv.getFinalPrice());
            auctionVendorBid1.setFinalTotal(aiv.getFinalPrice());
            auctionVendorBid1.setDateTime(formattedDate);
            auctionVendorBid1.setAuctionItemMasterId(aiv.getAuctionItemMasterId());
            auctionItemVendorBidService.create(auctionVendorBid1);
            
            AuctionItemVendorBidHistory auctionVendorBidHistory1 = new AuctionItemVendorBidHistory();
            auctionVendorBidHistory1.setAuctionNo(auction_no);
            auctionVendorBidHistory1.setVendorCode(username);
            auctionVendorBidHistory1.setCurrency(aiv.getCurrency());
            auctionVendorBidHistory1.setVendorBasicStartPrice(aiv.getVendorBasicStartPrice());
            auctionVendorBidHistory1.setLoadingFactorPer(aiv.getLoadingFactorPer());
            auctionVendorBidHistory1.setLoadingFactorVal(aiv.getLoadingFactorVal());
            auctionVendorBidHistory1.setFinalPrice(aiv.getFinalPrice());
            auctionVendorBidHistory1.setFinalTotal(aiv.getFinalPrice());
            auctionVendorBidHistory1.setDateTime(formattedDate);
            auctionVendorBidHistory1.setAuctionItemMasterId(aiv.getAuctionItemMasterId());
            auctionItemVendorBidHistoryService.create(auctionVendorBidHistory1); 
            }
         }
        
        List auctionVendorBid = auctionItemVendorBidService.readByAuctionNo(auction_no, username);
        
        if(auctionVendorBid.isEmpty())
        {
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            mv.setViewName("Auction/ViewVendorTermsAndCondition");
            return mv;
        }
        else 
        {
             List auctionItemMasterList = new LinkedList();
            for (Object o1 : vendorAuctionNo) {
            
            AuctionItemVendor auctionItemVendor = (AuctionItemVendor) o1;
            int item_id = auctionItemVendor.getAuctionItemMasterId();
            AuctionItemMaster auctionItemMaster  =auctionItemMasterService.readById(item_id);
            String itemCode =auctionItemMaster.getItemCode();
            String itemNo =auctionItemMaster.getAuctionNo();
            String itemName = auctionItemMaster.getItemName();
            String itemDesc =auctionItemMaster.getItemDesc();
            String itemRemark =auctionItemMaster.getItemRemark();
            String uom =auctionItemMaster.getUom();
            String qty =auctionItemMaster.getQty();
            int rank=0;
            
          
            
            AuctionItemVendorBid auctionVendorBid4 = auctionItemVendorBidService.readByL1WithItem(auction_no, item_id);
            
            String l1_price = auctionVendorBid4.getFinalTotal();
            
            AuctionItemVendorBid auctionVendorBid5 = auctionItemVendorBidService.readByH1WithItem(auction_no ,item_id);
            
            String h1_price = auctionVendorBid5.getFinalTotal();
            
            int i=0;
            
            if(auction_type1.equals("Reverse"))
            {
                List auctionVendorBid6 = auctionItemVendorBidService.readByReverseAuctionRankWithItem(auction_no ,item_id);

                for (Object o : auctionVendorBid6) {
                    i++;
                    AuctionItemVendorBid avb = (AuctionItemVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }

                }
            }
            if(auction_type1.equals("Forward"))
            {
                List auctionVendorBid7 = auctionItemVendorBidService.readByForwardAuctionRankWithItem(auction_no ,item_id);

                for (Object o : auctionVendorBid7) {
                    i++;
                    AuctionItemVendorBid avb = (AuctionItemVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }
                }
            }
            
            AuctionItemVendorBid auctionVendorBid2 = auctionItemVendorBidService.readByAuctionVendorWithItem(auction_no, username ,item_id);
            
            String start_price = auctionVendorBid2.getVendorBasicStartPrice();
            String final_price = auctionVendorBid2.getFinalPrice();
            String loading_per = auctionVendorBid2.getLoadingFactorPer();
            String loading_val = auctionVendorBid2.getLoadingFactorVal();

             mv.getModelMap().put("itemCode", itemCode);
              mv.getModelMap().put("itemNo", itemNo);
              mv.getModelMap().put("itemName", itemName);
              mv.getModelMap().put("itemDesc", itemDesc);
              mv.getModelMap().put("itemRemark", itemRemark);
              mv.getModelMap().put("uom", uom);
              mv.getModelMap().put("qty", qty);

            mv.getModelMap().put("start_price", start_price);
            mv.getModelMap().put("final_price", final_price);
            mv.getModelMap().put("loading_per", loading_per);
            mv.getModelMap().put("loading_val", loading_val);
            
            mv.getModelMap().put("Rank", i);
            mv.getModelMap().put("l1_price", l1_price);
            mv.getModelMap().put("h1_price", h1_price);
            
            
            
                  List starusList = new ArrayList();
              starusList.add(itemCode);
                
                starusList.add(itemName);
                starusList.add(itemDesc);
                starusList.add(itemRemark);
                starusList.add( uom);
                starusList.add(qty);
                starusList.add(itemNo);
                starusList.add(start_price);
                starusList.add(loading_per);
                starusList.add(loading_val);
                starusList.add(final_price);
                starusList.add(i);
                starusList.add(item_id);
                auctionItemMasterList.add(starusList);
                
  
            }
               mv.getModelMap().put("auctionItemMasterList", auctionItemMasterList);
//            mv.getModelMap().put("list", auctionItemMaster);
//            
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
           
   mv.setViewName("Auction/VendorItemwiseAuction");
   return mv;
   }  
   }
          

    public ModelAndView vendorItemAuctionApplySubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
       
//        String[] startPrice =request.getParameterValues("start_price1");
//        String[]  finalPrice =request.getParameterValues("final_price");
//        String[] loadingVal =request.getParameterValues("loading_val");
//        String[] loadingPer =request.getParameterValues("loading_per");
//         LocalDateTime myDateObj = LocalDateTime.now();
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDate = myDateObj.format(myFormatObj);
//        
//        for(int i =0 ;i>=itemId.length;i++){
//        AuctionItemVendorBidHistory auctionItemVendorBidHistory = auctionItemVendorBidHistoryService.readById(Integer.parseInt(itemId[i]));
//        
////        if(auctionItemVendorBidHistory.getAuctionItemMasterId() == (itemId)){
//        auctionItemVendorBidHistory.setVendorBasicStartPrice(startPrice[i]);
//        auctionItemVendorBidHistory.setFinalPrice(finalPrice[i]);
//        auctionItemVendorBidHistory.setFinalTotal(finalPrice[i]);
//        auctionItemVendorBidHistory.setLoadingFactorPer(loadingPer[i]);
//        auctionItemVendorBidHistory.setLoadingFactorVal(loadingVal[i]);
//         auctionItemVendorBidHistory.setDateTime(formattedDate);
//        auctionItemVendorBidHistoryService.update(auctionItemVendorBidHistory);
//        }
        
        
        
           String auction_no = request.getParameter("auction_no");
        String auction_type = request.getParameter("type");
     
//        String[] startPrice=request.getParameterValues("start_price");
//        int i2=0;
//        for(int j=0; j<=startPricẹ.length();j++){
//            i2++;
// String[] submit =request.getParameterValues("Submit"+i2);
//        }
     
        
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
         List vendorAuctionNo = auctionItemVendorService.readByAuctionNo(auction_no , username);
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
        
        String bidding_start_date = auctionMaster.getBiddingStartdate();
        String bidding_end_date = auctionMaster.getBiddingEnddate();
        String last_bidding_time = auctionMaster.getLastBiddingTime();
        String extend_bidding_time = auctionMaster.getExtendTime();
        String no_of_time = auctionMaster.getExtendTimeNo();
        String auction_type1 = auctionMaster.getType();
        
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        SimpleDateFormat sdf11= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        try
        {
        Date date = new Date();
        Date d11 = sdf11.parse(biddingEnddate);
        long difference_In_Time11
                = d11.getTime() - date.getTime();
        mv.getModelMap().put("difference_In_Time", difference_In_Time11);
        }catch(Exception e11){}
        
        String refresh_rate1 = auctionMaster.getRefreshRate();
        
        int refresh_rate = 50;
        try{
        refresh_rate = Integer.parseInt(refresh_rate1);
        }catch(Exception e11){}
        
        refresh_rate = refresh_rate * 1000;
        mv.getModelMap().put("refresh_rate", refresh_rate);
        
        int no_time = Integer.parseInt(no_of_time);
        //Checking Date comparision
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date d1 = sdf.parse(bidding_end_date);
        Date d2 = sdf.parse(formattedDate);
        
        long difference_In_Time
                = d1.getTime() - d2.getTime();
        
        if(difference_In_Time < 0)
        {
            //exit auction over
            request.setAttribute("successMessage",
                    "Information: Auction Time Is Over");
            mv.setViewName("forward:vendorAuction.htm?act=liveVendorAuction");
            return mv;
        }
        else
        {
            if(no_time > 0){
                

                // last minite auction check
                Calendar cal = Calendar.getInstance();
                cal.setTime(d2);

                SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date d3 = sdf.parse("00-00-0000 "+last_bidding_time);

                String[] result = last_bidding_time.split(":");

                Calendar c2 = Calendar.getInstance();
                c2.setTime(d3);

                Calendar cTotal = (Calendar) cal.clone();
                cTotal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(result[0]));
                cTotal.add(Calendar.MINUTE, Integer.parseInt(result[1]));
                cTotal.add(Calendar.SECOND, Integer.parseInt(result[2]));

                Date modifiedDate = cTotal.getTime();

                long difference_In_Time1 = d1.getTime() - modifiedDate.getTime();

                if(difference_In_Time1 < 0)
                {
                    //Extend time
                    String[] result1 = extend_bidding_time.split(":");

                    Calendar cal1 = Calendar.getInstance();
                    cal1.setTime(d2);

                    Calendar cTotal1 = (Calendar) cal1.clone();
                    cTotal1.add(Calendar.HOUR_OF_DAY, Integer.parseInt(result1[0]));
                    cTotal1.add(Calendar.MINUTE, Integer.parseInt(result1[1]));
                    cTotal1.add(Calendar.SECOND, Integer.parseInt(result1[2]));

                    Date modifiedDate1 = cTotal1.getTime();
                    //
                    
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");  
                    String strDate = dateFormat.format(modifiedDate1);  
                    
                    no_time--;
                    //update query
                    
                    auctionMasterService.updateDate(auction_no,modifiedDate1,no_time);

                }
            }
        }
        
     
         String[] item_id =request.getParameterValues("item_id");
         int i1=0;
         for(int j=0;j<item_id.length;j++){
             i1++;
      String submit1 =request.getParameter("Submit"+i1);
      if (submit1== null){
      submit1 = "";}
//      String[] submit =request.getParameterValues("Submit"+i1);
             if(submit1.equals("Submit")){
             
             
        String[] start_price = request.getParameterValues("start_price");
        String[] final_price = request.getParameterValues("final_price");
        String[] loading_per =request.getParameterValues("loading_per");
        String[] loading_val =request.getParameterValues("loading_val");
             
//        AuctionItemVendor auctionVendor = auctionItemVendorService.readByVendorAuction(auction_no, username , Integer.parseInt(item_id[j]));
        
        List auctionVendorBid3 = auctionItemVendorBidService.readByAuctionNoWithItem( auction_no,  username, Integer.parseInt(item_id[j]));
        
        if(auctionVendorBid3.isEmpty())
        {
            
            AuctionItemVendorBid auctionVendorBid1 = new AuctionItemVendorBid();
            auctionVendorBid1.setAuctionNo(auction_no);
            auctionVendorBid1.setVendorCode(username);
            auctionVendorBid1.setCurrency("INR (Rupees)");
            auctionVendorBid1.setVendorBasicStartPrice(start_price[j]);
            auctionVendorBid1.setLoadingFactorPer(loading_per[j]);
            auctionVendorBid1.setLoadingFactorVal(loading_val[j]);
            auctionVendorBid1.setFinalPrice(final_price[j]);
            auctionVendorBid1.setFinalTotal(final_price[j]);
            auctionVendorBid1.setDateTime(formattedDate);
            auctionVendorBid1.setAuctionItemMasterId(Integer.parseInt(item_id[j]));
            auctionItemVendorBidService.create(auctionVendorBid1);
        
        }
                
        else
        {
           
            auctionItemVendorBidService.updateInfo(auction_no,username,start_price[j],final_price[j],formattedDate ,Integer.parseInt(item_id[j]));
           
        }
    
        AuctionItemVendorBidHistory auctionVendorBidHistory1 = new AuctionItemVendorBidHistory();
        auctionVendorBidHistory1.setAuctionNo(auction_no);
        auctionVendorBidHistory1.setVendorCode(username);
        auctionVendorBidHistory1.setCurrency("INR (Rupees)");
        auctionVendorBidHistory1.setVendorBasicStartPrice(start_price[j]);
        auctionVendorBidHistory1.setLoadingFactorPer(loading_per[j]);
        auctionVendorBidHistory1.setLoadingFactorVal(loading_val[j]);
        auctionVendorBidHistory1.setFinalPrice(final_price[j]);
        auctionVendorBidHistory1.setFinalTotal(final_price[j]);
        auctionVendorBidHistory1.setDateTime(formattedDate);
        
        auctionVendorBidHistory1.setAuctionItemMasterId(Integer.parseInt(item_id[j]));
        auctionItemVendorBidHistoryService.create(auctionVendorBidHistory1);
         }
         }
         
         List auctionVendorBid = auctionItemVendorBidService.readByAuctionNo(auction_no, username);
        
        if(auctionVendorBid.isEmpty())
        {
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            mv.setViewName("Auction/ViewVendorTermsAndCondition");
             request.setAttribute("failureMessage",
                    "Information: Vendor is Not Available for Auction");
          
            return mv;
        }
        else 
        {
             List auctionItemMasterList = new LinkedList();
            for (Object o1 : vendorAuctionNo) {
            
            AuctionItemVendor auctionItemVendor = (AuctionItemVendor) o1;
            int item_id1 = auctionItemVendor.getAuctionItemMasterId();
            AuctionItemMaster auctionItemMaster  =auctionItemMasterService.readById(item_id1);
            String itemCode =auctionItemMaster.getItemCode();
            String itemNo =auctionItemMaster.getAuctionNo();
            String itemName = auctionItemMaster.getItemName();
            String itemDesc =auctionItemMaster.getItemDesc();
            String itemRemark =auctionItemMaster.getItemRemark();
            String uom =auctionItemMaster.getUom();
            String qty =auctionItemMaster.getQty();
            int rank=0;
            
          
            
            AuctionItemVendorBid auctionVendorBid4 = auctionItemVendorBidService.readByL1WithItem(auction_no, item_id1);
            
            String l1_price = auctionVendorBid4.getFinalTotal();
            
            AuctionItemVendorBid auctionVendorBid5 = auctionItemVendorBidService.readByH1WithItem(auction_no ,item_id1);
            
            String h1_price = auctionVendorBid5.getFinalTotal();
            
            int i=0;
            
            if(auction_type1.equals("Reverse"))
            {
                List auctionVendorBid6 = auctionItemVendorBidService.readByReverseAuctionRankWithItem(auction_no ,item_id1);

                for (Object o : auctionVendorBid6) {
                    i++;
                    AuctionItemVendorBid avb = (AuctionItemVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }

                }
            }
            if(auction_type1.equals("Forward"))
            {
                List auctionVendorBid7 = auctionItemVendorBidService.readByForwardAuctionRankWithItem(auction_no ,item_id1);

                for (Object o : auctionVendorBid7) {
                    i++;
                    AuctionItemVendorBid avb = (AuctionItemVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }
                }
            }
            
            AuctionItemVendorBid auctionVendorBid2 = auctionItemVendorBidService.readByAuctionVendorWithItem(auction_no, username ,item_id1);
            
            String start_price = auctionVendorBid2.getVendorBasicStartPrice();
            String final_price = auctionVendorBid2.getFinalPrice();
            String loading_per = auctionVendorBid2.getLoadingFactorPer();
            String loading_val = auctionVendorBid2.getLoadingFactorVal();

             mv.getModelMap().put("itemCode", itemCode);
              mv.getModelMap().put("itemNo", itemNo);
              mv.getModelMap().put("itemName", itemName);
              mv.getModelMap().put("itemDesc", itemDesc);
              mv.getModelMap().put("itemRemark", itemRemark);
              mv.getModelMap().put("uom", uom);
              mv.getModelMap().put("qty", qty);

            mv.getModelMap().put("start_price", start_price);
            mv.getModelMap().put("final_price", final_price);
            mv.getModelMap().put("loading_per", loading_per);
            mv.getModelMap().put("loading_val", loading_val);
            
            mv.getModelMap().put("Rank", i);
            mv.getModelMap().put("l1_price", l1_price);
            mv.getModelMap().put("h1_price", h1_price);
            
            
            
                  List starusList = new ArrayList();
              starusList.add(itemCode);
                
                starusList.add(itemName);
                starusList.add(itemDesc);
                starusList.add(itemRemark);
                starusList.add( uom);
                starusList.add(qty);
                starusList.add(itemNo);
                starusList.add(start_price);
                starusList.add(loading_per);
                starusList.add(loading_val);
                starusList.add(final_price);
                starusList.add(i);
                starusList.add(item_id1);
                auctionItemMasterList.add(starusList);
                
  
            }
        
        
        
               mv.getModelMap().put("auctionItemMasterList", auctionItemMasterList);
//            mv.getModelMap().put("list", auctionItemMaster);
            }
         
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
           
   mv.setViewName("Auction/VendorItemwiseAuction");
   return mv;
        } 

     public ModelAndView applyItemwiseAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String auction_no = request.getParameter("auction_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
        String auction_type1 = auctionMaster.getType();
        String refresh_rate1 = auctionMaster.getRefreshRate();
        String bidding_end_date = auctionMaster.getBiddingEnddate();
       
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try
        {
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        
        Date date = new Date();
        Date d11 = sdf.parse(biddingEnddate);
        long difference_In_Time
                = d11.getTime() - date.getTime();
        mv.getModelMap().put("difference_In_Time", difference_In_Time);
        }catch(Exception e11){}
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date d1 = sdf.parse(bidding_end_date);
        Date d2 = sdf.parse(formattedDate);
        
        long difference_In_Time11
                = d1.getTime() - d2.getTime();
        
        if(difference_In_Time11 < 0)
        {
            //exit auction over
            request.setAttribute("successMessage",
                    "Information: Auction Time Is Over");
            mv.setViewName("forward:vendorAuction.htm?act=liveVendorAuction");
            return mv;
        }
        
        int refresh_rate = 50;
        try{
        refresh_rate = Integer.parseInt(refresh_rate1);
        }catch(Exception e11){}
        
        refresh_rate = refresh_rate * 1000;
        mv.getModelMap().put("refresh_rate", refresh_rate);
        
        AuctionItemVendor auctionItemVendor = auctionItemVendorService.readByVendorAuction(auction_no, username);
        
        List auctionItemVendorBid = auctionItemVendorBidService.readByAuctionNo(auction_no, username);
        
        if(auctionItemVendorBid.isEmpty())
        {
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            mv.setViewName("Auction/ViewVendorTermsAndCondition");
            return mv;
        }
        else
        {
            int rank=0;
            
            AuctionItemVendorBid auctionItemVendorBid4 = auctionItemVendorBidService.readByL1(auction_no);
            
            String l1_price = auctionItemVendorBid4.getFinalTotal();
            
            AuctionItemVendorBid auctionItemVendorBid5 = auctionItemVendorBidService.readByH1(auction_no);
            
            String h1_price = auctionItemVendorBid5.getFinalTotal();
            
            int i=0;
            
            if(auction_type1.equals("Reverse"))
            {
                List auctionItemVendorBid6 = auctionItemVendorBidService.readByReverseAuctionRank(auction_no);

                for (Object o : auctionItemVendorBid6) {
                    i++;
                    AuctionItemVendorBid avb = (AuctionItemVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }

                }
            }
            if(auction_type1.equals("Forward"))
            {
                List auctionItemVendorBid7 = auctionVendorBidService.readByForwardAuctionRank(auction_no);

                for (Object o : auctionItemVendorBid7) {
                    i++;
                    AuctionItemVendorBid avb = (AuctionItemVendorBid) o;
                    if(username.equals(avb.getVendorCode()))
                    {
                        break;
                    }
                }
            }
            
            AuctionItemVendorBid auctionItemVendorBid2 = auctionItemVendorBidService.readByAuctionVendor(auction_no, username);
            
            String start_price = auctionItemVendorBid2.getVendorBasicStartPrice();
            String final_price = auctionItemVendorBid2.getFinalPrice();
            String loading_per = auctionItemVendorBid2.getLoadingFactorPer();
            String loading_val = auctionItemVendorBid2.getLoadingFactorVal();
            
            mv.getModelMap().put("start_price", start_price);
            mv.getModelMap().put("final_price", final_price);
            mv.getModelMap().put("loading_per", loading_per);
            mv.getModelMap().put("loading_val", loading_val);
            
            mv.getModelMap().put("Rank", i);
            mv.getModelMap().put("l1_price", l1_price);
            mv.getModelMap().put("h1_price", h1_price);
            
            mv.getModelMap().put("auctionVendorBid2", auctionItemVendorBid2);
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.getModelMap().put("auction_no", auction_no);
            mv.setViewName("forward:vendorAuction.htm?act=vendorItemwiseAuctionSubmit");
            return mv;
            
        }
    
    
     } 
}
