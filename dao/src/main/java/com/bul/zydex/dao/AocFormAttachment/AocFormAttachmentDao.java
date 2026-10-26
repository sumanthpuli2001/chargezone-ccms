/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormAttachment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AocFormAttachment;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface AocFormAttachmentDao<T> extends GenericsDAO<T> {

    public List readByattach(String aocFormattach);

    public List readByattachzip(String id1);

    public void deleteByid(int id1);
    
}
