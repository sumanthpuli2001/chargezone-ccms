/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.model;

/**
 *
 * @author Admin
 */
public class QuestionDetails implements java.io.Serializable{

    private Integer id;
    private QuestionPaper questionPaper;
    private QuestionLibrary questionLibrary;

    public QuestionDetails() {
    }

    public QuestionDetails(QuestionPaper questionPaper, QuestionLibrary questionLibrary) {
        this.questionPaper = questionPaper;
        this.questionLibrary = questionLibrary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QuestionPaper getQuestionPaper() {
        return questionPaper;
    }

    public void setQuestionPaper(QuestionPaper questionPaper) {
        this.questionPaper = questionPaper;
    }

    public QuestionLibrary getQuestionLibrary() {
        return questionLibrary;
    }

    public void setQuestionLibrary(QuestionLibrary questionLibrary) {
        this.questionLibrary = questionLibrary;
    }
    
    

}
