/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.webservice;

import com.bul.zydex.controller.CustomAbstract;
import com.bul.zydex.model.HrServiceRequest;
import com.bul.zydex.model.QueryType;
import com.bul.zydex.service.emprequest.HrServiceRequestService;
import com.bul.zydex.service.emprequest.QueryTypeService;
import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author <Jay>
 */
public class HrWebServiceAbstract extends CustomAbstract {

    protected HrServiceRequestService<HrServiceRequest> hrServiceRequestService;
    protected QueryTypeService<QueryType> queryTypeService;

    public QueryTypeService<QueryType> getQueryTypeService() {
        return queryTypeService;
    }

    public void setQueryTypeService(QueryTypeService<QueryType> queryTypeService) {
        this.queryTypeService = queryTypeService;
    }

    public HrServiceRequestService<HrServiceRequest> getHrServiceRequestService() {
        return hrServiceRequestService;
    }

    public void setHrServiceRequestService(HrServiceRequestService<HrServiceRequest> hrServiceRequestService) {
        this.hrServiceRequestService = hrServiceRequestService;
    }

    public JSONObject doConvert(HttpServletRequest request) throws IOException, JSONException {

        StringBuffer buffer = new StringBuffer();
        String line = null;
        try {
            BufferedReader bufferedReader = request.getReader();
            while ((line = bufferedReader.readLine()) != null) {
                buffer.append(line);
            }
        } catch (Exception e) {
        }
        JSONObject jSONObject = new JSONObject(buffer.toString());

        return jSONObject;
    }
}
