/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormMultiAttachment;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface AocFormMultiAttachmentService<T> extends GenericsService<T> {

    public List readByMulti(String aocFormmulti);

    public List readByattachzip(String id1);
    
}
