/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.zydexLocation;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Irfan
 */
public interface ZydexLocationMasterDAO<T> extends GenericsDAO<T> {

    public boolean isExist(T object);
    
    public List<?> readByName(String zydexLocation);

}
