<%--
    Document   : PayrollProfessionalTaxView
    Created on : Jul 13, 2016, 4:24:25 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Saving Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Employee Saving : </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">create</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
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
                                <form:form action="payrollSavingAmount.htm?act=createSubmit" method="post" 
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    
                                        <div class="box-body no-padding">
                                            
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12" style="font-size: 16px; margin: 10px 0px 20px 0px;">
                                           
                                          
                                                 <b>Employee Name : </b>
                                                 <span>${employeeMaster.employeeName}</span>
                                            <input type="hidden" name="employeeId" value="${employeeMaster.id}">
                                            
                                           &nbsp;&nbsp;&nbsp;
                                             <b> Year : </b>
                                             <span>${payrollFormSixteenMaster.payrollFinancialYear.title}</span> 
                                           <input type="hidden" name="yearId" value="${payrollFormSixteenMaster.id}">  
                                           
                                            </div>
                                            </div>
                                            <div class="table table-bordered">
                                                <table id="" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <thead>
                                                        <tr>
                                                        <th>Sr. No.</th>
                                                        <th>Saving Type</th>
                                                        <th>Amount</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <input type="hidden" name="savingTypeCount" value="15">
                                                        
                                                        <tr>
                                                            <td>1.</td>
                                                            <td><input type="hidden" name="savingType1" value="V.P.F.">V.P.F.</td>
                                                            <td><input type="text" name="savingTypeAmount1" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>2.</td>
                                                            <td><input type="hidden" name="savingType2" value="LIC - SSS">LIC - SSS</td>
                                                            <td><input type="text" name="savingTypeAmount2" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>3.</td>
                                                            <td><input type="hidden" name="savingType3" value="LIC - DIRECT">LIC - DIRECT</td>
                                                            <td><input type="text" name="savingTypeAmount3" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>4.</td>
                                                            <td><input type="hidden" name="savingType4" value="P.P.F.">P.P.F.</td>
                                                            <td><input type="text" name="savingTypeAmount4" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>5.</td>
                                                            <td><input type="hidden" name="savingType5" value="ULIP">ULIP</td>
                                                            <td><input type="text" name="savingTypeAmount5" value="0.0" class="form-control"></td>
                                                        </tr>
                                                    <tr>
                                                            <td>6.</td>
                                                            <td><input type="hidden" name="savingType6" value="NSC">NSC</td>
                                                            <td><input type="text" name="savingTypeAmount6" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>7.</td>
                                                            <td><input type="hidden" name="savingType7" value="NSC Interest">NSC Interest</td>
                                                            <td><input type="text" name="savingTypeAmount7" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>8.</td>
                                                            <td><input type="hidden" name="savingType8" value="Housing Loan">Housing Loan</td>
                                                            <td><input type="text" name="savingTypeAmount8" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>9.</td>
                                                            <td><input type="hidden" name="savingType9" value="Home Loan">Home Loan</td>
                                                            <td><input type="text" name="savingTypeAmount9" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>10.</td>
                                                            <td><input type="hidden" name="savingType10" value="ELSS">ELSS</td>
                                                            <td><input type="text" name="savingTypeAmount10" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>11.</td>
                                                            <td><input type="hidden" name="savingType11" value="PLI">PLI</td>
                                                            <td><input type="text" name="savingTypeAmount11" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>12.</td>
                                                            <td><input type="hidden" name="savingType12" value="Others">Others</td>
                                                            <td><input type="text" name="savingTypeAmount12" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>13.</td>
                                                            <td><input type="hidden" name="savingType13" value="Education Expenses">Education Expenses</td>
                                                            <td><input type="text" name="savingTypeAmount13" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>14.</td>
                                                            <td><input type="hidden" name="savingType14" value="Infrastructure Investment">Infrastructure Investment</td>
                                                            <td><input type="text" name="savingTypeAmount14" value="0.0" class="form-control"></td>
                                                        </tr>
                                                        <tr>
                                                            <td>15.</td>
                                                            <td><input type="hidden" name="savingType15" value="Bank Deposit">Bank Deposit</td>
                                                            <td><input type="text" name="savingTypeAmount15" value="0.0" class="form-control"></td>
                                                        </tr>
                                                    
                                                    </tbody>
                                                </table>
                                            </div>
                                            <c:if test="${!empty employeelist}">
                                               
                                            </c:if>

                                        </div><!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                         
                                       
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                            </div>

                                        </div>
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>