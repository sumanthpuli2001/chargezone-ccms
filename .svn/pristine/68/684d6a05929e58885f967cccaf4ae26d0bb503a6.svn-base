/*
 * 
 * Author Vinita
 */

package com.bul.zydex.controller.emprequest;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.LevelMaster;
import com.bul.zydex.model.LocationMaster;
import com.bul.zydex.model.QueryType;
import com.bul.zydex.model.UserRightMaster;
import com.bul.zydex.service.UserRight.UserRightMasterService;
import com.bul.zydex.service.emprequest.HrServiceRequestService;
import com.bul.zydex.service.emprequest.QueryTypeService;
import com.bul.zydex.service.level.LevelMasterService;
import com.bul.zydex.service.location.LocationMasterService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.Validator;

/**
 *
 * @author Vinita
 */
public abstract class HrServiceRequestAbstract extends CustomAbstract{
     
    public HrServiceRequestService<HrServiceRequest> hrServiceRequestService;
    public QueryTypeService<QueryType> queryTypeService;
    public LevelMasterService<LevelMaster> levelMasterService;
    public LocationMasterService<LocationMaster> locationMasterService;
    public Validator hrServiceRequestValidator;
    protected UserRightMasterService<UserRightMaster> userRightMasterService;

    public UserRightMasterService<UserRightMaster> getUserRightMasterService() {
        return userRightMasterService;
    }

    public void setUserRightMasterService(UserRightMasterService<UserRightMaster> userRightMasterService) {
        this.userRightMasterService = userRightMasterService;
    }

    
    public HrServiceRequestService<HrServiceRequest> getHrServiceRequestService() {
        return hrServiceRequestService;
    }

    public void setHrServiceRequestService(HrServiceRequestService<HrServiceRequest> hrServiceRequestService) {
        this.hrServiceRequestService = hrServiceRequestService;
    }

    public LevelMasterService<LevelMaster> getLevelMasterService() {
        return levelMasterService;
    }

    public void setLevelMasterService(LevelMasterService<LevelMaster> levelMasterService) {
        this.levelMasterService = levelMasterService;
    }

    public LocationMasterService<LocationMaster> getLocationMasterService() {
        return locationMasterService;
    }

    public void setLocationMasterService(LocationMasterService<LocationMaster> locationMasterService) {
        this.locationMasterService = locationMasterService;
    }

    public Validator getHrServiceRequestValidator() {
        return hrServiceRequestValidator;
    }

    public void setHrServiceRequestValidator(Validator hrServiceRequestValidator) {
        this.hrServiceRequestValidator = hrServiceRequestValidator;
    }

    public QueryTypeService<QueryType> getQueryTypeService() {
        return queryTypeService;
    }

    public void setQueryTypeService(QueryTypeService<QueryType> queryTypeService) {
        this.queryTypeService = queryTypeService;
    }
    
    
    
    public void readquerytype(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        List<?> list = queryTypeService.read();
        Map<Integer, String> querytypeMap = new LinkedHashMap<Integer, String>();

        for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
            QueryType queryType = (QueryType) iterator.next();
            querytypeMap.put(queryType.getId(), queryType.getText());
        }
        request.setAttribute("querytypeMap", querytypeMap);
    }

}
