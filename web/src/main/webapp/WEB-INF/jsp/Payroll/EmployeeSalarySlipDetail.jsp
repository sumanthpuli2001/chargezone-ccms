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
        <title> Salary Slip Search</title>
    </head>
    <script>
        function viewClick(id, month, year) {
            window.location = "employeeSalarySlip.htm?act=ViewIndiviualSalarySlip&id=" + id + "&month=" + month + "&year=" + year;
        }
    </script>
    <script>
        function editClick(id, month, year) {
            window.location = "employeeSalarySlip.htm?act=editIndiviualSalarySlip&id=" + id + "&month=" + month + "&year=" + year;
        }
    </script>
    <script>
        function printall(month, year) {


            window.location = "employeeSalarySlip.htm?act=printAllViewIndiviualSalarySlip&month=" + month + "&year=" + year;
        }
    </script>
    <script>
        function deleteCheck11() {
            var checkboxes = "";
            checkboxes = document.getElementsByName('checkId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select one or more record(s).");
            return false;
        }
    </script>
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
    <style type="text/css">

        /*right-align monetary amounts*/ 
        td[data-monetary-amount] {
            text-align: left;

        }

        /*make the cells output their value*/ 
        td[data-monetary-amount]:after {
            content: attr(data-monetary-amount);
        }

        /*make debit amounts show up in red*/ 
        td[data-monetary-amount^="-"]:after {
            color: red;
        }

    </style>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>SEARCH SALARY SLIP EMPLOYEE DETAIL</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Search Salary Slip Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="employeeSalarySlip.htm?act=searchFormEmployeeSlipDetailSubmit" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <input type="hidden" name="zydexLocationMasterId" value=""/>
                                            <input type="hidden" name="employeeTypeMasterId" value=""/>
                                            <input type="hidden" name="employeeSubTypeId" value=""/>
                                            <input type="hidden" name="paymentType" value=""/>
                                            <!--                                            <div class="form-group">
                                                                                            <div class="col-sm-6">${list[4]}
                                                                                                <label>Location:<span style="color: red;font-size: 12px;"></span></label>
                                                                                                <select name="zydexLocationMasterId" id="zydexLocationMasterId" class="form-control ">
                                                                                                    <option value="" label="-- Select --" ></option>
                                            <%--<c:forEach var="deptName" items="${deptMap}">--%>
                                                <option value="${deptName.key}" label="${deptName.value}" ></option>
                                            <%--</c:forEach>--%>
                                        </select>
                                    </div>

                                    <input type="hidden" name="typeOfEmployee" id="typeOfEmployee" value="${employeeTypeMaster.typeOfEmployee}">
                                    <div class="col-sm-6">
                                        <label>Type of Employee :<span style="color: red;font-size: 12px;"></span></label>
                                        <select name="employeeTypeMasterId" id="employeeTypeMasterId" onchange="selectsubtype(this.value);" class="form-control">
                                            <option value="" label="-- Select --" ></option>
                                            <%--<c:forEach var="EmpType" items="${EmployeeTypeList}">--%>
                                                <option value="${EmpType.key}" label="${EmpType.value}" ></option>
                                            <%--</c:forEach>--%>
                                        </select>

                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6" id="employeeSubTypeId">
                                        <label>Employee SubType:<span style="color: red;font-size: 12px;"></span></label>
                                        <select name="employeeSubTypeId" id="employeeSubTypeId" class="form-control">
                                            <option value="" label="-- Select --" ></option> 

                                        </select>
                                    </div>


                                    <div class="col-sm-6">
                                        <label>Payment Type:<span style="color: red;font-size: 12px;"></span></label>
                                        <select name="paymentType" id="paymentType" class="form-control ">
                                            <option value="">--Select--</option>
                                            <option value="0">Cheque</option>
                                            <option value="1">Cash</option>

                                        </select>
                                    </div>
                                </div>-->
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
                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.box-body -->
                            <div class="form-group">
                                <div class=" col-sm-12">
                                    <center>
                                        <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button><br><br>
                                    </center>
                                </div>
                            </div>

                            <div class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>
        <form:form action="employeeSalarySlip.htm?act=printAllViewIndiviualSalarySlip" method="post" commandName="employeeMaster"
                   name='form2' onsubmit='return deleteCheck11();'  class="form-horizontal" role="form">
            <c:if test="${search ne 'none'}">
                <input type="hidden" name="month" value="${month}">
                <input type="hidden" name="year" value="${year}">
                <input type="hidden" name="year" value="${list[4]}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <!--                                <div class="box-header" style="text-align: right;">
                                                                        <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="window.location = 'employeePfCheck.htm?act=exportToExcelPfCheck'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                                    </div>-->
                                    <!--                                  <div class="box-header" style="text-align: right;">
                                                                    <input type="button" class="btn btn-primary" value="Print" onclick="printDiv('printableArea')">
                                                                       </div>-->
                                    <div id="printableArea">
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">
                                                        <table id="table_1"  class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                                                    <button type="submit" class="btn btn-primary" title="" style="width: 100px;"><i class="fa fa-print"></i>&nbsp;&nbsp;Print</button>
                                                                    <tr>
                                                                        <th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                                        <th>Emp Id</th>
                                                                        <th>Emp Name</th>
                                                                        <th>Net Salary</th>
                                                                        <th>Action</th>
                                                                            <c:if test="${sessionScope.userRight.payroll}">
                                                                            <th>Edit</th>
                                                                            </c:if>


                                                                    </tr>
                                                                    </thead>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <tbody>
                                                            <input style="display: none;" type="Text" name="employeeListLength"  value="${fn:length(employeelist)}"/>

                                                            <c:forEach var="list" items="${employeelist}" varStatus="status">
                                                                <tr>
                                                                    <td align="Center">
                                                                        <input type="checkbox" name="checkId" id="deptCheckId" value="${list[5]}">
                                                                    </td>
                                                                    <td>${list[0]}</td>
                                                                    <td>${list[1]}</td>
                                                                    <td data-monetary-amount="${list[6]}"></td>

                                                                    <td>  <button type="button" onclick="viewClick('${list[4]}', '${list[2]}', '${list[3]}');" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </td>
                                                                    <c:if test="${sessionScope.userRight.payroll}">
                                                                        <td>  <button type="button" onclick="editClick('${list[4]}', '${list[2]}', '${list[3]}');" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                &nbsp;&nbsp;Edit
                                                                            </button>
                                                                        </td>
                                                                    </c:if>


                                                                </tr>
                                                            </c:forEach>

                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <c:if test="${!empty employeelist}">

                                                    </c:if>

                                                </div><!-- /.col -->
                                            </div><!-- /.row -->
                                        </div><!-- /.box-body -->
                                    </div><!-- /.tab-content -->
                                </div><!-- nav-tabs-custom -->

                            </div>
                        </div><!-- /.col -->
                </section>
            </div>
        </c:if>
    </div>
</form:form>

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
    });</script>
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
    });</script>
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
    document.getElementById('year11').innerHTML = options11;</script>
<script type="text/javascript">
    function printDiv(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;
        document.body.innerHTML = printContents;
        window.print();
        document.body.innerHTML = originalContents;
    }
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

