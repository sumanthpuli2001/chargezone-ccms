/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Kaizen;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.KaizenMaster;
import java.util.List;

/**
 *
 * @author Aman
 */
public interface KaizenMasterDAO<T>extends GenericsDAO<T>{

    public List<?> readKaizenMaster();

    public List<?> readKaizenMaster(Integer id);

    public List<?> readKaizenList();

    public List<?> readKaizenMasterapprovalList(Integer id);

    public List<?> readKaizenMasterList(Integer id);

    public List<?> readPastKaizenMaster();
    
}
