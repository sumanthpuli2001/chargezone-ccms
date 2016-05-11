<%-- 
    Document   : returnableNonReturnableGatePass
    Created on : Oct 5, 2015, 11:02:24 AM
    Author     : admin dhaval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script>
        window.print();
    </script>
    <span class="logo-lg"><img src="StorageYard/Images/logo.png" style="width: 160px;float: left;"/></span>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>No Dues Forms:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">No Due Form</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <!--form horizontal starts here-->
                            <form:form action="noDueMaster.htm?act=submitNoDueApproval" method="post" commandName="noDueMaster" name='form1' class="form-horizontal" role="form">
                                <form:input type="hidden" path="id" value="${id}"/>

                                <div class="box-header">
                                    <h3 class="box-title">Employee Detail:</h3>

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Name Of The Employee:</label>
                                                    <input type="Text" class="form-control" value="${employeeMaster.employeeName}" readonly="true">
                                                    <input type="hidden"  name="empId" value="${employeeMaster.id}">
                                                </div>

                                                <div class="col-sm-6">
                                                    <label>Date Of Relieving:</label>
                                                    <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                        <input id="leaveStartDateId" class="form-control" size="16" type="text" value="${employeeMaster.dateOfLeaving}" readonly>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- /.col -->

                                    <!-- /.col -->
                                </div><!-- /.row -->

                                <div class="box-header">
                                    <h3 class="box-title">Concerned Department:</h3>

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >



                                        <tr style="background-color: darkgrey">
                                            <th style="text-align: center" width="50%"><b>Concerned Department</b></th>
                                            <th style="text-align: center" width="25%">Status</th>
                                            <th style="text-align: center" width="25%">Remark</th>

                                        </tr>


                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Equipments / Manuals / Files </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        ${noDueMaster.equipments}
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        ${noDueMaster.equipmentsRemarks}
                                                    </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Special Tools & Gadgets </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        ${noDueMaster.specialTool}
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-12">
                                                        ${noDueMaster.specialToolRemark}
                                                    </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Computer Files & Password /Cupboard Keys</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="computerFiles" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                        ${noDueMaster.computerFilesRemark}
                                                    </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td  style="background-color: lightgrey;vertical-align: middle"><b>Transfer of Advance Amount (please mention name in remarks)</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="advanceAmount" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                        ${noDueMaster.advanceAmountRemark}
                                                    </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle">
                                                <b>Other</b>
                                                ${noDueMaster.deptOtherText}
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="deptOther" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                        ${noDueMaster.deptOtherRemark}
                                                    </div>
                                            </td>

                                        </tr>

                                    </table>

                                    <!-- /.col -->
                                </div><!-- /.row -->

                                <div class="box-header">
                                    <h3 class="box-title">HR / Administration:</h3>

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >



                                        <tr style="background-color: darkgrey">
                                            <th style="text-align: center" width="50%"><b>Concerned Department</b></th>
                                            <th style="text-align: center" width="25%">Status</th>
                                            <th style="text-align: center" width="25%">Remark</th>

                                        </tr>



                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Company provided car </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="carProvided" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                        ${noDueMaster.carProvidedRemark}
                                                    </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Returnable Stationary Items – calculator, punch, stapler, etc.</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="stationaryItem" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                        ${noDueMaster.stationaryItemRemark}
                                                    </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td  style="background-color: lightgrey;vertical-align: middle"><b>Checking  of   company  provided residence and equipments installed inside</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="residance" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                        ${noDueMaster.residanceRemark}
                                                    </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td  style="background-color: lightgrey;vertical-align: middle"><b>Identity Card</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="identityCard" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                        ${noDueMaster.identityCardRemark}    
                                                    </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td  style="background-color: lightgrey;vertical-align: middle"><b>Library</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="library" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                        ${noDueMaster.libraryRemark}    
                                                    </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td  style="background-color: lightgrey;vertical-align: middle"><b>Cafeteria</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="cafeteria" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                        ${noDueMaster.cafeteriaRemark}   
                                                    </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td  style="background-color: lightgrey;vertical-align: middle"><b>Exit Interview</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="exitInterview" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                              ${noDueMaster.exitInterviewReamrk}   
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle">
                                                <b>Other</b>
                                                 ${noDueMaster.hrOtherText}
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="hrOther" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                             ${noDueMaster.hrOtherRemark}
                                                </div>
                                            </td>

                                        </tr>

                                    </table>

                                    <!-- /.col -->
                                </div><!-- /.row -->

                                <div class="box-header">
                                    <h3 class="box-title">I.T Department:</h3>

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >

                                        <tr style="background-color: darkgrey">
                                            <th style="text-align: center" width="50%"><b>Concerned Department</b></th>
                                            <th style="text-align: center" width="25%">Status</th>
                                            <th style="text-align: center" width="25%">Remark</th>
                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Company mobile phone </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="companyMobile" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                             ${noDueMaster.companyMobileRemark}
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Computer Checked / Password / Printer Recovered </b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="computerChecked" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                             ${noDueMaster.computerCheckedRemark}
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Domain Name Changed / Email</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="email" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                             ${noDueMaster.emailRemark}
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Computer Transferred To(please mention name in remarks)</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="computerTransfered" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            ${noDueMaster.computerTransferedRemark}
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle">
                                                <b>Other</b>
                                                <form:textarea path="itOtherText" class="form-control" rows="2" readonly="true"/>
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="itOther" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                             ${noDueMaster.itOtherRemark}
                                                </div>
                                            </td>

                                        </tr>


                                    </table>

                                    <!-- /.col -->
                                </div><!-- /.row -->

                                <div class="box-header">
                                    <h3 class="box-title">Finance Department:</h3>

                                </div><!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <table id="demo" class="table table-bordered table-striped table-hover" style="" align="Center"  >



                                        <tr style="background-color: darkgrey">
                                            <th style="text-align: center" width="50%"><b>Concerned Department</b></th>
                                            <th style="text-align: center" width="25%">Status</th>
                                            <th style="text-align: center" width="25%">Remark</th>

                                        </tr>


                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Advance Cleared</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="advanceCleared" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                            ${noDueMaster.advanceClearedRemark}
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Pending Bills Submitted</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="pendingBills" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                             ${noDueMaster.pendingBillsRemark}
                                                </div>
                                            </td>

                                        </tr>

                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle"><b>Salary Advance / Loans / Earlier Travel Remittance</b></td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="salaryAdvanceOrLoan" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                             ${noDueMaster.salaryAdvanceOrLoanRemark}
                                                </div>
                                            </td>

                                        </tr>
                                        <tr>
                                            <td style="background-color: lightgrey;vertical-align: middle">
                                                <b>Other</b>
                                                 ${noDueMaster.financeOtherText}
                                            </td>
                                            <td>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <form:input path="financeOther" class="form-control" value="" readonly="true" ></form:input>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-12">
                                                             ${noDueMaster.financeOtherRemark}
                                                </div>
                                            </td>

                                        </tr>

                                    </table>

                                    <!-- /.col -->
                                </div><!-- /.row -->
                            </div><!-- /.box-body -->


                        </form:form>
                    </div>



                    <!--form horizontal ends here-->
                    <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                    <!--</div> /.tab-content -->
                </div><!-- nav-tabs-custom -->
            </div><!-- /.col -->
    </div>
</section><!-- /.content -->
</div>


<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

