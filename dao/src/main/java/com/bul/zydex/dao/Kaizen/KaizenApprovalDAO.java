/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Kaizen;

import com.bul.zydex.dao.GenericsDAO;
import com.bul.zydex.model.KaizenApproval;
import java.util.List;

/**
 *
 * @author Aman
 */
public interface KaizenApprovalDAO<T> extends GenericsDAO<T> {

    public KaizenApproval readByIdAndEmp(int id, int empId);

    public List<?> readApprovalSteeringCommitteList(int empId);

}
