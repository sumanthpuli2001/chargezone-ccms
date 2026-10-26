/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DeliverableMulti;

import com.bul.zydex.model.DeliverableMulti;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface DeliverableMultiService <T> extends GenericsService<T>{

    public List readByDeliveryId(String id);

    public List readBydesignCoordinator(String username);

    public List readByDesignAssign(String username);

    public List readByAocId(String aocid);

    public List readByOapid(String oapid);

    public List readByDeliveryId(int deliverableid);

    public List readByoapid(int oapformid);

    public List readByaocId(int aocformid);

    public List readByoapidflag(int oapformid);

    public int countAllDesignCoorOap();

    public int readByFlagOneOap();

    public int countAllDesignCoorAoc();

    public int readByFlagOneAoc();

    public int countAllDesignCoorOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByFlagOneOapDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int countAllDesignCoorAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByFlagOneAocDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List readByOapIdAndZeroFlag(int oapformid);

    public List readByAocIdAndZeroFlag(int aocFormid);

    public List getDesignCoordinatorPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalDesignCoordinatorCount(String username);

    public int getFilteredDesignCoordinatorCount(String username, String searchValue);

    public List getDesignAssignPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalDesignAssignCount(String username);

    public int getFilteredDesignAssignCount(String username, String searchValue);

   
    
}
