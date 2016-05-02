<%-- 
    Document   : EmpView
    Created on : Nov 19, 2015, 6:04:13 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
          <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View HR Service Request</title>
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
  </script>
    </head>
    <body>
              <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>HR Service Request: </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">HR Service Request</li>
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
            <form:form action="hrServiceRequest.htm?act=returnCreateSubmit&id=${hrServiceRequest.id}" method="post" commandName="hrServiceRequest"
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
                                        <h3 class="box-title">Query Type And It's Description:</h3>
                                        <div class="box-tools pull-right">
                                            <span id="spanId2">Expand</span><button class="btn btn-box-tool" data-widget="collapse" onclick="buttonFun2();"><i class="fa fa-plus" id="minusId2" ></i></button>
                                        </div>
                                    </div><!-- /.box-header -->
                                    <div class="box-body no-padding">
                                        <section class="content">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12">
                                                  <div class="form-group">
                                                      <label class="col-sm-3 control-label">Query Related To:</label>
                                                    <div class="col-sm-7">
                                                  <form:select path="queryType" id="queryType" class="form-control">
                                                         <form:option value="${hrServiceRequest.queryType.id}">${hrServiceRequest.queryType.text}</form:option>
                                                      <c:forEach var="map" items="${querytypeMap}">
                                                        <form:option value="${map.key}">${map.value}</form:option>
                                                        </c:forEach>
                                               </form:select>  
                                                    <form:errors path="queryType" cssClass="errorDiv"></form:errors>
                                                  </div>
                                                 </div>
                                                 <div class="form-group">
                                                      <label class="col-sm-3 control-label">Details:</label>
                                                    <div class="col-sm-7">
                                                 <form:textarea path="details"  class="form-control" size="16" type="text" rows="6" value="" ></form:textarea>
                                                        </div>
                                                  </div>
                                                  </div>
                                                  </div>
                                              </section>
                                         </div>
                                     </div>
                 <c:if test="${hrServiceRequest.status eq 4 || hrServiceRequest.status eq 9}">
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
                                                        <form:textarea path="rejectRemark"  class="form-control" size="16" type="text" rows="6" value="" readonly="true"></form:textarea>
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
<!--          <div class="form-group">
                <div class="col-sm-offset-3 col-sm-4">
                   <%--<c:if test="${hrServiceRequest.status eq 4}">--%>
                        &nbsp;&nbsp;<button type="submit" class="btn btn-primary" id="saveSubmit1" >Submit</button>
                    <%--</c:if>--%>  
                    <%--<c:if test="${hrServiceRequest.status eq 1 || hrServiceRequest.status eq 2}">--%>
                        <button type="submit"  class="btn btn-warning" value="Withdraw">Withdraw</button>
                    <%--</c:if>--%>
                  <%--<c:if test="${hrServiceRequest.status eq 9}">--%>
                &nbsp;&nbsp;<button type="submit"  class="btn btn-primary" id="saveSubmit1" value="Submit">Submit</button>
                <%--</c:if>--%>
                </div>
                </div>-->
          </form:form>
            </div>
        </div><!-- nav-tabs-custom -->
                   </div>
                 </div>
                 </section>
               </div>
          <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    </body>
</html>
