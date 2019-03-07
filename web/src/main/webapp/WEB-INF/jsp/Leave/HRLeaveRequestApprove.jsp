<%--
    Document   : LeaveRequestApprove
    Created on : Oct 16, 2015, 6:11:21 PM
    Author     : AJAY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <script>
//        $(function () {

        $(document).ready(function () {
//            alert('ajay');
            var noOfDay = document.getElementById("noOfDays").value;
            var leaveType1 = document.getElementById("leaveType").value;
            var leaveType = document.getElementById(leaveType1).innerHTML = noOfDay;
//            document.getElementById(leaveType1 + "2").innerHTML = document.getElementById(leaveType1 + "1").innerHTML - document.getElementById(leaveType1).innerHTML;
            document.getElementById(leaveType1 + "2").innerHTML = document.getElementById(leaveType1 + "1").innerHTML;
        });



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
        function buttonFun6() {
            var className = $('#minusId6').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId6').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId6').innerHTML = 'Expand';
            }
        }
    </script>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Leave Application Request:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Leave Request</li>
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
                            <form:form action="leaveEmployeeDetail.htm?act=HRapproveRequestAdminClick" method="post" commandName="leaveEmployeeDetail"
                                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                <form:hidden path="id"></form:hidden>
                                    <!--form horizontal starts here-->
                                    <!--Read only entries Starts here-->

                                    <!--Employee detail completes here-->
                                    <!--read only entries ends here-->

                                    <!--form horizontal starts here-->
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
                                                        <input type="hidden" name="empid" id="empid" value="${employeeMaster[0]}">
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
                                    </div>
                                </div>
                                <!--Employee detail completes here-->
                                <!--read only entries ends here-->

                                <div class="box box-info collapsed-box">

                                    <div class="box-header">
                                        <h3 class="box-title">Leave Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2()"><i class="fa fa-plus" id="minusId2"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <c:forEach var="list" items="${list}">
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label>Leave Type:</label>
                                                            <input type="text" name="leaveType" id="leaveType" value="${list[0]}" class="form-control" readonly=""/>
                                                            <%--<form:select path="" id="poolCarRequestSelectId" class="form-control ">--%>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class=" col-sm-4">
                                                            <label>Leave Start Date:</label>
                                                            <input type="text" value="${list[1]}" class="form-control" readonly=""/>
                                                        </div>
                                                        <c:if test="${list[0] ne 'Short Leave'}">

                                                            <div class="col-sm-2">
                                                                <label></label>
                                                                <input type="text" value="${list[2]}" class="form-control" readonly=""/>
                                                            </div>
                                                        </c:if>

                                                        <div class=" col-sm-4">
                                                            <label>Leave End Date:</label>
                                                            <input type="text" value="${list[3]}" class="form-control" readonly=""/>
                                                        </div>
                                                        <c:if test="${list[0] ne 'Short Leave'}">

                                                            <div class="col-sm-2">
                                                                <label></label>
                                                                <input type="text" value="${list[4]}" class="form-control" readonly=""/>
                                                            </div>
                                                        </c:if>

                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            <label>Number Of Days:</label>
                                                            <%--<form:input path="leaveDays" type="number" class="form-control" readonly="true"></form:input>--%>
                                                            <input id="noOfDays" name="noOfDays" type="number" class="form-control" readonly="true" value="${list[5]}"/>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                    <!--Leave Detail completes Here-->

                                    <div class="box box-info collapsed-box">
                                        <div class="box-header">
                                            <h3 class="box-title">Reason In Detail:</h3>
                                            <div class="box-tools pull-right">
                                                <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3()"><i class="fa fa-plus" id="minusId3"></i></button>
                                            </div>
                                        </div><!-- /.box-header -->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">Reason :</label>
                                                        <div class="col-sm-7">
                                                            <textarea id="empRemark" class="form-control" rows="6" readonly="">${list[6]}</textarea>
                                                        </div>
                                                    </div>
                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div>
                                </c:forEach>
                                <!--Reason For Leave In Detail completes Here-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Leave Balance Sheet In Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4()"><i class="fa fa-plus" id="minusId4"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table-responsive">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th>Leave</th>
                                                                <c:forEach var="remain" items="${listRemain}">
                                                                <th>${remain.key}</th>
                                                                </c:forEach>
                                                        </tr>
                                                        <tr>
                                                            <td>Leave Balance In Start Of The Year</td>
                                                            <c:forEach var="totalDays" items="${totalDaysMap}">

                                                                <td>${totalDays.value}</td>
                                                            </c:forEach>

                                                        </tr>
                                                        <tr>
                                                            <td>No. Of Leaves Applied During The Year</td>
                                                            <c:forEach var="empreq" items="${empReqMap}">
                                                                <td>${empreq.value}</td>
                                                            </c:forEach>

                                                        </tr>
                                                        <tr>
                                                            <td>Current Available Balance</td>
                                                            <c:forEach var="remain" items="${listRemain}">
                                                                <td id="${remain.key}1">${remain.value}</td>

                                                            </c:forEach>
                                                        </tr>
                                                        <tr>
                                                            <td>No. Of Leaves Applied In This Application</td>
                                                            <c:forEach var="remain" items="${listRemain}">
                                                                <td id="${remain.key}">0</td>
                                                            </c:forEach>

                                                        </tr>
                                                        <tr>
                                                            <th>Projected Balance After This Application Approval</th>

                                                            <c:forEach var="remain" items="${listRemain}">
                                                                <th id="${remain.key}2">0</th>
                                                                </c:forEach>
                                                        </tr>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>

                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Same Day Leave:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId6">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6()"><i class="fa fa-plus" id="minusId6"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body">
                                        <div class="row">

                                            <div class="col-md-12 col-sm-12">

                                                <div class="table table-bordered">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty sameDateCheck}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no record found."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>

                                                                    <tr>
                                                                        <th>Employee Name</th>
                                                                        <th>No of Day</th>
                                                                        <th>Start Date</th>
                                                                        <th>End Date</th>
                                                                        <th>Status</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${sameDateCheck}">
                                                                <tr>
                                                                    <td>${list[5]}</td>
                                                                    <td>${list[4]}</td>
                                                                    <td>${list[0]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>Approved</td>

                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>

                                <!--Leave Balance Shit In Detail completes Here-->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Approver Comments:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5()"><i class="fa fa-plus" id="minusId5"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Comments/Remark:</label>
                                                    <div class="col-sm-7">
                                                        <textarea id="hrRemark" name="hrRemark" class="form-control" rows="6"></textarea>
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Approval History:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId6">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun6()"><i class="fa fa-plus" id="minusId6"></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body">
                                        <div class="row">

                                            <div class="col-md-12 col-sm-12">

                                                <div class="table table-bordered">
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <c:choose>
                                                            <c:when test="${empty approvalHistoryList}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="There is no record found."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>

                                                                    <tr>
                                                                        <th>Approval Name</th>
                                                                        <th>Approval Comment</th>
                                                                        <th>Approved Date</th>
                                                                        <th>Status</th>
                                                                    </tr>
                                                                </thead>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="list" items="${approvalHistoryList}">
                                                                <tr>
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td>${list[4]}</td>
                                                                    <td>${list[3]}</td>

                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>

                                
                                <c:if test="${list[0][7] eq 3 || list[0][7] eq 0 || list[0][7] eq 8}">
                                    <div class="form-group">
                                        <div class="col-sm-4" style="text-align: left">
                                            <button type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-success" style="width: 100px" data-original-title="" title="" value="approve">APPROVE</button>
                                        </div>
                                        <div class="col-sm-4" style="text-align: center">
                                            <button type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-warning" style="width: 100px" data-original-title="" title="" value="rework">REWORK</button>
                                        </div>
                                        <div class="col-sm-4" style="text-align: right">
                                            <button type="submit" name="btnSubmit" id="btnSubmit" class="btn btn-danger" style="width: 100px" data-original-title="" title="" value="reject">REJECT</button>
                                        </div>
                                    </div>
                                </c:if>
                            </form:form>

                            <!--form horizontal ends here-->
                            <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
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
            forceParse: 0,
            showMeridian: 1
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
