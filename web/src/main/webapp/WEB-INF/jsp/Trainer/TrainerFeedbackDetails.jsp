<%-- 
    Document   : TrainerFeedbackDetails
    Created on : Mar 22, 2018, 5:24:45 PM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>

    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Training Feedback</title>
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
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Feedback Details</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training feedback details</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="trainerLogin.htm?act=showTrainingFeedbackList" method="post" commandName="trainingMaster1" name='form1' class="form-horizontal" role="form">

            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<button type="submit" class="btn btn-primary" title="" onclick="window.location = 'trainingIdentification.htm?act=showTrainingFeedbackList2'"><i class="fa fa-search"></i>&nbsp;&nbsp;Search</button>-->
                                <input type="button" class="btn btn-primary" style="float: left" value="Back" onclick="window.history.back();" />
                                <!--<button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>-->
                                <!--<div class="col-sm-5">-->

                                <div class="col-sm-5">
                                    <!--${trainingsMaps}-->
                                    <label>Training:<span style="color: red;font-size: 12px;">*</span></label>

                                    <!--                                    <select path="departmentMaster.id" class="form-control">
                                                                                                <option value="" label="-- Select --" ></option>
                                                                                                <options items="${deptMap}"></options>
                                                                                            </select>-->
<!--                                    <select id="TrainingId" name="TrainingId" class="form-control" >
                                        <option value="">--SELECT--</option>
                                        <%--<c:forEach var="trainingsMaps" items="${trainingsMaps}">--%>
                                            <option value="${trainingsMaps.key}">${trainingsMaps.value}</option>
                                        <%--</c:forEach>--%>
                                    </select>-->

                                    <%--<form:errors path="trainingMaster.id" cssClass="errorDiv"></form:errors>--%>
                                </div>
                            </div>
                            <div class="box-header">
                            </div>
                            <div class="box-body no-padding">

                                <div class="row">

                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">

                                            <table id="table_12" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                <c:choose>
                                                    <c:when test="${empty trainingFeedbackList}">
                                                        <tr>
                                                            <td align="Center">There Is No Any Record</td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                <th>Sr.No.</th>
                                                                <th>Employee</th>
                                                                <th>Feedback</th>
                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <!--${trainingFeedbackList}-->
                                                            <c:forEach  var="trainingFeedbackList" items="${trainingFeedbackList}">
                                                                <c:set var="count" value="${count + 1}" scope="page"/>
                                                                <tr>
                                                                    <td align="Center">
                                                                        <input type="checkbox" name="checkId" id="checkId" value="${trainingFeedbackList[0]}">
                                                                    </td>
                                                                    <td>
                                                                        <c:out value = "${count}"/>
                                                                    </td>
                                                                    <td>
                                                                        ${trainingFeedbackList[2]}
                                                                    </td>
                                                                    <td>
                                                                        ${trainingFeedbackList[1]}
                                                                    </td>
                                                                    <!--                                                                    <td>
                                                                                                                                            <div class="btn-group">
                                                                                                                                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" onclick="viewClick(${trainingList.id});">
                                                                                                                                                    &nbsp;Edit
                                                                                                                                                </button>
                                                                    
                                                                                                                                            </div>
                                                                                                                                        </td>-->
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
                                        </div>
                                    </div>

                                </div><!-- /.tab-pane -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </section>
    </div>
</form:form><!-- /.content -->
</div><!-- /.content-wrapper -->
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
