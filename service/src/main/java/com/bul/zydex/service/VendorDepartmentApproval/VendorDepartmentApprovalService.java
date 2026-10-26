/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorDepartmentApproval;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public interface VendorDepartmentApprovalService<T> extends GenericsService<T> {

    public List readByAll();

    public List readFinancialApproval();

    public List readTehnicalApproval();

    public List readHrApproval();

    public List readSafetyApproval();

    public List readITApproval();

    public List getVenDeptPagination(int start, int length, String searchValue, String orderColumn, String orderDir);

    public int getTotalVenDeptCount();

    public int getFilteredVenDeptCount(String searchValue);

}
