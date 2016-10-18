/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Position;

import com.bul.zydex.dao.Position.PositionReferMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Dhaval
 */
public class PositionReferMasterServiceImpl<T> extends GenericsServiceImpl<T> implements PositionReferMasterService<T> {

    private PositionReferMasterDAO<T> positionReferMasterDAO;

    public PositionReferMasterDAO<T> getPositionReferMasterDAO() {
        return positionReferMasterDAO;
    }

    public void setPositionReferMasterDAO(PositionReferMasterDAO<T> positionReferMasterDAO) {
        this.positionReferMasterDAO = positionReferMasterDAO;
        setGenericsDAO(positionReferMasterDAO);
    }

    @Override
    public boolean isExist(T object) {
     return positionReferMasterDAO.isExist(object);   
    }
    
    @Override
    public List<?> readPositionData(){
     return positionReferMasterDAO.readPositionData();   
    }

}
