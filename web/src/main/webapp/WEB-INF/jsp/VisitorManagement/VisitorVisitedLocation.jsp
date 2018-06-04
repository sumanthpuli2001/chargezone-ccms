<%-- 
    Document   : VisitorVisitedLocation
    Created on : Feb 3, 2016, 2:23:42 PM
    Author     : BlackBull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitor Visited Location</title>

        <script>
            var flag3 = true;
            function saveSubmit11() {
                if (flag3) {
                    flag3 = false;
                    document.getElementById('saveSubmit1').innerHTML = 'Checking ... .. .';
                    document.form1.submit();
                    return true;
                } else {
                    return false;
                }
            }
            $(function () {
                $("#username").focus();
            });

            function deleteCheck11() {
                var checkboxes = "";
                checkboxes = document.getElementsByName('id');
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
    <body>
        <div class="content-wrapper">
            <section class="content-header">
                <h1>ADD VISITED LOCATION </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">Visitor Visited Location</li>
                </ol>
            </section>
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                            
                                <div class="tab-pane active" id="tab_1">
                                    <span style="color: red;font-size: 14px;">* indicates mandatory field.</span>
                                       <c:if test="${!empty successmessage}">
                                            <div class="fadeOutEffect alert alert-info" role="alert">${successmessage}</div>
                                        </c:if>
                                 <c:if test="${!empty failuremessage}">
                                              <div class="fadeOutEffect alert alert-danger" role="alert">${failuremessage}</div>
                                    </c:if>
                                    <form:form class="form-horizontal" role="form" action="visitorVisitedLocation.htm?act=createSubmit" commandName="visitorVisitedLocation" enctype="multipart/form-data" method="post" name='form' onsubmit='return saveSubmit11();'>
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="box-header">
                                                    <div class="form-group">
                                                        <div class="col-sm-3">
                                                            <label class="control-label">Enter Location Name: <span style="color: red;font-size: 12px;">*</span></label>
                                                        </div>
                                                        <div class="col-sm-6">
                                                            <form:input path="location" value="" placeholder="Enter Location Name" class="form-control" required="true"/>
                                                        </div>
                                                        <br/>
                                                        <br/>
                                                        <br/>
                                                        <div class="form-group">
                                                            <div class="col-sm-6 col-sm-offset-5">
                                                          <button type="submit" class="btn btn-primary"  value="Add Location">SUBMIT</button>
                                                                <!--<input type="submit" class="btn btn-primary" style="width: 100px;"  title="" >-->
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
            <section class="content">
                <div class="nav-tabs-custom">
                    <div class="tab-content">
                        <form:form action="visitorVisitedLocation.htm?act=deleteClick" method="post" commandName="visitorVisitedLocation"
                                   name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="tab-content">
                                        <button type="submit" class="btn btn-danger" ><i class="fa fa-trash"></i>&nbsp;&nbsp;Delete</button>
                                        <div class="box-body no-padding">
                                            <div class="row">
                                                <div class="col-md-12 col-sm-12">
                                                    <br/>
                                                    <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center">
                                                        <c:choose>
                                                            <c:when test="${empty locationList}">
                                                                <tr>
                                                                    <td align="Center">There Is No Any Record</td>
                                                                </tr>
                                                            </c:when>
                                                            <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th align="center" style="width: 1px;"><input type="checkbox" id="toggleId" align="center"/></th>
                                                                    <th style="text-align: justify;width: 80%;">Location Name</th>
                                                                    <th style="text-align: center;width: 20%;">Action</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <tr>
                                                                    <c:forEach var="locationList" items="${locationList}">
                                                                        <td align="center"><input type="checkbox" name="id" id="id" value="${locationList.id}"/></td>
                                                                        <td>${locationList.location}</td>
                                                                        <td>
                                                                             <button type="button" class="btn btn-default dropdown-toggle"   onclick="location.href='visitorVisitedLocation.htm?act=editClick&id=${locationList.id}'"
                                                                                     data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Edit  </button>
                                                                            <!--<button class="btn btn-primary center-block" style="width: 75px;">-->
                                                                        </td>
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </section>
        </div>
    </body>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
