<%--
    Document   : Probationlevel1
    Created on : Dec 16, 2015, 3:38:34 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        ---------------------        <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
        <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Probation To Confirmation</title>
        <script>
            function buttonFun1() {
                var className = $('#minusId1').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId1').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId1').innerHTML = 'Expand';
                }
            }
            function buttonFun2() {
                var className = $('#minusId2').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId2').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId2').innerHTML = 'Expand';
                }
            }
            function buttonFun3() {
                var className = $('#minusId3').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId3').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId3').innerHTML = 'Expand';
                }
            }
            function buttonFun4() {
                var className = $('#minusId4').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId4').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId4').innerHTML = 'Expand';
                }
            }
            function buttonFun5() {
                var className = $('#minusId5').attr('class');
                if (className == 'fa fa-plus') {
                    document.getElementById('spanId5').innerHTML = 'Minimize';
                } else {
                    document.getElementById('spanId5').innerHTML = 'Expand';
                }
            }

        </script>
        <script>
            function saveSubmit11() {
                var flag3 = true;
//            alert("called");
                var selectedValue = document.getElementById("RecomendationTypeSelectId").value;
//                alert(selectedValue);
                if (selectedValue == "Extend") {
                    if (document.getElementById("extendedmonth").value == '') {
                        document.getElementById("recommendationExtendPeriodError").innerHTML = "- It must be Selected";
                        flag3 = false;
                    } else {
                        document.getElementById("recommendationExtendPeriodError").innerHTML = "";
                    }
                    if (document.getElementById("remarkid").value == '') {
                        document.getElementById("recommendationRemarkError").innerHTML = "- It must be Selected";
                        flag3 = false;
                    } else {
                        document.getElementById("recommendationRemarkError").innerHTML = "";
                    }
                } else if (selectedValue == "No") {
                    if (document.getElementById("remarkid").value == '') {
                        document.getElementById("recommendationRemarkError").innerHTML = "- It must be Selected";
                        flag3 = false;
                    } else {
                        document.getElementById("recommendationRemarkError").innerHTML = "";
                    }
                }

                if (flag3) {

                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Saving ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
        </script>
    </head>
    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Probation To Confirmation Form : </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Probation To Confirmation</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <form:form action="probationToConfirmation.htm?act=level1Submit" method="post" commandName="ptc"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="employeeMasterByEmployeeMasterId.id"></form:hidden>
                                    <%--<form:hidden path="reportingManagerId"></form:hidden>--%>
                                    <!--Read only entries Starts here-->
                                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Employee No.:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.employeeId" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Employee Name:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.employeeName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Department:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.departmentMaster.departmentName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Designation:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.designationMaster.designationName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                <!--employeeMasterByEmployeeMasterId.designationMaster.designationName-->
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Level:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.levelMaster.level" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Reporting Manager:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="reportingManagerId" class="form-control" size="16" type="text" value="${reportingLevel1}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Work Location:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="employeeMasterByEmployeeMasterId.locationMaster.location" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Assessment Period:</h3>
                                                <div class="box-tools pull-right">
                                                    <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                    <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">From Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class=" col-sm-7">
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                                                <form:input path="assessmentFromDate" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                                <form:errors path="assessmentFromDate" cssClass="errorDiv"></form:errors>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">To Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class=" col-sm-7">
                                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii" data-link-field="dtp_input1">
                                                                <form:input path="assessmentToDate" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                                <form:errors path="assessmentToDate" cssClass="errorDiv"></form:errors>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">What are the jobs being handled by the employee?</h3><span style="color: red;font-size: 12px;">*</span>
                                                <div class="box-tools pull-right">
                                                    <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">

                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="jobHandled" class="form-control" size="16" type="text" value=""></form:textarea>
                                                            <form:errors path="jobHandled" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Performance Rating:</h3><span style="color: red;font-size: 12px;">*</span>
                                                <div class="box-tools pull-right">
                                                    <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                                    <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <div class="col-md-3 col-sm-3"></div>
                                                            <fieldset id="performanceRating">
                                                                <!--<label class="col-sm-3 control-label">Name of the Joiner:</label>-->
                                                                <div class="col-sm-10 " >
                                                                <c:if test="${ptc.performanceRating eq 'Excellent'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent" checked style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="NeedsImprovement" style="width: 15px;height: 15px" >Needs Improvement
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Very Good'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" checked style="width: 15px;height: 15px"> Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="NeedsImprovement" style="width: 15px;height: 15px" >Needs Improvement
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Good'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" checked style="width: 15px;height: 15px">Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px" >Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="NeedsImprovement" style="width: 15px;height: 15px">Needs Improvement
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'Average'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" checked style="width: 15px;height: 15px">Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" value="NeedsImprovement" style="width: 15px;height: 15px" >Needs Improvement
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq 'NeedsImprovement'}">
                                                                    <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px" > Excellent
                                                                    <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px" > Very Good
                                                                    <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px" >Good
                                                                    <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px">Average
                                                                    <input type="radio" name="performanceRating" id="NeedsImprovement" checked value="NeedsImprovement" style="width: 15px;height: 15px">Needs Improvement
                                                                </c:if>
                                                                <c:if test="${ptc.performanceRating eq ''}">
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="Excellent" value="Excellent"  style="width: 15px;height: 15px"> Excellent
                                                                    </label>
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="Very Good" value="Very Good" style="width: 15px;height: 15px"> Very Good
                                                                    </label>
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="Good"  value="Good" style="width: 15px;height: 15px">Good
                                                                    </label>
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="Average" value="Average" style="width: 15px;height: 15px">Average
                                                                    </label>
                                                                    <label class="radio-inline">
                                                                        <input type="radio" name="performanceRating" id="NeedsImprovement" value="NeedsImprovement" style="width: 15px;height: 15px">Needs Improvement
                                                                    </label>
                                                                </c:if>
                                                            </div>
                                                        </fieldset>
                                                        <!--<div class="col-md-3 col-sm-3">-->
                                                        <!--</div>-->
                                                    </div>
                                                    <div class="col-sm-offset-5 col-sm-4">
                                                        <form:errors path="performanceRating" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Can The Employee Be Confirmed Based On Present Performance?:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="table-responsive">
                                                            <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                <tr>
                                                                    <td >REPORTING MANAGER (RECOMMENDATION)<span style="color: red;font-size: 12px;">*</span></td>
                                                                    <td>
                                                                    <form:select path="recommendationSelect" id="RecomendationTypeSelectId" class="form-control ">
                                                                        <form:option value="">--SELECT--</form:option>
                                                                        <form:option value="Yes">Yes</form:option>
                                                                        <form:option value="No">No</form:option>
                                                                        <form:option value="Extend">Extend</form:option>
                                                                    </form:select>
                                                                    <form:errors path="recommendationSelect" cssClass="errorDiv"></form:errors>
                                                                    </td>
                                                                    <td id="RecomendationExtPeriodId" style="display: none">Extention Period<span style="color: red;font-size: 12px;">*</span></td>
                                                                    <td id="RecomendationExtSelectId" style="display: none">
                                                                    <form:select path="recommendationExtendPeriod" id="extendedmonth" name ="extendedmonth" class="form-control ">
                                                                        <form:option value="">--SELECT--</form:option>
                                                                        <form:option value="1Month">1 Month</form:option>
                                                                        <form:option value="2Month">2 Month</form:option>
                                                                        <form:option value="3Month">3 Month</form:option>
                                                                        <form:option value="4Month">4 Month</form:option>
                                                                        <form:option value="5Month">5 Month</form:option>
                                                                        <form:option value="6Month">6 Month</form:option>
                                                                        <form:option value="7Month">7 Month</form:option>
                                                                        <form:option value="8Month">8 Month</form:option>
                                                                        <form:option value="9Month">9 Month</form:option>
                                                                    </form:select>
                                                                    <span id="recommendationExtendPeriodError" style="color: red;"></span>
                                                                </td>
                                                                <td id="RecomendationRemarkId" style="display: none">Remark<span style="color: red;font-size: 12px;">*</span></td>
                                                                <td id="RecomendationRemarkTxtId" style="display: none">
                                                                    <form:textarea path="recommendationRemark" id="remarkid" name = "remarkid" class="form-control" type="text" value=""></form:textarea>
                                                                        <span id="recommendationRemarkError" style="color: red;"></span>
                                                                </tr>
                                                            </table>
                                                        </div><!-- /.col -->
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <label>Please provide your detailed justification for Confirmation / Extension of Probation / Termination of Services. Kindly Note, the same is mandatory for further process.</label><span style="color: red;font-size: 12px;">*</span>
                                                            <form:textarea path="managerJustification" id="remarkid" name = "remarkid" class="form-control" type="text" value=""></form:textarea>
                                                            <form:errors path="managerJustification" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                        </div>
                                                    <c:if test="${ptc.recomendationByHr ne '' && ptc.recomendationByHr ne null}">
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <label>HR Remarks:</label>
                                                                <form:textarea path="recomendationByHr" class="form-control" type="text" value="" readonly="true" ></form:textarea>
                                                                </div>
                                                            </div>
                                                    </c:if>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-5 col-sm-4">
                                            &nbsp;&nbsp;<button type="submit" style="width: 100px" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <script>
            $(function () {
                $("#RecomendationTypeSelectId").on("change", function () {
                    var selectedValue = this.value;
                    if (selectedValue == "Extend") {
                        $('#RecomendationExtPeriodId').show();
                        $('#RecomendationExtSelectId').show();
                        $('#RecomendationRemarkId').show();
                        $('#RecomendationRemarkTxtId').show();
                    }
                    else if (selectedValue == "No") {
                        $('#RecomendationExtPeriodId').hide();
                        $('#RecomendationExtSelectId').hide();
                        $('#RecomendationRemarkId').show();
                        $('#RecomendationRemarkTxtId').show();
                    }
                    else {
                        $('#RecomendationExtPeriodId').hide();
                        $('#RecomendationExtSelectId').hide();
                        $('#RecomendationRemarkId').hide();
                        $('#RecomendationRemarkTxtId').hide();
                    }
                });
            });</script>
        <!--         <script type="text/javascript">
                $('.form_datetime').datetimepicker({
                    weekStart: 1,
                    todayBtn: 1,
                    autoclose: 1,
                    todayHighlight: 1,
                    startView: 2,
                    forceParse: 0,
                    showMeridian: 1
        //             startDate: new Date()
                });
            </script>-->

        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
