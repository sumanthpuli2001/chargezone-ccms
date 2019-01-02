/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Kaizen;

import com.bul.zydex.dao.Kaizen.KaizenMasterDAO;
import com.bul.zydex.model.KaizenMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman
 */
public class KaizenMasterServiceImpl<T> extends GenericsServiceImpl<T> implements KaizenMasterService<T> {

    private KaizenMasterDAO<T> kaizenMasterDAO;

    public KaizenMasterDAO<T> getKaizenMasterDAO() {
        return kaizenMasterDAO;
    }

    public void setKaizenMasterDAO(KaizenMasterDAO<T> kaizenMasterDAO) {
        this.kaizenMasterDAO = kaizenMasterDAO;
        setGenericsDAO(kaizenMasterDAO);
    }

    @Override
    public List<?> readKaizenMaster() {
        return kaizenMasterDAO.readKaizenMaster();
    }

    @Override
    public List<?> readKaizenMaster(Integer id) {
        return kaizenMasterDAO.readKaizenMaster(id);
    }

    @Override
    public List<?> readKaizenList() {
        return kaizenMasterDAO.readKaizenList();
    }

    @Override
    public List<?> readKaizenMasterapprovalList(Integer id) {
        return kaizenMasterDAO.readKaizenMasterapprovalList(id);
    }

    @Override
    public List<?> readKaizenMasterList(Integer id) {
        return kaizenMasterDAO.readKaizenMasterList(id);
    }

    @Override
    public List<?> readPastKaizenMaster() {
        return kaizenMasterDAO.readPastKaizenMaster();
    }

    @Override
    public List<?> readByDeptIdCompanyNameDesId(int deptid) {
        return kaizenMasterDAO.readByDeptIdCompanyNameDesId(deptid);
    }

}
