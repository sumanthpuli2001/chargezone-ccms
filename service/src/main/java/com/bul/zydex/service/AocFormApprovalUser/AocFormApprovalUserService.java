/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.AocFormApprovalUser;

import com.bul.zydex.model.AocFormApprovalUser;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface AocFormApprovalUserService<T> extends GenericsService<T> {

    public AocFormApprovalUser appval(String username);

    public AocFormApprovalUser readLevel(String level, int aocFormid);

    public List readByDleteCode(int formid);

    public List readByApprovalStatus(String id);

    public AocFormApprovalUser appvals(String username, String id);

    public List readByaocId(String id);

    public List readByaocId(int aocformid);

    public AocFormApprovalUser readByIdAndUsername(String id, String username);

    
}
