/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CommMasterAttachment;
import java.util.List;
/**
 *
 * @author admin
 */
public interface CommMasterAttachmentDao<T> extends GenericsDAO<T> {

    public List readByCommId(String tender_no, String username, String subject);
    
}
