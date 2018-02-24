/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.thought;

import com.bul.zydex.dao.thought.ThoughtMasterDAO;
import com.bul.zydex.model.ThoughtMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class ThoughtMasterServiceImpl<T> extends GenericsServiceImpl<T>
        implements ThoughtMasterService<T> {
    protected ThoughtMasterDAO<T> thoughtMasterDAO;

    public ThoughtMasterDAO<T> getThoughtMasterDAO() {
        return thoughtMasterDAO;
    }

    public void setThoughtMasterDAO(ThoughtMasterDAO<T> thoughtMasterDAO) {
        this.thoughtMasterDAO = thoughtMasterDAO;
        setGenericsDAO(thoughtMasterDAO);
    }

    @Override
    public List<?> readthoughtmasterDetail() {
        return thoughtMasterDAO.readthoughtmasterDetail();
    }

    @Override
    public ThoughtMaster readByCurrentDate(String date) {
         return thoughtMasterDAO.readByCurrentDate(date);
    }

}
