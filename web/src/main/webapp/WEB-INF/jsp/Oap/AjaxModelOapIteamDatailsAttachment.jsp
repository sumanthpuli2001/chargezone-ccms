<%-- 
    Document   : AjaxModelOapIteamDatailsAttachment
    Created on : Dec 31, 2025, 4:05:02 PM
    Author     : Sumanth
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<c:set var="count" value="0" scope="page" />--%>
<%--<c:if test="${!empty successMessage}">
    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
</c:if>
<c:if test="${!empty failureMessage}">
    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
</c:if>--%>
<div id="swalData" data-message="${message}" data-status="${status}" style="display:none;"></div>


<h6 class="fw-600 mr-4 mb-0 d-none" id="itemDetailsTitle">Please Wait</h6>

<div>
    <table id="AjaxModelOapIteamDatailsTab" class="table table-striped bg-white" style="width:100%;">
        <thead>
            <tr>
                <th data-dt-order="disable" class="text-center">
                    <input type="checkbox" name="select_all_rows" id="select_all">
                </th>
                <th>Sr. No</th>
                <th>Item Code</th>
                <th style="min-width:230px;">Item Description</th>
                <th>Purpose</th>
                <th>Make</th>
                <th>UOM</th>
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
            <c:forEach var="item" items="${itemDetailsGoodsnService}" varStatus="status">
                <tr>
                    <td class="text-center">
                        <input type="checkbox" name="select_current_row" class="rowCheckbox" value="${item.id}">
                    </td>
                    <td>${item.sno}</td>
                    <td>${item.iteamCode}</td>
                    <td>${item.iteamDescription}</td>
                    <td>${item.purpose}</td>
                    <td>${item.make}</td>
                    <td>${item.uom}</td>
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
