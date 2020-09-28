/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Log;

import com.bul.zydex.dao.log.LogDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author aman.bahukhandi
 */
public class LogServiceImpl<T> extends GenericsServiceImpl<T> implements LogService<T> {

    private LogDao<T> logDao;

    public LogDao<T> getLogDao() {
        return logDao;
    }

    public void setLogDao(LogDao<T> logDao) {
        this.logDao = logDao;
        setGenericsDAO(logDao);
    }

    @Override
    public List readLogs(String dFrom, String eFrom) {
        return logDao.readLogs(dFrom, eFrom);
    }

}
