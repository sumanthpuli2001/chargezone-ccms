/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

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
import com.bul.zydex.service.UserMasterService;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emp.EmployeeMasterService;
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
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public abstract class ExpenseReportAbstarct extends CustomAbstract{

    
    
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

    public TravelRequestMasterService<TravelRequestMaster> getTravelRequestMasterService() {
        return travelRequestMasterService;
    }

    public void setTravelRequestMasterService(TravelRequestMasterService<TravelRequestMaster> travelRequestMasterService) {
        this.travelRequestMasterService = travelRequestMasterService;
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

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public PolicyMasterService<PolicyMaster> getPolicyMasterService() {
        return policyMasterService;
    }

    public void setPolicyMasterService(PolicyMasterService<PolicyMaster> policyMasterService) {
        this.policyMasterService = policyMasterService;
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

    public RelocationOrOtherExpenseService<RelocationOrOtherExpense> getRelocationOrOtherExpenseService() {
        return relocationOrOtherExpenseService;
    }

    public void setRelocationOrOtherExpenseService(RelocationOrOtherExpenseService<RelocationOrOtherExpense> relocationOrOtherExpenseService) {
        this.relocationOrOtherExpenseService = relocationOrOtherExpenseService;
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

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }
     public JSONObject doPost(HttpServletRequest request)
            throws ServletException, IOException, JSONException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) { /*report an error*/ }
         JSONObject jsonObject = new JSONObject(jb.toString());

        return jsonObject;
  
    }

}
