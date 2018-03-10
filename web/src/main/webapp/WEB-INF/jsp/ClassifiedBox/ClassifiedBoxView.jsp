<%--
    Document   : PayrollProfessionalTaxView
    Created on : Jul 13, 2016, 4:24:25 PM
    Author     : AJAY <ajay@bulwarks.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Classified Edit</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Edit Classified : </h1>
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
                                           commandName="classifiedBox" action="classifiedBox.htm?act=editSubmit">
                                    <form:hidden path="id"></form:hidden>
<!--                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Location:<span style="color: red;font-size: 12px;">*</span></label>
                                            <%--<form:select path="zydexLocationMaster.id" class="form-control ">--%>
                                                <%--<form:option value="" label="-- Select --" ></form:option>--%>
                                                <%--<form:options items="${deptMap}"></form:options>--%>
                                            <%--</form:select>--%>
                                            <%--<form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>--%>
                                            </div>
                                        </div>-->
                                         <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Advertisement Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="advertisementName"  placeholder="Enter Advertisement Name" class="form-control"></form:input>
                                                <form:errors path="advertisementName" cssClass="errorDiv"></form:errors>
                                                </div>
                                            <div class="col-sm-6">
                                                <label>Description:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="description"   placeholder="Enter Description"  class="form-control"></form:input>
                                            <form:errors path="description" cssClass="errorDiv"></form:errors>
                                            
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6 col-sm-offset-5">
                                                <input type="submit" class="btn btn-primary" style="width: 100px;" title="" value="SUBMIT">
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script type="text/javascript">
            function pepe() {
                var flag = true;
              var salaryFrom = document.getElementById("salaryFrom").value;
              var salaryTo = document.getElementById("salaryTo").value;
              if(salaryFrom !='' && salaryTo !=''){
                  salaryFrom = parseFloat(salaryFrom);
                  salaryTo = parseFloat(salaryTo);
                  if(salaryTo<salaryFrom){
                alert(" Salary To is Greater than Salary From.!!");
                flag = false;
                  }
               
              }
              return flag;
            }
        </script>   
</html>