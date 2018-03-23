<%-- 
    Document   : trainerList
    Created on : Mar 10, 2018, 6:33:01 PM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Trainer Login</title>

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">

        <link rel="shortcut icon" href="../../dist/img/ico/logo.png">
        <!--<link rel="shortcut icon" href="../../bootstrap/ico/favicon.png">-->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="StorageYard/Images/login/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="StorageYard/Images/login/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="StorageYard/Images/login/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="StorageYard/Images/login/apple-touch-icon-57-precomposed.png">

        <style>
            #containers {
                display: flex;              /* establish flex container */
                flex-direction: column;
                justify-content: center;    /* align items vertically, in this case */
                align-items: center;        /* align items horizontally, in this case */
                height: 800px;
                /*border: 1px solid black;*/
            }

        </style>
        <script>
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Continuing ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
        <script>
            function homeClick(id) {
                alert(id);
                window.location = 'trainerMaster.htm?act=backToHome&id=' + id;
            }
        </script>
        <script>
        function viewClick(monthAndYear, btnType) {
            window.location = "trainerLogin.htm?act=calendarList&monthAndYear=" + monthAndYear + "&btnType=" + btnType;
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
    </head>
    <body>
        <section class="content-header" style="margin-top: 5%;">
            <c:if test="${sessionScope.trainerMaster ne null}">
                <button type="button" class="btn btn-primary" style="float: right; width: 130px; margin-right: 2%;" onclick="window.location = 'trainerLogin.htm?act=logout'"><i class="fa fa-sign-out"></i>&nbsp&nbsp&nbsp;Log Out</button>
                <label>Candidate User Name&nbsp : &nbsp&nbsp${sessionScope.trainerMaster.userName}</label>
            </c:if>
            <h1>Trainer</h1>
            <ol class="breadcrumb">
            </ol>
        </section>
        <ul class="nav nav-tabs" style="text-align: center" >
            <li class="active " ><a href="trainerLogin.htm?act=showcalendar">My Calendar</a></li>
            <!--<li ><a href="trainerLogin.htm?act=showTrainingFeedbackList">Feedback</a></li>-->
        </ul>
        <br/>
        <br/>
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
                                        <tr>

                                            <td  id="tableId${list[0]}"  ><span >${list[0][1]}</span><br><c:forEach var="innerlist" items="${list[0][3]}" varStatus="status"><div class="text-left  borderClass"><a href="trainerLogin.htm?act=viewProfile&id=${innerlist[0]}&eventdate=${innerlist[2]}">${status.count}.${innerlist[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[1]}"  ><span >${list[1][1]}</span><br><c:forEach var="innerlist1" items="${list[1][3]}" varStatus="status"><div class="text-left  borderClass"><a href="trainerLogin.htm?act=viewProfile&id=${innerlist1[0]}&eventdate=${innerlist1[2]}">${status.count}.${innerlist1[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[2]}"  ><span >${list[2][1]}</span><br><c:forEach var="innerlist2" items="${list[2][3]}" varStatus="status"><div class="text-left  borderClass"><a href="trainerLogin.htm?act=viewProfile&id=${innerlist2[0]}&eventdate=${innerlist2[2]}">${status.count}.${innerlist2[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[3]}"  ><span >${list[3][1]}</span><br><c:forEach var="innerlist3" items="${list[3][3]}" varStatus="status"><div class="text-left  borderClass"><a href="trainerLogin.htm?act=viewProfile&id=${innerlist3[0]}&eventdate=${innerlist3[2]}">${status.count}.${innerlist3[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[4]}"  ><span >${list[4][1]}</span><br><c:forEach var="innerlist4" items="${list[4][3]}" varStatus="status"><div class="text-left  borderClass"><a href="trainerLogin.htm?act=viewProfile&id=${innerlist4[0]}&eventdate=${innerlist4[2]}">${status.count}.${innerlist4[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[5]}"  ><span >${list[5][1]}</span><br><c:forEach var="innerlist5" items="${list[5][3]}" varStatus="status"><div class="text-left  borderClass"><a href="trainerLogin.htm?act=viewProfile&id=${innerlist5[0]}&eventdate=${innerlist5[2]}">${status.count}.${innerlist5[1]}</a></div><br></c:forEach></td>
                                            <td  id="tableId${list[6]}"  ><span >${list[6][1]}</span><br><c:forEach var="innerlist6" items="${list[6][3]}" varStatus="status"><div class="text-left  borderClass"><a href="trainerLogin.htm?act=viewProfile&id=${innerlist6[0]}&eventdate=${innerlist6[2]}">${status.count}.${innerlist6[1]}</a></div><br></c:forEach></td> 
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
        
    </body>
</html>
