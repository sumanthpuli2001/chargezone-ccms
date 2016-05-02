/*
 *
 * Author Dhaval
 */
package com.bul.zydex.dao.pip;

import com.bul.zydex.dao.GenericsDAO;
import java.util.List;

/**
 *
 * @author Dhaval
 */
public interface ImprovementGoalDAO<T> extends GenericsDAO<T> {

    public List<?> readImprovementGoalByPipMaster(T object);

}
