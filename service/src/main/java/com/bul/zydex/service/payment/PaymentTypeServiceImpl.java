/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.payment;

import com.bul.zydex.dao.Payment.PaymentTypeDAO;
import com.bul.zydex.dao.emp.EmployeeTypeDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import com.bul.zydex.service.emp.EmployeeTypeService;
import static com.lowagie.text.pdf.PdfName.T;
import static com.lowagie.text.pdf.PdfPKCS7.X509Name.T;
import static javafx.scene.input.KeyCode.T;
import static org.apache.derby.impl.sql.compile.SQLParserConstants.T;
import static org.bouncycastle.asn1.x509.X509Name.T;

/**
 *
 * @author admin
 */
public class PaymentTypeServiceImpl<T> extends GenericsServiceImpl<T> implements PaymentTypeService<T>{
    
    private PaymentTypeDAO<T> paymentTypeDAO;

    public PaymentTypeDAO<T> getEmployeeTypeDAO() {
        return paymentTypeDAO;
    }

    public void setPaymentTypeDAO(PaymentTypeDAO<T> paymentTypeDAO) {
        this.paymentTypeDAO = paymentTypeDAO;
        setGenericsDAO(paymentTypeDAO);
    }
}
