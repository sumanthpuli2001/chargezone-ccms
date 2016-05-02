<%-- 
    Document   : GatePassSecurityView
    Created on : Nov 25, 2015, 2:54:24 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
         <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gate Pass Security View</title>
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
         function securityapprove(id) {
                window.location = "gatePass.htm?act=securityAprroveClick&id=" + id;
            }
              function withdrawapprove(id) {
                window.location = "gatePass.htm?act=adminAprrovewithdrawClick&id=" + id;
            }
     </script>
    </head>
    <body>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Gate Pass </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Gate Pass</li>
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
                            <form:form action="" method="post" commandName="gatePass"
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
                 <h3 class="box-title">Gate Pass Type:</h3>
                        <div class="box-tools pull-right">
                          <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                        </div>
                     </div><!-- /.box-header -->
                     <div class="box-body no-padding">
                        <section>
                            <div class="row">
                              <div class="col-md-12 col-sm-12">
                                <div class="form-group">   
                                      <label class="col-sm-4 control-label">Returnable/Non-Returnable Gate Pass:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                             <c:if test="${gatePass.gatePassType eq true}">
                                                    <input name="Returnable Gate Pass" class="form-control " readonly="true" value="Returnable Gate Pass"/>
                                             </c:if>
                                             <c:if test="${gatePass.gatePassType eq false}">
                                                    <input name="Non-Returnable Gate Pass" class="form-control " readonly="true" value="Non-Returnable Gate Pass"/>
                                             </c:if>
                                </div>
                              </div>
                              </div>
                              </div>
                         </section>
                     </div>
             </div>
           <div class="box box-info collapsed-box">
              <div class="box-header">
                 <h3 class="box-title">Material For Delivery(Asset) Detail:</h3>
                        <div class="box-tools pull-right">
                          <span id="spanId3">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun3();"><i class="fa fa-plus" id="minusId3" ></i></button>
                        </div>
                     </div><!-- /.box-header -->
                     <div class="box-body no-padding">
                        <section class="content">
                            <div class="row">
                              <div class="col-md-12 col-sm-12">
                                <div class="form-group">   
                                             <label class="col-sm-4 control-label">Asset Description:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                <form:input path="assetDescription" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                             </div>       
                                              </div>
                                             <div class="form-group"> 
                                            <label class="col-sm-4 control-label">Asset Value (INR):<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                <form:input path="assetValue" class="form-control" size="16" type="number" min="0"  value="" readonly="true" ></form:input>
                                             </div>                                  
                                </div>
                                <div class="form-group">   
                                     <label class="col-sm-4 control-label">Asset Identity No.:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                <form:input path="assetIdentityNo" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                             </div>                                  
                                              </div>                                  
                                                <div class="form-group">   
                                                <label class="col-sm-4 control-label">Destination where material is to be taken:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                <form:input path="destination" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                             </div>                                  
                                </div>
                                <div class="form-group">   
                                    <label class="col-sm-4 control-label">Name of the person carrying the material:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                <form:input path="materialCarryingPersonName" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                             </div>   
                                             </div>                                  
                                             <div class="form-group">   
                                                <label class="col-sm-4 control-label">Contact no. of the person carrying the material:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                <form:input path="materialCarryingPersonCntctNo" class="form-control" size="16" type="number" min="0"  value="" readonly="true" ></form:input>
                                                <!--pattern="/^\d{10}$/"-->
                                             </div>                                  
                                </div>
                                <div class="form-group">   
                                       <div class="form-group">   
                                            <label class="col-sm-4 control-label">Name of the person to whom the material is taken:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                <form:input path="materialTakenToPersonName" class="form-control" size="16" type="text" value="" readonly="true" ></form:input>
                                             </div>                                  
                                             </div>                                  
                                            <div class="form-group">   
                                             <label class="col-sm-4 control-label">Contact no. of the person to whom the material is  taken:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div>
                                                        <label class="col-lg-1 ">Landline No.: </label>
                                                        <div class="col-lg-2">
                                                <form:input path="materialTakenToPersonLandlineNo" class="form-control" size="16" type="text" value="" readonly="true" ></form:input>
                                                        </div>  
                                                    </div>
                                                           <div>
                                                        <label class="col-lg-1">Mobile No.:</label>
                                                        <div class="col-lg-2">
                                                           <form:input path="materialTakenToPersonMobileNo" class="form-control" size="16"  type="number" min="0" value="" readonly="true" ></form:input>
                                                        </div>  
                                                    </div> 
                                             </div>   
                                               <div class="form-group">   
                                             <label class="col-sm-4 control-label">Material out Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                             <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii" data-link-field="dtp_input1">
                                            <form:input path="materialOutDateTime" class="form-control" size="16" type="text" value=""  readonly="true"></form:input>
                                            <form:errors path="materialOutDateTime" cssClass="errorDiv"></form:errors>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                             </div>  
                                             </div>  
                                            <c:if test="${gatePass.gatePassType eq true}">
                                        <div class="form-group" id="expextedDateOfReturnDiv" >        
                                             <label class="col-sm-4 control-label">Expected Date & Time Of Return:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                            <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                            <form:input path="expectedReturnDateTime" class="form-control" size="16" type="text" value="" readonly="true"></form:input>
                                            <form:errors path="expectedReturnDateTime" cssClass="errorDiv"></form:errors>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                             </div>  
                                        </div> 
                                                </c:if>     
                                </div>
                              </div>
                         </section>
                     </div>
             </div>
    <div class="box box-info collapsed-box">
                   <div class="box-header">
                                        <h3 class="box-title">Reason In Detail:</h3>
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
                                                    <label class="col-sm-4 control-label">Reason for Request:</label>
                                                    <div class="col-sm-7">         
                                            <form:textarea path="reason" rows="6" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
                                            </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                </div>
                          </section>
                </div> 
           </div>
  <c:if test="${gatePass.securityRemark ne null}">
<c:if test="${gatePass.status eq 9 || gatePass.status eq 19}">
       <div class="box box-info collapsed-box">
                   <div class="box-header">
                                        <h3 class="box-title">Request Return Reason:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId5">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun5();"><i class="fa fa-plus" id="minusId5" ></i></button>
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
                                                   <label class="col-sm-4 control-label">Reason:</label>
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
     </c:if>                  
                    <div class="form-group">
                       <div class="col-sm-offset-5 col-sm-4">
                        <c:if test="${gatePass.status ne 12}">
                        <c:if test="${gatePass.status ne 19}">
                            &nbsp;&nbsp;<button type="button" class="btn btn-primary" style="width: 150px !important;" onclick="securityapprove(${gatePass.id},4);">EXIT CONFIRMED</button>
<!--                            &nbsp;&nbsp;<button type="button" class="btn btn-danger" style="width: 100px;margin-left: 370px" data-toggle="modal" data-target="#rejectRemark"  onclick="rejectClick('rejectRemark')">Reject</button>
                            &nbsp;&nbsp;<button type="button" class="btn btn-warning" style="width: 100px;margin-left: 370px" data-toggle="modal" data-target="#returnRemark" onclick="remarkClick('returnRemark')">Return</button>-->
                </c:if></c:if>
           <c:if test="${gatePass.status eq 12 || gatePass.status eq 19}">
                    <!--&nbsp;&nbsp;<button type="button" class="btn btn-primary" style="width: 100px;margin-left: 10px" onclick="withdrawapprove(${gatePass.id},14);">Approve </button>-->
<!--                    &nbsp;&nbsp;<button type="button" class="btn btn-danger" style="width: 100px;margin-left: 370px" data-toggle="modal" data-target="#withdrawrejectRemark" >Reject </button>
                    &nbsp;&nbsp;<button type="button" class="btn btn-warning" style="width: 100px;margin-left: 370px" data-toggle="modal" data-target="#withdrawreturnRemark">Return </button>-->
                </c:if>     
                    </div>
                   </div>
            </div>
                </div>
            </form:form>
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
                              action="gatePass.htm?act=securityAprroveClick&id=${gatePass.id}&statusType=5" commandName="gatePass"
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
                              action="gatePass.htm?act=securityAprroveClick&id=${gatePass.id}&statusType=7" commandName="gatePass"
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
                              
  <c:if test="${gatePass.status eq 12 || gatePass.status eq 19}">
             <!--withdraw reject popup-->
            <div class="modal fade" id="withdrawrejectRemark" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                 <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only"></span></button>
                            <h4 class="modal-title" id="myModalLabel">Withdraw Request Reject Remark</h4>
                        </div>
                        <form onsubmit="return withdrawrejectSubmit();"
                              action="gatePass.htm?act=adminAprrovewithdrawClick&id=${gatePass.id}&statusType=15" commandName="gatePass"
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
                              action="gatePass.htm?act=adminAprrovewithdrawClick&id=${gatePass.id}&statusType=17"
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
