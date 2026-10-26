/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormAttachment;

import com.bul.zydex.model.AocFormAttachment;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface AocFormAttachmentService<T> extends GenericsService<T> {

    public List readByattach(String aocFormattach);

    public List readByattachzip(String id1);

    public void deleteByid(int id1);
    
}
