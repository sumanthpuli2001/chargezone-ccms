/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.controller.appraisalPerformance;

import com.bul.zydex.model.AppraisalPerformanceMaster;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dhaval Parmar<dhaval@bulwarks.com>
 */
public class AppraisalPerformanceBehaviorsController extends AppraisalPerformanceBehaviorsAbstract {

    public ModelAndView hrDashboard(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        Year year = Year.now();
        List<List<String>> finalList = new ArrayList<List<String>>();
        final int lastYear = Integer.parseInt(year.toString()) - 1;
        List<?> departmentWiseEmpCountList = departmentMasterService.countEmpByDepartmentList2();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Object o1 : departmentWiseEmpCountList) {
            Object[] o = (Object[]) o1;
            String departStr = (String) o[0];
            int id = (Integer) o[2];
//            List<?> performanceRatingList = appraisalPerformanceBehaviorsService.readperformanceRatingList(currentYear, id);
//            map.put(departStr, performanceRatingList);

            int score = 0;
            List<String> farExceedsExpectations = new ArrayList();
            List<String> exceedsExpectations = new ArrayList();
            List<String> meetsExpectations = new ArrayList();
            List<String> partiallyMeetsExpectations = new ArrayList();
            List<String> doesNotMeetExpectations = new ArrayList();
            List<?> lastYearPerformanceRatiingRecordList = appraisalPerformanceBehaviorsService.readperformanceRatingList(lastYear, id);
            if (!lastYearPerformanceRatiingRecordList.isEmpty()) {
                for (Object o2 : lastYearPerformanceRatiingRecordList) {
//                    Object[] o3 = (Object[]) o2;
                    if (o2 != null && !"".equals(o2)) {
                        String score1 = "" + o2;

                        score = Integer.parseInt(score1);

                        if (score >= 91) {
                            farExceedsExpectations.add("" + score);
                        } else if (score >= 81 && score <= 90) {
                            exceedsExpectations.add("" + score);
                        } else if (score >= 71 && score <= 80) {
                            meetsExpectations.add("" + score);
                        } else if (score >= 51 && score <= 70) {
                            partiallyMeetsExpectations.add("" + score);
                        } else {
                            doesNotMeetExpectations.add("" + score);
                        }
                    }

                }
                List<String> scoreList = new ArrayList<String>();

                scoreList.add("" + departStr);
                scoreList.add("" + farExceedsExpectations.size());
                scoreList.add("" + exceedsExpectations.size());
                scoreList.add("" + meetsExpectations.size());
                scoreList.add("" + partiallyMeetsExpectations.size());
                scoreList.add("" + doesNotMeetExpectations.size());
                finalList.add(scoreList);
//            map.put(departStr, scoreList);

            }
        }

//            mv.addObject("performanceRatingList", performanceRatingList);
//        mv.addObject("performanceRatingmap", map);
        request.setAttribute("finalList", finalList);
        mv.addObject("departmentWiseEmpCountList", departmentWiseEmpCountList);
        mv.setViewName("forward:userMaster.htm?act=hrDashboardShow");
//        mv.setViewName("Dashboard/HrDashBoard");
        return mv;
    }

}
