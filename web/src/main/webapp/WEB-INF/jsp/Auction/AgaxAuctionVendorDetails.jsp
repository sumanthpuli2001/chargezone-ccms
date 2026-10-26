<%-- 
    Document   : AgaxAuctionVendorDetails
    Created on : 16 Jul, 2022, 10:42:30 AM
    Author     : admin
--%>

<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>
<table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
        <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Address</th>
                <th>E-mail ID</th>
                <th>Mobile No.</th>
                <th>Basic Start Price</th>
                <th>Loading Factor (%)</th>
                <th>Loading Factor (Value)</th>
                <th>Final Price</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="auctionVendor1" items="${auctionVendor1}" varStatus="status">
                <tr>
            <input type="hidden" name="vendor_code" value="${auctionVendor1.vendorCode}">
                    <td>${auctionVendor1.vendorCode}</td>
                     <td>${auctionVendor1.vendorName}</td>
                     <td>${auctionVendor1.address}</td>
                     <td><input name="email_id" value="${auctionVendor1.emailId}" class="form-control"   maxlength="230" required/></td>
                     <td><input name="mobile_no" value="${auctionVendor1.mobileNo}" class="form-control"   maxlength="130" required/></td>
                     <td><input name="start_price" value="${auctionVendor1.vendorBasicStartPrice}" onchange="calculate_price()" class="form-control"   maxlength="130" required/></td>
                     <td><input name="loading_factor_per" value="${auctionVendor1.loadingFactorPer}" onchange="calculate_price()" class="form-control"   maxlength="130" required/></td>
                     <td><input name="loading_factor_val" value="${auctionVendor1.loadingFactorVal}" onchange="calculate_price()" class="form-control"   maxlength="130" required/></td>
                     <td><input name="final_price" value="${auctionVendor1.finalPrice}" class="form-control"   maxlength="130" readonly="true"/></td>
                    
                </tr>
            </c:forEach>
        </tbody>
</table>
                                                           
