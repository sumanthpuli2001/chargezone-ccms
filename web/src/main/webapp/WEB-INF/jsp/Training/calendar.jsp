<%-- 
    Document   : calendar
    Created on : 7 Mar, 2018, 3:38:34 PM
    Author     : Dell-1
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title>Calendar</title>
    </head>
    <script>
        function viewClick(monthAndYear, btnType) {
            window.location = "trainingType.htm?act=calendarList&monthAndYear=" + monthAndYear + "&btnType=" + btnType;
        }
    </script>
    <style type="text/css">
        #calendar-buttons {
            display: none;
        }
        .jarviswidget .fc-toolbar {
            margin-top: -32px;
        }
        .calendar .top-nav .calendar-label {
            position: absolute;
            display: block;
            width: 100%;
            margin-top: 8px;
            text-align: center;
            font-family: sans-serif;
        }
        .calendar .top-nav .nav-btns {
            position: absolute;
            width: 100%;
        }
        .calendar table.table thead th {
            text-align: center;
        }
        .calendar table.table tbody td {
            text-align: center;
            width: 100px;
            height: 120px;
            cursor: pointer;
            position: relative;
        }
        .calendar table.table tbody td.inactive {
            cursor: default;
            background: #eaeaea;
        }
        .calendar table.table tbody td i.fa {
            display: none;
            position: absolute;
            top: 5px;
            right: 5px;
        }
        .calendar table.table tbody td.selected i.fa {
            display: block;
        }
        .eventClass{
            background-color: rgb(228, 255, 255);
        }
        td,th{
            border: 1px #e1e1e1 solid !important;
        }
    </style>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Calendar:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Calendar</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <div>
            <div class="jarviswidget-editbox">
            </div>
            <div class="widget-body" style="padding-bottom: 0px;">
                <div class="calendar">
                    <div class="top-nav">
${list}
                            <div class="col-xs-12 no-padding">
                            <div class="col-xs-5">
                                 <a class="btn btn-default" onclick="viewClick('${list[0]}', 'Last')"><i class="fa fa-arrow-left"></i></a>
                            </div>
                            <div class="col-xs-2">
                                <h4><label><b>${list[0]}</b></label></h4>
                            </div>
                            <div class="col-xs-5">
                                
                            <a class="btn btn-default pull-right" onclick="viewClick('${list[0]}', 'Next')"><i class="fa fa-arrow-right" ></i></a>
                            </div>
                           
                        </div>
                    </div>
                    <div style="padding-top: 30px;">
                        <div class="col-xs-12 no-padding">
                            <hr/>
                            <table class="table table-bordered" style="width: 100% !important;">
                                <thead>
                                    <tr>
                                        <th>Sunday</th>
                                        <th>Monday</th>
                                        <th>Tuesday</th>
                                        <th>Wednesday</th>
                                        <th>Thursday</th>
                                        <th>Friday</th>
                                        <th>Saturday</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="list" items="${list[1]}" varStatus="status">
                                        <tr>

                                            <td  id="tableId${list[0]}"  >${list[0][4]}</td>
                                            <td  id="tableId${list[1]}"  >${list[1][4]}</td>
                                            <td  id="tableId${list[2]}"  >${list[2][4]}</td>
                                            <td  id="tableId${list[3]}"  >${list[3][4]}</td>
                                            <td  id="tableId${list[4]}"  >${list[4][4]}</td>
                                            <td  id="tableId${list[5]}"  >${list[5][4]}</td>
                                            <td  id="tableId${list[6]}"  >${list[6][4]}</td> 
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>





    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>


