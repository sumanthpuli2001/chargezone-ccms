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
                                                    <label>MPR Name:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${mprMaster.name}</span> 
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>MPR Budget:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${budget}</span> 
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Job Type:</label>  &nbsp;&nbsp;&nbsp;
                                                    <span >${jobtypeNAme}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Job Role:</label>  &nbsp;&nbsp;&nbsp;
                                                    <span >${designationName}</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Location:</label> &nbsp;&nbsp;&nbsp;
                                                    <span> ${locationName}</span>
                                                </div>

                                                <div class="col-sm-6">
                                                    <label>Department:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${departmentName}</span>    
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Number Of Position:</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${position}</span>
                                                </div>
                                                <div class="col-sm-6">
                                                    <label>Work Experience(In Years):</label> &nbsp;&nbsp;&nbsp;
                                                    <span>${mprMaster.experience}</span> 
                                                </div>


                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-6">
                                                    <label>Description :</label> &nbsp;&nbsp;&nbsp;
                                                    <span> ${mprMaster.description}</span>
                                                </div>
                                            </div>
                                            <div class="form-group">
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
                                                        <button type="submit" class="btn btn-success" id="btnType2" name="btnType"  value="Approve" style="width: 100px">Approve</button>
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
