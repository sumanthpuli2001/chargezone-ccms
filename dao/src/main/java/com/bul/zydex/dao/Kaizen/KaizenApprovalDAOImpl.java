/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Kaizen;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.KaizenApproval;
import java.util.List;

/**
 *
 * @author Aman
 */
public class KaizenApprovalDAOImpl<T> extends GenericsDAOImpl<T> implements KaizenApprovalDAO<T> {

    @Override
    protected Class getDomainClass() {
        return KaizenApproval.class;
    }

    @Override
    public KaizenApproval readByIdAndEmp(int id, int empId) {
        KaizenApproval kaizenApproval = new KaizenApproval();
        String query = "SELECT a"
                + " FROM KaizenApproval a "
                + " WHERE a.kaizenMaster.id = " + id
                + " and a.employeeMaster.id = " + empId;

        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            kaizenApproval = (KaizenApproval) list.get(0);
        } else {
            kaizenApproval = null;
        }
        return kaizenApproval;

    }

    @Override
    public List<?> readApprovalSteeringCommitteList(int empId) {
        String query = "";
        query += " "
                + " SELECT mm.id, mm.srNo, mm.teamName, mm.department, mm.teamMember, ma.status, mm.currentLevel, "
                + " ma.level "
                + " FROM KaizenApproval ma "
                + " Left Join ma.kaizenMaster mm "
                //                + " Where  mm.currentLevel >= ma.level "
                + " Where mm.status = " + 1
                + " And ma.employeeMaster.id = " + empId
                + " order by mm.id desc"
                + " group by mm.id desc";

        List<?> list = getHibernateTemplate().find(query);
        return list;
    }

}
