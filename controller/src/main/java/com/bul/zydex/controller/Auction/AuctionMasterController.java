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
import com.bul.zydex.model.TenderApprovalUser;
import com.bul.zydex.model.TenderFollowup;
import com.bul.zydex.model.TenderGeneralDoc;
import com.bul.zydex.model.TenderItemMaster;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.TenderPreQualification;
import com.bul.zydex.model.TenderPriceApproval;
import com.bul.zydex.model.TenderPriceApprovalComment;
import com.bul.zydex.model.TenderPriceApprovalUser;

import com.bul.zydex.model.AuctionPriceApproval;
import com.bul.zydex.model.AuctionPriceApprovalComment;
import com.bul.zydex.model.AuctionPriceApprovalUser;
import com.bul.zydex.model.TenderTechnical;
import com.bul.zydex.model.TenderTechnicalDoc;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.model.VendorTenderBid;
import com.bul.zydex.util.DownloadFile;
import java.util.LinkedList;
/**
 *
 * @author admin
 */
public class AuctionMasterController extends AuctionMasterAbstract {
    
    public ModelAndView selectAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        
        //tender id
        String ref_no="";
        AuctionNoTemp auctionNoTemp = auctionNoTempService.readLastRecord();
        ref_no = auctionNoTemp.getAuctionNo();
        int ref_no1 = Integer.parseInt(ref_no);
        ref_no1++;
        
        AuctionNoTemp auctionNoTemp1 = new AuctionNoTemp();
        auctionNoTemp1.setAuctionNo(ref_no1+"");
        auctionNoTempService.create(auctionNoTemp1);
        
        mv.getModelMap().put("ref_no", ref_no1);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/SelectAuction");
        return mv;
    }
    
    public ModelAndView createAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        String type = request.getParameter("auctionType");
        String ref_no = request.getParameter("ref_no");
        //tender id
        //String ref_no="";
        
        /*AuctionNoTemp auctionNoTemp = auctionNoTempService.readLastRecord();
        ref_no = auctionNoTemp.getAuctionNo();
        int ref_no1 = Integer.parseInt(ref_no);
        ref_no1++;
        
        AuctionNoTemp auctionNoTemp1 = new AuctionNoTemp();
        auctionNoTemp1.setAuctionNo(ref_no1+"");
        auctionNoTempService.create(auctionNoTemp1); */
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String submitLastdate = myDateObj.format(myFormatObj1);
        submitLastdate = submitLastdate + " 23:59:00";
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String employee_name = employeeMaster.getName();
        String ph_no = employeeMaster.getPhNo();
        String location = employeeMaster.getLocation();
        
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        
        
        mv.getModelMap().put("employee_name", employee_name);
        mv.getModelMap().put("ph_no", ph_no);
        mv.getModelMap().put("location", location);
        mv.getModelMap().put("formattedDate", formattedDate);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("type", type);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/CreateAuction");
        return mv;
    }
    
    public ModelAndView submitAuctionMaster(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
    
        String type = request.getParameter("type");
        String refNo = request.getParameter("auction_no");
        String title = request.getParameter("title");
        String value = request.getParameter("value");
        String categoryId = request.getParameter("categoryId");
        String docCost = request.getParameter("docCost");
        String emd = request.getParameter("emd");
        String location = request.getParameter("location");
        String announceDate = request.getParameter("biddingStartdate");
        String submitLastdate = request.getParameter("biddingEnddate");
        String workDesc = request.getParameter("workDesc");
        String prNo = request.getParameter("prNo");
        String contactPerson = request.getParameter("contactPerson");
        String auctionAdminContactNumber = request.getParameter("auctionAdminContactNumber");
        String auctionAuthorizePerson = request.getParameter("auctionAuthorizePerson");
        String auctionAuthorizeContactNo = request.getParameter("auctionAuthorizeContactNo");
        String remark = request.getParameter("remark");
        String lastBiddingTime = request.getParameter("lastBiddingTime");
        String extendTime = request.getParameter("extendTime");
        String extendTimeNo = request.getParameter("extendTimeNo");
        String autoDecIncAmount = request.getParameter("autoDecIncAmount");
        String refreshRate = request.getParameter("refreshRate");
        String bidding_display = request.getParameter("bidding_display");
        String biddingType = request.getParameter("biddingType"); if(biddingType == null) biddingType="";
        if(biddingType.equals(""))biddingType="Lot Bidding";
        String auction_by = request.getParameter("auction_by");
        String auctionAmount = request.getParameter("auctionAmount");
        
        String refNo1 = refNo;
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String department = employeeMaster.getDepartment();
        
        Date date = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("yy");
        String sysdate=sdf4.format(date);
        Date date1 = new java.util.Date();
        SimpleDateFormat sdf5 = new SimpleDateFormat("MM");
        String sysdate1=sdf5.format(date1);
        int month_frt=Integer.parseInt(sysdate1);
        int year_frt=Integer.parseInt(sysdate);
        
        AuctionNo auctionNo = auctionNoService.readByAuctionNo();
        
        String auctionno = "0"; 
        auctionno = auctionNo.getAuctionNo(); if(auctionno == null) auctionno="0";
        
        int ten_no_int=0;
        
        ten_no_int = Integer.parseInt(auctionno);
        
        long ten_no_final=0;
        
        String final_ten_no="";
        ten_no_int++;
        String text = String.format("%07d", ten_no_int);
        String mini=text.substring(0,2);
        String sub_text="";
        if(month_frt<=3)
        {   int bbb=year_frt-1;
                sysdate=Integer.toString(bbb);
                if(mini.equals(sysdate))
                {
                    final_ten_no=text;

                }
                else
                {
                    int bbbb=year_frt-1;
                    sysdate=Integer.toString(bbbb);
                    sub_text=text.substring(2);
                    final_ten_no=sysdate+sub_text;
                }
        }else{
            if(mini.equals(sysdate))
            {
                final_ten_no=text;
            }
            else
            {
                sub_text=text.substring(2);
                final_ten_no=sysdate+"00001";
            }
        }

        refNo = final_ten_no;
        
        AuctionNo auctionNo1 = new AuctionNo();
        auctionNo1.setAuctionNo(refNo);
        auctionNoService.create(auctionNo1);
        
        refNo = "A"+refNo;
        String path=getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo;
        File f1 = new File(path);  
        boolean bool = f1.mkdir();
        
        List auctionMaster1 = auctionMasterService.readByRefNo(refNo);
        
        if(auctionMaster1.isEmpty())
        {
            auctionMaster.setAuctionNo(refNo);
            auctionMaster.setTitle(title);
            auctionMaster.setBiddingStartdate(announceDate);
            auctionMaster.setBiddingEnddate(submitLastdate);
            auctionMaster.setWorkDesc(workDesc);
            auctionMaster.setPrNo(prNo);
            auctionMaster.setValue(value);
            auctionMaster.setDocCost(docCost);
            auctionMaster.setEmd(emd);
            auctionMaster.setLocation(location);
            auctionMaster.setCategoryId(categoryId);
            auctionMaster.setContactPerson(contactPerson);
            auctionMaster.setAuctionAdminContactNumber(auctionAdminContactNumber);
            auctionMaster.setAuctionAuthorizePerson(auctionAuthorizePerson);
            auctionMaster.setAuctionAuthorizeContactNo(auctionAuthorizeContactNo);
            auctionMaster.setAuctionAdmin(username);
            auctionMaster.setAuctionRemark(remark);
            auctionMaster.setAuthorizeFlag(0);
            auctionMaster.setEmailFlag(0);
            auctionMaster.setReturnFlag(0);
            auctionMaster.setDeleteFlag(0);
            auctionMaster.setDepartment(department);
            auctionMaster.setType(type);
            auctionMaster.setLastBiddingTime(lastBiddingTime);
            auctionMaster.setExtendTime(extendTime);
            auctionMaster.setExtendTimeNo(extendTimeNo);
            auctionMaster.setAutoDecIncAmount(autoDecIncAmount);
            auctionMaster.setRefreshRate(refreshRate);
            auctionMaster.setBiddingDisplay(bidding_display);
            auctionMaster.setBiddingType(biddingType);
            auctionMaster.setAuctionBy(auction_by);
            auctionMaster.setAuctionAmount(auctionAmount);
            auctionMasterService.create(auctionMaster);
        }
        
        
        // update item table
        
        auctionItemMasterService.updateAuctionNo(refNo1,refNo);
        
        auctionAttachmentService.updateAuctionNo(refNo1,refNo);
        
        
        
        //attach general document
        
        int otherDetailCount = 0;
        //int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile" + i);if(generalfile == null)generalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("generalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(generalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(generalfile);
                auctionAttachment.setAttachmentType(0);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        //attach additional document
        
        int otherDetailCount1 = 0;
//        int otherDetailCount1 = Integer.parseInt(request.getParameter("policyCount1"));
        for (int i = 1; i <= otherDetailCount1; i++) {
            String additionalfile = request.getParameter("additionalfile" + i);if(additionalfile == null)additionalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("additionalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    additionalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(additionalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(additionalfile);
                auctionAttachment.setAttachmentType(1);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        
        //attach technical document technical
        
        int otherDetailCount2 = 0;
//        int otherDetailCount2 = Integer.parseInt(request.getParameter("policyCount2"));
        for (int i = 1; i <= otherDetailCount2; i++) {
            String technicalfile = request.getParameter("technicalfile" + i);if(technicalfile == null)technicalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("technicalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    technicalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(technicalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(technicalfile);
                auctionAttachment.setAttachmentType(2);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        String[] vendor_code = request.getParameterValues("vendor_code");
        String[] email_id = request.getParameterValues("email_id");
        String[] mobile_no = request.getParameterValues("mobile_no");
        String[] start_price = request.getParameterValues("start_price");
        String[] loading_factor_per = request.getParameterValues("loading_factor_per");
        String[] loading_factor_val = request.getParameterValues("loading_factor_val");
        String[] final_price = request.getParameterValues("final_price");
        
        
        int no_of_vendor = 0;
        int j=0;
        
        for(int i=0;i<vendor_code.length;i++){
            j++;
            int checkVendorId = 0;
            
            String vendor_code1 = vendor_code[i];
            auctionVendorService.updateAuctionNo(refNo1, refNo, vendor_code1, email_id[i], mobile_no[i], start_price[i], loading_factor_per[i], loading_factor_val[i], final_price[i], checkVendorId);
        }
        no_of_vendor = j;
        
        
        request.setAttribute("successMessage",
                    "Information: Auction Created Successfully");
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        
        mv.setViewName("forward:auctionMaster.htm?act=liveAuctionList");
        //mv.setViewName("Auction/SelectAuction");
        return mv;
    }
    
    public ModelAndView addItemDocument(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
        
        List itemDetail = auctionItemMasterService.readRefNo(ref_no);
                
                
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String department = employeeMaster.getDepartment();
        String location = employeeMaster.getLocation();
        
       
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("itemDetail", itemDetail);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.setViewName("Auction/AddAuctionItemDocument");
        return mv;
    }
    
    public ModelAndView addItemDocumentSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
        
        
        
        String path=getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no;
        File f1 = new File(path);  
        boolean bool = f1.mkdir();
        
        String service_file = request.getParameter("service_file");if(service_file == null)service_file="";
        
        String service_file1 = service_file.replaceAll(" ", "");
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("service_file");
            
            service_file1 = multipartFile.getOriginalFilename().replaceAll(" ", "");
            
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    service_file = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        
            
            
        try {
                File file = new File(getServletContext().getRealPath("/")+"/StorageYard/Auction/"+ref_no + "/" + service_file);
                //creating a new file instance  
                FileInputStream fis = new FileInputStream(file);
                //obtaining bytes from the file  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                //creating a Sheet object to retrieve object  
                Iterator < Row > itr = sheet.iterator();
                //iterating over excel file
                System.out.println("The given file is");
                
                auctionItemMasterService.deleteRefNo(ref_no);
                
                int j = 0;
                while (itr.hasNext()) {
                    j++;
                    
                    Row row = itr.next();
                    Iterator < Cell > cellIterator = row.cellIterator();
                    //iterating over each column  
                    if(j>=2)
                    {
                    String srNo ="";
                    String item_code ="";
                    String item_name ="";
                    String item_desc ="";
                    String uom ="";
                    String qty ="";
                    String remark ="";
                    int i=0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        if(i==1)
                        {
                            try
                            {
                                srNo = cell.getNumericCellValue() + "";
                            }
                            catch(Exception e1)
                            {
                                srNo = cell.getStringCellValue();
                            }
                        }
                        if(i==2)
                        {
                            try
                            {
                                item_code = cell.getNumericCellValue() + "";
                            }
                            catch(Exception e1)
                            {
                                item_code = cell.getStringCellValue();
                            }
                            
                        }
                        if(i==3)
                        {
                            item_name = cell.getStringCellValue();
                        }
                        if(i==4)
                        {
                            item_desc = cell.getStringCellValue();
                            remark = item_desc;
                        }
                        if(i==5)
                        {
                            uom = cell.getStringCellValue();
                        }
                        if(i==6)
                        {
                            try
                            {
                                qty = cell.getNumericCellValue() + "";
                            }
                            catch(Exception e1)
                            {
                                qty = cell.getStringCellValue();
                            }
                            
                        }
                        
                
                    }
                    
                    //insert data
                    
                    AuctionItemMaster auctionItemMaster = new AuctionItemMaster();
                    auctionItemMaster.setAuctionNo(ref_no);
                    auctionItemMaster.setSrNo(srNo);
                    auctionItemMaster.setItemCode(item_code);
                    auctionItemMaster.setItemName(item_name);
                    auctionItemMaster.setItemDesc(item_desc);
                    auctionItemMaster.setItemRemark(remark);
                    auctionItemMaster.setUom(uom);
                    auctionItemMaster.setQty(qty);
                    
                    auctionItemMasterService.create(auctionItemMaster);
                    
                    
                  
               
                    }
                  System.out.println("");
                }
              }
              catch(Exception e) {
                e.printStackTrace();
                request.setAttribute("failureMessage",
                    "Information: Problem in file uploading");
              }
        
        request.setAttribute("successMessage",
                    "Information: File Upload successfully");
        
        
        
        
        List itemDetail = auctionItemMasterService.readRefNo(ref_no);
                
                
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String department = employeeMaster.getDepartment();
        String location = employeeMaster.getLocation();
        
       
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("itemDetail", itemDetail);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.setViewName("Auction/AddAuctionItemDocument");
        return mv;
    }
    
    public ModelAndView deleteItemDocument(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
        
        
        String[] checkId = request.getParameterValues("checkedIdd");
        for (String checkedValues : checkId) {
    
            auctionItemMasterService.delete(Integer.parseInt(checkedValues));
            
        }
        
        List itemDetail = auctionItemMasterService.readRefNo(ref_no);
                
                
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String department = employeeMaster.getDepartment();
        String location = employeeMaster.getLocation();
        
       
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("itemDetail", itemDetail);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.setViewName("Auction/AddAuctionItemDocument");
        return mv;
    }
    
    public ModelAndView agaxAuctionItemDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("q");
        String ref_no = request.getParameter("q");
        
        List itemDetail = auctionItemMasterService.readRefNo(ref_no);
        mv.getModelMap().put("itemDetail", itemDetail);
        
        
        
        
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.setViewName("Auction/AgaxAuctionItemDetails");
        return mv;
    }
    
    public ModelAndView addAuctionGeneralFileDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        
        List generalDocument  = auctionAttachmentService.readAuctionGeneralDoc(ref_no);
   
        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AddAuctionGeneralFileDetails");
        return mv;
    }
    
    public ModelAndView addAuctionGeneralFileDetailsSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        
        String path=getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no;
        File f1 = new File(path);  
        boolean bool = f1.mkdir();
        
        
            String generalfile = request.getParameter("generalfile");if(generalfile == null)generalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("generalfile");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(generalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(ref_no);
                auctionAttachment.setAttachmentDoc(generalfile);
                auctionAttachment.setAttachmentType(0);
                auctionAttachment.setRfqNo(ref_no);
                auctionAttachmentService.create(auctionAttachment);
            }
        
        
        
        List generalDocument  = auctionAttachmentService.readAuctionGeneralDoc(ref_no);
   
        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AddAuctionGeneralFileDetails");
        return mv;
    }
    
    public ModelAndView auctionGeneralFileDetailsDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String id = request.getParameter("id");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        
        auctionAttachmentService.delete(Integer.parseInt(id));
        
        List generalDocument  = auctionAttachmentService.readAuctionGeneralDoc(ref_no);
   
        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AddAuctionGeneralFileDetails");
        return mv;
    }
    
    public ModelAndView addAuctionAdditionalFileDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        
        List additionalDocument  = auctionAttachmentService.readAuctionAdditionalDoc(ref_no);
   
        mv.getModelMap().put("additionalDocument", additionalDocument);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AddAuctionAdditionalFileDetails");
        return mv;
    }
    
    public ModelAndView addAuctionAdditionalFileDetailsSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        
        String path=getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no;
        File f1 = new File(path);  
        boolean bool = f1.mkdir();
        
        
            String generalfile = request.getParameter("generalfile");if(generalfile == null)generalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("generalfile");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(generalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(ref_no);
                auctionAttachment.setAttachmentDoc(generalfile);
                auctionAttachment.setAttachmentType(1);
                auctionAttachment.setRfqNo(ref_no);
                auctionAttachmentService.create(auctionAttachment);
            }
        
        
        
        List additionalDocument  = auctionAttachmentService.readAuctionAdditionalDoc(ref_no);
   
        mv.getModelMap().put("additionalDocument", additionalDocument);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AddAuctionAdditionalFileDetails");
        return mv;
    }
    
    public ModelAndView auctionAdditionalFileDetailsDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String id = request.getParameter("id");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        
        auctionAttachmentService.delete(Integer.parseInt(id));
        
        List additionalDocument  = auctionAttachmentService.readAuctionAdditionalDoc(ref_no);
   
        mv.getModelMap().put("additionalDocument", additionalDocument);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AddAuctionAdditionalFileDetails");
        return mv;
    }
    
    public ModelAndView addAuctionTechnicalFileDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        
        List technicalDocument  = auctionAttachmentService.readAuctionTechnicalDoc(ref_no);
   
        mv.getModelMap().put("technicalDocument", technicalDocument);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AddAuctionTechnicalFileDetails");
        return mv;
    }
    
    public ModelAndView addAuctionTechnicalFileDetailsSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        
        String path=getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no;
        File f1 = new File(path);  
        boolean bool = f1.mkdir();
        
        
            String generalfile = request.getParameter("generalfile");if(generalfile == null)generalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("generalfile");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(generalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(ref_no);
                auctionAttachment.setAttachmentDoc(generalfile);
                auctionAttachment.setAttachmentType(2);
                auctionAttachment.setRfqNo(ref_no);
                auctionAttachmentService.create(auctionAttachment);
            }
        
        
        
        List technicalDocument  = auctionAttachmentService.readAuctionTechnicalDoc(ref_no);
   
        mv.getModelMap().put("technicalDocument", technicalDocument);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AddAuctionTechnicalFileDetails");
        return mv;
    }
    
    public ModelAndView auctionTechnicalFileDetailsDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String id = request.getParameter("id");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String employee_code = user.getLoginName();
        
        auctionAttachmentService.delete(Integer.parseInt(id));
        
        List technicalDocument  = auctionAttachmentService.readAuctionTechnicalDoc(ref_no);
   
        mv.getModelMap().put("technicalDocument", technicalDocument);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AddAuctionTechnicalFileDetails");
        return mv;
    }
    
    public ModelAndView agaxAuctionGeneralFileDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("q");
        String ref_no = request.getParameter("q");
        String service = request.getParameter("service");
        
        List generalDocument  = auctionAttachmentService.readAuctionGeneralDoc(ref_no);
   
        mv.getModelMap().put("generalDocument", generalDocument);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AgaxAuctionGeneralFileDetails");
        return mv;
    }
    
    public ModelAndView agaxAuctionAdditionalFileDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("q");
        String ref_no = request.getParameter("q");
        String service = request.getParameter("service");
        
        List additionalDocument  = auctionAttachmentService.readAuctionAdditionalDoc(ref_no);
   
        mv.getModelMap().put("additionalDocument", additionalDocument);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AgaxAuctionAdditionalFileDetails");
        return mv;
    }
    
    public ModelAndView agaxAuctionTechnicalFileDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("q");
        String ref_no = request.getParameter("q");
        String service = request.getParameter("service");
        
        List technicalDocument  = auctionAttachmentService.readAuctionTechnicalDoc(ref_no);
   
        mv.getModelMap().put("technicalDocument", technicalDocument);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Auction/AgaxAuctionTechnicalFileDetails");
        return mv;
    }
    
    
    public ModelAndView searchVendorForAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        List auctionVendor1 = auctionVendorService.readByRefNo(ref_no);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("Auction/SearchVendorForAuction");
        return mv;
    }
    
    public ModelAndView searchVendorForAuctionSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String vendor_code = request.getParameter("vendor_code");
        String vendor_name = request.getParameter("vendor_name");
        String ref_no = request.getParameter("ref_no");
        
        List vendorMaster = vendorMasterService.readByCodeName(vendor_code, vendor_name);
        
        List auctionVendor1 = auctionVendorService.readByRefNo(ref_no);
        
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        mv.getModelMap().put("vendorMaster", vendorMaster);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("Auction/SearchVendorForAuction");
        return mv;
    }
    
    public ModelAndView addVendorForAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
        String vendor_code = "";
        String vendor_name = "";
        String email_id = "";
        String mobile_no= "";
        String address= "";
        //checkedId
        String[] checkId = request.getParameterValues("checkedId");
        for (String checkedValues : checkId) {
            
            VendorMaster vendorMaster = vendorMasterService.read(checkedValues);
            vendor_code = vendorMaster.getVendorRegNo();
            vendor_name = vendorMaster.getVendorName();
            email_id = vendorMaster.getVendorEmailID();
            mobile_no = vendorMaster.getVendorMobNo();
            address = vendorMaster.getVendorAddressLine1();
            
            List auctionVendor1 = auctionVendorService.readByRefVendor(ref_no, vendor_code);
            
            if(auctionVendor1.isEmpty())
            {
                AuctionVendor auctionVendor = new AuctionVendor();
                auctionVendor.setAuctionNo(ref_no);
                auctionVendor.setVendorCode(vendor_code);
                auctionVendor.setVendorName(vendor_name);
                auctionVendor.setAddress(address);
                auctionVendor.setEmailId(email_id);
                auctionVendor.setMobileNo(mobile_no);
                auctionVendorService.create(auctionVendor);
            }
            else
            {
                request.setAttribute("failureMessage",
                    "Information: Vendor already added");
            }
            
        }
        
        List auctionVendor1 = auctionVendorService.readByRefNo(ref_no);
            
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("Auction/SearchVendorForAuction");
        return mv;
    }
    
    public ModelAndView deleteVendorForAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
        //checkedId
        String[] checkId = request.getParameterValues("checkedIdd");
        for (String checkedValues : checkId) {
    
            auctionVendorService.delete(Integer.parseInt(checkedValues));
            
        }
        
        List auctionVendor1 = auctionVendorService.readByRefNo(ref_no);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("Auction/SearchVendorForAuction");
        return mv;
    }
    
    public ModelAndView agaxAuctionVendorDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String ref_no = request.getParameter("q");
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        List auctionVendor1 = auctionVendorService.readByRefNo(ref_no);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/AgaxAuctionVendorDetails");
        return mv;
    }
    
    public ModelAndView uploadExcelVendorForAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        List auctionVendor1 = auctionVendorService.readByRefNo(ref_no);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("Auction/UploadExcelForAuction");
        return mv;
    }
    
    public ModelAndView uploadExcelVendorForAuctionSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
        
        
        
        
        String path=getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no;
        File f1 = new File(path);  
        boolean bool = f1.mkdir();
        
        
        String technicalfile = request.getParameter("technicalfile");if(technicalfile == null)technicalfile="";
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("technicalfile");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + ref_no + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    technicalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        
            ArrayList<PreQualificationExcel> al=new ArrayList<PreQualificationExcel>();
            //read excel file
            
            try {
                File file = new File(getServletContext().getRealPath("/")+"/StorageYard/Auction/"+ref_no + "/" + technicalfile);
                //creating a new file instance  
                FileInputStream fis = new FileInputStream(file);
                //obtaining bytes from the file  
                //creating Workbook instance that refers to .xlsx file  
                XSSFWorkbook wb = new XSSFWorkbook(fis);
                XSSFSheet sheet = wb.getSheetAt(0);
                //creating a Sheet object to retrieve object  
                Iterator < Row > itr = sheet.iterator();
                //iterating over excel file
                System.out.println("The given file is");
                int j = 0;
                while (itr.hasNext()) {
                    j++;
                    
                    Row row = itr.next();
                    Iterator < Cell > cellIterator = row.cellIterator();
                    //iterating over each column  
                    if(j>=2)
                    {
                        String srNo ="";
                        String desc ="";
                        String comp ="";
                        String vendor_code = "";
                        String vendor_name = "";
                        String email_id = "";
                        String mobile_no= "";
                        String address= "";
                        String vendorBasicStartPrice= "";
                        String loadingFactorPer = "";
                        String loadingFactorVal = "";
                        String finalPrice = "";
                                                                                
                        
                        int i=0;
                        while (cellIterator.hasNext()) {
                            i++;
                            Cell cell = cellIterator.next();
                            if(i==1)
                            {
                                srNo = cell.getNumericCellValue() + "";
                            }
                            if(i==2)
                            {
                                vendor_code = cell.getStringCellValue();
                            }
                            if(i==7)
                            {
                                try
                                {
                                    vendorBasicStartPrice = cell.getNumericCellValue() + "";
                                }
                                catch(Exception e1)
                                {
                                    vendorBasicStartPrice = cell.getStringCellValue();
                                }
                            }
                            if(i==8)
                            {
                                try
                                {
                                    loadingFactorPer = cell.getNumericCellValue() + "";
                                }
                                catch(Exception e1)
                                {
                                    loadingFactorPer = cell.getStringCellValue();
                                }
                            }
                            if(i==9)
                            {
                                try
                                {
                                    loadingFactorVal = cell.getNumericCellValue() + "";
                                }
                                catch(Exception e1)
                                {
                                    loadingFactorVal = cell.getStringCellValue();
                                }
                            }
                            if(i==10)
                            {
                                try
                                {
                                    finalPrice = cell.getNumericCellValue() + "";
                                }
                                catch(Exception e1)
                                {
                                    finalPrice = cell.getStringCellValue();
                                }
                            }
                            

                        }
                        
                        //----------------------
                        
                        VendorMaster vendorMaster = vendorMasterService.read(vendor_code);
                        vendor_code = vendorMaster.getVendorRegNo();
                        vendor_name = vendorMaster.getVendorName();
                        email_id = vendorMaster.getVendorEmailID();
                        mobile_no = vendorMaster.getVendorMobNo();
                        address = vendorMaster.getVendorAddressLine1();

                        List auctionVendor1 = auctionVendorService.readByRefVendor(ref_no, vendor_code);

                        if(auctionVendor1.isEmpty())
                        {
                            AuctionVendor auctionVendor = new AuctionVendor();
                            auctionVendor.setAuctionNo(ref_no);
                            auctionVendor.setVendorCode(vendor_code);
                            auctionVendor.setVendorName(vendor_name);
                            auctionVendor.setAddress(address);
                            auctionVendor.setEmailId(email_id);
                            auctionVendor.setMobileNo(mobile_no);
                            auctionVendor.setVendorBasicStartPrice(vendorBasicStartPrice);
                            auctionVendor.setLoadingFactorPer(loadingFactorPer);
                            auctionVendor.setLoadingFactorVal(loadingFactorVal);
                            auctionVendor.setFinalPrice(finalPrice);
                            auctionVendorService.create(auctionVendor);
                            
                        }
            
                  
                    

                    }
                  System.out.println("");
                }
              }
              catch(Exception e) {
                e.printStackTrace();
              }
        
        
        
        List auctionVendor1 = auctionVendorService.readByRefNo(ref_no);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("ref_no", ref_no);
        mv.setViewName("Auction/UploadExcelForAuction");
        return mv;
    }
    
    public ModelAndView liveAuctionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        int authuser = userRights.getAuthorizeTender();
        
        
        if(authuser == 0)
        {
            List list = auctionMasterService.liveAuctionList(username, location, department);
            
            List list2 = auctionMasterService.liveAuctionUnautorizeList(username, location, department);

            request.setAttribute("list", list);

            mv.getModelMap().put("list", list);
            mv.getModelMap().put("list2", list2);
        }
        else
        {
            List list = auctionMasterService.liveAuctionAuthorizerList(username, location, department);
            
            List list2 = auctionMasterService.liveAuctionUnautorizeList(username, location, department);
            request.setAttribute("list", list);

            mv.getModelMap().put("list", list);
            mv.getModelMap().put("list2", list2);
        }
        mv.getModelMap().put("authuser", authuser);
        
        mv.setViewName("Auction/LiveAuctionList");
        return mv;
    }
    
    public ModelAndView closeAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auction_no", auction_no);
        mv.setViewName("Auction/CloseAuction");
        return mv;
    }
    
    public ModelAndView closeAuctionSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String remark = request.getParameter("remark");
        
        auctionMasterService.updateCloseAuction(auction_no, remark);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auction_no", auction_no);
        mv.setViewName("Auction/CloseAuction");
        return mv;
    }
    
    public ModelAndView pendingAuthorize(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        List list = auctionMasterService.unauthorizeAuction(username, location, department);
        
        List list2 = auctionMasterService.unauthorizeEmailAuction(username, location, department);
        
        request.setAttribute("list", list);
        
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/PendingAuthorize");
        return mv;
    }
    
    public ModelAndView authorizeView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
    //    String tenderPhase = request.getParameter("tenderPhase");
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        String refNo = auctionMaster.getAuctionNo();
        String emd = auctionMaster.getEmd();
        String doc_cost = auctionMaster.getDocCost();
        String auction_remark = auctionMaster.getAuctionRemark();
        String submitLastdate = auctionMaster.getBiddingEnddate();
        String type = auctionMaster.getType();
        String biddingType =auctionMaster.getBiddingType();
        
        //Get attachment of tender
        List generalDocs = auctionAttachmentService.readAuctionGeneralDoc(refNo);
        List additionalDocs = auctionAttachmentService.readAuctionAdditionalDoc(refNo);
        List technicalDocs = auctionAttachmentService.readAuctionTechnicalDoc(refNo);
        
        List tenderItemMaster = tenderItemMasterService.readByRefNo(refNo);
        List tenderVendor = tenderVendorService.readByRefNo(refNo);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("tenderVendor", tenderVendor);
        mv.getModelMap().put("biddingType", biddingType);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auction_remark", auction_remark);
        mv.getModelMap().put("auctionNo", refNo);
        mv.getModelMap().put("type", type);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        
        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        
        mv.setViewName("Auction/AuthorizeView");
        return mv;
    }
    
    public void downloadAuctionFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");
        String RefNo = request.getParameter("RefNo");


        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Auction"
                + File.separator + RefNo + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }
    
    public ModelAndView deleteAttachmentDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
    //    String tenderPhase = request.getParameter("tenderPhase");
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        
        String docid = request.getParameter("docid");
        auctionAttachmentService.delete(Integer.parseInt(docid));
        
        
        
        mv.setViewName("forward:auctionMaster.htm?act=authorizeView&id="+id);
        return mv;
    }
    
    public ModelAndView deleteRecycleAttachmentDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
    //    String tenderPhase = request.getParameter("tenderPhase");
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        
        String docid = request.getParameter("docid");
        auctionAttachmentService.delete(Integer.parseInt(docid));
        
        
        
        mv.setViewName("forward:auctionMaster.htm?act=recycleView&id="+id);
        return mv;
    }
    
    public ModelAndView deleteCorrigendumViewAttachmentDoc(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
    //    String tenderPhase = request.getParameter("tenderPhase");
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        
        String docid = request.getParameter("docid");
        auctionAttachmentService.delete(Integer.parseInt(docid));
        
        
        
        mv.setViewName("forward:auctionMaster.htm?act=corrigendumView&id="+id);
        return mv;
    }
    
    public ModelAndView submitAuthorizeView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        String full_name = employeeMaster.getName();
        String contact_no = employeeMaster.getPhNo();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        String id = request.getParameter("id");
        String refNo = request.getParameter("auctionNo");
        String title = request.getParameter("title");
        String value = request.getParameter("value");
        String categoryId = request.getParameter("categoryId");
        String docCost = request.getParameter("docCost");
        String emd = request.getParameter("emd");
        String submitLastdate = request.getParameter("biddingEnddate");
        String submitLastdate1 = request.getParameter("biddingEnddate1");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date d1 = sdf.parse(submitLastdate1);
        Date d2 = sdf.parse(submitLastdate);
        
        long difference_In_Time
                = d2.getTime() - d1.getTime();
        
        if(difference_In_Time < 0)
        {
            request.setAttribute("failureMessage",
                    "Information: Auction Due Date con not be less than current due date"); 
            
            mv.setViewName("forward:auctionMaster.htm?act=authorizeView&id="+id);
            return mv;
        }
        String workDesc = request.getParameter("workDesc");
        String prNo = request.getParameter("prNo");
        String remark = request.getParameter("remark");
        
        String lastBiddingTime = request.getParameter("lastBiddingTime");
        String extendTime = request.getParameter("extendTime");
        String extendTimeNo = request.getParameter("extendTimeNo");
        String autoDecIncAmount = request.getParameter("autoDecIncAmount");
        String refreshRate = request.getParameter("refreshRate");
        String bidding_display = request.getParameter("bidding_display");
        
        
        
        
        //attach general document
        
        //int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        int otherDetailCount = 0;
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile" + i);if(generalfile == null)generalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("generalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(generalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(generalfile);
                auctionAttachment.setAttachmentType(0);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        //attach additional document
        
        int otherDetailCount1 = 0;
        //int otherDetailCount1 = Integer.parseInt(request.getParameter("policyCount1"));
        for (int i = 1; i <= otherDetailCount1; i++) {
            String additionalfile = request.getParameter("additionalfile" + i);if(additionalfile == null)additionalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("additionalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    additionalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(additionalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(additionalfile);
                auctionAttachment.setAttachmentType(1);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        
        //attach technical document technical
        
        int otherDetailCount2 = 0;
        //int otherDetailCount2 = Integer.parseInt(request.getParameter("policyCount2"));
        for (int i = 1; i <= otherDetailCount2; i++) {
            String technicalfile = request.getParameter("technicalfile" + i);if(technicalfile == null)technicalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("technicalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    technicalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(technicalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(technicalfile);
                auctionAttachment.setAttachmentType(1);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        
        // update in item table
        
        
        
        // update vendor details
        
        //String[] checkVendorId = request.getParameterValues("checkVendorId");
        String[] vendor_code = request.getParameterValues("vendor_code");
        String[] email_id = request.getParameterValues("email_id");
        String[] mobile_no = request.getParameterValues("mobile_no");
        String[] start_price = request.getParameterValues("start_price");
        String[] loading_factor_per = request.getParameterValues("loading_factor_per");
        String[] loading_factor_val = request.getParameterValues("loading_factor_val");
        String[] final_price = request.getParameterValues("final_price");
        
        int j=0;
        try
        {
        for(int i=0;i<vendor_code.length;i++){
            j++;
            String checkVendorId = "1";
            
            auctionVendorService.updateRefNo(refNo, refNo, vendor_code[i], email_id[i], mobile_no[i], start_price[i], loading_factor_per[i], loading_factor_val[i], final_price[i], 1);
            
            if(checkVendorId.equals("1"))
            {
                //email send to authorizser
                
                UserMaster userMaster = userMasterService.read(vendor_code[i]);
                String password = userMaster.getPassword();

                AuctionMaster auctionMaster11 = auctionMasterService.readById(Integer.parseInt(id));
                String announceDate = auctionMaster11.getBiddingStartdate();
                

                List employeeMaster1 = employeeMasterService.readAuthorizserUser(location,department);

                String subject = "";
                String msg = "";
                String mail_from = "";
                String mail_to = "";
                
                mail_to = email_id[i];
                String mail_to1[]=mail_to.split(",");
                    
                for(int ml=0;ml<mail_to1.length;ml++)
                {
                    mail_to=mail_to1[ml];

                    if(password.equals("Sumul@123"))
                    {
                        EmailTemplate emailTemplate = emailTemplateService.readById(20);

                        subject = emailTemplate.getSubject();
                        msg = emailTemplate.getBodytext();
                    }
                    else
                    {
                        EmailTemplate emailTemplate = emailTemplateService.readById(20);

                        subject = emailTemplate.getSubject();
                        msg = emailTemplate.getBodytext();
                    }
                    

                
                    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

                    msg = msg.replaceAll("\\{tender_title\\}", title.toUpperCase());
                    msg = msg.replaceAll("\\{ref_no\\}", refNo);
                    msg = msg.replaceAll("\\{start_date\\}", announceDate);
                    msg = msg.replaceAll("\\{end_date\\}", submitLastdate);
                    msg = msg.replaceAll("\\{fee\\}", docCost);
                    msg = msg.replaceAll("\\{vendor_code\\}", vendor_code[i]);
                    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
                    msg = msg.replaceAll("\\{department\\}", department);


                    SendMail s = new SendMail();
                    s.sendMail(mail_from, mail_to, subject, msg);
                }
            }
        }
        }catch(Exception e11){}
        
        
        auctionMasterService.authorizeAuction(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark, lastBiddingTime, extendTime, extendTimeNo, autoDecIncAmount, refreshRate, bidding_display);

        //HttpSession session = request.getSession(false);
            UserMaster user11 = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Auction Authorize with auction no "+refNo+"").setDrow("Y");
            logService.create(lm);
            
            
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            
            TenderFollowup tenderFollowup = new TenderFollowup();
            tenderFollowup.setActivityDate(formattedDate);
            tenderFollowup.setActivity("Auction Authorize with auction no "+refNo+"");
            tenderFollowup.setLocation(location);
            tenderFollowup.setTenderNo(refNo);
            tenderFollowup.setPerson(user11.getLoginName());
            tenderFollowup.setPersonFullname(user11.getUserFullName());
     //       tenderFollowupService.create(tenderFollowup);
            
    
            request.setAttribute("successMessage",
                    "Information: Auction No: "+refNo+" Authorize successfully");
            
            
       // List list = tenderMasterService.unauthorizeTender(username, location, department);
        
        //request.setAttribute("list", list);
        
        //mv.getModelMap().put("list", list);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("forward:auctionMaster.htm?act=pendingAuthorize");
        return mv;
    }
    
    public ModelAndView rejectAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        //AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        String full_name = employeeMaster.getName();
        String contact_no = employeeMaster.getPhNo();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        String id = request.getParameter("id");
        String refNo = request.getParameter("auctionNo");
        String title = request.getParameter("title");
        String value = request.getParameter("value");
        String categoryId = request.getParameter("categoryId");
        String docCost = request.getParameter("docCost");
        String emd = request.getParameter("emd");
        String submitLastdate = request.getParameter("biddingEnddate");
        String submitLastdate1 = request.getParameter("biddingEnddate1");
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(refNo);
        auctionMaster.setAuthorizeFlag(3);
        auctionMasterService.update(auctionMaster);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date d1 = sdf.parse(submitLastdate1);
        Date d2 = sdf.parse(submitLastdate);
        
        // update vendor details
        
        //String[] checkVendorId = request.getParameterValues("checkVendorId");
        
        
        
        //HttpSession session = request.getSession(false);
            UserMaster user11 = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Auction Rejected with auction no "+refNo+"").setDrow("Y");
            logService.create(lm);
            
            
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            
            TenderFollowup tenderFollowup = new TenderFollowup();
            tenderFollowup.setActivityDate(formattedDate);
            tenderFollowup.setActivity("Auction Rejected with auction no "+refNo+"");
            tenderFollowup.setLocation(location);
            tenderFollowup.setTenderNo(refNo);
            tenderFollowup.setPerson(user11.getLoginName());
            tenderFollowup.setPersonFullname(user11.getUserFullName());
     //       tenderFollowupService.create(tenderFollowup);
            
    
            request.setAttribute("successMessage",
                    "Information: Auction No: "+refNo+" Reject successfully");
            
            
       // List list = tenderMasterService.unauthorizeTender(username, location, department);
        
        //request.setAttribute("list", list);
        
        //mv.getModelMap().put("list", list);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("forward:auctionMaster.htm?act=pendingAuthorize");
        return mv;
    }
    
    public ModelAndView receivedAuctionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        int authuser = userRights.getAuthorizeTender();
        
        
                List list = auctionMasterService.receiveAuctionList(username, location, department);
            request.setAttribute("list", list);

            mv.getModelMap().put("list", list);
            
        mv.getModelMap().put("authuser", authuser);
        
        mv.setViewName("Auction/ReceiveAuctionList");
        return mv;
    }
    
    public ModelAndView receivedAuctionView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        int authuser = userRights.getAuthorizeTender();
        
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        String refNo = auctionMaster.getAuctionNo();
        String type = auctionMaster.getType();
        
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        Date d11 = sdf.parse(biddingEnddate);
        long difference_In_Time
                = d11.getTime() - date.getTime();
        mv.getModelMap().put("difference_In_Time", difference_In_Time);
        
        if(type.equals("Reverse"))
        {
            List auctionVendorBid = auctionVendorBidService.readByReverseAuction(refNo);
            mv.getModelMap().put("auctionVendorBid", auctionVendorBid);
        }
        else
        {
            List auctionVendorBid = auctionVendorBidService.readByForwardAuction(refNo);
            mv.getModelMap().put("auctionVendorBid", auctionVendorBid);
        }
        
        String vendor_code = "";
        List auctionVendor = auctionVendorService.readByRefNo(refNo);
        
        mv.getModelMap().put("auctionVendor", auctionVendor);
        
        for (Object o : auctionVendor) {
            //i++;
            AuctionVendor av = (AuctionVendor) o;
            vendor_code = av.getVendorCode();
            
            List auctionVendorBid = auctionVendorBidService.readByAuctionNo(refNo, vendor_code);
            
            
        }
        
            List list = auctionMasterService.liveAuctionList(username, location, department);
            request.setAttribute("list", list);

            mv.getModelMap().put("list", list);
            
        mv.getModelMap().put("authuser", authuser);
        mv.getModelMap().put("refNo", refNo);
        
        mv.setViewName("Auction/ReceiveAuctionView");
        return mv;
    }
    
    public ModelAndView receivedAuctionView1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        int authuser = userRights.getAuthorizeTender();
        
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        String refNo = auctionMaster.getAuctionNo();
        String type = auctionMaster.getType();
        
        List auctionItemMaster = auctionItemMasterService.readByAuctionId(refNo);
        
        mv.getModelMap().put("auctionItemMaster", auctionItemMaster);
        
        
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        Date d11 = sdf.parse(biddingEnddate);
        long difference_In_Time
                = d11.getTime() - date.getTime();
        mv.getModelMap().put("difference_In_Time", difference_In_Time);
        
        if(type.equals("Reverse"))
        {
            List auctionVendorBid = auctionVendorBidService.readByReverseAuction(refNo);
            mv.getModelMap().put("auctionVendorBid", auctionVendorBid);
        }
        else
        {
            List auctionVendorBid = auctionVendorBidService.readByForwardAuction(refNo);
            mv.getModelMap().put("auctionVendorBid", auctionVendorBid);
        }
        
        String vendor_code = "";
        List auctionVendor = auctionVendorService.readByRefNo(refNo);
        
        mv.getModelMap().put("auctionVendor", auctionVendor);
        
        for (Object o : auctionVendor) {
            //i++;
            AuctionVendor av = (AuctionVendor) o;
            vendor_code = av.getVendorCode();
            
            List auctionVendorBid = auctionVendorBidService.readByAuctionNo(refNo, vendor_code);
            
            
        }
        
            List list = auctionMasterService.liveAuctionList(username, location, department);
            request.setAttribute("list", list);

            mv.getModelMap().put("list", list);
            
            mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("authuser", authuser);
        mv.getModelMap().put("refNo", refNo);
        
        
        int auction_price_approval_id=0;
        AuctionPriceApproval auctionPriceApproval12 = auctionPriceApprovalService.readByList(refNo);
        auction_price_approval_id = auctionPriceApproval12.getId();
        List list2 = auctionPriceApprovalCommentService.readByRefNo(auction_price_approval_id);
        mv.getModelMap().put("list3", list2);
        mv.getModelMap().put("auctionPriceApproval", auctionPriceApproval12);
        
        mv.setViewName("Auction/ReceiveAuctionView1");
        return mv;
    }
    
    public ModelAndView vendorAuctionHistoryView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        int authuser = userRights.getAuthorizeTender();
        
        String id = request.getParameter("id");
            
        String vendor_code = request.getParameter("vendorCode");
        String auction_no = request.getParameter("auction_no");
        
        List list = auctionVendorBidHistoryService.readVendorHistory(auction_no, vendor_code);
        
        
        
            request.setAttribute("list", list);

            mv.getModelMap().put("list", list);
            
        mv.getModelMap().put("authuser", authuser);
        mv.getModelMap().put("auction_no", auction_no);
        
        mv.setViewName("Auction/VendorAuctionHistoryView");
        return mv;
    }
    
    public ModelAndView liveAuctionSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        int authuser = userRights.getAuthorizeTender();
        
        
            List list = auctionMasterService.liveAuctionList1(username, location, department);
            request.setAttribute("list", list);

            mv.getModelMap().put("list", list);
            
        mv.getModelMap().put("authuser", authuser);
        
        mv.setViewName("Auction/LiveAuctionSearch");
        return mv;
    }
    
    public ModelAndView liveAuctionView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
    //    String tenderPhase = request.getParameter("tenderPhase");
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        String refNo = auctionMaster.getAuctionNo();
        String emd = auctionMaster.getEmd();
        String doc_cost = auctionMaster.getDocCost();
        String auction_remark = auctionMaster.getAuctionRemark();
        String submitLastdate = auctionMaster.getBiddingEnddate();
        String type = auctionMaster.getType();
        
        //Get attachment of tender
        List generalDocs = auctionAttachmentService.readAuctionGeneralDoc(refNo);
        List additionalDocs = auctionAttachmentService.readAuctionAdditionalDoc(refNo);
        List technicalDocs = auctionAttachmentService.readAuctionTechnicalDoc(refNo);
        
        List tenderItemMaster = tenderItemMasterService.readByRefNo(refNo);
        List tenderVendor = tenderVendorService.readByRefNo(refNo);
        
        List auctionVendor = auctionVendorService.readByRefNo(refNo);
        List auctionVendorBid = auctionVendorBidService.readByReverseAuctionRank(refNo);

        mv.getModelMap().put("auctionVendor", auctionVendor);
        mv.getModelMap().put("auctionVendorBid", auctionVendorBid);
        
        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("tenderVendor", tenderVendor);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auction_remark", auction_remark);
        mv.getModelMap().put("auctionNo", refNo);
        mv.getModelMap().put("type", type);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        
        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        
        mv.setViewName("Auction/LiveAuctionView");
        return mv;
    }
    
    public ModelAndView recycleAuctionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        List list = auctionMasterService.recycleAuction(username, location, department);
        
        request.setAttribute("list", list);
        
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/RecycleAuctionList");
        return mv;
    }
    
    public ModelAndView recycleView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
    //    String tenderPhase = request.getParameter("tenderPhase");
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        String refNo = auctionMaster.getAuctionNo();
        String emd = auctionMaster.getEmd();
        String doc_cost = auctionMaster.getDocCost();
        String auction_remark = auctionMaster.getAuctionRemark();
        String submitLastdate = auctionMaster.getBiddingEnddate();
        String type = auctionMaster.getType();
        
        //Get attachment of tender
        List generalDocs = auctionAttachmentService.readAuctionGeneralDoc(refNo);
        List additionalDocs = auctionAttachmentService.readAuctionAdditionalDoc(refNo);
        List technicalDocs = auctionAttachmentService.readAuctionTechnicalDoc(refNo);
        
        List tenderItemMaster = tenderItemMasterService.readByRefNo(refNo);
        List tenderVendor = tenderVendorService.readByRefNo(refNo);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("tenderVendor", tenderVendor);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auction_remark", auction_remark);
        mv.getModelMap().put("auctionNo", refNo);
        mv.getModelMap().put("type", type);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        
        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        
        mv.setViewName("Auction/RecycleView");
        return mv;
    }
    
    public ModelAndView submitRecycleView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        String full_name = employeeMaster.getName();
        String contact_no = employeeMaster.getPhNo();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        String id = request.getParameter("id");
        String refNo = request.getParameter("auctionNo");
        String title = request.getParameter("title");
        String value = request.getParameter("value");
        String categoryId = request.getParameter("categoryId");
        String docCost = request.getParameter("docCost");
        String emd = request.getParameter("emd");
        String submitLastdate = request.getParameter("biddingEnddate");
        String submitLastdate1 = request.getParameter("biddingEnddate1");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date d1 = sdf.parse(submitLastdate1);
        Date d2 = sdf.parse(submitLastdate);
        
        long difference_In_Time
                = d2.getTime() - d1.getTime();
        
        if(difference_In_Time < 0)
        {
            request.setAttribute("failureMessage",
                    "Information: Auction Due Date con not be less than current due date"); 
            
            mv.setViewName("forward:auctionMaster.htm?act=recycleView&id="+id);
            return mv;
        }
        String workDesc = request.getParameter("workDesc");
        String prNo = request.getParameter("prNo");
        String remark = request.getParameter("remark");
        
        String lastBiddingTime = request.getParameter("lastBiddingTime");
        String extendTime = request.getParameter("extendTime");
        String extendTimeNo = request.getParameter("extendTimeNo");
        String autoDecIncAmount = request.getParameter("autoDecIncAmount");
        String refreshRate = request.getParameter("refreshRate");
        String bidding_display = request.getParameter("bidding_display");
        
        
        
        
        //attach general document
        
        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile" + i);if(generalfile == null)generalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("generalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(generalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(generalfile);
                auctionAttachment.setAttachmentType(0);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        //attach additional document
        
        int otherDetailCount1 = Integer.parseInt(request.getParameter("policyCount1"));
        for (int i = 1; i <= otherDetailCount1; i++) {
            String additionalfile = request.getParameter("additionalfile" + i);if(additionalfile == null)additionalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("additionalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    additionalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(additionalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(additionalfile);
                auctionAttachment.setAttachmentType(1);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        
        //attach technical document technical
        
        int otherDetailCount2 = Integer.parseInt(request.getParameter("policyCount2"));
        for (int i = 1; i <= otherDetailCount2; i++) {
            String technicalfile = request.getParameter("technicalfile" + i);if(technicalfile == null)technicalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("technicalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    technicalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(technicalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(technicalfile);
                auctionAttachment.setAttachmentType(1);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        
        // update in item table
        
        
        
        // update vendor details
        
        //String[] checkVendorId = request.getParameterValues("checkVendorId");
        String[] vendor_code = request.getParameterValues("vendor_code");
        String[] email_id = request.getParameterValues("email_id");
        String[] mobile_no = request.getParameterValues("mobile_no");
        String[] start_price = request.getParameterValues("start_price");
        String[] loading_factor_per = request.getParameterValues("loading_factor_per");
        String[] loading_factor_val = request.getParameterValues("loading_factor_val");
        String[] final_price = request.getParameterValues("final_price");
        
        int j=0;
        try
        {
        for(int i=0;i<vendor_code.length;i++){
            j++;
            String checkVendorId = "1";
            
            auctionVendorService.updateRefNo(refNo, refNo, vendor_code[i], email_id[i], mobile_no[i], start_price[i], loading_factor_per[i], loading_factor_val[i], final_price[i], 1);
            
            
        }
        }catch(Exception e11){}
        
        
        auctionMasterService.recycleAuctionSubmit(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark, lastBiddingTime, extendTime, extendTimeNo, autoDecIncAmount, refreshRate, bidding_display);

        //HttpSession session = request.getSession(false);
            UserMaster user11 = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Tender Authorize with tender no "+refNo+"").setDrow("Y");
            logService.create(lm);
            
            
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            
            TenderFollowup tenderFollowup = new TenderFollowup();
            tenderFollowup.setActivityDate(formattedDate);
            tenderFollowup.setActivity("Auction Authorize with auction no "+refNo+"");
            tenderFollowup.setLocation(location);
            tenderFollowup.setTenderNo(refNo);
            tenderFollowup.setPerson(user11.getLoginName());
            tenderFollowup.setPersonFullname(user11.getUserFullName());
            tenderFollowupService.create(tenderFollowup);
            
    
       // List list = tenderMasterService.unauthorizeTender(username, location, department);
        
        //request.setAttribute("list", list);
        
        //mv.getModelMap().put("list", list);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("forward:auctionMaster.htm?act=recycleAuctionList");
        return mv;
    }
    
    public ModelAndView rejectAuctionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        List list = auctionMasterService.rejectAuction(username, location, department);
        
        request.setAttribute("list", list);
        
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/RejectAuctionList");
        return mv;
    }
    
    public ModelAndView rejectView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
    //    String tenderPhase = request.getParameter("tenderPhase");
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        String refNo = auctionMaster.getAuctionNo();
        String emd = auctionMaster.getEmd();
        String doc_cost = auctionMaster.getDocCost();
        String auction_remark = auctionMaster.getAuctionRemark();
        String submitLastdate = auctionMaster.getBiddingEnddate();
        String type = auctionMaster.getType();
        
        //Get attachment of tender
        List generalDocs = auctionAttachmentService.readAuctionGeneralDoc(refNo);
        List additionalDocs = auctionAttachmentService.readAuctionAdditionalDoc(refNo);
        List technicalDocs = auctionAttachmentService.readAuctionTechnicalDoc(refNo);
        
        List tenderItemMaster = tenderItemMasterService.readByRefNo(refNo);
        List tenderVendor = tenderVendorService.readByRefNo(refNo);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("tenderVendor", tenderVendor);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auction_remark", auction_remark);
        mv.getModelMap().put("auctionNo", refNo);
        mv.getModelMap().put("type", type);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        
        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        
        mv.setViewName("Auction/RejectView");
        return mv;
    }
    
    public ModelAndView corrigendumView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
    //    String tenderPhase = request.getParameter("tenderPhase");
        String id = request.getParameter("id");
    
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));
        String refNo = auctionMaster.getAuctionNo();
        String emd = auctionMaster.getEmd();
        String doc_cost = auctionMaster.getDocCost();
        String auction_remark = auctionMaster.getAuctionRemark();
        String submitLastdate = auctionMaster.getBiddingEnddate();
        String type = auctionMaster.getType();
        String biddingType =auctionMaster.getBiddingType();
        
        //Get attachment of tender
        List generalDocs = auctionAttachmentService.readAuctionGeneralDoc(refNo);
        List additionalDocs = auctionAttachmentService.readAuctionAdditionalDoc(refNo);
        List technicalDocs = auctionAttachmentService.readAuctionTechnicalDoc(refNo);
        
        List tenderItemMaster = tenderItemMasterService.readByRefNo(refNo);
        List tenderVendor = tenderVendorService.readByRefNo(refNo);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("tenderVendor", tenderVendor);
        mv.getModelMap().put("biddingType", biddingType);

        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auction_remark", auction_remark);
        mv.getModelMap().put("auctionNo", refNo);
        mv.getModelMap().put("type", type);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        
        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        
        mv.setViewName("Auction/CorrigendumView");
        return mv;
    }
    
    public ModelAndView submitCorrigendumView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        String full_name = employeeMaster.getName();
        String contact_no = employeeMaster.getPhNo();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        String id = request.getParameter("id");
        String refNo = request.getParameter("auctionNo");
        String title = request.getParameter("title");
        String value = request.getParameter("value");
        String categoryId = request.getParameter("categoryId");
        String docCost = request.getParameter("docCost");
        String emd = request.getParameter("emd");
        String submitLastdate = request.getParameter("biddingEnddate");
        String submitLastdate1 = request.getParameter("biddingEnddate1");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date d1 = sdf.parse(submitLastdate1);
        Date d2 = sdf.parse(submitLastdate);
        
        long difference_In_Time
                = d2.getTime() - d1.getTime();
        
        if(difference_In_Time < 0)
        {
            request.setAttribute("failureMessage",
                    "Information: Auction Due Date con not be less than current due date"); 
            
            mv.setViewName("forward:auctionMaster.htm?act=corrigendumView&id="+id);
            return mv;
        }
        String workDesc = request.getParameter("workDesc");
        String prNo = request.getParameter("prNo");
        String remark = request.getParameter("remark");
        
        String lastBiddingTime = request.getParameter("lastBiddingTime");
        String extendTime = request.getParameter("extendTime");
        String extendTimeNo = request.getParameter("extendTimeNo");
        String autoDecIncAmount = request.getParameter("autoDecIncAmount");
        String refreshRate = request.getParameter("refreshRate");
        String bidding_display = request.getParameter("bidding_display");
        
        
        
        
        //attach general document
        
        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile" + i);if(generalfile == null)generalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("generalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(generalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(generalfile);
                auctionAttachment.setAttachmentType(0);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        //attach additional document
        
        int otherDetailCount1 = Integer.parseInt(request.getParameter("policyCount1"));
        for (int i = 1; i <= otherDetailCount1; i++) {
            String additionalfile = request.getParameter("additionalfile" + i);if(additionalfile == null)additionalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("additionalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    additionalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(additionalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(additionalfile);
                auctionAttachment.setAttachmentType(1);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        
        //attach technical document technical
        
        int otherDetailCount2 = Integer.parseInt(request.getParameter("policyCount2"));
        for (int i = 1; i <= otherDetailCount2; i++) {
            String technicalfile = request.getParameter("technicalfile" + i);if(technicalfile == null)technicalfile="";
            
            
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
            MultipartFile multipartFile = multipartRequest.getFile("technicalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Auction"
                            + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                    technicalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                    multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            if(technicalfile.equals(""))
            {}
            else
            {
                AuctionAttachment auctionAttachment = new AuctionAttachment();
                auctionAttachment.setAuctionNo(refNo);
                auctionAttachment.setAttachmentDoc(technicalfile);
                auctionAttachment.setAttachmentType(1);
                auctionAttachmentService.create(auctionAttachment);
            }
        }
        
        
        // update in item table
        
        
        
        // update vendor details
        
        //String[] checkVendorId = request.getParameterValues("checkVendorId");
        String[] vendor_code = request.getParameterValues("vendor_code");
        String[] email_id = request.getParameterValues("email_id");
        String[] mobile_no = request.getParameterValues("mobile_no");
        String[] start_price = request.getParameterValues("start_price");
        String[] loading_factor_per = request.getParameterValues("loading_factor_per");
        String[] loading_factor_val = request.getParameterValues("loading_factor_val");
        String[] final_price = request.getParameterValues("final_price");
        
        int j=0;
        try
        {
        for(int i=0;i<vendor_code.length;i++){
            j++;
            String checkVendorId = "1";
            
            auctionVendorService.updateRefNo(refNo, refNo, vendor_code[i], email_id[i], mobile_no[i], start_price[i], loading_factor_per[i], loading_factor_val[i], final_price[i], 1);
            
            
        }
        }catch(Exception e11){}
        
        
        auctionMasterService.recycleAuctionSubmit(refNo, username, full_name, contact_no, title, value, categoryId, docCost, emd, submitLastdate, workDesc, prNo, remark, lastBiddingTime, extendTime, extendTimeNo, autoDecIncAmount, refreshRate, bidding_display);

        //HttpSession session = request.getSession(false);
            UserMaster user11 = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Tender Authorize with tender no "+refNo+"").setDrow("Y");
            logService.create(lm);
            
            
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            
            TenderFollowup tenderFollowup = new TenderFollowup();
            tenderFollowup.setActivityDate(formattedDate);
            tenderFollowup.setActivity("Auction Corrigendum with auction no "+refNo+"");
            tenderFollowup.setLocation(location);
            tenderFollowup.setTenderNo(refNo);
            tenderFollowup.setPerson(user11.getLoginName());
            tenderFollowup.setPersonFullname(user11.getUserFullName());
            tenderFollowupService.create(tenderFollowup);
            
    
       // List list = tenderMasterService.unauthorizeTender(username, location, department);
        
        //request.setAttribute("list", list);
        
        //mv.getModelMap().put("list", list);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("forward:auctionMaster.htm?act=liveAuctionList");
        return mv;
    }
    
    public ModelAndView extendDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String refNo = request.getParameter("refNo");
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(refNo);
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        mv.getModelMap().put("biddingEnddate", biddingEnddate);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/ExtendDate");
        return mv;
    }
    
    public ModelAndView extendDateSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String refNo = request.getParameter("refNo");
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(refNo);
        String title = auctionMaster.getTitle();
        String announceDate = auctionMaster.getBiddingStartdate();
        //String docCost = tenderMaster.getDocCost();
        
        String biddingEnddate1 = request.getParameter("biddingEnddate1");
        String biddingEnddate = request.getParameter("biddingEnddate");
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        Date d1 = sdf.parse(biddingEnddate1);
        Date d2 = sdf.parse(biddingEnddate);
        
        long difference_In_Time
                = d2.getTime() - d1.getTime();
        
        if(difference_In_Time < 0)
        {
            request.setAttribute("failureMessage",
                    "Information: Tender Due Date con not be less than current due date");     
            
            mv.getModelMap().put("refNo", refNo);
            mv.getModelMap().put("biddingEnddate", biddingEnddate1);
            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.setViewName("Auction/ExtendDate");
            return mv;
        }
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        auctionMasterService.updateDate1(refNo, biddingEnddate);
        
        /*
        List list = tenderVendorService.readByRefNo(refNo);
        
        for (Object o : list) {
            TenderVendor tv = (TenderVendor) o;
            String email_id = tv.getEmailId();
            String vendor_code = tv.getVendorCode();
            int checked = tv.getChecked();
            
            if(checked == 1)
            {
                String subject = "";
                String msg = "";
                String mail_from = "";
                String mail_to = "";
                
                mail_to = email_id;
                String mail_to1[]=mail_to.split(",");
                
                for(int ml=0;ml<mail_to1.length;ml++)
                {
                    mail_to=mail_to1[ml];

                        EmailTemplate emailTemplate = emailTemplateService.readById(12);

                        subject = emailTemplate.getSubject();
                        msg = emailTemplate.getBodytext();
                    
                    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

                    msg = msg.replaceAll("\\{tender_title\\}", title.toUpperCase());
                    msg = msg.replaceAll("\\{ref_no\\}", refNo);
                    msg = msg.replaceAll("\\{start_date\\}", announceDate);
                    msg = msg.replaceAll("\\{end_date\\}", biddingEnddate);
                    msg = msg.replaceAll("\\{vendor_code\\}", vendor_code);
                    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
                    msg = msg.replaceAll("\\{department\\}", department);


                    SendMail s = new SendMail();
                    //s.sendMail(mail_from, mail_to, subject, msg);
                }
            }
        }
        
        */
            //HttpSession session = request.getSession(false);
            UserMaster user11 = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Auction Extend Date for auction no "+refNo+"").setDrow("Y");
            logService.create(lm);
            
            
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            /*
            TenderFollowup tenderFollowup = new TenderFollowup();
            tenderFollowup.setActivityDate(formattedDate);
            tenderFollowup.setActivity("Tender Extend Date for tender no "+refNo+"");
            tenderFollowup.setLocation(location);
            tenderFollowup.setTenderNo(refNo);
            tenderFollowup.setPerson(user11.getLoginName());
            tenderFollowup.setPersonFullname(user11.getUserFullName());
            tenderFollowupService.create(tenderFollowup);
        */
        
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("biddingEnddate", biddingEnddate);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/ExtendDate");
        return mv;
    }
    
    public ModelAndView updateVendorPrice(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String refNo = request.getParameter("refNo");
        String vendorCode = request.getParameter("vendorCode");
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(refNo);
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        String start_price = "";
        String loading_factor_per = "";
        String loading_factor_val = "";
        String final_price = "";
        
        AuctionVendorBid auctionVendorBid = auctionVendorBidService.readByAuctionVendor(refNo, vendorCode);
        
        start_price = auctionVendorBid.getVendorBasicStartPrice();
        loading_factor_per = auctionVendorBid.getLoadingFactorPer();
        loading_factor_val = auctionVendorBid.getLoadingFactorVal();
        final_price = auctionVendorBid.getFinalPrice();
        
        mv.getModelMap().put("biddingEnddate", biddingEnddate);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("vendorCode", vendorCode);
        mv.getModelMap().put("start_price", start_price);
        mv.getModelMap().put("loading_factor_per", loading_factor_per);
        mv.getModelMap().put("loading_factor_val", loading_factor_val);
        mv.getModelMap().put("final_price", final_price);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/UpdateVendorPrice");
        return mv;
    }
    
    public ModelAndView updateVendorPriceSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String refNo = request.getParameter("refNo");
        String vendorCode = request.getParameter("vendorCode");
        String start_price = request.getParameter("start_price");
        String loading_factor_per = request.getParameter("loading_factor_per");
        String loading_factor_val = request.getParameter("loading_factor_val");
        String final_price = request.getParameter("final_price");
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(refNo);
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        auctionVendorBidService.updatePrice(refNo, vendorCode, start_price, final_price);
        
        mv.getModelMap().put("biddingEnddate", biddingEnddate);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("vendorCode", vendorCode);
        mv.getModelMap().put("start_price", start_price);
        mv.getModelMap().put("loading_factor_per", loading_factor_per);
        mv.getModelMap().put("loading_factor_val", loading_factor_val);
        mv.getModelMap().put("final_price", final_price);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/UpdateVendorPrice");
        return mv;
    }
    
    public ModelAndView sendEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        
        String refNo = request.getParameter("refNo");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        List list = auctionVendorService.readByRefNo(refNo);
        
        
        request.setAttribute("list", list);
        
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.setViewName("Auction/SendEmail");
        return mv;
    }
    
    public ModelAndView sendEmailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        
        String refNo = request.getParameter("refNo");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        String[] checkId = request.getParameterValues("checkId");
        
        for (String checkedValues : checkId) {
        
            //Send Email
            
                UserMaster userMaster = userMasterService.read(checkedValues);
                String password = userMaster.getPassword();
                
                AuctionVendor tenderVendor = auctionVendorService.readByVendorAuction(refNo, checkedValues);

                AuctionMaster tenderMaster11 = auctionMasterService.readByAuctionNo(refNo);
                String announceDate = tenderMaster11.getBiddingStartdate();
                String title = tenderMaster11.getTitle();
                String submitLastdate = tenderMaster11.getBiddingEnddate();
                
                String subject = "";
                String msg = "";
                String mail_from = "";
                String mail_to = "";
                
                mail_to = tenderVendor.getEmailId();
                String mail_to1[]=mail_to.split(",");
                
                for(int ml=0;ml<mail_to1.length;ml++)
                {
                    mail_to=mail_to1[ml];

                    if(password.equals("gipcl"))
                    {
                        EmailTemplate emailTemplate = emailTemplateService.readById(6);

                        subject = emailTemplate.getSubject();
                        msg = emailTemplate.getBodytext();
                    }
                    else
                    {
                        EmailTemplate emailTemplate = emailTemplateService.readById(5);

                        subject = emailTemplate.getSubject();
                        msg = emailTemplate.getBodytext();
                    }
                    

                
                    subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

                    msg = msg.replaceAll("\\{tender_title\\}", title.toUpperCase());
                    msg = msg.replaceAll("\\{ref_no\\}", refNo);
                    msg = msg.replaceAll("\\{start_date\\}", announceDate);
                    msg = msg.replaceAll("\\{end_date\\}", submitLastdate);
                    msg = msg.replaceAll("\\{vendor_code\\}", checkedValues);
                    msg = msg.replaceAll("\\{location\\}", location.toUpperCase());
                    msg = msg.replaceAll("\\{department\\}", department);


                    SendMail s = new SendMail();
                    //s.sendMail(mail_from, mail_to, subject, msg);
                }
                
            
        }
        
        
        
        //HttpSession session = request.getSession(false);
            UserMaster user11 = (UserMaster) session.getAttribute("user");
            LogsMaster lm = new LogsMaster();
            Date date = new Date();
            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Send mail for auction no "+refNo+"").setDrow("Y");
            logService.create(lm);
            
            
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);
            
            TenderFollowup tenderFollowup = new TenderFollowup();
            tenderFollowup.setActivityDate(formattedDate);
            tenderFollowup.setActivity("Send mail for Auction no "+refNo+"");
            tenderFollowup.setLocation(location);
            tenderFollowup.setTenderNo(refNo);
            tenderFollowup.setPerson(user11.getLoginName());
            tenderFollowup.setPersonFullname(user11.getUserFullName());
            tenderFollowupService.create(tenderFollowup);
        
        
        
        
        
            
        
        List list = auctionVendorService.readByRefNo(refNo);
        
        request.setAttribute("list", list);
        
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.setViewName("Auction/SendEmail");
        return mv;
    }
    
    public ModelAndView addVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        List auctionVendor1 = auctionVendorService.readByRefNo(ref_no);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auction_no", auction_no);
        mv.setViewName("Auction/AddVendor");
        return mv;
    }
    
    public ModelAndView addVendorSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String auction_no = request.getParameter("auction_no");
        String vendor_code = request.getParameter("vendor_code");
        String vendor_name = request.getParameter("vendor_name");
        String ref_no = request.getParameter("ref_no");
        
        List vendorMaster = vendorMasterService.readByCodeName(vendor_code, vendor_name);
        
        for (Object o : vendorMaster) {
        
            VendorMaster vm = (VendorMaster) o;
            vendor_code = vm.getVendorRegNo();
            vendor_name = vm.getVendorName();
            
                
            break;
        }
        
        List auctionVendor1 = auctionVendorService.readByRefNo(ref_no);
        
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        mv.getModelMap().put("vendorMaster", vendorMaster);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("auction_no", auction_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("vendor_name", vendor_name);
        mv.setViewName("Auction/AddVendor");
        return mv;
    }
    
    public ModelAndView addVendorSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String auction_no = request.getParameter("auction_no");
        String vendor_code = request.getParameter("vendor_code1");
        String vendor_name = request.getParameter("vendor_name1");
        String start_price = request.getParameter("start_price");
        String loading_factor_per = request.getParameter("loading_factor_per");
        String loading_factor_val = request.getParameter("loading_factor_val");
        String final_price = request.getParameter("final_price");
        String address="";
        String email_id="";
        String mobile_no="";
        
        String ref_no = request.getParameter("ref_no");
        
        List vendorMaster = vendorMasterService.readByCodeName(vendor_code, vendor_name);
        
        for (Object o : vendorMaster) {
        
            VendorMaster vm = (VendorMaster) o;
            vendor_code = vm.getVendorRegNo();
            vendor_name = vm.getVendorName();
            address = vm.getVendorAddressLine1();
            email_id = vm.getVendorEmailID();
            mobile_no = vm.getVendorMobNo();
            break;
        }
        
        List auctionVendor1 = auctionVendorService.readByRefVendor(auction_no, vendor_code);
            
            if(auctionVendor1.isEmpty())
            {
                AuctionVendor auctionVendor = new AuctionVendor();
                auctionVendor.setAuctionNo(auction_no);
                auctionVendor.setVendorCode(vendor_code);
                auctionVendor.setVendorName(vendor_name);
                auctionVendor.setAddress(address);
                auctionVendor.setEmailId(email_id);
                auctionVendor.setMobileNo(mobile_no);
                auctionVendor.setVendorBasicStartPrice(start_price);
                auctionVendor.setLoadingFactorPer(loading_factor_per);
                auctionVendor.setLoadingFactorVal(loading_factor_val);
                auctionVendor.setFinalPrice(final_price);
                auctionVendorService.create(auctionVendor);
                
                request.setAttribute("successMessage",
                    "Information: Vendor added successfully");
            }
            else
            {
                request.setAttribute("failureMessage",
                    "Information: Vendor already available");
            }
        
        
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        mv.getModelMap().put("vendorMaster", vendorMaster);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("auction_no", auction_no);
        
        mv.setViewName("Auction/AddVendor");
        return mv;
    }
    
    public ModelAndView pastAuctionSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String refNo = request.getParameter("refNo");
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(refNo);
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        mv.getModelMap().put("biddingEnddate", biddingEnddate);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/PastAuctionSearch");
        return mv;
    }
    
    public ModelAndView pastAuctionList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String auction_no = request.getParameter("auction_no");
        String auction_title = request.getParameter("auction_title");
        String open_from_date = request.getParameter("open_from_date");
        String open_to_date = request.getParameter("open_to_date");
        String close_from_date = request.getParameter("close_from_date");
        String close_to_date = request.getParameter("close_to_date");
        
        
        
        
        String refNo = request.getParameter("refNo");
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(refNo);
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
            
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        
        List list = auctionMasterService.pastAuctionList(location, department, auction_no, auction_title,open_from_date, open_to_date, close_from_date, close_to_date);
        
        mv.getModelMap().put("biddingEnddate", biddingEnddate);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("Auction/PastAuctionSearch");
        return mv;
    }
    
    public ModelAndView addItemDocumentAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
        int item_no = Integer.parseInt(request.getParameter("item_id"));
        
       
        AuctionItemMaster itemDetail = auctionItemMasterService.readById(item_no);
           mv.getModelMap().put("itemDetail", itemDetail);
        List auctionVendor1 = auctionItemVendorService.readByRefNo(ref_no,item_no);        
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
                
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String department = employeeMaster.getDepartment();
        String location = employeeMaster.getLocation();
        
        List li =auctionItemVendorService.readByIds(ref_no, item_no);
          mv.getModelMap().put("li", li);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("item_no", item_no);
        
        mv.setViewName("Auction/CreateItemwiseAuction");
        return mv;
    }
     
    public ModelAndView searchVendorItemForAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
         
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
         int item_no = Integer.parseInt(request.getParameter("item_id"));
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        List auctionVendor1 = auctionItemVendorService.readByRefNo(ref_no,item_no);  
          List li =auctionItemVendorService.readByIds(ref_no, item_no);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
         mv.getModelMap().put("item_no", item_no);
          mv.getModelMap().put("li", li);
          mv.getModelMap().put("li", li);
        mv.setViewName("forward:auctionMaster.htm?act=searchVendorItemForAuctionSubmit&item_id=" + item_no );
        return mv;
    }
    
    public ModelAndView searchVendorItemForAuctionSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String vendor_code = request.getParameter("vendor_code");
        String vendor_name = request.getParameter("vendor_name");
        String ref_no = request.getParameter("ref_no");
      
        int item_no = Integer.parseInt(request.getParameter("item_id"));
        
        List vendorMaster = vendorMasterService.readByCodeName(vendor_code, vendor_name);
        
        List auctionVendor1 = auctionItemVendorService.readByRefNo(ref_no,item_no);   
        List li =auctionItemVendorService.readByIds(ref_no, item_no);
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);

        mv.getModelMap().put("vendorMaster", vendorMaster);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("ref_no", ref_no);
         mv.getModelMap().put("li", li);
         request.setAttribute("li", li);
         mv.getModelMap().put("item_no", item_no);
        mv.setViewName("Auction/CreateItemwiseAuction");
        return mv;
    }
        
    public ModelAndView addVendorItemForAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {

       ModelAndView mv = new ModelAndView();
        AuctionItemVendor auctionItemVendor1 = new AuctionItemVendor();
       

        String ref_no = request.getParameter("ref_no");
         String[] checkId = request.getParameterValues("checkedId");
         int lengthOfArrays  = checkId.length;
         int item_no = Integer.parseInt(request.getParameter("item_id"));
         

         
    String[] start_price = request.getParameterValues("start_price");
    String[] start_price1 = new String[lengthOfArrays];
    int x1 = 0;
    for (int j = 0; j < start_price.length; j++) {
        if (!start_price[j].isEmpty()) {
            start_price1[x1] = start_price[j];
            x1++;
        }
    }

    String[] loading_factor_per = request.getParameterValues("loading_factor_per");

    String[] loading_factor_per1 = new String[lengthOfArrays];
    int x = 0;
    for (int j = 0; j < loading_factor_per.length; j++) {

        if (!loading_factor_per[j].isEmpty()) {
            loading_factor_per1[x] = loading_factor_per[j];
            x++;
        }
    }

    String[] loading_factor_val = request.getParameterValues("loading_factor_val");
    String[] loading_factor_val1 = new String[lengthOfArrays];
    int x2 = 0;
    for (int j = 0; j < loading_factor_val.length; j++) {

        if (!loading_factor_val[j].isEmpty()) {
            loading_factor_val1[x2] = loading_factor_val[j];
            x2++;
        }
    }
    
    
    String[] final_price = request.getParameterValues("final_price");

    String[] final_price1 = new String[lengthOfArrays];
    int x3 = 0;
    for (int j = 0; j < final_price.length; j++) {
       Double d =  Double.parseDouble(final_price[j]);
    
        if (!(Double.isNaN(d)))
         {
            final_price1[x3] = final_price[j];
            x3++;
        }
    }

    
         
         
        String vendor_code = "";
        String vendor_name = "";
        String email_id = "";
        String mobile_no= "";
        String address= "";
        //checkedId
       
//        for (String checkedValues : checkId)
         for(int i=0;i<checkId.length;i++){
           
            VendorMaster vendorMaster = vendorMasterService.read(checkId[i]);
            vendor_code = vendorMaster.getVendorRegNo();
            vendor_name = vendorMaster.getVendorName();
            email_id = vendorMaster.getVendorEmailID();
            mobile_no = vendorMaster.getVendorMobNo();
            address = vendorMaster.getVendorAddressLine1();
            
            List auctionVendor1 = auctionItemVendorService.readByRefVendor(ref_no, vendor_code ,item_no);
            
            if(auctionVendor1.isEmpty())
            {
                AuctionItemVendor auctionItemVendor = new AuctionItemVendor();
                auctionItemVendor.setId(1);
                auctionItemVendor.setAuctionNo(ref_no);
                auctionItemVendor.setVendorCode(vendor_code);
                auctionItemVendor.setVendorName(vendor_name);
                auctionItemVendor.setAddress(address);
                auctionItemVendor.setCurrency("INR (Rupees)");
                auctionItemVendor.setContactName(vendor_name);
                auctionItemVendor.setEmailId(email_id);
                auctionItemVendor.setMobileNo(mobile_no);
                auctionItemVendor.setVendorBasicStartPrice(start_price1[i]);
                auctionItemVendor.setLoadingFactorVal(loading_factor_val1[i]);
                auctionItemVendor.setLoadingFactorPer(loading_factor_per1[i]);
                auctionItemVendor.setFinalPrice(final_price1[i]);
                auctionItemVendor.setAuctionItemMasterId(item_no);
                auctionItemVendorService.create(auctionItemVendor);
            }
            else
            {
                request.setAttribute("failureMessage",
                    "Information: Vendor already added");
            }
            
        }
         List li =auctionItemVendorService.readByIds(ref_no, item_no);
        List auctionVendor1 = auctionItemVendorService.readByRefNo(ref_no,item_no);        
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
         mv.getModelMap().put("li", li);
          mv.getModelMap().put("li", li);
        mv.getModelMap().put("ref_no", ref_no);
         mv.getModelMap().put("item_no", item_no);
        mv.setViewName("Auction/CreateItemwiseAuction");
        return mv;
    }
    
    public ModelAndView editVendorItemForAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
//        AuctionMaster auctionMaster = new AuctionMaster();
//        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");
         int item_no = Integer.parseInt(request.getParameter("item_id"));
         
            String[] li = request.getParameterValues("li");  
            
            
                    String[] email_id = request.getParameterValues("email_id");
              //checkedId
              String[] checkId = request.getParameterValues("checkedIdd");
//        for (String checkedValues : checkId)

              List auctionVendor1 = auctionItemVendorService.readByRefNo(ref_no, item_no);

              int i1=0;
              for (int j = 0; j <= email_id.length; j++) {
                  i1++;
                  String checkId1 = request.getParameter("checkedIdd"+i1); if(checkId1 == null)checkId1="";
                  if(!checkId1.equals(""))
                  {
                      String start_price =request.getParameter("start_price1"+i1);
                      String loading_factor_per = request.getParameter("loading_factor_per1"+i1);
                        String loading_factor_val = request.getParameter("loading_factor_val1"+i1);
                        String final_price = request.getParameter("final_price1"+i1);
         
                      AuctionItemVendor auctionItemVendor = auctionItemVendorService.readById(Integer.parseInt(checkId1));
                      
                              auctionItemVendor.setVendorBasicStartPrice(start_price);
                              auctionItemVendor.setLoadingFactorVal(loading_factor_val);
                              auctionItemVendor.setLoadingFactorPer(loading_factor_per);
                              auctionItemVendor.setFinalPrice(final_price);
                              auctionItemVendorService.update(auctionItemVendor);
                              
                  }
                  
              }
   
        

        
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
         mv.getModelMap().put("li", li);
         request.setAttribute("li", li); 
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        request.setAttribute("auctionVendor1", auctionVendor1);
//        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
         mv.getModelMap().put("item_no", item_no);
        mv.setViewName("forward:auctionMaster.htm?act=addItemDocumentAction&item_id="+ item_no + "&li="+ li );
        return mv;
    }
    
    public ModelAndView deleteVendorItemForAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String[] length =request.getParameterValues("length");
        String ref_no = request.getParameter("ref_no");
        int item_no = Integer.parseInt(request.getParameter("item_id"));
        //checkedId
        int i1=0;
          for (int j = 0; j <= length.length; j++) {
                  i1++;
                  String checkId1 = request.getParameter("checkedIdd"+i1); if(checkId1 == null)checkId1="";
                  if(!checkId1.equals(""))
                  {
            auctionItemVendorService.delete(Integer.parseInt(checkId1));
            
        }
          }
        
         List auctionVendor1 = auctionItemVendorService.readByRefNo( ref_no , item_no);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("ref_no", ref_no);
         mv.getModelMap().put("item_no", item_no);
        mv.setViewName("Auction/CreateItemwiseAuction");
        return mv;
    }
     
    public ModelAndView uploadExcelVendorItemForAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        String ref_no = request.getParameter("ref_no");  
        int item_no = Integer.parseInt(request.getParameter("item_id"));
          String[] li = request.getParameterValues("li");  
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
          List auctionVendor1 = auctionItemVendorService.readByRefNo(ref_no,item_no);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("li", li);
        request.setAttribute("li", li);
         mv.getModelMap().put("item_no", item_no);
        mv.setViewName("forward:auctionMaster.htm?act=uploadExcelItemVendorForAuctionSubmit&item_id="+ item_no + "&li=" +li);
        return mv;
    }
     
    public ModelAndView uploadExcelItemVendorForAuctionSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        String auction_no = request.getParameter("auction_no");
        int item_no = Integer.parseInt(request.getParameter("item_id"));
        String ref_no = request.getParameter("ref_no");
        String[] li = request.getParameterValues("li");

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Auction"
                + File.separator + ref_no;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        String technicalfile = request.getParameter("technicalfile");
        if (technicalfile == null) {
            technicalfile = "";
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile multipartFile = multipartRequest.getFile("technicalfile");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Auction"
                        + File.separator + ref_no + File.separator;
                File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", ""));
                technicalfile = multipartFile.getOriginalFilename().replaceAll(" ", "");
                multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ArrayList<PreQualificationExcel> al = new ArrayList<PreQualificationExcel>();
            //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Auction/" + ref_no + "/" + technicalfile);
            //creating a new file instance  
            FileInputStream fis = new FileInputStream(file);
                //obtaining bytes from the file  
            //creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            //creating a Sheet object to retrieve object  
            Iterator< Row> itr = sheet.iterator();
            //iterating over excel file
            System.out.println("The given file is");
            int j = 0;
            while (itr.hasNext()) {
                j++;

                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String srNo = "";
                    String desc = "";
                    String comp = "";
                    String vendor_code = "";
                    String vendor_name = "";
                    String email_id = "";
                    String mobile_no = "";
                    String address = "";
                    String vendorBasicStartPrice = "";
                    String loadingFactorPer = "";
                    String loadingFactorVal = "";
                    String finalPrice = "";

                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        if (i == 1) {
                            srNo = cell.getNumericCellValue() + "";
                        }
                        if (i == 2) {
                            vendor_code = cell.getStringCellValue();
                        }
                        if (i == 7) {
                            try {
                                vendorBasicStartPrice = cell.getNumericCellValue() + "";
                            } catch (Exception e1) {
                                vendorBasicStartPrice = cell.getStringCellValue();
                            }
                        }
                        if (i == 8) {
                            try {
                                loadingFactorPer = cell.getNumericCellValue() + "";
                            } catch (Exception e1) {
                                loadingFactorPer = cell.getStringCellValue();
                            }
                        }
                        if (i == 9) {
                            try {
                                loadingFactorVal = cell.getNumericCellValue() + "";
                            } catch (Exception e1) {
                                loadingFactorVal = cell.getStringCellValue();
                            }
                        }
                        if (i == 10) {
                            try {
                                finalPrice = cell.getNumericCellValue() + "";
                            } catch (Exception e1) {
                                finalPrice = cell.getStringCellValue();
                            }
                        }

                    }

                        //----------------------
                    VendorMaster vendorMaster = vendorMasterService.read(vendor_code);
                    vendor_code = vendorMaster.getVendorRegNo();
                    vendor_name = vendorMaster.getVendorName();
                    email_id = vendorMaster.getVendorEmailID();
                    mobile_no = vendorMaster.getVendorMobNo();
                    address = vendorMaster.getVendorAddressLine1();

                    List auctionVendor1 = auctionItemVendorService.readByRefVendor(ref_no, vendor_code, item_no);

                    if (auctionVendor1.isEmpty()) {

                        AuctionItemVendor auctionItemVendor = new AuctionItemVendor();
                        auctionItemVendor.setId(1);
                        auctionItemVendor.setAuctionNo(ref_no);
                        auctionItemVendor.setVendorCode(vendor_code);
                        auctionItemVendor.setVendorName(vendor_name);
                        auctionItemVendor.setAddress(address);
                        auctionItemVendor.setEmailId(email_id);
                        auctionItemVendor.setCurrency("INR (Rupees)");
                        auctionItemVendor.setContactName(vendor_name);
                        auctionItemVendor.setMobileNo(mobile_no);
                        auctionItemVendor.setVendorBasicStartPrice(vendorBasicStartPrice);
                        auctionItemVendor.setLoadingFactorPer(loadingFactorPer);
                        auctionItemVendor.setLoadingFactorVal(loadingFactorVal);
                        auctionItemVendor.setFinalPrice(finalPrice);
                        auctionItemVendor.setAuctionItemMasterId(item_no);
                        auctionItemVendorService.create(auctionItemVendor);

                        mv.getModelMap().put("auctionVendor1", auctionVendor1);

                    }
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

        List auctionVendor1 = auctionItemVendorService.readByRefNo(ref_no, item_no);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auctionVendor1", auctionVendor1);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("item_no", item_no);
        mv.getModelMap().put("li", li);
        request.setAttribute("li", li);
        mv.setViewName("Auction/CreateItemwiseAuction");
        return mv;
    }

    public ModelAndView itemwiseReceivedAuctionView(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();
//   String auctionNo =request.getParameter("auctionNo");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String auction_no = request.getParameter("auctionId");
//          List vendorAuctionNo = auctionItemVendorService.read();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
//        List auctionItemVendorBid = auctionItemVendorBidService.readByAuctionId(auction_no);

        //Add CountDown For Start bidding//
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);

        String bidding_start_date = auctionMaster.getBiddingStartdate();
        String bidding_end_date = auctionMaster.getBiddingEnddate();
        String last_bidding_time = auctionMaster.getLastBiddingTime();
        String extend_bidding_time = auctionMaster.getExtendTime();
        String no_of_time = auctionMaster.getExtendTimeNo();
        String auction_type1 = auctionMaster.getType();
        int auctionMasterId = auctionMaster.getId();
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        SimpleDateFormat sdf11 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        try {
            Date date = new Date();
            Date d11 = sdf11.parse(biddingEnddate);
            long difference_In_Time11
                    = d11.getTime() - date.getTime();
            mv.getModelMap().put("difference_In_Time", difference_In_Time11);
        } catch (Exception e11) {
        }

      List auctionItemMaster =auctionItemMasterService.readByAuctionId(auction_no);

        List auctionItemVendorList = new LinkedList();
        for (Object o1 : auctionItemMaster) {
            AuctionItemMaster aim = (AuctionItemMaster) o1;
            int itemId = aim.getId();
            String itemCode = aim.getItemCode();
                String itemNo = aim.getAuctionNo();
                String itemName = aim.getItemName();
                String itemDesc = aim.getItemDesc();
                String itemRemark = aim.getItemRemark();
                String uom = aim.getUom();
                String qty = aim.getQty();
            
            String vendor_code = "";
            
            
   List list1 =auctionItemVendorBidService.readByReverseAuction(auction_no, itemId);
   
        for (Object o2 : list1) {
//            AuctionItemVendorBid aivb = (AuctionItemVendorBid) o2;
              Object[] aivb = (Object[]) o2;
           String vendorCode = aivb[0].toString();
            int i = 1;
         
            VendorMaster vendorMaster = vendorMasterService.read(vendorCode);
            
            String vendor_name = aivb[1].toString();
            String vendorPrice =aivb[2].toString();
            String dateTime =aivb[3].toString();
            String auctionItemMasterId =aivb[4].toString();
            
            
            List starusList = new ArrayList();
                
                starusList.add(itemId);
                starusList.add(vendorCode);
//                starusList.add(vendorName);
                starusList.add(vendorPrice);
                starusList.add(vendor_name);

                starusList.add(auctionItemMasterId);
                starusList.add(dateTime);
                starusList.add(itemCode);
                starusList.add(itemName);
                starusList.add(itemDesc);
                starusList.add(itemRemark);
                starusList.add(uom);
                starusList.add(qty);
                starusList.add(itemNo);
                starusList.add(i);
               
                auctionItemVendorList.add(starusList);
                
            
        }
   
   List li2 =auctionItemVendorService.readAuctionItemVendor(auction_no, itemId);
 
   for(Object o3 : li2){
        AuctionItemVendor auctionItemVendor = (AuctionItemVendor) o3;
        String Vendor_code= auctionItemVendor.getVendorCode();
        String Vendor_Name= auctionItemVendor.getVendorName();
        
        int i=0;
        for(Object o4 : list1){
//            AuctionItemVendorBid auctionItemVendorBid =(AuctionItemVendorBid) o4;
            Object[] auctionItemVendorBid = (Object[]) o4;
            String Vendor_code2 =auctionItemVendorBid[0].toString();
            if(Vendor_code.equals(Vendor_code2)){
                i=1;
            }
        }
        
        if(i == 0)
        {
            List starusList = new ArrayList();
                
                starusList.add(itemId);
                starusList.add(Vendor_code);
//                starusList.add(vendorName);
                starusList.add("");
                starusList.add(Vendor_Name);

                starusList.add("");
                starusList.add("");
                starusList.add(itemCode);
                starusList.add(itemName);
                starusList.add(itemDesc);
                starusList.add(itemRemark);
                starusList.add(uom);
                starusList.add(qty);
                starusList.add(itemNo);
                starusList.add("");
               
              
                auctionItemVendorList.add(starusList);
            
        }
   }
 

            }


        List auctionVendor = auctionItemVendorService.readByAuctionId(auction_no);

        mv.getModelMap().put("auctionVendor", auctionVendor);

        mv.getModelMap().put("auctionItemVendorList", auctionItemVendorList);
//        mv.getModelMap().put("auctionItemMasterList", auctionItemMasterList);

      
        mv.getModelMap().put("formattedDate", formattedDate);
        mv.getModelMap().put("auctionItemMaster", auctionItemMaster);
//        mv.getModelMap().put("auctionItemVendorBid", auctionItemVendorBid);
//           mv.getModelMap().put("auctionItemVendor", auctionItemVendor); 
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auction_no", auction_no);
//              mv.getModelMap().put("auctionItemVendor", auctionItemVendor);

        mv.setViewName("Auction/ReceiveItemwiseAuctionView");
        return mv;
    }

    public ModelAndView vendorItemwiseAuctionHistoryView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();

        UserRights userRights = userRightsService.readByUser(username);
        int authuser = userRights.getAuthorizeTender();

        int itemId = Integer.parseInt(request.getParameter("itemId"));
        int auctionMasterId = Integer.parseInt(request.getParameter("auctionMasterId"));
        String vendor_code = request.getParameter("vendorCode");
        String auction_no = request.getParameter("auction_no");

        AuctionMaster auctionMaster = auctionMasterService.readById(auctionMasterId);
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        SimpleDateFormat sdf11 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        mv.getModelMap().put("biddingEnddate", biddingEnddate);
        String refNo = auctionMaster.getAuctionNo();
        String type = auctionMaster.getType();
        List list = auctionItemVendorBidHistoryService.readVendorHistory(auction_no, vendor_code);

        if (type.equals("Reverse")) {

            List li = auctionItemVendorBidHistoryService.readByReverseAuction1(refNo, itemId ,vendor_code);
            request.setAttribute("li", li);
            mv.getModelMap().put("li", li);
        }
        else {

            List li = auctionItemVendorBidHistoryService.readByForwardAuction1(refNo, itemId ,vendor_code);
            request.setAttribute("li", li);
            mv.getModelMap().put("li", li);
        }

        
        
        
        mv.getModelMap().put("list", list);

        mv.getModelMap().put("authuser", authuser);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("auctionMaster", auctionMaster);

        request.setAttribute("list", list);

        mv.getModelMap().put("list", list);

        mv.getModelMap().put("authuser", authuser);
        mv.getModelMap().put("auction_no", auction_no);

        mv.setViewName("Auction/VendorAuctionHistoryView");
        return mv;
    }

    public ModelAndView sendToAuction(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        String tender_no = request.getParameter("tender_no");
        String submit = request.getParameter("submit");
        //tender id
        String ref_no="";
        AuctionNoTemp auctionNoTemp = auctionNoTempService.readLastRecord();
        ref_no = auctionNoTemp.getAuctionNo();
        int ref_no1 = Integer.parseInt(ref_no);
        ref_no1++;
        
        AuctionNoTemp auctionNoTemp1 = new AuctionNoTemp();
        auctionNoTemp1.setAuctionNo(ref_no1+"");
        auctionNoTempService.create(auctionNoTemp1);
        
        mv.getModelMap().put("ref_no", ref_no1);
        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        
        
        mv.setViewName("Auction/SendToAuction");
        return mv;
    }
    
    public ModelAndView sendToAuctionCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        AuctionMaster auctionMaster = new AuctionMaster();
        
        String tender_no = request.getParameter("tender_no");
        String type = request.getParameter("auctionType");
        String ref_no = request.getParameter("ref_no");
        //tender id
        //String ref_no="";
        
        /*AuctionNoTemp auctionNoTemp = auctionNoTempService.readLastRecord();
        ref_no = auctionNoTemp.getAuctionNo();
        int ref_no1 = Integer.parseInt(ref_no);
        ref_no1++;
        
        AuctionNoTemp auctionNoTemp1 = new AuctionNoTemp();
        auctionNoTemp1.setAuctionNo(ref_no1+"");
        auctionNoTempService.create(auctionNoTemp1); */
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String submitLastdate = myDateObj.format(myFormatObj1);
        submitLastdate = submitLastdate + " 23:59:00";
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.readUser(username);

        String employee_name = employeeMaster.getName();
        String ph_no = employeeMaster.getPhNo();
        String location = employeeMaster.getLocation();
        
    //    List list = employeeMasterService.readByDrow();
    //    request.setAttribute("list", list);
        
        List tenderItem = tenderItemMasterService.readByRefNo(tender_no);
        
        for (Object o : tenderItem) {
            //i++;
            TenderItemMaster tim = (TenderItemMaster) o;
            String item_code = tim.getItemCode();
            String srNo = tim.getSrNo();
            String item_name = tim.getItemDescription();
            String item_desc = tim.getDeliveryScheduleDate();
            String remark = tim.getRemark();
            String uom = tim.getUom();
            String qty = tim.getQty();
            
                    AuctionItemMaster auctionItemMaster = new AuctionItemMaster();
                    auctionItemMaster.setAuctionNo(ref_no);
                    auctionItemMaster.setSrNo(srNo);
                    auctionItemMaster.setItemCode(item_code);
                    auctionItemMaster.setItemName(item_name);
                    auctionItemMaster.setItemDesc(item_desc);
                    auctionItemMaster.setItemRemark(remark);
                    auctionItemMaster.setUom(uom);
                    auctionItemMaster.setQty(qty);
                    
                    auctionItemMasterService.create(auctionItemMaster);
                    
        }
        
        List tenderVendor = tenderVendorService.readByRefNo(tender_no);
        
        for (Object o : tenderVendor) {
            //i++;
            TenderVendor tv = (TenderVendor) o;
            
            String vendor_code = tv.getVendorCode();
            String vendor_name = tv.getVendorName();
            String address = tv.getAddress();
            String email_id = tv.getEmailId();
            String mobile_no = tv.getMobileNo();
            String item_total = "0";
            
            try{
                VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(tender_no, vendor_code);
            
                item_total = vendorTenderBid.getItemTotal();
            }catch(Exception e11){}
            
            if(item_total == null) item_total="0";
                        List auctionVendor1 = auctionVendorService.readByRefVendor(ref_no, vendor_code);

                        if(auctionVendor1.isEmpty())
                        {
                            AuctionVendor auctionVendor = new AuctionVendor();
                            auctionVendor.setAuctionNo(ref_no);
                            auctionVendor.setVendorCode(vendor_code);
                            auctionVendor.setVendorName(vendor_name);
                            auctionVendor.setAddress(address);
                            auctionVendor.setEmailId(email_id);
                            auctionVendor.setMobileNo(mobile_no);
                            auctionVendor.setVendorBasicStartPrice(item_total);
                            auctionVendor.setLoadingFactorPer("0");
                            auctionVendor.setLoadingFactorVal("0");
                            auctionVendor.setFinalPrice(item_total);
                            auctionVendorService.create(auctionVendor);
                            
                        }
                        
            
        }
        
        
        
        mv.getModelMap().put("employee_name", employee_name);
        mv.getModelMap().put("ph_no", ph_no);
        mv.getModelMap().put("location", location);
        mv.getModelMap().put("formattedDate", formattedDate);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("type", type);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        
        mv.setViewName("Auction/SendToAuctionCreate");
        return mv;
    }
    
    public ModelAndView approvalWorkFlowSelect(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));

        String refNo = request.getParameter("refNo");
        String vendorCode = request.getParameter("vendorCode");

        boolean x = auctionPriceApprovalService.isExist(refNo);
        
        
        List tenderApprovalSetting =  tenderApprovalSettingService.read();
        

        if (x == false) {

            List employeeMaster1 = employeeMasterService.read();

            HttpSession session = request.getSession(false);
            UserMaster user = (UserMaster) session.getAttribute("user");
            String username = user.getLoginName();

            EmployeeMaster employeeMaster = employeeMasterService.read(username);
            
            List<?> userTender = tenderApprovalUserService.readByIdToList(id);

            UserRights userRights = userRightsService.readByUser(username);

            request.setAttribute("refNo", refNo);

            mv.getModelMap().put("id", id);
            mv.getModelMap().put("refNo", refNo);
           // mv.getModelMap().put("employeeMaster1", employee);
            mv.getModelMap().put("tenderApprovalSetting", tenderApprovalSetting);

            mv.getModelMap().put("vendorCode", vendorCode);

            mv.getModelMap().put("auctionMaster", auctionMaster);
            mv.setViewName("Auction/ApprovalWorkFlowSelect");

        } else {
            request.setAttribute("failureMessage", "User is Already Selected For Approval....");
            mv.setViewName("forward:auctionMaster.htm?act=receivedAuctionView1&id=" + id);
        }

        return mv;
    }
    
    public ModelAndView approvalWorkFlowSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        AuctionPriceApproval auctionPriceApproval = new AuctionPriceApproval();
        AuctionPriceApprovalUser auctionPriceApprovalUser = new AuctionPriceApprovalUser();
        AuctionPriceApprovalComment auctionPriceApprovalComment = new AuctionPriceApprovalComment();

        String id = request.getParameter("id");
        String tenderApprovalSetting = request.getParameter("tenderApprovalSetting");
        AuctionMaster auctionMaster = auctionMasterService.readById(Integer.parseInt(id));

        String refNo = request.getParameter("refNo");
        String vendorCode = request.getParameter("vendorCode"); if(vendorCode == null)vendorCode="";
        int policyCount = Integer.parseInt(request.getParameter("policyCount"));
        String comment = request.getParameter("comment");
        if (comment == null) {
            comment = "";
        }
        
        List TenderApprovalUser = tenderApprovalUserService.readByIdToList(tenderApprovalSetting);
        policyCount = TenderApprovalUser.size();
        
        //auctionPriceApproval.setVendorCode(vendorCode);
        auctionPriceApproval.setAuctionNo(refNo);
        auctionPriceApproval.setCurrentApproval(1);
        auctionPriceApproval.setApprovalStatus(0);
        auctionPriceApproval.setTotalApproval(policyCount);

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        auctionPriceApproval.setDateTime(formattedDate);

        String approvalRemark = request.getParameter("approvalRemark");
        if (approvalRemark == null) {
            approvalRemark = "";
        }
        auctionPriceApproval.setApprovalRemark(approvalRemark);

        List employeeMaster1 = employeeMasterService.read();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        UserRights userRights = userRightsService.readByUser(username);

        EmployeeMaster employeeMaster = employeeMasterService.read(username);

        String employeeCode = employeeMaster.getEmployeeCode();
        auctionPriceApproval.setUserId(employeeCode);
        auctionPriceApproval.setApprovalRemark(comment);
        auctionPriceApprovalService.create(auctionPriceApproval);

        int approveId = auctionPriceApproval.getId();

        int i1=0;
        for (Object o : TenderApprovalUser) {
            i1++;
            TenderApprovalUser tau = (TenderApprovalUser) o;
            String user_id = tau.getUserId();
            
            auctionPriceApprovalUser.setUserId(user_id);
            auctionPriceApprovalUser.setAuctionNo(refNo);
           // auctionPriceApprovalUser.setVendorCode(vendorCode);
            auctionPriceApprovalUser.setAuctionApprovalId(approveId);
            auctionPriceApprovalUser.setLevel(i1);
            auctionPriceApprovalUser.setApprovalStatus(0);

        //    tenderPriceApprovalComment.setApprovalStatus(0);
        //    tenderPriceApprovalComment.setDateTime(formattedDate);
        //    tenderPriceApprovalComment.setTenderApprovalId(approveId);
        //    tenderPriceApprovalComment.setUserId(user_id);
        //    tenderPriceApprovalComment.setApprovalComment(comment);
            

            auctionPriceApprovalUserService.create(auctionPriceApprovalUser);
        //    tenderPriceApprovalCommentService.create(tenderPriceApprovalComment);
        }
        
    

        mv.getModelMap().put("id", id);

        mv.getModelMap().put("employeeMaster1", employeeMaster1);
        mv.getModelMap().put("auctionPriceApproval", auctionPriceApproval);
        mv.getModelMap().put("auctionPriceApprovalUser", auctionPriceApprovalUser);
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.setViewName("forward:auctionMaster.htm?act=receivedAuctionView1&id=" + id);
        return mv;
    }
    
    public ModelAndView viewApproveUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        AuctionPriceApproval auctionPriceApproval = auctionPriceApprovalService.readById(Integer.parseInt(id));

        int approveId = auctionPriceApproval.getId();
        String auction_no = auctionPriceApproval.getAuctionNo();
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);

        
        List li = auctionPriceApprovalUserService.readByRefNo(approveId);
        
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("auctionMaster", auctionMaster);

        mv.getModelMap().put("li", li);
        mv.setViewName("Auction/ViewApproveUserList");
        return mv;
    }
    
    public ModelAndView approvePriceBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List auctionPriceApproval = auctionPriceApprovalService.approvaList(username);
        List tenderPriceApprovalUser = tenderPriceApprovalUserService.read();
        List tenderPriceApproval1 = tenderPriceApprovalService.read();

        mv.getModelMap().put("list1", auctionPriceApproval);
        mv.getModelMap().put("list3", tenderPriceApproval1);
        mv.getModelMap().put("list2", tenderPriceApprovalUser);
        mv.getModelMap().put("id", id);
        mv.setViewName("Auction/ApprovePriceBidList");
        return mv;
    }
    
    public ModelAndView viewapprovePriceBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();
        
        UserRights userRights = userRightsService.readByUser(username);
        int authuser = userRights.getAuthorizeTender();
        
        AuctionPriceApproval auctionPriceApproval = auctionPriceApprovalService.readById(Integer.parseInt(id));
        String refNo = auctionPriceApproval.getAuctionNo();
        
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(refNo);
        
        String type = auctionMaster.getType();
        
        List auctionItemMaster = auctionItemMasterService.readByAuctionId(refNo);
        
        mv.getModelMap().put("auctionItemMaster", auctionItemMaster);
        
        
        String biddingEnddate = auctionMaster.getBiddingEnddate();
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        Date d11 = sdf.parse(biddingEnddate);
        long difference_In_Time
                = d11.getTime() - date.getTime();
        mv.getModelMap().put("difference_In_Time", difference_In_Time);
        
        if(type.equals("Reverse"))
        {
            List auctionVendorBid = auctionVendorBidService.readByReverseAuction(refNo);
            mv.getModelMap().put("auctionVendorBid", auctionVendorBid);
        }
        else
        {
            List auctionVendorBid = auctionVendorBidService.readByForwardAuction(refNo);
            mv.getModelMap().put("auctionVendorBid", auctionVendorBid);
        }
        
        String vendor_code = "";
        List auctionVendor = auctionVendorService.readByRefNo(refNo);
        
        mv.getModelMap().put("auctionVendor", auctionVendor);
        
        for (Object o : auctionVendor) {
            //i++;
            AuctionVendor av = (AuctionVendor) o;
            vendor_code = av.getVendorCode();
            
            List auctionVendorBid = auctionVendorBidService.readByAuctionNo(refNo, vendor_code);
            
            
        }
        
            List list = auctionMasterService.liveAuctionList(username, location, department);
            request.setAttribute("list", list);

            mv.getModelMap().put("list", list);
            
            mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("authuser", authuser);
        mv.getModelMap().put("refNo", refNo);
        
        
        

        
        int auction_price_approval_id=0;
        AuctionPriceApproval auctionPriceApproval12 = auctionPriceApprovalService.readByList(refNo);
        auction_price_approval_id = auctionPriceApproval12.getId();
        List list2 = auctionPriceApprovalCommentService.readByRefNo(auction_price_approval_id);
        mv.getModelMap().put("list3", list2);

        //List list = tenderMasterService.liveTenderList(username, location, department);
        request.setAttribute("refNo", refNo);

        mv.getModelMap().put("id", id);
        
        mv.getModelMap().put("auctionMaster", auctionMaster);
        mv.getModelMap().put("auctionPriceApproval", auctionPriceApproval12);
        

        List auctionPriceApproval1 = auctionPriceApprovalService.readByIds(id);
        mv.getModelMap().put("auctionPriceApproval", auctionPriceApproval12);
        mv.setViewName("Auction/ViewapprovePriceBid");
        return mv;
    }
    
    public ModelAndView approveBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        AuctionPriceApproval auctionPriceApproval = auctionPriceApprovalService.readById(Integer.parseInt(id));
        AuctionPriceApprovalUser auctionPriceApprovalUser = auctionPriceApprovalUserService.approvaList2(Integer.parseInt(id));

        int approveId = auctionPriceApproval.getId();
        AuctionPriceApprovalComment auctionPriceApprovalComment = auctionPriceApprovalCommentService.readByApproveId(approveId);

        int totalApproval = auctionPriceApproval.getTotalApproval();
        int ca = auctionPriceApproval.getCurrentApproval();

        int level=0;
        if (totalApproval == ca) {
            auctionPriceApproval.setApprovalStatus(1);
            auctionPriceApprovalUser.setApprovalStatus(1);
            auctionPriceApprovalComment.setApprovalStatus(1);
            
            String auction_no = auctionPriceApproval.getAuctionNo();
            AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
            String user_to = auctionMaster.getAuctionAdmin();
            EmployeeMaster employeeMaster1 = employeeMasterService.read(user_to);
            String email_to = employeeMaster1.getEmailId();
            
            String subject = "";
                String msg = "";
                String mail_from = "";
                String mail_to = email_to;
                
            EmailTemplate emailTemplate = emailTemplateService.readById(14);

                        subject = emailTemplate.getSubject();
                        msg = emailTemplate.getBodytext();
                        
                    msg = msg.replaceAll("\\{tender_title\\}", auctionMaster.getTitle().toUpperCase());
                    msg = msg.replaceAll("\\{ref_no\\}", auctionMaster.getAuctionNo());
                    
                    
                    SendMail s = new SendMail();
                //    s.sendMail(mail_from, mail_to, subject, msg);
                        
        } else {

            level = auctionPriceApprovalUser.getLevel();
            level++;

            auctionPriceApproval.setCurrentApproval(level);
            auctionPriceApprovalUser.setApprovalStatus(1);
            auctionPriceApprovalComment.setApprovalStatus(1);
            

            mv.getModelMap().put("auctionPriceApprovalUser", auctionPriceApprovalUser);

            String auction_no = auctionPriceApproval.getAuctionNo();
            AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
            AuctionPriceApprovalUser auctionPriceApprovalUser1 = auctionPriceApprovalUserService.readByLevel(auction_no, level);

            String user_to = auctionPriceApprovalUser1.getUserId();
            EmployeeMaster employeeMaster1 = employeeMasterService.read(user_to);
            String email_to = employeeMaster1.getEmailId();
            
            String subject = "";
                String msg = "";
                String mail_from = "";
                String mail_to = email_to;
        
                EmailTemplate emailTemplate = emailTemplateService.readById(13);

                        subject = emailTemplate.getSubject();
                        msg = emailTemplate.getBodytext();
                        
                        msg = msg.replaceAll("\\{tender_title\\}", auctionMaster.getTitle().toUpperCase());
                    msg = msg.replaceAll("\\{ref_no\\}", auctionMaster.getAuctionNo());
                    
                    
                    SendMail s = new SendMail();
                //    s.sendMail(mail_from, mail_to, subject, msg);
        }
        
        
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        auctionPriceApprovalComment.setDateTime(formattedDate);
        
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();
        auctionPriceApprovalComment.setUserId(employeeCode);
        auctionPriceApprovalComment.setAuctionApprovalId(approveId);

        auctionPriceApprovalComment.setApprovalComment(comment);
        auctionPriceApprovalCommentService.create(auctionPriceApprovalComment);
        auctionPriceApprovalService.update(auctionPriceApproval);
        auctionPriceApprovalUserService.update(auctionPriceApprovalUser);

         request.setAttribute("successMessage",
                    "Information: Auction Approve successfully");
         
        mv.getModelMap().put("auctionPriceApproval", auctionPriceApproval);
        mv.setViewName("forward:auctionMaster.htm?act=approvePriceBid");
        return mv;
    }
    
    public ModelAndView reworkBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        AuctionPriceApproval auctionPriceApproval = auctionPriceApprovalService.readById(Integer.parseInt(id));
        AuctionPriceApprovalUser auctionPriceApprovalUser = auctionPriceApprovalUserService.approvaList2(Integer.parseInt(id));

        int approveId = auctionPriceApproval.getId();
        AuctionPriceApprovalComment auctionPriceApprovalComment = auctionPriceApprovalCommentService.readByApproveId(approveId);

        String auction_no = auctionPriceApproval.getAuctionNo();
        AuctionMaster auctionMaster = auctionMasterService.readByAuctionNo(auction_no);
        int level = auctionPriceApprovalUser.getLevel();
        if(level>1)
        {
            level--;
            
            AuctionPriceApprovalUser auctionPriceApprovalUser1 = auctionPriceApprovalUserService.readByLevel(auction_no, level);

            String user_to = auctionPriceApprovalUser1.getUserId();
            EmployeeMaster employeeMaster1 = employeeMasterService.read(user_to);
            String email_to = employeeMaster1.getEmailId();
            
            String subject = "";
                String msg = "";
                String mail_from = "";
                String mail_to = email_to;
        
                
            
            
                EmailTemplate emailTemplate = emailTemplateService.readById(23);

                        subject = emailTemplate.getSubject();
                        msg = emailTemplate.getBodytext();
                        
                        msg = msg.replaceAll("\\{tender_title\\}", auctionMaster.getTitle().toUpperCase());
                    msg = msg.replaceAll("\\{ref_no\\}", auctionMaster.getAuctionNo());
                    
                    
                    SendMail s = new SendMail();
                //    s.sendMail(mail_from, mail_to, subject, msg);
        }
        else
        {
            auctionPriceApproval.setApprovalStatus(3);
            
            
            String user_to = auctionMaster.getAuctionAdmin();
            EmployeeMaster employeeMaster1 = employeeMasterService.read(user_to);
            String email_to = employeeMaster1.getEmailId();
            
            String subject = "";
                String msg = "";
                String mail_from = "";
                String mail_to = email_to;
                
            EmailTemplate emailTemplate = emailTemplateService.readById(24);

                        subject = emailTemplate.getSubject();
                        msg = emailTemplate.getBodytext();
                        
                        msg = msg.replaceAll("\\{tender_title\\}", auctionMaster.getTitle().toUpperCase());
                    msg = msg.replaceAll("\\{ref_no\\}", auctionMaster.getAuctionNo());
                    
                    
                    SendMail s = new SendMail();
                //    s.sendMail(mail_from, mail_to, subject, msg);
        }
        auctionPriceApproval.setCurrentApproval(level);
        auctionPriceApprovalUser.setApprovalStatus(2);
        auctionPriceApprovalComment.setApprovalStatus(2);
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        auctionPriceApprovalComment.setDateTime(formattedDate);
        
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();
        auctionPriceApprovalComment.setUserId(employeeCode);
        auctionPriceApprovalComment.setAuctionApprovalId(approveId);

        auctionPriceApprovalComment.setApprovalComment(comment);
        auctionPriceApprovalCommentService.create(auctionPriceApprovalComment);
        
        auctionPriceApprovalService.update(auctionPriceApproval);
        auctionPriceApprovalUserService.update(auctionPriceApprovalUser);
        mv.getModelMap().put("auctionPriceApprovalUser", auctionPriceApprovalUser);
        mv.getModelMap().put("auctionPriceApproval", auctionPriceApproval);

        mv.setViewName("forward:auctionMaster.htm?act=approvePriceBid");
        return mv;
    }
    
    
}
