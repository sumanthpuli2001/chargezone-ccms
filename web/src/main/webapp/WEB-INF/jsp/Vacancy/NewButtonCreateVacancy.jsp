<%-- 
    Document   : NewButtonCreateVacancy
    Created on : 7 Mar, 2018, 6:16:08 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Create Vacancy</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>CREATE NEW VACANCY</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create New Vacancy</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
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
                            <div class="box-header">
                            </div>
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="table table-bordered">
                                        </div>
                                        <form:form class="form-horizontal" method="post"
                                                   commandName="vacancyMaster" action="vacancy.htm?act=CreateNewVacancy">
                                            <input type="hidden" name="mprMasterid" id="mprMasterid" value="${mprMaster.id}">

                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Department:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="departmentMaster.id" id="departmentMaster" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${deptMap}"></form:options>
                                                    </form:select>
                                                    <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Location:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="locationMaster.id" id="locationMaster" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${locationMap}"/>
                                                    </form:select>
                                                    <form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Job Type:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="jobtypeMaster.id" id="jobtypeMaster" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${jobtype1}"></form:options>
                                                    </form:select>
                                                    <form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Designation:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="designationMaster.id" id="designationMaster" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${desigList}"></form:options>
                                                    </form:select>
                                                    <form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Number Of Position:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="numberOfPosition" class="form-control" placeholder="number Of Position"></form:input>
                                                    <form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Experience:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="experience" class="form-control" placeholder="Experience"></form:input>
                                                    <form:errors path="experience" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>From Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                        <form:input path="fromDate" class="form-control" onchange="dateDifference(this.value);" placeholder="From Date" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="fromDate" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>To Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                        <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                        <form:input path="toDate" class="form-control" onchange="dateDifference(this.value);" placeholder="To Date" readonly="true"></form:input>
                                                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                                        </div>
                                                    <form:errors path="toDate" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Vacancy Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="name" class="form-control" placeholder="Vacancy Name"></form:input>
                                                    <form:errors path="name" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Salary :<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="salaryRange" class="form-control" placeholder="Salary Range"></form:input>
                                                    <form:errors path="salaryRange" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-9">
                                                        <label>Description:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:textarea path="description" class="form-control" id="editor" placeholder="Description"></form:textarea>
                                                    <form:errors path="description" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-6 col-sm-offset-5">
                                                    <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                                </div>
                                            </div>
                                    </form:form>
                                    <!--</div>-->

                                </div><!-- /.col -->
                            </div><!-- /.row -->
                        </div>
                    </div><!-- /.tab-content -->
                </div><!-- nav-tabs-custom -->
            </div><!-- /.col -->
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
        minView: 2,
        forceParse: 0
    });

</script>
<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
<script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
<!--<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/css/samples.css">-->
<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
<script>
    initSample();
</script>
</html>
