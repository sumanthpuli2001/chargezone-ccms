/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.CoffRegularizationDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Hussain
 */
public class CoffRegularizationServiceImpl<T> extends GenericsServiceImpl<T> implements CoffRegularizationService<T> {

    protected CoffRegularizationDAO<T> coffRegularizationDAO;

    public CoffRegularizationDAO<T> getCoffRegularizationDAO() {
        return coffRegularizationDAO;
    }

    public void setCoffRegularizationDAO(CoffRegularizationDAO<T> coffRegularizationDAO) {
        this.coffRegularizationDAO = coffRegularizationDAO;
        setGenericsDAO(coffRegularizationDAO);
    }

    @Override
    public List<?> userWiseCoffRegularizationList(int id) {
        return coffRegularizationDAO.userWiseCoffRegularizationList(id);
    }

    @Override
    public List<?> userReportingManager(int id) {
        return coffRegularizationDAO.userReportingManager(id);
    }

    @Override
    public List<?> approvalLeval1WiseCoffRegularizationList(int id) {
      return coffRegularizationDAO.approvalLeval1WiseCoffRegularizationList(id);
    }

}
