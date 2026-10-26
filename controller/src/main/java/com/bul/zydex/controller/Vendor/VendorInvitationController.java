/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.Vendor;

import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.LogsMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.VendorInvitation;
import com.bul.zydex.model.ApprovalSetting;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.GroupCategory;
import com.bul.zydex.model.GroupMaster;
import com.bul.zydex.model.GroupSubCategory;
import com.bul.zydex.model.VendorApprovalUser;
import com.bul.zydex.model.VendorDepartmentApproval;
import com.bul.zydex.model.VendorInformation;
import com.bul.zydex.model.VendorInvitationCategory;
import com.bul.zydex.model.VendorMaster;
import com.bul.zydex.model.VendorRequestApproval;
import com.bul.zydex.model.VendorRequestApprovalComment;
import com.bul.zydex.model.VendorRequestApprovalUser;
import com.bul.zydex.model.VendorRequestDetails;
import com.bul.zydex.model.VendorRequestedInvitationCategory;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import com.bul.zydex.util.SendMail;
import com.bul.zydex.util.AES;
import java.net.URL;
import java.security.spec.KeySpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import static net.sf.dynamicreports.report.builder.component.Components.currentDate;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author admin
 */
public class VendorInvitationController extends VendorInvitationAbstract {

    public ModelAndView showList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        VendorInvitation vendorInvitation = new VendorInvitation();
        List list = vendorInvitationService.readByrow();
        request.setAttribute("list", list);
        mv.getModelMap().put("vendorInvitation", vendorInvitation);
        mv.setViewName("Vendor/VendorInvitationList");
        return mv;

    }

    public ModelAndView addVendorInvitation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VendorInvitation vendorInvitation = new VendorInvitation();
        HttpSession session = request.getSession(false);

        List list = groupMasterService.read();
        List list1 = groupCategoryService.read();
        List list2 = groupSubCategoryService.read();
        List list4 = RiskCategoryService.read();
        List list5 = VendorInviteSourceService.read();
        List list6 = auditorMasterService.read();

        mv.getModelMap().put("vendorInvitation", vendorInvitation);
        request.setAttribute("list", list);
        request.setAttribute("list1", list1);
        request.setAttribute("list2", list2);
        request.setAttribute("list4", list4);
        request.setAttribute("list5", list5);
        request.setAttribute("list6", list6);

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
        mv.setViewName("Vendor/VendorInvitationCreate");
        return mv;
    }

    public ModelAndView createVendorPolicy(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        //VendorInvitation vendorInvitation = new VendorInvitation(); 
        //readEmployee(request, response);
        //mv.getModelMap().put("vendorInvitation", vendorInvitation);
        mv.setViewName("Vendor/VendorPolicy");
        return mv;
    }

    public ModelAndView submitVendorInvitation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        VendorInvitation vendorInvitation = new VendorInvitation();
        bind(request, vendorInvitation);
        String venderRequestId = "0";
        venderRequestId = request.getParameter("venderRequestId");
        int status = 0;
        try {
            VendorRequestDetails vendorRequestDetails = vendorRequestDetailsService.readById(Integer.parseInt(venderRequestId));
            vendorRequestDetails.setFlagStatus(6);
            vendorRequestDetailsService.update(vendorRequestDetails);
            status = vendorRequestDetails.getFlagStatus();
        } catch (Exception e) {

        }

        String unencryptedString = vendorInvitation.getVendorEmailId();
        String companyName = vendorInvitation.getCompanyName();
        final String secretKey = "ssshhhhhhhhhhh!!!!";

        String originalString = "howtodoinjava.com";

        String vendorInviteSource = request.getParameter("vendorInviteSource");
        String vendorContactNo = request.getParameter("vendorContactNo");

        String encryptedString1 = AES.encrypt(originalString, secretKey);
        String decryptedString = AES.decrypt(encryptedString1, secretKey);

        String encryptedString = null;
        try {
            encryptedString = encription(unencryptedString);

        } catch (Exception e) {
            e.printStackTrace();
        }

        List rfId = vendorInvitationService.readEmail(vendorInvitation.getVendorEmailId());

        if (rfId.isEmpty()) {
            UserMaster user = (UserMaster) session.getAttribute("user");
            Date date = new Date();

            // --  Approval Setting -----
            String user11 = user.getLoginName();

            ApprovalSetting approvalSetting = approvalSettingService.readUserId(user11);

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = myDateObj.format(myFormatObj);

            Date currentDate = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(currentDate);
            cal.add(Calendar.HOUR, 72);
            Date oneHourBack = cal.getTime();

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String strDate = dateFormat.format(oneHourBack);

            vendorInvitation.setInviteStatus("0");
            vendorInvitation.setInvitedBy(user.getLoginName());
            vendorInvitation.setInvitedDateTime(formattedDate);
            vendorInvitation.setVendorCode("");
            vendorInvitation.setApprovalSettingId(approvalSetting.getId());
            vendorInvitation.setLinkExpireDateTime(strDate);
            vendorInvitation.setEncryText(encryptedString);
            vendorInvitation.setContactName("");
            vendorInvitation.setBpGroup("");
            vendorInvitation.setVendorInviteSource(vendorInviteSource);
            vendorInvitation.setVendorContactNo(vendorContactNo);
            vendorInvitationService.create(vendorInvitation);

            int id = vendorInvitation.getId();

            String[] groupIdd = request.getParameterValues("groupIdd");
            String[] groupCategoryId = request.getParameterValues("groupCategoryId");
            String[] groupSubCategoryId = request.getParameterValues("groupSubcategory");

            int subCategoryIndex = 0;
            Set<String> groupNames = new LinkedHashSet<>();
            Set<String> groupCatNames = new LinkedHashSet<>();
            Set<String> groupSubCatNames = new LinkedHashSet<>();

            List<String> priorityOrder = Arrays.asList("high", "medium", "low");

            Comparator<String> customComparator = (a, b) -> {
                return Integer.compare(priorityOrder.indexOf(a), priorityOrder.indexOf(b));
            };

            TreeSet<String> set1 = new TreeSet<>(customComparator);

            for (String subCat : groupSubCategoryId) {

                GroupSubCategory groupSubCategory = groupSubCategoryService.readById(Integer.parseInt(subCat));
                int groupMasterId = groupSubCategory.getGroupMasterId();
                int groupCategoryId1 = groupSubCategory.getGroupCategoryId();
                String riskCategory = groupSubCategory.getRiskCategory();
                set1.add(riskCategory.toLowerCase());

                GroupMaster groupMaster = groupMasterService.readById(groupMasterId);
                GroupCategory groupCategory = groupCategoryService.readById(groupCategoryId1);

                String groupName = groupMaster.getGroupName();
                String groupCatName = groupCategory.getGroupCatogryName();
                String groupSubCatName = groupSubCategory.getSubCategoryName();

                groupNames.add(groupName);
                groupCatNames.add(groupCatName);
                groupSubCatNames.add(groupSubCatName);

                VendorInvitationCategory vendorInvitationCategory = new VendorInvitationCategory();
                vendorInvitationCategory.setGroupId(String.valueOf(groupMasterId));
                vendorInvitationCategory.setVendorId(String.valueOf(id));
                vendorInvitationCategory.setGroupCategoryId(String.valueOf(groupCategoryId1));
                vendorInvitationCategory.setGroupSubCategoryId(subCat);

                vendorInvitationCategoryService.create(vendorInvitationCategory);
            }

            VendorInvitation vendorInvitationToUpdate = vendorInvitationService.readById(id);
            vendorInvitationToUpdate.setVendorTypes(String.join("<br>", groupNames));
            vendorInvitationToUpdate.setGroupCategory(String.join("<br>", groupCatNames));
            vendorInvitationToUpdate.setGroupSubCategory(String.join("<br>", groupSubCatNames));
            vendorInvitationToUpdate.setRiskCategory(set1.first());
            vendorInvitationService.update(vendorInvitationToUpdate);

            URL url = new URL(request.getRequestURL().toString());

            String host = url.getHost();
            String userInfo = url.getUserInfo();
            String scheme = url.getProtocol();
            int port = url.getPort();

            host = "localhost:8080";

            String vendorEmailId = vendorInvitation.getVendorEmailId();
            String buyer = vendorInvitation.getInvitedBy();

            EmployeeMaster employeeMaster = employeeMasterService.read(buyer);
            String buyerNo = employeeMaster.getMobileNo();

            String companyname = vendorInvitation.getCompanyName();
            String mail_from = "samir@bulwarks.com";
            String mail_to = unencryptedString;
            String subject = "";
            String msg = "";

            EmailTemplate emailTemplate = emailTemplateService.readById(27);
            subject = emailTemplate.getSubject();
            msg = emailTemplate.getBodytext();

            msg = msg.replaceAll("\\{contactname\\}", companyname);
            msg = msg.replaceAll("\\{companyname\\}", companyname);
            msg = msg.replaceAll("\\{vendorEmailId\\}", vendorEmailId);
            msg = msg.replaceAll("\\{buyer\\}", buyer);
            msg = msg.replaceAll("\\{buyerNo\\}", buyerNo);

            SendMail s = new SendMail();

            s.sendMail(mail_from, mail_to, subject, msg);

            //------for Log entry---------
            LogsMaster lm = new LogsMaster();

            lm.setlDate(dateFormat.format(date)).setTime(timeFOrmat.format(date)).setUserName(user.getUserFullName()).setIp(myIp).setAction("Vendor Invitation").setDrow("Y");
            logService.create(lm);

            List vendorMaster = vendorMasterService.readVendorRegNo(unencryptedString);

            if (vendorMaster.isEmpty()) {
                VendorMaster vendorMaster2 = new VendorMaster();
                vendorMaster2.setVendorName(companyName);
                vendorMaster2.setVendorRegNo(unencryptedString);
                vendorMaster2.setVendorStxNo("");
                vendorMaster2.setVendorCstxNo("");
                vendorMaster2.setVendorAddressLine1("");
                vendorMaster2.setVendorAddressLine2("");
                vendorMaster2.setVendorAddressLine3("");
                vendorMaster2.setVendorCity("");
                vendorMaster2.setVendorPincode("");
                vendorMaster2.setVendorDistrict("");
                vendorMaster2.setVendorState("");
                vendorMaster2.setVendorCountry("");
                vendorMaster2.setVendorPhNo("");
                vendorMaster2.setVendorMobNo("");
                vendorMaster2.setVendorFax("");
                vendorMaster2.setVendorEmailID(unencryptedString);
                vendorMaster2.setFlag(2);
                vendorMaster2.setVendorcc("");
                vendorMaster2.setVendorRemark("");
                vendorMaster2.setVendorTypeId(1);
                vendorMasterService.create(vendorMaster2);

                List userMaster11 = userMasterService.readEmailId(unencryptedString);

                if (userMaster11.isEmpty()) {
                    UserMaster userMaster12 = new UserMaster();
                    userMaster12.setLoginName(unencryptedString);
                    userMaster12.setPassword("Admin@123");
                    userMaster12.setUserFullName(companyName);
                    userMaster12.setUserType(1);
                    userMaster12.setPwdChange(0);
                    userMaster12.setLock1(0);
                    userMaster12.setUserTry(0);
                    userMasterService.create(userMaster12);
                }
            }

            session.setAttribute("successMessage", "Vendor Invited Successfully");
            session.setAttribute("vendorInvitation", vendorInvitation);
            mv.setViewName("redirect:vendorInformation.htm?act=firstLevelnApprove");
        } else {
            session.setAttribute("failureMessage", "Vendor Already Exist.");
            session.setAttribute("vendorInvitation", vendorInvitation);
            mv.setViewName("redirect:vendorInvitation.htm?act=addVendorInvitation");
        }
        return mv;

    }

    public ModelAndView vendorInvite(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        VendorRequestDetails vendorRequestDetails = new VendorRequestDetails();
        List vendorApprovalsetting = vendorApprovalSettingService.read();

        List list = groupMasterService.read();
        List list1 = groupCategoryService.read();
        List list2 = groupSubCategoryService.read();

        request.setAttribute("list", list);
        request.setAttribute("list1", list1);
        request.setAttribute("list2", list2);
        mv.getModelMap().put("vendorApprovalsetting", vendorApprovalsetting);
        mv.getModelMap().put("vendorRequestDetails", vendorRequestDetails);
        mv.setViewName("Vendor/VendorInviteRequest");
        return mv;

    }

    public ModelAndView showInviteList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        VendorRequestDetails vendorRequestDetails = new VendorRequestDetails();
        List list = vendorRequestDetailsService.readByUserName(username);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("vendorRequestDetails", vendorRequestDetails);
        mv.setViewName("Vendor/ShowInviteList");
        return mv;

    }

    public ModelAndView vendorRequestApproval(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();
        VendorRequestDetails vendorRequestDetails = new VendorRequestDetails();
        List vendorApprovalsetting = vendorRequestApprovalService.readByUserName(username);
        mv.getModelMap().put("vendorApprovalsetting", vendorApprovalsetting);
        mv.getModelMap().put("vendorRequestDetails", vendorRequestDetails);
        mv.setViewName("Vendor/VendorRequestApproval");
        return mv;

    }

    public ModelAndView vendorRequestApproveSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        VendorRequestDetails vendorRequestDetails = new VendorRequestDetails();
        String company = request.getParameter("company");
        String contactaName = request.getParameter("contactaName");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");
        String description = request.getParameter("description");
        String address = request.getParameter("address");
        String approval = request.getParameter("approval");
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        vendorRequestDetails.setCompany(company);
        vendorRequestDetails.setContactaName(contactaName);
        vendorRequestDetails.setEmail(email);
        vendorRequestDetails.setPhoneNo(phoneNo);
        vendorRequestDetails.setDescription(description);
        vendorRequestDetails.setAddress(address);
        vendorRequestDetails.setFlagStatus(0);
        vendorRequestDetails.setCreatedBy(username);
        vendorRequestDetails.setVendorApprovalSetting(Integer.parseInt(approval));
        vendorRequestDetailsService.create(vendorRequestDetails);
        int vendorRequestId = vendorRequestDetails.getId();

        // approval name drop down relted code
        List approval_list = vendorApprovalUserService.readByIdToList1(approval);

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        VendorRequestApproval vendorRequestApproval = new VendorRequestApproval();
        vendorRequestApproval.setVendorDetailsId(vendorRequestId);
        vendorRequestApproval.setTotalApproval(approval_list.size());
        vendorRequestApproval.setApprovalStatus(0);
        vendorRequestApproval.setApprovalRemark("add");
        vendorRequestApproval.setUserId(employeeCode);
        vendorRequestApproval.setCurrentApproval("1");
        vendorRequestApprovalService.create(vendorRequestApproval);

        int approveId = vendorRequestApproval.getId();

        VendorRequestApproval vendorRequestApproval1 = vendorRequestApprovalService.readById(approveId);

        int j = 0;

        for (Object o : approval_list) {
            j++;
            VendorApprovalUser vap1 = (VendorApprovalUser) o;
            VendorRequestApprovalUser vendorRequestApprovalUser = new VendorRequestApprovalUser();
            vendorRequestApprovalUser.setVendorRequestApprovalId(approveId);
            vendorRequestApprovalUser.setVendorRequestDetailsId(vendorRequestId);
            vendorRequestApprovalUser.setUserId(vap1.getUserId());
            vendorRequestApprovalUser.setLevel(j);
            vendorRequestApprovalUser.setApprovalStatus(0);
            vendorRequestApprovalUserService.create(vendorRequestApprovalUser);

        }

        VendorRequestedInvitationCategory vendorRequestedInvitationCategory = new VendorRequestedInvitationCategory();
        String[] groupIdd = request.getParameterValues("groupIdd");
        String[] groupCategoryId = request.getParameterValues("groupCategoryId");
        String[] groupSubCategoryId = request.getParameterValues("groupSubcategory");
        int subCategoryIndex = 0;
        for (String subCat : groupSubCategoryId) {
            GroupSubCategory groupSubCategory = groupSubCategoryService.readById(Integer.parseInt(groupSubCategoryId[subCategoryIndex]));
            int groupMasterId = groupSubCategory.getGroupMasterId();
            int groupCategoryId1 = groupSubCategory.getGroupCategoryId();
            vendorRequestedInvitationCategory.setGroupId(groupMasterId);
            vendorRequestedInvitationCategory.setVendodRequestId(vendorRequestId); // Assuming 'id' is defined
            vendorRequestedInvitationCategory.setGroupCategoryId(groupCategoryId1);
            vendorRequestedInvitationCategory.setGroupSubCategoryId(Integer.parseInt(subCat));
            vendorRequestedInvitationCategoryService.create(vendorRequestedInvitationCategory);
            subCategoryIndex++;
        }

        List vendorApprovalsetting = vendorApprovalSettingService.read();
        mv.getModelMap().put("vendorApprovalsetting", vendorApprovalsetting);
        mv.getModelMap().put("vendorRequestDetails", vendorRequestDetails);
        mv = showInviteList(request, response);
        return mv;

    }

    public ModelAndView vendorRequestApprovalView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String id1 = request.getParameter("id1");
        VendorRequestDetails vendorRequestDetails = vendorRequestDetailsService.readById(Integer.parseInt(id));
        List vendorApprovalsetting = vendorApprovalSettingService.read();
        mv.getModelMap().put("vendorApprovalsetting", vendorApprovalsetting);
        mv.getModelMap().put("vendorRequestDetails", vendorRequestDetails);
        mv.getModelMap().put("id1", id1);
        mv.setViewName("Vendor/VendorRequestApprovalView");
        return mv;

    }

    public ModelAndView vendorRequestApprovalSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        String comment = request.getParameter("comment");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        VendorRequestApproval vendorReqApproval = vendorRequestApprovalService.readById(Integer.parseInt(id));
        int vendorReqApprovalid = vendorReqApproval.getId();

        int vendorReqId = vendorReqApproval.getVendorDetailsId();
        VendorRequestDetails vendorRequestDetails = vendorRequestDetailsService.readById(vendorReqId);

        VendorRequestApprovalUser vendorRequestApprovalUser = vendorRequestApprovalUserService.appval(username);

        int approvalid = vendorReqApproval.getId();

        VendorRequestApprovalComment vendorRequestApprovalComment = vendorRequestApprovalCommentService.readByApproveId(approvalid);

        int totalApproval = vendorReqApproval.getTotalApproval();
        String ca = vendorReqApproval.getCurrentApproval();

        if (ca.equals(totalApproval + "")) {
            vendorReqApproval.setApprovalStatus(1);
            vendorRequestApprovalUser.setApprovalStatus(1);
            vendorRequestApprovalComment.setApprovalStatus(1);
            vendorRequestDetails.setFlagStatus(2);

        } else {
            int level = vendorRequestApprovalUser.getLevel();
            int a = level;
            a++;

            vendorReqApproval.setCurrentApproval(level + "");
            vendorRequestApprovalUser.setApprovalStatus(1);
            vendorRequestApprovalComment.setApprovalStatus(1);
            vendorReqApproval.setCurrentApproval("2");

//	    VendorRequestApprovalUser oapFormApprovalUser1 = vendorRequestApprovalUserService.readLevel(level, oapFormid);
//	    String secondApproval = oapFormApprovalUser1.getUserId();
//	    EmployeeMaster employeeMaster = employeeMasterService.readUser(secondApproval);
        }

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();
        vendorRequestApprovalComment.setApprovalComment(comment);
        vendorRequestApprovalComment.setUserId(username);
        vendorRequestApprovalComment.setVendorRequestApprovalId(vendorReqApprovalid);
        vendorRequestApprovalComment.setApprovalStatus(1);
        vendorRequestApprovalComment.setVendorRequestDetailsId(vendorReqId);
        vendorRequestApprovalCommentService.create(vendorRequestApprovalComment);

        vendorRequestApprovalService.update(vendorReqApproval);
        vendorRequestApprovalUserService.update(vendorRequestApprovalUser);

        vendorRequestDetailsService.update(vendorRequestDetails);

        mv = vendorRequestApproval(request, response);
        return mv;

    }

    public ModelAndView vendorRequestRecycle(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        VendorRequestApproval vendorRequestApproval = vendorRequestApprovalService.readById(Integer.parseInt(id));
        int vendorReqAprovalid = vendorRequestApproval.getId();

        int vendorReqid = vendorRequestApproval.getVendorDetailsId();
        VendorRequestDetails vendorRequestDetails = vendorRequestDetailsService.readById(vendorReqid);

        VendorRequestApprovalUser vendorRequestApprovalUser = vendorRequestApprovalUserService.appval(username);

        int approvalid = vendorRequestApproval.getId();

        VendorRequestApprovalComment vendorRequestApprovalComment = vendorRequestApprovalCommentService.readByApproveId(approvalid);

        int level = vendorRequestApprovalUser.getLevel();
        int levelInt = level;
        levelInt--;

        vendorRequestApproval.setCurrentApproval(levelInt + "");
        vendorRequestApprovalUser.setApprovalStatus(2);
        vendorRequestApprovalComment.setApprovalStatus(2);
        vendorRequestDetails.setFlagStatus(4);
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        vendorRequestApprovalComment.setUserId(employeeCode);
        vendorRequestApprovalComment.setVendorRequestApprovalId(vendorReqAprovalid);
        vendorRequestApprovalComment.setApprovalComment(comment);
        vendorRequestApprovalComment.setVendorRequestDetailsId(vendorReqid);
        vendorRequestApprovalCommentService.create(vendorRequestApprovalComment);

        vendorRequestApprovalService.update(vendorRequestApproval);
        vendorRequestApprovalUserService.update(vendorRequestApprovalUser);
        vendorRequestDetailsService.update(vendorRequestDetails);

        mv = vendorRequestApproval(request, response);
        return mv;

    }

    public ModelAndView vendorRequestReject(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        String id = request.getParameter("id");
        String comment = request.getParameter("comment");

        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();

        VendorRequestApproval vendorRequestApproval = vendorRequestApprovalService.readById(Integer.parseInt(id));
        int vendorReqAprovalid = vendorRequestApproval.getId();

        int vendorReqid = vendorRequestApproval.getVendorDetailsId();
        VendorRequestDetails vendorRequestDetails = vendorRequestDetailsService.readById(vendorReqid);

        VendorRequestApprovalUser vendorRequestApprovalUser = vendorRequestApprovalUserService.appval(username);

        int approvalid = vendorRequestApproval.getId();

        VendorRequestApprovalComment vendorRequestApprovalComment = vendorRequestApprovalCommentService.readByApproveId(approvalid);

        int approvalStatus = vendorRequestApproval.getApprovalStatus();
        int g = 0;

        if (g == approvalStatus) {
            vendorRequestApproval.setApprovalStatus(3);
            vendorRequestApprovalUser.setApprovalStatus(3);
            vendorRequestApprovalComment.setApprovalStatus(3);
        } else {
            vendorRequestApprovalUser.setApprovalStatus(3);
            vendorRequestApprovalComment.setApprovalStatus(3);
        }
        vendorRequestDetails.setFlagStatus(3);

        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        vendorRequestApprovalComment.setUserId(employeeCode);
        vendorRequestApprovalComment.setVendorRequestApprovalId(vendorReqAprovalid);
        vendorRequestApprovalComment.setApprovalComment(comment);
        vendorRequestApprovalComment.setVendorRequestDetailsId(vendorReqid);
        vendorRequestApprovalCommentService.create(vendorRequestApprovalComment);

        vendorRequestApprovalService.update(vendorRequestApproval);
        vendorRequestApprovalUserService.update(vendorRequestApprovalUser);
        vendorRequestDetailsService.update(vendorRequestDetails);
        mv = vendorRequestApproval(request, response);
        return mv;
    }

    public ModelAndView vendorRequestRecycleEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        VendorRequestDetails vendorRequestDetails = vendorRequestDetailsService.readById(Integer.parseInt(id));
        List vendorApprovalsetting = vendorApprovalSettingService.read();
        mv.getModelMap().put("vendorApprovalsetting", vendorApprovalsetting);
        mv.getModelMap().put("vendorRequestDetails", vendorRequestDetails);
        List list = vendorRequestedInvitationCategoryService.readByVendorRequestId(id);
        mv.getModelMap().put("list", list);
        mv.setViewName("Vendor/VendorRequestRecycleEdit");
        return mv;

    }

    public ModelAndView vendorRequestRecycleSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");
        HttpSession session1 = request.getSession(false);
        UserMaster user1 = (UserMaster) session1.getAttribute("user");
        String username1 = user1.getLoginName();
        VendorRequestDetails vendorRequestDetails = vendorRequestDetailsService.readById(Integer.parseInt(id));
        String company = request.getParameter("company");
        String contactaName = request.getParameter("contactaName");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");
        String description = request.getParameter("description");
        String address = request.getParameter("address");
        String approval = request.getParameter("approval");
        vendorRequestDetails.setCompany(company);
        vendorRequestDetails.setContactaName(contactaName);
        vendorRequestDetails.setEmail(email);
        vendorRequestDetails.setPhoneNo(phoneNo);
        vendorRequestDetails.setDescription(description);
        vendorRequestDetails.setAddress(address);
        vendorRequestDetails.setFlagStatus(0);
        vendorRequestDetails.setVendorApprovalSetting(Integer.parseInt(approval));
        vendorRequestDetailsService.update(vendorRequestDetails);
        int vendorRequestId = vendorRequestDetails.getId();

        VendorRequestApproval vendorRequestApproval = vendorRequestApprovalService.readByDeltecodes(id);

        int formid = vendorRequestApproval.getId();
        List list44 = vendorRequestApprovalUserService.readByDleteCode(formid);

        for (Object o : list44) {
            VendorRequestApprovalUser vendorRequestApprovalUser = (VendorRequestApprovalUser) o;
            int id3 = vendorRequestApprovalUser.getId();
            vendorRequestApprovalUserService.delete(id3);

        }

        vendorRequestApprovalService.delete(formid);

        // approval name drop down relted code
        List approval_list = vendorApprovalUserService.readByIdToList(approval);
        HttpSession session = request.getSession(false);
        UserMaster user = (UserMaster) session.getAttribute("user");
        String username = user.getLoginName();
        EmployeeMaster employeeMaster = employeeMasterService.read(username);
        String employeeCode = employeeMaster.getEmployeeCode();

        VendorRequestApproval vendorRequestApproval1 = new VendorRequestApproval();
        vendorRequestApproval1.setVendorDetailsId(vendorRequestId);
        vendorRequestApproval1.setTotalApproval(approval_list.size());
        vendorRequestApproval1.setApprovalStatus(0);
        vendorRequestApproval1.setApprovalRemark("add");
        vendorRequestApproval1.setUserId(employeeCode);
        vendorRequestApproval1.setCurrentApproval("1");
        vendorRequestApprovalService.create(vendorRequestApproval1);

        int approveId = vendorRequestApproval1.getId();
        VendorRequestApproval vendorRequestApproval2 = vendorRequestApprovalService.readById(approveId);

        int j = 0;

        for (Object o : approval_list) {
            j++;
            VendorApprovalUser vendorApprovalUser = (VendorApprovalUser) o;
            VendorRequestApprovalUser vendorRequestApprovalUser = new VendorRequestApprovalUser();
            vendorRequestApprovalUser.setVendorRequestApprovalId(approveId);
            vendorRequestApprovalUser.setVendorRequestDetailsId(vendorRequestId);
            vendorRequestApprovalUser.setUserId(vendorApprovalUser.getUserId());
            vendorRequestApprovalUser.setLevel(j);
            vendorRequestApprovalUser.setApprovalStatus(0);
            vendorRequestApprovalUserService.create(vendorRequestApprovalUser);

        }

        mv = showInviteList(request, response);
        return mv;

    }

    public ModelAndView vendorRequestView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        VendorRequestDetails vendorRequestDetails = vendorRequestDetailsService.readById(Integer.parseInt(id));
        List vendorApprovalsetting = vendorApprovalSettingService.read();
        List list = vendorRequestedInvitationCategoryService.readByVendorRequestId(id);
        mv.getModelMap().put("list", list);
        mv.getModelMap().put("vendorApprovalsetting", vendorApprovalsetting);
        mv.getModelMap().put("vendorRequestDetails", vendorRequestDetails);

        mv.setViewName("Vendor/VendorRequestView");
        return mv;

    }

    public ModelAndView requestVendor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();

        List list = vendorRequestDetailsService.readByAprrove1();

        mv.getModelMap().put("list", list);

        mv.setViewName("Vendor/RequestVendor");
        return mv;

    }

    public ModelAndView requestedVendorInvitation(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String id = request.getParameter("id");

        VendorRequestDetails vendorRequestDetails = vendorRequestDetailsService.readById(Integer.parseInt(id));
        VendorInvitation vendorInvitation = new VendorInvitation();
        List list = groupMasterService.read();
        List list1 = groupCategoryService.read();
        List list2 = groupSubCategoryService.read();

        //readEmployee(request, response);
        mv.getModelMap().put("vendorInvitation", vendorInvitation);
        request.setAttribute("list", list);
        request.setAttribute("list1", list1);
        request.setAttribute("list2", list2);
        List list3 = bpGroupService.read();
        request.setAttribute("list3", list3);
        //////////////////////////Financial Approval List
        List vendorDepartmentApproval = vendorDepartmentApprovalService.readFinancialApproval();
        List financialList = new ArrayList();

        for (Object o : vendorDepartmentApproval) {
            VendorDepartmentApproval vendorDepartmentApproval2 = (VendorDepartmentApproval) o;
            String departName = vendorDepartmentApproval2.getDepartmentId();
            List financialList1 = employeeMasterService.readByDepartName(departName);
            for (Object o1 : financialList1) {
                EmployeeMaster employeeMaster = (EmployeeMaster) o1;

                String name = employeeMaster.getName();
                financialList.add(name);
            }

        }

        //////////////////////////Technical Approval List
        List vendorDepartmentApproval1 = vendorDepartmentApprovalService.readTehnicalApproval();
        List technicalList = new ArrayList();

        for (Object o : vendorDepartmentApproval1) {
            VendorDepartmentApproval vendorDepartmentApproval2 = (VendorDepartmentApproval) o;
            String departName = vendorDepartmentApproval2.getDepartmentId();
            List technicalList1 = employeeMasterService.readByDepartName(departName);
            for (Object o1 : technicalList1) {
                EmployeeMaster employeeMaster = (EmployeeMaster) o1;

                String name = employeeMaster.getName();
                technicalList.add(name);
            }

        }

        //////////////////////////HR Approval List
        List vendorDepartmentApproval22 = vendorDepartmentApprovalService.readHrApproval();
        List hrList = new ArrayList();

        for (Object o : vendorDepartmentApproval22) {
            VendorDepartmentApproval vendorDepartmentApproval2 = (VendorDepartmentApproval) o;
            String departName = vendorDepartmentApproval2.getDepartmentId();
            List hrList1 = employeeMasterService.readByDepartName(departName);
            for (Object o1 : hrList1) {
                EmployeeMaster employeeMaster = (EmployeeMaster) o1;

                String name = employeeMaster.getName();
                hrList.add(name);
            }

        }

        //////////////////////////Safety Approval List
        List vendorDepartmentApproval222 = vendorDepartmentApprovalService.readSafetyApproval();
        List safetyList = new ArrayList();

        for (Object o : vendorDepartmentApproval222) {
            VendorDepartmentApproval vendorDepartmentApproval2 = (VendorDepartmentApproval) o;
            String departName = vendorDepartmentApproval2.getDepartmentId();
            List safetyList1 = employeeMasterService.readByDepartName(departName);
            for (Object o1 : safetyList1) {
                EmployeeMaster employeeMaster = (EmployeeMaster) o1;

                String name = employeeMaster.getName();
                safetyList.add(name);
            }

        }

        List list5 = vendorRequestedInvitationCategoryService.readByVendorRequestId(id);
        mv.getModelMap().put("list5", list5);

        mv.getModelMap().put("financialList", financialList);
        mv.getModelMap().put("technicalList", technicalList);
        mv.getModelMap().put("hrList", hrList);
        mv.getModelMap().put("safetyList", safetyList);
        mv.getModelMap().put("vendorRequestDetails", vendorRequestDetails);

        mv.setViewName("Vendor/RequestedVendorInvitation");
        return mv;

    }

    public ModelAndView vendorInvitationView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        VendorInvitation vendorInvitation = new VendorInvitation();
        List list = groupMasterService.read();
        List list1 = groupCategoryService.read();
        List list2 = groupSubCategoryService.read();

        //readEmployee(request, response);
        mv.getModelMap().put("vendorInvitation", vendorInvitation);
        request.setAttribute("list", list);
        request.setAttribute("list1", list1);
        request.setAttribute("list2", list2);
        List list3 = bpGroupService.read();
        request.setAttribute("list3", list3);
        String id = request.getParameter("id");
        VendorInformation vendorInformation = vendorInformationService.readById(Integer.parseInt(id));
        request.setAttribute("vendorInformation", vendorInformation);
        String buyer = vendorInformation.getApprovalOne();
        String safety = vendorInformation.getSafetyApproval();
        String hr = vendorInformation.getHrApproval();
        String it = vendorInformation.getItApproval();
        String technical = vendorInformation.getTechnicalApproval();
        String financial = vendorInformation.getFinacialApproval();
        String vendor = vendorInformation.getCompanyName();
        int vendorInvitationid = vendorInformation.getVendorInvitationId();

        List vendorInvitationList = vendorInvitationCategoryService.readByVendorInvtlistId(vendorInvitationid);

        Map<String, Integer> rightsMap = new HashMap<>();

        for (Object vendorinvList : vendorInvitationList) {

            VendorInvitationCategory v = (VendorInvitationCategory) vendorinvList;
            String groupSubCategoryId = v.getGroupSubCategoryId();
            GroupSubCategory groupSubCategory = groupSubCategoryService.readById(Integer.parseInt(groupSubCategoryId));

            // Now check each field and update the map if 1 is found
            if (Integer.parseInt(groupSubCategory.getHr()) == 1) {
                rightsMap.put("HR", 1);
            }
            if (Integer.parseInt(groupSubCategory.getHsc()) == 1) {
                rightsMap.put("HSC", 1);
            }
            if (Integer.parseInt(groupSubCategory.getIt()) == 1) {
                rightsMap.put("IT", 1);
            }
            if (Integer.parseInt(groupSubCategory.getTechnical()) == 1) {
                rightsMap.put("TECHNICAL", 1);
            }
        }

        //////////////////////////Financial Approval List
        List vendorDepartmentApproval = vendorDepartmentApprovalService.readFinancialApproval();
        List financialList = new ArrayList();

        for (Object o : vendorDepartmentApproval) {
            VendorDepartmentApproval vendorDepartmentApproval2 = (VendorDepartmentApproval) o;
            String departName = vendorDepartmentApproval2.getDepartmentId();
            List financialList1 = employeeMasterService.readByDepartName(departName);
            for (Object o1 : financialList1) {
                EmployeeMaster employeeMaster = (EmployeeMaster) o1;

                String name = employeeMaster.getName();
                financialList.add(name);
            }

        }

        //////////////////////////Technical Approval List
        List vendorDepartmentApproval1 = vendorDepartmentApprovalService.readTehnicalApproval();
        List technicalList = new ArrayList();

        for (Object o : vendorDepartmentApproval1) {
            VendorDepartmentApproval vendorDepartmentApproval2 = (VendorDepartmentApproval) o;
            String departName = vendorDepartmentApproval2.getDepartmentId();
            List technicalList1 = employeeMasterService.readByDepartName(departName);
            for (Object o1 : technicalList1) {
                EmployeeMaster employeeMaster = (EmployeeMaster) o1;

                String name = employeeMaster.getName();
                technicalList.add(name);
            }

        }
        if (rightsMap.containsKey("TECHNICAL")) {

            mv.getModelMap().put("technicalList", technicalList);
        }

        //////////////////////////HR Approval List
        List vendorDepartmentApproval22 = vendorDepartmentApprovalService.readHrApproval();
        List hrList = new ArrayList();

        for (Object o : vendorDepartmentApproval22) {
            VendorDepartmentApproval vendorDepartmentApproval2 = (VendorDepartmentApproval) o;
            String departName = vendorDepartmentApproval2.getDepartmentId();
            List hrList1 = employeeMasterService.readByDepartName(departName);
            for (Object o1 : hrList1) {
                EmployeeMaster employeeMaster = (EmployeeMaster) o1;

                String name = employeeMaster.getName();
                hrList.add(name);
            }

        }
        if (rightsMap.containsKey("HR")) {

            mv.getModelMap().put("hrList", hrList);
        }

        //////////////////////////Safety Approval List
        List vendorDepartmentApproval222 = vendorDepartmentApprovalService.readSafetyApproval();
        List safetyList = new ArrayList();

        for (Object o : vendorDepartmentApproval222) {
            VendorDepartmentApproval vendorDepartmentApproval2 = (VendorDepartmentApproval) o;
            String departName = vendorDepartmentApproval2.getDepartmentId();
            List safetyList1 = employeeMasterService.readByDepartName(departName);
            for (Object o1 : safetyList1) {
                EmployeeMaster employeeMaster = (EmployeeMaster) o1;

                String name = employeeMaster.getName();
                safetyList.add(name);
            }

        }
        if (rightsMap.containsKey("HSC")) {

            mv.getModelMap().put("safetyList", safetyList);
        }

        //////////////////////////It Approval List
        List vendorDepartmentApproval2222 = vendorDepartmentApprovalService.readITApproval();
        List itList = new ArrayList();

        for (Object o : vendorDepartmentApproval2222) {
            VendorDepartmentApproval vendorDepartmentApproval2 = (VendorDepartmentApproval) o;
            String departName = vendorDepartmentApproval2.getDepartmentId();
            List itList1 = employeeMasterService.readByDepartName(departName);
            for (Object o1 : itList1) {
                EmployeeMaster employeeMaster = (EmployeeMaster) o1;

                String name = employeeMaster.getName();
                itList.add(name);
            }

        }
        if (rightsMap.containsKey("IT")) {

            mv.getModelMap().put("itList", itList);
        }

        List list21 = userRightsService.readByBuyerApproval();

        mv.getModelMap().put("financialList", financialList);
        mv.getModelMap().put("buyer", buyer);
        mv.getModelMap().put("safety", safety);
        mv.getModelMap().put("hr", hr);
        mv.getModelMap().put("it", it);
        mv.getModelMap().put("technical", technical);
        mv.getModelMap().put("financial", financial);
        mv.getModelMap().put("vendorInvitationid", vendorInvitationid);
        mv.getModelMap().put("list21", list21);
        mv.getModelMap().put("vendor", vendor);
        mv.setViewName("Vendor/VendorInvitationView");
        return mv;

    }

    public ModelAndView editInvitationDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String vendorInvitationid = request.getParameter("vendorInvitationid");
        String vendorInformation1 = request.getParameter("vendorInformation");

        String financialApproval = request.getParameter("financialApproval");
        String technicalApproval = request.getParameter("technicalApproval");
        String hrApproval1 = request.getParameter("hrApproval");
        String itApproval = request.getParameter("itApproval");
        String safetyApproval = request.getParameter("safetyApproval");
        String buyer = request.getParameter("buyer");

        VendorInvitation vendorInvitation = vendorInvitationService.readById(Integer.parseInt(vendorInvitationid));

        vendorInvitation.setHrName(hrApproval1);
        vendorInvitation.setSafetyName(safetyApproval);
        vendorInvitation.setTechnicalName(technicalApproval);
        vendorInvitation.setFinanicailName(financialApproval);
        vendorInvitation.setInvitedBy(buyer);

        vendorInvitationService.update(vendorInvitation);

        VendorInformation vendorInformation = vendorInformationService.readById(Integer.parseInt(vendorInformation1));
        vendorInformation.setHrApproval(hrApproval1);
        vendorInformation.setItApproval(itApproval);
        vendorInformation.setSafetyApproval(safetyApproval);
        vendorInformation.setTechnicalApproval(technicalApproval);
        vendorInformation.setApprovalOne(buyer);
        vendorInformation.setApprovalTwo(financialApproval);
        vendorInformationService.update(vendorInformation);
        mv.setViewName("forward:vendorInvitation.htm?act=addVendorInvitation");
        return mv;
    }
}
