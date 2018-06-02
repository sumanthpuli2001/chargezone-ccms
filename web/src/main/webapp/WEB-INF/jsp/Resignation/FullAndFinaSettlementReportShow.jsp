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
                                                    out.print("ToDay : " + df.format(date));
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
                                                            <td>${ListBWw[1]}</td>
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
                                                            <c:if test="${ctcDetail1[1] == 2}"><td>${totalMonthlyAmount2}</td></c:if>
                                                            <%--<c:if test="${ctcDetail1[1] == 3}"><td>${totalMonthlyAmount3}</td></c:if>--%>
                                                            <c:if test="${ctcDetail1[1] == 4}"><td>${totalMonthlyAmount4}</td></c:if>
                                                            <c:if test="${ctcDetail1[1] == 5}"><td>${totalMonthlyAmount5}</td></c:if>
                                                            <c:if test="${ctcDetail1[1] == 6}"><td>${totalMonthlyAmount6}</td></c:if>
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
                                                            <td>${Gratuiety1[2]}</td>
                                                            </tr>
                                                    </c:forEach>

                                                    <tr>
                                                        <th colspan="2"></th>
                                                        <th>TOTAL PAYABLES</th>
                                                        <th>${totalpayable}</th>
                                                    </tr>
                                                    <tr>
                                                        <th  colspan="4" style="text-align: center;">( B ) SALARY DEDUCTIONS </th>
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
                                                                <td>${list[4]}</td>
                                                            </tr>
                                                        </c:forEach>
                                                        <tr>
                                                            <th colspan="2"></th>
                                                            <th>TOTAL DEDUCTIONS</th>
                                                            <th>${deductionAmount}</th>
                                                        </tr>
                                                        <tr>
                                                            <th  colspan="4" style="text-align: center;"> ( A - B ) TOTAL NET PAYABLE</th>
                                                        </tr>
                                                        <tr>
                                                            <th colspan="3" style="text-align: center;"></th>
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
