<%-- 
    Document   : ApprovalList
    Created on : 16 Mar, 2018, 12:56:34 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Approval Setting</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>APPROVAL SETTING</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Approval Setting</li>
            </ol>
        </section>

        <script>
            function deleteCheck11() {
                var checkboxes = confirm("Are you sure you want to delete? If you delete than after approval cycle does'n work");
                if (checkboxes) {
                    checkboxes = document.getElementsByName('checkId');
                    for (var i = 0, n = checkboxes.length; i < n; i++) {
                        if (checkboxes[i].checked) {
                            return true;
                        }
                    }
                    alert("Please, Select one or more record(s).");
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
        <!-- Main content -->
        <form:form action="approval.htm?act=deleteApprovalSetting" method="post" commandName="approvalMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Custom Tabs -->
                            <div class="nav-tabs-custom">
                                <div class="tab-content">
                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                    <!--<button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" onclick="window.location = 'employeeMaster.htm?act=exportToExcel&searchString=${param.searchString}'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>-->

                                    <!--<button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'approval.htm?act=createApprovalSetting'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>-->

                                </c:if>
                                <div class="box-header">
                                    <button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>
                                    <button type="button" class="btn btn-primary" title="" style="float: right; width: 120px;" onclick="window.location = 'approval.htm?act=createApprovalSetting'"><i class="fa fa-plus"></i>&nbsp;&nbsp;New</button>
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">
                                        <div class="col-md-12 col-sm-12">
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
                                                                    <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                        <th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>
                                                                        </c:if>
                                                                    <!--<th>user id</th>-->
                                                                    <th style="width: 50px;">Module Name</th>
                                                                    <th style="width: 50px;">Approval Name</th>
                                                                    <!--<th style="width: 50px;">level</th>-->
                                                                    <th style="width: 50px;">Action</th>

                                                                    <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                    <td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="employeeId" value="${list[4]}"/></td>
                                                                    </c:if>
                                                                <!--<td>/</td>-->
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <!--<td>${list[3]}</td>-->

                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="viewClick(${list[4]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </div>

                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
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
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>

    <script>
        function viewClick(id) {
            window.location = 'approval.htm?act=viewApprovalDetail&id=' + id;
        }
    </script>
</html>
