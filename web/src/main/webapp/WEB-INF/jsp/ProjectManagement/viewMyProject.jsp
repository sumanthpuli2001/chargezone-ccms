<%-- 
    Document   : viewMyProject
    Created on : Jul 20, 2018, 12:32:06 PM
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
                    </div>
                </div>
            </section>
        </form:form>
        <!--<div class="tab-pane" id="tab_3"></div> /.tab-pane -->
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
