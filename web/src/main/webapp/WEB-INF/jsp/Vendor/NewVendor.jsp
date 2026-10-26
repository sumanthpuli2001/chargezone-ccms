<%-- 
    Document   : New Vendor
    Created on : 8 Jan, 2025, 2:06:19 PM
    Author     : fnp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/WEB-INF/jsp/Common/HeaderNew.jsp"%>

    <head>
        <title>Invited Vendor List</title>
    </head>

    <body>
        <!-- Content Wrapper. Contains page content -->
        <main class="d-flex align-items-end justify-content-end">
            <%@include file="/WEB-INF/jsp/Common/NavbarNew.jsp"%>

            <section class="main-content">
                <form:form action="" method="post" commandName="rightMaster"
                           name='form1' onsubmit='return deleteCheck11();' class="form-horizontal" role="form">
                    <div class="card-box rounded-3 mb-0 d-flex align-items-center justify-content-between sticky-model0">
                        <div class="page-title d-flex align-items-center">
                            <div class="toggle-sidebar d-flex align-items-center justify-content-center mr-2">
                                <img src="StorageYard/assets/images/menu-collapse.svg" class="fa-bars" onload="SVGInject(this)" alt="Menu collapse">
                                <img src="StorageYard/assets/images/menu-expand.svg" class="fa-bars-sort" onload="SVGInject(this)" alt="Menu collapse">
                            </div>

                            <h5 class="fw-600 mb-0">New Vendor List</h5>
                        </div>
                        <c:if test="${fn:contains(sessionScope.userRights.venderInvite,'1')}">
                        <div class="cta d-flex align-items-center">                            
                            <a onclick="window.location = 'vendorInvitation.htm?act=addVendorInvitation'" class="btn theme-btn flex ml-3">
                                <img src="StorageYard/assets/images/plus.svg" onload="SVGInject(this)" class="mr-2 icon" alt="Plus Icon">
                                Invite Vendor
                            </a>
                        </div>
                        </c:if>
                    </div>
                    <hr>                    

                    <div class="card-box rounded-3 mt-3 py-2 px-3 top-0 sticky-model1">
                        <ul class="list-unstyled mb-0 d-flex align-items-center overflow-auto">
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.allVendor=='1'}">
                                    <a href="vendorInformation.htm?act=allVendor" class="tab-link transition-0">All Vendors</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.venderInvite=='1'}">
                                    <a href="vendorInformation.htm?act=newVendor" class="tab-link active transition-0">Invited Vendor</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.venderRequest=='1'}">
                                    <a href="vendorInformation.htm?act=inprogressVendor" class="tab-link transition-0">In Progress</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.buyerApproval=='1'}">
                                    <a href="vendorInformation.htm?act=firstLevelnApprove" class="tab-link transition-0">Buyer</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.procurementHead=='1'}">
                                    <a href="vendorInformation.htm?act=procurementHeadApproval" class="tab-link transition-0">Procurement Head Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.financialApproval=='1'}">
                                    <a href="vendorInformation.htm?act=finacialApproval" class="tab-link transition-0">Financial Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.technicalApproval=='1'}">
                                    <a href="vendorInformation.htm?act=technicalApproval" class="tab-link transition-0">Technical Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.hrApproval=='1'}">
                                    <a href="vendorInformation.htm?act=hrApproval" class="tab-link transition-0">HR Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.safetyApproval=='1'}">
                                    <a href="vendorInformation.htm?act=safetyApproval" class="tab-link transition-0">Safety Approval</a>
                                </c:if>
                            </li>
                            <li class="tab-item mr-2">
                                <c:if test="${userRights.itApproval=='1'}">
                                    <a href="vendorInformation.htm?act=itApproval" class="tab-link transition-0">IT Approval</a>
                                </c:if>
                            </li>
<!--                            <li class="tab-item mr-2">
                                <%--<c:if test="${userRights.activeVendor=='1'}">--%>
                                    <a href="vendorInformation.htm?act=activeVendor" class="tab-link transition-0">Active Vendor</a>
                                <%--</c:if>--%>
                            </li>-->
                        </ul>
                    </div>

                    <style>                      
.wrap-text {
    white-space: normal !important;   /* allow wrapping */
    word-break: break-word !important; /* modern browsers */
    overflow-wrap: anywhere !important; /* break long strings */
}
                        </style>
       
                  
                    <%@include file="/WEB-INF/jsp/Common/TablePageNew.jsp"%>

                    <table id="listCommonSearch" class="table table-striped bg-white " style="min-width: 100%;" align="Center"  >
                        <c:choose>
                            <c:when test="${empty vendorInformation1}"></c:when>
                            <c:otherwise>
                                <thead>
                                    <tr>                                        
                                        <th>Sr.No.</th>                                                                 
                                        <th>Company Name</th>
                                        <th>Email Id</th>
                                        <th>Invite By</th>
                                        <th>Invite Date & Time</th>
                                    </tr>
                                </thead>
                                <c:set var="count" value="0" scope="page" />
                                <tbody>
                                    <c:forEach var="list" items="${vendorInformation1}" varStatus="status">
                                        <tr>                                            
                                            <td> ${status.count}</td>
                                            <td>${list[1]}</td>
                                            <td class="wrap-text">${list[2]}</td>
                                            <td>${list[3]}</td>
                                            <td>${list[4]}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </c:otherwise>
                        </c:choose>
                    </table>


                </form:form>
            </section>
        </main> 
    </body>

    <%@include file="/WEB-INF/jsp/Common/NewUIFooter.jsp"%>
    
</html>
