/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceDetail1Dao;
import com.bul.zydex.model.ServiceDetail1;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class ServiceDetail1ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceDetail1Service<T> {
    
    private ServiceDetail1Dao<T> serviceDetail1Dao;

    public ServiceDetail1Dao<T> getServiceDetail1Dao() {
        return serviceDetail1Dao;
    }

    public void setServiceDetail1Dao(ServiceDetail1Dao<T> serviceDetail1Dao) {
        this.serviceDetail1Dao = serviceDetail1Dao;
        setGenericsDAO(serviceDetail1Dao);
    }

    @Override
    public List readRefNo(String file_name, String ref_no) {
        return serviceDetail1Dao.readRefNo(file_name, ref_no);
    }

    @Override
    public void deleteFile(String ref_no, String file_name) {
        serviceDetail1Dao.deleteFile(ref_no, file_name);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        serviceDetail1Dao.updateTenderNo(refNo1,refNo);
    }

    @Override
    public List readTenderNo(String file_name, String refNo) {
        return serviceDetail1Dao.readTenderNo(file_name, refNo);
    }
}
