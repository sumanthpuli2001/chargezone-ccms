<%-- 
    Document   : VisitorRequestSecurityView
    Created on : Nov 16, 2015, 3:14:49 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitor Request</title>
        <script>
            function approve(id) {
                window.location = "visitorManagement.htm?act=securityAprroveClick&id=" + id;
            }
            function withdrawapprove(id) {
                window.location = "visitorManagement.htm?act=adminAprrovewithdrawClick&id=" + id;
            }
        </script>
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
    </head>

    <body>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Visitor Request: </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Visitor Management System</li>
                </ol>
            </section>
            <c:if test="${!empty successMessage}">
                <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
            </c:if>
            <c:if test="${!empty failureMessage}">
                <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
            </c:if>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <form:form action="" method="post" commandName="visitorManagement"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="employeeMasterByEmployeeMasterId.id"></form:hidden>
                                    <form:hidden path="id"></form:hidden>
                                        <!--Read only entries Starts here-->
                                        <div class="box box-info collapsed-box ">
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
                                                            <div class="col-sm-2">
                                                                <label>Employee No.:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.employeeId}" readonly="true"></form:input>
                                                            </div>
                                                            <div class=" col-sm-2">
                                                                <label>Employee Name:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.employeeName}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Department:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.departmentMaster.departmentName}" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Designation:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.designationMaster.designationName}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Level:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.levelMaster.level}" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Reporting Manager:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${reportingLevel1}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class=" col-sm-2">
                                                                <label>Work Location:</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                            <form:input path="" class="form-control" size="16" type="text" value="${employeeMaster.locationMaster.location}" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>         
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Visitor's Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <section class="content">
                                                    <div class="row">
                                                        <div class="col-md-12 col-sm-12">
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Name:</label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorName" class="form-control" size="16" type="text" value=""  readonly="true" ></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Organization:</label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorOrganization" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Incoming Date & Time:</label>
                                                                <div class="col-sm-7">
                                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                                                    <form:input path="incomingDateTime" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Visits To:</label>
                                                                <div class="col-sm-7">
                                                                <%--<form:input path="" class="form-control" size="16" type="text" value="${visitorManagement.locationMaster.location}" readonly="true"></form:input>--%>
                                                                <form:input path="visitorVisitedLocation.location"  class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Contact Detail:</label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="visitorContactDetail"  class="form-control" size="16" type="text" value=""  readonly="true"></form:textarea>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Coming From:</label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="visitorComingFrom"  class="form-control" size="16" type="text" value=""  readonly="true"></form:textarea>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Accessories:</label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="accesories"  class="form-control" size="16" type="text" value=""  readonly="true"></form:textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                </section>
                                            </div>
                                        </div>
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Reason In Detail:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <section>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <!-- Custom Tabs -->
                                                            <div class="nav-tabs-custom">
                                                                <div class="tab-content">
                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label">Reason:</label>
                                                                        <div class="col-sm-7">
                                                                        <form:textarea path="reason" rows="6" class="form-control" size="16" type="text" value=""  readonly="true"></form:textarea>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </section>
                                            </div> 
                                        </div>
                                    <c:if test="${visitorManagement.status eq 5 || visitorManagement.status eq 10}">
                                        <div class="box box-info collapsed-box">
                                            <div class="box-header">
                                                <h3 class="box-title">Request Return Reason:</h3>
                                                <div class="box-tools pull-right">
                                                    <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                                </div>
                                            </div><!-- /.box-header -->
                                            <div class="box-body no-padding">
                                                <section>
                                                    <div class="row">
                                                        <div class="col-md-12">
                                                            <!-- Custom Tabs -->
                                                            <div class="nav-tabs-custom">
                                                                <div class="tab-content">
                                                                    <div class="form-group">
                                                                        <label class="col-sm-3 control-label">Reason:</label>
                                                                        <div class="col-sm-7">
                                                                            <form:textarea path="securityRemark" rows="6" class="form-control" size="16" type="text" value="securityRemark" readonly="true"></form:textarea>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </section>
                                                </div> 
                                            </div>  
                                    </c:if>                                       
                                    <div class="form-group">
                                        <div class="col-sm-offset-5 col-sm-4">
                                            <%--<c:if test="${visitorManagement.status ne 10}">--%>
                                            <c:if test="${visitorManagement.status eq 1}">
                                                &nbsp;&nbsp;<button type="button" class="btn btn-primary" style="width: 110px !important;" onclick="approve(${visitorManagement.id}, 2);">CONFIRM VISIT</button>
                                            </c:if>
                                            <!--&nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#rejectRemark"  onclick="rejectClick('rejectRemark')">Reject</button>-->
                                            <!--&nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#returnRemark" onclick="remarkClick('returnRemark')">Return</button>-->      
                                            <%--</c:if>--%>
                                            <%--<c:if test="${visitorManagement.status eq 6 || visitorManagement.status eq 10}">--%>
                        <!--                    &nbsp;&nbsp;<button type="button" class="btn btn-primary" onclick="withdrawapprove(${visitorManagement.id},8);">Approve </button>
                                            &nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#withdrawrejectRemark" >Reject </button>
                                            &nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#withdrawreturnRemark">Return </button>-->

                                            <%--</c:if>--%>      
                                        </div>
                                    </div>
                                </div>
                            </form:form>
                        </div><!-- nav-tabs-custom -->
                    </div>
                </div>
            </section>
        </div>
        <!--reject popup-->
        <div class="modal fade" id="rejectRemark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                        <h4 class="modal-title" id="myModalLabel">Reject Remark</h4>
                    </div>
                    <form onsubmit="return rejectSubmit();"
                          action="visitorManagement.htm?act=securityAprroveClick&id=${visitorManagement.id}&statusType=3" commandName="visitorManagement"
                          method="post"  name='form2' id ="form2" class="form-horizontal" role="form">

                        <div class="modal-body">
                            <div class="control-group">
                                <label for="inputPassword" class="col-sm-1 control-label">
                                    Remark<font style="color: red;font-size: 16px;">*</font>
                                </label>
                                <div class="controls">
                                    <textarea name="securityRemark" id="Remark1" class="form-control span5"></textarea>
                                    <div id="errorRemark1" style="color: red;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button id="close" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button id="Save" type="submit" class="btn btn-primary" >Reject</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--return remark-->
        <div class="modal fade" id="returnRemark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                        <h4 class="modal-title" id="myModalLabel">Return Remark</h4>
                    </div>
                    <form onsubmit="return returnSubmit();"
                          action="visitorManagement.htm?act=securityAprroveClick&id=${visitorManagement.id}&statusType=4" commandName="visitorManagement"
                          method="post"  name='form3' id ="form3" class="form-horizontal" role="form">
                        <div class="modal-body">
                            <div class="control-group">
                                <label for="inputPassword" class="col-sm-1 control-label">
                                    Remark<font style="color: red;font-size: 16px;">*</font>
                                </label>
                                <div class="controls">
                                    <textarea name="securityRemark" id="Remark0" class="form-control span5"></textarea>
                                    <div id="errorRemark0" style="color: red;"></div>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button id="close" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button id="Save" type="submit" class="btn btn-primary" >Return</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <c:if test="${visitorManagement.status eq 6 || visitorManagement.status eq 10}">
            <!--withdraw reject popup-->
            <div class="modal fade" id="withdrawrejectRemark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                            <h4 class="modal-title" id="myModalLabel">Withdraw Request Reject Remark</h4>
                        </div>
                        <form onsubmit="return withdrawrejectSubmit();"
                              action="visitorManagement.htm?act=adminAprrovewithdrawClick&id=${visitorManagement.id}&statusType=7" commandName="visitorManagement"
                              method="post"  name='form4' id ="form4" class="form-horizontal" role="form">

                            <div class="modal-body">
                                <div class="control-group">
                                    <label for="inputPassword" class="col-sm-1 control-label">
                                        Remark<font style="color: red;font-size: 16px;">*</font>
                                    </label>
                                    <div class="controls">
                                        <textarea name="securityRemark" id="Remark3" class="form-control span5"></textarea>
                                        <div id="errorRemark3" style="color: red;"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button id="close" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button id="Save1" type="submit" class="btn btn-primary" >Reject</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>      
            <!--withdraw return remark-->
            <div class="modal fade" id="withdrawreturnRemark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                            <h4 class="modal-title" id="myModalLabel">Withdraw Request Return Remark</h4>
                        </div>
                        <form onsubmit="return withdrawreturnSubmit();"
                              action="visitorManagement.htm?act=adminAprrovewithdrawClick&id=${visitorManagement.id}&statusType=9"
                              method="post"  name='form5' id ="form5" class="form-horizontal" role="form">
                            <div class="modal-body">
                                <div class="control-group">
                                    <label for="inputPassword" class="col-sm-1 control-label">
                                        Remark<font style="color: red;font-size: 16px;">*</font>
                                    </label>
                                    <div class="controls">
                                        <textarea name="securityRemark" id="Remark2" class="form-control span5"></textarea>
                                        <div id="errorRemark2" style="color: red;"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button id="close" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button id="Save" type="submit" class="btn btn-primary" >Return</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>                   

        </c:if>            
        <script>
            $('#approveRemark').modal('hide');
            $('#returnRemark').modal('hide');
            $('#rejectRemark').modal('hide');
            $('#withdrawreturnRemark').modal('hide');
            $('#withdrawrejectRemark').modal('hide');

            function returnSubmit() {
                var flag = true;
                var securityRemark = document.getElementById('Remark0').value;
                if ('' === securityRemark) {
                    flag = false;
                    document.getElementById('errorRemark0').innerHTML = 'Please Enter Remark.';
                }
                return flag;
            }

            function rejectSubmit() {
                var flag = true;
                var securityRemark = document.getElementById('Remark1').value;
                if ('' === securityRemark) {
                    flag = false;
                    document.getElementById('errorRemark1').innerHTML = 'Please Enter Remark.';
                }
                return flag;
            }
            function withdrawreturnSubmit() {
                var flag = true;
                var securityRemark = document.getElementById('Remark2').value;
                if ('' === securityRemark) {
                    flag = false;
                    document.getElementById('errorRemark2').innerHTML = 'Please Enter Remark.';
                }
                return flag;
            }

            function withdrawrejectSubmit() {
                var flag = true;
                var securityRemark = document.getElementById('Remark3').value;
                if ('' === securityRemark) {
                    flag = false;
                    document.getElementById('errorRemark3').innerHTML = 'Please Enter Remark.';
                }
                return flag;
            }

        </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
