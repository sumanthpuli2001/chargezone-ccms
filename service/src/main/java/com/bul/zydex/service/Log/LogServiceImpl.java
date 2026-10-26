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

    @Override
    public List readLog(String user_name, String open_from_date, String open_to_date) {
        return logDao.readLog(user_name, open_from_date, open_to_date);
    }

    @Override
    public List getActivityLogsPagination(int start, int length, String searchValue, String userName, String fromDate, String toDate, String orderColumn, String orderDir) {
        return logDao.getActivityLogsPagination(start, length, searchValue, userName, fromDate, toDate, orderColumn, orderDir);
    }

    @Override
    public int getActivityLogsCount(String userName) {
        return logDao.getActivityLogsCount(userName);
    }

    @Override
    public int getFilteredActivityLogsCount(String searchValue, String userName, String fromDate, String toDate) {
        return logDao.getFilteredActivityLogsCount(searchValue, userName, fromDate, toDate);
    }

}
