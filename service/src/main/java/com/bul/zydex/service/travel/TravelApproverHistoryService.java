/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.travel;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Irfan
 */
public interface TravelApproverHistoryService<T> extends GenericsService<T> {

    public List<?> readapproverlist(int TabId, String loginId);

    public List<?> readpreviousmanagerdata(int TabId, String prevManagerId);

    public List<?> readlastapprove(int TabId, String loginId);

    public List<?> readSameTravelId(T object);

    public List<?> readApproverStatusList(T object);
}
