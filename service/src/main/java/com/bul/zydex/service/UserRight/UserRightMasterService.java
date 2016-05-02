/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.UserRight;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author admin
 */
public interface UserRightMasterService<T> extends GenericsService<T> {

    public List<?> readByUserId(String userId);

    public List<?> readByUserRight(T object);

    public List<?> readHRList();

    public List<?> readpoolcarAdminList();

    public List<?> readSecurityList();

    public List<?> readCafeAdminList();

    public List<?> readITAdminList();

    public List<?> readEmployeeExitRightsList();

    public List<?> readExitInterviewRightsList();

    public List<?> readNoDueRightsList();

    public List<?> readProbationToConfirmationAdminList();

    public List<?> readEmployeeReferralRights();

    public List<?> readApparaisal360Rights();

    public List<?> readTravelAdmin();

    public List<?> readExpenseAdmin();

}
