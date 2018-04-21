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

                                <div class="box-body">
                                    <div class="row">
                                        <div id="printableArea">
                                            <center> <img src=" StorageYard/Images/logo.png" style="width:15%;height: 15%;" BORDER="0"/> </center>
                                                <%
                                                    Date date = new Date();
                                                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                    out.print("Date : " + df.format(date));
//                                                    out.print("<div align=\"right\">DATE : " + df.format(date) + "</div>");
                                                %>
                                            <center><b><font size="3">SPC LIFESCIENCES PVT LTD. </font></b></center> 
                                            <div class="form-group">
                                                <center><b><font size="2">FULL AND FINAL SETTLEMENT </font></b></center> 

                                                <table style=" width: 100%; height: 0px !important;" align="left" name="SalarySlip" id="salarySlip" cellspacing="0" cellpadding="0" align="center" class="table table-bordered table-striped table-hover">
                                                    <tr>
                                                        <th>Employee Name</th>
                                                        <td>${employeeMaster.employeeName}</td>
                                                        <th>Date Of Joining</th>
                                                        <td>${employeeMaster.dateOfJoining}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Designation</th>
                                                        <td>${designationName}</td>
                                                        <th>Date Of Resignation</th>
                                                        <td>${rm.effectiveDatetime}</td>
                                                    </tr>
                                                    <tr>
                                                        <th>Department</th>
                                                        <td>${departmentName}</td>
                                                        <th>Date Of Relieving</th>
                                                        <td>${rm.relievingDate}</td>
                                                    </tr>

                                                    <tr>
                                                        <th  colspan="4" style="text-align: center;">Particular</th>
                                                    </tr>
                                                    <tr>
                                                        <th  colspan="4" style="text-align: center;">(A ) PAYABLES </th>
                                                    </tr>
                                                    <tr>
                                                        <th colspan="3"></th>
                                                        <th>Amount (Rs.)</th>
                                                    </tr>
                                                    <c:forEach var="esp" items="${esp}">
                                                        <tr>
                                                            <td><b>Salary  For The Month of</b></td>
                                                            <th colspan="1"></th>
                                                            <c:if test="${esp.month == 01}"><td><b>JAN</b></td></c:if>
                                                            <c:if test="${esp.month == 02}"><td><b>FEB</b></td></c:if>
                                                            <c:if test="${esp.month == 03}"><td><b>MAR</b></td></c:if>
                                                            <c:if test="${esp.month == 04}"><td><b>APR</b></td></c:if>
                                                            <c:if test="${esp.month == 05}"><td><b>MAY</b></td></c:if>
                                                            <c:if test="${esp.month == 06}"><td><b>JUN</b></td></c:if>
                                                            <c:if test="${esp.month == 07}"><td><b>JUL</b></td></c:if>
                                                            <c:if test="${esp.month == 08}"><td><b>AUG</b></td></c:if>
                                                            <c:if test="${esp.month == 09}"><td><b>SEP</b></td></c:if>
                                                            <c:if test="${esp.month == 10}"><td><b>OCT</b></td></c:if>
                                                            <c:if test="${esp.month == 11}"><td><b>NOV</b></td></c:if>
                                                            <c:if test="${esp.month == 12}"><td><b>DEC</b></td></c:if>
                                                            <td>${esp.netPayable}</td>
                                                        </tr>
                                                    </c:forEach>
                                                    <c:forEach var="ctcDetail11" items="${ctcDetail1}">
                                                        <tr>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 2}"><td><b>Bonus</b></td></c:if>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 3}"><td><b>Gratuiety</b></td></c:if>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 4}"><td><b>LTA</td></b></c:if>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 5}"><td><b>PERFORMANCE PAY</b></td></c:if>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 6}"><td><b>Variable</b></td></c:if>
                                                                <th colspan="1"></th>
                                                            <c:if test="${ctcDetail11.month == 01}"><td><b>JAN</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 02}"><td><b>FEB</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 03}"><td><b>MAR</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 04}"><td><b>APR</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 05}"><td><b>MAY</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 06}"><td><b>JUN</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 07}"><td><b>JUL</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 08}"><td><b>AUG</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 09}"><td><b>SEP</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 10}"><td><b>OCT</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 11}"><td><b>NOV</b></td></c:if>
                                                            <c:if test="${ctcDetail11.month == 12}"><td><b>DEC</b></td></c:if>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 2}"><td>${totalMonthlyAmount2}</td></c:if>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 3}"><td>${totalMonthlyAmount3}</td></c:if>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 4}"><td>${totalMonthlyAmount4}</td></c:if>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 5}"><td>${totalMonthlyAmount5}</td></c:if>
                                                            <c:if test="${ctcDetail11.ctcAllowance.id == 6}"><td>${totalMonthlyAmount6}</td></c:if>
                                                            </tr>
                                                    </c:forEach>

                                                    <tr>
                                                        <th colspan="2"></th>
                                                        <th>(B) TOTAL PAYABLES</th>
                                                        <th>${totalpayable}</th>
                                                    </tr>
                                                    <tr>
                                                        <th  colspan="3" style="text-align: center;">( C ) SALARY DEDUCTIONS </th>
                                                        <th></th>
                                                    </tr>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <td><b>${list[0].deductionType}</b></td>
                                                                <th colspan="1"></th>
                                                                <c:if test="${list[1].month == 01}"><td><b>JAN</b></td></c:if>
                                                                <c:if test="${list[1].month == 02}"><td><b>FEB</b></td></c:if>
                                                                <c:if test="${list[1].month == 03}"><td><b>MAR</b></td></c:if>
                                                                <c:if test="${list[1].month == 04}"><td><b>APR</b></td></c:if>
                                                                <c:if test="${list[1].month == 05}"><td><b>MAY</b></td></c:if>
                                                                <c:if test="${list[1].month == 06}"><td><b>JUN</b></td></c:if>
                                                                <c:if test="${list[1].month == 07}"><td><b>JUL</b></td></c:if>
                                                                <c:if test="${list[1].month == 08}"><td><b>AUG</b></td></c:if>
                                                                <c:if test="${list[1].month == 09}"><td><b>SEP</b></td></c:if>
                                                                <c:if test="${list[1].month == 10}"><td><b>OCT</b></td></c:if>
                                                                <c:if test="${list[1].month == 11}"><td><b>NOV</b></td></c:if>
                                                                <c:if test="${list[1].month == 12}"><td><b>DEC</b></td></c:if>
                                                                <td>${list[0].deductionAmount}</td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <th colspan="2"></th>
                                                            <th>(D) TOTAL DEDUCTIONS</th>
                                                            <th>${deductionAmount}</th>
                                                        </tr>
                                                        <tr>
                                                            <th  colspan="3" style="text-align: center;">TOTAL NET PAYABLE ( B - D )</th>
                                                            <!--<th colspan="1"></th>-->
                                                            <th>${finaltotalBD}</th>
                                                        </tr>
                                                    </tbody>

                                                </table>
                                            </div>
                                            <div class="form-group">
                                                <table style=" width: 100%; border: 0px;">
                                                    <tr>
                                                        <td colspan="2"> Said amount of Rs <b>${finaltotalBD}</b> /- will be credited to his ICICI Bank Account No. ${employeeMaster.bankAccountNo} against full and final statement of his account.</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2"><b>${fNfList[0].companyName}</b></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td> <span style="border-top: 1px black solid;">Prepared By:</span></td>
                                                        <td> <span style="border-top: 1px black solid;">Forwarded By:</span></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Kundan Gupta</td>
                                                        <td>Shailesh Limbachiya <br/> Manager HR & Admin</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2">${fNfList[0].description}</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2" style="text-align: right;"><b>MR.&nbsp;${employeeMaster.employeeName}</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2" style="text-align: right;">Receiver Signature&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                                    </tr>
                                                </table>
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
