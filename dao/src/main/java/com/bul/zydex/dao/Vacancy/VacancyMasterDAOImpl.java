/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vacancy;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VacancyMaster;
import java.util.List;

/**
 *
 * @author Vikas
 */
public class VacancyMasterDAOImpl<T> extends GenericsDAOImpl<T> implements VacancyMasterDAO<T> {

    @Override
    protected Class getDomainClass() {
        return VacancyMaster.class;
    }

    @Override
    public List<?> fetchVacancyDetail() {
        String query = "";
        query += " "
                + " SELECT a.id, a.name, a.numberOfPosition, a.salaryRange, a.experience, a.status, a.fromDate, a.toDate"
                + " FROM VacancyMaster a "
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

    @Override
    public List<?> fetchCreatedVacancy(int empId) {
        String query = "";
        query += " "
                + " SELECT a.id, a.name, a.numberOfPosition, a.salaryRange, a.experience, a.status, a.fromDate, a.toDate"
                + " FROM VacancyMaster a "
                + " Where a.createdBy =" + empId
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> fetchVacancyBydate(String date) {
        String query = "";
        query += " "
                + " SELECT a.id, a.name, a.numberOfPosition, a.salaryRange, a.experience, a.status, a.fromDate, a.toDate"
                + " FROM VacancyMaster a "
                + " WHERE STR_TO_DATE(a.fromDate,'%d/%m/%Y') <=  STR_TO_DATE('" + date + "','%d/%m/%Y')"
                + " AND STR_TO_DATE(a.toDate,'%d/%m/%Y') >=  STR_TO_DATE('" + date + "','%d/%m/%Y')"
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }

    @Override
    public List<?> fetchDateWiseData(String startDate, String endDate) {
//        String query = "";
//        query += " "
//                + " SELECT a.id, a.name, a.numberOfPosition, a.salaryRange, a.experience, a.status, a.fromDate, a.toDate"
//                + " FROM VacancyMaster a "
//                + " WHERE STR_TO_DATE(a.fromDate,'%d/%m/%Y') >=  STR_TO_DATE('" + startDate + "','%d/%m/%Y')"
//                + " AND STR_TO_DATE(a.toDate,'%d/%m/%Y') <=  STR_TO_DATE('" + endDate + "','%d/%m/%Y')"
//                + " order by a.id desc";

        String query = " SELECT a.id as cjaId,b.id as cajId,c.id as vmId,b.name as candidatename, "
                + " b.highestEducationQualification,b.emailId,b.experianceDateJoiningYear,c.name as vacancyName,a.status,a.createdDate,de.departmentName "
                + " FROM CandidateJobApplication a "
                + " LEFT JOIN a.candidateApplyJob b "
                + " LEFT JOIN a.vacancyMaster c "
                + " LEFT JOIN c.departmentMaster de "
                + " WHERE a.status!=0 "
                + " AND STR_TO_DATE(c.fromDate,'%d/%m/%Y') >=  STR_TO_DATE('" + startDate + "','%d/%m/%Y')"
                + " AND STR_TO_DATE(c.toDate,'%d/%m/%Y') <=  STR_TO_DATE('" + endDate + "','%d/%m/%Y')"
                + " order by a.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;

    }
}
