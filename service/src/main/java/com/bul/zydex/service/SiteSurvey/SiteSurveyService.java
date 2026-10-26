/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.SiteSurvey;

import com.bul.zydex.model.SiteSurvey;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface SiteSurveyService<T> extends GenericsService<T> {

    public List readbyusername(String username);

    public List readByVendor(String username1);

    public SiteSurvey readBySurveyNo(String id);

    public List readSiteSurveySearch(String siteSurveyNumber, String open_from_date, String open_to_date);

    public List getSitesurveyPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir);

    public int getTotalSitesurveyCount(String username);

    public int getFilteredSitesurveyCount(String username, String searchValue);

    public List getSiteSurveyReportPagination(int start, int length, String searchValue, String SiteSurveyNumber, String fromDate, String toDate, String orderColumn, String orderDir);

    public int getTotalSiteSurveyReportCount();

    public int getFilteredSiteSurveyReportCount(String searchValue, String SiteSurveyNumber, String fromDate, String toDate);
    

    
    
    
}



