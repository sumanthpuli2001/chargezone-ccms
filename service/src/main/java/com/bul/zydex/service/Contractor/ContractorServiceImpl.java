/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Contractor;

import com.bul.zydex.dao.Contractor.ContractorDao;
import com.bul.zydex.model.ContractorMaster;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class ContractorServiceImpl<T> extends GenericsServiceImpl<T> implements ContractorService<T> {

    private ContractorDao<T> contractorDao;

    public ContractorDao<T> getContractorDao() {
        return contractorDao;
    }

    public void setContractorDao(ContractorDao<T> contractorDao) {
        this.contractorDao = contractorDao;
        setGenericsDAO(contractorDao);
    }

    @Override
    public Boolean readByContractorCode(String contractorCode) {
        return contractorDao.readByContractorCode(contractorCode);
    }

    @Override
    public ContractorMaster read(String ccCode) {
        return contractorDao.read(ccCode);
    }

    @Override
    public void deleteByContractorCode(String checkedValues) {
        contractorDao.deleteByContractorCode(checkedValues);
    }

    @Override
    public List readShift(String code) {
        return contractorDao.readShift(code);
    }

    @Override
    public ContractorMaster readByRfIdValue(String empCode) {
        return contractorDao.readByRfIdValue(empCode);
    }

    @Override
    public List readContractor() {
        return contractorDao.readContractor();
    }

    @Override
    public List readContractorLast60Days() {
        return contractorDao.readContractorLast60Days();
    }

    @Override
    public List readByDrow() {
        return contractorDao.readByDrow();
    }

    @Override
    public List readByDrowDisable() {
        return contractorDao.readByDrowDisable();
    }

    @Override
    public List readByRfId(String rfId) {
        return contractorDao.readByRfId(rfId);
    }

}
