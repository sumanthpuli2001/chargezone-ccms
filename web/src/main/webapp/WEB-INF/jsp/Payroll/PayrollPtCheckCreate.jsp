<%--
    Document   : PayrollTaxRuleCreate
    Created on : Jul 14, 2016, 4:39:27 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PT Create</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>ADD NEW PT CHECK</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form class="form-horizontal" method="post"
                                           commandName="payrollPtCheck" action="payrollPtCheck.htm?act=createSubmit">
                                     <input type="hidden" name="typeOfEmployee" id="typeOfEmployee" value="${employeeTypeMaster.typeOfEmployee}">
                                            <div class="form-group">
                                                    <div class="col-sm-6">
                                                         <label>Type of Employee :<span style="color: red;font-size: 12px;">*</span></label>
                                                         <form:select path="employeeTypeMaster.id" id="employeeTypeMaster.id" onchange="selectsubtype(this.value);" class="form-control">
                                                         <form:option value="" label="-- Select --" ></form:option>
                                                         <form:options items="${EmployeeTypeList}"></form:options>
                                                         </form:select>
                                                         
                                                         <form:errors path="employeeTypeMaster.id" cssClass="errorDiv"></form:errors>
                                                       </div>
                                                     </div>
                                            <div class="form-group">
                                                    <div class="col-sm-6" id="employeeSubTypeId">
                                                        <label>Employee SubType:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <input type="hidden" name="subTypeId" id="subTypeId" value="${employeeMaster.employeeSubType.id}">
                                                        <form:select path="employeeSubType.id" class="form-control">
                                                        <form:option value="" label="-- Select --" ></form:option> 
                                                        </form:select>
                                                        </div>
                                                         </div>
                                                      <div class="form-group">
                                                          <div class="col-sm-6">
                                                              <form:errors path="employeeSubType.id" cssClass="errorDiv"></form:errors>
                                                          </div>
                                                      </div>
                                                          
                                            <div class="form-group">
                                                       <div class="col-sm-6">
                                                       <label>PT Applicable:<span style="color: red;font-size: 12px;">*</span></label>&nbsp;&nbsp;
                                                        <%--<form:select path="gender" id="gender" class="form-control">--%>
                                                        <fieldset id="group1">
                                                        <form:radiobutton path="ptCheck" value="false"/>NO&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        <form:radiobutton path="ptCheck" value="true"/>YES
                                                        </fieldset>
                                                        <form:errors path="ptCheck" cssClass="errorDiv"></form:errors>
                                                        </div>
                                                     </div>
                                           <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                            </div>
                                         </div>
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
   <script>
        function selectsubtype(typeId) {
         
            var empSubTypeId = document.getElementById("subTypeId").value;
//            document.getElementById('EmployeeId').innerHTML = "Fetching ... .. .";
            $.post("employeeMaster.htm?act=readEmpTypeAjax",
                    {
                        typeId: typeId,
                        empSubTypeId: empSubTypeId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt"+responseTxt);
                    document.getElementById('employeeSubTypeId').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }
        
         $( document ).ready(function() {
            var empTypeId = document.getElementById("employeeTypeMaster.id").value;
            selectsubtype(empTypeId);
            
});

    </script>
   
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
