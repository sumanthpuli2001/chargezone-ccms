/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffFormApprovalUser;

import com.bul.zydex.model.KickOffFormApprovalUser;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface KickOffFormApprovalUserService<T> extends GenericsService<T> {

    public KickOffFormApprovalUser appval(String username);

    public List readByDleteCode(int formid);

    public List readByApprovestatus(String id);

    public List readBykomid(int komid);

    public KickOffFormApprovalUser appvals(String username, int kickOffFormid);

    
}
