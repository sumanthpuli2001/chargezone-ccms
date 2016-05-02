<%-- 
    Document   : attendanceRegularizationFormForEmployee
    Created on : Oct 6, 2015, 10:38:59 AM
    Author     : Dhaval Patel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
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
        function hourCheck() {
            var hour = document.getElementById("noOfHoursWork").value;
            hour = hour.replace(":", ".");
            if (hour < 4) {
                $("#coffdiv").show();
                document.getElementById("leaveEndDate_SelectFullOrHalfId").value = '';
                setTimeout(function () {
                    $("#coffdiv").fadeOut();
                }, 10000);
            }
        }
    </script>
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
    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Co Off Form : </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Co Off</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="cOffLeaveRequest.htm?act=createSubmit" commandName="cOffLeaveRequest" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>


            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--form horizontal starts here-->
                                <form class="form-horizontal" role="form">

                                    <!--Read only entries Starts here-->    
                                    <div class="box box-info collapsed-box ">
                                        <div class="box-header">
                                            <h3 class="box-title">Employee Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1()"><i class="fa fa-plus" id="minusId1"></i></button>
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
                                                            <input type="Text" class="form-control" value="${employeeMaster[0]}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Employee Name:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster[1]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Designation:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster[2]}" readonly>
                                                        </div>
                                                        <div class="col-sm-2">
                                                            <label>Level:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${employeeMaster[3]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Department:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control"  value="${employeeMaster[4]}" readonly>
                                                        </div>

                                                        <div class="col-sm-2">
                                                            <label>Work Location:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control"  value="${employeeMaster[5]}" readonly>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-2">
                                                            <label>Reporting Manager:</label>
                                                        </div>
                                                        <div class="col-sm-4">
                                                            <input type="Text" class="form-control" value="${reportingManager}" readonly>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Time In Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Date:</label>
                                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                                <form:input path="dateOf"  class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            <form:errors path="dateOf" cssClass="errorDiv"></form:errors>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <label>No Of Hours</label>
                                                                <div class="input-group date form_datetime1" data-date-format="hh:ii " data-link-field="dtp_input1">
                                                                <form:input path="noOfHoursWork" class="form-control" size="16" type="text" value="" readonly="true" onchange="hourCheck();"></form:input>
                                                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                </div>
                                                            <form:errors path="noOfHoursWork" cssClass="errorDiv"></form:errors>  
                                                                <div  id="coffdiv" name="coffdiv" style="color: red; display: none;">C-Off Apply For Minimun 4 Hours.</div>
                                                            </div>

                                                        </div>
                                                    </div><!-- /.col -->
                                                </div><!-- /.row -->
                                            </div><!-- /.box-body -->
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Reason In Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                                </div>
                                            </div>
                                            <div class="box-body no-padding">
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Reason for Request:</label>
                                                            <div class="col-sm-7">
                                                            <form:textarea  path="leaveFor" class="form-control" rows="6"/> 
                                                        </div>
                                                        <form:errors path="leaveFor" cssClass="errorDiv"></form:errors>  
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--                                            <div class="box-body no-padding">
                                                                                            <div class="row">
                                                                                                <div class="col-md-12 col-sm-12">
                                                                                                    <div class="form-group">
                                                                                                        <label class="col-sm-3 control-label">Remark:</label>
                                                                                                        <div class="col-sm-7">
                                        <%--<form:textarea  path="remark" class="form-control" rows="6"/>--%>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>-->
                                    </div>
                                    <!--Reason In Detail completes Here-->
                                    <div class="form-group">
                                        <div class="col-lg-offset-2 col-sm-3">
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="">Submit</button>
                                        </div>
                                    </div>
                                </form>
                                <!--form horizontal ends here-->
                                <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section><!-- /.content -->
        </form:form>
    </div><!-- /.content-wrapper -->
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
    <script type="text/javascript">
        $('.form_datetime1').datetimepicker({
            //            language: 'fr',
            weekStart: 1,
            //            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 1,
            minView: 0,
            maxView: 1,
            forceParse: 0
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
