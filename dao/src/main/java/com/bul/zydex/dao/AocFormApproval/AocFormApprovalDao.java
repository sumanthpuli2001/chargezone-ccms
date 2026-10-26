/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormApproval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AocFormApproval;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface AocFormApprovalDao<T> extends GenericsDAO<T> {

    public List approvaList(String username);

    public List readByIds(String id);

    public AocFormApproval readByDeltecodes(String id);

    public List getAocApprovalPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalAocApprovalCount(String username);

    public int getFilteredAocApprovalCount(String username, String searchValue);
    
}
