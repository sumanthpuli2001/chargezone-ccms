<%--
    Document   : EmployeeRegistrationForm
    Created on : Oct 3, 2015, 10:16:00 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Employee Shift Change</title>
    </head>
    <script>
        var flag3 = true;
        function saveSubmit11() {
//            alert("vxcvxcvjk");
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
    <script>
        $(document).ready(function () {
            shift();
            var rotationId = document.getElementById("shiftId").value;
            selectShift(rotationId);
        });

        function shift() {
            var selectedValue = document.getElementById('WorkTypeSelectId').value;
            if (selectedValue == "HourlyBase") {
                $('#hourlyBaseTitleDiv').show();
                $('#shiftNameDiv').hide();
                $('#shiftMasterId').hide();
                $('#shiftRotationDateDiv').hide();
            } else if (selectedValue == "ShiftBase") {
                $('#shiftNameDiv').show();
                $('#shiftMasterId').show();
                $('#hourlyBaseTitleDiv').hide();
                $('#shiftRotationDateDiv').show();
            } else {
                $('#hourlyBaseTitleDiv').hide();
                $('#shiftNameDiv').hide();
                $('#shiftMasterId').hide();
                $('#shiftRotationDateDiv').hide();
            }
        }
        function selectShift(rotationId) {

            var userId = document.getElementById("userId").value;
//            document.getElementById('shiftMasterId').innerHTML = "Fetching ... .. .";
            $.post("shiftRotationMaster.htm?act=readRotationAjax",
                    {
                        rotationId: rotationId, userId: userId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    document.getElementById('shiftMasterId').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    alert("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }


    </script>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Shift Change Form:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Shift Change Form</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=changeEmployeeShiftSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <form:hidden path="id"></form:hidden>
                <input type="hidden" name="userId" id="userId" value="${employeeMaster.userMaster.id}">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--form horizontal starts here-->
                                <div class="box box-info ">
                                    <div class="box-header">
                                        <h3 class="box-title">Shift Detail:</h3>

                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Name:</label>
                                                        <form:input path="employeeName" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Work Type:</label>
                                                            <select name="shiftType" id="WorkTypeSelectId" class="form-control" onchange="shift();">
                                                            <c:if test="${shiftType eq 'HourlyBase'}">
                                                                <option value="HourlyBase" selected="">Hourly Base</option>
                                                                <option value="ShiftBase">Shift Base</option>
                                                            </c:if>
                                                            <c:if test="${shiftType eq 'ShiftBase'}">
                                                                <option value="ShiftBase" selected="">Shift Base</option>
                                                                <option value="HourlyBase">Hourly Base</option>
                                                            </c:if>
                                                            <c:if test="${shiftType eq ''}">
                                                                <option value="" label="-- Select --" ></option>
                                                                <option value="HourlyBase" label="Hourly Base"></option>
                                                                <option value="ShiftBase" label="Shift Base"></option>
                                                            </c:if>

                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group" >
                                                    <div class="col-sm-6" id="hourlyBaseTitleDiv">
                                                        <label>Hourly Base Title:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <select name="shiftHoursId" id="shiftHoursId" class="form-control">
                                                            <c:forEach var="hours1" items="${hours}">
                                                                <option value="${hours1.key}">${hours1.value}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group" >
                                                    <div class="col-sm-6" id="shiftNameDiv">
                                                        <label>Shift Rotation Name:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <select name="shiftId" id="shiftId" class="form-control" onchange="selectShift(this.value)">
                                                            <option value="" label="-- Select --" ></option>
                                                            <c:forEach var="shift1" items="${rotationMap}">
                                                                <c:if test="${shift1.key eq employeeMaster.shiftHoursId}">
                                                                    <option value="${shift1.key}" selected="">${shift1.value}</option>
                                                                </c:if>
                                                                <c:if test="${shift1.key ne employeeMaster.shiftHoursId}">
                                                                    <option value="${shift1.key}" >${shift1.value}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </select>
                                                    </div>

                                                    <div class="col-sm-6" id="shiftMasterId">
                                                        <label>Shift Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <select name="shiftMasterId" id="shiftMasterId" class="form-control">
                                                            
                                                        </select>

                                                    </div> 
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6" id="shiftRotationDateDiv">
                                                        <label>Shift Rotation Date:<span style="color: red;font-size: 12px;">*</span></label>

                                                        <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                            <form:input path="shiftRotationDate" class="form-control" size="16" value="" readonly="true"></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class=" col-sm-12" style="text-align: center;">
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" >Submit</button>
                                        </div>
                                    </div>
                                </div>
                            </div>


                            <div class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>

                </section>
        </form:form>
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

