/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.CandidateF2FRequest;

import com.bul.zydex.model.CandidateF2FObservation;
import com.bul.zydex.service.GenericsService;
import java.util.List;

/**
 *
 * @author Hussain
 */
public interface CandidateF2FObservationService<T> extends GenericsService<T> {

    public CandidateF2FObservation ReadByIdCandidateF2FOb(int empId, int vancyId, int applycandidate, int applicationID);

    public List<?> ReadByIdCandidateF2FObHr(int vancyId, int applycandidate, int applicationID);
}
