/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.shift;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface WoffRegularizationDAO<T> extends GenericsDAO<T> {

    public List<?> userReportingManager(int id);

    public List<?> approvalLeval1WiseShiftRegularizationList(int id);
}
