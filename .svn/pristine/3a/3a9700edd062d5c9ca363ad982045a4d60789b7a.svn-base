/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.expense;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.EmailTemplate;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ExpenseMaster;
import com.bul.zydex.model.ExpenseOtherType;
import com.bul.zydex.model.ExpenseReconsilation;
import com.bul.zydex.model.ExpenseTravelType;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PolicyMaster;
import com.bul.zydex.model.RelocationOrOtherExpense;
import com.bul.zydex.model.TravelRequestMaster;
import com.bul.zydex.model.UserMaster;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.EmailTemplateService;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.expense.ExpenseMasterService;
import com.bul.zydex.service.expense.ExpenseReconsilationService;
import com.bul.zydex.service.expenseOtherType.ExpenseOtherTypeService;
import com.bul.zydex.service.expenseTravelType.ExpenseTravelTypeService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.otherExpense.RelocationOrOtherExpenseService;
import com.bul.zydex.service.policy.PolicyMasterService;
import com.bul.zydex.service.travel.TravelRequestMasterService;
import com.bul.zydex.util.SendMail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author dhruv
 */
public abstract class ExpenseMasterAbstract extends CustomAbstract {

    protected ExpenseMasterService<ExpenseMaster> expenseMasterService;
    protected Validator expenseMasterValidator;
    protected LevelMasterService<LevelMaster> levelMasterService;
    protected TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService;
    protected PolicyMasterService<PolicyMaster> policyMasterService;
    protected ExpenseTravelTypeService<ExpenseTravelType> expenseTravelTypeService;
    protected ExpenseOtherTypeService<ExpenseOtherType> expenseOtherTypeService;
    protected RelocationOrOtherExpenseService<RelocationOrOtherExpense> relocationOrOtherExpenseService;
    protected ExpenseReconsilationService<ExpenseReconsilation> expenseReconsilationService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected EmailTemplateService<EmailTemplate> emailTemplateService;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;
    protected SendMail sendMail;

    public RelocationOrOtherExpenseService<RelocationOrOtherExpense> getRelocationOrOtherExpenseService() {
        return relocationOrOtherExpenseService;
    }

    public void setRelocationOrOtherExpenseService(RelocationOrOtherExpenseService<RelocationOrOtherExpense> relocationOrOtherExpenseService) {
        this.relocationOrOtherExpenseService = relocationOrOtherExpenseService;
    }

    public ExpenseTravelTypeService<ExpenseTravelType> getExpenseTravelTypeService() {
        return expenseTravelTypeService;
    }

    public void setExpenseTravelTypeService(ExpenseTravelTypeService<ExpenseTravelType> expenseTravelTypeService) {
        this.expenseTravelTypeService = expenseTravelTypeService;
    }

    public ExpenseOtherTypeService<ExpenseOtherType> getExpenseOtherTypeService() {
        return expenseOtherTypeService;
    }

    public void setExpenseOtherTypeService(ExpenseOtherTypeService<ExpenseOtherType> expenseOtherTypeService) {
        this.expenseOtherTypeService = expenseOtherTypeService;
    }

    public PolicyMasterService<PolicyMaster> getPolicyMasterService() {
        return policyMasterService;
    }

    public void setPolicyMasterService(PolicyMasterService<PolicyMaster> policyMasterService) {
        this.policyMasterService = policyMasterService;
    }

    public TravelRequestMasterService<TravelRequestMaster> getTravelRequestMasterService() {
        return travelRequestMasterService;
    }

    public void setTravelRequestMasterService(TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService) {
        this.travelRequestMasterService = travelRequestMasterService;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public ExpenseMasterService<ExpenseMaster> getExpenseMasterService() {
        return expenseMasterService;
    }

    public void setExpenseMasterService(ExpenseMasterService<ExpenseMaster> expenseMasterService) {
        this.expenseMasterService = expenseMasterService;
    }

    public Validator getExpenseMasterValidator() {
        return expenseMasterValidator;
    }

    public void setExpenseMasterValidator(Validator expenseMasterValidator) {
        this.expenseMasterValidator = expenseMasterValidator;
    }

    public ExpenseReconsilationService<ExpenseReconsilation> getExpenseReconsilationService() {
        return expenseReconsilationService;
    }

    public void setExpenseReconsilationService(ExpenseReconsilationService<ExpenseReconsilation> expenseReconsilationService) {
        this.expenseReconsilationService = expenseReconsilationService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public EmailTemplateService<EmailTemplate> getEmailTemplateService() {
        return emailTemplateService;
    }

    public void setEmailTemplateService(EmailTemplateService<EmailTemplate> emailTemplateService) {
        this.emailTemplateService = emailTemplateService;
    }

    public SendMail getSendMail() {
        return sendMail;
    }

    public void setSendMail(SendMail sendMail) {
        this.sendMail = sendMail;
    }

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    protected void selectTravelNo(HttpServletRequest request, UserMaster user) {
        TravelRequestMaster travelRequestMaster = new TravelRequestMaster();
        EmployeeMaster employeeMaster = new EmployeeMaster();
        employeeMaster.setUserMaster(user);
        List<?> empList = employeeMasterService.readByUserName(employeeMaster);
        if (!empList.isEmpty()) {
            employeeMaster = (EmployeeMaster) empList.get(0);
        }
        travelRequestMaster.setEmployeeMasterByEmployeeMasterId(employeeMaster);
        List<?> travelList = travelRequestMasterService.readTotalRequest(travelRequestMaster);
        Map<Integer, String> travelNo = new HashMap<>();
        for (Object o : travelList) {
            travelRequestMaster = (TravelRequestMaster) o;
            if (!travelRequestMaster.getTravelType().equals("Local")) {
                travelNo.put(travelRequestMaster.getId(), travelRequestMaster.getTravelRequestNo());
            }
        }
        request.setAttribute("travelNo", travelNo);
    }

    protected void policyList(HttpServletRequest request) {
        PolicyMaster policyMaster = new PolicyMaster();
        List<?> policyList = policyMasterService.read();
        Map<Integer, String> dm = new HashMap<>();
        for (Object o : policyList) {
            policyMaster = (PolicyMaster) o;
            dm.put(policyMaster.getId(), policyMaster.getPolicyName());
        }

        request.setAttribute("policyMap", dm);
    }
}
