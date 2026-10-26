/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapDocumentAttachment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.OapDocumentAttachment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface OapDocumentAttachmentDao<T> extends GenericsDAO<T> {

    public List readByattach(String oapFormattach);

    public OapDocumentAttachment readByattach1(String id1);

    public List readByattachzip(String id1);

    public void deleteByid(String id);
    
}
