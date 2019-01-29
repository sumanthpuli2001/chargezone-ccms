<%-- 
    Document   : ShowAll EmployeePuchData
    Created on : 10 Jan, 2019, 12:24:12 PM
    Author     : Teja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>

    <script src="StorageYard/Plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="StorageYard/Plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script>
        function viewClick(id) {
            window.location = 'attendanceRegularizationMaster.htm?act=viewClick&id=' + id;
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
    <%--<%@include file="/WEB-INF/jsp/Common/Top.jsp"%>--%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date Wise Punch Records</title>
    </head>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>Date Wise Punch Records:</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Result</li>
            </ol>
        </section>

        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>

        <form:form class="form-horizontal" role="form" action="attendanceRegularizationMaster.htm?act=deleteSubmit" commandName=""  method="post" onsubmit='return deleteCheck11();' name='form' >
            <input type="hidden" name="id" value="${empId1}"/>;      
            <input type="hidden" name="date" value="${date1}"/>;      
            <section class="content">
                <div class="row">
                    <div class="col-md-12">
                        <div class="nav-tabs-custom">
                            <div class="tab-content">
                                <button type="submit" class="btn btn-danger" ><i class="fa fa-trash"></i>&nbsp&nbsp;Delete</button>

                                <div class="box-header">
                                </div>
                                <div class="box-body no-padding">
                                    <div class="row">            
                                        <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">
                                                <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty punchList}">
                                                            <tr>
                                                                <td align="center">
                                                                    <c:out value="There is no record found."></c:out>
                                                                    </td>
                                                                </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th align="center" style="width: 1px;"><input type="checkbox" id="toggleId"/></th>
                                                                    <th>Date and time</th>
                                                                    <th>Location</th>
                                                                    <th>Action</th>
                                                                </tr>
                                                            </thead>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <tbody>
                                                        <c:forEach var="list" items="${punchList}">
                                                            <tr>
                                                                <td align="center"><input type="checkbox" name="checkId" id="" value="${list[0]}"/></td>
                                                                <td>${list[1]}</td>
                                                                <td>${list[2]}</td>
                                                                <td>
                                                                    <div class="btn-group">
                                                                        <button type="button" onclick="viewClick(${list[0]});" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                                            &nbsp;&nbsp;Edit
                                                                        </button>

                                                                    </div>
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </div>


                                        </div><!-- /.col -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- /.row -->

            </section>
        </form:form>
    </div>
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
</html>
