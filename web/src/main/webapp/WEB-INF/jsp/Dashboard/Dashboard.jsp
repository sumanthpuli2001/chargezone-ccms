<%-- 
    Document   : tenderdashboard.jsp
    Created on : Jul 17, 2025, 4:01:02 PM
    Author     : Sumanth
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <head>
        <title>My DashBoard</title>
        <style>
            
            ul li.active a {
                border-bottom: 2px solid #007bff; 
                font-weight: 600;                 
            }
            .sticky {
    position: sticky;
    top: 0;
}
        </style>
    </head>

    <body>
        <script>
            function viewClick(id) {
            var loginName = $('#loginName' + id).val();
                    window.location = 'approvalSetting.htm?act=viewClick&id=' + loginName;
            }
            function deleteCheck11() {
            var checkboxes = "";
                    checkboxes = document.getElementsByName('checkId');
                    for (var i = 0, n = checkboxes.length; i < n; i++) {
            if (checkboxes[i].checked) {
            return true;
            }
            }
            alert("Please, Select one or more record(s).");
                    return false;
            }
        </script>

        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>            
            
            <section class="main-content dashboard">
                <form:form action="dashboard.htm?act=tenderDashboard" method="post" commandName=""
                           name='form1'  class="form-horizontal" role="form">
                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars"
                                     onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort"
                                     onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">Dashboard</h5>
                        </div>                    
                        <div class="cta d-flex align-items-center" style="gap: 10px;">
                            <li class="search-container" style="margin-left: auto; display: flex; align-items: center;">

                                <button type="button" style="background-color: #00bcd4; color: white;" class="btn theme-btn" data-toggle="modal" data-target="#searchModal">
                                     Filter
                                </button>
                            </li>
                           
                                         
                        </div>
                    </div>
                     <div id="searchModal" class="modal fade" tabindex="-1" role="dialog">
                                <div class="modal-dialog modal-sm" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header d-flex justify-content-between align-items-center">

                                            <h5 class="modal-title">Search</h5>

                                            <div class="ml-auto d-flex align-items-center">
                                                <button type="submit" class="btn theme-btn mr-2" name="btn" value="1">
                                                    Apply
                                                </button>

                                                <a class="btn theme-btn light-btn mr-2" data-dismiss="modal">
                                                    Close
                                                </a>
                                            </div>
                                        </div>

                                        <div class="modal-body">
                                            <div class="form-horizontal">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">From Date :</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" autocomplete="off" name="Fromdate" placeholder="DD-MM-YYYY" id="Fromdate" class="input-field " >
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">To Date :</label>
                                                    <div class="col-sm-9">
                                                        <input type="text" autocomplete="off" name="Todate"  placeholder="DD-MM-YYYY" id="Todate" class="input-field">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="date-filter">Filter By :</label>
                                                    <div class="col-sm-9">
                                                        <select id="date-filter" name="Filter" class="select-input">
                                                            <option value="--select--">--SELECT--</option>
                                                            <option value="last-week">Last-1-Week</option>
                                                            <option value="last-month">Last-1-Month</option>
                                                            <option value="last-6-month">Last-6-Month</option>
                                                            <option value="last-year">Last-1-Year</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label" for="date-Department">Department :</label>
                                                    <div class="col-sm-9">
                                                        <select class="select-input" id="date-Department" name="Department" >
                                                            <option value="--select--">--SELECT--</option>
                                                            <c:forEach var="list" items="${list0}">
                                                                <option value="${list.departmentName}">${list.departmentName}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

<!--                                        <div class="modal-footer">
                                            <button type="submit" class="btn theme-btn" name="btn" value="1">Apply</button>
                                            <a  class="btn theme-btn light-btn mr-3" data-dismiss="modal">Close</a>
                                                                                <button class="btn thead-light mr-2" data-dismiss="modal">Close</button>
                                        </div>-->
                                    </div>
                                </div>
                            </div>

                            <script type="text/javascript">
                                        $(function () {
                                        flatpickr("#Fromdate", {
                                        enableTime: false,
                                                dateFormat: "d-m-Y",
                                                allowInput: true
                                        });
                                                flatpickr("#Todate", {
                                                enableTime: false,
                                                        dateFormat: "d-m-Y",
                                                        allowInput: true
                                                });
                                        });    
                            </script>     
                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0 sticky-model1">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=tenderDashboard" class="tab-link transition-0 active">Dashboard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="oapForm.htm?act=oapAndAocDashboard" class="tab-link transition-0">OAP & AOC DashBoard</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=report" class="tab-link transition-0">PR Register</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=activeVendorDashboard" class="tab-link transition-0">Active Vendor</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=oapTracker" class="tab-link transition-0">OAP Tracker</a>
                            </li>
                            <li class="tab-item mr-2">
                                <a href="dashboard.htm?act=aocTracker" class="tab-link transition-0">AOC Tracker</a>
                            </li>

                        </ul>
                    </div>                    
                            <div class="statistics mt-4 py-2">
                                <div class="row g-3 row-cols-6">
                                    <div class="col">
                                        <c:url var="totalPrLink" value="dashboard.htm">
                                            <c:param name="act" value="totalPr"/>
                                            <c:param name="Fromdate" value="${Fromdate}"/>
                                            <c:param name="Todate" value="${Todate}"/>
                                            <c:param name="Filter" value="${Filter}"/>
                                            <c:param name="Department" value="${Department}"/>
                                        </c:url>
                                        <a href="${totalPrLink}" style="text-decoration: none; color: inherit;">
                                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #e0edf9; border-top: 3px solid #3498db;">
                                                <div class="content">
                                                    <i class="fas fa-file-alt" style="color: #3498db; font-size:25px;"></i>
                                                    <h5 class="mb-1 fw-bold " number>${prRaised}</h5>
                                                    <p class="mb-0 small">Total PR</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>

                                    <div class="col">
                                        <c:url var="underApprovalLink" value="dashboard.htm">
                                            <c:param name="act" value="underApproval"/>
                                            <c:param name="Fromdate" value="${Fromdate}"/>
                                            <c:param name="Todate" value="${Todate}"/>
                                            <c:param name="Filter" value="${Filter}"/>
                                            <c:param name="Department" value="${Department}"/>
                                        </c:url>
                                        <a href="${underApprovalLink}" style="text-decoration: none; color: inherit;">
                                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #bdeec0; border-top: 3px solid #2ecc71;">
                                                <div class="content">
                                                    <i class="fas fa-check-circle" style="color: #2ecc71; font-size:25px;"></i>
                                                    <h5 class="mb-1 fw-bold">${underApproval}</h5>
                                                    <p class="mb-0 small">Under Approval</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="col">
                                        <c:url var="rejectedPrLink" value="dashboard.htm">
                                            <c:param name="act" value="rejectedPr"/>
                                            <c:param name="Fromdate" value="${Fromdate}"/>
                                            <c:param name="Todate" value="${Todate}"/>
                                            <c:param name="Filter" value="${Filter}"/>
                                            <c:param name="Department" value="${Department}"/>
                                        </c:url>
                                        <a href="${rejectedPrLink}" style="text-decoration: none; color: inherit;">
                                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #bbe6ec; border-top: 3px solid #1abc9c;">
                                                <div class="content">
                                                    <i class="fas fa-times-circle" style="color: #1abc9c; font-size:25px;"></i>
                                                    <h5 class="mb-1 fw-bold">${rejectedPr}</h5>
                                                    <p class="mb-0 small">Rejected PR</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="col">
                                        <c:url var="livePrLink" value="dashboard.htm">
                                            <c:param name="act" value="livePr"/>
                                            <c:param name="Fromdate" value="${Fromdate}"/>
                                            <c:param name="Todate" value="${Todate}"/>
                                            <c:param name="Filter" value="${Filter}"/>
                                            <c:param name="Department" value="${Department}"/>
                                        </c:url>
                                        <a href="${livePrLink}" style="text-decoration: none; color: inherit;">
                                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #ffdea9; border-top: 3px solid #e67e22;">
                                                <div class="content">
                                                    <i class="fas fa-bolt" style="color: #e67e22; font-size:25px;"></i>
                                                    <h5 class="mb-1 fw-bold">${livePr}</h5>
                                                    <p class="mb-0 small">Live PR</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="col">
                                        <c:url var="tenderPendingToFloatLink" value="dashboard.htm">
                                            <c:param name="act" value="tenderPendingToFloat"/>
                                            <c:param name="Fromdate" value="${Fromdate}"/>
                                            <c:param name="Todate" value="${Todate}"/>
                                            <c:param name="Filter" value="${Filter}"/>
                                            <c:param name="Department" value="${Department}"/>
                                        </c:url>
                                        <a href="${tenderPendingToFloatLink}" style="text-decoration: none; color: inherit;">
                                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #e3f2fd; border-top: 3px solid #2980b9;">
                                                <div class="content">
                                                    <i class="fas fa-spinner" style="color: #2980b9; font-size:15px;"></i>
                                                    <h5 class="mb-1 fw-bold">${approve}</h5>
                                                    <p class="mb-0 small" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
                                                        Tender Pending to Float
                                                    </p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                    <div class="col">
                                        <c:url var="pendingToAssignLink" value="dashboard.htm">
                                            <c:param name="act" value="pendingToAssign"/>
                                            <c:param name="Fromdate" value="${Fromdate}"/>
                                            <c:param name="Todate" value="${Todate}"/>
                                            <c:param name="Filter" value="${Filter}"/>
                                            <c:param name="Department" value="${Department}"/>
                                        </c:url>
                                        <a href="${pendingToAssignLink}" style="text-decoration: none; color: inherit;">
                                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #fef9e7; border-top: 3px solid #f39c12;">
                                                <div class="content">
                                                    <i class="fas fa-hourglass-half" style="color: #f39c12; font-size:25px;"></i>
                                                    <h5 class="mb-1 fw-bold">${pendassign}</h5>
                                                    <p class="mb-0 small">Pending To Assign</p>
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>


                <div class="row g-3 row-cols-6">

                    <div class="col">
                        <c:url var="assginedToBuyerLink" value="dashboard.htm">
                            <c:param name="act" value="assginedToBuyer"/>
                            <c:param name="Fromdate" value="${Fromdate}"/>
                            <c:param name="Todate" value="${Todate}"/>
                            <c:param name="Filter" value="${Filter}"/>
                            <c:param name="Department" value="${Department}"/>
                        </c:url>
                        <a href="${assginedToBuyerLink}" style="text-decoration: none; color: inherit;">
                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3"  style="background-color: #fde8e9; border-top: 3px solid #e74c3c;">
                                <div class="content">
                                    <i class="fas fa-user-check" style="color: #e74c3c; font-size:25px;"></i>
                                    <h5 class="mb-1 fw-bold">${assbuyer}</h5>
                                    <p class="mb-0 small">Assigned to Buyer</p>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col">
                        <c:url var="tenderCreatedLink" value="dashboard.htm">
                            <c:param name="act" value="tenderCreated"/>
                            <c:param name="Fromdate" value="${Fromdate}"/>
                            <c:param name="Todate" value="${Todate}"/>
                            <c:param name="Filter" value="${Filter}"/>
                            <c:param name="Department" value="${Department}"/>
                        </c:url>
                        <a href="${tenderCreatedLink}" style="text-decoration: none; color: inherit;">
                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #f0d9ff; border-top: 3px solid #9b59b6;">
                                <div class="content">
                                    <i class="fas fa-folder-plus" style="color: #9b59b6; font-size:25px;"></i>
                                    <h5 class="mb-1 fw-bold">${tendercount}</h5>
                                    <p class="mb-0 small">Tender Created</p>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col">
                        <c:url var="liveTenderLink" value="dashboard.htm">
                            <c:param name="act" value="liveTender"/>
                            <c:param name="Fromdate" value="${Fromdate}"/>
                            <c:param name="Todate" value="${Todate}"/>
                            <c:param name="Filter" value="${Filter}"/>
                            <c:param name="Department" value="${Department}"/>
                        </c:url>
                        <a href="${liveTenderLink}" style="text-decoration: none; color: inherit;">
                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #d4f4dd; border-top: 3px solid #2ecc71;">
                                <div class="content">
                                    <i class="fas fa-play-circle" style="color: #2ecc71; font-size:25px;"></i>
                                    <h5 class="mb-1 fw-bold">${tenderLive}</h5>
                                    <p class="mb-0 small">Live Tender</p>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col">
                        <c:url var="tenderClosedLink" value="dashboard.htm">
                            <c:param name="act" value="tenderClosed"/>
                            <c:param name="Fromdate" value="${Fromdate}"/>
                            <c:param name="Todate" value="${Todate}"/>
                            <c:param name="Filter" value="${Filter}"/>
                            <c:param name="Department" value="${Department}"/>
                        </c:url>
                        <a href="${tenderClosedLink}" style="text-decoration: none; color: inherit;">
                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #ffd3b6; border-top: 3px solid #e67e22;">
                                <div class="content">
                                    <i class="fas fa-lock" style="color: #e67e22; font-size:25px;"></i>
                                    <h5 class="mb-1 fw-bold">${tenderclosed}</h5>
                                    <p class="mb-0 small">Tender Closed</p>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col">
                        <c:url var="tenderClosedByForceLink" value="dashboard.htm">
                            <c:param name="act" value="tenderClosedByForce"/>
                            <c:param name="Fromdate" value="${Fromdate}"/>
                            <c:param name="Todate" value="${Todate}"/>
                            <c:param name="Filter" value="${Filter}"/>
                            <c:param name="Department" value="${Department}"/>
                        </c:url>
                        <a href="${tenderClosedByForceLink}" style="text-decoration: none; color: inherit;">
                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #FFB7CE; border-top: 3px solid #e67e22;">
                                <div class="content">
                                    <i class="fas fa-lock" style="color: #e67e22; font-size:25px;"></i>
                                    <h5 class="mb-1 fw-bold">${tenderclosedByForce}</h5>
                                    <p class="mb-0 small" style="white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">Tender Close By Force</p>
                                </div>
                            </div>
                        </a>       
                    </div>
                    <div class="col">
                        <c:url var="closePrLink" value="dashboard.htm">
                            <c:param name="act" value="closePr"/>
                            <c:param name="Fromdate" value="${Fromdate}"/>
                            <c:param name="Todate" value="${Todate}"/>
                            <c:param name="Filter" value="${Filter}"/>
                            <c:param name="Department" value="${Department}"/>
                        </c:url>
                        <a href="${closePrLink}" style="text-decoration: none; color: inherit;">
                            <div class="card-box rounded-3  d-flex align-items-center justify-content-center text-center px-3 py-3" style="background-color: #cddaebff; border-top: 3px solid #e67e22;">
                                <div class="content">
                                    <i class="fas fa-lock" style="color: #e67e22; font-size:25px;"></i>
                                    <h5 class="mb-1 fw-bold">${totalClosePr}</h5>
                                    <p class="mb-0 small">Close PR</p>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
                
                
                
                
                
                    <div class="row mt-4">
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Month Wise PR Data</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="prLineChart"></canvas>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="box-card rounded-2 p-3">
                                <div class="chart-title pb-2 d-flex align-items-center justify-content-between">
                                    <h6 class="fw-600 mb-1">Month Wise Tender Data</h6>
                                </div>
                                <div class="pt-2">
                                    <canvas id="lineChart3"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box-card rounded-2 p-3">
                        <div class="chart-title pb-2">
                            <h6 class="fw-600 mb-1">Tender Status By Person</h6>
                        </div>
                        <div class="pt-2" style="height: 400px;"> <!-- Canvas height fix -->
                            <canvas id="lineChart4"></canvas>
                        </div>
                    </div>
                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp" %>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="StorageYard/assets/js/dashboard.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

    <script>
        // Safely encoded values for use inside JS chart-click links below.
        var deptParam = encodeURIComponent("${Department}");
        var filterParam = encodeURIComponent("${Filter}");
    </script>

    <script>
                                        if ($('#prLineChart').length > 0) {

                                const ctx = document.getElementById('prLineChart').getContext('2d');
                                        // Gradient (same style as upper code)
                                        let gradient = ctx.createLinearGradient(0, 0, 0, 400);
                                        gradient.addColorStop(0, 'rgba(0, 123, 255, 0.4)');
                                        gradient.addColorStop(1, 'rgba(0, 123, 255, 0)');
                                        new Chart(ctx, {
                                        type: 'line',
                                                data: {
                                                labels: [
                                                        '${prmonthName1}', '${prmonthName2}', '${prmonthName3}',
                                                        '${prmonthName4}', '${prmonthName5}', '${prmonthName6}',
                                                        '${prmonthName7}', '${prmonthName8}', '${prmonthName9}',
                                                        '${prmonthName10}', '${prmonthName11}', '${prmonthName12}'
                                                ],
                                                        datasets: [{
                                                        label: 'MONTH WISE PR DATA',
                                                        data: [
                                                                ${prnumberOfValue1}, ${prnumberOfValue2}, ${prnumberOfValue3},
                                                                ${prnumberOfValue4}, ${prnumberOfValue5}, ${prnumberOfValue6},
                                                                ${prnumberOfValue7}, ${prnumberOfValue8}, ${prnumberOfValue9},
                                                                ${prnumberOfValue10}, ${prnumberOfValue11}, ${prnumberOfValue12}
                                                            ],
                                                                fill: true,
                                                                backgroundColor: gradient,
                                                                borderColor: 'rgba(0,123,255,1)',
                                                                borderWidth: 2,
                                                                tension: 0.4,
                                                                pointRadius: 4,
                                                                pointHoverRadius: 6,
                                                                pointBackgroundColor: 'rgba(0,123,255,1)'
                                                        }]
                                                },
                                                options: {
                                                responsive: true,
                                                        plugins: {
                                                        legend: {
                                                        display: true,
                                                                labels: { color: '#333' }
                                                        },
                                                                tooltip: {
                                                                enabled: true,
                                                                        mode: 'nearest',
                                                                        intersect: false
                                                                }
                                                        },
                                                        scales: {
                                                        x: {
                                                        ticks: { color: '#333' }
                                                        },
                                                                y: {
                                                                beginAtZero: true
                                                                }
                                                        },
                                                        onClick: function (event, elements) {
                                                        if (elements.length > 0) {
                                                        const index = elements[0].index;
                                                                const links = [
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName1}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName2}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName3}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName4}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName5}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName6}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName7}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName8}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName9}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName10}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName11}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                        "dashboard.htm?act=monthWisePr&label=${prmonthName12}&Filter=" + filterParam + "&Department=" + deptParam
                                                                ];
                                                                window.location.href = links[index];
                                                        }
                                                        }
                                                }
                                        });
                                }
                                </script>
                                <script>
                                                    if ($('#lineChart3').length > 0) {

                                                    const ctx = document.getElementById('lineChart3').getContext('2d');
                                                            // gradient (same as upper chart)
                                                            let gradient = ctx.createLinearGradient(0, 0, 0, 400);
                                                            gradient.addColorStop(0, 'rgba(52, 152, 219, 0.45)');
                                                            gradient.addColorStop(1, 'rgba(52, 152, 219, 0)');
                                                            new Chart(ctx, {
                                                            type: 'line',
                                                                    data: {
                                                                    labels: [
                                                                            '${monthName1}', '${monthName2}', '${monthName3}',
                                                                            '${monthName4}', '${monthName5}', '${monthName6}',
                                                                            '${monthName7}', '${monthName8}', '${monthName9}',
                                                                            '${monthName10}', '${monthName11}', '${monthName12}'
                                                                    ],
                                                                            datasets: [{
                                                                            label: 'MONTH WISE TENDER DATA',
                                                                            data: [
                                                                            ${numberOfValue1}, ${numberOfValue2}, ${numberOfValue3},
                                                                            ${numberOfValue4}, ${numberOfValue5}, ${numberOfValue6},
                                                                            ${numberOfValue7}, ${numberOfValue8}, ${numberOfValue9},
                                                                            ${numberOfValue10}, ${numberOfValue11}, ${numberOfValue12}
                                                                                ],
                                                                                    fill: true,
                                                                                    backgroundColor: gradient,
                                                                                    borderColor: '#3498db',
                                                                                    borderWidth: 2,
                                                                                    tension: 0.4,
                                                                                    pointRadius: 4,
                                                                                    pointHoverRadius: 6,
                                                                                    pointBackgroundColor: '#3498db'
                                                                            }]
                                                                    },
                                                                    options: {
                                                                    responsive: true,
                                                                            plugins: {
                                                                            legend: {
                                                                            display: true,
                                                                                    labels: { color: '#333' }
                                                                            }
                                                                            },
                                                                            scales: {
                                                                            y: { beginAtZero: true },
                                                                                    x: { ticks: { color: '#333' } }
                                                                            },
                                                                            // click navigation (same logic as barChart3)
                                                                            onClick: function (evt, elements) {
                                                                            if (elements.length > 0) {
                                                                            const i = elements[0].index;
                                                                                    const links = [
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName1}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName2}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName3}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName4}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName5}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName6}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName7}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName8}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName9}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName10}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName11}&Filter=" + filterParam + "&Department=" + deptParam,
                                                                                            "dashboard.htm?act=monthWiseTender&label=${monthName12}&Filter=" + filterParam + "&Department=" + deptParam
                                                                                    ];
                                                                                    window.location.href = links[i];
                                                                            }
                                                                            }
                                                                    }
                                                            });
                                                    }
                </script>
                <script>
                        const ctx = document.getElementById('lineChart4').getContext('2d');

                        const colors = {
                            total: '#FF6384',
                            live: '#36A2EB',
                            close: '#FFCE56'
                        };

                        var lineChart4Data = {
                                labels: [
                                    '${firstElement1_1}', '${secondElement1_1}', '${thirdElement1_1}',
                                    '${fourthElement1_1}', '${fifthElement1_1}', '${sixthElement1_1}',
                                    '${seventhElement1_1}', '${eighthElement1_1}', '${ninthElement1_1}', '${tenthElement1_1}'
                                ],
                                datasets: [
                                    {
                                        label: 'Total Tender',
                                        data: [${firstElement1_2}, ${secondElement1_2}, ${thirdElement1_2}, ${fourthElement1_2}, ${fifthElement1_2}, ${sixthElement1_2}, ${seventhElement1_2}, ${eighthElement1_2}, ${ninthElement1_2}, ${tenthElement1_2}],
                                        backgroundColor: colors.total,
                                        borderColor: colors.total,
                                        borderWidth: 1,
                                        borderRadius: 6
                                    },
                                    {
                                        label: 'Live Tender',
                                        data: [${firstElement1_3}, ${secondElement1_3}, ${thirdElement1_3}, ${fourthElement1_3}, ${fifthElement1_3}, ${sixthElement1_3}, ${seventhElement1_3}, ${eighthElement1_3}, ${ninthElement1_3}, ${tenthElement1_3}],
                                        backgroundColor: colors.live,
                                        borderColor: colors.live,
                                        borderWidth: 1,
                                        borderRadius: 6
                                    },
                                    {
                                        label: 'Close Tender',
                                        data: [${firstElement1_4}, ${secondElement1_4}, ${thirdElement1_4}, ${fourthElement1_4}, ${fifthElement1_4}, ${sixthElement1_4}, ${seventhElement1_4}, ${eighthElement1_4}, ${ninthElement1_4}, ${tenthElement1_4}],
                                        backgroundColor: colors.close,
                                        borderColor: colors.close,
                                        borderWidth: 1,
                                        borderRadius: 6
                                    }
                                ]
                            };

                        new Chart(ctx, {
                            type: 'bar',
                            data: lineChart4Data,
                                options: {
                                responsive: true,
                                maintainAspectRatio: false,
                                plugins: {
                                    legend: { 
                                        display: true, 
                                        labels: { color: '#333', font: { size: 12 } } 
                                    },
                                    tooltip: { enabled: true }
                                },
                                scales: {
                                    x: {
                                        ticks: { color: '#333' },
                                        grid: { display: false }
                                    },
                                    y: {
                                        beginAtZero: true,
                                        ticks: { color: '#333' },
                                        grid: {
                                            color: 'rgba(0,0,0,0.1)',
                                            borderDash: [4, 2]
                                        }
                                    }
                                },
                                onClick: function(evt, elements) {

                                    if (elements.length > 0) {

                                        const clickedElementIndex = elements[0].index;
                                        const datasetIndex = elements[0].datasetIndex;

                                        var links = {

                                            0: [
                                                "dashboard.htm?act=contectPersonTender&contact=${firstElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${secondElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${thirdElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${fourthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${fifthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${sixthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${seventhElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${eighthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${ninthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${tenthElement1_1}&Value=zero&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam
                                            ],

                                            1: [
                                                "dashboard.htm?act=contectPersonTender&contact=${firstElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${secondElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${thirdElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${fourthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${fifthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${sixthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${seventhElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${eighthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${ninthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${tenthElement1_1}&Value=One&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam
                                            ],

                                            2: [
                                                "dashboard.htm?act=contectPersonTender&contact=${firstElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${secondElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${thirdElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${fourthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${fifthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${sixthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${seventhElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${eighthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${ninthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam,
                                                "dashboard.htm?act=contectPersonTender&contact=${tenthElement1_1}&Value=Two&Fromdate=${Fromdate}&Todate=${Todate}&Filter=" + filterParam + "&Department=" + deptParam
                                            ]
                                        };
                                        if (links[datasetIndex] && links[datasetIndex][clickedElementIndex]) {
                                            window.location.href = links[datasetIndex][clickedElementIndex];
                                        } else {
                                            console.error("No link found for the clicked element.");
                                        }
                                    }
                                }
                            }
                        });
            </script>

</html>