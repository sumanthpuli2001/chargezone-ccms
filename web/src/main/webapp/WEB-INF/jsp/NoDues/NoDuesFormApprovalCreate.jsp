<%-- 
    Document   : returnableNonReturnableGatePass
    Created on : Oct 5, 2015, 11:02:24 AM
    Author     : admin dhaval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <script>
        function buttonFun1() {
            var className = $('#minusId1').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId1').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId1').innerHTML = 'Expand';
            }
        }
        function buttonFun2() {
            var className = $('#minusId2').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId2').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId2').innerHTML = 'Expand';
            }
        }
        function buttonFun3() {
            var className = $('#minusId3').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId3').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId3').innerHTML = 'Expand';
            }
        }
        function buttonFun4() {
            var className = $('#minusId4').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId4').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId4').innerHTML = 'Expand';
            }
        }
        function buttonFun5() {
            var className = $('#minusId5').attr('class');
            if (className == 'fa fa-plus') {
                document.getElementById('spanId5').innerHTML = 'Minimize';
            } else {
                document.getElementById('spanId5').innerHTML = 'Expand';
            }
        }

    </script>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>No Dues Forms:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">No Due Form</li>
            </ol>
            <div class="col-md-12" style="text-align: center;">
                <!--<input type="button" value="Print" id="printBtn" name="printBtn" style="margin-left: 959px; width: 100px;" class="btn btn-primary" onclick="appraisalSelectedPrint()">-->
                <a href="noDueMaster.htm?act=printClick&id=${id}&empId=${empId}" target="_blank"  class="btn btn-primary">Print</a>
                <input type="hidden" id="empId" name="empId" value="${empId}">
                <input type="hidden" id="id" name="id" value="${id}">
            </div>
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
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Employee Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId1">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun1();"><i class="fa fa-plus" id="minusId1" ></i></button>
                                        </div>
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
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- /.col -->

                                        <!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Concerned Department:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                        </div>
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
                                                            <form:input path="equipments" class="form-control" value="" readonly="true" ></form:input>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="equipmentsRemarks" class="form-control" rows="2" readonly="true"/>                                               </div>
                                                    </div>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td style="background-color: lightgrey;vertical-align: middle"><b>Special Tools & Gadgets </b></td>
                                                <td>
                                                    <div class="form-group">
                                                        <div class="col-sm-10">
                                                            <form:input path="specialTool" class="form-control" value="" readonly="true" ></form:input>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                            <form:textarea path="specialToolRemark" class="form-control" rows="2" readonly="true"/>                                                   </div>
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
                                                            <form:textarea path="computerFilesRemark" class="form-control" rows="2" readonly="true"/>                                                   </div>
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
                                                            <form:textarea path="advanceAmountRemark" class="form-control" rows="2" readonly="true"/>                                                   </div>
                                                    </div>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td style="background-color: lightgrey;vertical-align: middle">
                                                    <b>Other</b>
                                                    <form:textarea path="deptOtherText" class="form-control" rows="2" readonly="true"/>
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
                                                            <form:textarea path="deptOtherRemark" class="form-control" rows="2" readonly="true"/>                                                   </div>
                                                    </div>
                                                </td>

                                            </tr>

                                        </table>

                                        <!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">HR / Administration:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                        </div>
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
                                                            <form:textarea path="carProvidedRemark" class="form-control" rows="2" readonly="true"/>                                                  </div>
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
                                                            <form:textarea path="stationaryItemRemark" class="form-control" rows="2" readonly="true"/>                                                   </div>
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
                                                            <form:textarea path="residanceRemark" class="form-control" rows="2" readonly="true"/>                                                   </div>
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
                                                            <form:textarea path="identityCardRemark" class="form-control" rows="2" readonly="true"/>                                                    </div>
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
                                                            <form:textarea path="libraryRemark" class="form-control" rows="2" readonly="true"/>                                                    </div>
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
                                                            <form:textarea path="cafeteriaRemark" class="form-control" rows="2" readonly="true"/>                                                    </div>
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
                                                            <form:textarea path="exitInterviewReamrk" class="form-control" rows="2" readonly="true"/>                                                    </div>
                                                    </div>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td style="background-color: lightgrey;vertical-align: middle">
                                                    <b>Other</b>
                                                    <form:textarea path="hrOtherText" class="form-control" rows="2" readonly="true"/>
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
                                                            <form:textarea path="hrOtherRemark" class="form-control" rows="2" readonly="true"/>                                                    </div>
                                                    </div>
                                                </td>

                                            </tr>

                                        </table>

                                        <!-- /.col -->
                                    </div><!-- /.row -->
                                </div>
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">I.T Department:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                        </div>
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
                                                            <form:textarea path="companyMobileRemark" class="form-control" rows="2" readonly="true"/>                                                    </div>
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
                                                            <form:textarea path="computerCheckedRemark" class="form-control" rows="2" readonly="true"/>                                                    </div>
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
                                                            <form:textarea path="emailRemark" class="form-control" rows="2" readonly="true"/>                                                   </div>
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
                                                            <form:textarea path="computerTransferedRemark" class="form-control" rows="2" readonly="true"/>                                                  </div>
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
                                                            <form:textarea path="itOtherRemark" class="form-control" rows="2" readonly="true"/>                                                    </div>
                                                    </div>
                                                </td>

                                            </tr>


                                        </table>

                                        <!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Finance Department:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                        </div>
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
                                                            <form:textarea path="advanceClearedRemark" class="form-control" rows="2" readonly="true"/>                                                    </div>
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
                                                            <form:textarea path="pendingBillsRemark" class="form-control" rows="2" readonly="true"/>                                                   </div>
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
                                                            <form:textarea path="salaryAdvanceOrLoanRemark" class="form-control" rows="2" readonly="true"/>                                                   </div>
                                                    </div>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td style="background-color: lightgrey;vertical-align: middle">
                                                    <b>Other</b>
                                                    <form:textarea path="financeOtherText" class="form-control" rows="2" readonly="true"/>
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
                                                            <form:textarea path="financeOtherRemark" class="form-control" rows="2" readonly="true"/>                                                    </div>
                                                    </div>
                                                </td>

                                            </tr>

                                        </table>

                                        <!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->

                                <div class="form-group">
                                    <!--<div class="col-lg-12 col-sm-offset-2" style="">-->
                                    <!--<input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />-->
                                    <%--<c:if test="${noDueMaster.status eq 0 || noDueMaster.status eq 3}">--%>
                                    <!--<input type="submit" class="btn btn-primary" name="btnType" value="Approve"  />-->
                                    <!--<div class="col-sm-6" style="text-align: left">-->
                                    <!--<button type="submit" class="btn btn-success" style="width: 100px;" name="btnType" value="Approve" >APPROVE</button>-->
                                    <!--</div>-->
                                    <!--<div class="col-sm-6" style="text-align: right">-->
                                    <!--<button type="submit" class="btn btn-warning" style="width: 100px;" name="btnType" value="Return" >RETURN</button>-->
                                    <!--</div>-->
                                    <!--<input type="submit" class="btn btn-primary" name="btnType" value="Return"  />-->
                                    <%--</c:if>--%>
                                    <%--<c:if test="${noDueMaster.status eq 4 || noDueMaster.status eq 7}">--%>
                                    <!--                                             <div class="col-sm-6" style="text-align: left">
                                                                            <button type="submit" class="btn btn-success" style="width: 100px;" name="btnType" value="WithdrawApprove" >APPROVE</button>
                                                                           </div>
                                                                            <div class="col-sm-6" style="text-align: right">
                                                                            <button type="submit" class="btn btn-warning" style="width: 100px;" name="btnType" value="WithdrawReturn" >RETURN</button>
                                                                            </div>-->
                                    <!--<input type="submit" class="btn btn-primary" name="btnType" value="WithdrawApprove"  />-->
                                    <!--<input type="submit" class="btn btn-primary" name="btnType" value="WithdrawReturn"  />-->
                                    <%--</c:if>--%>
                                    <!--</div>-->
                                </div>
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

