<%-- 
    Document   : EmployeeDataToExcel
    Created on : Feb 4, 2016, 3:35:29 PM
    Author     : Irfan
--%>

<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>
<!DOCTYPE html>
<html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <%--<%@include file="/WEB-INF/jsp/Common/Header.jsp"%>--%>
    <%--<%@include file="/WEB-INF/jsp/Common/Navbar.jsp"%>--%>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>Employee Detail Sheet</title>
        <style>
            table,th,td {
                border: 1px solid black;

            }
        </style>
    </head>

    <table id="table_1" class="table table-bordered table-striped" style="" cellpadding="3" align="Center"  >
        <c:choose>
            <c:when test="${empty employeeMasterList}">
                <tr>
                    <td align="center">
                        <c:out value="There is no record found."></c:out>
                        </td>
                    </tr>
            </c:when>
            <c:otherwise>
                <tr>
                </tr>
                <tr>
                    <!--<th>user id</th>-->
                    <th></th>
                    <th></th>
                    <th>Employee ID</th>
                    <th>Employee Name</th>
                    <th>Department</th>
                    <th>Designation</th>
                    <th>Level</th>
                    <th>Company Name</th>
                    <th> Location</th>
                    <th>Work Location</th>
                    <th>Last Year Performance Rating</th>
                    <th>E-mail-Id</th>
                    <th>Contact No.</th>
                    <th>Gender</th>
                    <th>Marital Status</th>
                    <th>Present Address</th>
                    <th>Permanent Address</th>
                </tr>
            </c:otherwise>
        </c:choose>
        <tbody>
            <c:forEach var="employeeMasterList" items="${employeeMasterList}">
                <tr>
                    <td></td>
                    <td></td>
                    <td>${employeeMasterList[1]}</td>
                    <td>${employeeMasterList[2]}</td>
                    <td>${employeeMasterList[3]}</td>
                    <td>${employeeMasterList[4]}</td>
                    <td>${employeeMasterList[5]}</td>
                    <td>${employeeMasterList[6]}</td>
                    <td>${employeeMasterList[7]}</td>
                    <td>${employeeMasterList[8]}</td>
                    <td>${employeeMasterList[9]}</td>
                    <td>${employeeMasterList[10]}</td>
                    <td>${employeeMasterList[11]}</td>
                    <td>${employeeMasterList[12]}</td>
                    <td>${employeeMasterList[13]}</td>
                    <td>${employeeMasterList[14]}</td>
                    <td>${employeeMasterList[15]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</html>
