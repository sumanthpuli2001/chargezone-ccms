package com.bul.zydex.service.shift;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AJAY
 */
public interface ShiftMasterService<T> extends GenericsService<T> {

    public List<?> readByShiftId(T object);

    public List<?> readByShiftName();

    public List<?> checkExistingShift(T object);

    public List<?> getByShiftName(final String shiftTempString);

}
