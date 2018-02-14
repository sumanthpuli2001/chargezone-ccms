/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.Recruitment.MprEmployeeTypeMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Vikas
 */
public class MprEmployeeTypeMasterServiceImpl<T> extends GenericsServiceImpl<T> implements MprEmployeeTypeMasterService<T> {

    private MprEmployeeTypeMasterDAO<T> mprEmployeeTypeMasterDAO;

    public MprEmployeeTypeMasterDAO<T> getMprEmployeeTypeMasterDAO() {
        return mprEmployeeTypeMasterDAO;
    }

    public void setMprEmployeeTypeMasterDAO(MprEmployeeTypeMasterDAO<T> mprEmployeeTypeMasterDAO) {
        this.mprEmployeeTypeMasterDAO = mprEmployeeTypeMasterDAO;
        setGenericsDAO(mprEmployeeTypeMasterDAO);
    }

}
