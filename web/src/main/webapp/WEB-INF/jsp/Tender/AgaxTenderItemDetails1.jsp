<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

 
<c:set var="count" value="0" scope="page" />





    <table id="IteamsTables" class="table table-striped bg-white" style="width: 100%;" align="center">  
        <thead>
         <tr >
                <th>Sr. No.</th>
                <th style="min-width: 190px;" >Item Code</th>
                <th style="min-width: 530px;">Item Description</th>
                <th style="min-width: 190px;" >iteam Details</th>
                <th style="min-width: 190px;" >Make</th>
                <th style="min-width: 190px;" >UOM</th>
                <th style="min-width: 190px;">qty</th>
<!--                <th >Account Category</th>
                <th >Account Value</th>
                <th>Product Type</th>
                <th >Product Group</th>
                <th >TAX Code</th>
                <th >Price</th>
                <th style="min-width: 190px;" >Delivery Date</th>
                <th  style="min-width: 190px;">Start Date</th>
                <th  style="min-width: 190px;">End Date</th>-->
            </tr>

    </thead>
    <tbody>
        <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status1">
<input type="hidden" name="sr_no" class="form-control" value="${tenderItemMaster.srNo}">
            <tr>
                <td>${tenderItemMaster.srNo}</td>
                <td>${tenderItemMaster.itemCode}</td>
                <td>${tenderItemMaster.itemDescription}</td>
                <td>${tenderItemMaster.deliveryScheduleQty}</td>
                <td><input type="text" name="item_detail" readonly="true" class="input-field" value='${tenderItemMaster.deliveryScheduleDate}'></td>
                <td>${tenderItemMaster.uom}</td>
                <td>${tenderItemMaster.qty}</td>
<!--                <td>${tenderItemMaster.accountAssigmentCategory}</td>
                <td>${tenderItemMaster.accountAssigmentValue}</td>
                <td>${tenderItemMaster.productType}</td>
                <td>${tenderItemMaster.productGroup}</td>
                <td>${tenderItemMaster.taxCode}</td>
                <td>${tenderItemMaster.valuationPrice}</td>
                <td>${tenderItemMaster.deliveryDate}</td>
                <td>${tenderItemMaster.startDate}</td>
                <td>${tenderItemMaster.endDate}</td>-->
            </tr>
        </c:forEach>


    </tbody>
</table>




<hr>
