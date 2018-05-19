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
        <section class="content-header">
            <h1>Salary Slip</h1>
            <h3>
                <input type="button" class="btn btn-primary" value="Print" onclick="window.print('printDiv')">
            </h3>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Salary Slip</li>
            </ol>
        </section>


        <!-- Main content -->
        <section class="content">
            <div class="row" id="printDiv">



                <div class="col-md-6" style="text-align: center;">
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
                                            <center><img src=" StorageYard/Images/logo.png" style="width:14%;height: 14%;" BORDER="0"/> </center>
                                            <center><b><font size="4">  ${employeeMaster.company}</font></b></center> 
                                            <center><b><font size="4">PAY SLIP FOR THE MONTH OF<c:if test="${month eq 1}">JANUARY</c:if>
                                                    <c:if test="${month eq 2}">FEBRUARY</c:if>
                                                    <c:if test="${month eq 3}">MARCH</c:if>
                                                    <c:if test="${month eq 4}">APRIL</c:if>
                                                    <c:if test="${month eq 5}">MAY</c:if>
                                                    <c:if test="${month eq 6}">JUNE</c:if>
                                                    <c:if test="${month eq 7}">JULY</c:if>
                                                    <c:if test="${month eq 8}">AUGUST</c:if>
                                                    <c:if test="${month eq 9}">SEPTEMBER</c:if>
                                                    <c:if test="${month eq 10}">OCTOBER</c:if>
                                                    <c:if test="${month eq 11}">NOVEMBERr</c:if>
                                                    <c:if test="${month eq 12}">DECEMBERr</c:if> ${year}</font></b></center> 
                                            </header>


                                            <table style=" width: 90%; height: 0px !important;" name="SalarySlip" id="salarySlip" cellspacing="0" cellpadding="0" align="center" class="table table-bordered table-striped table-hover">

                                                <tr>
                                                    <td style="border:0px; width: 30%;  height: 0px !important">
                                                        <b>Emp ID</b>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.employeeId} </td>
                                                <td style="border:0px; width: 30%;"><!--style="border:0px"-->
                                                    <b>Emp Name</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.employeeName} </td>

                                            </tr>

                                            <tr>
                                                <td><!--style="border:0px"-->
                                                    <b>Department</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.departmentMaster.departmentName} </td>
                                                <td><!--style="border:0px"-->
                                                    <b>Designation</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.designationMaster.designationName}</td>
                                            </tr>
                                            <td><!--style="border:0px"-->
                                                <b>DOJ</b>
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.dateOfJoining} </td>
                                            <td><!--style="border:0px"-->
                                                <b>Bank A/C No</b>
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.bankAccountNo} </td>
                                            <tr>


                                                <td><!--style="border:0px"-->
                                                    <b>P.F. A/C No</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.pfNo} </td>

                                                <c:if test="${not empty employeeMaster.esicNo}">
                                                    <td><!--style="border:0px"-->
                                                        <b>E.S.I.C No</b>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.esicNo}</td>
                                                    </c:if>


                                            </tr>
                                        </table>

                                        <table style=" width: 90%;" align="center">
                                            <tr>
                                                <td colspan="2">
                                                    <table border="1" style="width: 100%" name="leave" id="leave" cellspacing="0" cellpadding="0" align="center"  class="table table-bordered table-striped table-hover">
                                                        <tr>

                                                            <th style="width: 150px;">W.Days</th>
                                                            <th style="width: 150px;">W.Off</th>
                                                            <th style="width: 150px;">P.Days</th>
                                                            <th style="width: 150px;">C.L</th>
                                                            <th style="width: 150px;">P.L</th>
                                                            <th style="width: 150px;">LWP</th>
                                                            <th style="width: 150px;">Absent</th>
                                                            <th style="width: 150px;">OT Hours</th>
                                                        </tr>
                                                        <tr>
                                                        <tbody>
                                                            <c:forEach  var="employeeExcelRecordList" items="${employeeExcelRecordList}">
                                                                <c:set var="count" value="${count + 1}" scope="page"/>
                                                                <tr>
                                                                    <td>
                                                                        ${employeeExcelRecordList.workingDays}
                                                                    </td>
                                                                    <td>
                                                                        ${employeeExcelRecordList.sickLeave}
                                                                    </td>
                                                                    <td>
                                                                        ${employeeExcelRecordList.presentDays}
                                                                    </td>

                                                                    <td>
                                                                        ${employeeExcelRecordList.casuaLeave}
                                                                    </td>

                                                                    <td>
                                                                        ${employeeExcelRecordList.pleave}
                                                                    </td>
                                                                    <td>
                                                                        ${employeeExcelRecordList.lwp}
                                                                    </td>
                                                                    <td>
                                                                        ${employeeExcelRecordList.otherLeave}
                                                                    </td>
                                                                    <td>
                                                                        ${employeeExcelRecordList.otHours}
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </tbody>
                                            </tr>
                                        </table>
                                        </td>
                                        </tr>

                                        <tr >
                                            <td valign="top">
                                                <table border="0" cellspacing="0" cellpadding="0" style="width: 100%; border: 0px;"  align="center" id="demo" class="table table-bordered table-striped table-hover">

                                                    <c:choose>
                                                        <c:when test="${empty employeeAdditionalList}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="No any Increment."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead style="height: 5%">
                                                                <tr>
                                                                    <th align="left">Earnings</th>
                                                                    <th  style="text-align: right; padding-right:  2cm">Amount</th>

                                                                </tr>
                                                            </thead>
                                                            <tfoot>
                                                                <tr >
                                                                    <th align="left">Gross Salary</th>
                                                                    <th style="text-align: right; padding-right:  2cm" ><fmt:formatNumber maxFractionDigits="0" value="${total}"></fmt:formatNumber>.00</th>
                                                                    </tr>
                                                                </tfoot>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <tr>
                                                            <td>Basic +DA </td>
                                                            <td style="text-align: right; padding-right:  2cm"><fmt:formatNumber maxFractionDigits="0" value="${basicSalary}"></fmt:formatNumber>.00</td>
                                                            </tr>

                                                        <c:forEach var="employeeAdditional" items="${employeeAdditionalList}">
                                                            <c:if test="${employeeAdditional[1] ne 0.0}">

                                                                <tr>
                                                                    <td>${employeeAdditional[0]}</td>
                                                                    <td style="text-align: right; padding-right:  2cm"><fmt:formatNumber maxFractionDigits="0" value="${employeeAdditional[1]}"></fmt:formatNumber>.00</td>

                                                                    </tr>
                                                            </c:if>

                                                        </c:forEach>

                                                    </tbody>
                                                </table></td>
                                            <td valign="top">
                                                <table id="demo" cellspacing="0" cellpadding="0" style="width: 100%; border: 0px;"
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
                                                                    <th align="left" >Deductions</th>
                                                                    <th style="text-align: right; padding-right:  2cm">Amount</th>
                                                                </tr>
                                                            </thead>

                                                            <tfoot>
                                                                <tr>
                                                                    <th align="left">Total Deduction</th>
                                                                    <th style="text-align: right; padding-right:  2cm"><fmt:formatNumber maxFractionDigits="0" value="${totalDeductionAmount}"></fmt:formatNumber>.00</th>
                                                                    </tr>
                                                                </tfoot>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="listDec" items="${employeeDeductionList}">
                                                            <tr>
                                                                <td>${listDec[0]}</td>
                                                                <td style="text-align: right; padding-right:  2cm"><fmt:formatNumber maxFractionDigits="0" value="${listDec[1]}"></fmt:formatNumber>.00</td>
                                                                </tr>



                                                        </c:forEach>

                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                        </table>
                                        <!--</table></td><td>-->
                                        <table border="1" style="width: 90%" cellspacing="0" cellpadding="0" align="center" id="demo" class="table table-bordered table-striped table-hover">
                                            <thead>

                                                <tr>
                                                    <th align="right">Recd. Pay Slip, Salary & Verified</th>
                                                    <th align="left">Net Salary</th>
                                                    <th style="text-align: right; padding-right:  2cm">${nettotal}</th>

                                                </tr>
                                                <c:if test="${not empty loanRemainigAmount[0]}">
                                                    <tr>

                                                        <th align="left">Remaining Company Loan Balance : ${loanRemainigAmount[0]} </th>

                                                    </tr>
                                                </c:if>

                                            </thead>

                                            <%--</c:otherwise>--%>
                                            <%--</c:choose>--%>

                                        </table>

                                    </div>


                                    <!--<input type="submit" value="Export To Pdf" class="btn btn-primary"/>-->

                                </form:form>
                                <hr />

                            </div>

                        </div> <!-- /container -->

                    </div> 
                </div> 
            </div> 
        </section> 
    </div> 
    <style>
        .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th{
            padding: 0px;
        }
    </style>
    <!--    <form>
            <input type="button" value="Print" onclick="window.print()">
        </form>-->
</html>

