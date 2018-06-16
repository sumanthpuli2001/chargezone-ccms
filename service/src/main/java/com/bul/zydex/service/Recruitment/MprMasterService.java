/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.MprMaster;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface MprMasterService<T> extends GenericsDAO<T> {

    public List<?> readMprList();

    public List<?> readForMPRDetail();

    public List<?> readMprListByUserId(int empId);

    public List<?> Mppdelete(String mppId);

    public MprMaster readByMPRId(int mprId);

}
