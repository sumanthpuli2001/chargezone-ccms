<%-- 
    Document   : SearchDateWiseEmployeeVacancy
    Created on : 22 May, 2018, 9:59:15 AM
    Author     : Dell-1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Candidate List</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Candidate Job Applying Request List</h1>
            <ol class="breadcrumb">
                <li><a href="homeController.htm?act=openHomePage"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Candidate Request List</li>
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
        <form:form action="recruitment.htm?act=budgetdeleteSubmit" method="post" commandName="vacancyMaster"
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
                                                                    <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                    <!--<th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>-->
                                                                    <%--</c:if>--%>
                                                                    <!--<th>user id</th>-->
                                                                    <th style="width: 50px;">Name of Candidate</th>
                                                                    <!--<th style="width: 50px;">Qualification</th>-->
                                                                    <!--<th style="width: 50px;">Email Address</th>-->
                                                                    <!--<th style="width: 50px;">Experience Joining Year</th>-->
                                                                    <th style="width: 50px;">Position Applied For</th>
                                                                    <th style="width: 50px;">Department</th>
                                                                    <th style="width: 50px;">Date Of Application</th>
                                                                    <th style="width: 50px;">Application Status</th>
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
                                                                <%--<c:if test="${sessionScope.userRight.hr}">--%>
                                                                    <!--<td align="center" style="width: 1px;"><input type="checkbox" id="checkId" name="checkId"  value="${list[0]}"  /></td>-->
                                                                <%--</c:if>--%>
                                                                <!--<td>/</td>-->
                                                                <td>${list[3]}</td>
                                                                <!--<td>${list[4]}</td>-->
                                                                <!--<td>${list[5]}</td>-->
                                                                <!--<td>${list[6]}</td>-->
                                                                <td>${list[7]}</td>
                                                                <td>${list[10]}</td>
                                                                <td>${list[9]}</td>
                                                                <td>
                                                                    <c:if test="${list[8] eq 1}"><span class="label label-default">New Applicant</span></c:if>
                                                                    <c:if test="${list[8] eq 2}"><span class="label label-default">Shortlisted</span></c:if>
                                                                    <c:if test="${list[8] eq 3}"><span class="label label-default">Rejected</span></c:if>
                                                                    <c:if test="${list[8] eq 4}"><span class="label label-default">Online Assessment</span></c:if>
                                                                    <c:if test="${list[8] eq 5}"><span class="label label-default">Assessment Submission </span></c:if>
                                                                    <c:if test="${list[8] eq 6}"><span class="label label-default">Assessment Pass </span></c:if>
                                                                    <c:if test="${list[8] eq 7}"><span class="label label-default">Assessment Fail</span></c:if>
                                                                    <c:if test="${list[8] eq 8}"><span class="label label-default">F2F interview Invitation</span></c:if>
                                                                    <c:if test="${list[8] eq 9}"><span class="label label-default">Candidate On hold</span></c:if>
                                                                    <c:if test="${list[8] eq 10}"><span class="label label-default">Candidate Rejected </span></c:if>
                                                                    <c:if test="${list[8] eq 11}"><span class="label label-default">Candidate Selected</span></c:if>
                                                                    <c:if test="${list[8] eq 12}"><span class="label label-default">Employee Induction</span></c:if>
                                                                    <c:if test="${list[8] eq 13}"><span class="label label-default">Employee On board </span></c:if>
                                                                    <c:if test="${list[8] eq 14}"><span class="label label-default">Send Offer Letter </span></c:if>
                                                                    </td>
                                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="ViewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
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
        function ViewClick(id) {
            window.location = 'recruitment.htm?act=CandidateViewClick&id=' + id;
        }
    </script>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    <script>
        function editViewClick(id) {
            window.location = 'recruitment.htm?act=editMppRClick&id=' + id;
        }
    </script>
    <script>
        function viewClick(id) {
            window.location = 'recruitment.htm?act=viewMPPShow&id=' + id;
        }
    </script>
</html>
