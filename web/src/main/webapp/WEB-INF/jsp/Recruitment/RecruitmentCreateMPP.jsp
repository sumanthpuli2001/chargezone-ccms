<%-- 
    Document   : RecruitmentCreateMPP
    Created on : 5 Feb, 2018, 2:16:28 PM
    Author     : Vikas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>
    <head>
        <title>Employee Registration Result</title>
    </head>
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Man Power Planning Budget List</h1>
            <ol class="breadcrumb">
                <li><a href="homeController.htm?act=openHomePage"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Budget Detail List</li>
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
        <form:form action="recruitment.htm?act=budgetdeleteSubmit" method="post" commandName="recruitmentMaster"
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

                                    <button type="button" class="btn btn-primary" style="float: right; width: 100px;" onclick="window.location = 'recruitment.htm?act=newCreateBudget'"><i class="fa fa-plus"></i>&nbsp&nbsp;NEW</button>
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
                                                                    <th style="width: 50px;">Location</th>
                                                                    <th style="width: 50px;">Department Name</th>
                                                                    <th style="width: 50px;">Job Type</th>
                                                                    <th style="width: 50px;">Budget</th>
                                                                    <th style="width: 50px;">No Of Position</th>
                                                                    <th style="width: 50px;">Date</th>
                                                                    <th style="width: 50px;">Status</th>
                                                                    <th style="width: 100px;">Action</th>
                                                                    <!--<th style="width: 50px;">Edit</th>-->
                                                                    <%--</c:if>--%>

                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${list}">
                                                            <c:set var="string2" value="${fn:split(list[6], '~')}" />
                                                            <tr>
                                                                <c:if test="${sessionScope.userRight.employeeManagement}">
                                                                    <td align="center" style="width: 1px;"><input type="checkbox" name="checkId" id="employeeId" value="${list[0]}"/></td>
                                                                    </c:if>
                                                                <!--<td>/</td>-->
                                                                <td>${list[3]}</td>
                                                                <td>${list[4]}</td>
                                                                <td>${list[5]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>${list[1]}</td>
                                                                <td>${list[7]}</td>
                                                                <%--<c:if test="${list[6] == 0}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                <c:if test="${list[6] == 0}"> <td>

                                                                        <span class="badge" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Pending</span></td></c:if>
                                                                    <%--<c:if test="${list[6] == 2}"><td><span class="badge">Pending</span></td></c:if>--%>
                                                                    <c:if test="${list[6] == 2}">  <td><span class="badge" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th><th bgcolor='#000000'> ${string3[1]}</th><th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Pending</span></td></c:if>
                                                                    <%--<c:if test="${list[6] == 1}"><td><span class="label label-warning">Recycled</span></td></c:if>--%>
                                                                    <c:if test="${list[6] == 1}"><td><span class="label label-warning" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Recycled</span></td></c:if>
                                                                    <%--<c:if test="${list[6] == 3}"><td><span class="label label-danger">Rejected</span></td></c:if>--%>
                                                                    <c:if test="${list[6] == 3}">  <td><span class="label label-danger" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Rejected</span></td></c:if>
                                                                    <%--<c:if test="${list[6] == 4}"><td><span class="label label-success">Approved</span></td></c:if>--%>
                                                                    <c:if test="${list[6] == 4}"> <td><span class="label label-success" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Approved</span></td></c:if>
                                                                    <%--<c:if test="${list[6] == 5 || list[6] == 21}"><td><span class="label label-success">Final Approved</span></td></c:if>--%>
                                                                    <c:if test="${list[6] == 5 || list[6] == 21}"><td><span class="label label-success" rel="tooltip" data-html="true" data-toggle="tooltip" data-placement="top"
                                                                              data-title="<table bgcolor='#000000' style='border: none'>
                                                                              <tr bgcolor='#000000'><th bgcolor='#000000'>Approver</th><th bgcolor='#000000'>Status</th><th bgcolor='#000000'>DateTime</th>
                                                                              <c:forEach var="qq" items="${string2}"> <c:set var="string3" value="${fn:split(qq, '_')}" /><tr bgcolor='#000000'><th bgcolor='#000000'>${string3[0]}</th>
                                                                                  <c:if test="${string3[1] eq 'Pending'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '0'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Pending</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '1'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Reworked</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '2'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Rejected</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '3'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '4'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      WithDraw</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '5'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Final Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '6'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <c:if test="${string3[1] eq '8'}">
                                                                                      <th bgcolor='#000000'>
                                                                                      Approved</th>
                                                                                  </c:if>
                                                                                  <th bgcolor='#000000'>${string3[2]}</th></tr></c:forEach>
                                                                              </table>">Final Approved</span></td></c:if>

                                                                    <td>
                                                                        <div class="btn-group">
                                                                            <button type="button" onclick="viewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;View
                                                                        </button>
                                                                    </div>
                                                                    <c:if test="${list[6] eq 0 || list[6] eq 1}">
                                                                        <div class="btn-group">
                                                                            <button type="button" onclick="editViewClick(${list[0]});" class="btn btn-default" aria-haspopup="true" aria-expanded="false">
                                                                                &nbsp;&nbsp;&nbsp;&nbsp;Edit
                                                                            </button>
                                                                        </div>
                                                                    </c:if>

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
            window.location = 'recruitment.htm?act=editMppRClick&id=' + id;
        }
    </script>
    <script>
        function viewClick(id) {
            window.location = 'recruitment.htm?act=viewMPPShow&id=' + id;
        }
    </script>
</html>
