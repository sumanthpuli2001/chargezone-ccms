<%-- 
    Document   : OapApprovalMatrixUserAjax
    Created on : 13 Jun, 2026, 1:41:17 PM
    Author     : bulwarks-2
--%>
<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<input type="hidden" id="existingUserIds" value="<c:forEach var='list' items='${oapMasterUser}'>${list.userId},</c:forEach>" />
<table id="commonTable" class="table table-striped bg-white" style="min-width: 100%" align="center">
    <thead>
        <tr>
            <th>UserName</th>
            <th data-dt-order="disable">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="oapMasterUser" items="${oapMasterUser}" varStatus="status">
            <tr>
                <td>${oapMasterUser.userId}</td>
                <td>
                    <a data-id="${oapMasterUser.id}" data-appr-id="${oapMaster.id}" class="d-block text-danger p-1 mx-1 action-link delete-btn1" data-toggle="tooltip"
                       data-placement="left" title="Delete">
                        <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon">
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
