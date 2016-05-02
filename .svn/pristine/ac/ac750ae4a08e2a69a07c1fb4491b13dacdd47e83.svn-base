<%-- 
    Document   : AppraisalFillingDataCreate
    Created on : Oct 26, 2015, 12:05:43 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appraisal Filling Data Create</title>
    </head>
    <script>
        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }

//        function appraisalFillingdata() {
//            var startDate = document.getElementById("startDate").value;
//            var startDateCopy = document.getElementById("startDate").value;
//            alert(startDate);
//            var endDate = document.getElementById("endDate").value;
//            var endDateCopy = document.getElementById("endDate").value;
//            alert(endDate);
//            startDate = startDate.split('/');
//            endDate = endDate.split('/');
//            startDate = new Date(startDate[2], startDate[1], startDate[0]);
//            endDate = new Date(endDate[2], endDate[1], endDate[0]);
//            var fillingDays = ((startDate - endDate) / (1000 * 60 * 60 * 24)) + 1;
//            alert("startDate"+startDate);
//            alert("endDate"+endDate);
//            if (startDate < endDate) {
//
//                alert('please select Start Date After End Date.');
//            }else{
//                
//            }
//            if (fillingDays <= 0) {
//                alert('please select Start Date After End Date.');
//            }
//        }
    </script>




    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Appraisal Filling Data Create: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage1}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage2}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage3}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="appraisalFillingData.htm?act=createSubmit" method="post" commandName="appraisalFillingData"
                   name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">

            <!--<form class="form-horizontal" role="form" commandName>-->

            <!--Read only entries Starts here-->
            <!--<div class="box box-info collapsed-box ">-->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <div class="box-header">

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Year:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="year" class="form-control" placeholder="Enter Year"></form:input>
                                                    <form:errors path="year" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Employee Time-Line Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="startDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="startDate" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Time-Line End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="endDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="endDate" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                    <div class="col-sm-6">
                                                        <label>Employee Time-Line Mid Year Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="midYearStartDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="midYearStartDate" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Time-Line Mid Year End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="midYearEndDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="midYearEndDate" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                    <div class="col-sm-6">
                                                        <label>Employee Time-Line End Year Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="yearEndStartDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="yearEndStartDate" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Time-Line End Year End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="yearEndEndDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="yearEndEndDate" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Manager Time-Line Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="managerStartDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="managerStartDate" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                    <div class="col-sm-6">
                                                        <label>Manager Time-Line End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="managerEndDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="managerEndDate" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Manager Time-Line Mid-Year Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="managerMidYearStartDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="managerMidYearStartDate" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                    <div class="col-sm-6">
                                                        <label>Manager Time-Line Mid-Year End Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="managerMidYearEndDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="managerMidYearEndDate" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>



                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Manager Time-Line Year-End Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="managerYearEndStartDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="managerYearEndStartDate" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                    <div class="col-sm-6">
                                                        <label>Manager Time-Line Year-End  End-Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <form:input path="managerYearEndEndDate"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="managerYearEndEndDate" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.tab-content -->
                                    <hr/>
                                    <button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button> 
                                </div><!-- nav-tabs-custom -->
                            </div><!-- /.col -->
                        </div>
                </section>
        </form:form> 
        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane --> 
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
    <script>
        $('#carriedForwardStatus1').on('ifChecked', function (event) {
            $('#chechBoxDivId').show(500);
        });
        $('#carriedForwardStatus1').on('ifUnchecked', function (event) {
            $('#chechBoxDivId').hide(500);
        });


    </script>
</html>
