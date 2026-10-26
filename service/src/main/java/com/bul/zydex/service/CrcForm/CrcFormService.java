/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CrcForm;

import com.bul.zydex.model.CrcForm;
import com.bul.zydex.model.OapForm;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface CrcFormService<T> extends GenericsService<T> {

    public List readByusername(String username);

    public CrcForm readByoapId(String id);

    public List readByoapid(String id);

    public List ApprovalStatus();

    public CrcForm readByoapIds(int oapformid);

    public List readDeliverableList(String username);

    public List readByFlagTwoDashBoard();

    public List readByFlagThreeDashBoard();

    public List readByPendingCRC();

    public List readByrevisionCrcDashBorad();

    public CrcForm readByoapdDocumentNo(String oapDocumentNo);

    public List getusernamePagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalusernameCount(String username);

    public int getFilteredusernameCount(String username, String searchValue);

    public List getoapDeliverableViewPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotaloapDeliverableViewCount(String username);

    public int getFilteredoapDeliverableViewCount(String username, String searchValue);

    public int countAllCrc();

    public int countAllCrcDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getTotalCrcPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalCrcCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredTotalCrcCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByFlagFour();

    public int readByFlagFourDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getTotalApprovedCrcPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalApprovedCrcCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredTotalApprovedCrcCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readBypendingCrc();

    public int readBypendingCrcDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getPendingCRCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getPendingCRCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredPendingCRCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByrevisionCrc();

    public int readByrevisionCrcDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getRevisionCRCPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getTotalRevisionCRCCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilterdRevisionCRCCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByFlagTwo();

    public int readByFlagTwoDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getParticiallyPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getParticiallyCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredParticiallyCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int readByFlagThree();

    public int readByFlagThreeDateformate(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public List getRejectedPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getRejectedCount(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

    public int getFilteredRejectedCount(String searchValue, String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate);

}
