/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.KickOffFormApproval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.KickOffFormApproval;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface KickOffFormApprovalDao<T> extends GenericsDAO<T> {

    public List approvaList(String username);

    public List readids(String id);

    public KickOffFormApproval readBykickapprid(String id);

    public KickOffFormApproval readByDeltecodes(String id);

    public KickOffFormApproval readBykickid(int id1);

    public List getKomApprovalUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalKomApprovalUserCount(String username);

    public int getFilteredKomApprovalUserCount(String username, String searchValue);
    
}
