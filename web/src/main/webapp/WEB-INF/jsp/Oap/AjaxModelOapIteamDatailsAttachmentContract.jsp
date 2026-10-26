<%-- 
    Document   : AjaxModelOapIteamDatailsAttachment
    Created on : Dec 31, 2025, 4:05:02 PM
    Author     : Sumanth
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<c:set var="count" value="0" scope="page" />--%>
<!--<h6 class="fw-600 mr-4 mb-0 d-none" id="itemDetailsTitleContract">Please Wait</h6>-->
<div id="swalData" data-message="${message}" data-status="${status}" style="display:none;"></div>

<div>
    <table id="AjaxOapIteamDetailsContractTab" class="table table-striped bg-white" style="width:100%;">
        <thead>
            <tr>
                <th data-dt-order="disable" class="text-center">
                    <input type="checkbox" name="select_all_rows" id="select_all">
                </th>
                <th>Sr.No</th>
                <th style="min-width:230px;">Item Code</th>
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
                <th style="min-width:190px;">Delivery Date</th>
                <th style="min-width:190px;">Start Date</th>
                <th style="min-width:190px;">End Date</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="list" items="${itemDetailsContract}" varStatus="status">
                <tr>
                    <td class="text-center">
                        <input type="checkbox" name="select_current_row" class="rowCheckbox" value="${list.id}">
                    </td>
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
