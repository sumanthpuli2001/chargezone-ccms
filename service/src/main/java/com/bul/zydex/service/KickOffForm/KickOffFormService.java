/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.KickOffForm;

import com.bul.zydex.model.KickOffForm;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface KickOffFormService<T> extends GenericsService<T> {

    public List readbyApprove(String username);

    public KickOffForm readByaocId(String id);

    public KickOffForm readByaocIds(int aocformid);

    public List readDeliverableList(String username);

    public List readByFlagoneDashBoard();

    public List readByFlagThreeDashBoard();

    public List readByPendingKom();

    public List getusernamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalusernameCount(String username);

    public int getFilteredusernameCount(String username, String searchValue);

    public List getkomDeliverableViewPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalkomDeliverableViewCount(String username);

    public int getFilteredkomDeliverableViewCount(String username, String searchValue);

    public int countAllKom();

    public int countAllKomDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getTotalKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredTotalKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByFlagone();

    public int readByFlagoneDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getTotalApproveKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalApproveKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredTotalApproveKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByPendingKOM();

    public int readByPendingKOMDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getPendingKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getPendingKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredPendingKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByFlagThree();

    public int readByFlagThreeDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getRejectedKOMPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getRejectedKOMCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredRejectedKOMCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

}
