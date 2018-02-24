<%-- 
    Document   : CreateQuestionPaper
    Created on : 23 Feb, 2018, 4:48:04 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Question Paper Create</title>
    </head>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Question Paper Create </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Question Paper</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form class="form-horizontal" method="post" commandName="questionPaper" action="questionLibrary.htm?act=submitQuestionPaper">
            <section class="content">
                <div class="col-md-12">
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="box-body no-padding">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12">
                                        <div class="form-group">
                                            <div class="col-sm-4">
                                                <%--<form:input path="id" id="id" class="form-control" type="hidden"></form:input>--%>
                                                <label>Category :<span style="color: red;font-size: 12px;"></span></label>
                                                    <form:select path="categoryName" id="categoryName" class="form-control">
                                                        <form:option value="" label="-- Select --" />
                                                        <form:options items="${categoryList}"></form:options>
                                                    </form:select>
                                                    <form:errors path="categoryName" cssClass="errorDiv"></form:errors>
                                                </div>
                                                <div class="col-sm-4">
                                                    <label>Question Paper Name : <span style="color: red;font-size: 12px;">*</span></label>
                                                <form:input path="paperName" id="marks" class="form-control" placeholder="Marks"></form:input>
                                                <form:errors path="paperName" cssClass="errorDiv"></form:errors>

                                                </div>
                                                <div class="col-sm-4">
                                                    <label>Status : <span style="color: red;font-size: 12px;">*</span></label>
                                                    <fieldset>
                                                    <form:radiobutton path="status" id="status" name="status"  value="0"/>Active&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                    <form:radiobutton path="status" id="status" name="status" value="1"/>Inactive
                                                </fieldset>
                                            </div>

                                            <%--<form:errors path="type" cssClass="errorDiv"></form:errors>--%>
                                        </div>
                                       
                                    </div>
                                    &nbsp;


                                    <div class="form-group">
                                        <div class=" col-sm-6 col-sm-offset-5">
                                            <button type="submit" class="btn btn-primary" style="width: 100px;" data-original-title="" title="" >SUBMIT</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form:form>
    </div>
</html>


<%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
<script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
<script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>
<link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
<script>
    initSample();
</script>

