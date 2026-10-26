/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.BpGroup;

import com.bul.zydex.model.BpGroup;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface BpGroupService<T> extends GenericsService<T> {

    public BpGroup readByBpCode(String extractedBpGroup);

    public List getbpGroupPagination(int start, int length, String search, String orderColumn, String orderDir);

    public int getTotalbpGroupCount();

    public int getFilteredbpGroupCount(String searchValue);

}
