<%-- 
    Document   : CreateVacancy
    Created on : 15 Feb, 2018, 4:50:18 PM
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
            <h1>Create New Vacancy</h1>
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
                                        <!--<div class="form-group">-->

                                        <form:form class="form-horizontal" method="post"
                                                   commandName="mprMaster" action="recruitment.htm?act=detailCreateForMpr">

                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>MPR Budget:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${budget}</span> 
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Job Type:</label>  &nbsp;&nbsp;&nbsp;
                                                    <%--<form:select disabled="true" path="jobtypeMaster.id" id="jobtypeMaster" class="form-control" readonly="true">--%>
                                                    <span >${jobtypeNAme}</span>
                                                    <%--</form:select>--%>
                                                    <%--<form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Department:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${departmentName}</span>    
                                                    <%--<form:select path="departmentMaster.id" id="departmentMaster" class="form-control" disabled="true" readonly="true">--%>
                                                    <%--<form:option value="" label="-- Select --" />--%>
                                                    <%--<form:options items="${deptMap}"></form:options>--%>
                                                    <%--</form:select>--%>
                                                    <%--<form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Job Role:</label>  &nbsp;&nbsp;&nbsp;
                                                    <%--<form:select disabled="true" path="jobtypeMaster.id" id="jobtypeMaster" class="form-control" readonly="true">--%>
                                                    <span >${designationName}</span>
                                                    <%--</form:select>--%>
                                                    <%--<form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Experiance:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${experiance}</span>   
                                                    <%--<form:select path="departmentMaster.id" id="departmentMaster" class="form-control" disabled="true" readonly="true">--%>
                                                    <%--<form:option value="" label="-- Select --" />--%>
                                                    <%--<form:options items="${deptMap}"></form:options>--%>
                                                    <%--</form:select>--%>
                                                    <%--<form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>--%>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <!--                                                    <div class="col-sm-6">
                                                                                                        <label>Location:<span style="color: red;font-size: 12px;"></span></label>
                                                <%--<form:select path="locationMaster.id" id="locationMaster" class="form-control"  disabled="true" >--%>
                                                <%--<form:option value="" label="-- Select --" />--%>
                                                <%--<form:options items="${locationMap}"/>--%>
                                                <%--</form:select>--%>
                                                <%--<form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>--%>
                                            </div>-->
                                                <div class="col-sm-6">
                                                    <label>Location:</label> &nbsp;&nbsp;&nbsp;
                                                        <%--<form:select path="locationMaster.id" id="locationMaster" class="form-control"  disabled="true" >--%>
                                                        <%--<form:option value="" label="-- Select --" />--%>

                                                    <span> ${locationName}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${position}</span>
                                                    <%--<form:input path="numberOfPosition" class="form-control" placeholder="Number Of Position" disabled="true"></form:input>--%>
                                                    <%--<form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>--%>
                                                </div>

                                            </div>
                                        </form:form>
                                        <form:form class="form-horizontal" method="post"
                                                   commandName="vacancyMaster" action="vacancy.htm?act=vacancySubmitCreate">
                                             <input type="hidden" name="mprMasterid" id="mprMasterid" value="${mprMaster.id}">

                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>From Date:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <div class="input-group date form_datetime" data-date-format="dd/mm/yyyy" data-link-field="dtp_input1" >
                                                        <form:input path="fromDate" class="form-control" onchange="dateDifference(this.value);" placeholder="From Date" readonly="true" ></form:input>
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
                                                        <label>Salary Range:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="salaryRange" class="form-control" placeholder="Salary Range"></form:input>
                                                    <form:errors path="salaryRange" cssClass="errorDiv"></form:errors>
                                                    </div>
<!--                                                    <div class="col-sm-6">
                                                        <label>Skill:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <%--<form:input path="skill" class="form-control" placeholder="Skill"></form:input>--%>
                                                    <%--<form:errors path="skill" cssClass="errorDiv"></form:errors>--%>
                                                    </div>-->
                                                </div>
                                                <div class="form-group">
<!--                                                    <div class="col-sm-6">
                                                        <label>Work Experience(In Year):<span style="color: red;font-size: 12px;">*</span></label>
                                                    <%--<form:input path="experience" class="form-control" placeholder="Experience"></form:input>--%>
                                                    <%--<form:errors path="experience" cssClass="errorDiv"></form:errors>--%>
                                                    </div>-->
                                                     <div class="col-sm-9">
                                                        <label>Description:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:textarea path="description" class="form-control" id="editor" placeholder="Description"></form:textarea>
                                                    <form:errors path="description" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                   
                                                </div>
<!--                                                <div class="form-group">

                                                    <div class="col-sm-6">
                                                        <label>Responsibility:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <%--<form:input path="responsibility" class="form-control" placeholder="Responsibility"></form:input>--%>
                                                    <%--<form:errors path="responsibility" cssClass="errorDiv"></form:errors>--%>
                                                    </div>
                                                </div>-->
                                                <div class="form-group">
<!--                                                    <div class="col-sm-6">
                                                        <label>Description:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <%--<form:textarea path="description" class="form-control" id="editor" placeholder="Description"></form:textarea>--%>
                                                    <%--<form:errors path="description" cssClass="errorDiv"></form:errors>--%>
                                                    </div>-->
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
