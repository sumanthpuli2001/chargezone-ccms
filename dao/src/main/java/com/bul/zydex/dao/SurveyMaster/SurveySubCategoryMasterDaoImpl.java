/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
// */
//package com.bul.zydex.dao.SurveyMaster;
//
//import com.bul.zydex.dao.GenericsDAOImpl;
//import com.bul.zydex.model.SurveySubCategoryMaster;
//import java.util.List;
//
///**
// *
// * @author Admin
// */
//public class SurveySubCategoryMasterDaoImpl<T> extends GenericsDAOImpl<T> implements SurveySubCategoryMasterDao<T> {
//
//    @Override
//    protected Class getDomainClass() {
//        return SurveySubCategoryMaster.class;
//    }
//
//    @Override
//    public List readByCateId(int id) {
//        String query = "";
//        query += " FROM SurveySubCategoryMaster a"
//                + " WHERE a.surveyCategoryId = " + id;
//        return getHibernateTemplate().find(query);
//    }
//
//}
