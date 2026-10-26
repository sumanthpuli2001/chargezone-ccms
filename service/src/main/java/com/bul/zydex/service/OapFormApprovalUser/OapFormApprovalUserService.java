/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.OapFormApprovalUser;

import com.bul.zydex.model.OapFormApprovalUser;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface OapFormApprovalUserService<T> extends GenericsService<T> {

    public OapFormApprovalUser appval(String username);

    public OapFormApprovalUser readLevel(String level, int oapFormid);

    public List readByDleteCode(int formid);

    public List readByapprovalStatus(String id);

    public OapFormApprovalUser appvals(String username, String id);

    public List readByoapid(int oapid);

    public OapFormApprovalUser readByIdAndUsername(String id, String username);

    
}
