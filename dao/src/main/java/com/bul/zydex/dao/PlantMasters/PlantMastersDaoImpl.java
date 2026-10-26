/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.dao.PlantMasters;

import com.bul.zydex.dao.GenericsDAOImpl;
import com.bul.zydex.model.PlantMasters;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Sumanth
 */
public class PlantMastersDaoImpl<T> extends GenericsDAOImpl<T> implements PlantMastersDao<T> {

    @Override
    protected Class getDomainClass() {

        return PlantMasters.class;
    }

    @Override
    public boolean isExist(T object) {
        boolean flag = false;
        PlantMasters plantMasters = (PlantMasters) object;
        List list = getHibernateTemplate().find(
                "from PlantMasters l where "
                + "l.companyCode = ? and l.plantCode = ? and l.plantName = ? and l.address = ? and l.gst = ? "
                + "and l.purchasingOrganisation = ? and l.postalCode = ? and l.country = ? and l.region = ? and l.language = ?",
                plantMasters.getCompanyCode(), plantMasters.getPlantCode(), plantMasters.getPlantName(),
                plantMasters.getAddress(), plantMasters.getGst(),
                plantMasters.getPurchasingOrganisation(), plantMasters.getPostalCode(),
                plantMasters.getCountry(), plantMasters.getRegion(),
                plantMasters.getLanguage()
        );
        if (list.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    @Override
    public PlantMasters readByPlant(String plan_code) {
        PlantMasters plantMasters = new PlantMasters();
        String query = "";
        query += " FROM PlantMasters a"
                + " WHERE a.plantCode = '" + plan_code + "'";
        List<?> list = getHibernateTemplate().find(query);
        if (!list.isEmpty()) {
            plantMasters = (PlantMasters) list.get(0);
        }
        return plantMasters;
    }

    @Override
    public List getPlantMastersPagination(int start, int length, String search, String orderColumn, String orderDir) {
        Session session = getSessionFactory().openSession();
        try {
            if (orderColumn == null || orderColumn.trim().equals("")) {
                orderColumn = "id";
            }
            if (orderDir == null || orderDir.trim().equals("")) {
                orderDir = "desc";
            }

            if (!orderDir.equalsIgnoreCase("asc") && !orderDir.equalsIgnoreCase("desc")) {
                orderDir = "desc";
            }

            String hql = "from PlantMasters a where 1 = 1 ";

            if (search != null && !search.trim().equals("")) {
                hql += " AND ("
                        + " lower(a.companyCode) LIKE :search "
                        + " OR lower(a.plantCode) LIKE :search "
                        + " OR lower(a.plantName) LIKE :search "
                        + " OR lower(a.address) LIKE :search "
                        + " OR lower(a.gst) LIKE :search "
                        + " OR lower(a.purchasingOrganisation) LIKE :search "
                        + " OR lower(a.postalCode) LIKE :search "
                        + " OR lower(a.country) LIKE :search "
                        + " OR lower(a.region) LIKE :search "
                        + " OR lower(a.language) LIKE :search "
                        + ")";
            }

            hql += " order by a."
                    + orderColumn
                    + " "
                    + orderDir;

            System.out.println("HQL : " + hql);
            Query query = session.createQuery(hql);

            if (search != null && !search.trim().equals("")) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
    public int getTotalPlantMastersCount() {
        Session session = getSessionFactory().openSession();
        Long count = (Long) session.createQuery(
                "select count(a.id) "
                + "from PlantMasters a "
                + "where 1=1"
        ).uniqueResult();

        session.close();
        return count.intValue();
    }

    @Override
    public int getFilteredPlantMastersCount(String search) {
        Session session = getSessionFactory().openSession();
        try {
            String hql = "select count(a.id) "
                    + "from PlantMasters a "
                    + "where 1 = 1";

            if (search != null && !search.trim().isEmpty()) {
                hql += " AND ("
                        + " lower(a.companyCode) LIKE :search "
                        + " OR lower(a.plantCode) LIKE :search "
                        + " OR lower(a.plantName) LIKE :search "
                        + " OR lower(a.address) LIKE :search "
                        + " OR lower(a.gst) LIKE :search "
                        + " OR lower(a.purchasingOrganisation) LIKE :search "
                        + " OR lower(a.postalCode) LIKE :search "
                        + " OR lower(a.country) LIKE :search "
                        + " OR lower(a.region) LIKE :search "
                        + " OR lower(a.language) LIKE :search "
                        + ")";

            }

            Query query = session.createQuery(hql);
            if (search != null && !search.trim().isEmpty()) {
                query.setParameter("search", "%" + search.toLowerCase() + "%");
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
