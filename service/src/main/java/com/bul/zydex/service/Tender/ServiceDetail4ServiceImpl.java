/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceDetail4Dao;
import com.bul.zydex.model.ServiceDetail4;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class ServiceDetail4ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceDetail4Service<T> {
  
    private ServiceDetail4Dao<T> serviceDetail4Dao;

    public ServiceDetail4Dao<T> getServiceDetail4Dao() {
        return serviceDetail4Dao;
    }

    public void setServiceDetail4Dao(ServiceDetail4Dao<T> serviceDetail4Dao) {
        this.serviceDetail4Dao = serviceDetail4Dao;
        setGenericsDAO(serviceDetail4Dao);
    }

    @Override
    public List readRefNo(String file_name, String ref_no) {
        return serviceDetail4Dao.readRefNo(file_name, ref_no);
    }

    @Override
    public void deleteFile(String ref_no, String file_name) {
        serviceDetail4Dao.deleteFile(ref_no, file_name);
    }

    @Override
    public void updateTenderNo(String refNo1, String refNo) {
        serviceDetail4Dao.updateTenderNo(refNo1,refNo);
    }

    @Override
    public List readTenderNo(String file_name, String refNo) {
        return serviceDetail4Dao.readTenderNo(file_name, refNo);
    }
}
