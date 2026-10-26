<%-- 
    Document   : ViewVendorAuction
    Created on : 29 Jul, 2022, 12:39:54 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarVendor.jsp"%>
    
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auction Information</title>
        
<script language="javascript" type="text/javascript">
    
    function recycleTender()
    {
        window.location='auctionMaster.htm?act=recycleAuction';
    }
    
    function rejectTender()
    {
        window.location='auctionMaster.htm?act=rejectAuction';
    }
            
    	  
</script>

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Auction Information</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Auction Information</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <!-- Custom Tabs -->
                    <div class="nav-tabs-custom">
                        <div class="tab-content">
                            <div class="tab-pane active" id="tab_1">
                                
                                
                                <c:if test="${!empty successMessage}">
                                    <div class="fadeOutEffect alert alert-info" role="alert">${successMessage}</div>
                                </c:if>
                                <c:if test="${!empty failureMessage}">
                                    <div class="fadeOutEffect alert alert-danger" role="alert">${failureMessage}</div>
                                </c:if>
                                <form:form action="vendorAuction.htm?act=submitAuthorizeView" method="post" enctype="multipart/form-data" commandName="auctionMaster"
                                           class="form-horizontal" role="form">
                                    <c:if test ="${auctionMaster.biddingType ne 'Itemwise Bidding'}">
                                    <input type="submit" class="btn btn-primary" style="width: 100px;" formaction="vendorAuction.htm?act=applyAuction" title="" value="Apply Bid" >
                                    </c:if>
                                    
                                     <c:if test ="${auctionMaster.biddingType eq 'Itemwise Bidding'}">
                                    <input type="submit" class="btn btn-primary" style="width: 100px;" formaction="vendorAuction.htm?act=applyItemwiseAuction" title="" value="Apply Bid" >
                                    </c:if>
                                    
                                    <hr>
                                    <input type="hidden" name="auction_no" value="${auction_no}">
                                    <div class="form-group">
                                        
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Type :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="type" value="${type}" class="form-control" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction No. :</label>
                                        </div>
                                        <div class="col-sm-2">
                                            <form:input path="auctionNo" value="${type}" class="form-control" readonly="true"/>
                                            
                                        </div>
                                        
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Title :</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <form:input path="title" class="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        
                                        <div class="col-sm-3">
                                            <label class="control-label">Item Category :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="categoryId" class="form-control" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction Location :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="location" class="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Fee :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="docCost" class="form-control"   pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))" maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction EMD :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="emd" class="form-control"  pattern="[0-9]+" onkeypress="return (event.charCode !=8 && event.charCode ==0 || (event.charCode >= 48 && event.charCode <= 57))"  readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Date :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="biddingStartdate" class="form-control" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction Due Date :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="biddingEnddate" class="form-control" value="${formattedDate}"  maxlength="30" required="required" readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction Work Description :</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <form:input path="workDesc" class="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">P.R. No. :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="prNo" class="form-control" readonly="true"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Auction By :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input name="auction_by" class="form-control" value="${auction_by}"  maxlength="30"  readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Auction Amount :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <input name="auction_amount" class="form-control" value="${auction_amount}"  maxlength="30"  readonly="true"/>
                                        </div>
                                    </div>
                                    
                                    Auction Contact Person
                                    <hr>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Created By :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="contactPerson" class="form-control" value="${employee_name}"  maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Contact Number :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="auctionAdminContactNumber" class="form-control" value="${ph_no}"  maxlength="30" readonly="true"/>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Authorize By :</label>
                                        </div>
                                        <div class="col-sm-3">
                                            <form:input path="auctionAuthorizePerson" class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                        <div class="col-sm-2">
                                            <label class="control-label">Contact Number :</label>
                                        </div>
                                        <div class="col-sm-3">
                                             <form:input path="auctionAuthorizeContactNo" class="form-control"   maxlength="30" readonly="true"/>
                                        </div>
                                    </div>
                                        
                                    Item Details
                                    <hr>
         
                                    <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                        <tr>
                                            <th style="text-align: center; vertical-align: middle">Sr No.</th>
                                            <th style="text-align: center; vertical-align: middle">Item Code</th>
                                            <th style="text-align: center; vertical-align: middle">Item Name</th>
                                            <th style="text-align: center; vertical-align: middle">Item Description</th>
                                            <th style="text-align: center; vertical-align: middle">Item Remark</th>
                                            <th style="text-align: center; vertical-align: middle">UOM</th>
                                            <th style="text-align: center; vertical-align: middle">Quantity</th>
                                        </tr>

                                        <c:forEach var="auctionItemMaster" items="${auctionItemMaster}" varStatus="status">
                                            <tr>
                                                <td>${auctionItemMaster.srNo}</td>
                                                <td>${auctionItemMaster.itemCode}</td>
                                                <td>${auctionItemMaster.itemName}</td>
                                                <td>${auctionItemMaster.itemDesc}</td>
                                                <td>${auctionItemMaster.itemRemark}</td>
                                                <td>${auctionItemMaster.uom}</td>
                                                <td>${auctionItemMaster.qty}</td>
                                            </tr>
                                        </c:forEach>



                                    </table>

                           
                                    
                                    Auction Attachment
                                    <hr>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">General Terms & Conditions :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <table id="policyTable" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Attachment</th>
                                                            <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                                        </tr>
                                                        
                                                        <c:forEach var="generalDocs" items="${generalDocs}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="auctionMaster.htm?act=downloadAuctionFile&amp;fileName=${generalDocs.attachmentDoc}&RefNo=${generalDocs.rfqNo}">${generalDocs.attachmentDoc}</a>
                                                                        </td>
                                                                    </tr>
                                                        </c:forEach>
                                                                
                                                        
                                                        
                                                    </table>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Additional Document :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <table id="policyTable1" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Attachment</th>
                                                            <input type="hidden" name="policyCount1" id="policyCount1" value="1"/>
                                                        </tr>
                                                        
                                                        <c:forEach var="additionalDocs" items="${additionalDocs}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="auctionMaster.htm?act=downloadAuctionFile&amp;fileName=${additionalDocs.attachmentDoc}&RefNo=${generalDocs.rfqNo}">${additionalDocs.attachmentDoc}</a>
                                                                        </td>
                                                                        
                                                                    </tr>
                                                        </c:forEach>
                                                        
                                                    </table>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Tender Technical Document :<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <table id="policyTable2" class="table table-bordered table-striped table-hover" style="" align="Center"  >
                                                        <tr>
                                                            <th style="text-align: center; vertical-align: middle">Attachment</th>
                                                            <input type="hidden" name="policyCount2" id="policyCount2" value="1"/>
                                                        </tr>
                                                        
                                                        <c:forEach var="technicalDocs" items="${technicalDocs}" varStatus="status">
                                                                    <tr>
                                                                        <td>
                                                                            <a href="auctionMaster.htm?act=downloadAuctionFile&amp;fileName=${technicalDocs.attachmentDoc}&RefNo=${generalDocs.rfqNo}">${technicalDocs.attachmentDoc}</a>
                                                                        </td>
                                                                        
                                                                    </tr>
                                                        </c:forEach>
                                                        
                                                        
                                                    </table>
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

    <!--datetime-->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
</html>

