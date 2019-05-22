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
                                        <header>
                                            <center><img src=" StorageYard/Images/logo.png" style="width:14%;height: 14%;" BORDER="0"/> </center>
                                            <center><b><font size="4">  ${employeeMaster.company}</font></b></center> 
                                            <center><b><font size="4">SALARY SLIP FOR <c:if test="${month eq 1}">JANUARY</c:if>
                                                    <c:if test="${month eq 2}">FEBRUARY</c:if>
                                                    <c:if test="${month eq 3}">MARCH</c:if>
                                                    <c:if test="${month eq 4}">APRIL</c:if>
                                                    <c:if test="${month eq 5}">MAY</c:if>
                                                    <c:if test="${month eq 6}">JUNE</c:if>
                                                    <c:if test="${month eq 7}">JULY</c:if>
                                                    <c:if test="${month eq 8}">AUGUST</c:if>
                                                    <c:if test="${month eq 9}">SEPTEMBER</c:if>
                                                    <c:if test="${month eq 10}">OCTOBER</c:if>
                                                    <c:if test="${month eq 11}">NOVEMBER</c:if>
                                                    <c:if test="${month eq 12}">DECEMBER</c:if> ${year}</font></b></center> 
                                            </header>


                                           

                                        <table style=" width: 90%;" align="center">
                                          
                                        
                                         <tr>
                                                    <td style="border:0px; width: 30%;"><!--style="border:0px"-->
                                                        <b>Emp Name</b>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.employeeName} </td>
                                                <td style="border:0px; width: 30%;  height: 0px !important">
                                                    <b>Employee Type&nbsp;</b>
                                                    <b>:</b>&nbsp;&nbsp;${employeeMaster.employeeId}
                                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                                    <b>Emp ID&nbsp;</b>
                                                    <b>:</b>&nbsp;&nbsp;${employeeMaster.employeeId}

                                                </td>


                                            </tr>

                                            <tr>
                                                <td><!--style="border:0px"-->
                                                    <b>Designation</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.designationMaster.designationName}</td>
                                                <td><!--style="border:0px"-->
                                                    <b>Duration&nbsp;</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;1st <c:if test="${month eq 1}">January</c:if>
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
                                                    <c:if test="${month eq 12}">December</c:if>, ${year}    to 31st <c:if test="${month eq 1}">January</c:if>
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
                                                    <c:if test="${month eq 12}">December</c:if>, ${year}</td>


                                                </tr>
                                                <tr>
                                                    <td>
                                                        <b>Department&nbsp;</b>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.departmentMaster.departmentName} </td>
                                                <td><!--style="border:0px"-->
                                                    <b>Total Month Days&nbsp;</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.uanNo} </td>
                                                <!--                                            <td>style="border:0px"
                                                                                                <b>DOJ&nbsp;</b>
                                                                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.dateOfJoining} </td>
                                                                                            <td>style="border:0px"
                                                                                                <b>Bank A/C No</b>
                                                                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.bankAccountNo} </td>-->
                                            </tr>

                                            <tr>
                                                <td>
                                                    <b>DOJ&nbsp;</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.dateOfJoining} </td>
                                                <td><!--style="border:0px"-->
                                                    <b>Working Days</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.esicNo}</td>
                                            </tr>
                                            <tr>

                                                <td><!--style="border:0px"-->
                                                    <b>PF Number&nbsp;</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.uanNo} </td>
                                                <!--<td>style="border:0px"-->
                                                <td>
                                                    <b>UAN No&nbsp;</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.uanNo} </td>




                                            </tr>

                                            <tr>




                                                <c:if test="${not empty employeeMaster.esicNo}">
                                                    <td><!--style="border:0px"-->
                                                        <b>PAN Number</b>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.esicNo}</td>
                                                    </c:if>
                                                    <c:if test="${not empty employeeMaster.esicNo}">
                                                    <td>
                                                        <b>E.S.I.C No</b>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.esicNo}</td>
                                                    </c:if>

                                            </tr>
                                            <tr>


                                                <td><!--style="border:0px"-->
                                                    <b>Bank Name&nbsp;</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.uanNo} </td>

                                                <c:if test="${not empty employeeMaster.esicNo}">
                                                    <td><!--style="border:0px"-->
                                                        <b>IFSC Code</b>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.esicNo}</td>
                                                    </c:if>


                                            </tr>
                                            <tr>


                                                <td><!--style="border:0px"-->
                                                    <b>Branch Name&nbsp;</b>
                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>:</b>&nbsp;&nbsp;${employeeMaster.uanNo} </td>




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
                                                    <th style="text-align: right; padding-right:  2cm">${nettotal} <b id="roundOffAmount" style="font-size: 10px;"></b></th>

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
                                                    
                                                     

                                            </thead>

                                            <%--</c:otherwise>--%>
                                            <%--</c:choose>--%>

                                        </table>

                                    </div>
                                    <div class="row" align="center"><b>Note:</b> ${notes}</div>

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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
     </body>
</html>

