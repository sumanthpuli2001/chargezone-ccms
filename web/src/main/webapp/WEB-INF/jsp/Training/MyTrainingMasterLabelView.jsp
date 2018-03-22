<%-- 
    Document   : MyTrainingMasterLabelView
    Created on : Mar 19, 2018, 11:04:59 AM
    Author     : DELL3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Calendar</title>
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
            <input type="hidden" id="id" name="id" value="${trainingMaster.id}"/>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${showFeedbackButton eq true}">
                                <button type="button" class="btn btn-primary" style="width: 100px;" onclick="window.location = 'trainingIdentification.htm?act=sendFeedback&id=${trainingMaster.id}'"><i class="fa fa-pencil"></i>&nbsp;&nbsp;Feedback</button>
                                </c:if>
                                <!--<button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>-->
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
                                            <label>Description : </label>&nbsp; &nbsp;
                                            ${trainingMaster.trainingDescription}</textarea>
                                        </div>
                                    </div>

                                </div>
                            </div><!-- /.tab-content -->
                        </div>
                        <input type="button" class="btn btn-primary" value="Back" onclick="window.location = 'trainingIdentification.htm?act=showcalendar'" />
                    </div>
                </div><!-- nav-tabs-custom -->
            </section>
            <!--        </div> /.col -->




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
