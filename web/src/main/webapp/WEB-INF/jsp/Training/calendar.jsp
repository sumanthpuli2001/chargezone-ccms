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
        .borderClass{
            width: 100%;
            border: 1px #e2e2e2 solid !important;
            background-color: #e1e1e1;
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
<!--                                        <tr>
                                            <td  id="tableId${list[0]}"  ><span >${list[0][1]}</span><c:if test="${!empty list[0][3]}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[0][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist" items="${list[0][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist[0]}&eventdate=${innerlist[2]}">${status.count}.${innerlist[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[1]}"  ><span >${list[1][1]}</span><c:if test="${!empty list[1][3]}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[1][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist1" items="${list[1][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist1[0]}&eventdate=${innerlist1[2]}">${status.count}.${innerlist1[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[2]}"  ><span >${list[2][1]}</span><c:if test="${!empty list[2][3]}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[2][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist2" items="${list[2][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist2[0]}&eventdate=${innerlist2[2]}">${status.count}.${innerlist2[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[3]}"  ><span >${list[3][1]}</span><c:if test="${!empty list[3][3]}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[3][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist3" items="${list[3][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist3[0]}&eventdate=${innerlist3[2]}">${status.count}.${innerlist3[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[4]}"  ><span >${list[4][1]}</span><c:if test="${!empty list[4][3]}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[4][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist4" items="${list[4][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist4[0]}&eventdate=${innerlist4[2]}">${status.count}.${innerlist4[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[5]}"  ><span >${list[5][1]}</span><c:if test="${!empty list[5][3]}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[5][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist5" items="${list[5][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist5[0]}&eventdate=${innerlist5[2]}">${status.count}.${innerlist5[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[6]}"  ><span >${list[6][1]}</span><c:if test="${!empty list[6][3]}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[6][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist6" items="${list[6][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist6[0]}&eventdate=${innerlist6[2]}">${status.count}.${innerlist6[1]}</a></div><br></c:forEach></td> 
                                            </tr>-->
                                            <tr>
                                            <td  id="tableId${list[0]}"  ><span >${list[0][1]}</span><c:if test="${list[0][3] eq true}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[0][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist" items="${list[0][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist[0]}&eventdate=${innerlist[2]}">${status.count}.${innerlist[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[1]}"  ><span >${list[1][1]}</span><c:if test="${list[1][3] eq true}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[1][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist1" items="${list[1][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist1[0]}&eventdate=${innerlist1[2]}">${status.count}.${innerlist1[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[2]}"  ><span >${list[2][1]}</span><c:if test="${list[2][3] eq true}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[2][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist2" items="${list[2][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist2[0]}&eventdate=${innerlist2[2]}">${status.count}.${innerlist2[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[3]}"  ><span >${list[3][1]}</span><c:if test="${list[3][3] eq true}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[3][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist3" items="${list[3][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist3[0]}&eventdate=${innerlist3[2]}">${status.count}.${innerlist3[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[4]}"  ><span >${list[4][1]}</span><c:if test="${list[4][3] eq true}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[4][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist4" items="${list[4][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist4[0]}&eventdate=${innerlist4[2]}">${status.count}.${innerlist4[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[5]}"  ><span >${list[5][1]}</span><c:if test="${list[5][3] eq true}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[5][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist5" items="${list[5][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist5[0]}&eventdate=${innerlist5[2]}">${status.count}.${innerlist5[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[6]}"  ><span >${list[6][1]}</span><c:if test="${list[6][3] eq true}"><button type="button" class="btn btn-flat" title="" style="width: 20px; float: right; padding: 0px" onclick="window.location = 'trainingMaster.htm?act=createClick&eventdate=${list[6][2]}'"><i class="fa fa-plus"></i>+</button><br></c:if><br><c:forEach var="innerlist6" items="${list[6][4]}" varStatus="status"><div class="text-left  borderClass"><a href="trainingType.htm?act=viewProfile&id=${innerlist6[0]}&eventdate=${innerlist6[2]}">${status.count}.${innerlist6[1]}</a></div><br></c:forEach></td> 
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


