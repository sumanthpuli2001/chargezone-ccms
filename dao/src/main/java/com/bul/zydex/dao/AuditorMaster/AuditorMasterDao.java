/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AuditorMaster;

import com.bul.zydex.dao.BpGroup.*;
import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AuditorMaster;
import com.bul.zydex.model.BpGroup;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface AuditorMasterDao <T> extends GenericsDAO<T>{

    public List readByCategoryHigh();

    public List readByCategoryMedium();

    public AuditorMaster readByAuditorCode(String auditor);

    public List getAuditorPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalAuditorCount();

    public int getFilteredAuditorCount(String search);

    
}
