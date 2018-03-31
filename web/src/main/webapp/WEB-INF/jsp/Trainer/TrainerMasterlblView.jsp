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
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class ="col-lg-1 col-md-1 col-sm-1 col-xs-1">
                    <button type="button" class="btn btn-primary" value="Back" style="float: left" onclick="window.location = 'trainerLogin.htm?act=showcalendar'" >Back</button>
                </div>
                <div class ="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <c:if test="${feedbackdshow eq true}">
                        <button type="button" class="btn btn-primary" style="float: left;margin-right: 10px" title="" style="width: 100px;" onclick="window.location = 'trainerLogin.htm?act=showTrainingFeedbackList&trainingMasterId=${trainingMasterId}&eventdate=${eventdate}'"><i class="fa fa-pencil-square-o"></i> Show Feedback</button>
                    </c:if>
                </div>
                <div class ="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <c:if test="${assflage eq true}">
                        <button type="button" style="float: right"  class="btn btn-primary" onclick="window.location = 'trainerLogin.htm?act=trainerAssessMent&id=${trainingMasterId}&eventdate=${eventdate}'">Online Assessment</button>
                    </c:if>
                </div>
                <div class ="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <c:if test="${shosts eq false}">
                        <c:if test="${shosts2 eq false}">
                            <button type="submit" class="btn btn-primary" style="float: left" title="" style="width: 100px;"><!--<i class="fa fa-"></i>-->Submit Attendance</button>
                        </c:if>
                    </c:if>
                </div>
                <div class ="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <c:if test="${feedbackStatus eq true}">
                        <button type="button" class="btn btn-primary" style="float: right" title="" style="width: 100px;" onclick="window.location = 'trainerLogin.htm?act=sendFeedback&id=${trainingMasterId}&eventdate=${eventdate}'"><i class="fa fa-pencil-square-o"></i>Receive Feedback</button>
                    </c:if>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
                    <c:if test="${finishStatus eq 0}">
                        <button type="button" class="btn btn-primary" style="float: right" title="" style="width: 100px;" onclick="window.location = 'trainerLogin.htm?act=finishTraining&id=${trainingMasterId}&eventdate=${eventdate}'"><i class="fa fa-pencil-square-o"></i>Finish Training</button>
                    </c:if>
                </div>
            </div>
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
                    </div>
                </div>
            </div>
            <div class="box-body no-padding">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="table table-bordered">

                            <table id="table_1" class="table table-bordered table-striped" style="" align="center"  >
                                <c:choose>
                                    <c:when test="${empty list}">
                                        <tr>

                                            <td align="center">
                                                <c:out value="There is no record found."></c:out>
                                                </td>
                                            </tr>
                                    </c:when>
                                    <c:otherwise>

                                        <thead>
                                            <tr>
                                                <c:if test="${shosts eq true}">
                                                    <c:if test="${shosts2 eq true}">
                                                        <th style="width: 50px;">SR. No</th>
                                                            <%--</c:if>--%> 
                                                        </c:if> 
                                                    </c:if> 
                                                    <c:if test="${shosts eq false}">
                                                        <c:if test="${shosts2 eq false}">
                                                        <th align="Center" style="width: 1px;"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                        </c:if> 
                                                    </c:if> 
                                                <th style="width: 50px;">Training</th>
                                                <th style="width: 50px;">Attendance</th>
                                                <th style="width: 50px;">Status</th>

                                            </tr>
                                        </thead>

                                        <tbody>
                                            <!--${list[0]}-->
                                            <c:forEach var="list"  items="${list}" varStatus="status">
                                                <tr>
                                                    <c:if test="${shosts eq false}">
                                                        <c:if test="${shosts2 eq false}">
                                                            <td align="Center">
                                                                <input type="checkbox" onclick="deleteCheck11();" name="checkId" id="checkId" value="${list[0]}">
                                                            </td>
                                                        </c:if> 
                                                    </c:if> 
                                                    <c:if test="${shosts eq true}">
                                                        <c:if test="${shosts2 eq true}">
                                                            <td>${status.count}</td>
                                                        </c:if> 
                                                    </c:if> 
                                                    <td>${list[1]}</td>
                                                    <!--<td>-->
                                                    <c:if test="${shosts eq true}">
                                                        <c:if test="${list[2] eq 0}">
                                                            <td><b style="color: green">PR</b></td>
                                                        </c:if> 
                                                        <c:if test="${list[2] eq 1}">
                                                            <td><b style="color: red">AB</b></td>
                                                        </c:if> 
                                                    </c:if> 
                                                    <c:if test="${shosts eq false}">
                                                        <td>Attendance not submitted</td>
                                                    </c:if> 

                                            <input type="hidden" id="eventdate" name="eventdate" value="${eventdate}">
                                            <c:if test="${list[3] eq 2}">
                                                <td><a type="button" class="btn btn-default" id="btnType1" onclick="window.location = 'trainerLogin.htm?act=goToAns&id=${list[0]}&eventdate=${eventdate}&trainingMasterId=${trainingMasterId}'" name="btnType" value="AssessMent">Check Paper</a></td>
                                            </c:if> 
                                            <c:if test="${list[3] eq 3}">
                                                <td>Assessment Submitted</td>
                                            </c:if> 
                                            <c:if test="${list[3] eq 1}">
                                                <td><label style="color: red;">FAIL</label></td>
                                            </c:if> 
                                            <c:if test="${list[3] eq 0}">
                                                <td><label style="color: green;">PASS</label></td>
                                            </c:if> 
                                                 <c:if test="${empty list[3] }">
                                                     <td>Assessment Not Submitted</td>
                                                 </c:if>
                                                     
                                    <!--<td><a type="button" class="btn btn-default" id="btnType1" onclick="goToAns(${list[0]},${trainingMasterId},${eventdate})" name="btnType" value="AssessMent">Training Assessment</a></td>-->
                                            <!--</td>-->
                                            </tr>
                                        </c:forEach>
                                        </tbody>

                                    </c:otherwise>

                                </c:choose>

                            </table>
                            <br>


                        </div>
                    </div>

                </div><!-- /.tab-pane -->
            </div>

        </form:form><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        function viewClick(id)
        {
            //            alert('hello '+id);
            window.location = 'trainerLogin.htm?act=editClick&id=' + id;
        }
        //        function deleteCheck11() {
        ////            alert("Hi");
        //            var checkboxes = "";
        //            
        //            checkboxes = document.getElementsByName('checkId');
        //            for(int i=0;i<checkboxes.lengthi++)
        //            {
        //                alert(checkboxes[i]);
        //            }
        //            for (var i = 0, n = checkboxes.length; i < n; i++) {
        //                if (checkboxes[i].checked) {
        //                    return true;
        //                }
        //            }
        //            alert("Please, Select one or more record(s).");
        //            
        //            return false;
        //        }

        //        $("#checkId").live("click", function () {
        //        $("input:checkbox:unchecked").each(function () {
        //            alert("Id: " + $(this).attr("id") + " Value: " + $(this).val());
        //        });
//        };
    </script>

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
