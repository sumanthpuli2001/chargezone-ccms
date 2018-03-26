<%-- 
    Document   : ApprovalForMPpHr
    Created on : 1 Mar, 2018, 11:02:27 AM
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
            <h1>Man Power Planning Approval </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Edit Budget Detail</li>
            </ol>
        </section>

        <script>
            function reject() {
                var checkreject = confirm("If You Reject You Can Not Edit,Submit Or View. So, Are You Sure You Want to Reject This Man Power Planning?");
                if (checkreject) {
                    checkreject = document.getElementsByName('Reject');
                    return true;
                }
                return false;
            }
        </script>

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


                                        <form:form class="form-horizontal" method="post" commandName="recruitmentMaster" action="recruitment.htm?act=submitMppApprove">
                                            <input type="hidden" id="empreqid" name="empreqid" value="${recruitmentMaster.id}">
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Department:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="departmentMaster.id" id="departmentMaster" class="form-control" disabled="true">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${deptMap}"></form:options>
                                                        </form:select>
                                                        <form:errors path="departmentMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <!--<div class="form-group">-->
                                                    <div class="col-sm-6">
                                                        <label>Location:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="locationMaster.id" id="locationMaster" class="form-control" disabled="true">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${locationMap}"/>
                                                        </form:select>
                                                        <form:errors path="locationMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-6">
                                                        <label>Job Type:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:select path="jobtypeMaster.id" id="jobtypeMaster" class="form-control" disabled="true">
                                                            <form:option value="" label="-- Select --" />
                                                            <form:options items="${jobtype1}"></form:options>
                                                        </form:select>
                                                        <form:errors path="jobtypeMaster.id" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                    <div class="col-sm-6">
                                                        <label>Budget:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="budget" class="form-control" placeholder="Budget" disabled="true"></form:input>
                                                        <form:errors path="budget" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">

                                                    <div class="col-sm-6">
                                                        <label>Number Of Position:<span style="color: red;font-size: 12px;"></span></label>
                                                        <form:input path="numberOfPosition" class="form-control" placeholder="Number Of Position" disabled="true"></form:input>
                                                        <form:errors path="numberOfPosition" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <div class="col-sm-2">
                                                        <label>Comment:<span style="color: red;font-size: 12px;"></span></label>

                                                    </div>
                                                    <div class="col-sm-8">
                                                    <form:textarea path="approvalComment" name="approvalComment" class="form-control" placeholder="Approval Comment"></form:textarea>
                                                    <form:errors path="approvalComment" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div> 

                                                <div class="form-group">
                                                    <div class="col-sm-4" style="text-align: left">
                                                    <%--<c:if test="${recruitmentMaster.mppStatus == 1 || recruitmentMaster.mppStatus == 2 || recruitmentMaster.mppStatus == 0}">--%>
                                                    <input type="submit" class="btn btn-danger" onclick="return reject();" id="btnType1" name="btnType" value="Reject" style="width: 100px" ></input>
                                                    <%--</c:if>--%>
                                                </div>
                                                <div class="col-sm-4" style="text-align: center">
                                                    <%--<c:if test="${recruitmentMaster.mppStatus == 0 || recruitmentMaster.mppStatus == 3 || recruitmentMaster.mppStatus == 1}">--%>
                                                    <input type="submit" class="btn btn-warning" id="btnType2" name="btnType"  value="Recycle"  style="width: 100px"></input>
                                                    <%--</c:if>--%>
                                                </div>
                                                <div class="col-sm-4" style="text-align: right">
                                                    <%--<c:if test="${recruitmentMaster.mppStatus == 0 || recruitmentMaster.mppStatus == 2 || recruitmentMaster.mppStatus == 3}">--%>
                                                    <input type="submit" class="btn btn-success" id="btnType2" name="btnType"  value="Approve" style="width: 100px"></input>
                                                    <%--</c:if>--%>
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
