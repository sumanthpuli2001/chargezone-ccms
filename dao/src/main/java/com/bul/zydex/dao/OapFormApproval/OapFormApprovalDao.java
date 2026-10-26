/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OapFormApproval;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.OapFormApproval;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface OapFormApprovalDao<T> extends GenericsDAO<T> {

    public List approvaList(String username);

    public List readByIds(String id);

    public List readByDeltecode(String id);

    public OapFormApproval readByDeltecodes(String id);

    public OapFormApproval readByoapappid(String id);

    public OapFormApproval readByIdAndUsername(String id, String userName);

    public List getOapApprovaListPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalOapApprovaListCount(String username);

    public int getFilteredOapApprovaListCount(String username, String searchValue);

}
