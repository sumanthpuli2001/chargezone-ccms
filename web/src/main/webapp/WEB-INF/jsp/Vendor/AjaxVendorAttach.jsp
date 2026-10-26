<%-- 
    Document   : AjaxAddTenderGeneralFileDetails
    Created on : Jan 19, 2026, 12:22:59 PM
    Author     : Sumanth
--%>
 
<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
<input type="hidden" name="refNo" id="refNo" value="${refNo}">
<input type="hidden" name="vendor_code" id="vendor_code" value="${vendor_code}">

<table id="AjaxVendorAttachTab" class="table table-striped bg-white dt-scroll" style="min-width: 100%" align="center">

    <thead>
        <tr>
            <th>Attachment</th>
             <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="list" items="${vendorAttachment}" varStatus="status">
            <tr>
                <td>
                    <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderVendorFile&amp;fileName=${list.attachment}&RefNo=${refNo}&vendor_code=${vendor_code}">${list.attachment}</a>
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


