<%-- 
    Document   : AttendanceReport
    Created on : 13 Oct, 2017, 11:55:30 AM
    Author     : Sejal
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title>Attendance Report</title>
    </head>
    <script>

        function saveSubmit11() {
            var flag3 = true;
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
            <h1>Attendance Detail:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Attendance Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="attendanceReport.htm?act=onSearchClick" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                                <input type="hidden" name="typeOfEmployee" id="typeOfEmployee" value="${employeeTypeMaster.typeOfEmployee}">
                                                <div class="col-sm-6">
                                                    <label>Type of Employee :<span style="color: red;font-size: 12px;"></span></label>
                                                    <select name="employeeTypeMasterId" id="employeeTypeMasterId" onchange="selectsubtype(this.value);" class="form-control">
                                                        <option value="" label="" >--Select--</option>
                                                        <c:forEach var="EmpType" items="${EmployeeTypeList}">
                                                            <option value="${EmpType.key}" label="${EmpType.value}" >${EmpType.value}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Employee SubType:<span style="color: red;font-size: 12px;"></span></label>
                                                    <!--                                                    <select name="employeeSubTypeId" id="employeeSubTypeId" class="form-control">
                                                                                                            <option value="" label="-- Select --" ></option> 
                                                                                                        </select>-->
                                                    <select name="employeeSubTypeId" id="employeeSubTypeId"  class="form-control">
                                                        <option value="" label="" >--Select--</option>
                                                        <c:forEach var="EmpSubType" items="${EmployeeSubTypeList}">
                                                            <option value="${EmpSubType.key}" label="${EmpSubType.value}" >${EmpSubType.value}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Months:<span style="color: red;font-size: 12px;">*</span></label>
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
        <form:form action="" method="post" commandName="attendanceReport.htm"
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
                                        <c:when test="${!empty attendanceList[1]}"> 
                                            <div class="box-header" style="text-align: right;">
                                                <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
                                            </div>
                                        </c:when>
                                    </c:choose>
                                    <div class="box-body no-padding">
                                        <div id="printableArea">
                                            <c:choose>
                                                <c:when test="${empty attendanceList[1]}"> 
                                                    <tr>
                                                        <td style="text-align:center;">
                                                            <b><i><c:out value="--   NO RECORD FOUND   --"></c:out></i></b>
                                                            </td>
                                                        </tr>
                                                </c:when>
                                                <c:otherwise>
                                                    <center><img src=" StorageYard/Images/logo.png" style="width:15%;height: 15%;" BORDER="0"/></center> 
                                                        <%
                                                            Date date = new Date();
                                                            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                            //                                           out.print( "Date.." + df.format(date));
                                                            out.print("<div align=\"right\">Date:" + df.format(date) + "</div>");
                                                        %>
                                                    <div class="form-group">
                                                        <center><b><font size="4">${attendanceList[1]}</font></b></center> 
                                                    </div>
                                                    <div class="form-group">
                                                        <header>
                                                            <center><b><font size="4">Attendance for the month
                                                                    <c:if test="${month eq 1}">January</c:if>
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
                                                                    ${year}
                                                                    </font></b></center> 
                                                        </header>
                                                    </div>
                                                    <div class="row">
                                                        <div class="row">

                                                            <div class="col-md-12 col-sm-12">
                                                                <div class="table table-bordered">
                                                                    <table id="tableid" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                                        <thead>
                                                                            <tr>
                                                                                <th>Sr.No</th>
                                                                                <th>Emp Id</th>
                                                                                <th>Emp Name</th>
                                                                                <th>W.Days</th>
                                                                                <th>W.Off</th>
                                                                                <th>P.Days</th>
                                                                                <th>C.L</th>
                                                                                <th>P.L</th>
                                                                                <th>Absent</th>
                                                                                <th>LWP</th>
                                                                                <th>O.T Hours</th>
                                                                            </tr>
                                                                        </thead>

                                                                        <tbody>
                                                                            <c:forEach var="attendanceList" items="${attendanceList[0]}" varStatus="status">
                                                                                <tr>
                                                                                    <td>${status.count}</td>
                                                                                    <td>${attendanceList[0]}</td>
                                                                                    <td>${attendanceList[1]}</td>
                                                                                    <td>${attendanceList[2]}</td>
                                                                                    <td>${attendanceList[5]}</td>
                                                                                    <td>${attendanceList[3]}</td>
                                                                                    <td>${attendanceList[4]}</td>

                                                                                    <td>${attendanceList[6]}</td>
                                                                                    <td>${attendanceList[7]}</td>
                                                                                    <td>${attendanceList[8]}</td>
                                                                                    <td>${attendanceList[9]}</td>
                                                                                </c:forEach>

                                                                        </tbody>                                           
                                                                    </table>
                                                                </div>


                                                            </div>  
                                                        </div>
                                                    </div> 
                                                </c:otherwise>
                                            </c:choose>
                                        </div>  
                                    </div> 

                                </div>
                            </div> 
                        </div>
                    </div>
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
<script type="text/javascript">
    function printDiv(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;

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
    }
</script>

<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<style>
    .class-with-width { width: 150px !important; }
</style>    
<script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>  
</html>