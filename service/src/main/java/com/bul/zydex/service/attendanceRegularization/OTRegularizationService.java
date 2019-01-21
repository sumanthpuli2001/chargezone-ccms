/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.attendanceRegularization;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Success
 */
public interface OTRegularizationService<T> extends GenericsService<T> {

    public List<?> userWiseOTRegularizationList(int id);

    public List<?> userReportingManager(int id);

    public List<?> approvalLeval1WiseOtRegularizationList(int id);
}
