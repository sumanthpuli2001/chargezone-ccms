<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>
<table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
    <thead>
        <tr>
            <th>Attachment</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="additionalDocument" items="${additionalDocument}" varStatus="status">
            <tr>
                <td>
                    <a href="auctionMaster.htm?act=downloadAuctionFile&amp;fileName=${additionalDocument.attachmentDoc}&RefNo=${additionalDocument.rfqNo}">${additionalDocument.attachmentDoc}</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
