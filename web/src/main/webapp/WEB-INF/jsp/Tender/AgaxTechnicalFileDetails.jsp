<%-- 
    Document   : AgaxTechnicalFileDetails
    Created on : 3 Oct, 2025, 10:55:48 AM
    Author     : Bulwark-5
--%>
<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>
<table id="tenderTechnicalTable" class="table table-striped bg-white" style="" align="Center"  >
    <thead>
        <tr>
            <th>Attachment</th>
            <th>Date & Time</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="technicalDocument" items="${technicalDocument}" varStatus="status">
            <tr>

                <td>
                    <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTechnicalFile&fileName=${technicalDocument.attachment}&refNo=${technicalDocument.refNo}&vendorCode=${technicalDocument.vendorCode}">${technicalDocument.attachment}</a>
                </td>
                <td>
                    ${technicalDocument.dateTime}
                </td>
                
            </tr>
        </c:forEach>
    </tbody>
</table>
