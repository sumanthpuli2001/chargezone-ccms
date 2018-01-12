<%--
    Document   : LeaveEmployeeDetailSearch
    Created on : Oct 19, 2015, 4:03:28 PM
    Author     : AJAY
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title>  Salary Search</title>
    </head>

    <script>
        function viewClick(id) {
            window.location = 'employeeSalaryProcess.htm?act=viewClick&id=' + id;
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



    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Search  Salary Employee Detail:</h1>
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
        <form:form class="form-horizontal" role="form1" action="employeeSalaryProcess.htm?act=searchSalaryDetailSubmit" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Location:<span style="color: red;font-size: 12px;"></span></label>
                                                    <select name="zydexLocationMasterId" id="zydexLocationMasterId" class="form-control ">
                                                        <option value="" label="-- Select --" ></option>
                                                        <c:forEach var="deptName" items="${deptMap}">
                                                            <option value="${deptName.key}" label="${deptName.value}" ></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>

                                                <input type="hidden" name="typeOfEmployee" id="typeOfEmployee" value="${employeeTypeMaster.typeOfEmployee}">
                                                <div class="col-sm-6">
                                                    <label>Type of Employee :<span style="color: red;font-size: 12px;"></span></label>
                                                    <select name="employeeTypeMasterId" id="employeeTypeMasterId" onchange="selectsubtype(this.value);" class="form-control">
                                                        <option value="" label="-- Select --" ></option>
                                                        <c:forEach var="EmpType" items="${EmployeeTypeList}">
                                                            <option value="${EmpType.key}" label="${EmpType.value}" ></option>
                                                        </c:forEach>
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

            </section>
        </form:form>
        <form:form action="" method="post" commandName="employeeSalaryProcess"
                   name='form2'  class="form-horizontal" role="form">
            <c:if test="${search ne 'none'}">
                <input type="hidden" name="month" value="${month}">
                <input type="hidden" name="year" value="${year}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <c:choose>
                                        <c:when test="${!empty finalList}">
                                            <div class="box-header" style="text-align: right;">
                                                <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
                                                <!--<a href="" onclick="javascipt:window.open('/Payroll/report.pdf');" class="popup">Click to open.</a>-->
                                            </div>
                                        </c:when>
                                    </c:choose>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div id="printableArea">
                                                <center> <img src="StorageYard/Images/chem2.jpg" style="width:15%;height: 15%;" BORDER="0"/> </center>
                                                    <%
                                                        Date date = new Date();
                                                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                        //                                           out.print( "Date.." + df.format(date));
                                                        out.print("<div align=\"right\">Date:" + df.format(date) + "</div>");
                                                    %>
                                                <div class="form-group">
                                                    <center><b><font size="4">CHEMCRUX ENTERPRISES LIMITED </font></b></center> 
                                                </div>
                                                <header>
                                                    <center><b><font size="4">Salary/ Wages Report for the Month of <c:if test="${month eq 1}">January</c:if>
                                                            <c:if test="${month eq 2}">February</c:if>
                                                            <c:if test="${month eq 3}">March</c:if>
                                                            <c:if test="${month eq 4}">April</c:if>
                                                            <c:if test="${month eq 5}">May</c:if>
                                                            <c:if test="${month eq 6}">June</c:if>
                                                            <c:if test="${month eq 7}">July</c:if>
                                                            <c:if test="${month eq 8}">August</c:if>
                                                            <c:if test="${month eq 9}">September</c:if>
                                                            <c:if test="${month eq 10}">October</c:if>
                                                            <c:if test="${month eq 11}">November</c:if>
                                                            <c:if test="${month eq 12}">December</c:if>
                                                            ${year}  </font></b></center> 
                                                </header>
                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <div class="table table-bordered">
                                                            <div class=" table table-bordered table-responsive">
                                                                <table id="tableid" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                    <c:choose>
                                                                        <c:when test="${empty finalList}">
                                                                            <tr>
                                                                                <td align="center">
                                                                                    <c:out value="There is no record found."></c:out>
                                                                                    </td>
                                                                                </tr>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Sr.No</th>  
                                                                                        <c:forEach var="headerList" items="${headerList123}">
                                                                                        <th >${headerList}</th>  
                                                                                        </c:forEach>
                                                                                </tr>
                                                                            </thead>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <tbody>
                                                                        <c:forEach var="finalMap1" items="${finalList}" varStatus="status">
                                                                            <tr>
                                                                                <td >${status.count}</td>
                                                                                <c:forEach var="headeStr" items="${headerList123}">
                                                                                    <td >
                                                                                        <c:if test="${finalMap1[headeStr] eq null}">-</c:if>
                                                                                        <c:if test="${finalMap1[headeStr] ne null}">${finalMap1[headeStr]}</c:if>
                                                                                        </td>

                                                                                </c:forEach>


                                                                            </tr>
                                                                        </c:forEach>

                                                                    </tbody>                                           
                                                                </table>
                                                            </div>
                                                        </div>


                                                    </div>  
                                                </div>
                                            </div> 
                                        </div>  
                                    </div> 

                                </div>
                            </div> 
                        </div>
                    </div>
                </section>
            </div>
        </c:if>
    </form:form>
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
    });</script>

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
//
        document.body.innerHTML = printContents;
        window.print();
        document.body.innerHTML = originalContents;
    }
    
</script>
<script type="text/javascript">
    function ExportToExcel(tableid) {
        var htmltable = document.getElementById('tableid');
        var html = htmltable.outerHTML;
        window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
//          window.open('data:application/vnd.pdf,' + encodeURIComponent(html));
    }
</script>
<style>
    tr,td,th{
        font-size: 11px;
        padding: 0px;
        margin: 0px;
    }
</style>
<script>
   
</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

