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
        <form:form action="designationMaster.htm?act=deleteClick" method="post" commandName="trainingMaster"
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
                                            <label>Description : </label>&nbsp; &nbsp;<textarea rows="4" style="width: 100%">${trainingMaster.trainingDescription}</textarea>
                                        </div>
                                    </div>
                                         <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class ="col-lg-6 col-md-6 col-sm-12 col-xs-12" style="margin-top:3%; margin-bottom: 3%;">
                                            <table >
                                            <thead>                                          
                                                <tr>
                                                    <th>No.</th>
                                                    <th>Employee name</th>
                                                </tr>
                                            </thead>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Rahul</td>
                                                </tr>
                                                 <tr>
                                                    <td>2</td>
                                                    <td>Rohita</td>
                                                </tr>
                                            </table>
                                        </div>
                                        <div class ="col-lg-6 col-md-6 col-sm-12 col-xs-12"style="margin-top:3%; margin-bottom: 3%;">
                                            <table>
                                                <tr>
                                                    <th>No.</th>
                                                    <th>Employee name</th>
                                                    <th>Absent/Present</th>
                                                </tr>
                                                <tr>
                                                    <td>1</td>
                                                    <td>Rahul</td>
                                                    <td> Absent</td>
                                                </tr>
                                                 <tr>
                                                    <td>2</td>
                                                    <td>Rohita</td>
                                                    <td>Present</td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>

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
