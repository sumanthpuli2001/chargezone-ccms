<%-- 
    Document   : LastDayReport
    Created on : 14-Jul-2020, 15:14:18
    Author     : Aman Bahukhandi 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>

    <head>
        <title> </title>
    </head>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1></h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active"></li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->

        <form:form  method="post"  commandName="pdm"
                    name='form2'  onsubmit='return deleteCheck11();' class="form-horizontal" >
            <section class="content">
                <div class="row">
                    <div class="content">
                        <div class="col-md-12">
                            <div class="table table-bordered">
                                <div class=" table table-bordered table-responsive">
                                    <div class="tab-content">
                                        <div id="printableArea">
                                            <table  id="tableid"  class="table table-bordered table-striped table-hover" style="" align="Center">
                                                <c:choose>
                                                    <c:when test="${empty list}">
                                                        <tr>
                                                            <td align="center">
                                                                <c:out value="There is no record found."></c:out>
                                                                </td>
                                                            </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="box-header" style="text-align: right;">
                                                            <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
                                                        </div>
                                                        <thead>
                                                            <tr>
                                                                <th colspan="12" style="text-align: center">
                                                                    GUJARAT INDUSTRIES POWER COMPANY LIMITED                                                            
                                                                </th>
                                                            </tr>
                                                            <tr>
                                                                <th colspan="12" style="text-align: center">
                                                                    Last Date Report
                                                                </th>
                                                            </tr>
                                                            <tr  style="text-align: center">
                                                                <th>Sr.No</th>  
                                                                <th colspan="2">RF ID</th>
                                                                <th colspan="3">Name</th>
                                                                <th colspan="2">Start Date</th>
                                                                <th colspan="2">End Date</th>
                                                                <th>No of Person</th>
                                                                <th>Department</th>
                                                            </tr>
                                                        </thead>

                                                        <tbody>
                                                            <c:forEach var="list" items="${list}" varStatus="status">
                                                                <tr>
                                                                    <td> ${status.count}</td>
                                                                    <td colspan="2">${list.rfId}</td>
                                                                    <td colspan="3">${list.name}</td>
                                                                    <td colspan="2">${list.startDate}</td>
                                                                    <td colspan="2">${list.endDate}</td>
                                                                    <td >${list.numberPerson}</td>
                                                                    <td >${list.department}</td>
                                                                </tr>   
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>  
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
        });</script>

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
</html>
