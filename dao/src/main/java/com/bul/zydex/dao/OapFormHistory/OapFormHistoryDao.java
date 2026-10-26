/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapFormHistory;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface OapFormHistoryDao<T> extends GenericsDAO<T> {

    public List readBylasttimestatus(int id1);

    public List readByoapid(String id);

    public List readBydocumentno(String documentNo);
    
}
