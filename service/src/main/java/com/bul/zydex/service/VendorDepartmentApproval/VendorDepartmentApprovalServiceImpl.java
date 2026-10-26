/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.VendorDepartmentApproval;

import com.bul.zydex.dao.SqlDataConnect.SqlDataConnectDao;
import com.bul.zydex.dao.VendorDepartmentApproval.VendorDepartmentApprovalDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author bulwarks-2
 */
public class VendorDepartmentApprovalServiceImpl<T> extends GenericsServiceImpl<T> implements VendorDepartmentApprovalService<T> {

    private VendorDepartmentApprovalDao<T> vendorDepartmentApprovalDao;

    public VendorDepartmentApprovalDao<T> getVendorDepartmentApprovalDao() {
        return vendorDepartmentApprovalDao;
    }

    public void setVendorDepartmentApprovalDao(VendorDepartmentApprovalDao<T> vendorDepartmentApprovalDao) {
        this.vendorDepartmentApprovalDao = vendorDepartmentApprovalDao;
        setGenericsDAO(vendorDepartmentApprovalDao);
    }

    @Override
    public List readByAll() {
        return vendorDepartmentApprovalDao.readByAll();
    }

    @Override
    public List readFinancialApproval() {
        return vendorDepartmentApprovalDao.readFinancialApproval();
    }

    @Override
    public List readTehnicalApproval() {
        return vendorDepartmentApprovalDao.readTehnicalApproval();
    }

    @Override
    public List readHrApproval() {
        return vendorDepartmentApprovalDao.readHrApproval();
    }

    @Override
    public List readSafetyApproval() {
        return vendorDepartmentApprovalDao.readSafetyApproval();
    }

    @Override
    public List readITApproval() {
        return vendorDepartmentApprovalDao.readITApproval();
    }

    @Override
    public List getVenDeptPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return vendorDepartmentApprovalDao.getVenDeptPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getTotalVenDeptCount() {
        return vendorDepartmentApprovalDao.getTotalVenDeptCount();
    }

    @Override
    public int getFilteredVenDeptCount(String search) {
        return vendorDepartmentApprovalDao.getFilteredVenDeptCount(search);
    }

}
