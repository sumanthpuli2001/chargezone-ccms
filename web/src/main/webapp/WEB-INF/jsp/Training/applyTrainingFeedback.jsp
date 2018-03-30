<%-- 
    Document   : applyTrainingFeedback
    Created on : Mar 15, 2018, 4:01:02 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Create Budget</title>
    </head>
    <script>
        function checkBlankField() {
            var flag = true;
            if ($('#trainingFeedback').val() == '') {
                document.getElementById('trainingFeedbackError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            if ($('#description').val() == '') {
                document.getElementById('descriptionError').innerHTML = '-It must not be empty or white space.';
                flag = false;
            }
            return flag;
        }

        function trainingOnChange(idString) {
            if (document.getElementById(idString).innerHTML != null) {
                document.getElementById(idString).innerHTML = '';
            }
        }
    </script>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Feedback</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Feedback</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <h1>Trainings Details:</h1>
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

                </div>

            </div>

            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-header">
                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                        </div>
                                        <!--<div class="form-group">-->


                                        <form:form class="form-horizontal" method="post" onsubmit='return checkBlankField();'
                                                   commandName="employeeFeedback" action="trainingIdentification.htm?act=submitEmployeeFeedbackCreate&eventdate=${eventdate}">
                                            <input type ="hidden" id="id2" name="id2" value="${id}">
                                            <input type ="hidden" id="id2" name="eventdate" value="${eventdate}">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Feedback <span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="trainingFeedback.id" id="trainingFeedback" class="form-control" onchange="trainingOnChange('trainingFeedbackError');">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${list}"/>
                                                    </form:select>
                                                    <span style="font-size: 14px; color: #dd4b39;" id="trainingFeedbackError"></span>
                                                    <%--<form:errors path="trainingMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                </div>

                                                <div class="col-md-12 col-sm-12">
                                                    <label>Description:<span style="color: red;font-size: 12px;">*</span></label><br>
                                                    <form:textarea style="resize: none; width:515px !important"  path="description" id="description" onchange="trainingOnChange('descriptionError');"></form:textarea><br>
                                                        <span style="font-size: 14px; color: #dd4b39;" id="descriptionError"></span>
                                                    </div>
                                                </div> 


                                                <div class="form-group">
                                                    <div class="col-sm-6 col-sm-offset-5">
                                                        <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                                    </div>

                                                </div>
                                        </form:form>
                                        <!--</div>-->

                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div>
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section>
    </div>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });

    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
