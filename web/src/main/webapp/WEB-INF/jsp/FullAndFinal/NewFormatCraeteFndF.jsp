<%-- 
    Document   : NewFormatCraeteFndF
    Created on : 19 Apr, 2018, 12:54:23 PM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Create Format Full And Final Settlement</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Create Format Full And Final Settlement</h1>
            <ol class="breadcrumb">
                <li><a href="homeController.htm?act=openHomePage"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Create Format Full And Final Settlement</li>
            </ol>
        </section>

        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="resignationMaster.htm?act=submitCraeteFormat" method="post" commandName="formateFullNdFinalLetter"
                   name='form1' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                <!--<button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>-->
                                <!--<button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" onclick="window.location = 'employeeMaster.htm?act=exportToExcel&searchString=${param.searchString}'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>-->

                                <!--<button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'recruitment.htm?act=newCreateBudget'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>-->
                                <%--</c:if>--%>
                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Company Name<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="companyName" class="form-control" placeholder="Company Name"></form:input>
                                                    <%--<form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>--%>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label class="control-label">Manager HR & Admin :<span style="color: red;font-size: 12px;"></span></label>
                                                    <!--<input type="text" name="empid" id="empid" class="form-control"/>-->
                                                    <form:input type="text" path="approvalPerson" name="policyId1" id="policyId1" class="form-control"/>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-10">
                                                    <label>Description:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:textarea path="description" class="form-control" id="editor" placeholder="description"></form:textarea>
                                                        <form:errors path="description" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6 col-sm-offset-5">
                                                        <input type="submit" class="btn btn-primary" style="width: 100px;"  title="" value="SUBMIT">
                                                    </div>
                                                </div>
                                            </div><!-- /.col -->
                                        </div><!-- /.row -->
                                    </div>
                                </div><!-- /.tab-content -->
                            </div><!-- nav-tabs-custom -->
                        </div><!-- /.col -->
                    </div>
                </section>

        </form:form>

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>

    <script>
        jQuery.noConflict();
        jQuery(document).ready(function () {

            jQuery("#policyId1").tokenInput(${list}, {
                preventDuplicates: true,
                noResultsText: "No Result",
                tokenLimit: "1",
                searchingText: "Searching ... .. .",
                prePopulate: ${preList}
            });
        });

    </script>

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <!--    <script src="StorageYard/Plugins/ckeditor/ckeditor.js"></script>
        <script src="StorageYard/Plugins/ckeditor/samples/js/sample.js"></script>-->
    <link rel="stylesheet" href="StorageYard/Plugins/ckeditor/samples/toolbarconfigurator/lib/codemirror/neo.css">
<!--    <script>
        initSample();


    </script>-->
    <script>
        function viewClick(id) {
            window.location = 'recruitment.htm?act=viewMPPShow&id=' + id;
        }
    </script>
</html>
