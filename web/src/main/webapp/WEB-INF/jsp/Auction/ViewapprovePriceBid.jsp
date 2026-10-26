<%-- 
    Document   : ViewapprovePriceBid
    Created on : 30 Jan, 2024, 9:52:35 AM
    Author     : admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/Header.jsp"%>
    <%@include file="/WEB-INF/jsp/Common/NavbarCmss.jsp"%>



    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tendor Approve Price Bid View</title>

        <script language="javascript" type="text/javascript">
            function gettender()
            {

                var t = document.getElementById("refNo").value;
                var tenderPhase = document.getElementById("tenderPhase").value;
                window.location = 'tenderMaster.htm?act=getTender&refNo=' + t + '&tenderPhase=' + tenderPhase;
            }

            function approve() {
                var id = document.getElementById("id").value;
                var comment = document.getElementById("comment").value;
                window.location = 'tenderMaster.htm?act=approveBid&id=' + id + '&comment=' + comment ;
            }

            function reject() {
                var id = document.getElementById("id").value;
                var comment = document.getElementById("comment").value;
                window.location = 'tenderMaster.htm?act=rejectBid&id=' + id + '&comment=' + comment ;
            }

            function rework() {
                var id = document.getElementById("id").value;
                var comment = document.getElementById("comment").value;
                window.location = 'tenderMaster.htm?act=reworkBid&id=' + id + '&comment=' + comment;
            }

        </script>

    </head>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Tendor Approve Price Bid View</h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Tendor Approve Price Bid View</li>
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
                                <form:form action="auctionMaster.htm?act=approveBid" method="post" enctype="multipart/form-data" commandName="auctionMaster"
                                           class="form-horizontal" role="form">
                                    <input type="hidden" name="policyCount" id="policyCount" value="1"/>
                                    <P align="right">
                                            <input type="button" class="btn btn-primary" style="width: 100px;" onclick="history.back();" title="" value="Back" >
                                            </P>
                                            <input type="hidden" name="id" value="${id}">
                                    <div class="col-md-12 col-sm-12">
<!--                                            <div class="table">-->
                                               <!--     <a href="tenderMaster.htm?act=priceBidPrintAll&refNo=${refNo}">Print All</a> -->

                                                     <table id="table_11" class="table table-bordered" style="" align="Center"  >
                                                <tr>
                                                    <td>Auction No.</td>
                                                    <td>${auctionMaster.auctionNo}</td>
                                                    <td>Auction Title</td>
                                                    <td>${auctionMaster.title}</td>
                                                </tr>
                                                <tr>
                                                    <td>Bidding Start Date</td>
                                                    <td>${auctionMaster.biddingStartdate}</td>
                                                    <td>Bidding End Date</td>
                                                    <td>${auctionMaster.biddingEnddate}</td>
                                                </tr>
                                                <tr>
                                                    <td>Auction Basic Start Price</td>
                                                    <td>${auctionMaster.auctionAmount}</td>
                                                    <td>Auction Created By</td>
                                                    <td>${auctionMaster.contactPerson}</td>
                                                </tr>
                                                <tr>
                                                    <td>Auction Remark</td>
                                                    <td>${auctionMaster.auctionRemark}</td>
                                                    
                                                </tr>
                                            </table>

                                                Item Details
                                                <hr>
                                                
                                                <table id="table_11" class="table table-bordered" style="" align="Center"  >
                                                    <tr>
                                                        <th>Item Code</th>
                                                        <th>Item Name</th>
                                                        <th>Item Description</th>
                                                        <th>UOM</th>
                                                        <th>Quantity</th>
                                                    </tr>
                                                    <c:forEach var="list" items="${auctionItemMaster}" varStatus="status">
                                                        <tr>
                                                            <td>${list.itemCode}</td>
                                                            <td>${list.itemName}</td>
                                                            <td>${list.itemRemark}</td>
                                                            <td>${list.uom}</td>
                                                            <td>${list.qty}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </table>
                                                
                                                Vendor Details
                                                <hr>
                                                
                                            <table id="table_11" class="table table-bordered" style="" align="Center"  >

                                                <thead>
                                                    <tr>
                                                        <th>Vendor Code</th>
                                                        <th>Vendor Name</th>
                                                        <th>Basic Price </th>
                                                        <th>Rank</th>
                                                        <th>History</th>    
                                                    </tr>
                                                </thead>
                                                <c:set var="count" value="0" scope="page" />
                                                <tbody>

                                                    <c:forEach var="list" items="${auctionVendorBid}" varStatus="status">
                                                        <tr>
                                                            <td>${list[0]}</td>
                                                            <td>${list[1]}</td>
                                                            <td>${list[4]}</td>
                                                            <td>${status.count} </td>
                                                            <td>
                                                                <a href="#" onclick="window.open('auctionMaster.htm?act=vendorAuctionHistoryView&vendorCode=${list[0]}&auction_no=${refNo}', '', 'left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1');
                                                                        ">History</a> 

                                                            </td>
                                                        </tr>
                                                    </c:forEach>

                                                    <c:forEach var="list" items="${auctionVendor}" varStatus="status">
                                                        <c:set var = "i1" value="0"/>
                                                        <c:forEach var="list1" items="${auctionVendorBid}" varStatus="status1">
                                                            <c:if test="${list.vendorCode == list1[0]}">
                                                                <c:set var = "i1" value="1"/>
                                                            </c:if>
                                                        </c:forEach>
                                                        <c:if test="${i1 == '0'}">
                                                            <tr>
                                                                <td>${list.vendorCode}</td>
                                                                <td>${list.vendorName}</td>
                                                                <td></td>
                                                                <td> </td>
                                                                <td>
                                                                </td>
                                                            </tr>
                                                        </c:if>


                                                    </c:forEach>


                                                </tbody>


                                            </table>
                                           
                                                        
                                                            
                                                          
                                            
                                                            
                                                            <br>
                                                            <h3>User Approval List</h3>
                                                            <br>
                                                             <table id="table_12" class="table table-bordered" style="" align="Center"  >
                                                    
                                                            <thead>
                                                                <tr>
                                                                    
                                                                    <th>Auction Ref No.</th>
                                                                    
                                                                    <th>Comment</th>
                                                                    <th>View</th>
                                                                    
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                               
                                                                     <tr>
                                                                        
                                                                        <td>${auctionPriceApproval.auctionNo}</td>
                                                                        <td>${auctionPriceApproval.approvalRemark}</td>
                                                                        <td><a href="auctionMaster.htm?act=viewApproveUserList&id=${auctionPriceApproval.id}">View</a></td>
                                                                     </tr>
                                                               
                                                            </tbody>

                                                        
                                                </table>
                                                            <br>
                                                            <h3>Approval Comments</h3>
                                                            <br>
                                                            
                                                        <table id="table_12" class="table table-bordered" style="" align="Center"  >
                                                            <thead>
                                                                <tr>
                                                                    <th>User Id</th>
                                                                    <th>Comment</th>
                                                                    <th>Date Time</th>
                                                                    
                                                                </tr>
                                                            </thead>
                                                            <c:set var="count" value="0" scope="page" />
                                                            <tbody>
                                                                <c:forEach var="list2" items="${list3}" varStatus="status">
                                                                    <tr>
                                                                        
                                                                        <td>${list2.userId}</td>
                                                                        <td>${list2.approvalComment}</td>
                                                                        <td>${list2.dateTime}</td>
                                                                        
                                                                    </tr>
                                                                </c:forEach>
                                                            </tbody>
                                                        </table>
                                                
<!--                                            </div>-->

                                    
                                        </div>

                                    Auction Approve Price Bid View
                                    <hr>
                                   

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">Comment:<span style="color: red;font-size: 12px;">*</span></label>
                                        </div>
                                        <div class="col-sm-3">
                                            <textarea type="text" class="form-control" id="comment" name="comment" required="true"></textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-6 col-sm-offset-5">

                                            <input type="submit" class="btn btn-primary" style="width: 100px;" onclick="approve();"   value="Approve">
                                        <!--    <input type="submit" class="btn btn-warning" style="width: 100px;" onclick="reject();" formaction="tenderMaster.htm?act=rejectBid" value="Reject"> -->
                                            <input type="submit" class="btn btn-linkedin" style="width: 100px;" formaction="auctionMaster.htm?act=reworkBid"  onclick="rework();" value="Rework"> 
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

