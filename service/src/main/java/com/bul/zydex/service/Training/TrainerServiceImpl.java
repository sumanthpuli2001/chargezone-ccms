/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.service.Training;

import com.bul.zydex.dao.Training.TrainerDAO;
import com.bul.zydex.model.Trainer;
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

    @Override
    public List<?> readTrainerList() {
        return trainerDAO.readTrainerList();
    }

    @Override
    public List<?> read(T object) {
        Trainer user;
        Trainer user2 = (Trainer) object;
        return trainerDAO.read(object);
        

//        List<?> list = userMasterDAO.read();
//        Iterator i = list.iterator();
//        while (i.hasNext()) {
//            user = (UserMaster) i.next();
//            if (!(user.getUserName().toLowerCase()
//                    .equals(user2.getUserName().toLowerCase()) && user
//                    .getPassword().toLowerCase()
//                    .equals(user2.getPassword().toLowerCase()))) {
//                i.remove();
//            }
//        }
//        return list;
    }

    @Override
    public List<?> readByUserName(T object) {
         return trainerDAO.readByUserName(object);
    }

    @Override
    public List<?> readByUser(String username) {
        return trainerDAO.readByUser(username);
    }


   
}
