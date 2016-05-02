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
            <h1>No Due Form:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">No Due Form</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <!--form horizontal starts here-->

                            <%--<c:if test="${!(sessionScope.employeeInfo.id eq param.employeeId)}">--%>
                            <form:form action="noDueMaster.htm?act=submitNoDueForm" method="post" commandName="noDueMaster" name='form1' class="form-horizontal" role="form" id="form1">
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
                                                <c:forEach var="list" items="${list}">
                                                    <div class="form-group">
                                                        <div class="col-sm-6">
                                                            <label>Name Of The Employee:</label>
                                                            <input type="text" class="form-control" value="${list.employeeName}" readonly/>
                                                            <input type="hidden"  name="empId" value="${list.id}"/>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <label>Date Of Relieving:</label>
                                                            <div class="input-group date form_datetime"   data-date-format="dd/mm/yyyy" data-link-field="dtp_input1">
                                                                <input id="leaveStartDateId" class="form-control" size="16" type="text" value="${list.dateOfLeaving}" readonly>
                                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div><!-- /.col -->

                                        <!-- /.col -->
                                    </div><!-- /.row -->
                                </div><!-- /.box-body -->
                                <%--<c:if test="${sessionScope.employeeInfo.id eq reportingManager}">--%>
                                <%--<c:if test="${(sessionScope.employeeInfo.id eq reportingManager) or (sessionScope.userRight.noDue && sessionScope.userRight.itAdmin && sessionScope.userRight.travelExpenseAdmin)}">--%>
                                <c:if test="${(sessionScope.employeeInfo.id eq reportingManager) or (sessionScope.userRight.employeeExit)}">
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
                                                                <form:select path="equipments" id="equipments" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="equipmentsRemarks" class="form-control" rows="2"/>                                               </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle"><b>Special Tools & Gadgets </b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="specialTool" id="specialTool" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="specialToolRemark" class="form-control" rows="2"/>                                                   </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle"><b>Computer Files & Password /Cupboard Keys</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="computerFiles" id="computerFiles" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="computerFilesRemark" class="form-control" rows="2"/>                                                   </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td  style="background-color: lightgrey;vertical-align: middle"><b>Transfer of Advance Amount (please mention name in remarks)</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="advanceAmount" id="advanceAmount" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="advanceAmountRemark" class="form-control" rows="2"/>                                                   </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle">
                                                        <b>Other</b>
                                                        <form:textarea path="deptOtherText" class="form-control" rows="2"/>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="deptOther" id="deptOther" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="deptOtherRemark" class="form-control" rows="2"/>                                                   </div>
                                                        </div>
                                                    </td>

                                                </tr>

                                            </table>

                                            <!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </c:if>
                                <%--<c:if test="${sessionScope.userRight.noDue}">--%>
                                <c:if test="${sessionScope.userRight.employeeExit}">
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
                                                                <form:select path="carProvided" id="carProvided" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="carProvidedRemark" class="form-control" rows="2"/>                                                  </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle"><b>Returnable Stationary Items – calculator, punch, stapler, etc.</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="stationaryItem" id="stationaryItem" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="stationaryItemRemark" class="form-control" rows="2"/>                                                   </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td  style="background-color: lightgrey;vertical-align: middle"><b>Checking  of   company  provided residence and equipments installed inside</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="residance" id="residance" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="residanceRemark" class="form-control" rows="2"/>                                                   </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td  style="background-color: lightgrey;vertical-align: middle"><b>Identity Card</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="identityCard" id="identityCard" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="identityCardRemark" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td  style="background-color: lightgrey;vertical-align: middle"><b>Library</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="library" id="library" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="libraryRemark" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td  style="background-color: lightgrey;vertical-align: middle"><b>Cafeteria</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="cafeteria" id="cafeteria" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="cafeteriaRemark" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td  style="background-color: lightgrey;vertical-align: middle"><b>Exit Interview</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="exitInterview" id="exitInterview" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="exitInterviewReamrk" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle">
                                                        <b>Other</b>
                                                        <form:textarea path="hrOtherText" class="form-control" rows="2"/>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="hrOther" id="hrOther" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="hrOtherRemark" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>

                                                </tr>

                                            </table>

                                            <!-- /.col -->
                                        </div><!-- /.row -->
                                    </div>
                                </c:if>
                                <c:if test="${(sessionScope.userRight.itAdmin) or (sessionScope.userRight.employeeExit)}">
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
                                                                <form:select path="companyMobile" id="companyMobile" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="companyMobileRemark" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle"><b>Computer Checked / Password / Printer Recovered </b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="computerChecked" id="computerChecked" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="computerCheckedRemark" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle"><b>Domain Name Changed / Email</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="email" id="email" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="emailRemark" class="form-control" rows="2"/>                                                   </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle"><b>Computer Transferred To(please mention name in remarks)</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="computerTransfered" id="computerTransfered" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="computerTransferedRemark" class="form-control" rows="2"/>                                                  </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle">
                                                        <b>Other</b>
                                                        <form:textarea path="itOtherText" class="form-control" rows="2"/>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="itOther" id="itOther" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="itOtherRemark" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>

                                                </tr>


                                            </table>

                                            <!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </c:if>
                                <%--<c:if test="${(sessionScope.userRight.travelExpenseAdmin)}">--%>
                                <c:if test="${(sessionScope.userRight.travelExpenseAdmin) or (sessionScope.userRight.employeeExit) }">
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
                                                                <form:select path="advanceCleared" id="advanceCleared" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="advanceClearedRemark" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle"><b>Pending Bills Submitted</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="pendingBills" id="pendingBills" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="pendingBillsRemark" class="form-control" rows="2"/>                                                   </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle"><b>Salary Advance / Loans / Earlier Travel Remittance</b></td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="salaryAdvanceOrLoan" id="salaryAdvanceOrLoan" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="salaryAdvanceOrLoanRemark" class="form-control" rows="2"/>                                                   </div>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <td style="background-color: lightgrey;vertical-align: middle">
                                                        <b>Other</b>
                                                        <form:textarea path="financeOtherText" class="form-control" rows="2"/>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-10">
                                                                <form:select path="financeOther" id="financeOther" class="form-control" >
                                                                    <form:options items="${status2}"></form:options>
                                                                </form:select>
                                                            </div>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="form-group">
                                                            <div class="col-sm-12">
                                                                <form:textarea path="financeOtherRemark" class="form-control" rows="2"/>                                                    </div>
                                                        </div>
                                                    </td>

                                                </tr>

                                            </table>

                                            <!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </c:if>
                                <c:if test="${!(sessionScope.employeeInfo.id eq param.employeeId)}">

                                    <div class="form-group">
                                        <div class="col-lg-12" style="text-align: center;">
                                            <c:set var="count" value="0" scope="page"/>
                                            <c:choose>
                                                <c:when test="${sessionScope.employeeInfo.id eq reportingManager}">
                                                    <%--<c:if test="${(noDueByEmployeeIdList.equipments eq null or noDueByEmployeeIdList.equipments eq '') or (sessionScope.userRight.noDue && sessionScope.userRight.itAdmin && sessionScope.userRight.travelExpenseAdmin)}">--%>
                                                    <c:if test="${(noDueByEmployeeIdList.equipments eq null or noDueByEmployeeIdList.equipments eq '') or (sessionScope.userRight.employeeExit)}">
                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                        <c:if test="${count eq 1}">
                                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">Submit</button>
                                                        </c:if>

                                                    </c:if>
                                                    <!--check it that reporting manager or not-->

                                                </c:when>
                                                <c:otherwise>
                                                    <%--<c:if test="${(sessionScope.userRight.noDue)&&(noDueByEmployeeIdList.carProvided eq null or noDueByEmployeeIdList.carProvided eq '')}">--%>
                                                    <c:if test="${(sessionScope.userRight.employeeExit)&&(noDueByEmployeeIdList.carProvided eq null or noDueByEmployeeIdList.carProvided eq '')}">
                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                        <c:if test="${count eq 1}">
                                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">Submit</button>
                                                        </c:if>                                                    </c:if>
                                                    <c:if test="${(sessionScope.userRight.itAdmin)&&(noDueByEmployeeIdList.computerChecked eq null or noDueByEmployeeIdList.computerChecked eq '')}">
                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                        <c:if test="${count eq 1}">
                                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">Submit</button>
                                                        </c:if>                                                    </c:if>
                                                    <c:if test="${(sessionScope.userRight.travelExpenseAdmin)&&(noDueByEmployeeIdList.salaryAdvanceOrLoan eq null or noDueByEmployeeIdList.salaryAdvanceOrLoan eq '')}">
                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                        <c:if test="${count eq 1}">
                                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">Submit</button>
                                                        </c:if>                                                    </c:if>
                                                    <%--<c:if test="${(sessionScope.userRight.noDue && sessionScope.userRight.itAdmin && sessionScope.userRight.travelExpenseAdmin)&&(noDueByEmployeeIdList.carProvided ne null or noDueByEmployeeIdList.carProvided ne '')&&(noDueByEmployeeIdList.computerChecked ne null or noDueByEmployeeIdList.computerChecked ne '')&&(noDueByEmployeeIdList.salaryAdvanceOrLoan ne null or noDueByEmployeeIdList.salaryAdvanceOrLoan ne '')}">--%>
                                                    <c:if test="${(sessionScope.userRight.employeeExit)
                                                                  &&(noDueByEmployeeIdList.carProvided ne null)
                                                                  &&(noDueByEmployeeIdList.computerChecked ne null)
                                                                  &&(noDueByEmployeeIdList.salaryAdvanceOrLoan ne null)}">
                                                        <c:set var="count" scope="page" value="${count + 1}" />
                                                        <c:set var="masertCount" scope="page" value="1" />
                                                        <c:if test="${count eq 1}">
                                                            <button type="submit" class="btn btn-primary" data-original-title="" title="" style="width: 100px">Submit</button>
                                                        </c:if>                                                    </c:if>
                                                </c:otherwise>
                                            </c:choose>
                                            <!--<input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />-->
                                        </div>
                                    </div>
                                </c:if>
                            </form:form>
                            <%--</c:if>--%>
                        </div>
                        <!--form horizontal ends here-->
                        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
                        <!--</div> /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div>
    <!--    <script type="text/javascript">
            $('.form_datetime').datetimepicker({
                //language:  'fr',
                weekStart: 1,
                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0,
                showMeridian: 1
            });
        </script>-->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--this is the script used for disable all form fields-->
    <script>
//        alert('' +${count});
        var isSubmitButtonExist = ${count};
//        var isMasertCount =${masertCount};
        if (isSubmitButtonExist == 1) {

        } else {
            var inputs = document.getElementsByTagName("input");
            for (var i = 0; i < inputs.length; i++) {
                inputs[i].disabled = true;
            }
            var selects = document.getElementsByTagName("select");
            for (var i = 0; i < selects.length; i++) {
                selects[i].disabled = true;
            }
            var textareas = document.getElementsByTagName("textarea");
            for (var i = 0; i < textareas.length; i++) {
                textareas[i].disabled = true;
            }
        }

    </script>
</html>

