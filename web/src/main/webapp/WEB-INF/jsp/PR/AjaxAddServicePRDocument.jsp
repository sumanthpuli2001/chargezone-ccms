<%-- 
    Document   : AjaxAddServicePRDocument
    Created on : Jan 12, 2026, 11:49:30 AM
    Author     : Administrator
--%>



<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
<c:set var="count" value="0" scope="page" />
 <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
<table id="importItemsDetailsTable1" class="table table-striped bg-white" style="width:100%">
    <thead>
        <tr class="text-center align-middle">
            <th  data-dt-order="disable" class="text-center">
                <input type="checkbox" name="select_all_rows_Iteam" id="select_all_Iteam">
            </th>
            <th width="2%">Sr.No</th>

            <th style="min-width: 190px;">Item Code</th>
            <th style="min-width: 230px;">Item Description</th>
            <th style="min-width: 230px;">Purpose</th>
            <th style="min-width: 230px;">Make</th>
            <th>UOM</th>
            <th>Qty</th>
            <th>Account Category</th>
            <th>Account Value</th>
            <th>Product Type</th>
            <th>Product Group</th>
            <th>TAX Code</th>
            <th>Price</th>
            <th style="min-width: 190px;">Delivery Date</th>
            <th style="min-width: 190px;">Start Date</th>
            <th style="min-width: 190px;">End Date</th>
        </tr>
    </thead>

    <tbody>
        <c:set var="total_qty" value="0"/>
        <c:set var="total_weight" value="0"/>
        <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status1">
            <tr>
                <!--<td ><input type="checkbox" name="checkedId" id="materialCheckedId" value="${tenderItemMaster.id}"></td>-->
               <td class="text-center">
                    <input type="checkbox" name="select_current_row_Iteam" class="rowCheckbox" value="${tenderItemMaster.id}">
                </td> 
                <td>${tenderItemMaster.srNo}</td>
                <td>${tenderItemMaster.itemCode}</td>
                <td>${tenderItemMaster.itemDescription}</td>
                <td>${tenderItemMaster.deliveryScheduleQty}</td>
                <td>${tenderItemMaster.deliveryScheduleDate}</td>
                <td>${tenderItemMaster.uom}</td>
                <td>${tenderItemMaster.qty}</td>
                <td>${tenderItemMaster.accountAssigmentCategory}</td>
                <td>${tenderItemMaster.accountAssigmentValue}</td>
                <td>${tenderItemMaster.productType}</td>
                <td>${tenderItemMaster.productGroup}</td>
                <td>${tenderItemMaster.taxCode}</td>
                <td>${tenderItemMaster.valuationPrice}</td>
                <td>${tenderItemMaster.deliveryDate}</td>
                <td>${tenderItemMaster.startDate}</td>
                <td>${tenderItemMaster.endDate}</td>
            </tr>
        </c:forEach>

    </tbody>
</table>

