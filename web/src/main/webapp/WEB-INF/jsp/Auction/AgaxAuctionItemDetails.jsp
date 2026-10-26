<%-- 
    Document   : AgaxAuctionItemDetails
    Created on : 15 Jul, 2022, 5:22:55 PM
    Author     : admin
--%>

<%@include file="/WEB-INF/jsp/Common/Header5.jsp"%>

                                                   
                                                            
    <c:set var="count" value="0" scope="page" />




                <table id="table_1" class="table table-bordered" style="" align="Center">
                    <thead>
                        <tr>
                            <th>Sr. No.</th>
                            <th>Item Code</th>
                            <th>Item Name</th>
                            <th>Item Description</th>
                          
                            <th>UOM</th>
                            <th>Qty</th>
                       <!--     <th>Action</th> -->
                        </tr>
                    </thead>
                    <tbody>
                            <c:set var="count" value="0" scope="page" />
                            <c:forEach var="itemDetail" items="${itemDetail}" varStatus="status1">
                            <input type="hidden" id="length" name="length" value="${status1.count}">
                                <input type="hidden" name="item_id" id="item_id" value="${itemDetail.id}">
                                <tr>
                                    <td>${itemDetail.srNo}</td>
                                    <td>${itemDetail.itemCode}</td>
                                    <td>${itemDetail.itemName}</td>
                                    <td>${itemDetail.itemDesc}</td>
                                   
                                    <td>${itemDetail.uom}</td>
                                    <td>${itemDetail.qty}</td>
                           <!--         <td style="width: 50px;"><a href="#" onclick="window.open('auctionMaster.htm?act=addItemDocumentAction&item_id=${itemDetail.id}&ref_no=${ref_no}&length=${status1.count}','','left=0,top=0,width=500,height=500,top=301,left=365,resizable=1,status=0,toolbar=0,scrollbars=1'); ">Action</a></td> -->
                                </tr>
                            </c:forEach>


                    </tbody>
                </table>


            <hr>
                                                                
