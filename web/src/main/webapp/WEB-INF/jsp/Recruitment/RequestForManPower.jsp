<%-- 
    Document   : RequestForManPower
    Created on : 10 Feb, 2018, 10:32:14 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Create Request For Man power Requisition</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create Request For Man Power Requisition</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create Request For Man Power</li>
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
                                                    <label>Department:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="departmentMaster.id" id="departmentMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${deptMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <!--<div class="form-group">-->
                                                    <div class="col-sm-6">
                                                        <label>Location:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="locationMaster.id" id="locationMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${locationMap}"/>
                                                        </form:select>
                                                        <form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Job Type:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="jobtypeMaster.id" id="jobtypeMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${jobtype1}"></form:options>
                                                        </form:select>
                                                        <form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Designation:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="designationMaster.id" id="designationMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${desigList}"></form:options>
                                                        </form:select>
                                                        <form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Employee Category:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="mprEmployeeCategory.id" id="mprEmployeeCategory" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${categoryList}"></form:options>
                                                        </form:select>
                                                        <form:errors path="mprEmployeeCategory.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Employee Type:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="mprEmployeeTypeMaster.id" id="mprEmployeeTypeMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${emptypeList}"></form:options>
                                                        </form:select>
                                                        <form:errors path="mprEmployeeTypeMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="nameOfMpr" class="form-control" placeholder="Name"></form:input>
                                                    <form:errors path="nameOfMpr" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Budget:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="budget" class="form-control" placeholder="Budget"></form:input>
                                                    <form:errors path="budget" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Number Of Position<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="numberOfPosition" class="form-control" placeholder="Number Of Position"></form:input>
                                                    <form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Work Experience:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="experience" class="form-control" placeholder="Experience"></form:input>
                                                    <form:errors path="experience" cssClass="errorDiv"></form:errors>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Description:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="description" class="form-control" placeholder="Description"></form:input>
                                                    <form:errors path="description" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Employee Type:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="qulificationMaster.id" id="qulificationMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${emptypeList}"></form:options>
                                                        </form:select>
                                                        <form:errors path="qulificationMaster.id" cssClass="errorDiv"></form:errors>
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
</html>
