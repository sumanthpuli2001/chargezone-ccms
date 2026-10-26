/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.DesignCoordinatorMultiAttach;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.DesignCoordinatorMultiAttach;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface DesignCoordinatorMultiAttachDao <T> extends GenericsDAO<T>{

    public List readBydelmultiid(int oapformid);

    public List readBydelmultiid1( int aocformid);

    public List readBydelimultiid(String id1);

    public DesignCoordinatorMultiAttach readBydelmultiids(int oapid);

    public DesignCoordinatorMultiAttach readBydelmultiidsaoc(int aocid);
    
}
