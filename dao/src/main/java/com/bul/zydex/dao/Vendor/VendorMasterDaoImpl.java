/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.Vendor;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.VendorMaster;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author admin
 */
public class VendorMasterDaoImpl<T> extends GenericsDAOImpl<T> implements VendorMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return VendorMaster.class;
    }

    @Override
    public VendorMaster read(String vendorCode) {
        VendorMaster vendorMaster = new VendorMaster();
        String query = "";
        query += " FROM VendorMaster a"
                + " WHERE a.vendorRegNo = '" + vendorCode + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorMaster = (VendorMaster) list.get(0);
        }
        return vendorMaster;
    }

    @Override
    public List readByEmailMobile(String emailid, String mobileNo) {
        String query = "";
        query += " FROM VendorMaster a"
                + " WHERE a.vendorEmailId like '%" + emailid + "%' or a.vendorMobNo like '%" + mobileNo + "%'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByCodeName(String vendor_code, String vendor_name) {
        String query = "";
        if (!vendor_code.equals("") && !vendor_name.equals("")) {
            query += " FROM VendorMaster a"
                    + " WHERE a.vendorRegNo like '" + vendor_code + "%' or a.vendorName like '" + vendor_name + "%'";
        } else if (!vendor_code.equals("")) {
            query += " FROM VendorMaster a"
                    + " WHERE a.vendorRegNo like '" + vendor_code + "%'";
        } else if (!vendor_name.equals("")) {
            query += " FROM VendorMaster a"
                    + " WHERE a.vendorName like '" + vendor_name + "%'";
        } else {
            query += " FROM VendorMaster a"
                    + " WHERE a.vendorRegNo = '" + vendor_code + "' or a.vendorName = '" + vendor_name + "'";
        }
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readVendorRegNo(String LIFNR) {
        String query = "";
        query += " FROM VendorMaster a"
                + " WHERE a.vendorRegNo = '" + LIFNR + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public void updateVendor(String LIFNR, String J_1ILSTNO, String J_1ICSTNO, String STR_SUPPL1, String STR_SUPPL2, String STR_SUPPL3, String CITY1, String POST_CODE1, String CITY2, String STATE, String COUNTRY, String tele, String email) {
        String query = "";
        query += " update VendorMaster a"
                + " set a.vendorStxNo='" + J_1ILSTNO + "', "
                + " a.vendorCstxNo='" + J_1ICSTNO + "', "
                + " a.vendorAddressLine1='" + STR_SUPPL1 + "', "
                + " a.vendorAddressLine2='" + STR_SUPPL2 + "', "
                + " a.vendorAddressLine3='" + STR_SUPPL3 + "', "
                + " a.vendorCity='" + CITY1 + "', "
                + " a.vendorPincode='" + POST_CODE1 + "', "
                + " a.vendorDistrict='" + CITY2 + "', "
                + " a.vendorState='" + STATE + "', "
                + " a.vendorCountry='" + COUNTRY + "', "
                + " a.vendorPhNo='" + tele + "', "
                + " a.vendorMobNo='" + tele + "', "
                + " a.vendorFax='" + tele + "', "
                + " a.vendorEmailID='" + email + "' "
                + " WHERE a.vendorRegNo = '" + LIFNR + "'";
        Query q = getSessionFactory().openSession().createQuery(query);
        q.executeUpdate();
    }

    @Override
    public List readByEmailId(String email_id) {
        String query = "";
        query += " FROM VendorMaster a"
                + " WHERE a.vendorName = '" + email_id + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List SearchByCode(String vendor_code, String vendor_name, String vendor_remark) {
        String query = "SELECT a.vendorRegNo, "
                + "a.vendorName, "
                + "a.vendorAddressLine1, "
                + "a.vendorEmailID, "
                + "a.vendorMobNo, "
                + "b.status1 "
                + "FROM VendorMaster a, VendorInformation b "
                + "WHERE a.vendorRegNo = b.vendorEmailId "
                + "AND b.status1 != 700 ";

        if (vendor_code != null && !vendor_code.trim().equals("")) {
            query += "AND (a.vendorRegNo LIKE '" + vendor_code.trim() + "%' "
                    + "OR b.vendorEmailId LIKE '" + vendor_code.trim() + "%') ";
        }

        if (vendor_name != null && !vendor_name.trim().equals("")) {
            query += "AND (a.vendorName LIKE '" + vendor_name.trim() + "%' "
                    + "OR b.companyName LIKE '" + vendor_name.trim() + "%') ";
        }

        if (vendor_remark != null && !vendor_remark.trim().equals("")) {
            query += "AND a.vendorRemark LIKE '%" + vendor_remark.trim() + "%' ";
        }

        System.out.println(query);

        return getHibernateTemplate().find(query);
    }

    @Override
    public VendorMaster readByRegNo(String login_name) {
        VendorMaster vendorMaster = new VendorMaster();
        String query = "";
        query += " FROM VendorMaster a"
                + " WHERE a.vendorRegNo = '" + login_name + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            vendorMaster = (VendorMaster) list.get(0);
        }
        return vendorMaster;
    }
}
