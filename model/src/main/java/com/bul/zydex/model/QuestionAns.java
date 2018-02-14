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
public class QuestionAns  implements java.io.Serializable {


     private Integer id;
     private QuestionLibrary questionLibrary;
     private String ans;

    public QuestionAns() {
    }

	
    public QuestionAns(QuestionLibrary questionLibrary) {
        this.questionLibrary = questionLibrary;
    }
    public QuestionAns(QuestionLibrary questionLibrary, String ans) {
       this.questionLibrary = questionLibrary;
       this.ans = ans;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public QuestionLibrary getQuestionLibrary() {
        return this.questionLibrary;
    }
    
    public void setQuestionLibrary(QuestionLibrary questionLibrary) {
        this.questionLibrary = questionLibrary;
    }
    public String getAns() {
        return this.ans;
    }
    
    public void setAns(String ans) {
        this.ans = ans;
    }




}


