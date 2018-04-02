/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.RecruitmentApprovalHistory;

import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Dell-1
 */
public interface RecruitmentApprovalHistoryService<T> extends GenericsService<T> {

    public List<?> getByRecruitementMasterId(int mppId);

}
