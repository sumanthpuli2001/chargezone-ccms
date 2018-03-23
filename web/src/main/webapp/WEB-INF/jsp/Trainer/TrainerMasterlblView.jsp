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
        <!--<meta http-equiv="X-UA-Compatible" content="IE=edge">-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">-->
<!--<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">-->
<!--<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">-->
<link rel="shortcut icon" href="StorageYard/Images/Icon/favicon.ico" type="image/x-icon">
<link rel="icon" href="StorageYard/Images/Icon/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="StorageYard/CSS/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="StorageYard/CSS/bootstrap/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" href="StorageYard/Plugins/fullcalendar/fullcalendar.min.css">
<link rel="stylesheet" href="StorageYard/Plugins/fullcalendar/fullcalendar.print.css" media="print">
<link rel="stylesheet" href="StorageYard/Plugins/datatables/jquery.dataTables.min.css">
<link rel="stylesheet" href="StorageYard/Plugins/iCheck/square/blue.css">
 <!--Theme style--> 
<!--<link rel="stylesheet" href="StorageYard/CSS/bootstrap/vms.css">-->
<!-- Employyee Search css -->
<link rel="stylesheet" href="StorageYard/CSS/bootstrap/token-input.css">
<link rel="stylesheet" href="StorageYard/CSS/bootstrap/token-input-fb.css">
<link rel="stylesheet" href="StorageYard/CSS/bootstrap/_all-skins.min.css">
<script type="text/javascript" src="StorageYard/Plugins/jQuery/jQuery-2.1.4.min.js"></script>

<link rel="stylesheet" href="StorageYard/CSS/bootstrap-datetimepicker.css">
<script type="text/javascript" src="StorageYard/JS/bootstrap-datetimepicker.js" charset="UTF-8"></script>

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
            <h1>Trainings Details:</h1>
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
            
            <br>
            <input type="hidden" id="trainingMasterId" name="trainingMasterId" value="${trainingMasterId}">
            <input type="hidden" id="eventdate" name="eventdate" value="${eventdate}">
            <!--<input type="hidden" id="allTrainingsId" name="allTrainingsId" value="${list[0]}">-->
            <section class="content">
                <input type="button" class="btn btn-primary" value="Back" style="float: left" onclick="window.location='trainerLogin.htm?act=showcalendar'" />
                <button type="button" class="btn btn-primary" style="float: right" title="" style="width: 100px;" onclick="window.location='trainerLogin.htm?act=showTrainingFeedbackList'"><i class="fa fa-pencil-square-o"></i>Show Feedback</button>
                <div class="row">
                    <div class="col-md-12">
                        
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            
                            
                            <div class="tab-content">
                                <!--<button type="button" class="btn btn-primary" title="" style="float: right; width: 120px;" onclick="window.history.back();"></i>&nbsp;&nbsp;BACK</button>-->
                                <c:if test="${feedbackStatus eq true}">
                                <button type="button" class="btn btn-primary" style="float: right" title="" style="width: 100px;" onclick="window.location='trainerLogin.htm?act=sendFeedback&id=${trainingMasterId}&eventdate=${eventdate}'"><i class="fa fa-pencil-square-o"></i>Get Feedback</button>
                                </c:if>

                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">

                                    <div class="row">

                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center"  >
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
                                                                        <th style="width: 50px;">SR. No</th>
                                                                        </c:if> 
                                                                        <c:if test="${shosts eq false}">
                                                                        <th align="Center" style="width: 1px;"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                        </c:if> 
                                                                    <th style="width: 50px;">Trainings</th>
                                                                    <th style="width: 50px;">Attendance</th>
                                                                    <th style="width: 50px;">CheckPaper</th>

                                                                </tr>
                                                            </thead>

                                                            <tbody>
                                                                <!--${list[0]}-->
                                                                <c:forEach var="list"  items="${list}" varStatus="status">
                                                                    <tr>
                                                                        <c:if test="${shosts eq false}">
                                                                            <td align="Center">
                                                                                <input type="checkbox" onclick="deleteCheck11();" name="checkId" id="checkId" value="${list[0]}">
                                                                            </td>
                                                                        </c:if> 
                                                                        <c:if test="${shosts eq true}">
                                                                            <td>${status.count}</td>
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
                                                                            <td></td>
                                                                        </c:if> 
                                                                        <td><button type="button" class="btn btn-primary" id="btnType1" onclick="goToAns(${list[0]})" name="btnType" value="AssessMent" style="width: 100px" >Ans</button></td>
                                                                        <!--</td>-->
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>

                                                    </c:choose>

                                                </table>
                                                <br>
                                                <c:if test="${shosts eq false}">
                                                    <button type="submit" class="btn btn-primary" style="float: left" title="" style="width: 100px;"><!--<i class="fa fa-"></i>-->Submit</button>
                                                </c:if>
                                                <c:if test="${shosts eq true}">
                                                    <a style="float: right"  class="btn btn-primary" onclick="window.location = 'trainerLogin.htm?act=trainerAssessMent&id=${trainingMasterId}&eventdate=${eventdate}'">Online Assessment</a>
                                                </c:if>
                                            </div>
                                        </div>

                                    </div><!-- /.tab-pane -->
                                </div>
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>

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