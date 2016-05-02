/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.leave;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ShortLeave;
import com.bul.zydex.service.leave.ShortLeaveService;
import org.springframework.validation.Validator;

/**
 *
 * @author Khurshid Khokhar <Khokharkhurshid123@gmail.com>
 */
public class ShortLeaveAbstract extends CustomAbstract {

    protected ShortLeaveService<ShortLeave> shortLeaveService;
    protected Validator ShortLeaveValidator;

    public ShortLeaveService<ShortLeave> getShortLeaveService() {
        return shortLeaveService;
    }

    public void setShortLeaveService(ShortLeaveService<ShortLeave> shortLeaveService) {
        this.shortLeaveService = shortLeaveService;
    }

    public Validator getShortLeaveValidator() {
        return ShortLeaveValidator;
    }

    public void setShortLeaveValidator(Validator ShortLeaveValidator) {
        this.ShortLeaveValidator = ShortLeaveValidator;
    }

}
