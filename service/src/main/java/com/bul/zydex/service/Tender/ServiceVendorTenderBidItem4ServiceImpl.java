/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceVendorTenderBidItem4Dao;
import com.bul.zydex.model.ServiceVendorTenderBidItem4;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidItem4ServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceVendorTenderBidItem4Service<T> {
    
    private ServiceVendorTenderBidItem4Dao<T> serviceVendorTenderBidItem4Dao;

    public ServiceVendorTenderBidItem4Dao<T> getServiceVendorTenderBidItem4Dao() {
        return serviceVendorTenderBidItem4Dao;
    }

    public void setServiceVendorTenderBidItem4Dao(ServiceVendorTenderBidItem4Dao<T> serviceVendorTenderBidItem4Dao) {
        this.serviceVendorTenderBidItem4Dao = serviceVendorTenderBidItem4Dao;
        setGenericsDAO(serviceVendorTenderBidItem4Dao);
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        return serviceVendorTenderBidItem4Dao.readVendorRefNo(file_name, username, refNo);
    }

    @Override
    public List readItemVendorRefNo(String refNo, String username, String file_name, String security_name) {
        return serviceVendorTenderBidItem4Dao.readItemVendorRefNo(refNo, username, file_name, security_name);
    }

    @Override
    public void updateItemVendorRefNo(String refNo, String username, String file_name, String security_name, String security, String wage, String per, String total, String allowance, String allowance_total, String uniform, String service, String total_per_day, String total_per_month, String total_per_year, String per_day, String per_month, String per_year, String total_per_day_pp, String total_per_day_per_pp) {
        serviceVendorTenderBidItem4Dao.updateItemVendorRefNo(refNo, username, file_name, security_name, security, wage, per, total, allowance, allowance_total, uniform, service, total_per_day, total_per_month, total_per_year, per_day, per_month, per_year, total_per_day_pp, total_per_day_per_pp);
    }
}
