/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Approval;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface ApprovalUserDAO<T> extends GenericsDAO<T> {

    public List<?> readByApprovalId(int id);

    public List<?> readapprovalempId();
    
    public List<?> reademyId(int emid);
    
    public List<?> readByApprovalFetch(int apid);
}
