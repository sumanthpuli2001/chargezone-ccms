/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Invoice;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InvoiceAttachmentService <T> extends GenericsService<T>{

    public List readByPoId(String poId, String username);

    public List readByPoIdAndStatus(String id, String vendorCode, int status);

    public boolean readByRecycleStatus(int poId,int status1);

    public boolean readByGrnRecycleStatus(int id, int status1);

    public boolean readByFinancialRecycleStatus(int id, int status1);
    
}
