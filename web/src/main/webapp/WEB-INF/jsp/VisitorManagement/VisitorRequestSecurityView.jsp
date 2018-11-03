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
//            function approve(id,empId) {
//                window.location = "visitorManagement.htm?act=viewSecurityClick&id=" + id+"&empId="+empId+"&for=confirm";
////                window.location = "visitorManagement.htm?act=securityAprroveClick&id=" + id;
//            }
            function withdrawapprove(id) {
                window.location = "visitorManagement.htm?act=adminAprrovewithdrawClick&get=b&id=" + id;
            }
        </script>
        <script>
            function printDivRedirect() {
                var id = document.getElementById("id").value;
                var empId = document.getElementById("employeeId").value;
                window.open("visitorManagement.htm?act=viewSecurityClick&for=print&id=" + id + "&empId=" + empId);
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
                <div class="row" id="printableArea">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <form:form action="" method="post" commandName="visitorManagement"
                                           name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                                    <form:hidden path="employeeMasterByEmployeeMasterId.id" name="employeeId" id="employeeId"></form:hidden>
                                    <form:hidden path="id" name="id" id="id"></form:hidden>
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
                                                            <form:input path="employeeMasterByEmployeeMasterId.employeeId" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Employee Name:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.employeeName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Department:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.departmentMaster.departmentName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class="col-sm-2">
                                                                <label>Designation:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.designationMaster.designationName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-sm-2">
                                                                <label>Level:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.levelMaster.level" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
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
                                                                <label>Location:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.locationMaster.location" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                            </div>
                                                            <div class=" col-sm-2">
                                                                <label>Work Location:</label>
                                                            </div>
                                                            <div class="col-sm-4">   
                                                            <form:input path="employeeMasterByEmployeeMasterId.zydexLocationMaster.zydexLocation" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
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
                                                        <div class="col-md-12 col-sm-12" style="text-align: center;">
                                                        <c:if test="${visitorManagement.visitorPhotograph ne null and visitorManagement.visitorPhotograph ne ''}">
                                                            <img id="newImageAtOld" src="<c:url value="${visitorManagement.visitorPhotograph}"/>"/>
                                                        </c:if>
                                                    </div>
                                                    <div class="col-md-12 col-sm-12">
                                                        </br>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Visitor Visits Location:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="col-sm-7">
                                                                <input type="text" name="zydexLocationId" id="zydexLocationId" class="form-control" readonly="true" value="${zydexLocation}"/>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Visitor Visits Employee:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="col-sm-7">
                                                                <input type="text" name="visitorVisitsToEmployeeId" id="visitorVisitsToEmployeeId" class="form-control" readonly="true" value="${empVisitsToString}" />    
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Visitor's Full Name<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="col-sm-7">
                                                                <form:input path="visitorName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Organization:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorOrganization" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Requested By:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <input class="form-control" size="16" type="text" value="${empRequestString}" readonly="true"/>
                                                            </div>
                                                        </div>    
                                                        <c:if test="${visitorManagement.requestDate ne null and visitorManagement.requestDate ne ''}"> 
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Requested Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <form:input path="requestDate" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                        </c:if>    
                                                        <c:if test="${visitorManagement.incomingDateTime ne null and visitorManagement.incomingDateTime ne ''}">    
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Incoming Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <form:input path="incomingDateTime" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                        </c:if>
                                                        <c:if test="${visitorManagement.meetingOffDate ne null and visitorManagement.meetingOffDate ne ''}">    
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Meeting Off Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <form:input path="meetingOffDate" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                        </c:if>
                                                        <c:if test="${visitorManagement.outgoingDateTime ne null and visitorManagement.outgoingDateTime ne ''}">  
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Outgoing Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                    <form:input path="outgoingDateTime" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                    </div>
                                                                </div>
                                                        </c:if>
                                                        <div class="form-group">
                                                            <label class="col-sm-3 control-label">Visitor's Contact Number:<span style="color: red;font-size: 12px;">*</span></label>
                                                            <div class="col-sm-7">
                                                                <form:input path="visitorContactDetail"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor Coming From:<span style="color: red;font-size: 12px;">*</span></label>
                                                                <div class="col-sm-7">
                                                                <form:input path="visitorComingFrom"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-3 control-label">Visitor's Accessories:</label>
                                                                <div class="col-sm-7">
                                                                <form:textarea path="accesories"  class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    <%--<c:if test="${visitorManagement.visitorPhotograph eq null or visitorManagement.visitorPhotograph eq ''}">--%>
                                                    <!--                                                        <div class="col-md-12 col-sm-12" style="text-align: center;" id="getDivImageBoxButton">
                                                                                                                <button type="button" class="btn btn-primary" id="getImageBoxButton" style="width: 100px;font-size: 10px;padding:2px;" data-original-title="" title="" >Add Photo</button>
                                                                                                            </div>-->
                                                    <%--</c:if>--%>
                                                    <!--<div class="col-md-12 col-sm-12" style="text-align: center;" id="divGetImage">-->
                                                    <%--<c:if test="${visitorManagement.visitorPhotograph eq null or visitorManagement.visitorPhotograph eq ''}">--%>
                                                    <!--                                                            <div class="col-md-6 col-sm-6">
                                                                                                                    <video id="video" width="400" height="400" autoplay style="margin: none;"></video>
                                                                                                                </div>
                                                                                                                <div class="col-md-6 col-sm-6">
                                                                                                                    <canvas id="canvas" width="400" height="300" name="ImageFile1" id="ImageFile1" style="border:1px solid #d3d3d3;margin-top:50px;"></canvas> 
                                                                                                                    <input type="hidden" name="ImageData" id="ImageData"/>
                                                                                                                </div>
                                                                                                                <div style="text-align: center;">
                                                                                                                    <button type="button" class="btn btn-primary" id="snap" style="width: 100px;font-size: 10px;padding:2px;" data-original-title="" title="" >Capture Photo</button>
                                                                                                                    <button type="button" id="submitImageButton" class="btn btn-primary" style="width: 100px;font-size: 10px;padding:2px;" data-original-title="" title="" onclick="setImageDataUsingAjax();">Submit</button>
                                                                                                                </div>-->
                                                    <%--</c:if>--%>        
                                                    <!--</div>-->
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
                                        <div style="text-align: center">
                                            <%--<c:if test="${visitorManagement.status ne 10}">--%>
                                            <%--<c:if test="${visitorManagement.status eq 1 and visitorManagement.status ne 8}">--%>
<!--                                                &nbsp;&nbsp;<button type="button" class="btn btn-primary" style="width: 120px !important;padding:5px;font-size:12px;" onclick="approve(${visitorManagement.id},${visitorManagement.employeeMasterByEmployeeMasterId.id});">CONFIRM VISIT</button>
                                                &nbsp;&nbsp;<button type="button" class="btn btn-primary" style="width: 120px !important;padding:5px;font-size:12px;" onclick="setImageDataUsingAjax();">CONFIRM VISIT</button>-->
                                            <%--</c:if>--%>
                                            <c:if test="${(visitorManagement.status ne 8 and visitorManagement.status ne 2)and(visitorManagement.incomingDateTime eq null || visitorManagement.incomingDateTime eq '')}">
                                                <button type="button" id="submitPrint" onclick="withdrawapprove(document.getElementById('id').value);" class="btn btn-warning" style="width: 120px !important;padding:5px;font-size:12px;">Withdraw</button>
                                            </c:if>
                                            <c:if test="${(visitorManagement.status ne 8)}">    
                                                <button type="button" id="submitPrint" onclick="printDivRedirect();" class="btn btn-primary" style="width: 120px !important;padding:5px;font-size:12px;">Print</button>
                                            </c:if>
                                            <%--<c:if test="${visitorManagement.status eq 2}">--%>    
                                            <!--<button type="button" id="submitPrint" onclick="printDivRedirect();" class="btn btn-primary" style="width: 120px !important;padding:5px;font-size:12px;">Print</button>-->
                                            <%--</c:if>--%>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
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

        <!--        <script>
                    $(document).ready(function () {
                        $("#divGetImage").hide();
                        $("#getImageBoxButton").click(function () {
                            $("#getDivImageBoxButton").hide();
                            $("#divGetImage").show();
                        });
                    });
                </script> 
                <script>
                    function setImageDataUsingAjax() {
                        var id = document.getElementById("id").value;
                        var empId = document.getElementById("employeeId").value;
                        var imageData = document.getElementById("ImageData").value;
                        $.ajax({
                            type: "POST",
                            url: "visitorManagement.htm?act=pushData",
                            data: {"id": id, "ImageData": imageData, "empId": empId,"for": "view"},
                            dataType: "json",
                            success: function (msg) {
                                location.reload();
                            },
                            error: function (msg) {
                                location.reload();
                            }
                        });
                    }
                </script>            -->
        <!--        <script>
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
                <script>
                    // camera code
                    // Put event listeners into place 
                    window.addEventListener("DOMContentLoaded", function () {
                        // Grab elements, create settings, etc. 
                        var canvas = document.getElementById("canvas"),
                                context = canvas.getContext("2d"),
                                video = document.getElementById("video"),
                                videoObj = {"video": true},
                                errBack = function (error) {
                                    console.log("Video capture error: ", error.code);
                                };
                        // Put video listeners into place 
                        if (navigator.getUserMedia) { // Standard 
                            navigator.getUserMedia(videoObj, function (stream) {
                                video.src = window.URL.createObjectURL(stream);
                                video.play();
                            }, errBack);
                        } else if (navigator.webkitGetUserMedia) { // WebKit-prefixed 
                            navigator.webkitGetUserMedia(videoObj, function (stream) {
                                video.src = window.webkitURL.createObjectURL(stream);
                                video.play();
                            }, errBack);
                        } else if (navigator.mozGetUserMedia) { // WebKit-prefixed 
                            navigator.mozGetUserMedia(videoObj, function (stream) {
                                video.src = window.URL.createObjectURL(stream);
                                video.play();
                            }, errBack);
                        }
        
                        // Trigger photo take 
                        document.getElementById("snap").addEventListener("click", function () {
                            //                    event.preventDefault();
                            context.drawImage(video, 0, 0, 400, 300);
                            document.getElementById('ImageData').value = canvas.toDataURL("image/png");
                            document.getElementById('canvasImg').src = canvas.toDataURL("image/png");
                            document.getElementById('newImageAtOld').src = canvas.toDataURL("image/png");
                            document.getElementById('canvasImg').style.display = "none";
                            //                    document.getElementById('video').style.display = "none"; // hide the live image video portin after click on take picture 
                        });
                    }
                    , false);
        
                </script>-->
        <script>
            function printDivRedirect() {
                var id = document.getElementById("id").value;
                var empId = document.getElementById("employeeId").value;
                window.open("visitorManagement.htm?act=viewSecurityClick&for=print&id=" + id + "&empId=" + empId);
                window.setTimeout(function () {
                    window.location = "visitorManagement.htm?act=securityApprove";
                }, 2000);
            }
        </script>
        <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
