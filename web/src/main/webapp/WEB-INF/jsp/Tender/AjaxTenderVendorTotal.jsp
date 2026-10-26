<%-- 
    Document   : AjaxTenderVendorTotal
    Created on : Jan 27, 2026, 9:49:21 AM
    Author     : Sumanth
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/jsp/Common/Top1.jsp"%>

<input type="hidden" name="refNo" id="refNo" value="${refNo}">
<input type="hidden" name="vendor_code" id="vendor_code" value="${vendor_code}">


<div class="p-3">
    <table id="commonTable1" class="table table-striped bg-white dt-scroll" align="center">                                                         
        <thead>
            <tr>

                <th style="text-align: left;">Vendor Code</th>
                <th>Name</th>
                <th>Email ID</th>
                <th>Mobile No</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="list1" items="${list1}" varStatus="status">
                <tr>

                    <td style="text-align: left;" >${list1.vendorCode}</td>
                    <td >${list1.vendorName}</td>
                    <td >${list1.emailId}</td>
                    <td >${list1.mobileNo}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>

</div>






<%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>



