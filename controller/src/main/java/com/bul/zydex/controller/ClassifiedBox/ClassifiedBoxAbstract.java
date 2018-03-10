/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.ClassifiedBox;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.ClassifiedBox;
import com.bul.zydex.service.ClassifiedBox.ClassifiedBoxService;
import org.springframework.validation.Validator;

/**
 *
 * @author Hussain
 */
public class ClassifiedBoxAbstract extends CustomAbstract{
    protected ClassifiedBoxService<ClassifiedBox> classifiedBoxService;
     protected Validator classifiedBoxValidator;

    public ClassifiedBoxService<ClassifiedBox> getClassifiedBoxService() {
        return classifiedBoxService;
    }

    public void setClassifiedBoxService(ClassifiedBoxService<ClassifiedBox> classifiedBoxService) {
        this.classifiedBoxService = classifiedBoxService;
    }

    public Validator getClassifiedBoxValidator() {
        return classifiedBoxValidator;
    }

    public void setClassifiedBoxValidator(Validator classifiedBoxValidator) {
        this.classifiedBoxValidator = classifiedBoxValidator;
    }
    
    
    
}
