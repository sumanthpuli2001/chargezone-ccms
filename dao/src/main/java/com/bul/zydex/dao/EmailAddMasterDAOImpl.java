/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao;

import com.bul.zydex.model.EmailAddMaster;
import java.util.List;

/**
 *
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public class EmailAddMasterDAOImpl<T> extends GenericsDAOImpl<T> implements EmailAddMasterDAO<T> {

    public Class getDomainClass() {
        return EmailAddMaster.class;
    }

    @Override
    public List<?> readByName(T object) {
        EmailAddMaster emailAddMaster = (EmailAddMaster) object;
        String query = "";

        query += " FROM EmailAddMaster a"
                + " WHERE a.moduleName = '" + emailAddMaster.getModuleName() + "'"
                + " and a.departmentMaster.id=" + emailAddMaster.getDepartmentMaster().getId();

        return getHibernateTemplate().find(query);
    }

}
