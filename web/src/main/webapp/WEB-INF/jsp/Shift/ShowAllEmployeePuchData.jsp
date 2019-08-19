<%-- 
    Document   : ShowAll EmployeePuchData
    Created on : 10 Jan, 2019, 12:24:12 PM
    Author     : Teja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script src="StorageYard/Plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="StorageYard/Plugins/datatables/dataTables.bootstrap.min.js"></script>
    <%@include file="/WEB-INF/jsp/Common/Top.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Date Wise Punch Records</title>
    </head>
    <script>
        function viewClick(id, empId, date, punchListDate) {
            window.location = 'attendanceRegularizationMaster.htm?act=viewClick1&id=' + id + '&empId=' + empId + '&date=' + date + '&punchListDate=' + punchListDate;
        }
        function newClick(empId, date) {
            window.location = 'attendanceRegularizationMaster.htm?act=newClick&empId=' + empId + '&date=' + date;
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
    <body>
        <section class="content-header">
            <h1>Date Wise Punch Records: </h1>
        </section>
        <c:if test="${!empty successMessage}">
            <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
        </c:if>
        <c:if test="${!empty failureMessage}">
            <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
        </c:if>
        <form:form action="attendanceRegularizationMaster.htm?act=deleteClickpunch" class="form-horizontal" role="form" onsubmit='return deleteCheck11();' method="post" name='form'>
            <input type="hidden" name="empId" id="empId" value="${empId}" />
            <input type="hidden" name="date" id="date" value="${date}" />
            <div class="box-body no-padding">
                <c:if test="${sessionScope.userRight.hr}">
                    <%--<c:if test="${size == 1 || size == 0}">--%>
                    <div class="btn-group">
                        <button type="button" class="btn btn-primary" style="float:right" onclick="newClick('${empId}', '${date}');" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></i>New</button>  
                        <button type="submit" class="btn btn-danger" title="" style="width: 100px;"><i class="fa fa-trash"></i>&nbsp;&nbsp;DELETE</button>
                    </div>
                    <%--</c:if>--%>
                </c:if>
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
                                                <th style="width: 1px;" align="Center"><input type="checkbox" id="toggleId" align="Center" ></th>
                                                <th >Date and time</th>
                                                <th>Location</th>
                                                <th>Action</th>

                                            </tr>
                                        </thead>
                                    </c:otherwise>
                                </c:choose>
                                <tbody>
                                    <c:forEach var="list" items="${punchList}">
                                        <tr>
                                            <td align="Center">
                                                <input type="checkbox" name="checkId" id="deletePunchId" value="${list[0]}">
                                            </td>
                                            <td>${list[1]}</td>
                                            <td>${list[2]}</td>
                                            <td>
                                                <div class="btn-group">
                                                    <c:if test="${sessionScope.userRight.hr}">
                                                        <button type="button" onclick="viewClick('${list[0]}', '${empId}', '${date}', '${punchListDate}');" class="btn btn-default " data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                            &nbsp;&nbsp;Edit
                                                        </button>
                                                    </c:if>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>


                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.box-body -->

        </form:form>
    </body>
</html>
