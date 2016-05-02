<%-- 
    Document   : managerSearchResult
    Created on : Jan 12, 2016, 12:24:14 PM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resignation Result</title>
    </head>
<script>

        function resign(id, empId) {
          window.location = 'resignationMaster.htm?act=createApproveOrRejectResignation&id=' + id + '&EmpId=' + empId;
        }
        function exit(id, empId) {
                 window.location = 'exitInterviewMaster.htm?act=createApproveOrReturn&id=' + id + '&empID=' + empId;
        }
      </script>


    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Resignation Result: </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Exit Interview</li>
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
                                                                    <th>Employee id</th>
                                                                    <th>Employee Name</th>
                                                                    <th>Resignation Date</th>
                                                                    <th>Resignation Status</th>
                                                                    <th>Exit Interview Status</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                    <c:forEach var="list" items="${list}">
                                                            <tr>
                                                               <td>${list[0]}</td>
                                                                <td>${list[1]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>
                                                                <c:if test="${list[2] == 0}"><span class="badge" onclick="resign('${list[6]}','${list[5]}')">Pending</span></c:if>
                                                                <c:if test="${list[2] == 1}"><span class="label label-warning">Returned</span></c:if>
                                                                <c:if test="${list[2] == 2}"><span class="label label-success" onclick="resign('${list[6]}','${list[5]}')">Manager Approved</span></c:if>
                                                                <c:if test="${list[2] == 3}"><span class="badge" onclick="resign('${list[6]}','${list[5]}')">Pending</span></c:if>
                                                                <c:if test="${list[2] == 4}"><span class="label label-success" onclick="resign('${list[6]}','${list[5]}')">HR Approved</span></c:if>
                                                                
                                                                <c:if test="${list[2] == 5}"><span class="badge" onclick="resign('${list[6]}','${list[5]}')">Withdraw Pending</span></c:if>
                                                                <c:if test="${list[2] == 6}"><span class="label label-warning">Returned by HR</span></c:if>
                                                                <c:if test="${list[2] == 7}"><span class="label label-warning">Withdraw Manager Approved</span></c:if>
                                                                <%--<c:if test="${list[2] == 8}"><span class="badge"  onclick="resign('${list[6]}','${list[5]}')">Withdraw Pending</span></c:if>--%>   
                                                                <c:if test="${list[2] == 9}"><span class="label label-warning">Withdraw HR Approved</span></c:if>
                                                                <c:if test="${list[2] == 10}"><span class="label label-warning">Withdraw Rejected</span></c:if>
                                                                <c:if test="${list[2] == 11}"><span class="label label-success">Withdraw Rejected(Resignation Accepted)</span></c:if>
                                                            </td>
                                                            <td>
                                                                <c:if test="${list[3] == 0}"><span class="badge" onclick="exit('${list[7]}','${list[5]}')">Pending</span></c:if>
                                                                <%--<c:if test="${list[3] == 1}"><span class="label label-danger">Returned</span></c:if>--%>
                                                                <c:if test="${list[3] == 1}"><span class="label label-success" onclick="exit('${list[7]}','${list[5]}')">Manager Approved</span></c:if>
                                                                <%--<c:if test="${list[3] == 3}"><span class="badge" onclick="exit('${list[7]}','${list[5]}')">Pending</span></c:if>--%>
                                                                <c:if test="${list[3] == 2}"><span class="label label-success" onclick="exit('${list[7]}','${list[5]}')">HR Approved</span></c:if>
                                                                
                                                                <%--<c:if test="${list[3] == 5}"><span class="badge"  onclick="exit('${list[7]}','${list[5]}')">Withdraw Pending span></c:if>--%>
                                                                <%--<c:if test="${list[3] == 6}"><span class="label label-success" onclick="exit('${list[7]}','${list[5]}')">Withdraw Manager Approved</span></c:if>--%>
                                                                <%--<c:if test="${list[3] == 7}"><span class="label label-success" onclick="exit('${list[7]}','${list[5]}')">Withdraw HR Approved</span></c:if>--%>
                                                            </td>
                                                                <!--<td>${list[3]}</td>-->
                                                                </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                        <br/>
                                        <br/>
                                        <div class="col-sm-6 col-sm-offset-5">
                                        </div><!-- /.row -->
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


