/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.dao.shift.ShiftRotationMasterDAO;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface ShiftRotationMasterService<T> extends ShiftRotationMasterDAO<T> {

    public List<?> readRotation(T object);

    public List<?> readByDuration(T object);

    public List<?> checkByShiftRotationName(T object);

    public List<?> readByShiftRotationName(String shiftRotationTemp);

}
