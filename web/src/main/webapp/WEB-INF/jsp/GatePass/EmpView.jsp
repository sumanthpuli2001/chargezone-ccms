<%-- 
    Document   : EmpView
    Created on : Nov 25, 2015, 4:26:59 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
          <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Gate Pass Request</title>
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
                            <form:form action="gatePass.htm?act=returnCreateSubmit&id=${gatePass.id}" method="post" commandName="gatePass"
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
                                             <form:select path="gatePassType" onchange="selectClick(this.value);" class="form-control ">
                                                 <c:if test="${gatePass.gatePassType eq true}">
                                                 <form:option value="1">Returnable Gate Pass</form:option>  
                                                 </c:if>  
                                                 <c:if test="${gatePass.gatePassType eq false}">
                                                 <form:option value="0">Non-Returnable Gate Pass</form:option>  
                                                 </c:if>
                                                 <form:option value="1">Returnable Gate Pass</form:option>
                                                 <form:option value="0">Non-Returnable Gate Pass</form:option>
                                                 </form:select>
                                             <%--<c:if test="${gatePass.gatePassType eq true}">--%>
                                                    <!--<input name="Returnable Gate Pass" class="form-control " readonly="true" value="Returnable Gate Pass"/>-->
                                             <%--</c:if>--%>
                                             <%--<c:if test="${gatePass.gatePassType eq false}">--%>
                                                    <!--<input name="Non-Returnable Gate Pass" class="form-control " readonly="true" value="Non-Returnable Gate Pass"/>-->
                                             <%--</c:if>--%>
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
                                    <form:input path="assetDescription" class="form-control" size="16" type="text" value=""></form:input>
                                             </div>                                  
                                            </div>
                                             <div class="form-group"> 
                                            <label class="col-sm-4 control-label">Asset Value (INR):<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                <form:input path="assetValue" class="form-control" size="16" type="number" min="0"  value="" ></form:input>
                                             </div>                                  
                                         </div>
                                <div class="form-group">   
                                     <label class="col-sm-4 control-label">Asset Identity No.:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                <form:input path="assetIdentityNo" class="form-control" size="16" type="text" value=""></form:input>
                                             </div>           
                                              </div>                                  
                                                <div class="form-group">   
                                                <label class="col-sm-4 control-label">Destination where material is to be taken:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                <form:input path="destination" class="form-control" size="16" type="text" value="" ></form:input>
                                             </div>                                  
                                </div>
                                <div class="form-group">   
                                    <label class="col-sm-4 control-label">Name of the person carrying the material:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                <form:input path="materialCarryingPersonName" class="form-control" size="16" type="text" value=""></form:input>
                                             </div>                                  
                                             </div>     
                                              <div class="form-group">  
                                    <label class="col-sm-4 control-label">Contact no. of the person carrying the material:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                <form:input path="materialCarryingPersonCntctNo" class="form-control" size="16" type="number" min="0"  value=""></form:input>
                                                <!--pattern="/^\d{10}$/"-->
                                             </div>                                  
                                </div>
                                <div class="form-group">   
                                     <label class="col-sm-4 control-label">Name of the person to whom the material is taken:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                <form:input path="materialTakenToPersonName" class="form-control" size="16" type="text" value="" ></form:input>
                                             </div>                                  
                                             </div>  
                                              <div class="form-group">   
                                             <label class="col-sm-4 control-label">Contact no. of the person to whom the material is  taken:<span style="color: red;font-size: 12px;">*</span></label>
                                                   <div>
                                                        <label class="col-lg-1 ">Landline No.: </label>
                                                        <div class="col-lg-2">
                                                           <form:input path="materialTakenToPersonLandlineNo" class="form-control" size="16" type="text" value="" ></form:input>
                                                        </div>  
                                                    </div>
                                                    <div>
                                                        <label class="col-lg-1">Mobile No.:</label>
                                                        <div class="col-lg-2">
                                                             <form:input path="materialTakenToPersonMobileNo" class="form-control" size="16"  type="number" min="0" value="" ></form:input>
                                                        </div>  
                                                    </div> 
                                                </div>
                                              <div class="form-group">   
                                                   <label class="col-sm-4 control-label">Material out Date & Time:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                                  <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii" data-link-field="dtp_input1">
                                            <form:input path="materialOutDateTime" class="form-control" size="16" type="text" value=""></form:input>
                                            <form:errors path="materialOutDateTime" cssClass="errorDiv"></form:errors>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                             </div>  
                                             </div>  
                                            <%--<c:if test="${gatePass.gatePassType eq true}">--%>
                                        <div class="form-group" id="expextedDateOfReturnDiv" >        
                                                 <label class="col-sm-4 control-label">Expected Date & Time Of Return:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="col-sm-7">
                                              <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy hh:ii " data-link-field="dtp_input1">
                                            <form:input path="expectedReturnDateTime" class="form-control" size="16" type="text" value="" ></form:input>
                                            <form:errors path="expectedReturnDateTime" cssClass="errorDiv"></form:errors>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                            </div>
                                             </div>  
                                        </div> 
                                 <%--</c:if>--%>     
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
                                                <form:textarea path="reason" rows="6" class="form-control" size="16" type="text" value="" ></form:textarea>
                                            </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                </div> 
           </div>
 <c:if test="${gatePass.status eq 6 || gatePass.status eq 16}">
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
                                                <form:textarea path="rejectRemark" rows="6" class="form-control" size="16" type="text" value="" readonly="true"></form:textarea>
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
                        <c:if test="${gatePass.status eq 6}">
                            <div class="col-sm-6" style="text-align: left">
                            &nbsp;&nbsp;<button type="submit" class="btn btn-primary" id="saveSubmit1" name="btnType" value="Submit">SUBMIT</button>
                            </div>
                            <div class="col-sm-6" style="text-align: right">
                         <button type="submit" class="btn btn-warning" name="btnType" value="Withdraw">WITHDRAW</button>
                         </div>
                        </c:if>
                       <div class="col-sm-offset-5 col-sm-4">
                        <c:if test="${gatePass.status eq 16}">
                         &nbsp;&nbsp; <button type="submit" class="btn btn-primary" id="saveSubmit1" name="btnType" value="Submit">SUBMIT</button>
               </c:if>
                        <c:if test="${gatePass.status eq 1|| gatePass.status eq 2|| gatePass.status eq 8}">
                         <button type="submit" class="btn btn-warning"name="btnType" value="Withdraw">WITHDRAW</button>
                         </c:if>
                       </div>
                   </div>
            </form:form>
            </div>
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
               if ('1' === val) {
                   document.getElementById('expextedDateOfReturnDiv').style.display = 'block';
                }
               else if ('Returnable Gate Pass' === val) {
                   document.getElementById('expextedDateOfReturnDiv').style.display = 'block';
                }
                else {
                   document.getElementById('expextedDateOfReturnDiv').style.display = 'none';
                }
        }
        $(document).ready(function () {
             var e = document.getElementById("gatePassType");
                var value = e.options[e.selectedIndex].value;
                selectClick(value);
        });
    </script>           
   <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
