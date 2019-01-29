/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.shift;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author AJAY
 */
public interface ShiftRotationInfoService<T> extends GenericsService<T> {

    public List<?> readRotaionDetail(T object);

    public String readFirstShfitId(String userId, String roationId);

//    public List<?> checkByUserId(final int userId);

    public List<?> readByUserId(int usermasterid);
    
}
