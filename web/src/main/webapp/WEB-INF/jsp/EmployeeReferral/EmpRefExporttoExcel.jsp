<%-- 
    Document   : EmpRefExporttoExcel
    Created on : Mar 30, 2016, 11:28:23 AM
    Author     : Vinita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
          <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
          <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Export Employee Referral Data</title>
        <style>
            table,th,td {
                border: 1px solid black;
            }
        </style>
    </head>
     <table id="table_1" class="table table-bordered table-striped table-hover" style="" align="center">
                                                <c:choose>
                                                    <c:when test="${empty employeeRefList}">
                                                        <tr>
                                                            <td align="center">There Is No Any Record</td>
                                                        </tr>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <thead>
                                                            <tr>
                                                                <!--<th style="width: 1px !important;" align="enter"><input type="checkbox" id="toggleId" align="center"/></th>-->
                                                                <th>Sr.No.</th>
                                                                <th>Employee Name</th>
                                                                <th>Department</th>
                                                                <th>Designation</th>
                                                                <th>Candidate Name</th>
                                                                <th>Candidate Contact No.</th>
                                                                <th>Position Referred For</th>
                                                                <th>Status</th>
                                                            </tr>
                                                        </thead>
                                                        <c:set var="count" value="0" scope="page" />
                                                        <tbody>
                                                            <c:forEach  var="employeeRefList" items="${employeeRefList}" varStatus="index">
                                                                <c:if test="${(sessionScope.userRight.hr or sessionScope.userRight.employeeReferral) or sessionScope.employeeInfo.employeeName eq employeeRefList[3]}">
                                                                    <c:set var="count" value="${count + 1}" scope="page"/>
                                                                    <tr>
                                                                        <!--<td align="center">-->
                                                                        <!--<input type="checkbox" name="checkId" id="deptCheckId" value="">--> 
                                                                        <!--</td>-->
                                                                        <td>
                                                                            ${count}
                                                                            <!--$count+1}-->
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[3]}
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[8]}
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[5]}
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[0].candidateName}
                                                                        </td>
                                                                        <td>
                                                                            ${employeeRefList[0].candidateContactNo}
                                                                        </td>
                                                                        <td>
                                                                               ${employeeRefList[13]}-${employeeRefList[14]}
                                                                        </td>
                                                                        <td>
                                                                            <span class="badge">${employeeRefList[0].statusRemark}</span>
                                                                        </td>
                                                                    </tr>
                                                                </c:if>
                                                            </c:forEach>
                                                        </tbody>
                                                    </c:otherwise>
                                                </c:choose>
                                            </table>
</html>
