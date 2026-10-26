<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>



<c:set var="count" value="0" scope="page" />


<style> 
    .table_wrapper{
        display: block;
        overflow-x: auto;
        white-space: wrap;
    }

</style> 
        <input type="text" id="countt" name="countt" value="${countt}">

<div class="table_wrapper">
    <table id="table_1" class="table table-bordered" style="" align="Center">

        <thead>
            <tr>
                <th>Sr No</th>
                <th>Item Code</th>
                <th>Item Description</th>
                <th>Purpose</th>
                <th>Make</th>
                <th>UOM</th>
                <th>Qty</th>
                <th>Account Category</th>
                <th>Account Value</th>
                <th>Product Type</th>
                <th>Product Group</th>
                <th>Tax Code</th>
                <th>Price</th>
                <th>Delivery Date</th>
                <th>Start Date</th>
                <th>End Date</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="list" items="${list}" varStatus="status">
                <tr>


                    <td>${list.sno}</td>
                    <td>${list.iteamCode}</td>
                    <td>${list.iteamDescription}</td>
                    <td>${list.purpose}</td>
                    <td>${list.make}</td>
                    <td>${list.uom}</td>
                    <td>${list.qty}</td>
                    <td>${item.accountCategory}</td>
                    <td>${item.accountValue}</td>
                    <td>${item.productType}</td>
                    <td>${item.productGroup}</td>
                    <td>${item.taxCode}</td>
                    <td>${item.price}</td>
                    <td>${item.deliveryDate}</td>
                    <td>${item.startDate}</td>
                    <td>${item.endDate}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>



<hr>
