<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>
  
<table id="generalTermsTable" class="table table-striped bg-white" style="min-width: 100%" align="Center"  >
    <thead>
        <tr>
            <th>Sr.No</th>
            <th>Attachment</th>
        </tr>
    </thead>
    <tbody>
        <input type="hidden" name="user_name" value="${tenderCommittee1.userId}">
        <c:forEach var="generalDocument" items="${generalDocument}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>
                    <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${generalDocument.document}&RefNo=${generalDocument.rfqNo}">${generalDocument.document}</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
