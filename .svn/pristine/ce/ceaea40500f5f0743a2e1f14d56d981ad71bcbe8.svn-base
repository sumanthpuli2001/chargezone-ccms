/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.travel;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.PolicyDeviationForAir;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.travel.PolicyDeviationForAirService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.Validator;

/**
 *
 * @author AJAY
 */
public class PolicyDeviationForAirAbstract extends CustomAbstract {

    protected PolicyDeviationForAirService<PolicyDeviationForAir> policyDeviationForAirService;
    protected Validator policyDeviationForAirValidator;
    protected LevelMasterService<LevelMaster> levelMasterService;

    public PolicyDeviationForAirService<PolicyDeviationForAir> getPolicyDeviationForAirService() {
        return policyDeviationForAirService;
    }

    public void setPolicyDeviationForAirService(PolicyDeviationForAirService<PolicyDeviationForAir> policyDeviationForAirService) {
        this.policyDeviationForAirService = policyDeviationForAirService;
    }

    public Validator getPolicyDeviationForAirValidator() {
        return policyDeviationForAirValidator;
    }

    public void setPolicyDeviationForAirValidator(Validator policyDeviationForAirValidator) {
        this.policyDeviationForAirValidator = policyDeviationForAirValidator;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    protected void levelList(HttpServletRequest request) {
        LevelMaster levelMaster = new LevelMaster();
        List<?> level = levelMasterService.read();
        Map<Integer, String> level1 = new HashMap<>();
        for (Object o : level) {
            levelMaster = (LevelMaster) o;
            level1.put(levelMaster.getId(), levelMaster.getLevel());
        }

        request.setAttribute("level", level1);
    }

}
