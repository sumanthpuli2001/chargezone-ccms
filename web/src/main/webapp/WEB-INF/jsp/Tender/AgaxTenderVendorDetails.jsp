<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>


<input type="hidden" name="tenderVendorcount" id="tenderVendorcount" value="${tenderVendorcount}"/>
<table id="VendorDetailsTable" class="table table-striped bg-white" style="min-width: 100%;" align="Center"  >
    <thead>
        <tr>
            <th>User Name</th>
            <th>Name</th>
            <th>Address</th>
            <th data-dt-order="disable">E-mail ID</th>
            <th data-dt-order="disable">Mobile No.</th>
        </tr>
    </thead>

    <tbody>
    <input type="hidden" name="vendor_code111" value="">
    <c:forEach var="tenderVendor1" items="${tenderVendor1}" varStatus="status">
        <input type="hidden" name="vendor_code111" value="">
        <tr class="text-center">
        <input type="hidden" name="vendor_code" value="${tenderVendor1.vendorCode}">
        <td>${tenderVendor1.vendorCode}</td>
        <td>${tenderVendor1.vendorName}</td>
        <td>${tenderVendor1.address}</td>
        <td><input name="email_id" value="${tenderVendor1.emailId}" class="input-field"    required/></td>
        <td><input name="mobile_no" value="${tenderVendor1.mobileNo}" class="input-field"   maxlength="30" required/></td>
    </tr>
</c:forEach>
</tbody>
</table>
