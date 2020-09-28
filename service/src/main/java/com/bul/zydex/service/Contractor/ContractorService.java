/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Contractor;

import com.bul.zydex.model.ContractorMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface ContractorService<T> extends GenericsService<T>{

    public Boolean readByContractorCode(String contractorCode);

    public ContractorMaster read(String ccCode);

    public void deleteByContractorCode(String checkedValues);

    public List readShift(String code);

    public ContractorMaster readByRfIdValue(String empCode);

    public List readContractor();

    public List readContractorLast60Days();

    public List readByDrow();

    public List readByDrowDisable();

    public List readByRfId(String rfId);
    
}
