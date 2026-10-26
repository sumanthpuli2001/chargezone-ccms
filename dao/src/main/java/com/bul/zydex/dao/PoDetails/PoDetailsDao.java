/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PoDetails;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface PoDetailsDao<T> extends GenericsDAO<T> {

    public List readByRefNo(String refNo);

    public List getPoDetailsPagination(int start, int length, String searchValue, String orderColumn, String orderDir, String username);

    public int getTotalPoDetailsCount(String username);

    public int getFilteredPoDetailsCount(String searchValue, String username);

    public List readByGrnExecutive(String username);

    public List readByfinancailExecutive(String username);

    
}
