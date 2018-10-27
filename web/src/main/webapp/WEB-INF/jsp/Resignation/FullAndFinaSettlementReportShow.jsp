<%-- 
    Document   : FullAndFinaSettlementReportShow
    Created on : 16 Apr, 2018, 5:09:04 PM
    Author     : Dell-1
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Resignation Employee</title>
    </head>

    <div class="content-wrapper">
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <input type="button" class="btn btn-facebook" style="float: right; width: 100px;" value="Print" onclick= "printDiv('printableArea')">

                                <div class="box-body">
                                    <div class="row">
                                        <div id="printableArea">
                                            <center> <img src=" StorageYard/Images/logo.png" style="width:15%;height: 15%;" BORDER="0"/> </center>
                                                <%
                                                    Date date = new Date();
                                                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                    out.print("Today : " + df.format(date));
//                                                    out.print("<div align=\"right\">DATE : " + df.format(date) + "</div>");
%>

                                            <!--<table style=" width: 100%; height: 0px !important;" align="left" name="SalarySlip" id="salarySlip" cellspacing="0" cellpadding="0" align="center" class="table table-bordered table-striped table-hover">-->
                                            <table style=" width: 100%; height: 0px !important;" border="1">
                                                <center><b><font size="3">SPC LIFESCIENCES PVT LTD. </font></b></center> 
                                                <div class="form-group">
                                                    <center><b><font size="2">FULL AND FINAL SETTLEMENT </font></b></center> 
                                                    <tr>
                                                        <th align="left">Employee Name</th>
                                                        <td >${employeeMaster.employeeName}</td>
                                                        <th align="left">Date Of Joining</th>
                                                        <td>${employeeMaster.dateOfJoining}</td>
                                                    </tr>
                                                    <tr>
                                                        <th align="left">Designation</th>
                                                        <td>${designationName}</td>
                                                        <th align="left">Date Of Resignation</th>
                                                        <td>${rm.effectiveDatetime}</td>
                                                    </tr>
                                                    <tr>
                                                        <th align="left">Department</th>
                                                        <td>${departmentName}</td>
                                                        <th align="left">Date Of Relieving</th>
                                                        <td>${rm.relievingDate}</td>
                                                    </tr>

                                                    <tr>
                                                        <th  colspan="4" style="text-align: center;">Particular</th>
                                                    </tr>
                                                    <tr>
                                                        <th  colspan="4" style="text-align: center;">( A ) PAYABLES </th>
                                                    </tr>
                                                    <tr>
                                                        <th colspan="3"></th>
                                                        <th>Amount (Rs.)</th>
                                                    </tr>
                                                    <c:forEach var="ListBWw" items="${ListBW}">
                                                        <tr>
                                                            <td><b>Salary  For The Month of</b></td>
                                                            <th colspan="1"></th>
                                                            <c:if test="${ListBWw[2] == 01}"><td><b>JAN</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 02}"><td><b>FEB</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 03}"><td><b>MAR</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 04}"><td><b>APR</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 05}"><td><b>MAY</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 06}"><td><b>JUN</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 07}"><td><b>JUL</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 08}"><td><b>AUG</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 09}"><td><b>SEP</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 10}"><td><b>OCT</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 11}"><td><b>NOV</b>'${ListBWw[3]}</td></c:if>
                                                            <c:if test="${ListBWw[2] == 12}"><td><b>DEC</b>'${ListBWw[3]}</td></c:if>
                                                            <td><fmt:formatNumber maxFractionDigits="0" value="${ListBWw[1]}"></fmt:formatNumber>.00</td>
                                                            </tr>
                                                    </c:forEach>
                                                    <c:forEach var="ctcDetail1" items="${ctcDetail}">
                                                        <tr>
                                                            <c:if test="${ctcDetail1[1] == 2}"><td><b>Bonus</b></td></c:if>
                                                            <%--<c:if test="${ctcDetail1[1] == 3}"><td><b>Gratuiety</b></td></c:if>--%>
                                                            <c:if test="${ctcDetail1[1] == 4}"><td><b>LTA</td></b></c:if>
                                                            <c:if test="${ctcDetail1[1] == 5}"><td><b>PERFORMANCE PAY</b></td></c:if>
                                                            <c:if test="${ctcDetail1[1] == 6}"><td><b>Variable</b></td></c:if>
                                                                <th colspan="1"></th>
                                                            <c:if test="${ctcDetail1[4] == 01}"><td><b>JAN</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 02}"><td><b>FEB</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 03}"><td><b>MAR</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 04}"><td><b>APR</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 05}"><td><b>MAY</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 06}"><td><b>JUN</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 07}"><td><b>JUL</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 08}"><td><b>AUG</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 09}"><td><b>SEP</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 10}"><td><b>OCT</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 11}"><td><b>NOV</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[4] == 12}"><td><b>DEC</b>'${ctcDetail1[5]}</td></c:if>
                                                            <c:if test="${ctcDetail1[1] == 2}"><td><fmt:formatNumber maxFractionDigits="0" value="${totalMonthlyAmount2}"></fmt:formatNumber>.00</td></c:if>
                                                            <%--<c:if test="${ctcDetail1[1] == 3}"><td>${totalMonthlyAmount3}</td></c:if>--%>
                                                            <c:if test="${ctcDetail1[1] == 4}"><td><fmt:formatNumber maxFractionDigits="0" value="${totalMonthlyAmount4}"></fmt:formatNumber>.00</td></c:if>
                                                            <c:if test="${ctcDetail1[1] == 5}"><td><fmt:formatNumber maxFractionDigits="0" value="${totalMonthlyAmount5}"></fmt:formatNumber>.00</td></c:if>
                                                            <c:if test="${ctcDetail1[1] == 6}"><td><fmt:formatNumber maxFractionDigits="0" value="${totalMonthlyAmount6}"></fmt:formatNumber>.00</td></c:if>
                                                                </tr>
                                                    </c:forEach>
                                                    <c:forEach var="Gratuiety1" items="${Gratuiety}">
                                                        <tr>
                                                            <!--<td><b>${Gratuiety1[1]}</b></td>-->
                                                            <c:if test="${Gratuiety1[1] == 3}"><td><b>Gratuiety</b></td></c:if>
                                                                <th colspan="1"></th>
                                                            <c:if test="${Gratuiety1[3] == 01}"><td><b>JAN</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 02}"><td><b>FEB</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 03}"><td><b>MAR</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 04}"><td><b>APR</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 05}"><td><b>MAY</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 06}"><td><b>JUN</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 07}"><td><b>JUL</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 08}"><td><b>AUG</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 09}"><td><b>SEP</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 10}"><td><b>OCT</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 11}"><td><b>NOV</b>'${Gratuiety1[4]}</td></c:if>
                                                            <c:if test="${Gratuiety1[3] == 12}"><td><b>DEC</b>'${Gratuiety1[4]}</td></c:if>
                                                            <td><fmt:formatNumber maxFractionDigits="0" value="${Gratuiety1[2]}"></fmt:formatNumber>.00</td>
                                                            </tr>
                                                    </c:forEach>

                                                    <tr>
                                                        <th colspan="2"></th>
                                                        <th align="left">TOTAL PAYABLES</th>
                                                        <th><fmt:formatNumber maxFractionDigits="0" value="${totalpayable}"></fmt:formatNumber>.00</th>
                                                    </tr>


                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <td><b>${list[3]}</b></td>
                                                                <th colspan="1"></th>
                                                                <c:if test="${list[1] == 01}"><td><b>JAN</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 02}"><td><b>FEB</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 03}"><td><b>MAR</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 04}"><td><b>APR</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 05}"><td><b>MAY</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 06}"><td><b>JUN</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 07}"><td><b>JUL</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 08}"><td><b>AUG</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 09}"><td><b>SEP</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 10}"><td><b>OCT</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 11}"><td><b>NOV</b>'${list[2]}</td></c:if>
                                                                <c:if test="${list[1] == 12}"><td><b>DEC</b>'${list[2]}</td></c:if>
                                                                <td><fmt:formatNumber maxFractionDigits="0" value="${list[4]}"></fmt:formatNumber>.00</td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <th colspan="2"></th>
                                                            <th align="left">TOTAL DEDUCTIONS</th>
                                                            <th><fmt:formatNumber maxFractionDigits="0" value="${deductionAmount}"></fmt:formatNumber>.00</th>
                                                        </tr>
                                                        <tr>
                                                            <th  colspan="4" style="text-align: center;"> ( A - B ) TOTAL NET PAYABLE</th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="3" style="text-align: center;"></th>
                                                            <th><fmt:formatNumber maxFractionDigits="0" value="${finaltotalBD}"></fmt:formatNumber>.00</th>
                                                        </tr>
                                                    </tbody>

                                            </table>


                                            <div class="form-group">
                                                <table style=" width: 100%; border: 0px;">
                                                    <tr>
                                                        <td colspan="2"> Said amount of Rs <b><fmt:formatNumber maxFractionDigits="0" value="${finaltotalBD}"></fmt:formatNumber>.00</b> /- will be credited to his ICICI Bank Account No. ${employeeMaster.bankAccountNo} against full and final statement of his account.</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2"><b>${fNfList[0][1]}</b></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">&nbsp;</td>
                                                    </tr>


                                                    <tr>
                                                        <td> <span style="border-top: 1px black solid;">Prepared By:</span></td>
                                                        <td> <span style="border-top: 1px black solid;">Forwarded By:</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Officer HR</td>
                                                        <td>HR Head</td>
                                                    </tr>

                                                    <tr>
                                                        <td colspan="2">${fNfList[0][3]}${employeeMaster.bankName} Bank Account No.${employeeMaster.bankAccountNo}</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2" style="text-align: right;"><b>MR.&nbsp;${employeeMaster.employeeName}</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2" style="text-align: right;">Receiver Signature&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                    </tr>
                                                </table>
                                                <div class="form-group">
                                                    <table style=" width: 100%; height: 0px !important;" border="1">
                                                        <tr><center><b><font size="3">EMPLOYEE DETAILS</font></b></center> </tr> 
                                                        <!--<table style=" width: 100%; height: 0px !important;" align="left" name="SalarySlip" id="salarySlip" cellspacing="0" cellpadding="0" align="center" class="table table-bordered table-striped table-hover">-->
                                                        <tr>
                                                            <th align="left">Name Of Employee</th>
                                                            <td>${employeeMaster.employeeName}</td>
                                                            <th align="left">Notice Period</th>
                                                            <td>${fullAndFinalSettlement.noticePeriod}</td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">Designation</th>
                                                            <td>${designationName}</td>
                                                            <th align="left">Given Notice</th>
                                                            <td>${fullAndFinalSettlement.givenNotice}</td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">Department</th>
                                                            <td>${departmentName}</td>
                                                            <th align="left">Recoverable Days</th>
                                                            <td>${fullAndFinalSettlement.recoveryDays}</td>
                                                        </tr>
                                                        <tr >
                                                            <th align="left">Employee Code</th>
                                                            <td>${employeeMaster.employeeId}</td>
                                                            <th>&nbsp;</th>
                                                            <td>&nbsp;</td>

                                                        </tr>
                                                        <tr>
                                                            <th align="left">Date of Joining</th>
                                                            <td>${employeeMaster.dateOfJoining}</td>
                                                            <th>&nbsp;</th>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">Date of Resignation</th>
                                                            <td>${rm.effectiveDatetime}</td>
                                                            <th>&nbsp;</th>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <th align="left">Date of Relieving</th>
                                                            <td>${rm.relievingDate}</td>
                                                            <th>&nbsp;</th>
                                                            <td>&nbsp;</td>
                                                        </tr>
                                                    </table>
                                                </div>
                                                <br>
                                                <table style=" width: 100%; height: 0px !important;" border="1">
                                                    <!--<table style=" width: 100%; height: 0px !important;" align="left" name="SalarySlip" id="salarySlip" cellspacing="0" cellpadding="0" align="center" class="table table-bordered table-striped table-hover">-->
                                                    <tr>
                                                        <th  colspan="4" style="text-align: center;">1. PAYABLE</th>
                                                        <th colspan="4" style="text-align: center;" > 2. OTHER DEDUCTION</th>
                                                    </tr>
                                                    <tr>
                                                        <th  colspan="4" style="text-align: left;">1.1 Earned Salary</th>
                                                        <th colspan="4" style="text-align: center;" ></th>
                                                    </tr>
                                                    <td colspan="3" style="text-align: left;"  ><b>COMPONENTS</b></td>
                                                    <td>
                                                        <c:forEach var="salary" items="${salary}">
                                                            <c:if test="${salary[1] == 01}"><b>JAN'01</b></c:if>
                                                            <c:if test="${salary[1] == 02}"><b>FEB'02</b></c:if>
                                                            <c:if test="${salary[1] == 03}"><b>MAR'03</b></c:if>
                                                            <c:if test="${salary[1] == 04}"><b>APR'04</b></c:if>
                                                            <c:if test="${salary[1] == 05}"><b>MAY'05</b></c:if>
                                                            <c:if test="${salary[1] == 06}"><b>JUN'06</b></c:if>
                                                            <c:if test="${salary[1] == 07}"><b>JUL'07</b></c:if>
                                                            <c:if test="${salary[1] == 08}"><b>AUG'08</b></c:if>
                                                            <c:if test="${salary[1] == 09}"><b>SEP'09</b></c:if>
                                                            <c:if test="${salary[1] == 10}"><b>OCT'10</b></c:if>
                                                            <c:if test="${salary[1] == 11}"><b>NOV'11</b></c:if>
                                                            <c:if test="${salary[1] == 12}"><b>DEC'12</b></c:if>
                                                        </c:forEach>
                                                    </td>
                                                    <th>2.1 Notice Period Recovery</th>
                                                    <td>${fullAndFinalSettlement.noticePeriodRecovery}</td>
                                                    <tr>
                                                        <th colspan="3" style="text-align: left;"  ><b></b></th>
                                                        <th></th>
                                                        <th>2.2 Shoes Deduction</th>
                                                        <td>${fullAndFinalSettlement.shoesDeduction}</td>
                                                    </tr>
                                                    <c:forEach var="salary" items="${salary}">
                                                        <tr>
                                                            <th colspan="3" style="text-align: left;"  ><b>Gross</b></th>
                                                            <th><fmt:formatNumber maxFractionDigits="0" value="${salary[6]}"></fmt:formatNumber>.00</th>
                                                            <th>2.3 Uniform Deduction</th>
                                                            <td>${fullAndFinalSettlement.uniformDeduction}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <th colspan="3" style="text-align: left;"  ><b>ESIC </b></th>
                                                        <th>-</th>
                                                        <th>2.4 Other Deduction</th>
                                                        <td>${fullAndFinalSettlement.otherDeduction}</td>
                                                    </tr>
                                                    <c:forEach var="list" items="${list}">
                                                        <tr>
                                                            <th colspan="3" style="text-align: left;"  ><b>${list[3]}</b></th>
                                                            <th><fmt:formatNumber maxFractionDigits="0" value="${list[4]}"></fmt:formatNumber>.00</th>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <th colspan="3" style="text-align: left;"  ><b>Reimbursment </b></th>
                                                        <th>-</th>
                                                        <th></th>
                                                        <td></td>
                                                    </tr>
                                                    <c:forEach var="salary" items="${salary}">
                                                        <tr>
                                                            <th colspan="3" style="text-align: left;" ><b>Salary Net Pay</b></th>
                                                            <th><fmt:formatNumber maxFractionDigits="0" value="${salary[5]}"></fmt:formatNumber>.00</th>
                                                        </tr>
                                                    </c:forEach>
                                                    <tr>
                                                        <th  colspan="4" style="text-align: left;">1.8 Leave Encashment</th>
                                                        <th>TOTAL DEDUCTION</th>
                                                        <td><fmt:formatNumber maxFractionDigits="0" value="${totaldeduction}"></fmt:formatNumber>.00</td>
                                                    </tr>
                                                    <tr>
                                                        <th colspan="3" style="text-align: left;"><b>Pl Calculation</b></th>
                                                        <th>  
                                                            <c:forEach var="salary" items="${salary}">
                                                                <b>YEAR'${salary[2]}</b
                                                            </c:forEach>
                                                        <th>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th colspan="3" style="text-align: left;">Basic</th>
                                                        <td>
                                                            <c:forEach var="salary" items="${salary}">
                                                                <b><fmt:formatNumber maxFractionDigits="0" value="${salary[7]}"></fmt:formatNumber>.00</b>
                                                            </c:forEach>
                                                        </td>
                                                        <td></td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <th colspan="3" style="text-align: left;">Leave Balance</th>
                                                        <th>${leavedayscount}</th>
                                                        <th></th>
                                                        <td></td>

                                                    </tr>
                                                    <tr>
                                                        <th colspan="3" style="text-align: left;" ><b>Pl Final Amt.</b></th>
                                                        <th><b><fmt:formatNumber maxFractionDigits="0" value="${totalLyamountCount}"></fmt:formatNumber>.00</b></th>
                                                        <th></th>
                                                        <td></td>
                                                    </tr>
                                                </table>
                                                <br>

                                                <c:set var="count" value="0" scope="page" />
                                                <table style=" width: 100%; height: 0px !important;" border="1">
                                                    <!--<table style=" width: 100%; height: 0px !important;" align="left" name="SalarySlip" id="salarySlip" cellspacing="0" cellpadding="0" align="center" class="table table-bordered table-striped table-hover">-->
                                                    <tr>
                                                        <th  colspan="4" style="text-align: left;">1.4 Bonus</th>
                                                    </tr>
                                                    <td><b>MONTHS</b></td>
                                                    <td><b>Paid Days</b></td>
                                                    <td><b>Earned Basic</b></td>
                                                    <c:forEach var="daysfetch" items="${daysfetch}" varStatus="index" >
                                                        <tr>
                                                            <c:if test="${daysfetch[2] == 01}"><td><b>JAN</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 02}"><td><b>FEB</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 03}"><td><b>MAR</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 04}"><td><b>APR</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 05}"><td><b>MAY</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 06}"><td><b>JUN</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 07}"><td><b>JUL</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 08}"><td><b>AUG</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 09}"><td><b>SEP</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 10}"><td><b>OCT</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 11}"><td><b>NOV</b></td></c:if>
                                                            <c:if test="${daysfetch[2] == 12}"><td><b>DEC</b></td></c:if>
                                                            <td>${daysfetch[1]}</td>
                                                            <td><fmt:formatNumber maxFractionDigits="0" value="${bonusFetch[count][1]}"></fmt:formatNumber>.00</td>
                                                        </tr>
                                                        <c:set var="count" value="${count + 1}" scope="page"/>
                                                    </c:forEach>
                                                    <td><b>TOTAL</b></td>
                                                    <td><b>${leavedaysfetch}</b></td>
                                                    <td><b><fmt:formatNumber maxFractionDigits="0" value="${bounsdata}"></fmt:formatNumber>.00</b></td>
                                                </table>
                                                <div class="row" align="center"><b>Note:</b> ${notes}</div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </div>
</section>
</div>
<script type="text/javascript">
    function onChangeTest(changeVal) {
        var x = document.getElementById("budget1").value;
        var y = document.getElementById("budget").value;
        var z = x - y;
        document.getElementById("remaining").value = z;
    }
</script>
<script type="text/javascript">
    function printDiv(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;
//
        document.body.innerHTML = printContents;
        window.print();
        document.body.innerHTML = originalContents;
    }

</script>
<style>
    .table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th{
        padding: 0px;
    }
</style>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
