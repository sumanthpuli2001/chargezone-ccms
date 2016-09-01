/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.leave;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Dhaval Patel <dhaval217@gmail.com>
 */
public interface COffLeaveMasterService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public List<?> readByDept(T object);

}
