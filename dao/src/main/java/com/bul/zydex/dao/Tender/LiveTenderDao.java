/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Tender;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.LiveTender;
import java.util.List;
/**
 *
 * @author admin
 */
public interface LiveTenderDao<T> extends GenericsDAO<T> {

    public List readByTender(String tenderno);

    public List readBySerch(String tender_no, String description);

    public void updateTender(String tenderno, String description, String technicalfile);
    
}
