/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapMultiAttachment;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface OapMultiAttachmentDao<T> extends GenericsDAO<T> {

    public List readByMulti(String oapFormmulti);

    public List readByattachzip(String id1);

    
}
