/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CommMaster;
import java.util.List;

/**
 *
 * @author admin
 */
public interface CommMasterDao<T> extends GenericsDAO<T> {

    public List readTenderVendorComm(String tender_no, String username);

    public void updateRead(String id);

    public List readTenderComm(String tender_no);
    
}
