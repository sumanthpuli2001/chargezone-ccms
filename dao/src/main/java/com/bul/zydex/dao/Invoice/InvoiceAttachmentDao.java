/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Invoice;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InvoiceAttachmentDao <T> extends GenericsDAO<T>{

    public List readByPoId(String poId, String username);

    public List readByPoIdAndStatus(String id, String vendorCode, int status);

    public boolean readByRecycleStatus(int poId, int status1);

    public boolean readByGrnRecycleStatus(int poId, int status1);

    public boolean readByFinancialRecycleStatus(int poId, int status1);
    
}
