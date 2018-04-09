<!DOCTYPE html>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
<html>
   
    <head>
        <style>
            .ui-datepicker{z-index: 99 !important};

        </style>
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
            <h1>My Dashboard</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">My Dashboard</li>
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
                                                <button type="button"  data-toggle="modal" data-target="#myModalOnline" class="btn btn-primary" style="float: right; width: 100px;" class="btn btn-default" aria-haspopup="true" aria-expanded="false"><i class="fa fa-plus"></i>&nbsp&nbsp;Gadget</button>
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

                                                                    <table cellpadding="0" cellspacing="0" border="0" style="margin: auto;">
                                                                        <tbody>
                                                                            <c:if test="${employeeMasterManager ne null}">
                                                                                <tr>
                                                                                    <td class="node-container" colspan="2">
                                                                                        <c:if test="${subordinateCount eq 0}">
                                                                                            <table cellpadding="0" cellspacing="0" border="0">
                                                                                                <tbody>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr class="node-cells">
                                                                                                        <!--<td class="node-cell" colspan="8" onclick="viewEmployeeDetail();">-->
                                                                                                        <c:forEach var="ceoMap" items="${ceoMap}">
                                                                                                            <td class="node-container" colspan="2">
                                                                                                                <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                    <tbody>
                                                                                                                        <tr class="node-cells">
                                                                                                                            <!--<td class="node-cell" style="width: 100px"  colspan="2" >-->
                                                                                                                            <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${ceoMap.value[1]} &#13; Department: ${ceoMap.value[2]} &#13; Designation: ${ceoMap.value[3]}">
                                                                                                                                    <img src="${ceoMap.value[4]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                    <span class="box-title" style="font-size: 105%;color: black">${ceoMap.value[1]}</span>

                                                                                                                                </div>
                                                                                                                            </td>
                                                                                                                        </tr>
                                                                                                                    </tbody>
                                                                                                                </table>
                                                                                                            </td>

                                                                                                        </c:forEach>

                                                                                                    </tr>
                                                                                                </tbody>
                                                                                            </table>
                                                                                        </c:if>
                                                                                        <c:if test="${subordinateCount <= 1 && subordinateCount ne 0}">
                                                                                            <table cellpadding="0" cellspacing="0" border="0" width="105px">
                                                                                                <tbody>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr class="node-cells">
                                                                                                        <!--<td class="node-cell" colspan="8" onclick="viewEmployeeDetail();">-->
                                                                                                        <c:forEach var="ceoMap" items="${ceoMap}">
                                                                                                            <td class="node-container" colspan="2">
                                                                                                                <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                    <tbody>
                                                                                                                        <tr class="node-cells">
                                                                                                                            <!--<td class="node-cell" style="width: 100px"  colspan="2" >-->
                                                                                                                            <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${ceoMap.value[1]} &#13; Department: ${ceoMap.value[2]} &#13; Designation: ${ceoMap.value[3]}">
                                                                                                                                    <img src="${ceoMap.value[4]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                    <span class="box-title" style="font-size: 105%;color: black">${ceoMap.value[1]}</span>

                                                                                                                                </div>
                                                                                                                            </td>
                                                                                                                        </tr>
                                                                                                                    </tbody>
                                                                                                                </table>
                                                                                                            </td>

                                                                                                        </c:forEach>

                                                                                                    </tr>
                                                                                                </tbody>
                                                                                            </table>
                                                                                        </c:if>
                                                                                        <c:if test="${subordinateCount == 2}">
                                                                                            <!--<table cellpadding="0" cellspacing="0" border="0" width="130px">-->
                                                                                            <table cellpadding="0" cellspacing="0" border="0" width="200px">
                                                                                                <tbody>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr class="node-cells">
                                                                                                        <!--<td class="node-cell" colspan="8" onclick="viewEmployeeDetail();">-->
                                                                                                        <c:forEach var="ceoMap" items="${ceoMap}">
                                                                                                            <td class="node-container" colspan="2">
                                                                                                                <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                    <tbody>
                                                                                                                        <tr class="node-cells">
                                                                                                                            <!--<td class="node-cell" style="width: 100px"  colspan="2" >-->
                                                                                                                            <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${ceoMap.value[1]} &#13; Department: ${ceoMap.value[2]} &#13; Designation: ${ceoMap.value[3]}">
                                                                                                                                    <img src="${ceoMap.value[4]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                    <span class="box-title" style="font-size: 105%;color: black">${ceoMap.value[1]}</span>

                                                                                                                                </div>
                                                                                                                            </td>
                                                                                                                        </tr>
                                                                                                                    </tbody>
                                                                                                                </table>
                                                                                                            </td>

                                                                                                        </c:forEach>

                                                                                                    </tr>
                                                                                                </tbody>
                                                                                            </table>
                                                                                        </c:if>
                                                                                        <c:if test="${subordinateCount == 3}">
                                                                                            <!--<table cellpadding="0" cellspacing="0" border="0" width="195px">-->
                                                                                            <table cellpadding="0" cellspacing="0" border="0" width="310px">
                                                                                                <tbody>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr class="node-cells">
                                                                                                        <!--<td class="node-cell" colspan="8" onclick="viewEmployeeDetail();">-->
                                                                                                        <c:forEach var="ceoMap" items="${ceoMap}">
                                                                                                            <td class="node-container" colspan="2">
                                                                                                                <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                    <tbody>
                                                                                                                        <tr class="node-cells">
                                                                                                                            <!--<td class="node-cell" style="width: 100px"  colspan="2" >-->
                                                                                                                            <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${ceoMap.value[1]} &#13; Department: ${ceoMap.value[2]} &#13; Designation: ${ceoMap.value[3]}">
                                                                                                                                    <img src="${ceoMap.value[4]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                    <span class="box-title" style="font-size: 105%;color: black">${ceoMap.value[1]}</span>

                                                                                                                                </div>
                                                                                                                            </td>
                                                                                                                        </tr>
                                                                                                                    </tbody>
                                                                                                                </table>
                                                                                                            </td>

                                                                                                        </c:forEach>

                                                                                                    </tr>
                                                                                                </tbody>
                                                                                            </table>
                                                                                        </c:if>
                                                                                        <c:if test="${subordinateCount == 4}">
                                                                                            <!--<table cellpadding="0" cellspacing="0" border="0" width="260px">-->
                                                                                            <table cellpadding="0" cellspacing="0" border="0" width="315px">

                                                                                                <tbody>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                        <td>&nbsp;</td>
                                                                                                    </tr>
                                                                                                    <tr class="node-cells">
                                                                                                        <!--<td class="node-cell" colspan="8" onclick="viewEmployeeDetail();">-->
                                                                                                        <c:forEach var="ceoMap" items="${ceoMap}">
                                                                                                            <td class="node-container" colspan="2">
                                                                                                                <table cellpadding="0" cellspacing="0" border="0">
                                                                                                                    <tbody>
                                                                                                                        <tr class="node-cells">
                                                                                                                            <!--<td class="node-cell" style="width: 100px"  colspan="2" >-->
                                                                                                                            <td class="node-cell" style="width: 100px"  colspan="2">
                                                                                                                                <div class="node ui-draggable ui-droppable" style="cursor: pointer;" title=" Name: ${ceoMap.value[1]} &#13; Department: ${ceoMap.value[2]} &#13; Designation: ${ceoMap.value[3]}">
                                                                                                                                    <img src="${ceoMap.value[4]}" style="border-radius: 50%;max-width: 100%;height: 60px;width: 60px;">
                                                                                                                                    <span class="box-title" style="font-size: 105%;color: black">${ceoMap.value[1]}</span>

                                                                                                                                </div>
                                                                                                                            </td>
                                                                                                                        </tr>
                                                                                                                    </tbody>
                                                                                                                </table>
                                                                                                            </td>

                                                                                                        </c:forEach>

                                                                                                    </tr>
                                                                                                </tbody>
                                                                                            </table>
                                                                                        </c:if>
                                                                                    </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                    <td>&nbsp;</td>
                                                                                </tr>
                                                                                <tr>

                                                                                    <!--                                                                                                        <td class="node-container" colspan="2">
                                                                                                                                                            <table cellpadding="0" cellspacing="0" border="0" style="margin: auto;">
                                                                                                                                                            <tbody>
                                                                                                                                                            <tr class="node-cells">
                                                                                                                                                            <td class="node-cell"  colspan="8" onclick="viewEmployeeDetail(${employeeMaster.id},${employeeMaster.userMaster.id});">
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
                                                                                                <div class="line down"></div>
                                                                                        <c:if test="${subordinateCount eq 1}">
                                                                                            <div>&nbsp;</div>
    
                                                                                        </c:if>
    
                                                                                    </td>
                                                                                </tr>
                                                                                <tr>
                                                                                        <c:if test="${subordinateCount >= 1}">
                                                                                            <c:if test="${subordinateCount >= 2}">
                                                                                                <td class="line left">&nbsp;</td>
                                                                                                <td class="line right top">&nbsp;</td>
                                                                                                <td>&nbsp;</td>
                                                                                                <td>&nbsp;</td>
                                                                                            </c:if>
                                                                                            <c:if test="${subordinateCount >= 3 }">
                                                                                                                                                                                <td class="line left top">&nbsp;</td>
                                                                                                                                                                    <td class="line right top">&nbsp;</td>
                                                                                                <td>&nbsp;</td>
                                                                                                <td>&nbsp;</td>
                                                                                            </c:if>
    
                                                                                            <c:if test="${subordinateCount >= 4}">
                                                                                                <td class="line left top">&nbsp;</td>
                                                                                                <td class="line right top">&nbsp;</td>
                                                                                                <td>&nbsp;</td>
                                                                                                <td>&nbsp;</td>
                                                                                            </c:if>
                                                                                            <c:if test="${subordinateCount >= 2}">
                                                                                                <td class="line left top">&nbsp;</td>
                                                                                                <td class="line right">&nbsp;</td>
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
                                                                                                            <td class="node-cell" style="width: 100px"  colspan="2" onclick="viewEmployeeDetail(${subordinateList[0][0]},${subordinateList[0][6]});">
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
                                                                                                            <td class="node-cell" style="width: 100px"  colspan="2" onclick="viewEmployeeDetail(${subordinateList[1][0]},${subordinateList[1][6]});">
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
                                                                                                            <td class="node-cell" style="width: 100px"  colspan="2" onclick="viewEmployeeDetail(${subordinateList[2][0]},${subordinateList[2][6]});">
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
                                                                                                            <td class="node-cell" style="width: 100px"  colspan="2" onclick="viewEmployeeDetail(${subordinateList[3][0]},${subordinateList[3][6]});">
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
                                                                        </td>-->
                                                                                </tr>
                                                                            </c:if>
                                                                        </tbody>
                                                                    </table>
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



                                </div><!-- /.row -->
                                <div class="row">



                                </div><!-- /.row -->
                            </div><!-- /.tab-pane -->

                            <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->


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


    //New Model for Graphical Report
    <div class="container">
        <div class="modal fade" id="myModalOnline" role="dialog">
            <div class="modal-dialog" >

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Dynamic Report</h4>
                    </div>
                    <form:form class="form-horizontal" method="post" commandName="" 
                               action="" >
                        <section class="content">
                            <!--<div class="col-md-12">-->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label class="control-label">Module<span style="color: red;font-size: 12px;">*</span></label>
                                                <select name="trainer" class="form-control" path="trainer.id" id="trainer" >
                                                    <option value="">--Select--</option>
                                                    <c:forEach items="${trainerMap}" var="trainer">
                                                        <option value="${trainer.key}">${trainer.value}</option>
                                                    </c:forEach>
                                                </select>
                                                <span style="font-size: 14px; color: #dd4b39;" id="trainerError"></span>
                                            </div>
                                            <div class="col-sm-6">
                                                <label class="control-label">Component<span style="color: red;font-size: 12px;">*</span></label>
                                                <select name="trainer" class="form-control" path="trainer.id" id="trainer" >
                                                    <option value="">--Select--</option>
                                                    <c:forEach items="${trainerMap}" var="trainer">
                                                        <option value="${trainer.key}">${trainer.value}</option>
                                                    </c:forEach>
                                                </select>
                                                <span style="font-size: 14px; color: #dd4b39;" id="trainerError"></span>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label class="control-label">Report for<span style="color: red;font-size: 12px;">*</span></label>
                                                <select name="trainer" class="form-control" path="trainer.id" id="trainer" >
                                                    <option value="">--Select--</option>
                                                    <c:forEach items="${trainerMap}" var="trainer">
                                                        <option value="${trainer.key}">${trainer.value}</option>
                                                    </c:forEach>
                                                </select>
                                                <span style="font-size: 14px; color: #dd4b39;" id="trainerError"></span>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label class="control-label">From<span style="color: red;font-size: 12px;">*</span></label>
                                                <div class="input-group"  data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                    <input type="text" id="datepicker1" class="form-control" size="3" type="text" value="" style="z-index: 1000!important;" readonly="true" >
                                                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>-->
                                                </div>
                                            </div>
                                            <div class="col-sm-6">
                                                <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>

                                                <label>Validity From :<span style="color: red;font-size: 12px;"></span></label>
                                                <input type="text" id="datetimepicker22" class="form-control"  placeholder="Please select From Date" name="datetimepicker2" readonly="true" required="true"/>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <!--<div class="form-group">-->
                                            <div class=" col-sm-5 col-sm-offset-5" style="text-align: right">
                                                <button type="button" class="btn btn-primary" data-original-title="" title="" >Submit</button>
                                            </div>
                                            <!--</div>-->
                                            <!--                                                                                                                                        <div style="float: right;">
                                                                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                                                                                            </div>-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--</div>-->
                            <!--</div>-->

                        </section>
                    </form:form>

                </div>
            </div>
        </div>
        <link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">  
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>  
        <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>  
    </div>

    <script>
        $(function () {
            alert("Hello");
            $("#datetimepicker22").datepicker().innerHTML;
        });
        $(document).ready(function () {
            alert("hiii");
            $('#datetimepicker22').datepicker({
            });
        });
    </script>


<!--    <script>
        //            $(function () {
        //                $("#datepicker").datepicker();
        //            });
        $("#datepicker1").datepicker({dateFormat: 'dd/mm/yy'});
        //              $(function () {
        //                $("#datepicker2").datepicker();
        //            });
    </script>-->
    <script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
    <script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
    <script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
    <script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
    <script src="StorageYard/JS/login/scripts.js"></script>
    <script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
    <!--                                                                                                <script type="text/javascript">
                                                                                                        $('.form_Startdatetime').datetimepicker({
                                                                                                            //language:  'fr',
                                                                                                            weekStart: 1,
                                                                                                            todayBtn: 1,
                                                                                                            autoclose: 2,
                                                                                                            todayHighlight: 1,
                                                                                                            startView: 2,
                                                                                                            minView: 2,
                                                                                                            forceParse: 0,
                                                                                                            showMeridian: 1
                                                                                                        });
                                                                                                        $('.form_Enddatetime').datetimepicker({
                                                                                                            //language:  'fr',
                                                                                                            weekStart: 1,
                                                                                                            todayBtn: 1,
                                                                                                            autoclose: 2,
                                                                                                            todayHighlight: 1,
                                                                                                            startView: 2,
                                                                                                            minView: 2,
                                                                                                            forceParse: 0,
                                                                                                            showMeridian: 1
                                                                                                        });
                                                                                                        $('.form_datetime').datetimepicker({
                                                                                                            //language:  'fr',
                                                                                                            //        language: 'fr',
                                                                                                            weekStart: 1,
                                                                                                            todayBtn: 1,
                                                                                                            autoclose: 1,
                                                                                                            todayHighlight: 1,
                                                                                                            startView: 1,
                                                                                                            minView: 0,
                                                                                                            maxView: 1,
                                                                                                            forceParse: 0
                                                                                                        });
                                                                                                    </script>-->
</html>
<%@include file="/WEB-INF/jsp/Dashboard/ChartIncludeCss.jsp"%>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
