/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.appraisalPerformance;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author admin
 */
public interface AppraisalFillingDataDAO<T> extends GenericsDAO<T> {

    public boolean isExist(String year);

    public List<?> readByCurrentYear(String cyear);

    public List<?> getCurrentAndPreviousYear();

    public List<?> getappraisalDate();

    public List<?> readByIdNew(int Id);

    public List<?> readYearList();

    public List<?> readByYear(String Year);
}
