/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorFinancialDetailsHistory;

import com.bul.zydex.model.VendorFinancialDetailsHistory;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface VendorFinancialDetailsHistoryService<T> extends GenericsService<T> {

    public VendorFinancialDetailsHistory readByVendorinfoId(int id);

    public List readByVendorFinancialDetailsHistory();

    public List readByVendorinfoIds(int id);

    public List readByVendorFinanHistoryinfoid(String vendorInfoid);

    public VendorFinancialDetailsHistory readyByReVisonR0(int id);

}
