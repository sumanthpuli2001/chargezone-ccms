/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectType;

import com.bul.zydex.dao.ProjectType.ProjectTypeDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public class ProjectTypeServiceImpl<T> extends GenericsServiceImpl<T> implements ProjectTypeService<T> {

    private ProjectTypeDao<T> projectTypeDao;

    public ProjectTypeDao<T> getProjectTypeDao() {
        return projectTypeDao;
    }

    public void setProjectTypeDao(ProjectTypeDao<T> projectTypeDao) {
        this.projectTypeDao = projectTypeDao;
        setGenericsDAO(projectTypeDao);
    }

    @Override
    public List getProTypePagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return projectTypeDao.getProTypePagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalProTypeCount() {
        return projectTypeDao.getTotalProTypeCount();
    }

    @Override
    public int getFilteredProTypeCount(String search) {
        return projectTypeDao.getFilteredProTypeCount(search);
    }

}
