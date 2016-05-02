<%-- 
    Document   : ViewPoolCarRequest
    Created on : Oct 19, 2015, 12:30:56 PM
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
    </head>
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
      <script>
      var flag3 = true;
            function approveSubmit1() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('approveSubmit1').innerHTML = 'Approve ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
    </script>
    <script>
         function approve(id) {
                window.location = "poolCarRequest.htm?act=aprroveClick&id=" + id;
            }
         function approvereturn(id) {
                window.location = "poolCarRequest.htm?act=aprroveReturnClick&id=" + id;
            }
        function withdrawapprove(id) {
                window.location = "poolCarRequest.htm?act=approverwithdraw&id=" + id;
            }
         function withdrawapprovereturn(id) {
                window.location = "poolCarRequest.htm?act=withdrawapprovereturn&id=" + id;
            }
      </script>
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>Pool Car Request: </h1>
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
            <form:form action="" method="post" commandName="poolCarRequest"
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
                                                    <label class="col-sm-3 control-label">Pool Car Request for:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                <input name="requestFor" id="poolCarRequestSelectId" class="form-control " readonly="true" value="${requestFor}"/>
                                                </div>
                                            </div>
                                          
                                          <div class="form-group">
                                                       <label class="col-sm-3 control-label">Start Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class=" col-sm-7">
                                                       <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy - hh:ii  " data-link-field="dtp_input1">
                                            <form:input path="startDateTime" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                            <form:errors path="startDateTime" cssClass="errorDiv"></form:errors>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                                </div>
                                               </div>
                                                 <div class="form-group">
                                                    <label class="col-sm-3 control-label">End Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class=" col-sm-7">
                                                       <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy - hh:ii  " data-link-field="dtp_input1">
                                            <form:input path="endDateTime" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                            <form:errors path="endDateTime" cssClass="errorDiv"></form:errors>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                <div class="form-group">
                                                    <label class="col-sm-3 control-label">Reason:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="reason" rows="6" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </div>
                                                
        <c:if test="${poolCarRequest.status eq 8 || poolCarRequest.status eq 7 || poolCarRequest.status eq 17 || poolCarRequest.status eq 18}" >                              
              <div class="box box-info collapsed-box">
                                    <div class="box-header">
                                        <h3 class="box-title">Pool Car Request Return Reason:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                    <c:if test="${poolCarRequest.status eq 8 || poolCarRequest.status eq 18}">
                                                <div class="form-group">
                                                      <c:if test="${poolCarRequest.rejectRemark ne null && not empty poolCarRequest.rejectRemark}">
                                                    <label class="col-sm-3 control-label">Manager Remark:</label>
                                                    <div class="col-sm-7">    
                                                    <form:textarea path="rejectRemark" rows="6" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                         </div>
                                                    </c:if>
                                                    </div>
                                                    <div class="form-group">
                                                    <%--<c:if test="${poolCarRequest.status eq 7 || poolCarRequest.status eq 17}">--%>
                                                      <c:if test="${poolCarRequest.adminRemark ne null && not empty poolCarRequest.adminRemark}">
                                                    <label class="col-sm-3 control-label">Admin Remark:</label>
                                                          <div class="col-sm-7">    
                                                    <form:textarea path="adminRemark" rows="6" class="form-control" size="16" type="text" value="adminRemark" readonly="true"></form:textarea>
                                                </div>
                                                    </c:if>    
                                            </div>
                                                    </c:if>    
                                        </div>
                                    </div>
                                </div>
                                </div>
      </c:if>
       <div class="form-group">
                 <!--<div class="col-sm-offset-3 col-sm-4">-->
                <c:if test="${poolCarRequest.status ne 18}">
                <c:if test="${poolCarRequest.status ne 17}">
                <c:if test="${poolCarRequest.status ne 10}">
                <c:if test="${poolCarRequest.status ne 14}">
                <c:if test="${poolCarRequest.status eq 8 || poolCarRequest.status eq 7}">
                    <div class="col-sm-4" style="text-align: left">
                &nbsp;&nbsp;<button type="button" class="btn btn-success" style="width: 100px;"onclick="approvereturn(${poolCarRequest.id});">APPROVE</button>
              </div>
                    </c:if>
                
                <c:if test="${poolCarRequest.status ne 8}">
                <c:if test="${poolCarRequest.status ne 7}">
                    <div class="col-sm-4" style="text-align: left">
                &nbsp;&nbsp;<button type="button" class="btn btn-success" style="width: 100px;"onclick="approve(${poolCarRequest.id},2);">APPROVE</button>
           </div>
                    </c:if>
              </c:if>
                <div class="col-sm-4" style="text-align: center">
                &nbsp;&nbsp;<button type="button" class="btn btn-danger" style="width: 100px;" data-toggle="modal" data-target="#rejectRemark"  onclick="rejectClick('rejectRemark')">REJECT</button>
               </div>
                <div class="col-sm-4" style="text-align: right">
                &nbsp;&nbsp;<button type="button" class="btn btn-warning" style="width: 100px;" data-toggle="modal" data-target="#returnRemark" onclick="remarkClick('returnRemark')">RETURN</button>
              </div>
                </c:if>
                </c:if>
                </c:if>
                </c:if>
                <%--<c:if test="${poolCarRequest.status eq 17 || poolCarRequest.status eq 18}">--%>
                    <!--<div class="col-sm-4" style="text-align: left">-->
                <!--&nbsp;&nbsp;<button type="button" class="btn btn-success" style="width: 100px;"onclick="withdrawapprovereturn(${poolCarRequest.id});">APPROVE  </button>-->
                <!--</div>-->
                 <!--<div class="col-sm-4" style="text-align: center">-->
                <!--&nbsp;&nbsp;<button type="button" class="btn btn-danger" style="width: 100px;" data-toggle="modal" data-target="#withdrawrejectRemark" >REJECT </button>-->
                <!--</div>-->
                 <!--<div class="col-sm-4" style="text-align: right">-->
                <!--&nbsp;&nbsp;<button type="button" class="btn btn-warning" style="width: 100px;" data-toggle="modal" data-target="#withdrawreturnRemark">RETURN </button>-->
                <!--</div>-->
                    
                <%--</c:if>--%>
                <%--<c:if test="${poolCarRequest.status eq 10}">--%>
                <!--&nbsp;&nbsp;<button type="button" class="btn btn-success" onclick="withdrawapprove(${poolCarRequest.id},12);">APPROVE </button>-->
                <!--&nbsp;&nbsp;<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#withdrawrejectRemark" >REJECT </button>-->
                <!--&nbsp;&nbsp;<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#withdrawreturnRemark">RETURN </button>-->
                <%--</c:if>--%>
            </div> 
            </div>
            <!--</div>-->
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
                              action="poolCarRequest.htm?act=aprroveClick&id=${poolCarRequest.id}&statusType=3" commandName="poolCarRequest"
                              method="post"  name='form2' id ="form2" class="form-horizontal" role="form">
                            
                            <div class="modal-body">
                                <div class="control-group">
                                    <label for="inputPassword" class="col-sm-1 control-label">
                                        Remark<font style="color: red;font-size: 16px;">*</font>
                                    </label>
                                    <div class="controls">
                                        <textarea name="rejectRemark" id="Remark1" class="form-control span5"></textarea>
                                        <div id="errorRemark1" style="color: red;"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button id="close" type="button" style="width: 100px;" class="btn btn-default" data-dismiss="modal">Close</button>
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
                              action="poolCarRequest.htm?act=aprroveClick&id=${poolCarRequest.id}&statusType=6"
                              method="post"  name='form3' id ="form3"
                              class="form-horizontal" role="form">
                            <div class="modal-body">
                                <div class="control-group">
                                    <label for="inputPassword" class="col-sm-1 control-label">
                                        Remark<font style="color: red;font-size: 16px;">*</font>
                                    </label>
                                    <div class="controls">
                                         <textarea name="rejectRemark" id="Remark0" class="form-control span5"></textarea>
                                        <div id="errorRemark0" style="color: red;"></div>
<!--                                        <textarea name="remark" id="Remark0" class="form-control"></textarea>
                                        <div id="errorRemark0" style="color: red;"></div>-->
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button id="close" type="button" class="btn btn-default"  style="width: 100px;" data-dismiss="modal">Close</button>
                                <button id="Save1" type="submit" class="btn btn-primary" >Return</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

                              
        <c:if test="${poolCarRequest.status eq 10 || poolCarRequest.status eq 17 || poolCarRequest.status eq 18}">
             <!--withdraw reject popup-->
            <div class="modal fade" id="withdrawrejectRemark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                 <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                            <h4 class="modal-title" id="myModalLabel">Withdraw Request Reject Remark</h4>
                        </div>
                        <form onsubmit="return withdrawrejectSubmit();"
                              action="poolCarRequest.htm?act=approverwithdraw&id=${poolCarRequest.id}&statusType=13" commandName="poolCarRequest"
                              method="post"  name='form4' id ="form4" class="form-horizontal" role="form">
                            
                            <div class="modal-body">
                                <div class="control-group">
                                    <label for="inputPassword" class="col-sm-1 control-label">
                                        Remark<font style="color: red;font-size: 16px;">*</font>
                                    </label>
                                    <div class="controls">
                                        <textarea name="rejectRemark" id="Remark3" class="form-control span5"></textarea>
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
                              action="poolCarRequest.htm?act=approverwithdraw&id=${poolCarRequest.id}&statusType=16"
                              method="post"  name='form5' id ="form5" class="form-horizontal" role="form">
                            <div class="modal-body">
                                <div class="control-group">
                                    <label for="inputPassword" class="col-sm-1 control-label">
                                        Remark<font style="color: red;font-size: 16px;">*</font>
                                    </label>
                                    <div class="controls">
                                         <textarea name="rejectRemark" id="Remark2" class="form-control span5"></textarea>
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
            $('#withdrawreturnRemark').modal('hide');
            $('#rejectRemark').modal('hide');
            $('#withdrawrejectRemark').modal('hide');
//            function remarkClick(id) {
//                $('#' + id).modal('show');
//            }
            function returnSubmit() {
                var flag = true;
                var rejectRemark = document.getElementById('Remark0').value;
                if ('' === rejectRemark) {
                    flag = false;
                    document.getElementById('errorRemark0').innerHTML = 'Please Enter Remark.';
                }
                return flag;
            }
            function rejectSubmit() {
                var flag = true;
                var rejectRemark = document.getElementById('Remark1').value;
                if ('' === rejectRemark) {
                    flag = false;
                    document.getElementById('errorRemark1').innerHTML = 'Please Enter Remark.';
                }
                return flag;
            }
            function withdrawreturnSubmit() {
                var flag = true;
                var rejectRemark = document.getElementById('Remark2').value;
                if ('' === rejectRemark) {
                    flag = false;
                    document.getElementById('errorRemark2').innerHTML = 'Please Enter Remark.';
                }
                return flag;
            }

            function withdrawrejectSubmit() {
                var flag = true;
                var rejectRemark = document.getElementById('Remark3').value;
                if ('' === rejectRemark) {
                    flag = false;
                    document.getElementById('errorRemark3').innerHTML = 'Please Enter Remark.';
                }
                return flag;
            }

        </script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

