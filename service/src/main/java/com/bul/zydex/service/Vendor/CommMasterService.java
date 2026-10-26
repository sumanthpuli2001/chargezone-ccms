/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.CommMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface CommMasterService<T> extends GenericsService<T> {

    public List readTenderVendorComm(String tender_no, String username);

    public void updateRead(String id);

    public List readTenderComm(String tender_no);
    
}
