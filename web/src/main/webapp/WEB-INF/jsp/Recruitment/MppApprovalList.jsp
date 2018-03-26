<%-- 
    Document   : MppApprovalList
    Created on : 1 Mar, 2018, 10:42:43 AM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>MPP Approval List</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Man Power Planning Budget List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">MPP Approval List</li>
            </ol>
        </section>

        <script>
            function deleteCheck11() {
                var checkboxes = confirm("Are you sure you want to delete?");
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
        <form:form action="recruitment.htm?act=budgetdeleteSubmit" method="post" commandName="recruitmentMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
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
                                                                    <th style="width: 50px;">Number Of Position</th>
                                                                    <th style="width: 50px;">Budget</th>
                                                                    <th style="width: 50px;">Experiance</th>
                                                                    <th style="width: 50px;">Action</th>
                                                                    <th style="width: 50px;">View</th>
                                                                        <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                    <td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="employeeId" value="${list[0]}"/></td>
                                                                    </c:if>
                                                                <!--<td>/</td>-->
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[3]}</td>
                                                                <td>
                                                                    <c:if test="${list[4] eq 0}"><span class="badge">Pending</span></c:if>
                                                                    <%--<c:if test="${list[5] == 1}"><span class="badge">Recycle</span></c:if>--%>
                                                                    <%--<c:if test="${list[5] == 2}"><span class="badge">Recycle</span></c:if>--%>
                                                                    <c:if test="${list[4] eq 3}"><span class="label label-danger">Reject</span></c:if>
                                                                    <c:if test="${list[4] eq 4 && list[5] ne list[6]}"><span class="label label-success">Approved</span></c:if>
                                                                    <c:if test="${list[4] eq 4 && list[5] eq list[6]}"><span class="badge">Pending</span></c:if>
                                                                    <c:if test="${list[4]  eq 5}"><span class="label label-success">Final Approved</span></c:if>
                                                                    <c:if test="${list[4] eq 2}"><span class="label label-warning">Recycled</span></c:if>
                                                                    <%--<c:if test="${list[5] == 0}"><span class="badge">Rejected</span></c:if>--%>



                                                                </td>

                                                                <td>
                                                                    <div class="btn-group">
                                                                        <c:if test="${list[4] eq 0}">
                                                                        <button type="button" onclick="mPPViewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;Approval
                                                                        </button>
                                                                        </c:if>
                                                                    </div>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="viewMpp(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
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
        function mPPViewClick(id) {
            window.location = 'recruitment.htm?act=mPPViewApproval&id=' + id;
        }
    </script>
    <script>
        function viewMpp(id) {
            window.location = 'recruitment.htm?act=viewMppOnly&id=' + id;
        }
    </script>
</html>
