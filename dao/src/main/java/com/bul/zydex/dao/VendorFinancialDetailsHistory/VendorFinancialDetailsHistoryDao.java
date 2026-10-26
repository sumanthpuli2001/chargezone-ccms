/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.VendorFinancialDetailsHistory;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.VendorFinancialDetailsHistory;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface VendorFinancialDetailsHistoryDao<T> extends GenericsDAO<T> {

    public VendorFinancialDetailsHistory readByVendorinfoId(int id);

    public List readByVendorFinancialDetailsHistory();

    public List readByVendorinfoIds(int id);

    public List readByVendorFinanHistoryinfoid(String vendorInfoid);

    public VendorFinancialDetailsHistory VendorFinancialDetailsHistory(int id);
    
}
