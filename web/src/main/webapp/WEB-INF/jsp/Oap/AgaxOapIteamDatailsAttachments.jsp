<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>



<c:set var="count" value="0" scope="page" />

<input type="hidden" value="${status}">


<div id="swalData" data-message="${message}" data-status="${status}" style="display:none;"></div>
<input type="hidden" id="countt" name="countt" value="${countt}">




    <table id="itemsDetailsTab" class="table table-striped bg-white" style="width: 100%;" >
        <thead>
            <tr>
                <th>Sr No</th>
                <th>Item Code</th>
                <th style="min-width:230px;">Item Description</th>
                <th>Purpose</th>
                <th>Make</th>
                <th>UOM</th>
                <th>Qty</th>
                <th>Account Category</th>
                <th>Account Value</th>
                <th>Product Type</th>
                <th>Product Group</th>
                <th>TAX Code</th>
                <th>Price</th>
                <th>Delivery Date</th>
                <th>Start Date</th>
                <th>End Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${list1}" varStatus="status">
                <tr>
                    <td>${item.sno}</td>
                    <td>${item.iteamCode}</td> 
                    <td>${item.iteamDescription}</td>  
                    <td>${item.purpose}</td>
                    <td>${item.make}</td>
                    <td>${item.uom}</td>
                    <td>${item.qty}</td>
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



