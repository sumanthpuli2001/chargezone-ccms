package com.bul.zydex.service.policy;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dhruv
 */
public interface PolicyMasterService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public List<?> readBySalaryTypeID(String salaryTpe);

    public List<?> readPolicyName();
}
