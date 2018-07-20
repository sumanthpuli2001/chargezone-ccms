<%-- 
    Document   : ViewDynamicCycle
    Created on : 9 Jul, 2018, 12:31:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dynamic Cycle List</title>
        <script>
            function viewClick(id) {
                //            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
                window.location = 'dynamicApprovalSetting.htm?act=viewClick&id=' + id;
            }


            function deleteCheck11() {
                var checkboxes = "";
                checkboxes = document.getElementsByName('checkId');
                for (var i = 0, n = checkboxes.length; i < n; i++) {
                    if (checkboxes[i].checked) {
                        return true;
                    }
                }
                alert("Please, Select one or more record(s).");
                return false;
            }
        </script>
    </head>



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Dynamic Cycle List </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Dynamic Cycle List</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="dynamicApprovalSetting.htm?act=deleteDynamicCycleSubmit" method="post" commandName="dynamicApprovalSetting"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                    <button type="submit" class="btn btn-danger" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>
                                    <!--<button type="button" class="btn btn-facebook col-sm-offset-4" style="width: 100px;" onclick="window.location = 'dynamicApprovalSetting.htm?act=exportToExcel&searchString=${param.searchString}'"><i class="fa fa-file-excel-o"></i>&nbsp&nbsp;EXPORT</button>-->

                                    <button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'dynamicApprovalSetting.htm?act=createClick'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
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
                                                            <th style="width: 50px;">Module Name</th>
                                                            <th style="width: 50px;">Location Name</th>
                                                            <th style="width: 50px;">Designation Name</th>
                                                            <th style="width: 50px;">Company Name</th>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
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
                                                            <td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="checkId" value="${list.id}"/></td>
                                                        </c:if>
                                                        <!--<td>/</td>-->
                                                        <td>${list.modules.moduleName}</td>
                                                        <td>${list.zydexLocationMaster.zydexLocation}</td>
                                                        <td>${list.designationMaster.designationName}</td>
                                                        <td>${list.company.companyName}</td>
                                                        <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                        <td>
                                                            <a href="#"
                                                               onclick="viewClick(${list.id});">
                                                                <!--onclick="viewClick($//{list[0]},$//{list[1]});">-->
                                                                &nbsp;&nbsp;Edit
                                                            </a>
                                                            <!--                                                                    <div class="btn-group">
                                                                                                                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                                                                                        Action <span class="caret"></span>
                                                                                                                                    </button>
                                                                                                                                    <ul class="dropdown-menu" >-->
                                                            <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>

                                                            <!--                                                                                <li style="width: 100px;">
                                                                                                                                                <a href="#"
                                                                                                                                                   onclick="viewClick(${list.id});">
                                                                                                                                                    onclick="viewClick($//{list[0]},$//{list[1]});">
                                                                                                                                                    &nbsp;&nbsp;Edit
                                                                                                                                                </a>
                                                                                                                                            </li>-->
                                                            <%--</c:if>--%>

                                                            <!--                                                                            <li>
                                                                                                                                            <a href="#"
                                                                                                                                               onclick="editRotation($/{list[6]});">
                                                                                                                                                &nbsp;&nbsp;Edit Shift Rotation
                                                                                                                                            </a>
                                                                                                                                        </li>-->
                                                            <!--</ul>-->
                                                            <!--</div>-->
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
                            </div><!-- /.tab-content -->
                        </div><!-- nav-tabs-custom -->
                    </div><!-- /.col -->
                </div>
            </section>

        </form:form>

        <div class="tab-pane" id="tab_3"></div><!-- /.tab-pane -->
        <!-- /.content -->
    </div>

    <script type="text/javascript">
        $('.form_datetime').datetimepicker({
            //            language: 'fr',
            weekStart: 1,
            //            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 1,
            minView: 0,
            maxView: 1,
            forceParse: 0
        });
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <!--    <script>
            $(document).ready(function () {
                $('#table_2').DataTable();
            })
        </script>-->
</html>

