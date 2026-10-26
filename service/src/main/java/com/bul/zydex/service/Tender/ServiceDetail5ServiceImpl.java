/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceDetail5Dao;
import com.bul.zydex.model.ServiceDetail5;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class ServiceDetail5ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceDetail5Service<T> {

    private ServiceDetail5Dao<T> serviceDetail5Dao;

    public ServiceDetail5Dao<T> getServiceDetail5Dao() {
        return serviceDetail5Dao;
    }

    public void setServiceDetail5Dao(ServiceDetail5Dao<T> serviceDetail5Dao) {
        this.serviceDetail5Dao = serviceDetail5Dao;
        setGenericsDAO(serviceDetail5Dao);
    }

    @Override
    public List readRefNo(String file_name, String ref_no) {
        return serviceDetail5Dao.readRefNo(file_name, ref_no);
    }

    @Override
    public void deleteFile(String ref_no, String file_name) {
        serviceDetail5Dao.deleteFile(ref_no, file_name);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        serviceDetail5Dao.updateTenderNo(refNo1,refNo);
    }

    @Override
    public List readTenderNo(String file_name, String refNo) {
        return serviceDetail5Dao.readTenderNo(file_name, refNo);
    }
}
