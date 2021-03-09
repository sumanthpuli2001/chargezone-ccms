/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Coupon;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.CouponMaster;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class CouponDaoImpl<T> extends GenericsDAOImpl<T> implements CouponDao<T> {

    @Override
    protected Class getDomainClass() {
        return CouponMaster.class;
    }

    @Override
    public List readByShiftType(String shiftType, String item) {

        String query = " Select a from CouponMaster a where a.shiftType='" + shiftType + "'"
                + " and a.couponType='" + item + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readCoupon(String item) {
        String Condition = " where 1 = 1 ";
        if (!item.equals("All")) {
            Condition += " and a.srNo= '" + item + "'";
        }

        String query = " Select a from CouponMaster a "
                + Condition;
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByName(String item) {
        String query = " Select a from CouponMaster a where a.srNo='" + item + "'"
                + " group by a.couponType ";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readAll() {
        String query = " Select a from CouponMaster a group by a.couponType";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByDrow() {
        String query = " Select a from CouponMaster a where a.dRow= 'N' ";
        return getHibernateTemplate().find(query);

    }

    @Override
    public List readByDrowDisable() {
        String query = " Select a from CouponMaster a where a.dRow= 'Y' ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByCoupon(String coupon) {
        String query = " Select a from CouponMaster a where a.couponType='" + coupon + "'";
        return getHibernateTemplate().find(query);

    }
    
     @Override
    public List readByname(String item) {
        String query = " Select a.srNo,a.couponType from CouponMaster a where a.srNo='" + item + "'";
//                + " group by a.couponType ";
        return getHibernateTemplate().find(query);

    }
    
    }
