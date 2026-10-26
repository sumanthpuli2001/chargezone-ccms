/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ChargerInstallationDetailsHistory;

import com.bul.zydex.dao.ChargerInstallationDetailsHistory.ChargerInstallationDetailsHistoryDao;
import com.bul.zydex.model.ChargerInstallationDetailsHistory;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ChargerInstallationDetailsHistoryServiceImpl<T> extends GenericsServiceImpl<T> implements ChargerInstallationDetailsHistoryService<T> {

    private ChargerInstallationDetailsHistoryDao<T> chargerInstallationDetailsHistoryDao;

    public ChargerInstallationDetailsHistoryDao<T> getChargerInstallationDetailsHistoryDao() {
        return chargerInstallationDetailsHistoryDao;
    }

    public void setChargerInstallationDetailsHistoryDao(ChargerInstallationDetailsHistoryDao<T> chargerInstallationDetailsHistoryDao) {
        this.chargerInstallationDetailsHistoryDao = chargerInstallationDetailsHistoryDao;
        setGenericsDAO(chargerInstallationDetailsHistoryDao);
    }

    @Override
    public List readByoapId(int oapid) {

    return chargerInstallationDetailsHistoryDao.readByoapId(oapid);
    
    }
    
    
    

}
