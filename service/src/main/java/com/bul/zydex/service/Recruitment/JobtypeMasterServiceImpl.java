/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Recruitment;

import com.bul.zydex.dao.Recruitment.JobtypeMasterDAO;
import com.bul.zydex.service.GenericsServiceImpl;

/**
 *
 * @author Vikas
 */
public class JobtypeMasterServiceImpl<T> extends GenericsServiceImpl<T> implements JobtypeMasterService<T>{
    
    private JobtypeMasterDAO<T> jobtypeMasterDAO;
    

    public JobtypeMasterDAO<T> getJobtypeMasterDAO() {
        return jobtypeMasterDAO;
    }

    public void setJobtypeMasterDAO(JobtypeMasterDAO<T> jobtypeMasterDAO) {
        this.jobtypeMasterDAO = jobtypeMasterDAO;
        setGenericsDAO(jobtypeMasterDAO);
    }
    
}
