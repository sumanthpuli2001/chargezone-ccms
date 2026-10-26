/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vendor;

import static com.bul.zydex.controller.CustomAbstract.dateFormat;
import static com.bul.zydex.controller.CustomAbstract.myIp;
import static com.bul.zydex.controller.CustomAbstract.timeFOrmat;
import com.bul.zydex.model.BpGroup;
import com.bul.zydex.model.FileDetail;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.TenderGeneralDoc;
import com.bul.zydex.model.TenderAdditionalDoc;
import com.bul.zydex.model.TenderPreQualification;
import com.bul.zydex.model.TenderTechnicalDoc;
import com.bul.zydex.model.TenderTechnical;
import com.bul.zydex.model.TenderVendorDoc;
import com.bul.zydex.model.VendorEmd;
import com.bul.zydex.model.VendorFee;
import com.bul.zydex.model.VendorPreBid;
import com.bul.zydex.model.VendorPreBidAttachment;
import com.bul.zydex.model.VendorTechnicalBid;
import com.bul.zydex.model.VendorTechnicalBidAttachment;
import com.bul.zydex.model.VendorTechnicalBidTech;
import com.bul.zydex.model.VendorTechnicalBidTerms;
import com.bul.zydex.model.VendorTechnicalBidTechAttachment;
import com.bul.zydex.model.VendorTechnicalBidTermsAttachment;
import com.bul.zydex.model.VendorAttachment;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.VendorTenderBid;
import com.bul.zydex.model.VendorTenderBidItem;
import com.bul.zydex.model.ServiceVendorTenderBid;
import com.bul.zydex.model.ServiceVendorTenderBidItem;
import com.bul.zydex.model.ServiceVendorTenderBidItem2;
import com.bul.zydex.model.ServiceVendorTenderBidItem3;
import com.bul.zydex.model.ServiceVendorTenderBidItem4;
import com.bul.zydex.model.ServiceVendorTenderBidItem6;
import com.bul.zydex.model.VendorInfo;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.model.TenderRegret;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.TenderFollowup;
import com.bul.zydex.model.TenderVendor;
import com.bul.zydex.model.CommMaster;
import com.bul.zydex.model.CommMasterAttachment;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.PRMaster;
import com.bul.zydex.model.ReviseVendorTechnicalBid;
import com.bul.zydex.model.ReviseVendorTenderBid;
import com.bul.zydex.model.ReviseVendorTenderBidItem;
import com.bul.zydex.model.TenderItemMaster;
import com.bul.zydex.model.TermsCondition;
import com.bul.zydex.model.TermsConditionParameter;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorPercentage;
import com.bul.zydex.model.VendorTermsCondition;
import com.bul.zydex.model.VendorTermsConditionPriceBid;
import com.bul.zydex.util.DownloadFile;
import com.bul.zydex.util.PreQualificationExcel;
import com.bul.zydex.util.TechnicalSpecificationExcel;
import com.bul.zydex.util.SendMail;
import com.bul.zydex.util.VendorBidItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author admin
 */
public class VendorController extends VendorAbstract {

    public ModelAndView createVendorPolicy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        //VendorInvitation vendorInvitation = new VendorInvitation(); 
        //readEmployee(request, response);
        //mv.getModelMap().put("vendorInvitation", vendorInvitation);
        mv.setViewName("Vendor/VendorPolicy");
        return mv;
    }

    public ModelAndView liveTender(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List tenderRegret = tenderRegretService.readByVendor(username);

        List list = tenderMasterService.vendorLiveTender(username);

        List list11 = tenderMasterService.vendorLiveTender1(username);

        List list1 = tenderMasterService.vendorOpenTender();

        List list2 = tenderMasterService.allLiveTender();

        List list3 = tenderMasterService.allLiveParticipateTender(username);

        //Revise bid list
        List list4 = tenderMasterService.vendorReviseTenderList(username);

        // Revise Technical Bid list
        List list5 = tenderMasterService.vendorTechnicalReviseTenderList(username);

        List list6 = tenderMasterService.vendorTechnicalList(username);

        request.setAttribute("list", list);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("username", username);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list11", list11);
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("list3", list3);
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("list5", list5);
        mv.getModelMap().put("list6", list6);
        mv.getModelMap().put("tenderRegret", tenderRegret);

        mv.setViewName("Vendor/LiveTender");
        return mv;
    }

    public ModelAndView closeTender(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        //    List tenderRegret = tenderRegretService.readByVendorBid(username);
        List list = vendorTenderBidService.readByVendorBid(username);

        List list1 = tenderMasterService.vendorOpenTender();

        List list2 = tenderMasterService.allLiveTender();

        List list3 = tenderMasterService.allLiveParticipateTender(username);

        request.setAttribute("list", list);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("username", username);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("list1", list1);
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("list3", list3);

        mv.setViewName("Vendor/CloseTender");
        return mv;
    }

    public ModelAndView acceptanceTender(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List list = vendorTenderBidService.readByVendorAward(username);

        request.setAttribute("list", list);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("username", username);
        mv.getModelMap().put("list", list);

        mv.setViewName("Vendor/AcceptanceTender");
        return mv;
    }

    public ModelAndView acceptanceTenderView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String refNo = request.getParameter("refNo");

        String vendorCode = request.getParameter("vendorCode");
        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);
        String title = tenderMaster.getTitle();
        String projectId = tenderMaster.getProjectId();
        int tenderPhase = tenderMaster.getTenderPhase();
        String emd = tenderMaster.getEmd();
        String fee = tenderMaster.getDocCost();
        String prNo = tenderMaster.getPrNo();

        String announceDate = tenderMaster.getAnnounceDate();
        String submitLastdate = tenderMaster.getSubmitLastdate();
        String contactPerson = tenderMaster.getContactPerson();
        String tenderAdminContactNumber = tenderMaster.getTenderAdminContactNumber();
        String tenderAuthorizePerson = tenderMaster.getTenderAuthorizePerson();
        String tenderAuthorizeContactNo = tenderMaster.getTenderAuthorizeContactNo();

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("title", title);
        mv.getModelMap().put("projectId", projectId);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("announceDate", announceDate);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        mv.getModelMap().put("contactPerson", contactPerson);
        mv.getModelMap().put("tenderAdminContactNumber", tenderAdminContactNumber);
        mv.getModelMap().put("tenderAuthorizePerson", tenderAuthorizePerson);
        mv.getModelMap().put("tenderAuthorizeContactNo", tenderAuthorizeContactNo);

        PRMaster prMaster = prMasterService.readByPrNo(prNo);
        mv.getModelMap().put("prMaster", prMaster);
        List MultipleAddress = multipleAddressService.readByPrNumber(prNo);
        mv.getModelMap().put("MultipleAddress", MultipleAddress);

        String rfqNo = "";
        String vendorName = "";
        List tenderVendor = tenderVendorService.readByVendor(refNo, vendorCode);
        for (Object o : tenderVendor) {
            TenderVendor tv = (TenderVendor) o;
            rfqNo = tv.getRfqNo();
            vendorName = tv.getVendorName();
        }

        mv.getModelMap().put("rfqNo", rfqNo);
        mv.getModelMap().put("vendorCode", vendorCode);
        mv.getModelMap().put("vendorName", vendorName);

        String technicalRemark = "";
        List tenderTechnical = tenderTechnicalService.readByRefNo(refNo);
        for (Object o : tenderTechnical) {
            TenderTechnical tt = (TenderTechnical) o;
            technicalRemark = tt.getRemark();
        }

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();

        UserRights userRights = userRightsService.readByUser(username);

        List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, vendorCode);

        mv.getModelMap().put("vendorTermsCondition1", vendorTermsCondition1);

        List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, vendorCode, 0);

        int item_type = 1;

        List vendorTenderBidItem1 = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, vendorCode, item_type);

        mv.getModelMap().put("vendorTenderBidItem1", vendorTenderBidItem1);
        mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);

        List reviseVendorTenderBidItem = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, vendorCode, 0);

        List revisevendorTenderBidItem1 = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, vendorCode, item_type);

        mv.getModelMap().put("reviseVendorTenderBidItem", reviseVendorTenderBidItem);
        mv.getModelMap().put("revisevendorTenderBidItem1", revisevendorTenderBidItem1);

        if (reviseVendorTenderBidItem.size() > 0) {
            ReviseVendorTenderBid vendorTenderBid = reviseVendorTenderBidService.readByVendorRefNo(refNo, vendorCode);

            String offerNo = vendorTenderBid.getOfferNo();
            String offerDate = vendorTenderBid.getOfferDate();
            String contact_person = vendorTenderBid.getContactPerson();
            String contact_no = vendorTenderBid.getContactNo();
            String contact_email = vendorTenderBid.getConactEmail();
            String gst_no = vendorTenderBid.getGstNo();

            String serviceDiscountType = vendorTenderBid.getServiceDiscountType();
            String serviceDiscountValue = vendorTenderBid.getServiceDiscountValue();
            String servicegst = vendorTenderBid.getServiceGst();
            String serviceTaxTotal = vendorTenderBid.getServiceTaxTotal();
            String serviceTotal = vendorTenderBid.getServiceTotal();

            if (serviceTotal == null) {
                serviceTotal = "0.0";
            }

            mv.getModelMap().put("serviceDiscountType", serviceDiscountType);
            mv.getModelMap().put("serviceDiscountValue", serviceDiscountValue);
            mv.getModelMap().put("servicegst", servicegst);
            mv.getModelMap().put("serviceTaxTotal", serviceTaxTotal);
            mv.getModelMap().put("serviceTotal", serviceTotal);

            mv.getModelMap().put("vendorTenderBid", vendorTenderBid);
            mv.getModelMap().put("offerNo", offerNo);
            mv.getModelMap().put("offerDate", offerDate);
            mv.getModelMap().put("contact_person", contact_person);
            mv.getModelMap().put("contact_no", contact_no);
            mv.getModelMap().put("contact_email", contact_email);
            mv.getModelMap().put("gst_no", gst_no);

            String deliveryLocation = vendorTenderBid.getDeliveryLocation();
            String deliveryPeriod = vendorTenderBid.getDeliveryPeriod();
            String termsOfPayment = vendorTenderBid.getTermsOfPayment();
            String validityPeriod = vendorTenderBid.getValidityPeriod();
            String modeOfTransport = vendorTenderBid.getModeOfTransport();
            String incoTerms = vendorTenderBid.getIncoTerms();
            String insurance = vendorTenderBid.getInsurance();
            String freight = vendorTenderBid.getFreight();

            mv.getModelMap().put("deliveryLocation", deliveryLocation);
            mv.getModelMap().put("deliveryPeriod", deliveryPeriod);
            mv.getModelMap().put("termsOfPayment", termsOfPayment);
            mv.getModelMap().put("validityPeriod", validityPeriod);
            mv.getModelMap().put("modeOfTransport", modeOfTransport);
            mv.getModelMap().put("incoTerms", incoTerms);
            mv.getModelMap().put("insurance", insurance);
            mv.getModelMap().put("freight", freight);

            String itemTotal = vendorTenderBid.getItemTotal();
            String selectCommon = vendorTenderBid.getSelectCommon();
            String discountType = vendorTenderBid.getDiscountType();
            String discountValue = vendorTenderBid.getDiscountValue();
            String packingType = vendorTenderBid.getPackingType();
            String packingValue = vendorTenderBid.getPackingValue();
            String freightType = vendorTenderBid.getFreightType();
            String freightValue = vendorTenderBid.getFreightValue();
            String errectionValue = vendorTenderBid.getErrectionValue();
            String chargesValue = vendorTenderBid.getChargesValue();
            String igstValue = vendorTenderBid.getIgstValue();
            String cgstValue = vendorTenderBid.getCgstValue();
            String sgstValue = vendorTenderBid.getSgstValue();
            String insuranceValue = vendorTenderBid.getInsuranceValue();
            String grandTotal = vendorTenderBid.getGrandTotal();
            String grandTotalWord = vendorTenderBid.getGrandTotalWord();

            String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
            String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();
            mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
            mv.getModelMap().put("free_delivery_comment", free_delivery_comment);

            mv.getModelMap().put("itemTotal", itemTotal);
            mv.getModelMap().put("selectCommon", selectCommon);
            mv.getModelMap().put("discountType", discountType);
            mv.getModelMap().put("discountValue", discountValue);
            mv.getModelMap().put("packingType", packingType);
            mv.getModelMap().put("packingValue", packingValue);
            mv.getModelMap().put("freightType", freightType);
            mv.getModelMap().put("freightValue", freightValue);
            mv.getModelMap().put("errectionValue", errectionValue);
            mv.getModelMap().put("chargesValue", chargesValue);
            mv.getModelMap().put("igstValue", igstValue);
            mv.getModelMap().put("cgstValue", cgstValue);
            mv.getModelMap().put("sgstValue", sgstValue);
            mv.getModelMap().put("insuranceValue", insuranceValue);
            mv.getModelMap().put("grandTotal", grandTotal);
            mv.getModelMap().put("grandTotalWord", grandTotalWord);

            Double itemTotalFinal = Double.parseDouble(itemTotal);
            Double discountValueFinal = 0.0;
            Double packingValueFinal = 0.0;
            Double freightValueFinal = 0.0;
            Double errectionValueFinal = 0.0;
            Double chargesValueFinal = 0.0;
            Double igstValueFinal = 0.0;
            Double cgstValueFinal = 0.0;
            Double sgstValueFinal = 0.0;
            Double insuranceValueFinal = 0.0;
            Double grandTotalFinal = 0.0;
            Double Total = 0.0;

            Double serviceTotalFinal = Double.parseDouble(serviceTotal);
            Double serviceDiscountValueFinal = 0.0;
            Double servicegstFinal = 0.0;
            Double serviceTaxTotalFinal = 0.0;
            Double serviceDiscountTypeFinal = 0.0;
            Double serviceTotal1 = 0.0;

            ArrayList<VendorBidItem> vbi = new ArrayList<VendorBidItem>();

            if (selectCommon.equals("1")) {
                Total = itemTotalFinal;

                if (packingType.equals("0")) {
                    packingValueFinal = Double.parseDouble(packingValue) * Total / 100;
                } else {
                    packingValueFinal = Double.parseDouble(packingValue);
                }
                long tmp = Math.round(packingValueFinal * 100);
                packingValueFinal = (double) tmp / 100;

                chargesValueFinal = Double.parseDouble(chargesValue) * Total / 100;
                tmp = Math.round(chargesValueFinal * 100);
                chargesValueFinal = (double) tmp / 100;

                insuranceValueFinal = Double.parseDouble(insuranceValue) * Total / 100;
                tmp = Math.round(insuranceValueFinal * 100);
                insuranceValueFinal = (double) tmp / 100;

                errectionValueFinal = Double.parseDouble(errectionValue) * Total / 100;
                tmp = Math.round(errectionValueFinal * 100);
                errectionValueFinal = (double) tmp / 100;

                Total = Total + packingValueFinal;
                Total = Total + errectionValueFinal;
                Total = Total + insuranceValueFinal;
                Total = Total + chargesValueFinal;

                if (discountType.equals("0")) {
                    discountValueFinal = Double.parseDouble(discountValue) * Total / 100;
                } else {
                    discountValueFinal = Double.parseDouble(discountValue);
                }
                tmp = Math.round(discountValueFinal * 100);
                discountValueFinal = (double) tmp / 100;
                Total = Total - discountValueFinal;

                igstValueFinal = Double.parseDouble(igstValue) * Total / 100;
                tmp = Math.round(igstValueFinal * 100);
                igstValueFinal = (double) tmp / 100;
                cgstValueFinal = Double.parseDouble(cgstValue) * Total / 100;
                tmp = Math.round(cgstValueFinal * 100);
                cgstValueFinal = (double) tmp / 100;
                sgstValueFinal = Double.parseDouble(sgstValue) * Total / 100;
                tmp = Math.round(sgstValueFinal * 100);
                sgstValueFinal = (double) tmp / 100;
                Total = Total + igstValueFinal + cgstValueFinal + sgstValueFinal;

            }

            if (selectCommon.equals("1")) {

                try {
                    serviceTotal1 = serviceTotalFinal;

                    if (serviceDiscountType.equals("0")) {
                        serviceDiscountValueFinal = Double.parseDouble(serviceDiscountValue) * serviceTotal1 / 100;
                    } else {
                        serviceDiscountValueFinal = Double.parseDouble(serviceDiscountValue);
                    }

                    long tmp1 = Math.round(serviceDiscountValueFinal * 100);
                    serviceDiscountValueFinal = (double) tmp1 / 100;
                    serviceTotal1 = serviceTotalFinal - serviceDiscountValueFinal;

                    servicegstFinal = Double.parseDouble(servicegst) * serviceTotal1 / 100;
                    tmp1 = Math.round(servicegstFinal * 100);
                    servicegstFinal = (double) tmp1 / 100;

                } catch (Exception e) {

                }

            }

            mv.getModelMap().put("serviceTotalFinal", serviceTotalFinal);
            mv.getModelMap().put("serviceDiscountValueFinal", serviceDiscountValueFinal);
            mv.getModelMap().put("servicegstFinal", servicegstFinal);
            mv.getModelMap().put("serviceTaxTotalFinal", serviceTaxTotalFinal);
            mv.getModelMap().put("serviceDiscountTypeFinal", serviceDiscountTypeFinal);
            mv.getModelMap().put("serviceTotal1", serviceTotal1);

            mv.getModelMap().put("discountValueFinal", discountValueFinal);
            mv.getModelMap().put("packingValueFinal", packingValueFinal);
            mv.getModelMap().put("freightValueFinal", freightValueFinal);
            mv.getModelMap().put("errectionValueFinal", errectionValueFinal);
            mv.getModelMap().put("chargesValueFinal", chargesValueFinal);
            mv.getModelMap().put("igstValueFinal", igstValueFinal);
            mv.getModelMap().put("cgstValueFinal", cgstValueFinal);
            mv.getModelMap().put("sgstValueFinal", sgstValueFinal);
            mv.getModelMap().put("insuranceValueFinal", insuranceValueFinal);
            mv.getModelMap().put("grandTotalFinal", grandTotalFinal);
            mv.getModelMap().put("Total", Total);
        } else {
            VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, vendorCode);

            String offerNo = vendorTenderBid.getOfferNo();
            String offerDate = vendorTenderBid.getOfferDate();
            String contact_person = vendorTenderBid.getContactPerson();
            String contact_no = vendorTenderBid.getContactNo();
            String contact_email = vendorTenderBid.getConactEmail();
            String gst_no = vendorTenderBid.getGstNo();

            String serviceDiscountType = vendorTenderBid.getServiceDiscountType();
            String serviceDiscountValue = vendorTenderBid.getServiceDiscountValue();
            String servicegst = vendorTenderBid.getServiceGst();
            String serviceTaxTotal = vendorTenderBid.getServiceTaxTotal();
            String serviceTotal = vendorTenderBid.getServiceTotal();

            if (serviceTotal == null) {
                serviceTotal = "0.0";
            }

            mv.getModelMap().put("serviceDiscountType", serviceDiscountType);
            mv.getModelMap().put("serviceDiscountValue", serviceDiscountValue);
            mv.getModelMap().put("servicegst", servicegst);
            mv.getModelMap().put("serviceTaxTotal", serviceTaxTotal);
            mv.getModelMap().put("serviceTotal", serviceTotal);

            mv.getModelMap().put("vendorTenderBid", vendorTenderBid);
            mv.getModelMap().put("offerNo", offerNo);
            mv.getModelMap().put("offerDate", offerDate);
            mv.getModelMap().put("contact_person", contact_person);
            mv.getModelMap().put("contact_no", contact_no);
            mv.getModelMap().put("contact_email", contact_email);
            mv.getModelMap().put("gst_no", gst_no);

            String deliveryLocation = vendorTenderBid.getDeliveryLocation();
            String deliveryPeriod = vendorTenderBid.getDeliveryPeriod();
            String termsOfPayment = vendorTenderBid.getTermsOfPayment();
            String validityPeriod = vendorTenderBid.getValidityPeriod();
            String modeOfTransport = vendorTenderBid.getModeOfTransport();
            String incoTerms = vendorTenderBid.getIncoTerms();
            String insurance = vendorTenderBid.getInsurance();
            String freight = vendorTenderBid.getFreight();

            mv.getModelMap().put("deliveryLocation", deliveryLocation);
            mv.getModelMap().put("deliveryPeriod", deliveryPeriod);
            mv.getModelMap().put("termsOfPayment", termsOfPayment);
            mv.getModelMap().put("validityPeriod", validityPeriod);
            mv.getModelMap().put("modeOfTransport", modeOfTransport);
            mv.getModelMap().put("incoTerms", incoTerms);
            mv.getModelMap().put("insurance", insurance);
            mv.getModelMap().put("freight", freight);

            String itemTotal = vendorTenderBid.getItemTotal();
            String selectCommon = vendorTenderBid.getSelectCommon();
            String discountType = vendorTenderBid.getDiscountType();
            String discountValue = vendorTenderBid.getDiscountValue();
            String packingType = vendorTenderBid.getPackingType();
            String packingValue = vendorTenderBid.getPackingValue();
            String freightType = vendorTenderBid.getFreightType();
            String freightValue = vendorTenderBid.getFreightValue();
            String errectionValue = vendorTenderBid.getErrectionValue();
            String chargesValue = vendorTenderBid.getChargesValue();
            String igstValue = vendorTenderBid.getIgstValue();
            String cgstValue = vendorTenderBid.getCgstValue();
            String sgstValue = vendorTenderBid.getSgstValue();
            String insuranceValue = vendorTenderBid.getInsuranceValue();
            String grandTotal = vendorTenderBid.getGrandTotal();
            String grandTotalWord = vendorTenderBid.getGrandTotalWord();

            String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
            String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();
            mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
            mv.getModelMap().put("free_delivery_comment", free_delivery_comment);

            mv.getModelMap().put("itemTotal", itemTotal);
            mv.getModelMap().put("selectCommon", selectCommon);
            mv.getModelMap().put("discountType", discountType);
            mv.getModelMap().put("discountValue", discountValue);
            mv.getModelMap().put("packingType", packingType);
            mv.getModelMap().put("packingValue", packingValue);
            mv.getModelMap().put("freightType", freightType);
            mv.getModelMap().put("freightValue", freightValue);
            mv.getModelMap().put("errectionValue", errectionValue);
            mv.getModelMap().put("chargesValue", chargesValue);
            mv.getModelMap().put("igstValue", igstValue);
            mv.getModelMap().put("cgstValue", cgstValue);
            mv.getModelMap().put("sgstValue", sgstValue);
            mv.getModelMap().put("insuranceValue", insuranceValue);
            mv.getModelMap().put("grandTotal", grandTotal);
            mv.getModelMap().put("grandTotalWord", grandTotalWord);

            Double itemTotalFinal = Double.parseDouble(itemTotal);
            Double discountValueFinal = 0.0;
            Double packingValueFinal = 0.0;
            Double freightValueFinal = 0.0;
            Double errectionValueFinal = 0.0;
            Double chargesValueFinal = 0.0;
            Double igstValueFinal = 0.0;
            Double cgstValueFinal = 0.0;
            Double sgstValueFinal = 0.0;
            Double insuranceValueFinal = 0.0;
            Double grandTotalFinal = 0.0;
            Double Total = 0.0;

            Double serviceTotalFinal = Double.parseDouble(serviceTotal);
            Double serviceDiscountValueFinal = 0.0;
            Double servicegstFinal = 0.0;
            Double serviceTaxTotalFinal = 0.0;
            Double serviceDiscountTypeFinal = 0.0;
            Double serviceTotal1 = 0.0;

            ArrayList<VendorBidItem> vbi = new ArrayList<VendorBidItem>();

            if (selectCommon.equals("1")) {
                Total = itemTotalFinal;

                if (packingType.equals("0")) {
                    packingValueFinal = Double.parseDouble(packingValue) * Total / 100;
                } else {
                    packingValueFinal = Double.parseDouble(packingValue);
                }
                long tmp = Math.round(packingValueFinal * 100);
                packingValueFinal = (double) tmp / 100;

                chargesValueFinal = Double.parseDouble(chargesValue) * Total / 100;
                tmp = Math.round(chargesValueFinal * 100);
                chargesValueFinal = (double) tmp / 100;

                insuranceValueFinal = Double.parseDouble(insuranceValue) * Total / 100;
                tmp = Math.round(insuranceValueFinal * 100);
                insuranceValueFinal = (double) tmp / 100;

                errectionValueFinal = Double.parseDouble(errectionValue) * Total / 100;
                tmp = Math.round(errectionValueFinal * 100);
                errectionValueFinal = (double) tmp / 100;

                Total = Total + packingValueFinal;
                Total = Total + errectionValueFinal;
                Total = Total + insuranceValueFinal;
                Total = Total + chargesValueFinal;

                if (discountType.equals("0")) {
                    discountValueFinal = Double.parseDouble(discountValue) * Total / 100;
                } else {
                    discountValueFinal = Double.parseDouble(discountValue);
                }
                tmp = Math.round(discountValueFinal * 100);
                discountValueFinal = (double) tmp / 100;
                Total = Total - discountValueFinal;

                igstValueFinal = Double.parseDouble(igstValue) * Total / 100;
                tmp = Math.round(igstValueFinal * 100);
                igstValueFinal = (double) tmp / 100;
                cgstValueFinal = Double.parseDouble(cgstValue) * Total / 100;
                tmp = Math.round(cgstValueFinal * 100);
                cgstValueFinal = (double) tmp / 100;
                sgstValueFinal = Double.parseDouble(sgstValue) * Total / 100;
                tmp = Math.round(sgstValueFinal * 100);
                sgstValueFinal = (double) tmp / 100;
                Total = Total + igstValueFinal + cgstValueFinal + sgstValueFinal;

            }

            if (selectCommon.equals("1")) {

                try {
                    serviceTotal1 = serviceTotalFinal;

                    if (serviceDiscountType.equals("0")) {
                        serviceDiscountValueFinal = Double.parseDouble(serviceDiscountValue) * serviceTotal1 / 100;
                    } else {
                        serviceDiscountValueFinal = Double.parseDouble(serviceDiscountValue);
                    }

                    long tmp1 = Math.round(serviceDiscountValueFinal * 100);
                    serviceDiscountValueFinal = (double) tmp1 / 100;
                    serviceTotal1 = serviceTotalFinal - serviceDiscountValueFinal;

                    servicegstFinal = Double.parseDouble(servicegst) * serviceTotal1 / 100;
                    tmp1 = Math.round(servicegstFinal * 100);
                    servicegstFinal = (double) tmp1 / 100;

                } catch (Exception e) {

                }

            }

            mv.getModelMap().put("serviceTotalFinal", serviceTotalFinal);
            mv.getModelMap().put("serviceDiscountValueFinal", serviceDiscountValueFinal);
            mv.getModelMap().put("servicegstFinal", servicegstFinal);
            mv.getModelMap().put("serviceTaxTotalFinal", serviceTaxTotalFinal);
            mv.getModelMap().put("serviceDiscountTypeFinal", serviceDiscountTypeFinal);
            mv.getModelMap().put("serviceTotal1", serviceTotal1);

            mv.getModelMap().put("discountValueFinal", discountValueFinal);
            mv.getModelMap().put("packingValueFinal", packingValueFinal);
            mv.getModelMap().put("freightValueFinal", freightValueFinal);
            mv.getModelMap().put("errectionValueFinal", errectionValueFinal);
            mv.getModelMap().put("chargesValueFinal", chargesValueFinal);
            mv.getModelMap().put("igstValueFinal", igstValueFinal);
            mv.getModelMap().put("cgstValueFinal", cgstValueFinal);
            mv.getModelMap().put("sgstValueFinal", sgstValueFinal);
            mv.getModelMap().put("insuranceValueFinal", insuranceValueFinal);
            mv.getModelMap().put("grandTotalFinal", grandTotalFinal);
            mv.getModelMap().put("Total", Total);
        }

        int revise_technical_bid_id = 0;
        String technicalBidDeviation = "";
        String technicalBidRemark = "";
        List reviseVendorTechnicalBid = reviseVendorTechnicalBidService.readByVendorRefNo(refNo, vendorCode);

        if (reviseVendorTechnicalBid.size() > 0) {
            for (Object o : reviseVendorTechnicalBid) {
                ReviseVendorTechnicalBid rvtb = (ReviseVendorTechnicalBid) o;
                revise_technical_bid_id = rvtb.getId();
                technicalBidDeviation = rvtb.getTechnicalDeviation();
                technicalBidRemark = rvtb.getTechnicalRemark();
                break;
            }
        } else {
            VendorTechnicalBid vendorTechnicalBid = vendorTechnicalBidService.readByVendorRefNo(refNo, vendorCode);
            technicalBidDeviation = vendorTechnicalBid.getTechnicalDeviation();
            technicalBidRemark = vendorTechnicalBid.getTechnicalRemark();
        }

        List vendorTechnicalBidTech = vendorTechnicalBidTechService.readByReviseVendorBid(refNo, vendorCode, revise_technical_bid_id);

        List vendorTechnicalBidTerms = vendorTechnicalBidTermsService.readByReviseVendorBid(refNo, vendorCode, revise_technical_bid_id);

        mv.getModelMap().put("vendorTechnicalBidTech", vendorTechnicalBidTech);
        mv.getModelMap().put("vendorTechnicalBidTerms", vendorTechnicalBidTerms);

        request.setAttribute("refNo", refNo);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("title", title);
        mv.getModelMap().put("projectId", projectId);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.setViewName("Vendor/AcceptanceTenderView");
        return mv;
    }

    public ModelAndView acceptanceTenderSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String refNo = request.getParameter("refNo");

        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);

        String location = tenderMaster.getLocation();

        String tenderPhase = request.getParameter("tenderPhase");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        //HttpSession session = request.getSession(false);
        UserMaster user11 = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Tender Acceptance for tender no " + refNo + " vednor " + username + "").setDrow("Y");
        logService.create(lm);

        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        TenderFollowup tenderFollowup = new TenderFollowup();
        tenderFollowup.setActivityDate(formattedDate1);
        tenderFollowup.setActivity("Tender Acceptance for tender no " + refNo + " Vendor Code " + username + "");
        tenderFollowup.setLocation(location);
        tenderFollowup.setTenderNo(refNo);
        tenderFollowup.setPerson(user11.getLoginName());
        tenderFollowup.setPersonFullname(user11.getUserFullName());
        tenderFollowupService.create(tenderFollowup);

        String pr_no = tenderMaster.getPrNo();

        PRMaster prMaster = prMasterService.readByPrNo(pr_no);
        prMaster.setTenderAcceptUser(username);
        prMaster.setTenderAcceptDate(formattedDate1);
        prMasterService.update(prMaster);

        List list = vendorTenderBidService.readByVendorAward(username);

        request.setAttribute("list", list);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("username", username);
        mv.getModelMap().put("list", list);

        mv.setViewName("Vendor/AcceptanceTender");
        return mv;
    }

    public ModelAndView acceptanceTenderReject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String refNo = request.getParameter("refNo");

        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);

        String location = tenderMaster.getLocation();

        String tenderPhase = request.getParameter("tenderPhase");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        //HttpSession session = request.getSession(false);
        UserMaster user11 = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Tender Acceptance Reject for tender no " + refNo + " vednor " + username + "").setDrow("Y");
        logService.create(lm);

        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        TenderFollowup tenderFollowup = new TenderFollowup();
        tenderFollowup.setActivityDate(formattedDate1);
        tenderFollowup.setActivity("Tender Acceptance Reject for tender no " + refNo + " Vendor Code " + username + "");
        tenderFollowup.setLocation(location);
        tenderFollowup.setTenderNo(refNo);
        tenderFollowup.setPerson(user11.getLoginName());
        tenderFollowup.setPersonFullname(user11.getUserFullName());
        tenderFollowupService.create(tenderFollowup);

        String pr_no = tenderMaster.getPrNo();

        List list = vendorTenderBidService.readByVendorAward(username);

        request.setAttribute("list", list);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("username", username);
        mv.getModelMap().put("list", list);

        mv.setViewName("Vendor/AcceptanceTender");
        return mv;
    }

    public ModelAndView bidTenderForPreQualification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        String tender_type = tenderMaster.getTenderType();

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);
        List tenderVendorDocs = tenderVendorDocService.readByRefNo(refNo, username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //get pre qualiication details
        VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
        String preBidDeviation = vendorPreBid.getPreBidDeviation();
        String preBidRemark = vendorPreBid.getPreBidRemark();

        List vendorPreBidAttachment = vendorPreBidAttachmentService.readByVendorRefNo(refNo, username);

        List list = tenderPreQualificationService.readByRefNo(refNo);

        String technicalfile = "";
        String document_ref_no = "";

        for (Object o : list) {
            TenderPreQualification pdm = (TenderPreQualification) o;
            technicalfile = pdm.getDocument();
            document_ref_no = pdm.getDocumentRefNo();
        }

        ArrayList<PreQualificationExcel> al = new ArrayList<PreQualificationExcel>();
        //read excel file

        try {

            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo + "/" + technicalfile);

            if (tender_type.equals("Service Manually")) {
                file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + document_ref_no + "/" + technicalfile);
            }

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
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        if (i == 1) {
                            srNo = cell.getNumericCellValue() + "";
                        }
                        if (i == 2) {
                            desc = cell.getStringCellValue();
                        }
                        if (i == 3) {
                            comp = cell.getStringCellValue();
                        }

                    }

                    PreQualificationExcel preQualificationExcel = new PreQualificationExcel(1, srNo, desc, comp);
                    //ArrayList<PreQualificationExcel> al=new ArrayList<PreQualificationExcel>();  
                    al.add(preQualificationExcel);

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);

        int rivision = vendorTenderBid.getRevision();

        mv.getModelMap().put("rivision", rivision);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("vendor_code", username);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);

        mv.getModelMap().put("al", al);
        mv.getModelMap().put("vendorPreBidAttachment", vendorPreBidAttachment);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("tenderVendorDocs", tenderVendorDocs);

        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);
        mv.getModelMap().put("preBidDeviation", preBidDeviation);
        mv.getModelMap().put("preBidRemark", preBidRemark);

        mv.setViewName("Vendor/BidTenderForPreQualification");
        return mv;
    }

    public ModelAndView bidTenderForPreQualificationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        String tender_type = tenderMaster.getTenderType();

        // emd
        if (emd != "0") {
            String emd_date = request.getParameter("emd_date");
            String emd_drawee_bank = request.getParameter("emd_drawee_bank");
            String cash_cheque = request.getParameter("cash_cheque");
            String emd_cheque_no = request.getParameter("emd_cheque_no");

            String emd_attach = request.getParameter("emd_attach");
            if (emd_attach == null) {
                emd_attach = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("emd_attach");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    emd_attach = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List vendorEmd1 = vendorEmdService.readVendorRefNo(refNo, username);

            if (vendorEmd1.isEmpty()) {
                VendorEmd vendorEmd = new VendorEmd();
                vendorEmd.setRefNo(refNo);
                vendorEmd.setVendorCode(username);
                vendorEmd.setEmdAmount(emd);
                vendorEmd.setEmdDate(emd_date);
                vendorEmd.setDraweeBank(emd_drawee_bank);
                vendorEmd.setAttachment(emd_attach);
                vendorEmd.setCashCheque(cash_cheque);
                vendorEmd.setChequeNo(emd_cheque_no);
                vendorEmdService.create(vendorEmd);
            } else {
                vendorEmdService.updateVendorRefNo(refNo, username, emd, emd_date, emd_drawee_bank, emd_attach, cash_cheque, emd_cheque_no);
            }
        }

        //fee
        if (doc_cost != "0") {
            String fee_date = request.getParameter("fee_date");
            String fee_drawee_bank = request.getParameter("fee_drawee_bank");
            String fee_cheque_no = request.getParameter("fee_cheque_no");

            String fee_attach = request.getParameter("fee_attach");
            if (fee_attach == null) {
                fee_attach = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("fee_attach");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    fee_attach = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List vendorFee1 = vendorFeeService.readVendorRefNo(refNo, username);

            if (vendorFee1.isEmpty()) {
                VendorFee vendorFee = new VendorFee();
                vendorFee.setRefNo(refNo);
                vendorFee.setVendorCode(username);
                vendorFee.setFeeAmount(doc_cost);
                vendorFee.setFeeDate(fee_date);
                vendorFee.setDraweeBank(fee_drawee_bank);
                vendorFee.setAttachment(fee_attach);
                vendorFee.setChequeNo(fee_cheque_no);
                vendorFeeService.create(vendorFee);
            } else {
                vendorFeeService.updateVendorRefNo(refNo, username, doc_cost, fee_date, fee_drawee_bank, fee_attach, fee_cheque_no);
            }
        }

        //pre qualiication details
        String preBidDeviation = request.getParameter("preBidDeviation");
        String preBidRemark = request.getParameter("preBidRemark");

        List vendorPreBid1 = vendorPreBidService.readVendorRefNo(refNo, username);

        if (vendorPreBid1.isEmpty()) {
            VendorPreBid vendorPreBid = new VendorPreBid();
            vendorPreBid.setRefNo(refNo);
            vendorPreBid.setVendorCode(username);
            vendorPreBid.setPreBidDeviation(preBidDeviation);
            vendorPreBid.setPreBidRemark(preBidRemark);
            vendorPreBidService.create(vendorPreBid);
        } else {
            vendorPreBidService.updateVendorRefNo(refNo, username, preBidDeviation, preBidRemark);
        }

        // Pri bid attachment
        String[] pre_attachment_desc = request.getParameterValues("pre_attachment_desc");
        String[] pre_attachment_comp = request.getParameterValues("pre_attachment_comp");
        int j = 0;
        for (int i = 0; i < pre_attachment_desc.length; i++) {
            j++;
            String pre_attachment = request.getParameter("pre_attachment" + j);
            if (pre_attachment == null) {
                pre_attachment = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("pre_attachment" + j);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    pre_attachment = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List vendorPreBidAttachment1 = vendorPreBidAttachmentService.readVendorRefNo(refNo, username, pre_attachment_desc[i]);

            if (vendorPreBidAttachment1.isEmpty()) {
                VendorPreBidAttachment vendorPreBidAttachment = new VendorPreBidAttachment();
                vendorPreBidAttachment.setRefNo(refNo);
                vendorPreBidAttachment.setVendorCode(username);
                vendorPreBidAttachment.setDescription(pre_attachment_desc[i]);
                vendorPreBidAttachment.setAttachmentRequired(pre_attachment_comp[i]);
                vendorPreBidAttachment.setAttachment(pre_attachment);
                vendorPreBidAttachmentService.create(vendorPreBidAttachment);
            } else {
                if (pre_attachment != "") {
                    vendorPreBidAttachmentService.updateVendorRefNo(refNo, username, pre_attachment_desc[i], pre_attachment_comp[i], pre_attachment);
                }
            }

        }

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);
        List tenderVendorDocs = tenderVendorDocService.readByRefNo(refNo, username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //---------------------------------
        //get Technical details
        VendorTechnicalBid vendorTechnicalBid = vendorTechnicalBidService.readByVendorRefNo(refNo, username);
        String technicalBidDeviation = vendorTechnicalBid.getTechnicalDeviation();
        String technicalBidRemark = vendorTechnicalBid.getTechnicalRemark();

        List vendorTechnicalBidTech = vendorTechnicalBidTechService.readByVendorRefNo(refNo, username);
        List vendorTechnicalBidTerms = vendorTechnicalBidTermsService.readByVendorRefNo(refNo, username);
        List vendorTechnicalBidAttachment = vendorTechnicalBidAttachmentService.readByVendorRefNo(refNo, username);

        List vendorTechnicalBidTechAttachment = vendorTechnicalBidTechAttachmentService.readByVendorRefNo(refNo, username);
        List vendorTechnicalBidTermsAttachment = vendorTechnicalBidTermsAttachmentService.readByVendorRefNo(refNo, username);

        List list = tenderTechnicalService.readByRefNo(refNo);

        String technicalfile = "";
        String termsConditionfile = "";
        String attachmentfile = "";
        String tech_doc_ref_no = "";
        String terms_doc_ref_no = "";
        String doc_ref_no = "";

        for (Object o : list) {
            TenderTechnical pdm = (TenderTechnical) o;
            technicalfile = pdm.getTechnicalDoc();
            termsConditionfile = pdm.getTermsConditionDoc();
            attachmentfile = pdm.getDocument();
            tech_doc_ref_no = pdm.getTechnicalRefNo();
            terms_doc_ref_no = pdm.getTermsRefNo();
            doc_ref_no = pdm.getDocumentRefNo();
        }

        // technical file
        ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTech1 = new ArrayList<TechnicalSpecificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo + "/" + technicalfile);
            if (tender_type.equals("Service Manually")) {
                file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + tech_doc_ref_no + "/" + technicalfile);
            }
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
            j = 0;
            while (itr.hasNext()) {
                j++;

                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String srNo = "";
                    String desc = "";
                    String remark = "";
                    String comp = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        try {
                            if (i == 1) {
                                srNo = cell.getNumericCellValue() + "";
                            }
                            if (i == 2) {
                                desc = cell.getStringCellValue();
                            }
                            if (i == 3) {
                                comp = cell.getStringCellValue();
                            }
                            if (i == 4) {
                                remark = cell.getStringCellValue();
                            }

                        } catch (Exception e11) {
                        }

                    }

                    TechnicalSpecificationExcel technicalSpecificationExcel = new TechnicalSpecificationExcel(1, srNo, desc, remark, comp);
                    vendorTechnicalBidTech1.add(technicalSpecificationExcel);

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //trems and condition file attacment --------------------------
        ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTerms1 = new ArrayList<TechnicalSpecificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo + "/" + termsConditionfile);
            if (tender_type.equals("Service Manually")) {
                file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + terms_doc_ref_no + "/" + termsConditionfile);
            }
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
            j = 0;
            while (itr.hasNext()) {
                j++;

                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String srNo = "";
                    String desc = "";
                    String remark = "";
                    String comp = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        try {
                            if (i == 1) {
                                srNo = cell.getNumericCellValue() + "";
                            }
                            if (i == 2) {
                                desc = cell.getStringCellValue();
                            }
                            if (i == 3) {
                                comp = cell.getStringCellValue();
                            }
                            if (i == 4) {
                                remark = cell.getStringCellValue();
                            }

                        } catch (Exception e11) {
                        }

                    }

                    TechnicalSpecificationExcel technicalSpecificationExcel = new TechnicalSpecificationExcel(1, srNo, desc, remark, comp);
                    vendorTechnicalBidTerms1.add(technicalSpecificationExcel);

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //vendor attachmnt -------------------------------------------
        ArrayList<PreQualificationExcel> vendorTechnicalBidAttachment1 = new ArrayList<PreQualificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo + "/" + attachmentfile);
            if (tender_type.equals("Service Manually")) {
                file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + doc_ref_no + "/" + attachmentfile);
            }
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
            j = 0;
            while (itr.hasNext()) {
                j++;

                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String srNo = "";
                    String desc = "";
                    String comp = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        if (i == 1) {
                            srNo = cell.getNumericCellValue() + "";
                        }
                        if (i == 2) {
                            desc = cell.getStringCellValue();
                        }
                        if (i == 3) {
                            comp = cell.getStringCellValue();
                        }

                    }

                    PreQualificationExcel preQualificationExcel = new PreQualificationExcel(1, srNo, desc, comp);
                    //ArrayList<PreQualificationExcel> al=new ArrayList<PreQualificationExcel>();  
                    vendorTechnicalBidAttachment1.add(preQualificationExcel);

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);

        int rivision = vendorTenderBid.getRevision();

        mv.getModelMap().put("rivision", rivision);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);
        mv.getModelMap().put("vendor_code", username);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("tenderVendorDocs", tenderVendorDocs);

        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);

        mv.getModelMap().put("technicalBidDeviation", technicalBidDeviation);
        mv.getModelMap().put("technicalBidRemark", technicalBidRemark);

        mv.getModelMap().put("vendorTechnicalBidTech", vendorTechnicalBidTech);
        mv.getModelMap().put("vendorTechnicalBidTech1", vendorTechnicalBidTech1);

        mv.getModelMap().put("vendorTechnicalBidTerms", vendorTechnicalBidTerms);
        mv.getModelMap().put("vendorTechnicalBidTerms1", vendorTechnicalBidTerms1);

        mv.getModelMap().put("vendorTechnicalBidAttachment", vendorTechnicalBidAttachment);
        mv.getModelMap().put("vendorTechnicalBidAttachment1", vendorTechnicalBidAttachment1);

        List vendorTechnicalBidTechAttachment1 = vendorTechnicalBidTechAttachmentService.readByVendorRefNo(refNo, username);
        List vendorTechnicalBidTermsAttachment1 = vendorTechnicalBidTermsAttachmentService.readByVendorRefNo(refNo, username);

        mv.getModelMap().put("vendorTechnicalBidTechAttachment", vendorTechnicalBidTechAttachment1);
        mv.getModelMap().put("vendorTechnicalBidTermsAttachment", vendorTechnicalBidTermsAttachment1);

        mv.setViewName("Vendor/BidTenderForTechnical");
        return mv;
    }

    public ModelAndView bidTenderFortTechnical(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        int tenderPhase1 = tenderMaster.getTenderPhase();
        String tender_type = tenderMaster.getTenderType();

        String prNo = tenderMaster.getPrNo();

        List multipleAddress = multipleAddressService.readByPrNumber(prNo);

        mv.getModelMap().put("list6", multipleAddress);

        PRMaster prm = prMasterService.readByPrNo(prNo);
        mv.getModelMap().put("list2", prm);

        List prDoc = prDocService.readByRefNo(prNo);
        int prDocAttachment = prDoc.size();

        mv.getModelMap().put("prDoc", prDoc);
        mv.getModelMap().put("prDocAttachment", prDocAttachment);

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);
        List tenderVendorDocs = tenderVendorDocService.readByRefNo(refNo, username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //---------------------------------
        //get Technical details
        VendorTechnicalBid vendorTechnicalBid = vendorTechnicalBidService.readByVendorRefNo(refNo, username);
        String technicalBidDeviation = vendorTechnicalBid.getTechnicalDeviation();
        String technicalBidRemark = vendorTechnicalBid.getTechnicalRemark();

        List vendorTechnicalBidTech = vendorTechnicalBidTechService.readByVendorRefNo(refNo, username);
        List vendorTechnicalBidTerms = vendorTechnicalBidTermsService.readByVendorRefNo(refNo, username);
        List vendorTechnicalBidAttachment = vendorTechnicalBidAttachmentService.readByVendorRefNo(refNo, username);

        List list = tenderTechnicalService.readByRefNo(refNo);

        String technicalfile = "";
        String termsConditionfile = "";
        String attachmentfile = "";
        String tech_doc_ref_no = "";
        String terms_doc_ref_no = "";
        String doc_ref_no = "";

        for (Object o : list) {
            TenderTechnical pdm = (TenderTechnical) o;
            technicalfile = pdm.getTechnicalDoc();
            termsConditionfile = pdm.getTermsConditionDoc();
            attachmentfile = pdm.getDocument();
            tech_doc_ref_no = pdm.getTechnicalRefNo();
            terms_doc_ref_no = pdm.getTermsRefNo();
            doc_ref_no = pdm.getDocumentRefNo();
        }

        mv.getModelMap().put("technicalfile", technicalfile);

        // technical file
        List vendorTechnicalBidTech1 = tenderItemMasterService.readByRefNoAndItemType(refNo, 0);
        int itemDetailsSize = vendorTechnicalBidTech1.size();
        mv.getModelMap().put("itemDetailsSize", itemDetailsSize);

        //  ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTech1=new ArrayList<TechnicalSpecificationExcel>();
        //read excel file
        //trems and condition file attacment --------------------------
        List vendorTechnicalBidTerms1 = tenderItemMasterService.readByRefNoAndItemType(refNo, 1);
        int itemDetailsForServiceSize = vendorTechnicalBidTerms1.size();
        mv.getModelMap().put("itemDetailsForServiceSize", itemDetailsForServiceSize);

        //    ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTerms1=new ArrayList<TechnicalSpecificationExcel>();
        //read excel file
        //vendor attachmnt -------------------------------------------
        ArrayList<PreQualificationExcel> vendorTechnicalBidAttachment1 = new ArrayList<PreQualificationExcel>();
        //read excel file

        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);

        int rivision = vendorTenderBid.getRevision();
        String attachment_type = "1";
        List vendorAttachment = vendorAttachmentService.readAttachment(refNo, username, attachment_type);

        mv.getModelMap().put("vendorAttachment", vendorAttachment);

        mv.getModelMap().put("rivision", rivision);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tenderPhase1", tenderPhase1);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);
        mv.getModelMap().put("vendor_code", username);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("tenderVendorDocs", tenderVendorDocs);

        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);

        mv.getModelMap().put("technicalBidDeviation", technicalBidDeviation);
        mv.getModelMap().put("technicalBidRemark", technicalBidRemark);

        mv.getModelMap().put("vendorTechnicalBidTech", vendorTechnicalBidTech);
        mv.getModelMap().put("vendorTechnicalBidTech1", vendorTechnicalBidTech1);

        mv.getModelMap().put("vendorTechnicalBidTerms", vendorTechnicalBidTerms);
        mv.getModelMap().put("vendorTechnicalBidTerms1", vendorTechnicalBidTerms1);

        mv.getModelMap().put("vendorTechnicalBidAttachment", vendorTechnicalBidAttachment);
        mv.getModelMap().put("vendorTechnicalBidAttachment1", vendorTechnicalBidAttachment1);

        List vendorTechnicalBidTechAttachment = vendorTechnicalBidTechAttachmentService.readByVendorRefNo(refNo, username);
        List vendorTechnicalBidTermsAttachment = vendorTechnicalBidTermsAttachmentService.readByVendorRefNo(refNo, username);

        mv.getModelMap().put("vendorTechnicalBidTechAttachment", vendorTechnicalBidTechAttachment);
        mv.getModelMap().put("vendorTechnicalBidTermsAttachment", vendorTechnicalBidTermsAttachment);

        mv.setViewName("Vendor/BidTenderForTechnical");
        return mv;
    }

    public ModelAndView techBidAttachByVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String refNo = request.getParameter("refNo");
        String srNo = request.getParameter("srNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List list = tenderTechnicalService.readByRefNo(refNo);

        String technicalfile = "";
        String termsConditionfile = "";
        String attachmentfile = "";
        String refNo1 = "";

        for (Object o : list) {
            TenderTechnical pdm = (TenderTechnical) o;
            technicalfile = pdm.getTechnicalDoc();
            termsConditionfile = pdm.getTermsConditionDoc();
            attachmentfile = pdm.getDocument();
            refNo1 = pdm.getTechnicalRefNo();
            if (refNo1 == null) {
                refNo1 = "";
            }
        }

        if (refNo1.equals("")) {
            refNo1 = refNo;
        }

        // technical file
        String desc = "";
        ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTech1 = new ArrayList<TechnicalSpecificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo1 + "/" + technicalfile);
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
            int k = -1;
            while (itr.hasNext()) {
                j++;
                k++;
                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String remark = "";
                    String comp = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        try {
                            if (i == 2) {
                                if (k == Integer.parseInt(srNo)) {
                                    desc = cell.getStringCellValue();
                                }
                            }
                        } catch (Exception e11) {
                        }
                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List vendorTechnicalBidTechAttachment = vendorTechnicalBidTechAttachmentService.readAttachment(refNo, username, desc);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("vendorTechnicalBidTechAttachment", vendorTechnicalBidTechAttachment);

        mv.getModelMap().put("vendor_code", username);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("srNo", srNo);

        mv.setViewName("Vendor/TechBidAttachByVendor");
        return mv;
    }

    public ModelAndView techBidAttachByVendorSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String refNo = request.getParameter("refNo");
        String srNo = request.getParameter("srNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List list = tenderTechnicalService.readByRefNo(refNo);

        String technicalfile = "";
        String termsConditionfile = "";
        String attachmentfile = "";
        String refNo1 = "";
        for (Object o : list) {
            TenderTechnical pdm = (TenderTechnical) o;
            technicalfile = pdm.getTechnicalDoc();
            termsConditionfile = pdm.getTermsConditionDoc();
            attachmentfile = pdm.getDocument();
            refNo1 = pdm.getTechnicalRefNo();
            if (refNo1 == null) {
                refNo1 = "";
            }
        }

        if (refNo1.equals("")) {
            refNo1 = refNo;
        }

        // technical file
        String desc = "";
        ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTech1 = new ArrayList<TechnicalSpecificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo1 + "/" + technicalfile);
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
            int k = -1;
            while (itr.hasNext()) {
                j++;
                k++;
                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String remark = "";
                    String comp = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        try {
                            if (i == 2) {
                                if (k == Integer.parseInt(srNo)) {
                                    desc = cell.getStringCellValue();
                                }
                            }
                        } catch (Exception e11) {
                        }
                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile" + i);
            if (generalfile == null) {
                generalfile = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("generalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (generalfile.equals("")) {
            } else {
                VendorTechnicalBidTechAttachment vendorTechnicalBidTechAttachment = new VendorTechnicalBidTechAttachment();
                vendorTechnicalBidTechAttachment.setRefNo(refNo);
                vendorTechnicalBidTechAttachment.setVendorCode(username);
                vendorTechnicalBidTechAttachment.setAttachment(generalfile);
                vendorTechnicalBidTechAttachment.setDescription(desc);
                vendorTechnicalBidTechAttachmentService.create(vendorTechnicalBidTechAttachment);

            }
        }

        List vendorTechnicalBidTechAttachment = vendorTechnicalBidTechAttachmentService.readAttachment(refNo, username, desc);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("vendorTechnicalBidTechAttachment", vendorTechnicalBidTechAttachment);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("srNo", srNo);
        mv.getModelMap().put("vendor_code", username);
        mv.setViewName("Vendor/TechBidAttachByVendor");
        return mv;
    }

    public ModelAndView techBidAttachByVendorDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String refNo = request.getParameter("refNo");
        String srNo = request.getParameter("srNo");
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        vendorTechnicalBidTechAttachmentService.delete(Integer.parseInt(id));

        List list = tenderTechnicalService.readByRefNo(refNo);

        String technicalfile = "";
        String termsConditionfile = "";
        String attachmentfile = "";

        for (Object o : list) {
            TenderTechnical pdm = (TenderTechnical) o;
            technicalfile = pdm.getTechnicalDoc();
            termsConditionfile = pdm.getTermsConditionDoc();
            attachmentfile = pdm.getDocument();
        }

        // technical file
        String desc = "";
        ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTech1 = new ArrayList<TechnicalSpecificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo + "/" + technicalfile);
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
            int k = -1;
            while (itr.hasNext()) {
                j++;
                k++;
                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String remark = "";
                    String comp = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        try {
                            if (i == 2) {
                                if (k == Integer.parseInt(srNo)) {
                                    desc = cell.getStringCellValue();
                                }
                            }
                        } catch (Exception e11) {
                        }
                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List vendorTechnicalBidTechAttachment = vendorTechnicalBidTechAttachmentService.readAttachment(refNo, username, desc);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("vendorTechnicalBidTechAttachment", vendorTechnicalBidTechAttachment);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("srNo", srNo);
        mv.getModelMap().put("vendor_code", username);

        mv.setViewName("Vendor/TechBidAttachByVendor");
        return mv;
    }

    public ModelAndView termsBidAttachByVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String refNo = request.getParameter("refNo");
        String srNo = request.getParameter("srNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List list = tenderTechnicalService.readByRefNo(refNo);

        String technicalfile = "";
        String termsConditionfile = "";
        String attachmentfile = "";
        String refNo1 = "";
        for (Object o : list) {
            TenderTechnical pdm = (TenderTechnical) o;
            technicalfile = pdm.getTechnicalDoc();
            termsConditionfile = pdm.getTermsConditionDoc();
            attachmentfile = pdm.getDocument();
            refNo1 = pdm.getTermsRefNo();
            if (refNo1 == null) {
                refNo1 = "";
            }
        }

        if (refNo1.equals("")) {
            refNo1 = refNo;
        }

        // technical file
        String desc = "";
        ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTech1 = new ArrayList<TechnicalSpecificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo + "/" + termsConditionfile);
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
            int k = -1;
            while (itr.hasNext()) {
                j++;
                k++;
                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String remark = "";
                    String comp = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        try {
                            if (i == 2) {
                                if (k == Integer.parseInt(srNo)) {
                                    desc = cell.getStringCellValue();
                                }
                            }
                        } catch (Exception e11) {
                        }
                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List vendorTechnicalBidTermsAttachment = vendorTechnicalBidTermsAttachmentService.readAttachment(refNo, username, desc);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("vendorTechnicalBidTermsAttachment", vendorTechnicalBidTermsAttachment);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("srNo", srNo);
        mv.getModelMap().put("vendor_code", username);
        mv.setViewName("Vendor/TermsBidAttachByVendor");
        return mv;
    }

    public ModelAndView termsBidAttachByVendorSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String refNo = request.getParameter("refNo");
        String srNo = request.getParameter("srNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List list = tenderTechnicalService.readByRefNo(refNo);

        String technicalfile = "";
        String termsConditionfile = "";
        String attachmentfile = "";
        String refNo1 = "";
        for (Object o : list) {
            TenderTechnical pdm = (TenderTechnical) o;
            technicalfile = pdm.getTechnicalDoc();
            termsConditionfile = pdm.getTermsConditionDoc();
            attachmentfile = pdm.getDocument();
            refNo1 = pdm.getTermsRefNo();
            if (refNo1 == null) {
                refNo1 = "";
            }
        }

        if (refNo1.equals("")) {
            refNo1 = refNo;
        }

        // technical file
        String desc = "";
        ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTech1 = new ArrayList<TechnicalSpecificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo + "/" + termsConditionfile);
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
            int k = -1;
            while (itr.hasNext()) {
                j++;
                k++;
                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String remark = "";
                    String comp = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        try {
                            if (i == 2) {
                                if (k == Integer.parseInt(srNo)) {
                                    desc = cell.getStringCellValue();
                                }
                            }
                        } catch (Exception e11) {
                        }
                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile" + i);
            if (generalfile == null) {
                generalfile = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("generalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + username + File.separator + refNo + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (generalfile.equals("")) {
            } else {
                VendorTechnicalBidTermsAttachment vendorTechnicalBidTermsAttachment = new VendorTechnicalBidTermsAttachment();
                vendorTechnicalBidTermsAttachment.setRefNo(refNo);
                vendorTechnicalBidTermsAttachment.setVendorCode(username);
                vendorTechnicalBidTermsAttachment.setAttachment(generalfile);
                vendorTechnicalBidTermsAttachment.setDescription(desc);
                vendorTechnicalBidTermsAttachmentService.create(vendorTechnicalBidTermsAttachment);

            }
        }

        List vendorTechnicalBidTermsAttachment = vendorTechnicalBidTermsAttachmentService.readAttachment(refNo, username, desc);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("vendorTechnicalBidTermsAttachment", vendorTechnicalBidTermsAttachment);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("srNo", srNo);
        mv.getModelMap().put("vendor_code", username);
        mv.setViewName("Vendor/TermsBidAttachByVendor");
        return mv;
    }

    public ModelAndView termsBidAttachByVendorDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String refNo = request.getParameter("refNo");
        String srNo = request.getParameter("srNo");
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        vendorTechnicalBidTermsAttachmentService.delete(Integer.parseInt(id));

        List list = tenderTechnicalService.readByRefNo(refNo);

        String technicalfile = "";
        String termsConditionfile = "";
        String attachmentfile = "";

        for (Object o : list) {
            TenderTechnical pdm = (TenderTechnical) o;
            technicalfile = pdm.getTechnicalDoc();
            termsConditionfile = pdm.getTermsConditionDoc();
            attachmentfile = pdm.getDocument();
        }

        // technical file
        String desc = "";
        ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTech1 = new ArrayList<TechnicalSpecificationExcel>();
        //read excel file

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Tender/" + refNo + "/" + termsConditionfile);
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
            int k = -1;
            while (itr.hasNext()) {
                j++;
                k++;
                Row row = itr.next();
                Iterator< Cell> cellIterator = row.cellIterator();
                //iterating over each column  
                if (j >= 2) {
                    String remark = "";
                    String comp = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        try {
                            if (i == 2) {
                                if (k == Integer.parseInt(srNo)) {
                                    desc = cell.getStringCellValue();
                                }
                            }
                        } catch (Exception e11) {
                        }
                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List vendorTechnicalBidTermsAttachment = vendorTechnicalBidTermsAttachmentService.readAttachment(refNo, username, desc);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("vendorTechnicalBidTermsAttachment", vendorTechnicalBidTermsAttachment);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("srNo", srNo);
        mv.getModelMap().put("vendor_code", username);
        mv.setViewName("Vendor/TermsBidAttachByVendor");
        return mv;
    }

    public ModelAndView bidTenderForTechnicalSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        //String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        String refFileNo = refNo;
        refFileNo = refFileNo.replaceAll("/", "");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refFileNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refFileNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();

        // emd
        if (emd != "0" && tender_phase == 2) {
            String emd_date = request.getParameter("emd_date");
            String emd_drawee_bank = request.getParameter("emd_drawee_bank");
            String cash_cheque = request.getParameter("cash_cheque");
            String emd_cheque_no = request.getParameter("emd_cheque_no");

            String emd_attach = request.getParameter("emd_attach");
            if (emd_attach == null) {
                emd_attach = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("emd_attach");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refFileNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    emd_attach = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List vendorEmd1 = vendorEmdService.readVendorRefNo(refNo, username);

            if (vendorEmd1.isEmpty()) {
                VendorEmd vendorEmd = new VendorEmd();
                vendorEmd.setRefNo(refNo);
                vendorEmd.setVendorCode(username);
                vendorEmd.setEmdAmount(emd);
                vendorEmd.setEmdDate(emd_date);
                vendorEmd.setDraweeBank(emd_drawee_bank);
                vendorEmd.setAttachment(emd_attach);
                vendorEmd.setCashCheque(cash_cheque);
                vendorEmd.setChequeNo(emd_cheque_no);
                vendorEmdService.create(vendorEmd);
            } else {
                vendorEmdService.updateVendorRefNo(refNo, username, emd, emd_date, emd_drawee_bank, emd_attach, cash_cheque, emd_cheque_no);
            }
        }

        //fee
        if (doc_cost != "0" && tender_phase == 2) {
            String fee_date = request.getParameter("fee_date");
            String fee_drawee_bank = request.getParameter("fee_drawee_bank");
            String fee_cheque_no = request.getParameter("fee_cheque_no");

            String fee_attach = request.getParameter("fee_attach");
            if (fee_attach == null) {
                fee_attach = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("fee_attach");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    fee_attach = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List vendorFee1 = vendorFeeService.readVendorRefNo(refNo, username);

            if (vendorFee1.isEmpty()) {
                VendorFee vendorFee = new VendorFee();
                vendorFee.setRefNo(refNo);
                vendorFee.setVendorCode(username);
                vendorFee.setFeeAmount(doc_cost);
                vendorFee.setFeeDate(fee_date);
                vendorFee.setDraweeBank(fee_drawee_bank);
                vendorFee.setAttachment(fee_attach);
                vendorFee.setChequeNo(fee_cheque_no);
                vendorFeeService.create(vendorFee);
            } else {
                vendorFeeService.updateVendorRefNo(refNo, username, doc_cost, fee_date, fee_drawee_bank, fee_attach, fee_cheque_no);
            }
        }

        //Technical details
        String technicalBidDeviation = request.getParameter("technicalBidDeviation");
        String technicalBidRemark = request.getParameter("technicalBidRemark");

        List vendorTechnicalBid1 = vendorTechnicalBidService.readVendorRefNo(refNo, username);

        if (vendorTechnicalBid1.isEmpty()) {
            VendorTechnicalBid vendorTechnicalBid = new VendorTechnicalBid();
            vendorTechnicalBid.setRefNo(refNo);
            vendorTechnicalBid.setVendorCode(username);
            vendorTechnicalBid.setTechnicalDeviation(technicalBidDeviation);
            vendorTechnicalBid.setTechnicalRemark(technicalBidRemark);
            vendorTechnicalBid.setReviseBidFlag(1);
            vendorTechnicalBidService.create(vendorTechnicalBid);
        } else {
            vendorTechnicalBidService.updateVendorRefNo(refNo, username, technicalBidDeviation, technicalBidRemark);
        }

        // technical bid
        String[] vendor_tech_desc = request.getParameterValues("vendor_tech_desc");
        String[] vendor_tech_remark = request.getParameterValues("vendor_tech_remark");
        String[] vendor_tech_comp = request.getParameterValues("vendor_tech_comp");
        String[] tech_sr_no = request.getParameterValues("tech_sr_no");
        String[] tech_item_code = request.getParameterValues("tech_item_code");
        String[] tech_uom = request.getParameterValues("tech_uom");
        String[] tech_qty = request.getParameterValues("tech_qty");
        int j = 0;
        int k1 = 0;
        int k2 = 0;

        try {
            for (int i = 0; i < vendor_tech_desc.length; i++) {
                j++;
                String techradion = request.getParameter("techradion" + j);
                if (techradion == null) {
                    techradion = "";
                }

                if (techradion.equals("0")) {
                    k1++;
                }
                k2++;

                String tech_vendor_remark = request.getParameter("tech_vendor_remark" + j);
                if (tech_vendor_remark == null) {
                    tech_vendor_remark = "";
                }

                List vendorTechnicalBidTech1 = vendorTechnicalBidTechService.readVendorRefNo(refNo, username, vendor_tech_desc[i]);

                if (vendorTechnicalBidTech1.isEmpty()) {
                    VendorTechnicalBidTech vendorTechnicalBidTech = new VendorTechnicalBidTech();
                    vendorTechnicalBidTech.setRefNo(refNo);
                    vendorTechnicalBidTech.setVendorCode(username);
                    vendorTechnicalBidTech.setDescription(vendor_tech_desc[i]);
                    vendorTechnicalBidTech.setDetails(vendor_tech_remark[i]);
                    vendorTechnicalBidTech.setAttachmentRequired(vendor_tech_comp[i]);
                    vendorTechnicalBidTech.setVendorResponse(Integer.parseInt(techradion));
                    vendorTechnicalBidTech.setRemark(tech_vendor_remark);
                    vendorTechnicalBidTech.setItemCode(tech_item_code[i]);
                    vendorTechnicalBidTech.setSrNo(tech_sr_no[i]);
                    vendorTechnicalBidTech.setUom(tech_uom[i]);
                    vendorTechnicalBidTech.setQty(tech_qty[i]);
                    vendorTechnicalBidTechService.create(vendorTechnicalBidTech);

                } else {
                    vendorTechnicalBidTechService.updateVendorRefNo(refNo, username, vendor_tech_desc[i], Integer.parseInt(techradion), tech_vendor_remark);

                }

            }
        } catch (Exception e11) {
        }
        // terms & Condition bid

        String[] vendor_terms_desc = request.getParameterValues("vendor_terms_desc");
        String[] vendor_terms_remark = request.getParameterValues("vendor_terms_remark");
        String[] vendor_terms_comp = request.getParameterValues("vendor_terms_comp");
        String[] terms_sr_no = request.getParameterValues("terms_sr_no");
        String[] terms_item_code = request.getParameterValues("terms_item_code");
        String[] terms_uom = request.getParameterValues("terms_uom");
        String[] terms_qty = request.getParameterValues("terms_qty");
        j = 0;
        try {
            for (int i = 0; i < vendor_terms_desc.length; i++) {
                j++;
                String termsradion = request.getParameter("termsradion" + j);
                if (termsradion == null) {
                    termsradion = "";
                }

                if (termsradion.equals("0")) {
                    k1++;
                }
                k2++;

                String terms_vendor_remark = request.getParameter("terms_vendor_remark" + j);
                if (terms_vendor_remark == null) {
                    terms_vendor_remark = "";
                }

                List vendorTechnicalBidTerms1 = vendorTechnicalBidTermsService.readVendorRefNo(refNo, username, vendor_terms_desc[i]);

                if (vendorTechnicalBidTerms1.isEmpty()) {
                    VendorTechnicalBidTerms vendorTechnicalBidTerms = new VendorTechnicalBidTerms();
                    vendorTechnicalBidTerms.setRefNo(refNo);
                    vendorTechnicalBidTerms.setVendorCode(username);
                    vendorTechnicalBidTerms.setDescription(vendor_terms_desc[i]);
                    vendorTechnicalBidTerms.setDetails(vendor_terms_remark[i]);
                    vendorTechnicalBidTerms.setAttachmentRequired(vendor_terms_comp[i]);
                    vendorTechnicalBidTerms.setVendorResponse(Integer.parseInt(termsradion));
                    vendorTechnicalBidTerms.setRemark(terms_vendor_remark);
                    vendorTechnicalBidTerms.setItemCode(terms_item_code[i]);
                    vendorTechnicalBidTerms.setSrNo(terms_sr_no[i]);
                    vendorTechnicalBidTerms.setUom(terms_uom[i]);
                    vendorTechnicalBidTerms.setQty(terms_qty[i]);
                    vendorTechnicalBidTermsService.create(vendorTechnicalBidTerms);
                } else {
                    vendorTechnicalBidTermsService.updateVendorRefNo(refNo, username, vendor_terms_desc[i], Integer.parseInt(termsradion), terms_vendor_remark);

                }

            }
        } catch (Exception e11) {
        }

        double percentage = k1 * 100 / k2;

        VendorTechnicalBid vendorTechnicalBid11 = vendorTechnicalBidService.readByVendorRefNo(refNo, username);

        vendorTechnicalBid11.setTechPercentage(percentage + "");
        vendorTechnicalBidService.update(vendorTechnicalBid11);

        // technical attachent attachment
        String[] tech_attachment_desc = request.getParameterValues("tech_attachment_desc");
        String[] tech_attachment_comp = request.getParameterValues("tech_attachment_comp");
        String[] document = request.getParameterValues("document");
        String[] remark = request.getParameterValues("remarks");
        String[] ids = request.getParameterValues("ids");
        j = 0;
        try {
            for (int i = 0; i < tech_attachment_desc.length; i++) {
                j++;
                String tech_attachment = request.getParameter("tech_attachment" + j);
                if (tech_attachment == null) {
                    tech_attachment = "";

                }
                String vender_response = request.getParameter("documentYes" + j);
                int vender_response1 = Integer.parseInt(vender_response);
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

                MultipartFile multipartFile = multipartRequest.getFile("tech_attachment" + j);
                if (multipartFile != null && multipartFile.getSize() > 0) {
                    try {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "Tender"
                                + File.separator + refFileNo + File.separator + username + File.separator;
                        File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        tech_attachment = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                        multipartFile.transferTo(photoFile);
                        //    vendorInformation.setTermsConditionFile(photoFile+"");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                List vendorTechnicalBidAttachment1 = vendorTechnicalBidAttachmentService.readVendorRefNo(refNo, username, tech_attachment_desc[i]);

                if (vendorTechnicalBidAttachment1.isEmpty()) {
                    VendorTechnicalBidAttachment vendorTechnicalBidAttachment = new VendorTechnicalBidAttachment();
                    vendorTechnicalBidAttachment.setRefNo(refNo);
                    vendorTechnicalBidAttachment.setVendorCode(username);
                    vendorTechnicalBidAttachment.setDescription(tech_attachment_desc[i]);

                    vendorTechnicalBidAttachment.setAttachment(tech_attachment);
                    vendorTechnicalBidAttachment.setDocument(document[i]);

                    vendorTechnicalBidAttachment.setVenderResponse(vender_response1);

                    vendorTechnicalBidAttachment.setRemark(remark[i]);
                    vendorTechnicalBidAttachmentService.create(vendorTechnicalBidAttachment);
                } else {
                    if (tech_attachment != "") {
                        //      vendorTechnicalBidAttachmentService.updateVendorRefNo(refNo, username, tech_attachment_desc[i], tech_attachment_comp[i], tech_attachment);
                    }

                    VendorTechnicalBidAttachment vendorTechnicalBidAttachment2 = vendorTechnicalBidAttachmentService.readByTechdoc(refNo, username, tech_attachment_desc[i]);
                    vendorTechnicalBidAttachment2.setDescription(tech_attachment_desc[i]);
                    if (tech_attachment != "") {
                        vendorTechnicalBidAttachment2.setAttachment(tech_attachment);
                    } else {

                    }

                    vendorTechnicalBidAttachment2.setDocument(document[i]);

                    vendorTechnicalBidAttachment2.setVenderResponse(vender_response1);

                    vendorTechnicalBidAttachment2.setRemark(remark[i]);
                    vendorTechnicalBidAttachmentService.update(vendorTechnicalBidAttachment2);
                }

            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }

        List vendorTenderBid1 = vendorTenderBidService.readVendorRefNo(refNo, username);

        if (vendorTenderBid1.isEmpty()) {
            VendorTenderBid vendorTenderBid = new VendorTenderBid();
            vendorTenderBid.setRefNo(refNo);
            vendorTenderBid.setVendorCode(username);
            vendorTenderBid.setTechSubmitFlag(1);
            vendorTenderBid.setRevision(1);

            vendorTenderBidService.create(vendorTenderBid);
        }

        TenderMaster tenderMaster11 = tenderMasterService.readRefNo(refNo);
        String location = tenderMaster11.getLocation();
        String title = tenderMaster11.getTitle();

        //HttpSession session = request.getSession(false);
        UserMaster user11 = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Tender Technical Bid Submition for tender no " + refNo + "").setDrow("Y");
        logService.create(lm);

        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        TenderFollowup tenderFollowup = new TenderFollowup();
        tenderFollowup.setActivityDate(formattedDate1);
        tenderFollowup.setActivity("Tender Technical Bid Submition for tender no " + refNo + "");
        tenderFollowup.setLocation(location);
        tenderFollowup.setTenderNo(refNo);
        tenderFollowup.setPerson(user11.getLoginName());
        tenderFollowup.setPersonFullname(user11.getUserFullName());
        tenderFollowupService.create(tenderFollowup);

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);
        List tenderVendorDocs = tenderVendorDocService.readByRefNo(refNo, username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //get Offer etails
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        String offer_no = vendorTenderBid.getOfferNo();
        String offer_date = vendorTenderBid.getOfferDate();
        String contact_person = vendorTenderBid.getContactPerson();
        String contact_no = vendorTenderBid.getContactNo();
        String contact_email = vendorTenderBid.getConactEmail();
        String gst_no = vendorTenderBid.getGstNo();
        int rivision = vendorTenderBid.getRevision();

        if (contact_email == null) {
            contact_email = "";
        }
        TenderVendor tenderVendor = tenderVendorService.readByRefVendor1(refNo, username);
        if (contact_email.equals("")) {
            contact_email = tenderVendor.getEmailId();
        }

        mv.getModelMap().put("rivision", rivision);

        mv.getModelMap().put("offer_no", offer_no);
        mv.getModelMap().put("offer_date", offer_date);
        mv.getModelMap().put("contact_person", contact_person);
        mv.getModelMap().put("contact_no", contact_no);
        mv.getModelMap().put("contact_email", contact_email);
        mv.getModelMap().put("gst_no", gst_no);

        //---------------------------------
        //vendor attachmnt -------------------------------------------
        String attachment_type = "1";
        List vendorAttachment = vendorAttachmentService.readAttachment(refNo, username, attachment_type);

        mv.getModelMap().put("vendorAttachment", vendorAttachment);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("tenderVendorDocs", tenderVendorDocs);

        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);

        String prDocAttachment = request.getParameter("prDocAttachment");
        String itemDetailsSize = request.getParameter("itemDetailsSize");
        String itemDetailsForServiceSize = request.getParameter("itemDetailsForServiceSize");

        List<VendorTechnicalBidTech> list4 = vendorTechnicalBidTechService.readByVendorRefNo(refNo, username);
        List<VendorTechnicalBidTerms> list5 = vendorTechnicalBidTermsService.readByVendorRefNo(refNo, username);
        List<VendorTechnicalBidAttachment> list6 = vendorTechnicalBidAttachmentService.readByVendorRefNo(refNo, username);

        int prDocAttachmentCount = list6.size();
        int itemDetailsCount = list4.size();
        int itemDetailsServiceCount = list5.size();

//        itemDetailsCount && itemDetailsServiceCount && prDocAttachmentCount
        boolean isPrDocAttachmentValid = (Integer.parseInt(prDocAttachment) == prDocAttachmentCount);
        boolean isItemDetailsValid = (Integer.parseInt(itemDetailsSize) == itemDetailsCount);
        boolean isServiceDetailsValid = (Integer.parseInt(itemDetailsForServiceSize) == itemDetailsServiceCount);

        if (isPrDocAttachmentValid && isItemDetailsValid && isServiceDetailsValid) {
            request.setAttribute("successMessage",
                    "Information: Bid Submited successfully");
            mv.setViewName("forward:vendor.htm?act=liveTender");
        } else {

            vendorTechnicalBidTechService.readByDelete(refNo, username);
            vendorTechnicalBidTermsService.readByDelete(refNo, username);
            vendorTechnicalBidAttachmentService.readByDelete(refNo, username);

            vendorTechnicalBidService.readByDelete(refNo, username);
            vendorTenderBidService.readByDelete(refNo, username);

            request.setAttribute("failureMessage",
                    "Information: Data not submitted properly. Please try again.");
            mv.setViewName("forward:vendor.htm?act=bidTenderFortTechnical&refNo=" + refNo);
        }

        //mv.setViewName("Vendor/BidTenderForOffer");
        return mv;
    }

    public ModelAndView bidTenderForOffer(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        int tenderPhase1 = tenderMaster.getTenderPhase();
        String tender_remark = tenderMaster.getTenderRemark();

        String prNo = tenderMaster.getPrNo();

        PRMaster prm = prMasterService.readByPrNo(prNo);
        mv.getModelMap().put("prm", prm);

        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);

        List multipleAddList = multipleAddressService.readByPrNumber(prNo);
        mv.getModelMap().put("multipleAddList", multipleAddList);

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);
        List tenderVendorDocs = tenderVendorDocService.readByRefNo(refNo, username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //get Offer etails
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        String offer_no = vendorTenderBid.getOfferNo();
        String offer_date = vendorTenderBid.getOfferDate();
        String contact_person = vendorTenderBid.getContactPerson();
        String contact_no = vendorTenderBid.getContactNo();
        String contact_email = vendorTenderBid.getConactEmail();
        String gst_no = vendorTenderBid.getGstNo();
        int rivision = vendorTenderBid.getRevision();
        if (contact_email == null) {
            contact_email = "";
        }
        TenderVendor tenderVendor = tenderVendorService.readByRefVendor1(refNo, username);
        if (contact_email.equals("")) {
            contact_email = tenderVendor.getEmailId();
        }

        if (offer_date == null) {
            offer_date = "";
        }
        if (offer_date.equals("")) {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String submitLastdate = myDateObj.format(myFormatObj1);
            offer_date = submitLastdate;

        }

        mv.getModelMap().put("tender_remark", tender_remark);
        mv.getModelMap().put("vendor_code", username);

        mv.getModelMap().put("rivision", rivision);
        mv.getModelMap().put("offer_no", offer_no);

        mv.getModelMap().put("offer_date", offer_date);
        mv.getModelMap().put("contact_person", contact_person);
        mv.getModelMap().put("contact_no", contact_no);
        mv.getModelMap().put("contact_email", contact_email);
        mv.getModelMap().put("gst_no", gst_no);

        String attachment_type = "1";
        List vendorAttachment = vendorAttachmentService.readAttachment(refNo, username, attachment_type);

        mv.getModelMap().put("vendorAttachment", vendorAttachment);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("tenderPhase1", tenderPhase1);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("tenderVendorDocs", tenderVendorDocs);

        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);

        mv.setViewName("Vendor/BidTenderForOffer");
        return mv;
    }

    public ModelAndView bidTenderForOfferSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String RefNo = refNo.replace("/", "");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + RefNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + RefNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        String tender_type = tenderMaster.getTenderType();
        if (tender_type == null) {
            tender_type = "";
        }

        // emd
        if (emd != "0" && tender_phase == 1) {
            String emd_date = request.getParameter("emd_date");
            String emd_drawee_bank = request.getParameter("emd_drawee_bank");
            String cash_cheque = request.getParameter("cash_cheque");
            String emd_cheque_no = request.getParameter("emd_cheque_no");

            String emd_attach = request.getParameter("emd_attach");
            if (emd_attach == null) {
                emd_attach = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("emd_attach");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + RefNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    emd_attach = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List vendorEmd1 = vendorEmdService.readVendorRefNo(refNo, username);

            if (vendorEmd1.isEmpty()) {
                VendorEmd vendorEmd = new VendorEmd();
                vendorEmd.setRefNo(refNo);
                vendorEmd.setVendorCode(username);
                vendorEmd.setEmdAmount(emd);
                vendorEmd.setEmdDate(emd_date);
                vendorEmd.setDraweeBank(emd_drawee_bank);
                vendorEmd.setAttachment(emd_attach);
                vendorEmd.setCashCheque(cash_cheque);
                vendorEmd.setChequeNo(emd_cheque_no);
                vendorEmdService.create(vendorEmd);
            } else {
                vendorEmdService.updateVendorRefNo(refNo, username, emd, emd_date, emd_drawee_bank, emd_attach, cash_cheque, emd_cheque_no);
            }
        }

        //fee
        if (doc_cost != "0" && tender_phase == 1) {
            String fee_date = request.getParameter("fee_date");
            String fee_drawee_bank = request.getParameter("fee_drawee_bank");
            String fee_cheque_no = request.getParameter("fee_cheque_no");

            String fee_attach = request.getParameter("fee_attach");
            if (fee_attach == null) {
                fee_attach = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("fee_attach");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + RefNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    fee_attach = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List vendorFee1 = vendorFeeService.readVendorRefNo(refNo, username);

            if (vendorFee1.isEmpty()) {
                VendorFee vendorFee = new VendorFee();
                vendorFee.setRefNo(refNo);
                vendorFee.setVendorCode(username);
                vendorFee.setFeeAmount(doc_cost);
                vendorFee.setFeeDate(fee_date);
                vendorFee.setDraweeBank(fee_drawee_bank);
                vendorFee.setAttachment(fee_attach);
                vendorFee.setChequeNo(fee_cheque_no);
                vendorFeeService.create(vendorFee);
            } else {
                vendorFeeService.updateVendorRefNo(refNo, username, doc_cost, fee_date, fee_drawee_bank, fee_attach, fee_cheque_no);
            }
        }

        String offer_no = request.getParameter("offer_no");
        String offer_date = request.getParameter("offer_date");
        String contact_person = request.getParameter("contact_person");
        String contact_no = request.getParameter("contact_no");
        String contact_email = request.getParameter("contact_email");
        String gst_no = request.getParameter("gst_no");

        List vendorTenderBid1 = vendorTenderBidService.readVendorRefNo(refNo, username);

        if (vendorTenderBid1.isEmpty()) {
            VendorTenderBid vendorTenderBid = new VendorTenderBid();
            vendorTenderBid.setRefNo(refNo);
            vendorTenderBid.setVendorCode(username);
            vendorTenderBid.setOfferNo(offer_no);
            vendorTenderBid.setOfferDate(offer_date);
            vendorTenderBid.setContactPerson(contact_person);
            vendorTenderBid.setContactNo(contact_no);
            vendorTenderBid.setConactEmail(contact_email);
            vendorTenderBid.setGstNo(gst_no);
            vendorTenderBidService.create(vendorTenderBid);
        } else {
            try {
                vendorTenderBidService.updateVendorOffer(refNo, username, offer_no, offer_date, contact_person, contact_no, contact_email, gst_no);
            } catch (Exception e12) {
            }
        }

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        // Service Manual Financial bid
        if (tender_type.equals("Service Manually")) {

            String service_type1 = "";

            List fileDetail = fileDetailService.readTenderNo(refNo);

            mv.getModelMap().put("fileDetail", fileDetail);

            String file_name = "";
            String serviceDetail1 = "";
            String from_date = "";
            String to_date = "";
            String date_wise = "";
            int i = 0;
            for (Object o : fileDetail) {
                i++;
                if (i == 1) {
                    FileDetail fd = (FileDetail) o;
                    service_type1 = fd.getSerType();
                    file_name = fd.getFileName();
                    from_date = fd.getFromDate();
                    to_date = fd.getToDate();
                    date_wise = fd.getDateWise();

                    String select_common = "";
                    String discount_type = "";
                    String discount_value = "";
                    String packing_type = "";
                    String packing_value = "";
                    String freight_type = "";
                    String freight_value = "";
                    String errection_value = "";
                    String charges_value = "";
                    String igst_value = "";
                    String cgst_value = "";
                    String sgst_value = "";
                    String insurance_value = "";
                    String grand_total = "";
                    String item_total = "";
                    try {
                        List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBid", serviceVendorTenderBid);

                        for (Object o1 : serviceVendorTenderBid) {

                            ServiceVendorTenderBid svtb = (ServiceVendorTenderBid) o1;
                            select_common = svtb.getSelectCommon();
                            discount_type = svtb.getDiscountType();
                            discount_value = svtb.getDiscountValue();
                            packing_type = svtb.getPackingType();
                            packing_value = svtb.getPackingValue();
                            freight_type = svtb.getFreightType();
                            freight_value = svtb.getFreightValue();
                            errection_value = svtb.getErrectionValue();
                            charges_value = svtb.getChargesValue();
                            igst_value = svtb.getIgstValue();
                            cgst_value = svtb.getCgstValue();
                            sgst_value = svtb.getSgstValue();
                            insurance_value = svtb.getInsuranceValue();
                            grand_total = svtb.getGrandTotal();
                            item_total = svtb.getItemTotal();

                        }

                    } catch (Exception e1) {
                    }

                    mv.getModelMap().put("select_common", select_common);
                    mv.getModelMap().put("discount_type", discount_type);
                    mv.getModelMap().put("discount_value", discount_value);
                    mv.getModelMap().put("packing_type", packing_type);
                    mv.getModelMap().put("packing_value", packing_value);
                    mv.getModelMap().put("freight_type", freight_type);
                    mv.getModelMap().put("freight_value", freight_value);
                    mv.getModelMap().put("errection_value", errection_value);
                    mv.getModelMap().put("charges_value", charges_value);
                    mv.getModelMap().put("igst_value", igst_value);
                    mv.getModelMap().put("cgst_value", cgst_value);
                    mv.getModelMap().put("sgst_value", sgst_value);
                    mv.getModelMap().put("insurance_value", insurance_value);
                    mv.getModelMap().put("grand_total", grand_total);
                    mv.getModelMap().put("item_total", item_total);

                    if (service_type1.equals("Service1")) {
                        List serviceDetail = serviceDetail1Service.readTenderNo(file_name, refNo);
                        mv.getModelMap().put("serviceDetail", serviceDetail);

                        try {
                            List serviceVendorTenderBidItem = serviceVendorTenderBidItemService.readVendorRefNo(file_name, username, refNo);
                            mv.getModelMap().put("serviceVendorTenderBidItem", serviceVendorTenderBidItem);
                        } catch (Exception e1) {
                        }
                    } else if (service_type1.equals("Service2")) {
                        List serviceDetail = serviceDetail2Service.readTenderNo(file_name, refNo);
                        mv.getModelMap().put("serviceDetail", serviceDetail);

                        try {
                            List serviceVendorTenderBidItem2 = serviceVendorTenderBidItem2Service.readVendorRefNo(file_name, username, refNo);
                            mv.getModelMap().put("serviceVendorTenderBidItem2", serviceVendorTenderBidItem2);
                        } catch (Exception e1) {
                        }

                    } else if (service_type1.equals("Service3")) {
                        List serviceDetail = serviceDetail3Service.readTenderNo(file_name, refNo);
                        mv.getModelMap().put("serviceDetail", serviceDetail);

                        try {
                            List serviceVendorTenderBidItem3 = serviceVendorTenderBidItem3Service.readVendorRefNo(file_name, username, refNo);
                            mv.getModelMap().put("serviceVendorTenderBidItem3", serviceVendorTenderBidItem3);
                        } catch (Exception e1) {
                        }
                    } else if (service_type1.equals("Service4")) {
                        long difference_In_Days = 0;
                        if (date_wise.equals("date_service4")) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            try {
                                Date d1 = sdf.parse(from_date);
                                Date d2 = sdf.parse(to_date);

                                long difference_In_Time = d2.getTime() - d1.getTime();
                                difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

                            } catch (Exception e1) {
                            }

                        }

                        mv.getModelMap().put("from_date", from_date);
                        mv.getModelMap().put("to_date", to_date);
                        mv.getModelMap().put("diff_days", difference_In_Days);

                        List serviceDetail = serviceDetail4Service.readTenderNo(file_name, refNo);
                        mv.getModelMap().put("serviceDetail", serviceDetail);

                        try {
                            List serviceVendorTenderBidItem4 = serviceVendorTenderBidItem4Service.readVendorRefNo(file_name, username, refNo);
                            mv.getModelMap().put("serviceVendorTenderBidItem4", serviceVendorTenderBidItem4);
                        } catch (Exception e1) {
                        }
                    } else if (service_type1.equals("Service5")) {
                        List serviceDetail = serviceDetail5Service.readTenderNo(file_name, refNo);
                        mv.getModelMap().put("serviceDetail", serviceDetail);

                        try {
                            List serviceVendorTenderBidItem = serviceVendorTenderBidItemService.readVendorRefNo(file_name, username, refNo);
                            mv.getModelMap().put("serviceVendorTenderBidItem", serviceVendorTenderBidItem);
                        } catch (Exception e1) {
                        }
                    } else if (service_type1.equals("Service6")) {
                        List serviceDetail = serviceDetail6Service.readTenderNo(file_name, refNo);
                        mv.getModelMap().put("serviceDetail", serviceDetail);

                        try {
                            List serviceVendorTenderBidItem6 = serviceVendorTenderBidItem6Service.readVendorRefNo(file_name, username, refNo);
                            mv.getModelMap().put("serviceVendorTenderBidItem6", serviceVendorTenderBidItem6);
                        } catch (Exception e1) {
                        }
                    }

                    mv.getModelMap().put("file_no", "1");
                    mv.getModelMap().put("file_name", file_name);
                }
            }

            int rivision = 0;

            VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);
            rivision = vendorTenderBid11.getRevision();

            mv.getModelMap().put("rivision", rivision);

            mv.getModelMap().put("refNo", refNo);
            mv.getModelMap().put("tenderMaster", tenderMaster);
            PRMaster prm = prMasterService.readByPrNo(tenderMaster.getPrNo());
            mv.getModelMap().put("prm", prm);
            mv.getModelMap().put("generalDocs", generalDocs);
            mv.getModelMap().put("additionalDocs", additionalDocs);
            mv.getModelMap().put("technicalDocs", technicalDocs);

            mv.setViewName("Vendor/BidTenderForFinancialServiceManual");
            return mv;
        } else {

            //get item details
            List tenderItemMaster = tenderItemMasterService.readByRefNoAndItemType(refNo, 0);
            int itemMasterSize = tenderItemMaster.size();
            List vendorTenderBidItem1 = vendorTenderBidItemService.readByVendorRefNo(refNo, username);

            int item_type = 0;
            List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, item_type);

            String gst = "";
            if (vendorTenderBidItem.size() == 0) {
                // check last bid data
                for (Object o : tenderItemMaster) {

                    TenderItemMaster tim = (TenderItemMaster) o;
                    String uom = tim.getUom();
                    gst = tim.getGst();

                    if (!uom.equals("")) {
                        break;

                    }

                }

            }

            //vendor tender bid
            VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
            int rivision = vendorTenderBid.getRevision();
            String discount_type = vendorTenderBid.getDiscountType();
            String discount_value = vendorTenderBid.getDiscountValue();
            String packing_type = vendorTenderBid.getPackingType();
            String packing_value = vendorTenderBid.getPackingValue();
            String freight_type = vendorTenderBid.getFreightType();
            String freight_value = vendorTenderBid.getFreightValue();
            String errection_value = vendorTenderBid.getErrectionValue();
            String charges_value = vendorTenderBid.getChargesValue();
            String igst_value = vendorTenderBid.getIgstValue();
            String cgst_value = vendorTenderBid.getCgstValue();
            String sgst_value = vendorTenderBid.getSgstValue();
            String insurance_value = vendorTenderBid.getInsuranceValue();
            String item_total = vendorTenderBid.getItemTotal();
            String grand_total = vendorTenderBid.getGrandTotal();
            String grand_total_word = vendorTenderBid.getGrandTotalWord();
            String select_common = vendorTenderBid.getSelectCommon();
            String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
            String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();

            if (vendorTenderBidItem.size() == 0) {
                igst_value = gst;
                mv.getModelMap().put("igst_value", gst);
            }

            mv.getModelMap().put("rivision", rivision);
            mv.getModelMap().put("discount_type", discount_type);
            mv.getModelMap().put("discount_value", discount_value);
            mv.getModelMap().put("packing_type", packing_type);
            mv.getModelMap().put("packing_value", packing_value);
            mv.getModelMap().put("freight_type", freight_type);
            mv.getModelMap().put("freight_value", freight_value);
            mv.getModelMap().put("errection_value", errection_value);
            mv.getModelMap().put("charges_value", charges_value);
            mv.getModelMap().put("igst_value", igst_value);
            mv.getModelMap().put("cgst_value", cgst_value);
            mv.getModelMap().put("sgst_value", sgst_value);
            mv.getModelMap().put("insurance_value", insurance_value);
            mv.getModelMap().put("item_total", item_total);
            mv.getModelMap().put("grand_total", grand_total);
            mv.getModelMap().put("grand_total_word", grand_total_word);
            mv.getModelMap().put("select_common", select_common);

            mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
            mv.getModelMap().put("free_delivery_comment", free_delivery_comment);

            //get pre qualiication details
            VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
            String preBidDeviation = vendorPreBid.getPreBidDeviation();
            String preBidRemark = vendorPreBid.getPreBidRemark();

            List list1 = tenderMasterService.vendorLiveTender(username);
            request.setAttribute("list", list1);
            mv.getModelMap().put("tenderMaster", tenderMaster);
            mv.getModelMap().put("refNo", refNo);

            mv.getModelMap().put("generalDocs", generalDocs);
            mv.getModelMap().put("additionalDocs", additionalDocs);
            mv.getModelMap().put("technicalDocs", technicalDocs);

            mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

            mv.getModelMap().put("itemMasterSize", itemMasterSize);

            mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);
            PRMaster prm = prMasterService.readByPrNo(tenderMaster.getPrNo());
            mv.getModelMap().put("prm", prm);
            mv.setViewName("Vendor/BidTenderForFinancial");
            return mv;
        }
    }

    public ModelAndView bidTenderForFinancialPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String RefNo = refNo.replace("/", "");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List list1 = tenderMasterService.vendorLiveTender(username);
        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);

        List tenderItemMaster = tenderItemMasterService.readByRefNoAndItemType(refNo, 0);
        int itemMasterSize = tenderItemMaster.size();
        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        mv.getModelMap().put("itemMasterSize", itemMasterSize);
        mv.setViewName("Vendor/BidTenderForFinancial");
        return mv;
    }

    public ModelAndView bidTenderForTermsServicePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String RefNo = refNo.replace("/", "");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List list1 = tenderMasterService.vendorLiveTender(username);
        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);

        List tenderItemMaster = tenderItemMasterService.readByRefNoAndItemType(refNo, 1);
        int itemMasterSize = tenderItemMaster.size();
        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

        mv.getModelMap().put("itemMasterSize", itemMasterSize);
        mv.setViewName("Vendor/BidTenderForServiceFinancial");
        return mv;
    }

    public ModelAndView bidTenderForTermsConditionPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String RefNo = refNo.replace("/", "");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        String termsParameter = tenderMaster.getTermsCondition();

        TermsCondition termsCondition = termsConditionService.readByName(termsParameter);
        int termsParameterId = termsCondition.getId();

        List list4 = termsConditionParameterService.readAllTerms(termsParameterId);
        int termsConditionCount = list4.size();
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("termsConditionCount", termsConditionCount);

        mv.getModelMap().put("refNo", refNo);

        mv.setViewName("Vendor/BidTenderForCondition");
        return mv;
    }

    public ModelAndView bidTenderForFinancialSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String itemMasterSize = request.getParameter("itemMasterSize");

        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        String termsParameter = tenderMaster.getTermsCondition();

        TermsCondition termsCondition = termsConditionService.readByName(termsParameter);
        int termsParameterId = termsCondition.getId();

        List list4 = termsConditionParameterService.readAllTerms(termsParameterId);
        int termsConditionCount = list4.size();

        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("termsConditionCount", termsConditionCount);

        //-----------------------------------------
        String common_tax = request.getParameter("common_tax");
        if (common_tax == null) {
            common_tax = "0";
        }
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = "0";
        String freight = "0";
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value = request.getParameter("insurance_value");
        String total_amount = request.getParameter("total_amount");
        String grand_total = request.getParameter("grand_total");
        String venodr_total_words = request.getParameter("venodr_total_words");
        String modeOfFraight = request.getParameter("modeOfFraight");
        String freight_comment = request.getParameter("freight_comment");

        vendorTenderBidService.updateVendorItem(refNo, username, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total, venodr_total_words);

        VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);

        String service_tax_total = vendorTenderBid11.getServiceTaxTotal();
        if (service_tax_total == null) {
            service_tax_total = "0.0";
        }
        double final_total = Double.parseDouble(grand_total) + Double.parseDouble(service_tax_total);

        vendorTenderBid11.setFreightFreeDelivery(modeOfFraight);
        vendorTenderBid11.setFreeDeliveryComment(freight_comment);
        vendorTenderBid11.setFinalTotal(final_total + "");

        vendorTenderBidService.update(vendorTenderBid11);
        //item details

        String[] item_code = request.getParameterValues("item_code");
        String[] item_description = request.getParameterValues("item_description");
        String[] item_remark = request.getParameterValues("item_remark");
        String[] uom = request.getParameterValues("uom");
        String[] qty = request.getParameterValues("qty");
        String[] attachment_required = request.getParameterValues("attachment_required");
        String[] delivery_schedule_date = request.getParameterValues("delivery_schedule_date");
        String[] delivery_schedule_qty = request.getParameterValues("delivery_schedule_qty");
        String[] item_location = request.getParameterValues("item_location");
        String[] pur_no = request.getParameterValues("pur_no");
        String[] item_no = request.getParameterValues("item_no");
        String[] sr_no = request.getParameterValues("sr_no");
        String[] pr_no = request.getParameterValues("pr_no");
        String[] unit_rate = request.getParameterValues("unit_rate");
        String[] net_rate = request.getParameterValues("net_rate");
        String[] hsn_no = request.getParameterValues("hsn_no");
        String[] vendor_remark = request.getParameterValues("vendor_remark");
        String[] item_discount_val = request.getParameterValues("item_discount_val");
        String[] item_discount = request.getParameterValues("item_discount");
        String[] item_packing_val = request.getParameterValues("item_packing_val");
        String[] item_packing = request.getParameterValues("item_packing");
        String[] item_freight_val = request.getParameterValues("item_freight_val");
        String[] item_freight = request.getParameterValues("item_freight");
        String[] item_errection = request.getParameterValues("item_errection");
        String[] item_other_charges = request.getParameterValues("item_other_charges");
        String[] item_igst = request.getParameterValues("item_igst");
        String[] item_cgst = request.getParameterValues("item_cgst");
        String[] item_sgst = request.getParameterValues("item_sgst");
        String[] item_insurance_value = request.getParameterValues("item_insurance_value");
        String[] item_total = request.getParameterValues("item_total");
        String[] item_regret = request.getParameterValues("item_regret");
        String[] accountAssigmentCategory = request.getParameterValues("accountAssigmentCategory");
        String[] accountAssigmentValue = request.getParameterValues("accountAssigmentValue");
        String[] productType = request.getParameterValues("productType");
        String[] productGroup = request.getParameterValues("productGroup");
        String[] taxCode = request.getParameterValues("taxCode");
        String[] valuationPrice = request.getParameterValues("valuationPrice");
        String[] deliveryDate = request.getParameterValues("deliveryDate");
        String[] startDate = request.getParameterValues("startDate");
        String[] endDate = request.getParameterValues("endDate");

        int j = 0;
        for (int i = 0; i < item_code.length; i++) {
            j++;

            int item_type = 0;
            List vendorTenderBidItem1 = vendorTenderBidItemService.readItemVendorRefNo(refNo, username, sr_no[i], item_type);

            if (vendorTenderBidItem1.isEmpty()) {
                VendorTenderBidItem vendorTenderBidItem = new VendorTenderBidItem();
                vendorTenderBidItem.setRefNo(refNo);
                vendorTenderBidItem.setVendorCode(username);
                vendorTenderBidItem.setItemCode(item_code[i]);
                vendorTenderBidItem.setItemDescription(item_description[i]);
                vendorTenderBidItem.setRemark(item_remark[i]);
                vendorTenderBidItem.setUom(uom[i]);
                vendorTenderBidItem.setQty(qty[i]);
                vendorTenderBidItem.setAttachmentRequired(attachment_required[i]);
                vendorTenderBidItem.setDeliveryScheduleDate(delivery_schedule_date[i]);
                vendorTenderBidItem.setDeliveryScheduleQty(delivery_schedule_qty[i]);
                vendorTenderBidItem.setLocation(item_location[i]);
                vendorTenderBidItem.setPurNo(pur_no[i]);
                vendorTenderBidItem.setItemNo(item_no[i]);
                vendorTenderBidItem.setSrNo(sr_no[i]);
                vendorTenderBidItem.setPrNo(pr_no[i]);
                if (unit_rate[i].equals("")) {
                    unit_rate[i] = "0";
                }
                vendorTenderBidItem.setRate(unit_rate[i]);
                vendorTenderBidItem.setNetRate(net_rate[i]);
                vendorTenderBidItem.setHsnNo(hsn_no[i]);
                vendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                vendorTenderBidItem.setDiscountType(item_discount_val[i]);
                vendorTenderBidItem.setDiscountValue(item_discount[i]);
                vendorTenderBidItem.setPackingType(item_packing_val[i]);
                vendorTenderBidItem.setPackingValue(item_packing[i]);
                vendorTenderBidItem.setFreightType(item_freight_val[i]);
                vendorTenderBidItem.setFreightValue(item_freight[i]);
                vendorTenderBidItem.setErrectionValue(item_errection[i]);
                vendorTenderBidItem.setChargesValue(item_other_charges[i]);
                vendorTenderBidItem.setIgstValue(item_igst[i]);
                vendorTenderBidItem.setCgstValue(item_cgst[i]);
                vendorTenderBidItem.setSgstValue(item_sgst[i]);
                vendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                vendorTenderBidItem.setTotalValue(item_total[i]);
                vendorTenderBidItem.setItemRegret(item_regret[i]);
                vendorTenderBidItem.setItemType(0);
                vendorTenderBidItem.setAccountAssigmentCategory(accountAssigmentCategory[i]);
                vendorTenderBidItem.setAccountAssigmentValue(accountAssigmentValue[i]);
                vendorTenderBidItem.setProductType(productType[i]);
                vendorTenderBidItem.setProductGroup(productGroup[i]);
                vendorTenderBidItem.setTaxCode(taxCode[i]);
                vendorTenderBidItem.setValuationPrice(valuationPrice[i]);
                vendorTenderBidItem.setDeliveryDate(deliveryDate[i]);
                vendorTenderBidItem.setStartDate(startDate[i]);
                vendorTenderBidItem.setEndDate(endDate[i]);
                vendorTenderBidItemService.create(vendorTenderBidItem);
            } else {
                vendorTenderBidItemService.updateItemVendorRefNo(refNo, username, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], attachment_required[i], delivery_schedule_date[i], delivery_schedule_qty[i], item_location[i], pur_no[i], item_no[i], unit_rate[i], net_rate[i], hsn_no[i], vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i]);
                VendorTenderBidItem vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNo(refNo, username, "0");
                vendorTenderBidItem.setAccountAssigmentCategory(accountAssigmentCategory[i]);
                vendorTenderBidItem.setAccountAssigmentValue(accountAssigmentValue[i]);
                vendorTenderBidItem.setProductType(productType[i]);
                vendorTenderBidItem.setProductGroup(productGroup[i]);
                vendorTenderBidItem.setTaxCode(taxCode[i]);
                vendorTenderBidItem.setValuationPrice(valuationPrice[i]);
                vendorTenderBidItem.setDeliveryDate(deliveryDate[i]);
                vendorTenderBidItem.setStartDate(startDate[i]);
                vendorTenderBidItem.setEndDate(endDate[i]);
                //    vendorTenderBidItemService.update(vendorTenderBidItem);
            }

        }

        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        String type = tenderMaster.getType();

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //get pre qualiication details
        VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
        String preBidDeviation = vendorPreBid.getPreBidDeviation();
        String preBidRemark = vendorPreBid.getPreBidRemark();

        List tenderItemMaster = tenderItemMasterService.readByRefNoAndItemType(refNo, 1);
        int tenderItemMasterCount = tenderItemMaster.size();

        if (tenderItemMaster.size() > 0) {

            List vendorTenderBidItem1 = vendorTenderBidItemService.readByVendorRefNo(refNo, username);

            int item_type = 1;
            List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, item_type);

            String gst = "";
            if (vendorTenderBidItem.size() == 0) {
                // check last bid data
                for (Object o : tenderItemMaster) {

                    TenderItemMaster tim = (TenderItemMaster) o;
                    String uom1 = tim.getUom();
                    gst = tim.getGst();

                    if (!uom1.equals("")) {
                        break;

                    }

                }

            }

            //vendor tender bid
            VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
            int rivision = vendorTenderBid.getRevision();
            String discount_type = vendorTenderBid.getServiceDiscountType();
            String discount_value = vendorTenderBid.getServiceDiscountValue();
            String packing_type = vendorTenderBid.getPackingType();
            String packing_value = vendorTenderBid.getPackingValue();
            String freight_type = vendorTenderBid.getFreightType();
            String freight_value = vendorTenderBid.getFreightValue();
            String errection_value = vendorTenderBid.getErrectionValue();
            String charges_value = vendorTenderBid.getChargesValue();
            String igst_value = vendorTenderBid.getServiceGst();
            String cgst_value = vendorTenderBid.getCgstValue();
            String sgst_value = vendorTenderBid.getSgstValue();
            // String insurance_value = vendorTenderBid.getInsuranceValue();
            String item_total1 = vendorTenderBid.getServiceTotal();
            String grand_total1 = vendorTenderBid.getServiceTaxTotal();
            String grand_total_word = vendorTenderBid.getGrandTotalWord();
            String select_common = vendorTenderBid.getSelectCommon();
            String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
            String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();

            if (vendorTenderBidItem.size() == 0) {
                igst_value = gst;
                mv.getModelMap().put("igst_value", gst);
            }

            mv.getModelMap().put("rivision", rivision);
            mv.getModelMap().put("discount_type", discount_type);
            mv.getModelMap().put("discount_value", discount_value);
            mv.getModelMap().put("packing_type", packing_type);
            mv.getModelMap().put("packing_value", packing_value);
            mv.getModelMap().put("freight_type", freight_type);
            mv.getModelMap().put("freight_value", freight_value);
            mv.getModelMap().put("errection_value", errection_value);
            mv.getModelMap().put("charges_value", charges_value);
            mv.getModelMap().put("igst_value", igst_value);
            mv.getModelMap().put("cgst_value", cgst_value);
            mv.getModelMap().put("sgst_value", sgst_value);
            mv.getModelMap().put("insurance_value", insurance_value);
            mv.getModelMap().put("item_total", item_total1);
            mv.getModelMap().put("grand_total", grand_total1);
            mv.getModelMap().put("grand_total_word", grand_total_word);
            mv.getModelMap().put("select_common", select_common);

            mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
            mv.getModelMap().put("free_delivery_comment", free_delivery_comment);

            List list1 = tenderMasterService.vendorLiveTender(username);
            request.setAttribute("list", list1);
            mv.getModelMap().put("tenderMaster", tenderMaster);
            mv.getModelMap().put("refNo", refNo);

            mv.getModelMap().put("generalDocs", generalDocs);
            mv.getModelMap().put("additionalDocs", additionalDocs);
            mv.getModelMap().put("technicalDocs", technicalDocs);

            mv.getModelMap().put("tenderItemMaster", tenderItemMaster);

            mv.getModelMap().put("tenderItemMasterCount", tenderItemMasterCount);

            mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);

            List<VendorTenderBidItem> vendorTenderBidItem2 = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, 0);
            int vendorTenderBidItem2count = vendorTenderBidItem2.size();

            boolean isVendorItemDerailsValid = (Integer.parseInt(itemMasterSize) == vendorTenderBidItem2count);

            if (isVendorItemDerailsValid) {
                mv.setViewName("Vendor/BidTenderForServiceFinancial");
            } else {
                for (VendorTenderBidItem venTenderBid : vendorTenderBidItem2) {
                    int id = venTenderBid.getId();
                    vendorTenderBidItemService.delete(id);
                }

                request.setAttribute("failureMessage",
                        "Information: Data not submitted properly. Please try again.");
                mv.setViewName("forward:vendor.htm?act=bidTenderForFinancialPage&refNo=" + refNo);

            }

            return mv;

        }

        //vendor tender bid
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        int rivision = vendorTenderBid.getRevision();
        String delivery_location = vendorTenderBid.getDeliveryLocation();
        String delivery_period = vendorTenderBid.getDeliveryPeriod();
        String terms_of_payment = vendorTenderBid.getTermsOfPayment();
        String validity_period = vendorTenderBid.getValidityPeriod();
        String mode_of_transport = vendorTenderBid.getModeOfTransport();
        String inco_terms = vendorTenderBid.getIncoTerms();
        String insurance1 = vendorTenderBid.getInsurance();
        String freight1 = vendorTenderBid.getFreight();
        String grand_total1 = vendorTenderBid.getGrandTotal();
        String grand_total_word1 = vendorTenderBid.getGrandTotalWord();
        String remark_by_vendor = vendorTenderBid.getRemarkByVendor();

        mv.getModelMap().put("rivision", rivision);
        mv.getModelMap().put("type", type);

        mv.getModelMap().put("delivery_location", delivery_location);
        mv.getModelMap().put("delivery_period", delivery_period);
        mv.getModelMap().put("terms_of_payment", terms_of_payment);
        mv.getModelMap().put("validity_period", validity_period);
        mv.getModelMap().put("mode_of_transport", mode_of_transport);
        mv.getModelMap().put("inco_terms", inco_terms);
        mv.getModelMap().put("insurance1", insurance1);
        mv.getModelMap().put("freight1", freight1);
        mv.getModelMap().put("grand_total1", grand_total1);
        mv.getModelMap().put("grand_total_word1", grand_total_word1);
        mv.getModelMap().put("remark_by_vendor", remark_by_vendor);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);

//        TermsConditionParameter termsConditionParameter = new TermsConditionParameter().readByName();
        List vendorTermsConditionPriceBid1 = vendorTermsConditionPriceBidService.readByRef(refNo, username);

        mv.getModelMap().put("vendorTermsCondition1", vendorTermsConditionPriceBid1);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);
        mv.getModelMap().put("preBidDeviation", preBidDeviation);
        mv.getModelMap().put("preBidRemark", preBidRemark);

        mv.setViewName("Vendor/BidTenderForCondition");
        return mv;
    }

    public ModelAndView bidTenderForServiceFinancialSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        String termsParameter = tenderMaster.getTermsCondition();

        TermsCondition termsCondition = termsConditionService.readByName(termsParameter);
        int termsParameterId = termsCondition.getId();

        List list4 = termsConditionParameterService.readAllTerms(termsParameterId);
        int termsConditionCount = list4.size();
        mv.getModelMap().put("list4", list4);
        mv.getModelMap().put("termsConditionCount", termsConditionCount);

        //-----------------------------------------
        String common_tax = request.getParameter("common_tax");
        if (common_tax == null) {
            common_tax = "0";
        }
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value = request.getParameter("insurance_value");
        String total_amount = request.getParameter("total_amount");
        String grand_total = request.getParameter("grand_total");
        String venodr_total_words = request.getParameter("venodr_total_words");
        String modeOfFraight = request.getParameter("modeOfFraight");
        String freight_comment = request.getParameter("freight_comment");

        vendorTenderBidService.updateVendorServiceItem(refNo, username, discount_val, discount, igst, total_amount, grand_total);

        VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);

        String item_tax_total = vendorTenderBid11.getGrandTotal();
        if (item_tax_total == null) {
            item_tax_total = "0.0";
        }
        double final_total = Double.parseDouble(grand_total) + Double.parseDouble(item_tax_total);

        long tmp = Math.round(final_total * 100);
        final_total = (double) tmp / 100;

        BigDecimal bd = new BigDecimal(final_total);
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        String plainString = bd.toPlainString();

        vendorTenderBid11.setFreightFreeDelivery(modeOfFraight);
        vendorTenderBid11.setFreeDeliveryComment(freight_comment);
        vendorTenderBid11.setFinalTotal(plainString + "");
        vendorTenderBidService.update(vendorTenderBid11);
        //item details

        String[] item_code = request.getParameterValues("item_code");
        String[] item_description = request.getParameterValues("item_description");
        String[] item_remark = request.getParameterValues("item_remark");
        String[] uom = request.getParameterValues("uom");
        String[] qty = request.getParameterValues("qty");
        String[] attachment_required = request.getParameterValues("attachment_required");
        String[] delivery_schedule_date = request.getParameterValues("delivery_schedule_date");
        String[] delivery_schedule_qty = request.getParameterValues("delivery_schedule_qty");
        String[] item_location = request.getParameterValues("item_location");
        String[] pur_no = request.getParameterValues("pur_no");
        String[] item_no = request.getParameterValues("item_no");
        String[] sr_no = request.getParameterValues("sr_no");
        String[] pr_no = request.getParameterValues("pr_no");
        String[] unit_rate = request.getParameterValues("unit_rate");
        String[] net_rate = request.getParameterValues("net_rate");
        String[] hsn_no = request.getParameterValues("hsn_no");
        String[] vendor_remark = request.getParameterValues("vendor_remark");
        String[] item_discount_val = request.getParameterValues("item_discount_val");
        String[] item_discount = request.getParameterValues("item_discount");
        String[] item_packing_val = request.getParameterValues("item_packing_val");
        String[] item_packing = request.getParameterValues("item_packing");
        String[] item_freight_val = request.getParameterValues("item_freight_val");
        String[] item_freight = request.getParameterValues("item_freight");
        String[] item_errection = request.getParameterValues("item_errection");
        String[] item_other_charges = request.getParameterValues("item_other_charges");
        String[] item_igst = request.getParameterValues("item_igst");
        String[] item_cgst = request.getParameterValues("item_cgst");
        String[] item_sgst = request.getParameterValues("item_sgst");
        String[] item_insurance_value = request.getParameterValues("item_insurance_value");
        String[] item_total = request.getParameterValues("item_total");
        String[] item_regret = request.getParameterValues("item_regret");

        int j = 0;
        for (int i = 0; i < item_code.length; i++) {
            j++;

            int item_type = 1;
            List vendorTenderBidItem1 = vendorTenderBidItemService.readItemVendorRefNo(refNo, username, sr_no[i], item_type);

            if (vendorTenderBidItem1.isEmpty()) {
                VendorTenderBidItem vendorTenderBidItem = new VendorTenderBidItem();
                vendorTenderBidItem.setRefNo(refNo);
                vendorTenderBidItem.setVendorCode(username);
                vendorTenderBidItem.setItemCode(item_code[i]);
                vendorTenderBidItem.setItemDescription(item_description[i]);
                vendorTenderBidItem.setRemark(item_remark[i]);
                vendorTenderBidItem.setUom(uom[i]);
                vendorTenderBidItem.setQty(qty[i]);
                vendorTenderBidItem.setAttachmentRequired(attachment_required[i]);
                vendorTenderBidItem.setDeliveryScheduleDate(delivery_schedule_date[i]);
                vendorTenderBidItem.setDeliveryScheduleQty(delivery_schedule_qty[i]);
                vendorTenderBidItem.setLocation(item_location[i]);
                vendorTenderBidItem.setPurNo(pur_no[i]);
                vendorTenderBidItem.setItemNo(item_no[i]);
                vendorTenderBidItem.setSrNo(sr_no[i]);
                vendorTenderBidItem.setPrNo(pr_no[i]);
                if (unit_rate[i].equals("")) {
                    unit_rate[i] = "0";
                }
                vendorTenderBidItem.setRate(unit_rate[i]);
                vendorTenderBidItem.setNetRate(net_rate[i]);
                vendorTenderBidItem.setHsnNo(hsn_no[i]);
                vendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                vendorTenderBidItem.setDiscountType(item_discount_val[i]);
                vendorTenderBidItem.setDiscountValue(item_discount[i]);
                vendorTenderBidItem.setPackingType(item_packing_val[i]);
                vendorTenderBidItem.setPackingValue(item_packing[i]);
                vendorTenderBidItem.setFreightType(item_freight_val[i]);
                vendorTenderBidItem.setFreightValue(item_freight[i]);
                vendorTenderBidItem.setErrectionValue(item_errection[i]);
                vendorTenderBidItem.setChargesValue(item_other_charges[i]);
                vendorTenderBidItem.setIgstValue(item_igst[i]);
                vendorTenderBidItem.setCgstValue(item_cgst[i]);
                vendorTenderBidItem.setSgstValue(item_sgst[i]);
                vendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                vendorTenderBidItem.setTotalValue(item_total[i]);
                vendorTenderBidItem.setItemRegret(item_regret[i]);
                vendorTenderBidItem.setItemType(1);
                vendorTenderBidItemService.create(vendorTenderBidItem);
            } else {
                vendorTenderBidItemService.updateItemVendorRefNo1(refNo, username, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], attachment_required[i], delivery_schedule_date[i], delivery_schedule_qty[i], item_location[i], pur_no[i], item_no[i], unit_rate[i], net_rate[i], hsn_no[i], vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i]);

            }

        }

        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        String type = tenderMaster.getType();

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //get pre qualiication details
        VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
        String preBidDeviation = vendorPreBid.getPreBidDeviation();
        String preBidRemark = vendorPreBid.getPreBidRemark();

        //vendor tender bid
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        int rivision = vendorTenderBid.getRevision();
        String delivery_location = vendorTenderBid.getDeliveryLocation();
        String delivery_period = vendorTenderBid.getDeliveryPeriod();
        String terms_of_payment = vendorTenderBid.getTermsOfPayment();
        String validity_period = vendorTenderBid.getValidityPeriod();
        String mode_of_transport = vendorTenderBid.getModeOfTransport();
        String inco_terms = vendorTenderBid.getIncoTerms();
        String insurance1 = vendorTenderBid.getInsurance();
        String freight1 = vendorTenderBid.getFreight();
        String grand_total1 = vendorTenderBid.getFinalTotal();
        String grand_total_word1 = vendorTenderBid.getGrandTotalWord();
        String remark_by_vendor = vendorTenderBid.getRemarkByVendor();

        mv.getModelMap().put("rivision", rivision);
        mv.getModelMap().put("type", type);

        mv.getModelMap().put("delivery_location", delivery_location);
        mv.getModelMap().put("delivery_period", delivery_period);
        mv.getModelMap().put("terms_of_payment", terms_of_payment);
        mv.getModelMap().put("validity_period", validity_period);
        mv.getModelMap().put("mode_of_transport", mode_of_transport);
        mv.getModelMap().put("inco_terms", inco_terms);
        mv.getModelMap().put("insurance1", insurance1);
        mv.getModelMap().put("freight1", freight1);
        mv.getModelMap().put("grand_total1", grand_total1);
        mv.getModelMap().put("grand_total_word1", grand_total_word1);
        mv.getModelMap().put("remark_by_vendor", remark_by_vendor);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, username);

        mv.getModelMap().put("vendorTermsCondition1", vendorTermsCondition1);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);
        mv.getModelMap().put("preBidDeviation", preBidDeviation);
        mv.getModelMap().put("preBidRemark", preBidRemark);

        String itemMasterSize = request.getParameter("tenderItemMasterCount");

        List<VendorTenderBidItem> vendorTenderBidItem2 = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, 1);
        int vendorTenderBidItem2count = vendorTenderBidItem2.size();

        boolean isVendorItemDerailsValid = (Integer.parseInt(itemMasterSize) == vendorTenderBidItem2count);

        if (isVendorItemDerailsValid) {
            mv.setViewName("Vendor/BidTenderForCondition");
        } else {
            for (VendorTenderBidItem venTenderBid : vendorTenderBidItem2) {
                int id = venTenderBid.getId();
                vendorTenderBidItemService.delete(id);
            }

            request.setAttribute("failureMessage",
                    "Information: Data not submitted properly. Please try again.");
            mv.setViewName("forward:vendor.htm?act=bidTenderForTermsServicePage&refNo=" + refNo);

        }

        return mv;
    }

    public ModelAndView bidTenderForFinancialServiceManualSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String file_no = request.getParameter("file_no");
        String service_type = request.getParameter("service_type");
        String file_name = request.getParameter("file_name");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        if (service_type.equals("Service1")) {
            String common_tax = request.getParameter("common_tax");
            if (common_tax == null) {
                common_tax = "0";
            }
            String discount_val = request.getParameter("discount_val");
            if (discount_val == null) {
                discount_val = "0";
            }
            String discount = request.getParameter("discount");
            if (discount == null) {
                discount = "0";
            }
            String packing_val = request.getParameter("packing_val");
            if (packing_val == null) {
                packing_val = "0";
            }
            String packing = request.getParameter("packing");
            if (packing == null) {
                packing = "0";
            }
            String freight_val = request.getParameter("freight_val");
            if (freight_val == null) {
                freight_val = "0";
            }
            String freight = request.getParameter("freight");
            if (freight == null) {
                freight = "0";
            }
            String errection = request.getParameter("errection");
            if (errection == null) {
                errection = "0";
            }
            String other_charges = request.getParameter("other_charges");
            if (other_charges == null) {
                other_charges = "0";
            }
            String igst = request.getParameter("igst");
            if (igst == null) {
                igst = "0";
            }
            String cgst = request.getParameter("cgst");
            if (cgst == null) {
                cgst = "0";
            }
            String sgst = request.getParameter("sgst");
            if (sgst == null) {
                sgst = "0";
            }
            String insurance_value = request.getParameter("insurance_value");
            if (insurance_value == null) {
                insurance_value = "0";
            }
            String total_amount = request.getParameter("total_amount");
            if (total_amount == null) {
                total_amount = "0";
            }
            String grand_total = request.getParameter("grand_total");
            if (grand_total == null) {
                grand_total = total_amount;
            }

            List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);

            if (serviceVendorTenderBid.isEmpty()) {
                ServiceVendorTenderBid serviceVendorTenderBid1 = new ServiceVendorTenderBid();
                serviceVendorTenderBid1.setTenderNo(refNo);
                serviceVendorTenderBid1.setVendorCode(username);
                serviceVendorTenderBid1.setFileName(file_name);
                serviceVendorTenderBid1.setSelectCommon(common_tax);
                serviceVendorTenderBid1.setDiscountType(discount_val);
                serviceVendorTenderBid1.setDiscountValue(discount);
                serviceVendorTenderBid1.setPackingType(packing_val);
                serviceVendorTenderBid1.setPackingValue(packing);
                serviceVendorTenderBid1.setFreightType(freight_val);
                serviceVendorTenderBid1.setFreightValue(freight);
                serviceVendorTenderBid1.setErrectionValue(errection);
                serviceVendorTenderBid1.setChargesValue(other_charges);
                serviceVendorTenderBid1.setIgstValue(igst);
                serviceVendorTenderBid1.setCgstValue(cgst);
                serviceVendorTenderBid1.setSgstValue(sgst);
                serviceVendorTenderBid1.setInsuranceValue(insurance_value);
                serviceVendorTenderBid1.setItemTotal(total_amount);
                serviceVendorTenderBid1.setGrandTotal(grand_total);
                serviceVendorTenderBidService.create(serviceVendorTenderBid1);
            } else {
                serviceVendorTenderBidService.updateVendorTenderBid(refNo, username, file_name, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total);
            }

            //item details
            String[] sr_no = request.getParameterValues("sr_no");
            String[] item_description = request.getParameterValues("item_description");
            String[] item_remark = request.getParameterValues("item_remark");
            String[] uom = request.getParameterValues("uom");
            String[] qty = request.getParameterValues("qty");
            String[] attachment_required = request.getParameterValues("attachment_required");
            String[] unit_rate = request.getParameterValues("unit_rate");
            String[] net_rate = request.getParameterValues("net_rate");
            String[] hsn_no = request.getParameterValues("hsn_no");
            String[] vendor_remark = request.getParameterValues("vendor_remark");
            String[] item_discount_val = request.getParameterValues("item_discount_val");
            String[] item_discount = request.getParameterValues("item_discount");
            String[] item_packing_val = request.getParameterValues("item_packing_val");
            String[] item_packing = request.getParameterValues("item_packing");
            String[] item_freight_val = request.getParameterValues("item_freight_val");
            String[] item_freight = request.getParameterValues("item_freight");
            String[] item_errection = request.getParameterValues("item_errection");
            String[] item_other_charges = request.getParameterValues("item_other_charges");
            String[] item_igst = request.getParameterValues("item_igst");
            String[] item_cgst = request.getParameterValues("item_cgst");
            String[] item_sgst = request.getParameterValues("item_sgst");
            String[] item_insurance_value = request.getParameterValues("item_insurance_value");
            String[] item_total = request.getParameterValues("item_total");
            String[] item_regret = request.getParameterValues("item_regret");

            int j = 0;
            for (int i = 0; i < sr_no.length; i++) {
                j++;

                List serviceVendorTenderBidItem1 = serviceVendorTenderBidItemService.readItemVendorRefNo(refNo, username, file_name, sr_no[i]);

                if (serviceVendorTenderBidItem1.isEmpty()) {
                    ServiceVendorTenderBidItem serviceVendorTenderBidItem = new ServiceVendorTenderBidItem();
                    serviceVendorTenderBidItem.setTenderNo(refNo);
                    serviceVendorTenderBidItem.setVendorCode(username);
                    serviceVendorTenderBidItem.setFileName(file_name);
                    serviceVendorTenderBidItem.setSrNo(sr_no[i]);
                    serviceVendorTenderBidItem.setItemDesc(item_description[i]);
                    serviceVendorTenderBidItem.setRemark(item_remark[i]);
                    serviceVendorTenderBidItem.setUom(uom[i]);
                    serviceVendorTenderBidItem.setQuantity(qty[i]);
                    serviceVendorTenderBidItem.setRate(unit_rate[i]);
                    serviceVendorTenderBidItem.setNetRate(net_rate[i]);
                    serviceVendorTenderBidItem.setHsnNo(hsn_no[i]);
                    serviceVendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                    serviceVendorTenderBidItem.setDiscountType(item_discount_val[i]);
                    serviceVendorTenderBidItem.setDiscountValue(item_discount[i]);
                    serviceVendorTenderBidItem.setPackingType(item_packing_val[i]);
                    serviceVendorTenderBidItem.setPackingValue(item_packing[i]);
                    serviceVendorTenderBidItem.setFreightType(item_freight_val[i]);
                    serviceVendorTenderBidItem.setFreightValue(item_freight[i]);
                    serviceVendorTenderBidItem.setErrectionValue(item_errection[i]);
                    serviceVendorTenderBidItem.setChargesValue(item_other_charges[i]);
                    serviceVendorTenderBidItem.setIgstValue(item_igst[i]);
                    serviceVendorTenderBidItem.setCgstValue(item_cgst[i]);
                    serviceVendorTenderBidItem.setSgstValue(item_sgst[i]);
                    serviceVendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                    serviceVendorTenderBidItem.setTotalValue(item_total[i]);
                    serviceVendorTenderBidItem.setItemRegret(item_regret[i]);
                    serviceVendorTenderBidItemService.create(serviceVendorTenderBidItem);
                } else {
                    serviceVendorTenderBidItemService.updateItemVendorRefNo(refNo, username, file_name, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], unit_rate[i], net_rate[i], hsn_no[i], vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i]);

                }

            }

        } else if (service_type.equals("Service2")) {
            String total_amount = request.getParameter("total_amount");

            List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);

            if (serviceVendorTenderBid.isEmpty()) {
                ServiceVendorTenderBid serviceVendorTenderBid1 = new ServiceVendorTenderBid();
                serviceVendorTenderBid1.setTenderNo(refNo);
                serviceVendorTenderBid1.setVendorCode(username);
                serviceVendorTenderBid1.setFileName(file_name);
                serviceVendorTenderBid1.setSelectCommon("");
                serviceVendorTenderBid1.setDiscountType("");
                serviceVendorTenderBid1.setDiscountValue("");
                serviceVendorTenderBid1.setPackingType("");
                serviceVendorTenderBid1.setPackingValue("");
                serviceVendorTenderBid1.setFreightType("");
                serviceVendorTenderBid1.setFreightValue("");
                serviceVendorTenderBid1.setErrectionValue("");
                serviceVendorTenderBid1.setChargesValue("");
                serviceVendorTenderBid1.setIgstValue("");
                serviceVendorTenderBid1.setCgstValue("");
                serviceVendorTenderBid1.setSgstValue("");
                serviceVendorTenderBid1.setInsuranceValue("");
                serviceVendorTenderBid1.setItemTotal("0");
                serviceVendorTenderBid1.setGrandTotal("0");
                serviceVendorTenderBidService.create(serviceVendorTenderBid1);
            } else {
                serviceVendorTenderBidService.updateVendorTenderBid(refNo, username, file_name, "", "", "", "", "", "", "", "", "", "", "", "", "", "0", "0");
            }

            String[] sr_no = request.getParameterValues("sr_no");
            String[] item_description = request.getParameterValues("item_description");
            String[] onlyBearing1 = request.getParameterValues("onlyBearing1");
            String[] onlyBearing2 = request.getParameterValues("onlyBearing2");
            String[] onlyBearing3 = request.getParameterValues("onlyBearing3");
            String[] onlyBearing4 = request.getParameterValues("onlyBearing4");
            String[] onlyBearing5 = request.getParameterValues("onlyBearing5");
            String[] onlyBearing6 = request.getParameterValues("onlyBearing6");
            String[] onlyBearing7 = request.getParameterValues("onlyBearing7");
            String[] onlyBearing8 = request.getParameterValues("onlyBearing8");
            String[] onlyBearing9 = request.getParameterValues("onlyBearing9");
            String[] onlyBearing10 = request.getParameterValues("onlyBearing10");

            int j = 0;
            for (int i = 0; i < sr_no.length; i++) {
                j++;

                String Bearing1 = "";
                String Bearing2 = "";
                String Bearing3 = "";
                String Bearing4 = "";
                String Bearing5 = "";
                String Bearing6 = "";
                String Bearing7 = "";
                String Bearing8 = "";
                String Bearing9 = "";
                String Bearing10 = "";
                try {
                    Bearing1 = onlyBearing1[i];
                } catch (Exception e1) {
                }
                try {
                    Bearing2 = onlyBearing2[i];
                } catch (Exception e1) {
                }
                try {
                    Bearing3 = onlyBearing3[i];
                } catch (Exception e1) {
                }
                try {
                    Bearing4 = onlyBearing4[i];
                } catch (Exception e1) {
                }
                try {
                    Bearing5 = onlyBearing5[i];
                } catch (Exception e1) {
                }
                try {
                    Bearing6 = onlyBearing6[i];
                } catch (Exception e1) {
                }
                try {
                    Bearing7 = onlyBearing7[i];
                } catch (Exception e1) {
                }
                try {
                    Bearing8 = onlyBearing8[i];
                } catch (Exception e1) {
                }
                try {
                    Bearing9 = onlyBearing9[i];
                } catch (Exception e1) {
                }
                try {
                    Bearing10 = onlyBearing10[i];
                } catch (Exception e1) {
                }

                List serviceVendorTenderBidItem21 = serviceVendorTenderBidItem2Service.readItemVendorRefNo(refNo, username, file_name, sr_no[i]);

                if (serviceVendorTenderBidItem21.isEmpty()) {
                    ServiceVendorTenderBidItem2 serviceVendorTenderBidItem2 = new ServiceVendorTenderBidItem2();
                    serviceVendorTenderBidItem2.setTenderNo(refNo);
                    serviceVendorTenderBidItem2.setVendorCode(username);
                    serviceVendorTenderBidItem2.setFileName(file_name);
                    serviceVendorTenderBidItem2.setSrNo(sr_no[i]);
                    serviceVendorTenderBidItem2.setItemDesc(item_description[i]);
                    serviceVendorTenderBidItem2.setOnlyBearing1(Bearing1);
                    serviceVendorTenderBidItem2.setOnlyBearing2(Bearing2);
                    serviceVendorTenderBidItem2.setOnlyBearing3(Bearing3);
                    serviceVendorTenderBidItem2.setOnlyBearing4(Bearing4);
                    serviceVendorTenderBidItem2.setOnlyBearing5(Bearing5);
                    serviceVendorTenderBidItem2.setOnlyBearing6(Bearing6);
                    serviceVendorTenderBidItem2.setOnlyBearing7(Bearing7);
                    serviceVendorTenderBidItem2.setOnlyBearing8(Bearing8);
                    serviceVendorTenderBidItem2.setOnlyBearing9(Bearing9);
                    serviceVendorTenderBidItem2.setOnlyBearing10(Bearing10);
                    serviceVendorTenderBidItem2Service.create(serviceVendorTenderBidItem2);
                } else {
                    serviceVendorTenderBidItem2Service.updateItemVendorRefNo(refNo, username, file_name, sr_no[i], item_description[i], Bearing1, Bearing2, Bearing3, Bearing4, Bearing5, Bearing6, Bearing7, Bearing8, Bearing9, Bearing10);
                }
            }

        } else if (service_type.equals("Service3")) {
            String total_amount = request.getParameter("total_amount");

            List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);

            if (serviceVendorTenderBid.isEmpty()) {
                ServiceVendorTenderBid serviceVendorTenderBid1 = new ServiceVendorTenderBid();
                serviceVendorTenderBid1.setTenderNo(refNo);
                serviceVendorTenderBid1.setVendorCode(username);
                serviceVendorTenderBid1.setFileName(file_name);
                serviceVendorTenderBid1.setSelectCommon("");
                serviceVendorTenderBid1.setDiscountType("");
                serviceVendorTenderBid1.setDiscountValue("");
                serviceVendorTenderBid1.setPackingType("");
                serviceVendorTenderBid1.setPackingValue("");
                serviceVendorTenderBid1.setFreightType("");
                serviceVendorTenderBid1.setFreightValue("");
                serviceVendorTenderBid1.setErrectionValue("");
                serviceVendorTenderBid1.setChargesValue("");
                serviceVendorTenderBid1.setIgstValue("");
                serviceVendorTenderBid1.setCgstValue("");
                serviceVendorTenderBid1.setSgstValue("");
                serviceVendorTenderBid1.setInsuranceValue("");
                serviceVendorTenderBid1.setItemTotal(total_amount);
                serviceVendorTenderBid1.setGrandTotal(total_amount);
                serviceVendorTenderBidService.create(serviceVendorTenderBid1);
            } else {
                serviceVendorTenderBidService.updateVendorTenderBid(refNo, username, file_name, "", "", "", "", "", "", "", "", "", "", "", "", "", total_amount, total_amount);
            }

            String[] sr_no = request.getParameterValues("sr_no");
            String[] particular = request.getParameterValues("particular");
            String[] scheduled_amount = request.getParameterValues("scheduled_amount");
            String[] percentage = request.getParameterValues("percentage");
            String[] percentage_amount = request.getParameterValues("percentage_amount");
            String[] net_rate = request.getParameterValues("net_rate");
            String[] vendor_remark = request.getParameterValues("vendor_remark");
            String[] item_regret = request.getParameterValues("item_regret");

            int j = 0;
            for (int i = 0; i < sr_no.length; i++) {
                j++;

                List serviceVendorTenderBidItem31 = serviceVendorTenderBidItem3Service.readItemVendorRefNo(refNo, username, file_name, sr_no[i]);

                if (serviceVendorTenderBidItem31.isEmpty()) {
                    ServiceVendorTenderBidItem3 serviceVendorTenderBidItem3 = new ServiceVendorTenderBidItem3();
                    serviceVendorTenderBidItem3.setTenderNo(refNo);
                    serviceVendorTenderBidItem3.setVendorCode(username);
                    serviceVendorTenderBidItem3.setFileName(file_name);
                    serviceVendorTenderBidItem3.setSrNo(sr_no[i]);
                    serviceVendorTenderBidItem3.setParticular(particular[i]);
                    serviceVendorTenderBidItem3.setScheduledAmount(scheduled_amount[i]);
                    serviceVendorTenderBidItem3.setPercent(percentage[i]);
                    serviceVendorTenderBidItem3.setPercentRate(percentage_amount[i]);
                    serviceVendorTenderBidItem3.setAmountTotal(net_rate[i]);
                    serviceVendorTenderBidItem3.setVendorRemark(vendor_remark[i]);
                    serviceVendorTenderBidItem3.setItemregret(item_regret[i]);
                    serviceVendorTenderBidItem3Service.create(serviceVendorTenderBidItem3);
                } else {
                    serviceVendorTenderBidItem3Service.updateItemVendorRefNo(refNo, username, file_name, sr_no[i], particular[i], scheduled_amount[i], percentage[i], percentage_amount[i], net_rate[i], vendor_remark[i], item_regret[i]);
                }

            }
        } else if (service_type.equals("Service4")) {
            String total_amount = "";

            List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);

            if (serviceVendorTenderBid.isEmpty()) {
                ServiceVendorTenderBid serviceVendorTenderBid1 = new ServiceVendorTenderBid();
                serviceVendorTenderBid1.setTenderNo(refNo);
                serviceVendorTenderBid1.setVendorCode(username);
                serviceVendorTenderBid1.setFileName(file_name);
                serviceVendorTenderBid1.setSelectCommon("");
                serviceVendorTenderBid1.setDiscountType("");
                serviceVendorTenderBid1.setDiscountValue("");
                serviceVendorTenderBid1.setPackingType("");
                serviceVendorTenderBid1.setPackingValue("");
                serviceVendorTenderBid1.setFreightType("");
                serviceVendorTenderBid1.setFreightValue("");
                serviceVendorTenderBid1.setErrectionValue("");
                serviceVendorTenderBid1.setChargesValue("");
                serviceVendorTenderBid1.setIgstValue("");
                serviceVendorTenderBid1.setCgstValue("");
                serviceVendorTenderBid1.setSgstValue("");
                serviceVendorTenderBid1.setInsuranceValue("");
                serviceVendorTenderBid1.setItemTotal(total_amount);
                serviceVendorTenderBid1.setGrandTotal(total_amount);
                serviceVendorTenderBidService.create(serviceVendorTenderBid1);
            } else {
                //   serviceVendorTenderBidService.updateVendorTenderBid(refNo,username,file_name,"","","","","","", "", "", "", "", "", "", "", total_amount, total_amount);
            }

            String[] security_name = request.getParameterValues("security_name");
            String[] security = request.getParameterValues("security");
            String[] wage = request.getParameterValues("wage");
            String[] per = request.getParameterValues("per");
            String[] total = request.getParameterValues("total");
            String[] allowance = request.getParameterValues("allowance");
            String[] allowance_total = request.getParameterValues("allowance_total");
            String[] uniform = request.getParameterValues("uniform");
            String[] service = request.getParameterValues("service");
            String[] total_per_day = request.getParameterValues("total_per_day");
            String[] total_per_month = request.getParameterValues("total_per_month");
            String[] total_per_year = request.getParameterValues("total_per_year");
            String[] total_per_day_pp = request.getParameterValues("total_per_day_pp");
            String[] per_day = request.getParameterValues("per_day");
            String[] per_month = request.getParameterValues("per_month");
            String[] per_year = request.getParameterValues("per_year");
            String[] total_per_day_per_pp = request.getParameterValues("total_per_day_per_pp");

            int j = 0;
            for (int i = 0; i < security_name.length; i++) {
                j++;

                List serviceVendorTenderBidItem41 = serviceVendorTenderBidItem4Service.readItemVendorRefNo(refNo, username, file_name, security_name[i]);

                if (serviceVendorTenderBidItem41.isEmpty()) {
                    ServiceVendorTenderBidItem4 serviceVendorTenderBidItem4 = new ServiceVendorTenderBidItem4();
                    serviceVendorTenderBidItem4.setTenderNo(refNo);
                    serviceVendorTenderBidItem4.setVendorCode(username);
                    serviceVendorTenderBidItem4.setFileName(file_name);
                    serviceVendorTenderBidItem4.setSecurityName(security_name[i]);
                    serviceVendorTenderBidItem4.setNoOfPerson(security[i]);
                    serviceVendorTenderBidItem4.setWages(wage[i]);
                    serviceVendorTenderBidItem4.setPercentage(per[i]);
                    serviceVendorTenderBidItem4.setPerTotal(total[i]);
                    serviceVendorTenderBidItem4.setAllowance(allowance[i]);
                    serviceVendorTenderBidItem4.setAllowanceTotal(allowance_total[i]);
                    serviceVendorTenderBidItem4.setuCharges(uniform[i]);
                    serviceVendorTenderBidItem4.setsCharges(service[i]);
                    serviceVendorTenderBidItem4.settPDPP(total_per_day[i]);
                    serviceVendorTenderBidItem4.settPMPP(total_per_month[i]);
                    serviceVendorTenderBidItem4.settPYPP(total_per_year[i]);
                    serviceVendorTenderBidItem4.settPD(per_day[i]);
                    serviceVendorTenderBidItem4.settPM(per_month[i]);
                    serviceVendorTenderBidItem4.settDY(per_year[i]);
                    serviceVendorTenderBidItem4.setPerDayPerPerson(total_per_day_pp[i]);
                    serviceVendorTenderBidItem4.setPerDayPerDay(total_per_day_per_pp[i]);
                    serviceVendorTenderBidItem4Service.create(serviceVendorTenderBidItem4);
                } else {
                    serviceVendorTenderBidItem4Service.updateItemVendorRefNo(refNo, username, file_name, security_name[i], security[i], wage[i], per[i], total[i], allowance[i], allowance_total[i], uniform[i], service[i], total_per_day[i], total_per_month[i], total_per_year[i], per_day[i], per_month[i], per_year[i], total_per_day_pp[i], total_per_day_per_pp[i]);
                }

            }

        } else if (service_type.equals("Service5")) {
            String common_tax = request.getParameter("common_tax");
            if (common_tax == null) {
                common_tax = "0";
            }
            String discount_val = request.getParameter("discount_val");
            String discount = request.getParameter("discount");
            String packing_val = request.getParameter("packing_val");
            String packing = request.getParameter("packing");
            String freight_val = request.getParameter("freight_val");
            String freight = request.getParameter("freight");
            String errection = request.getParameter("errection");
            String other_charges = request.getParameter("other_charges");
            String igst = request.getParameter("igst");
            String cgst = request.getParameter("cgst");
            String sgst = request.getParameter("sgst");
            String insurance_value = request.getParameter("insurance_value");
            String total_amount = request.getParameter("total_amount");
            String grand_total = request.getParameter("grand_total");

            List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);

            if (serviceVendorTenderBid.isEmpty()) {
                ServiceVendorTenderBid serviceVendorTenderBid1 = new ServiceVendorTenderBid();
                serviceVendorTenderBid1.setTenderNo(refNo);
                serviceVendorTenderBid1.setVendorCode(username);
                serviceVendorTenderBid1.setFileName(file_name);
                serviceVendorTenderBid1.setSelectCommon(common_tax);
                serviceVendorTenderBid1.setDiscountType(discount_val);
                serviceVendorTenderBid1.setDiscountValue(discount);
                serviceVendorTenderBid1.setPackingType(packing_val);
                serviceVendorTenderBid1.setPackingValue(packing);
                serviceVendorTenderBid1.setFreightType(freight_val);
                serviceVendorTenderBid1.setFreightValue(freight);
                serviceVendorTenderBid1.setErrectionValue(errection);
                serviceVendorTenderBid1.setChargesValue(other_charges);
                serviceVendorTenderBid1.setIgstValue(igst);
                serviceVendorTenderBid1.setCgstValue(cgst);
                serviceVendorTenderBid1.setSgstValue(sgst);
                serviceVendorTenderBid1.setInsuranceValue(insurance_value);
                serviceVendorTenderBid1.setItemTotal(total_amount);
                serviceVendorTenderBid1.setGrandTotal(grand_total);
                serviceVendorTenderBidService.create(serviceVendorTenderBid1);
            } else {
                serviceVendorTenderBidService.updateVendorTenderBid(refNo, username, file_name, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total);
            }

            //item details
            String[] sr_no = request.getParameterValues("sr_no");
            String[] item_description = request.getParameterValues("item_description");
            String[] item_remark = request.getParameterValues("item_remark");
            String[] uom = request.getParameterValues("uom");
            String[] qty = request.getParameterValues("qty");
            String[] attachment_required = request.getParameterValues("attachment_required");
            String[] unit_rate = request.getParameterValues("unit_rate");
            String[] net_rate = request.getParameterValues("net_rate");
            String[] hsn_no = request.getParameterValues("hsn_no");
            String[] vendor_remark = request.getParameterValues("vendor_remark");
            String[] item_discount_val = request.getParameterValues("item_discount_val");
            String[] item_discount = request.getParameterValues("item_discount");
            String[] item_packing_val = request.getParameterValues("item_packing_val");
            String[] item_packing = request.getParameterValues("item_packing");
            String[] item_freight_val = request.getParameterValues("item_freight_val");
            String[] item_freight = request.getParameterValues("item_freight");
            String[] item_errection = request.getParameterValues("item_errection");
            String[] item_other_charges = request.getParameterValues("item_other_charges");
            String[] item_igst = request.getParameterValues("item_igst");
            String[] item_cgst = request.getParameterValues("item_cgst");
            String[] item_sgst = request.getParameterValues("item_sgst");
            String[] item_insurance_value = request.getParameterValues("item_insurance_value");
            String[] item_total = request.getParameterValues("item_total");
            String[] item_regret = request.getParameterValues("item_regret");

            int j = 0;
            for (int i = 0; i < sr_no.length; i++) {
                j++;

                List serviceVendorTenderBidItem1 = serviceVendorTenderBidItemService.readItemVendorRefNo(refNo, username, file_name, sr_no[i]);

                if (serviceVendorTenderBidItem1.isEmpty()) {
                    ServiceVendorTenderBidItem serviceVendorTenderBidItem = new ServiceVendorTenderBidItem();
                    serviceVendorTenderBidItem.setTenderNo(refNo);
                    serviceVendorTenderBidItem.setVendorCode(username);
                    serviceVendorTenderBidItem.setFileName(file_name);
                    serviceVendorTenderBidItem.setSrNo(sr_no[i]);
                    serviceVendorTenderBidItem.setItemDesc(item_description[i]);
                    serviceVendorTenderBidItem.setRemark(item_remark[i]);
                    serviceVendorTenderBidItem.setUom(uom[i]);
                    serviceVendorTenderBidItem.setQuantity(qty[i]);
                    serviceVendorTenderBidItem.setRate(unit_rate[i]);
                    serviceVendorTenderBidItem.setNetRate(net_rate[i]);
                    serviceVendorTenderBidItem.setHsnNo(hsn_no[i]);
                    serviceVendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                    serviceVendorTenderBidItem.setDiscountType(item_discount_val[i]);
                    serviceVendorTenderBidItem.setDiscountValue(item_discount[i]);
                    serviceVendorTenderBidItem.setPackingType(item_packing_val[i]);
                    serviceVendorTenderBidItem.setPackingValue(item_packing[i]);
                    serviceVendorTenderBidItem.setFreightType(item_freight_val[i]);
                    serviceVendorTenderBidItem.setFreightValue(item_freight[i]);
                    serviceVendorTenderBidItem.setErrectionValue(item_errection[i]);
                    serviceVendorTenderBidItem.setChargesValue(item_other_charges[i]);
                    serviceVendorTenderBidItem.setIgstValue(item_igst[i]);
                    serviceVendorTenderBidItem.setCgstValue(item_cgst[i]);
                    serviceVendorTenderBidItem.setSgstValue(item_sgst[i]);
                    serviceVendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                    serviceVendorTenderBidItem.setTotalValue(item_total[i]);
                    serviceVendorTenderBidItem.setItemRegret(item_regret[i]);
                    serviceVendorTenderBidItemService.create(serviceVendorTenderBidItem);
                } else {
                    serviceVendorTenderBidItemService.updateItemVendorRefNo(refNo, username, file_name, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], unit_rate[i], net_rate[i], hsn_no[i], vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i]);

                }

            }

        } else if (service_type.equals("Service6")) {
            String total_amount = request.getParameter("total_amount");

            List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);

            if (serviceVendorTenderBid.isEmpty()) {
                ServiceVendorTenderBid serviceVendorTenderBid1 = new ServiceVendorTenderBid();
                serviceVendorTenderBid1.setTenderNo(refNo);
                serviceVendorTenderBid1.setVendorCode(username);
                serviceVendorTenderBid1.setFileName(file_name);
                serviceVendorTenderBid1.setSelectCommon("");
                serviceVendorTenderBid1.setDiscountType("");
                serviceVendorTenderBid1.setDiscountValue("");
                serviceVendorTenderBid1.setPackingType("");
                serviceVendorTenderBid1.setPackingValue("");
                serviceVendorTenderBid1.setFreightType("");
                serviceVendorTenderBid1.setFreightValue("");
                serviceVendorTenderBid1.setErrectionValue("");
                serviceVendorTenderBid1.setChargesValue("");
                serviceVendorTenderBid1.setIgstValue("");
                serviceVendorTenderBid1.setCgstValue("");
                serviceVendorTenderBid1.setSgstValue("");
                serviceVendorTenderBid1.setInsuranceValue("");
                serviceVendorTenderBid1.setItemTotal(total_amount);
                serviceVendorTenderBid1.setGrandTotal(total_amount);
                serviceVendorTenderBidService.create(serviceVendorTenderBid1);
            } else {
                serviceVendorTenderBidService.updateVendorTenderBid(refNo, username, file_name, "", "", "", "", "", "", "", "", "", "", "", "", "", total_amount, total_amount);
            }

            String[] sr_no = request.getParameterValues("sr_no");
            String[] pc_type = request.getParameterValues("pc_type");
            String[] item_description = request.getParameterValues("item_description");
            String[] uom = request.getParameterValues("uom");
            String[] qty = request.getParameterValues("qty");
            String[] amc_required_days = request.getParameterValues("amc_required_days");
            String[] rate = request.getParameterValues("rate");
            String[] net_rate = request.getParameterValues("net_rate");
            String[] vendor_remark = request.getParameterValues("vendor_remark");
            String[] item_regret = request.getParameterValues("item_regret");

            int j = 0;
            for (int i = 0; i < sr_no.length; i++) {
                j++;

                List serviceVendorTenderBidItem61 = serviceVendorTenderBidItem6Service.readItemVendorRefNo(refNo, username, file_name, sr_no[i]);

                if (serviceVendorTenderBidItem61.isEmpty()) {
                    ServiceVendorTenderBidItem6 serviceVendorTenderBidItem6 = new ServiceVendorTenderBidItem6();
                    serviceVendorTenderBidItem6.setTenderNo(refNo);
                    serviceVendorTenderBidItem6.setVendorCode(username);
                    serviceVendorTenderBidItem6.setFileName(file_name);
                    serviceVendorTenderBidItem6.setSrNo(sr_no[i]);
                    serviceVendorTenderBidItem6.setPcType(pc_type[i]);
                    serviceVendorTenderBidItem6.setItemDesc(item_description[i]);
                    serviceVendorTenderBidItem6.setUom(uom[i]);
                    serviceVendorTenderBidItem6.setQuantity(qty[i]);
                    serviceVendorTenderBidItem6.setAmcRequiredDays(amc_required_days[i]);
                    serviceVendorTenderBidItem6.setRate(rate[i]);
                    serviceVendorTenderBidItem6.setAmountTotal(net_rate[i]);
                    serviceVendorTenderBidItem6.setVendorRemark(vendor_remark[i]);
                    serviceVendorTenderBidItem6.setItemregret(item_regret[i]);
                    serviceVendorTenderBidItem6Service.create(serviceVendorTenderBidItem6);
                } else {
                    serviceVendorTenderBidItem6Service.updateItemVendorRefNo(refNo, username, file_name, sr_no[i], pc_type[i], item_description[i], uom[i], qty[i], amc_required_days[i], rate[i], net_rate[i], vendor_remark[i], item_regret[i]);
                }
            }
        }

        int file_no1 = Integer.parseInt(file_no);
        file_no1++;
        String service_type1 = "";

        List fileDetail = fileDetailService.readTenderNo(refNo);

        mv.getModelMap().put("fileDetail", fileDetail);

        file_name = "";
        String serviceDetail1 = "";
        String from_date = "";
        String to_date = "";
        String date_wise = "";
        int i = 0;
        for (Object o : fileDetail) {
            i++;
            if (i == file_no1) {
                FileDetail fd = (FileDetail) o;
                service_type1 = fd.getSerType();
                file_name = fd.getFileName();
                from_date = fd.getFromDate();
                to_date = fd.getToDate();
                date_wise = fd.getDateWise();

                String select_common = "";
                String discount_type = "";
                String discount_value = "";
                String packing_type = "";
                String packing_value = "";
                String freight_type = "";
                String freight_value = "";
                String errection_value = "";
                String charges_value = "";
                String igst_value = "";
                String cgst_value = "";
                String sgst_value = "";
                String insurance_value = "";
                String grand_total = "";
                String item_total = "";
                try {
                    List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);
                    mv.getModelMap().put("serviceVendorTenderBid", serviceVendorTenderBid);

                    for (Object o1 : serviceVendorTenderBid) {

                        ServiceVendorTenderBid svtb = (ServiceVendorTenderBid) o1;
                        select_common = svtb.getSelectCommon();
                        discount_type = svtb.getDiscountType();
                        discount_value = svtb.getDiscountValue();
                        packing_type = svtb.getPackingType();
                        packing_value = svtb.getPackingValue();
                        freight_type = svtb.getFreightType();
                        freight_value = svtb.getFreightValue();
                        errection_value = svtb.getErrectionValue();
                        charges_value = svtb.getChargesValue();
                        igst_value = svtb.getIgstValue();
                        cgst_value = svtb.getCgstValue();
                        sgst_value = svtb.getSgstValue();
                        insurance_value = svtb.getInsuranceValue();
                        grand_total = svtb.getGrandTotal();
                        item_total = svtb.getItemTotal();

                    }

                } catch (Exception e1) {
                }

                mv.getModelMap().put("select_common", select_common);
                mv.getModelMap().put("discount_type", discount_type);
                mv.getModelMap().put("discount_value", discount_value);
                mv.getModelMap().put("packing_type", packing_type);
                mv.getModelMap().put("packing_value", packing_value);
                mv.getModelMap().put("freight_type", freight_type);
                mv.getModelMap().put("freight_value", freight_value);
                mv.getModelMap().put("errection_value", errection_value);
                mv.getModelMap().put("charges_value", charges_value);
                mv.getModelMap().put("igst_value", igst_value);
                mv.getModelMap().put("cgst_value", cgst_value);
                mv.getModelMap().put("sgst_value", sgst_value);
                mv.getModelMap().put("insurance_value", insurance_value);
                mv.getModelMap().put("grand_total", grand_total);
                mv.getModelMap().put("item_total", item_total);

                if (service_type1.equals("Service1")) {
                    List serviceDetail = serviceDetail1Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem = serviceVendorTenderBidItemService.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem", serviceVendorTenderBidItem);
                    } catch (Exception e1) {
                    }
                } else if (service_type1.equals("Service2")) {
                    List serviceDetail = serviceDetail2Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem2 = serviceVendorTenderBidItem2Service.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem2", serviceVendorTenderBidItem2);
                    } catch (Exception e1) {
                    }

                } else if (service_type1.equals("Service3")) {
                    List serviceDetail = serviceDetail3Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem3 = serviceVendorTenderBidItem3Service.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem3", serviceVendorTenderBidItem3);
                    } catch (Exception e1) {
                    }
                } else if (service_type1.equals("Service4")) {
                    long difference_In_Days = 0;
                    if (date_wise.equals("date_service4")) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date d1 = sdf.parse(from_date);
                            Date d2 = sdf.parse(to_date);

                            long difference_In_Time = d2.getTime() - d1.getTime();
                            difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

                        } catch (Exception e1) {
                        }

                    }

                    mv.getModelMap().put("from_date", from_date);
                    mv.getModelMap().put("to_date", to_date);
                    mv.getModelMap().put("diff_days", difference_In_Days);

                    List serviceDetail = serviceDetail4Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem4 = serviceVendorTenderBidItem4Service.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem4", serviceVendorTenderBidItem4);
                    } catch (Exception e1) {
                    }
                } else if (service_type1.equals("Service5")) {
                    List serviceDetail = serviceDetail5Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem = serviceVendorTenderBidItemService.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem", serviceVendorTenderBidItem);
                    } catch (Exception e1) {
                    }
                } else if (service_type1.equals("Service6")) {
                    List serviceDetail = serviceDetail6Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem6 = serviceVendorTenderBidItem6Service.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem6", serviceVendorTenderBidItem6);
                    } catch (Exception e1) {
                    }
                }

                mv.getModelMap().put("file_no", i);
                mv.getModelMap().put("refNo", refNo);
                mv.getModelMap().put("file_name", file_name);
                mv.getModelMap().put("tenderMaster", tenderMaster);

                VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);
                int rivision = vendorTenderBid11.getRevision();

                mv.getModelMap().put("rivision", rivision);

                mv.setViewName("Vendor/BidTenderForFinancialServiceManual");
                return mv;

            }
        }

        //-----------------------------------------
        //item details
        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //get pre qualiication details
        VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
        String preBidDeviation = vendorPreBid.getPreBidDeviation();
        String preBidRemark = vendorPreBid.getPreBidRemark();

        //vendor tender bid
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        int rivision = vendorTenderBid.getRevision();
        String delivery_location = vendorTenderBid.getDeliveryLocation();
        String delivery_period = vendorTenderBid.getDeliveryPeriod();
        String terms_of_payment = vendorTenderBid.getTermsOfPayment();
        String validity_period = vendorTenderBid.getValidityPeriod();
        String mode_of_transport = vendorTenderBid.getModeOfTransport();
        String inco_terms = vendorTenderBid.getIncoTerms();
        String insurance1 = vendorTenderBid.getInsurance();
        String freight1 = vendorTenderBid.getFreight();
        String grand_total1 = vendorTenderBid.getGrandTotal();
        String grand_total_word1 = vendorTenderBid.getGrandTotalWord();
        String remark_by_vendor = vendorTenderBid.getRemarkByVendor();

        //service manual tender
        TenderMaster tenderMaster1 = tenderMasterService.readRefNo(refNo);

        String tender_type = tenderMaster1.getTenderType();

        double total = 0.0;
        if (tender_type.equals("Service Manually")) {
            List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo2(username, refNo);
            for (Object o : serviceVendorTenderBid) {

                ServiceVendorTenderBid svtb = (ServiceVendorTenderBid) o;
                try {
                    total = total + Double.parseDouble(svtb.getGrandTotal());
                } catch (Exception e11) {
                }
            }
            grand_total1 = total + "";
            grand_total_word1 = "";
        }

        mv.getModelMap().put("rivision", rivision);
        mv.getModelMap().put("type", "Service");
        mv.getModelMap().put("delivery_location", delivery_location);
        mv.getModelMap().put("delivery_period", delivery_period);
        mv.getModelMap().put("terms_of_payment", terms_of_payment);
        mv.getModelMap().put("validity_period", validity_period);
        mv.getModelMap().put("mode_of_transport", mode_of_transport);
        mv.getModelMap().put("inco_terms", inco_terms);
        mv.getModelMap().put("insurance1", insurance1);
        mv.getModelMap().put("freight1", freight1);
        mv.getModelMap().put("grand_total1", grand_total1);
        mv.getModelMap().put("grand_total_word1", grand_total_word1);
        mv.getModelMap().put("remark_by_vendor", remark_by_vendor);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);
        mv.getModelMap().put("preBidDeviation", preBidDeviation);
        mv.getModelMap().put("preBidRemark", preBidRemark);

        mv.setViewName("Vendor/BidTenderForCondition");
        return mv;
    }

    public ModelAndView bidTenderForTwoPartFinancial(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        String tender_type = tenderMaster.getTenderType();
        if (tender_type == null) {
            tender_type = "";
        }

        //get item details
        List tenderItemMaster = tenderItemMasterService.readByRefNo(refNo);
        List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNo(refNo, username);

        //vendor tender bid
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        int rivision = vendorTenderBid.getRevision();
        String discount_type = vendorTenderBid.getDiscountType();
        String discount_value = vendorTenderBid.getDiscountValue();
        String packing_type = vendorTenderBid.getPackingType();
        String packing_value = vendorTenderBid.getPackingValue();
        String freight_type = vendorTenderBid.getFreightType();
        String freight_value = vendorTenderBid.getFreightValue();
        String errection_value = vendorTenderBid.getErrectionValue();
        String charges_value = vendorTenderBid.getChargesValue();
        String igst_value = vendorTenderBid.getIgstValue();
        String cgst_value = vendorTenderBid.getCgstValue();
        String sgst_value = vendorTenderBid.getSgstValue();
        String insurance_value = vendorTenderBid.getInsuranceValue();
        String item_total = vendorTenderBid.getItemTotal();
        String grand_total = vendorTenderBid.getGrandTotal();
        String grand_total_word = vendorTenderBid.getGrandTotalWord();
        String select_common = vendorTenderBid.getSelectCommon();

        mv.getModelMap().put("rivision", rivision);
        mv.getModelMap().put("discount_type", discount_type);
        mv.getModelMap().put("discount_value", discount_value);
        mv.getModelMap().put("packing_type", packing_type);
        mv.getModelMap().put("packing_value", packing_value);
        mv.getModelMap().put("freight_type", freight_type);
        mv.getModelMap().put("freight_value", freight_value);
        mv.getModelMap().put("errection_value", errection_value);
        mv.getModelMap().put("charges_value", charges_value);
        mv.getModelMap().put("igst_value", igst_value);
        mv.getModelMap().put("cgst_value", cgst_value);
        mv.getModelMap().put("sgst_value", sgst_value);
        mv.getModelMap().put("insurance_value", insurance_value);
        mv.getModelMap().put("item_total", item_total);
        mv.getModelMap().put("grand_total", grand_total);
        mv.getModelMap().put("grand_total_word", grand_total_word);
        mv.getModelMap().put("select_common", select_common);

        //get pre qualiication details
        VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
        String preBidDeviation = vendorPreBid.getPreBidDeviation();
        String preBidRemark = vendorPreBid.getPreBidRemark();

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);

        mv.setViewName("Vendor/BidTenderForTwoPartFinancial");
        return mv;

    }

    public ModelAndView bidTenderForTwoPartFinancialSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        //-----------------------------------------
        String common_tax = request.getParameter("common_tax");
        if (common_tax == null) {
            common_tax = "0";
        }
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value = request.getParameter("insurance_value");
        String total_amount = request.getParameter("total_amount");
        String grand_total = request.getParameter("grand_total");
        String venodr_total_words = request.getParameter("venodr_total_words");

        vendorTenderBidService.updateVendorItem(refNo, username, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total, venodr_total_words);

        //item details
        String[] item_code = request.getParameterValues("item_code");
        String[] item_description = request.getParameterValues("item_description");
        String[] item_remark = request.getParameterValues("item_remark");
        String[] uom = request.getParameterValues("uom");
        String[] qty = request.getParameterValues("qty");
        String[] attachment_required = request.getParameterValues("attachment_required");
        String[] delivery_schedule_date = request.getParameterValues("delivery_schedule_date");
        String[] delivery_schedule_qty = request.getParameterValues("delivery_schedule_qty");
        String[] item_location = request.getParameterValues("item_location");
        String[] pur_no = request.getParameterValues("pur_no");
        String[] item_no = request.getParameterValues("item_no");
        String[] sr_no = request.getParameterValues("sr_no");
        String[] pr_no = request.getParameterValues("pr_no");
        String[] unit_rate = request.getParameterValues("unit_rate");
        String[] net_rate = request.getParameterValues("net_rate");
        String[] hsn_no = request.getParameterValues("hsn_no");
        String[] vendor_remark = request.getParameterValues("vendor_remark");
        String[] item_discount_val = request.getParameterValues("item_discount_val");
        String[] item_discount = request.getParameterValues("item_discount");
        String[] item_packing_val = request.getParameterValues("item_packing_val");
        String[] item_packing = request.getParameterValues("item_packing");
        String[] item_freight_val = request.getParameterValues("item_freight_val");
        String[] item_freight = request.getParameterValues("item_freight");
        String[] item_errection = request.getParameterValues("item_errection");
        String[] item_other_charges = request.getParameterValues("item_other_charges");
        String[] item_igst = request.getParameterValues("item_igst");
        String[] item_cgst = request.getParameterValues("item_cgst");
        String[] item_sgst = request.getParameterValues("item_sgst");
        String[] item_insurance_value = request.getParameterValues("item_insurance_value");
        String[] item_total = request.getParameterValues("item_total");
        String[] item_regret = request.getParameterValues("item_regret");
        String[] accountAssigmentCategory = request.getParameterValues("accountAssigmentCategory");
        String[] accountAssigmentValue = request.getParameterValues("accountAssigmentValue");
        String[] productType = request.getParameterValues("productType");
        String[] productGroup = request.getParameterValues("productGroup");
        String[] taxCode = request.getParameterValues("taxCode");
        String[] valuationPrice = request.getParameterValues("valuationPrice");
        String[] deliveryDate = request.getParameterValues("deliveryDate");
        String[] startDate = request.getParameterValues("startDate");
        String[] endDate = request.getParameterValues("endDate");

        int j = 0;
        for (int i = 0; i < item_code.length; i++) {
            j++;

            List vendorTenderBidItem1 = vendorTenderBidItemService.readItemVendorRefNo(refNo, username, sr_no[i], 0);

            if (vendorTenderBidItem1.isEmpty()) {
                VendorTenderBidItem vendorTenderBidItem = new VendorTenderBidItem();
                vendorTenderBidItem.setRefNo(refNo);
                vendorTenderBidItem.setVendorCode(username);
                vendorTenderBidItem.setItemCode(item_code[i]);
                vendorTenderBidItem.setItemDescription(item_description[i]);
                vendorTenderBidItem.setRemark(item_remark[i]);
                vendorTenderBidItem.setUom(uom[i]);
                vendorTenderBidItem.setQty(qty[i]);
                vendorTenderBidItem.setAttachmentRequired(attachment_required[i]);
                vendorTenderBidItem.setDeliveryScheduleDate(delivery_schedule_date[i]);
                vendorTenderBidItem.setDeliveryScheduleQty(delivery_schedule_qty[i]);
                vendorTenderBidItem.setLocation(item_location[i]);
                vendorTenderBidItem.setPurNo(pur_no[i]);
                vendorTenderBidItem.setItemNo(item_no[i]);
                vendorTenderBidItem.setSrNo(sr_no[i]);
                vendorTenderBidItem.setPrNo(pr_no[i]);
                vendorTenderBidItem.setRate(unit_rate[i]);
                vendorTenderBidItem.setNetRate(net_rate[i]);
                vendorTenderBidItem.setHsnNo(hsn_no[i]);
                vendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                vendorTenderBidItem.setDiscountType(item_discount_val[i]);
                vendorTenderBidItem.setDiscountValue(item_discount[i]);
                vendorTenderBidItem.setPackingType(item_packing_val[i]);
                vendorTenderBidItem.setPackingValue(item_packing[i]);
                vendorTenderBidItem.setFreightType(item_freight_val[i]);
                vendorTenderBidItem.setFreightValue(item_freight[i]);
                vendorTenderBidItem.setErrectionValue(item_errection[i]);
                vendorTenderBidItem.setChargesValue(item_other_charges[i]);
                vendorTenderBidItem.setIgstValue(item_igst[i]);
                vendorTenderBidItem.setCgstValue(item_cgst[i]);
                vendorTenderBidItem.setSgstValue(item_sgst[i]);
                vendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                vendorTenderBidItem.setTotalValue(item_total[i]);
                vendorTenderBidItem.setItemRegret(item_regret[i]);

                vendorTenderBidItemService.create(vendorTenderBidItem);
            } else {
                vendorTenderBidItemService.updateItemVendorRefNo(refNo, username, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], attachment_required[i], delivery_schedule_date[i], delivery_schedule_qty[i], item_location[i], pur_no[i], item_no[i], unit_rate[i], net_rate[i], hsn_no[i], vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i]);

            }

        }

        request.setAttribute("successMessage",
                "Information: Bid Submited successfully");

        mv.setViewName("forward:vendor.htm?act=liveTender");
        return mv;
    }

    public ModelAndView venderTenderItemDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        //-----------------------------------------
        String common_tax = "0";
        String discount_val = request.getParameter("discount_val");
        if (discount_val == null) {
            discount_val = "0";
        }
        String discount = request.getParameter("discount");
        if (discount == null) {
            discount = "0";
        }
        if (discount.equals("")) {
            discount = "0";
        }
        String packing_val = request.getParameter("packing_val");
        if (packing_val == null) {
            packing_val = "0";
        }
        String packing = request.getParameter("packing");
        if (packing == null) {
            packing = "0";
        }
        if (packing.equals("")) {
            packing = "0";
        }
        String freight_val = request.getParameter("freight_val");
        if (freight_val == null) {
            freight_val = "0";
        }
        String freight = request.getParameter("freight");
        if (freight == null) {
            freight = "0";
        }
        if (freight.equals("")) {
            freight = "0";
        }
        String errection = request.getParameter("errection");
        if (errection == null) {
            errection = "0";
        }
        if (errection.equals("")) {
            errection = "0";
        }
        String other_charges = request.getParameter("other_charges");
        if (other_charges == null) {
            other_charges = "0";
        }
        if (other_charges.equals("")) {
            other_charges = "0";
        }
        String igst = request.getParameter("igst");
        if (igst == null) {
            igst = "0";
        }
        if (igst.equals("")) {
            igst = "0";
        }
        String cgst = request.getParameter("cgst");
        if (cgst == null) {
            cgst = "0";
        }
        if (cgst.equals("")) {
            cgst = "0";
        }
        String sgst = request.getParameter("sgst");
        if (sgst == null) {
            sgst = "0";
        }
        if (sgst.equals("")) {
            sgst = "0";
        }
        String insurance_value = request.getParameter("insurance_value");
        if (insurance_value == null) {
            insurance_value = "0";
        }
        if (insurance_value.equals("")) {
            insurance_value = "0";
        }
        String total_amount = request.getParameter("total_amount");
        String grand_total = request.getParameter("grand_total");
        String venodr_total_words = request.getParameter("venodr_total_words");

        vendorTenderBidService.updateVendorItem(refNo, username, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total, venodr_total_words);

        //item details
        String[] item_code = request.getParameterValues("item_code");
        String[] item_description = request.getParameterValues("item_description");
        String[] item_remark = request.getParameterValues("item_remark");
        String[] uom = request.getParameterValues("uom");
        String[] qty = request.getParameterValues("qty");
        String[] attachment_required = request.getParameterValues("attachment_required");
        String[] delivery_schedule_date = request.getParameterValues("delivery_schedule_date");
        String[] delivery_schedule_qty = request.getParameterValues("delivery_schedule_qty");
        String[] item_location = request.getParameterValues("item_location");
        String[] pur_no = request.getParameterValues("pur_no");
        String[] item_no = request.getParameterValues("item_no");
        String[] sr_no = request.getParameterValues("sr_no");
        String[] pr_no = request.getParameterValues("pr_no");
        String[] unit_rate = request.getParameterValues("unit_rate");
        String[] net_rate = request.getParameterValues("net_rate");
        String[] hsn_no = request.getParameterValues("hsn_no");
        String[] vendor_remark = request.getParameterValues("vendor_remark");
        String[] item_discount_val = request.getParameterValues("item_discount_val");
        String[] item_discount = request.getParameterValues("item_discount");
        String[] item_packing_val = request.getParameterValues("item_packing_val");
        String[] item_packing = request.getParameterValues("item_packing");
        String[] item_freight_val = request.getParameterValues("item_freight_val");
        String[] item_freight = request.getParameterValues("item_freight");
        String[] item_errection = request.getParameterValues("item_errection");
        String[] item_other_charges = request.getParameterValues("item_other_charges");
        String[] item_igst = request.getParameterValues("item_igst");
        String[] item_cgst = request.getParameterValues("item_cgst");
        String[] item_sgst = request.getParameterValues("item_sgst");
        String[] item_insurance_value = request.getParameterValues("item_insurance_value");
        String[] item_total = request.getParameterValues("item_total");
        String[] item_regret = request.getParameterValues("item_regret");

        int j = 0;
        for (int i = 0; i < item_code.length; i++) {
            j++;

            List vendorTenderBidItem1 = vendorTenderBidItemService.readItemVendorRefNo(refNo, username, sr_no[i], 0);

            if (vendorTenderBidItem1.isEmpty()) {
                VendorTenderBidItem vendorTenderBidItem = new VendorTenderBidItem();
                vendorTenderBidItem.setRefNo(refNo);
                vendorTenderBidItem.setVendorCode(username);
                vendorTenderBidItem.setItemCode(item_code[i]);
                vendorTenderBidItem.setItemDescription(item_description[i]);
                vendorTenderBidItem.setRemark(item_remark[i]);
                vendorTenderBidItem.setUom(uom[i]);
                vendorTenderBidItem.setQty(qty[i]);
                vendorTenderBidItem.setAttachmentRequired(attachment_required[i]);
                vendorTenderBidItem.setDeliveryScheduleDate(delivery_schedule_date[i]);
                vendorTenderBidItem.setDeliveryScheduleQty(delivery_schedule_qty[i]);
                vendorTenderBidItem.setLocation(item_location[i]);
                vendorTenderBidItem.setPurNo(pur_no[i]);
                vendorTenderBidItem.setItemNo(item_no[i]);
                vendorTenderBidItem.setSrNo(sr_no[i]);
                vendorTenderBidItem.setPrNo(pr_no[i]);
                if (unit_rate[i].equals("")) {
                    unit_rate[i] = "0";
                }
                vendorTenderBidItem.setRate(unit_rate[i]);
                vendorTenderBidItem.setNetRate(net_rate[i]);
                //    vendorTenderBidItem.setHsnNo(hsn_no[i]);
                vendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                vendorTenderBidItem.setDiscountType(item_discount_val[i]);
                vendorTenderBidItem.setDiscountValue(item_discount[i]);
                vendorTenderBidItem.setPackingType(item_packing_val[i]);
                vendorTenderBidItem.setPackingValue(item_packing[i]);
                vendorTenderBidItem.setFreightType(item_freight_val[i]);
                vendorTenderBidItem.setFreightValue(item_freight[i]);
                vendorTenderBidItem.setErrectionValue(item_errection[i]);
                vendorTenderBidItem.setChargesValue(item_other_charges[i]);
                vendorTenderBidItem.setIgstValue(item_igst[i]);
                vendorTenderBidItem.setCgstValue(item_cgst[i]);
                vendorTenderBidItem.setSgstValue(item_sgst[i]);
                vendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                vendorTenderBidItem.setTotalValue(net_rate[i]);
                vendorTenderBidItem.setItemRegret(item_regret[i]);
                vendorTenderBidItemService.create(vendorTenderBidItem);
            } else {
                vendorTenderBidItemService.updateItemVendorRefNo(refNo, username, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], attachment_required[i], delivery_schedule_date[i], delivery_schedule_qty[i], item_location[i], pur_no[i], item_no[i], unit_rate[i], net_rate[i], "", vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i]);

            }

        }

        //get item details
        List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNo(refNo, username);
        String item_code1 = "";
        String sr_no2 = "";
        int i = 0;
        for (Object o : vendorTenderBidItem) {
            i++;
            if (i == Integer.parseInt(id)) {
                VendorTenderBidItem tm = (VendorTenderBidItem) o;
                item_code1 = tm.getItemCode();
                sr_no2 = tm.getSrNo();
            }
        }

        //vendor tender bid
        VendorTenderBidItem vendorTenderBidItem1 = vendorTenderBidItemService.readByVendorRefNo(refNo, username, sr_no2);
        String item_description1 = vendorTenderBidItem1.getItemDescription();
        String remark1 = vendorTenderBidItem1.getRemark();
        String uom1 = vendorTenderBidItem1.getUom();
        String qty1 = vendorTenderBidItem1.getQty();
        String rate1 = vendorTenderBidItem1.getRate();
        String netrate1 = vendorTenderBidItem1.getNetRate();
        String discount_val1 = vendorTenderBidItem1.getDiscountType();
        String discount1 = vendorTenderBidItem1.getDiscountValue();
        String packing_val1 = vendorTenderBidItem1.getPackingType();
        String packing1 = vendorTenderBidItem1.getPackingValue();
        String freight_val1 = vendorTenderBidItem1.getFreightType();
        String freight1 = vendorTenderBidItem1.getFreightValue();
        String errection1 = vendorTenderBidItem1.getErrectionValue();
        String other_charges1 = vendorTenderBidItem1.getChargesValue();
        String igst1 = vendorTenderBidItem1.getIgstValue();
        String cgst1 = vendorTenderBidItem1.getCgstValue();
        String sgst1 = vendorTenderBidItem1.getSgstValue();
        String insurance_value1 = vendorTenderBidItem1.getInsuranceValue();
        String total_amount1 = vendorTenderBidItem1.getTotalValue();
        String sr_no1 = vendorTenderBidItem1.getSrNo();

        mv.getModelMap().put("item_description1", item_description1);
        mv.getModelMap().put("item_code1", item_code1);
        mv.getModelMap().put("sr_no1", sr_no1);
        mv.getModelMap().put("remark1", remark1);
        mv.getModelMap().put("uom1", uom1);
        mv.getModelMap().put("qty1", qty1);
        mv.getModelMap().put("rate1", rate1);
        mv.getModelMap().put("netrate1", netrate1);
        mv.getModelMap().put("discount_val1", discount_val1);
        mv.getModelMap().put("discount1", discount1);
        mv.getModelMap().put("packing_val1", packing_val1);
        mv.getModelMap().put("packing1", packing1);
        mv.getModelMap().put("freight_val1", freight_val1);
        mv.getModelMap().put("freight1", freight1);
        mv.getModelMap().put("errection1", errection1);
        mv.getModelMap().put("other_charges1", other_charges1);
        mv.getModelMap().put("igst1", igst1);
        mv.getModelMap().put("cgst1", cgst1);
        mv.getModelMap().put("sgst1", sgst1);
        mv.getModelMap().put("insurance_value1", insurance_value1);
        mv.getModelMap().put("total_amount1", total_amount1);

        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        List list1 = tenderMasterService.vendorLiveTender(username);

        VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);
        int rivision = vendorTenderBid11.getRevision();

        mv.getModelMap().put("rivision", rivision);

        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);

        mv.setViewName("Vendor/VenderTenderItemDetail");
        return mv;
    }

    public ModelAndView venderTenderItemDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();

        String item_code = request.getParameter("item_code");
        String sr_no = request.getParameter("sr_no");
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value1 = request.getParameter("insurance_value");
        String grand_total1 = request.getParameter("grand_total");

        vendorTenderBidItemService.updateItem(refNo, username, sr_no, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value1, grand_total1);

        // calculation part ----------------
        List vendorTenderBidItem1 = vendorTenderBidItemService.readByVendorRefNo(refNo, username);

        Double discountValueFinal = 0.0;
        Double packingValueFinal = 0.0;
        Double freightValueFinal = 0.0;
        Double errectionValueFinal = 0.0;
        Double chargesValueFinal = 0.0;
        Double igstValueFinal = 0.0;
        Double cgstValueFinal = 0.0;
        Double sgstValueFinal = 0.0;
        Double insuranceValueFinal = 0.0;
        Double grandTotalFinal = 0.0;
        Double Total = 0.0;

        for (Object o : vendorTenderBidItem1) {
            VendorTenderBidItem vtbi = (VendorTenderBidItem) o;

            int itemId = vtbi.getId();
            String itemCode = vtbi.getItemCode();
            String itemDesciption = vtbi.getItemDescription();
            String remark = vtbi.getRemark();
            String uom = vtbi.getUom();
            String qty = vtbi.getQty();
            String purNo = vtbi.getPurNo();
            String itemNo = vtbi.getItemNo();
            String rate = vtbi.getRate();
            String hsnNo = vtbi.getHsnNo();
            String vendorRemark = vtbi.getVendorRemark();
            String itemRegret = vtbi.getItemRegret();

            String individualNetTotal = vtbi.getNetRate();
            String individualDiscountType = vtbi.getDiscountType();
            String individualDiscountValue = vtbi.getDiscountValue();
            String individualPackingType = vtbi.getPackingType();
            String individualPackingValue = vtbi.getPackingValue();
            String individualFreightType = vtbi.getFreightType();
            String individualFreightValue = vtbi.getFreightValue();
            String individualErrectionValue = vtbi.getErrectionValue();
            String individualChargesValue = vtbi.getChargesValue();
            String individualIgstValue = vtbi.getIgstValue();
            String individualCgstValue = vtbi.getCgstValue();
            String individualSgstValue = vtbi.getSgstValue();
            String individualInsuranceValue = vtbi.getInsuranceValue();
            String individualgrandTotal = vtbi.getTotalValue();

            Double individualItemTotalFinal = Double.parseDouble(individualNetTotal);
            Double individualDiscountValueFinal = 0.0;
            Double individualPackingValueFinal = 0.0;
            Double individualFreightValueFinal = 0.0;
            Double individualErrectionValueFinal = 0.0;
            Double individualChargesValueFinal = 0.0;
            Double individualIgstValueFinal = 0.0;
            Double individualCgstValueFinal = 0.0;
            Double individualSgstValueFinal = 0.0;
            Double individualInsuranceValueFinal = 0.0;
            Double individualGrandTotalFinal = 0.0;

            Total = Total + individualItemTotalFinal;

            if (individualDiscountType.equals("0")) {
                individualDiscountValueFinal = Double.parseDouble(individualDiscountValue) * individualItemTotalFinal / 100;
            } else {
                individualDiscountValueFinal = Double.parseDouble(individualDiscountValue);
            }
            long tmp = Math.round(individualDiscountValueFinal * 100);
            individualDiscountValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualItemTotalFinal - individualDiscountValueFinal;
            discountValueFinal = discountValueFinal + individualDiscountValueFinal;

            if (individualPackingType.equals("0")) {
                individualPackingValueFinal = Double.parseDouble(individualPackingValue) * individualGrandTotalFinal / 100;
            } else {
                individualPackingValueFinal = Double.parseDouble(individualPackingValue);
            }
            tmp = Math.round(individualPackingValueFinal * 100);
            individualPackingValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualGrandTotalFinal + individualPackingValueFinal;
            packingValueFinal = packingValueFinal + individualPackingValueFinal;

            if (individualFreightType.equals("0")) {
                individualFreightValueFinal = Double.parseDouble(individualFreightValue) * individualGrandTotalFinal / 100;
            } else {
                individualFreightValueFinal = Double.parseDouble(individualFreightValue);
            }
            tmp = Math.round(individualFreightValueFinal * 100);
            individualFreightValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualGrandTotalFinal + individualFreightValueFinal;
            freightValueFinal = freightValueFinal + individualFreightValueFinal;

            individualErrectionValueFinal = Double.parseDouble(individualErrectionValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualErrectionValueFinal * 100);
            individualErrectionValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualGrandTotalFinal + individualErrectionValueFinal;
            errectionValueFinal = errectionValueFinal + individualErrectionValueFinal;

            individualChargesValueFinal = Double.parseDouble(individualChargesValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualChargesValueFinal * 100);
            individualChargesValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualGrandTotalFinal + individualChargesValueFinal;
            chargesValueFinal = chargesValueFinal + individualChargesValueFinal;

            individualIgstValueFinal = Double.parseDouble(individualIgstValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualIgstValueFinal * 100);
            individualIgstValueFinal = (double) tmp / 100;
            igstValueFinal = igstValueFinal + individualIgstValueFinal;

            individualCgstValueFinal = Double.parseDouble(individualCgstValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualCgstValueFinal * 100);
            individualCgstValueFinal = (double) tmp / 100;
            cgstValueFinal = cgstValueFinal + individualCgstValueFinal;

            individualSgstValueFinal = Double.parseDouble(individualSgstValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualSgstValueFinal * 100);
            individualSgstValueFinal = (double) tmp / 100;
            sgstValueFinal = sgstValueFinal + individualSgstValueFinal;

            individualGrandTotalFinal = individualGrandTotalFinal + individualIgstValueFinal + individualCgstValueFinal + individualSgstValueFinal;

            individualInsuranceValueFinal = Double.parseDouble(individualInsuranceValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualInsuranceValueFinal * 100);
            individualInsuranceValueFinal = (double) tmp / 100;
            insuranceValueFinal = insuranceValueFinal + individualInsuranceValueFinal;
            individualGrandTotalFinal = individualGrandTotalFinal + individualInsuranceValueFinal;

            grandTotalFinal = grandTotalFinal + individualGrandTotalFinal;
        }

        double tmp = Math.round(grandTotalFinal * 100);
        grandTotalFinal = (double) tmp / 100;

        tmp = Math.round(Total * 100);
        Total = (double) tmp / 100;

        VendorTenderBid vendorTenderBid1 = vendorTenderBidService.readByVendorRefNo(refNo, username);
        vendorTenderBid1.setItemTotal(Total + "");
        vendorTenderBid1.setGrandTotal(grandTotalFinal + "");
        vendorTenderBid1.setFinalTotal(grandTotalFinal + "");
        vendorTenderBidService.update(vendorTenderBid1);
        // ---------------------------------

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        //get item details
        List tenderItemMaster = tenderItemMasterService.readByRefNo(refNo);
        List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNo(refNo, username);

        //vendor tender bid
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        int rivision = vendorTenderBid.getRevision();
        String discount_type = vendorTenderBid.getDiscountType();
        String discount_value = vendorTenderBid.getDiscountValue();
        String packing_type = vendorTenderBid.getPackingType();
        String packing_value = vendorTenderBid.getPackingValue();
        String freight_type = vendorTenderBid.getFreightType();
        String freight_value = vendorTenderBid.getFreightValue();
        String errection_value = vendorTenderBid.getErrectionValue();
        String charges_value = vendorTenderBid.getChargesValue();
        String igst_value = vendorTenderBid.getIgstValue();
        String cgst_value = vendorTenderBid.getCgstValue();
        String sgst_value = vendorTenderBid.getSgstValue();
        String insurance_value = vendorTenderBid.getInsuranceValue();
        String item_total = vendorTenderBid.getItemTotal();
        String grand_total = vendorTenderBid.getGrandTotal();
        String grand_total_word = vendorTenderBid.getGrandTotalWord();
        String select_common = vendorTenderBid.getSelectCommon();

        mv.getModelMap().put("rivision", rivision);
        mv.getModelMap().put("discount_type", discount_type);
        mv.getModelMap().put("discount_value", discount_value);
        mv.getModelMap().put("packing_type", packing_type);
        mv.getModelMap().put("packing_value", packing_value);
        mv.getModelMap().put("freight_type", freight_type);
        mv.getModelMap().put("freight_value", freight_value);
        mv.getModelMap().put("errection_value", errection_value);
        mv.getModelMap().put("charges_value", charges_value);
        mv.getModelMap().put("igst_value", igst_value);
        mv.getModelMap().put("cgst_value", cgst_value);
        mv.getModelMap().put("sgst_value", sgst_value);
        mv.getModelMap().put("insurance_value", insurance_value);
        mv.getModelMap().put("item_total", item_total);
        mv.getModelMap().put("grand_total", grand_total);
        mv.getModelMap().put("grand_total_word", grand_total_word);
        mv.getModelMap().put("select_common", select_common);

        //get pre qualiication details
        VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
        String preBidDeviation = vendorPreBid.getPreBidDeviation();
        String preBidRemark = vendorPreBid.getPreBidRemark();

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);

        mv.setViewName("Vendor/BidTenderForFinancial");
        return mv;
    }

    public ModelAndView venderTenderService1ItemDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String id = request.getParameter("id");
        String srNo = request.getParameter("srNo");
        String file_no = request.getParameter("file_no");
        String service_type = request.getParameter("service_type");
        String file_name = request.getParameter("file_name");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        //-------------------------
        String common_tax = request.getParameter("common_tax");
        if (common_tax == null) {
            common_tax = "0";
        }
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value = request.getParameter("insurance_value");
        String total_amount = request.getParameter("total_amount");
        String grand_total = request.getParameter("grand_total");

        List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);

        if (serviceVendorTenderBid.isEmpty()) {
            ServiceVendorTenderBid serviceVendorTenderBid1 = new ServiceVendorTenderBid();
            serviceVendorTenderBid1.setTenderNo(refNo);
            serviceVendorTenderBid1.setVendorCode(username);
            serviceVendorTenderBid1.setFileName(file_name);
            serviceVendorTenderBid1.setSelectCommon(common_tax);
            serviceVendorTenderBid1.setDiscountType(discount_val);
            serviceVendorTenderBid1.setDiscountValue(discount);
            serviceVendorTenderBid1.setPackingType(packing_val);
            serviceVendorTenderBid1.setPackingValue(packing);
            serviceVendorTenderBid1.setFreightType(freight_val);
            serviceVendorTenderBid1.setFreightValue(freight);
            serviceVendorTenderBid1.setErrectionValue(errection);
            serviceVendorTenderBid1.setChargesValue(other_charges);
            serviceVendorTenderBid1.setIgstValue(igst);
            serviceVendorTenderBid1.setCgstValue(cgst);
            serviceVendorTenderBid1.setSgstValue(sgst);
            serviceVendorTenderBid1.setInsuranceValue(insurance_value);
            serviceVendorTenderBid1.setItemTotal(total_amount);
            serviceVendorTenderBid1.setGrandTotal(grand_total);
            serviceVendorTenderBidService.create(serviceVendorTenderBid1);
        } else {
            serviceVendorTenderBidService.updateVendorTenderBid(refNo, username, file_name, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total);
        }

        //item details
        String[] sr_no = request.getParameterValues("sr_no");
        String[] item_description = request.getParameterValues("item_description");
        String[] item_remark = request.getParameterValues("item_remark");
        String[] uom = request.getParameterValues("uom");
        String[] qty = request.getParameterValues("qty");
        String[] attachment_required = request.getParameterValues("attachment_required");
        String[] unit_rate = request.getParameterValues("unit_rate");
        String[] net_rate = request.getParameterValues("net_rate");
        String[] hsn_no = request.getParameterValues("hsn_no");
        String[] vendor_remark = request.getParameterValues("vendor_remark");
        String[] item_discount_val = request.getParameterValues("item_discount_val");
        String[] item_discount = request.getParameterValues("item_discount");
        String[] item_packing_val = request.getParameterValues("item_packing_val");
        String[] item_packing = request.getParameterValues("item_packing");
        String[] item_freight_val = request.getParameterValues("item_freight_val");
        String[] item_freight = request.getParameterValues("item_freight");
        String[] item_errection = request.getParameterValues("item_errection");
        String[] item_other_charges = request.getParameterValues("item_other_charges");
        String[] item_igst = request.getParameterValues("item_igst");
        String[] item_cgst = request.getParameterValues("item_cgst");
        String[] item_sgst = request.getParameterValues("item_sgst");
        String[] item_insurance_value = request.getParameterValues("item_insurance_value");
        String[] item_total = request.getParameterValues("item_total");
        String[] item_regret = request.getParameterValues("item_regret");

        int j = 0;
        for (int i = 0; i < sr_no.length; i++) {
            j++;

            List serviceVendorTenderBidItem1 = serviceVendorTenderBidItemService.readItemVendorRefNo(refNo, username, file_name, sr_no[i]);

            if (serviceVendorTenderBidItem1.isEmpty()) {
                ServiceVendorTenderBidItem serviceVendorTenderBidItem = new ServiceVendorTenderBidItem();
                serviceVendorTenderBidItem.setTenderNo(refNo);
                serviceVendorTenderBidItem.setVendorCode(username);
                serviceVendorTenderBidItem.setFileName(file_name);
                serviceVendorTenderBidItem.setSrNo(sr_no[i]);
                serviceVendorTenderBidItem.setItemDesc(item_description[i]);
                serviceVendorTenderBidItem.setRemark(item_remark[i]);
                serviceVendorTenderBidItem.setUom(uom[i]);
                serviceVendorTenderBidItem.setQuantity(qty[i]);
                serviceVendorTenderBidItem.setRate(unit_rate[i]);
                serviceVendorTenderBidItem.setNetRate(net_rate[i]);
                serviceVendorTenderBidItem.setHsnNo(hsn_no[i]);
                serviceVendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                serviceVendorTenderBidItem.setDiscountType(item_discount_val[i]);
                serviceVendorTenderBidItem.setDiscountValue(item_discount[i]);
                serviceVendorTenderBidItem.setPackingType(item_packing_val[i]);
                serviceVendorTenderBidItem.setPackingValue(item_packing[i]);
                serviceVendorTenderBidItem.setFreightType(item_freight_val[i]);
                serviceVendorTenderBidItem.setFreightValue(item_freight[i]);
                serviceVendorTenderBidItem.setErrectionValue(item_errection[i]);
                serviceVendorTenderBidItem.setChargesValue(item_other_charges[i]);
                serviceVendorTenderBidItem.setIgstValue(item_igst[i]);
                serviceVendorTenderBidItem.setCgstValue(item_cgst[i]);
                serviceVendorTenderBidItem.setSgstValue(item_sgst[i]);
                serviceVendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                serviceVendorTenderBidItem.setTotalValue(net_rate[i]);
                serviceVendorTenderBidItem.setItemRegret(item_regret[i]);
                serviceVendorTenderBidItemService.create(serviceVendorTenderBidItem);
            } else {
                serviceVendorTenderBidItemService.updateItemVendorRefNo(refNo, username, file_name, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], unit_rate[i], net_rate[i], hsn_no[i], vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i]);

            }

        }

        //-----------------------------------------
        //get item details
        List serviceVendorTenderBidItem = serviceVendorTenderBidItemService.readVendorRefNo(file_name, username, refNo);
        String sr_no1 = "";
        int i = 0;
        for (Object o : serviceVendorTenderBidItem) {
            i++;
            if (i == Integer.parseInt(id)) {
                ServiceVendorTenderBidItem svtb = (ServiceVendorTenderBidItem) o;
                sr_no1 = svtb.getSrNo();
            }
        }

        //vendor tender bid
        ServiceVendorTenderBidItem serviceVendorTenderBidItem1 = serviceVendorTenderBidItemService.readByVendorRefNo(refNo, username, file_name, sr_no1);
        String item_description1 = serviceVendorTenderBidItem1.getItemDesc();
        String remark1 = serviceVendorTenderBidItem1.getRemark();
        String uom1 = serviceVendorTenderBidItem1.getUom();
        String qty1 = serviceVendorTenderBidItem1.getQuantity();
        String rate1 = serviceVendorTenderBidItem1.getRate();
        String netrate1 = serviceVendorTenderBidItem1.getNetRate();
        String discount_val1 = serviceVendorTenderBidItem1.getDiscountType();
        String discount1 = serviceVendorTenderBidItem1.getDiscountValue();
        String packing_val1 = serviceVendorTenderBidItem1.getPackingType();
        String packing1 = serviceVendorTenderBidItem1.getPackingValue();
        String freight_val1 = serviceVendorTenderBidItem1.getFreightType();
        String freight1 = serviceVendorTenderBidItem1.getFreightValue();
        String errection1 = serviceVendorTenderBidItem1.getErrectionValue();
        String other_charges1 = serviceVendorTenderBidItem1.getChargesValue();
        String igst1 = serviceVendorTenderBidItem1.getIgstValue();
        String cgst1 = serviceVendorTenderBidItem1.getCgstValue();
        String sgst1 = serviceVendorTenderBidItem1.getSgstValue();
        String insurance_value1 = serviceVendorTenderBidItem1.getInsuranceValue();
        String total_amount1 = serviceVendorTenderBidItem1.getTotalValue();

        mv.getModelMap().put("item_description1", item_description1);
        mv.getModelMap().put("sr_no1", sr_no1);
        mv.getModelMap().put("remark1", remark1);
        mv.getModelMap().put("uom1", uom1);
        mv.getModelMap().put("qty1", qty1);
        mv.getModelMap().put("rate1", rate1);
        mv.getModelMap().put("netrate1", netrate1);
        mv.getModelMap().put("discount_val1", discount_val1);
        mv.getModelMap().put("discount1", discount1);
        mv.getModelMap().put("packing_val1", packing_val1);
        mv.getModelMap().put("packing1", packing1);
        mv.getModelMap().put("freight_val1", freight_val1);
        mv.getModelMap().put("freight1", freight1);
        mv.getModelMap().put("errection1", errection1);
        mv.getModelMap().put("other_charges1", other_charges1);
        mv.getModelMap().put("igst1", igst1);
        mv.getModelMap().put("cgst1", cgst1);
        mv.getModelMap().put("sgst1", sgst1);
        mv.getModelMap().put("insurance_value1", insurance_value1);
        mv.getModelMap().put("total_amount1", total_amount1);

        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        List list1 = tenderMasterService.vendorLiveTender(username);

        VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);
        int rivision = vendorTenderBid11.getRevision();

        mv.getModelMap().put("rivision", rivision);

        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("file_no", file_no);
        mv.getModelMap().put("file_name", file_name);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);

        mv.setViewName("Vendor/VenderTenderService1ItemDetail");
        return mv;
    }

    public ModelAndView venderTenderService1ItemDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String file_no = request.getParameter("file_no");
        String service_type = request.getParameter("service_type");
        String file_name = request.getParameter("file_name");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();

        String sr_no1 = request.getParameter("sr_no1");
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value1 = request.getParameter("insurance_value");
        String grand_total1 = request.getParameter("grand_total");

        serviceVendorTenderBidItemService.updateItemVendorRefNo1(refNo, username, file_name, sr_no1, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value1, grand_total1);

        // vendorTenderBidItemService.updateItem(refNo, username, item_code, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value1, grand_total1);
        int file_no1 = Integer.parseInt(file_no);
        //file_no1++;
        String service_type1 = "";

        List fileDetail = fileDetailService.readTenderNo(refNo);

        mv.getModelMap().put("fileDetail", fileDetail);

        file_name = "";
        String serviceDetail1 = "";
        String from_date = "";
        String to_date = "";
        String date_wise = "";
        int i = 0;
        for (Object o : fileDetail) {
            i++;
            if (i == file_no1) {
                FileDetail fd = (FileDetail) o;
                service_type1 = fd.getSerType();
                file_name = fd.getFileName();
                from_date = fd.getFromDate();
                to_date = fd.getToDate();
                date_wise = fd.getDateWise();

                String select_common = "";
                String discount_type = "";
                String discount_value = "";
                String packing_type = "";
                String packing_value = "";
                String freight_type = "";
                String freight_value = "";
                String errection_value = "";
                String charges_value = "";
                String igst_value = "";
                String cgst_value = "";
                String sgst_value = "";
                String insurance_value = "";
                String grand_total = "";
                String item_total = "";
                try {
                    List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, username, refNo);
                    mv.getModelMap().put("serviceVendorTenderBid", serviceVendorTenderBid);

                    for (Object o1 : serviceVendorTenderBid) {

                        ServiceVendorTenderBid svtb = (ServiceVendorTenderBid) o1;
                        select_common = svtb.getSelectCommon();
                        discount_type = svtb.getDiscountType();
                        discount_value = svtb.getDiscountValue();
                        packing_type = svtb.getPackingType();
                        packing_value = svtb.getPackingValue();
                        freight_type = svtb.getFreightType();
                        freight_value = svtb.getFreightValue();
                        errection_value = svtb.getErrectionValue();
                        charges_value = svtb.getChargesValue();
                        igst_value = svtb.getIgstValue();
                        cgst_value = svtb.getCgstValue();
                        sgst_value = svtb.getSgstValue();
                        insurance_value = svtb.getInsuranceValue();
                        grand_total = svtb.getGrandTotal();
                        item_total = svtb.getItemTotal();

                    }

                } catch (Exception e1) {
                }

                mv.getModelMap().put("select_common", select_common);
                mv.getModelMap().put("discount_type", discount_type);
                mv.getModelMap().put("discount_value", discount_value);
                mv.getModelMap().put("packing_type", packing_type);
                mv.getModelMap().put("packing_value", packing_value);
                mv.getModelMap().put("freight_type", freight_type);
                mv.getModelMap().put("freight_value", freight_value);
                mv.getModelMap().put("errection_value", errection_value);
                mv.getModelMap().put("charges_value", charges_value);
                mv.getModelMap().put("igst_value", igst_value);
                mv.getModelMap().put("cgst_value", cgst_value);
                mv.getModelMap().put("sgst_value", sgst_value);
                mv.getModelMap().put("insurance_value", insurance_value);
                mv.getModelMap().put("grand_total", grand_total);
                mv.getModelMap().put("item_total", item_total);

                if (service_type1.equals("Service1")) {
                    List serviceDetail = serviceDetail1Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem = serviceVendorTenderBidItemService.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem", serviceVendorTenderBidItem);
                    } catch (Exception e1) {
                    }
                } else if (service_type1.equals("Service2")) {
                    List serviceDetail = serviceDetail2Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem2 = serviceVendorTenderBidItem2Service.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem2", serviceVendorTenderBidItem2);
                    } catch (Exception e1) {
                    }

                } else if (service_type1.equals("Service3")) {
                    List serviceDetail = serviceDetail3Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem3 = serviceVendorTenderBidItem3Service.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem3", serviceVendorTenderBidItem3);
                    } catch (Exception e1) {
                    }
                } else if (service_type1.equals("Service4")) {
                    long difference_In_Days = 0;
                    if (date_wise.equals("date_service4")) {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date d1 = sdf.parse(from_date);
                            Date d2 = sdf.parse(to_date);

                            long difference_In_Time = d2.getTime() - d1.getTime();
                            difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

                        } catch (Exception e1) {
                        }

                    }

                    mv.getModelMap().put("from_date", from_date);
                    mv.getModelMap().put("to_date", to_date);
                    mv.getModelMap().put("diff_days", difference_In_Days);

                    List serviceDetail = serviceDetail4Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem4 = serviceVendorTenderBidItem4Service.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem4", serviceVendorTenderBidItem4);
                    } catch (Exception e1) {
                    }
                } else if (service_type1.equals("Service5")) {
                    List serviceDetail = serviceDetail5Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem = serviceVendorTenderBidItemService.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem", serviceVendorTenderBidItem);
                    } catch (Exception e1) {
                    }
                } else if (service_type1.equals("Service6")) {
                    List serviceDetail = serviceDetail6Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail", serviceDetail);

                    try {
                        List serviceVendorTenderBidItem6 = serviceVendorTenderBidItem6Service.readVendorRefNo(file_name, username, refNo);
                        mv.getModelMap().put("serviceVendorTenderBidItem6", serviceVendorTenderBidItem6);
                    } catch (Exception e1) {
                    }
                }

                VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);
                int rivision = vendorTenderBid11.getRevision();

                mv.getModelMap().put("rivision", rivision);

                mv.getModelMap().put("file_no", i);
                mv.getModelMap().put("refNo", refNo);
                mv.getModelMap().put("file_name", file_name);
                mv.getModelMap().put("tenderMaster", tenderMaster);

                mv.setViewName("Vendor/BidTenderForFinancialServiceManual");
                return mv;

            }
        }

        mv.setViewName("Vendor/BidTenderForFinancialServiceManual");
        return mv;

    }

    public ModelAndView bidTenderForConditionSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);

        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);

        //-----------------------------------------
        String tender_revision1 = "";
        String delivery_location = request.getParameter("delivery_location");
        String delivery_period = request.getParameter("delivery_period");
        String terms_of_payment = request.getParameter("terms_of_payment");
        String validity_period = request.getParameter("validity_period");
        String mode_of_transport = request.getParameter("mode_of_transport");
        String inco_terms = request.getParameter("inco_terms");
        String insurance = request.getParameter("insurance");
        String freight = request.getParameter("freight");
        String vendor_remark = request.getParameter("vendor_remark");
        int revision = vendorTenderBid.getRevision();
        revision++;
        vendorTenderBidService.updateVendorCondition(refNo, username, revision, delivery_location, delivery_period, terms_of_payment, validity_period, mode_of_transport, inco_terms, insurance, freight, vendor_remark);

        VendorTenderBid vendorTenderBid1 = vendorTenderBidService.readByVendorRefNo(refNo, username);

        vendorTenderBid1.setRevision(revision);
        vendorTenderBid1.setSubmitFlag("1");
        vendorTenderBidService.update(vendorTenderBid1);
        //vendorTenderBidService.updateVendorCondition(refNo, username, revision, delivery_location, delivery_period, terms_of_payment, validity_period, mode_of_transport, inco_terms, insurance, freight, vendor_remark);

        //send mail
        VendorMaster vendorMaster = vendorMasterService.read(username);

        TenderMaster tenderMaster11 = tenderMasterService.readRefNo(refNo);
        String location = tenderMaster11.getLocation();
        String title = tenderMaster11.getTitle();

        String subject = "";
        String msg = "";
        String mail_from = "";
        String mail_to = vendorMaster.getVendorEmailID();

        String mail_to1[] = mail_to.split(",");

        for (int ml = 0; ml < mail_to1.length; ml++) {
            mail_to = mail_to1[ml];

            EmailTemplate emailTemplate = emailTemplateService.readById(11);

            subject = emailTemplate.getSubject();
            msg = emailTemplate.getBodytext();

            subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{tender_title\\}", title.toUpperCase());
            msg = msg.replaceAll("\\{ref_no\\}", refNo);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);
        }

        //HttpSession session = request.getSession(false);
        UserMaster user11 = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Tender Price Bid Submition for tender no " + refNo + "").setDrow("Y");
        logService.create(lm);

        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        TenderFollowup tenderFollowup = new TenderFollowup();
        tenderFollowup.setActivityDate(formattedDate1);
        tenderFollowup.setActivity("Tender Price Bid Submition for tender no " + refNo + "");
        tenderFollowup.setLocation(location);
        tenderFollowup.setTenderNo(refNo);
        tenderFollowup.setPerson(user11.getLoginName());
        tenderFollowup.setPersonFullname(user11.getUserFullName());
        tenderFollowupService.create(tenderFollowup);

        request.setAttribute("successMessage",
                "Information: Bid Submited successfully");

        //item details
        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //get pre qualiication details
        VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
        String preBidDeviation = vendorPreBid.getPreBidDeviation();
        String preBidRemark = vendorPreBid.getPreBidRemark();

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, username);
//        List vendorTermsConditionPriceBid1 = vendorTermsConditionPriceBidService.readByRef(refNo, username);

//    
        String termsCondition[] = request.getParameterValues("termsCondition");
        String remarks[] = request.getParameterValues("remarks");
        String ids[] = request.getParameterValues("ids");
        String descripion[] = request.getParameterValues("description");

        try {
            int j = 0;
            for (int i = 0; i < termsCondition.length; i++) {
                j++;
                String documentYes = request.getParameter("documentYes" + j);

                if (vendorTermsCondition1.isEmpty()) {

                    VendorTermsConditionPriceBid vendorTermsConditionPriceBid = new VendorTermsConditionPriceBid();
                    vendorTermsConditionPriceBid.setTenderNo(refNo);
                    vendorTermsConditionPriceBid.setVendorCode(username);
                    vendorTermsConditionPriceBid.setTermsCondition(termsCondition[i]);
                    vendorTermsConditionPriceBid.setResponse(documentYes);
                    vendorTermsConditionPriceBid.setComment(remarks[i]);
                    vendorTermsConditionPriceBid.setDescription(descripion[i]);
                    vendorTermsConditionPriceBidService.create(vendorTermsConditionPriceBid);
                    VendorTermsCondition vendorTermsCondition = new VendorTermsCondition();
                    vendorTermsCondition.setTenderNo(refNo);
                    vendorTermsCondition.setVendorCode(username);
                    vendorTermsCondition.setTermsCondition(termsCondition[i]);
                    vendorTermsCondition.setResponse(documentYes);
                    vendorTermsCondition.setComment(remarks[i]);
                    vendorTermsCondition.setDescription(descripion[i]);
                    vendorTermsConditionService.create(vendorTermsCondition);

                } else {

                    VendorTermsCondition vendorTermsCondition = vendorTermsConditionService.readById(Integer.parseInt(ids[i]));
                    vendorTermsCondition.setTenderNo(refNo);
                    vendorTermsCondition.setVendorCode(username);
                    vendorTermsCondition.setTermsCondition(termsCondition[i]);
                    vendorTermsCondition.setResponse(documentYes);
                    vendorTermsCondition.setComment(remarks[i]);
                    vendorTermsCondition.setDescription(descripion[i]);
                    vendorTermsConditionService.update(vendorTermsCondition);

                    List reviseItemList = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, 0);

                    if (reviseItemList.size() == 0) {
                        VendorTermsConditionPriceBid vendorTermsConditionPriceBid = vendorTermsConditionPriceBidService.readByTerms(refNo, username, termsCondition[i]);
                        vendorTermsConditionPriceBid.setResponse(documentYes);
                        vendorTermsConditionPriceBid.setComment(remarks[i]);
                        vendorTermsConditionPriceBidService.update(vendorTermsConditionPriceBid);
                    }

                }

            }
        } catch (Exception e) {
            // Properly log the exception for debugging purposes
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as needed
        }

        mv.getModelMap().put("vendorTermsCondition1", vendorTermsCondition1);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);
        mv.getModelMap().put("preBidDeviation", preBidDeviation);
        mv.getModelMap().put("preBidRemark", preBidRemark);

        List list = tenderMasterService.vendorLiveTender(username);

        List list3 = tenderMasterService.vendorOpenTender();

        List list2 = tenderMasterService.allLiveTender();

        request.setAttribute("list", list);
        mv.getModelMap().put("list1", list3);
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        String termsConditionCount = request.getParameter("termsConditionCount");
        List<VendorTermsCondition> vendorTermsCondition2 = vendorTermsConditionService.readByRef(refNo, username);
        int vendorTermsCondition2Count = vendorTermsCondition2.size();

        boolean isVendorItemDerailsValid = (Integer.parseInt(termsConditionCount) == vendorTermsCondition2Count);

        if (isVendorItemDerailsValid) {
            mv.setViewName("forward:vendor.htm?act=liveTender");
        } else {
            for (VendorTermsCondition venTerms : vendorTermsCondition2) {
                int id = venTerms.getId();
                vendorTermsConditionService.delete(id);
            }

            request.setAttribute("failureMessage",
                    "Information: Data not submitted properly. Please try again.");
            mv.setViewName("forward:vendor.htm?act=bidTenderForTermsConditionPage&refNo=" + refNo);

        }

        //mv.setViewName("Vendor/LiveTender");
        return mv;
    }

    public ModelAndView bidTenderForConditionSave(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);

        //-----------------------------------------
        String tender_revision = request.getParameter("tender_revision");
        String delivery_location = request.getParameter("delivery_location");
        String delivery_period = request.getParameter("delivery_period");
        String terms_of_payment = request.getParameter("terms_of_payment");
        String validity_period = request.getParameter("validity_period");
        String mode_of_transport = request.getParameter("mode_of_transport");
        String inco_terms = request.getParameter("inco_terms");
        String insurance = request.getParameter("insurance");
        String freight = request.getParameter("freight");
        String vendor_remark = request.getParameter("vendor_remark");

        int revision = Integer.parseInt(tender_revision);
        //revision++;
        vendorTenderBidService.updateVendorConditionSave(refNo, username, revision, delivery_location, delivery_period, terms_of_payment, validity_period, mode_of_transport, inco_terms, insurance, freight, vendor_remark);

        //send mail
        VendorMaster vendorMaster = vendorMasterService.read(username);

        TenderMaster tenderMaster11 = tenderMasterService.readRefNo(refNo);
        String location = tenderMaster11.getLocation();
        String title = tenderMaster11.getTitle();

        String subject = "";
        String msg = "";
        String mail_from = "";
        String mail_to = vendorMaster.getVendorEmailID();

        String mail_to1[] = mail_to.split(",");

        //HttpSession session = request.getSession(false);
        UserMaster user11 = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        Date date = new Date();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Tender Bid Submition for tender no " + refNo + "").setDrow("Y");
        logService.create(lm);

        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        TenderFollowup tenderFollowup = new TenderFollowup();
        tenderFollowup.setActivityDate(formattedDate1);
        tenderFollowup.setActivity("Tender Bid Save for tender no " + refNo + "");
        tenderFollowup.setLocation(location);
        tenderFollowup.setTenderNo(refNo);
        tenderFollowup.setPerson(user11.getLoginName());
        tenderFollowup.setPersonFullname(user11.getUserFullName());
        tenderFollowupService.create(tenderFollowup);

        //item details
        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //get pre qualiication details
        VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
        String preBidDeviation = vendorPreBid.getPreBidDeviation();
        String preBidRemark = vendorPreBid.getPreBidRemark();

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);
        mv.getModelMap().put("preBidDeviation", preBidDeviation);
        mv.getModelMap().put("preBidRemark", preBidRemark);

        List list = tenderMasterService.vendorLiveTender(username);

        List list3 = tenderMasterService.vendorOpenTender();

        List list2 = tenderMasterService.allLiveTender();

        request.setAttribute("list", list);
        mv.getModelMap().put("list1", list3);
        mv.getModelMap().put("list2", list2);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("ref_no", refNo);
        mv.getModelMap().put("vendor_code", username);

        mv.setViewName("Vendor/BidTenderForSpecification");
        //mv.setViewName("forward:vendor.htm?act=liveTender");
        //mv.setViewName("Vendor/LiveTender");
        return mv;
    }

    public ModelAndView bidTenderForReviseBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        String tender_type = tenderMaster.getTenderType();
        if (tender_type == null) {
            tender_type = "";
        }

        List tenderItemMaster = tenderItemMasterService.readByRefNoAndItemType(refNo, 0);
        int tenderItemMasterCount = tenderItemMaster.size();

        int item_type = 0;
        List reviseVendorTenderBidItem = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, item_type);

        if (reviseVendorTenderBidItem.isEmpty()) {
            List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, item_type);
            mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);
        } else {
            mv.getModelMap().put("vendorTenderBidItem", reviseVendorTenderBidItem);
        }

        //vendor tender bid
        if (reviseVendorTenderBidItem.isEmpty()) {

            VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
            int rivision = vendorTenderBid.getRevision();
            String discount_type = vendorTenderBid.getDiscountType();
            String discount_value = vendorTenderBid.getDiscountValue();
            String packing_type = vendorTenderBid.getPackingType();
            String packing_value = vendorTenderBid.getPackingValue();
            String freight_type = vendorTenderBid.getFreightType();
            String freight_value = vendorTenderBid.getFreightValue();
            String errection_value = vendorTenderBid.getErrectionValue();
            String charges_value = vendorTenderBid.getChargesValue();
            String igst_value = vendorTenderBid.getIgstValue();
            String cgst_value = vendorTenderBid.getCgstValue();
            String sgst_value = vendorTenderBid.getSgstValue();
            String insurance_value = vendorTenderBid.getInsuranceValue();
            String item_total = vendorTenderBid.getItemTotal();
            String grand_total = vendorTenderBid.getGrandTotal();
            String grand_total_word = vendorTenderBid.getGrandTotalWord();
            String select_common = vendorTenderBid.getSelectCommon();
            String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
            String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();

            mv.getModelMap().put("rivision", rivision);
            mv.getModelMap().put("discount_type", discount_type);
            mv.getModelMap().put("discount_value", discount_value);
            mv.getModelMap().put("packing_type", packing_type);
            mv.getModelMap().put("packing_value", packing_value);
            mv.getModelMap().put("freight_type", freight_type);
            mv.getModelMap().put("freight_value", freight_value);
            mv.getModelMap().put("errection_value", errection_value);
            mv.getModelMap().put("charges_value", charges_value);
            mv.getModelMap().put("igst_value", igst_value);
            mv.getModelMap().put("cgst_value", cgst_value);
            mv.getModelMap().put("sgst_value", sgst_value);
            mv.getModelMap().put("insurance_value", insurance_value);
            mv.getModelMap().put("item_total", item_total);
            mv.getModelMap().put("grand_total", grand_total);
            mv.getModelMap().put("grand_total_word", grand_total_word);
            mv.getModelMap().put("select_common", select_common);
            mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
            mv.getModelMap().put("free_delivery_comment", free_delivery_comment);
        } else {
            ReviseVendorTenderBid vendorTenderBid = reviseVendorTenderBidService.readByVendorRefNo(refNo, username);

            int rivision = vendorTenderBid.getRevision();
            String discount_type = vendorTenderBid.getDiscountType();
            String discount_value = vendorTenderBid.getDiscountValue();
            String packing_type = vendorTenderBid.getPackingType();
            String packing_value = vendorTenderBid.getPackingValue();
            String freight_type = vendorTenderBid.getFreightType();
            String freight_value = vendorTenderBid.getFreightValue();
            String errection_value = vendorTenderBid.getErrectionValue();
            String charges_value = vendorTenderBid.getChargesValue();
            String igst_value = vendorTenderBid.getIgstValue();
            String cgst_value = vendorTenderBid.getCgstValue();
            String sgst_value = vendorTenderBid.getSgstValue();
            String insurance_value = vendorTenderBid.getInsuranceValue();
            String item_total = vendorTenderBid.getItemTotal();
            String grand_total = vendorTenderBid.getGrandTotal();
            String grand_total_word = vendorTenderBid.getGrandTotalWord();
            String select_common = vendorTenderBid.getSelectCommon();
            String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
            String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();

            mv.getModelMap().put("rivision", rivision);
            mv.getModelMap().put("discount_type", discount_type);
            mv.getModelMap().put("discount_value", discount_value);
            mv.getModelMap().put("packing_type", packing_type);
            mv.getModelMap().put("packing_value", packing_value);
            mv.getModelMap().put("freight_type", freight_type);
            mv.getModelMap().put("freight_value", freight_value);
            mv.getModelMap().put("errection_value", errection_value);
            mv.getModelMap().put("charges_value", charges_value);
            mv.getModelMap().put("igst_value", igst_value);
            mv.getModelMap().put("cgst_value", cgst_value);
            mv.getModelMap().put("sgst_value", sgst_value);
            mv.getModelMap().put("insurance_value", insurance_value);
            mv.getModelMap().put("item_total", item_total);
            mv.getModelMap().put("grand_total", grand_total);
            mv.getModelMap().put("grand_total_word", grand_total_word);
            mv.getModelMap().put("select_common", select_common);
            mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
            mv.getModelMap().put("free_delivery_comment", free_delivery_comment);

        }

        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        String revise_remark = vendorTenderBid.getReviseComment();

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("tenderItemMasterCount", tenderItemMasterCount);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("revise_remark", revise_remark);

        mv.setViewName("Vendor/BidTenderForReviseBid");
        return mv;

    }

    public ModelAndView venderTenderReviseItemDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        //-----------------------------------------
        String common_tax = "0";
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value = request.getParameter("insurance_value");
        String total_amount = request.getParameter("total_amount");
        String grand_total = request.getParameter("grand_total");
        String venodr_total_words = request.getParameter("venodr_total_words");
        String modeOfFraight = request.getParameter("modeOfFraight");
        String freight_comment = request.getParameter("freight_comment");

        VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);

        String offer_no = vendorTenderBid11.getOfferNo();
        String offer_date = vendorTenderBid11.getOfferDate();
        String contact_person = vendorTenderBid11.getContactPerson();
        String contact_no = vendorTenderBid11.getContactNo();
        String contact_email = vendorTenderBid11.getConactEmail();
        String gst_no = vendorTenderBid11.getGstNo();

        List reviseVendorTenderBid1 = reviseVendorTenderBidService.readVendorRefNo(refNo, username);

        if (reviseVendorTenderBid1.isEmpty()) {
            ReviseVendorTenderBid reviseVendorTenderBid = new ReviseVendorTenderBid();
            reviseVendorTenderBid.setRefNo(refNo);
            reviseVendorTenderBid.setVendorCode(username);
            reviseVendorTenderBid.setOfferNo(offer_no);
            reviseVendorTenderBid.setOfferDate(offer_date);
            reviseVendorTenderBid.setContactPerson(contact_person);
            reviseVendorTenderBid.setContactNo(contact_no);
            reviseVendorTenderBid.setConactEmail(contact_email);
            reviseVendorTenderBid.setGstNo(gst_no);
            reviseVendorTenderBidService.create(reviseVendorTenderBid);
        }

        reviseVendorTenderBidService.updateVendorItem(refNo, username, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total, venodr_total_words);

        ReviseVendorTenderBid reviseVendorTenderBid111 = reviseVendorTenderBidService.readByVendorRefNo(refNo, username);
        reviseVendorTenderBid111.setFreightFreeDelivery(modeOfFraight);
        reviseVendorTenderBid111.setFreeDeliveryComment(freight_comment);
     //   reviseVendorTenderBidService.update(reviseVendorTenderBid111);

        //item details
        String[] item_code = request.getParameterValues("item_code");
        String[] item_description = request.getParameterValues("item_description");
        String[] item_remark = request.getParameterValues("item_remark");
        String[] uom = request.getParameterValues("uom");
        String[] qty = request.getParameterValues("qty");
        String[] attachment_required = request.getParameterValues("attachment_required");
        String[] delivery_schedule_date = request.getParameterValues("delivery_schedule_date");
        String[] delivery_schedule_qty = request.getParameterValues("delivery_schedule_qty");
        String[] item_location = request.getParameterValues("item_location");
        String[] pur_no = request.getParameterValues("pur_no");
        String[] item_no = request.getParameterValues("item_no");
        String[] sr_no = request.getParameterValues("sr_no");
        String[] pr_no = request.getParameterValues("pr_no");
        String[] unit_rate = request.getParameterValues("unit_rate");
        String[] net_rate = request.getParameterValues("net_rate");
        String[] hsn_no = request.getParameterValues("hsn_no");
        String[] vendor_remark = request.getParameterValues("vendor_remark");
        String[] item_discount_val = request.getParameterValues("item_discount_val");
        String[] item_discount = request.getParameterValues("item_discount");
        String[] item_packing_val = request.getParameterValues("item_packing_val");
        String[] item_packing = request.getParameterValues("item_packing");
        String[] item_freight_val = request.getParameterValues("item_freight_val");
        String[] item_freight = request.getParameterValues("item_freight");
        String[] item_errection = request.getParameterValues("item_errection");
        String[] item_other_charges = request.getParameterValues("item_other_charges");
        String[] item_igst = request.getParameterValues("item_igst");
        String[] item_cgst = request.getParameterValues("item_cgst");
        String[] item_sgst = request.getParameterValues("item_sgst");
        String[] item_insurance_value = request.getParameterValues("item_insurance_value");
        String[] item_total = request.getParameterValues("item_total");
        String[] item_regret = request.getParameterValues("item_regret");

        int j = 0;
        for (int i = 0; i < item_code.length; i++) {
            j++;

            List vendorTenderBidItem1 = reviseVendorTenderBidItemService.readItemVendorRefNo(refNo, username, sr_no[i]);

            if (vendorTenderBidItem1.isEmpty()) {
                ReviseVendorTenderBidItem vendorTenderBidItem = new ReviseVendorTenderBidItem();
                vendorTenderBidItem.setRefNo(refNo);
                vendorTenderBidItem.setVendorCode(username);
                vendorTenderBidItem.setItemCode(item_code[i]);
                vendorTenderBidItem.setItemDescription(item_description[i]);
                vendorTenderBidItem.setRemark(item_remark[i]);
                vendorTenderBidItem.setUom(uom[i]);
                vendorTenderBidItem.setQty(qty[i]);
                vendorTenderBidItem.setAttachmentRequired(attachment_required[i]);
                vendorTenderBidItem.setDeliveryScheduleDate(delivery_schedule_date[i]);
                vendorTenderBidItem.setDeliveryScheduleQty(delivery_schedule_qty[i]);
                vendorTenderBidItem.setLocation(item_location[i]);
                vendorTenderBidItem.setPurNo(pur_no[i]);
                vendorTenderBidItem.setItemNo(item_no[i]);
                vendorTenderBidItem.setSrNo(sr_no[i]);
                vendorTenderBidItem.setPrNo(pr_no[i]);
                if (unit_rate[i].equals("")) {
                    unit_rate[i] = "0";
                }
                vendorTenderBidItem.setRate(unit_rate[i]);
                vendorTenderBidItem.setNetRate(net_rate[i]);
                vendorTenderBidItem.setHsnNo(hsn_no[i]);
                vendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                vendorTenderBidItem.setDiscountType(item_discount_val[i]);
                vendorTenderBidItem.setDiscountValue(item_discount[i]);
                vendorTenderBidItem.setPackingType(item_packing_val[i]);
                vendorTenderBidItem.setPackingValue(item_packing[i]);
                vendorTenderBidItem.setFreightType(item_freight_val[i]);
                vendorTenderBidItem.setFreightValue(item_freight[i]);
                vendorTenderBidItem.setErrectionValue(item_errection[i]);
                vendorTenderBidItem.setChargesValue(item_other_charges[i]);
                vendorTenderBidItem.setIgstValue(item_igst[i]);
                vendorTenderBidItem.setCgstValue(item_cgst[i]);
                vendorTenderBidItem.setSgstValue(item_sgst[i]);
                vendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                vendorTenderBidItem.setTotalValue(net_rate[i]);
                vendorTenderBidItem.setItemRegret(item_regret[i]);
                reviseVendorTenderBidItemService.create(vendorTenderBidItem);
            } else {
                reviseVendorTenderBidItemService.updateItemVendorRefNo(refNo, username, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], attachment_required[i], delivery_schedule_date[i], delivery_schedule_qty[i], item_location[i], pur_no[i], item_no[i], unit_rate[i], net_rate[i], hsn_no[i], vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i]);

            }

        }

        //get item details
        List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNo(refNo, username);
        String item_code1 = "";
        String sr_no2 = "";
        int i = 0;
        for (Object o : vendorTenderBidItem) {
            i++;
            if (i == Integer.parseInt(id)) {
                VendorTenderBidItem tm = (VendorTenderBidItem) o;
                item_code1 = tm.getItemCode();
                sr_no2 = tm.getSrNo();
            }
        }

        //vendor tender bid
        ReviseVendorTenderBidItem vendorTenderBidItem1 = reviseVendorTenderBidItemService.readByVendorRefNo1(refNo, username, sr_no2);
        String item_description1 = vendorTenderBidItem1.getItemDescription();
        String remark1 = vendorTenderBidItem1.getRemark();
        String uom1 = vendorTenderBidItem1.getUom();
        String qty1 = vendorTenderBidItem1.getQty();
        String rate1 = vendorTenderBidItem1.getRate();
        String netrate1 = vendorTenderBidItem1.getNetRate();
        String discount_val1 = vendorTenderBidItem1.getDiscountType();
        String discount1 = vendorTenderBidItem1.getDiscountValue();
        String packing_val1 = vendorTenderBidItem1.getPackingType();
        String packing1 = vendorTenderBidItem1.getPackingValue();
        String freight_val1 = vendorTenderBidItem1.getFreightType();
        String freight1 = vendorTenderBidItem1.getFreightValue();
        String errection1 = vendorTenderBidItem1.getErrectionValue();
        String other_charges1 = vendorTenderBidItem1.getChargesValue();
        String igst1 = vendorTenderBidItem1.getIgstValue();
        String cgst1 = vendorTenderBidItem1.getCgstValue();
        String sgst1 = vendorTenderBidItem1.getSgstValue();
        String insurance_value1 = vendorTenderBidItem1.getInsuranceValue();
        String total_amount1 = vendorTenderBidItem1.getTotalValue();
        String sr_no1 = vendorTenderBidItem1.getSrNo();

        mv.getModelMap().put("item_description1", item_description1);
        mv.getModelMap().put("item_code1", item_code1);
        mv.getModelMap().put("sr_no1", sr_no1);
        mv.getModelMap().put("remark1", remark1);
        mv.getModelMap().put("uom1", uom1);
        mv.getModelMap().put("qty1", qty1);
        mv.getModelMap().put("rate1", rate1);
        mv.getModelMap().put("netrate1", netrate1);
        mv.getModelMap().put("discount_val1", discount_val1);
        mv.getModelMap().put("discount1", discount1);
        mv.getModelMap().put("packing_val1", packing_val1);
        mv.getModelMap().put("packing1", packing1);
        mv.getModelMap().put("freight_val1", freight_val1);
        mv.getModelMap().put("freight1", freight1);
        mv.getModelMap().put("errection1", errection1);
        mv.getModelMap().put("other_charges1", other_charges1);
        mv.getModelMap().put("igst1", igst1);
        mv.getModelMap().put("cgst1", cgst1);
        mv.getModelMap().put("sgst1", sgst1);
        mv.getModelMap().put("insurance_value1", insurance_value1);
        mv.getModelMap().put("total_amount1", total_amount1);

        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        List list1 = tenderMasterService.vendorLiveTender(username);

        // ReviseVendorTenderBid vendorTenderBid11 = reviseVendorTenderBidService.readByVendorRefNo(refNo,username);
        int rivision = vendorTenderBid11.getRevision();

        mv.getModelMap().put("rivision", rivision);

        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);

        mv.setViewName("Vendor/VenderTenderReviseItemDetail");
        return mv;
    }

    public ModelAndView venderTenderReviseItemDetailSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();

        String item_code = request.getParameter("item_code");
        String sr_no = request.getParameter("sr_no");
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value1 = request.getParameter("insurance_value");
        String grand_total1 = request.getParameter("grand_total");

        reviseVendorTenderBidItemService.updateItem(refNo, username, sr_no, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value1, grand_total1);

        // calculation part ----------------
        List vendorTenderBidItem1 = reviseVendorTenderBidItemService.readByVendorRefNo(refNo, username);

        Double discountValueFinal = 0.0;
        Double packingValueFinal = 0.0;
        Double freightValueFinal = 0.0;
        Double errectionValueFinal = 0.0;
        Double chargesValueFinal = 0.0;
        Double igstValueFinal = 0.0;
        Double cgstValueFinal = 0.0;
        Double sgstValueFinal = 0.0;
        Double insuranceValueFinal = 0.0;
        Double grandTotalFinal = 0.0;
        Double Total = 0.0;

        for (Object o : vendorTenderBidItem1) {
            ReviseVendorTenderBidItem vtbi = (ReviseVendorTenderBidItem) o;

            int itemId = vtbi.getId();
            String itemCode = vtbi.getItemCode();
            String itemDesciption = vtbi.getItemDescription();
            String remark = vtbi.getRemark();
            String uom = vtbi.getUom();
            String qty = vtbi.getQty();
            String purNo = vtbi.getPurNo();
            String itemNo = vtbi.getItemNo();
            String rate = vtbi.getRate();
            String hsnNo = vtbi.getHsnNo();
            String vendorRemark = vtbi.getVendorRemark();
            String itemRegret = vtbi.getItemRegret();

            String individualNetTotal = vtbi.getNetRate();
            String individualDiscountType = vtbi.getDiscountType();
            String individualDiscountValue = vtbi.getDiscountValue();
            String individualPackingType = vtbi.getPackingType();
            String individualPackingValue = vtbi.getPackingValue();
            String individualFreightType = vtbi.getFreightType();
            String individualFreightValue = vtbi.getFreightValue();
            String individualErrectionValue = vtbi.getErrectionValue();
            String individualChargesValue = vtbi.getChargesValue();
            String individualIgstValue = vtbi.getIgstValue();
            String individualCgstValue = vtbi.getCgstValue();
            String individualSgstValue = vtbi.getSgstValue();
            String individualInsuranceValue = vtbi.getInsuranceValue();
            String individualgrandTotal = vtbi.getTotalValue();

            Double individualItemTotalFinal = Double.parseDouble(individualNetTotal);
            Double individualDiscountValueFinal = 0.0;
            Double individualPackingValueFinal = 0.0;
            Double individualFreightValueFinal = 0.0;
            Double individualErrectionValueFinal = 0.0;
            Double individualChargesValueFinal = 0.0;
            Double individualIgstValueFinal = 0.0;
            Double individualCgstValueFinal = 0.0;
            Double individualSgstValueFinal = 0.0;
            Double individualInsuranceValueFinal = 0.0;
            Double individualGrandTotalFinal = 0.0;

            Total = Total + individualItemTotalFinal;

            if (individualDiscountType.equals("0")) {
                individualDiscountValueFinal = Double.parseDouble(individualDiscountValue) * individualItemTotalFinal / 100;
            } else {
                individualDiscountValueFinal = Double.parseDouble(individualDiscountValue);
            }
            long tmp = Math.round(individualDiscountValueFinal * 100);
            individualDiscountValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualItemTotalFinal - individualDiscountValueFinal;
            discountValueFinal = discountValueFinal + individualDiscountValueFinal;

            if (individualPackingType.equals("0")) {
                individualPackingValueFinal = Double.parseDouble(individualPackingValue) * individualGrandTotalFinal / 100;
            } else {
                individualPackingValueFinal = Double.parseDouble(individualPackingValue);
            }
            tmp = Math.round(individualPackingValueFinal * 100);
            individualPackingValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualGrandTotalFinal + individualPackingValueFinal;
            packingValueFinal = packingValueFinal + individualPackingValueFinal;

            if (individualFreightType.equals("0")) {
                individualFreightValueFinal = Double.parseDouble(individualFreightValue) * individualGrandTotalFinal / 100;
            } else {
                individualFreightValueFinal = Double.parseDouble(individualFreightValue);
            }
            tmp = Math.round(individualFreightValueFinal * 100);
            individualFreightValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualGrandTotalFinal + individualFreightValueFinal;
            freightValueFinal = freightValueFinal + individualFreightValueFinal;

            individualErrectionValueFinal = Double.parseDouble(individualErrectionValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualErrectionValueFinal * 100);
            individualErrectionValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualGrandTotalFinal + individualErrectionValueFinal;
            errectionValueFinal = errectionValueFinal + individualErrectionValueFinal;

            individualChargesValueFinal = Double.parseDouble(individualChargesValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualChargesValueFinal * 100);
            individualChargesValueFinal = (double) tmp / 100;
            individualGrandTotalFinal = individualGrandTotalFinal + individualChargesValueFinal;
            chargesValueFinal = chargesValueFinal + individualChargesValueFinal;

            individualIgstValueFinal = Double.parseDouble(individualIgstValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualIgstValueFinal * 100);
            individualIgstValueFinal = (double) tmp / 100;
            igstValueFinal = igstValueFinal + individualIgstValueFinal;

            individualCgstValueFinal = Double.parseDouble(individualCgstValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualCgstValueFinal * 100);
            individualCgstValueFinal = (double) tmp / 100;
            cgstValueFinal = cgstValueFinal + individualCgstValueFinal;

            individualSgstValueFinal = Double.parseDouble(individualSgstValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualSgstValueFinal * 100);
            individualSgstValueFinal = (double) tmp / 100;
            sgstValueFinal = sgstValueFinal + individualSgstValueFinal;

            individualGrandTotalFinal = individualGrandTotalFinal + individualIgstValueFinal + individualCgstValueFinal + individualSgstValueFinal;

            individualInsuranceValueFinal = Double.parseDouble(individualInsuranceValue) * individualGrandTotalFinal / 100;
            tmp = Math.round(individualInsuranceValueFinal * 100);
            individualInsuranceValueFinal = (double) tmp / 100;
            insuranceValueFinal = insuranceValueFinal + individualInsuranceValueFinal;
            individualGrandTotalFinal = individualGrandTotalFinal + individualInsuranceValueFinal;

            grandTotalFinal = grandTotalFinal + individualGrandTotalFinal;
        }

        double tmp = Math.round(grandTotalFinal * 100);
        grandTotalFinal = (double) tmp / 100;

        tmp = Math.round(Total * 100);
        Total = (double) tmp / 100;

        VendorTenderBid vendorTenderBid1 = vendorTenderBidService.readByVendorRefNo(refNo, username);
        //  vendorTenderBid1.setGrandTotal(grandTotalFinal+"");
        vendorTenderBid1.setFinalTotal(grandTotalFinal + "");
        vendorTenderBidService.update(vendorTenderBid1);

        ReviseVendorTenderBid reviseVendorTenderBid1 = reviseVendorTenderBidService.readByVendorRefNo(refNo, username);
        reviseVendorTenderBid1.setItemTotal(Total + "");
        reviseVendorTenderBid1.setGrandTotal(grandTotalFinal + "");
        reviseVendorTenderBidService.update(reviseVendorTenderBid1);
        // ---------------------------------

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);

        //get item details
        List tenderItemMaster = tenderItemMasterService.readByRefNo(refNo);
        List vendorTenderBidItem = reviseVendorTenderBidItemService.readByVendorRefNo(refNo, username);

        //vendor tender bid
        ReviseVendorTenderBid vendorTenderBid = reviseVendorTenderBidService.readByVendorRefNo(refNo, username);
        int rivision = vendorTenderBid.getRevision();
        String discount_type = vendorTenderBid.getDiscountType();
        String discount_value = vendorTenderBid.getDiscountValue();
        String packing_type = vendorTenderBid.getPackingType();
        String packing_value = vendorTenderBid.getPackingValue();
        String freight_type = vendorTenderBid.getFreightType();
        String freight_value = vendorTenderBid.getFreightValue();
        String errection_value = vendorTenderBid.getErrectionValue();
        String charges_value = vendorTenderBid.getChargesValue();
        String igst_value = vendorTenderBid.getIgstValue();
        String cgst_value = vendorTenderBid.getCgstValue();
        String sgst_value = vendorTenderBid.getSgstValue();
        String insurance_value = vendorTenderBid.getInsuranceValue();
        String item_total = vendorTenderBid.getItemTotal();
        String grand_total = vendorTenderBid.getGrandTotal();
        String grand_total_word = vendorTenderBid.getGrandTotalWord();
        String select_common = vendorTenderBid.getSelectCommon();
        String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
        String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();

        mv.getModelMap().put("rivision", rivision);
        mv.getModelMap().put("discount_type", discount_type);
        mv.getModelMap().put("discount_value", discount_value);
        mv.getModelMap().put("packing_type", packing_type);
        mv.getModelMap().put("packing_value", packing_value);
        mv.getModelMap().put("freight_type", freight_type);
        mv.getModelMap().put("freight_value", freight_value);
        mv.getModelMap().put("errection_value", errection_value);
        mv.getModelMap().put("charges_value", charges_value);
        mv.getModelMap().put("igst_value", igst_value);
        mv.getModelMap().put("cgst_value", cgst_value);
        mv.getModelMap().put("sgst_value", sgst_value);
        mv.getModelMap().put("insurance_value", insurance_value);
        mv.getModelMap().put("item_total", item_total);
        mv.getModelMap().put("grand_total", grand_total);
        mv.getModelMap().put("grand_total_word", grand_total_word);
        mv.getModelMap().put("select_common", select_common);
        mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
        mv.getModelMap().put("free_delivery_comment", free_delivery_comment);

        //get pre qualiication details
        VendorPreBid vendorPreBid = vendorPreBidService.readByVendorRefNo(refNo, username);
        String preBidDeviation = vendorPreBid.getPreBidDeviation();
        String preBidRemark = vendorPreBid.getPreBidRemark();

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);

        mv.getModelMap().put("tenderItemMaster", tenderItemMaster);
        mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);

        mv.setViewName("Vendor/BidTenderForReviseBid");
        return mv;
    }

    public ModelAndView bidTenderForRevisedBidSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        String tenderItemMasterCount = request.getParameter("tenderItemMasterCount");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        //-----------------------------------------
        String common_tax = request.getParameter("common_tax");
        if (common_tax == null) {
            common_tax = "0";
        }
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value = request.getParameter("insurance_value");
        String total_amount = request.getParameter("total_amount");
        String grand_total = request.getParameter("grand_total");
        String venodr_total_words = request.getParameter("venodr_total_words");
        String modeOfFraight = request.getParameter("modeOfFraight");
        String freight_comment = request.getParameter("freight_comment");

        List reviseVendorTenderBidItem11 = reviseVendorTenderBidItemService.readByVendorRefNo(refNo, username);

        VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);

        String offer_no = vendorTenderBid11.getOfferNo();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);

        String offer_date = vendorTenderBid11.getOfferDate();
        offer_date = formattedDate;
        String contact_person = vendorTenderBid11.getContactPerson();
        String contact_no = vendorTenderBid11.getContactNo();
        String contact_email = vendorTenderBid11.getConactEmail();
        String gst_no = vendorTenderBid11.getGstNo();

        List reviseVendorTenderBid1 = reviseVendorTenderBidService.readVendorRefNo(refNo, username);

        if (reviseVendorTenderBid1.isEmpty()) {
            ReviseVendorTenderBid reviseVendorTenderBid = new ReviseVendorTenderBid();
            reviseVendorTenderBid.setRefNo(refNo);
            reviseVendorTenderBid.setVendorCode(username);
            reviseVendorTenderBid.setOfferNo(offer_no);
            reviseVendorTenderBid.setOfferDate(offer_date);
            reviseVendorTenderBid.setContactPerson(contact_person);
            reviseVendorTenderBid.setContactNo(contact_no);
            reviseVendorTenderBid.setConactEmail(contact_email);
            reviseVendorTenderBid.setGstNo(gst_no);
            reviseVendorTenderBidService.create(reviseVendorTenderBid);
        }

        reviseVendorTenderBidService.updateVendorItem(refNo, username, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total, venodr_total_words);

        ReviseVendorTenderBid reviseVendorTenderBid111 = reviseVendorTenderBidService.readByVendorRefNo(refNo, username);
        reviseVendorTenderBid111.setFreightFreeDelivery(modeOfFraight);
        reviseVendorTenderBid111.setFreeDeliveryComment(freight_comment);
        reviseVendorTenderBid111.setFreightValue(grand_total);
        reviseVendorTenderBidService.update(reviseVendorTenderBid111);

        VendorTenderBid vendorTenderBid111 = vendorTenderBidService.readByVendorRefNo(refNo, username);
        vendorTenderBid111.setFinalTotal(grand_total);
        vendorTenderBid111.setReviseStatus(1);
        vendorTenderBidService.update(vendorTenderBid111);
        //item details

        String[] item_code = request.getParameterValues("item_code");
        String[] item_description = request.getParameterValues("item_description");
        String[] item_remark = request.getParameterValues("item_remark");
        String[] uom = request.getParameterValues("uom");
        String[] qty = request.getParameterValues("qty");
        String[] attachment_required = request.getParameterValues("attachment_required");
        String[] delivery_schedule_date = request.getParameterValues("delivery_schedule_date");
        String[] delivery_schedule_qty = request.getParameterValues("delivery_schedule_qty");
        String[] item_location = request.getParameterValues("item_location");
        String[] pur_no = request.getParameterValues("pur_no");
        String[] item_no = request.getParameterValues("item_no");
        String[] sr_no = request.getParameterValues("sr_no");
        String[] pr_no = request.getParameterValues("pr_no");
        String[] unit_rate = request.getParameterValues("unit_rate");
        String[] net_rate = request.getParameterValues("net_rate");
        String[] hsn_no = request.getParameterValues("hsn_no");
        String[] vendor_remark = request.getParameterValues("vendor_remark");
        String[] item_discount_val = request.getParameterValues("item_discount_val");
        String[] item_discount = request.getParameterValues("item_discount");
        String[] item_packing_val = request.getParameterValues("item_packing_val");
        String[] item_packing = request.getParameterValues("item_packing");
        String[] item_freight_val = request.getParameterValues("item_freight_val");
        String[] item_freight = request.getParameterValues("item_freight");
        String[] item_errection = request.getParameterValues("item_errection");
        String[] item_other_charges = request.getParameterValues("item_other_charges");
        String[] item_igst = request.getParameterValues("item_igst");
        String[] item_cgst = request.getParameterValues("item_cgst");
        String[] item_sgst = request.getParameterValues("item_sgst");
        String[] item_insurance_value = request.getParameterValues("item_insurance_value");
        String[] item_total = request.getParameterValues("item_total");
        String[] item_regret = request.getParameterValues("item_regret");

        String[] accountAssigmentCategory = request.getParameterValues("accountAssigmentCategory");
        String[] accountAssigmentValue = request.getParameterValues("accountAssigmentValue");
        String[] productType = request.getParameterValues("productType");
        String[] productGroup = request.getParameterValues("productGroup");
        String[] taxCode = request.getParameterValues("taxCode");
        String[] valuationPrice = request.getParameterValues("valuationPrice");
        String[] deliveryDate = request.getParameterValues("deliveryDate");
        String[] startDate = request.getParameterValues("startDate");
        String[] endDate = request.getParameterValues("endDate");

        int j = 0;
        int item_type1 = 0;
        for (int i = 0; i < item_code.length; i++) {
            j++;

            List vendorTenderBidItem1 = reviseVendorTenderBidItemService.readItemVendorRefNoByItemType(refNo, username, sr_no[i], item_type1);

            if (vendorTenderBidItem1.isEmpty()) {
                ReviseVendorTenderBidItem vendorTenderBidItem = new ReviseVendorTenderBidItem();
                vendorTenderBidItem.setRefNo(refNo);
                vendorTenderBidItem.setVendorCode(username);
                vendorTenderBidItem.setItemCode(item_code[i]);
                vendorTenderBidItem.setItemDescription(item_description[i]);
                vendorTenderBidItem.setRemark(item_remark[i]);
                vendorTenderBidItem.setUom(uom[i]);
                vendorTenderBidItem.setQty(qty[i]);
                vendorTenderBidItem.setAttachmentRequired(attachment_required[i]);
                vendorTenderBidItem.setDeliveryScheduleDate(delivery_schedule_date[i]);
                vendorTenderBidItem.setDeliveryScheduleQty(delivery_schedule_qty[i]);
                vendorTenderBidItem.setLocation(item_location[i]);
                vendorTenderBidItem.setPurNo(pur_no[i]);
                vendorTenderBidItem.setItemNo(item_no[i]);
                vendorTenderBidItem.setSrNo(sr_no[i]);
                vendorTenderBidItem.setPrNo(pr_no[i]);
                if (unit_rate[i].equals("")) {
                    unit_rate[i] = "0";
                }
                vendorTenderBidItem.setRate(unit_rate[i]);
                vendorTenderBidItem.setNetRate(net_rate[i]);
                vendorTenderBidItem.setHsnNo(hsn_no[i]);
                vendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                vendorTenderBidItem.setDiscountType(item_discount_val[i]);
                vendorTenderBidItem.setDiscountValue(item_discount[i]);
                vendorTenderBidItem.setPackingType(item_packing_val[i]);
                vendorTenderBidItem.setPackingValue(item_packing[i]);
                vendorTenderBidItem.setFreightType(item_freight_val[i]);
                vendorTenderBidItem.setFreightValue(item_freight[i]);
                vendorTenderBidItem.setErrectionValue(item_errection[i]);
                vendorTenderBidItem.setChargesValue(item_other_charges[i]);
                vendorTenderBidItem.setIgstValue(item_igst[i]);
                vendorTenderBidItem.setCgstValue(item_cgst[i]);
                vendorTenderBidItem.setSgstValue(item_sgst[i]);
                vendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                vendorTenderBidItem.setTotalValue(item_total[i]);
                vendorTenderBidItem.setItemRegret(item_regret[i]);
                vendorTenderBidItem.setItemType(0);
                vendorTenderBidItem.setAccountAssigmentCategory(accountAssigmentCategory[i]);
                vendorTenderBidItem.setAccountAssigmentValue(accountAssigmentValue[i]);
                vendorTenderBidItem.setProductType(productType[i]);
                vendorTenderBidItem.setProductGroup(productGroup[i]);
                vendorTenderBidItem.setTaxCode(taxCode[i]);
                vendorTenderBidItem.setValuationPrice(valuationPrice[i]);
                vendorTenderBidItem.setDeliveryDate(deliveryDate[i]);
                vendorTenderBidItem.setStartDate(startDate[i]);
                vendorTenderBidItem.setEndDate(endDate[i]);

                reviseVendorTenderBidItemService.create(vendorTenderBidItem);
            } else {
                reviseVendorTenderBidItemService.updateItemVendorRefNoByItemType(refNo, username, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], attachment_required[i], delivery_schedule_date[i], delivery_schedule_qty[i], item_location[i], pur_no[i], item_no[i], unit_rate[i], net_rate[i], hsn_no[i], vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i], item_type1);

                ReviseVendorTenderBidItem reviseVendorTenderBidItem = reviseVendorTenderBidItemService.readByVendorRefNo1(refNo, username, "0");
                reviseVendorTenderBidItem.setAccountAssigmentCategory(accountAssigmentCategory[i]);
                reviseVendorTenderBidItem.setAccountAssigmentValue(accountAssigmentValue[i]);
                reviseVendorTenderBidItem.setProductType(productType[i]);
                reviseVendorTenderBidItem.setProductGroup(productGroup[i]);
                reviseVendorTenderBidItem.setTaxCode(taxCode[i]);
                reviseVendorTenderBidItem.setValuationPrice(valuationPrice[i]);
                reviseVendorTenderBidItem.setDeliveryDate(deliveryDate[i]);
                reviseVendorTenderBidItem.setStartDate(startDate[i]);
                reviseVendorTenderBidItem.setEndDate(endDate[i]);
                //       reviseVendorTenderBidItemService.update(reviseVendorTenderBidItem);

            }

        }

        if (tenderMaster.getType().equals("Contract") || tenderMaster.getType().equals("Contract Civil") || tenderMaster.getType().equals("Contract Electrical")) {
            List tenderItemMaster = tenderItemMasterService.readByRefNoAndItemType(refNo, 1);

            if (tenderItemMaster.size() > 0) {

                int item_type = 1;
                List reviseVendorTenderBidItem = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, item_type);

                if (reviseVendorTenderBidItem.isEmpty()) {
                    List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, item_type);
                    int vendorTenderBidItemCount = vendorTenderBidItem.size();
                    mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);
                    mv.getModelMap().put("vendorTenderBidItemCount", vendorTenderBidItemCount);

                } else {
                    mv.getModelMap().put("vendorTenderBidItem", reviseVendorTenderBidItem);
                }

                if (reviseVendorTenderBidItem.isEmpty()) {

                    VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
                    int rivision = vendorTenderBid.getRevision();
                    String discount_type = vendorTenderBid.getDiscountType();
                    String discount_value = vendorTenderBid.getDiscountValue();
                    String packing_type = vendorTenderBid.getPackingType();
                    String packing_value = vendorTenderBid.getPackingValue();
                    String freight_type = vendorTenderBid.getFreightType();
                    String freight_value = vendorTenderBid.getFreightValue();
                    String errection_value = vendorTenderBid.getErrectionValue();
                    String charges_value = vendorTenderBid.getChargesValue();
                    String igst_value = vendorTenderBid.getIgstValue();
                    String cgst_value = vendorTenderBid.getCgstValue();
                    String sgst_value = vendorTenderBid.getSgstValue();
                    String insurance_value1 = vendorTenderBid.getInsuranceValue();
                    String item_total1 = vendorTenderBid.getItemTotal();
                    String grand_total1 = vendorTenderBid.getGrandTotal();
                    String grand_total_word = vendorTenderBid.getGrandTotalWord();
                    String select_common = vendorTenderBid.getSelectCommon();
                    String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
                    String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();
                    String service_discount_type = vendorTenderBid.getServiceDiscountType();
                    String service_discount_value = vendorTenderBid.getServiceDiscountValue();
                    String service_gst = vendorTenderBid.getServiceGst();
                    String service_total = vendorTenderBid.getServiceTotal();
                    String service_tax_total = vendorTenderBid.getServiceTaxTotal();

                    mv.getModelMap().put("service_discount_type", service_discount_type);
                    mv.getModelMap().put("service_discount_value", service_discount_value);
                    mv.getModelMap().put("service_gst", service_gst);
                    mv.getModelMap().put("service_total", service_total);
                    mv.getModelMap().put("service_tax_total", service_tax_total);

                    mv.getModelMap().put("rivision", rivision);
                    mv.getModelMap().put("discount_type", discount_type);
                    mv.getModelMap().put("discount_value", discount_value);
                    mv.getModelMap().put("packing_type", packing_type);
                    mv.getModelMap().put("packing_value", packing_value);
                    mv.getModelMap().put("freight_type", freight_type);
                    mv.getModelMap().put("freight_value", freight_value);
                    mv.getModelMap().put("errection_value", errection_value);
                    mv.getModelMap().put("charges_value", charges_value);
                    mv.getModelMap().put("igst_value", igst_value);
                    mv.getModelMap().put("cgst_value", cgst_value);
                    mv.getModelMap().put("sgst_value", sgst_value);
                    mv.getModelMap().put("insurance_value", insurance_value1);
                    mv.getModelMap().put("item_total", item_total1);
                    mv.getModelMap().put("grand_total", grand_total1);
                    mv.getModelMap().put("grand_total_word", grand_total_word);
                    mv.getModelMap().put("select_common", select_common);
                    mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
                    mv.getModelMap().put("free_delivery_comment", free_delivery_comment);
                } else {
                    ReviseVendorTenderBid vendorTenderBid = reviseVendorTenderBidService.readByVendorRefNo(refNo, username);

                    int rivision = vendorTenderBid.getRevision();
                    String discount_type = vendorTenderBid.getDiscountType();
                    String discount_value = vendorTenderBid.getDiscountValue();
                    String packing_type = vendorTenderBid.getPackingType();
                    String packing_value = vendorTenderBid.getPackingValue();
                    String freight_type = vendorTenderBid.getFreightType();
                    String freight_value = vendorTenderBid.getFreightValue();
                    String errection_value = vendorTenderBid.getErrectionValue();
                    String charges_value = vendorTenderBid.getChargesValue();
                    String igst_value = vendorTenderBid.getIgstValue();
                    String cgst_value = vendorTenderBid.getCgstValue();
                    String sgst_value = vendorTenderBid.getSgstValue();
                    String insurance_value1 = vendorTenderBid.getInsuranceValue();
                    String item_total1 = vendorTenderBid.getItemTotal();
                    String grand_total1 = vendorTenderBid.getGrandTotal();
                    String grand_total_word = vendorTenderBid.getGrandTotalWord();
                    String select_common = vendorTenderBid.getSelectCommon();
                    String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
                    String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();
                    String service_discount_type = vendorTenderBid.getServiceDiscountType();
                    String service_discount_value = vendorTenderBid.getServiceDiscountValue();
                    String service_gst = vendorTenderBid.getServiceGst();
                    String service_total = vendorTenderBid.getServiceTotal();
                    String service_tax_total = vendorTenderBid.getServiceTaxTotal();

                    mv.getModelMap().put("service_discount_type", service_discount_type);
                    mv.getModelMap().put("service_discount_value", service_discount_value);
                    mv.getModelMap().put("service_gst", service_gst);
                    mv.getModelMap().put("service_total", service_total);
                    mv.getModelMap().put("service_tax_total", service_tax_total);

                    mv.getModelMap().put("rivision", rivision);
                    mv.getModelMap().put("discount_type", discount_type);
                    mv.getModelMap().put("discount_value", discount_value);
                    mv.getModelMap().put("packing_type", packing_type);
                    mv.getModelMap().put("packing_value", packing_value);
                    mv.getModelMap().put("freight_type", freight_type);
                    mv.getModelMap().put("freight_value", freight_value);
                    mv.getModelMap().put("errection_value", errection_value);
                    mv.getModelMap().put("charges_value", charges_value);
                    mv.getModelMap().put("igst_value", igst_value);
                    mv.getModelMap().put("cgst_value", cgst_value);
                    mv.getModelMap().put("sgst_value", sgst_value);
                    mv.getModelMap().put("insurance_value", insurance_value1);
                    mv.getModelMap().put("item_total", item_total1);
                    mv.getModelMap().put("grand_total", grand_total1);
                    mv.getModelMap().put("grand_total_word", grand_total_word);
                    mv.getModelMap().put("select_common", select_common);
                    mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
                    mv.getModelMap().put("free_delivery_comment", free_delivery_comment);

                }

                ReviseVendorTenderBid reviseVendorTenderBid = reviseVendorTenderBidService.readByVendorRefNo(refNo, username);

                mv.getModelMap().put("reviseVendorTenderBid", reviseVendorTenderBid);

                List list1 = tenderMasterService.vendorLiveTender(username);
                request.setAttribute("list", list1);
                mv.getModelMap().put("tenderMaster", tenderMaster);
                mv.getModelMap().put("refNo", refNo);
                List<ReviseVendorTenderBidItem> vendorTenderBidItem1 = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, 0);
                int vendorTenderBidItemCount = vendorTenderBidItem1.size();
                mv.getModelMap().put("vendorTenderBidItemCount", vendorTenderBidItemCount);

                boolean isVendorTenderBidItemValid = (Integer.parseInt(tenderItemMasterCount) == vendorTenderBidItemCount);

                if (isVendorTenderBidItemValid) {
                    mv.setViewName("Vendor/BidTenderForReviseSpecificationForContract");
                } else {
                    for (ReviseVendorTenderBidItem venTenderBid : vendorTenderBidItem1) {
                        int id = venTenderBid.getId();
                        reviseVendorTenderBidItemService.delete(id);
                    }

                    request.setAttribute("failureMessage",
                            "Information: Data not submitted properly. Please try again.");
                    mv.setViewName("forward:vendor.htm?act=bidTenderForReviseBid&refNo=" + refNo);

                }

                //    mv.setViewName("forward:vendor.htm?act=liveTender");
                return mv;
            } else {

                //vendor tender bid
                VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
                int rivision = vendorTenderBid.getRevision();
                String delivery_location = vendorTenderBid.getDeliveryLocation();
                String delivery_period = vendorTenderBid.getDeliveryPeriod();
                String terms_of_payment = vendorTenderBid.getTermsOfPayment();
                String validity_period = vendorTenderBid.getValidityPeriod();
                String mode_of_transport = vendorTenderBid.getModeOfTransport();
                String inco_terms = vendorTenderBid.getIncoTerms();
                String insurance1 = vendorTenderBid.getInsurance();
                String freight1 = vendorTenderBid.getFreight();
                String grand_total1 = vendorTenderBid.getGrandTotal();
                String grand_total_word1 = vendorTenderBid.getGrandTotalWord();
                String remark_by_vendor = vendorTenderBid.getRemarkByVendor();

                mv.getModelMap().put("rivision", rivision);

                mv.getModelMap().put("delivery_location", delivery_location);
                mv.getModelMap().put("delivery_period", delivery_period);
                mv.getModelMap().put("terms_of_payment", terms_of_payment);
                mv.getModelMap().put("validity_period", validity_period);
                mv.getModelMap().put("mode_of_transport", mode_of_transport);
                mv.getModelMap().put("inco_terms", inco_terms);
                mv.getModelMap().put("insurance1", insurance1);
                mv.getModelMap().put("freight1", freight1);
                mv.getModelMap().put("grand_total1", grand_total1);
                mv.getModelMap().put("grand_total_word1", grand_total_word1);
                mv.getModelMap().put("remark_by_vendor", remark_by_vendor);

                List list1 = tenderMasterService.vendorLiveTender(username);
                request.setAttribute("list", list1);

//        TermsConditionParameter termsConditionParameter = new TermsConditionParameter().readByName();
                List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, username);

                mv.getModelMap().put("vendorTermsCondition1", vendorTermsCondition1);

                mv.getModelMap().put("tenderMaster", tenderMaster);

                mv.setViewName("Vendor/BidTenderForCondition");

                //    mv.setViewName("forward:vendor.htm?act=liveTender");
                //    mv.setViewName("vendor.htm?act=bidTenderForFinancialSubmit1");
                // vendor.htm?act=bidTenderForFinancialSubmit
                return mv;
            }
        } else {

            //vendor tender bid
            VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
            int rivision = vendorTenderBid.getRevision();
            String delivery_location = vendorTenderBid.getDeliveryLocation();
            String delivery_period = vendorTenderBid.getDeliveryPeriod();
            String terms_of_payment = vendorTenderBid.getTermsOfPayment();
            String validity_period = vendorTenderBid.getValidityPeriod();
            String mode_of_transport = vendorTenderBid.getModeOfTransport();
            String inco_terms = vendorTenderBid.getIncoTerms();
            String insurance1 = vendorTenderBid.getInsurance();
            String freight1 = vendorTenderBid.getFreight();
            String grand_total1 = vendorTenderBid.getGrandTotal();
            String grand_total_word1 = vendorTenderBid.getGrandTotalWord();
            String remark_by_vendor = vendorTenderBid.getRemarkByVendor();

            mv.getModelMap().put("rivision", rivision);

            mv.getModelMap().put("delivery_location", delivery_location);
            mv.getModelMap().put("delivery_period", delivery_period);
            mv.getModelMap().put("terms_of_payment", terms_of_payment);
            mv.getModelMap().put("validity_period", validity_period);
            mv.getModelMap().put("mode_of_transport", mode_of_transport);
            mv.getModelMap().put("inco_terms", inco_terms);
            mv.getModelMap().put("insurance1", insurance1);
            mv.getModelMap().put("freight1", freight1);
            mv.getModelMap().put("grand_total1", grand_total1);
            mv.getModelMap().put("grand_total_word1", grand_total_word1);
            mv.getModelMap().put("remark_by_vendor", remark_by_vendor);

            List list1 = tenderMasterService.vendorLiveTender(username);
            request.setAttribute("list", list1);

//        TermsConditionParameter termsConditionParameter = new TermsConditionParameter().readByName();
            List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, username);

            mv.getModelMap().put("vendorTermsCondition1", vendorTermsCondition1);
            int termsConditionCount = vendorTermsCondition1.size();
            mv.getModelMap().put("termsConditionCount", termsConditionCount);

            mv.getModelMap().put("tenderMaster", tenderMaster);

            mv.setViewName("Vendor/BidTenderForCondition");
            //   mv.setViewName("forward:vendor.htm?act=liveTender");
            //  mv.setViewName("vendor.htm?act=bidTenderForFinancialSubmit1");
            return mv;
        }

    }

    public ModelAndView bidTenderForReviseSpecificationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        //-----------------------------------------
        String common_tax = request.getParameter("common_tax");
        if (common_tax == null) {
            common_tax = "0";
        }
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value = request.getParameter("insurance_value");
        String total_amount = request.getParameter("total_amount");
        String grand_total = request.getParameter("grand_total");
        String venodr_total_words = request.getParameter("venodr_total_words");

        List reviseVendorTenderBidItem11 = reviseVendorTenderBidItemService.readByVendorRefNo(refNo, username);

        //    reviseVendorTenderBidService.updateVendorItem(refNo, username, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total, venodr_total_words);
        ReviseVendorTenderBid reviseVendorTenderBid = reviseVendorTenderBidService.readByVendorRefNo(refNo, username);
        reviseVendorTenderBid.setSubmitFlag("1");
        reviseVendorTenderBidService.update(reviseVendorTenderBid);
        //vendor tender bid
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        vendorTenderBid.setReviseStatus(1);
        vendorTenderBidService.update(vendorTenderBid);

        int rivision = vendorTenderBid.getRevision();

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        VendorMaster vendorMaster = vendorMasterService.read(username);
        String subject = "";
        String msg = "";
        String mail_from = "";
        String mail_to = vendorMaster.getVendorEmailID();
        EmailTemplate emailTemplate = emailTemplateService.readById(19);

        subject = emailTemplate.getSubject();
        msg = emailTemplate.getBodytext();

        //subject = subject.replaceAll("\\{location\\}", location.toUpperCase());
        msg = msg.replaceAll("\\{tender_title\\}", tenderMaster.getTitle().toUpperCase());
        msg = msg.replaceAll("\\{ref_no\\}", refNo);

        SendMail s = new SendMail();
        s.sendMail(mail_from, mail_to, subject, msg);

        String user_to = tenderMaster.getTenderAdmin();
        EmployeeMaster employeeMaster1 = employeeMasterService.read(user_to);
        String email_to = employeeMaster1.getEmailId();

        emailTemplate = emailTemplateService.readById(18);

        subject = emailTemplate.getSubject();
        msg = emailTemplate.getBodytext();

        msg = msg.replaceAll("\\{tender_title\\}", tenderMaster.getTitle().toUpperCase());
        msg = msg.replaceAll("\\{ref_no\\}", refNo);
        msg = msg.replaceAll("\\{vendor_code\\}", username);

        //SendMail s = new SendMail();
        s.sendMail(mail_from, mail_to, subject, msg);

        request.setAttribute("successMessage",
                "Information: Revise Bid submited successfully");

        //    mv.setViewName("Vendor/BidTenderForReviseSpecification");
        mv.setViewName("forward:vendor.htm?act=liveTender");
        return mv;
    }

    public ModelAndView bidTenderForTechnicalReviseBid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();
        int tenderPhase1 = tenderMaster.getTenderPhase();
        String tender_type = tenderMaster.getTenderType();

        String prNo = tenderMaster.getPrNo();
        List prDoc = prDocService.readByRefNo(prNo);
        mv.getModelMap().put("prDoc", prDoc);
        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);
        List tenderVendorDocs = tenderVendorDocService.readByRefNo(refNo, username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //---------------------------------
        int revise_technical_bid_id = 0;
        String technicalBidDeviation = "";
        String technicalBidRemark = "";
        List reviseVendorTechnicalBid = reviseVendorTechnicalBidService.readByVendorRefNo(refNo, username);

        if (reviseVendorTechnicalBid.size() > 0) {
            for (Object o : reviseVendorTechnicalBid) {
                ReviseVendorTechnicalBid rvtb = (ReviseVendorTechnicalBid) o;
                revise_technical_bid_id = rvtb.getId();
                technicalBidDeviation = rvtb.getTechnicalDeviation();
                technicalBidRemark = rvtb.getTechnicalRemark();
                break;
            }
        } else {
            VendorTechnicalBid vendorTechnicalBid = vendorTechnicalBidService.readByVendorRefNo(refNo, username);
            technicalBidDeviation = vendorTechnicalBid.getTechnicalDeviation();
            technicalBidRemark = vendorTechnicalBid.getTechnicalRemark();
        }

        //get Technical details
        List vendorTechnicalBidTech = vendorTechnicalBidTechService.readByReviseVendorBid(refNo, username, revise_technical_bid_id);
        List vendorTechnicalBidTerms = vendorTechnicalBidTermsService.readByReviseVendorBid(refNo, username, revise_technical_bid_id);
        List vendorTechnicalBidAttachment = vendorTechnicalBidAttachmentService.readByVendorRefNo(refNo, username);

        int itemDetailsSize = vendorTechnicalBidTech.size();
        int itemDetailsForServiceSize = vendorTechnicalBidTerms.size();
        int attachmentCount = vendorTechnicalBidAttachment.size();
        mv.getModelMap().put("itemDetailsSize", itemDetailsSize);
        mv.getModelMap().put("itemDetailsForServiceSize", itemDetailsForServiceSize);
        mv.getModelMap().put("attachmentCount", attachmentCount);

        List list = tenderTechnicalService.readByRefNo(refNo);

        String technicalfile = "";
        String termsConditionfile = "";
        String attachmentfile = "";
        String tech_doc_ref_no = "";
        String terms_doc_ref_no = "";
        String doc_ref_no = "";

        for (Object o : list) {
            TenderTechnical pdm = (TenderTechnical) o;
            technicalfile = pdm.getTechnicalDoc();
            termsConditionfile = pdm.getTermsConditionDoc();
            attachmentfile = pdm.getDocument();
            tech_doc_ref_no = pdm.getTechnicalRefNo();
            terms_doc_ref_no = pdm.getTermsRefNo();
            doc_ref_no = pdm.getDocumentRefNo();
        }

        mv.getModelMap().put("technicalfile", technicalfile);

        // technical file
        List vendorTechnicalBidTech1 = tenderItemMasterService.readByRefNoAndItemType(refNo, 0);

        //  ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTech1=new ArrayList<TechnicalSpecificationExcel>();
        //read excel file
        //trems and condition file attacment --------------------------
        List vendorTechnicalBidTerms1 = tenderItemMasterService.readByRefNoAndItemType(refNo, 1);
        //    ArrayList<TechnicalSpecificationExcel> vendorTechnicalBidTerms1=new ArrayList<TechnicalSpecificationExcel>();
        //read excel file

        //vendor attachmnt -------------------------------------------
        ArrayList<PreQualificationExcel> vendorTechnicalBidAttachment1 = new ArrayList<PreQualificationExcel>();
        //read excel file

        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);

        int rivision = vendorTenderBid.getRevision();
        String attachment_type = "1";
        List vendorAttachment = vendorAttachmentService.readAttachment(refNo, username, attachment_type);

        mv.getModelMap().put("vendorAttachment", vendorAttachment);

        mv.getModelMap().put("rivision", rivision);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("tenderPhase1", tenderPhase1);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);
        mv.getModelMap().put("vendor_code", username);
        mv.getModelMap().put("vendorCode", username);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("tenderVendorDocs", tenderVendorDocs);

        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);

        mv.getModelMap().put("technicalBidDeviation", technicalBidDeviation);
        mv.getModelMap().put("technicalBidRemark", technicalBidRemark);

        mv.getModelMap().put("vendorTechnicalBidTech", vendorTechnicalBidTech);
        mv.getModelMap().put("vendorTechnicalBidTech1", vendorTechnicalBidTech1);

        mv.getModelMap().put("vendorTechnicalBidTerms", vendorTechnicalBidTerms);
        mv.getModelMap().put("vendorTechnicalBidTerms1", vendorTechnicalBidTerms1);

        mv.getModelMap().put("vendorTechnicalBidAttachment", vendorTechnicalBidAttachment);
        mv.getModelMap().put("vendorTechnicalBidAttachment1", vendorTechnicalBidAttachment1);

        List multipleAddress = multipleAddressService.readByPrNumber(prNo);
        mv.getModelMap().put("multipleAddress", multipleAddress);

        List vendorTechnicalBidTechAttachment = vendorTechnicalBidTechAttachmentService.readByVendorRefNo(refNo, username);
        List vendorTechnicalBidTermsAttachment = vendorTechnicalBidTermsAttachmentService.readByVendorRefNo(refNo, username);

        mv.getModelMap().put("vendorTechnicalBidTechAttachment", vendorTechnicalBidTechAttachment);
        mv.getModelMap().put("vendorTechnicalBidTermsAttachment", vendorTechnicalBidTermsAttachment);

        mv.setViewName("Vendor/BidTenderForTechnicalReviseBid");
        return mv;
    }

    public ModelAndView bidTenderForTechnicalReviseBidSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        //String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String RefNo = refNo.replace("/", "");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + RefNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + RefNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();
        String emd = tenderMaster.getEmd();
        String doc_cost = tenderMaster.getDocCost();

        // emd
        if (emd != "0" && tender_phase == 2) {
            String emd_date = request.getParameter("emd_date");
            String emd_drawee_bank = request.getParameter("emd_drawee_bank");
            String cash_cheque = request.getParameter("cash_cheque");
            String emd_cheque_no = request.getParameter("emd_cheque_no");

            String emd_attach = request.getParameter("emd_attach");
            if (emd_attach == null) {
                emd_attach = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("emd_attach");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + RefNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    emd_attach = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List vendorEmd1 = vendorEmdService.readVendorRefNo(refNo, username);

            if (vendorEmd1.isEmpty()) {
                VendorEmd vendorEmd = new VendorEmd();
                vendorEmd.setRefNo(refNo);
                vendorEmd.setVendorCode(username);
                vendorEmd.setEmdAmount(emd);
                vendorEmd.setEmdDate(emd_date);
                vendorEmd.setDraweeBank(emd_drawee_bank);
                vendorEmd.setAttachment(emd_attach);
                vendorEmd.setCashCheque(cash_cheque);
                vendorEmd.setChequeNo(emd_cheque_no);
                vendorEmdService.create(vendorEmd);
            } else {
                vendorEmdService.updateVendorRefNo(refNo, username, emd, emd_date, emd_drawee_bank, emd_attach, cash_cheque, emd_cheque_no);
            }
        }

        //fee
        if (doc_cost != "0" && tender_phase == 2) {
            String fee_date = request.getParameter("fee_date");
            String fee_drawee_bank = request.getParameter("fee_drawee_bank");
            String fee_cheque_no = request.getParameter("fee_cheque_no");

            String fee_attach = request.getParameter("fee_attach");
            if (fee_attach == null) {
                fee_attach = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("fee_attach");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + RefNo + File.separator + username + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    fee_attach = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            List vendorFee1 = vendorFeeService.readVendorRefNo(refNo, username);

            if (vendorFee1.isEmpty()) {
                VendorFee vendorFee = new VendorFee();
                vendorFee.setRefNo(refNo);
                vendorFee.setVendorCode(username);
                vendorFee.setFeeAmount(doc_cost);
                vendorFee.setFeeDate(fee_date);
                vendorFee.setDraweeBank(fee_drawee_bank);
                vendorFee.setAttachment(fee_attach);
                vendorFee.setChequeNo(fee_cheque_no);
                vendorFeeService.create(vendorFee);
            } else {
                vendorFeeService.updateVendorRefNo(refNo, username, doc_cost, fee_date, fee_drawee_bank, fee_attach, fee_cheque_no);
            }
        }

        //Technical details
        VendorTechnicalBid vendorTechnicalBid11 = vendorTechnicalBidService.readByVendorRefNo(refNo, username);

        int revise_bid_flag = vendorTechnicalBid11.getReviseBidFlag();
        int reviseVendorTechnicalBidIdtest = 0;

        int reviseVendorTechnicalBidId = 0;
        if (revise_bid_flag == 0) {

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            String technicalBidDeviation = request.getParameter("technicalBidDeviation");
            String technicalBidRemark = request.getParameter("technicalBidRemark");

            ReviseVendorTechnicalBid reviseVendorTechnicalBid = new ReviseVendorTechnicalBid();
            reviseVendorTechnicalBid.setRefNo(refNo);
            reviseVendorTechnicalBid.setVendorCode(username);
            reviseVendorTechnicalBid.setTechnicalDeviation(technicalBidDeviation);
            reviseVendorTechnicalBid.setTechnicalRemark(technicalBidRemark);
            reviseVendorTechnicalBid.setDateTime(formattedDate);
            reviseVendorTechnicalBidService.create(reviseVendorTechnicalBid);

            reviseVendorTechnicalBidId = reviseVendorTechnicalBid.getId();
            reviseVendorTechnicalBidIdtest = reviseVendorTechnicalBidId;

            String[] vendor_tech_desc = request.getParameterValues("vendor_tech_desc");
            String[] vendor_tech_remark = request.getParameterValues("vendor_tech_remark");
            String[] vendor_tech_comp = request.getParameterValues("vendor_tech_comp");
            String[] tech_sr_no = request.getParameterValues("tech_sr_no");
            String[] tech_item_code = request.getParameterValues("tech_item_code");
            String[] tech_uom = request.getParameterValues("tech_uom");
            String[] tech_qty = request.getParameterValues("tech_qty");
            String[] buyer_tech_response = request.getParameterValues("buyer_tech_response");
            String[] buyer_tech_remark = request.getParameterValues("buyer_tech_remark");

            int k1 = 0;
            int k2 = 0;
            int j = 0;
            try {
                for (int i = 0; i < vendor_tech_desc.length; i++) {
                    j++;
                    String techradion = request.getParameter("techradion" + j);
                    if (techradion == null) {
                        techradion = "";
                    }
                    if (techradion.equals("0")) {
                        k1++;
                    }
                    k2++;
                    String tech_vendor_remark = request.getParameter("tech_vendor_remark" + j);
                    if (tech_vendor_remark == null) {
                        tech_vendor_remark = "";
                    }

                    VendorTechnicalBidTech vendorTechnicalBidTech = new VendorTechnicalBidTech();
                    vendorTechnicalBidTech.setRefNo(refNo);
                    vendorTechnicalBidTech.setVendorCode(username);
                    vendorTechnicalBidTech.setDescription(vendor_tech_desc[i]);
                    vendorTechnicalBidTech.setDetails(vendor_tech_remark[i]);
                    vendorTechnicalBidTech.setAttachmentRequired(vendor_tech_comp[i]);
                    vendorTechnicalBidTech.setVendorResponse(Integer.parseInt(techradion));
                    vendorTechnicalBidTech.setRemark(tech_vendor_remark);
                    vendorTechnicalBidTech.setItemCode(tech_item_code[i]);
                    vendorTechnicalBidTech.setSrNo(tech_sr_no[i]);
                    vendorTechnicalBidTech.setUom(tech_uom[i]);
                    vendorTechnicalBidTech.setQty(tech_qty[i]);
                    vendorTechnicalBidTech.setBuyerResponse(Integer.parseInt(buyer_tech_response[i]));
                    vendorTechnicalBidTech.setBuyerRemark(buyer_tech_remark[i]);
                    vendorTechnicalBidTech.setReviseVendorTechnicalBidId(reviseVendorTechnicalBidId);
                    vendorTechnicalBidTechService.create(vendorTechnicalBidTech);

                }
            } catch (Exception e11) {
            }

            String[] vendor_terms_desc = request.getParameterValues("vendor_terms_desc");
            String[] vendor_terms_remark = request.getParameterValues("vendor_terms_remark");
            String[] vendor_terms_comp = request.getParameterValues("vendor_terms_comp");
            String[] terms_sr_no = request.getParameterValues("terms_sr_no");
            String[] terms_item_code = request.getParameterValues("terms_item_code");
            String[] terms_uom = request.getParameterValues("terms_uom");
            String[] terms_qty = request.getParameterValues("terms_qty");
            String[] buyer_terms_response = request.getParameterValues("buyer_terms_response");
            String[] buyer_terms_remark = request.getParameterValues("buyer_terms_remark");
            j = 0;
            try {
                for (int i = 0; i < vendor_terms_desc.length; i++) {
                    j++;
                    String termsradion = request.getParameter("termsradion" + j);
                    if (termsradion == null) {
                        termsradion = "";
                    }

                    if (termsradion.equals("0")) {
                        k1++;
                    }
                    k2++;

                    String terms_vendor_remark = request.getParameter("terms_vendor_remark" + j);
                    if (terms_vendor_remark == null) {
                        terms_vendor_remark = "";
                    }

                    VendorTechnicalBidTerms vendorTechnicalBidTerms = new VendorTechnicalBidTerms();
                    vendorTechnicalBidTerms.setRefNo(refNo);
                    vendorTechnicalBidTerms.setVendorCode(username);
                    vendorTechnicalBidTerms.setDescription(vendor_terms_desc[i]);
                    vendorTechnicalBidTerms.setDetails(vendor_terms_remark[i]);
                    vendorTechnicalBidTerms.setAttachmentRequired(vendor_terms_comp[i]);
                    vendorTechnicalBidTerms.setVendorResponse(Integer.parseInt(termsradion));
                    vendorTechnicalBidTerms.setRemark(terms_vendor_remark);
                    vendorTechnicalBidTerms.setItemCode(terms_item_code[i]);
                    vendorTechnicalBidTerms.setSrNo(terms_sr_no[i]);
                    vendorTechnicalBidTerms.setUom(terms_uom[i]);
                    vendorTechnicalBidTerms.setQty(terms_qty[i]);
                    vendorTechnicalBidTerms.setBuyerResponse(Integer.parseInt(buyer_terms_response[i]));
                    vendorTechnicalBidTerms.setBuyerRemark(buyer_terms_remark[i]);
                    vendorTechnicalBidTerms.setReviseVendorTechnicalBidId(reviseVendorTechnicalBidId);
                    vendorTechnicalBidTermsService.create(vendorTechnicalBidTerms);

                }
            } catch (Exception e11) {
            }

            double percentage = k1 * 100 / k2;
            vendorTechnicalBid11.setTechPercentage(percentage + "");

        }
        String technicalBidDeviation = request.getParameter("technicalBidDeviation");
        String technicalBidRemark = request.getParameter("technicalBidRemark");

        List vendorTechnicalBid1 = vendorTechnicalBidService.readVendorRefNo(refNo, username);

        if (vendorTechnicalBid1.isEmpty()) {
            VendorTechnicalBid vendorTechnicalBid = new VendorTechnicalBid();
            vendorTechnicalBid.setRefNo(refNo);
            vendorTechnicalBid.setVendorCode(username);
            vendorTechnicalBid.setTechnicalDeviation(technicalBidDeviation);
            vendorTechnicalBid.setTechnicalRemark(technicalBidRemark);
            vendorTechnicalBidService.create(vendorTechnicalBid);
        } else {
            vendorTechnicalBidService.updateVendorRefNo(refNo, username, technicalBidDeviation, technicalBidRemark);
        }

        // technical attachent attachment
        String[] tech_attachment_desc = request.getParameterValues("tech_attachment_desc");
        String[] tech_attachment_comp = request.getParameterValues("tech_attachment_comp");
        String[] remark = request.getParameterValues("remarks");
        String[] remark1 = request.getParameterValues("remark1");
        String[] ids = request.getParameterValues("ids");
        int j = 0;
        try {
            for (int i = 0; i < tech_attachment_desc.length; i++) {
                j++;
                String vender_response = request.getParameter("documentYes" + j);
                String buyer_response = request.getParameter("buyerAccept" + j);
                String tech_attachment = request.getParameter("tech_attachment" + j);
                if (tech_attachment == null) {
                    tech_attachment = "";
                }

                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

                MultipartFile multipartFile = multipartRequest.getFile("tech_attachment" + j);
                if (multipartFile != null && multipartFile.getSize() > 0) {
                    try {
                        String fileLocationURL = getServletContext().getRealPath("/")
                                + File.separator + "StorageYard" + File.separator + "Tender"
                                + File.separator + RefNo + File.separator + username + File.separator;
                        File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                        tech_attachment = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                        multipartFile.transferTo(photoFile);
                        //    vendorInformation.setTermsConditionFile(photoFile+"");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                List vendorTechnicalBidAttachment1 = vendorTechnicalBidAttachmentService.readVendorRefNo(refNo, username, tech_attachment_desc[i]);

                if (vendorTechnicalBidAttachment1.isEmpty()) {
                    VendorTechnicalBidAttachment vendorTechnicalBidAttachment = new VendorTechnicalBidAttachment();
                    vendorTechnicalBidAttachment.setRefNo(refNo);
                    vendorTechnicalBidAttachment.setVendorCode(username);
                    vendorTechnicalBidAttachment.setDescription(tech_attachment_desc[i]);
                    vendorTechnicalBidAttachment.setAttachmentRequired(tech_attachment_comp[i]);
                    vendorTechnicalBidAttachment.setAttachment(tech_attachment);
                    vendorTechnicalBidAttachmentService.create(vendorTechnicalBidAttachment);
                } else {
                    if (tech_attachment != "") {
                        vendorTechnicalBidAttachmentService.updateVendorRefNo(refNo, username, tech_attachment_desc[i], tech_attachment_comp[i], tech_attachment);
                    }

                    VendorTechnicalBidAttachment vendorTechnicalBidAttachment2 = vendorTechnicalBidAttachmentService.readById(Integer.parseInt(ids[i]));
                    vendorTechnicalBidAttachment2.setVenderResponse(Integer.parseInt(vender_response));
                    vendorTechnicalBidAttachment2.setRemark(remark[i]);
                    vendorTechnicalBidAttachment2.setBuyerResponse(Integer.parseInt(buyer_response));
                    vendorTechnicalBidAttachment2.setBuyerRemark(remark1[i]);
                    vendorTechnicalBidAttachmentService.update(vendorTechnicalBidAttachment2);
                }

            }
        } catch (Exception e11) {
        }

        vendorTechnicalBid11.setReviseBidFlag(1);
        vendorTechnicalBidService.update(vendorTechnicalBid11);

        //Get attachment of tender
        List generalDocs = tenderGeneralDocService.readByRefNo(refNo);
        List additionalDocs = tenderAdditionalDocService.readByRefNo(refNo);
        List technicalDocs = tenderTechnicalDocService.readByRefNo(refNo);
        List tenderVendorDocs = tenderVendorDocService.readByRefNo(refNo, username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, username);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, username);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        //get Offer etails
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        String offer_no = vendorTenderBid.getOfferNo();
        String offer_date = vendorTenderBid.getOfferDate();
        String contact_person = vendorTenderBid.getContactPerson();
        String contact_no = vendorTenderBid.getContactNo();
        String contact_email = vendorTenderBid.getConactEmail();
        String gst_no = vendorTenderBid.getGstNo();
        int rivision = vendorTenderBid.getRevision();

        if (contact_email == null) {
            contact_email = "";
        }
        TenderVendor tenderVendor = tenderVendorService.readByRefVendor1(refNo, username);
        if (contact_email.equals("")) {
            contact_email = tenderVendor.getEmailId();
        }

        mv.getModelMap().put("rivision", rivision);

        mv.getModelMap().put("offer_no", offer_no);
        mv.getModelMap().put("offer_date", offer_date);
        mv.getModelMap().put("contact_person", contact_person);
        mv.getModelMap().put("contact_no", contact_no);
        mv.getModelMap().put("contact_email", contact_email);
        mv.getModelMap().put("gst_no", gst_no);

        VendorMaster vendorMaster = vendorMasterService.read(username);

        TenderMaster tenderMaster11 = tenderMasterService.readRefNo(refNo);
        String location = tenderMaster11.getLocation();
        String title = tenderMaster11.getTitle();

        String subject = "";
        String msg = "";
        String mail_from = "";
        String mail_to = vendorMaster.getVendorEmailID();

        String mail_to1[] = mail_to.split(",");

        for (int ml = 0; ml < mail_to1.length; ml++) {
            mail_to = mail_to1[ml];

            EmailTemplate emailTemplate = emailTemplateService.readById(25);

            subject = emailTemplate.getSubject();
            msg = emailTemplate.getBodytext();

            subject = subject.replaceAll("\\{location\\}", location.toUpperCase());

            msg = msg.replaceAll("\\{tender_title\\}", title.toUpperCase());
            msg = msg.replaceAll("\\{ref_no\\}", refNo);

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject, msg);
        }

        //---------------------------------
        //vendor attachmnt -------------------------------------------
        String attachment_type = "1";
        List vendorAttachment = vendorAttachmentService.readAttachment(refNo, username, attachment_type);

        mv.getModelMap().put("vendorAttachment", vendorAttachment);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("doc_cost", doc_cost);

        mv.getModelMap().put("generalDocs", generalDocs);
        mv.getModelMap().put("additionalDocs", additionalDocs);
        mv.getModelMap().put("technicalDocs", technicalDocs);
        mv.getModelMap().put("tenderVendorDocs", tenderVendorDocs);

        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);

        String prDocAttachment = request.getParameter("attachmentCount");
        String itemDetailsSize = request.getParameter("itemDetailsSize");
        String itemDetailsForServiceSize = request.getParameter("itemDetailsForServiceSize");

        List<VendorTechnicalBidTech> list4 = vendorTechnicalBidTechService.readByReviseVendorBid(refNo, username, reviseVendorTechnicalBidIdtest);
        List<VendorTechnicalBidTerms> list5 = vendorTechnicalBidTermsService.readByReviseVendorBid(refNo, username, reviseVendorTechnicalBidIdtest);
        List<VendorTechnicalBidAttachment> list6 = vendorTechnicalBidAttachmentService.readByVendorRefNo(refNo, username);

//        int prDocAttachmentCount = list6.size();
        int itemDetailsCount = list4.size();
        int itemDetailsServiceCount = list5.size();

//        itemDetailsCount && itemDetailsServiceCount && prDocAttachmentCount
//        boolean isPrDocAttachmentValid = (Integer.parseInt(prDocAttachment) == prDocAttachmentCount);
        boolean isItemDetailsValid = (Integer.parseInt(itemDetailsSize) == itemDetailsCount);
        boolean isServiceDetailsValid = (Integer.parseInt(itemDetailsForServiceSize) == itemDetailsServiceCount);

        if (isItemDetailsValid && isServiceDetailsValid) {
            request.setAttribute("successMessage", "Information: Bid Submited successfully");
            mv.setViewName("redirect:vendor.htm?act=liveTender");
        } else {

            for (VendorTechnicalBidTech venTechBid : list4) {
                int id = venTechBid.getId();
                vendorTechnicalBidTechService.delete(id);
            }

            for (VendorTechnicalBidTerms venTechBidTerms : list5) {
                int id = venTechBidTerms.getId();
                vendorTechnicalBidTermsService.delete(id);
            }

            reviseVendorTechnicalBidService.delete(reviseVendorTechnicalBidIdtest);

            VendorTechnicalBid vendorTechnicalBid112 = vendorTechnicalBidService.readByVendorRefNo(refNo, username);

            vendorTechnicalBid112.setReviseBidFlag(0);
            vendorTechnicalBidService.update(vendorTechnicalBid112);

//              for(VendorTechnicalBidAttachment venTechBidAttachment: list6){
//                int id = venTechBidAttachment.getId();
//                vendorTechnicalBidAttachmentService.delete(id);
//            }
            request.setAttribute("failureMessage",
                    "Information: Data not submitted properly. Please try again.");
            mv.setViewName("redirect:vendor.htm?act=bidTenderForTechnicalReviseBid&refNo=" + refNo);
        }

        //mv.setViewName("Vendor/BidTenderForOffer");
        return mv;
    }

    public ModelAndView techBidAccept(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        //String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String vendorCode = request.getParameter("vendorCode");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        username = vendorCode;

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();
        int id = tenderMaster.getId();

        List reviseVendorTechnicalBid = reviseVendorTechnicalBidService.readByVendorRefNo(refNo, username);

        int revise_id = 0;
        for (Object o : reviseVendorTechnicalBid) {
            ReviseVendorTechnicalBid rvtb = (ReviseVendorTechnicalBid) o;
            revise_id = rvtb.getId();
            break;
        }

        // technical bid
        String[] vendor_tech_desc = request.getParameterValues("vendor_tech_desc");
        String[] vendor_tech_remark = request.getParameterValues("vendor_tech_remark");
        String[] vendor_tech_comp = request.getParameterValues("vendor_tech_comp");
        String[] tech_sr_no = request.getParameterValues("tech_sr_no");
        String[] tech_item_code = request.getParameterValues("tech_item_code");
        String[] tech_uom = request.getParameterValues("tech_uom");
        String[] tech_qty = request.getParameterValues("tech_qty");
        int j = 0;
        try {
            for (int i = 0; i < vendor_tech_desc.length; i++) {
                j++;
                String techradion = request.getParameter("techradion" + j);
                if (techradion == null) {
                    techradion = "";
                }
                String tech_vendor_remark = request.getParameter("tech_vendor_remark" + j);
                if (tech_vendor_remark == null) {
                    tech_vendor_remark = "";
                }

                vendorTechnicalBidTechService.updateAdminVendorRefNo(refNo, username, vendor_tech_desc[i], Integer.parseInt(techradion), tech_vendor_remark, revise_id);

            }
        } catch (Exception e11) {
        }
        // terms & Condition bid

        String[] vendor_terms_desc = request.getParameterValues("vendor_terms_desc");
        String[] vendor_terms_remark = request.getParameterValues("vendor_terms_remark");
        String[] vendor_terms_comp = request.getParameterValues("vendor_terms_comp");
        String[] terms_sr_no = request.getParameterValues("terms_sr_no");
        String[] terms_item_code = request.getParameterValues("terms_item_code");
        String[] terms_uom = request.getParameterValues("terms_uom");
        String[] terms_qty = request.getParameterValues("terms_qty");
        j = 0;
        try {
            for (int i = 0; i < vendor_terms_desc.length; i++) {
                j++;
                String termsradion = request.getParameter("termsradion" + j);
                if (termsradion == null) {
                    termsradion = "";
                }
                String terms_vendor_remark = request.getParameter("terms_vendor_remark" + j);
                if (terms_vendor_remark == null) {
                    terms_vendor_remark = "";
                }

                List vendorTechnicalBidTerms1 = vendorTechnicalBidTermsService.readVendorRefNo(refNo, username, vendor_terms_desc[i]);

                vendorTechnicalBidTermsService.updateAdminVendorRefNo(refNo, username, vendor_terms_desc[i], Integer.parseInt(termsradion), terms_vendor_remark, revise_id);

            }
        } catch (Exception e11) {
        }
        List vendorTechnicalBidAttachment = vendorTechnicalBidAttachmentService.readByVendorRefNo(refNo, username);

        int a = 1;

        for (Object o : vendorTechnicalBidAttachment) {
            try {
                String buyerAccept = request.getParameter("buyerAccept" + a);
                String buyerRemark = request.getParameter("buyerRemark" + a);
                VendorTechnicalBidAttachment vendorTechnicalBidAttachment1 = (VendorTechnicalBidAttachment) o;
                Integer ids = vendorTechnicalBidAttachment1.getId();
                VendorTechnicalBidAttachment vendorTechnicalBidAttachment2 = vendorTechnicalBidAttachmentService.readById(ids);
                vendorTechnicalBidAttachment2.setBuyerResponse(Integer.parseInt(buyerAccept));
                vendorTechnicalBidAttachment2.setBuyerRemark(buyerRemark);
                vendorTechnicalBidAttachmentService.update(vendorTechnicalBidAttachment2);
                a++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        VendorTechnicalBid vendorTechnicalBid = vendorTechnicalBidService.readByVendorRefNo(refNo, username);
        vendorTechnicalBid.setReviseBidFlag(2);
        vendorTechnicalBidService.update(vendorTechnicalBid);

        mv.setViewName("redirect:tenderMaster.htm?act=techBidOpenView&id=" + id);
        //mv.setViewName("Vendor/BidTenderForOffer");
        return mv;
    }

    public ModelAndView techBidSendToVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String refNo = request.getParameter("refNo");
        String vendorCode = request.getParameter("vendorCode");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        username = vendorCode;

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + username;
        f1 = new File(path);
        bool = f1.mkdir();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);
        int tender_phase = tenderMaster.getTenderPhase();
        int id = tenderMaster.getId();

        List reviseVendorTechnicalBid = reviseVendorTechnicalBidService.readByVendorRefNo(refNo, username);

        int revise_id = 0;
        for (Object o : reviseVendorTechnicalBid) {
            ReviseVendorTechnicalBid rvtb = (ReviseVendorTechnicalBid) o;
            revise_id = rvtb.getId();
            break;
        }

        String[] vendor_tech_desc = request.getParameterValues("vendor_tech_desc");
        String[] vendor_tech_remark = request.getParameterValues("vendor_tech_remark");
        String[] vendor_tech_comp = request.getParameterValues("vendor_tech_comp");
        String[] tech_sr_no = request.getParameterValues("tech_sr_no");
        String[] tech_item_code = request.getParameterValues("tech_item_code");
        String[] tech_uom = request.getParameterValues("tech_uom");
        String[] tech_qty = request.getParameterValues("tech_qty");
        int j = 0;
        try {
            for (int i = 0; i < vendor_tech_desc.length; i++) {
                j++;
                String techradion = request.getParameter("techradion" + j);
                if (techradion == null) {
                    techradion = "";
                }
                String tech_vendor_remark = request.getParameter("tech_vendor_remark" + j);
                if (tech_vendor_remark == null) {
                    tech_vendor_remark = "";
                }

                vendorTechnicalBidTechService.updateAdminVendorRefNo(refNo, username, vendor_tech_desc[i], Integer.parseInt(techradion), tech_vendor_remark, revise_id);

            }
        } catch (Exception e11) {
        }

        String[] vendor_terms_desc = request.getParameterValues("vendor_terms_desc");
        String[] vendor_terms_remark = request.getParameterValues("vendor_terms_remark");
        String[] vendor_terms_comp = request.getParameterValues("vendor_terms_comp");
        String[] terms_sr_no = request.getParameterValues("terms_sr_no");
        String[] terms_item_code = request.getParameterValues("terms_item_code");
        String[] terms_uom = request.getParameterValues("terms_uom");
        String[] terms_qty = request.getParameterValues("terms_qty");
        j = 0;
        try {
            for (int i = 0; i < vendor_terms_desc.length; i++) {
                j++;
                String termsradion = request.getParameter("termsradion" + j);
                if (termsradion == null) {
                    termsradion = "";
                }
                String terms_vendor_remark = request.getParameter("terms_vendor_remark" + j);
                if (terms_vendor_remark == null) {
                    terms_vendor_remark = "";
                }

                List vendorTechnicalBidTerms1 = vendorTechnicalBidTermsService.readVendorRefNo(refNo, username, vendor_terms_desc[i]);

                vendorTechnicalBidTermsService.updateAdminVendorRefNo(refNo, username, vendor_terms_desc[i], Integer.parseInt(termsradion), terms_vendor_remark, revise_id);

            }
        } catch (Exception e11) {
        }
        List vendorTechnicalBidAttachment = vendorTechnicalBidAttachmentService.readByVendorRefNo(refNo, username);

        int a = 1;

        for (Object o : vendorTechnicalBidAttachment) {
            try {
                String buyerAccept = request.getParameter("buyerAccept" + a);
                String buyerRemark = request.getParameter("buyerRemark" + a);
                VendorTechnicalBidAttachment vendorTechnicalBidAttachment1 = (VendorTechnicalBidAttachment) o;
                Integer ids = vendorTechnicalBidAttachment1.getId();
                VendorTechnicalBidAttachment vendorTechnicalBidAttachment2 = vendorTechnicalBidAttachmentService.readById(ids);
                vendorTechnicalBidAttachment2.setBuyerResponse(Integer.parseInt(buyerAccept));
                vendorTechnicalBidAttachment2.setBuyerRemark(buyerRemark);
                vendorTechnicalBidAttachmentService.update(vendorTechnicalBidAttachment2);
                a++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        VendorTechnicalBid vendorTechnicalBid = vendorTechnicalBidService.readByVendorRefNo(refNo, username);
        vendorTechnicalBid.setReviseBidFlag(0);
        vendorTechnicalBid.setBidApproveFlag("0");
        vendorTechnicalBidService.update(vendorTechnicalBid);

        mv.setViewName("redirect:tenderMaster.htm?act=techBidOpenView&id=" + id);
        return mv;
    }

    public ModelAndView vendorAttach(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String refNo = request.getParameter("refNo");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String attachment_type = "1";
        List vendorAttachment = vendorAttachmentService.readAttachment(refNo, vendor_code, attachment_type);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("vendorAttachment", vendorAttachment);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.setViewName("Vendor/AjaxVendorAttach");
        return mv;
    }

    public ModelAndView vendorAttachSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String RefNo = refNo.replace("/", "");

        String vendor_code = request.getParameter("vendor_code");

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + RefNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + RefNo + File.separator + vendor_code;
        f1 = new File(path);
        bool = f1.mkdir();

        //upload document
        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile" + i);
            if (generalfile == null) {
                generalfile = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("generalfile" + i);
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + RefNo + File.separator + vendor_code + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (generalfile.equals("")) {
            } else {
                VendorAttachment vendorAttachment = new VendorAttachment();
                vendorAttachment.setRefNo(refNo);
                vendorAttachment.setVendorCode(vendor_code);
                vendorAttachment.setAttachment(generalfile);
                vendorAttachment.setAttachmentType(1);
                vendorAttachmentService.create(vendorAttachment);

            }
        }

        String attachment_type = "1";
        List vendorAttachment = vendorAttachmentService.readAttachment(refNo, vendor_code, attachment_type);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("vendorAttachment", vendorAttachment);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.setViewName("Vendor/AjaxVendorAttach");
        return mv;
    }

    public ModelAndView vendorAttachDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("refNo");
        String vendor_code = request.getParameter("vendor_code");
        String id = request.getParameter("id");

        //delete code
        vendorAttachmentService.delete(Integer.parseInt(id));

        String attachment_type = "1";
        List vendorAttachment = vendorAttachmentService.readAttachment(refNo, vendor_code, attachment_type);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("vendorAttachment", vendorAttachment);
        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.setViewName("Vendor/AjaxVendorAttach");
        return mv;
    }

    public ModelAndView vendorRegistrationValidationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String stno = request.getParameter("stno");
        String vatno = request.getParameter("vatno");
        String panno = request.getParameter("panno");

        //upload document
        List vendorInfo = vendorInfoService.readData(stno, vatno, panno);

        if (vendorInfo.isEmpty()) {
            mv.getModelMap().put("stno", stno);
            mv.getModelMap().put("vatno", vatno);
            mv.getModelMap().put("panno", panno);

            mv.setViewName("Vendor/VendorRegistration");
            return mv;
        } else {
            mv.getModelMap().put("stno", stno);
            mv.getModelMap().put("vatno", vatno);
            mv.getModelMap().put("panno", panno);

            request.setAttribute("failureMessage",
                    "Information: Vendor alredy available. Please try again");

            mv.setViewName("Vendor/VendorRegistrationValidation");
            return mv;
        }

        //mv.setViewName("Vendor/VendorRegistrationValidation");
        //return mv;
    }

    public ModelAndView vendorRegistrationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String fname = request.getParameter("fname");
        String sfirm = request.getParameter("sfirm");
        String rdate = request.getParameter("rdate");
        String vrdate = request.getParameter("vrdate");
        String cinno = request.getParameter("cinno");
        String address = request.getParameter("address");
        String pinno = request.getParameter("pinno");
        String cperson = request.getParameter("cperson");
        String officeno = request.getParameter("officeno");
        String resino = request.getParameter("resino");
        String mobno = request.getParameter("mobno");
        String faxno = request.getParameter("faxno");
        String email1 = request.getParameter("email1");
        String email2 = request.getParameter("email2");
        String salesno = request.getParameter("salesno");
        String stno = request.getParameter("stno");
        String cstno = request.getParameter("cstno");
        String vatno = request.getParameter("vatno");
        String panno = request.getParameter("panno");
        String tenderno = request.getParameter("tenderno");

        //upload document
        List vendorInfo = vendorInfoService.readData(stno, vatno, panno);

        if (vendorInfo.isEmpty()) {
            VendorInfo vendorInfo1 = new VendorInfo();
            vendorInfo1.setFname(fname);
            vendorInfo1.setSfirm(sfirm);
            vendorInfo1.setRdate(rdate);
            vendorInfo1.setLocation(vrdate);
            vendorInfo1.setCinno(cinno);
            vendorInfo1.setAddr(address);
            vendorInfo1.setPinno(pinno);
            vendorInfo1.setCperson(cperson);
            vendorInfo1.setOfficeno(officeno);
            vendorInfo1.setResino(resino);
            vendorInfo1.setMobno(mobno);
            vendorInfo1.setFaxno(faxno);
            vendorInfo1.setEmailid(email1);
            vendorInfo1.setAltemailid(email2);
            vendorInfo1.setStno(salesno);
            vendorInfo1.setServicetaxno(stno);
            vendorInfo1.setCstno(cstno);
            vendorInfo1.setVatno(vatno);
            vendorInfo1.setPanno(panno);
            vendorInfo1.setTno(tenderno);
            vendorInfo1.setFlag(0);
            vendorInfoService.create(vendorInfo1);

            VendorInfo vendorInfo2 = vendorInfoService.readData1(stno, vatno, panno);

            int id = vendorInfo2.getId();

            String path = getServletContext().getRealPath("/")
                    + File.separator + "StorageYard" + File.separator + "Vendor"
                    + File.separator + id;
            File f1 = new File(path);
            boolean bool = f1.mkdir();

            String attachcinno = request.getParameter("attachcinno");
            if (attachcinno == null) {
                attachcinno = "";
            }
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("attachcinno");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Vendor"
                            + File.separator + id + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    attachcinno = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            String attachsalesno = request.getParameter("attachsalesno");
            if (attachsalesno == null) {
                attachsalesno = "";
            }

            multipartFile = multipartRequest.getFile("attachsalesno");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Vendor"
                            + File.separator + id + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    attachsalesno = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            String attachstno = request.getParameter("attachstno");
            if (attachstno == null) {
                attachstno = "";
            }

            multipartFile = multipartRequest.getFile("attachstno");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Vendor"
                            + File.separator + id + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    attachstno = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            String attachcstno = request.getParameter("attachcstno");
            if (attachcstno == null) {
                attachcstno = "";
            }

            multipartFile = multipartRequest.getFile("attachcstno");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Vendor"
                            + File.separator + id + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    attachcstno = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            String attachvatno = request.getParameter("attachvatno");
            if (attachvatno == null) {
                attachvatno = "";
            }

            multipartFile = multipartRequest.getFile("attachvatno");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Vendor"
                            + File.separator + id + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    attachvatno = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            String attachpanno = request.getParameter("attachpanno");
            if (attachpanno == null) {
                attachpanno = "";
            }

            multipartFile = multipartRequest.getFile("attachpanno");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Vendor"
                            + File.separator + id + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    attachpanno = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            String attachvendorprofile = request.getParameter("attachvendorprofile");
            if (attachvendorprofile == null) {
                attachvendorprofile = "";
            }

            multipartFile = multipartRequest.getFile("attachvendorprofile");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Vendor"
                            + File.separator + id + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    attachvendorprofile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            vendorInfo2.setCinnoFilePath(attachcinno);
            vendorInfo2.setStnoFilePath(attachsalesno);
            vendorInfo2.setServicetaxnoFilePath(attachstno);
            vendorInfo2.setCstnoFilePath(attachcstno);
            vendorInfo2.setVatnoFilePath(attachvatno);
            vendorInfo2.setPanFilePath(attachpanno);
            vendorInfo2.setVendorFilePath(attachvendorprofile);
            vendorInfoService.update(vendorInfo2);

            mv.getModelMap().put("stno", stno);
            mv.getModelMap().put("vatno", vatno);
            mv.getModelMap().put("panno", panno);

            request.setAttribute("successMessage",
                    "Information: Vendor Registration successfully");

            mv.setViewName("Vendor/VendorRegistrationSuccess");
            return mv;
        } else {
            mv.getModelMap().put("stno", stno);
            mv.getModelMap().put("vatno", vatno);
            mv.getModelMap().put("panno", panno);

            request.setAttribute("failureMessage",
                    "Information: Problem in vendor registration. Please try again");

            mv.setViewName("Vendor/VendorRegistrationValidation");
            return mv;
        }

        //mv.setViewName("User/Login");
        //return mv;
    }

    public ModelAndView regretTender(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("username", username);
        mv.getModelMap().put("tender_no", tender_no);

        mv.setViewName("Vendor/RegretTender");
        return mv;
    }

    public ModelAndView regretTenderSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");
        String remark = request.getParameter("remark");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List tenderRegret = tenderRegretService.readByTenderNo(tender_no, username);

        if (tenderRegret.isEmpty()) {
            TenderRegret tenderRegret1 = new TenderRegret();
            tenderRegret1.setRefNo(tender_no);
            tenderRegret1.setRemark(remark);
            tenderRegret1.setVendorCode(username);
            tenderRegret1.setFlag(1);
            tenderRegretService.create(tenderRegret1);
        } else {
            tenderRegretService.updateTenderRegret(tender_no, username, remark);
        }

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("username", username);
        mv.getModelMap().put("tender_no", tender_no);

        request.setAttribute("successMessage",
                "Information: Vendor Regret successfully");

        mv.setViewName("Vendor/RegretTender");
        return mv;
    }

    public ModelAndView bidTender(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        tenderRegretService.updateTenderBid(tender_no, username);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("username", username);
        mv.getModelMap().put("tender_no", tender_no);

        mv.setViewName("forward:vendor.htm?act=liveTender");
        //mv.setViewName("Vendor/RegretTender");
        return mv;
    }

    public ModelAndView tenderVendorCommunication(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List commMaster = commMasterService.readTenderVendorComm(tender_no, username);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("commMaster", commMaster);
        mv.setViewName("Vendor/AjaxTenderVendorCommunication");
        return mv;
    }

    public ModelAndView tenderVendorCommunicationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tender_no = request.getParameter("tender_no");
        TenderMaster tenderMaster = tenderMasterService.readRefNo(tender_no);
        String tender_admin = tenderMaster.getTenderAdmin();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String subject = request.getParameter("subject");
        String msg = request.getParameter("msg");

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        CommMaster commMaster = new CommMaster();
        commMaster.setVendorCode(username);
        commMaster.setTenderNo(tender_no);
        commMaster.setSubject(subject);
        commMaster.setMsg(msg);
        commMaster.setUserId(tender_admin);
        commMaster.setMsgdatetime(formattedDate);
        commMaster.setIsread("0");
        commMaster.setIdAdmin("vendor");
        commMasterService.create(commMaster);

        EmployeeMaster employeeMaster = employeeMasterService.readUser(tender_admin);

        EmailTemplate emailTemplate = emailTemplateService.readById(22);

        String subject1 = "";
        String msg1 = "";
        String mail_from = "";
        String mail_to = employeeMaster.getEmailId();

        subject1 = emailTemplate.getSubject();
        msg1 = emailTemplate.getBodytext();

        msg1 = msg1.replaceAll("\\{tender_title\\}", tenderMaster.getTitle());
        msg1 = msg1.replaceAll("\\{ref_no\\}", tender_no);
        msg1 = msg1.replaceAll("\\{start_date\\}", tenderMaster.getAnnounceDate());
        msg1 = msg1.replaceAll("\\{end_date\\}", tenderMaster.getSubmitLastdate());

        SendMail s = new SendMail();
        s.sendMail(mail_from, mail_to, subject1, msg1);

        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            List<MultipartFile> files = multipartRequest.getFiles("generalfile1");

            if (files != null && !files.isEmpty()) {
                for (MultipartFile file : files) {
                    if (file.isEmpty()) {
                        continue;
                    }

                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + tender_no + File.separator;

                    File directory = new File(fileLocationURL);
                    if (!directory.exists() && !directory.mkdirs()) {
                        throw new IOException("Failed to create directory: " + fileLocationURL);
                    }

                    String sanitizedFileName = file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "")
                            .replaceAll("[ &+]", "");

                    File destinationFile = new File(directory, sanitizedFileName);
                    file.transferTo(destinationFile);

                    CommMasterAttachment attachment = new CommMasterAttachment();
                    attachment.setAttachment(sanitizedFileName);
                    attachment.setTenderNo(tender_no);
                    attachment.setVendorCode(username);
                    attachment.setSubject(subject);

                    commMasterAttachmentService.create(attachment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        List commMaster1 = commMasterService.readTenderVendorComm(tender_no, username);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("commMaster", commMaster1);

        mv.setViewName("Vendor/AjaxTenderVendorCommunication");
        return mv;
    }

    public ModelAndView tenderVendorCommunicationCreateSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tender_no = request.getParameter("tender_no");
        TenderMaster tenderMaster = tenderMasterService.readRefNo(tender_no);
        String tender_admin = tenderMaster.getTenderAdmin();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String subject = request.getParameter("subject");
        String msg = request.getParameter("msg");

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        CommMaster commMaster = new CommMaster();
        commMaster.setVendorCode(username);
        commMaster.setTenderNo(tender_no);
        commMaster.setSubject(subject);
        commMaster.setMsg(msg);
        commMaster.setUserId(tender_admin);
        commMaster.setMsgdatetime(formattedDate);
        commMaster.setIsread("0");
        commMaster.setIdAdmin("vendor");
        commMasterService.create(commMaster);

        EmployeeMaster employeeMaster = employeeMasterService.readUser(tender_admin);

        EmailTemplate emailTemplate = emailTemplateService.readById(22);

        String subject1 = "";
        String msg1 = "";
        String mail_from = "";
        String mail_to = employeeMaster.getEmailId();

        subject1 = emailTemplate.getSubject();
        msg1 = emailTemplate.getBodytext();

        msg1 = msg1.replaceAll("\\{tender_title\\}", tenderMaster.getTitle());
        msg1 = msg1.replaceAll("\\{ref_no\\}", tender_no);
        msg1 = msg1.replaceAll("\\{start_date\\}", tenderMaster.getAnnounceDate());
        msg1 = msg1.replaceAll("\\{end_date\\}", tenderMaster.getSubmitLastdate());

        SendMail s = new SendMail();
        s.sendMail(mail_from, mail_to, subject1, msg1);

        try {
            MultipartHttpServletRequest multipartRequest2 = (MultipartHttpServletRequest) request;

            List<MultipartFile> files = multipartRequest2.getFiles("vendorCreateAttachment");

            if (files != null && !files.isEmpty()) {
                for (MultipartFile file : files) {
                    if (file.isEmpty()) {
                        continue;
                    }

                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + tender_no + File.separator;

                    File directory = new File(fileLocationURL);
                    if (!directory.exists() && !directory.mkdirs()) {
                        throw new IOException("Failed to create directory: " + fileLocationURL);
                    }

                    String sanitizedFileName = file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "")
                            .replaceAll("[ &+]", "");

                    File destinationFile = new File(directory, sanitizedFileName);
                    file.transferTo(destinationFile);

                    CommMasterAttachment attachment = new CommMasterAttachment();
                    attachment.setAttachment(sanitizedFileName);
                    attachment.setTenderNo(tender_no);
                    attachment.setVendorCode(username);
                    attachment.setSubject(subject);

                    commMasterAttachmentService.create(attachment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        List commMaster1 = commMasterService.readTenderVendorComm(tender_no, username);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("commMaster", commMaster1);

        mv.setViewName("Vendor/AjaxTenderVendorCommunication");
        return mv;
    }

    public ModelAndView tenderVendorCommunicationView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        CommMaster commMaster = commMasterService.readById(Integer.parseInt(id));

        String subject = commMaster.getSubject();
        String msg = commMaster.getMsg();
        String user_to = commMaster.getUserId();

        if (username.equals(user_to)) {
            commMasterService.updateRead(id);
        }

        List commMasterAttachment = commMasterAttachmentService.readByCommId(tender_no, username, subject);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("subject", subject);
        mv.getModelMap().put("msg", msg);
        mv.getModelMap().put("commMasterAttachment", commMasterAttachment);

        mv.setViewName("Vendor/AjaxTenderVendorCommunicationView");
        return mv;
    }

    public ModelAndView tenderVendorCommunicationReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        CommMaster commMaster = commMasterService.readById(Integer.parseInt(id));

        String subject = commMaster.getSubject();
        String msg = commMaster.getMsg();

        List commMasterAttachment = commMasterAttachmentService.readByCommId(tender_no, username, subject);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("subject", subject);
        mv.getModelMap().put("msg", msg);
        mv.getModelMap().put("commMasterAttachment", commMasterAttachment);

        mv.setViewName("Vendor/AjaxTenderVendorCommunicationReply");
        return mv;
    }

    public ModelAndView tenderAdminCommunication(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List commMaster = commMasterService.readTenderVendorComm(tender_no, username);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("commMaster", commMaster);
        mv.setViewName("Vendor/AjaxTenderAdminCommunication");
        return mv;
    }

    public ModelAndView tenderAdminCommunicationView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        CommMaster commMaster = commMasterService.readById(Integer.parseInt(id));

        String subject = commMaster.getSubject();
        String msg = commMaster.getMsg();
        String user_to = commMaster.getUserId();
        String vendor_code = commMaster.getVendorCode();

        if (username.equals(user_to)) {
            // CommMaster commMaster1 = new CommMaster();
            // commMaster1.setId(Integer.parseInt(id));
            // commMaster1.setIsread("1");
            commMasterService.updateRead(id);
        }

        List commMasterAttachment = commMasterAttachmentService.readByCommId(tender_no, username, subject);

        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("subject", subject);
        mv.getModelMap().put("msg", msg);
        mv.getModelMap().put("commMasterAttachment", commMasterAttachment);

        mv.setViewName("Vendor/AjaxTenderAdminCommunicationView");
        return mv;
    }

    public ModelAndView tenderAdminCommunicationReply(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");
        String vendor_code = request.getParameter("vendor_code");
        String id = request.getParameter("id");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        CommMaster commMaster = commMasterService.readById(Integer.parseInt(id));

        String subject = commMaster.getSubject();
        String msg = commMaster.getMsg();

        List commMasterAttachment = commMasterAttachmentService.readByCommId(tender_no, username, subject);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("id", id);
        mv.getModelMap().put("subject", subject);
        mv.getModelMap().put("msg", msg);
        mv.getModelMap().put("commMasterAttachment", commMasterAttachment);

        mv.setViewName("Vendor/AjaxTenderAdminCommunicationReply");
        return mv;
    }

    public ModelAndView tenderAdminCommunicationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tender_no = request.getParameter("tender_no");
        String vendor_code = request.getParameter("vendor_code");
        TenderMaster tenderMaster = tenderMasterService.readRefNo(tender_no);
        String tender_admin = tenderMaster.getTenderAdmin();

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String subject = request.getParameter("subject");
        String msg = request.getParameter("msg");
        String allvendor = request.getParameter("allvendor");
        if (allvendor == null) {
            allvendor = "";
        }

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        if (allvendor.equals("allvendor")) {
            List tenderVendor = tenderVendorService.readByRefNo(tender_no);

            for (Object o : tenderVendor) {
                TenderVendor tv = (TenderVendor) o;
                vendor_code = tv.getVendorCode();

                CommMaster commMaster = new CommMaster();
                commMaster.setVendorCode(username);
                commMaster.setTenderNo(tender_no);
                commMaster.setSubject(subject);
                commMaster.setMsg(msg);
                commMaster.setUserId(vendor_code);
                commMaster.setMsgdatetime(formattedDate);
                commMaster.setIsread("0");
                commMaster.setIdAdmin("admin");
                commMasterService.create(commMaster);

                EmailTemplate emailTemplate = emailTemplateService.readById(22);

                String subject1 = "";
                String msg1 = "";
                String mail_from = "";
                String mail_to = tv.getEmailId();

                subject1 = emailTemplate.getSubject();
                msg1 = emailTemplate.getBodytext();

                msg1 = msg1.replaceAll("\\{tender_title\\}", tenderMaster.getTitle());
                msg1 = msg1.replaceAll("\\{ref_no\\}", tender_no);
                msg1 = msg1.replaceAll("\\{start_date\\}", tenderMaster.getAnnounceDate());
                msg1 = msg1.replaceAll("\\{end_date\\}", tenderMaster.getSubmitLastdate());

                SendMail s = new SendMail();
                s.sendMail(mail_from, mail_to, subject1, msg1);

            }
        } else {
            CommMaster commMaster = new CommMaster();
            commMaster.setVendorCode(username);
            commMaster.setTenderNo(tender_no);
            commMaster.setSubject(subject);
            commMaster.setMsg(msg);
            commMaster.setUserId(vendor_code);
            commMaster.setMsgdatetime(formattedDate);
            commMaster.setIsread("0");
            commMaster.setIdAdmin("admin");
            commMasterService.create(commMaster);

            EmailTemplate emailTemplate = emailTemplateService.readById(22);

            VendorMaster vendorMaster = vendorMasterService.read(vendor_code);
            String subject1 = "";
            String msg1 = "";
            String mail_from = "";
            String mail_to = vendorMaster.getVendorEmailID();

            subject1 = emailTemplate.getSubject();
            msg1 = emailTemplate.getBodytext();

            msg1 = msg1.replaceAll("\\{tender_title\\}", tenderMaster.getTitle());
            msg1 = msg1.replaceAll("\\{ref_no\\}", tender_no);
            msg1 = msg1.replaceAll("\\{start_date\\}", tenderMaster.getAnnounceDate());
            msg1 = msg1.replaceAll("\\{end_date\\}", tenderMaster.getSubmitLastdate());

            SendMail s = new SendMail();
            s.sendMail(mail_from, mail_to, subject1, msg1);

        }

        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            List<MultipartFile> files = multipartRequest.getFiles("generalfile1");

            if (files != null && !files.isEmpty()) {
                for (MultipartFile file : files) {
                    if (file.isEmpty()) {
                        continue;
                    }

                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard"
                            + File.separator + "Tender"
                            + File.separator + tender_no
                            + File.separator;

                    File directory = new File(fileLocationURL);
                    if (!directory.exists() && !directory.mkdirs()) {
                        throw new IOException("Failed to create directory: " + fileLocationURL);
                    }

                    String sanitizedFileName = file.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "")
                            .replaceAll("[ &+]", "");

                    File destinationFile = new File(directory, sanitizedFileName);
                    file.transferTo(destinationFile);

                    CommMasterAttachment attachment = new CommMasterAttachment();
                    attachment.setAttachment(sanitizedFileName);
                    attachment.setTenderNo(tender_no);
                    attachment.setVendorCode(username);
                    attachment.setSubject(subject);

                    commMasterAttachmentService.create(attachment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        List commMaster1 = commMasterService.readTenderVendorComm(tender_no, username);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("commMaster", commMaster1);

        mv.setViewName("Vendor/AjaxTenderAdminCommunication");
        return mv;
    }

    public ModelAndView queryReport(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List commMaster = commMasterService.readTenderVendorComm(tender_no, username);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("commMaster", commMaster);
        mv.setViewName("Vendor/QueryReport");
        return mv;
    }

    public ModelAndView queryReportSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List commMaster = commMasterService.readTenderComm(tender_no);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("commMaster", commMaster);
        mv.setViewName("Vendor/QueryReport");
        return mv;
    }

    public ModelAndView uploadVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List commMaster = commMasterService.readTenderVendorComm(tender_no, username);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("commMaster", commMaster);
        mv.setViewName("Vendor/UploadVendor");
        return mv;
    }

    public ModelAndView uploadVendorSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        TenderMaster tenderMaster = new TenderMaster();
        String tender_no = request.getParameter("tender_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        String technicalfile = request.getParameter("vendorfile");
        if (technicalfile == null) {
            technicalfile = "";
        }
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile multipartFile = multipartRequest.getFile("vendorfile");
        if (multipartFile != null && multipartFile.getSize() > 0) {
            try {
                String fileLocationURL = getServletContext().getRealPath("/")
                        + File.separator + "StorageYard" + File.separator + "Vendor"
                        + File.separator;
                File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                technicalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                multipartFile.transferTo(photoFile);
                //    vendorInformation.setTermsConditionFile(photoFile+"");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            File file = new File(getServletContext().getRealPath("/") + "/StorageYard/Vendor/" + technicalfile);
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
                    String vendor_code = "";
                    String vendor_name = "";
                    String address = "";
                    String email_id = "";
                    String mobile_no = "";
                    int i = 0;
                    while (cellIterator.hasNext()) {
                        i++;
                        Cell cell = cellIterator.next();
                        if (i == 1) {
                            try {
                                srNo = cell.getNumericCellValue() + "";
                            } catch (Exception e1) {
                                srNo = cell.getStringCellValue();
                            }
                        }
                        if (i == 2) {
                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                vendor_code = lonVal + "";
                            } catch (Exception e1) {
                                vendor_code = cell.getStringCellValue();
                            }

                        }
                        if (i == 3) {
                            vendor_name = cell.getStringCellValue();
                        }
                        if (i == 4) {
                            address = cell.getStringCellValue();
                        }
                        if (i == 5) {
                            email_id = cell.getStringCellValue();
                        }
                        if (i == 6) {
                            try {
                                Double doubleValue = cell.getNumericCellValue();
                                BigDecimal bd = new BigDecimal(doubleValue.toString());
                                long lonVal = bd.longValue();

                                mobile_no = lonVal + "";
                            } catch (Exception e1) {
                                mobile_no = cell.getStringCellValue();
                            }
                        }

                    }

                    List vendorMaster = vendorMasterService.readVendorRegNo(vendor_code);

                    if (vendorMaster.isEmpty()) {
                        VendorMaster vendorMaster2 = new VendorMaster();
                        vendorMaster2.setVendorName(vendor_name);
                        vendorMaster2.setVendorRegNo(vendor_code);
                        vendorMaster2.setVendorStxNo("");
                        vendorMaster2.setVendorCstxNo("");
                        vendorMaster2.setVendorAddressLine1(address);
                        vendorMaster2.setVendorAddressLine2("");
                        vendorMaster2.setVendorAddressLine3("");
                        vendorMaster2.setVendorCity("");
                        vendorMaster2.setVendorPincode("");
                        vendorMaster2.setVendorDistrict("");
                        vendorMaster2.setVendorState("");
                        vendorMaster2.setVendorCountry("");
                        vendorMaster2.setVendorPhNo(mobile_no);
                        vendorMaster2.setVendorMobNo(mobile_no);
                        vendorMaster2.setVendorFax(mobile_no);
                        vendorMaster2.setVendorEmailID(email_id);
                        vendorMasterService.create(vendorMaster2);

                        List userMaster1 = userMasterService.readUser(vendor_code);

                        if (userMaster1.isEmpty()) {
                            UserMaster userMaster = new UserMaster();
                            userMaster.setLoginName(vendor_code);
                            userMaster.setPassword("Admin@123");
                            userMaster.setUserFullName(vendor_name);
                            userMaster.setUserType(1);
                            userMaster.setPwdChange(0);
                            userMaster.setLock1(0);
                            userMaster.setUserTry(0);
                            userMasterService.create(userMaster);
                        }

                    } else {
                        vendorMasterService.updateVendor(vendor_code, "", "", address, "", "", "", "", "", "", "", mobile_no, email_id);

                        List userMaster1 = userMasterService.readUser(vendor_code);

                        if (userMaster1.isEmpty()) {
                            UserMaster userMaster = new UserMaster();
                            userMaster.setLoginName(vendor_code);
                            userMaster.setPassword("Admin@123");
                            userMaster.setUserFullName(vendor_name);
                            userMaster.setUserType(1);
                            userMaster.setPwdChange(0);
                            userMaster.setLock1(0);
                            userMaster.setUserTry(0);
                            userMasterService.create(userMaster);
                        }

                    }

                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("successMessage",
                "Information: Vendor File Uploaded successfully");
        List commMaster = commMasterService.readTenderVendorComm(tender_no, username);

        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("commMaster", commMaster);
//        mv.setViewName("Vendor/UploadVendor");
        mv.setViewName("forward:vendorInformation.htm?act=searchVendor");
        return mv;
    }

    public ModelAndView agaxVendorTechnicalSpecification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("q");
        String ref_no = request.getParameter("q");
        String service = request.getParameter("service");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String attachment_type = "2";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AgaxVendorTechnicalSpecification");
        return mv;
    }

    public ModelAndView agaxVendorPriceSpecification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("q");
        String ref_no = request.getParameter("q");
        String service = request.getParameter("service");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String attachment_type = "3";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument1", generalDocument);

        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AgaxVendorPriceSpecification");
        return mv;
    }

    public ModelAndView addVendorTechnicalSpecification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        String attachment_type = "2";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AddVendorTechnicalSpecification");
        return mv;
    }

    public ModelAndView addVendorTechnicalSpecificationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("ref_no");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + vendor_code;
        f1 = new File(path);
        bool = f1.mkdir();

        //upload document
        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile");
            if (generalfile == null) {
                generalfile = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("generalfile");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refNo + File.separator + vendor_code + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (generalfile.equals("")) {
            } else {
                VendorAttachment vendorAttachment = new VendorAttachment();
                vendorAttachment.setRefNo(refNo);
                vendorAttachment.setVendorCode(vendor_code);
                vendorAttachment.setAttachment(generalfile);
                vendorAttachment.setAttachmentType(2);
                vendorAttachmentService.create(vendorAttachment);

            }
        }

        String attachment_type = "2";
        List generalDocument = vendorAttachmentService.readAttachment(refNo, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("ref_no", refNo);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.setViewName("Vendor/AddVendorTechnicalSpecification");
        return mv;
    }

    public ModelAndView vendorTechnicalSpecificationDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String id = request.getParameter("id");

        vendorAttachmentService.delete(Integer.parseInt(id));

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        String attachment_type = "2";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AddVendorTechnicalSpecification");
        return mv;
    }

    public ModelAndView addVendorPriceSpecification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        String attachment_type = "3";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AddVendorPriceSpecification");
        return mv;
    }

    public ModelAndView addVendorPriceSpecificationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("ref_no");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + vendor_code;
        f1 = new File(path);
        bool = f1.mkdir();

        //upload document
        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile");
            if (generalfile == null) {
                generalfile = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("generalfile");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refNo + File.separator + vendor_code + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (generalfile.equals("")) {
            } else {
                VendorAttachment vendorAttachment = new VendorAttachment();
                vendorAttachment.setRefNo(refNo);
                vendorAttachment.setVendorCode(vendor_code);
                vendorAttachment.setAttachment(generalfile);
                vendorAttachment.setAttachmentType(3);
                vendorAttachmentService.create(vendorAttachment);

            }
        }

        String attachment_type = "3";
        List generalDocument = vendorAttachmentService.readAttachment(refNo, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("ref_no", refNo);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.setViewName("Vendor/AddVendorPriceSpecification");
        return mv;
    }

    public ModelAndView vendorPriceSpecificationDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String id = request.getParameter("id");

        vendorAttachmentService.delete(Integer.parseInt(id));

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        String attachment_type = "3";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AddVendorPriceSpecification");
        return mv;
    }

    public ModelAndView agaxVendorReviseTechnicalSpecification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("q");
        String ref_no = request.getParameter("q");
        String service = request.getParameter("service");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String attachment_type = "4";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AgaxVendorReviseTechnicalSpecification");
        return mv;
    }

    public ModelAndView agaxVendorRevisePriceSpecification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("q");
        String ref_no = request.getParameter("q");
        String service = request.getParameter("service");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String attachment_type = "5";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);

        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AgaxVendorRevisePriceSpecification");
        return mv;
    }

    public ModelAndView addVendorReviseTechnicalSpecification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        String attachment_type = "4";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AddVendorReviseTechnicalSpecification");
        return mv;
    }

    public ModelAndView addVendorReviseTechnicalSpecificationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("ref_no");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + vendor_code;
        f1 = new File(path);
        bool = f1.mkdir();

        //upload document
        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile");
            if (generalfile == null) {
                generalfile = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("generalfile");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refNo + File.separator + vendor_code + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (generalfile.equals("")) {
            } else {
                VendorAttachment vendorAttachment = new VendorAttachment();
                vendorAttachment.setRefNo(refNo);
                vendorAttachment.setVendorCode(vendor_code);
                vendorAttachment.setAttachment(generalfile);
                vendorAttachment.setAttachmentType(4);
                vendorAttachmentService.create(vendorAttachment);

            }
        }

        String attachment_type = "4";
        List generalDocument = vendorAttachmentService.readAttachment(refNo, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("ref_no", refNo);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.setViewName("Vendor/AddVendorReviseTechnicalSpecification");
        return mv;
    }

    public ModelAndView vendorReviseTechnicalSpecificationDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String id = request.getParameter("id");

        vendorAttachmentService.delete(Integer.parseInt(id));

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        String attachment_type = "4";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AddVendorReviseTechnicalSpecification");
        return mv;
    }

    public ModelAndView addVendorRevisePriceSpecification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        String attachment_type = "5";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AddVendorRevisePriceSpecification");
        return mv;
    }

    public ModelAndView addVendorRevisePriceSpecificationSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String refNo = request.getParameter("ref_no");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo;
        File f1 = new File(path);
        boolean bool = f1.mkdir();

        path = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + vendor_code;
        f1 = new File(path);
        bool = f1.mkdir();

        //upload document
        int otherDetailCount = Integer.parseInt(request.getParameter("policyCount"));
        for (int i = 1; i <= otherDetailCount; i++) {
            String generalfile = request.getParameter("generalfile");
            if (generalfile == null) {
                generalfile = "";
            }

            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

            MultipartFile multipartFile = multipartRequest.getFile("generalfile");
            if (multipartFile != null && multipartFile.getSize() > 0) {
                try {
                    String fileLocationURL = getServletContext().getRealPath("/")
                            + File.separator + "StorageYard" + File.separator + "Tender"
                            + File.separator + refNo + File.separator + vendor_code + File.separator;
                    File photoFile = new File(fileLocationURL + multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", ""));
                    generalfile = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    multipartFile.transferTo(photoFile);
                    //    vendorInformation.setTermsConditionFile(photoFile+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (generalfile.equals("")) {
            } else {
                VendorAttachment vendorAttachment = new VendorAttachment();
                vendorAttachment.setRefNo(refNo);
                vendorAttachment.setVendorCode(vendor_code);
                vendorAttachment.setAttachment(generalfile);
                vendorAttachment.setAttachmentType(5);
                vendorAttachmentService.create(vendorAttachment);

            }
        }

        String attachment_type = "5";
        List generalDocument = vendorAttachmentService.readAttachment(refNo, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("ref_no", refNo);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.setViewName("Vendor/AddVendorRevisePriceSpecification");
        return mv;
    }

    public ModelAndView vendorRevisePriceSpecificationDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        TenderMaster tenderMaster = new TenderMaster();
        String tenderPhase = request.getParameter("tenderPhase");
        String tender_no = request.getParameter("tender_no");
        String ref_no = request.getParameter("ref_no");
        String id = request.getParameter("id");

        vendorAttachmentService.delete(Integer.parseInt(id));

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        String attachment_type = "5";
        List generalDocument = vendorAttachmentService.readAttachment(ref_no, vendor_code, attachment_type);

        mv.getModelMap().put("generalDocument", generalDocument);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("ref_no", ref_no);
        mv.getModelMap().put("vendor_code", vendor_code);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.setViewName("Vendor/AddVendorRevisePriceSpecification");
        return mv;
    }

    public ModelAndView bidTenderForContractSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tenderPhase = request.getParameter("tenderPhase");
        String tenderItemMasterCount = request.getParameter("vendorTenderBidItemCount");

        String refNo = request.getParameter("refNo");
        List t_c = tenderItemMasterService.readByRefNoAndItemType(refNo, 1);
        tenderItemMasterCount = t_c.size() + "";

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        TenderMaster tenderMaster = tenderMasterService.readByVendorRefNo(refNo, username);

        //-----------------------------------------
        String common_tax = request.getParameter("common_tax");
        if (common_tax == null) {
            common_tax = "0";
        }
        String discount_val = request.getParameter("discount_val");
        String discount = request.getParameter("discount");
        String packing_val = request.getParameter("packing_val");
        String packing = request.getParameter("packing");
        String freight_val = request.getParameter("freight_val");
        String freight = request.getParameter("freight");
        String errection = request.getParameter("errection");
        String other_charges = request.getParameter("other_charges");
        String igst = request.getParameter("igst");
        String cgst = request.getParameter("cgst");
        String sgst = request.getParameter("sgst");
        String insurance_value = request.getParameter("insurance_value");
        String total_amount = request.getParameter("total_amount");
        String grand_total = request.getParameter("grand_total");
        String venodr_total_words = request.getParameter("venodr_total_words");
        String modeOfFraight = request.getParameter("modeOfFraight");
        String freight_comment = request.getParameter("freight_comment");

        List reviseVendorTenderBidItem11 = reviseVendorTenderBidItemService.readByVendorRefNo(refNo, username);

        VendorTenderBid vendorTenderBid11 = vendorTenderBidService.readByVendorRefNo(refNo, username);

        String offer_no = vendorTenderBid11.getOfferNo();
        String offer_date = vendorTenderBid11.getOfferDate();
        String contact_person = vendorTenderBid11.getContactPerson();
        String contact_no = vendorTenderBid11.getContactNo();
        String contact_email = vendorTenderBid11.getConactEmail();
        String gst_no = vendorTenderBid11.getGstNo();

        List reviseVendorTenderBid1 = reviseVendorTenderBidService.readVendorRefNo(refNo, username);

        reviseVendorTenderBidService.updateVendorServiceItem(refNo, username, discount_val, discount, igst, total_amount, grand_total);

        //reviseVendorTenderBidService.updateVendorItem(refNo, username, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total, venodr_total_words);
        ReviseVendorTenderBid reviseVendorTenderBid111 = reviseVendorTenderBidService.readByVendorRefNo(refNo, username);

        String grandTotal1 = reviseVendorTenderBid111.getGrandTotal();

        double finalTotal = Double.parseDouble(grandTotal1) + Double.parseDouble(grand_total);

        long tmp = Math.round(finalTotal * 100);
        finalTotal = (double) tmp / 100;

        BigDecimal bd = new BigDecimal(finalTotal);
        bd = bd.setScale(2, RoundingMode.HALF_UP);

        String plainString = bd.toPlainString();

        reviseVendorTenderBid111.setFreightFreeDelivery(modeOfFraight);
        reviseVendorTenderBid111.setFreeDeliveryComment(freight_comment);
        reviseVendorTenderBidService.update(reviseVendorTenderBid111);

        VendorTenderBid vendorTenderBid111 = vendorTenderBidService.readByVendorRefNo(refNo, username);
        vendorTenderBid111.setFinalTotal(plainString + "");
        vendorTenderBidService.update(vendorTenderBid111);
        //item details

        String[] item_code = request.getParameterValues("item_code");
        String[] item_description = request.getParameterValues("item_description");
        String[] item_remark = request.getParameterValues("item_remark");
        String[] uom = request.getParameterValues("uom");
        String[] qty = request.getParameterValues("qty");
        String[] attachment_required = request.getParameterValues("attachment_required");
        String[] delivery_schedule_date = request.getParameterValues("delivery_schedule_date");
        String[] delivery_schedule_qty = request.getParameterValues("delivery_schedule_qty");
        String[] item_location = request.getParameterValues("item_location");
        String[] pur_no = request.getParameterValues("pur_no");
        String[] item_no = request.getParameterValues("item_no");
        String[] sr_no = request.getParameterValues("sr_no");
        String[] pr_no = request.getParameterValues("pr_no");
        String[] unit_rate = request.getParameterValues("unit_rate");
        String[] net_rate = request.getParameterValues("net_rate");
        String[] hsn_no = request.getParameterValues("hsn_no");
        String[] vendor_remark = request.getParameterValues("vendor_remark");
        String[] item_discount_val = request.getParameterValues("item_discount_val");
        String[] item_discount = request.getParameterValues("item_discount");
        String[] item_packing_val = request.getParameterValues("item_packing_val");
        String[] item_packing = request.getParameterValues("item_packing");
        String[] item_freight_val = request.getParameterValues("item_freight_val");
        String[] item_freight = request.getParameterValues("item_freight");
        String[] item_errection = request.getParameterValues("item_errection");
        String[] item_other_charges = request.getParameterValues("item_other_charges");
        String[] item_igst = request.getParameterValues("item_igst");
        String[] item_cgst = request.getParameterValues("item_cgst");
        String[] item_sgst = request.getParameterValues("item_sgst");
        String[] item_insurance_value = request.getParameterValues("item_insurance_value");
        String[] item_total = request.getParameterValues("item_total");
        String[] item_regret = request.getParameterValues("item_regret");

        int j = 0;
        int item_type = 1;
        for (int i = 0; i < item_code.length; i++) {
            j++;

            List vendorTenderBidItem1 = reviseVendorTenderBidItemService.readItemVendorRefNoByItemWise(refNo, username, sr_no[i], item_type);

            if (vendorTenderBidItem1.isEmpty()) {
                ReviseVendorTenderBidItem vendorTenderBidItem = new ReviseVendorTenderBidItem();
                vendorTenderBidItem.setRefNo(refNo);
                vendorTenderBidItem.setVendorCode(username);
                vendorTenderBidItem.setItemCode(item_code[i]);
                vendorTenderBidItem.setItemDescription(item_description[i]);
                vendorTenderBidItem.setRemark(item_remark[i]);
                vendorTenderBidItem.setUom(uom[i]);
                vendorTenderBidItem.setQty(qty[i]);
                vendorTenderBidItem.setAttachmentRequired(attachment_required[i]);
                vendorTenderBidItem.setDeliveryScheduleDate(delivery_schedule_date[i]);
                vendorTenderBidItem.setDeliveryScheduleQty(delivery_schedule_qty[i]);
                vendorTenderBidItem.setLocation(item_location[i]);
                vendorTenderBidItem.setPurNo(pur_no[i]);
                vendorTenderBidItem.setItemNo(item_no[i]);
                vendorTenderBidItem.setSrNo(sr_no[i]);
                vendorTenderBidItem.setPrNo(pr_no[i]);
                if (unit_rate[i].equals("")) {
                    unit_rate[i] = "0";
                }
                vendorTenderBidItem.setRate(unit_rate[i]);
                vendorTenderBidItem.setNetRate(net_rate[i]);
                vendorTenderBidItem.setHsnNo(hsn_no[i]);
                vendorTenderBidItem.setVendorRemark(vendor_remark[i]);
                vendorTenderBidItem.setDiscountType(item_discount_val[i]);
                vendorTenderBidItem.setDiscountValue(item_discount[i]);
                vendorTenderBidItem.setPackingType(item_packing_val[i]);
                vendorTenderBidItem.setPackingValue(item_packing[i]);
                vendorTenderBidItem.setFreightType(item_freight_val[i]);
                vendorTenderBidItem.setFreightValue(item_freight[i]);
                vendorTenderBidItem.setErrectionValue(item_errection[i]);
                vendorTenderBidItem.setChargesValue(item_other_charges[i]);
                vendorTenderBidItem.setIgstValue(item_igst[i]);
                vendorTenderBidItem.setCgstValue(item_cgst[i]);
                vendorTenderBidItem.setSgstValue(item_sgst[i]);
                vendorTenderBidItem.setInsuranceValue(item_insurance_value[i]);
                vendorTenderBidItem.setTotalValue(item_total[i]);
                if (item_regret[i].equals("")) {
                    item_regret[i] = "0";
                }
                vendorTenderBidItem.setItemRegret(item_regret[i]);
                vendorTenderBidItem.setItemType(1);
                reviseVendorTenderBidItemService.create(vendorTenderBidItem);
            } else {
                reviseVendorTenderBidItemService.updateItemVendorRefNoByItemType(refNo, username, sr_no[i], item_description[i], item_remark[i], uom[i], qty[i], attachment_required[i], delivery_schedule_date[i], delivery_schedule_qty[i], item_location[i], pur_no[i], item_no[i], unit_rate[i], net_rate[i], hsn_no[i], vendor_remark[i], item_discount_val[i], item_discount[i], item_packing_val[i], item_packing[i], item_freight_val[i], item_freight[i], item_errection[i], item_other_charges[i], item_igst[i], item_cgst[i], item_sgst[i], item_insurance_value[i], item_total[i], item_regret[i], item_type);

            }

        }

        //vendor tender bid
        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, username);
        int rivision = vendorTenderBid.getRevision();
        String delivery_location = vendorTenderBid.getDeliveryLocation();
        String delivery_period = vendorTenderBid.getDeliveryPeriod();
        String terms_of_payment = vendorTenderBid.getTermsOfPayment();
        String validity_period = vendorTenderBid.getValidityPeriod();
        String mode_of_transport = vendorTenderBid.getModeOfTransport();
        String inco_terms = vendorTenderBid.getIncoTerms();
        String insurance1 = vendorTenderBid.getInsurance();
        String freight1 = vendorTenderBid.getFreight();
        String grand_total1 = vendorTenderBid.getGrandTotal();
        String grand_total_word1 = vendorTenderBid.getGrandTotalWord();
        String remark_by_vendor = vendorTenderBid.getRemarkByVendor();

        mv.getModelMap().put("rivision", rivision);

        mv.getModelMap().put("delivery_location", delivery_location);
        mv.getModelMap().put("delivery_period", delivery_period);
        mv.getModelMap().put("terms_of_payment", terms_of_payment);
        mv.getModelMap().put("validity_period", validity_period);
        mv.getModelMap().put("mode_of_transport", mode_of_transport);
        mv.getModelMap().put("inco_terms", inco_terms);
        mv.getModelMap().put("insurance1", insurance1);
        mv.getModelMap().put("freight1", freight1);
        mv.getModelMap().put("grand_total1", plainString);
        mv.getModelMap().put("grand_total_word1", grand_total_word1);
        mv.getModelMap().put("remark_by_vendor", remark_by_vendor);

        List list1 = tenderMasterService.vendorLiveTender(username);
        request.setAttribute("list", list1);

//        TermsConditionParameter termsConditionParameter = new TermsConditionParameter().readByName();
        List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, username);
        int termsConditionCount = vendorTermsCondition1.size();

        mv.getModelMap().put("termsConditionCount", termsConditionCount);

        mv.getModelMap().put("vendorTermsCondition1", vendorTermsCondition1);

        mv.getModelMap().put("tenderMaster", tenderMaster);

        List<ReviseVendorTenderBidItem> vendorTenderBidItem1 = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, username, 1);
        int vendorTenderBidItemCount = vendorTenderBidItem1.size();

        boolean isVendorTenderBidItemValid = (Integer.parseInt(tenderItemMasterCount) == vendorTenderBidItemCount);

        if (isVendorTenderBidItemValid) {
            mv.setViewName("Vendor/BidTenderForCondition");
        } else {
            for (ReviseVendorTenderBidItem venTenderBid : vendorTenderBidItem1) {
                int id = venTenderBid.getId();
                reviseVendorTenderBidItemService.delete(id);
            }

            request.setAttribute("failureMessage",
                    "Information: Data not submitted properly. Please try again.");
            mv.setViewName("forward:vendor.htm?act=bidTenderForReviseBid&refNo=" + refNo);

        }

//        mv.setViewName("forward:vendor.htm?act=liveTender");
        //  mv.setViewName("vendor.htm?act=bidTenderForFinancialSubmit1");
        return mv;

    }

    public void downloadVenderAttachFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");
        String RefNo = request.getParameter("RefNo");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        String refNo = RefNo.replace("/", "");

        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Tender"
                + File.separator + refNo + File.separator + vendor_code + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);

        if (session != null) {

            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }

        mv.setViewName("Vendor/ShowVendorPercentage");
        return mv;
    }

    public ModelAndView createVendorPercentage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);

        if (session != null) {

            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
                mv.addObject("successMessage", successMessage);
                session.removeAttribute("successMessage");
            }

            String failureMessage = (String) session.getAttribute("failureMessage");
            if (failureMessage != null) {
                mv.addObject("failureMessage", failureMessage);
                session.removeAttribute("failureMessage");
            }
        }

        mv.setViewName("Vendor/CreateVendorPercentage");
        return mv;
    }

    public ModelAndView submitVendorPercentageGroup(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String technicalPercentage = request.getParameter("technicalPercentage");
        String hrPercentage = request.getParameter("hrPercentage");
        String safteyPercentage = request.getParameter("safteyPercentage");
        String itPercentage = request.getParameter("itPercentage");
        VendorPercentage vendorPercentage = new VendorPercentage();
        vendorPercentage.setTechnicalPercentage(technicalPercentage);
        vendorPercentage.setHrPercentage(hrPercentage);
        vendorPercentage.setSafteyPercentage(safteyPercentage);
        vendorPercentage.setItPercentage(itPercentage);

        if (!vendorPercentageService.isExist(vendorPercentage)) {
            vendorPercentageService.create(vendorPercentage);

            session.setAttribute("successMessage", "Vendor Percentage Created Successfully");
            mv.setViewName("redirect:vendor.htm?act=showList");

        } else {

            session.setAttribute("failureMessage", "Vendor Percentage Already Exist. Please Enter New Vendor Percentage");
            mv.setViewName("redirect:vendor.htm?act=createVendorPercentage");
        }

        return mv;
    }

    public ModelAndView editVendorPercentage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        VendorPercentage vendorPercentage = vendorPercentageService.readById(Integer.parseInt(id));

        mv.getModelMap().put("vendorPercentage", vendorPercentage);
        mv.setViewName("Vendor/EditVendorPercentage");
        return mv;
    }

    public ModelAndView submitEditVendorPercentage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        String id = request.getParameter("id");

        VendorPercentage vendorPercentage = vendorPercentageService.readById(Integer.parseInt(id));

        String technicalPercentage = request.getParameter("technicalPercentage");
        String hrPercentage = request.getParameter("hrPercentage");
        String safteyPercentage = request.getParameter("safteyPercentage");
        String itPercentage = request.getParameter("itPercentage");
        vendorPercentage.setTechnicalPercentage(technicalPercentage);
        vendorPercentage.setHrPercentage(hrPercentage);
        vendorPercentage.setSafteyPercentage(safteyPercentage);
        vendorPercentage.setItPercentage(itPercentage);
        vendorPercentageService.update(vendorPercentage);

        session.setAttribute("successMessage", "Vendor Percentage Edited Successfully");

        mv.setViewName("redirect:vendor.htm?act=showList");
        return mv;
    }

    public ModelAndView deleteVendorById(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String ids = request.getParameter("ids");
        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            vendorPercentageService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:vendor.htm?act=showList");
        return mv;

    }

    public ModelAndView deleteVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            vendorPercentageService.delete(Integer.parseInt(checkedValues));
        }

        mv.setViewName("redirect:vendor.htm?act=showList");

        return mv;
    }

    public ModelAndView vendorPercentagePaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "desc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "technicalPercentage";
                    break;
                case "3":
                    orderColumn = "hrPercentage";
                    break;
                case "4":
                    orderColumn = "safteyPercentage";
                    break;
                case "5":
                    orderColumn = "itPercentage";
                    break;

                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = vendorPercentageService.getVendorPercentagePagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = vendorPercentageService.getTotalVendorPercentageCount();

        int filteredRecords = vendorPercentageService.getFilteredVendorPercentageCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            VendorPercentage vendorPercentage = (VendorPercentage) obj;

            JSONObject json = new JSONObject();

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("technicalPercentage", vendorPercentage.getTechnicalPercentage() != null ? vendorPercentage.getTechnicalPercentage() : "");
            json.put("hrPercentage", vendorPercentage.getHrPercentage() != null ? vendorPercentage.getHrPercentage() : "");
            json.put("safteyPercentage", vendorPercentage.getSafteyPercentage() != null ? vendorPercentage.getSafteyPercentage() : "");
            json.put("itPercentage", vendorPercentage.getItPercentage() != null ? vendorPercentage.getItPercentage() : "");

            json.put(
                    "action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='vendor.htm?act=editVendorPercentage&id="
                    + vendorPercentage.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "</div>"
            );

            dataArray.put(json);

        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("draw", draw);
        responseJson.put("recordsTotal", totalRecords);
        responseJson.put("recordsFiltered", filteredRecords);
        responseJson.put("data", dataArray);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseJson.toString());

        return null;
    }

    public ModelAndView bidTenderSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String tender_no = request.getParameter("tender_no");
        String remark = request.getParameter("remarks");
        TenderMaster tenderMaster = tenderMasterService.readRefNo(tender_no);
        int id = tenderMaster.getId();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        List tenderRegret = tenderRegretService.readByTenderNo(tender_no, username);

        if (tenderRegret.isEmpty()) {
            TenderRegret tenderRegret1 = new TenderRegret();
            tenderRegret1.setRefNo(tender_no);
            tenderRegret1.setRemark(remark);
            tenderRegret1.setVendorCode(username);
            tenderRegret1.setFlag(0);
            tenderRegretService.create(tenderRegret1);
        } else {
            tenderRegretService.updateTenderBid(tender_no, username);
        }

        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.getModelMap().put("username", username);
        mv.getModelMap().put("tender_no", tender_no);
        mv.getModelMap().put("id", id);
        request.setAttribute("successMessage",
                "Information: Bid Open successfully");

        mv.setViewName("Vendor/RegretTender");
        return mv;
    }

    public ModelAndView priceBidServiceVendnorSidePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String refNo = request.getParameter("refNo");
        String vendorCode = request.getParameter("vendorCode");
        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);
        String title = tenderMaster.getTitle();
        String projectId = tenderMaster.getProjectId();
        int tenderPhase = tenderMaster.getTenderPhase();
        String emd = tenderMaster.getEmd();
        String fee = tenderMaster.getDocCost();
        String prNo = tenderMaster.getPrNo();

        String announceDate = tenderMaster.getAnnounceDate();
        String submitLastdate = tenderMaster.getSubmitLastdate();
        String contactPerson = tenderMaster.getContactPerson();
        String tenderAdminContactNumber = tenderMaster.getTenderAdminContactNumber();
        String tenderAuthorizePerson = tenderMaster.getTenderAuthorizePerson();
        String tenderAuthorizeContactNo = tenderMaster.getTenderAuthorizeContactNo();

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("title", title);
        mv.getModelMap().put("projectId", projectId);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("announceDate", announceDate);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        mv.getModelMap().put("contactPerson", contactPerson);
        mv.getModelMap().put("tenderAdminContactNumber", tenderAdminContactNumber);
        mv.getModelMap().put("tenderAuthorizePerson", tenderAuthorizePerson);
        mv.getModelMap().put("tenderAuthorizeContactNo", tenderAuthorizeContactNo);

        String rfqNo = "";
        String vendorName = "";
        List tenderVendor = tenderVendorService.readByVendor(refNo, vendorCode);
        for (Object o : tenderVendor) {
            TenderVendor tv = (TenderVendor) o;
            rfqNo = tv.getRfqNo();
            vendorName = tv.getVendorName();
        }

        mv.getModelMap().put("rfqNo", rfqNo);
        mv.getModelMap().put("vendorCode", vendorCode);
        mv.getModelMap().put("vendorName", vendorName);

        String technicalRemark = "";
        List tenderTechnical = tenderTechnicalService.readByRefNo(refNo);
        for (Object o : tenderTechnical) {
            TenderTechnical tt = (TenderTechnical) o;
            technicalRemark = tt.getRemark();
        }

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();

        UserRights userRights = userRightsService.readByUser(username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, vendorCode);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, vendorCode);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        mv.getModelMap().put("fee", fee);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);

        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, vendorCode);

        String offerNo = vendorTenderBid.getOfferNo();
        String offerDate = vendorTenderBid.getOfferDate();
        String contact_person = vendorTenderBid.getContactPerson();
        String contact_no = vendorTenderBid.getContactNo();
        String contact_email = vendorTenderBid.getConactEmail();
        String gst_no = vendorTenderBid.getGstNo();

        mv.getModelMap().put("offerNo", offerNo);
        mv.getModelMap().put("offerDate", offerDate);
        mv.getModelMap().put("contact_person", contact_person);
        mv.getModelMap().put("contact_no", contact_no);
        mv.getModelMap().put("contact_email", contact_email);
        mv.getModelMap().put("gst_no", gst_no);

        String deliveryLocation = vendorTenderBid.getDeliveryLocation();
        String deliveryPeriod = vendorTenderBid.getDeliveryPeriod();
        String termsOfPayment = vendorTenderBid.getTermsOfPayment();
        String validityPeriod = vendorTenderBid.getValidityPeriod();
        String modeOfTransport = vendorTenderBid.getModeOfTransport();
        String incoTerms = vendorTenderBid.getIncoTerms();
        String insurance = vendorTenderBid.getInsurance();
        String freight = vendorTenderBid.getFreight();
        String total1 = vendorTenderBid.getGrandTotal();
        String total_word = vendorTenderBid.getGrandTotalWord();

        mv.getModelMap().put("deliveryLocation", deliveryLocation);
        mv.getModelMap().put("deliveryPeriod", deliveryPeriod);
        mv.getModelMap().put("termsOfPayment", termsOfPayment);
        mv.getModelMap().put("validityPeriod", validityPeriod);
        mv.getModelMap().put("modeOfTransport", modeOfTransport);
        mv.getModelMap().put("incoTerms", incoTerms);
        mv.getModelMap().put("insurance", insurance);
        mv.getModelMap().put("freight", freight);
        mv.getModelMap().put("total1", total1);
        mv.getModelMap().put("total_word", total_word);

        //----------------------
        List fileDetail = fileDetailService.readTenderNo(refNo);

        mv.getModelMap().put("fileDetail", fileDetail);

        int i11 = 0;
        for (Object o11 : fileDetail) {
            i11++;
            FileDetail fd = (FileDetail) o11;

            String file_name = fd.getFileName();
            String service_type = fd.getSerType();

            List serviceVendorTenderBid = serviceVendorTenderBidService.readVendorRefNo(file_name, vendorCode, refNo);

            for (Object o : serviceVendorTenderBid) {
                ServiceVendorTenderBid svtb = (ServiceVendorTenderBid) o;

                String item_total = svtb.getItemTotal();
                mv.getModelMap().put("item_total1_" + i11, item_total);

                if (service_type.equals("Service1") || service_type.equals("Service5")) {
                    List serviceVendorTenderBidItem = serviceVendorTenderBidItemService.readVendorRefNo(file_name, vendorCode, refNo);
                    mv.getModelMap().put("serviceVendorTenderBidItem11_" + i11, serviceVendorTenderBidItem);

                    String itemTotal = svtb.getItemTotal();
                    String selectCommon = svtb.getSelectCommon();
                    String discountType = svtb.getDiscountType();
                    String discountValue = svtb.getDiscountValue();
                    String packingType = svtb.getPackingType();
                    String packingValue = svtb.getPackingValue();
                    String freightType = svtb.getFreightType();
                    String freightValue = svtb.getFreightValue();
                    String errectionValue = svtb.getErrectionValue();
                    String chargesValue = svtb.getChargesValue();
                    String igstValue = svtb.getIgstValue();
                    String cgstValue = svtb.getCgstValue();
                    String sgstValue = svtb.getSgstValue();
                    String insuranceValue = svtb.getInsuranceValue();
                    String grandTotal = svtb.getGrandTotal();
                    // String grandTotalWord = svtb.getGrandTotalWord();

                    mv.getModelMap().put("itemTotal" + i11, itemTotal);
                    mv.getModelMap().put("selectCommon" + i11, selectCommon);
                    mv.getModelMap().put("discountType" + i11, discountType);
                    mv.getModelMap().put("discountValue" + i11, discountValue);
                    mv.getModelMap().put("packingType" + i11, packingType);
                    mv.getModelMap().put("packingValue" + i11, packingValue);
                    mv.getModelMap().put("freightType" + i11, freightType);
                    mv.getModelMap().put("freightValue" + i11, freightValue);
                    mv.getModelMap().put("errectionValue" + i11, errectionValue);
                    mv.getModelMap().put("chargesValue" + i11, chargesValue);
                    mv.getModelMap().put("igstValue" + i11, igstValue);
                    mv.getModelMap().put("cgstValue" + i11, cgstValue);
                    mv.getModelMap().put("sgstValue" + i11, sgstValue);
                    mv.getModelMap().put("insuranceValue" + i11, insuranceValue);
                    mv.getModelMap().put("grandTotal" + i11, grandTotal);
                    // mv.getModelMap().put("grandTotalWord", grandTotalWord);

                    Double itemTotalFinal = Double.parseDouble(itemTotal);
                    Double discountValueFinal = 0.0;
                    Double packingValueFinal = 0.0;
                    Double freightValueFinal = 0.0;
                    Double errectionValueFinal = 0.0;
                    Double chargesValueFinal = 0.0;
                    Double igstValueFinal = 0.0;
                    Double cgstValueFinal = 0.0;
                    Double sgstValueFinal = 0.0;
                    Double insuranceValueFinal = 0.0;
                    Double grandTotalFinal = 0.0;
                    Double Total = 0.0;

                    ArrayList<VendorBidItem> vbi = new ArrayList<VendorBidItem>();

                    if (selectCommon.equals("1")) {
                        if (discountType.equals("0")) {
                            discountValueFinal = Double.parseDouble(discountValue) * itemTotalFinal / 100;
                        } else {
                            discountValueFinal = Double.parseDouble(discountValue);
                        }
                        long tmp = Math.round(discountValueFinal * 100);
                        discountValueFinal = (double) tmp / 100;
                        Total = itemTotalFinal - discountValueFinal;
                        if (packingType.equals("0")) {
                            packingValueFinal = Double.parseDouble(packingValue) * Total / 100;
                        } else {
                            packingValueFinal = Double.parseDouble(packingValue);
                        }
                        tmp = Math.round(packingValueFinal * 100);
                        packingValueFinal = (double) tmp / 100;
                        Total = Total + packingValueFinal;
                        if (freightType.equals("0")) {
                            freightValueFinal = Double.parseDouble(freightValue) * Total / 100;
                        } else {
                            freightValueFinal = Double.parseDouble(freightValue);
                        }
                        tmp = Math.round(freightValueFinal * 100);
                        freightValueFinal = (double) tmp / 100;
                        Total = Total + freightValueFinal;

                        errectionValueFinal = Double.parseDouble(errectionValue);
                        tmp = Math.round(errectionValueFinal * 100);
                        errectionValueFinal = (double) tmp / 100;
                        Total = Total + errectionValueFinal;

                        chargesValueFinal = Double.parseDouble(chargesValue);
                        tmp = Math.round(chargesValueFinal * 100);
                        chargesValueFinal = (double) tmp / 100;
                        Total = Total + chargesValueFinal;

                        igstValueFinal = Double.parseDouble(igstValue) * Total / 100;
                        tmp = Math.round(igstValueFinal * 100);
                        igstValueFinal = (double) tmp / 100;
                        cgstValueFinal = Double.parseDouble(cgstValue) * Total / 100;
                        tmp = Math.round(cgstValueFinal * 100);
                        cgstValueFinal = (double) tmp / 100;
                        sgstValueFinal = Double.parseDouble(sgstValue) * Total / 100;
                        tmp = Math.round(sgstValueFinal * 100);
                        sgstValueFinal = (double) tmp / 100;
                        Total = Total + igstValueFinal + cgstValueFinal + sgstValueFinal;

                        insuranceValueFinal = Double.parseDouble(insuranceValue) * Total / 100;
                        tmp = Math.round(insuranceValueFinal * 100);
                        insuranceValueFinal = (double) tmp / 100;
                        Total = Total + insuranceValueFinal;
                    } else {
                        for (Object o21 : serviceVendorTenderBidItem) {
                            ServiceVendorTenderBidItem vtbi = (ServiceVendorTenderBidItem) o21;

                            int itemId = vtbi.getId();
                            String itemCode = vtbi.getSrNo();
                            String itemDesciption = vtbi.getDetails();
                            String remark = vtbi.getRemark();
                            String uom = vtbi.getUom();
                            String qty = vtbi.getQuantity();
                            String rate = vtbi.getRate();
                            String hsnNo = vtbi.getHsnNo();
                            String vendorRemark = vtbi.getVendorRemark();
                            String itemRegret = vtbi.getItemRegret();

                            String individualNetTotal = vtbi.getNetRate();
                            String individualDiscountType = vtbi.getDiscountType();
                            String individualDiscountValue = vtbi.getDiscountValue();
                            String individualPackingType = vtbi.getPackingType();
                            String individualPackingValue = vtbi.getPackingValue();
                            String individualFreightType = vtbi.getFreightType();
                            String individualFreightValue = vtbi.getFreightValue();
                            String individualErrectionValue = vtbi.getErrectionValue();
                            String individualChargesValue = vtbi.getChargesValue();
                            String individualIgstValue = vtbi.getIgstValue();
                            String individualCgstValue = vtbi.getCgstValue();
                            String individualSgstValue = vtbi.getSgstValue();
                            String individualInsuranceValue = vtbi.getInsuranceValue();
                            String individualgrandTotal = vtbi.getTotalValue();

                            Double individualItemTotalFinal = Double.parseDouble(individualNetTotal);
                            Double individualDiscountValueFinal = 0.0;
                            Double individualPackingValueFinal = 0.0;
                            Double individualFreightValueFinal = 0.0;
                            Double individualErrectionValueFinal = 0.0;
                            Double individualChargesValueFinal = 0.0;
                            Double individualIgstValueFinal = 0.0;
                            Double individualCgstValueFinal = 0.0;
                            Double individualSgstValueFinal = 0.0;
                            Double individualInsuranceValueFinal = 0.0;
                            Double individualGrandTotalFinal = 0.0;

                            if (individualDiscountType.equals("0")) {
                                individualDiscountValueFinal = Double.parseDouble(individualDiscountValue) * individualItemTotalFinal / 100;
                            } else {
                                individualDiscountValueFinal = Double.parseDouble(individualDiscountValue);
                            }
                            long tmp = Math.round(individualDiscountValueFinal * 100);
                            individualDiscountValueFinal = (double) tmp / 100;
                            individualGrandTotalFinal = individualItemTotalFinal - individualDiscountValueFinal;
                            discountValueFinal = discountValueFinal + individualDiscountValueFinal;

                            if (individualPackingType.equals("0")) {
                                individualPackingValueFinal = Double.parseDouble(individualPackingValue) * individualGrandTotalFinal / 100;
                            } else {
                                individualPackingValueFinal = Double.parseDouble(individualPackingValue);
                            }
                            tmp = Math.round(individualPackingValueFinal * 100);
                            individualPackingValueFinal = (double) tmp / 100;
                            individualGrandTotalFinal = individualGrandTotalFinal + individualPackingValueFinal;
                            packingValueFinal = packingValueFinal + individualPackingValueFinal;

                            if (individualFreightType.equals("0")) {
                                individualFreightValueFinal = Double.parseDouble(individualFreightValue) * individualGrandTotalFinal / 100;
                            } else {
                                individualFreightValueFinal = Double.parseDouble(individualFreightValue);
                            }
                            tmp = Math.round(individualFreightValueFinal * 100);
                            individualFreightValueFinal = (double) tmp / 100;
                            individualGrandTotalFinal = individualGrandTotalFinal + individualFreightValueFinal;
                            freightValueFinal = freightValueFinal + individualFreightValueFinal;

                            individualErrectionValueFinal = Double.parseDouble(individualErrectionValue);
                            tmp = Math.round(individualErrectionValueFinal * 100);
                            individualErrectionValueFinal = (double) tmp / 100;
                            individualGrandTotalFinal = individualGrandTotalFinal + individualErrectionValueFinal;
                            errectionValueFinal = errectionValueFinal + individualErrectionValueFinal;

                            individualChargesValueFinal = Double.parseDouble(individualChargesValue);
                            tmp = Math.round(individualChargesValueFinal * 100);
                            individualChargesValueFinal = (double) tmp / 100;
                            individualGrandTotalFinal = individualGrandTotalFinal + individualChargesValueFinal;
                            chargesValueFinal = chargesValueFinal + individualChargesValueFinal;

                            individualIgstValueFinal = Double.parseDouble(individualIgstValue) * individualGrandTotalFinal / 100;
                            tmp = Math.round(individualIgstValueFinal * 100);
                            individualIgstValueFinal = (double) tmp / 100;
                            igstValueFinal = igstValueFinal + individualIgstValueFinal;

                            individualCgstValueFinal = Double.parseDouble(individualCgstValue) * individualGrandTotalFinal / 100;
                            tmp = Math.round(individualCgstValueFinal * 100);
                            individualCgstValueFinal = (double) tmp / 100;
                            cgstValueFinal = cgstValueFinal + individualCgstValueFinal;

                            individualSgstValueFinal = Double.parseDouble(individualSgstValue) * individualGrandTotalFinal / 100;
                            tmp = Math.round(individualSgstValueFinal * 100);
                            individualSgstValueFinal = (double) tmp / 100;
                            sgstValueFinal = sgstValueFinal + individualSgstValueFinal;

                            individualGrandTotalFinal = individualIgstValueFinal + individualCgstValueFinal + individualSgstValueFinal;

                            individualInsuranceValueFinal = Double.parseDouble(individualInsuranceValue) * individualGrandTotalFinal / 100;
                            tmp = Math.round(individualInsuranceValueFinal * 100);
                            individualInsuranceValueFinal = (double) tmp / 100;
                            insuranceValueFinal = insuranceValueFinal + individualInsuranceValueFinal;
                            individualGrandTotalFinal = individualGrandTotalFinal + individualInsuranceValueFinal;

                            VendorBidItem vendorBidItem1 = new VendorBidItem(itemId, itemCode, itemDesciption, remark, uom, qty, "", "", rate, hsnNo, vendorRemark, itemRegret, individualNetTotal, individualDiscountType, individualDiscountValue, individualPackingType, individualPackingValue, individualFreightType, individualFreightValue, individualErrectionValue, individualChargesValue, individualIgstValue, individualCgstValue, individualSgstValue, individualInsuranceValue, individualgrandTotal, individualItemTotalFinal, individualDiscountValueFinal, individualPackingValueFinal, individualFreightValueFinal, individualErrectionValueFinal, individualChargesValueFinal, individualIgstValueFinal, individualCgstValueFinal, individualSgstValueFinal, individualInsuranceValueFinal, individualGrandTotalFinal);
                            vbi.add(vendorBidItem1);

                        }
                    }

                    mv.getModelMap().put("discountValueFinal" + i11, discountValueFinal);
                    mv.getModelMap().put("packingValueFinal" + i11, packingValueFinal);
                    mv.getModelMap().put("freightValueFinal" + i11, freightValueFinal);
                    mv.getModelMap().put("errectionValueFinal" + i11, errectionValueFinal);
                    mv.getModelMap().put("chargesValueFinal" + i11, chargesValueFinal);
                    mv.getModelMap().put("igstValueFinal" + i11, igstValueFinal);
                    mv.getModelMap().put("cgstValueFinal" + i11, cgstValueFinal);
                    mv.getModelMap().put("sgstValueFinal" + i11, sgstValueFinal);
                    mv.getModelMap().put("insuranceValueFinal" + i11, insuranceValueFinal);
                    mv.getModelMap().put("grandTotalFinal" + i11, grandTotalFinal);
                    mv.getModelMap().put("Total" + i11, Total);

                    mv.getModelMap().put("vbi" + i11, vbi);

                } else if (service_type.equals("Service2")) {
                    List serviceDetail2 = serviceDetail2Service.readTenderNo(file_name, refNo);
                    mv.getModelMap().put("serviceDetail21_" + i11, serviceDetail2);

                    List serviceVendorTenderBidItem2 = serviceVendorTenderBidItem2Service.readVendorRefNo(file_name, vendorCode, refNo);
                    mv.getModelMap().put("serviceVendorTenderBidItem21_" + i11, serviceVendorTenderBidItem2);
                } else if (service_type.equals("Service3")) {
                    List serviceVendorTenderBidItem3 = serviceVendorTenderBidItem3Service.readVendorRefNo(file_name, vendorCode, refNo);
                    mv.getModelMap().put("serviceVendorTenderBidItem31_" + i11, serviceVendorTenderBidItem3);

                } else if (service_type.equals("Service4")) {
                    List serviceVendorTenderBidItem4 = serviceVendorTenderBidItem4Service.readVendorRefNo(file_name, vendorCode, refNo);
                    mv.getModelMap().put("serviceVendorTenderBidItem41_" + i11, serviceVendorTenderBidItem4);
                } else if (service_type.equals("Service6")) {
                    List serviceVendorTenderBidItem6 = serviceVendorTenderBidItem6Service.readVendorRefNo(file_name, vendorCode, refNo);
                    mv.getModelMap().put("serviceVendorTenderBidItem61_" + i11, serviceVendorTenderBidItem6);
                }
            }
        }

        request.setAttribute("refNo", refNo);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("title", title);
        mv.getModelMap().put("projectId", projectId);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.setViewName("Vendor/PriceBidServiceVendnorSidePrint");
        return mv;
    }

    public ModelAndView priceBidVendorSidePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String refNo = request.getParameter("refNo");

        String vendorCode = request.getParameter("vendorCode");
        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);
        String title = tenderMaster.getTitle();
        String projectId = tenderMaster.getProjectId();
        int tenderPhase = tenderMaster.getTenderPhase();
        String emd = tenderMaster.getEmd();
        String fee = tenderMaster.getDocCost();
        String prNo = tenderMaster.getPrNo();

        String announceDate = tenderMaster.getAnnounceDate();
        String submitLastdate = tenderMaster.getSubmitLastdate();
        String contactPerson = tenderMaster.getContactPerson();
        String tenderAdminContactNumber = tenderMaster.getTenderAdminContactNumber();
        String tenderAuthorizePerson = tenderMaster.getTenderAuthorizePerson();
        String tenderAuthorizeContactNo = tenderMaster.getTenderAuthorizeContactNo();

//         String termsParameter = tenderMaster.getTermsCondition();
//
//        TermsCondition termsCondition = termsConditionService.readByName(termsParameter);
//        int termsParameterId = termsCondition.getId();
//
//        List list4 = termsConditionParameterService.readAllTerms(termsParameterId);
//        mv.getModelMap().put("list4", list4);
//        List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, vendorCode);
        List vendorTermsConditionPriceBid1 = vendorTermsConditionPriceBidService.readByRef(refNo, vendorCode);

//        mv.getModelMap().put("vendorTermsCondition1", vendorTermsCondition1);
        mv.getModelMap().put("vendorTermsCondition1", vendorTermsConditionPriceBid1);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("title", title);
        mv.getModelMap().put("projectId", projectId);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("announceDate", announceDate);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        mv.getModelMap().put("contactPerson", contactPerson);
        mv.getModelMap().put("tenderAdminContactNumber", tenderAdminContactNumber);
        mv.getModelMap().put("tenderAuthorizePerson", tenderAuthorizePerson);
        mv.getModelMap().put("tenderAuthorizeContactNo", tenderAuthorizeContactNo);

        String rfqNo = "";
        String vendorName = "";
        List tenderVendor = tenderVendorService.readByVendor(refNo, vendorCode);
        for (Object o : tenderVendor) {
            TenderVendor tv = (TenderVendor) o;
            rfqNo = tv.getRfqNo();
            vendorName = tv.getVendorName();
        }

        mv.getModelMap().put("rfqNo", rfqNo);
        mv.getModelMap().put("vendorCode", vendorCode);
        mv.getModelMap().put("vendorName", vendorName);

        String technicalRemark = "";
        List tenderTechnical = tenderTechnicalService.readByRefNo(refNo);
        for (Object o : tenderTechnical) {
            TenderTechnical tt = (TenderTechnical) o;
            technicalRemark = tt.getRemark();
        }

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();

        UserRights userRights = userRightsService.readByUser(username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, vendorCode);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, vendorCode);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        mv.getModelMap().put("fee", fee);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);

        VendorTenderBid vendorTenderBid = vendorTenderBidService.readByVendorRefNo(refNo, vendorCode);

        String offerNo = vendorTenderBid.getOfferNo();
        String offerDate = vendorTenderBid.getOfferDate();
        String contact_person = vendorTenderBid.getContactPerson();
        String contact_no = vendorTenderBid.getContactNo();
        String contact_email = vendorTenderBid.getConactEmail();
        String gst_no = vendorTenderBid.getGstNo();

        String serviceDiscountType = vendorTenderBid.getServiceDiscountType();
        String serviceDiscountValue = vendorTenderBid.getServiceDiscountValue();
        String servicegst = vendorTenderBid.getServiceGst();
        String serviceTaxTotal = vendorTenderBid.getServiceTaxTotal();
        String serviceTotal = vendorTenderBid.getServiceTotal();

        if (serviceTotal == null) {
            serviceTotal = "0.0";
        }

        mv.getModelMap().put("serviceDiscountType", serviceDiscountType);
        mv.getModelMap().put("serviceDiscountValue", serviceDiscountValue);
        mv.getModelMap().put("servicegst", servicegst);
        mv.getModelMap().put("serviceTaxTotal", serviceTaxTotal);
        mv.getModelMap().put("serviceTotal", serviceTotal);

        mv.getModelMap().put("vendorTenderBid", vendorTenderBid);
        mv.getModelMap().put("offerNo", offerNo);
        mv.getModelMap().put("offerDate", offerDate);
        mv.getModelMap().put("contact_person", contact_person);
        mv.getModelMap().put("contact_no", contact_no);
        mv.getModelMap().put("contact_email", contact_email);
        mv.getModelMap().put("gst_no", gst_no);

        String deliveryLocation = vendorTenderBid.getDeliveryLocation();
        String deliveryPeriod = vendorTenderBid.getDeliveryPeriod();
        String termsOfPayment = vendorTenderBid.getTermsOfPayment();
        String validityPeriod = vendorTenderBid.getValidityPeriod();
        String modeOfTransport = vendorTenderBid.getModeOfTransport();
        String incoTerms = vendorTenderBid.getIncoTerms();
        String insurance = vendorTenderBid.getInsurance();
        String freight = vendorTenderBid.getFreight();

        mv.getModelMap().put("deliveryLocation", deliveryLocation);
        mv.getModelMap().put("deliveryPeriod", deliveryPeriod);
        mv.getModelMap().put("termsOfPayment", termsOfPayment);
        mv.getModelMap().put("validityPeriod", validityPeriod);
        mv.getModelMap().put("modeOfTransport", modeOfTransport);
        mv.getModelMap().put("incoTerms", incoTerms);
        mv.getModelMap().put("insurance", insurance);
        mv.getModelMap().put("freight", freight);

        String itemTotal = vendorTenderBid.getItemTotal();
        String selectCommon = vendorTenderBid.getSelectCommon();
        String discountType = vendorTenderBid.getDiscountType();
        String discountValue = vendorTenderBid.getDiscountValue();
        String packingType = vendorTenderBid.getPackingType();
        String packingValue = vendorTenderBid.getPackingValue();
        String freightType = vendorTenderBid.getFreightType();
        String freightValue = vendorTenderBid.getFreightValue();
        String errectionValue = vendorTenderBid.getErrectionValue();
        String chargesValue = vendorTenderBid.getChargesValue();
        String igstValue = vendorTenderBid.getIgstValue();
        String cgstValue = vendorTenderBid.getCgstValue();
        String sgstValue = vendorTenderBid.getSgstValue();
        String insuranceValue = vendorTenderBid.getInsuranceValue();
        String grandTotal = vendorTenderBid.getGrandTotal();
        String grandTotalWord = vendorTenderBid.getGrandTotalWord();

        String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
        String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();
        mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
        mv.getModelMap().put("free_delivery_comment", free_delivery_comment);

        mv.getModelMap().put("itemTotal", itemTotal);
        mv.getModelMap().put("selectCommon", selectCommon);
        mv.getModelMap().put("discountType", discountType);
        mv.getModelMap().put("discountValue", discountValue);
        mv.getModelMap().put("packingType", packingType);
        mv.getModelMap().put("packingValue", packingValue);
        mv.getModelMap().put("freightType", freightType);
        mv.getModelMap().put("freightValue", freightValue);
        mv.getModelMap().put("errectionValue", errectionValue);
        mv.getModelMap().put("chargesValue", chargesValue);
        mv.getModelMap().put("igstValue", igstValue);
        mv.getModelMap().put("cgstValue", cgstValue);
        mv.getModelMap().put("sgstValue", sgstValue);
        mv.getModelMap().put("insuranceValue", insuranceValue);
        mv.getModelMap().put("grandTotal", grandTotal);
        mv.getModelMap().put("grandTotalWord", grandTotalWord);

        if (itemTotal == null) {
            itemTotal = "0";
        }
        if (serviceTotal == null) {
            serviceTotal = "0";
        }

        Double itemTotalFinal = Double.parseDouble(itemTotal);
        Double discountValueFinal = 0.0;
        Double packingValueFinal = 0.0;
        Double freightValueFinal = 0.0;
        Double errectionValueFinal = 0.0;
        Double chargesValueFinal = 0.0;
        Double igstValueFinal = 0.0;
        Double cgstValueFinal = 0.0;
        Double sgstValueFinal = 0.0;
        Double insuranceValueFinal = 0.0;
        Double grandTotalFinal = 0.0;
        Double Total = 0.0;

        Double serviceTotalFinal = Double.parseDouble(serviceTotal);
        Double serviceDiscountValueFinal = 0.0;
        Double servicegstFinal = 0.0;
        Double serviceTaxTotalFinal = 0.0;
        Double serviceDiscountTypeFinal = 0.0;
        Double serviceTotal1 = 0.0;

        List vendorTenderBidItem = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, vendorCode, 0);

        ArrayList<VendorBidItem> vbi = new ArrayList<VendorBidItem>();

        if (selectCommon != null && "1".equals(selectCommon)) {
            Total = itemTotalFinal;

            if (packingType.equals("0")) {
                packingValueFinal = Double.parseDouble(packingValue) * Total / 100;
            } else {
                packingValueFinal = Double.parseDouble(packingValue);
            }
            long tmp = Math.round(packingValueFinal * 100);
            packingValueFinal = (double) tmp / 100;

            chargesValueFinal = Double.parseDouble(chargesValue) * Total / 100;
            tmp = Math.round(chargesValueFinal * 100);
            chargesValueFinal = (double) tmp / 100;

            insuranceValueFinal = Double.parseDouble(insuranceValue) * Total / 100;
            tmp = Math.round(insuranceValueFinal * 100);
            insuranceValueFinal = (double) tmp / 100;

            errectionValueFinal = Double.parseDouble(errectionValue) * Total / 100;
            tmp = Math.round(errectionValueFinal * 100);
            errectionValueFinal = (double) tmp / 100;

            Total = Total + packingValueFinal;
            Total = Total + errectionValueFinal;
            Total = Total + insuranceValueFinal;
            Total = Total + chargesValueFinal;

            if (discountType.equals("0")) {
                discountValueFinal = Double.parseDouble(discountValue) * Total / 100;
            } else {
                discountValueFinal = Double.parseDouble(discountValue);
            }
            tmp = Math.round(discountValueFinal * 100);
            discountValueFinal = (double) tmp / 100;
            Total = Total - discountValueFinal;

            /*  if(freightType.equals("0"))
             {
             freightValueFinal = Double.parseDouble(freightValue) * Total / 100;
             }
             else
             {
             freightValueFinal = Double.parseDouble(freightValue);
             }
             tmp = Math.round(freightValueFinal*100);
             freightValueFinal = (double)tmp/100;
             Total = Total + freightValueFinal; */
            igstValueFinal = Double.parseDouble(igstValue) * Total / 100;
            tmp = Math.round(igstValueFinal * 100);
            igstValueFinal = (double) tmp / 100;
            cgstValueFinal = Double.parseDouble(cgstValue) * Total / 100;
            tmp = Math.round(cgstValueFinal * 100);
            cgstValueFinal = (double) tmp / 100;
            sgstValueFinal = Double.parseDouble(sgstValue) * Total / 100;
            tmp = Math.round(sgstValueFinal * 100);
            sgstValueFinal = (double) tmp / 100;
            Total = Total + igstValueFinal + cgstValueFinal + sgstValueFinal;

        } else {
            for (Object o : vendorTenderBidItem) {
                VendorTenderBidItem vtbi = (VendorTenderBidItem) o;

                int itemId = vtbi.getId();
                String itemCode = vtbi.getItemCode();
                String itemDesciption = vtbi.getItemDescription();
                String remark = vtbi.getRemark();
                String uom = vtbi.getUom();
                String qty = vtbi.getQty();
                String purNo = vtbi.getPurNo();
                String itemNo = vtbi.getItemNo();
                String rate = vtbi.getRate();
                String hsnNo = vtbi.getHsnNo();
                String vendorRemark = vtbi.getVendorRemark();
                String itemRegret = vtbi.getItemRegret();

                String individualNetTotal = vtbi.getNetRate();
                String individualDiscountType = vtbi.getDiscountType();
                String individualDiscountValue = vtbi.getDiscountValue();
                String individualPackingType = vtbi.getPackingType();
                String individualPackingValue = vtbi.getPackingValue();
                String individualFreightType = vtbi.getFreightType();
                String individualFreightValue = vtbi.getFreightValue();
                String individualErrectionValue = vtbi.getErrectionValue();
                String individualChargesValue = vtbi.getChargesValue();
                String individualIgstValue = vtbi.getIgstValue();
                String individualCgstValue = vtbi.getCgstValue();
                String individualSgstValue = vtbi.getSgstValue();
                String individualInsuranceValue = vtbi.getInsuranceValue();
                String individualgrandTotal = vtbi.getTotalValue();

                Double individualItemTotalFinal = Double.parseDouble(individualNetTotal);
                Double individualDiscountValueFinal = 0.0;
                Double individualPackingValueFinal = 0.0;
                Double individualFreightValueFinal = 0.0;
                Double individualErrectionValueFinal = 0.0;
                Double individualChargesValueFinal = 0.0;
                Double individualIgstValueFinal = 0.0;
                Double individualCgstValueFinal = 0.0;
                Double individualSgstValueFinal = 0.0;
                Double individualInsuranceValueFinal = 0.0;
                Double individualGrandTotalFinal = 0.0;

                if (individualDiscountType.equals("0")) {
                    individualDiscountValueFinal = Double.parseDouble(individualDiscountValue) * individualItemTotalFinal / 100;
                } else {
                    individualDiscountValueFinal = Double.parseDouble(individualDiscountValue);
                }
                long tmp = Math.round(individualDiscountValueFinal * 100);
                individualDiscountValueFinal = (double) tmp / 100;
                individualGrandTotalFinal = individualItemTotalFinal - individualDiscountValueFinal;
                discountValueFinal = discountValueFinal + individualDiscountValueFinal;

                if (individualPackingType.equals("0")) {
                    individualPackingValueFinal = Double.parseDouble(individualPackingValue) * individualGrandTotalFinal / 100;
                } else {
                    individualPackingValueFinal = Double.parseDouble(individualPackingValue);
                }
                tmp = Math.round(individualPackingValueFinal * 100);
                individualPackingValueFinal = (double) tmp / 100;
                individualGrandTotalFinal = individualGrandTotalFinal + individualPackingValueFinal;
                packingValueFinal = packingValueFinal + individualPackingValueFinal;

                /*   if(individualFreightType.equals("0"))
                 {
                 individualFreightValueFinal = Double.parseDouble(individualFreightValue) * individualGrandTotalFinal / 100;
                 }
                 else
                 {
                 individualFreightValueFinal = Double.parseDouble(individualFreightValue);
                 }
                 tmp = Math.round(individualFreightValueFinal*100);
                 individualFreightValueFinal = (double)tmp/100;
                 individualGrandTotalFinal = individualGrandTotalFinal + individualFreightValueFinal;
                 freightValueFinal = freightValueFinal + individualFreightValueFinal; */
                individualErrectionValueFinal = Double.parseDouble(individualErrectionValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualErrectionValueFinal * 100);
                individualErrectionValueFinal = (double) tmp / 100;
                individualGrandTotalFinal = individualGrandTotalFinal + individualErrectionValueFinal;
                errectionValueFinal = errectionValueFinal + individualErrectionValueFinal;

                individualChargesValueFinal = Double.parseDouble(individualChargesValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualChargesValueFinal * 100);
                individualChargesValueFinal = (double) tmp / 100;
                individualGrandTotalFinal = individualGrandTotalFinal + individualChargesValueFinal;
                chargesValueFinal = chargesValueFinal + individualChargesValueFinal;

                individualIgstValueFinal = Double.parseDouble(individualIgstValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualIgstValueFinal * 100);
                individualIgstValueFinal = (double) tmp / 100;
                igstValueFinal = igstValueFinal + individualIgstValueFinal;

                individualCgstValueFinal = Double.parseDouble(individualCgstValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualCgstValueFinal * 100);
                individualCgstValueFinal = (double) tmp / 100;
                cgstValueFinal = cgstValueFinal + individualCgstValueFinal;

                individualSgstValueFinal = Double.parseDouble(individualSgstValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualSgstValueFinal * 100);
                individualSgstValueFinal = (double) tmp / 100;
                sgstValueFinal = sgstValueFinal + individualSgstValueFinal;

                individualGrandTotalFinal = individualIgstValueFinal + individualCgstValueFinal + individualSgstValueFinal;

                individualInsuranceValueFinal = Double.parseDouble(individualInsuranceValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualInsuranceValueFinal * 100);
                individualInsuranceValueFinal = (double) tmp / 100;
                insuranceValueFinal = insuranceValueFinal + individualInsuranceValueFinal;
                individualGrandTotalFinal = individualGrandTotalFinal + individualInsuranceValueFinal;

                VendorBidItem vendorBidItem1 = new VendorBidItem(itemId, itemCode, itemDesciption, remark, uom, qty, purNo, itemNo, rate, hsnNo, vendorRemark, itemRegret, individualNetTotal, individualDiscountType, individualDiscountValue, individualPackingType, individualPackingValue, individualFreightType, individualFreightValue, individualErrectionValue, individualChargesValue, individualIgstValue, individualCgstValue, individualSgstValue, individualInsuranceValue, individualgrandTotal, individualItemTotalFinal, individualDiscountValueFinal, individualPackingValueFinal, individualFreightValueFinal, individualErrectionValueFinal, individualChargesValueFinal, individualIgstValueFinal, individualCgstValueFinal, individualSgstValueFinal, individualInsuranceValueFinal, individualGrandTotalFinal);
                vbi.add(vendorBidItem1);

            }
        }

        int item_type = 1;

        List vendorTenderBidItem1 = vendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, vendorCode, item_type);

        mv.getModelMap().put("vendorTenderBidItem1", vendorTenderBidItem1);

        if (selectCommon != null && "1".equals(selectCommon)) {

            try {
                serviceTotal1 = serviceTotalFinal;

                if (serviceDiscountType.equals("0")) {
                    serviceDiscountValueFinal = Double.parseDouble(serviceDiscountValue) * serviceTotal1 / 100;
                } else {
                    serviceDiscountValueFinal = Double.parseDouble(serviceDiscountValue);
                }

                long tmp1 = Math.round(serviceDiscountValueFinal * 100);
                serviceDiscountValueFinal = (double) tmp1 / 100;
                serviceTotal1 = serviceTotalFinal - serviceDiscountValueFinal;

                servicegstFinal = Double.parseDouble(servicegst) * serviceTotal1 / 100;
                tmp1 = Math.round(servicegstFinal * 100);
                servicegstFinal = (double) tmp1 / 100;

            } catch (Exception e) {

            }

        }

        mv.getModelMap().put("serviceTotalFinal", serviceTotalFinal);
        mv.getModelMap().put("serviceDiscountValueFinal", serviceDiscountValueFinal);
        mv.getModelMap().put("servicegstFinal", servicegstFinal);
        mv.getModelMap().put("serviceTaxTotalFinal", serviceTaxTotalFinal);
        mv.getModelMap().put("serviceDiscountTypeFinal", serviceDiscountTypeFinal);
        mv.getModelMap().put("serviceTotal1", serviceTotal1);

        mv.getModelMap().put("discountValueFinal", discountValueFinal);
        mv.getModelMap().put("packingValueFinal", packingValueFinal);
        mv.getModelMap().put("freightValueFinal", freightValueFinal);
        mv.getModelMap().put("errectionValueFinal", errectionValueFinal);
        mv.getModelMap().put("chargesValueFinal", chargesValueFinal);
        mv.getModelMap().put("igstValueFinal", igstValueFinal);
        mv.getModelMap().put("cgstValueFinal", cgstValueFinal);
        mv.getModelMap().put("sgstValueFinal", sgstValueFinal);
        mv.getModelMap().put("insuranceValueFinal", insuranceValueFinal);
        mv.getModelMap().put("grandTotalFinal", grandTotalFinal);
        mv.getModelMap().put("Total", Total);

        mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);

        request.setAttribute("refNo", refNo);
        mv.getModelMap().put("vbi", vbi);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("title", title);
        mv.getModelMap().put("projectId", projectId);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        PRMaster prm = prMasterService.readByPrNo(prNo);
        mv.getModelMap().put("prm", prm);
        mv.setViewName("Vendor/PriceBidVendorSidePrint");

        return mv;
    }

    public ModelAndView revisePriceBidReviseVenSidePrint(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String refNo = request.getParameter("refNo");

        String vendorCode = request.getParameter("vendorCode");
        TenderMaster tenderMaster = tenderMasterService.readRefNo(refNo);
        String title = tenderMaster.getTitle();
        String projectId = tenderMaster.getProjectId();
        int tenderPhase = tenderMaster.getTenderPhase();
        String emd = tenderMaster.getEmd();
        String fee = tenderMaster.getDocCost();
        String prNo = tenderMaster.getPrNo();

        String announceDate = tenderMaster.getAnnounceDate();
        String submitLastdate = tenderMaster.getSubmitLastdate();
        String contactPerson = tenderMaster.getContactPerson();
        String tenderAdminContactNumber = tenderMaster.getTenderAdminContactNumber();
        String tenderAuthorizePerson = tenderMaster.getTenderAuthorizePerson();
        String tenderAuthorizeContactNo = tenderMaster.getTenderAuthorizeContactNo();

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("title", title);
        mv.getModelMap().put("projectId", projectId);
        mv.getModelMap().put("prNo", prNo);
        mv.getModelMap().put("announceDate", announceDate);
        mv.getModelMap().put("submitLastdate", submitLastdate);
        mv.getModelMap().put("contactPerson", contactPerson);
        mv.getModelMap().put("tenderAdminContactNumber", tenderAdminContactNumber);
        mv.getModelMap().put("tenderAuthorizePerson", tenderAuthorizePerson);
        mv.getModelMap().put("tenderAuthorizeContactNo", tenderAuthorizeContactNo);

        String rfqNo = "";
        String vendorName = "";
        List tenderVendor = tenderVendorService.readByVendor(refNo, vendorCode);
        for (Object o : tenderVendor) {
            TenderVendor tv = (TenderVendor) o;
            rfqNo = tv.getRfqNo();
            vendorName = tv.getVendorName();
        }

        mv.getModelMap().put("rfqNo", rfqNo);
        mv.getModelMap().put("vendorCode", vendorCode);
        mv.getModelMap().put("vendorName", vendorName);

        String technicalRemark = "";
        List tenderTechnical = tenderTechnicalService.readByRefNo(refNo);
        for (Object o : tenderTechnical) {
            TenderTechnical tt = (TenderTechnical) o;
            technicalRemark = tt.getRemark();
        }

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String location = employeeMaster.getLocation();
        String department = employeeMaster.getDepartment();

        UserRights userRights = userRightsService.readByUser(username);

        //get EMD details
        VendorEmd vendorEmd = vendorEmdService.readByVendorRefNo(refNo, vendorCode);
        String emd_date = vendorEmd.getEmdDate();
        String emd_drawee_bank = vendorEmd.getDraweeBank();
        String emd_cheque_no = vendorEmd.getChequeNo();
        String cash_cheque = vendorEmd.getCashCheque();
        String emd_attach = vendorEmd.getAttachment();

        mv.getModelMap().put("emd", emd);
        mv.getModelMap().put("emd_date", emd_date);
        mv.getModelMap().put("emd_drawee_bank", emd_drawee_bank);
        mv.getModelMap().put("emd_cheque_no", emd_cheque_no);
        mv.getModelMap().put("cash_cheque", cash_cheque);
        mv.getModelMap().put("emd_attach", emd_attach);

        //get Fee Detailss
        VendorFee vendorFee = vendorFeeService.readByVendorRefNo(refNo, vendorCode);
        String fee_date = vendorFee.getFeeDate();
        String fee_drawee_bank = vendorFee.getDraweeBank();
        String fee_cheque_no = vendorFee.getChequeNo();
        String fee_attach = vendorFee.getAttachment();

        mv.getModelMap().put("fee", fee);
        mv.getModelMap().put("fee_date", fee_date);
        mv.getModelMap().put("fee_drawee_bank", fee_drawee_bank);
        mv.getModelMap().put("fee_cheque_no", fee_cheque_no);
        mv.getModelMap().put("fee_attach", fee_attach);

        ReviseVendorTenderBid vendorTenderBid = reviseVendorTenderBidService.readByVendorRefNo(refNo, vendorCode);
        VendorTenderBid vendorTenderBid1 = vendorTenderBidService.readByVendorRefNo(refNo, vendorCode);

        String offerNo = vendorTenderBid.getOfferNo();
        String offerDate = vendorTenderBid.getOfferDate();
        String contact_person = vendorTenderBid.getContactPerson();
        String contact_no = vendorTenderBid.getContactNo();
        String contact_email = vendorTenderBid.getConactEmail();
        String gst_no = vendorTenderBid.getGstNo();

        String serviceDiscountType = vendorTenderBid.getServiceDiscountType();
        String serviceDiscountValue = vendorTenderBid.getServiceDiscountValue();
        String servicegst = vendorTenderBid.getServiceGst();
        String serviceTaxTotal = vendorTenderBid.getServiceTaxTotal();
        String serviceTotal = vendorTenderBid.getServiceTotal();

        if (serviceTotal == null) {
            serviceTotal = "0.0";
        }

        mv.getModelMap().put("serviceDiscountType", serviceDiscountType);
        mv.getModelMap().put("serviceDiscountValue", serviceDiscountValue);
        mv.getModelMap().put("servicegst", servicegst);
        mv.getModelMap().put("serviceTaxTotal", serviceTaxTotal);
        mv.getModelMap().put("serviceTotal", serviceTotal);

        mv.getModelMap().put("vendorTenderBid", vendorTenderBid);
        mv.getModelMap().put("offerNo", offerNo);
        mv.getModelMap().put("offerDate", offerDate);
        mv.getModelMap().put("contact_person", contact_person);
        mv.getModelMap().put("contact_no", contact_no);
        mv.getModelMap().put("contact_email", contact_email);
        mv.getModelMap().put("gst_no", gst_no);

        String deliveryLocation = vendorTenderBid1.getDeliveryLocation();
        String deliveryPeriod = vendorTenderBid1.getDeliveryPeriod();
        String termsOfPayment = vendorTenderBid1.getTermsOfPayment();
        String validityPeriod = vendorTenderBid.getValidityPeriod();
        String modeOfTransport = vendorTenderBid1.getModeOfTransport();
        String incoTerms = vendorTenderBid1.getIncoTerms();
        String insurance = vendorTenderBid.getInsurance();
        String freight = vendorTenderBid.getFreight();

        mv.getModelMap().put("deliveryLocation", deliveryLocation);
        mv.getModelMap().put("deliveryPeriod", deliveryPeriod);
        mv.getModelMap().put("termsOfPayment", termsOfPayment);
        mv.getModelMap().put("validityPeriod", validityPeriod);
        mv.getModelMap().put("modeOfTransport", modeOfTransport);
        mv.getModelMap().put("incoTerms", incoTerms);
        mv.getModelMap().put("insurance", insurance);
        mv.getModelMap().put("freight", freight);

        String itemTotal = vendorTenderBid.getItemTotal();
        String selectCommon = vendorTenderBid.getSelectCommon();
        String discountType = vendorTenderBid.getDiscountType();
        String discountValue = vendorTenderBid.getDiscountValue();
        String packingType = vendorTenderBid.getPackingType();
        String packingValue = vendorTenderBid.getPackingValue();
        String freightType = vendorTenderBid.getFreightType();
        String freightValue = vendorTenderBid.getFreightValue();
        String errectionValue = vendorTenderBid.getErrectionValue();
        String chargesValue = vendorTenderBid.getChargesValue();
        String igstValue = vendorTenderBid.getIgstValue();
        String cgstValue = vendorTenderBid.getCgstValue();
        String sgstValue = vendorTenderBid.getSgstValue();
        String insuranceValue = vendorTenderBid.getInsuranceValue();
        String grandTotal = vendorTenderBid.getGrandTotal();
        String grandTotalWord = vendorTenderBid.getGrandTotalWord();

        String freight_free_delivery = vendorTenderBid.getFreightFreeDelivery();
        String free_delivery_comment = vendorTenderBid.getFreeDeliveryComment();
        mv.getModelMap().put("freight_free_delivery", freight_free_delivery);
        mv.getModelMap().put("free_delivery_comment", free_delivery_comment);

        mv.getModelMap().put("itemTotal", itemTotal);
        mv.getModelMap().put("selectCommon", selectCommon);
        mv.getModelMap().put("discountType", discountType);
        mv.getModelMap().put("discountValue", discountValue);
        mv.getModelMap().put("packingType", packingType);
        mv.getModelMap().put("packingValue", packingValue);
        mv.getModelMap().put("freightType", freightType);
        mv.getModelMap().put("freightValue", freightValue);
        mv.getModelMap().put("errectionValue", errectionValue);
        mv.getModelMap().put("chargesValue", chargesValue);
        mv.getModelMap().put("igstValue", igstValue);
        mv.getModelMap().put("cgstValue", cgstValue);
        mv.getModelMap().put("sgstValue", sgstValue);
        mv.getModelMap().put("insuranceValue", insuranceValue);
        mv.getModelMap().put("grandTotal", grandTotal);
        mv.getModelMap().put("grandTotalWord", grandTotalWord);

        Double itemTotalFinal = Double.parseDouble(itemTotal);
        Double discountValueFinal = 0.0;
        Double packingValueFinal = 0.0;
        Double freightValueFinal = 0.0;
        Double errectionValueFinal = 0.0;
        Double chargesValueFinal = 0.0;
        Double igstValueFinal = 0.0;
        Double cgstValueFinal = 0.0;
        Double sgstValueFinal = 0.0;
        Double insuranceValueFinal = 0.0;
        Double grandTotalFinal = 0.0;
        Double Total = 0.0;

        Double serviceTotalFinal = Double.parseDouble(serviceTotal);
        Double serviceDiscountValueFinal = 0.0;
        Double servicegstFinal = 0.0;
        Double serviceTaxTotalFinal = 0.0;
        Double serviceDiscountTypeFinal = 0.0;
        Double serviceTotal1 = 0.0;

        List vendorTenderBidItem = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, vendorCode, 0);

        ArrayList<VendorBidItem> vbi = new ArrayList<VendorBidItem>();

        if (selectCommon.equals("1")) {
            Total = itemTotalFinal;

            if (packingType.equals("0")) {
                packingValueFinal = Double.parseDouble(packingValue) * Total / 100;
            } else {
                packingValueFinal = Double.parseDouble(packingValue);
            }
            long tmp = Math.round(packingValueFinal * 100);
            packingValueFinal = (double) tmp / 100;

            chargesValueFinal = Double.parseDouble(chargesValue) * Total / 100;
            tmp = Math.round(chargesValueFinal * 100);
            chargesValueFinal = (double) tmp / 100;

            insuranceValueFinal = Double.parseDouble(insuranceValue) * Total / 100;
            tmp = Math.round(insuranceValueFinal * 100);
            insuranceValueFinal = (double) tmp / 100;

            errectionValueFinal = Double.parseDouble(errectionValue) * Total / 100;
            tmp = Math.round(errectionValueFinal * 100);
            errectionValueFinal = (double) tmp / 100;

            Total = Total + packingValueFinal;
            Total = Total + errectionValueFinal;
            Total = Total + insuranceValueFinal;
            Total = Total + chargesValueFinal;

            if (discountType.equals("0")) {
                discountValueFinal = Double.parseDouble(discountValue) * Total / 100;
            } else {
                discountValueFinal = Double.parseDouble(discountValue);
            }
            tmp = Math.round(discountValueFinal * 100);
            discountValueFinal = (double) tmp / 100;
            Total = itemTotalFinal - discountValueFinal;

            igstValueFinal = Double.parseDouble(igstValue) * Total / 100;
            tmp = Math.round(igstValueFinal * 100);
            igstValueFinal = (double) tmp / 100;
            cgstValueFinal = Double.parseDouble(cgstValue) * Total / 100;
            tmp = Math.round(cgstValueFinal * 100);
            cgstValueFinal = (double) tmp / 100;
            sgstValueFinal = Double.parseDouble(sgstValue) * Total / 100;
            tmp = Math.round(sgstValueFinal * 100);
            sgstValueFinal = (double) tmp / 100;
            Total = Total + igstValueFinal + cgstValueFinal + sgstValueFinal;

        } else {
            for (Object o : vendorTenderBidItem) {
                ReviseVendorTenderBidItem vtbi = (ReviseVendorTenderBidItem) o;

                int itemId = vtbi.getId();
                String itemCode = vtbi.getItemCode();
                String itemDesciption = vtbi.getItemDescription();
                String remark = vtbi.getRemark();
                String uom = vtbi.getUom();
                String qty = vtbi.getQty();
                String purNo = vtbi.getPurNo();
                String itemNo = vtbi.getItemNo();
                String rate = vtbi.getRate();
                String hsnNo = vtbi.getHsnNo();
                String vendorRemark = vtbi.getVendorRemark();
                String itemRegret = vtbi.getItemRegret();

                String individualNetTotal = vtbi.getNetRate();
                String individualDiscountType = vtbi.getDiscountType();
                String individualDiscountValue = vtbi.getDiscountValue();
                String individualPackingType = vtbi.getPackingType();
                String individualPackingValue = vtbi.getPackingValue();
                String individualFreightType = vtbi.getFreightType();
                String individualFreightValue = vtbi.getFreightValue();
                String individualErrectionValue = vtbi.getErrectionValue();
                String individualChargesValue = vtbi.getChargesValue();
                String individualIgstValue = vtbi.getIgstValue();
                String individualCgstValue = vtbi.getCgstValue();
                String individualSgstValue = vtbi.getSgstValue();
                String individualInsuranceValue = vtbi.getInsuranceValue();
                String individualgrandTotal = vtbi.getTotalValue();

                Double individualItemTotalFinal = Double.parseDouble(individualNetTotal);
                Double individualDiscountValueFinal = 0.0;
                Double individualPackingValueFinal = 0.0;
                Double individualFreightValueFinal = 0.0;
                Double individualErrectionValueFinal = 0.0;
                Double individualChargesValueFinal = 0.0;
                Double individualIgstValueFinal = 0.0;
                Double individualCgstValueFinal = 0.0;
                Double individualSgstValueFinal = 0.0;
                Double individualInsuranceValueFinal = 0.0;
                Double individualGrandTotalFinal = 0.0;

                if (individualDiscountType.equals("0")) {
                    individualDiscountValueFinal = Double.parseDouble(individualDiscountValue) * individualItemTotalFinal / 100;
                } else {
                    individualDiscountValueFinal = Double.parseDouble(individualDiscountValue);
                }
                long tmp = Math.round(individualDiscountValueFinal * 100);
                individualDiscountValueFinal = (double) tmp / 100;
                individualGrandTotalFinal = individualItemTotalFinal - individualDiscountValueFinal;
                discountValueFinal = discountValueFinal + individualDiscountValueFinal;

                if (individualPackingType.equals("0")) {
                    individualPackingValueFinal = Double.parseDouble(individualPackingValue) * individualGrandTotalFinal / 100;
                } else {
                    individualPackingValueFinal = Double.parseDouble(individualPackingValue);
                }
                tmp = Math.round(individualPackingValueFinal * 100);
                individualPackingValueFinal = (double) tmp / 100;
                individualGrandTotalFinal = individualGrandTotalFinal + individualPackingValueFinal;
                packingValueFinal = packingValueFinal + individualPackingValueFinal;

                individualErrectionValueFinal = Double.parseDouble(individualErrectionValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualErrectionValueFinal * 100);
                individualErrectionValueFinal = (double) tmp / 100;
                individualGrandTotalFinal = individualGrandTotalFinal + individualErrectionValueFinal;
                errectionValueFinal = errectionValueFinal + individualErrectionValueFinal;

                individualChargesValueFinal = Double.parseDouble(individualChargesValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualChargesValueFinal * 100);
                individualChargesValueFinal = (double) tmp / 100;
                individualGrandTotalFinal = individualGrandTotalFinal + individualChargesValueFinal;
                chargesValueFinal = chargesValueFinal + individualChargesValueFinal;

                individualIgstValueFinal = Double.parseDouble(individualIgstValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualIgstValueFinal * 100);
                individualIgstValueFinal = (double) tmp / 100;
                igstValueFinal = igstValueFinal + individualIgstValueFinal;

                individualCgstValueFinal = Double.parseDouble(individualCgstValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualCgstValueFinal * 100);
                individualCgstValueFinal = (double) tmp / 100;
                cgstValueFinal = cgstValueFinal + individualCgstValueFinal;

                individualSgstValueFinal = Double.parseDouble(individualSgstValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualSgstValueFinal * 100);
                individualSgstValueFinal = (double) tmp / 100;
                sgstValueFinal = sgstValueFinal + individualSgstValueFinal;

                individualGrandTotalFinal = individualIgstValueFinal + individualCgstValueFinal + individualSgstValueFinal;

                individualInsuranceValueFinal = Double.parseDouble(individualInsuranceValue) * individualGrandTotalFinal / 100;
                tmp = Math.round(individualInsuranceValueFinal * 100);
                individualInsuranceValueFinal = (double) tmp / 100;
                insuranceValueFinal = insuranceValueFinal + individualInsuranceValueFinal;
                individualGrandTotalFinal = individualGrandTotalFinal + individualInsuranceValueFinal;

                VendorBidItem vendorBidItem1 = new VendorBidItem(itemId, itemCode, itemDesciption, remark, uom, qty, purNo, itemNo, rate, hsnNo, vendorRemark, itemRegret, individualNetTotal, individualDiscountType, individualDiscountValue, individualPackingType, individualPackingValue, individualFreightType, individualFreightValue, individualErrectionValue, individualChargesValue, individualIgstValue, individualCgstValue, individualSgstValue, individualInsuranceValue, individualgrandTotal, individualItemTotalFinal, individualDiscountValueFinal, individualPackingValueFinal, individualFreightValueFinal, individualErrectionValueFinal, individualChargesValueFinal, individualIgstValueFinal, individualCgstValueFinal, individualSgstValueFinal, individualInsuranceValueFinal, individualGrandTotalFinal);
                vbi.add(vendorBidItem1);

            }
        }

        int item_type = 1;

        List vendorTenderBidItem1 = reviseVendorTenderBidItemService.readByVendorRefNoAndItemType(refNo, vendorCode, item_type);

        mv.getModelMap().put("vendorTenderBidItem1", vendorTenderBidItem1);

        if (selectCommon.equals("1")) {

            try {
                serviceTotal1 = serviceTotalFinal;

                if (serviceDiscountType.equals("0")) {
                    serviceDiscountValueFinal = Double.parseDouble(serviceDiscountValue) * serviceTotal1 / 100;
                } else {
                    serviceDiscountValueFinal = Double.parseDouble(serviceDiscountValue);
                }

                long tmp1 = Math.round(serviceDiscountValueFinal * 100);
                serviceDiscountValueFinal = (double) tmp1 / 100;
                serviceTotal1 = serviceTotalFinal - serviceDiscountValueFinal;

                servicegstFinal = Double.parseDouble(servicegst) * serviceTotal1 / 100;
                tmp1 = Math.round(servicegstFinal * 100);
                servicegstFinal = (double) tmp1 / 100;

            } catch (Exception e) {

            }

        }
        List vendorTermsCondition1 = vendorTermsConditionService.readByRef(refNo, vendorCode);

        mv.getModelMap().put("vendorTermsCondition1", vendorTermsCondition1);
//        mv.getModelMap().put("vendorTermsCondition1", vendorTermsConditionPriceBid1);

        mv.getModelMap().put("serviceTotalFinal", serviceTotalFinal);
        mv.getModelMap().put("serviceDiscountValueFinal", serviceDiscountValueFinal);
        mv.getModelMap().put("servicegstFinal", servicegstFinal);
        mv.getModelMap().put("serviceTaxTotalFinal", serviceTaxTotalFinal);
        mv.getModelMap().put("serviceDiscountTypeFinal", serviceDiscountTypeFinal);
        mv.getModelMap().put("serviceTotal1", serviceTotal1);

        mv.getModelMap().put("discountValueFinal", discountValueFinal);
        mv.getModelMap().put("packingValueFinal", packingValueFinal);
        mv.getModelMap().put("freightValueFinal", freightValueFinal);
        mv.getModelMap().put("errectionValueFinal", errectionValueFinal);
        mv.getModelMap().put("chargesValueFinal", chargesValueFinal);
        mv.getModelMap().put("igstValueFinal", igstValueFinal);
        mv.getModelMap().put("cgstValueFinal", cgstValueFinal);
        mv.getModelMap().put("sgstValueFinal", sgstValueFinal);
        mv.getModelMap().put("insuranceValueFinal", insuranceValueFinal);
        mv.getModelMap().put("grandTotalFinal", grandTotalFinal);
        mv.getModelMap().put("Total", Total);

        mv.getModelMap().put("vendorTenderBidItem", vendorTenderBidItem);

        request.setAttribute("refNo", refNo);

        mv.getModelMap().put("vbi", vbi);

        mv.getModelMap().put("refNo", refNo);
        mv.getModelMap().put("title", title);
        mv.getModelMap().put("projectId", projectId);
        mv.getModelMap().put("tenderPhase", tenderPhase);
        mv.getModelMap().put("tenderMaster", tenderMaster);
        mv.setViewName("Vendor/RevisePriceBidReviseVenSidePrint");
        return mv;
    }

}
