<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

<c:set var="count" value="0" scope="page" />
<table id="IteamTable" class="table table-striped bg-white"  style="width: 100%;" align="center">   
    <thead>
        <tr>
            <th>Sr. No.</th>
            <th style="min-width: 180px;">Item Code</th>
            <th style="min-width: 530px;">Item Description</th>
            <th style="min-width: 180px;">iteam Details</th>
            <th>Make</th>
            <th>UOM</th>
            <th>qty</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status1">
            <input type="hidden" name="sr_no" class="form-control" value="${tenderItemMaster.srNo}">
            <input type="hidden" name="item_detail" readonly="true" class="form-control" value='${tenderItemMaster.deliveryScheduleDate}'>
            <tr>
                <td>${tenderItemMaster.srNo}</td>
                <td>${tenderItemMaster.itemCode}</td>
                <td>${tenderItemMaster.itemDescription}</td>
                <td>${tenderItemMaster.deliveryScheduleQty}</td>
                <td>${tenderItemMaster.deliveryScheduleDate}</td>
                <td>${tenderItemMaster.uom}</td>
                <td>${tenderItemMaster.qty}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>



