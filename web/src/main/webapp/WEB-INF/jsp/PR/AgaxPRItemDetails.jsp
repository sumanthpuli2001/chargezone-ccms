<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

<style>

    
    #table11 {
        /* font-family:"Helvetica Neue",Helvetica,Arial,sans-serif; */
        font-size: 13px;
        line-height: 1.42857143;
        color: #333;
        background-color: #fff
    }

</style>  

<c:set var="count" value="0" scope="page" />



<input type="hidden" name="tenderItemMastercount" id="tenderItemMastercount" value="${tenderItemMastercount}">

    <table id="itemsDetailsTable" class="table table-striped"  align="Center" >

        <thead>
            <tr>

                <th width="2%">Sr.No</th>
                <th style="min-width: 190px;">Item Code</th>
                <th style="min-width: 530px;">Item Description</th>
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
           <c:forEach var="tenderItemMaster" items="${tenderItemMaster}" varStatus="status1">
            <input type="hidden" name="prItemDetails111" value="">

                <tr>
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
</div>



<hr>
