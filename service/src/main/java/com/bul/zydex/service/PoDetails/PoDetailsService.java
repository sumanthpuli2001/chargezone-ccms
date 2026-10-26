/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.PoDetails;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface PoDetailsService<T> extends GenericsService<T> {

    public List readByRefNo(String refNo);

    public List getPoDetailsPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username);

    public int getTotalPoDetailsCount(String username);

    public int getFilteredPoDetailsCount(String searchValue, String username);

    public List readByGrnExecutive(String username);

    public List readByfinancailExecutive(String username);

    
}
