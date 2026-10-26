<%-- 
    Document   : AjaxAddTechnicalFileDetails
    Created on : Jan 13, 2026, 11:35:36 AM
    Author     : Administrator
--%>


<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
<input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">

<table id="AjaxTechTab" class="table table-striped bg-white dt-scroll" style="width: 100%" align="center">
    <thead>
        <tr>
            <th>Attachment</th>
            <th>Attachment Required From Vendor</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="list" items="${technicalDocument}" varStatus="status">
            <tr>
                <td >
                    <a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile &amp;fileName=${list.docName} &amp;RefNo=${list.refNo}">
                        ${list.docName}
                    </a>
                </td>

                <td >
                    <c:choose>
                        <c:when test="${list.attachmentRequired == 1}">
                            Yes
                        </c:when>
                        <c:otherwise>
                            No
                        </c:otherwise>
                    </c:choose>
                </td>
                <td class="text-center">
                     <a href="#" class="d-flex text-danger p-1 mx-1 action-link delete-doc-row"
                       data-toggle="tooltip" data-id="${list.id}" data-placement="left" title="Delete">
                         <img src="StorageYard/assets/images/delete-icon.svg" onload="SVGInject(this)" alt="Delete Icon">
                    </a> 
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>


