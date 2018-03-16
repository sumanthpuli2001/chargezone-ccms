/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Training;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.Trainer;
import java.util.List;

/**
 *
 * @author Dell-1
 */
public interface TrainerDAO<T> extends GenericsDAO<T> {

    public List<?> readTrainerList();

    public List<?> read(T object);

    public List<?> readByUserName(T object);

    public List<?> readByUser(String username);

    public List<?> ListeventDates(String eventDate , int trainerId);
}
