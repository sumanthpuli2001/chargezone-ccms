/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffAttendencesHistory;

import com.bul.zydex.dao.KickOffAttendencesHistory.KickOffAttendencesHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Admin
 */
public class KickOffAttendencesHistoryServiceImpl <T> extends GenericsServiceImpl<T> implements KickOffAttendencesHistoryService<T>{
    private KickOffAttendencesHistoryDao<T> kickOffAttendencesHistoryDao;

    public KickOffAttendencesHistoryDao<T> getKickOffAttendencesHistoryDao() {
        return kickOffAttendencesHistoryDao;
    }

    public void setKickOffAttendencesHistoryDao(KickOffAttendencesHistoryDao<T> kickOffAttendencesHistoryDao) {
        this.kickOffAttendencesHistoryDao = kickOffAttendencesHistoryDao;
        setGenericsDAO(kickOffAttendencesHistoryDao);
    }
}
