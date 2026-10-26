/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceDetail3Dao;
import com.bul.zydex.model.ServiceDetail3;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class ServiceDetail3ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceDetail3Service<T> {
 
    private ServiceDetail3Dao<T> serviceDetail3Dao;

    public ServiceDetail3Dao<T> getServiceDetail3Dao() {
        return serviceDetail3Dao;
    }

    public void setServiceDetail3Dao(ServiceDetail3Dao<T> serviceDetail3Dao) {
        this.serviceDetail3Dao = serviceDetail3Dao;
        setGenericsDAO(serviceDetail3Dao);
    }

    @Override
    public List readRefNo(String file_name, String ref_no) {
        return serviceDetail3Dao.readRefNo(file_name, ref_no);
    }

    @Override
    public void deleteFile(String ref_no, String file_name) {
        serviceDetail3Dao.deleteFile(ref_no, file_name);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        serviceDetail3Dao.updateTenderNo(refNo1,refNo);
    }

    @Override
    public List readTenderNo(String file_name, String refNo) {
        return serviceDetail3Dao.readTenderNo(file_name, refNo);
    }
}
