<%-- 
    Document   : AgaxOapIteamDatailsAttachmentsCreateContract
--%>

<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>
<c:set var="count" value="0" scope="page" />
<%--<c:if test="${!empty successMessage}">
    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
</c:if>
<c:if test="${!empty failureMessage}">
    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
</c:if>--%>
<div id="swalData" data-message="${message}" data-status="${status}" style="display:none;"></div>
<input type="hidden" id="countt" name="countt" value="${countt}">

<div>
    <table id="itemsDetailsContractTab" class="table table-striped bg-white" style="width: 100%;" >
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

