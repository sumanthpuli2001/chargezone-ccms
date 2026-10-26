/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface TechnicalMultiAttachmentDao<T> extends GenericsDAO<T> {

    public List readByRefNoVendorCode(String ref_no, String vendorCode);
}
