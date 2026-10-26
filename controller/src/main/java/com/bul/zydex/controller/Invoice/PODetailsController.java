/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Invoice;

import com.bul.zydex.controller.CustomAbstract;
import static com.bul.zydex.controller.CustomAbstract.dateFormat;
import static com.bul.zydex.controller.CustomAbstract.myIp;
import static com.bul.zydex.controller.CustomAbstract.timeFOrmat;
import com.bul.zydex.model.DocumentType;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.InvoiceAttachment;
import com.bul.zydex.model.InvoiceMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.PoDetails;
import com.bul.zydex.model.TenderFollowup;
import com.bul.zydex.model.TenderMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRights;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.util.DownloadFile;
import com.bul.zydex.util.SendMail;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Admin // service is InvoiceService Dao is InvoiceDao and Controller
 * is PODetails
 */
public class PODetailsController extends CustomAbstract {

    public ModelAndView documentTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

        mv.setViewName("PO/DocumentTypeList");
        return mv;

    }

    public ModelAndView documentTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        mv.setViewName("PO/DocumentTypeCreate");
        return mv;
    }

    public ModelAndView submitDocumentTypeCreate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String documentType = request.getParameter("documentType");

        DocumentType documentType1 = new DocumentType();

        documentType1.setName(documentType);

        if (!documentTypeService.isExist(documentType1)) {
            documentTypeService.create(documentType1);

            session1.setAttribute("successMessage", "Document Type Created Successfully");
            mv.setViewName("redirect:poDetails.htm?act=documentTypeList");

        } else {

            session1.setAttribute("failureMessage", "Document Type Already Exist. Please Enter Document Type");
            mv.setViewName("redirect:poDetails.htm?act=documentTypeCreate");
        }

        return mv;

    }

    public ModelAndView documentTypeEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        String id = request.getParameter("id");

        DocumentType documentType = documentTypeService.readById(Integer.parseInt(id));

        mv.getModelMap().put("documentType", documentType);
        mv.getModelMap().put("id", id);
        mv.setViewName("PO/DocumentTypeEdit");

        return mv;

    }

    public ModelAndView documentTypeEditSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        HttpSession session1 = request.getSession(false);

        String documentType = request.getParameter("documentType");

        DocumentType documentType1 = documentTypeService.readById(Integer.parseInt(id));
        documentType1.setName(documentType);
        documentTypeService.update(documentType1);

        session1.setAttribute("successMessage", " Document Type Edited successfully");
        mv.setViewName("redirect:poDetails.htm?act=documentTypeList");

        return mv;
    }

    public ModelAndView deleteDocumentTypeList(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");

        DocumentType documentType1 = documentTypeService.readById(Integer.parseInt(id));

        documentTypeService.delete(Integer.parseInt(id));

        mv.setViewName("redirect:poDetails.htm?act=documentTypeList");

        return mv;
    }

    public ModelAndView deleteDocumentTypeMulti(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();

        String ids = request.getParameter("ids");

        String[] idArray = ids.split(",");
        for (String checkedValues : idArray) {
            documentTypeService.delete(Integer.parseInt(checkedValues));
        }

        session1.setAttribute("successMessage", " Document Type Deleted successfully");

        mv.setViewName("redirect:poDetails.htm?act=documentTypeList");

        return mv;
    }

    public ModelAndView documentPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "id";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "id";
                    break;
                case "2":
                    orderColumn = "name";
                    break;
                default:
                    orderColumn = "id";
                    break;
            }
        }

        List list = documentTypeService.getDocumentPagination(start, length, searchValue, orderColumn, orderDir);

        int totalRecords = documentTypeService.getTotalChargerCount();

        int filteredRecords = documentTypeService.getFilteredChargerCount(searchValue);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            DocumentType documentType = (DocumentType) obj;

            JSONObject json = new JSONObject();

            json.put("checkbox", "<input type='checkbox' " + "class='rowCheckbox' " + "value='" + documentType.getId() + "'>");

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("name", documentType.getName());

            json.put("action",
                    "<div class='d-flex align-items-center justify-content-center'>"
                    + "<a href='poDetails.htm?act=documentTypeEdit&id="
                    + documentType.getId()
                    + "' class='d-block text-info p-1 mx-1'>"
                    + "<img src=\"StorageYard/assets/images/edit-icon.svg\" "
                    + "style='width:18px;height:18px;'>"
                    + "</a>"
                    + "<a href='javascript:void(0);' "
                    + "class='delete-btn1 d-block text-danger p-1 mx-1' "
                    + "data-id='" + documentType.getId() + "'>"
                    + "<img src=\"StorageYard/assets/images/delete-icon.svg\" "
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

    public ModelAndView poDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
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
        mv.setViewName("PO/PoDetails");
        return mv;
    }

    public ModelAndView poDetailsPaginationAjax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        int draw = Integer.parseInt(request.getParameter("draw"));
        int start = Integer.parseInt(request.getParameter("start"));
        int length = Integer.parseInt(request.getParameter("length"));
        String searchValue = request.getParameter("search[value]");
        String orderColumnIndex = request.getParameter("order[0][column]");
        String orderDir = request.getParameter("order[0][dir]");

        if (orderDir == null || orderDir.trim().equals("")) {
            orderDir = "asc";
        }

        String orderColumn = "poNo";

        if (orderColumnIndex != null) {
            switch (orderColumnIndex) {
                case "1":
                    orderColumn = "poNo";
                    break;
                case "2":
                    orderColumn = "tenderNo";
                    break;

                case "3":
                    orderColumn = "poDate";
                    break;
                case "4":
                    orderColumn = "poValue";
                    break;
                case "5":
                    orderColumn = "noDocumentAttached";
                    break;
                case "6":
                    orderColumn = "status";
                    break;
                default:
                    orderColumn = "poNo";
                    break;
            }
        }

        List list = poDetailsService.getPoDetailsPagination(start, length, searchValue, orderColumn, orderDir, username);

        int totalRecords = poDetailsService.getTotalPoDetailsCount(username);

        int filteredRecords = poDetailsService.getFilteredPoDetailsCount(searchValue, username);

        JSONArray dataArray = new JSONArray();

        boolean isDesc = "desc".equalsIgnoreCase(orderDir) && "2".equals(orderColumnIndex);

        int srNo;

        if (isDesc) {
            srNo = filteredRecords - start;
        } else {
            srNo = start + 1;
        }

        for (Object obj : list) {

            PoDetails poDetails = (PoDetails) obj;

            JSONObject json = new JSONObject();

            if (isDesc) {
                json.put("srNo", srNo--);
            } else {
                json.put("srNo", srNo++);
            }

            json.put("prNo", poDetails.getPrNo());
            json.put("tenderNo", poDetails.getTenderNo());
            json.put("poNo", poDetails.getPoNo());
            json.put("poDate", poDetails.getPoDate());
            json.put("poValue", poDetails.getPoValue());
            json.put("noDocumentAttached", poDetails.getNoDocumentAttached());

            String statusText;
            if (poDetails.getStatus() == 0) {
                statusText = "Document Pending";

            } else {
                statusText = "Document Uploaded";
            }
            json.put("status", statusText);
            if (poDetails.getStatus() == 0) {
                json.put(
                        "action",
                        "<div class='d-flex align-items-center justify-content-center'>"
                        + "<a href='poDetails.htm?act=uploadInvoice&id="
                        + poDetails.getId()
                        + "' class='btn theme-btn btn-sm'>"
                        + "Submit Document"
                        + "</a>"
                        + "</div>"
                );

            } else {
                json.put(
                        "action",
                        "<div class='d-flex align-items-center justify-content-center'>"
                        + "<a href='poDetails.htm?act=viewInvoice&id="
                        + poDetails.getId()
                        + "' class='btn theme-btn btn-sm'>"
                        + "View Document"
                        + "</a>"
                        + "</div>"
                );
            }

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

    public ModelAndView uploadInvoice(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
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
        List documentTypeList = documentTypeService.read();

        session.setAttribute("documentTypeList", documentTypeList);
        session.setAttribute("id", id);
        mv.setViewName("PO/UploadInvoice");
        return mv;
    }

    public ModelAndView submitInvoice(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (session == null) ? null : (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        VendorMaster vendorMaster = vendorMasterService.read(username);
        if (user == null) {
            mv.setViewName("redirect:login.htm");
            return mv;
        }
        Date date = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String sysdate = sdf4.format(date);
        String id = request.getParameter("id");
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));

        int poId = poDetails.getId();

        String policyCountStr = request.getParameter("policyCount");
        int policyCount = 0;
        if (policyCountStr != null && !policyCountStr.trim().equals("")) {
            policyCount = Integer.parseInt(policyCountStr);
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        // ---------------- 1st pass: server-side required validation ----------------
        for (int i = 1; i <= policyCount; i++) {

            String documentType = multipartRequest.getParameter("documentName" + i);
            if (documentType == null) {
                continue;   // row was removed on the page
            }
            documentType = documentType.trim();

            String documentNo = trim(multipartRequest.getParameter("documentNo" + i));
            String invoiceAmount = trim(multipartRequest.getParameter("invoiceAmount" + i));
            String otherType = trim(multipartRequest.getParameter("otherDocumentType" + i));
            MultipartFile file = multipartRequest.getFile("attachDocument" + i);

            String error = null;
            if (documentType.isEmpty()) {
                error = "Please select document type.";
            } else if (documentNo.isEmpty()) {
                error = "Document No is required.";
            } else if (documentType.toLowerCase().contains("invoice") && invoiceAmount.isEmpty()) {
                error = "Invoice Amount is required.";
            } else if (documentType.toLowerCase().contains("invoice") && !invoiceAmount.matches("\\d+(\\.\\d{1,2})?")) {
                error = "Enter a valid Invoice Amount.";
            } else if (documentType.equals("Other") && otherType.isEmpty()) {
                error = "Other Document Type is required.";
            } else if (file == null || file.getSize() <= 0) {
                error = "Please attach a document.";
            }

            if (error != null) {
                session.setAttribute("failureMessage", error);
                mv.setViewName("redirect:poDetails.htm?act=uploadInvoice&id=" + id);
                return mv;
            }
        }

        List invoiceMasterList = invoiceMasterService.readByPoNoAndVendorCode(poDetails.getPoNo(), username);
        if (invoiceMasterList.isEmpty()) {
            InvoiceMaster invoiceMaster = new InvoiceMaster();
            invoiceMaster.setPoNumber(poDetails.getPoNo());
            invoiceMaster.setTenderNo(poDetails.getTenderNo());
            invoiceMaster.setVendorCode(username);
            invoiceMaster.setVendorName(vendorMaster.getVendorName());
            invoiceMaster.setStatus(0);
            invoiceMaster.setPoId(poDetails.getId());
            invoiceMaster.setInvoiceAmount(poDetails.getPoValue());
            invoiceMasterService.create(invoiceMaster);
        }
        // ---------------- 2nd pass: save files + records ----------------
        for (int i = 1; i <= policyCount; i++) {

            String documentType = multipartRequest.getParameter("documentName" + i);
            if (documentType == null) {
                continue;   // removed row
            }
            documentType = documentType.trim();

            String documentNo = trim(multipartRequest.getParameter("documentNo" + i));
            String invoiceAmount = trim(multipartRequest.getParameter("invoiceAmount" + i));
            String otherType = trim(multipartRequest.getParameter("otherDocumentType" + i));
            MultipartFile multipartFile = multipartRequest.getFile("attachDocument" + i);

            boolean isInvoice = documentType.toLowerCase().contains("invoice");
            boolean isOther = documentType.equals("Other");

            try {
                String uploadPath = session.getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "Invoice"
                        + File.separator + poId + File.separator;
                File uploadDirectory = new File(uploadPath);
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs();
                }

                String fileName = multipartFile.getOriginalFilename().replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                File photoFile = new File(uploadPath + fileName);
                multipartFile.transferTo(photoFile);

                InvoiceAttachment invoiceAttachment = new InvoiceAttachment();
                invoiceAttachment.setPoId(poId);
                invoiceAttachment.setInvoiceAttachment(fileName);
                invoiceAttachment.setDocumentType(documentType);                       // Invoice / ... / Other
                invoiceAttachment.setOtherDocumentNo(isOther ? otherType : null); // typed name when "Other"
                invoiceAttachment.setDocumentNo(documentNo);                           // always saved
//            invoiceAttachment.setInvoiceNo(isInvoice ? documentNo : null);         // keeps old invoiceNo usage working
                invoiceAttachment.setInvoiceAmount(isInvoice ? invoiceAmount : null);
                invoiceAttachment.setPoNo(poDetails.getPoNo());
                invoiceAttachment.setTenderNo(poDetails.getTenderNo());                // <-- change if your getter differs
                // otherDocumentNo is not collected on this page
                invoiceAttachment.setStatus(0);
                invoiceAttachment.setVendorCode(username);
                invoiceAttachment.setVendorName(vendorMaster.getVendorName());
                invoiceAttachmentService.create(invoiceAttachment);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        List invoiceAttachmentList = invoiceAttachmentService.readByPoId(id, username);
        poDetails.setNoDocumentAttached(invoiceAttachmentList.size());
        poDetails.setStatus(1);
        poDetailsService.update(poDetails);
        String poNo = poDetails.getPoNo();
        String tenderNo = poDetails.getTenderNo();
        TenderMaster tenderMaster = tenderMasterService.readRefNo(tenderNo);
        try {

            String buyerCode = tenderMaster.getTenderAdmin();
            EmployeeMaster employeeMaster = employeeMasterService.read(buyerCode);
            EmailTemplate emailTemplate1 = emailTemplateService.readById(205);
            String subject1 = emailTemplate1.getSubject().replace("{po_no}", poNo);
            String msg1 = "";
            String mail_from1 = vendorMaster.getVendorEmailID();
            String mail_to1 = employeeMaster.getEmailId();
            subject1 = emailTemplate1.getSubject();
            msg1 = emailTemplate1.getBodytext();

            msg1 = msg1.replaceAll("\\{po_no\\}", poNo);
            msg1 = msg1.replaceAll("\\{tender_no\\}", tenderNo);
            msg1 = msg1.replaceAll("\\{username\\}", username);
            msg1 = msg1.replaceAll("\\{createddate\\}", sysdate);
            msg1 = msg1.replaceAll("\\{vendor_name\\}", vendorMaster.getVendorName());

            SendMail s = new SendMail();
            s.sendMail(mail_from1, mail_to1, subject1, msg1);
        } catch (Exception e) {

        }
        //HttpSession session = request.getSession(false);
        UserMaster user11 = (UserMaster) session.getAttribute("user");
        LogsMaster lm = new LogsMaster();
        lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Vendor uploaded document of PO No: " + poNo).setDrow("Y");
        logService.create(lm);

        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        TenderFollowup tenderFollowup = new TenderFollowup();
        tenderFollowup.setActivityDate(formattedDate1);
        tenderFollowup.setActivity("Vendor uploaded document of PO No: " + poNo);
        tenderFollowup.setLocation("");
        tenderFollowup.setTenderNo(tenderNo);
        tenderFollowup.setPerson(user11.getLoginName());
        tenderFollowup.setPersonFullname(user11.getUserFullName());
        tenderFollowupService.create(tenderFollowup);
        session.setAttribute("successMessage", "Documents uploaded successfully.");
        mv.setViewName("redirect:poDetails.htm?act=poDetails");
        return mv;
    }

// helper (put once in the controller class)
    private String trim(String value) {
        return value == null ? "" : value.trim();
    }

    public ModelAndView viewInvoice(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        String poNo = poDetails.getPoNo();
        TenderMaster tenderMaster = tenderMasterService.readRefNo(poDetails.getTenderNo());
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
        List documentTypeList = documentTypeService.read();

        session.setAttribute("documentTypeList", documentTypeList);
        List invoiceAttachmentList = invoiceAttachmentService.readByPoId(id, username);
        session.setAttribute("poDetails", poDetails);
        session.setAttribute("tenderMaster", tenderMaster);
        session.setAttribute("invoiceAttachmentList", invoiceAttachmentList);
        session.setAttribute("id", id);
        mv.setViewName("PO/ViewInvoice");
        return mv;
    }

    public ModelAndView viewPoDocuments(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
        String vendorCode = request.getParameter("vendorCode");
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        TenderMaster tenderMaster = tenderMasterService.readRefNo(poDetails.getTenderNo());
        String poNo = poDetails.getPoNo();
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
        List invoiceAttachmentList = invoiceAttachmentService.readByPoId(id, vendorCode);
//        InvoiceMaster invoiceMaster = invoiceMasterService.readByPoNoAndVendorCode1(poNo, vendorCode);
        InvoiceMaster invoiceMaster = invoiceMasterService.readByPoId(poDetails.getId(), vendorCode);

        session.setAttribute("invoiceMaster", invoiceMaster);
        session.setAttribute("poDetails", poDetails);
        session.setAttribute("tenderMaster", tenderMaster);
        session.setAttribute("invoiceAttachmentList", invoiceAttachmentList);
        session.setAttribute("id", id);
        mv.setViewName("PO/ViewPoDocuments");
        return mv;
    }

    public void downloadPOAttachFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Invoice"
                + File.separator + id + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public void downloadPOBuyerAttachFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Invoice" + File.separator + "Buyer"
                + File.separator + id + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public void downloadPOGrnAttachFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Invoice" + File.separator + "GRN"
                + File.separator + id + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public void downloadPOFinancialAttachFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String fileName = request.getParameter("fileName");
        String id = request.getParameter("id");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();

        String certificateFileLocationURL = getServletContext().getRealPath("/")
                + File.separator + "StorageYard" + File.separator + "Invoice" + File.separator + "Financial"
                + File.separator + id + File.separator + fileName;

        request.setAttribute("filePath", certificateFileLocationURL);

        DownloadFile downloadFile = new DownloadFile();
        downloadFile.doDownload(request, response);
    }

    public ModelAndView updateDocumentStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (session == null) ? null : (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        if (user == null) {
            mv.setViewName("redirect:login.htm");
            return mv;
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        String id = multipartRequest.getParameter("id");
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        String vendorCode = poDetails.getVendorCode();

        String docAction = multipartRequest.getParameter("docAction");
        String docId = multipartRequest.getParameter("docIds");
        String backUrl = "redirect:poDetails.htm?act=viewPoDocuments&id=" + id + "&vendorCode=" + vendorCode;
        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);
        if (docId == null || docId.trim().isEmpty() || docAction == null) {
            session.setAttribute("failureMessage", "Please select a document.");
            mv.setViewName(backUrl);
            return mv;
        }
        docId = docId.trim();
        boolean actionSuccess = false;
        String finalAttachment = "";
        int status;
        String doneText;
        if ("Accept".equals(docAction)) {
            status = 2;                 // Document Accepted
            doneText = "accepted";
        } else if ("Recycle".equals(docAction)) {
            status = 3;                 // Document Recycle
            doneText = "recycled";
        } else if ("Reject".equals(docAction)) {
            status = 4;                 // Document Rejected  
            doneText = "rejected";
        } else {
            session.setAttribute("failureMessage", "Invalid action.");
            mv.setViewName(backUrl);
            return mv;
        }

        String remark = multipartRequest.getParameter("remark_" + docId);
        remark = (remark == null) ? "" : remark.trim();
        InvoiceMaster invoiceMaster = invoiceMasterService.readByPoId(poDetails.getId(), vendorCode);
        // remark is mandatory for Recycle and Reject
        if ((status == 3 || status == 4) && remark.isEmpty() && invoiceMaster.getGrnFlag() != 3) {
            session.setAttribute("failureMessage", "Remark is required to " + ("Recycle".equals(docAction) ? "recycle" : "reject") + " a document.");
            mv.setViewName(backUrl);
            return mv;
        }
        InvoiceAttachment attachment = null;
        try {
            attachment = invoiceAttachmentService.readById(Integer.parseInt(docId));

            if (attachment == null) {
                session.setAttribute("failureMessage", "Document not found.");
            } else if (attachment.getPoId() != Integer.parseInt(id)) {
                session.setAttribute("failureMessage", "Invalid document.");
            } else if (attachment.getStatus() != 0 && invoiceMaster.getGrnFlag() == 0) {
                session.setAttribute("failureMessage", "This document has already been processed.");
            } else {

                // value already saved (e.g. file given at an earlier Recycle)
                String previousBuyerAttachment = attachment.getBuyerAttachment();
                String newBuyerAttachment = null;

                // optional NEW attachment for this action
                MultipartFile file = multipartRequest.getFile("actionFile_" + docId);
                if (file != null && file.getSize() > 0) {
                    String uploadPath = session.getServletContext().getRealPath("/") + File.separator + "StorageYard"
                            + File.separator + "Invoice"
                            + File.separator + "Buyer"
                            + File.separator + attachment.getPoId() + File.separator;
                    File uploadDirectory = new File(uploadPath);
                    if (!uploadDirectory.exists()) {
                        uploadDirectory.mkdirs();
                    }

                    // timestamp stops a repeat upload with the same name from overwriting the earlier file
                    String fileName = file.getOriginalFilename()
                            .replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    file.transferTo(new File(uploadPath + fileName));
                    newBuyerAttachment = fileName;
                }

                // new file wins, otherwise keep what was already saved
                finalAttachment = (newBuyerAttachment != null) ? newBuyerAttachment : previousBuyerAttachment;

                attachment.setBuyerAttachment(finalAttachment == null ? "" : finalAttachment);
                attachment.setBuyerComment(remark.isEmpty() ? null : remark);
                attachment.setStatus(status);
                attachment.setGrnStatus(0);
                invoiceAttachmentService.update(attachment);
                actionSuccess = true;

                session.setAttribute("successMessage", "Document " + doneText + " successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("failureMessage", "Something went wrong. Please try again.");
        }
        int status1 = 3;

        boolean isExistByRecycle = invoiceAttachmentService.readByRecycleStatus(poDetails.getId(), status1);

        if (!isExistByRecycle) {
            invoiceMaster.setBuyerStatus(0);
            invoiceMasterService.update(invoiceMaster);
        }
        if (actionSuccess) {
            // status-wise activity text
            String actionText;
            if (status == 2) {
                actionText = "Buyer accepted document";
            } else if (status == 3) {
                actionText = "Buyer recycled document";

                String poNo = poDetails.getPoNo();
                String tenderNo = poDetails.getTenderNo();
                TenderMaster tenderMaster = tenderMasterService.readRefNo(tenderNo);
                VendorMaster vendorMaster = vendorMasterService.read(vendorCode);

                try {

                    String buyerCode = tenderMaster.getTenderAdmin();
                    EmployeeMaster employeeMaster = employeeMasterService.read(buyerCode);
                    EmailTemplate emailTemplate1 = emailTemplateService.readById(207);
                    String subject1 = emailTemplate1.getSubject().replace("{po_no}", poNo);
                    String msg1 = "";
                    String mail_from1 = employeeMaster.getEmailId();
                    String mail_to1 = vendorMaster.getVendorEmailID();
                    subject1 = emailTemplate1.getSubject();
                    msg1 = emailTemplate1.getBodytext();

                    msg1 = msg1.replaceAll("\\{po_no\\}", poNo);
                    msg1 = msg1.replaceAll("\\{tender_no\\}", tenderNo);
                    msg1 = msg1.replaceAll("\\{remark\\}", remark);
                    msg1 = msg1.replaceAll("\\{username\\}", username);
                    msg1 = msg1.replaceAll("\\{document_type\\}", attachment.getDocumentType());
                    msg1 = msg1.replaceAll("\\{document_no\\}", attachment.getDocumentNo());
                    msg1 = msg1.replaceAll("\\{createddate\\}", formattedDate1);
                    msg1 = msg1.replaceAll("\\{buyer_name\\}", employeeMaster.getName());
                    msg1 = msg1.replaceAll("\\{vendor_name\\}", vendorMaster.getVendorName());

                    SendMail s = new SendMail();
                    s.sendMail(mail_from1, mail_to1, subject1, msg1);
                } catch (Exception e) {

                }
            } else { // status == 4
                actionText = "Buyer rejected document";
            }

            String activity = actionText
                    + (finalAttachment == null || finalAttachment.isEmpty() ? "" : " (" + finalAttachment + ")")
                    + " of PO No: " + poDetails.getPoNo()
                    + (remark == null || remark.isEmpty() ? "" : " - Remark: " + remark);
            Date date = new java.util.Date();
            // 'user' is already in scope from the top of the method
            LogsMaster lm = new LogsMaster();
            lm.setlDate(dateFormat.format(date))
                    .setTime(timeFOrmat.format(date))
                    .setUserName(user.getUserFullName())
                    .setIp(myIp)
                    .setAction(activity)
                    .setDrow("Y");
            logService.create(lm);

            TenderFollowup tenderFollowup = new TenderFollowup();
            tenderFollowup.setActivityDate(formattedDate1);
            tenderFollowup.setActivity(activity);
            tenderFollowup.setLocation("");
            tenderFollowup.setTenderNo(poDetails.getTenderNo());
            tenderFollowup.setPerson(user.getLoginName());
            tenderFollowup.setPersonFullname(user.getUserFullName());
            tenderFollowupService.create(tenderFollowup);
        }

        mv.setViewName(backUrl);
        return mv;

    }

    public ModelAndView sendToGrnExecutive(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (session == null) ? null : (UserMaster) session.getAttribute("user");

        String buyerRemark = request.getParameter("buyerRemark");
        if (user == null) {
            mv.setViewName("redirect:login.htm");
            return mv;
        }
        String username = user.getLoginName();
        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);
        String id = request.getParameter("id");

        // PO id
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        String refNo = poDetails.getTenderNo();
        String vendorCode = poDetails.getVendorCode();
        String poNo = poDetails.getPoNo();
        String backUrl = "redirect:tenderMaster.htm?act=priceBidComparisonData&refNo=" + refNo;

        try {
            List<InvoiceAttachment> list = invoiceAttachmentService.readByPoId(id, poDetails.getVendorCode());

            // server-side check: every document must be Accepted (2) or Rejected (4)
            boolean hasUnresolved = false;
            if (list != null) {
                for (InvoiceAttachment a : list) {
                    if (a.getStatus() == 0 || a.getStatus() == 3) {
                        hasUnresolved = true;
                        break;
                    }
                }
            }

            if (list == null || list.isEmpty()) {
                session.setAttribute("failureMessage", "No documents to send.");
            } else if (hasUnresolved) {
                session.setAttribute("failureMessage", "All documents must be accepted or rejected before sending to GRN Executive.");
            } else {

                InvoiceMaster invoiceMaster = invoiceMasterService.readByPoId(poDetails.getId(), vendorCode);

                invoiceMaster.setBuyerComment(buyerRemark);
                invoiceMaster.setBuyerStatus(1);
                invoiceMasterService.update(invoiceMaster);

                String tenderNo = poDetails.getTenderNo();
                TenderMaster tenderMaster = tenderMasterService.readRefNo(tenderNo);
                VendorMaster vendorMaster = vendorMasterService.read(vendorCode);
                List grnExectiveList = userRightsService.readByGRN();

                for (Object o : grnExectiveList) {
                    UserRights userRight = (UserRights) o;
                    String grnUserCode = userRight.getUsername();
                    EmployeeMaster em = employeeMasterService.read(grnUserCode);
                    String toEmail = em.getEmailId();

                    try {

                        String buyerCode = tenderMaster.getTenderAdmin();
                        EmployeeMaster employeeMaster = employeeMasterService.read(buyerCode);
                        EmailTemplate emailTemplate1 = emailTemplateService.readById(208);
                        String subject1 = emailTemplate1.getSubject().replace("{po_no}", poNo);
                        String msg1 = "";
                        String mail_from1 = employeeMaster.getEmailId();
                        String mail_to1 = toEmail;
                        subject1 = emailTemplate1.getSubject();
                        msg1 = emailTemplate1.getBodytext();

                        msg1 = msg1.replaceAll("\\{po_no\\}", poNo);
                        msg1 = msg1.replaceAll("\\{tender_no\\}", tenderNo);
                        msg1 = msg1.replaceAll("\\{remark\\}", buyerRemark);
                        msg1 = msg1.replaceAll("\\{username\\}", username);
                        msg1 = msg1.replaceAll("\\{createddate\\}", formattedDate1);
                        msg1 = msg1.replaceAll("\\{buyer_name\\}", employeeMaster.getName());
                        msg1 = msg1.replaceAll("\\{vendor_name\\}", vendorMaster.getVendorName());
                        msg1 = msg1.replaceAll("\\{vendor_code\\}", vendorCode);

                        SendMail s = new SendMail();
                        s.sendMail(mail_from1, mail_to1, subject1, msg1);
                    } catch (Exception e) {

                    }
                }
                Date date = new java.util.Date();
                session.setAttribute("successMessage", "Documents sent to GRN Executive successfully.");
                // 'user' is already in scope from the top of the method
                LogsMaster lm = new LogsMaster();
                lm.setlDate(dateFormat.format(date))
                        .setTime(timeFOrmat.format(date))
                        .setUserName(user.getUserFullName())
                        .setIp(myIp)
                        .setAction("PO No:- " + poNo + " Documents sent to GRN Executive successfully.")
                        .setDrow("Y");
                logService.create(lm);

                TenderFollowup tenderFollowup = new TenderFollowup();
                tenderFollowup.setActivityDate(formattedDate1);
                tenderFollowup.setActivity("PO No:- " + poNo + " Documents sent to GRN Executive successfully.");
                tenderFollowup.setLocation("");
                tenderFollowup.setTenderNo(poDetails.getTenderNo());
                tenderFollowup.setPerson(user.getLoginName());
                tenderFollowup.setPersonFullname(user.getUserFullName());
                tenderFollowupService.create(tenderFollowup);
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("failureMessage", "Something went wrong. Please try again.");
        }

        mv.setViewName(backUrl);
        return mv;
    }

    public ModelAndView reuploadDocument(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (session == null) ? null : (UserMaster) session.getAttribute("user");
        String vendor_code = user.getLoginName();
        VendorMaster vendorMaster = vendorMasterService.read(vendor_code);
        if (user == null) {
            mv.setViewName("redirect:login.htm");
            return mv;
        }
        Date date = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String sysdate = sdf4.format(date);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        String id = multipartRequest.getParameter("id");          // PO id
        String docId = multipartRequest.getParameter("docIds");   // id of the recycled row
        String backUrl = "redirect:poDetails.htm?act=viewInvoice&id=" + id;

        if (docId == null || docId.trim().isEmpty()) {
            session.setAttribute("failureMessage", "Please select a document.");
            mv.setViewName(backUrl);
            return mv;
        }
        docId = docId.trim();

        String remark = multipartRequest.getParameter("reRemark_" + docId);
        remark = (remark == null) ? "" : remark.trim();
        MultipartFile file = multipartRequest.getFile("reFile_" + docId);
        if (file == null || file.getSize() <= 0) {
            session.setAttribute("failureMessage", "Please attach the document.");
            mv.setViewName(backUrl);
            return mv;
        }
        if (remark.isEmpty()) {
            session.setAttribute("failureMessage", "Remark is required.");
            mv.setViewName(backUrl);
            return mv;
        }

        try {
            InvoiceAttachment attachment = invoiceAttachmentService.readById(Integer.parseInt(docId));
            if (attachment == null) {
                session.setAttribute("failureMessage", "Document not found.");
            } else if (attachment.getPoId() != Integer.parseInt(id)) {
                session.setAttribute("failureMessage", "Invalid document.");
            } else if (!user.getLoginName().equals(attachment.getVendorCode())) {
                session.setAttribute("failureMessage", "Invalid document.");
            } else if (attachment.getStatus() != 3) {
                session.setAttribute("failureMessage", "Only a recycled document can be uploaded again.");
            } else {

                String uploadPath = session.getServletContext().getRealPath("/") + File.separator + "StorageYard" + File.separator + "Invoice"
                        + File.separator + attachment.getPoId() + File.separator;
                File uploadDirectory = new File(uploadPath);
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs();
                }

                String fileName = file.getOriginalFilename()
                        .replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                file.transferTo(new File(uploadPath + fileName));

                attachment.setInvoiceAttachment(fileName);   // new vendor document
                attachment.setVendorComment(remark);          // NEW field on InvoiceAttachment
                attachment.setStatus(0);
                invoiceAttachmentService.update(attachment);

                PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
                String documentType = attachment.getDocumentType();
                String documentNo = attachment.getDocumentNo();
                String poNo = poDetails.getPoNo();
                String tenderNo = poDetails.getTenderNo();
                TenderMaster tenderMaster = tenderMasterService.readRefNo(tenderNo);
                try {
                    String buyerCode = tenderMaster.getTenderAdmin();
                    EmployeeMaster employeeMaster = employeeMasterService.read(buyerCode);
                    EmailTemplate emailTemplate1 = emailTemplateService.readById(206);
                    String subject1 = emailTemplate1.getSubject().replace("{po_no}", poNo);
                    String msg1 = "";
                    String mail_from1 = vendorMaster.getVendorEmailID();
                    String mail_to1 = employeeMaster.getEmailId();
                    subject1 = emailTemplate1.getSubject();
                    msg1 = emailTemplate1.getBodytext();

                    msg1 = msg1.replaceAll("\\{po_no\\}", poNo);
                    msg1 = msg1.replaceAll("\\{tender_no\\}", tenderNo);
                    msg1 = msg1.replaceAll("\\{document_type\\}", documentType);
                    msg1 = msg1.replaceAll("\\{document_no\\}", documentNo);
                    msg1 = msg1.replaceAll("\\{remark\\}", remark);
                    msg1 = msg1.replaceAll("\\{username\\}", vendor_code);
                    msg1 = msg1.replaceAll("\\{createddate\\}", sysdate);
                    msg1 = msg1.replaceAll("\\{vendor_name\\}", vendorMaster.getVendorName());

                    SendMail s = new SendMail();
                    s.sendMail(mail_from1, mail_to1, subject1, msg1);
                } catch (Exception e) {

                }
                //HttpSession session = request.getSession(false);
                UserMaster user11 = (UserMaster) session.getAttribute("user");
                LogsMaster lm = new LogsMaster();
                lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user11.getUserFullName()).setIp(myIp).setAction("Vendor re-uploaded the recycled document of PO No: " + poNo).setDrow("Y");
                logService.create(lm);

                LocalDateTime myDateObj1 = LocalDateTime.now();
                DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate1 = myDateObj1.format(myFormatObj1);

                TenderFollowup tenderFollowup = new TenderFollowup();
                tenderFollowup.setActivityDate(formattedDate1);
                tenderFollowup.setActivity("Vendor re-uploaded the recycled document of PO No: " + poNo);
                tenderFollowup.setLocation("");
                tenderFollowup.setTenderNo(tenderNo);
                tenderFollowup.setPerson(user11.getLoginName());
                tenderFollowup.setPersonFullname(user11.getUserFullName());
                tenderFollowupService.create(tenderFollowup);

                session.setAttribute("successMessage", "Document uploaded again successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("failureMessage", "Something went wrong. Please try again.");
        }

        mv.setViewName(backUrl);
        return mv;
    }

    public ModelAndView grnExecutiveApprovalList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        List grnExecutiveList = poDetailsService.readByGrnExecutive(username);
        mv.getModelMap().put("grnExecutiveList", grnExecutiveList);
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

        mv.setViewName("PO/GrnExecutiveApprovalList");
        return mv;
    }

    public ModelAndView viewGRNApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
        String vendorCode = request.getParameter("vendorCode");
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        TenderMaster tenderMaster = tenderMasterService.readRefNo(poDetails.getTenderNo());
        String poNo = poDetails.getPoNo();
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
        int status = 4;
        List invoiceAttachmentList = invoiceAttachmentService.readByPoIdAndStatus(id, vendorCode, status);
        InvoiceMaster invoiceMaster = invoiceMasterService.readByPoId(poDetails.getId(), vendorCode);

        session.setAttribute("invoiceMaster", invoiceMaster);
        session.setAttribute("poDetails", poDetails);
        session.setAttribute("tenderMaster", tenderMaster);
        session.setAttribute("invoiceAttachmentList", invoiceAttachmentList);
        session.setAttribute("id", id);

        mv.setViewName("PO/ViewGRNApproval");
        return mv;
    }

    public ModelAndView updateDocumentGRNStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (session == null) ? null : (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        if (user == null) {
            mv.setViewName("redirect:login.htm");
            return mv;
        }
        Date date = new java.util.Date();
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String sysdate = sdf4.format(date);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        String id = multipartRequest.getParameter("id");
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        String vendorCode = poDetails.getVendorCode();

        String docAction = multipartRequest.getParameter("docAction");
        String docId = multipartRequest.getParameter("docIds");
        String backUrl = "redirect:poDetails.htm?act=viewGRNApproval&id=" + id + "&vendorCode=" + vendorCode;

        if (docId == null || docId.trim().isEmpty() || docAction == null) {
            session.setAttribute("failureMessage", "Please select a document.");
            mv.setViewName(backUrl);
            return mv;
        }
        docId = docId.trim();
        boolean actionSuccess = false;
        String attachmentName = "";
        int status;
        String doneText;
        if ("Accept".equals(docAction)) {
            status = 2;                 // Document Accepted
            doneText = "accepted";
        } else if ("Recycle".equals(docAction)) {
            status = 3;                 // Document Recycle
            doneText = "recycled";
        } else if ("Reject".equals(docAction)) {
            status = 4;                 // Document Rejected  
            doneText = "rejected";
        } else {
            session.setAttribute("failureMessage", "Invalid action.");
            mv.setViewName(backUrl);
            return mv;
        }

        String remark = multipartRequest.getParameter("remark_" + docId);
        remark = (remark == null) ? "" : remark.trim();
        InvoiceMaster invoiceMaster = invoiceMasterService.readByPoId(poDetails.getId(), vendorCode);
        // remark is mandatory for Recycle and Reject
        if ((status == 3 || status == 4) && remark.isEmpty() && invoiceMaster.getFinancialFlag() != 3) {
            session.setAttribute("failureMessage", "Remark is required to " + ("Recycle".equals(docAction) ? "recycle" : "reject") + " a document.");
            mv.setViewName(backUrl);
            return mv;
        }
        InvoiceAttachment attachment = null;
        try {
            attachment = invoiceAttachmentService.readById(Integer.parseInt(docId));

            if (attachment == null) {
                session.setAttribute("failureMessage", "Document not found.");
            } else if (attachment.getPoId() != Integer.parseInt(id)) {
                session.setAttribute("failureMessage", "Invalid document.");
            } else if (attachment.getGrnStatus() != 0 && invoiceMaster.getFinancialFlag() == 0) {
                session.setAttribute("failureMessage", "This document has already been processed.");
            } else {

                // value already saved (e.g. file given at an earlier Recycle)
                String previousGRNAttachment = attachment.getGrnAttachment();
                String newGrnAttachment = null;

                // optional NEW attachment for this action
                MultipartFile file = multipartRequest.getFile("actionFile_" + docId);
                if (file != null && file.getSize() > 0) {
                    String uploadPath = session.getServletContext().getRealPath("/") + File.separator + "StorageYard"
                            + File.separator + "Invoice"
                            + File.separator + "GRN"
                            + File.separator + attachment.getPoId() + File.separator;
                    File uploadDirectory = new File(uploadPath);
                    if (!uploadDirectory.exists()) {
                        uploadDirectory.mkdirs();
                    }

                    // timestamp stops a repeat upload with the same name from overwriting the earlier file
                    String fileName = file.getOriginalFilename()
                            .replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    file.transferTo(new File(uploadPath + fileName));
                    newGrnAttachment = fileName;
                }

                // new file wins, otherwise keep what was already saved
                String finalAttachment = (newGrnAttachment != null) ? newGrnAttachment : previousGRNAttachment;
                attachmentName = finalAttachment;
                attachment.setGrnAttachment(finalAttachment == null ? "" : finalAttachment);
                attachment.setGrnComment(remark.isEmpty() ? null : remark);
                attachment.setGrnStatus(status);
                attachment.setFinancialStatus(0);
                attachment.setGrnExectiveCode(username);
                invoiceAttachmentService.update(attachment);
                actionSuccess = true;
                session.setAttribute("successMessage", "Document " + doneText + " successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("failureMessage", "Something went wrong. Please try again.");
        }
        int status1 = 3;

        boolean isExistByRecycle = invoiceAttachmentService.readByGrnRecycleStatus(poDetails.getId(), status1);

        if (!isExistByRecycle) {
            invoiceMaster.setGrnFlag(0);
            invoiceMasterService.update(invoiceMaster);
        }
        if (status == 3) {
            invoiceMaster.setGrnFlag(3);
            invoiceMasterService.update(invoiceMaster);
        }

        if (actionSuccess) {
            // status-wise activity text
            String actionText;
            if (status == 2) {
                actionText = "GRN Executive accepted document";
            } else if (status == 3) {
                actionText = "GRN Executive recycled document";
                String poNo = poDetails.getPoNo();
                String tenderNo = poDetails.getTenderNo();
                TenderMaster tenderMaster = tenderMasterService.readRefNo(tenderNo);
                VendorMaster vendorMaster = vendorMasterService.read(vendorCode);
                try {

                    String buyerCode = tenderMaster.getTenderAdmin();
                    EmployeeMaster employeeMaster = employeeMasterService.read(buyerCode);
                    EmployeeMaster employeeMaster1 = employeeMasterService.read(username);
                    EmailTemplate emailTemplate1 = emailTemplateService.readById(209);
                    String subject1 = emailTemplate1.getSubject().replace("{po_no}", poNo);
                    String msg1 = "";
                    String mail_from1 = employeeMaster1.getEmailId();
                    String mail_to1 = employeeMaster.getEmailId();
                    subject1 = emailTemplate1.getSubject();
                    msg1 = emailTemplate1.getBodytext();

                    msg1 = msg1.replaceAll("\\{po_no\\}", poNo);
                    msg1 = msg1.replaceAll("\\{tender_no\\}", tenderNo);
                    msg1 = msg1.replaceAll("\\{remark\\}", remark);
                    msg1 = msg1.replaceAll("\\{username\\}", username);
                    msg1 = msg1.replaceAll("\\{document_type\\}", attachment.getDocumentType());
                    msg1 = msg1.replaceAll("\\{document_no\\}", attachment.getDocumentNo());
                    msg1 = msg1.replaceAll("\\{createddate\\}", sysdate);
                    msg1 = msg1.replaceAll("\\{buyer_name\\}", employeeMaster.getName());
                    msg1 = msg1.replaceAll("\\{vendor_name\\}", vendorMaster.getVendorName());
                    msg1 = msg1.replaceAll("\\{vendor_code\\}", vendorCode);
                    EmployeeMaster em = employeeMasterService.read(username);
                    msg1 = msg1.replaceAll("\\{grn_executive_name\\}", em.getName());

                    SendMail s = new SendMail();
                    s.sendMail(mail_from1, mail_to1, subject1, msg1);
                } catch (Exception e) {

                }
            } else { // status == 4
                actionText = "GRN Executive rejected document";
            }

            String activity = actionText
                    + (attachmentName == null || attachmentName.isEmpty() ? "" : " (" + attachmentName + ")")
                    + " of PO No: " + poDetails.getPoNo()
                    + (remark == null || remark.isEmpty() ? "" : " - Remark: " + remark);

            LocalDateTime myDateObj1 = LocalDateTime.now();
            DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate1 = myDateObj1.format(myFormatObj1);

            // 'user' is already in scope from the top of the method
            LogsMaster lm = new LogsMaster();
            lm.setlDate(dateFormat.format(date))
                    .setTime(timeFOrmat.format(date))
                    .setUserName(user.getUserFullName())
                    .setIp(myIp)
                    .setAction(activity)
                    .setDrow("Y");
            logService.create(lm);

            TenderFollowup tenderFollowup = new TenderFollowup();
            tenderFollowup.setActivityDate(formattedDate1);
            tenderFollowup.setActivity(activity);
            tenderFollowup.setLocation("");
            tenderFollowup.setTenderNo(poDetails.getTenderNo());
            tenderFollowup.setPerson(user.getLoginName());
            tenderFollowup.setPersonFullname(user.getUserFullName());
            tenderFollowupService.create(tenderFollowup);
        }

        mv.setViewName(backUrl);
        return mv;
    }

    public ModelAndView sendToFinancialExecutive(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (session == null) ? null : (UserMaster) session.getAttribute("user");
        String buyerRemark = request.getParameter("buyerRemark");
        if (user == null) {
            mv.setViewName("redirect:login.htm");
            return mv;
        }
        String username = user.getLoginName();
        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        String id = request.getParameter("id");
        String grnNumber = request.getParameter("grnNumber");
        String grnDate = request.getParameter("grnDate");
        // PO id
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        String refNo = poDetails.getTenderNo();
        String vendorCode = poDetails.getVendorCode();
        String poNo = poDetails.getPoNo();
        String backUrl = "redirect:poDetails.htm?act=grnExecutiveApprovalList";

        try {
            List<InvoiceAttachment> list = invoiceAttachmentService.readByPoId(id, poDetails.getVendorCode());

            // server-side check: every document must be Accepted (2) or Rejected (4)
            boolean hasUnresolved = false;
            if (list != null) {
                for (InvoiceAttachment a : list) {
                    if (a.getGrnStatus() == 0 || a.getGrnStatus() == 3) {
                        hasUnresolved = true;
                        break;
                    }
                }
            }

            if (list == null || list.isEmpty()) {
                session.setAttribute("failureMessage", "No documents to send.");
            } else if (hasUnresolved) {
                session.setAttribute("failureMessage", "All documents must be accepted or rejected before sending to Financial Executive.");
            } else {

                InvoiceMaster invoiceMaster = invoiceMasterService.readByPoId(poDetails.getId(), vendorCode);

                invoiceMaster.setGrnComment(buyerRemark);
                invoiceMaster.setGrnFlag(1);
                invoiceMaster.setGrnDate(grnDate);
                invoiceMaster.setGrnExectiveCode(username);
                invoiceMaster.setGrnNumber(grnNumber);
                invoiceMasterService.update(invoiceMaster);
                String tenderNo = poDetails.getTenderNo();
                TenderMaster tenderMaster = tenderMasterService.readRefNo(tenderNo);
                VendorMaster vendorMaster = vendorMasterService.read(vendorCode);
                List financialList = userRightsService.readByFinancial();
                for (Object o : financialList) {
                    UserRights userRight = (UserRights) o;
                    String grnUserCode = userRight.getUsername();
                    EmployeeMaster em = employeeMasterService.read(grnUserCode);
                    String toEmail = em.getEmailId();

                    try {

                        EmployeeMaster employeeMaster = employeeMasterService.read(username);
                        EmailTemplate emailTemplate1 = emailTemplateService.readById(210);
                        String subject1 = emailTemplate1.getSubject().replace("{po_no}", poNo);
                        String msg1 = "";
                        String mail_from1 = employeeMaster.getEmailId();
                        String mail_to1 = toEmail;
                        subject1 = emailTemplate1.getSubject();
                        msg1 = emailTemplate1.getBodytext();

                        msg1 = msg1.replaceAll("\\{po_no\\}", poNo);
                        msg1 = msg1.replaceAll("\\{tender_no\\}", tenderNo);
                        msg1 = msg1.replaceAll("\\{remark\\}", buyerRemark);
                        msg1 = msg1.replaceAll("\\{username\\}", username);
                        msg1 = msg1.replaceAll("\\{createddate\\}", formattedDate1);
                        msg1 = msg1.replaceAll("\\{grn_no\\}", grnNumber);
                        msg1 = msg1.replaceAll("\\{grn_date\\}", grnDate);
                        msg1 = msg1.replaceAll("\\{grn_executive_name\\}", employeeMaster.getName());
                        msg1 = msg1.replaceAll("\\{vendor_name\\}", vendorMaster.getVendorName());
                        msg1 = msg1.replaceAll("\\{vendor_code\\}", vendorCode);

                        SendMail s = new SendMail();
                        s.sendMail(mail_from1, mail_to1, subject1, msg1);
                    } catch (Exception e) {

                    }
                }
                Date date = new java.util.Date();
                // 'user' is already in scope from the top of the method
                LogsMaster lm = new LogsMaster();
                lm.setlDate(dateFormat.format(date))
                        .setTime(timeFOrmat.format(date))
                        .setUserName(user.getUserFullName())
                        .setIp(myIp)
                        .setAction("PO No:- " + poDetails.getPoNo() + " Documents sent to Financial Executive successfully")
                        .setDrow("Y");
                logService.create(lm);

                TenderFollowup tenderFollowup = new TenderFollowup();
                tenderFollowup.setActivityDate(formattedDate1);
                tenderFollowup.setActivity("PO No:- " + poDetails.getPoNo() + " Documents sent to Financial Executive successfully");
                tenderFollowup.setLocation("");
                tenderFollowup.setTenderNo(poDetails.getTenderNo());
                tenderFollowup.setPerson(user.getLoginName());
                tenderFollowup.setPersonFullname(user.getUserFullName());
                tenderFollowupService.create(tenderFollowup);
                session.setAttribute("successMessage", "Documents sent to Financial Executive successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("failureMessage", "Something went wrong. Please try again.");
        }

        mv.setViewName(backUrl);
        return mv;
    }

    public ModelAndView financialExecutiveApprovalList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        List financialExecutiveList = poDetailsService.readByfinancailExecutive(username);
        mv.getModelMap().put("financialExecutiveList", financialExecutiveList);
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

        mv.setViewName("PO/FinancialExecutiveApprovalList");
        return mv;
    }

    public ModelAndView viewFinancialApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        String id = request.getParameter("id");
        String vendorCode = request.getParameter("vendorCode");
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        TenderMaster tenderMaster = tenderMasterService.readRefNo(poDetails.getTenderNo());
        String poNo = poDetails.getPoNo();
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
        int status = 4;
        List invoiceAttachmentList = invoiceAttachmentService.readByPoIdAndStatus(id, vendorCode, status);
        InvoiceMaster invoiceMaster = invoiceMasterService.readByPoId(poDetails.getId(), vendorCode);

        session.setAttribute("invoiceMaster", invoiceMaster);
        session.setAttribute("poDetails", poDetails);
        session.setAttribute("tenderMaster", tenderMaster);
        session.setAttribute("invoiceAttachmentList", invoiceAttachmentList);
        session.setAttribute("id", id);

        mv.setViewName("PO/ViewFinancailApproval");
        return mv;
    }

    public ModelAndView updateDocumentFinancialStatus(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (session == null) ? null : (UserMaster) session.getAttribute("user");

        if (user == null) {
            mv.setViewName("redirect:login.htm");
            return mv;
        }
        String username = user.getLoginName();
        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        String id = multipartRequest.getParameter("id");
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        String vendorCode = poDetails.getVendorCode();

        String docAction = multipartRequest.getParameter("docAction");
        String docId = multipartRequest.getParameter("docIds");
        String backUrl = "redirect:poDetails.htm?act=viewFinancialApproval&id=" + id + "&vendorCode=" + vendorCode;

        if (docId == null || docId.trim().isEmpty() || docAction == null) {
            session.setAttribute("failureMessage", "Please select a document.");
            mv.setViewName(backUrl);
            return mv;
        }
        docId = docId.trim();

        int status;
        boolean actionSuccess = false;
        String attachmentName = "";
        String doneText;
        if ("Accept".equals(docAction)) {
            status = 2;                 // Document Accepted
            doneText = "accepted";
        } else if ("Recycle".equals(docAction)) {
            status = 3;                 // Document Recycle
            doneText = "recycled";
        } else if ("Reject".equals(docAction)) {
            status = 4;                 // Document Rejected  
            doneText = "rejected";
        } else {
            session.setAttribute("failureMessage", "Invalid action.");
            mv.setViewName(backUrl);
            return mv;
        }

        String remark = multipartRequest.getParameter("remark_" + docId);
        remark = (remark == null) ? "" : remark.trim();

        // remark is mandatory for Recycle and Reject
        if ((status == 3 || status == 4) && remark.isEmpty()) {
            session.setAttribute("failureMessage", "Remark is required to " + ("Recycle".equals(docAction) ? "recycle" : "reject") + " a document.");
            mv.setViewName(backUrl);
            return mv;
        }
        InvoiceAttachment attachment = null;
        try {
            attachment = invoiceAttachmentService.readById(Integer.parseInt(docId));

            if (attachment == null) {
                session.setAttribute("failureMessage", "Document not found.");
            } else if (attachment.getPoId() != Integer.parseInt(id)) {
                session.setAttribute("failureMessage", "Invalid document.");
            } else if (attachment.getFinancialStatus() != 0) {
                session.setAttribute("failureMessage", "This document has already been processed.");
            } else {

                // value already saved (e.g. file given at an earlier Recycle)
                String previousFinancialAttachment = attachment.getGrnAttachment();
                String newFinacialAttachment = null;

                // optional NEW attachment for this action
                MultipartFile file = multipartRequest.getFile("actionFile_" + docId);
                if (file != null && file.getSize() > 0) {
                    String uploadPath = session.getServletContext().getRealPath("/") + File.separator + "StorageYard"
                            + File.separator + "Invoice"
                            + File.separator + "Financial"
                            + File.separator + attachment.getPoId() + File.separator;
                    File uploadDirectory = new File(uploadPath);
                    if (!uploadDirectory.exists()) {
                        uploadDirectory.mkdirs();
                    }

                    // timestamp stops a repeat upload with the same name from overwriting the earlier file
                    String fileName = file.getOriginalFilename()
                            .replaceAll(" ", "").replaceAll("&", "").replaceAll("\\+", "");
                    file.transferTo(new File(uploadPath + fileName));
                    newFinacialAttachment = fileName;
                }

                // new file wins, otherwise keep what was already saved
                String finalAttachment = (newFinacialAttachment != null) ? newFinacialAttachment : previousFinancialAttachment;
                attachment.setFinancialAttachment(finalAttachment == null ? "" : finalAttachment);
                attachment.setFinancialComment(remark.isEmpty() ? null : remark);
                attachment.setFinancialStatus(status);
                attachment.setFinancialStatus(status);
                attachment.setFinancialPersonCode(username);
                invoiceAttachmentService.update(attachment);
                attachmentName = finalAttachment;
                actionSuccess = true;

                session.setAttribute("successMessage", "Document " + doneText + " successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("failureMessage", "Something went wrong. Please try again.");
        }
        InvoiceMaster invoiceMaster = invoiceMasterService.readByPoId(poDetails.getId(), vendorCode);
        if (status == 3) {
            invoiceMaster.setFinancialFlag(3);
            invoiceMasterService.update(invoiceMaster);
        }
        int status1 = 3;
        boolean isExistByRecycle = invoiceAttachmentService.readByFinancialRecycleStatus(poDetails.getId(), status1);

        if (!isExistByRecycle) {
            invoiceMaster.setFinancialFlag(0);
            invoiceMasterService.update(invoiceMaster);
        }
        if (actionSuccess) {
            // status-wise activity text
            String actionText;
            if (status == 2) {
                actionText = "Financial accepted document";
            } else if (status == 3) {
                actionText = "Financial recycled document";
                String poNo = poDetails.getPoNo();
                String tenderNo = poDetails.getTenderNo();
                TenderMaster tenderMaster = tenderMasterService.readRefNo(tenderNo);
                VendorMaster vendorMaster = vendorMasterService.read(vendorCode);

                List grnExectiveList = userRightsService.readByGRN();

                for (Object o : grnExectiveList) {
                    UserRights userRight = (UserRights) o;
                    String grnUserCode = userRight.getUsername();
                    EmployeeMaster em = employeeMasterService.read(grnUserCode);
                    String toEmail = em.getEmailId();

                    try {

                        EmployeeMaster employeeMaster = employeeMasterService.read(username);
                        EmailTemplate emailTemplate1 = emailTemplateService.readById(209);
                        String subject1 = emailTemplate1.getSubject().replace("{po_no}", poNo);
                        String msg1 = "";
                        String mail_from1 = vendorMaster.getVendorEmailID();
                        String mail_to1 = toEmail;
                        subject1 = emailTemplate1.getSubject();
                        msg1 = emailTemplate1.getBodytext();

                        msg1 = msg1.replaceAll("\\{po_no\\}", poNo);
                        msg1 = msg1.replaceAll("\\{tender_no\\}", tenderNo);
                        msg1 = msg1.replaceAll("\\{remark\\}", remark);
                        msg1 = msg1.replaceAll("\\{username\\}", username);
                        msg1 = msg1.replaceAll("\\{document_type\\}", attachment.getDocumentType());
                        msg1 = msg1.replaceAll("\\{document_no\\}", attachment.getDocumentNo());
                        msg1 = msg1.replaceAll("\\{createddate\\}", formattedDate1);
                        msg1 = msg1.replaceAll("\\{vendor_name\\}", vendorMaster.getVendorName());
                        msg1 = msg1.replaceAll("\\{vendor_code\\}", vendorCode);
                        msg1 = msg1.replaceAll("\\{finance_executive_name\\}", employeeMaster.getName());

                        SendMail s = new SendMail();
                        s.sendMail(mail_from1, mail_to1, subject1, msg1);
                    } catch (Exception e) {

                    }
                }

            } else { // status == 4
                actionText = "Financial rejected document";
            }

            String activity = actionText
                    + (attachmentName.isEmpty() ? "" : " (" + attachmentName + ")")
                    + " of PO No: " + poDetails.getPoNo()
                    + (remark.isEmpty() ? "" : " - Remark: " + remark);
            Date date = new java.util.Date();
            // 'user' is already in scope from the top of the method
            LogsMaster lm = new LogsMaster();
            lm.setlDate(dateFormat.format(date))
                    .setTime(timeFOrmat.format(date))
                    .setUserName(user.getUserFullName())
                    .setIp(myIp)
                    .setAction(activity)
                    .setDrow("Y");
            logService.create(lm);

            TenderFollowup tenderFollowup = new TenderFollowup();
            tenderFollowup.setActivityDate(formattedDate1);
            tenderFollowup.setActivity(activity);
            tenderFollowup.setLocation("");
            tenderFollowup.setTenderNo(poDetails.getTenderNo());
            tenderFollowup.setPerson(user.getLoginName());
            tenderFollowup.setPersonFullname(user.getUserFullName());
            tenderFollowupService.create(tenderFollowup);
        }

        mv.setViewName(backUrl);
        return mv;
    }

    public ModelAndView approveByFinancial(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        ModelAndView mv = new ModelAndView();

        HttpSession session = request.getSession(false);
        UserMaster user = (session == null) ? null : (UserMaster) session.getAttribute("user");
        String financialRemark = request.getParameter("financialRemark");
        if (user == null) {
            mv.setViewName("redirect:login.htm");
            return mv;
        }
        String username = user.getLoginName();
        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate1 = myDateObj1.format(myFormatObj1);

        String id = request.getParameter("id");
        String bookingNo = request.getParameter("bookingNo");
        String bookingDate = request.getParameter("bookingDate");
        // PO id
        PoDetails poDetails = poDetailsService.readById(Integer.parseInt(id));
        String refNo = poDetails.getTenderNo();
        String vendorCode = poDetails.getVendorCode();
        String poNo = poDetails.getPoNo();
        String backUrl = "redirect:poDetails.htm?act=financialExecutiveApprovalList";

        try {
            List<InvoiceAttachment> list = invoiceAttachmentService.readByPoId(id, poDetails.getVendorCode());

            // server-side check: every document must be Accepted (2) or Rejected (4)
            boolean hasUnresolved = false;
            if (list != null) {
                for (InvoiceAttachment a : list) {
                    if (a.getFinancialStatus() == 0 || a.getFinancialStatus() == 3) {
                        hasUnresolved = true;
                        break;
                    }
                }
            }

            if (list == null || list.isEmpty()) {
                session.setAttribute("failureMessage", "No documents to send.");
            } else if (hasUnresolved) {
                session.setAttribute("failureMessage", "All documents must be accepted or rejected before Approving.");
            } else {

                InvoiceMaster invoiceMaster = invoiceMasterService.readByPoId(poDetails.getId(), vendorCode);

                invoiceMaster.setFinancialComment(financialRemark);
                invoiceMaster.setFinancialFlag(1);
                invoiceMaster.setBookingNo(bookingNo);
                invoiceMaster.setBookingDate(bookingDate);
                invoiceMaster.setFinancialPersonCode(username);
                invoiceMasterService.update(invoiceMaster);
                Date date = new java.util.Date();
                // 'user' is already in scope from the top of the method
                LogsMaster lm = new LogsMaster();
                lm.setlDate(dateFormat.format(date))
                        .setTime(timeFOrmat.format(date))
                        .setUserName(user.getUserFullName())
                        .setIp(myIp)
                        .setAction("PO No:- " + poDetails.getPoNo() + " Documents approved by Financial Executive successfully")
                        .setDrow("Y");
                logService.create(lm);

                TenderFollowup tenderFollowup = new TenderFollowup();
                tenderFollowup.setActivityDate(formattedDate1);
                tenderFollowup.setActivity("PO No:- " + poDetails.getPoNo() + " Documents approved by Financial Executive successfully");
                tenderFollowup.setLocation("");
                tenderFollowup.setTenderNo(poDetails.getTenderNo());
                tenderFollowup.setPerson(user.getLoginName());
                tenderFollowup.setPersonFullname(user.getUserFullName());
                tenderFollowupService.create(tenderFollowup);

                session.setAttribute("successMessage", "Documents Approved by financial person successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("failureMessage", "Something went wrong. Please try again.");
        }

        mv.setViewName(backUrl);
        return mv;
    }
}
