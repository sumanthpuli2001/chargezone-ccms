/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.VendorFee;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface VendorFeeService<T> extends GenericsService<T> {

    public VendorFee readByVendorRefNo(String refNo, String username);

    public List readVendorRefNo(String refNo, String username);

    public void updateVendorRefNo(String refNo, String username, String doc_cost, String fee_date, String fee_drawee_bank, String fee_attach, String fee_cheque_no);
    
}
