/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainerDAO;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Rishi
 */
public class TrainerServiceImpl<T> extends GenericsServiceImpl<T> implements TrainerService<T> {

    private TrainerDAO<T> trainerDAO;

    public TrainerDAO<T> trainerDAO() {
        return trainerDAO;
    }

    public void setTrainerDAO(TrainerDAO<T> trainerDAO) {
        this.trainerDAO = trainerDAO;
        setGenericsDAO(trainerDAO);
    }

   
}
