/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.OnCall;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author admin
 */
public interface OnCallDAO<T> extends GenericsDAO<T> {

    public List<?> userWiseOnCallList(int id);

    public List<?> userReportingManager(int id);

    public List<?> approvalmanagerWiseOnCallList(int id);

    public List<?> approvalmanagerWiseOnCallList(String startdate, Integer id);
    
}
