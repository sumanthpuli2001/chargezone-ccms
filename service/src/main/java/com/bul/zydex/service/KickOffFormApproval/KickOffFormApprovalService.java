/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffFormApproval;

import com.bul.zydex.model.KickOffFormApproval;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface KickOffFormApprovalService<T> extends GenericsService<T> {

    public List approvaList(String username);

    public List readids(String id);

    public KickOffFormApproval readBykickapprid(String id);

    public KickOffFormApproval readByDeltecodes(String id);

    public KickOffFormApproval readBykickid(int id1);

    public List getKomApprovalUserPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalKomApprovalUserCount(String username);

    public int getFilteredKomApprovalUserCount(String username, String searchValue);

}
