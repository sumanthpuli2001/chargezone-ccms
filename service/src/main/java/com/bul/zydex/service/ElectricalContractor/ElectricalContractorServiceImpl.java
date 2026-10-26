/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ElectricalContractor;

import com.bul.zydex.dao.ElectricalContractor.ElectricalContractorDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ElectricalContractorServiceImpl<T> extends GenericsServiceImpl<T> implements ElectricalContractorService<T> {

    private ElectricalContractorDao<T> electricalContractorDao;

    public ElectricalContractorDao<T> getElectricalContractorDao() {
        return electricalContractorDao;
    }

    public void setElectricalContractorDao(ElectricalContractorDao<T> electricalContractorDao) {
        this.electricalContractorDao = electricalContractorDao;
        setGenericsDAO(electricalContractorDao);
    }

    @Override
    public List readByVendorInformationId(String vendorInformationid) {
        return electricalContractorDao.readByVendorInformationId(vendorInformationid);

    }

    @Override
    public void deleteByVendorInformationId(String VInformationId) {
        electricalContractorDao.deleteByVendorInformationId(VInformationId);
    }

}
