<%-- 
    Document   : MprEditSubmit
    Created on : 13 Feb, 2018, 5:52:59 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Man Power Requisition Create</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>MAN POWER REQUISITION CREATE</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create MPR</li>
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
                                                   commandName="mprMaster" action="recruitment.htm?act=mprEditSubmitDetail">
                                            <form:hidden path="id"></form:hidden>
                                            <form:hidden path="status"></form:hidden>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Man Power Planing Budget:</label> &nbsp;&nbsp;&nbsp;
                                                        <span> ${Mppbudget}</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Department:</label>
                                                    <form:select path="departmentMaster.id" id="departmentMaster" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${deptMap}"></form:options>
                                                    </form:select>
                                                    <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Location:</label>
                                                    <form:select path="locationMaster.id" id="locationMaster" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${locationMap}"/>
                                                    </form:select>
                                                    <form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Job Type:</label>
                                                    <form:select path="jobtypeMaster.id" id="jobtypeMaster" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${jobtype1}"></form:options>
                                                    </form:select>
                                                    <form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Designation:</label>
                                                    <form:select path="designationMaster.id" id="designationMaster" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${desigList}"></form:options>
                                                    </form:select>
                                                    <form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Vacancy Name:</label>
                                                    <form:input path="name" class="form-control" placeholder="Name"></form:input>
                                                    <form:errors path="name" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Budget:</label>
                                                    <form:input path="budget" class="form-control" placeholder="Budget"></form:input>
                                                    <form:errors path="budget" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Number Of Position:</label>
                                                    <form:input path="numberOfPosition" class="form-control" placeholder="Number Of Position"></form:input>
                                                    <form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Work Experience(In Years):</label>
                                                    <form:input path="experience" class="form-control" placeholder="Experience"></form:input>
                                                    <form:errors path="experience" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-10">
                                                        <label>Job Description:</label>
                                                    <form:textarea path="description" class="form-control" id="editor" placeholder="Description"></form:textarea>
                                                    <form:errors path="description" cssClass="errorDiv"></form:errors>
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
    <script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
    <!--<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/css/samples.css">-->
    <link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
    <script>
        initSample();
    </script>
</html>
