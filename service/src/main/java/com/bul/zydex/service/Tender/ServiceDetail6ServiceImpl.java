/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceDetail6Dao;
import com.bul.zydex.model.ServiceDetail6;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class ServiceDetail6ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceDetail6Service<T> {

    private ServiceDetail6Dao<T> serviceDetail6Dao;

    public ServiceDetail6Dao<T> getServiceDetail6Dao() {
        return serviceDetail6Dao;
    }

    public void setServiceDetail6Dao(ServiceDetail6Dao<T> serviceDetail6Dao) {
        this.serviceDetail6Dao = serviceDetail6Dao;
        setGenericsDAO(serviceDetail6Dao);
    }

    @Override
    public List readRefNo(String file_name, String ref_no) {
        return serviceDetail6Dao.readRefNo(file_name, ref_no);
    }

    @Override
    public void deleteFile(String ref_no, String file_name) {
        serviceDetail6Dao.deleteFile(ref_no, file_name);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        serviceDetail6Dao.updateTenderNo(refNo1,refNo);
    }

    @Override
    public List readTenderNo(String file_name, String refNo) {
        return serviceDetail6Dao.readTenderNo(file_name, refNo);
    }
}
