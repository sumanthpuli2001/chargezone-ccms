/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.zydexLocation;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.ZydexLocationMaster;
import java.util.List;

/**
 *
 * @author Irfan
 */
public class ZydexLocationMasterDAOImpl<T> extends GenericsDAOImpl<T>implements ZydexLocationMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return ZydexLocationMaster.class;
    }

    @Override
    public boolean isExist(T object) {
         boolean flag = false;
        ZydexLocationMaster zydexLocationMaster = (ZydexLocationMaster) object;
        List<?> list = getHibernateTemplate().find("from ZydexLocationMaster  where zydexLocation ='" + zydexLocationMaster.getZydexLocation() + "'");
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }
    
     @Override
    public List<?> readByName(String zydexLocation) {
         String query = "";
          query += "From ZydexLocationMaster a "
//                + " Where a.zydexLocation = '" + zydexLocation + "'";
                + " Where lower(trim(a.zydexLocation)) ='" + zydexLocation + "'";
       return getHibernateTemplate().find(query);
    }
    
    
    
}
