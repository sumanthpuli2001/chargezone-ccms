/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.SiteSurvey;

import com.bul.zydex.dao.SiteSurvey.SiteSurveyDao;
import com.bul.zydex.model.SiteSurvey;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class SiteSurveyServiceImpl<T> extends GenericsServiceImpl<T> implements SiteSurveyService<T> {

    private SiteSurveyDao<T> siteSurveyDao;

    public SiteSurveyDao<T> getSiteSurveyDao() {
        return siteSurveyDao;
    }

    public void setSiteSurveyDao(SiteSurveyDao<T> siteSurveyDao) {
        this.siteSurveyDao = siteSurveyDao;
        setGenericsDAO(siteSurveyDao);

    }

    @Override
    public List readbyusername(String username) {
        return siteSurveyDao.readbyusername(username);
    }

    @Override
    public List readByVendor(String username1) {
        return siteSurveyDao.readByVendor(username1);

    }

    @Override
    public SiteSurvey readBySurveyNo(String id) {
        return siteSurveyDao.readBySurveyNo(id);
    }

    @Override
    public List readSiteSurveySearch(String siteSurveyNumber, String open_from_date, String open_to_date) {
        return siteSurveyDao.readSiteSurveySearch(siteSurveyNumber, open_from_date, open_to_date);

    }

    @Override
    public List getSitesurveyPagination(int start, int length, String searchValue, String username, String orderColumn, String orderDir) {

        return siteSurveyDao.getSitesurveyPagination(start, length, searchValue, username, orderColumn, orderDir);

    }

    @Override
    public int getTotalSitesurveyCount(String username) {
        return siteSurveyDao.getTotalSitesurveyCount(username);

    }

    @Override
    public int getFilteredSitesurveyCount(String username, String searchValue) {

        return siteSurveyDao.getFilteredSitesurveyCount(username, searchValue);

    }

    @Override
    public List getSiteSurveyReportPagination(int start, int length, String searchValue, String SiteSurveyNumber, String fromDate, String toDate, String orderColumn, String orderDir) {
        return siteSurveyDao.getSiteSurveyReportPagination(start, length, searchValue, SiteSurveyNumber, fromDate, toDate, orderColumn, orderDir);
    }

    @Override
    public int getTotalSiteSurveyReportCount() {
        return siteSurveyDao.getTotalSiteSurveyReportCount();
    }

    @Override
    public int getFilteredSiteSurveyReportCount(String searchValue, String SiteSurveyNumber, String fromDate, String toDate) {
        return siteSurveyDao.getFilteredSiteSurveyReportCount(searchValue, SiteSurveyNumber, fromDate, toDate);
    }

}
