<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

<style>

    
    #table11 {
        /* font-family:"Helvetica Neue",Helvetica,Arial,sans-serif; */
        font-size: 13px;
        line-height: 1.42857143;
        color: #333;
        background-color: #fff
    }

</style>  


<table id="table11" class="table table-bordered table-striped table-hover"style="overflow-x: auto; border: 1px solid #ddd; margin: auto; width: 100%;" align="Center"  >
    <thead>
        <tr>
            <th class="col-sm-2">Code</th>
            <th>Name</th>
            <th class="col-sm-1">Address</th>
            <th>E-mail ID</th>
            <th>Mobile No.</th>

        </tr>
    </thead>

    <tbody>
        <c:forEach var="tenderVendor1" items="${tenderVendor1}" varStatus="status">
            <tr>
        <input type="hidden" name="vendor_code" value="${tenderVendor1.vendorCode}">
        <td>${tenderVendor1.vendorCode}</td>
        <td>${tenderVendor1.vendorName}</td>
        <td>${tenderVendor1.address}</td>
        <td><input name="email_id" value="${tenderVendor1.emailId}" class="form-control"   maxlength="30" required/></td>
        <td><input name="mobile_no" value="${tenderVendor1.mobileNo}" class="form-control"   maxlength="30" required/></td>

    </tr>
</c:forEach>
</tbody>
</table>
