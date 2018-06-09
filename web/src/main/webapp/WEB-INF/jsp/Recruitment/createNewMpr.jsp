<%-- 
    Document   : createNewMpr
    Created on : 8 Feb, 2018, 5:45:16 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>MPR Created List</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>MAN POWER REQUISITION LIST</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">MPR Created List</li>
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
        <form:form action="recruitment.htm?act=mprdeleteData" method="post" commandName="recruitmentMaster"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                    <button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>
                                    <button type="button" class="btn btn-facebook" style="float: right; width: 200px;" onclick="window.location = 'recruitment.htm?act=searchForCreatedBudget'"><i class="fa fa-search"></i>&nbsp&nbsp;Man Power Planning Search</button>

                                    <!--<button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'recruitment.htm?act=requestForManPower'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>-->
                                </c:if>
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
                                                                    <th style="width: 50px;">Name</th>
                                                                    <th style="width: 50px;">Budget</th>
                                                                    <th style="width: 50px;">Number Of Position</th>
                                                                    <th style="width: 50px;">Experience</th>
                                                                    <th style="width: 50px;">Status</th>
                                                                    <th style="width: 80px;">Action</th>
                                                                    <th style="width: 50px;">Create Vacancy</th>
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
                                                                <td>${list[3]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[4]}</td>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                <td>
                                                                    <c:if test="${list[5] == 0}"><span class="badge">Pending</span></c:if>
                                                                    <c:if test="${list[5] == 1}"><span class="label label-warning">Recycle</span></c:if>
                                                                    <c:if test="${list[5] == 2}"><span class="badge">Pending</span></c:if>
                                                                    <c:if test="${list[5] == 3}"><span class="label label-danger">Reject</span></c:if>
                                                                    <c:if test="${list[5] == 4}"><span class="label-success">Approved</span></c:if>
                                                                    <c:if test="${list[5] == 5}"><span class="label label-success">Final Approved</span></c:if>

                                                                    </td>

                                                                    <td>
                                                                        <div class="btn-group">  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                            <button  type="button" onclick="mprViewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </div>
                                                                    <div class="btn-group">
                                                                        <c:if test="${list[5] == 0 || list[5] == 1}">
                                                                            <button  type="button" onclick="editViewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                &nbsp;&nbsp;Edit
                                                                            </button>
                                                                        </c:if>
                                                                    </div>

                                                                </td>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <c:if test="${list[5] == 5}">
                                                                            <button type="button" onclick="vacancyClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                &nbsp;&nbsp;Create Vacancy
                                                                            </button>
                                                                        </c:if>
                                                                    </div>
                                                                </td>
                                                                <%--</c:if>--%>
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
    <script>
        function editViewClick(id) {
            window.location = 'recruitment.htm?act=editMprClick&id=' + id;
        }
    </script>
    <script>
        function vacancyClick(id) {
            window.location = 'vacancy.htm?act=newVacancyCreate&id=' + id;
        }
    </script>
    <script>
        function mprViewClick(id) {
            window.location = 'recruitment.htm?act=mprViewOnly&id=' + id;
        }
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
