/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffFormHistory;

import com.bul.zydex.dao.KickoffFormHistory.KickoffFormHistoryDao;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Admin
 */
public class KickOffFormHistoryServiceImpl <T> extends GenericsServiceImpl<T> implements KickOffFormHistoryService<T>{
    private KickoffFormHistoryDao<T> kickoffFormHistoryDao;

    public KickoffFormHistoryDao<T> getKickoffFormHistoryDao() {
        return kickoffFormHistoryDao;
    }

    public void setKickoffFormHistoryDao(KickoffFormHistoryDao<T> kickoffFormHistoryDao) {
        this.kickoffFormHistoryDao = kickoffFormHistoryDao;
        setGenericsDAO(kickoffFormHistoryDao);
    }
}
