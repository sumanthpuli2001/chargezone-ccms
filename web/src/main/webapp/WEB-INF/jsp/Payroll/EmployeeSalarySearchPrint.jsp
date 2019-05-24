<%--
    Document   : LeaveEmployeeDetailSearch
    Created on : Oct 19, 2015, 4:03:28 PM
    Author     : AJAY
--%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 <script src="StorageYard/JS/TableExcel/jquery.table2excel.js"></script>

<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>

    <head>
        <title>  Salary Search</title>
    </head>







    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">


        <!-- Main content -->

        <form:form action="" method="post" commandName="employeeSalaryProcess"
                   name='form2'  class="form-horizontal" role="form">
            <c:if test="${search ne 'none'}">
                <input type="hidden" name="month" value="${month}">
                <input type="hidden" name="year" value="${year}">
                <input type="hidden" name="zydexlocationid" value="${zydexlocationid}">
                <input type="hidden" name="typeofemployee" value="${typeofemployee}">
                <input type="hidden" name="employeesubid" value="${employeesubid}">
                <input type="hidden" name="paymenttype" value="${paymenttype}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <c:choose>
                                        <c:when test="${!empty finalList}">
                                            <div class="box-header" style="text-align: right;">
                                                <!--<a href="" onclick="javascipt:window.open('/Payroll/report.pdf');" class="popup">Click to open.</a>-->
                                            </div>
                                        </c:when>
                                    </c:choose>
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div id="printableArea">
                                                <center> <img src=" StorageYard/Images/logo.png" style="width:15%;height: 15%;" BORDER="0"/> </center>
                                                    <%
                                                        Date date = new Date();
                                                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                        //                                           out.print( "Date.." + df.format(date));
                                                        out.print("<div align=\"right\">Date:" + df.format(date) + "</div>");
                                                    %>
                                                <div class="form-group">
                                                    <center><b><font size="4">Vadera & Co. </font></b></center> 
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

                                                <table class="table2excel" data-tableName="Test Table 1">
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
                </section>
            </div>
        </c:if>
    </form:form>
</div>


<script>
    $(function () {
        $(".table2excel").table2excel({
            exclude: ".noExl",
            name: "Excel Document Name",
            filename: "employeeSalaryexcel",
            fileext: ".xls",
            exclude_img: true,
            exclude_links: true,
            exclude_inputs: true
        });
    });
</script>

<%--<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>--%>
</html>

