<%-- 
    Document   : ViewCafeRequest
    Created on : Nov 5, 2015, 11:16:28 AM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cafe Request </title>
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
         function approve(id) {
                window.location = "cafeteriaRequest.htm?act=aprroveClick&id=" + id;
            }
            function approvereturn(id) {
                window.location = "cafeteriaRequest.htm?act=aprroveReturnClick&id=" + id;
            }
             function withdrawapprove(id) {
                window.location = "cafeteriaRequest.htm?act=approverwithdraw&id=" + id;
            }
            function withdrawapprovereturn(id) {
                window.location = "cafeteriaRequest.htm?act=withdrawapprovereturn&id=" + id;
            }
</script>
    </head>
    <body>
          <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>CAFETERIA REQUEST </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Cafeteria Request</li>
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
                                <form:form action="cafeteriaRequest.htm?act=createSubmit" method="post" commandName="cafeteriaRequest"
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
                        <h3 class="box-title">Cafeteria Detail:</h3>
                          <div class="box-tools pull-right">
                             <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                        </div>
                    </div><!-- /.box-header -->
                    <div class="box-body no-padding">
                        <section class="content">
                            <div class="row">
                                <div class="col-md-12">
                                    <!-- Custom Tabs -->
                                    <div class="nav-tabs-custom">
                                        <div class="tab-content">
                            <div class="form-group">
                                  <label class="col-sm-3 control-label">Cafeteria Request:</label>
                                                    <div class="col-sm-7">
                                <form:input path="requestType"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                            </div>
                            </div>
                             <div class="form-group">
                                  <label class="col-sm-3 control-label">No. Of Employees / Visitors:</label>
                                  <div class="col-sm-7">
                                    <form:input path="requestFor"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                  </div>
                            </div>
                            <div class="form-group">
                                  <label class="col-sm-3 control-label">Venue:</label>
                                                    <div class="col-sm-7">
                                <form:input path="venue"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                            </div>
                            </div>
                             <div class="form-group">
                                  <label class="col-sm-3 control-label">Order Date & Time:</label>
                                   <div class="col-sm-7">
                                        <form:input path="orderDateTime"  class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                   </div>
                             </div>
                                <c:if test="${cafeteriaRequest.requestType eq 'SpecialMeal'}">
                             <div class="form-group">
                                   <label class="col-sm-3 control-label">Special Meal Specify Here:</label>
                                   <div class="col-sm-7">
                                      <form:textarea path="specialMeal" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                 
                                </div>   
                           </div></c:if>
                                        </div>
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
                                             <label class="col-sm-3 control-label">Reason for Request:</label>
                                                    <div class="col-sm-7">
                                                        <form:textarea path="reason" rows="6" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                        <form:errors path="reason" cssClass="errorDiv"></form:errors>
                                            </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </div>
                          </section>
                </div> 
           </div>
    <c:if test="${cafeteriaRequest.status eq 7 || cafeteriaRequest.status eq 8 || cafeteriaRequest.status eq 17 || cafeteriaRequest.status eq 18}" >                              
                <div class="box box-info collapsed-box">
                    <div class="box-header">
                        <h3 class="box-title">Cafeteria Request Return Reason:</h3>
                          <div class="box-tools pull-right">
                             <span id="spanId4">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun4();"><i class="fa fa-plus" id="minusId4" ></i></button>
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
                                                    <c:if test="${cafeteriaRequest.status eq 8 || cafeteriaRequest.status eq 18}">
                                                    <form:textarea path="rejectRemark" rows="6"  class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                                    </c:if>    
                                                    <c:if test="${cafeteriaRequest.status eq 7 || cafeteriaRequest.status eq 17}">
                                                    <form:textarea path="adminRemark" rows="6" class="form-control" size="16" type="text" value="adminRemark" readonly="true"></form:textarea>
                                                    </c:if>    
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
              <div class="col-sm-offset-3 col-sm-4">
                   <c:if test="${cafeteriaRequest.status ne 18}">
                <c:if test="${cafeteriaRequest.status ne 17}">
              <c:if test="${cafeteriaRequest.status ne 10}">
                  <c:if test="${cafeteriaRequest.status eq 8 || cafeteriaRequest.status eq 7}">
                &nbsp;&nbsp;<button type="button" class="btn btn-primary" onclick="approvereturn(${cafeteriaRequest.id});">Approve</button>
               </c:if>
                   <c:if test="${cafeteriaRequest.status ne 8}">
                   <c:if test="${cafeteriaRequest.status ne 7}">
                   <button type="button" class="btn btn-primary" onclick="approve(${cafeteriaRequest.id},2);">Approve</button>
                </c:if>
                </c:if>
                   &nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#rejectRemark"  onclick="rejectClick('rejectRemark')">Reject</button>
                &nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#returnRemark" onclick="remarkClick('returnRemark')">Return</button>
                </c:if> 
                </c:if> 
                </c:if> 
                 <c:if test="${cafeteriaRequest.status eq 17 || cafeteriaRequest.status eq 18}">
                &nbsp;&nbsp;<button type="button" class="btn btn-primary" onclick="withdrawapprovereturn(${cafeteriaRequest.id});">Approve </button>
                    &nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#withdrawrejectRemark" >Reject </button>
                &nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#withdrawreturnRemark">Return </button>
                    
                </c:if>
                <c:if test="${cafeteriaRequest.status eq 10}">
                &nbsp;&nbsp;<button type="button" class="btn btn-primary" onclick="withdrawapprove(${cafeteriaRequest.id},12);">Approve </button>
                &nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#withdrawrejectRemark" >Reject </button>
                &nbsp;&nbsp;<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#withdrawreturnRemark">Return </button>
                </c:if>
                
                </div>
           </div>
          </form:form>
                 </div><!-- nav-tabs-custom -->
                   </div>
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
                              action="cafeteriaRequest.htm?act=aprroveClick&id=${cafeteriaRequest.id}&statusType=3" commandName="cafeteriaRequest"
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
                              action="cafeteriaRequest.htm?act=aprroveClick&id=${cafeteriaRequest.id}&statusType=6"
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
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button id="close" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button id="Save1" type="submit" class="btn btn-primary" >Return</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
                             
 <c:if test="${cafeteriaRequest.status eq 10 || cafeteriaRequest.status eq 17}">
   <!--withdraw reject popup-->
            <div class="modal fade" id="withdrawrejectRemark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                 <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                            <h4 class="modal-title" id="myModalLabel">Withdraw Request Reject Remark</h4>
                        </div>
                        <form onsubmit="return withdrawrejectSubmit();"
                              action="cafeteriaRequest.htm?act=approverwithdraw&id=${cafeteriaRequest.id}&statusType=13" commandName="cafeteriaRequest"
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
                              action="cafeteriaRequest.htm?act=approverwithdraw&id=${cafeteriaRequest.id}&statusType=16"
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
  <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
  <script>
        $('#approveRemark').modal('hide');
           $('#returnRemark').modal('hide');
            $('#withdrawreturnRemark').modal('hide');
            $('#rejectRemark').modal('hide');
            $('#withdrawrejectRemark').modal('hide');
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
    </body>
</html>
