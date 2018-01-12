<%--
    Document   : Form16Print
    Created on : 5.8.2016 , 5:50:46 PM
    Author     : Prem
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incentive </title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <!--        <script>
                    function deleteclick(id, month, year) {
                        window.location = "employeeSalarySlip.htm?act=deleteIndiviualSalarySlip&id=" + id + "&amount=" + amount + "&amountint=" + amountint;
                    }
                </script>-->



        <!-- Main content -->


        <section class="content">
            <div class="row" id="printDiv">

                <center><img src="StorageYard/Images/chem2.jpg" style="width:14%;height: 14%;" BORDER="0"/> </center>
                    <%
                        Date date = new Date();
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        out.print("<div align=\"right\">Date:" + df.format(date) + "</div>");
                    %>

                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>

                                <form:form action="" method="post" commandName=""
                                           name='form1' class="form-horizontal" id="form1" role="form">

<!--                                    <input type="hidden" name="id" value="${id}"/>
                                    <input type="hidden" name="month" value="${month}"/>
                                    <input type="hidden" name="year" value="${year}"/>
                                    <%--<%@include file="/WEB-INF/jsp/Payroll/PayrollMonthYearDetails.jsp"%>--%>

                                    <div class="form-group">
                                        <header>
                                            <center><b><font size="4">  ${employeeMaster.company}</font></b></center> 
                                            <center><b><font size="4">Particular Employee Details<c:if test="${month eq 1}">January</c:if>
                                    -->                                                    <%--<c:if test="${month eq 2}"> February</c:if>--%>
                                    <%--<c:if test="${month eq 3}"> March</c:if>--%>
                                    <%--<c:if test="${month eq 4}"> April</c:if>--%>
                                    <%--<c:if test="${month eq 5}"> May</c:if>--%>
                                    <%--<c:if test="${month eq 6}"> June</c:if>--%>
                                    <%--<c:if test="${month eq 7}"> July</c:if>--%>
                                    <%--<c:if test="${month eq 8}"> August</c:if>--%>
                                    <%--<c:if test="${month eq 9}"> September</c:if>--%>
                                    <%--<c:if test="${month eq 10}"> October</c:if>--%>
                                    <%--<c:if test="${month eq 11}"> November</c:if>--%>
                                    <%--<c:if test="${month eq 12}"> December</c:if>--%> 
                                    ${year}
                                    <!--</font></b></center> 
                            </header>-->


                                    <!--                                            <table border="1" style="width: 100%" name="SalarySlip" id="salarySlip" cellspacing="0" cellpadding="0" align="center" class="table table-bordered table-striped table-hover">
                                                                                                                                    <tr>
                                                                                                                                        <td>style="border:0px"
                                                                                                                                            <b>Emp ID:</b>
                                                                                                                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${employeeMaster.employeeId} </td>
                                                                                                                                    <td>style="border:0px"
                                                                                                                                        <b>Emp Name:</b>
                                                                                                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${employeeMaster.employeeName} </td>
                                                                                                                                </tr>
                                    
                                    
                                    
                                                                            </table>-->



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
                                                            <th>Basic Rate Per Day</th>
                                                            <th>Attnd.Inct Day</th>





                                                        </tr>
                                                    </thead>
                                                </c:otherwise>
                                            </c:choose>
                                            <tbody>

                                                <c:forEach var="list" items="${employeelist}" varStatus="status">
                                                    <tr>
                                                        <td>   <fmt:formatNumber maxFractionDigits="0" value="${list[2]}"></fmt:formatNumber></td>
                                                            <td><input id="attendIncentive" name="attendIncentive" class="form-group" /></td>

                                                            <td>  <div class="form-group" >
                                                                    <div class=" col-sm-2">
                                                                        <button type="button" class="btn btn-primary" onclick="submitclick(${list[7]});" >Submit</button>
                                                                </div>
                                                            </div>
                                                        </td>

                                                    </tr>
                                                </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>




                                </form:form>
                                <hr />

                            </div>

                        </div> <!-- /container -->
                    </div>
                </div> 
            </div> 
    </div> 
</section> 
</div> 
<script>
    function submitclick(id) {

        var incentiveMapId = document.getElementById("attendIncentive").value;
        alert(incentiveMapId);
        window.location = "employeeIncentiveMonthWise.htm?act=submitincentiveedit&id=" + id + "&incentiveMapId=" + incentiveMapId;
//                window.location = "employeeIncentiveMonthWise.htm?act=submitincentiveedit&id=" + id + "&incentiveMapId=" + incentiveMapId;
    }
</script>


<!--    <form>
        <input type="button" value="Print" onclick="window.print()">
    </form>-->
</html>

