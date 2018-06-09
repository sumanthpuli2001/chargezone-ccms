<%-- 
    Document   : OddPunchReport
    Created on : 27 Jan, 2018, 10:08:22 AM
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
        <title>Odd Punch Report</title>
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
            <h1>ODD PUNCH DETAIL</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Odd Punch Report</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="employeeDatetimeData.htm?act=onSearchClick" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                                    <label>Enter Date:<span style="color: red;font-size: 12px;"></span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <input type="date" id="enteredDate" name="enteredDate" class="form-control" size="16" placeholder="dd/mm/yyyy"  />
                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                    </div>
                                                </div>
                                                <!--                                                <div class="col-sm-6">
                                                                                                    <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                                                        <input class="form-control" size="16" type="text" value="" readonly>
                                                                                                        <input id="endDate" name="endDate" class="form-control" size="16" placeholder="DD/MM/YYYY" readonly="true" />
                                                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                                                    </div>
                                                                                                </div>-->
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
        <form:form action="" method="post" commandName="employeeDatetimeData.htm"
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
                                        <c:when test="${!empty oddPunchList}"> 
                                            <div class="box-header" style="text-align: right;">
                                                <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
                                            </div>
                                        </c:when>
                                    </c:choose>
                                    <div class="box-body no-padding">
                                        <div id="printableArea">
                                            <c:choose>
                                                <c:when test="${empty oddPunchList}"> 
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
                                                    <!--<div class="form-group">-->
                                                        <!--<center><b><font size="4">${oddPunchList}</font></b></center>--> 
                                                    <!--</div>-->
                                                    <div class="form-group">
                                                        <header>
                                                            <center><b><font size="4">Odd Punch Data
                                                                    </font></b></center> 
                                                        </header>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <b><font size="4">Searched Date :${date}</font></b>
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="row">

                                                            <div class="col-md-12 col-sm-12">
                                                                <div class="table table-bordered">
                                                                    <table id="tableid" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                                        <thead>
                                                                            <tr>
                                                                                <th>Sr.No</th>
                                                                                <th>Employee Id</th>
                                                                                <th>Employee Name</th>
                                                                            </tr>
                                                                        </thead>

                                                                        <tbody>
                                                                            <c:forEach var="oddPunchList" items="${oddPunchList}" varStatus="status">
                                                                                <tr>
                                                                                    <td>${status.count}</td>
                                                                                    <td>${oddPunchList[0]}</td>
                                                                                    <td>${oddPunchList[1]}</td>

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
        <!--</div>-->
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
