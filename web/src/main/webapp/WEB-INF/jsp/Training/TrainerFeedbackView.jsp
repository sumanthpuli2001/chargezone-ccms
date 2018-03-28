<%-- 
    Document   : TrainerFeedbackView
    Created on : 27 Mar, 2018, 4:35:47 PM
    Author     : Vikas
--%>

<%-- 
    Document   : TrainerMasterlblView
    Created on : Mar 14, 2018, 10:46:12 AM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Training Details</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">-->
        <link rel="stylesheet" href="StorageYard/CSS/login/form-elements.css">
        <link rel="stylesheet" href="StorageYard/CSS/login/style.css">
        <script type="text/javascript" src="StorageYard/Plugins/jQuery/jQuery-2.1.4.min.js"></script>

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
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Training Details:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Training Details</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->

        <form:form action="trainerLogin.htm?act=SubmitAttendanceClick" method="post" commandName="trainerMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <input type="hidden" id="trainingMasterId" name="trainingMasterId" value="${trainingMasterId}">
            <input type="hidden" id="eventdate" name="eventdate" value="${eventdate}">
            <!--<input type="hidden" id="allTrainingsId" name="allTrainingsId" value="${list[0]}">-->
            <!-- Custom Tabs -->
            <!--<button type="button" class="btn btn-primary" title="" style="float: right; width: 120px;" onclick="window.history.back();"></i>&nbsp;&nbsp;BACK</button>-->
            <input type="button" class="btn btn-primary" value="Back" style="float: left" onclick="window.history.back();"/>
            <%--<c:if test="${feedbackStatus eq true}">--%>
                <!--<button type="button" class="btn btn-primary" style="float: right" title="" style="width: 100px;" onclick="window.location = 'trainerLogin.htm?act=sendFeedback&id=${trainingMasterId}&eventdate=${eventdate}'"><i class="fa fa-pencil-square-o"></i>Feedback</button>-->
            <%--</c:if>--%>
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <!--<button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>-->
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label>Training Title : </label>&nbsp;&nbsp;${trainingMaster.trainingTitle}
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label>Training Requester : </label>&nbsp;&nbsp;${trainingMaster.trainingOwner}
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class ="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <label>Training Type : </label>&nbsp;&nbsp;${trainingMaster.trainingType.training}
                                </div>
                                <div class ="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <label>Training sub-type : </label>&nbsp;&nbsp;${trainingMaster.trainingSubType.trainingsubtype}
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class ="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <label>Training Source : </label>&nbsp;&nbsp;${trainingMaster.trainingSource}
                                </div>
                                <div class ="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <label>Trainer : </label>&nbsp;&nbsp;${trainingMaster.trainer.trainerName}
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class ="col-lg-3 col-md-3 col-sm-6 col-xs-12">

                                    <label>Start Date : </label>&nbsp;&nbsp;${trainingMaster.startDate}
                                </div>
                                <div class ="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <label>End Date : </label>&nbsp;&nbsp;${trainingMaster.endDate}
                                </div>
                                <div class ="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <label>Training time from : </label>&nbsp;&nbsp;${trainingMaster.trainingTimeForm}
                                </div>
                                <div class ="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <label>Training time to : </label>&nbsp;&nbsp;${trainingMaster.trainingTimeTo}
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class ="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label>Venue : </label>&nbsp;&nbsp;${trainingMaster.venue}
                                </div>
                            </div>
                            <div class ="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class ="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                                    <label>Description : </label>&nbsp; &nbsp;
                                    ${trainingMaster.trainingDescription}</textarea>
                                </div>
                            </div>
                        </div>
                    </div><!-- /.tab-content -->
                    <section class="content-header">
                        <h1>FeedBack Details:</h1>
                    </section>
                    <div class="tab-content">
                        <!--<button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>-->
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                <div class ="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <label>Employee Name : </label>&nbsp;&nbsp;${EmployeeName}
                                </div>
                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label>Feedback : </label>&nbsp;&nbsp;${Feedaback}
                                </div>
                            </div>
                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">

                                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                    <label>Description  : </label>&nbsp;&nbsp;${description}
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </form:form><!-- /.content -->
</div><!-- /.content-wrapper -->
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>

<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid ;
        text-align: left;
        padding: 8px;
    }
    body{
        text-align: left;
    }
</style>
<script src="StorageYard/JS/JQuery/jquery-1.11.1.min.js"></script>
<script src="StorageYard/JS/bootstrap/bootstrap.min.js"></script>
<script src="StorageYard/JS/login/jquery.backstretch.min.js"></script>
<script src="StorageYard/JS/login/retina-1.1.0.min.js"></script>
<script src="StorageYard/JS/login/scripts.js"></script>
<script type="text/javascript" src="StorageYard/JS/JQuery/common.js"></script>
<script>
                function goToAns(trainerId) {
                    window.location = 'trainerLogin.htm?act=goToAns&id=' + trainerId;
                }
</script>
