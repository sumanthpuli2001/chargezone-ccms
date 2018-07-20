<%-- 
    Document   : viewProject
    Created on : Jun 28, 2018, 12:23:41 PM
    Author     : Aman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <head> 
        <title>View Project</title>
        <script>
            function viewClick(id) {
                window.location = 'projectManagement.htm?act=createTask&projectId=' + id;
            }
            function viewClick1(id) {
                window.location = 'projectManagement.htm?act=viewTask&taskId=' + id;
            }
            function editTask(id, projectId) {
                window.location = 'projectManagement.htm?act=editTask&taskId=' + id + '&projectId=' + projectId;
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
            <h1>VIEW PROJECT </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">View Project </li>
            </ol>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty faliureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${faliureMessage}</div>
        </c:if>
        <form:form action="projectManagement.htm?act=deleteTask" method="post"
                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
            <input type="hidden" name="projectId" value="${projectManagement.id}">
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <!-- Custom Tabs -->
                        <div class="nav-tabs-custom">
                            <h3>&nbsp; Basic:</h3>
                            <div class="tab-content">
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Project Code:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${projectManagement.projectCode}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Project Name:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${projectManagement.name}</span> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Project Code:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${projectManagement.plannedDate}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Client:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${clientMaster.name}</span> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Stage:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${stateMaster.name}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Priority:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${priorityMaster.name}</span> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label> Risk Impact:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${projectManagement.riskImpact}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Work Location:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${workLocation.zydexLocation}</span> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label> Project Finish Date:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${projectManagement.finishDate}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Manager:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${employeeMaster.employeeName}</span> 
                                    </div>
                                </div>
                                <!--</div>-->
                                <h3> Financial</h3>
                                <!--<div class="tab-content">-->
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Project % Complete:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${projectManagement.taskCompleted}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Budget:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${projectManagement.budget}</span> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-6">
                                        <label>Billing Type:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${projectManagement.billingType}</span> 
                                    </div>
                                    <div class="col-sm-6">
                                        <label>Description:</label> &nbsp;&nbsp;&nbsp;
                                        <span>${projectManagement.description}</span> 
                                    </div>
                                </div>
                                <!--</div>-->
                                <h3> Attachment</h3>
                                <!--<div class="tab-content">-->
                                <c:choose>
                                    <c:when test="${empty attachementList}">
                                        <c:out value="(Their is No Attachement)"></c:out>
                                    </c:when>
                                </c:choose>
                                <c:forEach var="list" items="${attachementList}">
                                    <a href="${list[0]}">${list[1]}</a><br>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 " >
                                <input type="button" onclick="viewClick(${projectManagement.id});" width="48 px" style="height: 25 px;width: 132px !important ; " value="CreateTask" class="btn btn-primary dropdown-toggle" >
                            </div>
                            <c:if test="${!empty list}">
                                <div class="col-md-6 text-right" >
                                    <button type="submit" class="btn btn-danger " style="width: 100px;"><i class="fa fa-trash"></i>&nbsp&nbsp;DELETE</button>
                                </div>
                            </c:if>

                        </div>
                    </div>
                </div>
                <br/>
                <div class="box-body no-padding">
                    <div class="row">
                        <div class="col-md-12 col-sm-12">
                            <div class="table table-bordered">
                                <table class="table table-bordered table-striped table-hover" >
                                    <c:choose>
                                        <c:when test="${empty list}">
                                            <tr>
                                                <td align="center">
                                                    <c:out value="There is no Task found."></c:out>
                                                    </td>
                                                </tr>
                                        </c:when>
                                        <c:otherwise>
                                            <thead>
                                                <tr>
                                                    <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                    <th style="width: 1px;text-align: center;"><input type="checkbox" id="toggleId"/></th>
                                                        <%--</c:if>--%>
                                                    <th style="width: 50px;">Task Name</th>
                                                    <th style="width: 50px;">Task % Completed</th>
                                                    <th style="width: 50px;">Priority</th>
                                                    <th style="width: 50px;">Planned Start</th>
                                                    <th style="width: 50px;">Planned Finish</th>
                                                    <th style="width: 50px;">Action</th>

                                                </tr>
                                            </thead>
                                        </c:otherwise>
                                    </c:choose>
                                    <tbody>
                                        <c:forEach var="list" items="${list}">
                                            <tr>
                                                <%--<c:if test="${sessionScope.userRight.employeeManagement}">--%>
                                                <td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="employeeId" value="${list[0]}"/></td>
                                                    <%--</c:if>--%>
                                                <!--<td>/</td>-->
                                                <td>${list[1]}</td>
                                                <td>${list[2]}</td>
                                                <td>${list[3]}</td>
                                                <td>${list[4]}</td>
                                                <td>${list[5]}</td>
                                                <!--<td></td>-->
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
                                                                   onclick="viewClick1(${list[0]});">
                                                                    &nbsp;&nbsp;View
                                                                </a>
                                                            </li>
                                                            <li style="width: 100px;">
                                                                <a href="#"
                                                                   onclick="editTask('${list[0]}', '${projectManagement.id}');">
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
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"></div>
                        <div class="col-md-6  text-right" >
                            <input type="button" onclick="projectId(${projectManagement.id});" style="height: 25 px;width: 170px !important ; " value="Send For Approval" class="btn btn-primary dropdown-toggle" >
                        </div>
                    </div>
                </div>
            </section>
        </form:form>
        <!--<div class="tab-pane" id="tab_3"></div> /.tab-pane -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
