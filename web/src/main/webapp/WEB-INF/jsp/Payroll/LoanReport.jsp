<%-- 
    Document   : LoanReport
    Created on : 11 Oct, 2017, 11:53:43 AM
    Author     : Sejal
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <title>Loan Report</title>
    </head>
    <script>

        function saveSubmit11() {
            var flag3 = true;
            if (document.getElementById("month").value == '') {
                document.getElementById("monthError").innerHTML = "- It must be selected.";
                flag3 = false;
            } else {
                document.getElementById("monthError").innerHTML = '';
            }
            if (document.getElementById("loanType").value == '') {
                document.getElementById("loanError").innerHTML = "- It must be selected.";
                flag3 = false;
            } else {
                document.getElementById("loanError").innerHTML = '';
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
            <h1>Loan Detail:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Loan Detail</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" role="form1" action="loanReport.htm?act=onSearchClick" method="post" name='form' onsubmit='return saveSubmit11();'>
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
                                                <div class="col-md-6">
                                                    <label>Employee Name:</label>
                                                    <input type="text" id="employeeMasterId" name="employeeMasterId" class="form-control">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Department:<span style="color: red;font-size: 12px;"></span></label>
                                                    <select name="departmentId" id="departmentId"  class="form-control">
                                                        <option value="" label="" >--Select--</option>
                                                        <c:forEach var="department" items="${deptMap}">
                                                            <option value="${department.key}" label="${department.value}" >${department.value}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Loan Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <select name="loanType" id="loanType"  class="form-control">
                                                        <option value="" label="" >--Select--</option>
                                                        <c:forEach var="loan" items="${loanTypes}">
                                                            <option value="${loan.key}" label="${loan.value}" >${loan.value}</option>
                                                        </c:forEach>
                                                    </select>
                                                    <span id="loanError" style="color: red;"></span>
                                                </div>
                                            </div>
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
        <form:form action="" method="post" commandName="loanReport.htm"
                   name='form2'  class="form-horizontal" role="form">
            <c:if test="${search ne 'none'}">
                <input type="hidden" name="month" value="${month}">
                <input type="hidden" name="year" value="${year}">
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                    <c:choose>
                                        <c:when test="${!empty loanList}"> 
                                            <div class="box-header" style="text-align: right;">
                                                <button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" title="Export To Excel" onclick="ExportToExcel('tableid')"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>
                                                <input type="button" class="btn btn-facebook" style="width: 100px;" value="Print" onclick= "printDiv('printableArea')">
                                            </div>
                                        </c:when>
                                    </c:choose>
                                    <div class="box-body no-padding">
                                        <div id="printableArea">
                                            <c:choose>
                                                <c:when test="${empty loanList}"> 
                                                    <tr>
                                                        <td style="alignment-adjust: central">
                                                            <b><i><c:out value="--   NO RECORD FOUND   --"></c:out></i></b>
                                                            </td>
                                                        </tr>
                                                </c:when>
                                                <c:otherwise>
                                                    <center>  <img src="StorageYard/Images/bulwarks.png" style="width:15%;height: 15%;" BORDER="0"/> </center> 

                                                    <!--                                                    <div class="form-group">
                                                                                                            <center><b><font size="4">CHEMCRUX ENTERPRISES LTD.</font></b></center> 
                                                                                                        </div>-->
                                                    <div class="form-group">
                                                        <header>
                                                            <center><b><font size="4">${loanDatatype[0]} Statement for the month of
                                                                    <c:if test="${month eq 1}">January</c:if>
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
                                                                    <c:if test="${month eq 12}">December</c:if>
                                                                    ${year}
                                                                    </font></b></center> 
                                                        </header>
                                                        <%
                                                            Date date = new Date();
                                                            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                            //                                           out.print( "Date.." + df.format(date));
                                                            out.print("<div align=\"right\">Date:" + df.format(date) + "</div>");
                                                        %>
                                                    </div>
                                                    <div class="row">
                                                        <div class="row">
                                                            <div class="col-md-12 col-sm-12">
                                                                <div class="table table-bordered">


                                                                    <c:forEach var="listOfLoan" items="${loanList[0]}">
                                                                        <c:if test="${fn:length(listOfLoan[1])!=0}"> 
                                                                            <%--<c:out value="${fn:length(listOfLoan[1])==0}"></c:out>--%>

                                                                            <div style="text-align: center;"><b>${listOfLoan[0]}</b></div>
                                                                            <br/>
                                                                            <table id="tableid" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                                                <tr>
                                                                                    <th>Sr.No</th>
                                                                                    <th>Emp Id</th>
                                                                                    <th>Emp Name</th>
                                                                                    <!--<th>Loan Type</th>-->
                                                                                    <th>Op.Balance</th>
                                                                                    <th>Inst.Amt.</th>
                                                                                    <th>Int.Amt.</th>
                                                                                    <th>Total</th>
                                                                                    <th>Cl.Balance</th>
                                                                                </tr>


                                                                                <%--<c:out value="${fn:length(listOfLoan[1])}"></c:out>--%>
                                                                                <c:forEach var="listOfLoanData" items="${listOfLoan[1]}" varStatus="status">

                                                                                    <tr>
                                                                                        <td>${status.count}</td>
                                                                                        <td>${listOfLoanData[0]}</td>
                                                                                        <td>${listOfLoanData[1]}</td>
                                                                                        <!--<td>${listOfLoanData[2]}</td>-->
                                                                                        <td>${listOfLoanData[3]}0</td>
                                                                                        <td>${listOfLoanData[4]}0</td>
                                                                                        <td>${listOfLoanData[5]}0</td>
                                                                                        <td>${listOfLoanData[6]}0</td>
                                                                                        <td>${listOfLoanData[7]}0</td>
                                                                                    </tr>

                                                                                </c:forEach>
                                                                                <%--</c:otherwise>--%>
                                                                                <%--</c:choose>--%>

                                                                            </table>
                                                                            <br/>
                                                                            <br/>


                                                                        </c:if>
                                                                    </c:forEach>
                                                                    <table id="tableid" class="table table-bordered table-striped table-hover" style="" align="Center" >
                                                                        <tr>
                                                                            <th colspan="6" style="text-align: center;">Final Account Total</th>
                                                                        </tr>
                                                                        <tr>
                                                                            <th>Detail</th>
                                                                            <th>Op.Balance</th>
                                                                            <th>Inst.Amt.</th>
                                                                            <th>Int.Amt.</th>
                                                                            <th>Total</th>
                                                                            <th>Cl.Balance</th>
                                                                        </tr>
                                                                        <c:choose>
                                                                            <c:when test="${!empty loanList[0]}">
                                                                                <tr>
                                                                                    <td><b>Total Amount</b></td>
                                                                                    <td>${openBalance}0</td>
                                                                                    <td>${totalInstallmentAmount}0</td>
                                                                                    <td>${totalInterestAmount}0</td>
                                                                                    <td>${totalOfInstAndInterest}0</td>
                                                                                    <td>${totalClearBalance}0</td>

                                                                                </tr>
                                                                            </c:when>
                                                                        </c:choose>
                                                                    </table>

                                                                </div>
                                                            </div> 

                                                        </c:otherwise>
                                                    </c:choose>

                                                </div>  
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
            <script>
                jQuery.noConflict();
                jQuery(document).ready(function () {
                    jQuery("#employeeMasterId").tokenInput(${list}, {
                        preventDuplicates: true, noResultsText: "No Result",
                        tokenLimit: "1",
                        searchingText: "Searching ... .. .",
                    });
                });
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
            <style>
                .class-with-width { width: 150px !important; }
            </style>    
            <script type="text/javascript" src="StorageYard/Plugins/alert/bootbox.min.js"></script>  
            </html>
