/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Tender;

import com.bul.zydex.dao.Tender.ServiceVendorTenderBidDao;
import com.bul.zydex.model.ServiceVendorTenderBid;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
/**
 *
 * @author admin
 */
public class ServiceVendorTenderBidServiceImpl<T> extends GenericsServiceImpl<T> implements ServiceVendorTenderBidService<T> {
   
    private ServiceVendorTenderBidDao<T> serviceVendorTenderBidDao;

    public ServiceVendorTenderBidDao<T> getServiceVendorTenderBidDao() {
        return serviceVendorTenderBidDao;
    }

    public void setServiceVendorTenderBidDao(ServiceVendorTenderBidDao<T> serviceVendorTenderBidDao) {
        this.serviceVendorTenderBidDao = serviceVendorTenderBidDao;
        setGenericsDAO(serviceVendorTenderBidDao);
    }

    @Override
    public List readVendorRefNo(String file_name, String username, String refNo) {
        return serviceVendorTenderBidDao.readVendorRefNo(file_name, username, refNo);
    }

    @Override
    public List readVendorRefNo1(String file_name, String username, String refNo) {
        return serviceVendorTenderBidDao.readVendorRefNo(file_name, username, refNo);
    }

    @Override
    public void updateVendorTenderBid(String refNo, String username, String file_name, String common_tax, String discount_val, String discount, String packing_val, String packing, String freight_val, String freight, String errection, String other_charges, String igst, String cgst, String sgst, String insurance_value, String total_amount, String grand_total) {
        serviceVendorTenderBidDao.updateVendorTenderBid(refNo, username, file_name, common_tax, discount_val, discount, packing_val, packing, freight_val, freight, errection, other_charges, igst, cgst, sgst, insurance_value, total_amount, grand_total);
    }

    @Override
    public List readVendorRefNo2(String username, String refNo) {
        return serviceVendorTenderBidDao.readVendorRefNo2(username, refNo);
    }
}
