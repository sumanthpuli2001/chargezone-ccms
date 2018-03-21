/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateF2FApproval;

import com.bul.zydex.model.CandidateF2FRequest;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Vikas
 */
public interface CandidateF2FApprovalService<T> extends GenericsService<T>{
       public List<?> readByReqId(int id);
}
