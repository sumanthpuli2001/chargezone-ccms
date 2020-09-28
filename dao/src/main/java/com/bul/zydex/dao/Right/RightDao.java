/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Right;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.RightMaster;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface RightDao<T> extends GenericsDAO<T> {

    public RightMaster read(String rightName);

    public void deleteByRightName(String checkedValues);

    public List readByDrow();

    public List readByDrowDisable();
}
