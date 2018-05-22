/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bul.zydex.model;

/**
 *
 * @author Rishi
 */
public class Candidatef2fInterviewRating implements java.io.Serializable{
    
    private Integer id;
    private CandidateF2FRequest candidateF2FRequest;
    
    public Candidatef2fInterviewRating(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CandidateF2FRequest getCandidateF2FRequest() {
        return candidateF2FRequest;
    }

    public void setCandidateF2FRequest(CandidateF2FRequest candidateF2FRequest) {
        this.candidateF2FRequest = candidateF2FRequest;
    }

    
    

}
