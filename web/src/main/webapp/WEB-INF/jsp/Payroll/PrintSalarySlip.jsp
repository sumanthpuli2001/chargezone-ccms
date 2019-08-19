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
        <title>Salary Slip</title>
    </head>
    <style>
            table {
                border:1px solid #000 !important;
                padding: 3px !important;
            }
            th, td {
                padding: 3px !important;
                border:1px solid #000 !important;
            }
        </style>
    <style type="text/css">



        br.newpage {
            mso-special-character:line-break;
            page-break-after:always;
        }

    </style>
<body onload="test_skill(${nettotal});">
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
                <div class="col-md-8">
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
                                        <c:forEach var="employeeMaster" items="${Addfinallist3}">
                                            <table style=" width: 90%;" align="center">
                                            <tr>
                                                <td style="border:0px; width: 17%;">
                                            <center><img src=" StorageYard/Images/logo.png" style="width:70%;height: 70%;" BORDER="0"/> </center>
                                            </td>
                                            <td style="border:0px; width: 40%;">
                                                <center><b><font size="5">Vadera & Co.</font></b></center>
                                                <font size="2"><b>Registered Office Address:</b> 406, Ozone, Nr Centre Square Mall, Sarabhai Marg , Vadodara -
                                                390003, Gujarat , India<br/>
                                                <b>Business Unit:</b> Business Augmentation Services<br/>
                                                <b> Business Unit Address:</b> 403, Ozone, Near Vadodara Central, Sarabhai Road, Vadodara </font>

                                                </td>
                                            </tr>
                                            
                                            </table>
                                            <table style=" width: 90%;" align="center">
                                            <tr>
                                                <td>
                                                    <header>
                                            <center><font size="4">Salary Slip for <c:if test="${month eq 1}">January</c:if>
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
                                                    <c:if test="${month eq 12}">December</c:if> - ${year}</font></center> 
                                                    </header>
                                                </td>
                                                </tr>
                                            </table>


                                            <table style=" width: 90%;" align="center">
                                                <tr>
                                                        <td style="border:0px; width: 30%;" colspan="2">
                                                            <font size="2">Employee Name:<b>${employeeMaster[0].employeeName}</b></font></td>
                                                    <td style="border:0px; width: 15%;  height: 0px !important">
                                                        <font size="2">Employee Type:<b>${employeeMaster[0].employeeType}</font>
                                                    </td>
                                                    <td style="border:0px; width: 15%;  height: 0px !important">
                                                        <font size="2">Employee NO:&nbsp;&nbsp;<b>${employeeMaster[0].employeeId}</b></font>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2">
                                                        <font size="2">Designation:&nbsp;&nbsp;<b>${employeeMaster[0].designationMaster.designationName}</b></font></td>
                                                    <td colspan="2">
                                                        <font size="2">Duration:&nbsp;&nbsp;<b>1st <c:if test="${month eq 1}">January</c:if>
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
                                                            <c:if test="${month eq 12}">December</c:if>, ${year} to 31st <c:if test="${month eq 1}">January</c:if>
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
                                                            <c:if test="${month eq 12}">December</c:if>, ${year}</b></font></td>


                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">
                                                            <font size="2">Department:&nbsp;&nbsp;<b>${employeeMaster[0].departmentMaster.departmentName}</b></font> </td>
                                                    <td colspan="2">
                                                        <font size="2">Total Month Days:&nbsp;&nbsp;<b>${employeeMaster[0].uanNo}</b></font></td>
                                                </tr>


                                            <tr>
                                                    <td colspan="2">
                                                        <font size="2">Date of Joining:&nbsp;&nbsp;<b>${employeeMaster[0].dateOfJoining}</b></font></td>
                                                    <td colspan="2">
                                                        <font size="2">Working Days:<b>&nbsp;&nbsp;${employeeMaster[1][0].workingDays}</b></font></td>
                                                </tr>
                                            <tr>

                                                    <td style="border:0px; width: 15%;" >
                                                        <font size="2">PF Number: <b>${employeeMaster[0].pfNo}</b></font></td>
                                                    <td style="border:0px; width: 15%;" >
                                                        <font size="2">UAN Number: <b>${employeeMaster[0].uanNo}</b></font> </td>
                                                        <c:if test="${not empty employeeMaster[0].esicNo}">
                                                        <td>
                                                            <font size="2">PAN Number: &nbsp;&nbsp;<b>${employeeMaster[0].panCard}</b></font></td>
                                                        </c:if>
                                                        <c:if test="${not empty employeeMaster[0].esicNo}">
                                                        <td>
                                                            <font size="2"> ESIC No: &nbsp;&nbsp;<b>${employeeMaster[0].esicNo}</b></font></td>
                                                        </c:if>
                                                </tr>
                                                <tr>
                                                    <td colspan="1">
                                                        <font size="2">Bank Name: <b>${employeeMaster[0].uanNo}</b></font> </td>
                                                    <td colspan="1">
                                                        <font size="2">Account No: <b>${employeeMaster[0].bankAccountNo}</b></font> </td>
                                                        <c:if test="${not empty employeeMaster[0].esicNo}">
                                                        <td>
                                                            <font size="2">IFSC Code: <b>${employeeMaster[0].esicNo}</b></font></td>
                                                        </c:if>

                                                    <td>
                                                        <font size="2">Branch Name: <b>${employeeMaster[0].uanNo}</b> </font></td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2">
                                                <center><font size="2"><b>Earnings</b></font></center> </td>
                                                <td colspan="2">
                                                <center><font size="2"><b>Deductions</b></font></center></td>
                                                </tr>
                                        <!--</table>-->


                                        <!--<table style=" width: 90%;" align="center">-->

                                        <tr>
                                            <td colspan="2">

                                                <table id="demo" cellspacing="0" cellpadding="0" style="width: 100%; border: 0px;"
                                                               border="0" align="center" class="table table-bordered table-striped table-hover"  >

                                                    <c:choose>
                                                        <c:when test="${empty employeeMaster[2]}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="No any Increment."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th align="left">Components</th>
                                                                    <th style="text-align: right; padding-right:  2cm">Amount</th>

                                                                </tr>
                                                            </thead>
                                                            <tfoot>
                                                                <tr>
                                                                    <th align="left">Gross Salary (A)</th>
                                                                    <th  style="text-align: right; padding-right:  2cm" ><fmt:formatNumber maxFractionDigits="0" value="${employeeMaster[4]}"></fmt:formatNumber>.00</th>
                                                                    </tr>
                                                                </tfoot>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <tr>
                                                            <td>Basic +DA </td>
                                                            <td style="text-align: right; padding-right:  2cm"><fmt:formatNumber maxFractionDigits="0" value="${employeeMaster[3]}"></fmt:formatNumber>.00</td>
                                                            </tr>

                                                        <c:forEach var="employeeAdditional" items="${employeeMaster[2]}">
                                                            <c:if test="${employeeAdditional[1] ne 0.0}">

                                                                <tr>
                                                                    <td>${employeeAdditional[0]}</td>
                                                                    <td style="text-align: right; padding-right:  2cm"><fmt:formatNumber maxFractionDigits="0" value="${employeeAdditional[1]}"></fmt:formatNumber>.00</td>

                                                                    </tr>
                                                            </c:if>

                                                        </c:forEach>

                                                    </tbody>
                                                </table></td>

                                                <td colspan="2">
                                                <table id="demo" cellspacing="0" cellpadding="0" style="width: 100%; border: 0px;"
                                                       border="0" align="center" class="table table-bordered table-striped table-hover"  >

                                                    <c:choose>
                                                        <c:when test="${empty employeeMaster[5]}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="No any Decrement."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr >
                                                                    <th align="left" >Components</th>
                                                                    <th style="text-align: right; padding-right:  2cm">Amount</th>
                                                                </tr>
                                                            </thead>

                                                            <tfoot>
                                                                <tr>
                                                                    <th align="left">Total Deduction (B)</th>
                                                                    <th style="text-align: right; padding-right:  2cm"><fmt:formatNumber maxFractionDigits="0" value="${employeeMaster[6]}"></fmt:formatNumber>.00</th>
                                                                    </tr>
                                                                </tfoot>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="listDec" items="${employeeMaster[5]}">
                                                            <tr>
                                                                <td>${listDec[0]}</td>
                                                                <td style="text-align: right; padding-right:  2cm"><fmt:formatNumber maxFractionDigits="0" value="${listDec[1]}"></fmt:formatNumber>.00</td>
                                                                </tr>



                                                        </c:forEach>

                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td align="left">Net Pay (A-B)</td>
                                                    <td style="text-align: right; padding-right:  2cm"><b id="roundOffAmount">${nettotal}</b></td>
                                                    <td colspan="2"></td>

                                        </tr>
                                        <tr>
                                                    <td align="left">Excess/Short </td>
                                                    <td style="text-align: right; padding-right:  2cm">${excessShort} <b id="" style="font-size: 10px;"></b></td>
                                                    <td align="left">Actual Net Pay</td>
                                                    <td style="text-align: right; padding-right:  2cm">${actualNetpaybale}</td>
                                                </tr>

<!--                                        <tr>
                                            <td align="left"><b>Recd. Pay Slip, Salary & Verified</b></td>
                                            <td style="text-align: right; padding-right:  2cm">
                                                <b>Net Salary:</b>
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatNumber maxFractionDigits="0" value="${employeeMaster[7]}"></fmt:formatNumber> .00</td>

                                            </tr>-->
                                        <c:if test="${not empty employeeMaster[8][0]}">
                                            <tr>

                                                <td align="left"><b>Remaining Company Loan Balance :</b> ${employeeMaster[8][0]} </td>

                                            </tr>


                                        </c:if>

                                        <tr>
                                                    <td colspan="4" align="center"><b>Note:</b> ${notes}</td> 
                                                </tr>
                                        </table>
                                    </c:forEach>

                                    </div> 


                                </form:form>
                            </div> <!-- /container 
    
                            <!---->                                </div> 
                    </div> 
                </div> 
            </div>
        </section> 
    </div> 
    </body>
    <style>
        .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th{
            padding: 0px;
        }
    </style>

    <!--    <form>
            <input type="button" value="Print" onclick="window.print()">
        </form>
    <!---->    </html>

