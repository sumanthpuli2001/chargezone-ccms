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
                <th>Update Price</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="auctionVendor1" items="${auctionVendor1}" varStatus="status">
                <tr>
            <input type="hidden" name="vendor_code" value="${auctionVendor1.vendorCode}">
                    <td>${auctionVendor1.vendorCode}</td>
                     <td>${auctionVendor1.vendorName}</td>
                     <td>${auctionVendor1.address}</td>
                     <td>${auctionVendor1.emailId}</td>
                     <td>${auctionVendor1.mobileNo}</td>
                     <td>${auctionVendor1.vendorBasicStartPrice}</td>
                     <td>${auctionVendor1.loadingFactorPer}</td>
                     <td>${auctionVendor1.loadingFactorVal}</td>
                     <td>${auctionVendor1.finalPrice}</td>
                     <td><a href="">Update Price</a></td>
                </tr>
            </c:forEach>
        </tbody>
</table>
                                                           
