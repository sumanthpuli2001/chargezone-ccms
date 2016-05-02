/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.overTime;

import com.bul.zydex.dao.overTime.OverTimeMasterDAO;
import com.bul.zydex.service.*;
import java.util.List;

/**
 *
 * @author Dhaval Patel
 */
public class OverTimeMasterServiceImpl<T> extends GenericsServiceImpl<T> implements OverTimeMasterService<T> {

    protected OverTimeMasterDAO<T> overTimeMasterDAO;

    public OverTimeMasterDAO<T> getOverTimeMasterDAO() {
        return overTimeMasterDAO;
    }

    public void setOverTimeMasterDAO(OverTimeMasterDAO<T> overTimeMasterDAO) {
        this.overTimeMasterDAO = overTimeMasterDAO;
        setGenericsDAO(overTimeMasterDAO);
    }

    @Override
    public List<?> overTimeComparision(int id,String overTimeDate) {
        return overTimeMasterDAO.overTimeComparision(id,overTimeDate);
    }

}
