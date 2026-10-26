/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorBuyerApproval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorBuyerApproval;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface VendorBuyerApprovalDao<T> extends GenericsDAO<T> {

    public VendorBuyerApproval readByVendorInvtId(int vendorInvtId);

    public List readByVendorInvtIdList(int vendorInvtId);

}
