<%-- 
    Document   : AjaxSendEmail
    Created on : Jan 22, 2026, 3:22:53 PM
    Author     : Sumanth
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>



<input type="hidden" name="refNo" id="refNo" value="${refNo}">
<div class="p-3">
<table id="commonTable" class="table table-striped bg-white " align="center">
    <thead>
        <tr>
            <th>Select</th>
            <th>Code</th>
            <th>Name</th>
            <th>Email Id</th>
            <th>Mobile No</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="list" items="${list}" varStatus="status">
            <tr>
                <td>
                    <c:set var = "auth" value="0"/>
                    <c:forEach var="list1" items="${list1}" varStatus="status1">
                        <c:if test="${list.vendorCode == list1.vendorCode}">
                            <c:set var = "auth" value="1"/>
                        </c:if>
                    </c:forEach>
                    <input type="checkbox" name="checkId" value="${list.vendorCode}" id="checkId" >


                </td>
                <td>${list.vendorCode}</td>
                <td>${list.vendorName}</td>
                <td>${list.emailId}</td>
                <td>${list.mobileNo}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
<%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>

