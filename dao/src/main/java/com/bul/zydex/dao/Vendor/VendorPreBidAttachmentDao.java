/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorPreBidAttachment;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorPreBidAttachmentDao<T> extends GenericsDAO<T> {

    public List readByVendorRefNo(String refNo, String username);

    public List readVendorRefNo(String refNo, String username, String pre_attachment_desc);

    public void updateVendorRefNo(String refNo, String username, String pre_attachment_desc, String pre_attachment_comp, String pre_attachment);
    
}
