package com.bul.zydex.controller.Dashboard;

import com.google.gson.Gson;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class OapAocDashboardController extends OapAocDashboardAbstract {

    public ModelAndView oapAndAocDashboardData(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String Fromdate = request.getParameter("Fromdate");
        String Todate = request.getParameter("Todate");
        String Filter = request.getParameter("Filter");

        String formattedDate = "";
        String formattedStartDate = "";
        try {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            switch (Filter) {
                case "last-week":
                    formattedStartDate = now.minusDays(7).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-month":
                    formattedStartDate = now.minusDays(30).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-6-month":
                    formattedStartDate = now.minusDays(183).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                case "last-year":
                    formattedStartDate = now.minusDays(365).format(fmt);
                    formattedDate = now.format(fmt);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
        }

        Map<String, Object> result = new HashMap<>();

        // ---- OAP ----
        int totalOap = oapFormService.readByAllOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int approvedOap = oapFormService.readByFlagFourDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int pendingOap = oapFormService.readBypendingOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int rejctedOap = oapFormService.readByrejctedOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int unfieldCRC = oapFormService.readByunfieldCRCDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        // ---- CRC ----
        int totalCrc = crcFormService.countAllCrcDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int approvedCrc = crcFormService.readByFlagFourDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int pendingCrc = crcFormService.readBypendingCrcDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int revisionCrc = crcFormService.readByrevisionCrcDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int partiallyApprovedCrc = crcFormService.readByFlagTwoDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int rejectedCrc = crcFormService.readByFlagThreeDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//
//        // ---- AOC ----
        int totalAoc = aocFormService.countAllAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int approvedAoc = aocFormService.readByFlagFourDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int pendingAoc = aocFormService.readBypendingAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int rejectedAoc = aocFormService.readByrejectedAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int unfieldKOM = aocFormService.readByunfieldKOMDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//
//        // ---- KOM ----
        int totalKom = kickOffFormService.countAllKomDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int approvedKom = kickOffFormService.readByFlagoneDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int pendingKom = kickOffFormService.readByPendingKOMDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        int rejectedKom = kickOffFormService.readByFlagThreeDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);

        result.put("totalOap", totalOap);
        result.put("approvedOap", approvedOap);
        result.put("pendingOap", pendingOap);
        result.put("rejctedOap", rejctedOap);
        result.put("unfieldCRC", unfieldCRC);

        result.put("totalCrc", totalCrc);
        result.put("approvedCrc", approvedCrc);
        result.put("pendingCrc", pendingCrc);
        result.put("revisionCrc", revisionCrc);
        result.put("partiallyApprovedCrc", partiallyApprovedCrc);
        result.put("rejectedCrc", rejectedCrc);

        result.put("totalAoc", totalAoc);
        result.put("approvedAoc", approvedAoc);
        result.put("pendingAoc", pendingAoc);
        result.put("rejectedAoc", rejectedAoc);
        result.put("unfieldKOM", unfieldKOM);

        result.put("totalKom", totalKom);
        result.put("approvedKom", approvedKom);
        result.put("pendingKom", pendingKom);
        result.put("rejectedKom", rejectedKom);

        List monthWiseOap;
        if (!Fromdate.isEmpty() || !Todate.isEmpty() || !Filter.isEmpty()) {
            monthWiseOap = oapFormService.readByMontOapDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        } else {
            monthWiseOap = oapFormService.readByMontOap(rollingFromDate());
        }
        result.put("oapMonthly", buildMonthlySeries(monthWiseOap));

        List monthWiseAoc;
        if (!Fromdate.isEmpty() || !Todate.isEmpty() || !Filter.isEmpty()) {
            monthWiseAoc = aocFormService.readByMonthAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
        } else {
            monthWiseAoc = aocFormService.readByMonthAoc(rollingFromDate());
        }
        result.put("aocMonthly", buildMonthlySeries(monthWiseAoc));

//        List projectCoordinatorRows = oapFormService.readByProjectCoordinatorDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//        result.put("projectCoordinator", buildDesignationSeries(projectCoordinatorRows, 6));
//        List projectManagerRows = oapFormService.readByProjectMangerDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate);
//        result.put("projectManager", buildDesignationSeries(projectManagerRows, 4));
        String rollingFrom = rollingFromDate();

//        List oapAnalyticsRows = (!Fromdate.isEmpty() || !Todate.isEmpty() || !Filter.isEmpty()) ? oapFormService.readByMonthWiseAnalyticsDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate) : oapFormService.readByMonthWiseAnalytics(rollingFrom);
//        result.put("oapAnalytics", buildAnalyticsSeries(oapAnalyticsRows));
//        List aocAnalyticsRows = (!Fromdate.isEmpty() || !Todate.isEmpty() || !Filter.isEmpty()) ? aocFormService.readByMonthWiseAnalyticsDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate) : aocFormService.readByMonthWiseAnalytics(rollingFrom);
//        result.put("aocAnalytics", buildAnalyticsSeries(aocAnalyticsRows));
        result.put("bifurcation", buildAllBifurcations(Fromdate, Todate, Filter, formattedDate, formattedStartDate, rollingFrom));

        Map<String, String> appliedFilter = new HashMap<>();
        appliedFilter.put("Fromdate", Fromdate);
        appliedFilter.put("Todate", Todate);
        appliedFilter.put("Filter", Filter);
        result.put("appliedFilter", appliedFilter);

        writeJson(response, result);
        return null;
    }

    private void writeJson(HttpServletResponse response, Object payload) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(new Gson().toJson(payload));
            out.flush();
        }
    }

    private String rollingFromDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -11);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return new SimpleDateFormat("dd/MM/yyyy").format(cal.getTime());
    }

    private Map<String, Object> buildMonthlySeries(List rows) {
        List<String> labels = new ArrayList<>();
        List<String> values = new ArrayList<>();
        List<String> mw = new ArrayList<>();

        int i = 0;
        for (Object o : rows) {
            if (i >= 12) {
                break;
            }
            Object[] r = (Object[]) o;
            values.add(r.length > 0 && r[0] != null ? r[0].toString() : "0");
            labels.add(r.length > 1 && r[1] != null ? r[1].toString() : "");
            mw.add(r.length > 2 && r[2] != null ? r[2].toString() : "0");
            i++;
        }

        Map<String, Object> series = new HashMap<>();
        series.put("labels", labels);
        series.put("values", values);
        series.put("mw", mw);
        return series;
    }

    private Map<String, Object> buildDesignationSeries(List rows, int columns) {
        List<String> labels = new ArrayList<>();
        List<String> total = new ArrayList<>();
        List<String> underApproval = new ArrayList<>();
        List<String> approved = new ArrayList<>();
        List<String> pendingCrc = new ArrayList<>();
        List<String> pendingKom = new ArrayList<>();

        int i = 0;
        for (Object o : rows) {
            if (i >= 10) {
                break;
            }
            Object[] r = (Object[]) o;
            if (r.length < columns) {
                continue;
            }
            labels.add(r[0] != null ? shortLabel(r[0].toString()) : "");
            total.add(r.length > 1 && r[1] != null ? r[1].toString() : "0");
            underApproval.add(r.length > 2 && r[2] != null ? r[2].toString() : "0");
            approved.add(r.length > 3 && r[3] != null ? r[3].toString() : "0");
            if (columns >= 6) {
                pendingCrc.add(r.length > 4 && r[4] != null ? r[4].toString() : "0");
                pendingKom.add(r.length > 5 && r[5] != null ? r[5].toString() : "0");
            }
            i++;
        }

        Map<String, Object> series = new HashMap<>();
        series.put("labels", labels);
        series.put("total", total);
        series.put("underApproval", underApproval);
        series.put("approved", approved);
        if (columns >= 6) {
            series.put("pendingCrc", pendingCrc);
            series.put("pendingKom", pendingKom);
        }
        return series;
    }

    private String shortLabel(String text) {
        String name = text.split("\\.")[0];
        return name.length() > 10 ? name.substring(0, 10) + "..." : name;
    }

    private Map<String, Object> buildAnalyticsSeries(List rows) {
        List<String> labels = new ArrayList<>();
        List<String> noOfCharger = new ArrayList<>();
        List<String> chargerCapacity = new ArrayList<>();
        List<String> kwRating = new ArrayList<>();

        int i = 0;
        for (Object o : rows) {
            if (i >= 12) {
                break;
            }
            Object[] r = (Object[]) o;
            if (r == null || r.length < 6) {
                continue;
            }
            noOfCharger.add(String.valueOf(r[1]));
            chargerCapacity.add(String.valueOf(r[2]));
            kwRating.add(String.valueOf(r[3]));
            labels.add(String.valueOf(r[5]));
            i++;
        }

        Map<String, Object> series = new HashMap<>();
        series.put("labels", labels);
        series.put("noOfCharger", noOfCharger);
        series.put("chargerCapacity", chargerCapacity);
        series.put("kwRating", kwRating);
        return series;
    }

    private Map<String, Object> buildBifurcationChart(List rows) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy", Locale.ENGLISH);

        Map<String, Map<YearMonth, Integer>> byCustomer = new HashMap<>();
        Set<YearMonth> months = new TreeSet<>();

        for (Object o : rows) {
            Object[] row = (Object[]) o;
            String customer = row[0].toString();
            int count = ((Number) row[1]).intValue();
            YearMonth ym = YearMonth.parse(row[2].toString(), formatter);

            months.add(ym);
            byCustomer.computeIfAbsent(customer, k -> new HashMap<>()).put(ym, count);
        }

        List<String> labels = months.stream().map(m -> m.format(formatter)).collect(Collectors.toList());

        List<Map<String, Object>> datasets = new ArrayList<>();
        for (String customer : byCustomer.keySet()) {
            Map<YearMonth, Integer> monthData = byCustomer.get(customer);
            List<Integer> data = new ArrayList<>();
            for (YearMonth m : months) {
                data.add(monthData.getOrDefault(m, 0));
            }
            Map<String, Object> ds = new HashMap<>();
            ds.put("label", customer);
            ds.put("data", data);
            datasets.add(ds);
        }

        Map<String, Object> chart = new HashMap<>();
        chart.put("labels", labels);
        chart.put("datasets", datasets);
        return chart;
    }

    private Map<String, Object> buildAllBifurcations(String Fromdate, String Todate, String Filter, String formattedDate, String formattedStartDate, String rollingFrom) throws Exception {

        boolean filtered = !Fromdate.isEmpty() || !Todate.isEmpty() || !Filter.isEmpty();
        Map<String, Object> out = new HashMap<>();

//        List ethan = filtered
//                ? oapFormService.readByMonthWiseEthanBurificationDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate)
//                : oapFormService.readByMonthWiseEthanBurification(rollingFrom);
//        out.put("ethan", buildBifurcationChart(ethan));
//        List equa = filtered
//                ? oapFormService.readByMonthWiseEquaBurificationDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate)
//                : oapFormService.readByMonthWiseEquaBurification(rollingFrom);
//        out.put("equator", buildBifurcationChart(equa));
//
//        List hub = filtered
//                ? oapFormService.readByMonthWiseHubBurificationDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate)
//                : oapFormService.readByMonthWiseHubBurification(rollingFrom);
//        out.put("hub", buildBifurcationChart(hub));
//
//        List capex = filtered
//                ? oapFormService.readByMonthWiseCapexBurificationDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate)
//                : oapFormService.readByMonthWiseCapexBurification(rollingFrom);
//        out.put("capex", buildBifurcationChart(capex));
//
//        // ---- AOC side ----
//        List ethanAoc = filtered
//                ? aocFormService.readByMonthWiseEthanBurificationAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate)
//                : aocFormService.readByMonthWiseEthanBurificationAoc(rollingFrom);
//        out.put("ethanAoc", buildBifurcationChart(ethanAoc));
//
//        List equaAoc = filtered
//                ? aocFormService.readByMonthWiseEquaBurificationAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate)
//                : aocFormService.readByMonthWiseEquaBurificationAoc(rollingFrom);
//        out.put("equatorAoc", buildBifurcationChart(equaAoc));
//
//        List hubAoc = filtered
//                ? aocFormService.readByMonthWiseHubBurificationAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate)
//                : aocFormService.readByMonthWiseHubBurificationAoc(rollingFrom);
//        out.put("hubAoc", buildBifurcationChart(hubAoc));
//
//        List capexAoc = filtered
//                ? aocFormService.readByMonthWiseCapexBurificationAocDateformate(Fromdate, Todate, Filter, formattedDate, formattedStartDate)
//                : aocFormService.readByMonthWiseCapexBurificationAoc(rollingFrom);
//        out.put("capexAoc", buildBifurcationChart(capexAoc));
        return out;
    }
}
