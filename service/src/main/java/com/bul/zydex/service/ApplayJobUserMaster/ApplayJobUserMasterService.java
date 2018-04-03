/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.ApplayJobUserMaster;

import com.bul.zydex.model.ApplayJobUserMaster;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface ApplayJobUserMasterService<T> extends GenericsService<T> {

    public boolean isExist(T object);

    public boolean profileFilling(int userId);

    public ApplayJobUserMaster checkByUserNameandPass(T object);

    public Boolean checkByLogInStatus(T object);

}
