/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapDocumentAttachment;

import com.bul.zydex.model.OapDocumentAttachment;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface OapDocumentAttachmentService<T> extends GenericsService<T> {

    public List readByattach(String oapFormattach);

    public OapDocumentAttachment readByattach1(String id1);

    public List readByattachzip(String id1);

    public void deleteByid(String id);
    
}
