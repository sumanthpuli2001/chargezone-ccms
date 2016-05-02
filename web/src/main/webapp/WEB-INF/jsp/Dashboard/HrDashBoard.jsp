<!DOCTYPE html>
<html>
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>

        <script type = "text/javascript" >
            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Department', 'No Of Employees'],
            ${departmentWiseEmp}
//                    ['Information Technology', 5],
//                    ['Purchase', 10],
//                    ['Account', 25],
//                    ['Management', 35]
                ]);

                var options = {
                    legend: 'none',
                    pieSliceText: 'label',
                    title: '',
                    pieStartAngle: 100,
                    chartArea: {left: 20, top: 6, width: 250, height: 250},
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                chart.draw(data, options);
            }
        </script>
        <script type = "text/javascript" >
            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Task', 'Hours per Day'],
            ${dailyAttendanceResult}
                ]);

                var options = {
                    legend: 'none',
                    pieSliceText: 'label',
                    title: '',
                    pieStartAngle: 100,
                    chartArea: {left: 20, top: 6, width: 250, height: 250},
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart'));
                chart.draw(data, options);
            }
        </script>
        <!--        <script type="text/javascript">
                    google.load("visualization", "1", {packages: ["corechart"]});
                    google.setOnLoadCallback(drawChart);
                    function drawChart() {

                        var data = google.visualization.arrayToDataTable([
                            ['Task', 'Hours per Day'],
                            ['Presence', 11],
                            ['Absence', 2],
                            ['Approved Leave', 2],
                        ]);

                        var options = {
                            title: ''
                        };

                        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                        chart.draw(data, options);
                    }
                </script>-->

        <script type = "text/javascript">
            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Department', 'No Of Employee'],
            ${locationWiseEmployee}
                ]);

                var options = {
                    legend: 'none',
                    pieSliceText: 'label',
                    title: '',
                    pieStartAngle: 100,
                    chartArea: {left: 20, top: 6, width: 250, height: 250},
                };

                var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
                chart.draw(data, options);
            }
        </script>

        <script type="text/javascript">
            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Department', 'Resignation'],
                    ['Information Technology', 5],
                    ['Purchase', 2],
                    ['Account', 5],
                    ['Management', 4]
                ]);

                var options = {title: '',
                    pieHole: 0.4,
                    chartArea: {left: 20, top: 6, width: 250, height: 250},
                };

                var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Status', ''],
            ${expenseReportString}

                ]);

                var options = {
                    legend: 'none',
                    pieSliceText: 'label', title: '',
                    pieStartAngle: 100,
                    chartArea: {left: 20, top: 6, width: 250, height: 250},
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart11'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Status', ''],
            ${probationToCinfirmationReportString}

                ]);

                var options = {
                    legend: 'none',
                    pieSliceText: 'label',
                    title: '',
                    pieStartAngle: 100,
                    chartArea: {left: 20, top: 6, width: 250, height: 250},
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart22'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Department', 'Resignation'],
            ${departmentWiseResignedEmployee}


                ]);

                var options = {
                    legend: 'none',
                    pieSliceText: 'label',
                    title: '',
                    pieStartAngle: 100,
                    chartArea: {left: 20, top: 6, width: 250, height: 250},
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart33'));
                chart.draw(data, options);
            }
        </script>
        <script>
            google.load("visualization", "1", {packages: ["corechart"]});
            google.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                    ['Genre', 'Fantasy & Sci Fi', 'Romance', 'Mystery/Crime', 'General',
                        'Western', 'Literature', {role: 'annotation'}],
                    ['2010', 10, 24, 20, 32, 18, 5, ''],
                    ['2020', 16, 22, 23, 30, 16, 9, ''],
                    ['2030', 28, 19, 29, 30, 12, 13, '']
                ]);

                var options = {
                    width: 600,
                    height: 400,
                    legend: {position: 'top', maxLines: 3},
                    bar: {groupWidth: '75%'},
                    isStacked: true,
                    chartArea: {left: 20, top: 6, width: 250, height: 250},
                };
                var chart = new google.visualization.PieChart(document.getElementById('barChart'));
                chart.draw(data, options);
            }
        </script>
        <script>
            function buttonFun1() {
                var className = $('#minusId1').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId1').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId1').innerHTML = 'Expand';
                }
            }
            function buttonFun2() {
                var className = $('#minusId2').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId2').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId2').innerHTML = 'Expand';
                }
            }
            function buttonFun3() {
                var className = $('#minusId3').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId3').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId3').innerHTML = 'Expand';
                }
            }
        </script>
        <script>
            function viewEmployeeDetail(employeeId, userId) {
                window.location = "employeeMaster.htm?act=getUserDetail&id=" + employeeId + "&userid=" + userId;
            }
        </script>



        <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Dashboard</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dashboard</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <!--                                <ul class="nav nav-tabs">
                                                            <li class="active"><a id="tab1" href="#tab_1" data-toggle="tab">Employee</a></li>
                                                            <li><a id="tab2" href="#tab_2" data-toggle="tab">HR</a></li>
                                                            <li><a href="#tab_3" data-toggle="tab">Contract</a></li>
                                                        </ul>-->
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="">
                                            <div class="box-header">
                                                <!--<h3 class="box-title">Employee Summary</h3>-->
                                                <div class="box-tools pull-right">
                                                    <!--                                                            <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                                                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>-->
                                                </div>
                                            </div>
                                            <div class="box-body">
                                                <div class="row">

                                                    <div class="col-md-4">
                                                        <!-- Nature of Business Pane -->
                                                        <div class="box box-warning">
                                                            <div class="box-header">
                                                                <h3 class="box-title">Department Wise Employee</h3>
                                                                <div class="box-tools pull-right">
                                                                    <button class="btn btn-box-tool" data-widget="collapse" ><i class="fa fa-minus" id="minusId1"></i></button>                                                                </div>
                                                            </div><!-- /.box-header -->
                                                            <div class="box-body">
                                                                <div class="pull-left" id="piechart_3d" style="width: 300px; height: 300px;"></div>
                                                            </div>
                                                            <!--                                                                    <div class="box-footer text-center">
                                                                                                                                </div> /.box-footer -->
                                                        </div><!-- /.box -->
                                                    </div><!-- /.col -->
                                                    <div class="col-md-4">
                                                        <!-- Nature of Business Pane -->
                                                        <div class="box box-success">
                                                            <div class="box-header">
                                                                <h3 class="box-title">Employee Daily Attendance</h3>
                                                                <div class="box-tools pull-right">
                                                                    <button class="btn btn-box-tool" data-widget="collapse" ><i class="fa fa-minus" id="minusId2"></i></button>

                                                                </div>
                                                            </div><!-- /.box-header -->
                                                            <div class="box-body" id="piechartId">
                                                                <div id="piechart" style="width: 300px; height:300px;"></div>
                                                            </div>
                                                        </div><!-- /.box-body -->
                                                        <!--                                                    <div class="box-footer text-center">
                                                                                                                <a href="javascript::" class="uppercase">View All Business Areas</a>
                                                                                                            </div> /.box-footer -->
                                                    </div><!-- /.box -->

                                                    <div class="col-md-4">
                                                        <!-- USERS LIST -->
                                                        <div class="box box-danger">
                                                            <div class="box-header">
                                                                <!--<h3 class="box-title">My Subordinates</h3>-->
                                                                <h3 class="box-title">Organization Chart</h3>
                                                                <div class="box-tools pull-right">
                                                                    <button class="btn btn-box-tool" data-widget="collapse">
                                                                        <i class="fa fa-minus"></i>
                                                                    </button>
                                                                </div>
                                                            </div><!-- /.box-header -->
                                                            <div class="box-body no-padding">
                                                                <div class="jOrgChart" style="text-align: center">
                                                                    <c:if test="${employeeMasterManager ne null}">

                                                                        <table cellpadding="0" cellspacing="0" border="0" style="margin: auto;">
                                                                            <tbody>
                                                                                <!--                                                            <tr class="node-cells">
                                                                                                                                                <td class="node-cell" colspan="4">
                                                                                                                                                    <div class="node fruit ui-draggable ui-droppable" style="cursor: n-resize;">

                                                                                                                                                    </div>
                                                                                                                                                </td>
                                                                                                                                            </tr>-->
                                                                                <tr>

                                                                                    <td class="node-container" colspan="2">
                                                                                        <c:if test="${subordinateCount eq 0}">
                                                                                            <table cellpadding="0" cellspacing="0" border="0">
                                                                                            </c:if>
                                                                                            <c:if test="${subordinateCount <= 1 && subordinateCount ne 0}">
                                                                                                <table cellpadding="0" cellspacing="0" border="0" width="105px">
                                                                                                </c:if>
                                                                                                <c:if test="${subordinateCount == 2}">
                                                                                                    <!--<table cellpadding="0" cellspacing="0" border="0" width="130px">-->
                                                                                                    <table cellpadding="0" cellspacing="0" border="0" width="200px">

                                                                                                    </c:if>
                                                                                                    <c:if test="${subordinateCount == 3}">
                                                                                                        <!--<table cellpadding="0" cellspacing="0" border="0" width="195px">-->
                                                                                                        <table cellpadding="0" cellspacing="0" border="0" width="310px">

                                                                                                        </c:if>
                                                                                                        <c:if test="${subordinateCount == 4}">
                                                                                                            <!--<table cellpadding="0" cellspacing="0" border="0" width="260px">-->
                                                                                                            <table cellpadding="0" cellspacing="0" border="0" width="315px">
                                                                                                            </c:if>
                                                                                                            <tbody>
                                                                                                                <tr class="node-cells">
                                                                                                                    <!--<td class="node-cell" colspan="8" onclick="viewEmployeeDetail();">-->
                                                                                                                    <td class="node-cell" colspan="8">
                                                                                                                        <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${employeeMasterManager.employeeName} &#13; Department: ${employeeMasterManager.departmentMaster.departmentName} &#13; Designation: ${employeeMasterManager.designationMaster.designationName}">
                                                                                                                            <img src="${imageManager}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                            <span class="box-title" style="font-size: 105%;color: black">${employeeMasterManager.employeeName}</span>
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                </tr>
                                                                                                            </tbody>
                                                                                                        </table>
                                                                                                        </td>
                                                                                                        </tr>
                                                                                                    </c:if>




                                                                                                    <tr>
                                                                                                        <!--<td class="line left">&nbsp;</td>-->
                                                                                                        <!--<td class="line ">&nbsp;</td>-->
                                                                                                        <!--<td class="line ">&nbsp;</td>-->
                                                                                                        <!--<td class="line ">&nbsp;</td>-->
                                                                                                        <!--<td class="line ">&nbsp;</td>-->
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>

                                                                                                        <td class="node-container" colspan="2">
                                                                                                            <table cellpadding="0" cellspacing="0" border="0" style="margin: auto;">
                                                                                                                <tbody>
                                                                                                                    <tr class="node-cells">
                                                                                                                        <!--<td class="node-cell"  colspan="8" onclick="viewEmployeeDetail(${employeeMaster.id},${employeeMaster.userMaster.id});">-->
                                                                                                                        <td class="node-cell"  colspan="8">
                                                                                                                            <div class="node ui-draggable ui-droppable" style="cursor: pointer;"  title=" Name: ${employeeMaster.employeeName} &#13; Department: ${employeeMaster.departmentMaster.departmentName} &#13; Designation: ${employeeMaster.designationMaster.designationName}">
                                                                                                                                <img src="${imageUser}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                <span class="box-title" style="font-size: 105%;color: black">${employeeMaster.employeeName}</span>
                                                                                                                            </div>
                                                                                                                        </td>
                                                                                                                    </tr>
                                                                                                                    <c:if test="${subordinateCount > 0}">

                                                                                                                        <tr>
                                                                                                                            <td colspan="8">
                                                                                                                                <!--<div class="line down"></div>-->
                                                                                                                                <c:if test="${subordinateCount eq 1}">
                                                                                                                                    <div>&nbsp;</div>

                                                                                                                                </c:if>

                                                                                                                            </td>
                                                                                                                        </tr>
                                                                                                                        <tr>
                                                                                                                            <c:if test="${subordinateCount >= 1}">
                                                                                                                                <c:if test="${subordinateCount >= 2}">
                                                                                                                                    <!--<td class="line left">&nbsp;</td>-->
                                                                                                                                    <!--<td class="line right top">&nbsp;</td>-->
                                                                                                                                    <td>&nbsp;</td>
                                                                                                                                    <td>&nbsp;</td>
                                                                                                                                </c:if>
                                                                                                                                <c:if test="${subordinateCount >= 3 }">
                                                                                                                                    <!--                                                                                                                                <td class="line left top">&nbsp;</td>
                                                                                                                                                                                                        <td class="line right top">&nbsp;</td>-->
                                                                                                                                    <td>&nbsp;</td>
                                                                                                                                    <td>&nbsp;</td>
                                                                                                                                </c:if>

                                                                                                                                <c:if test="${subordinateCount >= 4}">
                                                                                                                                    <!--<td class="line left top">&nbsp;</td>-->
                                                                                                                                    <!--<td class="line right top">&nbsp;</td>-->
                                                                                                                                    <td>&nbsp;</td>
                                                                                                                                    <td>&nbsp;</td>
                                                                                                                                </c:if>
                                                                                                                                <c:if test="${subordinateCount >= 2}">
                                                                                                                                    <!--<td class="line left top">&nbsp;</td>-->
                                                                                                                                    <!--<td class="line right">&nbsp;</td>-->
                                                                                                                                    <td>&nbsp;</td>
                                                                                                                                    <td>&nbsp;</td>
                                                                                                                                </c:if>
                                                                                                                            </c:if>
                                                                                                                        </tr>
                                                                                                                        <tr>
                                                                                                                            <c:if test="${subordinateCount >= 1}">
                                                                                                                                <td class="node-container" colspan="2">
                                                                                                                                    <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                                        <tbody>
                                                                                                                                            <tr class="node-cells">
                                                                                                                                                <!--<td class="node-cell" style="width: 100px"  colspan="2" onclick="viewEmployeeDetail(${subordinateList[0][0]},${subordinateList[0][6]});">-->
                                                                                                                                                <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                                    <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${subordinateList[0][2]} &#13; Department: ${subordinateList[0][3]} &#13; Designation: ${subordinateList[0][4]}">
                                                                                                                                                        <img src="${subordinateList[0][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                                        <span class="box-title" style="font-size: 105%;color: black">${subordinateList[0][2]}</span>

                                                                                                                                                    </div>
                                                                                                                                                </td></tr>
                                                                                                                                        </tbody>
                                                                                                                                    </table>
                                                                                                                                </td>
                                                                                                                            </c:if>
                                                                                                                            <c:if test="${subordinateCount >= 2}">
                                                                                                                                <td class="node-container" colspan="2">
                                                                                                                                    <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                                        <tbody>
                                                                                                                                            <tr class="node-cells">
                                                                                                                                                <!--<td class="node-cell" style="width: 100px"  colspan="2" onclick="viewEmployeeDetail(${subordinateList[1][0]},${subordinateList[1][6]});">-->
                                                                                                                                                <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                                    <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${subordinateList[1][2]} &#13; Department: ${subordinateList[1][3]} &#13; Designation: ${subordinateList[1][4]}">
                                                                                                                                                        <img src="${subordinateList[1][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                                        <span class="box-title" style="font-size: 105%;color: black">${subordinateList[1][2]}</span>

                                                                                                                                                    </div>
                                                                                                                                                </td>
                                                                                                                                            </tr>
                                                                                                                                        </tbody>
                                                                                                                                    </table>
                                                                                                                                </td>
                                                                                                                            </c:if>
                                                                                                                            <c:if test="${subordinateCount >= 3}">
                                                                                                                                <td class="node-container" colspan="2">
                                                                                                                                    <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                                        <tbody>
                                                                                                                                            <tr class="node-cells">
                                                                                                                                                <!--<td class="node-cell" style="width: 100px"  colspan="2" onclick="viewEmployeeDetail(${subordinateList[2][0]},${subordinateList[2][6]});">-->
                                                                                                                                                <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                                    <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${subordinateList[2][2]} &#13; Department: ${subordinateList[2][3]} &#13; Designation: ${subordinateList[2][4]}">
                                                                                                                                                        <img src="${subordinateList[2][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                                        <span class="box-title" style="font-size: 105%;color: black">${subordinateList[2][2]}</span>

                                                                                                                                                    </div>
                                                                                                                                                </td>
                                                                                                                                            </tr>
                                                                                                                                        </tbody>
                                                                                                                                    </table>
                                                                                                                                </td>
                                                                                                                            </c:if>
                                                                                                                            <c:if test="${subordinateCount >= 4}">
                                                                                                                                <td class="node-container" colspan="2">
                                                                                                                                    <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                                        <tbody>
                                                                                                                                            <tr class="node-cells">
                                                                                                                                                <!--<td class="node-cell" style="width: 100px"  colspan="2" onclick="viewEmployeeDetail(${subordinateList[3][0]},${subordinateList[3][6]});">-->
                                                                                                                                                <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                                    <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${subordinateList[3][2]} &#13; Department: ${subordinateList[3][3]} &#13; Designation: ${subordinateList[3][4]}">
                                                                                                                                                        <img src="${subordinateList[3][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                                        <span class="box-title" style="font-size: 105%;color: black">${subordinateList[3][2]}</span>
                                                                                                                                                    </div>
                                                                                                                                                </td>
                                                                                                                                            </tr>
                                                                                                                                        </tbody>
                                                                                                                                    </table>
                                                                                                                                </td>
                                                                                                                            </c:if>
                                                                                                                        </tr>
                                                                                                                    </c:if>

                                                                                                                </tbody>
                                                                                                            </table>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <c:if test="${employeeMasterManager ne null}">


                                                                                                        </tbody>
                                                                                                    </table>
                                                                                                </c:if>
                                                                                                </div>
                                                                                                <!--                                                                                            <div class="jOrgChart">
                                                                                                                                                                                                <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                                                                                                    <tbody>

                                                                                                <%--<c:if test="${subordinateAddiCount > 0}">--%>

                                                                                                    <tr>
                                                                                                        <td colspan="8">
                                                                                                            <div class="line down"></div>
                                                                                                        </td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                <%--<c:if test="${subordinateAddiCount >= 1}">--%>
                                                                                                <%--<c:if test="${subordinateAddiCount >= 2}">--%>
                                                                                                    <td class="line left">&nbsp;</td>
                                                                                                    <td class="line right top">&nbsp;</td>
                                                                                                <%--</c:if>--%>
                                                                                                <%--<c:if test="${subordinateAddiCount >= 3 }">--%>
                                                                                                    <td class="line left top">&nbsp;</td>
                                                                                                    <td class="line right top">&nbsp;</td>
                                                                                                <%--</c:if>--%>

                                                                                                <%--<c:if test="${subordinateAddiCount >= 4}">--%>
                                                                                                    <td class="line left top">&nbsp;</td>
                                                                                                    <td class="line right top">&nbsp;</td>
                                                                                                <%--</c:if>--%>
                                                                                                <%--<c:if test="${subordinateAddiCount >= 2}">--%>
                                                                                                    <td class="line left top">&nbsp;</td>
                                                                                                    <td class="line right">&nbsp;</td>
                                                                                                <%--</c:if>--%>
                                                                                                <%--</c:if>--%>
                                                                                            </tr>
                                                                                            <tr>
                                                                                                <%--<c:if test="${subordinateAddiCount >= 1}">--%>
                                                                                                    <td class="node-container" colspan="2">
                                                                                                        <table cellpadding="0" cellspacing="0" border="0">
                                                                                                            <tbody>
                                                                                                                <tr class="node-cells">
                                                                                                                    <td class="node-cell" colspan="2" onclick="viewEmployeeDetail(${subordinateList[4][0]},${subordinateList[4][6]});">
                                                                                                                        <div class="node ui-draggable ui-droppable" title=" Name: ${subordinateList[4][2]} &#13; Department: ${subordinateList[4][3]} &#13; Designation: ${subordinateList[4][4]}">
                                                                                                                            <img src="${subordinateList[4][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">

                                                                                                                        </div>
                                                                                                                    </td></tr>
                                                                                                            </tbody>
                                                                                                        </table>
                                                                                                    </td>
                                                                                                <%--</c:if>--%>
                                                                                                <%--<c:if test="${subordinateAddiCount >= 2}">--%>
                                                                                                    <td class="node-container" colspan="2">
                                                                                                        <table cellpadding="0" cellspacing="0" border="0">
                                                                                                            <tbody>
                                                                                                                <tr class="node-cells">
                                                                                                                    <td class="node-cell" colspan="2" onclick="viewEmployeeDetail(${subordinateList[5][0]},${subordinateList[5][6]});">
                                                                                                                        <div class="node ui-draggable ui-droppable" title=" Name: ${subordinateList[5][2]} &#13; Department: ${subordinateList[5][3]} &#13; Designation: ${subordinateList[5][4]}">
                                                                                                                            <img src="${subordinateList[5][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                </tr>
                                                                                                            </tbody>
                                                                                                        </table>
                                                                                                    </td>
                                                                                                <%--</c:if>--%>
                                                                                                <%--<c:if test="${subordinateAddiCount >= 3}">--%>
                                                                                                    <td class="node-container" colspan="2">
                                                                                                        <table cellpadding="0" cellspacing="0" border="0">
                                                                                                            <tbody>
                                                                                                                <tr class="node-cells">
                                                                                                                    <td class="node-cell" colspan="2" onclick="viewEmployeeDetail(${subordinateList[6][0]},${subordinateList[6][6]});">
                                                                                                                        <div class="node ui-draggable ui-droppable" title=" Name: ${subordinateList[6][2]} &#13; Department: ${subordinateList[6][3]} &#13; Designation: ${subordinateList[6][4]}">
                                                                                                                            <img src="${subordinateList[6][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                </tr>
                                                                                                            </tbody>
                                                                                                        </table>
                                                                                                    </td>
                                                                                                <%--</c:if>--%>
                                                                                                <%--<c:if test="${subordinateAddiCount >= 4}">--%>
                                                                                                    <td class="node-container" colspan="2">
                                                                                                        <table cellpadding="0" cellspacing="0" border="0">
                                                                                                            <tbody>
                                                                                                                <tr class="node-cells">
                                                                                                                    <td class="node-cell" colspan="2" onclick="viewEmployeeDetail(${subordinateList[7][0]},${subordinateList[7][6]});">
                                                                                                                        <div class="node ui-draggable ui-droppable" title=" Name: ${subordinateList[7][2]} &#13; Department: ${subordinateList[7][3]} &#13; Designation: ${subordinateList[7][4]}">
                                                                                                                            <img src="${subordinateList[7][5]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                        </div>
                                                                                                                    </td>
                                                                                                                </tr>
                                                                                                            </tbody>
                                                                                                        </table>
                                                                                                    </td>
                                                                                                <%--</c:if>--%>
                                                                                            </tr>
                                                                                                <%--</c:if>--%>
                                                                                            </tbody>
                                                                                        </table>
                                                                                    </div>-->






                                                                                                </div><!-- /.box-body -->
                                                                                                <div class="box-footer text-center">
                                                                                                    <a href="employeeMaster.htm?act=viewAllSubordinate" class="uppercase">View All Employees</a>
                                                                                                </div><!-- /.box-footer -->
                                                                                                </div><!--/.box -->
                                                                                                </div>
                                                                                                <!-- /.col -->
                                                                                                </div><!-- /.col -->
                                                                                                <!--                                                            <div class="col-md-8">
                                                                                                                                                                <div class="chart">
                                                                                                                                                                    <canvas id="barchart"></canvas>
                                                                                                                                                                </div> /.chart-responsive
                                                                                                                                                            </div> /.col -->

                                                                                                </div><!-- /.row -->
                                                                                                </div><!-- ./box-body -->
                                                                                                <!--                                                    <div class="box-footer">
                                                                                                                                                        <div class="row">
                                                                                                                                                            <div class="col-sm-3 col-xs-6">
                                                                                                                                                                <div class="description-block border-right">
                                                                                                                                                                    <h5 class="description-header">54 Employee</h5>
                                                                                                                                                                    <span class="description-text">in UAE</span>
                                                                                                                                                                </div> /.description-block
                                                                                                                                                            </div> /.col
                                                                                                                                                            <div class="col-sm-3 col-xs-6">
                                                                                                                                                                <div class="description-block border-right">
                                                                                                                                                                    <h5 class="description-header">13 Employee</h5>
                                                                                                                                                                    <span class="description-text">in USA</span>
                                                                                                                                                                </div> /.description-block
                                                                                                                                                            </div> /.col
                                                                                                                                                            <div class="col-sm-3 col-xs-6">
                                                                                                                                                                <div class="description-block border-right">
                                                                                                                                                                    <h5 class="description-header">12 Employee</h5>
                                                                                                                                                                    <span class="description-text">in India</span>
                                                                                                                                                                </div> /.description-block
                                                                                                                                                            </div> /.col
                                                                                                                                                            <div class="col-sm-3 col-xs-6">
                                                                                                                                                                <div class="description-block">
                                                                                                                                                                    <h5 class="description-header">06 Employee</h5>
                                                                                                                                                                    <span class="description-text">Germany</span>
                                                                                                                                                                </div> /.description-block
                                                                                                                                                            </div>
                                                                                                                                                        </div> /.row
                                                                                                                                                    </div> /.box-footer -->
                                                                                                </div><!-- /.box -->
                                                                                                </div><!-- /.col -->
                                                                                                <div class="row">

                                                                                                    <div class="col-md-4">
                                                                                                        <!-- USERS LIST -->
                                                                                                        <div class="box box-danger">
                                                                                                            <div class="box-header">
                                                                                                                <h3 class="box-title">Location Wise Employees</h3>
                                                                                                                <div class="box-tools pull-right">
                                                                                                                    <button class="btn btn-box-tool" data-widget="collapse">
                                                                                                                        <i class="fa fa-minus"></i>
                                                                                                                    </button>
                                                                                                                </div>
                                                                                                            </div><!-- /.box-header -->
                                                                                                            <div class="box-body" id="chart_divId">
                                                                                                                <div id="chart_div" style="width: 300px; height: 300px;"></div>
                                                                                                            </div>

                                                                                                            <!--                                        <div class="box-footer text-center">
                                                                                                                                                        <a href="Hierarchy.jsp" class="uppercase">View Department WIse</a>
                                                                                                                                                    </div> /.box-footer -->
                                                                                                        </div><!--/.box -->
                                                                                                    </div>

                                                                                                    <div class="col-md-4">
                                                                                                        <!-- Nature of Business Pane -->
                                                                                                        <div class="box box-primary">
                                                                                                            <div class="box-header">
                                                                                                                <h3 class="box-title">Performance Management stage wise</h3>
                                                                                                                <div class="box-tools pull-right">
                                                                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                                                                </div>
                                                                                                            </div><!-- /.box-header -->
                                                                                                            <div class="box-body">
                                                                                                                <ul class="products-list product-list-in-box">
                                                                                                                    <li class="">
                                                                                                                        <div class="progress-group" style="padding-bottom: 15px;">
                                                                                                                            <span class="progress-text">KRA Setting By Employee</span>
                                                                                                                            <span class="progress-number"><b>${performanceManagementStage[1]}</b>/${performanceManagementStage[0]}</span>
                                                                                                                            <div class="progress sm">
                                                                                                                                <div class="progress-bar progress-bar-aqua" style="width: ${(performanceManagementStage[1]/performanceManagementStage[0])*100}%"></div>
                                                                                                                            </div>
                                                                                                                        </div>
                                                                                                                    </li><!-- /.item -->

                                                                                                                    <li class="">
                                                                                                                        <div class="progress-group" style="padding-bottom: 15px;">
                                                                                                                            <span class="progress-text">KRA Approval By Manager</span>
                                                                                                                            <span class="progress-number"><b>${performanceManagementStage[2]}</b>/${performanceManagementStage[0]}</span>
                                                                                                                            <div class="progress sm">
                                                                                                                                <div class="progress-bar progress-bar-red" style="width: ${(performanceManagementStage[2]/performanceManagementStage[0])*100}%"></div>
                                                                                                                            </div>
                                                                                                                        </div>
                                                                                                                    </li><!-- /.item -->

                                                                                                                    <li class="">
                                                                                                                        <div class="progress-group" style="padding-bottom: 15px;">
                                                                                                                            <span class="progress-text">Employees Mid Year Self Assessment</span>
                                                                                                                            <span class="progress-number"><b>${performanceManagementStage[3]}</b>/${performanceManagementStage[0]}</span>
                                                                                                                            <div class="progress sm">
                                                                                                                                <div class="progress-bar progress-bar-green" style="width: ${(performanceManagementStage[3]/performanceManagementStage[0])*100}%"></div>
                                                                                                                            </div>
                                                                                                                        </div>
                                                                                                                    </li><!-- /.item -->

                                                                                                                    <li class="">
                                                                                                                        <div class="progress-group" style="padding-bottom: 15px;">
                                                                                                                            <span class="progress-text">Managers Mid Year Review</span>
                                                                                                                            <span class="progress-number"><b>${performanceManagementStage[4]}</b>/${performanceManagementStage[0]}</span>
                                                                                                                            <div class="progress sm">
                                                                                                                                <div class="progress-bar progress-bar-yellow" style="width: ${(performanceManagementStage[4]/performanceManagementStage[0])*100}%"></div>
                                                                                                                            </div>
                                                                                                                        </div>
                                                                                                                    </li><!-- /.item -->

                                                                                                                    <li class="">
                                                                                                                        <div class="progress-group" style="padding-bottom: 15px;">
                                                                                                                            <span class="progress-text">Employees End Year Self Assessment</span>
                                                                                                                            <span class="progress-number"><b>${performanceManagementStage[5]}</b>/${performanceManagementStage[0]}</span>
                                                                                                                            <div class="progress sm">
                                                                                                                                <div class="progress-bar progress-bar-light-blue" style="width: ${(performanceManagementStage[5]/performanceManagementStage[0])*100}%"></div>
                                                                                                                            </div>
                                                                                                                        </div>
                                                                                                                    </li><!-- /.item -->

                                                                                                                    <li class="">
                                                                                                                        <div class="progress-group">
                                                                                                                            <span class="progress-text">Managers End Year Review</span>
                                                                                                                            <span class="progress-number"><b>${performanceManagementStage[6]}</b>/${performanceManagementStage[0]}</span>
                                                                                                                            <div class="progress sm">
                                                                                                                                <div class="progress-bar progress-bar-light-darkViolet" style="width: ${(performanceManagementStage[6]/performanceManagementStage[0])*100}%"></div>
                                                                                                                            </div>
                                                                                                                        </div>
                                                                                                                    </li><!-- /.item -->

                                                                                                                </ul>
                                                                                                                <!--<div id="dual_x_div" style="width: 900px; height: 500px;"></div>-->
                                                                                                            </div><!-- /.box-body -->
                                                                                                            <!--                                                    <div class="box-footer text-center">
                                                                                                                                                                    <a href="javascript::" class="uppercase">View All Business Areas</a>
                                                                                                                                                                </div> /.box-footer -->
                                                                                                        </div><!-- /.box -->
                                                                                                    </div><!-- /.col -->
                                                                                                    <div class="col-md-4">
                                                                                                        <!-- Nature of Business Pane -->
                                                                                                        <div class="box box-info">
                                                                                                            <div class="box-header">
                                                                                                                <h3 class="box-title">Performance rating department wise</h3>
                                                                                                                <div class="box-tools pull-right">
                                                                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                                                                </div>
                                                                                                            </div><!-- /.box-header -->
                                                                                                            <div class="box-body">
                                                                                                                <ul class="products-list product-list-in-box">
                                                                                                                    <%--<c:forEach items="${departmentWiseEmpCountList}" var="departmentWiseEmpCountList" varStatus="counter">--%>
                                                                                                                    <c:forEach items="${finalList}" var="performanceRatingList" varStatus="counterInner">
                                                                                                                        <li class="">
                                                                                                                            <div class="progress-group">
                                                                                                                                <span class="progress-text">${performanceRatingList[0]}</span>
                                                                                                                                <span class="progress-number"></span>

                                                                                                                                <div class="progress sm" style="height: 20px;">
                                                                                                                                    <c:set var="count" value="0" scope="page" />
                                                                                                                                    <%--<c:if test="${performanceRatingList[3] eq departmentWiseEmpCountList[0]}">--%>
                                                                                                                                    <c:set var="totalScore" value="${performanceRatingList[1]+performanceRatingList[2]+performanceRatingList[3]+performanceRatingList[4]+performanceRatingList[5]}" scope="page"/>
                                                                                                                                    <%--</c:if>--%>

                                                                                                                                    <c:forEach items="${departmentWiseEmpCountList}" var="departmentWiseEmpCountList" varStatus="counter">
                                                                                                                                        <c:if test="${departmentWiseEmpCountList[0] eq performanceRatingList[0]}">
                                                                                                                                            <c:set var="divideScore" value="${(departmentWiseEmpCountList[1]+1) *75/100}" scope="page"/>
                                                                                                                                            <c:set var="divideScore1" value="${(departmentWiseEmpCountList[1]+1) *25/100}" scope="page"/>
                                                                                                                                            <div class="progress-bar progress-bar-aqua" style="width: ${(performanceRatingList[1]+1) *divideScore/totalScore}%;background-color: #008000;color: black"><b>${performanceRatingList[1]}</b></div>
                                                                                                                                            <div class="progress-bar progress-bar-red" style="width: ${(performanceRatingList[2]+1) *divideScore/totalScore}%;background-color: #6AA121;color: black" ><b>${performanceRatingList[2]}</b></div>
                                                                                                                                            <div class="progress-bar progress-bar-green" style="width: ${(performanceRatingList[3]+1) *divideScore/totalScore}%;background-color: #FFFF00;color: black"><b>${performanceRatingList[3]}</b></div>
                                                                                                                                            <div class="progress-bar progress-bar-yellow" style="width: ${(performanceRatingList[4]+1) *divideScore/totalScore}%;background-color: #FFA375;;color: black"><b>${performanceRatingList[4]}</b></div>
                                                                                                                                            <div class="progress-bar progress-bar-light-blue" style="width: ${(performanceRatingList[5]+1) *divideScore/totalScore}%;background-color: #FF8080;color: black"><b>${performanceRatingList[5]}</b></div>
                                                                                                                                            <div class="progress-bar " style="width: ${divideScore1}%;background-color: #f5f5f5;color: black;text-align: right"><b>${totalScore}</b>/<b>${departmentWiseEmpCountList[1]}</b></div>
                                                                                                                                                </c:if>
                                                                                                                                            </c:forEach>
                                                                                                                                </div>
                                                                                                                            </div>
                                                                                                                        </li><!-- /.item -->
                                                                                                                    </c:forEach>
                                                                                                                    <!--                                                    <li class="">
                                                                                                                                                                            <div class="progress-group">
                                                                                                                                                                                <span class="progress-text">HR</span>
                                                                                                                                                                                <span class="progress-number"></span>
                                                                                                                                                                                <div class="progress sm" style="height: 20px;">
                                                                                                                                                                                    <div class="progress-bar progress-bar-aqua" style="width: 20%;background-color: #008000;color: black"><b>5</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-red" style="width: 10%;background-color: #6AA121;color: black" ><b>3</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-green" style="width: 10%;background-color: #FFFF00;color: black"><b>2</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-yellow" style="width: 20%;background-color: #FFA375;;color: black"><b>4</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-light-blue" style="width: 15%;background-color: #FF8080;color: black"><b>3</b></div>
                                                                                                                                                                                    <div class="progress-bar " style="width: 25%;background-color: #f5f5f5;color: black;text-align: right"><b>40</b></div>
                                                                                                                                                                                </div>
                                                                                                                                                                            </div>
                                                                                                                                                                        </li> /.item
                                                                                                                                                                        <li class="">
                                                                                                                                                                            <div class="progress-group">
                                                                                                                                                                                <span class="progress-text">Purchase</span>
                                                                                                                                                                                <span class="progress-number"></span>
                                                                                                                                                                                <div class="progress sm" style="height: 20px;">
                                                                                                                                                                                    <div class="progress-bar progress-bar-aqua" style="width: 20%;background-color: #008000;color: black"><b>5</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-red" style="width: 10%;background-color: #6AA121;color: black" ><b>3</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-green" style="width: 10%;background-color: #FFFF00;color: black"><b>2</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-yellow" style="width: 20%;background-color: #FFA375;;color: black"><b>4</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-light-blue" style="width: 15%;background-color: #FF8080;color: black"><b>3</b></div>
                                                                                                                                                                                    <div class="progress-bar " style="width: 25%;background-color: #f5f5f5;color: black;text-align: right"><b>30</b></div>
                                                                                                                                                                                </div>
                                                                                                                                                                            </div>
                                                                                                                                                                        </li> /.item
                                                                                                                                                                        <li class="">
                                                                                                                                                                            <div class="progress-group">
                                                                                                                                                                                <span class="progress-text">Finance</span>
                                                                                                                                                                                <span class="progress-number"></span>
                                                                                                                                                                                <div class="progress sm" style="height: 20px;">
                                                                                                                                                                                    <div class="progress-bar progress-bar-aqua" style="width: 20%;background-color: #008000;color: black"><b>5</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-red" style="width: 10%;background-color: #6AA121;color: black" ><b>3</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-green" style="width: 10%;background-color: #FFFF00;color: black"><b>2</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-yellow" style="width: 20%;background-color: #FFA375;;color: black"><b>4</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-light-blue" style="width: 15%;background-color: #FF8080;color: black"><b>3</b></div>
                                                                                                                                                                                    <div class="progress-bar " style="width: 25%;background-color: #f5f5f5;color: black;text-align: right"><b>35</b></div>
                                                                                                                                                                                </div>
                                                                                                                                                                            </div>
                                                                                                                                                                        </li> /.item
                                                                                                                                                                        <li class="">
                                                                                                                                                                            <div class="progress-group">
                                                                                                                                                                                <span class="progress-text">Design</span>
                                                                                                                                                                                <span class="progress-number"></span>
                                                                                                                                                                                <div class="progress sm" style="height: 20px;">
                                                                                                                                                                                    <div class="progress-bar progress-bar-aqua" style="width: 20%;background-color: #008000;color: black"><b>5</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-red" style="width: 10%;background-color: #6AA121;color: black" ><b>3</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-green" style="width: 10%;background-color: #FFFF00;color: black"><b>2</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-yellow" style="width: 20%;background-color: #FFA375;;color: black"><b>4</b></div>
                                                                                                                                                                                    <div class="progress-bar progress-bar-light-blue" style="width: 15%;background-color: #FF8080;color: black"><b>3</b></div>
                                                                                                                                                                                    <div class="progress-bar " style="width: 25%;background-color: #f5f5f5;color: black;text-align: right"><b>45</b></div>
                                                                                                                                                                                </div>
                                                                                                                                                                            </div>
                                                                                                                                                                        </li> /.item -->





                                                                                                                </ul>
                                                                                                            </div><!-- /.box-body -->
                                                                                                            <!--                                                    <div class="box-footer text-center">
                                                                                                                                                                    <a href="javascript::" class="uppercase">View All Business Areas</a>
                                                                                                                                                                </div> /.box-footer -->
                                                                                                        </div><!-- /.box -->
                                                                                                    </div><!-- /.col -->

                                                                                                </div><!-- /.row -->
                                                                                                <div class="row">

                                                                                                    <div class="col-md-4">
                                                                                                        <!-- USERS LIST -->
                                                                                                        <div class="box box-danger">
                                                                                                            <div class="box-header">
                                                                                                                <h3 class="box-title">Department wise employee resignation</h3>
                                                                                                                <div class="box-tools pull-right">
                                                                                                                    <button class="btn btn-box-tool" data-widget="collapse">
                                                                                                                        <i class="fa fa-minus"></i>
                                                                                                                    </button>
                                                                                                                </div>
                                                                                                            </div><!-- /.box-header -->
                                                                                                            <div class="box-body" id="piechart33Id">
                                                                                                                <div id="piechart33" style="width: 300px; height: 300px;">

                                                                                                                </div>
                                                                                                            </div>


                                                                                                            <!--                                        <div class="box-footer text-center">
                                                                                                            <a href="Hierarchy.jsp" class="uppercase">View Department WIse</a>
                                                                                                       </div> /.box-footer -->
                                                                                                        </div><!--/.box -->
                                                                                                    </div>

                                                                                                    <div class="col-md-4">
                                                                                                        <!-- Nature of Business Pane -->
                                                                                                        <div class="box box-primary">
                                                                                                            <div class="box-header">
                                                                                                                <h3 class="box-title">Travel expense report</h3>
                                                                                                                <div class="box-tools pull-right">
                                                                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                                                                </div>
                                                                                                            </div><!-- /.box-header -->
                                                                                                            <div class="box-body" id="piechart11Id">
                                                                                                                <div id="piechart11" style="width: 300px; height: 300px;"></div>

                                                                                                                <!--<div id="dual_x_div" style="width: 900px; height: 500px;"></div>-->
                                                                                                            </div><!-- /.box-body -->
                                                                                                            <!--                                                    <div class="box-footer text-center">
                                                                                                                                                                    <a href="javascript::" class="uppercase">View All Business Areas</a>
                                                                                                                                                                </div> /.box-footer -->
                                                                                                        </div><!-- /.box -->
                                                                                                    </div><!-- /.col -->
                                                                                                    <div class="col-md-4">
                                                                                                        <!-- Nature of Business Pane -->
                                                                                                        <div class="box box-info">
                                                                                                            <div class="box-header">
                                                                                                                <h3 class="box-title">Probation to confirmation</h3>
                                                                                                                <div class="box-tools pull-right">
                                                                                                                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                                                                                </div>
                                                                                                            </div><!-- /.box-header -->
                                                                                                            <div class="box-body" id="piechart22Id">
                                                                                                                <div id="piechart22" style="width: 300px; height: 300px;"></div>
                                                                                                            </div><!-- /.box-body -->
                                                                                                            <!--                                                    <div class="box-footer text-center">
                                                                                                                                                                </div> /.box-footer -->
                                                                                                        </div><!-- /.box -->
                                                                                                    </div><!-- /.col -->

                                                                                                </div><!-- /.row -->
                                                                                                </div><!-- /.tab-pane -->

                                                                                                <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                                                                                                </div><!-- /.tab-content -->
                                                                                                </div><!-- nav-tabs-custom -->
                                                                                                </div><!-- /.col -->
                                                                                                </section><!-- /.content -->
                                                                                                </div><!-- /.content-wrapper -->

                                                                                                <%@include file="/WEB-INF/jsp/Dashboard/ChartIncludeCss.jsp"%>
                                                                                                <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
                                                                                                <!--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>-->
                                                                                                <!--<script type="text/javascript" src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>-->

                                                                                                <script>
                                                                                                    jQuery(document).ready(function () {
                                                                                                        $("#org").jOrgChart({
                                                                                                            chartElement: '#chart',
                                                                                                            dragAndDrop: true
                                                                                                        });
                                                                                                    });


                                                                                                </script>
                                                                                                <script>
                                                                                                    $(document).ready(function () {
                                                                                                        $('[data-toggle="tooltip"]').tooltip();
                                                                                                    });
                                                                                                </script>
                                                                                                </html>
