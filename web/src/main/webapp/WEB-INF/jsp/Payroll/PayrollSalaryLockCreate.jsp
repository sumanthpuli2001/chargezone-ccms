<%-- 
    Document   : LocationCreate
    Created on : Oct 20, 2015, 12:46:23 PM
    Author     : Irfan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salary Lock </title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Salary Lock:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Salary Lock</li>
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
                                           modelAttribute="payrollSalaryLock" action="payrollSalaryLock.htm?act=createSubmit">
                                    <form:hidden path="id"></form:hidden>

                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                 <label class="control-label">Month:<span style="color: red;font-size: 12px;">*</span></label>
                                                 <form:select path="pmonth" id="pmonth" class="form-control ">
                                                        <form:option value="">--Select--</form:option>
                                                        <form:option value="01">January</form:option>
                                                        <form:option value="02">February</form:option>
                                                        <form:option value="03">March </form:option>
                                                        <form:option value="04">April</form:option>
                                                        <form:option value="05">May</form:option>
                                                        <form:option value="06">June</form:option>
                                                        <form:option value="07">July</form:option>
                                                        <form:option value="08">August</form:option>
                                                        <form:option value="09">September</form:option>
                                                        <form:option value="10">October </form:option>
                                                        <form:option value="11">November </form:option>
                                                        <form:option value="12">December</form:option>

                                                    </form:select>
                                            <form:errors path="pmonth" cssClass="errorDiv"/>
                                        </div>
                                           
                                            <div class="col-sm-6">
                                                     <label class="control-label">Year:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="pyear"  id="pyear" name="pyear" class="form-control ">

                                                    </form:select>
                                                </div>
                                        
                                        <div class="col-sm-6 col-sm-offset-5" style="margin-top: 20px;">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="LOCK">
                                        </div>
                                        <!--                                        <div class=" col-sm-offset-2 col-sm-3 ">
                                                                                    <button type="button" class="btn btn-danger" data-original-title="" title="" onclick="window.location = 'departmentMaster.htm?act=showList'">Cancel</button>
                                                                                </div>-->
                                </form:form>
                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
      <script type="text/javascript">
        window.onload = init;
        function init() {
            document.form1.month.options[new Date().getMonth()].selected = true;
        }
        var start = 1990;
        var end = new Date().getFullYear();
        var options11 = "";

        for (var year1 = end; year1 >= start; year1--) {
            options11 += "<option>" + year1 + "</option>";
        }
        document.getElementById('pyear').innerHTML = options11;
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>