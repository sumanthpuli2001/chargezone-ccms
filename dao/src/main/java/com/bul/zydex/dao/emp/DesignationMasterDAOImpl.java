/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.emp;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.DesignationMaster;
import java.util.List;

/**
 *
 * @author Administrator
 * @param <T>
 */
public class DesignationMasterDAOImpl<T> extends GenericsDAOImpl<T> implements
        DesignationMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return DesignationMaster.class;
    }

    @Override
    public boolean isExist(T t) {
        boolean flag = false;
        DesignationMaster designationMaster = (DesignationMaster) t;
        List list = getHibernateTemplate().find("from DesignationMaster where designationName='" + designationMaster.getDesignationName() + "'");
        //To change body of generated methods, choose Tools | Templates.
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public List<?> readByName(String designation) {
        String query = "";
        query += "From DesignationMaster a "
//                + " Where a.designationName like '%" + designation + "'";
                + " Where lower(trim(a.designationName)) = '" + designation + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List<?> readDesignationAndLevel() {
        return getHibernateTemplate().find("select dgm , lm.level from DesignationMaster dgm left join dgm.levelMaster lm");
    }

    @Override
    public List<?> readDesignationsOfLevel(final int levelMasterId) {
        return getHibernateTemplate().find("From DesignationMaster dgm where dgm.levelMaster=" + levelMasterId);
    }

    @Override
    public List<?> readByID(int empdesig) {
        String query = "";
        query += "From DesignationMaster a "
              + " Where a.id =" + empdesig ;
        return getHibernateTemplate().find(query);
    }

}
