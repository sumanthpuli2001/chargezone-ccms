<%-- 
    Document   : AjaxTenderVendorCommunication
    Created on : Feb 5, 2026, 10:12:12 AM
    Author     : Sumanth
--%>



<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>


<c:set var="count" value="0" scope="page" />

<input type="hidden" name="tender_no" id="tender_no" value="${tender_no}">




<table id="vendorQueryTable" class="table  table-striped  bg-white" style="width: 100%" align="Center"  >
    <c:choose>
        <c:when test="${empty commMaster}">

        </c:when>
        <c:otherwise>
            <thead>
                <tr>
                    <th>Sr.No.</th>
                    <th>Subject</th>
                    <th data-dt-order="disable">View</th>
                </tr>
            </thead>
            <c:set var="count" value="0" scope="page" />
            <tbody>
                <c:forEach var="commMaster" items="${commMaster}" varStatus="status">
                    <c:if test="${commMaster.isread == '0'}">
    <tr>
        <td><b>${status.count}</b></td>
        <td><b>${commMaster.subject}</b></td>
        <td>
            <b>
                <a href="javascript:void(0);"
                   onclick="openVendorModalReply('${commMaster.id}', '${commMaster.tenderNo}')">
                    View
                </a>
            </b>
        </td>
    </tr>
</c:if>

<c:if test="${commMaster.isread == '1'}">
    <tr>
        <td>${status.count}</td>
        <td>${commMaster.subject}</td>
        <td>
            <a href="javascript:void(0);"
               onclick="openVendorModalReply('${commMaster.id}', '${commMaster.tenderNo}')">
                View
            </a>
        </td>
    </tr>
</c:if>



                </c:forEach>
            </tbody>

        </c:otherwise>
    </c:choose>
</table>






