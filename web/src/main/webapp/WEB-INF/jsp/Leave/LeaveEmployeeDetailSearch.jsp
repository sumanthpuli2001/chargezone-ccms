<%--
    Document   : LeaveEmployeeDetailSearch
    Created on : Oct 19, 2015, 4:03:28 PM
    Author     : AJAY
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Leave Detail Search</title>
    </head>

    <script>

        var flag3 = true;
        function saveSubmit11() {
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Searching ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>
    <script>
        function selectsubtype(typeId) {

            var empSubTypeId = document.getElementById("subTypeId").value;
//            document.getElementById('EmployeeId').innerHTML = "Fetching ... .. .";
            $.post("employeeMaster.htm?act=readEmpTypeAjax",
                    {
                        typeId: typeId,
                        empSubTypeId: empSubTypeId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt" + responseTxt);
//                    alert(responseTxt);
                    document.getElementById('employeeSubTypeId').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }

        $(document).ready(function () {
            var empTypeId = document.getElementById("employeeTypeMaster.id").value;
            selectsubtype(empTypeId);
        });
    </script>
    <script>
        function showDiv(element)
        {
            if (element == 7)
            {
                document.getElementById("uAsSickId").style.display = 'block';
            }
            else
            {
                document.getElementById("uAsSickId").style.display = 'none';
            }
        }

    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>SEARCH EMPLOYEE LEAVE DETAIL</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Search Leave Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form" action="leaveEmployeeDetail.htm?act=searchEmpLeaveDetailSubmit" commandName="employeeMaster" enctype="multipart/form-data"  method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <!--<span style="color: red;font-size: 14px;">* indicates mandatory field.</span>-->
                                <!--form horizontal starts here-->

                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">                                          
                                            <div class="form-group">
                                                <div class="col-sm-6"><span style="color: red;font-size: 12px;"></span>
                                                    <label>Employee Name:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="employeeName" class="form-control"></form:input>
                                                        <form:errors path="employeeName" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Business Unit:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="departmentMaster" id="departmentMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${deptMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="departmentMaster" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Designation:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="designationMaster" id="designationMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${desigList}"></form:options>
                                                        </form:select>
                                                        <form:errors path="designationMaster" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                    <div class="col-sm-6">
                                                        <label>Leave Type:<span style="color: red;font-size: 12px;"></span></label>
                                                        <select name="leaveType" id="leaveType" onchange="showDiv(this.value);" class="form-control">
                                                            <option value="">--Select--</option>
                                                        <c:forEach var="map" items="${leaveTypemap11}">
                                                            <option value="${map.key}">${map.value}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div id="uAsSickId" style="display: none;margin-left: 2px;">
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        <label>Use As a Sick Leave:<span style="color: red;font-size: 12px;"></span></label>
                                                        <fieldset id="group1">
                                                            <input type="radio" name="useAsSickLeave" value="1" > Yes
                                                            <input type="radio" name="useAsSickLeave" value="0" checked> No
                                                        </fieldset>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Department:<span style="color: red;font-size: 12px;"></span></label>
                                                    <select name="employeeTypeMaster" id="employeeTypeMaster" onchange="selectsubtype(this.value);" class="form-control">
                                                        <option value="">--Select--</option>
                                                        <c:forEach var="map" items="${EmployeeTypeList}">
                                                            <option value="${map.key}">${map.value}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-sm-6" id="employeeSubTypeId">
                                                    <label>Division:<span style="color: red;font-size: 12px;"></span></label>
                                                    <input type="hidden" name="subTypeId" id="subTypeId" value="${employeeMaster.employeeSubType.id}">
                                                    <select name="employeeSubType" id="employeeSubType" class="form-control">
                                                        <option value="" label="-- Select --" ></option> 
                                                    </select>
                                                </div>    
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Start Date:<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <input type="text" id="startDate" name="startDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                        <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>

                                            </div>

                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="form-group">
                                    <div class=" col-sm-2">
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                                    </div>
                                </div>

                                <div class="tab-pane" id="tab_3"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>
        <form:form action="leaveTypeMaster.htm?act=deleteSubmit" method="post" commandName="leaveTypeMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <div class="box-header" style="text-align: right;">
                                    <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'leaveEmployeeDetail.htm?act=exportToExcelForLeaveRequest'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty list11}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Employee Id</th>
                                                                    <th>Employee Name</th>
                                                                    <!--<th>Business Unit</th>-->
                                                                    <!--<th>Designation</th>-->
                                                                    <th>Department</th>
                                                                    <th>Division</th>
                                                                    <th>Leave Type</th>
                                                                    <!--<th>Use As Sick Leave</th>-->
                                                                    <th>Start Date</th>
                                                                    <th>End Date</th>
                                                                    <th>Date of Submission</th>
                                                                    <th>No Of Days</th>
                                                                    <th>Status</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list11" items="${list11}">
                                                            <tr>
                                                                <td>${list11[0]}</td>
                                                                <td>${list11[1]}</td>
                                                                <!--<td>${list11[2]}</td>-->
                                                                <!--<td>${list11[3]}</td>-->
                                                                <td>${list11[10]}</td>
                                                                <td>${list11[11]}</td>
                                                                <td>${list11[4]}</td>
                                                                <!--<td>${list11[12]}</td>-->
                                                                <td>${list11[5]}</td>
                                                                <td>${list11[6]}</td>
                                                                <td>${list11[9]}</td>
                                                                <td>${list11[8]}</td>
                                                                <c:if test="${list11[7] eq 0}">
                                                                    <td><span class="badge">Pending</span></td>
                                                                </c:if>
                                                                <c:if test="${list11[7] eq 3}">
                                                                    <td><span class="label label-success">Approved</span></td>
                                                                </c:if>
                                                                <c:if test="${list11[7] eq 2}">
                                                                    <td> <span class="label label-danger">Rejected</span></td>
                                                                </c:if>
                                                                <c:if test="${list11[7] eq 1}">
                                                                    <td><span class="label label-warning">Reworked</span></td>
                                                                </c:if>
                                                                <c:if test="${list11[7] eq 4}">
                                                                    <td><span class="label label-info">WithDraw Request</span></td>
                                                                </c:if>
                                                                <c:if test="${list11[7] eq 5}">
                                                                    <td><span class="label label-info">WithDrawn</span></td>
                                                                </c:if>


                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>

        </form:form>
    </div>
    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {
            jQuery("#employeeName").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
            });
        });
    </script>
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

