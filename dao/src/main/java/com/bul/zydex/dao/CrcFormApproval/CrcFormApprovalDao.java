/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CrcFormApproval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CrcFormApproval;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface CrcFormApprovalDao<T> extends GenericsDAO<T> {

    public List approvaList(String username);

    public List readids(String id);

    public CrcFormApproval readByDeltecodes(String id);

    public CrcFormApproval readBycrcid(String id);

    public CrcFormApproval readBycrcFormid(int crcFormid);

    public CrcFormApproval readBycrcids(int id1);

    public List getCrcApprovaListPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalCrcApprovaListCount(String username);

    public int getFilteredCrcApprovaListCount(String username, String searchValue);
    
}
