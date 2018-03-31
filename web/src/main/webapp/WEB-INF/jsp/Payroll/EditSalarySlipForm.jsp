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
      <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salary Slip</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
<!--        <script>
            function deleteclick(id, month, year) {
                window.location = "employeeSalarySlip.htm?act=deleteIndiviualSalarySlip&id=" + id + "&amount=" + amount + "&amountint=" + amountint;
            }
        </script>-->
        <script>
        function deleteclick(id, month, year,payrollid,index,excelid) {
            var one = "amount" + index;
            var two = "amountInt" + index;
            var amonut = $('#'+one).is(':checked'); ;
            var amountInt = $('#'+two).is(':checked'); 
            
            window.location = "employeeSalarySlip.htm?act=deleteIndiviualSalarySlip&id=" + id + "&month=" + month + "&year=" + year + "&payrollid=" + payrollid + "&amount=" + amonut+ "&amountInt=" + amountInt+ "&excelid=" + excelid;
        }
    </script>


        <!-- Main content -->
        <section class="content">
            <div class="row" id="printDiv">

                <center><img src=" StorageYard/Images/logo.png" style="width:14%;height: 14%;" BORDER="0"/> </center>
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

                                    <input type="hidden" name="id" value="${id}"/>
                                    <input type="hidden" name="month" value="${month}"/>
                                    <input type="hidden" name="year" value="${year}"/>
                                    <%--<%@include file="/WEB-INF/jsp/Payroll/PayrollMonthYearDetails.jsp"%>--%>

                                    <div class="form-group">
                                        <header>
                                            <center><b><font size="4">  ${employeeMaster.company}</font></b></center> 
                                            <center><b><font size="4">Particular Employee Details<c:if test="${month eq 1}">January</c:if>
                                                    <c:if test="${month eq 2}"> February</c:if>
                                                    <c:if test="${month eq 3}"> March</c:if>
                                                    <c:if test="${month eq 4}"> April</c:if>
                                                    <c:if test="${month eq 5}"> May</c:if>
                                                    <c:if test="${month eq 6}"> June</c:if>
                                                    <c:if test="${month eq 7}"> July</c:if>
                                                    <c:if test="${month eq 8}"> August</c:if>
                                                    <c:if test="${month eq 9}"> September</c:if>
                                                    <c:if test="${month eq 10}"> October</c:if>
                                                    <c:if test="${month eq 11}"> November</c:if>
                                                    <c:if test="${month eq 12}"> December</c:if> ${year}</font></b></center> 
                                            </header>


                                            <table border="1" style="width: 100%" name="SalarySlip" id="salarySlip" cellspacing="0" cellpadding="0" align="center" class="table table-bordered table-striped table-hover">
                                                <!--                                                <tr>
                                                                                                    <td>style="border:0px"
                                                                                                        <b>Emp ID:</b>
                                                                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${employeeMaster.employeeId} </td>
                                                                                                <td>style="border:0px"
                                                                                                    <b>Emp Name:</b>
                                                                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${employeeMaster.employeeName} </td>
                                                                                            </tr>-->


                                            <tr>

                                                <td valign="top">
                                                    <table id="demo" cellspacing="0" cellpadding="0" 
                                                           border="0" align="center" class="table table-bordered table-striped table-hover"  >

                                                        <c:choose>
                                                            <c:when test="${empty employeeDeductionList}">
                                                                <tr>
                                                                    <td align="center">
                                                                        <c:out value="No any Decrement."></c:out>
                                                                        </td>
                                                                    </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <thead>
                                                                    <tr >
                                                                        <th align="left" >Salary Deduction Type</th>
                                                                        <th align="left">Amount</th>
                                                                        <th align="left">EMI Int Rate</th>
                                                                        <th align="left">Action</th>
                                                                      

                                                                    </tr>
                                                                </thead>
                                                                <!--
                                                                                                                                <tfoot>
                                                                                                                                    <tr>
                                                                                                                                        <th align="left">Total Deduction</th>
                                                                                                                                        <th align="left"><fmt:formatNumber maxFractionDigits="0" value="${totalDeductionAmount}"></fmt:formatNumber></th>
                                                                                                                                        </tr>
                                                                                                                                    </tfoot>-->
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <tbody>
                                                            <c:forEach var="listDec" items="${employeeDeductionList}" varStatus="loop">
                                                                <tr>
                                                                    <td>${listDec[0]}
                                                                      
                                                                    </td>
                                                                    <td><fmt:formatNumber maxFractionDigits="0" value="${listDec[1]}"></fmt:formatNumber> <input type="checkbox"  id="amount${loop.index}" name="amount"  value="0" ></td>
                                                                    <td><fmt:formatNumber maxFractionDigits="0" value="${listDec[2]}"></fmt:formatNumber><input type="checkbox" id="amountInt${loop.index}"  name="amount"  value="1"></td>
                                                                    <td>  <button type="button" onclick="deleteclick('${listDec[4]}','${listDec[6]}', '${listDec[7]}','${listDec[3]}',${loop.index},'${listDec[5]}');" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;Delete
                                                                        </button>
                                                                   
                                                                    </td>
                                                                </tr>


                                                            </c:forEach>

                                                        </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                        </table>


                                    </div>




                                </form:form>
                                <hr />

                            </div>

                        </div> <!-- /container -->

                    </div> 
                </div> 
            </div> 
        </section> 
    </div> 


    <!--    <form>
            <input type="button" value="Print" onclick="window.print()">
        </form>-->
</html>

