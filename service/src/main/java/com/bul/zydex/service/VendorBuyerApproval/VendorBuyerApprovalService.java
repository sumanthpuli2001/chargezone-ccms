/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorBuyerApproval;

import com.bul.zydex.model.VendorBuyerApproval;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface VendorBuyerApprovalService<T> extends GenericsService<T> {

    public VendorBuyerApproval readByVendorInvtId(int vendorInvtId);

    public List readByVendorInvtIdList(int vendorInvtId);

}
