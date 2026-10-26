/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Approval;

import com.bul.zydex.dao.Employee.EmployeeMasterDao;
import com.bul.zydex.dao.Approval.ApprovalSettingDao;
import com.bul.zydex.model.EmployeeMaster;
import com.bul.zydex.model.ApprovalSetting;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;


public class ApprovalSettingServiceImpl<T> extends GenericsServiceImpl<T> implements ApprovalSettingService<T> 
{
    private ApprovalSettingDao<T> approvalSettingDao;

    public ApprovalSettingDao<T> getApprovalSettingDao() {
        return approvalSettingDao;
    }

    public void setApprovalSettingDao(ApprovalSettingDao<T> approvalSettingDao) {
        this.approvalSettingDao = approvalSettingDao;
        setGenericsDAO(approvalSettingDao);
    }
    
    
    @Override
    public List readByrow() {
        return approvalSettingDao.readByrow();
    }
    
    @Override
    public ApprovalSetting read(String Code) {
        return approvalSettingDao.read(Code);
    }

    @Override
    public List readOne(String rone) {
        return approvalSettingDao.readOne(rone);
    }
    
    @Override
    public void deleteByCode(String checkedValues) {
        approvalSettingDao.deleteByCode(checkedValues);
    }
    
    public ApprovalSetting readUserId(String user){
        return approvalSettingDao.readUserId(user);
    }

    @Override
    public List getApprovalPagination(int start, int length, String searchValue, String orderColumn, String orderDir) {
        return approvalSettingDao.getApprovalPagination(start, length, searchValue, orderColumn, orderDir);
    }

    @Override
    public int getApprovalCount() {
        return approvalSettingDao.getApprovalCount();
    }

    @Override
    public int getFilteredApprovalCount(String search) {
        return approvalSettingDao.getFilteredApprovalCount(search);
    }
}
