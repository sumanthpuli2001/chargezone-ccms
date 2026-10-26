/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.log;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author aman.bahukhandi
 */
public interface LogDao<T> extends GenericsDAO<T> {

    public List readLogs(String dFrom, String eFrom);

    public List readLog(String user_name, String open_from_date, String open_to_date);

    public List getActivityLogsPagination(int start, int length, String searchValue, String userName, String fromDate, String toDate, String orderColumn, String orderDir);

    public int getActivityLogsCount(String userName);

    public int getFilteredActivityLogsCount(String searchValue, String userName, String fromDate, String toDate);

}
