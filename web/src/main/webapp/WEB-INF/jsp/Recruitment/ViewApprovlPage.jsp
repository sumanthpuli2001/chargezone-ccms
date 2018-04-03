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
                                            <%--<form:hidden path="approvalComment"></form:hidden>--%>
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
                                            <!--                                            <div class="form-group">
                                                                                            <div class="col-sm-6">
                                                                                                <label>Comment:<span style="color: red;font-size: 12px;">*</span></label>
                                            
                                                                                            </div>
                                                                                        </div>-->

                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <label>Comment:<span style="color: red;font-size: 12px;"></span></label>

                                                </div>
                                                <div class="col-sm-8">
                                                    <form:textarea path="approvalComment" class="form-control" placeholder="Approval Comment"></form:textarea>
                                                    <form:errors path="approvalComment" cssClass="errorDiv"></form:errors>
                                                    </div>
                                                </div> 

                                                <div class="row">
                                                    <div class="col-md-12 col-sm-12">
                                                        <label><h3>Approval Detail</h3></label>
                                                        <div class="table table-bordered">
                                                            <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center"  >
                                                            <c:choose>
                                                                <c:when test="${empty list}">
                                                                    <tr>
                                                                        <td align="center">
                                                                            <c:out value="There is no record found."></c:out>
                                                                            </td>
                                                                        </tr>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <thead>
                                                                        <tr>
                                                                            <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                            <!--<th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>-->
                                                                            <%--</c:if>--%>
                                                                            <!--<th>user id</th>-->
                                                                            <th style="width: 50px;">Name</th>
                                                                            <th style="width: 50px;">Date</th>
                                                                            <th style="width: 50px;">Comment</th>
                                                                            <th style="width: 50px;">Status</th>

                                                                            <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                            <%--</c:if>--%>

                                                                        </tr>
                                                                    </thead>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <tbody>
                                                                <c:forEach var="list" items="${list}">
                                                                    <tr>
                                                                        <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                            <!--<td align="center" style="width: 1px;"><input type="checkbox" id="checkId" name="checkId"  value="${list[0]}"  /></td>-->
                                                                        <%--</c:if>--%>
                                                                        <!--<td>/</td>-->
                                                                        <td>${list[1]}</td>
                                                                        <td>${list[6]}</td>
                                                                        <td>${list[3]}</td>
                                                                        <td><span class="label label-default">${list[5]}</span></td>
                                                                        <!--<td>-->
                                                                        <%--<c:if test="${list[4] eq 0}"><span class="label label-default">Pending</span></c:if>--%>
                                                                        <%--<c:if test="${list[4] eq 2}"><span class="label label-default">Pending</span></c:if>--%>
                                                                        <%--<c:if test="${list[4] eq 1}"><span class="label label-default">Recycle</span></c:if>--%>
                                                                        <%--<c:if test="${list[4] eq 5}"><span class="label label-default">Approve</span></c:if>--%>
                                                                        <%--<c:if test="${list[4] eq 3}"><span class="label label-default">Rejected</span></c:if>--%>
                                                                        <%--<c:if test="${list[4] eq 4}"><span class="label label-default">Online Assessment</span></c:if>--%>

                                                                        <!--</td>-->
                                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>

                                                                        <%--</c:if>--%>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                    </div>


                                                </div><!-- /.col -->
                                            </div><!-- /.row -->


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
