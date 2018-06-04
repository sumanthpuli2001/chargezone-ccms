<%-- 
    Document   : EmpView
    Created on : Oct 23, 2015, 12:26:56 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request For Pool Car</title>
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
<!--         <script>
//            function returnSubmit(id) {
//                window.location = "poolCarRequest.htm?act=returnCreateSubmit&id=" + id;
//            }
            function withdraw(id) {
                window.location = "poolCarRequest.htm?act=empwithdraw&id=" + id;
            }
            function withdrawreturnSubmit(id) {
                window.location = "poolCarRequest.htm?act=withdrawreturnSubmit&id=" + id;
            }
        </script>-->
    </head>
   
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>POOL CAR REQUEST </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Pool Car Request</li>
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
            <form:form action="poolCarRequest.htm?act=returnCreateSubmit&id=${poolCarRequest.id}" method="post" commandName="poolCarRequest"
                       name='form1' onsubmit='return saveSubmit11();' class="form-horizontal" role="form">
                <form:hidden path="employeeMasterByEmployeeMasterId.id"></form:hidden>
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
                                                                <!--employeeMasterByEmployeeMasterId.designationMaster.designationName-->
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
                                        <h3 class="box-title">Pool Car Request Type:</h3>
                                        <div class="box-tools pull-right">
                                            <!--<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i></button>-->
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Pool Car Request for:</label>
                                                    <div class="col-sm-7">
                                                <form:select path="requestFor" id="poolCarRequestSelectId" onchange="selectClick(this.value);"  class="form-control ">
                                                          <form:option value="${requestFor}">${requestFor}</form:option>  
                                                          <%--<c:if test="${requestFor} eq 'false'">--%>
                                                               <c:if test="${poolCarRequest.requestFor eq false}">
                                                          <form:option value="true">Self</form:option></c:if>
                                                          <c:if test="${poolCarRequest.requestFor eq true}">
                                                          <form:option value="false">Other</form:option></c:if>
                                                </form:select>
                                                </div>
                                            </div>
                                           <div class="form-group bg-aqua modal-info modal-body" id="attendanceDiv"  style="display: none">
                                                <div class="col-sm-offset-3">
                                                <strong style="color: black">Your Attendance For The Below Date & Time Will Be Automatically Regularized. </strong>
                                             </div>
                                             </div>
                                            <div class="form-group">
                                                       <label class="col-sm-3 control-label">Start Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class=" col-sm-7">
                                                       <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii  " data-link-field="dtp_input1">
                                            <form:input path="startDateTime" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                            <form:errors path="startDateTime" cssClass="errorDiv"></form:errors>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                                </div>
                                                 </div>
                                                 <div class="form-group">
                                                    <label class="col-sm-3 control-label">End Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class=" col-sm-7">
                                                       <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                            <form:input path="endDateTime" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                            <form:errors path="endDateTime" cssClass="errorDiv"></form:errors>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                                </div>
                                            </div>
                                        </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div><!-- /.box-body -->
                                </div>
                <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Reason In Detail:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason for Request:</label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="reason" rows="6" class="form-control" size="16" type="text" value=""></form:textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </div>
    <c:if test="${poolCarRequest.status eq 6 || poolCarRequest.status eq 16}" >                              
        <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Return Reason:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason:</label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="rejectRemark" rows="6" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
            </div>
      </c:if>
    <c:if test="${poolCarRequest.status eq 7 }" >                              
        <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Return Reason:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason:</label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="adminRemark" rows="6" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
            </div>
      </c:if>
               
                <div class="form-group">
            <c:if test="${poolCarRequest.status eq 6 || poolCarRequest.status eq 7}">
                <div class="col-sm-6" style="text-align: left">
                &nbsp;&nbsp;<button type="submit" class="btn btn-primary" style="width: 100px" id="saveSubmit1" name="btnType" value="Submit" >Submit</button>
                </div>
                <div class="col-sm-6" style="text-align: right">
                <button type="submit" class="btn btn-warning"  name="btnType" value="Withdraw">Withdraw</button>
                </div>
            </c:if>
               <div class="col-sm-offset-5 col-sm-4">
            <c:if test="${poolCarRequest.status eq 16}">
                &nbsp;&nbsp;<button type="submit" class="btn btn-warning" name="btnType" style="width: 100px" id="saveSubmit1" onclick="withdrawreturnSubmit(${poolCarRequest.id})" value="Submit">Submit</button>
            </c:if>
            <c:if test="${poolCarRequest.status eq 1 ||poolCarRequest.status eq 2 || poolCarRequest.status eq 4
                  ||poolCarRequest.status eq 8 || poolCarRequest.status eq 9}">
                <button type="submit" class="btn btn-warning" name="btnType" value="Withdraw">Withdraw</button>
            </c:if>
                </div> 
            </div>
            </div>
          </form:form>
        </div><!-- nav-tabs-custom -->
                   </div>
                 </div>
               </div>
           </section>
        
    </div>
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1,
             startDate: new Date()
        });
    </script>
    <script>
       function selectClick(val) {
               if ('true' === val) {
                   document.getElementById('attendanceDiv').style.display = 'block';
                }
                else {
                   document.getElementById('attendanceDiv').style.display = 'none';
                }
        }
        $(document).ready(function () {
             var e = document.getElementById("requestFor");
                var value = e.options[e.selectedIndex].value;
                selectClick(value);
        });
    </script>        
     <style>
        .bg-aqua,
        .modal-info .modal-body {
            background-color: #D6EBFF !important;
        }
    </style>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
