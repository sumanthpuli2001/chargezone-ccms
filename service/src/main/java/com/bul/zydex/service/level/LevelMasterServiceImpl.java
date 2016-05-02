/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.level;

import com.bul.zydex.dao.level.LevelMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author admin
 */
public class LevelMasterServiceImpl<T> extends GenericsServiceImpl<T> implements LevelMasterService<T>{
    private LevelMasterDAO<T> levelMasterDAO;

    public LevelMasterDAO<T> getLevelMasterDAO() {
        return levelMasterDAO;
    }

    public void setLevelMasterDAO(LevelMasterDAO<T> levelMasterDAO) {
        this.levelMasterDAO = levelMasterDAO;
        setGenericsDAO(levelMasterDAO);
    }

    @Override
    public boolean isExist(T object) {
        return levelMasterDAO.isExist(object);
    }
    @Override
    public List<?> readByName(String name) {
        return levelMasterDAO.readByName(name);
    }
  
}
