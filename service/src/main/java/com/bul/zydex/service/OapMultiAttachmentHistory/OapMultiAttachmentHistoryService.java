/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapMultiAttachmentHistory;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OapMultiAttachmentHistoryService<T> extends GenericsService<T> {

    public List readByMulti(int oaphistoryid);

    public List readByMulti1(String id);

    
}
