/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.CrcFormApprovalUser;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.CrcFormApprovalUser;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface CrcFormApprovalUserDao<T> extends GenericsDAO<T> {

    public CrcFormApprovalUser appvals(String username,String crcFormid);

    public List readByDleteCode(int formid);

    public List readByApprovalStatus(String id);

    public List readByApprovalStatuszero(int crcFormid);

    public List readyByCrcId(int crcid);
    
}
