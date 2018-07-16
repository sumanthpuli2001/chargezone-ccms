<%-- 
    Document   : dashboardshowPolicy
    Created on : 30 May, 2018, 10:00:46 AM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Policy</title>
    </head>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>Policy List</h1>
            <ol class="breadcrumb">
                <li><a href="homeController.htm?act=openHomePage"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Policy List</li>
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
        <form:form action="policyMaster.htm?act=policydeleteSubmit" method="post" commandName="policyCreate"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
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
                                                                        <!--<th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>-->
                                                                    </c:if>
                                                                    <th style="width: 50px;">Policy Name</th>
                                                                    <th style="width: 50px;">Policy Type</th>
                                                                    <th style="width: 50px;">View</th>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                    <!--<td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="employeeId" value="${list[0]}"/></td>-->
                                                                </c:if>
                                                                <td>${list[1]}</td>
                                                                <td>${list[4]}</td>
                                                                <!--<td><a onclick='clickdownload(${list[0]});'>${list[2]}</a></td>-->
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="EditClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form:form>

        <div class="tab-pane" id="tab_3"></div>

    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
   <script>
        function EditClick(id) {
            window.location = 'policyMaster.htm?act=readViewDasPolicy&id=' + id;
        }
    </script>
    <script>
        function clickdownload(id) {
            window.location = 'policyMaster.htm?act=downloadAttachment&id=' + id;
        }
    </script>
</html>
