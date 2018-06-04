<%-- 
    Document   : EmpResult
    Created on : Jan 9, 2016, 6:16:45 PM
    Author     : Vinita
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NO Due Result</title>
    </head>
    <script>

//        function viewClick(id, empId) {
//
//            window.location = 'noDueMaster.htm?act=createNoDueReturn&id=' + id + '&empID=' + empId;
//        }
        function viewClick(employeeId, employeeNo) {
//            window.location = 'employeeMaster.htm?act=viewClick&id=' + id;
            window.location = 'noDueMaster.htm?act=createNoDueReturn&employeeId=' + employeeId + '&employeeNo=' + employeeNo;
        }

        function toggle(source) {
            var checkboxes = document.getElementsByName('hoursId');
            for (var i = 0, n = checkboxes.length; i < n; i++) {
                checkboxes[i].checked = source.checked;
            }
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



    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>NO DUE RESULT </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">No Due</li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <!-- Main content -->
        <form:form action="" method="post" commandName=""
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
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
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
                                                                    <!--<th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>-->
                                                                    <th>Employee Id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Status</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <tr>
                                                                <!--<td align="center"><input type="checkbox" name="checkId" id="hoursId" value="${list[0]}"/></td>-->
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>

                                                                <td>
                                                                    <c:choose>
                                                                        <c:when test="${(list[8]) && (list[9]) && (list[10]) && (list[11])}">
                                                                            <span class="label label-success label-as-badge">
                                                                                Completed
                                                                            </span>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <span class="label label-default label-as-badge">
                                                                                Pending
                                                                            </span>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                    <%--<c:if test="${list[3] == 0}"><span class="badge">Pending</span></c:if>--%>
                                                                    <%--<c:if test="${list[3] == 1}"><span class="label label-danger">Returned by Approver</span></c:if>--%>
                                                                    <%--<c:if test="${list[3] == 2}"><span class="label label-success">Approved</span></c:if>--%>
                                                                    <%--<c:if test="${list[3] == 3}"><span class="badge"> Pending</span></c:if>--%>

                                                                    <%--<c:if test="${list[3] == 4}"><span class="badge">Withdraw Pending</span></c:if>--%>
                                                                    <%--<c:if test="${list[3] == 5}"><span class="label label-danger">Withdraw Returned</span></c:if>--%>
                                                                    <%--<c:if test="${list[3] == 6}"><span class="label label-success">Withdraw Approved</span></c:if>--%>
                                                                    <%--<c:if test="${list[3] == 7}"><span class="badge">Withdraw Pending</span></c:if>--%>


                                                                </td>

                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="viewClick('${list[0]}', '${list[1]}');" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                        <!--                                                                            <ul class="dropdown-menu">
                                                                                                                                                        <li>
                                                                                                                                                            <a href="#"
                                                                                                                                                               >
                                                                                                                                                          
                                                                                                                                                        </a>
                                                                                                                                                    </li>
                                                                                                                                                </ul>-->
                                                                    </div>
                                                                </td>


                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                        <br/>
                                        <br/>
                                        <!--<input type="button" class="btn btn-primary" value="Back" onclick="window.history.back();" />-->
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

    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>


