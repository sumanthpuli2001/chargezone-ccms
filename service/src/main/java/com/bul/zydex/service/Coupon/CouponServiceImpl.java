/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.service.Coupon;

import com.bul.zydex.dao.Coupon.CouponDao;
import com.bul.zydex.service.GenericsServiceImpl;
import java.util.List;

/**
 *
 * @author Aman Bahukhandi
 */
public class CouponServiceImpl<T> extends GenericsServiceImpl<T> implements CouponService<T> {

    private CouponDao<T> couponDao;

    public CouponDao<T> getCouponDao() {
        return couponDao;
    }

    public void setCouponDao(CouponDao<T> couponDao) {
        this.couponDao = couponDao;
        setGenericsDAO(couponDao);
    }

    @Override
    public List readByShiftType(String shiftType, String item) {
        return couponDao.readByShiftType(shiftType, item);
    }

    @Override
    public List readCoupon(String item) {
        return couponDao.readCoupon(item);
    }

    @Override
    public List readByName(String item) {
        return couponDao.readByName(item);
    }

    @Override
    public List readAll() {
        return couponDao.readAll();
    }

    @Override
    public List readByDrow() {
        return couponDao.readByDrow();
    }

    @Override
    public List readByDrowDisable() {
        return couponDao.readByDrowDisable();
    }

    @Override
    public List readByCoupon(String coupon) {
        return couponDao.readByCoupon(coupon);
    }
    @Override
    public List readByname(String item) {
        return couponDao.readByname(item);
    }
    }
