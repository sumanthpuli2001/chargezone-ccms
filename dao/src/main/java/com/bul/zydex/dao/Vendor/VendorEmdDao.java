/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorEmd;
import java.util.List;
/**
 *
 * @author admin
 */
public interface VendorEmdDao<T> extends GenericsDAO<T> {

    public VendorEmd readByVendorRefNo(String refNo, String username);

    public List readVendorRefNo(String refNo, String username);

    public void updateVendorRefNo(String refNo, String username, String emd, String emd_date, String emd_drawee_bank, String emd_attach, String cash_cheque, String emd_cheque_no);
    
}
