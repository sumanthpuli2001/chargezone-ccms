/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ProjectProfile;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProjectProfileService<T> extends  GenericsService<T> {

    public List getprojectProfilePagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalprojectProfileCount();

    public int getFilteredprojectProfileCount(String searchValue);
    
}
