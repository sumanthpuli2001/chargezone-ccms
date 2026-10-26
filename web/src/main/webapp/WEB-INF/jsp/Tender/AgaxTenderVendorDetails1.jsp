<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>
<table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>Code</th>
                                                                    <th>Name</th>
                                                                    <th>Address</th>
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
                                                                         <td><input name="email_id" value="${tenderVendor1.emailId}" class="form-control"   required/></td>
                                                                         <td><input name="mobile_no" value="${tenderVendor1.mobileNo}" class="form-control"   maxlength="30" required/></td>
                                                                   
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
</table>
                                                           