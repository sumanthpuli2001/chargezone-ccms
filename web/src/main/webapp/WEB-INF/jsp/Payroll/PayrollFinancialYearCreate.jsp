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
        <title>Financial Year</title>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>ADD NEW FINANCIAL YEAR</h1>
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
                                           commandName="payrollFinancialYear" action="payrollFinancialYear.htm?act=createSubmit">
                                    <div class="form-group">
                                        <div class="col-sm-6">
                                            <label>Location:<span style="color: red;font-size: 12px;">*</span></label>
                                            <form:select path="zydexLocationMaster.id" class="form-control ">
                                                <form:option value="" label="-- Select --" ></form:option>
                                                <form:options items="${deptMap}"></form:options>
                                            </form:select>
                                            <form:errors path="zydexLocationMaster.id" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <label>Start Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                                <form:input path="startDate" class="form-control" onchange="dateDifference(this.value);" placeholder="Enter Start Date"></form:input>
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                </div>
                                                <form:errors path="startDate" cssClass="errorDiv"></form:errors>
                                            </div>
                                            <div class="col-sm-6">
                                                <label>End Date<span style="color: red;font-size: 12px;"></span></label>
                                                    <!--<input class="form-control" size="16" type="text" value="" readonly>-->
                                            <form:input path="endDate" class="form-control" readonly="true" placeholder="Enter End Date"></form:input>
                                                <form:errors path="endDate" cssClass="errorDiv"></form:errors>
                                            </div>
                                        </div>
                                        <div class="form-group"> 

                                            <div class="col-sm-6">
                                                <label>Title <span style="color: red;font-size: 12px;">*</span></label>
                                            <form:input path="title" class="form-control" placeholder="Enter Title"></form:input>
                                            <form:errors path="title" cssClass="errorDiv"></form:errors>
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
    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //language:  'fr',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
   
    </script>
    <script type="text/javascript">

            function dateDifference(ele) {
               
                var sDate = ele.split("/");
                var dateTemp = new Date();
                var year = dateTemp.getFullYear();
                var date1 = new Date(sDate[2],sDate[1]-1,sDate[0]);
                
                date1.setFullYear(date1.getFullYear() + 1);
                date1.setDate(date1.getDate() - 1);
               
//                  format: 'MM, dd, yyyy';
                var date;
                if (9 >= date1.getDate()) {
//                    date = '0' + date1.getDate();
                    date =  date1.getDate();
                } else {
                    date = date1.getDate();
                }
                var month;
                if (9 >= date1.getMonth()) {
//                    month = '0' + (parseInt(date1.getMonth())+1);
                    month =  (parseInt(date1.getMonth())+1);
                } else {
                    month = (parseInt(date1.getMonth())+1);
                }
//                var str = months[date1.getMonth()] + ", " + date1.getDate() + ", " + date1.getFullYear();
                var str = date + "/" + month + "/" + date1.getFullYear();
                
                document.getElementById("endDate").value = str;
                
            }
        </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
