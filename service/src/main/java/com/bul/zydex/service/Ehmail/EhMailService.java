/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Ehmail;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface EhMailService<T> extends GenericsService<T> {

    public List getEhMailPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalEhMailCount();

    public int getFilteredEhMailCount(String searchValue);
    
}
