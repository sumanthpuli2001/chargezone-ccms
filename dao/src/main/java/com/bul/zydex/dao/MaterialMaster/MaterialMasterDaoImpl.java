/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.MaterialMaster;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.MaterialMaster;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Aman Bahukhandi
 */
public class MaterialMasterDaoImpl<T> extends GenericsDAOImpl<T> implements MaterialMasterDao<T> {

    @Override
    protected Class getDomainClass() {
        return MaterialMaster.class;
    }

    @Override
    public List searchMaterial(String material_group, String material_Type, String material_code, String material_desc) {
        String query = "";
        query += " FROM MaterialMaster a"
                + " WHERE 1=1 ";

        if (material_group.equals("")) {
        } else {
            query += " and a.materialGroupMaster.id = '" + material_group + "'";
        }
        if (material_Type.equals("")) {
        } else {
            query += " and a.materialTypeMaster.id = '" + material_Type + "'";
        }
        if (material_code.equals("")) {
        } else {
            query += " and a.materialCode like '" + material_code + "%'";
        }
        if (material_desc.equals("")) {
        } else {
            query += " and a.materialDescription like '" + material_desc + "%'";
        }

        return getHibernateTemplate().find(query);
    }

    @Override
    public List readAll() {
        String hqlQuery = " SELECT a.id,b.materialType,d.materialGroupName,a.materialCode,a.materialDescription,a.materialLongDescription,a.uom,a.hsnNo,a.gst"
                + " FROM MaterialMaster a left join a.materialTypeMaster b"
                + " left join a.materialGroupMaster d ";

        return getHibernateTemplate().find(hqlQuery);
    }

    @Override
    public boolean isExist(T object) {

        boolean flag = false;
        MaterialMaster materialMaster = (MaterialMaster) object;
        List list = getHibernateTemplate().find("from MaterialMaster l"
                + " WHERE l.materialCode = '" + materialMaster.getMaterialCode() + "'");

        if (list.isEmpty()) {
            flag = true;
        }
        return flag;

    }

    @Override
    public List search1(String materialCode, String materialDescription, String group, String type) {

        String query = "";
        query = " SELECT a.id,b.materialType,d.materialGroupName,a.materialCode,a.materialDescription,a.materialLongDescription,a.uom,a.hsnNo,a.gst"
                + " FROM MaterialMaster a left join a.materialTypeMaster b"
                + " left join a.materialGroupMaster d "
                + "WHERE 1=1";

        if (materialCode.equals("")) {
        } else {
            query += " and a.materialCode = '" + materialCode + "'";
        }
        if (materialDescription.equals("")) {
        } else {
            query += " and a.materialDescription = '" + materialDescription + "'";
        }
        if (group.equals("")) {
        } else {
            query += " and d.id = '" + group + "'";
        }

        if (type.equals("")) {
        } else {
            query += " and b.id = '" + type + "'";
        }
        query += " ";
        return getHibernateTemplate().find(query);
    }

    @Override
    public List readByMaterialcode(String material_code) {

        String query = "";
        query += " FROM MaterialMaster a"
                + " WHERE a.materialCode = '" + material_code + "'";
        return getHibernateTemplate().find(query);
    }

    @Override
    public MaterialMaster read(String materialCode) {
        MaterialMaster materialMaster = new MaterialMaster();
        String query = "";
        query += " FROM MaterialMaster a"
                + " WHERE a.materialCode = '" + materialCode + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            materialMaster = (MaterialMaster) list.get(0);
        }
        return materialMaster;
    }

    @Override
    public List getMaterialPagination(int start, int length, String searchValue, String group, String type, String materialCode, String materialDescription, String orderColumn, String orderDir) {

        Session session = getSessionFactory().openSession();

        try {
            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "id";
            }
            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "asc";
            }

            if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "asc";
            }

            String hql = " select a.id, b.materialType, c.materialGroupName, a.materialCode, a.materialDescription, a.materialLongDescription, a.uom, a.hsnNo, a.gst "
                    + "from MaterialMaster a, MaterialTypeMaster b, MaterialGroupMaster c "
                    + " where a.materialTypeMaster = b.id "
                    + " And a.materialGroupMaster = c.id ";

            if (group != null && !group.trim().equals("")) {

                hql += " AND lower(c.materialGroupName) LIKE :group ";
            }

            if (type != null && !type.trim().equals("")) {

                hql += " AND lower(b.materialType) LIKE :type ";
            }

            if (materialCode != null && !materialCode.trim().equals("")) {

                hql += " AND lower(a.materialCode) LIKE :materialCode ";
            }

            if (materialDescription != null && !materialDescription.trim().equals("")) {

                hql += " AND lower(a.materialDescription) LIKE :materialDescription ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.id) LIKE :search "
                        + " OR lower(b.materialType) LIKE :search "
                        + " OR lower(c.materialGroupName) LIKE :search "
                        + " OR lower(a.materialCode) LIKE :search "
                        + " OR lower(a.materialDescription) LIKE :search "
                        + " OR lower(a.materialLongDescription) LIKE :search "
                        + " OR lower(a.uom) LIKE :search "
                        + " OR lower(a.hsnNo) LIKE :search "
                        + " OR lower(a.gst) LIKE :search "
                        + ") ";
            }

            hql += " order by " + orderColumn + " " + orderDir;

            Query query = session.createQuery(hql);

            if (group != null && !group.trim().equals("")) {
                query.setParameter("group", "%" + group.toLowerCase() + "%");
            }

            if (type != null && !type.trim().equals("")) {
                query.setParameter("type", "%" + type.toLowerCase() + "%");
            }

            if (materialCode != null && !materialCode.trim().equals("")) {
                query.setParameter("materialCode", "%" + materialCode.toLowerCase() + "%");
            }

            if (materialDescription != null && !materialDescription.trim().equals("")) {
                query.setParameter("materialDescription", "%" + materialDescription.toLowerCase() + "%");
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            query.setFirstResult(start);
            query.setMaxResults(length);

            List list = query.list();

            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        } finally {
            session.close();
        }

    }

    @Override
    public int getTotalMaterialCount() {
        Session session = getSessionFactory().openSession();

        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from MaterialMaster a "
                + "where 1=1"
        ).uniqueResult();

        session.close();

        return count.intValue();

    }

    @Override
    public int getFilteredMaterialCount(String group, String type, String materialCode, String materialDescription, String searchValue) {

        Session session = getSessionFactory().openSession();

        try {
            String hql = "select count(a.id) "
                    + "from MaterialMaster a, MaterialTypeMaster b, MaterialGroupMaster c "
                    + " where a.materialTypeMaster = b.id "
                    + " And a.materialGroupMaster = c.id ";

            if (group != null && !group.trim().equals("")) {

                hql += " AND lower(c.materialGroupName) LIKE :group ";
            }

            if (type != null && !type.trim().equals("")) {

                hql += " AND lower(b.materialType) LIKE :type ";
            }

            if (materialCode != null && !materialCode.trim().equals("")) {

                hql += " AND lower(a.materialCode) LIKE :materialCode ";
            }

            if (materialDescription != null && !materialDescription.trim().equals("")) {

                hql += " AND lower(a.materialDescription) LIKE :materialDescription ";
            }

            if (searchValue != null && !searchValue.trim().equals("")) {

                hql += " AND ("
                        + " lower(a.id) LIKE :search "
                        + " OR lower(b.materialType) LIKE :search "
                        + " OR lower(c.materialGroupName) LIKE :search "
                        + " OR lower(a.materialCode) LIKE :search "
                        + " OR lower(a.materialDescription) LIKE :search "
                        + " OR lower(a.materialLongDescription) LIKE :search "
                        + " OR lower(a.uom) LIKE :search "
                        + " OR lower(a.hsnNo) LIKE :search "
                        + " OR lower(a.gst) LIKE :search "
                        + ") ";
            }

            Query query = session.createQuery(hql);

            if (group != null && !group.trim().equals("")) {
                query.setParameter("group", "%" + group.toLowerCase() + "%");
            }

            if (type != null && !type.trim().equals("")) {
                query.setParameter("type", "%" + type.toLowerCase() + "%");
            }

            if (materialCode != null && !materialCode.trim().equals("")) {
                query.setParameter("materialCode", "%" + materialCode.toLowerCase() + "%");
            }

            if (materialDescription != null && !materialDescription.trim().equals("")) {
                query.setParameter("materialDescription", "%" + materialDescription.toLowerCase() + "%");
            }

            if (searchValue != null && !searchValue.trim().equals("")) {
                query.setParameter("search", "%" + searchValue.toLowerCase() + "%");
            }

            Long count = (Long) query.uniqueResult();
            return count.intValue();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            session.close();
        }
    }

}
