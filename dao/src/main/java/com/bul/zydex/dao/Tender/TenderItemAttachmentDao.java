/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.TenderItemAttachment;
import java.util.List;

/**
 *
 * @author admin
 */
public interface TenderItemAttachmentDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo, String pur_no, String item_no);

    public List readByDocRefNo(String refNo, String pur_no, String item_no, String attachment);

    public void deleteByRefNo(String refNo, String pur_no, String item_no);

    public List readByRefNo1(String refNo);
    
}
