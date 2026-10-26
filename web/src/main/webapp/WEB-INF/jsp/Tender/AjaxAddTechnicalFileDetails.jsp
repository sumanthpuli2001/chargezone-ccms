<%-- 
    Document   : AjaxAddTechnicalFileDetails
    Created on : Jan 27, 2026, 1:36:48 PM
    Author     : Sumanth
--%>

<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
<input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">

<table id="AjaxtenderTechnicalTab" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">

    <thead>
        <tr>
            <th>Attachment</th>
             <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="list" items="${technicalDocument}" varStatus="status">
            <tr>
                <td>
                    <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTechnicalFile&amp;fileName=${list.attachment}&refNo=${list.refNo}&vendorCode=${list.vendorCode}">${list.attachment}</a>
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
