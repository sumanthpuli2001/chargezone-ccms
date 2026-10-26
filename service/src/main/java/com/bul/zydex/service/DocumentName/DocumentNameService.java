/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.DocumentName;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Sumanth
 */
public interface DocumentNameService<T> extends GenericsService<T> {

    public List readAll();

    public List readBystate(String state);

    public List readByStateName(String state);

    public List readyBydisconn(int discom, int connection);

    public List readByall();
    
}
