<%-- 
    Document   : ViewApprovlPage
    Created on : 15 Feb, 2018, 11:18:28 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Employee Registration Result</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Man Power Requisition Confirmation </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Budget Detail List</li>
            </ol>

            <script>
                function reject() {
                    var checkreject = confirm("If You Reject You Can Not Edit,Submit Or View. So, Are You Sure You Want to Reject This MPR?");
                    if (checkreject) {
                        checkreject = document.getElementsByName('Reject');
                        return true;
                    }
                    return false;
                }
            </script>

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
                                                   commandName="mprMaster" action="recruitment.htm?act=approveSubmitForMpr">
                                              <form:hidden path="approvalComment"></form:hidden>
                                            <input type="hidden" id="empreqid" name="empreqid" value="${mprMaster.id}">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Department111111:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="departmentMaster.id" id="departmentMaster" class="form-control">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${deptMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
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
                                                <!--                                                <div class="form-group">
                                                                                                    <div class="col-sm-6">
                                                                                                        <label>Employee Category:<span style="color: red;font-size: 12px;"></span></label>
                                            <%--<form:select path="mprEmployeeCategory.id" id="mprEmployeeCategory" class="form-control">--%>
                                            <%--<form:option value="" label="-- Select --" />--%>
                                            <%--<form:options items="${categoryList}"></form:options>--%>
                                            <%--</form:select>--%>
                                            <%--<form:errors path="mprEmployeeCategory.id" cssClass="errorDiv"></form:errors>--%>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>Employee Type:<span style="color: red;font-size: 12px;"></span></label>
                                            <%--<form:select path="mprEmployeeTypeMaster.id" id="mprEmployeeTypeMaster" class="form-control">--%>
                                            <%--<form:option value="" label="-- Select --" />--%>
                                            <%--<form:options items="${emptypeList}"></form:options>--%>
                                            <%--</form:select>--%>
                                            <%--<form:errors path="mprEmployeeTypeMaster.id" cssClass="errorDiv"></form:errors>--%>
                                        </div>
                                    </div>-->
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Name:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="name" class="form-control" placeholder="Name"></form:input>
                                                    <form:errors path="name" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Budget:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="budget" class="form-control" placeholder="Budget"></form:input>
                                                    <form:errors path="budget" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <!--                                                    <div class="col-sm-6">
                                                                                                            <label>Created Budget:<span style="color: red;font-size: 15px;"></span><br>${recruitmentMaster.budget}</label>
                                                                                                    </div>-->
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
                                                    <form:textarea path="description" class="form-control" id="editor" placeholder="Description"></form:textarea>
                                                    <form:errors path="description" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Comment:<span style="color: red;font-size: 12px;">*</span></label>
                                                    <form:input path="approvalComment" class="form-control" placeholder="Approval Comment"></form:input>
                                                    <form:errors path="approvalComment" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <div class="col-sm-4" style="text-align: left">
                                                    <c:if test="${status != 1}">
                                                        <button type="submit" class="btn btn-danger" onclick="return reject();" id="btnType1" name="btnType" value="Reject" style="width: 100px" >REJECT</button>
                                                    </c:if>
                                                </div>
                                                <div class="col-sm-4" style="text-align: center">
                                                    <c:if test="${status != 2}">
                                                        <button type="submit" class="btn btn-warning" id="btnType2" name="btnType"  value="Return"  style="width: 100px">RECYCLE</button>
                                                    </c:if>
                                                </div>
                                                <div class="col-sm-4" style="text-align: right">
                                                    <c:if test="${status != 3}">
                                                        <button type="submit" class="btn btn-success" id="btnType2" name="btnType"  value="Approve" style="width: 100px">APPROVE</button>
                                                    </c:if>
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
