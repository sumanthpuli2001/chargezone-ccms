<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PR Details</title>
    </head>
    <body>


        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>
            <section class="main-content">
                  <form:form action="prMaster.htm?act=searchPRList" method="post" commandName="employeeMaster"
                   name='form1'  class="form-horizontal" role="form">
                    <div class="content-top rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)"
                                     alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)"
                                     alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">PR Details</h5>
                        </div>

                        <div class="cta d-flex align-items-center">
                            <a onclick="history.back();" class="btn theme-btn light-btn mr-3">Back</a>
                            <!--                            <button type="submit" class="btn theme-btn">Search</button>-->
                        </div>
                    </div>

                    <hr>
                   <div class="form-group">
                                <h6 class="fw-600"> PR Approval History</h6>
                            </div>

                    <table id="commonTable" class="table  table-striped bg-white" style="width: 100%" align="center">

                        <thead>
                            <tr>


                                <th style="min-width: 180px;">PR Number</th>
                                <th style="min-width:180px;">User Id</th>
                                <th style="min-width:180px;">Date Time</th>
                                <th>Remark</th>
                                <th style="min-width:150px;">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr> 
                                <td>${prMaster.prNo}</td>
                                <td>${prMaster.contactPerson}</td>
                                <td>${prMaster.announceDate}</td>
                                <td>PR Create</td>
                                <td></td>
                            </tr>

                            <c:forEach var="approvalList" items="${approvalList}" varStatus="status">
                                <tr>
                                    <td>${approvalList.prNo}</td>
                                    <td>${approvalList.userId}</td>
                                    <td>${approvalList.dateTime}</td>
                                    <td>${approvalList.comment}</td>
                                    <td>${approvalList.approvalStatus}</td>

                                </tr>
                            </c:forEach>

                            <tr> 
                                <td>${prMaster.prNo}</td>
                                <td>${prMaster.prAuthorizeUser}</td>
                                <td>${prMaster.prAuthorizeDate}</td>
                                <td>PR Authorize</td>
                                <td></td>

                            </tr>

                            <c:forEach var="tenderFollowup" items="${tenderFollowup}" varStatus="status">
                                <tr> 
                                    <td>${tenderFollowup.tenderNo}</td>
                                    <td>${tenderFollowup.person}</td>
                                    <td>${tenderFollowup.activityDate}</td>
                                    <td>${tenderFollowup.activity}</td>
                                    <td></td>

                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                   <div class="form-group">
                                <h6 class="fw-600"> Activity Milestone  </h6>
                            </div>
                   
                    <table id="commonTable1" class="table  table-striped bg-white " style="width: 100%" align="center">
                        <thead>
                            <tr>
                                <th>Sr No.</th>
                                <th>Activity</th>
                                <th>Activity By</th>
                                <th>Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>PR Create</td>
                                <td>${prMaster.contactPerson}</td>
                                <td>${prMaster.announceDate}</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>PR Approve</td>
                                <td>${prMaster.prAuthorizeUser}</td>
                                <td>${prMaster.prAuthorizeDate}</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Tender Assign By</td>
                                <td>${prMaster.tenderAssignUser}</td>
                                <td>${prMaster.tenderAssignDate}</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>Tender Create</td>
                                <td>${prMaster.tenderCreaterUser}</td>
                                <td>${prMaster.tenderCreaterDate}</td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>Technical Bid Open</td>
                                <td>${prMaster.techBidOpenUser}</td>
                                <td>${prMaster.techBidOpenDate}</td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td>Technical Bid Approve</td>
                                <td>${prMaster.techBidApproveUser}</td>
                                <td>${prMaster.techBidApproveDate}</td>
                            </tr>
                            <tr>
                                <td>7</td>
                                <td>Price Bid Initiate</td>
                                <td>${prMaster.priceBidStartUser}</td>
                                <td>${prMaster.priceBidStartDate}</td>
                            </tr>
                            <tr>
                                <td>8</td>
                                <td>Price Bid Open</td>
                                <td>${prMaster.priceBidOpenUser}</td>
                                <td>${prMaster.priceBidOpenDate}</td>
                            </tr>
                            <tr>
                                <td>9</td>
                                <td>Tender Award</td>
                                <td>${prMaster.tenderAwardUser}</td>
                                <td>${prMaster.tenderAwardDate}</td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td>Tender Acceptance</td>
                                <td>${prMaster.tenderAcceptUser}</td>
                                <td>${prMaster.tenderAcceptDate}</td>
                            </tr>
                            <tr>
                                <td>11</td>
                                <td>Tender Close</td>
                                <td>${prMaster.finalCloseUser}</td>
                                <td>${prMaster.finalCloseDate}</td>
                            </tr>
                        </tbody>
                    </table>




                </form:form>
            </section>
        </main>
    </body>
    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
</html>
