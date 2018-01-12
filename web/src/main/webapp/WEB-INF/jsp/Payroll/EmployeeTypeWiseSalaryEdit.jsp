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
        <title>Assign Salary Edit</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Edit Assign Salary:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit</li>
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
                                           commandName="employeeTypeWiseSalary" action="employeeTypeWiseSalary.htm?act=editSubmit">
                                    <form:hidden path="id"></form:hidden>
                                        <div class="form-group" style="pointer-events: none">
                                            <div class="col-sm-6">
                                                <label>Location:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="zydexLocationMaster.id" class="form-control ">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:options items="${deptMap}"></form:options>
                                            </form:select>
                                            <form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <input type="hidden" name="typeOfEmployee" id="typeOfEmployee" value="${employeeTypeMaster.typeOfEmployee}">
                                    <div class="form-group"  style="pointer-events: none">
                                        <div class="col-sm-6">
                                            <label>Type of Employee :<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="employeeTypeMaster.id" id="employeeTypeMaster.id" onchange="selectsubtype(this.value);" class="form-control">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:options items="${EmployeeTypeList}"></form:options>
                                            </form:select>
                                            <form:errors path="employeeTypeMaster.id" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group"  style="pointer-events: none">
                                            <div class="col-sm-6" id="employeeSubTypeId">
                                                <label>Employee SubType:<span style="color: red;font-size: 12px;">*</span></label>
                                                <input type="hidden" name="subTypeId" id="subTypeId" value="${employeeMaster.employeeSubType.id}">
                                            <form:select path="employeeSubType.id" class="form-control">
                                                <form:option value="" label="-- Select --" ></form:option> 
                                                <form:options items="${EmployeeSubTypeList}"></form:options>
                                            </form:select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label>Salary Type:<span style="color: red;font-size: 12px;">*</span></label>

                                            &nbsp;&nbsp;&nbsp;
                                            <Br>
                                            <c:forEach var="salaryType" items="${PayrollSalaryTypeList}">
                                                <%--<c:forEach var="l" items="${list}">--%>
                                                <%--<c:choose>--%>
                                                <c:if test="${fn:contains(list, salaryType.key)}">
                                                    <input type="checkbox"  name="payrollSalaryType" id="payrollSalaryType" checked="true" value="${salaryType.key}">${salaryType.value}
                                                </c:if>
                                                <c:if test="${!fn:contains(list, salaryType.key)}">
                                                    <input type="checkbox"  name="payrollSalaryType" id="payrollSalaryType" value="${salaryType.key}">${salaryType.value}
                                                </c:if>
                                              
                                                <%--</c:choose>--%>
                                                <%--</c:forEach>--%>
                                            </c:forEach>



                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT" onclick="return checkBox();">
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

            var employeeId = document.getElementById("id").value;

            //            document.getElementById('EmployeeId').innerHTML = "Fetching ... .. .";
            $.post("employeeTypeWiseSalary.htm?act=readEmpTypeAjax",
                    {
                        typeId: typeId,
                        employeeId: employeeId
                    }, function (responseTxt, statusTxt, xhr) {
                if (statusTxt === "success") {
                    ("responseTxt" + responseTxt);
                    document.getElementById('employeeSubTypeId').innerHTML = responseTxt;
                }
                if (statusTxt === "error")
                    ("Error: " + xhr.status + ": " + xhr.statusText);
            });
        }


        $(document).ready(function () {
            var empTypeId = document.getElementById("employeeTypeMaster.id").value;

            selectsubtype(empTypeId);

        });

    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
      <script>
      function checkBox() {
            var checkboxes = "";
             var checkboxes = "";
            checkboxes = document.getElementsByName('payrollSalaryType');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                if (checkboxes[i].checked) {
                    return true;
                }
            }
            alert("Please, Select Salary Type one or more record(s).");
            return false;
     }
         </script>
</html>
