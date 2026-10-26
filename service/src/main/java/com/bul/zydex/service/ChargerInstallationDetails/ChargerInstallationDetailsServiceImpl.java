/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ChargerInstallationDetails;

import com.bul.zydex.dao.ChargerInstallationDetails.ChargerInstallationDetailsDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ChargerInstallationDetailsServiceImpl<T> extends GenericsServiceImpl<T> implements ChargerInstallationDetailsService<T> {

    private ChargerInstallationDetailsDao<T> chargerInstallationDetailsDao;

    public ChargerInstallationDetailsDao<T> getChargerInstallationDetailsDao() {
        return chargerInstallationDetailsDao;
    }

    public void setChargerInstallationDetailsDao(ChargerInstallationDetailsDao<T> chargerInstallationDetailsDao) {
        this.chargerInstallationDetailsDao = chargerInstallationDetailsDao;
        setGenericsDAO(chargerInstallationDetailsDao);

    }

    @Override
    public List readByoapId(String id) {
        return chargerInstallationDetailsDao.readByoapId(id);

    }

}
