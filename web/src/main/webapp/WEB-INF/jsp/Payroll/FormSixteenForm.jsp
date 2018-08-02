<%--
    Document   : Form16Print
    Created on : 5.8.2016 , 5:50:46 PM
    Author     : Prem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form 16 Print</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Form 16</h1>
            <h3>
                <input type="button" class="btn btn-primary" value="Print" onclick="window.print('printDiv')">
            </h3>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Form Sixteen Form </li>
            </ol>
        </section>


        <!-- Main content -->
        <section class="content">
            <div class="row" id="printDiv">
               
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
                                <form:form class="form-horizontal" method="post"
                                           action="">


                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="table table-bordered">
                                                    <table id="" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                                        <thead>


                                                        </thead>
                                                        <form>
                                                            <tbody><tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                                    <td style="border: 1px solid black;border-right:none;border-bottom:none" colspan="5" align="center"><b>Form No. 16</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="5" align="center">Certificate under section 203 of the Income-tax Act,</td></tr>
                                                                <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                                    <td style="border: 1px solid black;border-right:none;border-bottom:none" colspan="5" align="center"><b>[ See rule 31 (1) (a) ]</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="5" align="center">1961 for tax deducted at source from income</td>
                                                                </tr>
                                                                <tr height="16" style="mso-height-source:userset;height:12.0pt">
                                                                    <td style="border: 1px solid black;border-right:none" colspan="5">&nbsp;</td>
                                                                    <td style="border: 1px solid black" colspan="5" align="center">chargeable under the head " Salaries "</td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="10"></td>
                                                                </tr>
                                                                <tr height="18" style="mso-height-source:userset;height:13.5pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6">Name and
                                                                        Address of the Employer</td>

                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="4">Name and Designation of the Employee</td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6">
                                                                        <!--employee Station Name-->
                                                                        <b>
                                                                            ${employeeMaster.company}
                                                                        </b>
                                                                    </td><td style="border: 1px solid black;border-bottom:none" colspan="4">
                                                                        <!-- Employee Name-->
                                                                        <b>
                                                                            ${employeeMaster.employeeName} ${employeeMaster.designationMaster.designationName}
                                                                        </b>
                                                                    </td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6"></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="4">
                                                                        <!--employee Designation Type-->
                                                                        <b>
                                                                        </b>
                                                                    </td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6">
                                                                        <!-- Employee Address-->
                                                                    </td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="4"><b>Form 24 Seq. No. :</b></td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="4">&nbsp;</td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="4"><b>PAN / GIR No.</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="2"><b>TAN No</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="4"><b>PAN / GIR No.</b></td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="4"><b> ${employeeMaster.panCard}</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="2"><b>${payrollFormSixteenMaster.tanNo}</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="4"><b> ${employeeMaster.panCard}</b>


                                                                    </td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6" align="center">TDS Circle where Annual Return/Statement</td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="2" align="center">Period</td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="2" align="center">Assessment</td>
                                                                </tr>

                                                                <tr height="19" style="mso-height-source:userset;height:14.25pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6" align="center">under Sec.206 is to be filed.</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">From</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">To</td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="2" align="center">Year</td>
                                                                </tr>

                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6">&nbsp;</td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                </tr>

                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6">&nbsp;</td
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                </tr>

                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="6">&nbsp;</td
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                </tr>
                                                                <tr height="20" style="height:15.0pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3" width="183"><b>Ist</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3" width="215">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none"></td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="2">&nbsp;</td>
                                                                </tr>
                                                                <tr height="20" style="height:15.0pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3" width="183"><b>IInd</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3" width="215">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none"></td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                </tr>
                                                                <tr height="20" style="height:15.0pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3" width="183"><b>IIIrd</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3" width="215">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none"></td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                </tr>
                                                                <tr height="21" style="height:15.75pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3" width="183"><b>IVth</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3">&nbsp;</td>
                                                                    <!--employee Financial Year-->


                                                                    <td style="border: 1px solid black;border-bottom:none" align="right"><b>${payrollFormSixteenMaster.payrollFinancialYear.startDate}</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none"><b>${payrollFormSixteenMaster.payrollFinancialYear.endDate}</b></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="2" align="center"><b>${payrollFormSixteenMaster.payrollFinancialYear.title}</b></td>
                                                                </tr>
                                                                <tr height="11" style="mso-height-source:userset;height:8.25pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="10"></td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="10" align="center">DETAILS OF
                                                                        SALARY PAID AND ANY OTHER INCOME AND TAX DEDUCTED</td>
                                                                </tr>
                                                                <tr height="12" style="mso-height-source:userset;height:9.0pt">
                                                                    <td style="border: 1px solid black" colspan="10"></td>
                                                                </tr>
                                                                <tr height="14" style="mso-height-source:userset;height:10.5pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="10">&nbsp;</td>
                                                                </tr>
                                                                <tr height="18" style="mso-height-source:userset;height:13.5pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="10">1 GROSS SALARY<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">a) Salary as per
                                                                        provisions contained in sec.17(1)<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3">
                                                                        <!--employee Gross Yearly Salary -->
                                                                        Indian Rupee. ${totallist}
                                                                    </td></tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">b) Value of perquisites
                                                                        u/s 17(2) (as per FormNo.12BA, wherever applicable)</td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3">Indian Rupee.0 </td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black" colspan="7">c) Profits in lieu of
                                                                        salary under section 17(3) (as per Form No.12BA,<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                    <td style="border: 1px solid black" colspan="3">Indian Rupee.0 </td>
                                                                </tr>
                                                                <tr height="18" style="mso-height-source:userset;height:13.5pt">
                                                                    <td style="border: 1px solid black" colspan="7"><span style="mso-spacerun:yes">&nbsp;&nbsp;&nbsp;&nbsp; </span>wherever applicable)<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                    <td style="border: 1px solid black" colspan="3"></td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">d) Total<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="3">
                                                                        <!--Total Salary-->
                                                                        ${totallist}
                                                                    </td>
                                                                </tr>
                                                                <tr height="15" style="mso-height-source:userset;height:15.95pt">

                                                                    <td style="border: 1px solid black" colspan="10"></td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="10">2 LESS : Allowances to
                                                                        the extent exempt under section 10</td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black" colspan="5">Allowance</td>
                                                                    <td style="border: 1px solid black" colspan="2">Amount</td>

                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="5">Conveyance Allowance</td>
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="2">Indian Rupee.0 </td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                </tr>
                                                                <tr height="18" style="mso-height-source:userset;height:13.5pt">
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7"></td>
                                                                    <td style="border: 1px solid black;border-bottom:none">Indian Rupee.0 </td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>

                                                                </tr>
                                                                <tr height="19" style="mso-height-source:userset;height:14.25pt">

                                                                    <td style="border: 1px solid black" colspan="7">3 BALANCE<span style="mso-spacerun:yes">&nbsp;&nbsp;&nbsp; </span>( 1 - 2 )</td>

                                                                    <td style="border: 1px solid black">
                                                                        <!--employee Gross Yearly Salary -->
                                                                        ${totallist}
                                                                    </td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black"></td>
                                                                </tr>
                                                                <tr height="16" style="mso-height-source:userset;height:12.0pt">

                                                                    <td style="border: 1px solid black" colspan="7"></td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="19" style="mso-height-source:userset;height:14.25pt">
                                                                    <!--<td style="border: 1px solid black" height=19 class=xl66 style='height:14.25pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">4 DEDUCTION</td>
                                                                    <td style="border: 1px solid black;border-bottom:none"></td>
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none"></td>
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="5"><span style="mso-spacerun:yes"></span>(a) Tax on employment<span style="mso-spacerun:yes"></span></td>
                                                                    <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                    <td style="border: 1px solid black" colspan="2">

                                                                        Indian Rupee.${employeeDeductionPtAmountList[0][1]}

                                                                    </td>
                                                                    <!--<td style="border: 1px solid black"></td>-->
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="5"><span style="mso-spacerun:yes"></span>(b) Entertainment Allowance<span style="mso-spacerun:yes"></span></td>
                                                                    <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="2">Indian Rupee.0 </td>
                                                                    <!--<td style="border: 1px solid black"></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="14" style="mso-height-source:userset;height:10.5pt">
                                                                    <!--<td style="border: 1px solid black" height=14 class=xl66 style='height:10.5pt'></td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7"></td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">5 AGGREGATE OF 4<span style="mso-spacerun:yes">&nbsp; </span>( a to b )</td>
                                                                    <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" class="xl126"> <!--total pt Value-->

                                                                        Indian Rupee.${employeeDeductionPtAmountList[0][1]}

                                                                    </td>
                                                                    <td style="border: 1px solid black;border-bottom:none" class="xl126">
                                                                        <!--total pt Value-->

                                                                        Indian Rupee.${employeeDeductionPtAmountList[0][1]}
                                                                    </td>
                                                                    <td style="border: 1px solid black;border-bottom:none" class="xl127">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="20" style="mso-height-source:userset;height:15.0pt">
                                                                    <!--<td style="border: 1px solid black" height=20 class=xl66 style='height:15.0pt'></td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7"></td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">6 INCOME CHARGEABLE
                                                                        UNDER THE HEAD SALARIES ( 3 - 5)</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none" class="xl126">
                                                                        <!--total chargeableSalary Value-->
                                                                        Indian Rupee.  ${totallist-employeeDeductionPtAmountList[0][1]}
                                                                    </td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="10" style="mso-height-source:userset;height:7.5pt">
                                                                    <!--<td style="border: 1px solid black" height=10 class=xl66 style='height:7.5pt'></td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7"></td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">7 ADD Any other income
                                                                        reported by the employee</td>
                                                                    <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">Indian Rupee.0 </td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="7" style="mso-height-source:userset;height:5.25pt">
                                                                    <!--<td style="border: 1px solid black" height=7 class=xl66 style='height:5.25pt'></td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7"></td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">8 GROSS TOTAL INCOME ( 6
                                                                        + 7 )</td>
                                                                    <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">Indian Rupee.${totallist-employeeDeductionPtAmountList[0][1]}</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="20" style="mso-height-source:userset;height:15.0pt">
                                                                    <!--<td style="border: 1px solid black" height=20 class=xl66 style='height:15.0pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="20" style="mso-height-source:userset;height:15.0pt">
                                                                    <!--<td style="border: 1px solid black" height=20 class=xl66 style='height:15.0pt'></td>-->
                                                                    <td style="border: 1px solid black" colspan="10"></td>
                                                                    <!--<td style="border: 1px solid black" colspan=3 style='mso-ignore:colspan'></td>-->
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="20" style="mso-height-source:userset;height:15.0pt">
                                                                    <!--<td style="border: 1px solid black" height=20 class=xl66 style='height:15.0pt'></td>-->
                                                                    <td style="border: 1px solid black" colspan="7">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <td style="border: 1px solid black">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">9 DEDUCTION UNDER
                                                                        CHAPTER VI - A</td>
                                                                    <!--<td style="border: 1px solid black" style='border-top:none'>&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black" style='border-top:none'>&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black" style='border-top:none'>&nbsp;</td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--                                <td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="10"></td>
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black" style='border-left:none'>&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="7">(A) Sections 80C, 80CCC
                                                                        and 80D</td>
                                                                    <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none">Gross Amt</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">Deducti. Amt</td>
                                                                    <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                                <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                    <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                    <td style="border: 1px solid black;border-bottom:none" colspan="10"><span style="mso-spacerun:yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>A. Section 80C</td>
                                                                    <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                    <!--<td style="border: 1px solid black"></td>-->
                                                                    <!--<td style="border: 1px solid black"></td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black" style='border-left:none'>&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                    <!--<td style="border: 1px solid black" ></td>-->
                                                                </tr>
                                                            <tbody>
                                                                <tr>
                                                                    <td style="border: 1px solid black">1<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                    <td style="border: 1px solid black" colspan="6">${employeeDeductionAmountList[0][0]}</td>
                                                                    <td style="border: 1px solid black" class="xl126" colspan="3">Indian Rupee:${employeeDeductionAmountList[0][1]}</td>
                                                                </tr>
                                                            </tbody>     
                                                            </td>
                                                            <!--<td style="border: 1px solid black" style='border-left:none'>&nbsp;</td>-->
                                                            <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                            <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tbody>
                                                                <c:forEach var="list" items="${payrollSavingAmountList}" varStatus="status">
                                                                    <tr>
                                                                        <td style="border: 1px solid black">${status.count+1}<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                        <td style="border: 1px solid black" colspan="6">${list[0]}</td>
                                                                        <td style="border: 1px solid black" class="xl126" colspan="3">Indian Rupee:${list[1]}</td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>     
                                                            </td>
                                                            <!--<td style="border: 1px solid black" style='border-left:none'>&nbsp;</td>-->
                                                            <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                            <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black;border-bottom:none" colspan="7">B. Section 80 CCC</td>
                                                                <!--<td style="border: 1px solid black" colspan=3 style='mso-ignore:colspan'></td>-->
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <td style="border: 1px solid black;border-bottom:none" colspan="3">Indian Rupee.0.0</td>
                                                                <!--<td style="border: 1px solid black" style='border-left:none'>&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black;border-bottom:none" colspan="7">C. Section 80 D</td>
                                                                <!--<td style="border: 1px solid black" colspan=3 style='mso-ignore:colspan'></td>-->
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <td style="border: 1px solid black;border-bottom:none" colspan="3">Indian Rupee.0 </td>
                                                                <!--<td style="border: 1px solid black" style='border-left:none'>&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black;border-bottom:none" colspan="10"></td>
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black" style='border-left:none'>&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black;border-bottom:none" colspan="10">(B) Other Sections (e.g.
                                                                    80E, 80G etc.) under chapter VI A</td>
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black" style='border-left:none'>&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black;border-bottom:none" colspan="6"></td>
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <td style="border: 1px solid black;border-bottom:none">Gross Amt</td>
                                                                <td style="border: 1px solid black;border-bottom:none">Qualify Amt</td>
                                                                <td style="border: 1px solid black;border-bottom:none">Deduct. Amt</td>
                                                                <td style="border: 1px solid black;border-bottom:none">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black">(a)<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                <td style="border: 1px solid black" colspan="4">Section 80C</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">  Indian Rupee.0</td>
                                                                <td style="border: 1px solid black" align="right">


                                                                    ${totalSavinglist+employeeDeductionAmountList[0][1]}
                                                                </td>
                                                                <td style="border: 1px solid black" class="xl126">Indian Rupee.${totalSavinglist+employeeDeductionAmountList[0][1]}</td>
                                                                <td style="border: 1px solid black" class="xl126">Indian Rupee.${totalSavinglist+employeeDeductionAmountList[0][1]}</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black">(b)<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                <td style="border: 1px solid black" colspan="4">Section 80CCC</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black" align="right">0.00</td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black">(c)<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                <td style="border: 1px solid black" colspan="4">Section 80D</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black" align="right">0.00</td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black">(d)<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                <td style="border: 1px solid black" colspan="4">Section 80E</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black" align="right">0.00</td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black">(e)</td>
                                                                <td style="border: 1px solid black" colspan="4">Section 80G</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black" align="right">0.00</td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black">(f)</td>
                                                                <td style="border: 1px solid black" colspan="4">Section - Housing Loan
                                                                    Interest</td>
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black" align="right">0.00</td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">Indian Rupee.0</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="7"></td>
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">10 Aggregate of
                                                                    Deductible amount under Chapter VI - A</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" class="xl126">


                                                                    Indian Rupee. ${totalSavinglist+employeeDeductionAmountList[0][1]}
                                                                </td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="7"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">11 TOTAL INCOME<span style="mso-spacerun:yes">&nbsp;&nbsp; </span>( 8 - 10 )</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    Indian Rupee.
                                                                      <fmt:formatNumber value="${(totallist-employeeDeductionPtAmountList[0][1]) - (totalSavinglist+employeeDeductionAmountList[0][1])}"></fmt:formatNumber>
                                                                </td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black" >&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="7" class="xl147"></td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">12 TAX ON TOTAL INCOME</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" class="xl125">
                                                                    Indian Rupee.0.00

                                                                </td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="7"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">13 SURCHARGE ( ON TAX
                                                                    COMPUTED AT SR.NO.12)</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" align="right">0.00</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="7"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">14 EDUCATION CESS @ 2%
                                                                    ON (TAX AT S. NO. 12 PLUS SURCHARGE AT S.</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" align="right">0.00</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">NO.13)</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="7"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black;" colspan="7">15 TAX PAYABLE
                                                                    (12+13+14)</td>
                                                                <!--                                <td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" align="right">
                                                                    Indian Rupee.0.00
                                                                </td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7"></td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black"></td>
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">16<span style="mso-spacerun:yes">&nbsp; </span>Relief under section 89 (attach details)</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="7"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black;border-bottom:none" colspan="7">17 Tax payable (15-16)</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" class="xl126">
                                                                    Indian Rupee.0.00
                                                                </td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="7"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">18 Less : (a) Tax
                                                                    deducted at source u/s 192(1)</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7"><span style="mso-spacerun:yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>(b) Tax paid by the
                                                                    employer on behalf of the employee u/s 192(1A) on</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7"><span style="mso-spacerun:yes">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span>perquisites u/s 17(2)</td>
                                                                <!--<td style="border: 1px solid black" class=xl154 style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <td style="border: 1px solid black">Indian Rupee.0 </td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="7"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">19 TAX PAYABLE /
                                                                    (REFUNDABLE)<span style="mso-spacerun:yes">&nbsp; </span>( 17 - 18 )</td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" class="xl126">
                                                                    Indian Rupee.0.00
                                                                </td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="7">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="10"></td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="10" align="center">DETAILS OF
                                                                    TAX DEDUCTED AND DEPOSITED INTO CENTRAL GOVERNMENT ACCOUNT</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="39" style="mso-height-source:userset;height:29.25pt">
                                                                <!--<td style="border: 1px solid black" height=39 class=xl66 style='height:29.25pt'></td>-->
                                                                <td style="border: 1px solid black" rowspan="2" width="41">Sr.No.</td>
                                                                <td style="border: 1px solid black" rowspan="2" width="90">TDS</td>
                                                                <td style="border: 1px solid black" rowspan="2" width="52">Surcharges</td>
                                                                <td style="border: 1px solid black" rowspan="2" width="67">Education Cess</td>
                                                                <td style="border: 1px solid black" rowspan="2" width="68">Total Tax Deposited</td>
                                                                <td style="border: 1px solid black" rowspan="2" width="80">Chq No./ DD No.</td>
                                                                <td style="border: 1px solid black" rowspan="2" width="80">BSR Code of Bank Branch</td>
                                                                <td style="border: 1px solid black" rowspan="2" width="77">Date on which tax deposited (DD/MM/YY)</td>
                                                                <td style="border: 1px solid black" colspan="2" rowspan="2" width="161">Transfer voucher/Challan
                                                                    Identification No.</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="54" style="mso-height-source:userset;height:40.5pt">
                                                                <!--<td style="border: 1px solid black" height=54 class=xl66 style='height:40.5pt'></td>-->
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>





                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  1</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  2</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  3</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  4</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  5</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  6</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  7</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  8</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  9</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  10</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  11</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <td style="border: 1px solid black">  12</td>
                                                                <td style="border: 1px solid black"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    0.0


                                                                </td>

                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>




                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">
                                                                    Indian Rupee.<br>0.00
                                                                </td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="2">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="0" style="display:none;mso-height-source:userset;mso-height-alt:
                                                                319">
                                                                <!--<td style="border: 1px solid black" height=0 class=xl66></td>-->
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <td style="border: 1px solid black" colspan="3"></td>
                                                                <td style="border: 1px solid black" align="right">0.00</td>
                                                                <td style="border: 1px solid black" colspan="4"></td>
                                                                <td style="border: 1px solid black">&nbsp;</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="10"></td>
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="10">I &nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
                                                                    <b> ${payrollFormSixteenMaster.ename}</b>
                                                                    &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; , son/ of &nbsp;&nbsp;&nbsp; <b> ${payrollFormSixteenMaster.fname}</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;working in the capacity
                                                                    of &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<b> ${employeeMaster.designationMaster.designationName}</b></td>
                                                                <!--                                <td style="border: 1px solid black" colspan=3>-->
                                                                <!-- Employee Name-->


                                                                <!--<td style="border: 1px solid black">, son/ of</td>-->
                                                                <!--                                <td style="border: 1px solid black" colspan=2 >


                                                            </td>-->
                                                                <!--                                <td style="border: 1px solid black" colspan=2 style='mso-ignore:colspan'>working in the capacity
                                                                                                    of</td>-->
                                                                <!--<td style="border: 1px solid black" class=xl127>PARTNER</td>-->
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <input type="hidden" name="totalTemp" id="totalTemp" value="0.00">
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" class="totalWords11" id="totalWords11" colspan="10">(Designation) do hereby
                                                                    certify that a sum of &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<span style="display:none">Indian Rupee.</span>&nbsp; &nbsp;&nbsp;&nbsp;<b> Indian Rupee.</b><b>0.00</b> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;(Indian Rupee.<span></span>)</td>

                                                                <!--                                 <td style="border: 1px solid black" class="totalWords11" id="totalWords11" colspan="5"style='mso-ignore:colspan;border-right:1.0pt solid black'>
                                                                                               </td>-->

                                                            </tr>
                                                            <!--                            <tr height=21 style='mso-height-source:userset;height:15.95pt'>
                                                                                            <td height=21 class=xl66 style='height:15.95pt'></td>
                                                                                            <td class=xl128 colspan=4 style='mso-ignore:colspan'>(Designation) do hereby
                                                                                                certify that<span style='mso-spacerun:yes'>&nbsp; </span>a sum of <span
                                                                                                    style='display:none'>Indian Rupee.</span></td>
                                                                                            <td class=xl176 align=right>
                                                            Indian Rupee.<br>0.00


                                                        </td>
                                                    <input hidden="hidden" name="totalTemp" id="totalTemp" value="0.00"/>
                                                            <td class="totalWords11" colspan=5 id="totalWords11" style='mso-ignore:colspan;border-right:1.0pt solid black'>
                                                            Indian Rupee.(<span></span>)</td>
                                                        <td class=xl67></td>
                                                        </tr>-->
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl177 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="10">has
                                                                    been deducted at source and paid to the credit of the Central Government. I
                                                                    further certify that the information given above is<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl177 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black" colspan="10">true and correct baseed
                                                                    on the book of accounts, documents and other available records</td>
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                                <!--<td style="border: 1px solid black" >&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl177 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="10"></td>
                                                                <!--<td style="border: 1px solid black" >&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black"></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:25.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="10"></td>
                                                                <!--<td style="border: 1px solid black" style='mso-ignore:colspan'></td>-->
                                                                <!--<td style="border: 1px solid black" >&nbsp;</td>-->
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>

                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="6"></td>
                                                                <td style="border: 1px solid black" colspan="4" align="center">Signature of the person responsible for the</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <!--<td style="border: 1px solid black">&nbsp;</td>-->
                                                                <td style="border: 1px solid black" colspan="6"></td>
                                                                <td style="border: 1px solid black" colspan="4" align="center">deduction of tax.</td>
                                                                <!--<td style="border: 1px solid black" ></td>-->
                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">
                                                                <!--<td style="border: 1px solid black" height=21 class=xl66 style='height:15.95pt'></td>-->
                                                                <td style="border: 1px solid black">Place :</td>
                                                                <td style="border: 1px solid black">
                                                                    <b>
                                                                        ${payrollFormSixteenMaster.place}
                                                                    </b>
                                                                </td>
                                                                <td style="border: 1px solid black" colspan="3"></td>
                                                                <td style="border: 1px solid black">Full Name :</td>
                                                                <td style="border: 1px solid black" colspan="4">
                                                                    <!-- Employee Name-->
                                                                    <b>
                                                                        ${payrollFormSixteenMaster.ename} ${payrollFormSixteenMaster.fname}
                                                                    </b>
                                                                </td>

                                                            </tr>
                                                            <tr height="21" style="mso-height-source:userset;height:15.95pt">

                                                                <td style="border: 1px solid black">Date :<span style="mso-spacerun:yes">&nbsp;</span></td>
                                                                <td style="border: 1px solid black"><b> ${payrollFormSixteenMaster.date}</b></td>
                                                                <td style="border: 1px solid black" colspan="3"></td>
                                                                <td style="border: 1px solid black">Designation :</td>
                                                                <td style="border: 1px solid black" colspan="4">
                                                                    <!--employee Designation Type-->
                                                                    <b> ${employeeMaster.designationMaster.designationName}</b>
                                                                    <span style="mso-spacerun:yes">&nbsp;</span></td>

                                                            </tr>
                                                            </tbody>
                                                        </form>
                                                    </table>


                                                </div>


                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->

                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <!--<form>
        <input type="button" value="Print" onclick="window.print()">
    </form> ------>
     <%--<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>--%>
</html>

