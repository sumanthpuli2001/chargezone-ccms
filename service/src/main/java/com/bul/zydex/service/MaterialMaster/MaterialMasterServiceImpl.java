/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.MaterialMaster;

import com.bul.zydex.service.MaterialGroupMaster.*;
import com.bul.zydex.dao.MaterialGroupMaster.MaterialGroupMasterDao;
import com.bul.zydex.dao.MaterialMaster.MaterialMasterDao;
import com.bul.zydex.model.MaterialMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class MaterialMasterServiceImpl<T> extends GenericsServiceImpl<T> implements MaterialMasterService<T> {

    private MaterialMasterDao<T> materialMasterDao;

    public MaterialMasterDao<T> getMaterialMasterDao() {
        return materialMasterDao;
    }

    public void setMaterialMasterDao(MaterialMasterDao<T> materialMasterDao) {
        this.materialMasterDao = materialMasterDao;
        setGenericsDAO(materialMasterDao);
    }

    @Override
    public List searchMaterial(String material_group, String material_Type, String material_code, String material_desc) {
        return materialMasterDao.searchMaterial(material_group, material_Type, material_code, material_desc);
    }

    @Override
    public List readAll() {
        return materialMasterDao.readAll();
    }

    @Override
    public boolean isExist(T object) {
        return materialMasterDao.isExist(object);
    }

    @Override
    public List search1(String materialCode, String materialDescription, String group, String type) {
        return materialMasterDao.search1(materialCode, materialDescription, group, type);
    }

    @Override
    public List readByMaterialcode(String material_code) {
        return materialMasterDao.readByMaterialcode(material_code);
    }

    @Override
    public MaterialMaster read(String materialCode) {
        return materialMasterDao.read(materialCode);
    }

    @Override
    public List getMaterialPagination(int start, int length, String searchValue, String group, String type, String materialCode, String materialDescription, String orderColumn, String orderDir) {
        return materialMasterDao.getMaterialPagination(start, length, searchValue, group, type, materialCode, materialDescription, orderColumn, orderDir);
    }

    @Override
    public int getTotalMaterialCount() {
        return materialMasterDao.getTotalMaterialCount();
    }

    @Override
    public int getFilteredMaterialCount(String group, String type, String materialCode, String materialDescription, String searchValue) {
        return materialMasterDao.getFilteredMaterialCount(group, type, materialCode, materialDescription, searchValue);
    }
}
