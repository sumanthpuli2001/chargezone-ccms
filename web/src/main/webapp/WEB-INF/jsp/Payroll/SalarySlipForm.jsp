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
    </head>
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



                    <div class="col-md-8" >
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
                                            <table style=" width: 90%;" align="center">
                                                <tr>
                                                    <td style="border:0px; width: 17%;">
                                                <center><img src=" StorageYard/Images/logo.png" style="width: 70%;height: 70%;" BORDER="0"/> </center>
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
                                                                <c:if test="${month eq 2}"> February</c:if>
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
                                                            <font size="2">Employee Name:<b>${employeeMaster.employeeName}</b></font></td>
                                                    <td style="border:0px; width: 15%;  height: 0px !important">
                                                        <font size="2">Employee Type:<b>${employeeMaster.employeeType}</b></font>
                                                    </td>
                                                    <td style="border:0px; width: 15%;  height: 0px !important">
                                                        <font size="2">Employee NO:&nbsp;&nbsp;<b>${employeeMaster.employeeId}</b></font>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td colspan="2">
                                                        <font size="2">Designation:&nbsp;&nbsp;<b>${employeeMaster.designationMaster.designationName}</b></font></td>
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
                                                            <font size="2">Department:&nbsp;&nbsp;<b>${employeeMaster.departmentMaster.departmentName}</b></font> </td>
                                                    <td colspan="2">
                                                        <font size="2">Total Month Days:&nbsp;&nbsp;<b>${employeeMaster.uanNo}</b></font></td>
                                                </tr>

                                                <tr>
                                                    <td colspan="2">
                                                        <font size="2">Date of Joining:&nbsp;&nbsp;<b>${employeeMaster.dateOfJoining}</b></font></td>
                                                    <c:forEach  var="employeeExcelRecordList" items="${employeeExcelRecordList}">
                                                                <c:set var="count" value="${count + 1}" scope="page"/>
                                                    <td colspan="2">
                                                        <font size="2">Working Days:<b>&nbsp;&nbsp;${employeeExcelRecordList.workingDays}</b></font></td>
                                                    </c:forEach>
                                                </tr>
                                                <tr>

                                                    <td style="border:0px; width: 15%;" >
                                                        <font size="2">PF Number: <b>${employeeMaster.pfNo}</b></font></td>
                                                    <td style="border:0px; width: 15%;" >
                                                        <font size="2">UAN Number: <b>${employeeMaster.uanNo}</b></font> </td>
                                                        <c:if test="${not empty employeeMaster.esicNo}">
                                                        <td>
                                                            <font size="2">PAN Number: &nbsp;&nbsp;<b>${employeeMaster.panCard}</b></font></td>
                                                        </c:if>
                                                        <c:if test="${not empty employeeMaster.esicNo}">
                                                        <td>
                                                            <font size="2"> ESIC No: &nbsp;&nbsp;<b>${employeeMaster.esicNo}</b></font></td>
                                                        </c:if>
                                                </tr>
                                                <tr>
                                                    <td colspan="1">
                                                        <font size="2">Bank Name: <b>${employeeMaster.uanNo}</b></font> </td>
                                                    <td colspan="1">
                                                        <font size="2">Account No: <b>${employeeMaster.bankAccountNo}</b></font> </td>
                                                        <c:if test="${not empty employeeMaster.esicNo}">
                                                        <td>
                                                            <font size="2">IFSC Code: <b>${employeeMaster.esicNo}</b></font></td>
                                                        </c:if>

                                                    <td>
                                                        <font size="2">Branch Name: <b>${employeeMaster.uanNo}</b> </font></td>
                                                </tr>        
                                                <tr>
                                                    <td colspan="2">
                                                <center><font size="2"><b>Earnings</b></font></center> </td>
                                                <td colspan="2">
                                                <center><font size="2"><b>Deductions</b></font></center></td>
                                                </tr>
                                                <!--
                                                
                                                <tr>
                                                    <td colspan="1">
                                                    <center><font size="2"><b>Components</b></font></center> </td>
                                                    <td colspan="1">
                                                    <center><font size="2">Amount (Rs.)</font></center></td>
                                                    <td colspan="1">
                                                    <font size="2"><b>Common Deductions</b></font></td>
                                                    <td colspan="1">
                                                    <center><font size="2">Amount (Rs.)</font></center></td>
                                                </tr>-->



                                                <tr>
                                                    <td  colspan="2">
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
                                                                            <th align="left">Components</th>
                                                                            <th  style="text-align: right; padding-right:  2cm">Amount</th>

                                                                        </tr>
                                                                    </thead>
                                                                    <tfoot>
                                                                        <tr>
                                                                            <th align="left">Gross Earning (A)</th>
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
                                                            <!--</table>-->
                                                        </table>
                                                    </td>
                                                    <td colspan="2">
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
                                                                            <th align="left" >Components</th>
                                                                            <th style="text-align: right; padding-right:  2cm">Amount</th>
                                                                        </tr>
                                                                    </thead>

                                                                    <tfoot>
                                                                        <tr>
                                                                            <th align="left">Total Deduction (B)</th>
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
                                                <!--</table>-->

                                                <!--<table border="1" style="width: 90%" cellspacing="0" cellpadding="0" align="center" id="demo" class="table table-bordered table-striped table-hover">-->
                                                <!--<thead>-->

                                                <tr>
                                                    <!--<th align="right">Recd. Pay Slip, Salary & Verified</th>-->
                                                    <td align="left">Net Pay (A-B)</td>
                                                    <td style="text-align: right; padding-right:  2cm"> <b id="roundOffAmount">${nettotal}</b></td>
                                                    <td colspan="2"></td>
                                                </tr>
                                                <!--                                                <tr style="border: none !important;">
                                                                                                        <td style="text-align: left; vertical-align: middle;width:50%;border: none !important;">
                                                                                                            <b style="font-size: 10px;">Rupee:</b>&nbsp;&nbsp;&emsp;<b id="paraGraphId" style="font-size: 10px;">&nbsp;Only</b>
                                                                                                        </td>
                                                                                                    </tr>-->
                                                <c:if test="${not empty loanRemainigAmount[0]}">
                                                    <tr>

                                                        <th align="left">Remaining Company Loan Balance : ${loanRemainigAmount[0]} </th>

                                                    </tr>
                                                </c:if>



                                                <!--</thead>-->

                                                <%--</c:otherwise>--%>
                                                <%--</c:choose>--%>
                                                <tr>
                                                    <td colspan="4" align="center"><b>Note:</b> ${notes}</td> 
                                                </tr>

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


        <script>
            function test_skill(aa) {

                var junkVal = String(aa);
                junkVal = Math.round(junkVal);
                var obStr = new String(junkVal);
                numReversed = obStr.split("");
                actnumber = numReversed.reverse();
                if (Number(junkVal) >= 0) {
                    //do nothing
                } else {
                    //                alert('wrong Number cannot be converted');
                    return false;
                }
                if (Number(junkVal) == 0) {
                    //document.getElementById('container').innerHTML=obStr+''+'Rupees Zero Only';
                    return false;
                }
                if (actnumber.length > 9) {
                    //                alert('Oops!!!! the Number is too big to covertes');
                    return false;
                }

                var iWords = ["Zero", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine"];
                var ePlace = ['Ten', ' Eleven', ' Twelve', ' Thirteen', ' Fourteen', ' Fifteen', ' Sixteen', ' Seventeen', ' Eighteen', ' Nineteen'];
                var tensPlace = ['dummy', ' Ten', ' Twenty', ' Thirty', ' Forty', ' Fifty', ' Sixty', ' Seventy', ' Eighty', ' Ninety'];

                var iWordsLength = numReversed.length;
                var totalWords = "";
                var inWords = new Array();
                var finalWord = "";
                j = 0;
                for (i = 0; i < iWordsLength; i++) {
                    switch (i)
                    {
                        case 0:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            } else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            //                        inWords[j] = inWords[j] + ' Point ';
                            inWords[j] = inWords[j] + '';
                            break;
                        case 1:
                            tens_complication();
                            break;
                        case 2:
                            if (actnumber[i] == 0) {
                                inWords[j] = '';
                            } else if (actnumber[i - 1] != 0 && actnumber[i - 2] != 0) {
                                inWords[j] = iWords[actnumber[i]] + ' Hundred and';
                            } else {
                                inWords[j] = iWords[actnumber[i]] + ' Hundred';
                            }
                            break;
                        case 3:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            } else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            if (actnumber[i + 1] != 0 || actnumber[i] > 0) {
                                inWords[j] = inWords[j] + " Thousand";
                            }
                            break;
                        case 4:
                            tens_complication();
                            break;
                        case 5:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            } else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            if (actnumber[i + 1] != 0 || actnumber[i] > 0) {
                                inWords[j] = inWords[j] + " Lakh";
                            }
                            break;
                        case 6:
                            tens_complication();
                            break;
                        case 7:
                            if (actnumber[i] == 0 || actnumber[i + 1] == 1) {
                                inWords[j] = '';
                            } else {
                                inWords[j] = iWords[actnumber[i]];
                            }
                            inWords[j] = inWords[j] + " Crore";
                            break;
                        case 8:
                            tens_complication();
                            break;
                        default:
                            break;
                    }
                    j++;
                }

                function tens_complication() {
                    if (actnumber[i] == 0) {
                        inWords[j] = '';
                    } else if (actnumber[i] == 1) {
                        inWords[j] = ePlace[actnumber[i - 1]];
                    } else {
                        inWords[j] = tensPlace[actnumber[i]];
                    }
                }
                inWords.reverse();
                for (i = 0; i < inWords.length; i++) {
                    finalWord += inWords[i];
                }

                var a = finalWord;
                document.getElementById('paraGraphId').innerHTML = a;

                document.getElementById('roundOffAmount').innerHTML = (parseFloat(junkVal) - parseFloat(${netAmount})).toFixed(2);
            }

        </script>
        <!--    <form>
                <input type="button" value="Print" onclick="window.print()">
            </form>-->
        <%--<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>--%>
    </body>
</html>

