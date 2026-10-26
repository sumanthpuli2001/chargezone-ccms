/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ValuationClassMaster;

import com.bul.zydex.service.ProductTypeMaster.*;
import com.bul.zydex.dao.MaterialMaster.MaterialMasterDao;
import com.bul.zydex.dao.ProductTypeMaster.ProductTypeMasterDao;
import com.bul.zydex.dao.ValuationClassMaster.ValuationClassMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import com.bul.zydex.service.MaterialMaster.MaterialMasterService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class ValuationClassMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ValuationClassMasterService<T> {

    private ValuationClassMasterDao<T> valuationClassMasterDao;

    public ValuationClassMasterDao<T> getValuationClassMasterDao() {
        return valuationClassMasterDao;
    }

    public void setValuationClassMasterDao(ValuationClassMasterDao<T> valuationClassMasterDao) {
        this.valuationClassMasterDao = valuationClassMasterDao;
        setGenericsDAO(valuationClassMasterDao);

    }

    @Override
    public List getValPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return valuationClassMasterDao.getValPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getFilteredValCount(String search) {
        return valuationClassMasterDao.getFilteredValCount(search);
    }

    @Override
    public int getTotalValCount() {
        return valuationClassMasterDao.getTotalValCount();
    }

}
