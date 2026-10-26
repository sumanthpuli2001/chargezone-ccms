<%-- 
    Document   : AjaxTenderAdminCommunication
    Created on : Jan 23, 2026, 11:07:10 AM
    Author     : Sumanth
--%>

<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>


<c:set var="count" value="0" scope="page" />

<!--<input type="text" name="refNo" id="refNo" value="${refNo}">-->
<input type="hidden" name="tender_no" id="tender_no" value="${tender_no}">

<table id="vendorQueryTable" class="table table-striped bg-white" style="width:100%">
    <thead>
        <tr>
            <th>Sr.No.</th>
            <th>Subject</th>
            <th>From</th>
            <th>To</th>
            <th>Date</th>
            <th data-dt-order="disable">View</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="commMaster" items="${commMaster}" varStatus="status">

            <tr>
                <td>
                    <c:if test="${commMaster.isread == '0'}"><b>${status.count}</b></c:if>
                    <c:if test="${commMaster.isread == '1'}">${status.count}</c:if>
                </td>

                <td>
                    <c:if test="${commMaster.isread == '0'}"><b>${commMaster.subject}</b></c:if>
                    <c:if test="${commMaster.isread == '1'}">${commMaster.subject}</c:if>
                </td>

                <td>${commMaster.vendorCode}</td>
                <td>${commMaster.userId}</td>
                <td>${commMaster.msgdatetime}</td>

                <td>
                    <a href="javascript:void(0);"
                       onclick="openVendorModalReply('${commMaster.id}','${commMaster.tenderNo}')">
                        View
                    </a>
                </td>
            </tr>

        </c:forEach>
    </tbody>
</table>








