/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.Recruitment.MprMasterDAO;
import com.bul.zydex.model.MprMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class MprMasterServiceImpl<T> extends GenericsServiceImpl<T> implements MprMasterService<T> {

    private MprMasterDAO<T> mprMasterDAO;

    public MprMasterDAO<T> getMprMasterDAO() {
        return mprMasterDAO;
    }

    public void setMprMasterDAO(MprMasterDAO<T> mprMasterDAO) {
        this.mprMasterDAO = mprMasterDAO;
        setGenericsDAO(mprMasterDAO);
    }

    @Override
    public List<?> readMprList() {
        return mprMasterDAO.readMprList();
    }

    @Override
    public List<?> readForMPRDetail() {
        return mprMasterDAO.readForMPRDetail();
    }

    @Override
    public List<?> readMprListByUserId(int empId) {
        return mprMasterDAO.readMprListByUserId(empId);
    }

    @Override
    public List<?> Mppdelete(String mppId) {
         return mprMasterDAO.Mppdelete(mppId);
    }

    @Override
    public MprMaster readByMPRId(int mprId) {
        return mprMasterDAO.readByMPRId(mprId);
    }

}
