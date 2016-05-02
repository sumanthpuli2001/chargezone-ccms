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
 * @author Khurshid Khokhar <khokharkhurshid123@gmail.com>
 */
public interface LeaveEncashmentService<T> extends GenericsService<T> {

    public List<?> readByEmpId(T object);

    public List<?> readByEmpNLeaveId(T object);

    public List<?> readAll();

    public List<?> readStatusByHr(T object);
}
