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
                        <!--<table id="" class="table  table-striped" style=""  >-->
                        <!--                            <thead>
                                                        <tr>
                                                    <img src="StorageYard/Images/EPFO-Logo.jpg" style="width:8%;height: 8%;" BORDER="0"/> 
                                                    <td style="border-bottom:none" colspan="10" align="center"><b>COMBINED CHALLEN OF A/C NO.01,02,10,21 & 22(With ECR)</b></td>
                        
                                                    </tr>
                                                    <tr>
                                                        <td style="border-bottom:none" colspan="10"  align="center"><b> <ins>EMPLOYEES'PROVIDENT FUND ORGANISATION</ins></b>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td align="right"><b>TRRN:</b>1871709001589
                                                        </td>
                                                    </tr>
                                                    </thead>
                                                </table>-->
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

                                    <table id="" class="table  table-striped" style=""  >
                                        <thead>
                                        <tbody>
                                            <tr>
                                        <img src="StorageYard/Images/EPFO-Logo.jpg" style="width:8%;height: 8%;" BORDER="0"/> 
                                        <td style="border-bottom:none" colspan="10" align="center"><b>COMBINED CHALLEN OF A/C NO.01,02,10,21 & 22(With ECR)</b></td>

                                        </tr>
                                        <tr>
                                            <td style="border-bottom:none" colspan="10"  align="center"><b> <ins>EMPLOYEES'PROVIDENT FUND ORGANISATION</ins></b>
                                            </td>
                                        </tr>
                                        <!--                                        <tr>
                                                                                    <td align="right"><b>TRRN:</b>1871709001589
                                                                                    </td>
                                                                                </tr>-->
                                        <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                            <td style="border-right:none;border-bottom:none" colspan="5" align="left">Establishment Code & Name: SRBRH00181800 Chemcrux Enterprises ltd</td>
                                            <td style="border-bottom:none" colspan="5" align="right">Dues for the Wage month of: August 2017</td></tr>
                                        <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                            <td style=border-right:none;border-bottom:none" colspan="5" align="left">Address : 4713,GIDC Road South10,Ankleshwar,Ankleshwar Bharuch,gujarat</td>
                                            <!--<td style="border-bottom:none" colspan="5" align="center">1961 for tax deducted at source from income</td>-->
                                        </tr>
                                        <tr colspan="10">
                                            <td colspan="2"></td>
                                            <td colspan="2"></td>
                                            <td colspan="2" >EPF</td>
                                            <td colspan="2">EPS</td>
                                            <td colspan="2" >EDLI</td>
                                        </tr>
                                        <tr colspan="10">
                                            <td colspan="2" >Total Subscribers:</td>
                                            <td colspan="2"></td>
                                            <td  colspan="2" >54</td>
                                            <td  colspan="2">54</td>
                                            <td colspan="2" >54</td> 
                                        </tr>
                                        <tr colspan="10">
                                            <td colspan="2" >Total Wages:</td>
                                            <td colspan="2"></td>
                                            <td  colspan="2" >9,36,379</td>
                                            <td  colspan="2">7,36,379</td>
                                            <td colspan="2" >7,36,379</td> 
                                        </tr>


                                        <!--<td style="border-bottom:none" colspan="5" align="right">Dues for the Wage month of: August 2017</td></tr>-->
                                        </tbody>

                                    </table>

                                    <table class="table table-bordered table-striped table-hover " >
                                        <tr>
                                            <th>SL</th>
                                            <th>PARTICULARS</th>
                                            <th>A/C.01(Rs.)</th>
                                            <th>A/C.02(Rs.)</th>
                                            <th>A/C.10(Rs.)</th>
                                            <th>A/C.21(Rs.)</th>
                                            <th>A/C.22(Rs.)</th>
                                            <th>TOTAL</th>
                                        </tr>
                                        <tr>
                                            <td>1</td>
                                            <td>Administration Charges</td>
                                            <td>0</td>
                                            <td>6859</td>
                                            <td>0</td>
                                            <td>0</td>
                                            <td>0</td>
                                            <td>6859</td>
                                        </tr>
                                        <tr>
                                            <td>2</td>
                                            <td>Employer's Share of Contribution</td>
                                            <td>51510</td>
                                            <td>0</td>
                                            <td>60856</td>
                                            <td>0</td>
                                            <td>0</td>
                                            <td>112356</td>
                                        </tr>
                                        <tr>
                                            <td>3</td>
                                            <td>Employee's Share of Contribution</td>
                                            <td>112366</td>
                                            <td>0</td>
                                            <td>0</td>
                                            <td>0</td>
                                            <td>0</td>
                                            <td>112366</td>
                                        </tr>
                                        <tr>
                                            <td>Grand Total:</td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                            <td>230616</td>
                                        </tr>

                                    </table>

                                    <table class="table  table-striped"  >
                                        <thead>
                                        <tbody>
                                            
                                            <tr>

                                                <td style="border-bottom:none" colspan="10" align="center"><b>(Only for offline payment in case permitted by EPFO)</b></td>

                                            </tr>

                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left"><b>FOR BANK USE ONLY</b></td>
                                                <td style="border-bottom:none" colspan="5" align="right"><b>FOR ESTABLISHMENT USE ONLY</b> (To be Manually filled by Employer)</td></tr>
                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style=border-right:none;border-bottom:none" colspan="5" align="left">Amount Received Rs._________________</td>
                                                <td style="border-bottom:none" colspan="5" align="right">Cheque/DD No.________________________Date:_______________</td></tr>
                                            </tr>
                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style=border-right:none;border-bottom:none" colspan="5" align="left">Date of presentation of cheque/DD_________________</td>
                                                <td style="border-bottom:none" colspan="5" align="right">Cheque/DD drawn bank & &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style=border-right:none;border-bottom:none" colspan="5" align="left">Date of Realisation of cheque/DD_________________</td>
                                                <td style="border-bottom:none" colspan="5" align="right">Name of the Depositer _____________________________________</td></tr>
                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style=border-right:none;border-bottom:none" colspan="5" align="left">SBI Branch Name_________________</td>
                                                <td style="border-bottom:none" colspan="5" align="right">Date of Deposit___________________Moblie No:_______________</td></tr>
                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style=border-right:none;border-bottom:none" colspan="5" align="left">SBI Branch Code_________________</td>
                                                <td style="border-bottom:none" colspan="5" align="right">Signature of the __________________________________________</td></tr>
                                            <tr>

                                                <td style="border-bottom:none" colspan="10" align="center">(This is a system generated challen on 11-SEP-2017 13:47, the particulars shown in this challan are populated from the Electronic Challan Cum Return(ECR) uploaded by the establishment for the specified month and year)</td>

                                            </tr>

                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">Note:- The Following amounts are being remitted directly by Government of india of PMRPY and PMPRPY.</b></td></tr>
                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">A)A/C no 1(Employer Share)(Rs.)-</td>
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">0</td>

                                            </tr>
                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">B)A/C no 10(Pension fund)(Rs.)-</td>
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">0</td>
                                            </tr>

                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">C)Total(A+B)(Rs.)-</td>
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">0</td>

                                            </tr>
                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">D)Total remittance by Employer(Rs.)-</td>
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">230818</td>
                                            </tr>
                                            <tr height="17" style="mso-height-source:userset;height:12.75pt">
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">E)Total amount of uploaded ECR(C+D)(Rs.)-</td>
                                                <td style="border-right:none;border-bottom:none" colspan="5" align="left">230818</td>
                                            </tr>

                                    </table>

                                </div>




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
</html>

