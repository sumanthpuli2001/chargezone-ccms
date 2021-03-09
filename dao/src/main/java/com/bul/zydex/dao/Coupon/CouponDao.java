/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Coupon;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public interface CouponDao<T> extends GenericsDAO<T> {

    public List readByShiftType(String shiftType, String item);

    public List readCoupon(String item);

    public List readByName(String item);

    public List readAll();

    public List readByDrow();

    public List readByDrowDisable();

    public List readByCoupon(String parameter);
    public List readByname(String item);
}
