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
            <h1>EMPLOYEE PASSWORD CHANGE:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee Password Change</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=adminChangePassWordSubmit" commandName="employeeMaster" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <input type="hidden" name="userId" id="userId" value="${employeeMaster.userMaster.id}">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--form horizontal starts here-->
                                <div class="box box-info ">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>

                                    </div>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <form:input path="employeeName" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>New Password:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <input type="text" class="form-control" id="password" name="password" placeholder="Enter New Password">
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

