/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuthTenderItemAttachment;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuthTenderItemAttachmentDao<T> extends GenericsDAO<T> {
    
    public List readByRefNo(String refNo, String pur_no, String item_no);

    public List readByDocRefNo(String refNo, String pur_no, String item_no, String attachment);

    public void deleteRefNo(String refNo);
}
