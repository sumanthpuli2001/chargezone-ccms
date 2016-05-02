package com.bul.zydex.service.shift;

import com.bul.zydex.service.GenericsService;
import java.util.List;

public interface TemporaryShiftAssignService<T> extends GenericsService<T> {
    
    public List<?> temporaryShiftAssignResult();
    
    public T temporaryShiftAssignResultByDaysWise(T object);

}
