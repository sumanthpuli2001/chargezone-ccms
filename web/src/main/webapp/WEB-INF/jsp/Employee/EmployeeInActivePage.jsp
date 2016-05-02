<%-- 
    Document   : EmployeeInActivePage
    Created on : 13 Apr, 2016, 5:34:56 PM
    Author     : HRINTRA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Employee InActive</title>
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
            <h1>Employee InActive:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Employee InActive</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="employeeMaster.htm?act=inActiveEmployeeSubmit" commandName="employeeMaster"  method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <input type="hidden" name="empId" id="empId" value="${empId}">
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
                                                        <label>Employee Name:</label>
                                                        <form:input path="employeeName" class="form-control" readonly="true"></form:input>
                                                        </div>
                                                    <div class="col-sm-6">
                                                        <label>Date Of Reliving:</label>
                                                          <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy - hh:ii " data-link-field="dtp_input1">
                                                          <form:input class="form-control" path="dateOfLeaving" readonly='true'></form:input>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
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
            forceParse: 0,
            showMeridian: 1  
//            startDate: new Date()
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

</html>


