
<%-- 
    Document   : AddTechnicalFileDetails 
--%>



<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>


<table id="techDocumentsTable0" class="table  table-striped bg-white" style="width: 100%" align="Center"  >
    <thead>
        <tr>
            <th>Attachment</th>
            <th >Attachment Required From Vendor</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="technicalDocument" items="${technicalDocument}" varStatus="status">
            <tr>

                <td>
                    <a class="fw-600 text-break gradient-text" href="prMaster.htm?act=downloadPrFile&amp;fileName=${technicalDocument.docName}&RefNo=${technicalDocument.refNo}">${technicalDocument.docName}</a>
                </td>
                <td>
                    <c:if test="${technicalDocument.attachmentRequired == 1}">
                        Yes
                    </c:if>
                    <c:if test="${technicalDocument.attachmentRequired == 0}">
                        No
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
