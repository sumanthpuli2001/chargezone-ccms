/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.payment;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.PaymentMode;
import com.bul.zydex.model.PaymentTypeMaster;
import com.bul.zydex.model.TypeOfPayment;
import com.bul.zydex.model.Vendors;
import com.bul.zydex.service.location.LocationMasterService;
import com.bul.zydex.service.payment.PaymentModeService;
import com.bul.zydex.service.payment.PaymentTypeMasterService;
import com.bul.zydex.service.payment.PaymentTypeService;
import com.bul.zydex.service.payment.VendorService;
import org.springframework.validation.Validator;

/**
 *
 * @author admin
 */
public abstract class PaymentAbstract extends CustomAbstract {

    //protected EmployeeTypeService<EmployeeTypeMaster> employeeTypeService;
    protected Validator vendorValidator;

    public Validator getVendorValidator() {
        return vendorValidator;
    }

    public void setVendorValidator(Validator vendorValidator) {
        this.vendorValidator = vendorValidator;
    }
    protected PaymentTypeService<TypeOfPayment> paymentTypeService;
    protected PaymentModeService<PaymentMode> paymentModeService;
    protected PaymentTypeMasterService<PaymentTypeMaster> paymentTypeMasterService;
    protected LocationMasterService<LocationMaster> locationMasterService;
    protected VendorService<Vendors> vendorService;

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public PaymentTypeMasterService<PaymentTypeMaster> getPaymentTypeMasterService() {
        return paymentTypeMasterService;
    }

    public void setPaymentTypeMasterService(PaymentTypeMasterService<PaymentTypeMaster> paymentTypeMasterService) {
        this.paymentTypeMasterService = paymentTypeMasterService;
    }

    public PaymentModeService<PaymentMode> getPaymentModeService() {
        return paymentModeService;
    }

    public void setPaymentModeService(PaymentModeService<PaymentMode> paymentModeService) {
        this.paymentModeService = paymentModeService;
    }

    public PaymentTypeService<TypeOfPayment> getEmployeeTypeService() {
        return paymentTypeService;
    }

    public void setPaymentTypeService(PaymentTypeService<TypeOfPayment> employeeTypeService) {
        this.paymentTypeService = employeeTypeService;
    }

    public VendorService<Vendors> getVendorService() {
        return vendorService;
    }

    public void setVendorService(VendorService<Vendors> vendorService) {
        this.vendorService = vendorService;
    }
}
