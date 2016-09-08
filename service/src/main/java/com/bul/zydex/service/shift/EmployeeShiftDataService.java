package com.bul.zydex.service.shift;

import com.bul.zydex.service.GenericsService;
import java.util.List;

public interface EmployeeShiftDataService<T> extends GenericsService<T> {

    public List<?> dailyTimeEntry(T object);

    public List<?> attendanceRegularizationEntry(T object);

    public List<?> todaysData();

    public List<?> poolcarApproiveAttendenceRegularization(T object);

    public List<?> empOrDateWiseSearch(T object);

    public List<?> empOrMonthlySearch(T object);

    public List<?> getPastAndCurrentPunch(T object, String endShiftTime);

    public List<?> checkTodayPresent(T object);

    public List<?> checkTodayFirstHalfDayPresent(T object);

    public List<?> checkTodaySecondHalfDayPresent(T object);

    public List<?> getPastAndCurrentPunchForSelectedDate(T object, String endShiftTime, String selectDate, String PreviousDate);

    public List<?> dailyTimeEntryForSelectedDate(T object, String date);

    public List<?> readByEmployeeId(T object, String date);
}
