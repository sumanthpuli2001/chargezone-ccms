/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Recruitment;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.MprEmployeeTypeMaster;

/**
 *
 * @author Vikas
 */
public class MprEmployeeTypeMasterDAOImpl<T> extends GenericsDAOImpl<T> implements MprEmployeeTypeMasterDAO<T>{

    @Override
    protected Class getDomainClass() {
        return MprEmployeeTypeMaster.class;
    }
    
}
