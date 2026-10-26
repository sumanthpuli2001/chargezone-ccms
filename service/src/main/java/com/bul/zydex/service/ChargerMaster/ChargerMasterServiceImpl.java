/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ChargerMaster;

import com.bul.zydex.dao.ChargerMaster.ChargerMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import static com.lowagie.text.pdf.PdfName.T;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ChargerMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ChargerMasterService<T> {

    private ChargerMasterDao<T> chargerMasterDao;

    public ChargerMasterDao<T> getChargerMasterDao() {
        return chargerMasterDao;
    }

    public void setChargerMasterDao(ChargerMasterDao<T> chargerMasterDao) {
        this.chargerMasterDao = chargerMasterDao;
        setGenericsDAO(chargerMasterDao);
    }

    @Override
    public List getChargerMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {

        return chargerMasterDao.getChargerMasterPagination(start, length, searchValue, orderColumn, orderDir);

    }

    @Override
    public int getTotalChargerMasterCount() {
        return chargerMasterDao.getTotalChargerMasterCount();

    }

    @Override
    public int getFilteredChargerMasterCount(String searchValue) {

        return chargerMasterDao.getFilteredChargerMasterCount(searchValue);

    }
}
