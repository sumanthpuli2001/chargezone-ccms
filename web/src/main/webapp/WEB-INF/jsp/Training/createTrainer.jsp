<%-- 
    Document   : createTrainer
    Created on : Mar 9, 2018, 2:28:55 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Trainer Result</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Trainer List</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home111</a></li>
                <li class="active">Trainer Detail List</li>
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
        <form:form action="trainer.htm?act=budgetdeleteSubmit" method="post" commandName="trainer"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <form:hidden path="id"></form:hidden>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                    <button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>
                                    <!--<button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" onclick="window.location = 'employeeMaster.htm?act=exportToExcel&searchString=${param.searchString}'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>-->

                                    <button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'trainer.htm?act=newCreateTrainer'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
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
                                                                    <th style="width: 50px;">Trainer Name</th>
                                                                    <th style="width: 50px;">User Name</th>
                                                                    <th style="width: 50px;">Email Id</th>
                                                                    <!--<th style="width: 50px;">Status</th>-->
                                                                    <!--<th style="width: 50px;">Status</th>-->
                                                                    <th style="width: 50px;">Action</th>
                                                                    <!--<th style="width: 50px;">Edit</th>-->
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
                                                                <!--<td>${list[4]}</td>-->
                                                                <%--<c:if test="${list[6] == 0}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 2}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 1}"><td><span class="label label-warning">Recycled</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 3}"><td><span class="label label-danger">Rejected</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 4}"><td><span class="label label-success">Approved</span></td></c:if>--%>
                                                                <%--<c:if test="${list[6] == 5}"><td><span class="label label-success">Final Approved</span></td></c:if>--%>

                                                                    <td>
<!--                                                                        <div class="btn-group">
                                                                            <button type="button" onclick="viewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </div>-->
                                                                    <%--<c:if test="${list[6] eq 0 || list[6] eq 1}">--%>
                                                                        <div class="btn-group">
                                                                            <button type="button" onclick="editViewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                &nbsp;&nbsp;&nbsp;&nbsp;Edit
                                                                            </button>
                                                                        </div>
                                                                    <%--</c:if>--%>

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
        function editViewClick(id) {
            window.location = 'trainer.htm?act=newEditTrainer&id=' + id;
        }
    </script>
    <script>
        function viewClick(id) {
            window.location = 'recruitment.htm?act=viewMPPShow&id=' + id;
        }
    </script>
</html>