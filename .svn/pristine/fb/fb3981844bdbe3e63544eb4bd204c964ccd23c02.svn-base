/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.emp;

import com.bul.zydex.controller.*;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.service.level.LevelMasterService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import org.springframework.validation.Validator;

/**
 *
 * @author Administrator
 */
public abstract class DesignationMasterAbstract extends CustomAbstract {

    protected LevelMasterService<LevelMaster> levelMasterService;
    protected Validator designationMasterValidator;

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public Validator getDesignationMasterValidator() {
        return designationMasterValidator;
    }

    public void setDesignationMasterValidator(Validator designationMasterValidator) {
        this.designationMasterValidator = designationMasterValidator;
    }

    protected Map<Integer, String> getLevelMasterMap(HttpServletRequest request) {

        Map<Integer, String> levelMasterMap = new HashMap<Integer, String>();
        //HashMap because order is not matter here and comlexity of it is O(1) only and treemap complexity is O(log(N)).
        List levelMasterDataList = levelMasterService.read();
        LevelMaster levelMaster = new LevelMaster();
//            levelMasterDataList.stream().forEach(levelMaster -> levelMasterMap.put(levelMaster.getId, levelMaster.getLevel));
//            Stream.of(levelMasterDataList).filter(levelMaster->levelMaster instanceof LevelMaster).map(LevelMaster.class::cast).map(LevelMaster::getLevel).forEach(System.out::println);
//            Stream.of(levelMasterDataList).filter(levelMaster->levelMaster instanceof LevelMaster).map(levelMaster -> (LevelMaster) levelMaster).map(LevelMaster::getId,LevelMaster::getLevel).forEach(is::add);
        for (Object o : levelMasterDataList) {
            levelMaster = (LevelMaster) o;
            levelMasterMap.put(levelMaster.getId(), levelMaster.getLevel());
        }

        return levelMasterMap;
    }
}
