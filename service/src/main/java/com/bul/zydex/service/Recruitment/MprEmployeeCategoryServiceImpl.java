/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.Recruitment.MprEmployeeCategoryDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class MprEmployeeCategoryServiceImpl<T> extends GenericsServiceImpl<T> implements MprEmployeeCategoryService<T> {

    private MprEmployeeCategoryDAO<T> mprEmployeeCategoryDAO;

    public MprEmployeeCategoryDAO<T> getMprEmployeeCategoryDAO() {
        return mprEmployeeCategoryDAO;
    }

    public void setMprEmployeeCategoryDAO(MprEmployeeCategoryDAO<T> mprEmployeeCategoryDAO) {
        this.mprEmployeeCategoryDAO = mprEmployeeCategoryDAO;
        setGenericsDAO(mprEmployeeCategoryDAO);
    }

    @Override
    public List<?> getByName(String Ctname) {
        return mprEmployeeCategoryDAO.getByName(Ctname);
    }

}
