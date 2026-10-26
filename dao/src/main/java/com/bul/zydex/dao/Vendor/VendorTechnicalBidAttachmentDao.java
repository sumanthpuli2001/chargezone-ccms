/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorTechnicalBidAttachment;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorTechnicalBidAttachmentDao<T> extends GenericsDAO<T> {

    public List readByVendorRefNo(String refNo, String username);

    public List readVendorRefNo(String refNo, String username, String attachment_desc);

    public void updateVendorRefNo(String refNo, String username, String attachment_desc, String attachment_comp, String attachment);

    public VendorTechnicalBidAttachment readByTechdoc(String refNo, String username, String tech_attachment_desc);

    public void readByDelete(String refNo, String username);
    
}
