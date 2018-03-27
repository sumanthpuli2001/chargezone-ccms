<%-- 
    Document   : TrainingMasterlblview
    Created on : 9 Mar, 2018, 3:27:37 PM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
        function sendId() {
            var trainingId = document.getElementById("TrainingId").value;
      
//            window.location ="trainingIdentification.htm?act=showTrainingFeedbackList&val=" + val;
            window.location = 'trainingIdentification.htm?act=showTrainingFeedbackList&trainingId=' + trainingId;
        }
    </script>
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
        <br>
        <input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />
        <button type="submit" style="width: 150px !important" class="btn btn-primary" title="" onclick="sendId();"><i class="fa fa-search"></i>&nbsp;&nbsp;Show Feedback</button>
        <form:form action="" method="post" 
                   name='form1' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                
                                <!--                                <button type="button" class="btn btn-primary" title="" style="float: right; width: 120px;" onclick="window.location = 'trainingMaster.htm?act=createClick'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                                                <button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>-->
                                <div class="box-header">
                                </div>
                                <div class="row">

                                    <input type="hidden" id="TrainingId" name="TrainingId" value="${trainingMaster.id}">
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
                                            <label>Description : </label>&nbsp; &nbsp;${trainingMaster.trainingDescription}
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-sm-12">
                                        <h2 align="center">Trainee List</h2>
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
                                                                <th style="width: 50px;">SR. No</th>
                                                                <th style="width: 50px;">Employee Name</th>
                                                                <th style="width: 50px;">Attendance</th>

                                                            </tr>
                                                        </thead>

                                                        <tbody>
                                                            <c:forEach var="list"  items="${list}" varStatus="status">
                                                                <tr>
                                                                    <td>${status.count}</td>
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

                                                                    <!--</td>-->
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
                                        </div>
                                        

                                    </div><!-- /.col -->

                                </div>
                            </div><!-- /.tab-content -->
                        </div>
                    </div>
                </div><!-- nav-tabs-custom -->
            </section>
        </div><!-- /.col -->




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
</style>
