/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.MaterialGroupMaster;

import com.bul.zydex.dao.MaterialGroupMaster.MaterialGroupMasterDao;
import com.bul.zydex.model.MaterialGroupMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class MaterialGroupMasterServiceImpl<T> extends GenericsServiceImpl<T> implements MaterialGroupMasterService<T> {

    private MaterialGroupMasterDao<T> materialGroupMasterDao;

    public MaterialGroupMasterDao<T> getMaterialGroupMasterDao() {
        return materialGroupMasterDao;
    }

    public void setMaterialGroupMasterDao(MaterialGroupMasterDao<T> materialGroupMasterDao) {
        this.materialGroupMasterDao = materialGroupMasterDao;
        setGenericsDAO(materialGroupMasterDao);
    }

    @Override
    public MaterialGroupMaster readBymaterialgroup(String material_group_id) {
        return materialGroupMasterDao.readBymaterialgroup(material_group_id);
    }

    @Override
    public int getTotalmaterialGroupMasterCount() {
        return materialGroupMasterDao.getTotalmaterialGroupMasterCount();
    }

    @Override
    public int getFilteredmaterialGroupMasterCount(String search) {
        return materialGroupMasterDao.getFilteredmaterialGroupMasterCount(search);
    }

    @Override
    public List getmaterialGroupMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return materialGroupMasterDao.getmaterialGroupMasterPagination(start, length, searchValue, orderColumn, orderDir);
    }

}
