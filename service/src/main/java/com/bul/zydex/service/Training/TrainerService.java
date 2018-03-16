/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Training;

import com.bul.zydex.model.Trainer;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Dell-1
 */
public interface TrainerService<T> extends GenericsService<T> {

    public List<?> readByUserName(T object);

    public List<?> readByUser(String username);

    public List<?> readTrainerList();

    public List<?> read(T object);

    public List<?> ListeventDates(String eventDate , int trainerId);
}
