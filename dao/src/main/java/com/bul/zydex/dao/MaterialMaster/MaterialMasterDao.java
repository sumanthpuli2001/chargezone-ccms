/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.MaterialMaster;

import com.bul.zydex.dao.MaterialGroupMaster.*;
import com.bul.zydex.dao.Apprentices.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.ApprenticesMaster;
import com.bul.zydex.model.MaterialMaster;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface MaterialMasterDao<T> extends GenericsDAO<T> {

    public List searchMaterial(String material_group, String material_Type, String material_code, String material_desc);

    public List readAll();

    public boolean isExist(T object);

    public List search1(String materialCode, String materialDescription, String group, String type);

    public MaterialMaster read(String materialCode);

    public List readByMaterialcode(String material_code);

    public List getMaterialPagination(int start, int length, String searchValue, String group, String type, String materialCode, String materialDescription, String orderColumn, String orderDir);

    public int getTotalMaterialCount();

    public int getFilteredMaterialCount(String group, String type, String materialCode, String materialDescription, String searchValue);

}
