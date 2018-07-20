<%-- 
    Document   : taskList
    Created on : Jun 15, 2018, 4:41:03 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head> 
        <title>TASK LIST </title>
        <script>
            function viewClick(id) {
//            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
                window.location = 'trainingType.htm?act=edittraining&id=' + id;
            }

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
    </head>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>MY PROJECT LIST</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">MY PROJECT LIST</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty faliureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${faliureMessage}</div>
        </c:if>
        <form:form action="trainingType.htm?act=deleteSubmittrainingtype" method="post"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                    <!--<button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>-->


                                    <!--<button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'projectManagement.htm?act=createTask'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>-->
                                <%--</c:if>--%>
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
                                                                    <th style="width: 50px;">Project Code</th>
                                                                    <th style="width: 50px;">Project Name</th>
                                                                    <th style="width: 50px;">Planned Date</th>
                                                                    <th style="width: 50px;">DeadLine</th>
                                                                    <!--<th style="width: 50px;">Status</th>-->
                                                                    <!--<th style="width: 50px;"></th>-->
                                                                    <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                    <th style="width: 50px;">Action</th>

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
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>${list[6]}</td>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            Action <span class="caret"></span>
                                                                        </button>
                                                                        <ul class="dropdown-menu" >
                                                                            <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>

                                                                            <li style="width: 100px;">
                                                                                <a href="#"
                                                                                   onclick="viewClick(${list[2]});">
                                                                                    <!--onclick="viewClick($//{list[0]},$//{list[1]});">-->
                                                                                    &nbsp;&nbsp;Edit
                                                                                </a>
                                                                            </li>
                                                                            <%--</c:if>--%>
                                                                        </ul>
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
                                </div><!-- /.box-body -->
                            </div> <!--/tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>

        </form:form>
        <!--<div class="tab-pane" id="tab_3"></div> /.tab-pane -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>

