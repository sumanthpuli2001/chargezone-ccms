/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.pip;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface PipMeetingService<T> extends GenericsService<T> {

    public List<?> readPipMeetingByPipMaster(T object);

}
