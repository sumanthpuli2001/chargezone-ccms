<%-- 
    Document   : RecruitmentEditView
    Created on : 14 Feb, 2018, 5:22:20 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Recruitment Edit</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Edit Budget Detail</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit Budget Detail</li>
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


                                        <form:form class="form-horizontal" method="post" commandName="recruitmentMaster" action="recruitment.htm?act=budgetEditSubmit">
                                            <form:hidden path="id"></form:hidden>
                                            <form:hidden path="createdDate"></form:hidden>
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
                                                        <label>Budget:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="budget" class="form-control" placeholder="Budget"></form:input>
                                                        <form:errors path="budget" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Number Of Position:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="numberOfPosition" class="form-control" placeholder="Number Of Position"></form:input>
                                                        <form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <!--<div class="form-group">-->
                                                    <!--                                                        <div class="col-sm-6">
                                                                                                                <label>Date:<span style="color: red;font-size: 12px;"></span></label>
                                                <%--<form:input path="date" class="form-control" placeholder="Date"></form:input>--%>
                                                <%--<form:errors path="date" cssClass="errorDiv"></form:errors>--%>
                                                </div>-->
                                                <!--                                                    </div>-->
                                                <div class="col-sm-6">
                                                    <label>Job Role:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:select path="designationMaster.id" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${desigList}"></form:options>
                                                    </form:select>
                                                    <form:errors path="designationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>  
                                                </div>
                                            <c:if test="${recruitmentMaster.mppStatus == 0 || recruitmentMaster.mppStatus == 2}">
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Work Experience(In Year):<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="experiance" class="form-control" placeholder="Experience"></form:input>
                                                    <form:errors path="experiance" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>  
                                                <div class="form-group">
                                                    <div class="col-sm-6 col-sm-offset-5">
                                                        <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                                    </div>

                                                </div>
                                            </c:if>
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
