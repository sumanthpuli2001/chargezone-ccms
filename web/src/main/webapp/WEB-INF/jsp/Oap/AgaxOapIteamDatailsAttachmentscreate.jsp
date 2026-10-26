<%-- 
    Document   : AgaxOapIteamDatailsAttachmentscreate
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
            <th>Tax Code</th>
            <th>Price</th>
            <th>Delivery Date</th>
            <th>Start Date</th>
            <th>End Date</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="list1" items="${list1}" varStatus="status">
                <tr>
                    <td>${list1.sno}</td>
                    <td>${list1.iteamCode}</td>
                    <td>${list1.iteamDescription}</td>
                    <td>${list1.purpose}</td>
                    <td>${list1.make}</td>
                    <td>${list1.uom}</td>
                    <td>${list1.qty}</td>
                    <td>${list1.accountCategory}</td>
                    <td>${list1.accountValue}</td>
                    <td>${list1.productType}</td>
                    <td>${list1.productGroup}</td>
                    <td>${list1.taxCode}</td>
                    <td>${list1.price}</td>
                    <td>${list1.deliveryDate}</td>
                    <td>${list1.startDate}</td>
                    <td>${list1.endDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

