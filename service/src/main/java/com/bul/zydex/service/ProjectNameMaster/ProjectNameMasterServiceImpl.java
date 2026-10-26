/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectNameMaster;

import com.bul.zydex.dao.ProjectNameMaster.ProjectNameMasterDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProjectNameMasterServiceImpl<T> extends GenericsServiceImpl<T> implements ProjectNameMasterService<T> {

    private ProjectNameMasterDao<T> projectNameMasterDao;

    public ProjectNameMasterDao<T> getProjectNameMasterDao() {
        return projectNameMasterDao;
    }

    public void setProjectNameMasterDao(ProjectNameMasterDao<T> projectNameMasterDao) {
        this.projectNameMasterDao = projectNameMasterDao;
        setGenericsDAO(projectNameMasterDao);
    }

    @Override
    public boolean isExist(T object) {
        return projectNameMasterDao.isExist(object);
    }

    @Override
    public List getProjectNameMasterPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return projectNameMasterDao.getProjectNameMasterPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getProjectNameMasterCount() {
        return projectNameMasterDao.getProjectNameMasterCount();
    }

    @Override
    public int getFilteredProjectNameMasterCount(String searchValue) {
        return projectNameMasterDao.getFilteredProjectNameMasterCount(searchValue);
    }

}
