/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectProfile;

import com.bul.zydex.dao.ProjectProfile.ProjectProfileDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;
import static jdk.nashorn.internal.objects.NativeString.search;

/**
 *
 * @author Admin
 */
public class ProjectProfileServiceServiceImpl<T> extends GenericsServiceImpl<T> implements ProjectProfileService<T> {

    private ProjectProfileDao<T> projectProfileDao;

    public ProjectProfileDao<T> getProjectProfileDao() {
        return projectProfileDao;
    }

    public void setProjectProfileDao(ProjectProfileDao<T> projectProfileDao) {
        this.projectProfileDao = projectProfileDao;
        setGenericsDAO(projectProfileDao);
    }

    @Override
    public List getprojectProfilePagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return projectProfileDao.getprojectProfilePagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalprojectProfileCount() {
        return projectProfileDao.getTotalprojectProfileCount();
    }

    @Override
    public int getFilteredprojectProfileCount(String search) {
        return projectProfileDao.getFilteredprojectProfileCount(search);
    }

}
