<%--
    Document   : Form16Print
    Created on : 5.8.2016 , 5:50:46 PM
    Author     : DELL-3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form 16 Print</title>
        <style>
            /*            table.table-bordered{
                            border:1px solid black;
                        }*/
            table.table-bordered > tbody > tr > th{
                border: 1px solid;
                border-color: #000 !important;
                text-align: center;
                vertical-align: middle;
                font-size:12px;
            }
            table.table-bordered > tbody > tr > td{
                border: 1px solid;
                border-color: #000 !important;
                text-align: center;
                vertical-align: middle;
                font-size:12px;
            }

            page {
                background: white;
                display: block;
                margin: 0 auto;
                margin-bottom: 0.5cm;
                box-shadow: 0 0 0.5cm rgba(0,0,0,0.5);
            }
            page[size="A4"] {  
                width: 21cm;
                height: 29.7cm; 
            }
            page[size="A4"][layout="portrait"] {
                width: 29.7cm;
                height: 21cm;  
            }
            page[size="A3"] {
                width: 29.7cm;
                height: 42cm;
            }
            page[size="A3"][layout="portrait"] {
                width: 42cm;
                height: 29.7cm;  
            }
            page[size="A5"] {
                width: 14.8cm;
                height: 21cm;
            }
            page[size="A5"][layout="portrait"] {
                width: 21cm;
                height: 14.8cm;  
            }
            @media print {
                body, page {
                    margin: 0;
                    box-shadow: 0;
                }
            }
        </style>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Form 16</h1>
            <h3>
                <input type="button" class="btn btn-primary" value="Print" onclick="window.print('printDiv')">
            </h3>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>Home</a></li>
                <li class="active">Form Sixteen Form</li>
            </ol>
        </section>

        <!-- Main content -->
        <div class="row">
            <section class="content">
                <div class="col-sm-10" id="printDiv">
                    <!-- Custom Tabs -->
                    <div class="tab-pane active" id="tab_1">
                        <c:if test="${!empty successMessage}">
                            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                        </c:if>
                        <c:if test="${!empty failureMessage}">
                            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                        </c:if>
                        <table class="table table-bordered table-hover" style="background-color: white">
                            <tbody>
                                <tr>
                                    <td colspan="5">
                                        <b>Form No. 16 </br> [ See rule 31 (1) (a) ] </b>
                                    </td>
                                    <td colspan="5">
                                        Certificate under section 203 of the Income-tax Act, 1961 for tax deducted at source from income </br> chargeable under the head " Salaries "
                                    </td>
                                </tr> 

                                <tr style="background-color:whitesmoke">
                                    <td style="border:none;" colspan="10"></td>
                                </tr>

                                <tr>
                                    <td style="border-right:none;" colspan="6">Name and Address of the Employer</td>
                                    <td colspan="4">Name and Designation of the Employee</td>
                                </tr>
                                <tr>
                                    <td style="border-right:none;" colspan="6">
                                        <b>${employeeMaster.company}</b>
                                    </td>
                                    <td colspan="4">
                                        <b>${employeeMaster.employeeName} </br> ${employeeMaster.designationMaster.designationName}</b>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="border-right:none;" colspan="6"></td>
                                    <td colspan="4">
                                        <b>Form 24 Seq. No.:</b>
                                    </td>
                                </tr>

                                <tr>
                                    <td colspan="10"></td>
                                </tr>   

                                <tr>
                                    <td colspan="3"><b>PAN / GIR No.</b></td>
                                    <td colspan="3"><b>TAN No</b></td>
                                    <td colspan="4"><b>PAN / GIR No.</b></td>
                                </tr>
                                <tr>
                                    <td style="border-right:none;" colspan="3">${payrollFormSixteenMaster.panNo}</td>
                                    <td style="border-right:none;" colspan="3">${payrollFormSixteenMaster.tanNo}</td>
                                    <td colspan="4"><b>${employeeMaster.panCard}</b></td>
                                </tr>

                                <tr style="background-color:whitesmoke">
                                    <td colspan="10"></td>
                                </tr>

                                <tr>
                                    <td colspan="6" rowspan="2">TDS Circle where Annual Return/Statement</br>under Sec.206 is to be filed.</td>
                                    <td colspan="2">Period</td>
                                    <td colspan="2">Assessment</td>
                                </tr>
                                <tr>
                                    <td>From</td>
                                    <td>To</td>
                                    <td colspan="2">Year</td>
                                </tr>
                                <tr>
                                    <td colspan="6">Acknowledgement Nos. of all quarterly statements of TDS under sub-section (3) of section 200 as provided by TIN Facilitation Centre or NSDL web-site</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td colspan="3">Quarter</td>
                                    <td colspan="3">Acknowledgement No</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td colspan="3"><b>Ist</b></td>
                                    <td colspan="3"></td>
                                    <td></td>
                                    <td></td>
                                    <td colspan="2"></td>
                                </tr>
                                <tr>
                                    <td colspan="3"><b>IInd</b></td>
                                    <td colspan="3"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td colspan="3"><b>IIIrd</b></td>
                                    <td colspan="3"></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td colspan="3"><b>IVth</b></td>
                                    <td colspan="3"></td>
                                    <td><b>${payrollFormSixteenMaster.payrollFinancialYear.startDate}</b</td>
                                    <td><b>${payrollFormSixteenMaster.payrollFinancialYear.endDate}</b></td>
                                    <td colspan="2"><b>${payrollFormSixteenMaster.payrollFinancialYear.title}</b></td>
                                </tr>

                                <tr style="background-color:whitesmoke">
                                    <td colspan="10"></td>
                                </tr>

                                <tr>
                                    <td colspan="10">DETAILS OF SALARY PAID AND ANY OTHER INCOME AND TAX DEDUCTED</td>
                                </tr>

                                <tr style="background-color:whitesmoke">
                                    <td colspan="10"></td>
                                </tr>

                                <tr>
                                    <td style="text-align: left;" colspan="7">1 GROSS SALARY</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="7">&emsp;a) Salary as per
                                        provisions contained in sec.17(1)</td>
                                    <td style="text-align:right"> 
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${totallist}"/>
                                    </td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="7">&emsp;b) Value of perquisites
                                        u/s 17(2) <br/>&emsp;&emsp;(as per FormNo.12BA, wherever applicable)</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="7">&emsp;c) Profits in lieu of
                                        salary under section 17(3) <br/>&emsp;&emsp; (as per Form No.12BA,wherever applicable)</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="7">&emsp;d) Total</td>
                                    <td></td>
                                    <td style="text-align: right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${totallist}"/>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="7">
                                        2 LESS : Allowances to the extent exempt under section 10
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="6">&emsp;Allowance</td>
                                    <td>Amount</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="6">&emsp;Conveyance Allowance</td>
                                    <td style="text-align: right;">Rs. 0.00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td colspan="7"></td>
                                    <td style="text-align: right;">Rs. 0.00</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="7">3 BALANCE&nbsp;&nbsp;&nbsp;( 1 - 2 )</td>
                                    <td></td>
                                    <td style="text-align: right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${totallist}"/>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="7">4 DEDUCTION</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td  style="text-align: left" colspan="5">&emsp;(a) Tax on employment</td>
                                    <td  style="text-align: right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${employeeDeductionPtAmountList}"/>
                                    </td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td  style="text-align: left" colspan="5">&emsp;(b) Entertainment Allowance</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="7">5 AGGREGATE OF 4  ( a to b )</td>
                                    <td style="text-align:right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${employeeDeductionPtAmountList}"/>
                                    </td>
                                    <td style="text-align:right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${employeeDeductionPtAmountList}"/>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="7">6 INCOME CHARGEABLE UNDER THE HEAD SALARIES ( 3 - 5)</td>
                                    <td></td>
                                    <td></td>
                                    <td style="text-align:right">.
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${totallist-employeeDeductionPtAmountList}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="7">7 ADD Any other income reported by the employee</td>
                                    <td></td>
                                    <td></td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="7">8 GROSS TOTAL INCOME ( 6 + 7 )</td>
                                    <td></td>
                                    <td></td>
                                    <td style="text-align:right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${totallist-employeeDeductionPtAmountList}"/>
                                    </td>
                                </tr>

                                <tr style="background-color:whitesmoke">
                                    <td colspan="10"></td>
                                </tr>

                                <tr>
                                    <td style="text-align: left;" colspan="7">9 DEDUCTION UNDER CHAPTER VI - A</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="7">(A) Sections 80C, 80CCC and 80D</td>
                                    <td>Gross Amt</td>
                                    <td>Deducti. Amt</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;" colspan="7">&emsp;&nbsp;&nbsp; A. Section 80C</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="7">&emsp;&emsp;&emsp;Provident Fund</td>
                                    <td style="border: 1px solid black;text-align:right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${deductionPfAmount}"/>
                                    </td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <c:forEach var="list" items="${component80CList}" varStatus="status">
                                    <tr>
                                        <td colspan="7" style="text-align:left">&emsp;&emsp;&emsp;${list[0]}</td>
                                        <td style="text-align:right">
                                            Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${list[1]}"/>
                                        </td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td style="text-align: left" colspan="7">&emsp;&nbsp;&nbsp;B. Section 80 CCC</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left;border-bottom:none" colspan="7">&emsp;&nbsp;&nbsp;C. Section 80 D</td>
                                    <td style="text-align:right;border-bottom:none">Rs. 0.00</td>
                                    <td style="border-bottom:none"></td>
                                    <td  style="border-bottom:none"></td>
                                </tr>
                                <tr>
                                    <td colspan="7" style="border-top:none"></td>
                                    <td style="border-top:none"></td>
                                    <td style="border-top:none"></td>
                                    <td style="border-top:none"></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="6">(B) Other Sections (e.g. 80E, 80G etc.) under chapter VI A</td>
                                    <td>Gross Amt</td>
                                    <td>Qualify Amt</td>
                                    <td>Deduct. Amt</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="5">&emsp;&nbsp;&nbsp;(a) Section 80C</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${deductionPfAmount}"/>
                                    </td>
                                    <td style="text-align:right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${deductionPfAmount}"/>
                                    </td>
                                    <td style="text-align:right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${deductionPfAmount}"/>
                                    </td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="5">&emsp;&nbsp;&nbsp;(b) Section 80CCC</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="5">&emsp;&nbsp;&nbsp;(c) Section 80D</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="5">&emsp;&nbsp;&nbsp;(d) Section 80E</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="5">&emsp;&nbsp;&nbsp;(e) Section 80G</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="5">&emsp;&nbsp;&nbsp;(f) Section - Housing Loan Interest</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td style="text-align:right">Rs. 0.00</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="7">10 Aggregate of Deductible amount under Chapter VI - A</td>
                                    <td></td>
                                    <td></td>
                                    <td style="text-align:right">
                                        Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${deductionPfAmount}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: left" colspan="7">11 TOTAL INCOME &nbsp;&nbsp;( 8 - 10 )</td>
                                    <td></td>
                                    <td></td>
                                    <td style="border: 1px solid black;text-align:right">
                                        Rs .<fmt:formatNumber value="${(totallist-employeeDeductionPtAmountList) - deductionPfAmount}"></fmt:formatNumber>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left" colspan="7">12 TAX ON TOTAL INCOME</td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align:right">Rs. 0.00</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left" colspan="7">13 SURCHARGE ( ON TAX COMPUTED AT SR.NO.12)</td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align:right">Rs. 0.00</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left" colspan="7">14 EDUCATION CESS @ 2% ON (TAX AT S. NO. 12 PLUS SURCHARGE AT SR.NO.13)</td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align:right">
                                            <!--12 number value*0.2-->
                                            Rs. 0.00
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left" colspan="7">15 TAX PAYABLE (12+13+14)</td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align:right">Rs. 0.00</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left" colspan="7">16&nbsp; Relief under section 89 (attach details)</td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align:right">Rs. 0.00</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left" colspan="7">17 Tax payable (15-16)</td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align:right">
                                            <!--15 - 16 number value-->
                                            Rs. 0.00
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left" colspan="7">18 Less : (a) Tax
                                            deducted at source u/s 192(1)</td>
                                        <td></td>
                                        <td style="text-align:right">Rs. 0.00</td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left" colspan="7">&emsp;&emsp;&emsp;&emsp;&nbsp; (b) Tax paid by the employer on behalf of the employee u/s 
                                            </br>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;192(1A) on perquisites u/s 17(2)</td>
                                        <td></td>
                                        <td style="text-align:right">Rs. 0.00</td>
                                        <td style="text-align:right">Rs. 0.00</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left" colspan="7">19 TAX PAYABLE /(REFUNDABLE)&nbsp; ( 17 - 18 )</td>
                                        <td></td>
                                        <td></td>
                                        <td style="text-align:right">Rs. 0.00</td>
                                    </tr>

                                    <tr style="background-color:whitesmoke">
                                        <td colspan="10"></td>
                                    </tr>

                                    <tr>
                                        <td colspan="10">
                                            DETAILS OF TAX DEDUCTED AND DEPOSITED INTO CENTRAL GOVERNMENT ACCOUNT
                                        </td>
                                    </tr>

                                    <tr style="background-color:whitesmoke">
                                        <td colspan="10"></td>
                                    </tr>

                                    <tr>
                                        <td style="padding: 3px;">Sr.No.</td>
                                        <td style="padding: 2px;">TDS</td>
                                        <td style="padding: 2px;">Surcharges</td>
                                        <td style="padding: 2px;">Education</br>Cess</td>
                                        <td style="padding: 2px;">Total </br>Tax Deposited</td>
                                        <td style="padding: 2px;">Chq No.</br>/ DD No.</td>
                                        <td style="padding: 2px;">BSR Code </br>of Bank Branch</td>
                                        <td style="padding: 2px;">Date </br>on which </br>tax deposited (DD/MM/YY)</td>
                                        <td colspan="2" style="padding: 2px;">Transfer </br>voucher/Challan </br>Identification No.</td>
                                    </tr>
                                <c:forEach var="list" items="${tdsList}" varStatus="index">
                                    <tr>
                                        <td style="padding: 2px;">${index.count}</td>
                                        <td style="padding: 2px;text-align:right;">Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${list[1]}"/> </td>
                                        <td style="padding: 2px;"></td>
                                        <td style="padding: 2px;"></td>
                                        <td style="text-align:right;padding: 2px;">Rs. <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${list[1]}"/></td>
                                        <td style="padding: 2px;"></td>
                                        <td style="padding: 2px;"></td>
                                        <td style="padding: 2px;"></td>
                                        <td colspan="2" style="padding: 2px;"></td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td style="padding: 2px;"></td>
                                    <td style="padding: 2px;"></td>
                                    <td style="padding: 2px;"></td>
                                    <td style="padding: 2px;"></td>
                                    <td style="text-align:right;padding: 2px;">
                                        Rs .<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${tdsTotal}"/>
                                    </td>
                                    <td style="padding: 2px;"></td>
                                    <td style="padding: 2px;"></td>
                                    <td style="padding: 2px;"></td>
                                    <td style="padding: 2px;" colspan="2"></td>
                                </tr>

                                <tr style="background-color:whitesmoke;">
                                    <td colspan="10"></td>
                                </tr>

                                <tr>
                                    <td style="border: 1px solid black;text-align:justify" colspan="10" >
                                        I &emsp;<b><u>${payrollFormSixteenMaster.ename}</u></b>, &emsp;son/ of &emsp;<b><u>${payrollFormSixteenMaster.fname}</u></b> &emsp; working in the capacity
                                        of &emsp;&emsp;<b><u>${employeeMaster.designationMaster.designationName}</u></b>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: justify;" class="totalWords11" id="totalWords11" colspan="10">
                                        (Designation) do hereby certify that a sum of &emsp;<b> Rs .<b><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${tdsTotal}"/>&emsp;(Rs. Zero only) &emsp;&emsp; has been deducted at source and paid to the credit of the Central Government. 
                                        &emsp;I further certify that the information given above is true and correct based
                                        on the book of accounts, documents and other available records.
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="10" style="border: none;border-left:1px solid black;border-right:1px solid black;padding:10px 8px"></td>
                                </tr>
                                <tr>
                                    <td style="border: none;border-left:1px solid black;" colspan="6" rowspan="3"></td>
                                    <td style="border: none;border-top:2px solid black;border-right:1px solid black;" colspan="4" rowspan="2">Signature of the person responsible for the <br/>deduction of tax.</td>
                                </tr>
                                <tr>
                                </tr>
                                <tr style="border:none;">
                                </tr>
                                <tr>
                                    <td style="border: none;border-left:1px solid black;text-align: left;" colspan="5">Place:&emsp;<b>${payrollFormSixteenMaster.place}</b></td>
                                    <td style="border: none;border-right:1px solid black;text-align: left;" colspan="5">
                                        Full Name: &emsp;&nbsp;&nbsp;<b> ${payrollFormSixteenMaster.ename}</b>
                                    </td>
                                </tr>
                                <tr style="border-bottom:1px solid black">
                                    <td style="border: none;border-left:1px solid black;text-align: left;" colspan="5">Date:&emsp;<b>${payrollFormSixteenMaster.date}</b></td>
                                    <td style="border: none;border-right:1px solid black;text-align: left;" colspan="5">
                                        Designation: &nbsp;&nbsp;<b> ${employeeMaster.designationMaster.designationName}</b>
                                    </td>
                                </tr>
                                <tr style="background-color:whitesmoke">
                                    <td colspan="10"></td>
                                </tr>
                            <input type="hidden" name="totalTemp" id="totalTemp" value="0.00">
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>