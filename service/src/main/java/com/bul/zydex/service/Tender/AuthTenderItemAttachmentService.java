/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.model.AuthTenderItemAttachment;
import com.bul.zydex.service.GenericsService;
import java.util.List;
/**
 *
 * @author admin
 */
public interface AuthTenderItemAttachmentService<T> extends GenericsService<T> {

    public List readByRefNo(String refNo, String pur_no, String item_no);
    
    public List readByDocRefNo(String refNo, String pur_no, String item_no, String attachment);

    public void deleteRefNo(String refNo);
    
}
