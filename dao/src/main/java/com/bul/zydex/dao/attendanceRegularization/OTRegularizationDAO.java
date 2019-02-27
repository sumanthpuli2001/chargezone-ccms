/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.attendanceRegularization;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Success
 */
public interface OTRegularizationDAO<T> extends GenericsDAO<T> {

    public List<?> userWiseOTRegularizationList(int id);

    public List<?> userReportingManager(int id);

    public List<?> approvalLeval1WiseOtRegularizationList(int id);

    public List<?> readOTDateWise(String date, int id);

}
