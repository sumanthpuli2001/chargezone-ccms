<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>
<table id="tenderTechnicalTable" class="table  table-striped bg-white" style="min-width: 100%" align="Center"  >
    <thead>
        <tr>
            <th>Sr No</th>
            <th>Attachment</th>

        </tr>
    </thead>

    <tbody>
                <input type="hidden" name="user_name" value="${tenderCommittee1.userId}">

        <c:forEach var="technicalDocument" items="${technicalDocument}" varStatus="status">
            <tr>
        <td>
            ${status.count}
        </td>
        <td>
            <a class="fw-600 text-break gradient-text" href="tenderMaster.htm?act=downloadTenderFile&amp;fileName=${technicalDocument.document}&RefNo=${technicalDocument.rfqNo}">${technicalDocument.document}</a>

        </td>

    </tr>
</c:forEach>
</tbody>
</table>
