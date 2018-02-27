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
public class QuestionPaper  implements java.io.Serializable {


     private Integer id;
     private QuestionLibrary questionLibrary;
     private String categoryName;
     private String paperName;
     private Double totalMarks;
     private Integer status;
     private Integer createdBy;
     private String createdDate;
     private Integer updatedBy;
     private String updatedDate;

    public QuestionPaper() {
    }

	
    public QuestionPaper(QuestionLibrary questionLibrary) {
        this.questionLibrary = questionLibrary;
    }
    public QuestionPaper(QuestionLibrary questionLibrary, String categoryName, String paperName, Double totalMarks, Integer status, Integer createdBy, String createdDate, Integer updatedBy, String updatedDate) {
       this.questionLibrary = questionLibrary;
       this.categoryName = categoryName;
       this.paperName = paperName;
       this.totalMarks = totalMarks;
       this.status = status;
       this.createdBy = createdBy;
       this.createdDate = createdDate;
       this.updatedBy = updatedBy;
       this.updatedDate = updatedDate;
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
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getPaperName() {
        return this.paperName;
    }
    
    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }
    public Double getTotalMarks() {
        return this.totalMarks;
    }
    
    public void setTotalMarks(Double totalMarks) {
        this.totalMarks = totalMarks;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    public String getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public Integer getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    public String getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }




}
