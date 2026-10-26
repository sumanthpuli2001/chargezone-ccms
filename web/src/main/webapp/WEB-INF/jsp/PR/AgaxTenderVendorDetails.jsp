<%-- 
    Document   : AgaxTenderVendorDetails
    Created on : Jan 22, 2026, 11:03:22 AM
    Author     : Sumanth
--%>

<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

<input type="hidden" id="vendorcount" name="vendorcount" value="${vendorcount}">
<div class="table-responsive">
    <table id="VendorDetailsTable" class="table table-striped bg-white" align="center">   
        <thead>
            <tr>
                <th>Sr.No</th>
                <th>Code</th>
                <th>Name</th>
                <th style="min-width: 250px;">Address</th>
                <th>E-mail ID</th>
                <th>Mobile No.</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tenderVendor1" items="${tenderVendor1}" varStatus="status">
                <tr>
                    <td>
                        ${status.count}
                        <input type="hidden" name="vendor_code" value="${tenderVendor1.vendorCode}">
                        <input type="hidden" name="mobile_no" value="${tenderVendor1.mobileNo}">
                        <input type="hidden" name="email_id" value="${tenderVendor1.emailId}">
                    </td>
                    <td>${tenderVendor1.vendorCode}</td>
                    <td>${tenderVendor1.vendorName}</td>
                    <td>${tenderVendor1.address}</td>
                    <td>${tenderVendor1.emailId}</td>
                    <td>${tenderVendor1.mobileNo}</td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
</div>
