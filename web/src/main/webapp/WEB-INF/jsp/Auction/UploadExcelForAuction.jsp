<%-- 
    Document   : UploadExcelForAuction
    Created on : 16 Jul, 2022, 11:06:19 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header4.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Vendor Excel</title>
        
<script>
	function closewindow() {
 //           window.opener.document.getElementById('requireDocument3').innerHTML=document.getElementById('hiddenAttachment').value;
     //       window.opener.document.getElementById('requireDocument3').innerHTML='${technicalfile}';
                window.opener.showuser('1');
		window.close();
	}
</script>
    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Upload Vendor Excel</h1>
            
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                <span style="color: red;font-size: 14px;">* Indicates Mandatory Field.</span>
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="auctionMaster.htm?act=uploadExcelVendorForAuctionSubmit" method="post" enctype="multipart/form-data" commandName="tenderMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="ref_no" id="ref_no" value="${ref_no}">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Upload Excel :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input type="file" class="form-control" id="technicalfile" name="technicalfile" accept="" onchange="checkFileSize();">
                                            <a href="StorageYard/Auction Vendor.xlsx">Eg. Auction Vendor File</a>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-12 col-sm-12">
                                            <div class="table table-bordered">

                                                <table id="table_11" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                    <c:choose>
                                                        <c:when test="${empty auctionVendor1}">
                                                            <tr>
                                                                <td align="Center">There Is No Any Record</td>
                                                            </tr>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <thead>
                                                                <tr>
                                                                    <th>Vendor Code</th>
                                                                    <th>Vendor Name</th>
                                                                    <th>Address</th>
                                                                    <th>Email Id</th>
                                                                    <th>Mobile No</th>
                                                                    <th>Basic Start Price</th>
                                                                    <th>Loading Factor (%)</th>
                                                                    <th>Loading Factor (Value)</th>
                                                                    <th>Final Price</th>
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="auctionVendor1" items="${auctionVendor1}" varStatus="status">
                                                                    <tr>
                                                                        
                                                                         <td>${auctionVendor1.vendorCode}</td>
                                                                         <td>${auctionVendor1.vendorName}</td>
                                                                         <td>${auctionVendor1.address}</td>
                                                                         <td>${auctionVendor1.emailId}</td>
                                                                         <td>${auctionVendor1.mobileNo}</td>
                                                                         <td>${auctionVendor1.vendorBasicStartPrice}</td>
                                                                        <td>${auctionVendor1.loadingFactorPer}</td>
                                                                        <td>${auctionVendor1.loadingFactorVal}</td>
                                                                        <td>${auctionVendor1.finalPrice}</td>
                                                                         
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>

                                                        </c:otherwise>
                                                    </c:choose>
                                                </table>
                                            </div>
                                        </div>

                                    
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">
                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="return Validate()"  title="" value="SUBMIT">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="closewindow();"  title="" value="Close">
                                        </div>
                                    </div>
                                </form:form>

                            </div><!-- /.tab-pane -->
                        </div><!-- /.tab-content -->
                    </div><!-- nav-tabs-custom -->
                </div><!-- /.col -->
            </div>
        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->
    <%@include file="/WEB-INF/jsp/Common/Footer.jsp"%>
    
</html>
