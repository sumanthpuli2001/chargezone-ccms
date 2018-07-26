<%-- 
    Document   : ESICchalanDetail
    Created on : 29 Jun, 2018, 10:54:00 AM
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
        <title> ESIC Deduction Statement Search</title>
    </head>
    <script>
        function viewClick(id, month, year) {
            window.location = "employeeSalarySlip.htm?act=ViewIndiviualSalarySlip&id=" + id + "&month=" + month + "&year=" + year;
        }
    </script>
    <script>

        function saveSubmit11() {
            var flag3 = true;
//            alert(document.getElementById("month").value);
            if (document.getElementById("month").value == '') {
                document.getElementById("monthError").innerHTML = "- It must be selected.";
                flag3 = false;
            } else {
                document.getElementById("monthError").innerHTML = '';
            }
//            alert(flag3);
            if (flag3) {
                flag3 = false;
                document.getElementById('saveSubmit1').innerHTML = 'Searching ... .. .';
                document.form1.submit();
                return true;
            } else {
                return false;
            }
        }
    </script>



    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Search ESIC Deduction Statement Employee Detail:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Search ESIC Deduction Statement Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="payrollESIC.htm?act=searchEsicSubmit" method="post" name='form' onsubmit='return saveSubmit11();'>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <!--form horizontal starts here-->

                                <div class="box-header">

                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Months:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <select name="month" id="month" class="form-control ">
                                                        <option value="">--Select--</option>
                                                        <option value="01">January</option>
                                                        <option value="02">February</option>
                                                        <option value="03">March </option>
                                                        <option value="04">April</option>
                                                        <option value="05">May</option>
                                                        <option value="06">June</option>
                                                        <option value="07">July</option>
                                                        <option value="08">August</option>
                                                        <option value="09">September</option>
                                                        <option value="10">October </option>
                                                        <option value="11">November </option>
                                                        <option value="12">December</option>

                                                    </select>
                                                    <span id="monthError" style="color: red;"></span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Year:<span style="color: red;font-size: 12px;"></span></label>  
                                                    <select name="year11" id="year11" class="form-control ">

                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.box-body -->
                            <div class="form-group">
                                <div class=" col-sm-2">
                                    <button type="submit" class="btn btn-primary" data-original-title="" title="" >Search</button>
                                </div>
                            </div>

                            <div class="tab-pane" id="tab_3"></div>
                        </div>
                    </div>
                </div>

            </section>
        </form:form>

        <form:form action="" method="post" commandName="bankStatement.htm"
                   name='form2'  class="form-horizontal" role="form">
            <c:if test="${search ne 'none'}">
                <input type="hidden" name="month" value="${month}">
                <input type="hidden" name="year" value="${year}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <%--<c:choose>--%>
                                    <%--<c:when test="${!empty employeelist}">--%>

                                    <c:choose>
                                        <c:when test="${!empty list}">
                                            <div class="box-header" style="text-align: right;">
                                                <input type="button" class="btn btn-facebook" style="width: 100px;"  value="Print" onclick="printDiv('printableArea')">
                                            </div>
                                        </c:when>
                                    </c:choose>
                                    <%--</c:when>--%>
                                    <%--</c:choose>--%>
                                    <div id="printableArea">
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <div class="table table-bordered">

                                                        <div id="printableArea">
                                                            <table>
                                                                <tr>
                                                                    <td>
                                                                        <div class="box-header" style="text-align: left;border-right: 1px solid black;">
                                                                            <table style="width: 100%">
                                                                                <tr style="width: 100%">
                                                                                    <td style="width: 50%"><b><font size="3">E.S.I.C.</font></b></td>
                                                                                    <td style="text-align: right;width: 50%"><b><font size="3">ORIGINAL</font></b><br/>(For Bank)</td>
                                                                                </tr>
                                                                            </table>
                                                                        </div>
                                                                        <div class="col-md-12 col-sm-12" style="border-right: 1px solid black;" >
                                                                            <center><font size="2">EMPLOYEES' STATE INSURANCE FUND ACCOUNT No.1 </font><br/></center> 
                                                                            <center><font size="2">PAY-IN-SLIP FOR CONTRIBUTION</font> <br/></center>
                                                                            <b><font size="2">${list[0].bankName}</font></b>
                                                                            <table width="100%">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <td width="30%"><p style="font-size: 12px;height: 10px;">Station </p></td>
                                                                                        <td style="border-right:1px black solid;height: 10px;" width='20%'><%
                                                                                            Date date = new Date();
                                                                                            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                                                            //                                           out.print( "Date.." + df.format(date));
                                                                                            out.print("<div align=\"right\"><p style=\"font-size: 12px\">Date:" + df.format(date) + "</p></div>");
                                                                                            %>
                                                                                        </td>
                                                                                        <td rowspan="4" width="50%"><p style="font-size: 12px;">
                                                                                                Paid into the credit of the Employee's State Insurance Fund A/c No.1.</p>
                                                                                            <p style="font-size: 12px;"><fmt:formatNumber maxFractionDigits="0" value="${total}"></fmt:formatNumber>.00</p>
                                                                                                <p style="font-size: 12px;">
                                                                                                    in cash/by cheque (on realisation for payment of contribution as per detail given below under the employee's State Insurance Act, 1948</p>
                                                                                                <p style="font-size: 12px;"> For the month of &nbsp;&nbsp;&nbsp;${employeelist[0][6]}&nbsp;-&nbsp;${employeelist[0][7]}</p>  
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr style="border:1px solid black;">
                                                                                        <td style="border:1px solid black;text-align: center;">Particulars </td>
                                                                                        <td style="border:1px solid black;text-align: center;">Amount</td>
                                                                                    </tr>
                                                                                    <tr style="border:1px solid black;">
                                                                                        <td style="height: 75px;border:1px solid black;">&nbsp;&nbsp;&nbsp;</td>
                                                                                        <!--<td style="height: 75px;border:1px solid black;">${total}</td>-->
                                                                                        <td style="height: 75px;border:1px solid black;text-align: center;"><fmt:formatNumber maxFractionDigits="0" value="${total}" ></fmt:formatNumber>.00</td>
                                                                                        </tr>
                                                                                        <tr style="border:1px solid black;">
                                                                                            <td style="border:1px solid black;text-align: center;">Total </td>
                                                                                            <!--<td style="border:1px solid black;">${total}</td>-->
                                                                                        <td style="border:1px solid black;text-align: center;"><fmt:formatNumber maxFractionDigits="0" value="${total}"></fmt:formatNumber>.00</td>
                                                                                        </tr>
                                                                                    </thead>
                                                                                </table>
                                                                                <div class="box-header">
                                                                                    <font size="2">Deposited By&nbsp;&nbsp; <b> ${list[0].companyName}</font></b>
                                                                            </div>
                                                                            <div class="box-header">
                                                                                <div>&nbsp;</div>
                                                                                <center><b><font size="2">Authorised Signatory</font></b></center>

                                                                            </div>
                                                                            <table style="width:100%">
                                                                                <tr>
                                                                                    <td colspan="2">Employer's Code No.</td>
                                                                                    <th>${list[0].employeeCodeNo}</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="3">Name and Address of Factory/Establishment</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <th colspan="3" style="text-align: left;">${list[0].companyName}</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="3">${list[0].address}</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="3"  style="height: 15px;">&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="2">Nos of Employees</td>
                                                                                    <td style="text-align: right;">${readEmployeeCountlist[0]}</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="2">Total Wages</td>
                                                                                    <!--<td>${totalgrossAmount}</td>-->
                                                                                    <td style="text-align: right;"><fmt:formatNumber maxFractionDigits="0" value="${totalgrossAmount}"></fmt:formatNumber>.00</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Employee's Contribution</td>
                                                                                        <td style="text-align: center;">Rs.</td>
                                                                                        <!--<td>${totalEmpContrubtionAmount}</td>-->
                                                                                    <td style="text-align: right;"><fmt:formatNumber maxFractionDigits="0" value="${totalEmpContrubtionAmount}"></fmt:formatNumber>.00</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Employer's Contribution</td>
                                                                                        <td style="text-align: center;">Rs.</td>
                                                                                        <!--<td>${totalCompContrubtionAmount}</td>-->
                                                                                    <td style="text-align: right;"><fmt:formatNumber maxFractionDigits="0" value="${totalCompContrubtionAmount}"></fmt:formatNumber>.00</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Total</td>
                                                                                        <td style="text-align: center;">Rs.</td>
                                                                                        <!--<td>${total}</td>-->
                                                                                    <th style="text-align: right;"><fmt:formatNumber maxFractionDigits="0" value="${total}"></fmt:formatNumber>.00</th>
                                                                                    </tr>
                                                                                </table>
                                                                                <br/>
                                                                                <br/>

                                                                            </div>
                                                                        </td>
                                                                        <td>
                                                                            <div class="box-header" style="text-align: left;">
                                                                                <table style="width: 100%">
                                                                                    <tr style="width: 100%">
                                                                                        <td style="width: 50%"><b><font size="3">E.S.I.C.</font></b></td>
                                                                                        <td style="text-align: right;width: 50%"><b><font size="3">DUPLICATE</font></b><br/>(For Bank)</td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                            <div class="col-md-12 col-sm-12">
                                                                                <center><font size="2">EMPLOYEES' STATE INSURANCE FUND ACCOUNT No.1 </font><br/></center> 
                                                                                <center><font size="2">PAY-IN-SLIP FOR CONTRIBUTION</font> <br/></center>
                                                                                <b><font size="2">${list[0].bankName}</font></b>
                                                                            <table width="100%">
                                                                                <thead>
                                                                                    <tr>
                                                                                        <td width="30%"><p style="font-size: 12px;height: 10px;">Station </p></td>
                                                                                        <td style="border-right:1px black solid;height: 10px;" width='20%'><%
                                                                                            Date date1 = new Date();
                                                                                            SimpleDateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
                                                                                            //                                           out.print( "Date.." + df.format(date));
                                                                                            out.print("<div align=\"right\"><p style=\"font-size: 12px\">Date:" + df1.format(date1) + "</p></div>");
                                                                                            %>
                                                                                        </td>
                                                                                        <td rowspan="4" width="50%"><p style="font-size: 12px;">
                                                                                                Paid into the credit of the Employee's State Insurance Fund A/c No.1.</p>
                                                                                            <p style="font-size: 12px;"><fmt:formatNumber maxFractionDigits="0" value="${total}"></fmt:formatNumber>.00</p>
                                                                                                <p style="font-size: 12px;">
                                                                                                    in cash/by cheque (on realisation for payment of contribution as per detail given below under the employee's State Insurance Act, 1948</p>
                                                                                                <p style="font-size: 12px;"> For the month of &nbsp;&nbsp;&nbsp;${employeelist[0][6]}&nbsp;-&nbsp;${employeelist[0][7]}</p>  
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr style="border:1px solid black;">
                                                                                        <td style="border:1px solid black;text-align: center;">Particulars </td>
                                                                                        <td style="border:1px solid black;text-align: center;">Amount</td>
                                                                                    </tr>
                                                                                    <tr style="border:1px solid black;">
                                                                                        <td style="height: 75px;border:1px solid black;">&nbsp;&nbsp;&nbsp;</td>
                                                                                        <!--<td style="height: 75px;border:1px solid black;">${total}</td>-->
                                                                                        <td style="height: 75px;border:1px solid black;text-align: center;"><fmt:formatNumber maxFractionDigits="0" value="${total}" ></fmt:formatNumber>.00</td>
                                                                                        </tr>
                                                                                        <tr style="border:1px solid black;">
                                                                                            <td style="border:1px solid black;text-align: center;">Total </td>
                                                                                            <!--<td style="border:1px solid black;">${total}</td>-->
                                                                                        <td style="border:1px solid black;text-align: center;"><fmt:formatNumber maxFractionDigits="0" value="${total}"></fmt:formatNumber>.00</td>
                                                                                        </tr>
                                                                                    </thead>
                                                                                </table>
                                                                                <div class="box-header">
                                                                                    <font size="2">Deposited By&nbsp;&nbsp; <b> ${list[0].companyName}</font></b>
                                                                            </div>
                                                                            <div class="box-header">
                                                                                <div>&nbsp;</div>
                                                                                <center><b><font size="2">Authorised Signatory</font></b></center>

                                                                            </div>
                                                                            <table style="width:100%">
                                                                                <tr>
                                                                                    <td colspan="2">Employer's Code No.</td>
                                                                                    <th>${list[0].employeeCodeNo}</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="3">Name and Address of Factory/Establishment</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <th colspan="3" style="text-align: left;">${list[0].companyName}</th>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="3">${list[0].address}</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="3"  style="height: 15px;">&nbsp;</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="2">Nos of Employees</td>
                                                                                    <td style="text-align: right;">${readEmployeeCountlist[0]}</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="2">Total Wages</td>
                                                                                    <!--<td>${totalgrossAmount}</td>-->
                                                                                    <td style="text-align: right;"><fmt:formatNumber maxFractionDigits="0" value="${totalgrossAmount}"></fmt:formatNumber>.00</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Employee's Contribution</td>
                                                                                        <td style="text-align: center;">Rs.</td>
                                                                                        <!--<td>${totalEmpContrubtionAmount}</td>-->
                                                                                    <td style="text-align: right;"><fmt:formatNumber maxFractionDigits="0" value="${totalEmpContrubtionAmount}"></fmt:formatNumber>.00</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Employer's Contribution</td>
                                                                                        <td style="text-align: center;">Rs.</td>
                                                                                        <!--<td>${totalCompContrubtionAmount}</td>-->
                                                                                    <td style="text-align: right;"><fmt:formatNumber maxFractionDigits="0" value="${totalCompContrubtionAmount}"></fmt:formatNumber>.00</td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td>Total</td>
                                                                                        <td style="text-align: center;">Rs.</td>
                                                                                        <!--<td>${total}</td>-->
                                                                                    <th style="text-align: right;"><fmt:formatNumber maxFractionDigits="0" value="${total}"></fmt:formatNumber>.00</th>
                                                                                    </tr>
                                                                                </table>
                                                                                <br/>
                                                                                <br/>

                                                                            </div>
                                                                        </td>

                                                                    </tr>
                                                                    <tr>
                                                                        <td>
                                                                            <div class="col-md-12 col-sm-12" style="border-right: 1px solid black;border-top: 1px solid black;" >
                                                                                <div>&nbsp;</div>
                                                                                <center><b><font size="2">ACKNOWLEDGEMENT</font></b></center>
                                                                                <center>(For use in Bank)</center>
                                                                                <center>(to be filled by depositer)</center>
                                                                                <div>&nbsp;</div>
                                                                                <table style="width: 100%">
                                                                                    <tr>
                                                                                        <td colspan="3">
                                                                                            Received payment with Cash/Chq/Draft No
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td colspan="3">
                                                                                            Rs. <fmt:formatNumber maxFractionDigits="0" value="${total}"></fmt:formatNumber>.00
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <!--                                                                                        <td colspan="3">
                                                                                                                                                                                    (Rupees SIXTY THREE THOUSAND FIVE HUNDRED THIRTY SIX ONLY)
                                                                                                                                                                                </td>-->
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td style="width: 15%">
                                                                                            drawn on
                                                                                        </td>
                                                                                        <td style="width: 45%">
                                                                                            &nbsp;
                                                                                        </td>
                                                                                        <td style="width: 40%">
                                                                                            (Bank) in favour
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td colspan="3">
                                                                                            of Employees' State Insurance Fund Account No. 1
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td colspan="3">
                                                                                            S1. No. in Bank's Scroll...........................
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td colspan="3" style="height:30px;">
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td style="width: 10%"><p style="font-size: 12px">
                                                                                                Dated :</p>
                                                                                        </td>
                                                                                        <td style="width: 50%">
                                                                                            &nbsp;
                                                                                        </td>
                                                                                        <td style="width: 40%"><p style="font-size: 12px">
                                                                                                Authorised Signatory <br> of the receiving Bank</p>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </td>
                                                                        <td>
                                                                            <div class="col-md-12 col-sm-12" style="border-top: 1px solid black;">
                                                                                <div>&nbsp;</div>
                                                                                <center><b><font size="2">ACKNOWLEDGEMENT</font></b></center>
                                                                                <center>(For use in Bank)</center>
                                                                                <center>(to be filled by depositer)</center>
                                                                                <div>&nbsp;</div>
                                                                                <table style="width: 100%">
                                                                                    <tr>
                                                                                        <td colspan="3">
                                                                                            Received payment with Cash/Chq/Draft No
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td colspan="3">
                                                                                            Rs. <fmt:formatNumber maxFractionDigits="0" value="${total}"></fmt:formatNumber>.00
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <!--                                                                                        <td colspan="3">
                                                                                                                                                                                    (Rupees SIXTY THREE THOUSAND FIVE HUNDRED THIRTY SIX ONLY)
                                                                                                                                                                                </td>-->
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td style="width: 15%">
                                                                                            drawn on
                                                                                        </td>
                                                                                        <td style="width: 45%">
                                                                                            &nbsp;
                                                                                        </td>
                                                                                        <td style="width: 40%">
                                                                                            (Bank) in favour
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td colspan="3">
                                                                                            of Employees' State Insurance Fund Account No. 1
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td colspan="3">
                                                                                            S1. No. in Bank's Scroll...........................
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td colspan="3" style="height:30px;">
                                                                                        </td>
                                                                                    </tr>
                                                                                    <tr>
                                                                                        <td style="width: 10%"><p style="font-size: 12px">
                                                                                                Dated :</p>
                                                                                        </td>
                                                                                        <td style="width: 50%">
                                                                                            &nbsp;
                                                                                        </td>
                                                                                        <td style="width: 40%"><p style="font-size: 12px">
                                                                                                Authorised Signatory <br> of the receiving Bank</p>
                                                                                        </td>
                                                                                    </tr>
                                                                                </table>
                                                                            </div>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            </section>
                                        </div>
                                </c:if>
                            </div>
                        </form:form>
                        <style>
                            .tableBorder{
                                border:1px solid black;text-align: center;
                            }
                        </style>
                        <script type="text/javascript">
                            $('.form_datetime').datetimepicker({
                                //language:  'fr',
                                weekStart: 1,
                                todayBtn: 1,
                                autoclose: 1,
                                todayHighlight: 1,
                                startView: 2,
                                minView: 2,
                                forceParse: 0
                            });
                        </script>
                        <script type="text/javascript">
                            window.onload = init;
                            function init() {
                                document.form1.month.options[new Date().getMonth()].selected = true;
                            }
                            var start = 1990;
                            var end = new Date().getFullYear();
                            var options11 = "";

                            for (var year1 = end; year1 >= start; year1--) {
                                options11 += "<option>" + year1 + "</option>";
                            }
                            document.getElementById('year11').innerHTML = options11;
                        </script>
                        <script type="text/javascript">
                            function printDiv(divName) {
                                var printContents = document.getElementById(divName).innerHTML;
                                var originalContents = document.body.innerHTML;

                                document.body.innerHTML = printContents;

                                window.print();

                                document.body.innerHTML = originalContents;
                            }
                        </script>
                        <script type="text/javascript">
                            function ExportToExcel(tableid) {
                                var htmltable = document.getElementById('tableid');
                                var html = htmltable.outerHTML;
                                window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
                            }
                        </script>
                        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
                        </html>
