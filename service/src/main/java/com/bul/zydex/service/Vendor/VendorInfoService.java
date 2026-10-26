/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Vendor;

import com.bul.zydex.model.VendorInfo;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface VendorInfoService<T> extends GenericsService<T> {

    public List readData(String stno, String vatno, String panno);

    public VendorInfo readData1(String stno, String vatno, String panno);

    public List searchVendor(String fname, String sfirm, String rdate, String cinno, String address, String pinno, String cperson, String officeno, String resino, String mobno, String faxno, String email1, String email2, String salesno, String stno, String cstno, String vatno, String panno, String tenderno);
    
}
