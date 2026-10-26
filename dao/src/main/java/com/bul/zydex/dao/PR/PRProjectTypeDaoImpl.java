/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PR;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PRProjectType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Query;
/**
 *
 * @author Bulwark-5
 */
public class PRProjectTypeDaoImpl<T> extends GenericsDAOImpl<T> implements PRProjectTypeDao<T> {
    
    @Override
    protected Class getDomainClass() {
        return PRProjectType.class;
    }
}
