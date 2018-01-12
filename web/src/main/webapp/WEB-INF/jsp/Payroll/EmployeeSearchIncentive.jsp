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
        <title> Incentive Search</title>
    </head>

    <script>

        function saveSubmit11() {
            var flag3 = true;
//            alert(document.getElementById("month").value);
            if (document.getElementById("month").value == '') {
                document.getElementById("monthError").innerHTML = "- It must be selected.";
                flag3 = false;
            } else {
                document.getElementById("monthError").innerHTML = '';
            }
            if (document.getElementById("aincentive").value == '') {
                document.getElementById("aincentiveerror").innerHTML = "- It must not be Empty.";
                flag3 = false;
            } else {
                document.getElementById("aincentiveerror").innerHTML = '';
            }
            if (document.getElementById("pincentive").value == '') {
                document.getElementById("pincentiveerror").innerHTML = "- It must not be Empty.";
                flag3 = false;
            } else {
                document.getElementById("pincentiveerror").innerHTML = '';
            }
//            alert(flag3);
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
        function editClick(id) {
            window.location = "employeeIncentiveMonthWise.htm?act=editemployeeIncentiveMonthWise&id=" + id;
        }
    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Generate Incentive:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Search Salary Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="employeeIncentiveMonthWise.htm?act=searchEmpIncentiveDetailSubmit" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <!--form horizontal starts here-->

                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <!--<div class="row">-->


                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <label>Production Incentive:<span style="color: red;font-size: 12px;">*</span></label>
                                            <input name="pincentive" id="pincentive"  placeholder="Enter Production Incentive" class="form-control"/>
                                            <span id="pincentiveerror" style="color: red;"></span>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>Attendance Incentive:<span style="color: red;font-size: 12px;">*</span></label>
                                            <input name="aincentive" id="aincentive"  placeholder="Enter Attendance Incentive" class="form-control"/>
                                            <span id="aincentiveerror" style="color: red;"></span>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <label>Months:<span style="color: red;font-size: 12px;">*</span></label>
                                            <%--<form:input path="bloodGroups" class="form-control"></form:input>--%>
                                            <select name="month" id="month" class="form-control ">
                                                <option value="">--Select--</option>
                                                <option value="01">January</option>
                                                <option value="02">February</option>
                                                <option value="03">March </option>
                                                <option value="04">April</option>
                                                <option value="05">May</option>
                                                <option value="06">June</option>
                                                <option value="07">July</option>
                                                <option value="08">August</option>
                                                <option value="09">September</option>
                                                <option value="10">October </option>
                                                <option value="11">November </option>
                                                <option value="12">December</option>

                                            </select>
                                            <span id="monthError" style="color: red;"></span>
                                        </div>

                                        <div class="col-sm-6">
                                            <label>Year:<span style="color: red;font-size: 12px;"></span></label>  
                                            <select name="year11" id="year11" class="form-control ">

                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group" >
                                        <div class=" col-sm-2">
                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" >Submit</button>
                                        </div>
                                    </div>
                                    <!--</div>-->
                                </div>
                            </div><!-- /.col -->
                        </div><!-- /.row -->
                    </div><!-- /.box-body -->



                </div>

            </form:form>
            <form:form action="" method="post" commandName=""
                       name='form2'  class="form-horizontal" role="form">
                <c:if test="${search ne 'none'}">
                    <input type="hidden" name="month" value="${month}">
                    <input type="hidden" name="year" value="${year}">
                    <section class="content">
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Custom Tabs -->
                                <div class="nav-tabs-custom">
                                    <div class="tab-content">
                                        <!--                                <div class="box-header" style="text-align: right;">
                                                                            <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'leaveEmployeeDetail.htm?act=exportToExcelForLeaveRequest'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                                        </div>-->
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <c:choose>
                                                                <c:when test="${empty employeelist}">
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
                                                                            <th>Present Day</th>
                                                                            <th>Prod.Inct.Per Day</th>
                                                                            <th>Prod.Inct.Amount</th>
                                                                            <th>Basic Rate Per Day</th>
                                                                            <th>Attnd.Inct Day</th>
                                                                            <th>Attnd.Inct Amount</th>
                                                                            <th>Edit</th>



                                                                        </tr>
                                                                    </thead>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <tbody>
                                                            <input style="display: none;" type="Text" name="employeeListLength"  value="${fn:length(employeelist)}"/>

                                                            <c:forEach var="list" items="${employeelist}" varStatus="status">
                                                                <tr>
                                                                    <td>${list[0]}</td>
                                                                    <td>${list[1]}</td>
                                                                    <td>${list[2]}</td>
                                                                    <td><fmt:formatNumber maxFractionDigits="0" value="${list[3]}"></fmt:formatNumber></td>
                                                                    <td><fmt:formatNumber maxFractionDigits="0" value="${list[4]}"></fmt:formatNumber></td>
                                                                    <td><fmt:formatNumber maxFractionDigits="0" value="${list[5]}"></fmt:formatNumber></td>
                                                                    <td>${list[6]}</td>
                                                                    <td><fmt:formatNumber maxFractionDigits="0" value="${list[7]}"></fmt:formatNumber></td>
                                                                    <td>  <button type="button" onclick="editClick('${list[8]}');" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;Edit
                                                                        </button>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                            <c:choose>
                                                                <c:when test="${!empty employeelist}">
                                                                    <tr>
                                                                        <td></td>

                                                                        <td><b>Total Amount</b></td>
                                                                        <td><fmt:formatNumber maxFractionDigits="0" value="${totalpresentday1}"></fmt:formatNumber></td>
                                                                            <td></td>
                                                                            <td><fmt:formatNumber maxFractionDigits="0" value="${productionIncentive1}"></fmt:formatNumber></td>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td><fmt:formatNumber maxFractionDigits="0" value="${atttentIncentive1}"></fmt:formatNumber></td>
                                                                            <td></td>
                                                                        </tr>
                                                                </c:when>
                                                            </c:choose>
                                                            </tbody>
                                                        </table>
                                                    </div>



                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.tab-content -->
                                </div><!-- nav-tabs-custom -->

                            </div>
                        </div><!-- /.col -->
                    </section>
                </c:if>
            </form:form>
        </section>
    </div>


    <script>
        function selectsubtype(typeId) {

            var empSubTypeId = document.getElementById("employeeSubTypeId").value;
            //            document.getElementById('EmployeeId').innerHTML = "Fetching ... .. .";
            $.post("employeeTypeWiseSalary.htm?act=readEmpTypeAjax",
                    {
                        typeId: typeId,
                        empSubTypeId: empSubTypeId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt" + responseTxt);
                    document.getElementById('employeeSubTypeId').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }

        $(document).ready(function () {
            var empTypeId = document.getElementById("employeeTypeMasterId").value;
            selectsubtype(empTypeId);

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
        window.onload = init;
        function init() {
            document.form1.month.options[new Date().getMonth()].selected = true;
        }
        var start = 1990;
        var end = new Date().getFullYear();
        var options11 = "";

        for (var year1 = end; year1 >= start; year1--) {
            options11 += "<option>" + year1 + "</option>";
        }
        document.getElementById('year11').innerHTML = options11;
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

