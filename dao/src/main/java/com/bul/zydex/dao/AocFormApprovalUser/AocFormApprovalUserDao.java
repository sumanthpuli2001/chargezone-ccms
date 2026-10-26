/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.AocFormApprovalUser;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.AocFormApprovalUser;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface AocFormApprovalUserDao<T> extends GenericsDAO<T> {

    public AocFormApprovalUser appval(String username);

    public AocFormApprovalUser readLevel(String level, int aocFormid);

    public List readByDleteCode(int formid);

    public List readByApprovalStatus(String id);

    public AocFormApprovalUser appvals(String username, String id);

    public List readByaocId(String id);

    public List readByaocId(int aocformid);

    public AocFormApprovalUser readByIdAndUsername(String id, String username);

    
}
